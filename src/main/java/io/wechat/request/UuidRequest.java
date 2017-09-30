package io.wechat.request;

import io.wechat.session.WechatSession;
import lombok.Data;

import java.util.Map;

@Data
public class UuidRequest extends AbstractWechatRequest implements WechatRequest {
    public UuidRequest(WechatSession wechatSession) {
        super(wechatSession);
    }

    @Override
    public String getRequestUrl() {
        return "https://login.weixin.qq.com/jslogin";
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = super.toMap();

        map.put("appid", getAppid());
        map.put("fun", getFun());
        map.put("lang", getLang());

        return map;
    }
}
