package com.liu.cli.example.demo;

/**
 * @author liujiazhong
 * @date 2020/8/26 17:35
 */
public interface OrderService {

    /**
     * create order
     * @param orderId orderId
     * @return orderCode
     */
    String createOrder(Long orderId);

}
