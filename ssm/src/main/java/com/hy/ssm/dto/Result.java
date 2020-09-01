package com.hy.ssm.dto;

import com.hy.ssm.enums.ResultEnums;

/**
 * 封装json对象，所有返回结果都使用它
 */
public class Result<T> {

    private ResultEnums resultEnums;

    private T       data;       // 成功时返回的数据

    private String  error;      // 错误信息

    public Result() {
    }

    public Result(ResultEnums resultEnums, String error) {
        this.resultEnums = resultEnums;
        this.error = error;
    }

    public Result(ResultEnums resultEnums, T data) {
        this.resultEnums = resultEnums;
        this.data = data;
    }

    public ResultEnums getResultEnums() {
        return resultEnums;
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
