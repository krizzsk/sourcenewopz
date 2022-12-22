package com.didi.sdk.debug.language;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/sdk/debug/language/LanguageModel;", "", "()V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleAction", "Lkotlin/Function1;", "", "getTitleAction", "()Lkotlin/jvm/functions/Function1;", "setTitleAction", "(Lkotlin/jvm/functions/Function1;)V", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LanguageModel.kt */
public final class LanguageModel {

    /* renamed from: a */
    private String f35806a = "";

    /* renamed from: b */
    private Function1<? super String, Unit> f35807b;

    public final String getTitle() {
        return this.f35806a;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f35806a = str;
    }

    public final Function1<String, Unit> getTitleAction() {
        return this.f35807b;
    }

    public final void setTitleAction(Function1<? super String, Unit> function1) {
        this.f35807b = function1;
    }
}
