package com.didi.dqr.oned.rss.expanded.decoders;

import com.didi.dqr.FormatException;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.BitArray;

/* renamed from: com.didi.dqr.oned.rss.expanded.decoders.g */
/* compiled from: AI01AndOtherAIs */
final class C7864g extends C7865h {

    /* renamed from: b */
    private static final int f18842b = 4;

    C7864g(BitArray bitArray) {
        super(bitArray);
    }

    public String parseInformation() throws NotFoundException, FormatException {
        StringBuilder sb = new StringBuilder();
        sb.append("(01)");
        int length = sb.length();
        sb.append(getGeneralDecoder().mo58450a(4, 4));
        mo58433a(sb, 8, length);
        return getGeneralDecoder().mo58452a(sb, 48);
    }
}
