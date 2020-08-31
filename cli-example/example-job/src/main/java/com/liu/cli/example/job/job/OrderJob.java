package com.liu.cli.example.job.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * @author liujiazhong
 * @date 2020/8/31 13:54
 */
@Slf4j
@Component
public class OrderJob {

    @XxlJob("orderJobHandler")
    public ReturnT<String> orderJobHandler(String param) {
        XxlJobLogger.log("into order job handler:{}", param);

        for (int i = 0; i < 5; i++) {
            XxlJobLogger.log("beat at:" + i);
        }

        return ReturnT.SUCCESS;
    }

}
