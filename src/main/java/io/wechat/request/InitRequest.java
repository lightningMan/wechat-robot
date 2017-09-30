package io.wechat.request;

import io.wechat.session.WechatSession;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class InitRequest extends AbstractWechatRequest implements WechatRequest {

    public InitRequest(WechatSession wechatSession) {
        super(wechatSession);
    }

    @Override
    public String getRequestUrl() {

        return "https://" + getWxHost() + "/cgi-bin/mmwebwx-bin/webwxinit?pass_ticket=" + getPassTicket() + "&skey=" + getSKey() + "&r=" + System.currentTimeMillis();
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();

        HashMap<String, Object> baseRequest = new HashMap<>();
        baseRequest.put("Uin", getUin());
        baseRequest.put("Sid", getSid());
        baseRequest.put("SKey", getSKey());
        baseRequest.put("DeviceID", getDeviceId());


        map.put("BaseRequest", baseRequest);


        return map;
    }
}
