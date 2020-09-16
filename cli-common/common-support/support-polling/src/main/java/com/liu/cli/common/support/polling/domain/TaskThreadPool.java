package com.liu.cli.common.support.polling.domain;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池工具类
 * @author lihongmin
 * @date 2019/10/28 12:46
 * @since 2.1.7
 */
@Slf4j
public class TaskThreadPool {

    /**
     *  线程池工具map
     */
    public static final Map<ThreadPoolEnum, ThreadPoolExecutor> THREAD_POOL_EXECUTOR_MAP = new HashMap<>(16);

    @Getter
    public enum ThreadPoolEnum {

        /**
         * 线程池集合枚举
         */
        DELAYED_TASK("delayedTask", "延时任务相关线程池", 4, 8, 60, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(50), new ThreadPoolExecutor.CallerRunsPolicy());

        ThreadPoolEnum(String taskName, String detail, int corePoolNum, int maxPoolNum, int deleteThreadNum, TimeUnit deleteTreadUnit, LinkedBlockingDeque<Runnable> blockingDeque, RejectedExecutionHandler rejectedExecutionHandler) {
            this.taskName = taskName;
            this.detail = detail;
            this.corePoolNum = corePoolNum;
            this.maxPoolNum = maxPoolNum;
            this.deleteThreadNum = deleteThreadNum;
            this.deleteTreadUnit = deleteTreadUnit;
            this.blockingDeque = blockingDeque;
            this.rejectedExecutionHandler = rejectedExecutionHandler;
        }

        public String taskName;

        private String detail;

        private int corePoolNum;

        private int maxPoolNum;

        private int deleteThreadNum;

        private TimeUnit deleteTreadUnit;

        private LinkedBlockingDeque<Runnable> blockingDeque;

        private RejectedExecutionHandler rejectedExecutionHandler;

        static Map<String, ThreadPoolEnum> map = new HashMap<>(16);

        static {
            for (ThreadPoolEnum threadPoolName : ThreadPoolEnum.values()) {
                map.put(threadPoolName.getTaskName(), threadPoolName);
            }
        }

    }

    /**
     *  线程工厂
     */
    static class DefaultThreadFactory implements ThreadFactory {

        /**
         *  定义线程组
         */
        static ThreadGroup threadGroup;

        /**
         *  定义每个线程池中每个线程的名称后缀数字
         */
        static final AtomicInteger THREAD_NUMBER = new AtomicInteger(1);

        /**
         *  定义每个线程词的名称前缀
         */
        static String namePrefix;

        public DefaultThreadFactory(String name) {
            final SecurityManager securityManager = System.getSecurityManager();
            threadGroup = (securityManager != null) ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = name + "-thread-";
        }

        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(threadGroup, runnable, namePrefix + THREAD_NUMBER.getAndIncrement(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if(thread.getPriority() != Thread.NORM_PRIORITY){
                thread.setPriority(Thread.NORM_PRIORITY);
            }
            return thread;
        }
    }

    static {
        for (ThreadPoolEnum threadPoolEnum : ThreadPoolEnum.values()) {
            THREAD_POOL_EXECUTOR_MAP.put(threadPoolEnum, getThreadPoolExecutor(threadPoolEnum));
        }
    }

    /**
     *  根据枚举获取线程池
     */
    private static ThreadPoolExecutor getThreadPoolExecutor(ThreadPoolEnum threadPoolEnum) {
        return new ThreadPoolExecutor(threadPoolEnum.corePoolNum,
                threadPoolEnum.maxPoolNum,
                threadPoolEnum.deleteThreadNum,
                threadPoolEnum.deleteTreadUnit,
                threadPoolEnum.blockingDeque,
                new DefaultThreadFactory(threadPoolEnum.taskName),
                threadPoolEnum.rejectedExecutionHandler);
    }

}