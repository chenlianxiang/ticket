package com.heheda.ticket.web.vo.error;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: ticket
 * @description: 错误对象
 * @author: clx
 * @create: 2019-09-11 10:54
 */
public class ErrorVo {

    private String localizedMessage;

    private String ex_message;

    private String message;

    private String clazz;

    private int lineNumber;

    private String fileName;

    private boolean nativeMethod;

    private String className;

    private String methodName;

    private String date;


    //Date指定格式：yyyy-MM-dd HH:mm:ss
    private SimpleDateFormat simpleDateFormat =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public ErrorVo errorVo(RuntimeException ex,String message){
        ErrorVo errorVo=new ErrorVo();
        //自定义传入消息提示
        errorVo.setMessage(message);
        //发生错误的类名
        errorVo.setClassName( ex.getStackTrace()[0].getClassName());
        //方法名
        errorVo.setMethodName(ex.getStackTrace()[0].getMethodName());
        errorVo.setFileName(ex.getStackTrace()[0].getFileName());
        errorVo.setLineNumber( ex.getStackTrace()[0].getLineNumber());
        errorVo.setNativeMethod(ex.getStackTrace()[0].isNativeMethod());
        errorVo.setEx_message(ex.getMessage());
        errorVo.setLocalizedMessage(ex.getLocalizedMessage());
        errorVo.setClazz(ex.getClass().getName());
        errorVo.setDate(simpleDateFormat.format(new Date()));
        return errorVo;
    }
    public ErrorVo errorVo(Exception ex,String message){
        ErrorVo errorVo=new ErrorVo();
        errorVo.setMessage(message);
        errorVo.setClassName( ex.getStackTrace()[0].getClassName());
        errorVo.setMethodName(ex.getStackTrace()[0].getMethodName());
        errorVo.setFileName(ex.getStackTrace()[0].getFileName());
        errorVo.setLineNumber( ex.getStackTrace()[0].getLineNumber());
        errorVo.setNativeMethod(ex.getStackTrace()[0].isNativeMethod());
        errorVo.setEx_message(ex.getMessage());
        errorVo.setLocalizedMessage(ex.getLocalizedMessage());
        errorVo.setClazz(ex.getClass().getName());
        errorVo.setDate(simpleDateFormat.format(new Date()));
        return errorVo;
    }

    public ErrorVo errorVo(VirtualMachineError ex,String message){
        ErrorVo errorVo=new ErrorVo();
        errorVo.setMessage(message);
        errorVo.setClassName( ex.getStackTrace()[0].getClassName());
        errorVo.setMethodName(ex.getStackTrace()[0].getMethodName());
        errorVo.setFileName(ex.getStackTrace()[0].getFileName());
        errorVo.setLineNumber( ex.getStackTrace()[0].getLineNumber());
        errorVo.setNativeMethod(ex.getStackTrace()[0].isNativeMethod());
        errorVo.setEx_message(ex.getMessage());
        errorVo.setLocalizedMessage(ex.getLocalizedMessage());
        errorVo.setClazz(ex.getClass().getName());
        errorVo.setDate(simpleDateFormat.format(new Date()));
        return errorVo;
    }

    public ErrorVo errorVo(Throwable ex,String message){
        ErrorVo errorVo=new ErrorVo();
        errorVo.setMessage(message);
        errorVo.setClassName(ex.getStackTrace()[0].getClassName());
        errorVo.setMethodName(ex.getStackTrace()[0].getMethodName());
        errorVo.setFileName(ex.getStackTrace()[0].getFileName());
        errorVo.setLineNumber( ex.getStackTrace()[0].getLineNumber());
        errorVo.setNativeMethod(ex.getStackTrace()[0].isNativeMethod());
        errorVo.setEx_message(ex.getMessage());
        errorVo.setLocalizedMessage(ex.getLocalizedMessage());
        errorVo.setClazz(ex.getClass().getName());
        errorVo.setDate(new Date().toString());
        return errorVo;
    }
    public String getLocalizedMessage() {
        return localizedMessage;
    }

    public void setLocalizedMessage(String localizedMessage) {
        this.localizedMessage = localizedMessage;
    }

    public String getEx_message() {
        return ex_message;
    }

    public void setEx_message(String ex_message) {
        this.ex_message = ex_message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isNativeMethod() {
        return nativeMethod;
    }

    public void setNativeMethod(boolean nativeMethod) {
        this.nativeMethod = nativeMethod;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
