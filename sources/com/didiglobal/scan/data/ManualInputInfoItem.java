package com.didiglobal.scan.data;

import com.google.gson.annotations.SerializedName;
import com.taxis99.R;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001b"}, mo175978d2 = {"Lcom/didiglobal/scan/data/ManualInputInfoItem;", "Ljava/io/Serializable;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "setActionType", "(Ljava/lang/String;)V", "enableEntrance", "", "getEnableEntrance", "()Z", "setEnableEntrance", "(Z)V", "entranceIcon", "", "getEntranceIcon", "()I", "setEntranceIcon", "(I)V", "scheme", "getScheme", "setScheme", "title", "getTitle", "setTitle", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ManualInputInfoItem.kt */
public final class ManualInputInfoItem implements Serializable {
    @SerializedName("action_type")
    private String actionType = "";
    @SerializedName("enable_entrance")
    private boolean enableEntrance = true;
    @SerializedName("entrance_icon")
    private int entranceIcon = R.drawable.global_icon_scan_enter_pin;
    @SerializedName("scheme")
    private String scheme = "";
    @SerializedName("title")
    private String title = "";

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.title = str;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final void setScheme(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.scheme = str;
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final void setActionType(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.actionType = str;
    }

    public final boolean getEnableEntrance() {
        return this.enableEntrance;
    }

    public final void setEnableEntrance(boolean z) {
        this.enableEntrance = z;
    }

    public final int getEntranceIcon() {
        return this.entranceIcon;
    }

    public final void setEntranceIcon(int i) {
        this.entranceIcon = i;
    }
}
