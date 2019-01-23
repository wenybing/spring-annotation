import com.wenyb.bean.Poet;
import com.wenyb.config.MainConfig;
import com.wenyb.config.PoetConfig;
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

    /**
     * 测试xml配置版自动扫描的包
     */
    @Test
    public void testComponentScanForxml() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    /**
     * 测试注解版指定要扫描的包
     */
    @Test
    public void testComponentScanForAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    /**
     * 注解:@Scope单元测试
     */
    @Test
    public void testScopeAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PoetConfig.class);
        System.out.println("IOC容器创建完成........");
        Poet bean1 = applicationContext.getBean(Poet.class);
        Poet bean2 = applicationContext.getBean(Poet.class);
        System.out.println(bean1 == bean2);
    }

    /**
     * 测试@Lazy注解
     */
    @Test
    public void testLazyAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PoetConfig.class);
        System.out.println("IOC容器创建完成........");
        Poet bean1 = applicationContext.getBean(Poet.class);
        Poet bean2 = applicationContext.getBean(Poet.class);
        System.out.println(bean1 == bean2);
    }
}
