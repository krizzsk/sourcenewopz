package com.didi.sdk.p146ad.model;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/sdk/ad/model/AdConfigItem;", "Ljava/io/Serializable;", "()V", "ddlType", "", "getDdlType", "()Ljava/lang/String;", "setDdlType", "(Ljava/lang/String;)V", "isForceSkipDefaultIndexCheck", "", "()I", "setForceSkipDefaultIndexCheck", "(I)V", "isNeedTopBanner", "setNeedTopBanner", "landingPageLink", "getLandingPageLink", "setLandingPageLink", "isInvalidUrl", "", "needSkipIndexPage", "needWaitTopBanner", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.sdk.ad.model.AdConfigItem */
/* compiled from: AdConfigItem.kt */
public final class AdConfigItem implements Serializable {
    private String ddlType = "";
    @SerializedName("isForceSkipDefaultIndexCheck")
    private int isForceSkipDefaultIndexCheck;
    @SerializedName("isNeedTopBanner")
    private int isNeedTopBanner;
    @SerializedName("landingPageLink")
    private String landingPageLink = "";

    public final String getLandingPageLink() {
        return this.landingPageLink;
    }

    public final void setLandingPageLink(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.landingPageLink = str;
    }

    public final int isNeedTopBanner() {
        return this.isNeedTopBanner;
    }

    public final void setNeedTopBanner(int i) {
        this.isNeedTopBanner = i;
    }

    public final int isForceSkipDefaultIndexCheck() {
        return this.isForceSkipDefaultIndexCheck;
    }

    public final void setForceSkipDefaultIndexCheck(int i) {
        this.isForceSkipDefaultIndexCheck = i;
    }

    public final boolean needWaitTopBanner() {
        return this.isNeedTopBanner == 1;
    }

    public final boolean isInvalidUrl() {
        return TextUtils.isEmpty(this.landingPageLink);
    }

    public final boolean needSkipIndexPage() {
        return this.isForceSkipDefaultIndexCheck == 1;
    }

    public final String getDdlType() {
        return this.ddlType;
    }

    public final void setDdlType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ddlType = str;
    }
}
