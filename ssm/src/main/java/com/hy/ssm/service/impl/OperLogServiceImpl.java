package com.hy.ssm.service.impl;

import com.hy.ssm.dao.OperLogDAO;
import com.hy.ssm.entity.OperLog;
import com.hy.ssm.service.OperLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OperLogServiceImpl implements OperLogService {

    @Resource
    private OperLogDAO operLogDAO;

    @Override
    public void insertOperLog(OperLog operLog) {
        operLogDAO.insertOperLog(operLog);
    }

    @Override
    public List<OperLog> selectOperLogList(OperLog operLog) {
        return operLogDAO.selectOperLogList(operLog);
    }
}
