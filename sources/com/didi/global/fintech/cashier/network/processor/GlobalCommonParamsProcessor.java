package com.didi.global.fintech.cashier.network.processor;

import android.net.wifi.WifiInfo;
import com.didi.global.fintech.cashier.base.module.GlobalCashierModuleType;
import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.didi.global.fintech.cashier.model.net.request.CashierRequestCommonParams;
import com.didi.global.fintech.cashier.model.net.request.DeviceInfo;
import com.didi.global.fintech.cashier.threeds.GlobalCashierThreeDSModule;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.ICashierFacade;
import com.didi.sdk.util.SystemUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u001f\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\t\u001a\u0002H\u0007H\u0016¢\u0006\u0002\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/network/processor/GlobalCommonParamsProcessor;", "Lcom/didi/global/fintech/cashier/network/processor/IBaseCommonParamsProcessor;", "uniqueId", "", "fromType", "(Ljava/lang/String;Ljava/lang/String;)V", "process", "T", "Lcom/didi/global/fintech/cashier/model/net/request/CashierRequestCommonParams;", "param", "(Lcom/didi/global/fintech/cashier/model/net/request/CashierRequestCommonParams;)Lcom/didi/global/fintech/cashier/model/net/request/CashierRequestCommonParams;", "cashier_network_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCommonParamsProcessor.kt */
public final class GlobalCommonParamsProcessor implements IBaseCommonParamsProcessor {

    /* renamed from: a */
    private final String f21634a;

    /* renamed from: b */
    private final String f21635b;

    public GlobalCommonParamsProcessor() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public GlobalCommonParamsProcessor(String str, String str2) {
        this.f21634a = str;
        this.f21635b = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobalCommonParamsProcessor(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public <T extends CashierRequestCommonParams> T process(T t) {
        String ssid;
        Intrinsics.checkNotNullParameter(t, "param");
        String str = this.f21634a;
        if (str == null) {
            str = "-1";
        }
        t.updateUniqueId(str);
        String paramByModuleSync = CashierFacade.Companion.getInstance().getParamByModuleSync(GlobalCashierModuleType.Core, GlobalCashierCoreModule.META_DATA, ICashierFacade.DefaultImpls.getParamByModuleSync$default(CashierFacade.Companion.getInstance(), GlobalCashierModuleType.Core, GlobalCashierCoreModule.CASHIER_SDK_VERSION_NAME, (String) null, 4, (Object) null));
        if (paramByModuleSync != null) {
            t.updateSdkVersion(paramByModuleSync);
        }
        String paramByModuleSync2 = CashierFacade.Companion.getInstance().getParamByModuleSync(GlobalCashierModuleType.Core, GlobalCashierCoreModule.META_DATA, ICashierFacade.DefaultImpls.getParamByModuleSync$default(CashierFacade.Companion.getInstance(), GlobalCashierModuleType.ThreeDS, GlobalCashierThreeDSModule.THREEDS_SDK_VERSION_NAME, (String) null, 4, (Object) null));
        if (paramByModuleSync2 != null) {
            t.getThird_party_ability().update3DSSdkVersion(paramByModuleSync2);
        }
        DeviceInfo device_info = t.getDevice_info();
        String str2 = this.f21635b;
        if (str2 == null) {
            str2 = "NATIVE";
        }
        device_info.updateFromType(str2);
        String paramByModuleSync$default = ICashierFacade.DefaultImpls.getParamByModuleSync$default(CashierFacade.Companion.getInstance(), GlobalCashierModuleType.Core, GlobalCashierCoreModule.PACKAGE_NAME, (String) null, 4, (Object) null);
        if (paramByModuleSync$default != null) {
            t.getDevice_info().updateAppId(paramByModuleSync$default);
        }
        DeviceInfo device_info2 = t.getDevice_info();
        String versionName = SystemUtil.getVersionName(CashierFacade.Companion.getInstance().getApplication());
        Intrinsics.checkNotNullExpressionValue(versionName, "getVersionName(CashierFa…etInstance().application)");
        device_info2.updateAppVersion(versionName);
        DeviceInfo device_info3 = t.getDevice_info();
        WifiInfo wifiInfo = SystemUtil.getWifiInfo(CashierFacade.Companion.getInstance().getApplication());
        String str3 = "";
        if (!(wifiInfo == null || (ssid = wifiInfo.getSSID()) == null)) {
            str3 = ssid;
        }
        device_info3.setSsid(str3);
        return t;
    }
}
