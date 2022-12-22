package com.didiglobal.enginecore.littleboy;

import android.content.Context;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;

public class LBAbility {

    /* renamed from: a */
    private String f50179a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Map<String, Object> f50180b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RpcService.Callback<JsonObject> f50181c;

    /* renamed from: d */
    private Context f50182d;

    private LBAbility(Context context, String str) {
        this.f50180b = new HashMap();
        this.f50182d = context;
        this.f50179a = str;
    }

    public static class Builder {
        private LBAbility mAbility;

        public Builder(Context context, String str) {
            this.mAbility = new LBAbility(context, str);
        }

        public Builder setParams(Map<String, Object> map) {
            if (CollectionUtil.isEmpty((Map<?, ?>) map)) {
                return this;
            }
            Map unused = this.mAbility.f50180b = map;
            return this;
        }

        public Builder addParams(String str, Object obj) {
            if (this.mAbility.f50180b == null) {
                Map unused = this.mAbility.f50180b = new HashMap();
            }
            this.mAbility.f50180b.put(str, obj);
            return this;
        }

        public Builder removeParams() {
            if (this.mAbility.f50180b != null) {
                this.mAbility.f50180b.clear();
            }
            return this;
        }

        public Builder setCallback(RpcService.Callback<JsonObject> callback) {
            RpcService.Callback unused = this.mAbility.f50181c = callback;
            return this;
        }

        public LBAbility build() {
            return this.mAbility;
        }
    }

    public String getRequestKey() {
        return this.f50179a;
    }

    public Map<String, Object> getRequestParam() {
        return this.f50180b;
    }

    public RpcService.Callback<JsonObject> getCallback() {
        return this.f50181c;
    }

    public Context getContext() {
        return this.f50182d;
    }
}
