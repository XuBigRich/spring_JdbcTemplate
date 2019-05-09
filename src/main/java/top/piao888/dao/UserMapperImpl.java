package top.piao888.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import top.piao888.domain.UserAuth;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserMapperImpl extends JdbcDaoSupport implements UserMapper {
    @Override
    public void addUser(UserAuth user) {
        String sql="insert into dept values(?,?)";
        getJdbcTemplate().update(sql,user.getDid(),user.getDname());
    }

    @Override
    public void delete(Long id) {
        String sql="delete from dept where did=?";
        getJdbcTemplate().update(sql,id);
    }

    @Override
    public UserAuth findById(Long id) {
        String sql="select * from dept where id=?";
       UserAuth userAuth= getJdbcTemplate().queryForObject(sql, new RowMapper<UserAuth>() {
            @Override
            public UserAuth mapRow(ResultSet rs, int i) throws SQLException {
                UserAuth user =new UserAuth();
                user.setDid(rs.getLong("did"));
                user.setDname(rs.getString("dname"));
                return user;
            }
        },id);
        return userAuth;
    }

    @Override
    public void update(UserAuth user) {
        String sql="update dept set dname=? where did=?";
        getJdbcTemplate().update(sql,user.getDname(),user.getDid());
    }

    @Override
    public List<UserAuth> all() {
        String sql="select * from dept";
        return getJdbcTemplate().query(sql, new RowMapper<UserAuth>() {
            @Override
            public UserAuth mapRow(ResultSet rs, int i) throws SQLException {
                UserAuth user =new UserAuth();
                user.setDid(rs.getLong("did"));
                user.setDname(rs.getString("dname"));
                return user;
            }
        });
    }


}
