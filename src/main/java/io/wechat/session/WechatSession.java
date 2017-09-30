package io.wechat.session;

import lombok.Data;

@Data
public class WechatSession {

    private String wxHost;
    private String type;
    private String appid;
    private String fun;
    private String lang;

    private String redirectUri;
    private String uuid;
    private String cookie;
    private String passTicket;
    private String sKey;
    private String uin;
    private String sid;
    private String deviceId;


    public static WechatSession defaultInstance() {
        WechatSession wechatSession = new WechatSession();
        wechatSession.setWxHost("wx.qq.com");
        wechatSession.setType("webwx");
        wechatSession.setAppid("wx782c26e4c19acffb");
        wechatSession.setFun("new");
        wechatSession.setLang("zh_CN");

        return wechatSession;
    }
}
