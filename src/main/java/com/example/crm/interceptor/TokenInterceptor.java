package com.example.crm.interceptor;

import com.example.crm.utils.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 除了登录的请求我们需要查看是否在 Header 里面携带自定义的 token
        String requestURI = request.getRequestURI(); //uri = 端口号后例如 http://localhost:8080<<</emp/testPage/1/2>>>
        if (requestURI.startsWith("/login")){
            return true;
        }
        String token = request.getHeader("token");
        if (token == null) {
            return false;
        }
        String logname = String.valueOf(request.getParameter("logname"));
        if (!"".equals(token) && token != null) {
//            if (!JwtUtil.isToken(logname, token)){
//                return false;
//            }
        }
        return true;
    }

    public static Object getRequestBody(HttpServletRequest request, String string) {
        Map<String, Object> map = new HashMap<String, Object>();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length > 0) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {
                    map.put(paramName, paramValue);
                    System.out.println(paramName+"->"+paramValue);
                }
            }
        }
        return map.get(string);
    }
}
