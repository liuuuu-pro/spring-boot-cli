package com.liu.cli.example.asynctool;

import com.liu.cli.common.support.asynctool.callback.ICallback;
import com.liu.cli.common.support.asynctool.callback.IWorker;
import com.liu.cli.common.support.asynctool.worker.WorkResult;
import com.liu.cli.common.support.asynctool.wrapper.WorkerWrapper;

import java.util.Map;

/**
 * @author liujiazhong
 * @date 2020/7/29 14:36
 */
public class OrderQueryFinishWorker implements IWorker<Long, String>, ICallback<Long, String> {

    @Override
    public void begin() {
        System.out.println("Worker开始查询finish状态的订单...");
    }

    @Override
    public void result(boolean success, Long orderId, WorkResult<String> result) {
        System.out.println(String.format("finish状态的订单查询完毕回调结果:success:%s, orderId:%s, result:%s",
                success, orderId, result.getResult()));
    }

    @Override
    public String action(Long orderId, Map<String, WorkerWrapper> map) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("finish状态的订单查询完毕.OrderId:%s", orderId));
        return "finish";
    }

    @Override
    public String defaultValue() {
        return "finish-default";
    }

}
