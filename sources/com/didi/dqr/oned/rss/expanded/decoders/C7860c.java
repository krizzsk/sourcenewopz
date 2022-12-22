package com.didi.dqr.oned.rss.expanded.decoders;

import com.didi.dqr.FormatException;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.BitArray;
import org.osgi.framework.VersionRange;

/* renamed from: com.didi.dqr.oned.rss.expanded.decoders.c */
/* compiled from: AI01392xDecoder */
final class C7860c extends C7865h {

    /* renamed from: b */
    private static final int f18830b = 8;

    /* renamed from: c */
    private static final int f18831c = 2;

    C7860c(BitArray bitArray) {
        super(bitArray);
    }

    public String parseInformation() throws NotFoundException, FormatException {
        if (getInformation().getSize() >= 48) {
            StringBuilder sb = new StringBuilder();
            mo58434b(sb, 8);
            int a = getGeneralDecoder().mo58450a(48, 2);
            sb.append("(392");
            sb.append(a);
            sb.append(VersionRange.RIGHT_OPEN);
            sb.append(getGeneralDecoder().mo58451a(50, (String) null).mo58440a());
            return sb.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
