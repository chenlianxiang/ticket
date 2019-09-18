package com.heheda.ticket.web.vo;

/**
 * @program: ticket
 * @description: 返回统一格式数据类
 * @author: clx
 * @create: 2019-09-11 10:41
 */
public class ApiResponse {

    //返回 1：正确 0：错误
    private int code;

    //返回请求状态码
    private int status;

    //返回结果  success / error
    private String result;

    //返回 请求数据结果
    private Object data;

    //返回错误信息对象
    private Object error_msg;

    private String encrypted;

    public ApiResponse success(Object data){
        return success(data,"");
    }
    //正确结果对象
    public ApiResponse success(Object data,String encrypted){
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setEncrypted(encrypted);
        apiResponse.setCode(1);
        apiResponse.setStatus(200);
        apiResponse.setResult("success");
        apiResponse.setData(data);
        return apiResponse;
    }


    //错误对象
    public ApiResponse error(int status,Object error_msg){
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setCode(0);
        apiResponse.setStatus(status);
        apiResponse.setResult("error");
        apiResponse.setError_msg(error_msg);
        return apiResponse;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getError_msg() {
        return error_msg;
    }

    public void setError_msg(Object error_msg) {
        this.error_msg = error_msg;
    }

    public String getEncrypted() {
        return encrypted;
    }

    public void setEncrypted(String encrypted) {
        this.encrypted = encrypted;
    }
}
