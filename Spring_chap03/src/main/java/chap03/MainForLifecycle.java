package chap03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForLifecycle
{
    
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
       // useXml();
        useJava();
    }

    private static void useXml()
    {
        // TODO Auto-generated method stub
        System.out.println("=====XML Meta=====");
        String configLocation = "classpath:config-for-lifecycle.xml";
        AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
        System.out.println("=======");
        ctx.close();
    }
    private static void useJava()
    {
        // TODO Auto-generated method stub
        System.out.println("=====java Meta=====");
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigForLifecycle.class);
        System.out.println("=======");
        ctx.close();
    }
    
}
