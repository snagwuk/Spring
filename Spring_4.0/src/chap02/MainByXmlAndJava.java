package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainByXmlAndJava
{
    
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        useSingleClass();
    }

    private static void useSingleClass()
    {
        // TODO Auto-generated method stub
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config1.class,Config2.class);
        useBean(ctx);
        ctx.close();
    }

    private static void useBean(AnnotationConfigApplicationContext ctx)
    {
        // TODO Auto-generated method stub
        AuthenticationService authSvc = ctx.getBean("authenticationService",AuthenticationService.class);
        authSvc.authenticate("bkchoi", "1234");
        PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
        pwChgSvc.changePassword("bkchoi", "1234", "5678");
    }
    
}
