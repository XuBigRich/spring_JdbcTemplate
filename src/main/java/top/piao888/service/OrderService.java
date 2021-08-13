package top.piao888.service;

import top.piao888.domain.Order;
import top.piao888.domain.User;

/**
 * @author 许鸿志
 * @since 2021/8/13
 */
public interface OrderService {
    /**
     * 下单
     *
     * @param order
     * @return
     */
    int placeOrder(Order order);

    /**
     * 判断是否是第一次下单
     *
     * @param user
     * @return
     */
    boolean firstPlaceOrder(User user);

    /**
     * 模拟一个用户同一时间，触发多线程，并行状态下下单
     */
    void simulation();
}
