package top.piao888;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.piao888.dao.UserMapper;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public void addService() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//加载xml中名为userMapper的bean 标签
        UserMapper userMapper =(UserMapper)context.getBean("userMapper");
        List list= userMapper.all();
        System.out.println(list.size());
//        userMapper.findById(1L);
        context.close();
    }
    public static void main( String[] args ) {
        App app=new App();
        app.addService();
        System.out.println( "Hello World!" );
    }
}
