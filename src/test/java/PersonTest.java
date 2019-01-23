import com.wenyb.bean.Person;
import com.wenyb.bean.PigFactoryBean;
import com.wenyb.config.PersonConfig;
import com.wenyb.config.PigFactoryBeanConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @Author wenyabing
 * @Date 2019/1/23 9:15
 */
public class PersonTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersonConfig.class);
        String[] names = applicationContext.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("--------------------------------");
        Object bill = applicationContext.getBean("Bill");
        Object Linus = applicationContext.getBean("Linus");
        System.out.println(bill);
        System.out.println(Linus);
        //获取操作系统信息
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println("获取操作系统信息:   " + property);
    }

    /**
     * 测试@Condition注解
     */
    @Test
    public void testConditionAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersonConfig.class);
        String[] names = applicationContext.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println(name);
        }
        //获取运行环境
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println("操作系统：" + property);
        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }

    /**
     * 测试@Import注解
     */
    @Test
    public void testImportAnnotation() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    /**
     * 测试@Import注解
     * ImportSelector：返回需要导入的组件的全类名数组
     */
    @Test
    public void testImportSelector() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    /**
     * 测试@Import注解
     * ImportBeanDefinitionRegistrar：手动注册bean到容器中
     */
    @Test
    public void testImportBeanDefinitionRegistrar() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    /**
     * 测试FactoryBean
     */
    @Test
    public void testFactoryBean() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PigFactoryBeanConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("------------");
        PigFactoryBean bean = context.getBean(PigFactoryBean.class);
        System.out.println("bean: " + bean);
        System.out.println("获取bean：" + bean.getObject());
        System.out.println("bean的类型：" + bean.getObjectType());
        System.out.println("是否单例" + bean.isSingleton());
        //获取工厂bean本身，需要在id前面加一个&
        Object factoryBean = context.getBean("&pigFactoryBean");
        System.out.println("获取工厂bean本身：" + factoryBean);
        System.out.println("bean的类型：" + factoryBean.getClass());
    }
}
