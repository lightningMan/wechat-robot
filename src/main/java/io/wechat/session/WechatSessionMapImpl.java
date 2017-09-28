package io.wechat.session;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class WechatSessionMapImpl implements WechatSessionMap {
    private Map<String, WechatSession> sessionMap;

    @PostConstruct
    public void init() {
        sessionMap = new ConcurrentHashMap<>();
    }

    @Override
    public WechatSession addWechatSession(WechatSession wechatSession) {
        return sessionMap.put(wechatSession.getUuid(), wechatSession);
    }

    @Override
    public WechatSession getWechatSession(String uuid) {
        return sessionMap.get(uuid);
    }

}
