package com.heheda.ticket.framework.handler;

import com.alibaba.fastjson.JSON;
import com.heheda.ticket.framework.anno.JwtIgnore;
import com.heheda.ticket.framework.constants.JwtConstant;
import com.heheda.ticket.framework.utils.JwtUtils;
import com.heheda.ticket.web.vo.ApiResponse;
import com.heheda.ticket.web.vo.error.ErrorVo;
import com.heheda.ticket.web.vo.jwt.JwtParam;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: project
 * @description: Jwt拦截器
 * @author: clx
 * @create: 2019-08-22 15:45
 */

@Slf4j
public class JwtInterceptor implements HandlerInterceptor {


    @Autowired
    private JwtParam jwtParam;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        response.setHeader("content-type", "text/json;charset=utf-8");
        // 忽略带JwtIgnore注解的请求, 不做后续token认证校验
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            JwtIgnore jwtIgnore = handlerMethod.getMethodAnnotation(JwtIgnore.class);
            if (jwtIgnore != null) {
                return true;
            }
        }

        if (HttpMethod.OPTIONS.equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);

            return true;
        }

        final String authHeader = request.getHeader(JwtConstant.AUTH_HEADER_KEY);

        if (StringUtils.isEmpty(authHeader)) {
            // TODO 这里自行抛出异常
            log.info("===== 用户未登录, 请先登录 =====");
            String json = JSON.toJSONString(new ApiResponse().error(401, "===== 用户未登录, 请先登录 ====="));
            response.getOutputStream().write(json.getBytes());
            return false;
        }

        // 校验头格式校验
        if (!JwtUtils.validate(authHeader)) {
            // TODO 这里自行抛出异常
            log.info("===== token格式异常 =====");
            String json = JSON.toJSONString(new ApiResponse().error(401, "===== 用户未登录, 请先登录 ====="));
            response.getOutputStream().write(json.getBytes());
            return false;
        }

        // token解析
        final String authToken = JwtUtils.getRawToken(authHeader);
        Claims claims = JwtUtils.parseToken(authToken, jwtParam.getBase64Secret());
        if (claims == null) {
            log.info("===== token解析异常 =====");
            String json = JSON.toJSONString(new ApiResponse().error(401, "===== 用户未登录, 请先登录 ====="));
            response.getOutputStream().write(json.getBytes());
            return false;
        }

        request.setAttribute("CLAIMS", claims);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

    }
}
