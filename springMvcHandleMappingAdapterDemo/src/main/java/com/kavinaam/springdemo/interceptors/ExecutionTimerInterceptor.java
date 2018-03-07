package com.kavinaam.springdemo.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class ExecutionTimerInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(ExecutionTimerInterceptor.class);
    private long PREHANDLE_TIME = 0;
    private long POSTHANDLE_TIME = 0;
    private long AFTER_COMPLETION_TIME = 0;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        PREHANDLE_TIME = System.currentTimeMillis();
        logger.info("Info Message: PREHANDLE_TIME = "+PREHANDLE_TIME);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        POSTHANDLE_TIME = System.currentTimeMillis();
        logger.info("Info Message: POSTHANDLE_TIME = "+POSTHANDLE_TIME);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        AFTER_COMPLETION_TIME = System.currentTimeMillis();
        logger.info("Info Message: AFTER_COMPLETION_TIME = "+AFTER_COMPLETION_TIME);
        logger.info("Info Message: HANDLER_EXECUTION_TIME = "+(POSTHANDLE_TIME-PREHANDLE_TIME));
        logger.info("Info Message: TOTAL_EXECUTION_TIME = "+(AFTER_COMPLETION_TIME-PREHANDLE_TIME));
    }
}
