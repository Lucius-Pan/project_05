package indi.Lucius.until;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: SpringFactory
 * @Description: spring工厂
 * @Author: Lucius Pan
 * @Date: 2023/5/26 11:37
 */
public class SpringFactory {
    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        if (applicationContext == null) {
            applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        }
        return applicationContext;
    }

    private SpringFactory() {
    }


}
