package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import src.AuthFailLogger;

public class MainByXmlWithoutId
{
    
    public static void main(String[] args)
    {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:config-without-id.xml");
        String[] beanNames = ctx.getBeanDefinitionNames();
        for (String bn : beanNames)
            System.out.println(bn);
        
        AuthFailLogger a1 = ctx.getBean("authFailLogger",AuthFailLogger.class);
        System.out.println("a1 : " + a1);
        AuthFailLogger a2 = ctx.getBean("authFailLogger",AuthFailLogger.class);
        System.out.println("a2 : " + a2);
        
        ctx.close();
    }
}
