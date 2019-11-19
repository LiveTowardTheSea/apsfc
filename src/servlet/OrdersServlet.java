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

import po.OrdersSearch;
import po.Page;
import service.OrdersService;
import util.PageUtil;
import vo.OrdersInfo;
import vo.SalesVolume;

/**
 * Servlet implementation class OrdersServlet
 */
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrdersService ordersService = new OrdersService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void findByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String currentPageStr = request.getParameter("currentPage");
		int currentPage;
		// 如果没有传入currentpage 默认查询第一页
		if (currentPageStr == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(currentPageStr);
		}
		long count = ordersService.count(null); // 获取总条数
		// 根据获取的count和currentpage创建一个page对象
		@SuppressWarnings("unchecked")
		Page<OrdersInfo> page = PageUtil.createPage(10, (int) count, currentPage);
		//根据page对象分页查找
		page = ordersService.findByPage(page, null);
		// 把page保存在域中
		request.setAttribute("ordersPage", page);
		request.getRequestDispatcher("/admin/order.jsp").forward(request, response);
    }
    
	protected void confirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取id
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String currentPage = request.getParameter("currentPage");
		// 删除id对应的项目
		int result = ordersService.confirm(id);
		// 获取输出流
		PrintWriter out = response.getWriter();
		if (result == 1) { // 成功
			// 弹出对话框 跳转到查询所有界面
			out.print("<script>" + "alert('确认成功');" + "window.location.href='" + request.getContextPath()
					+ "/OrdersServlet?method=findByPage&currentPage=" + currentPage + "';" + "</script>");
		} else { // 失败
			out.print("<script>" + "alert('确认失败');" + "window.location.href='" + request.getContextPath()
					+ "/OrdersServlet?method=findByPage&currentPage=" + currentPage + "';" + "</script>");
		}
	}

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取id
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String currentPage = request.getParameter("currentPage");
		// 删除id对应的项目
		int result = ordersService.delete(id);
		// 获取输出流
		PrintWriter out = response.getWriter();
		if (result == 1) { // 删除成功
			// 弹出对话框 跳转到查询所有界面
			out.print("<script>" + "alert('删除成功');" + "window.location.href='" + request.getContextPath()
					+ "/OrdersServlet?method=findByPage&currentPage="+ currentPage +"';" + "</script>");
		} else { // 删除失败
			out.print("<script>" + "alert('删除失败');" + "window.location.href='" + request.getContextPath()
			+ "/OrdersServlet?method=findByPage&currentPage="+ currentPage +"';" + "</script>");
		}
    }
    
    protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String userid = request.getParameter("userid");
    	String menuname = request.getParameter("menuname");
    	String date = request.getParameter("date");
    	String currentPageStr = request.getParameter("currentPage");
    	OrdersSearch search = new OrdersSearch(userid, menuname, date, null);
		int currentPage;
		// 如果没有传入currentpage 默认查询第一页
		if (currentPageStr == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(currentPageStr);
		}
    	long count = ordersService.count(search); // 获取总条数
		// 根据获取的count和currentpage创建一个page对象
		@SuppressWarnings("unchecked")
		Page<OrdersInfo> page = PageUtil.createPage(10, (int) count, currentPage);
		page = ordersService.findByPage(page, search);
		//根据page对象分页查找
		request.setAttribute("ordersSearch", search);
		request.setAttribute("ordersPage", page);
    	request.getRequestDispatcher("/admin/order_search.jsp").forward(request, response);
    }
    
    protected void findSales(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Date d = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String date = ft.format(d);
    	ArrayList<SalesVolume> salesList = ordersService.findSaleByDate(date);
    	request.setAttribute("salesList", salesList);
    	request.getRequestDispatcher("/admin/order_statistic.jsp").forward(request, response);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		if(method.equals("findByPage")) {
			findByPage(request, response);
		} else if (method.equals("confirm")) {
			confirm(request, response);
		} else if (method.equals("cancel")) {
			delete(request, response);
		} else if (method.equals("search")) {
			search(request, response);
		} else if(method.equals("findSales")) {
			findSales(request, response);
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
