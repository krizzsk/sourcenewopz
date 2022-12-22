package com.didi.component.savingcenter;

import com.android.didi.bfflib.business.BffBaseObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/component/savingcenter/SavingCenterInfoWrapper;", "Lcom/android/didi/bfflib/business/BffBaseObject;", "()V", "data", "Lcom/didi/component/savingcenter/SavingCenterInfoData;", "getData", "()Lcom/didi/component/savingcenter/SavingCenterInfoData;", "setData", "(Lcom/didi/component/savingcenter/SavingCenterInfoData;)V", "comp-savingcenter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SavingCenterInfoWrapper.kt */
public final class SavingCenterInfoWrapper extends BffBaseObject {
    @SerializedName("passenger_saving_center")
    private SavingCenterInfoData data;

    public final SavingCenterInfoData getData() {
        return this.data;
    }

    public final void setData(SavingCenterInfoData savingCenterInfoData) {
        this.data = savingCenterInfoData;
    }
}
