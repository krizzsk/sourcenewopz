package com.didi.beatles.p099im.protocol.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, mo175978d2 = {"Lcom/didi/beatles/im/protocol/model/IMMoreActionNetControlItem;", "", "isNetControl", "", "pluginId", "", "(ZI)V", "()Z", "getPluginId", "()I", "im_protocol_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didi.beatles.im.protocol.model.IMMoreActionNetControlItem */
/* compiled from: IMMoreActionNetControlItem.kt */
public final class IMMoreActionNetControlItem {

    /* renamed from: a */
    private final boolean f9569a;

    /* renamed from: b */
    private final int f9570b;

    public IMMoreActionNetControlItem() {
        this(false, 0, 3, (DefaultConstructorMarker) null);
    }

    public IMMoreActionNetControlItem(boolean z, int i) {
        this.f9569a = z;
        this.f9570b = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IMMoreActionNetControlItem(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? -1 : i);
    }

    public final int getPluginId() {
        return this.f9570b;
    }

    public final boolean isNetControl() {
        return this.f9569a;
    }
}
