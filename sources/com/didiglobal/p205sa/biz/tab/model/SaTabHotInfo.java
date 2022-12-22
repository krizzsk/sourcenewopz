package com.didiglobal.p205sa.biz.tab.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/tab/model/SaTabHotInfo;", "Ljava/io/Serializable;", "()V", "hideAfterActived", "", "getHideAfterActived", "()I", "setHideAfterActived", "(I)V", "hideAfterShown", "getHideAfterShown", "setHideAfterShown", "hotShowType", "getHotShowType", "setHotShowType", "hotUrl", "", "getHotUrl", "()Ljava/lang/String;", "setHotUrl", "(Ljava/lang/String;)V", "md5", "getMd5", "setMd5", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.tab.model.SaTabHotInfo */
/* compiled from: SaTabHotInfo.kt */
public final class SaTabHotInfo implements Serializable {
    @SerializedName("hideAfterActived")
    private int hideAfterActived;
    @SerializedName("hideAfterShown")
    private int hideAfterShown;
    @SerializedName("hotShowType")
    private int hotShowType;
    @SerializedName("hotUrl")
    private String hotUrl = "";
    @SerializedName("md5")
    private String md5 = "";

    public final String getMd5() {
        return this.md5;
    }

    public final void setMd5(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.md5 = str;
    }

    public final int getHideAfterActived() {
        return this.hideAfterActived;
    }

    public final void setHideAfterActived(int i) {
        this.hideAfterActived = i;
    }

    public final int getHideAfterShown() {
        return this.hideAfterShown;
    }

    public final void setHideAfterShown(int i) {
        this.hideAfterShown = i;
    }

    public final int getHotShowType() {
        return this.hotShowType;
    }

    public final void setHotShowType(int i) {
        this.hotShowType = i;
    }

    public final String getHotUrl() {
        return this.hotUrl;
    }

    public final void setHotUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.hotUrl = str;
    }
}
