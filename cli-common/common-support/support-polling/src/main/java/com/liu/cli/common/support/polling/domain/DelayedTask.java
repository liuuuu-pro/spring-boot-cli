package com.liu.cli.common.support.polling.domain;

import com.liu.cli.common.support.polling.core.DelayedTaskHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 延时任务
 * @author liujiazhong
 * @date 2020/1/10 9:34
 */
@Slf4j
public class DelayedTask implements Runnable, Delayed {

    private Long executeTime;
    private DelayedTaskEvent taskEvent;
    private DelayedTaskHandler handler;

    public DelayedTask(DelayedTaskEvent taskEvent, DelayedTaskHandler handler) {
        this.executeTime = getExecuteTime(taskEvent);
        this.taskEvent = taskEvent;
        this.handler = handler;
    }

    private long getExecuteTime(DelayedTaskEvent taskEvent) {
        Integer executeTimes = taskEvent.getExecuteTimes();
        Integer nextExecuteTimeInterval = taskEvent.getPollingRules().get(executeTimes + 1);
        return (Objects.nonNull(nextExecuteTimeInterval) ? nextExecuteTimeInterval : 0) + taskEvent.getLastExecuteTime();
    }

    public Long getTaskId() {
        return taskEvent.getEventId();
    }

    @Override
    public int compareTo(Delayed o) {
        DelayedTask task = (DelayedTask) o;
        return Long.compare(executeTime, task.executeTime);
    }

    @Override
    public void run() {
        handler.handleTask(taskEvent);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(executeTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }
}
