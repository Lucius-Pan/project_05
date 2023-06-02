package indi.Lucius.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: AuthInterceptor
 * @Description:
 * @Author: Lucius Pan
 * @Date: 2023/6/2 11:03
 */
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("收到了请求"+request.getRequestURI());
        // 从session中获取用户信息
        Object user = request.getSession().getAttribute("user");
        System.out.println("获取到用户："+user);
        if (user == null) {
            // 未登录，返回登录页面

//            response.sendRedirect(request.getContextPath()+"/");
           return false;
        }
        // 已登录，放行请求
        System.out.println("已登录，放行请求");
        return true;

//        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("请求处理中"+request.getRequestURI());
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("请求处理完毕"+request.getRequestURI());
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
