package com.didi.component.savingcenter;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/component/savingcenter/SavingCenterInfo;", "Lcom/android/didi/bfflib/business/BffGsonStruct;", "()V", "scH5Uri", "", "getScH5Uri", "()Ljava/lang/String;", "setScH5Uri", "(Ljava/lang/String;)V", "scIconUri", "getScIconUri", "setScIconUri", "scShowTime", "", "getScShowTime", "()Ljava/lang/Integer;", "setScShowTime", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "scSideText", "Lcom/didi/travel/psnger/model/response/GlobalRichInfo;", "getScSideText", "()Lcom/didi/travel/psnger/model/response/GlobalRichInfo;", "setScSideText", "(Lcom/didi/travel/psnger/model/response/GlobalRichInfo;)V", "scSubModle", "getScSubModle", "setScSubModle", "comp-savingcenter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SavingCenterInfo.kt */
public final class SavingCenterInfo implements BffGsonStruct {
    @SerializedName("sc_h5_uri")
    private String scH5Uri;
    @SerializedName("sc_icon_uri")
    private String scIconUri;
    @SerializedName("sc_show_time")
    private Integer scShowTime;
    @SerializedName("sc_side_text_rich")
    private GlobalRichInfo scSideText;
    @SerializedName("subModule")
    private String scSubModle;

    public Object clone() {
        return super.clone();
    }

    public final String getScIconUri() {
        return this.scIconUri;
    }

    public final void setScIconUri(String str) {
        this.scIconUri = str;
    }

    public final String getScH5Uri() {
        return this.scH5Uri;
    }

    public final void setScH5Uri(String str) {
        this.scH5Uri = str;
    }

    public final Integer getScShowTime() {
        return this.scShowTime;
    }

    public final void setScShowTime(Integer num) {
        this.scShowTime = num;
    }

    public final GlobalRichInfo getScSideText() {
        return this.scSideText;
    }

    public final void setScSideText(GlobalRichInfo globalRichInfo) {
        this.scSideText = globalRichInfo;
    }

    public final String getScSubModle() {
        return this.scSubModle;
    }

    public final void setScSubModle(String str) {
        this.scSubModle = str;
    }
}
