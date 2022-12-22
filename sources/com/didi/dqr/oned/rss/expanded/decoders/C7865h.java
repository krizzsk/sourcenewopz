package com.didi.dqr.oned.rss.expanded.decoders;

import com.didi.dqr.common.BitArray;

/* renamed from: com.didi.dqr.oned.rss.expanded.decoders.h */
/* compiled from: AI01decoder */
abstract class C7865h extends AbstractExpandedDecoder {

    /* renamed from: a */
    static final int f18843a = 40;

    C7865h(BitArray bitArray) {
        super(bitArray);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo58434b(StringBuilder sb, int i) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        mo58433a(sb, i, length);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo58433a(StringBuilder sb, int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            int a = getGeneralDecoder().mo58450a((i3 * 10) + i, 10);
            if (a / 100 == 0) {
                sb.append('0');
            }
            if (a / 10 == 0) {
                sb.append('0');
            }
            sb.append(a);
        }
        mo58432a(sb, i2);
    }

    /* renamed from: a */
    private static void mo58432a(StringBuilder sb, int i) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 13; i4++) {
            int charAt = sb.charAt(i4 + i) - '0';
            if ((i4 & 1) == 0) {
                charAt *= 3;
            }
            i3 += charAt;
        }
        int i5 = 10 - (i3 % 10);
        if (i5 != 10) {
            i2 = i5;
        }
        sb.append(i2);
    }
}
