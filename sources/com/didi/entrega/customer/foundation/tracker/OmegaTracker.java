package com.didi.entrega.customer.foundation.tracker;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public final class OmegaTracker {

    /* renamed from: a */
    private static final String f20040a = "OmegaTracker";

    /* renamed from: b */
    private Map<String, Object> f20041b;

    /* renamed from: c */
    private String f20042c;

    private OmegaTracker(String str, ScopeContext scopeContext, boolean z, Map<String, Object> map) {
        this.f20042c = str;
        if (!z) {
            this.f20041b = OmegaCommonParamHelper.getCommonParam();
        } else if (scopeContext != null && !scopeContext.getLiveHandler().isDestroyed()) {
            this.f20041b = OmegaCommonParamHelper.m14799a((String) scopeContext.getObject("ScopeContextPageId"));
        } else {
            return;
        }
        this.f20041b.putAll(map);
    }

    public void track() {
        if (this.f20041b != null) {
            LogUtil.m14765i(f20040a, "trackEvent mEventName： " + this.f20042c);
            OmegaSDKAdapter.trackEvent(this.f20042c, this.f20041b);
        }
    }

    public static final class Builder {
        private String mEventName;
        private Map<String, Object> mEventParamsMap = new HashMap();
        private boolean mNeedScopeContext;
        private ScopeContext mScopeContext;

        private Builder(String str, ScopeContext scopeContext, boolean z) {
            if (!TextUtils.isEmpty(str)) {
                this.mEventName = str;
                this.mScopeContext = scopeContext;
                this.mNeedScopeContext = z;
                return;
            }
            throw new IllegalStateException("eventName must have value");
        }

        public static Builder create(String str, ScopeContext scopeContext) {
            return new Builder(str, scopeContext, true);
        }

        public static Builder create(String str) {
            return new Builder(str, (ScopeContext) null, false);
        }

        public Builder addAllEventParam(Map map) {
            this.mEventParamsMap.putAll(map);
            return this;
        }

        public Builder addEventParam(String str, Object obj) {
            this.mEventParamsMap.put(str, obj);
            return this;
        }

        public OmegaTracker build() {
            return new OmegaTracker(this.mEventName, this.mScopeContext, this.mNeedScopeContext, this.mEventParamsMap);
        }
    }
}
