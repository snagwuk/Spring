package chap02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository
{
    private Map<String,User> userMap = new HashMap<>();
    
    public User findUserById(String id) 
    {
        System.out.println(userMap.get(id));
       return userMap.get(id);
    }
    public void setUsers(List<User> users)
    {
        for(User u : users)
            userMap.put(u.getId(),u);
    }
}
