package io.wechat.request;

import io.wechat.session.WechatSession;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public abstract class AbstractWechatRequest implements WechatRequest {

    private WechatSession wechatSession;

    public AbstractWechatRequest(WechatSession wechatSession) {
        this.wechatSession = wechatSession;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();

        map.put("_", System.currentTimeMillis());

        return map;
    }


    public String getUuid() {
        return wechatSession.getUuid();
    }

    public String getType() {
        return wechatSession.getType();
    }

    public String getCookie() {
        return wechatSession.getCookie();
    }

    public String getWxHost() {
        return wechatSession.getWxHost();
    }

    public String getPassTicket() {
        return wechatSession.getPassTicket();
    }

    public String getSKey() {
        return wechatSession.getSKey();
    }

    public String getUin() {
        return wechatSession.getUin();
    }

    public String getSid() {
        return wechatSession.getSid();
    }

    public String getDeviceId() {
        return wechatSession.getDeviceId();
    }

    public String getAppid() {
        return wechatSession.getAppid();
    }

    public String getFun() {
        return wechatSession.getFun();
    }

    public String getLang() {
        return wechatSession.getLang();
    }

    public String getRedirectUri() {
        return wechatSession.getRedirectUri();
    }
}
