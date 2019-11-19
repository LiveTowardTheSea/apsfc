package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import po.Users;

/**
 * Servlet Filter implementation class UsersFilter
 */
public class UsersFilter implements Filter {
	/**
	 * Default constructor.
	 */
	public UsersFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*
		 * 过滤规则 1.如果没有登录，跳转到index.jsp 2.如果已经登录，放行---->chain.doFilter(request,
		 * response);
		 */
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 获取用户请求的url------url包括项目名apsfc/admin/***
		String url = req.getRequestURI();
		// System.out.println(url);
		// String path = req.getServletPath(); //path不包括项目名admin/***
		// System.out.println(path);
		// 获取session 及session中的admin对象
		HttpSession session = req.getSession();
		Users user = (Users) session.getAttribute("user");
		// 判断用户是否已经登录
		if (user != null || url.endsWith(".css") || url.endsWith(".js") || url.endsWith(".gif") || url.endsWith(".jpg")
				|| url.endsWith("index.jsp") || url.endsWith("carry.jsp") || url.endsWith("copyright.jsp")
				|| url.endsWith("top.jsp") || url.endsWith("login.jsp") || url.endsWith("our.jsp")
				|| url.endsWith("reg.jsp") || url.endsWith("shoppingcar.jsp") || url.endsWith("show.jsp")
				|| url.endsWith("notice.jsp") || url.endsWith("noticelist.jsp")) { // 已经登录
			chain.doFilter(request, response); // 放行
		} else { // 没有登录
			// request.getRequestDispatcher("/admin/index.jsp").forward(request,
			// response); //跳转到index界面
			PrintWriter out = res.getWriter();
			out.print("<script>" + "alert('您还没有登录，请先登录');" + "window.location.href='" + req.getContextPath()
					+ "/qiantai/login.jsp" + "';" + "</script>");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
