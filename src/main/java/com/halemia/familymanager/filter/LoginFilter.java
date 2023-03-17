package com.halemia.familymanager.filter;

import com.halemia.familymanager.context.ThreadContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author : shangchy
 * @Date : Create in 14:35 2023/3/17
 */
public class LoginFilter implements Filter {

    private static Set<String> EXCLUDE_PREFIX = new HashSet<>();
    static {
        EXCLUDE_PREFIX.add("");
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /**
         * 判断登录状态
         */
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        if (EXCLUDE_PREFIX.contains(requestURI)) {
            filterChain.doFilter(servletRequest,servletResponse);
        }
        /**
         * 封装下上下文信息
         */
        String openId = request.getHeader("open_id");
        String familyId = request.getHeader("family_id");
        ThreadContext.getInstance().setOpenId(openId);
        ThreadContext.getInstance().setFamilyId(familyId);

    }

    @Override
    public void destroy() {
        ThreadContext.complete();
    }

}
