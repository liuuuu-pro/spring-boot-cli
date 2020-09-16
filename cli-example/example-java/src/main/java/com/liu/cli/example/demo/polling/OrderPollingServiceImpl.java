package com.liu.cli.example.demo.polling;

import com.liu.cli.common.support.polling.core.BaseDelayedTaskHandlerImpl;
import com.liu.cli.common.support.polling.domain.DelayedTaskEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author liujiazhong
 * @date 2020/1/10 10:12
 */
@Slf4j
@Component
public class OrderPollingServiceImpl extends BaseDelayedTaskHandlerImpl implements OrderPollingService {

    @Override
    public void createOrder() {
        log.info("创建订单...");
    }

    @Override
    protected void doHandle(DelayedTaskEvent event) {
        super.doHandle(event);
        Long eventId = event.getEventId();

        try {
            if (isSuccess()) {
                log.info("查询订单状态成功，延时任务结束...eventId:{}", eventId);

            } else {
                log.warn("查询订单状态失败，延时任务继续...eventId:{}", eventId);
                taskContinue(event);
            }
        } catch (Exception e) {
            log.error("查询订单状态发生异常，延时任务继续...eventId:{}", eventId, e);
            taskContinue(event);
        }

    }

    private boolean isSuccess() {
        return Boolean.FALSE;
    }

    private void taskContinue(DelayedTaskEvent event) {
        if (event.getExecuteTimes() < event.getMaxExecuteTimes()) {
            putOrderDelayedTaskToDelayQueue(event, this);
        } else {
            log.warn("延时任务已达到最大延时次数，任务终止...eventId:{}", event.getEventId());
        }
    }

}
