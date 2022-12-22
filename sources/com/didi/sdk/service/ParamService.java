package com.didi.sdk.service;

import java.util.Map;

public interface ParamService {
    String getHost();

    Map<String, String> getParams();

    String getPath();
}
