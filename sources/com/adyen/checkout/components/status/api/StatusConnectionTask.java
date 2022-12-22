package com.adyen.checkout.components.status.api;

import com.adyen.checkout.components.status.model.StatusRequest;
import com.adyen.checkout.components.status.model.StatusResponse;
import com.adyen.checkout.core.api.ConnectionTask;
import com.adyen.checkout.core.api.ThreadManager;
import com.adyen.checkout.core.exception.ApiCallException;
import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class StatusConnectionTask extends ConnectionTask<StatusResponse> {

    /* renamed from: b */
    private static final String f884b = LogUtil.getTag();

    /* renamed from: c */
    private static final int f885c = 100;

    /* renamed from: a */
    StatusCallback f886a;

    /* renamed from: d */
    private final StatusApi f887d;

    public interface StatusCallback {
        void onFailed(ApiCallException apiCallException);

        void onSuccess(StatusResponse statusResponse);
    }

    StatusConnectionTask(StatusApi statusApi, String str, StatusRequest statusRequest, StatusCallback statusCallback) {
        super(new C1354a(str, statusRequest));
        this.f887d = statusApi;
        this.f886a = statusCallback;
    }

    /* access modifiers changed from: protected */
    public void done() {
        Logger.m1082v(f884b, "done");
        if (isCancelled()) {
            Logger.m1076d(f884b, StatusResponseUtils.RESULT_CANCELED);
            m1052a(new ApiCallException("Execution canceled."));
            return;
        }
        try {
            m1051a((StatusResponse) get(100, TimeUnit.MILLISECONDS));
        } catch (ExecutionException e) {
            Logger.m1079e(f884b, "Execution failed.", e);
            m1052a(new ApiCallException("Execution failed.", e));
        } catch (InterruptedException e2) {
            Logger.m1079e(f884b, "Execution interrupted.", e2);
            m1052a(new ApiCallException("Execution interrupted.", e2));
        } catch (TimeoutException e3) {
            Logger.m1079e(f884b, "Execution timed out.", e3);
            m1052a(new ApiCallException("Execution timed out.", e3));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public StatusApi mo14642a() {
        return this.f887d;
    }

    /* renamed from: a */
    private void m1051a(final StatusResponse statusResponse) {
        ThreadManager.MAIN_HANDLER.post(new Runnable() {
            public void run() {
                StatusConnectionTask.this.mo14642a().mo14640a();
                StatusConnectionTask.this.f886a.onSuccess(statusResponse);
                StatusConnectionTask.this.f886a = null;
            }
        });
    }

    /* renamed from: a */
    private void m1052a(final ApiCallException apiCallException) {
        ThreadManager.MAIN_HANDLER.post(new Runnable() {
            public void run() {
                StatusConnectionTask.this.mo14642a().mo14640a();
                StatusConnectionTask.this.f886a.onFailed(apiCallException);
                StatusConnectionTask.this.f886a = null;
            }
        });
    }
}
