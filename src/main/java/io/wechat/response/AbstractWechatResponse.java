package io.wechat.response;

public abstract class AbstractWechatResponse implements WechatResponse {
    private boolean success;

    private String errorMessage;

    public void makeSuccess() {
        success = true;
    }

    public void makeFail() {
        success = false;
    }

    public void makeFail(String errorMessage) {
        success = false;
        this.errorMessage = errorMessage;
    }

    public boolean success() {
        return success;
    }


    public String errorMessage() {
        return errorMessage;
    }
}
