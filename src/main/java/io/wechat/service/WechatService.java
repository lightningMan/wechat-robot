package io.wechat.service;

import io.wechat.request.*;
import io.wechat.response.*;

public interface WechatService {

    /**
     * 获取一个随机UUID
     *
     * @param uuidRequest
     * @return
     */
    UuidResponse getUUID(UuidRequest uuidRequest);

    /**
     * 获取完一个随机UUID之后，生成一个二维码
     */
    GenerateQrcodeResponse getQrcode(GenerateQrcodeRequest generateQrcodeRequest);

    /**
     * 二维码生成之后，获取扫取二维码状态
     */
    GetScanQrcodeStatusResponse getScanQrcodeStatus(GetScanQrcodeStatusRequest getScanQrcodeStatusRequest);

    /**
     * 二维码扫描之后，获取确认登录状态
     */
    GetConfirmLoginResponse getGetConfirmLoginResponse(GetConfirmLoginRequest getConfirmLoginRequest);


    /**
     * 确认登录之后，进行登录操作
     */
    LoginResponse login(LoginRequest loginRequest);

    /**
     * 登录成功之后进行init操作
     */

    InitResponse init(InitRequest initRequest);


}
