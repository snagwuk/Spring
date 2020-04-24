package chap12.main;

import chap12.store.service.PlaceOrderService;
import chap12.store.service.PurchaseOrderRequest;
import chap12.store.service.PurchaseOrderResult;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainTxSchema
{
    
    public static void main(String[] args)
    {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/dataSource.xml", "classpath:/jdbcTxSchema.xml");
        
        PlaceOrderService orderService = ctx.getBean(PlaceOrderService.class);
        PurchaseOrderRequest orderRequest = new PurchaseOrderRequest();
        orderRequest.setItemId(1);
        orderRequest.setAddress("주소");
        
        PurchaseOrderResult orderResult = orderService.order(orderRequest);
        System.out.println(orderResult.getOrder().getId());
        
        ctx.close();
    }
    
}
