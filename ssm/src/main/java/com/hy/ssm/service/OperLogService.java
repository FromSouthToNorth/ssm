package com.hy.ssm.service;

import com.hy.ssm.entity.OperLog;

import java.util.List;

public interface OperLogService {

    void insertOperLog(OperLog operLog);

    List<OperLog> selectOperLogList(OperLog operLog);

}
