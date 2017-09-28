package io.wechat.response;

import lombok.Data;

@Data
public class GenerateQrcodeResponse extends AbstractWechatResponse implements WechatResponse {
    /**
     * 二维码数据
     */
    private byte[] data;

    public void makeSuccess(byte data[]) {
        super.makeSuccess();
        this.data = data;
    }
}
