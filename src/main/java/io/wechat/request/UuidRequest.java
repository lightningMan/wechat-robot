package io.wechat.request;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class UuidRequest implements WechatRequest {
    private String appid;
    private String fun;
    private String lang;
    private String timestamp;

    @Override
    public String getRequestUrl() {
        return "https://login.weixin.qq.com/jslogin";
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("appid", appid);
        map.put("fun", fun);
        map.put("lang", lang);
        map.put("_", timestamp);

        return map;
    }

    public static UuidRequest defaultInstance() {
        UuidRequest uuidRequest = new UuidRequest();

        uuidRequest.setAppid("wx782c26e4c19acffb");
        uuidRequest.setFun("new");
        uuidRequest.setLang("zh_CN");
        uuidRequest.setTimestamp(String.valueOf(System.currentTimeMillis()));

        return uuidRequest;
    }
}
