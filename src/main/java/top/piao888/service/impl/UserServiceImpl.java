package top.piao888.service.impl;

import lombok.Data;
import top.piao888.domain.User;
import top.piao888.dao.UserMapper;
import top.piao888.service.UserService;

import java.util.List;
@Data
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Override
    public List<User> all() {
        return userMapper.all();
    }

    /**
     * 当UserServiceImpl 注入到 UserService接口时 执行myinit方法
     */
    public void myinit() {
        System.out.println("初始化。。。。");
    }

    /**
     * 当UserServiceImpl 开始销毁时 执行mydestcry方法
     */
    public void mydestcry() {
        System.out.println("销毁关闭连接");
    }
}
