package io.wechat.request;

import lombok.Data;

@Data
public class GetConfirmLoginRequest extends GetScanQrcodeStatusRequest {
    public GetConfirmLoginRequest(String uuid) {
        super(uuid);
        setTip(0);
    }
}
