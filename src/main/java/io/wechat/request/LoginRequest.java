package io.wechat.request;

import io.wechat.session.WechatSession;
import lombok.Data;

@Data
public class LoginRequest extends AbstractWechatRequest implements WechatRequest {


    public LoginRequest(WechatSession wechatSession) {
        super(wechatSession);
    }

    @Override
    public String getRequestUrl() {
        return getRedirectUri();
    }
}
