package com.didi.rlab.uni_foundation.network;

import java.util.Map;

public interface NetworkService {
    Map<String, Object> URLParams();

    Map<String, Object> filePaths();

    Map<String, Object> headerParams();

    Map<String, Object> httpHeaderParams();

    Map<String, Object> httpPublicParams();

    String httpTraceId();

    long retryTimes();

    boolean urlSignEnabled();

    boolean useDefaultParams();
}
