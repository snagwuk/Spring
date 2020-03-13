package conf;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import src.AuthFailLogger;
import src.AuthenticationService;
import src.PasswordChangeService;
import src.User;
import src.UserRepository;

@Configuration
public class Config
{
    
    @Bean
    public User user1()
    {
        return new User("bkchoi", "1234");
    }
    
    @Bean(name = "user2")
    public User user()
    {
        return new User("madvirus", "qwer");
    }
    
    @Bean
    public UserRepository userRepository()
    {
        UserRepository userRepo = new UserRepository();
        userRepo.setUsers(Arrays.asList(user1(), user()));
        return userRepo;
    }
    
    @Bean
    public PasswordChangeService pwChangeSvc()
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
