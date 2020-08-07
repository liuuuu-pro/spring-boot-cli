package com.liu.cli.example.swagger.controller;

import com.liu.cli.example.swagger.domain.OrderQuery;
import com.liu.cli.example.swagger.domain.OrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujiazhong
 * @date 2020/8/3 16:15
 */
@Api("测试swagger模块")
@Slf4j
@RequestMapping("demo")
@RestController
public class DemoController {

    @ApiOperation("测试接口")
    @PostMapping("list_order")
    public List<OrderVO> listOrder(@RequestBody OrderQuery query) {
        log.info("查询订单列表:{}", query.getOrderId());
        return new ArrayList<>(0);
    }

}
