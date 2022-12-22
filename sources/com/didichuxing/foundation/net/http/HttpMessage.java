package com.didichuxing.foundation.net.http;

import java.util.List;

public interface HttpMessage {
    HttpEntity getEntity();

    String getHeader(String str);

    List<HttpHeader> getHeaders();

    List<String> getHeaders(String str);

    String getUrl();
}
