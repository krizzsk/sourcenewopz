package com.didi.soda.customer.p165h5;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/customer/h5/WebMessage;", "", "type", "", "data", "(ILjava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "getType", "()I", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.h5.WebMessage */
/* compiled from: WebMessageRepo.kt */
public final class WebMessage {

    /* renamed from: a */
    private final int f41308a;

    /* renamed from: b */
    private final Object f41309b;

    public WebMessage() {
        this(0, (Object) null, 3, (DefaultConstructorMarker) null);
    }

    public WebMessage(int i, Object obj) {
        this.f41308a = i;
        this.f41309b = obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WebMessage(int i, Object obj, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : obj);
    }

    public final int getType() {
        return this.f41308a;
    }

    public final Object getData() {
        return this.f41309b;
    }
}
