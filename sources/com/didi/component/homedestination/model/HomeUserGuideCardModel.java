package com.didi.component.homedestination.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001a\u0010\u0013\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/component/homedestination/model/HomeUserGuideCardModel;", "Ljava/io/Serializable;", "()V", "bottomAreaLeftIconResourceId", "", "getBottomAreaLeftIconResourceId", "()Ljava/lang/Integer;", "setBottomAreaLeftIconResourceId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "bottomAreaTextStr", "", "getBottomAreaTextStr", "()Ljava/lang/String;", "setBottomAreaTextStr", "(Ljava/lang/String;)V", "contentBgResourceId", "getContentBgResourceId", "setContentBgResourceId", "rightButtonStr", "getRightButtonStr", "setRightButtonStr", "title", "getTitle", "setTitle", "comp-homedestination_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeUserGuideCardModel.kt */
public final class HomeUserGuideCardModel implements Serializable {
    private Integer bottomAreaLeftIconResourceId;
    private String bottomAreaTextStr = "";
    private Integer contentBgResourceId;
    private String rightButtonStr = "";
    private String title = "";

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getRightButtonStr() {
        return this.rightButtonStr;
    }

    public final void setRightButtonStr(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rightButtonStr = str;
    }

    public final Integer getContentBgResourceId() {
        return this.contentBgResourceId;
    }

    public final void setContentBgResourceId(Integer num) {
        this.contentBgResourceId = num;
    }

    public final Integer getBottomAreaLeftIconResourceId() {
        return this.bottomAreaLeftIconResourceId;
    }

    public final void setBottomAreaLeftIconResourceId(Integer num) {
        this.bottomAreaLeftIconResourceId = num;
    }

    public final String getBottomAreaTextStr() {
        return this.bottomAreaTextStr;
    }

    public final void setBottomAreaTextStr(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bottomAreaTextStr = str;
    }
}
