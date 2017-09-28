package io.wechat.service.impl;

import io.wechat.request.*;
import io.wechat.response.*;
import io.wechat.service.WechatService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;

public class WechatServiceImplTest {

    @Test
    public void getUUID() throws Exception {
        WechatService wechatService = new WechatServiceImpl();

        UuidResponse uuidResponse = wechatService.getUUID(UuidRequest.defaultInstance());

        Assert.assertTrue(uuidResponse.success());
        Assert.assertTrue(!StringUtils.isEmpty(uuidResponse.getUuid()));
    }

    @Test
    public void getQrcode() throws Exception {
        WechatService wechatService = new WechatServiceImpl();

        UuidResponse uuidResponse = wechatService.getUUID(UuidRequest.defaultInstance());
        GenerateQrcodeRequest generateQrcodeRequest = new GenerateQrcodeRequest(uuidResponse.getUuid());
        GenerateQrcodeResponse qrcode = wechatService.getQrcode(generateQrcodeRequest);

        Assert.assertTrue(qrcode.success());
    }

    @Test
    public void getScanQrcodeStatus() throws Exception {
        WechatService wechatService = new WechatServiceImpl();

        UuidResponse uuidResponse = wechatService.getUUID(UuidRequest.defaultInstance());
        GenerateQrcodeRequest generateQrcodeRequest = new GenerateQrcodeRequest(uuidResponse.getUuid());
        GenerateQrcodeResponse qrcode = wechatService.getQrcode(generateQrcodeRequest);

        File file = new File("qrcode.jpg");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(qrcode.getData());
        fileOutputStream.close();
        GetScanQrcodeStatusRequest getScanQrcodeStatusRequest = new GetScanQrcodeStatusRequest(uuidResponse.getUuid());
        GetScanQrcodeStatusResponse scanQrcodeStatus = wechatService.getScanQrcodeStatus(getScanQrcodeStatusRequest);
        Assert.assertTrue("你可能没有扫码", scanQrcodeStatus.success());
    }

    @Test
    public void getGetConfirmLoginResponse() throws Exception {
        WechatService wechatService = new WechatServiceImpl();

        UuidResponse uuidResponse = wechatService.getUUID(UuidRequest.defaultInstance());
        GenerateQrcodeRequest generateQrcodeRequest = new GenerateQrcodeRequest(uuidResponse.getUuid());
        GenerateQrcodeResponse qrcode = wechatService.getQrcode(generateQrcodeRequest);

        File file = new File("qrcode.jpg");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(qrcode.getData());
        fileOutputStream.flush();
        fileOutputStream.close();
        GetScanQrcodeStatusRequest getScanQrcodeStatusRequest = new GetScanQrcodeStatusRequest(uuidResponse.getUuid());
        wechatService.getScanQrcodeStatus(getScanQrcodeStatusRequest);

        GetConfirmLoginRequest getConfirmLoginRequest = new GetConfirmLoginRequest(uuidResponse.getUuid());
        GetConfirmLoginResponse getConfirmLoginResponse = wechatService.getGetConfirmLoginResponse(getConfirmLoginRequest);
        Assert.assertTrue("你可能没有确认登录!", getConfirmLoginResponse.success());
    }

    @Test
    public void login() throws Exception {
        WechatService wechatService = new WechatServiceImpl();

        UuidResponse uuidResponse = wechatService.getUUID(UuidRequest.defaultInstance());
        GenerateQrcodeRequest generateQrcodeRequest = new GenerateQrcodeRequest(uuidResponse.getUuid());
        GenerateQrcodeResponse qrcode = wechatService.getQrcode(generateQrcodeRequest);

        File file = new File("qrcode.jpg");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(qrcode.getData());
        fileOutputStream.flush();
        fileOutputStream.close();
        GetScanQrcodeStatusRequest getScanQrcodeStatusRequest = new GetScanQrcodeStatusRequest(uuidResponse.getUuid());
        wechatService.getScanQrcodeStatus(getScanQrcodeStatusRequest);

        GetConfirmLoginRequest getConfirmLoginRequest = new GetConfirmLoginRequest(uuidResponse.getUuid());
        GetConfirmLoginResponse getConfirmLoginResponse = wechatService.getGetConfirmLoginResponse(getConfirmLoginRequest);

        LoginResponse loginResponse = wechatService.login(new LoginRequest(getConfirmLoginResponse.getRedirectUrl()));
        Assert.assertTrue("登录失败", loginResponse.success());
    }

    @Test
    public void init() throws Exception {
        WechatService wechatService = new WechatServiceImpl();

        UuidResponse uuidResponse = wechatService.getUUID(UuidRequest.defaultInstance());
        GenerateQrcodeRequest generateQrcodeRequest = new GenerateQrcodeRequest(uuidResponse.getUuid());
        GenerateQrcodeResponse qrcode = wechatService.getQrcode(generateQrcodeRequest);

        File file = new File("qrcode.jpg");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(qrcode.getData());
        fileOutputStream.flush();
        fileOutputStream.close();
        GetScanQrcodeStatusRequest getScanQrcodeStatusRequest = new GetScanQrcodeStatusRequest(uuidResponse.getUuid());
        wechatService.getScanQrcodeStatus(getScanQrcodeStatusRequest);

        GetConfirmLoginRequest getConfirmLoginRequest = new GetConfirmLoginRequest(uuidResponse.getUuid());
        GetConfirmLoginResponse getConfirmLoginResponse = wechatService.getGetConfirmLoginResponse(getConfirmLoginRequest);

        LoginResponse loginResponse = wechatService.login(new LoginRequest(getConfirmLoginResponse.getRedirectUrl()));

        InitRequest initRequest = new InitRequest();


        initRequest.setCookie(loginResponse.getCookie());
        initRequest.setDeviceId(loginResponse.getDeviceId());
        initRequest.setPassTicket(loginResponse.getPassTicket());
        initRequest.setSid(loginResponse.getSid());
        initRequest.setSKey(loginResponse.getSKey());
        initRequest.setTimestamp(System.currentTimeMillis());
        initRequest.setUin(loginResponse.getUin());

        InitResponse initResponse = wechatService.init(initRequest);

        Assert.assertTrue(initResponse.getBaseResponse().getErrMsg(), initResponse.success());

    }

}