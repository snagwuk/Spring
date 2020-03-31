package chap03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class MainForSensor
{
    public static void main(String[] args)
    {
   
        // TODO Auto-generated method stub
        //GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:chap03.xml");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigSensor.class);
        System.out.println("==================1");
        Monitor monitor = ctx.getBean(Monitor.class);
        System.out.println(monitor);
        ctx.close();
      
    }
}
