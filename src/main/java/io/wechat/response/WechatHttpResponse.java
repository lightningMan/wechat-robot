package io.wechat.response;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class WechatHttpResponse {
    private Map<String, List<String>> headers;

    private byte[] bytesBody;

    private String stringBody;
}
