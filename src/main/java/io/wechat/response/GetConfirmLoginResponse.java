package io.wechat.response;

import lombok.Data;

@Data
public class GetConfirmLoginResponse extends AbstractWechatResponse implements WechatResponse {

    private String redirectUrl;

    public void makeSuccess(String redirectUrl) {
        makeSuccess();
        this.redirectUrl = redirectUrl;
    }
}
