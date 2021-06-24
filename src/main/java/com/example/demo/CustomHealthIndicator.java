package com.example.demo;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * Author: wangtao
 * Date: 2021/3/25 13:19
 * Description:
 **/
@Component
public class CustomHealthIndicator  extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        builder.up()
                .withDetail("app", "项目很健康哦！")
                .withDetail("error", "项目有点问题哦！");
    }
}
