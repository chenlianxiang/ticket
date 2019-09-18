package com.heheda.ticket.framework.handler;

import com.alibaba.fastjson.JSON;
import com.heheda.ticket.framework.anno.SecurityParameter;
import com.heheda.ticket.framework.utils.AesEncryptUtils;
import com.heheda.ticket.framework.utils.RSAUtils;
import com.heheda.ticket.web.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @program: ticket
 * @description: 返回统一格式数据
 * @author: clx
 * @create: 2019-09-11 10:47
 */
@RestControllerAdvice(annotations = RestController.class)
public class ApiResponseHandler implements ResponseBodyAdvice {

    @Value("${client.public.key}")
    private String CLIENT_PUBLIC_KEY;

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse)  {

        boolean encode = false;
        if (methodParameter.getMethod().isAnnotationPresent(SecurityParameter.class)) {
            //获取注解配置的包含和去除字段
            SecurityParameter serializedField = methodParameter.getMethodAnnotation(SecurityParameter.class);
            //出参是否需要加密
            encode = serializedField.outEncode();
        }
        if (encode){
            System.out.println("对方法method :【" + methodParameter.getMethod().getName() + "】返回数据进行加密");

           try {
               // 生成aes秘钥
               String aseKey = getRandomString(16);
               // rsa加密
               String encrypted = RSAUtils.encryptedDataOnJava(aseKey, CLIENT_PUBLIC_KEY);

               if (o instanceof String){
                   //自定义请求头的格式
                   serverHttpResponse.getHeaders().setContentType(MediaType.APPLICATION_JSON);
                   // aes加密
                   String requestData = AesEncryptUtils.encrypt(JSON.toJSONString(o), aseKey);
                   //以JSON 字符串返回
                   return JSON.toJSONString(new ApiResponse().success(requestData,encrypted));
               }
               else if (o instanceof ApiResponse){
                   //错误对象
                   return o;
               }
               else {
                   String requestData = AesEncryptUtils.encrypt(JSON.toJSONString(o), aseKey);
                   return new ApiResponse().success(requestData,encrypted);
               }
           }catch (Exception e)
           {

           }
        }else {
            if (o instanceof String){
                //自定义请求头的格式
                serverHttpResponse.getHeaders().setContentType(MediaType.APPLICATION_JSON);
                //以JSON 字符串返回
                return JSON.toJSONString(new ApiResponse().success(o));
            }
            else if (o instanceof ApiResponse){
                //错误对象
                return o;
            }
            else {
                return new ApiResponse().success(o);
            }
        }
        return o;
    }

    /**
     * 创建指定位数的随机字符串
     * @param length 表示生成字符串的长度
     * @return 字符串
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
