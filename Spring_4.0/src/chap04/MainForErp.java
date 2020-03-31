package chap04;

import org.springframework.context.support.GenericXmlApplicationContext;


public class MainForErp
{
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:chap04.xml");
        System.out.println("==================1");
        ErpClientFactory factory = ctx.getBean("factory",ErpClientFactory.class);
        ErpClient client = factory.create();
        client.connect();
        System.out.println("==================2");
        client.close();
        ctx.close();
    }
}
