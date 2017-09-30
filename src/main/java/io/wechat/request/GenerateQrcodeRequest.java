package io.wechat.request;

import io.wechat.session.WechatSession;
import lombok.Data;

import java.util.Map;

@Data
public class GenerateQrcodeRequest extends AbstractWechatRequest implements WechatRequest {
    @Override
    public String getRequestUrl() {
        return "https://login.weixin.qq.com/qrcode/" + getUuid();
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = super.toMap();

        map.put("t", getType());

        return map;
    }

    public GenerateQrcodeRequest(WechatSession wechatSession) {
        super(wechatSession);
    }
}
