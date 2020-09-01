package com.hy.ssm.service;

import com.hy.ssm.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@ContextConfiguration({ "classpath:spring/spring-mvc.xml", "classpath:spring/spring-service.xml",
        "classpath:spring/spring-dao.xml" })
public class AbstractContextControllerTests extends BaseTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

}
