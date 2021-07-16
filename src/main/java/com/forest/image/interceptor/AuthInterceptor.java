//package com.forest.image.interceptor;
//
//import cn.hutool.core.util.ObjectUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.lang.Nullable;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.Random;
//
///**
// * @author Forest
// * @date 2020年05月17日 04:31
// */
//@Slf4j
//public class AuthInterceptor implements HandlerInterceptor {
//
//    /**
//     * session过期时间半小时
//     */
//    private static final int MAX_TIME = 15 * 60;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
//        HttpSession session = request.getSession();
//        String isLogin = (String) session.getAttribute("isLogin");
//        if (ObjectUtil.isNotEmpty(isLogin)) {
//            return true;
//        }
//        log.info("请求{}失败，尚未登录，跳转至登录页", request.getRequestURI());
//        return false;
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
//                         @Nullable Exception ex) throws Exception {
//        System.err.println(request.getSession().getMaxInactiveInterval());
//    }
//
//    public static void main(String[] args) {
//        Random random = new Random(47);
//        System.out.println(random.nextInt(100));
//        System.out.println(random.nextInt(100));
//        System.out.println(random.nextInt(100));
//        System.out.println(random.nextInt(100));
//        System.out.println(random.nextInt(100));
//        System.out.println(random.nextInt(100));
//    }
//}
