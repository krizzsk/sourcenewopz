package com.dmap.navigation.engine.p207a;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.utils.AsyncNetUtils;
import com.dmap.navigation.api.core.INaviTrafficUpdater;
import com.dmap.navigation.base.ctx.INaviContext;
import com.dmap.navigation.jni.swig.APIRequestHelper;
import com.dmap.navigation.jni.swig.APITrafficRequestCallback;
import com.dmap.navigation.jni.swig.NaviInfo;
import com.dmap.navigation.jni.swig.RequestInfo;
import com.dmap.navigation.jni.swig.SWIGTYPE_p_unsigned_char;
import com.dmap.navigation.jni.swig.TrafficNaviAPI;
import com.dmap.navigation.jni.swig.TrafficResponse;
import java.math.BigInteger;

/* renamed from: com.dmap.navigation.engine.a.d */
/* compiled from: TrafficAPIImpl */
public final class C17385d implements INaviTrafficUpdater {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final TrafficNaviAPI f51751a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Handler f51752b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C17401n f51753c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public INaviTrafficUpdater.Callback f51754d;

    /* renamed from: e */
    private final APITrafficRequestCallback f51755e = new APITrafficRequestCallback() {
        public final void onBegin() {
            HWLog.m16761i("nv_t", "onBegin");
            if (C17385d.this.f51754d != null) {
                C17385d.this.f51752b.post(new Runnable() {
                    public final void run() {
                        if (C17385d.this.f51754d != null) {
                            C17385d.this.f51754d.onBegin();
                        }
                    }
                });
            }
        }

        public final void onFinish(TrafficResponse trafficResponse) {
            HWLog.m16761i("nv_t", "onFinish");
            final C17397j jVar = new C17397j(trafficResponse);
            if (C17385d.this.f51754d != null) {
                C17385d.this.f51752b.post(new Runnable() {
                    public final void run() {
                        if (C17385d.this.f51754d != null) {
                            C17385d.this.f51754d.onFinish(jVar);
                        }
                    }
                });
            }
        }
    };

    /* renamed from: f */
    private final APIRequestHelper f51756f = new APIRequestHelper() {
        public final void onPost(int i, final String str, SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char, int i2) {
            HWLog.m16761i("nv_t", "url = " + str + " , body size = " + i2);
            if (!TextUtils.isEmpty(str)) {
                final byte[] a = C17400m.m37040a(sWIGTYPE_p_unsigned_char, i2);
                C17385d.this.f51752b.postDelayed(new Runnable() {
                    public final void run() {
                        AsyncNetUtils.doPost(str, a, new AsyncNetUtils.Callback() {
                            public final void onFailed(int i, Exception exc) {
                            }

                            public final void onSuccess(byte[] bArr) {
                                HWLog.m16761i("nv_t", "result size = " + bArr.length);
                                C17385d.this.f51751a.onResponse(bArr, bArr.length, (int) (System.currentTimeMillis() / 1000));
                                HWLog.binary_i((byte) 3, bArr, System.currentTimeMillis());
                            }
                        });
                    }
                }, (long) i);
                return;
            }
            HWLog.m16761i("nv_t", "url = null");
        }

        public final RequestInfo getRequestInfo() {
            RequestInfo requestInfo = new RequestInfo();
            requestInfo.setTraceId(C17400m.m37039a(C17385d.this.f51753c.f51827aL.getImei()));
            requestInfo.setCurrentTime(BigInteger.valueOf(System.currentTimeMillis()));
            requestInfo.setSessionId(C17385d.this.f51753c.getSessionId());
            requestInfo.setSeq(C17385d.this.f51753c.getSeq());
            requestInfo.setSpanId(C17400m.m37041b(C17385d.this.f51753c.f51827aL.getImei()));
            requestInfo.setLogId(C17400m.m37041b(C17385d.this.f51753c.f51827aL.getImei()) + C17400m.m37041b(C17385d.this.f51753c.f51827aL.getImei()));
            return requestInfo;
        }
    };

    public C17385d(INaviContext iNaviContext, NaviInfo naviInfo) {
        C17401n nVar = (C17401n) iNaviContext;
        this.f51753c = nVar;
        TrafficNaviAPI trafficNaviAPI = new TrafficNaviAPI(nVar.f51828aM, this.f51753c.f51827aL, this.f51753c.f51829aN);
        this.f51751a = trafficNaviAPI;
        trafficNaviAPI.setHelper(this.f51756f);
        this.f51751a.setCallback(this.f51755e);
        if (naviInfo != null) {
            this.f51751a.setNaviInfo(naviInfo);
        }
    }

    public final byte[] getRequestData() {
        return C17400m.m37040a(this.f51751a.getRequestData(), this.f51751a.getRequestDataLength());
    }

    public final void parseData(byte[] bArr, INaviTrafficUpdater.Callback callback) {
        this.f51754d = callback;
        this.f51751a.onResponse(bArr, bArr.length, (int) (System.currentTimeMillis() / 1000));
    }

    public final void enqueue(INaviTrafficUpdater.Callback callback) {
        this.f51754d = callback;
        this.f51751a.execute();
    }

    public final void cancel() {
        this.f51752b.removeCallbacksAndMessages((Object) null);
        this.f51754d = null;
        this.f51751a.cancel();
    }
}
