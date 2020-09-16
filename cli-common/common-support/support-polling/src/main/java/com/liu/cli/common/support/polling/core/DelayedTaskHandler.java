package com.liu.cli.common.support.polling.core;

import com.liu.cli.common.support.polling.domain.DelayedTaskEvent;

/**
 * @author liujiazhong
 * @date 2020/1/10 9:57
 */
public interface DelayedTaskHandler {

    /**
     * 处理延时事件
     * @param taskEvent 延时事件
     */
    void handleTask(DelayedTaskEvent taskEvent);

}
