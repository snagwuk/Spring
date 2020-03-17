package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import chap07.auth.Auth;
import chap07.auth.AuthenticationException;
import chap07.member.MemberInfo;

@Component
public class Authenticator
{
    @Autowired
    private MemberService memberService;
    
    public Authenticator()
    {
    }
    
    public Authenticator(MemberService memberService)
    {
        this.memberService = memberService;
    }
    public Auth authenticate(String email,String password)
    {
        MemberInfo mi = memberService.getMemberInfoByEmail(email);
        if(mi == null)
            throw new AuthenticationException();
        if(!mi.matchPassword(password))
            throw new AuthenticationException();
        
        return new Auth(mi.getId(),mi.getName());
    }
    
}
