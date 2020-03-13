package config;

import chap06.aop.ArticleCacheAspect;
import chap06.aop.ProfilingAspect;
import chap06.aop.UpdateMemberInfoTraceAspect;
import chap06.board.ArticleDao;
import chap06.board.MemoryArticleDao;
import chap06.board.ReadArticleServiceImpl;
import chap06.board.WriteArticleServiceImpl;
import chap06.member.MemberServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class QuickStartConfig
{
    @Bean
    public ProfilingAspect performanceTraceAspect()
    {
        return new ProfilingAspect();
    }
    @Bean
    public UpdateMemberInfoTraceAspect memberInfoTraceAspect()
    {
        return new UpdateMemberInfoTraceAspect();
    }
    @Bean
    public ArticleDao articleDao()
    {
        return new MemoryArticleDao();
    }
    
    @Bean
    public WriteArticleServiceImpl writeArticleService()
    {
        return new WriteArticleServiceImpl(articleDao());
    }
    
    @Bean
    public MemberServiceImpl memberService()
    {
        return new MemberServiceImpl();
    }
    
    @Bean
    public ArticleCacheAspect cache()
    {
        return new ArticleCacheAspect();
    }
    
    @Bean
    public ReadArticleServiceImpl readArticleService()
    {
        ReadArticleServiceImpl svc = new ReadArticleServiceImpl();
        svc.setArticleDao(articleDao());
        return svc;
    }
}
