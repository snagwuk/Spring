package chap13.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import chap13.store.service.PlaceOrderService;
import chap13.store.service.PurchaseOrderRequest;
import chap13.store.service.PurchaseOrderResult;
4r1
public class MainForXmlConfig {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:/dataSource.xml", "classpath:/store.xml");
        System.out.println("==============1");
		PlaceOrderService orderService = ctx.getBean(PlaceOrderService.class);
		PurchaseOrderRequest orderRequest = new PurchaseOrderRequest();
		orderRequest.setItemId(1);
		orderRequest.setAddress("주소=====");

		PurchaseOrderResult orderResult = orderService.order(orderRequest);
		System.out.println(orderResult.getOrder().getId());
		 System.out.println("==============2");
		ctx.close();
	}

}
