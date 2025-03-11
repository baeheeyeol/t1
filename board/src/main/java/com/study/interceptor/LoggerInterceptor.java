package com.study.interceptor;

import lombok.extern.slf4j.Slf4j;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Slf4j
public class LoggerInterceptor implements HandlerInterceptor {@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)	throws Exception {
		log.info("===============================================");
    	log.info("==================== BEGIN ====================");
    	log.info("Request URI ===> " + request.getRequestURI());
    	return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
	      log.info("==================== END ======================");
	      log.info("===============================================");
	      HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)	throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}


}