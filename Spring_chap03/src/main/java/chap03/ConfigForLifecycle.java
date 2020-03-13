package chap03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigForLifecycle
{
    @Bean
    public MyBean mybean()
    {
        MyBean mybean = new MyBean();
        mybean.setProperty1("prop");
        return mybean;
    }
    
    @Bean
    public ConnPool1 connpool1()
    {
        return new ConnPool1();
    }
    
    @Bean
    public ConnPool2 connpool2()
    {
        return new ConnPool2();
    }
    @Bean(initMethod="init", destroyMethod="destroy")
    public ConnPool3 connpool3()
    {
        return new ConnPool3();
    }
    @Bean
    public MyExtension extension()
    {
        return new MyExtension();
    }
}
