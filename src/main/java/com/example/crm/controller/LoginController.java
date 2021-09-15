package com.example.crm.controller;

import com.example.crm.service.IEmpService;
import com.example.crm.utils.JwtUtil;
import com.example.crm.vo.EmpVo;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import io.jsonwebtoken.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class LoginController {
    @Autowired
    IEmpService empService;
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @PostMapping("login")
    public ResponseEntity<EmpVo> login(@RequestParam("logname")String logname, @RequestParam("password")String password, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        EmpVo empVo = empService.login(logname, password);
        if (empVo == null){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        String tokenLogname = JwtUtil.generate(empVo.getLogname());
        HttpHeaders headers = new HttpHeaders();
        headers.add("token",tokenLogname);
        ResponseEntity<EmpVo> responseEntity = ResponseEntity.status(HttpStatus.OK).headers(headers).body(null);
        redisTemplate.opsForValue().set(logname,empVo,1, TimeUnit.DAYS);
        return responseEntity;
    }

    @GetMapping("menu")
    public ResponseEntity<Object> getMenu(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("token");
        //从redis中拿到存储的empvo
        Object o = redisTemplate.opsForValue().get(JwtUtil.parse(token).get("p"));
        if (o instanceof EmpVo){
            EmpVo empVo = (EmpVo)o;
            ResponseEntity<Object> responseEntity = ResponseEntity.status(HttpStatus.OK).body(empVo.getModules());
            return responseEntity;
        }else {
            return new ResponseEntity<Object>(HttpStatus.FORBIDDEN);
        }
    }
}
