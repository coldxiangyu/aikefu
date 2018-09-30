package com.aikefu.entity.enums;

/**
 * <pre>
 *     true or false enum
 * </pre>
 *
 * @author : coldxiangyu
 * @date : 2018/9/17
 */
public enum TrueFalseEnum {

    /**
     * 真
     */
    TRUE("true"),

    /**
     * 假
     */
    FALSE("false");

    private String desc;

    TrueFalseEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
