package com.ruituo.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * description
 *
 * @author huijunjie
 * @date 2018-05-22 下午 2:46
 */
@WebFilter(urlPatterns = "/**",filterName = "firstFilter")
public class FirstFilter implements Filter{

    private Logger logger = Logger.getLogger(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("come in doFilter()");
        logger.info("before do");
        filterChain.doFilter(servletRequest,servletResponse);
        logger.info("after do");
    }

    @Override
    public void destroy() {
        logger.info("destroy()");
    }
}
