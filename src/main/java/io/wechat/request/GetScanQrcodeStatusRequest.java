package io.wechat.request;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class GetScanQrcodeStatusRequest implements WechatRequest {
    private int tip;
    private String uuid;
    private long timestamp;


    public GetScanQrcodeStatusRequest(String uuid) {
        this.uuid = uuid;
        tip = 1;
        timestamp = System.currentTimeMillis();
    }

    @Override
    public String getRequestUrl() {

        return "https://login.wx.qq.com/cgi-bin/mmwebwx-bin/login";
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();

        map.put("tip", tip);
        map.put("uuid", uuid);
        map.put("_", timestamp);

        return map;
    }
}
