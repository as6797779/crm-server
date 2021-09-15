package com.example.crm.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException {

    /**
     *
     * @param notFindAnyOneException
     * @return 自定义异常页面的话,返回值可以是modelAndView,不使用ResponseBody
     */
    @ExceptionHandler(NotFindAnyOneException.class)
    @ResponseBody
    public Map<String, Object> handleCustomException(NotFindAnyOneException notFindAnyOneException) {
        Map<String, Object> errorResultMap = new HashMap<>(16);
        errorResultMap.put("code", notFindAnyOneException.getCode());
        errorResultMap.put("message", notFindAnyOneException.getMessage());
        return errorResultMap;
    }
}
