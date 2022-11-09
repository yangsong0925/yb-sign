package com.yb.common;

import lombok.extern.log4j.Log4j2;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author yangsong
 * @version 1.0
 * @date 2022/11/1 11:50
 */
@Log4j2
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public R<String> exceptionHandler(HttpServletRequest request, Exception e) {
        log.error("医保加密服务系统异常", e);
        return R.error("医保加密服务系统异常");

    }
}