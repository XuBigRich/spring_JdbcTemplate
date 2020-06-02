package top.piao888.service.impl;

import top.piao888.domain.UserAuth;
import top.piao888.dao.UserMapper;
import top.piao888.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper;
    @Override
    public List<UserAuth>  all() {
        return userMapper.all();
    }
    public void myinit(){
        System.out.println("初始化。。。。");
    }
    public void mydestcry(){
        System.out.println("销毁关闭连接");
    }
}
