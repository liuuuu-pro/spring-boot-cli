package com.liu.cli.common.support.polling.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 延时任务事件
 * @author liujiazhong
 * @date 2020/1/10 9:44
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DelayedTaskEvent {

    private Long eventId;

    private Long editTime;

    private Long lastExecuteTime;

    private Integer executeTimes;

    private Integer maxExecuteTimes;

    /**
     * 第n次的时间间隔
     */
    private Map<Integer, Integer> pollingRules;

    private Object businessInfo;

    public DelayedTaskEvent(DelayedRule rule) {
        this.executeTimes = 0;
        this.maxExecuteTimes = rule.getMaxPollingTimes();
        this.pollingRules = rule.getDelayedRules();
    }

}
