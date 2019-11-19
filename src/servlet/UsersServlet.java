package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import po.CarItem;
import po.Users;
import service.UsersService;

/**
 * Servlet implementation class UsersServlet
 */
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersService usersService = new UsersService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		Users user = usersService.findUserByNameAndPwd(name, pwd);
		HttpSession session = request.getSession();
		if(user != null) {
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath() + "/IndexServlet?method=allInfo");
		} else {
			request.setAttribute("name", name);
			request.getRequestDispatcher("/qiantai/login.jsp").forward(request, response);
		}
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		ArrayList<CarItem> carList = (ArrayList<CarItem>) session.getAttribute("carList");
		if (carList != null) {
			carList.clear();
			session.removeAttribute("carList");
		}
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}
    
	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String realname = request.getParameter("realname");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String card = request.getParameter("card");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		Users user = new Users(0, name, pwd, realname, sex, age, card, address, phone, email, code, "1");
		int result = usersService.register(user);
		PrintWriter out = response.getWriter();
		if (result == 1) {
			out.print("<script>" + "alert('注册成功,请登录');" + "window.location.href='" + request.getContextPath()
			+ "/qiantai/login.jsp';" + "</script>");
		} else if(result == -1){
			out.print("<script>" + "alert('用户名已存在！');" + "window.location.href='" + request.getContextPath()
			+ "/qiantai/reg.jsp';" + "</script>");
		} else {
			out.print("<script>" + "alert('注册失败');" + "window.location.href='" + request.getContextPath()
			+ "/qiantai/reg.jsp';" + "</script>");
		}
		
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String pwd = request.getParameter("pwd");
		String realname = request.getParameter("realname");
		String age = request.getParameter("age");
		String card = request.getParameter("card");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		Users user = new Users(id, ((Users)session.getAttribute("user")).getName(), pwd, realname, ((Users)session.getAttribute("user")).getSex(), age, card, address, phone, email, code, "1");
		int result = usersService.update(id, user);
		PrintWriter out = response.getWriter();
		if (result == 1) {
			session.removeAttribute("user");
			session.setAttribute("user", user);
			out.print("<script>" + "alert('修改成功');" + "window.location.href='" + request.getContextPath()
			+ "/index.jsp';" + "</script>");
		} else {
			out.print("<script>" + "alert('修改失败');" + "window.location.href='" + request.getContextPath()
			+ "/qiantai/center.jsp';" + "</script>");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		if (method.equals("login")) {
			login(request, response);
		} else if (method.equals("logout")) {
			logout(request, response);
		} else if (method.equals("register")) {
			register(request, response);
		} else if (method.equals("update")) {
			update(request, response);
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
