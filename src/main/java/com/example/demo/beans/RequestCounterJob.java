package com.example.demo.beans;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import org.springframework.stereotype.Component;

/**
 * Author: wangtao
 * Date: 2021/3/26 14:14
 * Description:
 **/
@Component
public class RequestCounterJob {
    private final Counter requestCounter;

    public RequestCounterJob(CollectorRegistry registry){
        requestCounter = Counter.build().name("my_request_count")
                .help("Request count")
                .register();
    }

    public void incrementCounter(){
        requestCounter.inc();
    }

}
