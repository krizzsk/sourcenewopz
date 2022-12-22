package com.ddmap.sdk.degrade.gnav.crashrule;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/ddmap/sdk/degrade/gnav/crashrule/ContinuousCrashRule;", "Lcom/ddmap/sdk/degrade/gnav/crashrule/ICrashRule;", "", "counts", "(I)V", "mConsecutiveCounts", "needDegrade", "", "t", "Degrade_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: ContinuousCrashRule.kt */
public final class ContinuousCrashRule implements ICrashRule<Integer> {

    /* renamed from: a */
    private int f4299a;

    public ContinuousCrashRule(int i) {
        this.f4299a = i;
    }

    public /* synthetic */ boolean needDegrade(Object obj) {
        return needDegrade(((Number) obj).intValue());
    }

    public boolean needDegrade(int i) {
        int i2 = this.f4299a;
        return i2 > 0 && i >= i2;
    }
}
