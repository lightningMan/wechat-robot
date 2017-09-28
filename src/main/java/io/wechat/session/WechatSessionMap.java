package io.wechat.session;

public interface WechatSessionMap {
    WechatSession addWechatSession(WechatSession wechatSession);

    WechatSession getWechatSession(String uuid);
}
