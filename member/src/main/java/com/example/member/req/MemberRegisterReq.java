package com.example.member.req;

import lombok.Data;

@Data
public class MemberRegisterReq {
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    private String mobile;
}
