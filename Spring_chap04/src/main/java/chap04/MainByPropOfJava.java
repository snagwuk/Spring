package chap04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainByPropOfJava
{
    
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigByProp.class);
        ctx.close();
    }
    
}
