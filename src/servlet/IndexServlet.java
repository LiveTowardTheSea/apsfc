package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import po.CarItem;
import po.Menus;
import po.Notice;
import po.Orders;
import po.OrdersSearch;
import po.Page;
import po.Types;
import po.Users;
import service.MenusService;
import service.NoticeService;
import service.OrdersService;
import service.TypesService;
import util.PageUtil;
import vo.MenusInfo;
import vo.OrdersInfo;
import vo.Rorder;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrdersService ordersService = new OrdersService();
	MenusService menusService = new MenusService();
	NoticeService noticeService = new NoticeService();
	TypesService typesService = new TypesService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void allInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//展示所有信息 查询所有信息存入域中 并且显示在网页中
    	//Menus
    	String currentPageStr = request.getParameter("currentPage");
    	int currentPage = 1;
    	if (currentPageStr == null || currentPageStr.equals("")) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(currentPageStr);
		}
    	long totalCount = menusService.count();
    	@SuppressWarnings("unchecked")
		Page<MenusInfo> page = PageUtil.createPage(6, (int)totalCount, currentPage);
    	page = menusService.findByPage(page);
    	request.setAttribute("menusPage", page);
    	
    	//Notice
    	ArrayList<Notice> noticeList = noticeService.findAll();
    	request.setAttribute("noticeList", noticeList);
    	
    	//销售排行
    	ArrayList<Rorder> rankingList = ordersService.findRankingList();
    	request.setAttribute("rankingList", rankingList);
    	
    	//获取到所有所需信息之后转发
    	request.getRequestDispatcher("/qiantai/index.jsp").forward(request, response);
    }
    
    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	/* 餐车操作：餐车使用ArrayList类型
    	 * 获取menuid
    	 * 获取餐车
    	 * 获取不到餐车，创建餐车
    	 * 		findbyid得到menu
    	 * 		根据menu的信息创建caritem对象，添加到餐车中
    	 * 		讲餐车添加到session中
    	 * 获取到了餐车
    	 * 		根据id查询餐车中是否有对应的菜，有---count+1 没有---创建caritem，添加到餐车
    	 */
    	//获取session中已登录的用户和餐车
		HttpSession session = request.getSession();
		/*// 判断用户是否登录
		Users user = (Users) session.getAttribute("user");
		if (user == null) {
			PrintWriter out = response.getWriter();
			out.print("<script>" + "alert('您还没有登录，请先登录');" + "window.location.href='" + request.getContextPath()
					+ "/qiantai/login.jsp" + "';" + "</script>");
			return;
		}*/
    	String idStr = request.getParameter("id");
    	int id = Integer.parseInt(idStr);
    	String currentPage = request.getParameter("currentPage");
    	//获取餐车对象
    	@SuppressWarnings("unchecked")
		ArrayList<CarItem> carList = (ArrayList<CarItem>) session.getAttribute("carList");
    	if(carList == null) { //获取不到餐车
    		carList = new ArrayList<>();
    		Menus menu = menusService.findById(id);
    		CarItem carItem = new CarItem(menu.getId(), menu.getName(), menu.getPrice(), 1);
    		carList.add(carItem);
    	} else { //获取到了餐车
    		boolean flag = false;
    		for (CarItem carItem : carList) {
				if(carItem.getMenuid() == id) {
					flag = true;
					carItem.addCount();
					break;
				}
			}
    		if(flag == false) {
    			Menus menu = menusService.findById(id);
        		CarItem carItem = new CarItem(menu.getId(), menu.getName(), menu.getPrice(), 1);
        		carList.add(carItem);
    		}
    	}
    	session.setAttribute("carList", carList);
    	//session.setAttribute("currentPage", request.getParameter("currentPage"));
    	response.sendRedirect("/apsfc/index.jsp?currentPage=" + currentPage);
    	//allInfo(request, response);
    }
    
    protected void removeItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String url = request.getParameter("url");
    	String idStr = request.getParameter("id");
    	int id = Integer.parseInt(idStr);
    	HttpSession session = request.getSession();
    	@SuppressWarnings("unchecked")
		ArrayList<CarItem> carList = (ArrayList<CarItem>) session.getAttribute("carList");
    	for(int i = 0; i < carList.size(); i++) {
    		if (carList.get(i).getMenuid() == id) {
				carList.remove(i);
				break;
			}
    	}
    	session.setAttribute("carList", carList);
    	if (url != null) {
    		String currentPage = request.getParameter("currentPage");
    		response.sendRedirect("/apsfc/IndexServlet?method=allInfo&currentPage=" + currentPage);
		} else {
			response.sendRedirect("/apsfc/qiantai/shoppingcar.jsp");
		}
	}
    protected void removeAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String url = request.getParameter("url");
    	HttpSession session = request.getSession();
    	@SuppressWarnings("unchecked")
		ArrayList<CarItem> carList = (ArrayList<CarItem>) session.getAttribute("carList");
    	carList.clear();
    	if (url != null) {
    		String currentPage = request.getParameter("currentPage");
    		response.sendRedirect("/apsfc/IndexServlet?method=allInfo&currentPage=" + currentPage);
		} else {
			response.sendRedirect("/apsfc/qiantai/shoppingcar.jsp");
		}
    }
    
    protected void findNoticeById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String idStr = request.getParameter("id");
    	int id = Integer.parseInt(idStr);
    	Notice notice = noticeService.findById(id);
    	request.setAttribute("notice", notice);
    	request.getRequestDispatcher("/qiantai/notice.jsp").forward(request, response);
    }
    
	protected void findOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//创建查找条件search
    	//根据用户查找，获取session中已登录的用户
    	HttpSession session = request.getSession();
    	Users user = (Users) session.getAttribute("user");
    	//判断用户是否登录
    	if(user == null) {
    		PrintWriter out = response.getWriter();
    		out.print("<script>" + "alert('您还没有登录，请先登录');" + "window.location.href='" + request.getContextPath()
			+ "/qiantai/login.jsp" + "';" + "</script>");
    		return;
    	}
		//获取表单中填写的menuname及date
		String menuname = request.getParameter("menuname");
    	String date = request.getParameter("date");
    	String delivery = request.getParameter("delivery");
    	OrdersSearch search = new OrdersSearch(user.getId() + "", menuname, date, delivery);
    	//创建分页
		long count = ordersService.count(search);
    	String currentPageStr = request.getParameter("currentPage");
		int currentPage = 1;
		// 如果没有传入currentpage 默认查询第一页
		if (currentPageStr == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(currentPageStr);
		}
		Page<OrdersInfo> page = PageUtil.createPage(6, (int) count, currentPage);
		//查询结果存入page中
    	page = ordersService.findByPage(page, search);
    	
    	//将查询结果存入request中，供页面调用
    	request.setAttribute("search", search);
    	request.setAttribute("ordersPage", page);
    	request.getRequestDispatcher("/qiantai/order.jsp").forward(request, response);
    }
	
	protected void carToOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取session中已登录的用户和餐车
		HttpSession session = request.getSession();
    	Users user = (Users) session.getAttribute("user");
    	//判断用户是否登录
    	if(user == null) {
    		PrintWriter out = response.getWriter();
    		out.print("<script>" + "alert('您还没有登录，请先登录');" + "window.location.href='" + request.getContextPath()
			+ "/qiantai/login.jsp" + "';" + "</script>");
    		return;
    	}
    	@SuppressWarnings("unchecked")
		ArrayList<CarItem> carList = (ArrayList<CarItem>) session.getAttribute("carList");
    	Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String times = ft.format(date);
		boolean result = true;
    	for (CarItem carItem : carList) {
			Orders order = new Orders(0, user.getId()+"", carItem.getMenuid()+"", carItem.getCount()+"", times, "0");
			boolean r = ordersService.add(order);
			result = result && r;
		}
    	carList.clear();  //传说中的清空购物车！
    	session.removeAttribute("carList");
		// 获取输出流
		PrintWriter out = response.getWriter();
		if (result == true) { // 成功
			// 弹出对话框 跳转到查询所有界面
			out.print("<script>" + "alert('添加成功');" + "window.location.href='" + request.getContextPath()
					+ "/IndexServlet?method=findOrders" + "';" + "</script>");
		} else { // 失败
			out.print("<script>" + "alert('添加失败');" + "window.location.href='" + request.getContextPath()
					+ "/IndexServlet?method=findOrders" + "';" + "</script>");
		}
	}

	protected void findMenuById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
    	int id = Integer.parseInt(idStr);
    	Menus menu = menusService.findById(id);
    	Types type = typesService.findById(Integer.parseInt(menu.getTypeid()));
    	MenusInfo menuInfo = new MenusInfo(0, menu.getName(), type.getId()+"", type.getName(), menu.getBrief(), menu.getBrief(), menu.getPrice(), menu.getSums(), menu.getPrice1(), menu.getSums1(), menu.getImgpath());
    	request.setAttribute("menuInfo", menuInfo);
    	request.getRequestDispatcher("/qiantai/show.jsp").forward(request, response);
	}
	
	protected void findAllNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Notice
    	ArrayList<Notice> noticeList = noticeService.findAll();
    	request.setAttribute("noticeList", noticeList);
    	request.getRequestDispatcher("/qiantai/noticelist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method.equals("allInfo")) {
			allInfo(request, response);
		} else if (method.equals("addItem")) {
			addItem(request, response);
		} else if (method.equals("removeItem")) {
			removeItem(request, response);
		} else if (method.equals("removeAll")) {
			removeAll(request, response);
		} else if (method.equals("findNoticeById")) {
			findNoticeById(request, response);
		} else if (method.equals("findOrders")) {
			findOrders(request, response);
		} else if (method.equals("carToOrder")) {
			carToOrder(request, response);
		} else if (method.equals("findMenuById")) {
			findMenuById(request, response);
		} else if (method.equals("findAllNotice")) {
			findAllNotice(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
