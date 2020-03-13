package chap06.aop;

import chap06.member.UpdateInfo;

public class UpdateMemberInfoTraceAdvice
{
    
    public void traceReturn(String memberId, UpdateInfo info)
    {
        System.out.printf("UpdateMemberInfoTraceAdvice [TA] 정보 수정: 대상회원=%s, 수정정보=%s\n", memberId, info);
    }
    
}
