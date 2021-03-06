package main;

import conf.ConfigScan;
import shop.OrderInfo;
import shop.OrderService;
import shop.ProductInfo;
import shop.ProductService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByScan {

        public static void main(String[] args) {
                useXmlWithScan();
               
        }

        private static void useXmlWithScan() {
                GenericXmlApplicationContext ctx =
                                new GenericXmlApplicationContext("classpath:config-with-scan.xml");
                useContext(ctx);
                ctx.close();
        }

      

        private static void useContext(ApplicationContext ctx) {
                ProductService productService = ctx.getBean("productService", ProductService.class);
                productService.createProduct(new ProductInfo());

                OrderService orderService = ctx.getBean("orderSvc", OrderService.class);
                orderService.order(new OrderInfo());
        }

}
