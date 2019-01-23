import com.wenyb.config.BeanLifeCycleConfig;
import com.wenyb.config.CatConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

}
