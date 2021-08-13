package top.piao888.dao.Impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import top.piao888.dao.UserMapper;
import top.piao888.domain.User;

import java.util.List;

public class UserMapperImpl extends JdbcDaoSupport implements UserMapper {
    @Override
    public void addUser(User user) {
        String sql = "insert into user values(?,?)";
        getJdbcTemplate().update(sql, user.getId(), user.getName());
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from user where id=?";
        getJdbcTemplate().update(sql, id);
    }

    @Override
    public User findById(Long id) {
        String sql = "select * from user where id=?";
        User userAuth = getJdbcTemplate().queryForObject(sql, (rs, i) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            return user;
        }, id);
        return userAuth;
    }

    @Override
    public void update(User user) {
        String sql = "update user set name=? where id=?";
        getJdbcTemplate().update(sql, user.getName(), user.getId());
    }

    @Override
    public List<User> all() {
        String sql = "select * from user";
        return getJdbcTemplate().query(sql, (rs, i) -> {
            User user = new User();
            user.setId(rs.getLong("did"));
            user.setName(rs.getString("dname"));
            return user;
        });
    }


}
