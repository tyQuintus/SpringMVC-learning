package com.quintus.error;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 全局的异常发生，会走此类写的handler。可以返回逻辑视图 转发和重定向

@ControllerAdvice
// @RestControllerAdvice = @ControllerAdvice + @ResponseBody 前后端分离项目可以直接写这个注解
// @ResponseBody 表示直接返回json字符串
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public Object ArithmeticExceptionHandler(ArithmeticException e){
        // 自定义处理异常
        String message = e.getMessage();
        System.out.println("message = " + message);
        return message;
    }

    // 若没有找到指定的异常处理方法，则会到父异常的处理方法
    @ExceptionHandler(Exception.class)
    public Object ExceptionHandler(Exception e){
        // 自定义处理异常
        String message = e.getMessage();
        System.out.println("message = " + message);
        return message;
    }
}
