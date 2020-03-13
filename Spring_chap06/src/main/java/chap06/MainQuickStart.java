package chap06;

import org.springframework.context.support.GenericXmlApplicationContext;

import chap06.board.NewArticleRequest;
import chap06.board.ReadArticleService;
import chap06.board.WriteArticleService;
import chap06.member.MemberRegRequest;
import chap06.member.MemberService;
import chap06.member.UpdateInfo;

public class MainQuickStart
{
    public static void main(String[] args)
    {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
                "classpath:acQuickStart.xml");
        
        WriteArticleService writeArticleService = ctx
                .getBean("writeArticleService", WriteArticleService.class);
        writeArticleService
                .write(new NewArticleRequest("writer1", "title", "content"));
        writeArticleService
                .write(new NewArticleRequest("writer2", "title", "content"));
        
        ReadArticleService readArticleService = ctx
                .getBean(ReadArticleService.class);
        readArticleService.read(1);
        readArticleService.read(1);
        readArticleService.read(2);
        
        MemberService memberService = ctx.getBean(MemberService.class);
        MemberRegRequest memberRegReq = new MemberRegRequest("id", "name",
                "pw");
        memberService.regist(memberRegReq);
        
        UpdateInfo updateInfo = new UpdateInfo();
        updateInfo.setNewName("새이름");
        memberService.update("madvirus", updateInfo);
        
        ctx.close();
    }
}
