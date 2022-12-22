package com.didi.global.fintech.cashier.core;

import com.didi.global.fintech.cashier.base.module.BaseGlobalCashierModule;
import com.didi.global.fintech.cashier.core.utils.CashierAppUtils;
import com.didi.global.fintech.cashier.core.utils.GlobalCashierApolloUtils;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/GlobalCashierCoreModule;", "Lcom/didi/global/fintech/cashier/base/module/BaseGlobalCashierModule;", "()V", "syncCall", "Lorg/json/JSONObject;", "args", "version", "", "Companion", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierCoreModule.kt */
public final class GlobalCashierCoreModule extends BaseGlobalCashierModule {
    public static final String APOLLO = "apollo";
    public static final String APP_NAME = "app_name";
    public static final String CASHIER_SDK_VERSION_NAME = "cashier_sdk_version_name";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String META_DATA = "meta_data";
    public static final String PACKAGE_NAME = "package_name";

    public String version() {
        return "0.0.1";
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/GlobalCashierCoreModule$Companion;", "", "()V", "APOLLO", "", "APP_NAME", "CASHIER_SDK_VERSION_NAME", "META_DATA", "PACKAGE_NAME", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalCashierCoreModule.kt */
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
            boolean z = false;
            switch (optString.hashCode()) {
                case -1877165340:
                    if (optString.equals(PACKAGE_NAME)) {
                        BaseGlobalCashierModule.Companion companion = BaseGlobalCashierModule.Companion;
                        String packageName = CashierAppUtils.INSTANCE.getPackageName(CashierFacade.Companion.getInstance().getApplication());
                        if (packageName == null) {
                            packageName = "unknown";
                        }
                        return companion.response(packageName);
                    }
                    break;
                case -1411091249:
                    if (optString.equals(APOLLO)) {
                        return BaseGlobalCashierModule.Companion.response(String.valueOf(GlobalCashierApolloUtils.INSTANCE.getStatus(jSONObject.optString(BaseGlobalCashierModule.ARGS), false)));
                    }
                    break;
                case -1069773404:
                    if (optString.equals(META_DATA)) {
                        String optString2 = jSONObject.optString(BaseGlobalCashierModule.ARGS);
                        Intrinsics.checkNotNullExpressionValue(optString2, "args.optString(ARGS)");
                        if (optString2.length() > 0) {
                            z = true;
                        }
                        if (!z) {
                            return super.syncCall(jSONObject);
                        }
                        BaseGlobalCashierModule.Companion companion2 = BaseGlobalCashierModule.Companion;
                        String optString3 = jSONObject.optString(BaseGlobalCashierModule.ARGS);
                        Intrinsics.checkNotNullExpressionValue(optString3, "args.optString(ARGS)");
                        return companion2.response(CashierAppUtils.INSTANCE.getMetaDataByKey(CashierFacade.Companion.getInstance().getApplication(), optString3));
                    }
                    break;
                case 228962163:
                    if (optString.equals(CASHIER_SDK_VERSION_NAME)) {
                        return BaseGlobalCashierModule.Companion.response("com.didi.global.fintech.cashier.version");
                    }
                    break;
                case 1167648233:
                    if (optString.equals("app_name")) {
                        return BaseGlobalCashierModule.Companion.response(CashierAppUtils.INSTANCE.getAppName(CashierFacade.Companion.getInstance().getApplication()));
                    }
                    break;
            }
        }
        return super.syncCall(jSONObject);
    }
}
