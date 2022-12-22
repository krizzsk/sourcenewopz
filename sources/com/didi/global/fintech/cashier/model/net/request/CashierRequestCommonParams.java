package com.didi.global.fintech.cashier.model.net.request;

import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0004R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/CashierRequestCommonParams;", "Ljava/io/Serializable;", "()V", "cashier_sdk_version", "", "getCashier_sdk_version", "()Ljava/lang/String;", "setCashier_sdk_version", "(Ljava/lang/String;)V", "cashier_unique_id", "getCashier_unique_id", "setCashier_unique_id", "device_info", "Lcom/didi/global/fintech/cashier/model/net/request/DeviceInfo;", "getDevice_info", "()Lcom/didi/global/fintech/cashier/model/net/request/DeviceInfo;", "setDevice_info", "(Lcom/didi/global/fintech/cashier/model/net/request/DeviceInfo;)V", "third_party_ability", "Lcom/didi/global/fintech/cashier/model/net/request/ThirdPartyAbility;", "getThird_party_ability", "()Lcom/didi/global/fintech/cashier/model/net/request/ThirdPartyAbility;", "setThird_party_ability", "(Lcom/didi/global/fintech/cashier/model/net/request/ThirdPartyAbility;)V", "ticket", "getTicket", "setTicket", "updateSdkVersion", "version", "updateUniqueId", "id", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CashierRequestCommonParams.kt */
public class CashierRequestCommonParams implements Serializable {
    @SerializedName("cashier_sdk_version")
    private String cashier_sdk_version = "1";
    @SerializedName("cashier_unique_id")
    private String cashier_unique_id = "temp holder";
    @SerializedName("device_info")
    private DeviceInfo device_info = new DeviceInfo((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 32767, (DefaultConstructorMarker) null);
    @SerializedName("third_party_ability")
    private ThirdPartyAbility third_party_ability = new ThirdPartyAbility((String) null, 1, (DefaultConstructorMarker) null);
    @SerializedName("ticket")
    private String ticket = CashierFacade.Companion.getInstance().getInitConfig().getToken();

    public CashierRequestCommonParams() {
    }

    public final String getCashier_unique_id() {
        return this.cashier_unique_id;
    }

    public final void setCashier_unique_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cashier_unique_id = str;
    }

    public final String getCashier_sdk_version() {
        return this.cashier_sdk_version;
    }

    public final void setCashier_sdk_version(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cashier_sdk_version = str;
    }

    public final DeviceInfo getDevice_info() {
        return this.device_info;
    }

    public final void setDevice_info(DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "<set-?>");
        this.device_info = deviceInfo;
    }

    public final ThirdPartyAbility getThird_party_ability() {
        return this.third_party_ability;
    }

    public final void setThird_party_ability(ThirdPartyAbility thirdPartyAbility) {
        Intrinsics.checkNotNullParameter(thirdPartyAbility, "<set-?>");
        this.third_party_ability = thirdPartyAbility;
    }

    public final String getTicket() {
        return this.ticket;
    }

    public final void setTicket(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ticket = str;
    }

    public final CashierRequestCommonParams updateUniqueId(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        CashierRequestCommonParams cashierRequestCommonParams = this;
        cashierRequestCommonParams.setCashier_unique_id(str);
        return cashierRequestCommonParams;
    }

    public final CashierRequestCommonParams updateSdkVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "version");
        CashierRequestCommonParams cashierRequestCommonParams = this;
        cashierRequestCommonParams.setCashier_sdk_version(str);
        return cashierRequestCommonParams;
    }
}
