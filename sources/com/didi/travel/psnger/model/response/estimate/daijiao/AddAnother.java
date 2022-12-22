package com.didi.travel.psnger.model.response.estimate.daijiao;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/travel/psnger/model/response/estimate/daijiao/AddAnother;", "Lcom/android/didi/bfflib/business/BffGsonStruct;", "()V", "canAdd", "", "getCanAdd", "()I", "setCanAdd", "(I)V", "icon", "", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "title", "Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "getTitle", "()Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "setTitle", "(Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;)V", "tebridge_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SubstituteCallModel.kt */
public final class AddAnother implements BffGsonStruct {
    @SerializedName("can_add")
    private int canAdd;
    private String icon;
    private LEGORichInfo title;

    public Object clone() {
        return super.clone();
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final LEGORichInfo getTitle() {
        return this.title;
    }

    public final void setTitle(LEGORichInfo lEGORichInfo) {
        this.title = lEGORichInfo;
    }

    public final int getCanAdd() {
        return this.canAdd;
    }

    public final void setCanAdd(int i) {
        this.canAdd = i;
    }
}
