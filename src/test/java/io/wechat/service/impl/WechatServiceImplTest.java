package io.wechat.service.impl;

import io.wechat.request.*;
import io.wechat.response.*;
import io.wechat.service.WechatService;
import io.wechat.session.WechatSession;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class WechatServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(WechatServiceImplTest.class);


    @Test
    public void getUUID() throws Exception {
        WechatService wechatService = new WechatServiceImpl();
        WechatSession wechatSession = WechatSession.defaultInstance();
        UuidRequest uuidRequest = new UuidRequest(wechatSession);
        UuidResponse uuidResponse = wechatService.getUUID(uuidRequest);

        Assert.assertTrue(uuidResponse.success());
        Assert.assertTrue(!StringUtils.isEmpty(wechatSession.getUuid()));
    }

    @Test
    public void getQrcode() throws Exception {
        WechatService wechatService = new WechatServiceImpl();
        WechatSession wechatSession = WechatSession.defaultInstance();
        UuidRequest uuidRequest = new UuidRequest(wechatSession);
        wechatService.getUUID(uuidRequest);

        GenerateQrcodeRequest generateQrcodeRequest = new GenerateQrcodeRequest(wechatSession);
        GenerateQrcodeResponse qrcode = wechatService.getQrcode(generateQrcodeRequest);

        Assert.assertTrue(qrcode.success());
    }

    @Test
    public void getScanQrcodeStatus() throws Exception {
        WechatService wechatService = new WechatServiceImpl();
        WechatSession wechatSession = WechatSession.defaultInstance();
        UuidRequest uuidRequest = new UuidRequest(wechatSession);
        wechatService.getUUID(uuidRequest);
        GenerateQrcodeRequest generateQrcodeRequest = new GenerateQrcodeRequest(wechatSession);
        logger.info("点击如下链接扫码：" + generateQrcodeRequest.getRequestUrl());


        GetScanQrcodeStatusRequest getScanQrcodeStatusRequest = new GetScanQrcodeStatusRequest(wechatSession);
        GetScanQrcodeStatusResponse scanQrcodeStatus = wechatService.getScanQrcodeStatus(getScanQrcodeStatusRequest);
        Assert.assertTrue("你可能没有扫码", scanQrcodeStatus.success());
    }

    @Test
    public void getGetConfirmLoginResponse() throws Exception {
        WechatService wechatService = new WechatServiceImpl();
        WechatSession wechatSession = WechatSession.defaultInstance();
        UuidRequest uuidRequest = new UuidRequest(wechatSession);
        wechatService.getUUID(uuidRequest);
        GenerateQrcodeRequest generateQrcodeRequest = new GenerateQrcodeRequest(wechatSession);
        logger.info("点击如下链接扫码：" + generateQrcodeRequest.getRequestUrl());


        GetScanQrcodeStatusRequest getScanQrcodeStatusRequest = new GetScanQrcodeStatusRequest(wechatSession);
        wechatService.getScanQrcodeStatus(getScanQrcodeStatusRequest);

        GetConfirmLoginRequest getConfirmLoginRequest = new GetConfirmLoginRequest(wechatSession);
        GetConfirmLoginResponse getConfirmLoginResponse = wechatService.getGetConfirmLoginResponse(getConfirmLoginRequest);
        Assert.assertTrue("你可能没有确认登录!", getConfirmLoginResponse.success());
    }

    @Test
    public void login() throws Exception {
        WechatService wechatService = new WechatServiceImpl();
        WechatSession wechatSession = WechatSession.defaultInstance();
        UuidRequest uuidRequest = new UuidRequest(wechatSession);
        wechatService.getUUID(uuidRequest);
        GenerateQrcodeRequest generateQrcodeRequest = new GenerateQrcodeRequest(wechatSession);
        logger.info("点击如下链接扫码：" + generateQrcodeRequest.getRequestUrl());


        GetScanQrcodeStatusRequest getScanQrcodeStatusRequest = new GetScanQrcodeStatusRequest(wechatSession);
        wechatService.getScanQrcodeStatus(getScanQrcodeStatusRequest);

        GetConfirmLoginRequest getConfirmLoginRequest = new GetConfirmLoginRequest(wechatSession);
        GetConfirmLoginResponse getConfirmLoginResponse = wechatService.getGetConfirmLoginResponse(getConfirmLoginRequest);
        Assert.assertTrue("你可能没有确认登录!", getConfirmLoginResponse.success());

        LoginResponse loginResponse = wechatService.login(new LoginRequest(wechatSession));
        Assert.assertTrue("登录失败", loginResponse.success());
    }

    @Test
    public void init() throws Exception {
        WechatService wechatService = new WechatServiceImpl();
        WechatSession wechatSession = WechatSession.defaultInstance();
        UuidRequest uuidRequest = new UuidRequest(wechatSession);
        wechatService.getUUID(uuidRequest);
        GenerateQrcodeRequest generateQrcodeRequest = new GenerateQrcodeRequest(wechatSession);
        logger.info("点击如下链接扫码：" + generateQrcodeRequest.getRequestUrl());


        GetScanQrcodeStatusRequest getScanQrcodeStatusRequest = new GetScanQrcodeStatusRequest(wechatSession);
        wechatService.getScanQrcodeStatus(getScanQrcodeStatusRequest);

        GetConfirmLoginRequest getConfirmLoginRequest = new GetConfirmLoginRequest(wechatSession);
        GetConfirmLoginResponse getConfirmLoginResponse = wechatService.getGetConfirmLoginResponse(getConfirmLoginRequest);
        Assert.assertTrue("你可能没有确认登录!", getConfirmLoginResponse.success());

        LoginResponse loginResponse = wechatService.login(new LoginRequest(wechatSession));
        Assert.assertTrue("登录失败", loginResponse.success());

        InitRequest initRequest = new InitRequest(wechatSession);

        InitResponse initResponse = wechatService.init(initRequest);

        Assert.assertTrue(initResponse.getBaseResponse().getErrMsg(), initResponse.success());

    }

}