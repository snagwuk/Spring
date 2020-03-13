package chap04;

import java.io.IOException;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class MainByPropOfXml
{
    public static void main(String[] args) throws IOException
    {
        usePropertyplaceholder();
        System.out.println("===");
        useTwoPropertyPlaceholder();
    }

    private static void usePropertyplaceholder()
    {
        // TODO Auto-generated method stub
        System.out.println("===== 1개 propertyPlaceholder 사용");
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/db-config.xml");
        ConfigurableEnvironment env = ctx.getEnvironment();
        
        System.out.println(env.getProperty("java.version"));
        ctx.close();
    }
    
    private static void useTwoPropertyPlaceholder()
    {
        // TODO Auto-generated method stub
        System.out.println("===== 2개 propertyPlaceholder 사용");
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/app-config.xml","classpath:/db-config.xml");
        ChargeCalculator calculator = ctx.getBean(ChargeCalculator.class);
        
        calculator.calculate();
        ctx.close();
    }

    
}
