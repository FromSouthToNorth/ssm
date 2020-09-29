package com.hy.ssm.service.impl;

import com.hy.ssm.dao.LogininforDAO;
import com.hy.ssm.entity.Logininfor;
import com.hy.ssm.service.LogininforService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LogininforServiceImpl implements LogininforService {

    @Resource
    private LogininforDAO logininforDAO;

    @Override
    public void insertLogininfor(Logininfor logininfor) {
        logininforDAO.insertLogininfor(logininfor);
    }

}
