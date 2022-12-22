package com.didi.dqr.oned.rss.expanded.decoders;

import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.BitArray;
import org.osgi.framework.VersionRange;

/* renamed from: com.didi.dqr.oned.rss.expanded.decoders.e */
/* compiled from: AI013x0x1xDecoder */
final class C7862e extends C7866i {

    /* renamed from: b */
    private static final int f18835b = 8;

    /* renamed from: c */
    private static final int f18836c = 20;

    /* renamed from: d */
    private static final int f18837d = 16;

    /* renamed from: e */
    private final String f18838e;

    /* renamed from: f */
    private final String f18839f;

    C7862e(BitArray bitArray, String str, String str2) {
        super(bitArray);
        this.f18838e = str2;
        this.f18839f = str;
    }

    public String parseInformation() throws NotFoundException {
        if (getInformation().getSize() == 84) {
            StringBuilder sb = new StringBuilder();
            mo58434b(sb, 8);
            mo58435b(sb, 48, 20);
            m13994c(sb, 68);
            return sb.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* renamed from: c */
    private void m13994c(StringBuilder sb, int i) {
        int a = getGeneralDecoder().mo58450a(i, 16);
        if (a != 38400) {
            sb.append(VersionRange.LEFT_OPEN);
            sb.append(this.f18838e);
            sb.append(VersionRange.RIGHT_OPEN);
            int i2 = a % 32;
            int i3 = a / 32;
            int i4 = (i3 % 12) + 1;
            int i5 = i3 / 12;
            if (i5 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i5);
            if (i4 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i4);
            if (i2 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo58432a(StringBuilder sb, int i) {
        sb.append(VersionRange.LEFT_OPEN);
        sb.append(this.f18839f);
        sb.append(i / 100000);
        sb.append(VersionRange.RIGHT_OPEN);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo58431a(int i) {
        return i % 100000;
    }
}
