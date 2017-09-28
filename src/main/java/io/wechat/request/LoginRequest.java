package io.wechat.request;

import lombok.Data;

@Data
public class LoginRequest implements WechatRequest {
    private String redirectUri;


    public LoginRequest(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    @Override
    public String getRequestUrl() {
        return redirectUri;
    }
}
