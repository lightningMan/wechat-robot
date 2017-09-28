package io.wechat.response;

public interface WechatResponse {
    boolean success();

    String errorMessage();
}
