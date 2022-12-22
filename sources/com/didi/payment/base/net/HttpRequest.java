package com.didi.payment.base.net;

import java.io.Serializable;
import java.util.Map;

public class HttpRequest implements Serializable {
    public String baseURL;
    public Map<String, Object> body;
    public Map<String, String> headers;
    public String path;
}
