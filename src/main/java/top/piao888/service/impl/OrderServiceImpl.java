package top.piao888.service.impl;

import lombok.Data;
import lombok.NoArgsConstructor;
import top.piao888.dao.Impl.OrderMapperImpl;
import top.piao888.dao.OrderMapper;
import top.piao888.domain.Order;
import top.piao888.domain.User;
import top.piao888.enums.BeanEnum;
import top.piao888.factory.BeanFactory;
import top.piao888.pool.ThreadPool;
import top.piao888.service.OrderService;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 订单服务
 *
 * @author 许鸿志
 * @since 2021/8/13
 */
@NoArgsConstructor
@Data
public class OrderServiceImpl implements OrderService {
    private OrderMapper orderMapper;

    private ThreadPoolExecutor threadPool = ThreadPool.threadPoolExecutor;

    @Override
    public int placeOrder(Order order) {
        return orderMapper.addOrder(order);
    }

    @Override
    public boolean firstPlaceOrder(User user) {
        List<Order> orderList = orderMapper.findOrderByUserId(user.getId());
        return orderList.size() > 0 ? false : true;
    }

    @Override
    public void simulation() {
        User user = new User();
        user.setId(1L);
        user.setName("许鸿志");
        //线程不安全的
//        Runnable runnable = unsafety(user);
        Runnable runnable = safety(user);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(runnable);
        }
    }

    //线程不安全
    public Runnable unsafety(User user) {
        Runnable runnable = () -> {
            //判断当前用户是否时第一次购买
            boolean flag = firstPlaceOrder(user);
            if (flag) {
                Order order = new Order();
                order.setOrderInfo("第一次购买");
                order.setUid(user.getId().intValue());
                order.setMoney(BigDecimal.ZERO);
                placeOrder(order);
            } else {
                Order order = new Order();
                order.setOrderInfo("非第一次购买");
                order.setUid(user.getId().intValue());
                order.setMoney(BigDecimal.valueOf(1));
                placeOrder(order);
            }
        };
        return runnable;
    }

    //安全
    public Runnable safety(User user) {
        Runnable runnable = () -> {
            //判断当前用户是否时第一次购买
            boolean flag;
            flag = firstPlaceOrder(user);
            //如果是第一次下单，那么进入if
            if (flag) {
                //进入if后给他上锁
                synchronized (OrderServiceImpl.class) {
                    //再次判断是否是第一次下单，如果是开始给他下单，不是则更改flag状态，多耗费一次 条件查询
                    flag = firstPlaceOrder(user);
                    if (flag) {
                        Order order = new Order();
                        order.setOrderInfo("第一次购买");
                        order.setUid(user.getId().intValue());
                        order.setMoney(BigDecimal.ZERO);
                        placeOrder(order);
                    }
                }
            }
            if (!flag) {
                Order order = new Order();
                order.setOrderInfo("非第一次购买");
                order.setUid(user.getId().intValue());
                order.setMoney(BigDecimal.valueOf(1));
                placeOrder(order);
            }
        };
        return runnable;
    }
}
