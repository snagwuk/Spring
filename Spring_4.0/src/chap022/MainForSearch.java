package chap022;

import org.springframework.context.support.GenericXmlApplicationContext;


public class MainForSearch
{
    
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:chap022.xml");
        System.out.println("==================1");
        SearchClientFactory factory = ctx.getBean("searchClientFactory",SearchClientFactory.class);
        System.out.println("==================2");
        System.out.println(factory);
        System.out.println("==================3");
        SearchClientFactory factory2 = ctx.getBean("searchClientFactory",SearchClientFactory.class);
        System.out.println("same instance = " + (factory == factory2));
    }
    
}
