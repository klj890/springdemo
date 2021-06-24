package com.example.demo;

import com.example.demo.beans.PrometheusCustomMonitor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

/**
 * Author: wangtao
 * Date: 2021/3/26 11:57
 * Description:
 **/
@RestController
public class OrderController {
    @Resource
    private PrometheusCustomMonitor monitor;

    @RequestMapping("/order")
    @ResponseBody
    public String order(@RequestParam(defaultValue = "0", name = "flag") String flag) throws Exception{
        // 统计下单次数
        monitor.getOrderCount().increment();
        if ("1".equals(flag)) {
            throw new Exception("出错啦");
        }
        Random random = new Random();
        int amount = random.nextInt(100);
        // 统计金额
        monitor.getAmountSum().record(amount);
        return "下单成功, 金额: " + amount;
    }
}
