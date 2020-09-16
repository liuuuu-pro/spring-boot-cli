package com.liu.cli.common.support.polling.core;

import com.liu.cli.common.support.polling.domain.DelayedTask;
import com.liu.cli.common.support.polling.domain.DelayedTaskEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author liujiazhong
 * @date 2020/1/10 10:08
 */
@Slf4j
@Component
public class BaseDelayedTaskHandlerImpl implements DelayedTaskHandler {

    protected void putOrderDelayedTaskToDelayQueue(DelayedTaskEvent event, DelayedTaskHandler handler) {
        if (Objects.nonNull(event)) {
            Integer executeTimes = event.getExecuteTimes();
            Integer maxExecuteTimes = event.getMaxExecuteTimes();
            if (Objects.equals(executeTimes, 0)) {
                event.setLastExecuteTime(System.currentTimeMillis());
            } else {
                event.setLastExecuteTime(event.getEditTime());
            }
            if (executeTimes < maxExecuteTimes) {
                DelayedTaskCore.tasks.put(new DelayedTask(event, handler));
                log.info("put delayed task to delay queue...eventId:{}", event.getEventId());
            }
        }
    }

    @Override
    public final void handleTask(DelayedTaskEvent taskEvent) {
        doHandle(taskEvent);
    }

    protected void doHandle(DelayedTaskEvent event) {
        Long eventId = event.getEventId();
        Integer executeTimes = event.getExecuteTimes();
        Integer maxExecuteTimes = event.getMaxExecuteTimes();
        event.setEditTime(System.currentTimeMillis());
        event.setExecuteTimes(executeTimes + 1);
        log.info("处理延时事件...事件ID:{}, 当前执行次数:{}, 最大执行次数:{}, 当前时间:{}", eventId, executeTimes + 1, maxExecuteTimes, System.currentTimeMillis());
    }

}
