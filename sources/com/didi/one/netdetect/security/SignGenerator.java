package com.didi.one.netdetect.security;

import java.util.Map;

public interface SignGenerator {
    String genSign(Map<String, String> map);
}
