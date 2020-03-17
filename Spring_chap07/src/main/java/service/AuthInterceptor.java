package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
@Component("authInterceptor")
public class AuthInterceptor extends HandlerInterceptorAdapter
{
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        System.out.println("AI : preHandle()");
       HttpSession session = request.getSession(false);
      /* if(session == null)
       {
           response.sendError(HttpServletResponse.SC_FORBIDDEN);
           return false;
       }*/
       if(session.getAttribute("auth") == null)
       {
           //response.sendError(HttpServletResponse.SC_FORBIDDEN);
           response.sendRedirect("/Spring_chap07/auth/login");
           return false;
       }
           return true;
    }
    
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {
        System.out.println("AI : afterCompletion()");
    }
    
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        System.out.println("AI : postHandle()");
    }
}
