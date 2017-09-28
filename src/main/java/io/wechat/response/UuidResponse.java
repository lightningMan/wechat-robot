package io.wechat.response;

import lombok.Data;

@Data
public class UuidResponse extends AbstractWechatResponse implements WechatResponse {

    private String uuid;

    public void setUuid(String UUID) {
        this.uuid = UUID;
    }
}
