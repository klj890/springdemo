package com.example.demo;

/**
 * Author: wangtao
 * Date: 2021/3/25 13:04
 * Description:
 **/
//import io.prometheus.client.Counter;
//import io.prometheus.client.Gauge;
import com.example.demo.beans.RequestCounterJob;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.Random;

/**
 * Hello world!
 */
@RestController
@EnableAutoConfiguration
public class HelloWorldController {
//    static final Gauge inprogressRequests = Gauge.build()
//            .name("inprogress_requests")
//            .help("Inprogress requests.")
//            .register();

//    static final Counter requests = Counter.build()
//            .name("requests_total")
//            .help("Total requests.")
//            .register();
    @Resource
    private RequestCounterJob rcj;

    @RequestMapping("/")
    public String sayHello() throws InterruptedException {
        rcj.incrementCounter();
        Random r = new Random();
        Thread.sleep(r.nextInt(100));
        return "Really appreciate your star, that's the power of our life.";

    }
}
