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

import po.Notice;
import service.NoticeService;

/**
 * Servlet implementation class NoticeServlet
 */
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeService noticeService = new NoticeService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Notice> noticeList = noticeService.findAll();
		request.setAttribute("noticeList", noticeList);
		request.getRequestDispatcher("/admin/notice.jsp").forward(request, response);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		// String --> int
		int id = Integer.parseInt(idStr);
		int result = noticeService.delete(id);
		// 获取输出流
		PrintWriter out = response.getWriter();
		if (result == 1) { // 删除成功
			// 弹出对话框 跳转到查询所有界面
			out.print("<script>" + "alert('删除成功');" + "window.location.href='" + request.getContextPath()
					+ "/NoticeServlet?method=findAll';" + "</script>");
		} else { // 删除失败
			out.print("<script>" + "alert('删除失败');" + "window.location.href='" + request.getContextPath()
					+ "/NoticeServlet?method=findAll';" + "</script>");
		}
	}
	
	protected void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String times = ft.format(date);
		Notice notice = new Notice(0, name, content, times);
		int result = noticeService.add(notice);
		// 获取输出流
		PrintWriter out = response.getWriter();
		if (result == 1) { // 成功
			// 弹出对话框 跳转到查询所有界面
			out.print("<script>" + "alert('添加成功');" + "window.location.href='" + request.getContextPath()
					+ "/NoticeServlet?method=findAll';" + "</script>");
		} else { // 失败
			out.print("<script>" + "alert('添加失败');" + "window.location.href='" + request.getContextPath()
					+ "/NoticeServlet?method=findAll';" + "</script>");
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method.equals("findAll")) {
			findAll(request, response);
		} else if (method.equals("delete")) {
			delete(request, response);
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
