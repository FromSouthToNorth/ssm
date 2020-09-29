package com.hy.ssm.dao;

import com.hy.ssm.entity.OperLog;

import java.util.List;

public interface OperLogDAO {

    /**
     * 新增操作日志
     * @param operLog 操作日志对象
     */
    void insertOperLog(OperLog operLog);

    List<OperLog> selectOperLogList(OperLog operLog);

}
