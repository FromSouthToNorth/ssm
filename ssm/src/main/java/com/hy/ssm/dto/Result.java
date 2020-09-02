package com.hy.ssm.dto;

/**
 * 封装json对象，所有返回结果都使用它
 */
public class Result<T> {

    private boolean success;

    private T       data;       // 成功时返回的数据

    private String  error;      // 错误信息

    public Result() {
    }

    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public Result(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
