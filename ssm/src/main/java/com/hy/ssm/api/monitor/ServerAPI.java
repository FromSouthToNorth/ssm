package com.hy.ssm.api.monitor;

import com.hy.ssm.core.controller.BaseController;
import com.hy.ssm.domain.Server;
import com.hy.ssm.dto.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务监控
 */
@RestController
@RequestMapping("/monitor/server")
public class ServerAPI extends BaseController {

    @GetMapping()
    public Result getInfo() throws Exception {
        Server server = new Server();
        server.copyTo();
        return Result.success(server);
    }

}
