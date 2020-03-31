package chap01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainBySpring
{
    public static void main(String[] args)
    {
        String configLocation = "classpath:chap01.xml";
        AbstractApplicationContext ctx =  new GenericXmlApplicationContext(configLocation);
        Project project = ctx.getBean("sampleProject",Project.class);
        project.build();
        ctx.close();
                }
}
