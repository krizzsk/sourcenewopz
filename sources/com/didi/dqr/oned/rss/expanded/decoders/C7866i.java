package com.didi.dqr.oned.rss.expanded.decoders;

import com.didi.dqr.common.BitArray;

/* renamed from: com.didi.dqr.oned.rss.expanded.decoders.i */
/* compiled from: AI01weightDecoder */
abstract class C7866i extends C7865h {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo58431a(int i);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo58432a(StringBuilder sb, int i);

    C7866i(BitArray bitArray) {
        super(bitArray);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo58435b(StringBuilder sb, int i, int i2) {
        int a = getGeneralDecoder().mo58450a(i, i2);
        mo58432a(sb, a);
        int a2 = mo58431a(a);
        int i3 = 100000;
        for (int i4 = 0; i4 < 5; i4++) {
            if (a2 / i3 == 0) {
                sb.append('0');
            }
            i3 /= 10;
        }
        sb.append(a2);
    }
}
