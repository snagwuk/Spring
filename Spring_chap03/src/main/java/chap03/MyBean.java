package chap03;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyBean implements BeanNameAware,ApplicationContextAware,InitializingBean,DisposableBean
{
    public void setProperty1(String property1)
    {
        System.out.println("MyBean.setProperty1() 실행");
    }

    @Override
    public void setBeanName(String arg0)
    {
        // TODO Auto-generated method stub
        System.out.println("MyBean.setBeanName() 실행");
    }
  

    @Override
    public void setApplicationContext(ApplicationContext arg0)
            throws BeansException
    {
        // TODO Auto-generated method stub
        System.out.println("MyBean.setApplicationContext() 실행");
    }
    
    
    @PostConstruct
    public void postConstruct()
    {
        // TODO Auto-generated method stub
        System.out.println("  @PostConstruct() 실행");
    }      
    
    
    @Override
    public void afterPropertiesSet() throws Exception
    {
        // TODO Auto-generated method stub
        System.out.println("MyBean.afterPropertiesSet() 실행");
    }

    public void customInit()
    {
        // TODO Auto-generated method stub
        System.out.println("MyBean.customInit() 실행");
    } 

   
    
    
    
                           
    
    @PreDestroy
    public void preDestroy()
    {
        // TODO Auto-generated method stub
        System.out.println("      @PreDestroy() 실행");
    } 
    
    @Override
    public void destroy() throws Exception
    {
        // TODO Auto-generated method stub
        System.out.println("MyBean.destroy() 실행");
    }
    public void customDestroy()
    {
        // TODO Auto-generated method stub
        System.out.println("MyBean.customDestroy() 실행");
    } 
    
}
