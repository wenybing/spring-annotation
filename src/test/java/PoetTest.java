import com.wenyb.bean.Poet;
import com.wenyb.config.MainConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author wenyabing
 * @Date 2019/1/22 18:06
 */
public class PoetTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Poet bean = applicationContext.getBean(Poet.class);
        System.out.println(bean);
    }

    @Test
    public void annotationBean() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Poet bean = applicationContext.getBean(Poet.class);
        System.out.println(bean);

        /**
         * 获取beanName 为配置类的方法名 可以通过@Bean(value="poet")指定
         */
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Poet.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
    }
}