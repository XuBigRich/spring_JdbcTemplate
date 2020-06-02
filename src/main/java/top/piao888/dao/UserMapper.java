package top.piao888.dao;

import top.piao888.domain.UserAuth;

import java.util.List;


public interface UserMapper {
    public void addUser(UserAuth user);
    public void delete(Long id);
    public UserAuth findById(Long id);
    public void update(UserAuth user);
    public List<UserAuth> all();
}
