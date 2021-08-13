package top.piao888.factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.piao888.enums.BeanEnum;

/**
 * mapper工厂类
 *
 * @author 许鸿志
 * @since 2021/8/13
 */
public class BeanFactory {
    public static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    /**
     * 关闭上下文
     */
    public static void closeContext() {
        context.close();
    }

    public static <T> T getBean(BeanEnum beanEnum) {
        //加载xml中名为userMapper的bean 标签
        T mapper = (T) context.getBean(beanEnum.getCode());
        return mapper;
    }
}
