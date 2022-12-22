package com.didi.soda.web;

import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.soda.web.tools.LogUtil;
import java.util.HashMap;

public class WebFusionCallback implements IFusionCallback {

    /* renamed from: a */
    private HashMap<String, CallbackFunction> f43862a;

    private WebFusionCallback() {
        if (this.f43862a == null) {
            this.f43862a = new HashMap<>();
        }
    }

    private static final class INSTANCE_HOLDER {
        /* access modifiers changed from: private */
        public static WebFusionCallback INSTANCE = new WebFusionCallback();

        private INSTANCE_HOLDER() {
        }
    }

    public static WebFusionCallback getInstance() {
        return INSTANCE_HOLDER.INSTANCE;
    }

    public void bindCallbackWithName(String str, CallbackFunction callbackFunction) {
        if (this.f43862a.get(str) == null) {
            this.f43862a.put(str, callbackFunction);
        }
    }

    public void doCallbackWithName(String str, Object... objArr) {
        CallbackFunction callbackFunction = this.f43862a.get(str);
        if (callbackFunction == null) {
            LogUtil.info("callbackFusion is null");
            return;
        }
        callbackFunction.onCallBack(objArr);
        this.f43862a.remove(str);
    }
}
