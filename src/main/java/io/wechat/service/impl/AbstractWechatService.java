package io.wechat.service.impl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import io.wechat.response.WechatHttpResponse;
import io.wechat.service.WechatService;

import java.io.InputStream;
import java.util.Map;

public abstract class AbstractWechatService implements WechatService {

    static {
        System.setProperty("https.protocols", "TLSv1");
        System.setProperty("jsse.enableSNIExtension", "false");
    }

    protected String getString(String url, Map<String, Object> params) {
        try {
            return Unirest.get(url).queryString(params).asString().getBody();
        } catch (UnirestException e) {
            return null;
        }
    }

    protected byte[] postBytes(String requestUrl, Map<String, Object> fields) {

        try {
            InputStream inputStream = Unirest.post(requestUrl).fields(fields).asBinary().getBody();
            ByteOutputStream byteOutputStream = new ByteOutputStream();
            byteOutputStream.write(inputStream);
            return byteOutputStream.getBytes();
        } catch (Exception e) {
            return null;
        }
    }

    protected String postString(String requestUrl, String body, String cookie) {
        try {
            HttpRequestWithBody post = Unirest.post(requestUrl);
            post.body(body);
            post.header("Cookie", cookie);
            post.header("Content-Type", "application/json; charset=utf-8");
            return post.asString().getBody();
        } catch (Exception e) {
            return null;
        }
    }


    protected WechatHttpResponse getHttpResponse(String requestUrl) {
        WechatHttpResponse wechatHttpResponse = new WechatHttpResponse();

        try {
            HttpResponse<String> response = Unirest.get(requestUrl).asString();
            wechatHttpResponse.setStringBody(response.getBody());
            wechatHttpResponse.setHeaders(response.getHeaders());
            return wechatHttpResponse;
        } catch (UnirestException e) {
            return null;
        }
    }
}
