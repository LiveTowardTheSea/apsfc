package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartRequest;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import po.Menus;
import po.Page;
import po.Types;
import service.MenusService;
import service.TypesService;
import util.PageUtil;
import vo.MenusInfo;

/**
 * Servlet implementation class MenusServlet
 */
public class MenusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenusService menusService = new MenusService();
	private TypesService typesService = new TypesService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenusServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 分页查询
	protected void findByPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取从浏览器传入的页数 以参数的形式传入
		String currentPageStr = request.getParameter("currentPage");
		int currentPage;
		// 如果没有传入currentpage 默认查询第一页
		if (currentPageStr == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(currentPageStr);
		}
		long count = menusService.count(); // 获取总条数
		// 根据获取的count和currentpage创建一个page对象
		@SuppressWarnings("unchecked")
		Page<MenusInfo> page = PageUtil.createPage(5, (int) count, currentPage);
		page = menusService.findByPage(page);
		// 把page保存在域中
		request.setAttribute("menusPage", page);
		// 转发到menus.jsp
		request.getRequestDispatcher("/admin/menus.jsp").forward(request, response);
	}

	/*
	 * 修改操作分为两个步骤： 1.根据当前栏位id查询信息显示在修改框中 1）查询所有菜品类别，在下拉菜单中显示 2）查询当前栏目的信息 在表单中显示
	 * 2.修改信息
	 */

	// 1.根据id查询
	protected void findById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 根据id查询菜品信息 实现信息回显
		String idStr = request.getParameter("id");
		String currentPage = request.getParameter("currentPage");
		int id = Integer.parseInt(idStr);
		Menus menu = menusService.findById(id);
		// 查询所有菜品类别项目路实现在下拉菜单中显示
		ArrayList<Types> typesList = typesService.findAll();
		// 把查询到的信息添加到域中
		request.setAttribute("typesList", typesList);
		request.setAttribute("menu", menu);
		request.setAttribute("currentPage", currentPage);
		request.getRequestDispatcher("/admin/menus_update.jsp").forward(request, response);
	}

	// 2.修改
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从浏览器获取参数 封装到类中
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String currentPage = request.getParameter("currentPage");
		Menus menu = new Menus(id, request.getParameter("name"), request.getParameter("typeid"),
				request.getParameter("burden"), request.getParameter("brief"), request.getParameter("price"), "0",
				request.getParameter("price1"), "0", request.getParameter("imgpath"));
		int result = menusService.update(id, menu);
		// 获取输出流
		PrintWriter out = response.getWriter();
		if (result == 1) { // 修改成功
			// 弹出对话框 跳转到查询所有界面
			out.print("<script>" + "alert('修改成功');" + "window.location.href='" + request.getContextPath()
					+ "/MenusServlet?method=findByPage&currentPage=" + currentPage + "';" + "</script>");
		} else { // 修改失败
			out.print("<script>" + "alert('修改失败');" + "window.location.href='" + request.getContextPath()
					+ "/MenusServlet?method=findByPage&currentPage=" + currentPage + "';" + "</script>");
		}
	}

	// 删除
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取id
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		// 获取从浏览器传入的页数 删除完之后再跳到这一页
		String currentPage = request.getParameter("currentPage");
		// 删除id对应的项目
		int result = menusService.delete(id);
		// 获取输出流
		PrintWriter out = response.getWriter();
		if (result == 1) { // 删除成功
			// 弹出对话框 跳转到查询所有界面
			out.print("<script>" + "alert('删除成功');" + "window.location.href='" + request.getContextPath()
			+ "/MenusServlet?method=findByPage&currentPage=" + currentPage + "';" + "</script>");
		} else { // 删除失败
			out.print("<script>" + "alert('删除失败');" + "window.location.href='" + request.getContextPath()
					+ "/MenusServlet?method=findByPage&currentPage=" + currentPage + "';" + "</script>");
		}
	}

	// 添加之前查询菜品类别
	protected void preAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 查询所有菜品类别项目路实现在下拉菜单中显示
		ArrayList<Types> typesList = typesService.findAll();
		// 把查询到的信息添加到域中
		request.setAttribute("typesList", typesList);
		// 转发到添加页面
		request.getRequestDispatcher("/admin/menus_add.jsp").forward(request, response);

	}

	// 添加
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取请求参数， 保存menus表中
		 * 2.保存上传的文件
		 * */
		
		// 新建SmartUpload对象
		SmartUpload smartUpload = new SmartUpload();
		ServletConfig config = this.getServletConfig();
		// 初始化配置
		smartUpload.initialize(config, request, response);
		// 获取请求对象
		SmartRequest req = smartUpload.getRequest();

		// 上传图片
		try {
			smartUpload.upload();
			
			SmartFile picFile = smartUpload.getFiles().getFile(0);

			// 获取请求参数 将参数封装在类中
			String name = req.getParameter("name");
			String burden = req.getParameter("burden");
			String brief = req.getParameter("brief");
			String price = req.getParameter("price");
			String price1 = req.getParameter("price1");
			String typeid = req.getParameter("typeid");
			String imgpath = "img/" + picFile.getFileName();
			Menus menu = new Menus(0, name, typeid, burden, brief, price, "0", price1, "0", imgpath);
			int result = menusService.add(menu);

			// 获取输出流
			PrintWriter out = response.getWriter();
			if (result == 1) { // 添加
				// 弹出对话框 跳转到查询所有界面
				smartUpload.save("/img");
				out.print("<script>" + "alert('添加成功');" + "window.location.href='" + request.getContextPath()
						+ "/MenusServlet?method=findByPage';" + "</script>");
			} else { // 修改失败
				out.print("<script>" + "alert('添加失败');" + "window.location.href='" + request.getContextPath()
						+ "/MenusServlet?method=findByPage';" + "</script>");
			}
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}

		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method.equals("findByPage")) {
			findByPage(request, response);
		} else if (method.equals("delete")) {
			delete(request, response);
		} else if (method.equals("findById")) {
			findById(request, response);
		} else if (method.equals("update")) {
			update(request, response);
		} else if (method.equals("preAdd")) {
			preAdd(request, response);
		} else if (method.equals("add")) {
			add(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
