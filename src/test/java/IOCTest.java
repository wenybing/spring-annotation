import com.wenyb.bean.Poet;
import com.wenyb.config.*;
import com.wenyb.service.PoetService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * @Author wenyabing
 * @Date 2019/1/23 17:27
 */
public class IOCTest {
    /**
     * 测试bean的生命周期通过@Bean(initMethod = "init", destroyMethod = "destory")
     */
    @Test
    public void testBeanLifeCycle() {
        //创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanLifeCycleConfig.class);
        System.out.println("IOC容器创建完成........");
        //关闭IOC容器
        applicationContext.close();
    }

    /**
     * 测试bean的生命周期通过实现接口InitializingBean, DisposableBean
     */
    @Test
    public void testBeanLifeCycleByInterface() {
        //创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(CatConfig.class);
        System.out.println("IOC容器创建完成........");
        //关闭IOC容器
        applicationContext.close();
    }

    /**
     * 测试@Value注解
     */
    @Test
    public void testValueAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PoetMainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        Poet poet = (Poet) applicationContext.getBean("poet");
        System.out.println(poet);
    }

    /**
     * 测试xml方式设置属性值
     */
    @Test
    public void testXmlSetProperties() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:bean.xml");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        Poet poet = (Poet) applicationContext.getBean("poet");
        System.out.println(poet);
    }

    /**
     * 测试@PropertySource、@Value("${外部属性文件的key}")注解
     */
    @Test
    public void testPropertySource() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PoetMainConfig.class);
        Poet bean = applicationContext.getBean(Poet.class);
        System.out.println(bean);
    }

    /**
     * 测试@Autowired注解
     */
    @Test
    public void testAutowiredAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredConfig.class);
//        PoetDao bean = applicationContext.getBean(PoetDao.class);
//        System.out.println(bean);
        Object poetDao01 = applicationContext.getBean(PoetService.class);
        System.out.println(poetDao01);
    }

    /**
     * 测试@Profile注解
     */
    @Test
    public void testProfileAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DataSourceConfig.class);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }
        /**使用@Profile注解：
         *  激活环境的方式有两种
         *  1.命令行方式：修改vm参数：-Dspring.profiles.active=dev
         *  2.代码的方式
         */

    }

    /**
     * 测试通过代码方式激活环境
     */
    @Test
    public void testActiveProfile() {
        //1.创建applicationContext
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //2.设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("pro");
        //3.注册配置类
        applicationContext.register(DataSourceConfig.class);
        //4.启动刷新容器
        applicationContext.refresh();
        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
    }

}
