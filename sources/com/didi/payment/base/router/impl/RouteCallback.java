package com.didi.payment.base.router.impl;

import java.util.Map;

public interface RouteCallback {
    void onResult(boolean z, Map<String, Object> map);
}
