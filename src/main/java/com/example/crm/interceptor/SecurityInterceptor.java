package com.example.crm.interceptor;


import com.example.crm.entity.Module;
import com.example.crm.entity.ModuleOperation;
import com.example.crm.entity.Operation;
import com.example.crm.entity.Role;
import com.example.crm.vo.EmpVo;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.List;

public class SecurityInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果是SpringMVC请求
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        String requestURI = request.getRequestURI(); //uri = 端口号后例如 http://localhost:8080<<</emp/testPage/1/2>>>
//        System.out.println(handler);//com.example.crm.controller.EmpController#testPage(Integer, Integer)
        //如果是登录请求
        if (requestURI.startsWith("/login")){
            return true;
        }
        HttpSession session = request.getSession();
        Object o = session.getAttribute("user");
        if (!(o instanceof EmpVo)) {
            return false;
        }
        EmpVo empVo = (EmpVo) o;
        List<ModuleOperation> moduleOperations = empVo.getModuleOperations();
        for (ModuleOperation moduleOperation : moduleOperations) {
            String path = moduleOperation.getPath();
            System.out.println(path);
            if ((moduleOperation.getEnable() > 0) && requestURI.startsWith(path)) {
                return true;
            }
        }
        return false;
    }
}
