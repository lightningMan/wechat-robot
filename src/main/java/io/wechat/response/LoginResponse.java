package io.wechat.response;

import lombok.Data;

@Data
public class LoginResponse extends AbstractWechatResponse implements WechatResponse {
    private String cookie;

    private String sKey;

    private String sid;

    private String uin;

    private String passTicket;

    private String deviceId;
}
