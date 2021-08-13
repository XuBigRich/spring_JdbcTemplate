package top.piao888.dao.Impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import top.piao888.dao.OrderMapper;
import top.piao888.domain.Order;

import java.util.List;

/**
 * @author 许鸿志
 * @since 2021/8/13
 */
public class OrderMapperImpl extends JdbcDaoSupport implements OrderMapper {
    @Override
    public int addOrder(Order order) {
        String sql = "insert into `order` values(?,?,?,?)";
        return getJdbcTemplate().update(sql, null, order.getUid(), order.getOrderInfo(), order.getMoney());
    }

    @Override
    public int delete(Long id) {
        String sql = "delete from `order` where id =?";
        return getJdbcTemplate().update(sql, id);
    }

    @Override
    public Order findById(Long id) {
        String sql = "select id,uid,order_info,money from `order` where id=?";
        return getJdbcTemplate().queryForObject(sql, (rs, i) -> {
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setUid(rs.getInt("uid"));
            order.setOrderInfo(rs.getString("order_info"));
            order.setMoney(rs.getBigDecimal("money"));
            return order;
        }, id);
    }

    @Override
    public int update(Order order) {
        String sql = "update `order` set uid=?,order_info=?,money=? where id =?";
        return getJdbcTemplate().update(sql, order.getUid(), order.getOrderInfo(), order.getMoney(), order.getId());
    }

    @Override
    public List<Order> all() {
        String sql = "select id,uid,order_info,money from `order`";
        return getJdbcTemplate().query(sql, (rs, i) -> {
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setUid(rs.getInt("uid"));
            order.setOrderInfo(rs.getString("order_info"));
            order.setMoney(rs.getBigDecimal("money"));
            return order;
        });
    }

    @Override
    public List<Order> findOrderByUserId(Long userId) {
        String sql = "select id,uid,order_info,money from `order` where uid=?";
        return getJdbcTemplate().query(sql, (rs, i) -> {
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setUid(rs.getInt("uid"));
            order.setOrderInfo(rs.getString("order_info"));
            order.setMoney(rs.getBigDecimal("money"));
            return order;
        }, userId);
    }
}
