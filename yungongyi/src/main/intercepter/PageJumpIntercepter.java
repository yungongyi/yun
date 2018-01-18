package cn.tuyuan.yungongyi.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 控制前端页面跳转
 * @author Administrator
 *
 */
public class PageJumpIntercepter implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse reponse, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse reponse,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		if(request.getSession().getAttribute("userId")==null){
			 System.out.println("Interceptor：跳转到login页面！");  
	          request.getRequestDispatcher("/WEB-INF/jsp/loginpage.jsp").forward(request, response);
	          return false;
		}
		
		return true;
		
	}

	
}
