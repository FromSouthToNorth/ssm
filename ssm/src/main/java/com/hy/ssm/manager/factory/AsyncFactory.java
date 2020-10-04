package com.hy.ssm.manager.factory;

import com.hy.ssm.constant.Constants;
import com.hy.ssm.entity.Logininfor;
import com.hy.ssm.entity.OperLog;
import com.hy.ssm.service.LogininforService;
import com.hy.ssm.service.OperLogService;
import com.hy.ssm.utils.LogUtils;
import com.hy.ssm.utils.ServletUtils;
import com.hy.ssm.utils.ip.AddressUtils;
import com.hy.ssm.utils.ip.IpUtils;
import com.hy.ssm.utils.spring.SpringUtils;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

/**
 * 异步工厂
 */
public class AsyncFactory {

    private static final Logger sys_user_logger = LoggerFactory.getLogger("sys-user");

    public static TimerTask recordLogininfor(final String username, final String status, final String message, final Object... args) {
       final UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
       final String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
       return new TimerTask() {
           @Override
           public void run() {
               String address = AddressUtils.getRealAddressByIP(ip);
               StringBuilder s = new StringBuilder();
               s.append(LogUtils.getBlock(ip));
               s.append(address);
               s.append(LogUtils.getBlock(username));
               s.append(LogUtils.getBlock(status));
               s.append(LogUtils.getBlock(message));
               // 打印信息到日志
               sys_user_logger.info(s.toString(), args);
               // 获取客户端操作系统
               String os = userAgent.getOperatingSystem().getName();
               // 获取客户端浏览器
               String browser = userAgent.getBrowser().getName();
               // 封装对象
               Logininfor logininfor = new Logininfor();
               logininfor.setUserName(username);
               logininfor.setIpaddr(ip);
               logininfor.setLoginLocation(address);
               logininfor.setBrowser(browser);
               logininfor.setOs(os);
               logininfor.setMsg(message);
               if (Constants.LOGIN_SUCCESS.equals(status) || Constants.LOGOUT.equals(status)) {
                   logininfor.setStatus(Constants.SUCCESS);
               } else if (Constants.LOGIN_FAIL.equals(status)) {
                   logininfor.setStatus(Constants.FAIL);
               }
               // 插入数据
               SpringUtils.getBean(LogininforService.class).insertLogininfor(logininfor);
           }
       };
    }

    /**
     * 操作日志记录
     * @param operLog 操作日志消息
     * @return 任务 task
     */
    public static TimerTask recordOper(final OperLog operLog) {

        return new TimerTask() {
            @Override
            public void run() {
                // 远程查询操作地点
                operLog.setOperLocation(AddressUtils.getRealAddressByIP(operLog.getOperIp()));
                SpringUtils.getBean(OperLogService.class).insertOperLog(operLog);
            }
        };
    }

}
