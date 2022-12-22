package com.adyen.checkout.components.status;

import android.os.Handler;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.adyen.checkout.components.status.api.StatusApi;
import com.adyen.checkout.components.status.api.StatusConnectionTask;
import com.adyen.checkout.components.status.api.StatusResponseUtils;
import com.adyen.checkout.components.status.model.StatusResponse;
import com.adyen.checkout.core.api.Environment;
import com.adyen.checkout.core.exception.ApiCallException;
import com.adyen.checkout.core.exception.ComponentException;
import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import java.util.concurrent.TimeUnit;

public final class StatusRepository {

    /* renamed from: a */
    static final String f862a = LogUtil.getTag();

    /* renamed from: k */
    private static final long f863k = TimeUnit.SECONDS.toMillis(2);

    /* renamed from: l */
    private static final long f864l = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: m */
    private static final long f865m = TimeUnit.SECONDS.toMillis(60);

    /* renamed from: n */
    private static final long f866n = TimeUnit.MINUTES.toMillis(15);

    /* renamed from: o */
    private static StatusRepository f867o;

    /* renamed from: b */
    final Handler f868b = new Handler();

    /* renamed from: c */
    final Runnable f869c = new Runnable() {
        public void run() {
            Logger.m1076d(StatusRepository.f862a, "mStatusPollingRunnable.run()");
            StatusRepository.this.f870d.callStatus(StatusRepository.this.f873g, StatusRepository.this.f874h, StatusRepository.this.f872f);
            StatusRepository.this.mo14630a();
            StatusRepository.this.f868b.postDelayed(StatusRepository.this.f869c, StatusRepository.this.f876j);
        }
    };

    /* renamed from: d */
    final StatusApi f870d;

    /* renamed from: e */
    final MutableLiveData<StatusResponse> f871e = new MutableLiveData<>();

    /* renamed from: f */
    final StatusConnectionTask.StatusCallback f872f = new StatusConnectionTask.StatusCallback() {
        public void onSuccess(StatusResponse statusResponse) {
            String str = StatusRepository.f862a;
            Logger.m1076d(str, "onSuccess - " + statusResponse.getResultCode());
            StatusRepository.this.f871e.postValue(statusResponse);
            if (StatusResponseUtils.isFinalResult(statusResponse)) {
                StatusRepository.this.stopPolling();
            }
        }

        public void onFailed(ApiCallException apiCallException) {
            Logger.m1078e(StatusRepository.f862a, "onFailed");
        }
    };

    /* renamed from: g */
    String f873g;

    /* renamed from: h */
    String f874h;

    /* renamed from: i */
    Boolean f875i = false;

    /* renamed from: j */
    long f876j;

    /* renamed from: p */
    private final MutableLiveData<ComponentException> f877p = new MutableLiveData<>();

    /* renamed from: q */
    private long f878q;

    public static StatusRepository getInstance(Environment environment) {
        synchronized (StatusRepository.class) {
            if (f867o == null) {
                f867o = new StatusRepository(environment);
            }
        }
        return f867o;
    }

    private StatusRepository(Environment environment) {
        this.f870d = StatusApi.getInstance(environment);
    }

    public LiveData<StatusResponse> getStatusResponseLiveData() {
        return this.f871e;
    }

    public LiveData<ComponentException> getErrorLiveData() {
        return this.f877p;
    }

    public void startPolling(String str, String str2) {
        Logger.m1076d(f862a, "startPolling");
        if (!this.f875i.booleanValue() || !str.equals(this.f873g) || !str2.equals(this.f874h)) {
            stopPolling();
            this.f875i = true;
            this.f873g = str;
            this.f874h = str2;
            this.f878q = System.currentTimeMillis();
            this.f868b.post(this.f869c);
            return;
        }
        Logger.m1078e(f862a, "Already polling for this payment.");
    }

    public void updateStatus() {
        Logger.m1076d(f862a, "updateStatus");
        if (!this.f875i.booleanValue()) {
            Logger.m1076d(f862a, "No polling in progress");
            return;
        }
        this.f868b.removeCallbacks(this.f869c);
        this.f868b.post(this.f869c);
    }

    public void stopPolling() {
        Logger.m1076d(f862a, "stopPolling");
        if (!this.f875i.booleanValue()) {
            Logger.m1084w(f862a, "Stop called with no polling in progress, stopping anyway");
        }
        this.f875i = false;
        this.f868b.removeCallbacksAndMessages((Object) null);
        this.f871e.setValue(null);
        this.f877p.setValue(null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo14630a() {
        long currentTimeMillis = System.currentTimeMillis() - this.f878q;
        if (currentTimeMillis <= f865m) {
            this.f876j = f863k;
        } else if (currentTimeMillis <= f866n) {
            this.f876j = f864l;
        } else {
            this.f877p.setValue(new ComponentException("Status requesting timed out with no result"));
        }
    }

    public long getMaxPollingDurationMillis() {
        return f866n;
    }
}
