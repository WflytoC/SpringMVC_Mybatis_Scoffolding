package exception;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wcshi on 2017/3/27.
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        CustomException customException = null;
        if (ex instanceof CustomException) {
            customException = (CustomException)ex;
        } else {
            customException = new CustomException("未知错误");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message",customException.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
