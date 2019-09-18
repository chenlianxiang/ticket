package com.heheda.ticket.framework.handler;

import com.heheda.ticket.web.vo.ApiResponse;
import com.heheda.ticket.web.vo.error.BindExceptionVo;
import com.heheda.ticket.web.vo.error.ErrorVo;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.IOException;

/**
 * @program: ticket
 * @description: 全局异常处理
 * @author: clx
 * @create: 2019-09-11 10:40
 */
//@ControllerAdvice
//@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ApiResponse runtimeExceptionHandler(RuntimeException ex){

        return new ApiResponse().error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new ErrorVo().errorVo(ex,"运行时出错"));
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    public ApiResponse nullPointerExceptionHandler(NullPointerException ex) {
        return new ApiResponse().error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new ErrorVo().errorVo(ex,"空指针异常"));
    }

    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    public ApiResponse classCastExceptionHandler(ClassCastException ex) {
        return new ApiResponse().error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new ErrorVo().errorVo(ex,"类型转换异常"));
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    public ApiResponse iOExceptionHandler(IOException ex) {
        return new ApiResponse().error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new ErrorVo().errorVo(ex,"类型转换异常"));
    }

    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    public ApiResponse noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        return new ApiResponse().error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new ErrorVo().errorVo(ex,"未知方法异常"));
}

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ApiResponse indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        return new ApiResponse().error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new ErrorVo().errorVo(ex,"数组越界异常"));
    }

    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ApiResponse requestNotReadable(HttpMessageNotReadableException ex) {
        return new ApiResponse().error(HttpStatus.BAD_REQUEST.value(),
                new ErrorVo().errorVo(ex,"400错误"));
    }

    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    public ApiResponse requestTypeMismatch(TypeMismatchException ex) {
        return new ApiResponse().error(HttpStatus.BAD_REQUEST.value(),
                new ErrorVo().errorVo(ex,"400错误"));
    }

    //404错误
    @ExceptionHandler({NoHandlerFoundException.class})
    public ApiResponse noHandlerFoundException(NoHandlerFoundException ex) {
        return new ApiResponse().error(HttpStatus.NOT_FOUND.value(),
                new ErrorVo().errorVo(ex,"找不到相应的路径"));
    }

    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ApiResponse requestMissingServletRequest(MissingServletRequestParameterException ex) {
        return new ApiResponse().error(HttpStatus.BAD_REQUEST.value(),
                new ErrorVo().errorVo(ex,"400错误"));
    }

    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ApiResponse request405(HttpRequestMethodNotSupportedException ex) {
        return new ApiResponse().error(HttpStatus.METHOD_NOT_ALLOWED.value(),
                new ErrorVo().errorVo(ex,"405错误"));
    }

    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public ApiResponse request406(HttpMediaTypeNotAcceptableException ex) {
        return new ApiResponse().error(HttpStatus.NOT_ACCEPTABLE.value(),
                new ErrorVo().errorVo(ex,"405错误"));
    }

    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public ApiResponse server500(RuntimeException ex) {
        return new ApiResponse().error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new ErrorVo().errorVo(ex,"500错误"));
    }

    //栈溢出
    @ExceptionHandler({StackOverflowError.class})
    public ApiResponse requestStackOverflow(StackOverflowError ex) {
        return new ApiResponse().error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new ErrorVo().errorVo(ex,"栈溢出"));
    }

    //除数不能为0
    @ExceptionHandler({ArithmeticException.class})
    public ApiResponse arithmeticException(ArithmeticException ex) {
        return new ApiResponse().error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new ErrorVo().errorVo(ex,"除数不能为0"));
    }


    //其他错误
    @ExceptionHandler({Exception.class})
    public ApiResponse exception(Exception ex) {
        System.out.println("发生异常");
        return new ApiResponse().error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new ErrorVo().errorVo(ex,"其他错误"));
    }

    private <T extends Throwable> ApiResponse resultFormat(Integer code, T ex) {
        return new ApiResponse().error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new ErrorVo().errorVo(ex,"其他错误"));
    }

    @ExceptionHandler({BindException.class})
    public ApiResponse bindException(BindException ex, BindingResult result){
        return new ApiResponse().error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new BindExceptionVo(ex,result).errorVo());
    }

    @ExceptionHandler({JwtException.class})
    public ApiResponse jwtException(JwtException ex){
        return new ApiResponse().error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new ErrorVo().errorVo(ex,"JWT错误"));
    }

    @ExceptionHandler({ExpiredJwtException.class})
    public ApiResponse jwtException(ExpiredJwtException ex){
        return new ApiResponse().error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new ErrorVo().errorVo(ex,"token过期"));
    }
}
