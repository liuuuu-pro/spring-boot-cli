package com.liu.cli.common.support.polling.core;

import com.liu.cli.common.support.polling.domain.DelayedTask;
import com.liu.cli.common.support.polling.domain.TaskThreadPool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ThreadPoolExecutor;

import static com.liu.cli.common.support.polling.domain.TaskThreadPool.THREAD_POOL_EXECUTOR_MAP;

/**
 * 开启处理延时任务
 * @author liujiazhong
 * @date 2020/1/10 10:33
 */
@Slf4j
@Component
public class DelayedTaskCore {

    public static DelayQueue<DelayedTask> tasks = new DelayQueue<>();
    private volatile boolean running = true;

    @PostConstruct
    public void init() {
        log.info("开始初始化延时任务处理...");
        startTask();
    }

    private void startTask() {
        log.info("delayed task thread start...");
        TaskThreadPool.ThreadPoolEnum delayedTaskThreadEnum = TaskThreadPool.ThreadPoolEnum.DELAYED_TASK;
        ThreadPoolExecutor executor = THREAD_POOL_EXECUTOR_MAP.get(delayedTaskThreadEnum);
        executor.execute(() -> {
            while (running) {
                try {
                    Thread.sleep(1000);
                    log.info("DELAYED_TASK THREAD_POOL_EXECUTOR INFO:ACTIVE:{}, MAX:{}, TASK:{}", executor.getActiveCount(), executor.getMaximumPoolSize(), tasks.size());
                    final DelayedTask task = tasks.take();
                    executor.execute(() -> {
                        try {
                            tasks.remove(task);
                            task.run();
                        } catch (Exception e) {
                            log.error("executor delayed task exception...taskId:{}", task.getTaskId(), e);
                        }
                    });
                } catch (Exception e) {
                    log.error("take delayed task exception...", e);
                }
            }
        });
    }

}
