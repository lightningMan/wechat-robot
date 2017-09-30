package io.wechat.request;

import io.wechat.session.WechatSession;
import lombok.Data;

import java.util.Map;

@Data
public class GetConfirmLoginRequest extends GetScanQrcodeStatusRequest {

    public GetConfirmLoginRequest(WechatSession wechatSession) {
        super(wechatSession);
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = super.toMap();

        map.put("tip", 0);

        return map;
    }
}

