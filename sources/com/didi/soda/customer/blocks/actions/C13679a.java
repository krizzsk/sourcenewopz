package com.didi.soda.customer.blocks.actions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/actions/ConditionBean;", "", "()V", "condition", "", "getCondition", "()Ljava/lang/String;", "setCondition", "(Ljava/lang/String;)V", "leftValue", "getLeftValue", "setLeftValue", "rightValue", "getRightValue", "setRightValue", "run", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.blocks.actions.a */
/* compiled from: ConditionAction.kt */
final class C13679a {

    /* renamed from: a */
    private String f40553a;

    /* renamed from: b */
    private String f40554b = "";

    /* renamed from: c */
    private String f40555c = "";

    /* renamed from: a */
    public final String mo102308a() {
        return this.f40553a;
    }

    /* renamed from: a */
    public final void mo102309a(String str) {
        this.f40553a = str;
    }

    /* renamed from: b */
    public final String mo102310b() {
        return this.f40554b;
    }

    /* renamed from: b */
    public final void mo102311b(String str) {
        this.f40554b = str;
    }

    /* renamed from: c */
    public final String mo102312c() {
        return this.f40555c;
    }

    /* renamed from: c */
    public final void mo102313c(String str) {
        this.f40555c = str;
    }

    /* renamed from: d */
    public final boolean mo102314d() {
        if (Intrinsics.areEqual((Object) this.f40553a, (Object) "=")) {
            return Intrinsics.areEqual((Object) this.f40554b, (Object) this.f40555c);
        }
        return false;
    }
}
