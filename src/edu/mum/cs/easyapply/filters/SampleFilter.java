package edu.mum.cs.easyapply.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "SampleFilter")
public class SampleFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        String baseUrl = String.format("%s://%s:%s%s", req.getScheme(), req.getServerName(),
                req.getServerPort(), context.getContextPath());
        context.setAttribute("baseUrl", baseUrl);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
