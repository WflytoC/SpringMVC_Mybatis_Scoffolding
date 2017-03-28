package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by wcshi on 2017/3/27.
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("----LoginInterceptor---preHandle");
        //获取请求的URL
        String url = request.getRequestURI();
        //判断URL是否是公开地址(实际使用时将公开地址配置在文件中)
        if (url.indexOf("login") >= 0) {
            return true;
        }
        //判断session
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        if (username != null) {
            return true;
        }
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("----LoginInterceptor---postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("----LoginInterceptor---afterCompletion");
    }
}
