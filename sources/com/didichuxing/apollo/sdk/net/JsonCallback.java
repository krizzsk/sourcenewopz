package com.didichuxing.apollo.sdk.net;

import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.didichuxing.apollo.sdk.log.LogUtils;
import com.turbomanage.httpclient.AsyncCallback;
import com.turbomanage.httpclient.HttpResponse;

public abstract class JsonCallback extends AsyncCallback {
    public abstract void onComplete(JsonResponse jsonResponse);

    public void onComplete(HttpResponse httpResponse) {
        LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "HttpResponse: " + httpResponse.getBodyAsString());
        onComplete(JsonResponse.convertFrom(httpResponse));
    }
}
