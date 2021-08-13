package top.piao888.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author 许鸿志
 * @since 2021/8/13
 */
@Data
@NoArgsConstructor
public class Order {
    private Integer id;
    private Integer uid;
    private String orderInfo;
    private BigDecimal money;
}
