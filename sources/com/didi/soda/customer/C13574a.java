package com.didi.soda.customer;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/soda/customer/DirectionInfo;", "", "isDirectOpen", "", "addressInfo", "", "(ZLjava/lang/String;)V", "getAddressInfo", "()Ljava/lang/String;", "setAddressInfo", "(Ljava/lang/String;)V", "()Z", "setDirectOpen", "(Z)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.a */
/* compiled from: CustomerSABusiness.kt */
final class C13574a {

    /* renamed from: a */
    private boolean f40287a;

    /* renamed from: b */
    private String f40288b;

    public C13574a() {
        this(false, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public C13574a(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "addressInfo");
        this.f40287a = z;
        this.f40288b = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C13574a(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str);
    }

    /* renamed from: a */
    public final void mo101685a(boolean z) {
        this.f40287a = z;
    }

    /* renamed from: a */
    public final boolean mo101686a() {
        return this.f40287a;
    }

    /* renamed from: a */
    public final void mo101684a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f40288b = str;
    }

    /* renamed from: b */
    public final String mo101687b() {
        return this.f40288b;
    }
}
