package com.terabits.redis;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */
@Service("memberService")
public class MemberService {

    @Resource(name="memberDao")
    private MemberDao memberDao;

    public void setMemberDao(MemberDao memberDao)
    {
        this.memberDao = memberDao;
    }

    public boolean add(Member member){
        boolean result = memberDao.add(member);
        return result;
    }

    public void delete(String id){
        memberDao.delete(id);
    }

    public Member get(String id)
    {
        return memberDao.get(id);
    }
    public boolean update(Member member){
        boolean result = memberDao.update(member);
        return result;
    }

    public List<Member> getMemberList(String keyId) {
        return  memberDao.getMemberList(keyId);
    }
}