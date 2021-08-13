package top.piao888.enums;

import lombok.Getter;

/**
 * @author 许鸿志
 * @since 2021/8/13
 */
@Getter
public enum BeanEnum {
    USERMAPPER("userMapper", "用户表操作"),
    USERSERVICE("userService", "用户服务"),
    ORDERMAPPER("orderMapper", "订单表操作"),

    ORDERSERVICE("orderService", "订单服务");

    private String code;
    private String name;

    BeanEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
