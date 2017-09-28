package io.wechat.request;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class GenerateQrcodeRequest implements WechatRequest {
    private String uuid;
    private String type;
    private long timestamp;

    @Override
    public String getRequestUrl() {
        return "https://login.weixin.qq.com/qrcode/" + uuid;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();

        map.put("t", type);
        map.put("_", timestamp);

        return map;
    }

    public GenerateQrcodeRequest(String uuid) {
        this.uuid = uuid;
        timestamp = System.currentTimeMillis();
        type = "webwx";
    }
}
