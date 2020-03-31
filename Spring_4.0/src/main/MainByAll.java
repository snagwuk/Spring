package main;
import org.springframework.context.support.GenericXmlApplicationContext;

import chap02.AuthenticationService;
import chap02.PasswordChangeService;
import chap03.Monitor;

public class MainByAll
{
    public static void main(String[] args)
    {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
                "classpath:config-all.xml");
        
        AuthenticationService authSvc = ctx
                .getBean("authenticationService", AuthenticationService.class);
        authSvc.authenticate("bkchoi", "1234");
        
        Monitor monitor = ctx.getBean(Monitor.class);
        System.out.println(monitor);
        
        ctx.close();
    }
}
