package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import po.Admin;

/**
 * Servlet Filter implementation class AdminFilter
 */
public class AdminFilter implements Filter {
	private FilterConfig config = null;
    /**
     * Default constructor. 
     */
    public AdminFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		 * 过滤规则
		 * 1.如果没有登录，跳转到index.jsp
		 * 2.如果已经登录，放行---->chain.doFilter(request, response);
		 */
		//读取配置
		String indexPath = this.config.getInitParameter("indexPath");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		//获取用户请求的url------url包括项目名apsfc/admin/***
		String url = req.getRequestURI();
		//System.out.println(url);
		//String path = req.getServletPath();   //path不包括项目名admin/***
		//System.out.println(path);
		//获取session 及session中的admin对象
		HttpSession session = req.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		//判断用户是否已经登录
		if (admin != null || url.endsWith(indexPath) || url.endsWith(".css")
				|| url.endsWith(".js") || url.endsWith(".gif") || url.endsWith(".jpg")) { //已经登录
			chain.doFilter(request, response);  //放行
		} else { //没有登录
			//request.getRequestDispatcher("/admin/index.jsp").forward(request, response); //跳转到index界面
			res.sendRedirect("/apsfc/admin/index.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config = fConfig;
	}

}
