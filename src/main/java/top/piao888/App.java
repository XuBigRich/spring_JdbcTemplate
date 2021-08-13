package top.piao888;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.piao888.dao.UserMapper;
import top.piao888.enums.BeanEnum;
import top.piao888.factory.BeanFactory;
import top.piao888.service.OrderService;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    private OrderService orderService = BeanFactory.getBean(BeanEnum.ORDERSERVICE);

    //查询所有用户 (历史代码 不舍得删)
    public void addService() {
        //加载xml中名为userMapper的bean 标签
        UserMapper userMapper = BeanFactory.getBean(BeanEnum.USERMAPPER);
        List list = userMapper.all();
        System.out.println(list.size());
//        userMapper.findById(1L);
    }

    public static void main(String[] args) throws ClassNotFoundException {
//        Class c=BeanFactory.class;
        App app = new App();
        app.addService();
        System.out.println("Hello World!");
        //业务需求是，用户第一次下单时，金额免费，以后下单金额1元
        app.orderService.simulation();
    }

}
