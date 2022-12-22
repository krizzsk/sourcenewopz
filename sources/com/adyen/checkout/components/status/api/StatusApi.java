package com.adyen.checkout.components.status.api;

import com.adyen.checkout.components.status.api.StatusConnectionTask;
import com.adyen.checkout.components.status.model.StatusRequest;
import com.adyen.checkout.core.api.Environment;
import com.adyen.checkout.core.api.ThreadManager;
import com.adyen.checkout.core.exception.ApiCallException;
import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;

public final class StatusApi {

    /* renamed from: a */
    private static final String f879a = LogUtil.getTag();

    /* renamed from: b */
    private static final String f880b = "services/PaymentInitiation/v1/status?token=%1$s";

    /* renamed from: c */
    private static StatusApi f881c;

    /* renamed from: d */
    private final String f882d;

    /* renamed from: e */
    private StatusConnectionTask f883e;

    public static StatusApi getInstance(Environment environment) {
        StatusApi statusApi;
        String baseUrl = environment.getBaseUrl();
        synchronized (StatusApi.class) {
            if (f881c == null || m1049a(f881c, baseUrl)) {
                f881c = new StatusApi(baseUrl);
            }
            statusApi = f881c;
        }
        return statusApi;
    }

    /* renamed from: a */
    private static boolean m1049a(StatusApi statusApi, String str) {
        return !statusApi.f882d.startsWith(str);
    }

    private StatusApi(String str) {
        String str2 = f879a;
        Logger.m1082v(str2, "Environment URL - " + str);
        this.f882d = str + f880b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo14640a() {
        synchronized (this) {
            this.f883e = null;
        }
    }

    public void callStatus(String str, String str2, StatusConnectionTask.StatusCallback statusCallback) {
        Logger.m1082v(f879a, "getStatus");
        String format = String.format(this.f882d, new Object[]{str});
        synchronized (this) {
            if (this.f883e != null) {
                Logger.m1078e(f879a, "Status already pending.");
                statusCallback.onFailed(new ApiCallException("Other Status call already pending."));
            }
            StatusRequest statusRequest = new StatusRequest();
            statusRequest.setPaymentData(str2);
            this.f883e = new StatusConnectionTask(this, format, statusRequest, statusCallback);
            ThreadManager.EXECUTOR.submit(this.f883e);
        }
    }
}
