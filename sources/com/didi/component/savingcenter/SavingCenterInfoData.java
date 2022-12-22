package com.didi.component.savingcenter;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/component/savingcenter/SavingCenterInfoData;", "Lcom/android/didi/bfflib/business/BffGsonStruct;", "()V", "scInfo", "Lcom/didi/component/savingcenter/SavingCenterInfo;", "getScInfo", "()Lcom/didi/component/savingcenter/SavingCenterInfo;", "setScInfo", "(Lcom/didi/component/savingcenter/SavingCenterInfo;)V", "comp-savingcenter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SavingCenterInfoData.kt */
public final class SavingCenterInfoData implements BffGsonStruct {
    @SerializedName("data")
    private SavingCenterInfo scInfo;

    public Object clone() {
        return super.clone();
    }

    public final SavingCenterInfo getScInfo() {
        return this.scInfo;
    }

    public final void setScInfo(SavingCenterInfo savingCenterInfo) {
        this.scInfo = savingCenterInfo;
    }
}
