package io.wechat.request;

import java.util.Map;

public interface WechatRequest {
    String getRequestUrl();

    default Map<String, Object> toMap() {
        return null;
    }
}
