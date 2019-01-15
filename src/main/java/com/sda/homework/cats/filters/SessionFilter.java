package com.sda.homework.cats.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class SessionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;

        Boolean logged = Optional.ofNullable(httpRequest.getSession().getAttribute("logged"))
                .map(Boolean.class::cast).orElse(false);
        if (logged) {
            chain.doFilter(req, resp);
        } else {
            HttpServletResponse httpResponse = (HttpServletResponse) resp;
            httpResponse.sendRedirect("/login.jsp");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
