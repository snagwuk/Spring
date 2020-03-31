package chap022;

import org.springframework.beans.factory.FactoryBean;

public class SearchClientFactoryBean implements FactoryBean<SearchClientFactory>
{
    private String server;
    
    private int port;
    
    private String contentType;
    private String encoding = "utf8";
    private SearchClientFactory searchClientFactory;
    
    
    public void setServer(String server)
    {
        this.server = server;
    }
    
    public void setPort(int port)
    {
        this.port = port;
    }
    
    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }

    public void setEncoding(String encoding)
    {
        this.encoding = encoding;
    }

    public SearchClientFactory getObject() throws Exception
    {
        System.out.println("-----getObject");
        if(this.searchClientFactory != null)
        {
            return this.searchClientFactory;
        }
        SearchClientFactoryBuilder builder = new SearchClientFactoryBuilder();
        builder.server(server).port(port).contentType(contentType == null ? "json" : contentType).encoding(encoding);
        SearchClientFactory searchClientFactory = builder.build();
        searchClientFactory.init();
        this.searchClientFactory = searchClientFactory;
        return this.searchClientFactory;
    }


    @Override
    public Class<?> getObjectType()
    {

        System.out.println("getObjectType");
        return SearchClientFactory.class;
    }

    @Override
    public boolean isSingleton()
    {
        System.out.println("isSingleton");
        return true;
    }
   
    
    
    
}
