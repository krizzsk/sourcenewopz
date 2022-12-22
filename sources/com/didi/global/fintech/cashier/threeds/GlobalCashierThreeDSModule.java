package com.didi.global.fintech.cashier.threeds;

import com.didi.global.fintech.cashier.base.module.BaseGlobalCashierModule;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import global.didi.pay.threeds.utils.ThreeDSUtils;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/GlobalCashierThreeDSModule;", "Lcom/didi/global/fintech/cashier/base/module/BaseGlobalCashierModule;", "()V", "syncCall", "Lorg/json/JSONObject;", "args", "version", "", "Companion", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierThreeDSModule.kt */
public final class GlobalCashierThreeDSModule extends BaseGlobalCashierModule {
    public static final String CALLBACK_SCHEME = "callback_schema";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String SUPPORT_VENDOR = "support_vendor";
    public static final String THREEDS_SDK_VERSION_NAME = "3ds_sdk_version_name";

    public String version() {
        return "0.0.1";
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/GlobalCashierThreeDSModule$Companion;", "", "()V", "CALLBACK_SCHEME", "", "SUPPORT_VENDOR", "THREEDS_SDK_VERSION_NAME", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalCashierThreeDSModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public JSONObject syncCall(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "args");
        String optString = jSONObject.optString("request");
        if (optString != null) {
            int hashCode = optString.hashCode();
            if (hashCode != -278779173) {
                if (hashCode != 181277716) {
                    if (hashCode == 1865583544 && optString.equals(SUPPORT_VENDOR)) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("response", CollectionsKt.listOf("adyen"));
                        return jSONObject2;
                    }
                } else if (optString.equals(THREEDS_SDK_VERSION_NAME)) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("response", "global.didi.pay.threeds.sdk.version");
                    return jSONObject3;
                }
            } else if (optString.equals(CALLBACK_SCHEME)) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("response", ThreeDSUtils.getCallbackUrl(ThreeDSUtils.getPackageName(CashierFacade.Companion.getInstance().getApplication())));
                return jSONObject4;
            }
        }
        return super.syncCall(jSONObject);
    }
}
