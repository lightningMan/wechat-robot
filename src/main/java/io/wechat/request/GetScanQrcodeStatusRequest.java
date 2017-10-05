package io.wechat.request;

import io.wechat.session.WechatSession;
import lombok.Data;

import java.util.Map;

@Data
public class GetScanQrcodeStatusRequest extends AbstractWechatRequest implements WechatRequest {

    public GetScanQrcodeStatusRequest(WechatSession wechatSession) {
        super(wechatSession);
    }

    @Override
    public String getRequestUrl() {

        return "https://login." + getWxHost() + "/cgi-bin/mmwebwx-bin/login";
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = super.toMap();

        map.put("tip", 1);
        map.put("uuid", getUuid());

        return map;
    }
}
