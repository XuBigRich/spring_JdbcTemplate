package top.piao888.dao;

import top.piao888.domain.Order;

import java.util.List;

/**
 * @author 许鸿志
 * @since 2021/8/13
 */
public interface OrderMapper {
    //添加订单信息
    int addOrder(Order order);

    //根据id删除订单
    int delete(Long id);

    //根据id 查找订单
    Order findById(Long id);

    //查询新订单
    int update(Order order);

    //查询所有
    List<Order> all();

    //查询某个用户的id
    List<Order> findOrderByUserId(Long userId);
}
