package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import chap07.member.MemberRegistRequest;
import chap07.member.MemberRegistValidator;
import service.MemberService;

@Controller
@RequestMapping("/member/regist")
public class RegistrationController
{
    private static final String Member_REGISTRATION_FORM = "member/registrationForm";
    @Autowired
    private MemberService memberService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String form(@ModelAttribute("memberInfo") MemberRegistRequest memRegReq)
    {
        return Member_REGISTRATION_FORM;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String regist(@ModelAttribute("memberInfo") MemberRegistRequest memRegReq, BindingResult bindingResult)
    {                           /// @ModelAttribute("memberInfo") ""안에 이름으로  memRegReq 가 넘어간다.
        new MemberRegistValidator().validate(memRegReq,bindingResult);
        if(bindingResult.hasErrors())
            return Member_REGISTRATION_FORM;
        
        memberService.registNewMember(memRegReq);
        return "member/registered";
    }
    
    
    public void setMemberService(MemberService memberService)
    {
        this.memberService = memberService;
    }
}
