package com.example.member.service;

import cn.hutool.core.collection.CollUtil;
import com.example.common.exception.BusinessException;
import com.example.common.exception.BusinessExceptionEnum;
import com.example.member.domain.Member;
import com.example.member.domain.MemberExample;
import com.example.member.mapper.MemberMapper;
import com.example.member.req.MemberRegisterReq;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Resource
    private MemberMapper memberMapper;


    public int count(){
        return Math.toIntExact(memberMapper.countByExample(null));
    }
    public long register(MemberRegisterReq req) {

        String mobile = req.getMobile();

        //先判断手机号是否已经被注册
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);
        if (CollUtil.isNotEmpty(list)) {
            // return list.get(0).getId();
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }


        Member member = new Member();
        member.setId(System.currentTimeMillis());
        member.setMobile(mobile);

        memberMapper.insert(member);
        return member.getId();

    }



}