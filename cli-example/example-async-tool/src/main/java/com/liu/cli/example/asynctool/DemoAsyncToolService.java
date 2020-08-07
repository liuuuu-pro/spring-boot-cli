package com.liu.cli.example.asynctool;

import com.liu.cli.common.support.asynctool.executor.Async;
import com.liu.cli.common.support.asynctool.worker.WorkResult;
import com.liu.cli.common.support.asynctool.wrapper.WorkerWrapper;

/**
 * @author liujiazhong
 * @date 2020/7/29 14:33
 */
public class DemoAsyncToolService {

    public static void main(String[] args) throws Exception {
        OrderQueryCancelWorker cancelWorker = new OrderQueryCancelWorker();
        OrderQueryFinishWorker finishWorker = new OrderQueryFinishWorker();

        WorkerWrapper<Long, String> cancelWrapper = new WorkerWrapper.Builder<Long, String>()
                .id("Cancel-001")
                .callback(cancelWorker)
                .worker(cancelWorker)
                .param(1001L)
                .build();

        WorkerWrapper<Long, String> finishWrapper = new WorkerWrapper.Builder<Long, String>()
                .id("Finish-001")
                .callback(finishWorker)
                .worker(finishWorker)
                .param(1002L)
                .build();

        Async.beginWork(1500, cancelWrapper, finishWrapper);

        WorkResult<String> cancelResult = cancelWrapper.getWorkResult();
        WorkResult<String> finishResult = finishWrapper.getWorkResult();

        System.out.println(cancelResult);
        System.out.println(finishResult);

        Async.shutDown();
    }

}
