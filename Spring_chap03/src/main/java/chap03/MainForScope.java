package chap03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForScope
{
    public static void main(String[] args)
    {
        // useXml();
        useJava();
    }
    
    private static void useXml()
    {
        // TODO Auto-generated method stub
        System.out.println("====XML Meta====");
        String configLocation = "classpath:config-for-scope.xml";
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
                configLocation);
        WorkScheduler scheduler = ctx.getBean("workScheduler",
                                              WorkScheduler.class);
        scheduler.makeAndRunWork();
        
        ctx.close();
    }
    
    private static void useJava()
    {
        // TODO Auto-generated method stub
        System.out.println("=====java Meta=====");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                ConfigForScope.class);
        
        WorkScheduler scheduler = ctx.getBean("workScheduler",
                                              WorkScheduler.class);
        scheduler.makeAndRunWork();
        ctx.close();
    }
    
}
