package chap08.member;

import java.util.Date;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;



public class MemberModRequest
{
    
    @NotEmpty
    private String id;
    
    @NotEmpty
    private String email;
    
    @NotEmpty
    private String name;
    
    @NotEmpty
    private String currentPassword;
    
    private boolean allowNoti;
    
    @Valid
    private Address address;
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getCurrentPassword()
    {
        return currentPassword;
    }
    
    public void setCurrentPassword(String currentPassword)
    {
        this.currentPassword = currentPassword;
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
