package com.fangfangxu.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW="error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req,Exception e) throws Exception{
        ModelAndView  mv=new ModelAndView();
        mv.addObject(e);
        mv.addObject(req.getRequestURL());
        mv.setViewName(DEFAULT_ERROR_VIEW);
        return mv;
    }



}
