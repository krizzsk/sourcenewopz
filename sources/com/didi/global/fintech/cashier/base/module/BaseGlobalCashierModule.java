package com.didi.global.fintech.cashier.base.module;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u000bH&¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/base/module/BaseGlobalCashierModule;", "", "()V", "asyncCall", "", "args", "Lorg/json/JSONObject;", "callback", "Lcom/didi/global/fintech/cashier/base/module/BaseGlobalCashierModule$Callback;", "syncCall", "version", "", "Callback", "Companion", "cashier_base_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierModuleManager.kt */
public abstract class BaseGlobalCashierModule {
    public static final String ARGS = "ARGS";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REQUEST = "request";
    public static final String RESPONSE = "response";

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/base/module/BaseGlobalCashierModule$Callback;", "", "onCall", "", "result", "Lorg/json/JSONObject;", "cashier_base_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalCashierModuleManager.kt */
    public interface Callback {
        void onCall(JSONObject jSONObject);
    }

    public void asyncCall(JSONObject jSONObject, Callback callback) {
        Intrinsics.checkNotNullParameter(jSONObject, "args");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    public JSONObject syncCall(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "args");
        return null;
    }

    public abstract String version();

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/base/module/BaseGlobalCashierModule$Companion;", "", "()V", "ARGS", "", "REQUEST", "RESPONSE", "request", "Lorg/json/JSONObject;", "name", "args", "response", "cashier_base_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalCashierModuleManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ JSONObject request$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            return companion.request(str, str2);
        }

        public final JSONObject request(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("request", str);
            jSONObject.put(BaseGlobalCashierModule.ARGS, str2);
            return jSONObject;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0012, code lost:
            if ((r4.length() == 0) == true) goto L_0x0014;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final org.json.JSONObject response(java.lang.String r4) {
            /*
                r3 = this;
                r0 = 1
                r1 = 0
                if (r4 != 0) goto L_0x0006
            L_0x0004:
                r0 = 0
                goto L_0x0014
            L_0x0006:
                r2 = r4
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                int r2 = r2.length()
                if (r2 != 0) goto L_0x0011
                r2 = 1
                goto L_0x0012
            L_0x0011:
                r2 = 0
            L_0x0012:
                if (r2 != r0) goto L_0x0004
            L_0x0014:
                if (r0 == 0) goto L_0x0018
                r4 = 0
                return r4
            L_0x0018:
                org.json.JSONObject r0 = new org.json.JSONObject
                r0.<init>()
                java.lang.String r1 = "response"
                r0.put(r1, r4)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.base.module.BaseGlobalCashierModule.Companion.response(java.lang.String):org.json.JSONObject");
        }
    }
}
