package org.apache.flink.cep;

import org.apache.flink.api.common.functions.Function;
import org.apache.flink.cep.pattern.Pattern;

import java.io.Serializable;

/** */
public interface PatternListener<T> extends Function, Serializable {

    /**
     * @Description: 留给用户判断当接受到元素的时候，是否需要更新CEP逻辑
     *
     * @return: java.lang.Boolean
     * @auther: lirui
     * @date: 2020/08/26 9:27
     */
    Boolean needChange(T element);

    /**
     * @Description: 当needChange为true时会被调用，留给用户实现返回一个新逻辑生成的pattern对象
     *
     * @return: org.apache.flink.cep.pattern.Pattern
     * @auther: lirui
     * @date: 2020/08/26 9:27
     */
    Pattern<T, ?> getPattern(T flagElement);
}
