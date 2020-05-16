package com.forest.image.interceptor;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Forest
 * @date 2020年05月17日 04:31
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String isLogin = (String) request.getSession().getAttribute("isLogin");
        if (ObjectUtil.isNotEmpty(isLogin)) {
            return true;
        }
        System.err.println("未登录");
        return false;
    }
}
