package com.liu.cli.example.swagger.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liujiazhong
 * @date 2020/8/3 16:20
 */
@Data
@ApiModel("订单信息")
public class OrderVO {

    @ApiModelProperty("订单号")
    private String orderCode;

    @ApiModelProperty("买家姓名")
    private String buyerName;

}
