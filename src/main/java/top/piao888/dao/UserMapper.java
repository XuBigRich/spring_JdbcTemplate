package top.piao888.dao;

import top.piao888.domain.User;

import java.util.List;


public interface UserMapper {
    //添加用户
    void addUser(User user);

    //根据id删除用户
    void delete(Long id);

    //根据id 查找用户
    User findById(Long id);

    //跟新用户
    void update(User user);

    //查询所有
    List<User> all();
}
