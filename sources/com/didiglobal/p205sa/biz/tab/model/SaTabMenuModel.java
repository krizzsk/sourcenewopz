package com.didiglobal.p205sa.biz.tab.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001e\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R \u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#¨\u0006'"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/tab/model/SaTabMenuModel;", "Ljava/io/Serializable;", "()V", "arrowStyle", "Lcom/didiglobal/sa/biz/tab/model/SaTabArrowModel;", "getArrowStyle", "()Lcom/didiglobal/sa/biz/tab/model/SaTabArrowModel;", "setArrowStyle", "(Lcom/didiglobal/sa/biz/tab/model/SaTabArrowModel;)V", "hotInfo", "Lcom/didiglobal/sa/biz/tab/model/SaTabHotInfo;", "getHotInfo", "()Lcom/didiglobal/sa/biz/tab/model/SaTabHotInfo;", "setHotInfo", "(Lcom/didiglobal/sa/biz/tab/model/SaTabHotInfo;)V", "icon", "", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "iconActive", "getIconActive", "setIconActive", "schema", "getSchema", "setSchema", "tabId", "getTabId", "setTabId", "tabName", "Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "getTabName", "()Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "setTabName", "(Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;)V", "tabNameActive", "getTabNameActive", "setTabNameActive", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.tab.model.SaTabMenuModel */
/* compiled from: SaTabMenuModel.kt */
public final class SaTabMenuModel implements Serializable {
    @SerializedName("arrowStyle")
    private SaTabArrowModel arrowStyle;
    @SerializedName("hotInfo")
    private SaTabHotInfo hotInfo;
    @SerializedName("icon")
    private String icon = "";
    @SerializedName("iconActive")
    private String iconActive = "";
    @SerializedName("schema")
    private String schema = "";
    @SerializedName("tabId")
    private String tabId = "";
    @SerializedName("tabName")
    private LEGORichInfo tabName;
    @SerializedName("tabNameActive")
    private LEGORichInfo tabNameActive;

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.icon = str;
    }

    public final String getIconActive() {
        return this.iconActive;
    }

    public final void setIconActive(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.iconActive = str;
    }

    public final String getTabId() {
        return this.tabId;
    }

    public final void setTabId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tabId = str;
    }

    public final LEGORichInfo getTabName() {
        return this.tabName;
    }

    public final void setTabName(LEGORichInfo lEGORichInfo) {
        this.tabName = lEGORichInfo;
    }

    public final LEGORichInfo getTabNameActive() {
        return this.tabNameActive;
    }

    public final void setTabNameActive(LEGORichInfo lEGORichInfo) {
        this.tabNameActive = lEGORichInfo;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final void setSchema(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.schema = str;
    }

    public final SaTabHotInfo getHotInfo() {
        return this.hotInfo;
    }

    public final void setHotInfo(SaTabHotInfo saTabHotInfo) {
        this.hotInfo = saTabHotInfo;
    }

    public final SaTabArrowModel getArrowStyle() {
        return this.arrowStyle;
    }

    public final void setArrowStyle(SaTabArrowModel saTabArrowModel) {
        this.arrowStyle = saTabArrowModel;
    }
}
