package com.global.didi.elvish.language;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, mo175978d2 = {"Lcom/global/didi/elvish/language/SupportLanguageItemModel;", "Ljava/io/Serializable;", "()V", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: SupportLanguageItemModel.kt */
public final class SupportLanguageItemModel implements Serializable {
    @SerializedName("lang")
    private String lang = "";

    public final String getLang() {
        return this.lang;
    }

    public final void setLang(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.lang = str;
    }
}
