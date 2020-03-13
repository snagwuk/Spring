package chap06.member;

public class MemberServiceImpl implements MemberService
{
    
    public void regist(MemberRegRequest memberRegReq)
    {
        System.out.println("MemberServiceImpl.regist() 호출됨");
    }
    
    public boolean update(String id, UpdateInfo updateInfo)
    {
        System.out.println("MemberServiceImpl.update() 호출됨");
        return true;
    }
    
}
