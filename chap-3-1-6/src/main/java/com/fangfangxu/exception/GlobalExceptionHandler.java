package com.fangfangxu.exception;

import com.fangfangxu.dto.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW="error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req,Exception e) throws Exception{
        ModelAndView  mv=new ModelAndView();
        mv.addObject("ex",e);
        mv.addObject("url",req.getRequestURL());
        mv.setViewName(DEFAULT_ERROR_VIEW);
        return mv;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> myException(HttpServletRequest req, Exception e) throws Exception{
        ErrorInfo<String> errorInfo=new ErrorInfo();
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setMessage(e.getMessage());
        errorInfo.setUrl(req.getRequestURL().toString());
        errorInfo.setData("Some Data");
        return errorInfo;
    }

}
