package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import chap03.Sensor;

public class MainByJavaConfig
{
    
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
       // useBean(new GenericXmlApplicationContext("classpath:chap023.xml"));
        useBean(new AnnotationConfigApplicationContext(ConfigWithXmlmport.class));
    }

    private static void useBean(
            AnnotationConfigApplicationContext ctx)
    {
        // TODO Auto-generated method stub
        AuthenticationService authSvc = ctx.getBean("authenticationService",AuthenticationService.class);
        authSvc.authenticate("bkchoi", "1234");
        PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
        pwChgSvc.changePassword("bkchoi", "1234", "5678");
        Sensor sensor1 = ctx.getBean("sensor1",Sensor.class);
        System.out.println(sensor1);
        ctx.close();
    }

    private static void useBean(
            GenericXmlApplicationContext ctx)
    {
        // TODO Auto-generated method stub
        AuthenticationService authSvc = ctx.getBean("authenticationService",AuthenticationService.class);
        authSvc.authenticate("bkchoi", "1234");
        PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
        pwChgSvc.changePassword("bkchoi", "1234", "5678");
        Sensor sensor1 = ctx.getBean("sensor1",Sensor.class);
        System.out.println(sensor1);
        ctx.close();
        
    }

    
}
