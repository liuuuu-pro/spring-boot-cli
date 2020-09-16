package com.liu.cli.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liujiazhong
 * @date 2020/9/11 11:22
 */
public class ValueAllocator {

    private static final Logger log = LoggerFactory.getLogger(ValueAllocator.class);
    private final double totalForAllocation;
    private int undistributedValue;
    private int allocationCounter = 0;
    private final int expectAllocationCount;
    private final String mark;

    public ValueAllocator(Integer totalForAllocation, int expectAllocationCount, String mark) {
        this.totalForAllocation = (double)ValueUtils.getValue(totalForAllocation);
        this.undistributedValue = ValueUtils.getValue(totalForAllocation);
        this.expectAllocationCount = expectAllocationCount;
        this.mark = mark;
    }

    public synchronized int allocate(double rate) {
        int expectAmount = (int)(rate * this.totalForAllocation);
        if (log.isTraceEnabled()) {
            log.trace("值分摊器[{}]: 数值分配中, 需求比例={}, 总计可分配值={}, 本次应分配值={}", this.mark, rate, this.totalForAllocation, expectAmount);
        }

        ++this.allocationCounter;
        if (this.allocationCounter > this.expectAllocationCount) {
            log.warn("值分摊器[{}]: 数值分配错误, 当前分配计数器大于了总共期望分配的次数{},请检查代码", this.mark, this.expectAllocationCount);
            return 0;
        } else if (this.allocationCounter == this.expectAllocationCount) {
            return this.undistributedValue;
        } else if (this.undistributedValue - expectAmount < 0) {
            int temp = this.undistributedValue;
            this.undistributedValue = 0;
            log.warn("值分摊器[{}]: 数值早于预期的分配完毕,请检查数据是否正确", this.mark);
            return temp;
        } else {
            this.undistributedValue -= expectAmount;
            return expectAmount;
        }
    }

    public double getTotalForAllocation() {
        return this.totalForAllocation;
    }

    public int getUndistributedValue() {
        return this.undistributedValue;
    }

    public int getAllocationCounter() {
        return this.allocationCounter;
    }

    public int getExpectAllocationCount() {
        return this.expectAllocationCount;
    }

}

