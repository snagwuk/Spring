package chap05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import chap022.SearchClientFactory;

public class MainForShop
{
    
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        runByUsingXmlConfig();
    }

    private static void runByUsingXmlConfig()
    {
       
        //GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:chap05.xml");
      AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigShop.class);
        System.out.println("================ctx new");
        useBean(ctx);
        ctx.close();
    }

    private static void useBean(ApplicationContext ctx)
    {
        // TODO Auto-generated method stub
        ProductService productService = ctx.getBean(ProductService.class);
        System.out.println("================ctx.getBean(ProductService");
        productService.createProduct(new ProductInfo());
        System.out.println("================productService.createProduct");
        OrderService orderService = ctx.getBean(OrderService.class);
        System.out.println("================ctx.getBean(OrderService");
        orderService.order(new OrderInfo());
        System.out.println("================orderService.order");
        
        SearchClientFactory orderSearchClientFactory = ctx.getBean("orderSearchClientFactory",
                                                                   SearchClientFactory.class);
        System.out.println(orderSearchClientFactory);
        SearchServiceHealthChecker healthChecker =
                ctx.getBean("searchServiceHealthChecker",SearchServiceHealthChecker.class);
        healthChecker.check();

    }
    
}
