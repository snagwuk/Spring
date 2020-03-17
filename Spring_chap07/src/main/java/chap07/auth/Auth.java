package chap07.auth;

public class Auth
{
    private String id;
    
    private String name;
    
    public Auth(String id, String name)
    {
        super();
        this.id = id;
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    
}
