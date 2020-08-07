package com.liu.cli.example.swagger.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liujiazhong
 * @date 2020/8/3 16:19
 */
@Data
@ApiModel("订单查询请求参数")
public class OrderQuery {

    @ApiModelProperty("订单id")
    private Long orderId;

}
