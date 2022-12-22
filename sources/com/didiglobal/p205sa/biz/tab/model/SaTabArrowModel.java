package com.didiglobal.p205sa.biz.tab.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/tab/model/SaTabArrowModel;", "Ljava/io/Serializable;", "()V", "icon", "", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "text", "Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "getText", "()Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "setText", "(Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;)V", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.tab.model.SaTabArrowModel */
/* compiled from: SaTabArrowModel.kt */
public final class SaTabArrowModel implements Serializable {
    @SerializedName("icon")
    private String icon = "";
    @SerializedName("text")
    private LEGORichInfo text;

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.icon = str;
    }

    public final LEGORichInfo getText() {
        return this.text;
    }

    public final void setText(LEGORichInfo lEGORichInfo) {
        this.text = lEGORichInfo;
    }
}
