package com.blessingsoftware.kivotos.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class KivotosFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri = request.getRequestURI();
        HttpSession session = request.getSession();

        if(uri.contains("login") || uri.contains("register") || uri.contains("static")){
            filterChain.doFilter(request, response);
            System.out.println("放行"+uri);
        }else{
            if(session.getAttribute("teacher")!=null){
                filterChain.doFilter(request, response);
                System.out.println("放行"+uri);
            }else{
                System.out.println("拦截"+uri);
                request.setAttribute("msg","您未进行过登录，您无访问权限");
                request.getRequestDispatcher("login").forward(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
