package io.wechat.service.impl;

import io.wechat.request.*;
import io.wechat.response.*;
import io.wechat.service.WechatService;
import io.wechat.util.Util;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class WechatServiceImpl extends AbstractWechatService implements WechatService {

    private static final String QRCODE_SCANED_CODE = "201";

    private static final String CONFIRM_LOGIN_CODE = "200";

    /**
     * response 格式类似为 window.QRLogin.code = 200; window.QRLogin.uuid = "YYihJJ5B4g==";
     */
    @Override
    public UuidResponse getUUID(UuidRequest uuidRequest) {
        UuidResponse uuidResponse = new UuidResponse();
        String url = uuidRequest.getRequestUrl();
        String responseString = getString(url, uuidRequest.toMap());
        if (StringUtils.isEmpty(responseString)) {
            uuidResponse.makeFail();
            return uuidResponse;
        }

        responseString.split(";");

        String[] responseArray = responseString.split(";");
        String code = responseArray[0].split(" ")[2];

        if (!"200".equals(code)) {
            uuidResponse.makeFail("获取UUID得到错误的状态码: " + code);
            return uuidResponse;
        }

        String uuid = responseArray[1].split(" ")[3].split("\"")[1];

        uuidResponse.makeSuccess();

        uuidRequest.getWechatSession().setUuid(uuid);

        return uuidResponse;
    }

    @Override
    public GenerateQrcodeResponse getQrcode(GenerateQrcodeRequest generateQrcodeRequest) {
        GenerateQrcodeResponse generateQrcodeResponse = new GenerateQrcodeResponse();
        byte[] data = postBytes(generateQrcodeRequest.getRequestUrl(), generateQrcodeRequest.toMap());

        if (data != null) {
            generateQrcodeResponse.makeSuccess(data);
        } else {
            generateQrcodeResponse.makeFail();
        }

        return generateQrcodeResponse;
    }

    @Override
    public GetScanQrcodeStatusResponse getScanQrcodeStatus(GetScanQrcodeStatusRequest request) {
        GetScanQrcodeStatusResponse response = new GetScanQrcodeStatusResponse();

        String string = getString(request.getRequestUrl(), request.toMap());

        String code = string.substring(12, 15);

        // 已扫描成功
        if (QRCODE_SCANED_CODE.equals(code)) {
            response.makeSuccess();
        } else {
            response.makeFail();
        }

        return response;
    }

    @Override
    public GetConfirmLoginResponse getGetConfirmLoginResponse(GetConfirmLoginRequest request) {
        GetConfirmLoginResponse response = new GetConfirmLoginResponse();

        String string = getString(request.getRequestUrl(), request.toMap());


        String code = string.substring(12, 15);

        // 已扫描成功
        if (CONFIRM_LOGIN_CODE.equals(code)) {
            request.getWechatSession().setRedirectUri(string.substring(38, string.length() - 2) + "&fun=new");
            response.makeSuccess();
        } else {
            response.makeFail();
        }

        return response;

    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();

        WechatHttpResponse httpResponse = getHttpResponse(loginRequest.getRequestUrl());

        if (httpResponse == null) {
            loginResponse.makeFail();
        } else {
            loginRequest.getWechatSession().setCookie(Util.getCookie(httpResponse.getHeaders().get("Set-Cookie")));
            String body = httpResponse.getStringBody();

            loginRequest.getWechatSession().setSKey(Util.extractString("<skey>(\\S+)</skey>", body));
            loginRequest.getWechatSession().setSid(Util.extractString("<wxsid>(\\S+)</wxsid>", body));
            loginRequest.getWechatSession().setUin(Util.extractString("<wxuin>(\\S+)</wxuin>", body));
            loginRequest.getWechatSession().setPassTicket(Util.extractString("<pass_ticket>(\\S+)</pass_ticket>", body));
            loginRequest.getWechatSession().setDeviceId("e" + System.currentTimeMillis());

            loginResponse.makeSuccess();

        }


        return loginResponse;
    }

    @Override
    public InitResponse init(InitRequest initRequest) {
        InitResponse initResponse = new InitResponse();

        String string = postString(initRequest.getRequestUrl(), Util.toJson(initRequest.toMap()), initRequest.getCookie());

        if (string == null) {
            initResponse.makeFail();
        } else {
            initResponse = Util.fromJson(string, InitResponse.class);
            if ((initResponse.getBaseResponse().getRet() == 0)) {
                initResponse.makeSuccess();
            } else {
                initResponse.makeFail(initResponse.getBaseResponse().getErrMsg());
            }
        }

        return initResponse;
    }
}
