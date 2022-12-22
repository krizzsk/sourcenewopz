package com.didi.beatles.p099im.omega;

import com.didi.beatles.p099im.utils.IMTextUtil;
import com.didichuxing.omega.sdk.Omega;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.beatles.im.omega.IMTraceError */
public class IMTraceError {
    public static final String ERROR_CHANGE_LOCAL = "change_local";
    public static final String ERROR_INNER_PATH = "inner_path";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static Map<String, TraceFlow> f9351a = new HashMap();

    public static void trackError(String str, Throwable th) {
        Omega.trackError(str, th);
    }

    public static TraceFlow trackErrorFlow(String str) {
        TraceFlow traceFlow = f9351a.get(str);
        if (traceFlow != null) {
            return traceFlow;
        }
        TraceFlow traceFlow2 = new TraceFlow(str);
        f9351a.put(str, traceFlow2);
        return traceFlow2;
    }

    /* renamed from: com.didi.beatles.im.omega.IMTraceError$TraceFlow */
    public static class TraceFlow {
        private Exception causeError;
        private final String key;
        private boolean result;
        private Exception resultError;

        private TraceFlow(String str) {
            this.key = str;
        }

        public TraceFlow setError(Exception exc) {
            this.causeError = exc;
            return this;
        }

        public TraceFlow setResult(boolean z, Exception exc) {
            this.result = z;
            this.resultError = exc;
            return this;
        }

        public void report() {
            IMTraceError.f9351a.remove(this.key);
            if (this.causeError != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("key", this.key);
                hashMap.put("causeError", IMTextUtil.getExceptionStr(this.causeError));
                hashMap.put("result", Boolean.valueOf(this.result));
                Exception exc = this.resultError;
                hashMap.put("resultError", exc == null ? "" : IMTextUtil.getExceptionStr(exc));
                OmegaSDKAdapter.trackEvent("im_android_error_flow", (Map<String, Object>) hashMap);
            }
        }
    }
}
