package com.hy.ssm.aop;

import com.hy.ssm.BaseTest;
import com.hy.ssm.config.ThreadPoolConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ScheduledExecutorService;

public class ThreadPoolConfigTest extends BaseTest {

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ThreadPoolConfig.class);
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) context.getBean("scheduledExecutorService");
        System.out.println("ScheduledExecutorService:  " + scheduledExecutorService);

    }

}
