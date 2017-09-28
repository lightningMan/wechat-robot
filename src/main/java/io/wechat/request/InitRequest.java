package io.wechat.request;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class InitRequest implements WechatRequest {
    public static final String DEFAULT_WX_HOST = "wx.qq.com";

    private String cookie;

    private String wxHost;

    private String passTicket;

    private String sKey;

    private String uin;

    private String sid;

    private String deviceId;


    private long timestamp;


    @Override
    public String getRequestUrl() {
        if (wxHost == null) {
            wxHost = DEFAULT_WX_HOST;
        }

        return "https://" + wxHost + "/cgi-bin/mmwebwx-bin/webwxinit?pass_ticket=" + passTicket + "&skey=" + sKey + "&r=" + timestamp;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();

        HashMap<String, Object> baseRequest = new HashMap<>();
        baseRequest.put("Uin", uin);
        baseRequest.put("Sid", sid);
        baseRequest.put("SKey", sKey);
        baseRequest.put("DeviceID", deviceId);


        map.put("BaseRequest", baseRequest);


        return map;
    }
}
