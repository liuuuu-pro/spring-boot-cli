package com.liu.cli.common.support.polling.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Objects;

/**
 * 延时规则
 * @author liujiazhong
 * @date 2020/1/10 10:27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DelayedRule {

    private Map<Integer, Integer> delayedRules;

    public Integer getMaxPollingTimes() {
        return Objects.isNull(delayedRules) ? 0 : delayedRules.size();
    }

}
