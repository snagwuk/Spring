package chap03;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ConnPool2 
{
    @PostConstruct
    public void initPool() throws Exception
    {
        System.out.println("ConnPool2.initPool()");
    }
    @PreDestroy
    public void destroyPool() throws Exception
    {
        System.out.println("ConnPool2.destroyPool()");
    }
    
    
}
