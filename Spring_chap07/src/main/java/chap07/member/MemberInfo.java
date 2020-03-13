package chap07.member;

public class MemberInfo
{
    
    private String id;
    
    private String name;
    
    private String email;
    
    private String password;
    
    private boolean allowNoti;
    
    private Address address;
    public MemberInfo(String id, String name, String email, String password, boolean allowNoti, Address address)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.allowNoti = allowNoti;
        this.address = address;
    }
    
    public boolean matchPassword(String inputPassword)
    {
        return password.equals(inputPassword);
    }
    
    public String getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public boolean isAllowNoti()
    {
        return allowNoti;
    }
    
    public void setAllowNoti(boolean allowNoti)
    {
        this.allowNoti = allowNoti;
    }
    
    public Address getAddress()
    {
        return address;
    }
    
    public void setAddress(Address address)
    {
        this.address = address;
    }
    
}
