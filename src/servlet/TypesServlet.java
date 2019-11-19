package servlet;

/*
 * 一个Servlet对应多个功能
 * 一个功能对应一个方法
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import po.Types;
import service.TypesService;

/**
 * Servlet implementation class TypesServlet
 */
public class TypesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TypesService typesService = new TypesService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TypesServlet() {
		super();
	}

	// 查询所有
	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Types> typesList = typesService.findAll();
		// 把查询到的信息添加到域中
		request.setAttribute("typesList", typesList);
		// 转发到type.jsp
		request.getRequestDispatcher("/admin/type.jsp").forward(request, response);
	}

	// 删除
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		// String --> int
		int id = Integer.parseInt(idStr);
		int result = typesService.delete(id);
		// 获取输出流
		PrintWriter out = response.getWriter();
		if (result == 1) { // 删除成功
			// 弹出对话框 跳转到查询所有界面
			out.print("<script>" + "alert('删除成功');" + "window.location.href='" + request.getContextPath()
					+ "/TypesServlet?method=findAll';" + "</script>");
		} else { // 删除失败
			out.print("<script>" + "alert('删除失败');" + "window.location.href='" + request.getContextPath()
					+ "/TypesServlet?method=findAll';" + "</script>");
		}
	}

	// 根据id查询
	protected void findById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取id
		String idStr = request.getParameter("id");
		// String --> int
		int id = Integer.parseInt(idStr);
		// 根据id查询
		Types type = typesService.findById(id);
		// 把查询到的信息添加到域中
		request.setAttribute("type", type);
		// 转发到修改页
		request.getRequestDispatcher("/admin/type_update.jsp").forward(request, response);
	}

	// 修改
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取id,获取name
		String idStr = request.getParameter("id");
		String name = request.getParameter("name");
		// String --> int
		int id = Integer.parseInt(idStr);
		// 根据id查询
		int result = typesService.update(id, name);
		PrintWriter out = response.getWriter();
		if (result == 1) {
			out.print("<script>" + "alert('修改成功');" + "window.location.href='" + request.getContextPath()
			+ "/TypesServlet?method=findAll';" + "</script>");
		} else {
			out.print("<script>" + "alert('修改失败');" + "window.location.href='" + request.getContextPath()
			+ "/TypesServlet?method=findAll';" + "</script>");
		}
	}

	// 添加
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取name
		String name = request.getParameter("name");
		Types type = new Types();
		type.setName(name);
		// 根据id查询
		int result = typesService.add(type);
		PrintWriter out = response.getWriter();
		if (result == 1) {
			out.print("<script>" + "alert('添加成功');" + "window.location.href='" + request.getContextPath()
			+ "/TypesServlet?method=findAll';" + "</script>");
		} else {
			out.print("<script>" + "alert('添加失败');" + "window.location.href='" + request.getContextPath()
			+ "/TypesServlet?method=findAll';" + "</script>");
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.setContentType("text/html;charset=utf-8");
		// request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if (method.equals("findAll")) {
			findAll(request, response);
		} else if (method.equals("delete")) {
			delete(request, response);
		} else if (method.equals("findById")) {
			findById(request, response);
		} else if (method.equals("update")) {
			update(request, response);
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
