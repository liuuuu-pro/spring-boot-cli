package com.liu.cli.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author liujiazhong
 * @date 2020/8/26 17:36
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public String createOrder(Long orderId) {
        return String.format("TEST%s", orderId);
    }

}
