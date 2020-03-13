package main;

import search.SearchClientFactory;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForSearch {

        public static void main(String[] args) {
                GenericXmlApplicationContext ctx = 
                                new GenericXmlApplicationContext("classpath:config-search.xml");
                SearchClientFactory factory = ctx.getBean("searchClientFactory", SearchClientFactory.class);
                System.out.println(factory);
                SearchClientFactory factory2 = ctx.getBean("searchClientFactory", SearchClientFactory.class);
                System.out.println("same instance = " + (factory == factory2));
                ctx.close();
        }

}
