package com.sohu.cache.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sohu.cache.entity.AppUser;
import com.sohu.cache.web.service.UserService;
import com.sohu.cache.web.util.UserLoginStatusUtil;

/**
 * 前台登陆验证
 *
 * @author leifu
 * @Time 2014年6月12日
 */
public class FrontUserLoginInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(FrontUserLoginInterceptor.class);
    
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        long userId = UserLoginStatusUtil.getUserIdFromLoginStatus(request);
        AppUser user = userService.get(userId);
        
        if (user == null) {
            String path = request.getSession(true).getServletContext().getContextPath();
            response.sendRedirect(path + "/manage/login");
            return false;
        }
        
        request.setAttribute("userInfo", user);
        request.setAttribute("uri", request.getRequestURI());
        
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}