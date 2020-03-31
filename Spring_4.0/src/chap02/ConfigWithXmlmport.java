package chap02;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:chap03.xml")
public class ConfigWithXmlmport
{
    @Bean
    public User user1()
    {
        return new User("bkchoi", "1234");
    }
    
    @Bean
    public User user()
    {
        return new User("madvirus", "qwer");
    }
    @Bean
    public UserRepository userRepository()
    {
        UserRepository userRepo = new UserRepository();
        userRepo.setUsers(Arrays.asList(user1(),user()));
        return userRepo;
    }
    
    
    @Bean
    public PasswordChangeService pwChangSvc()
    {
     return new PasswordChangeService(userRepository());
    }
    @Bean
    public AuthFailLogger authFailLogger()
    {
        AuthFailLogger logger = new AuthFailLogger();
        logger.setThreshold(2);
        return logger;
    }
    @Bean
    public AuthenticationService authenticationService()
    {
        AuthenticationService authSvc = new AuthenticationService();
        authSvc.setFailLogger(authFailLogger());
        authSvc.setUserRepository(userRepository());
        return authSvc;
    }
    

}
