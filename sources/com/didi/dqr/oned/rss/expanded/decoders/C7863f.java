package com.didi.dqr.oned.rss.expanded.decoders;

import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.BitArray;

/* renamed from: com.didi.dqr.oned.rss.expanded.decoders.f */
/* compiled from: AI013x0xDecoder */
abstract class C7863f extends C7866i {

    /* renamed from: b */
    private static final int f18840b = 5;

    /* renamed from: c */
    private static final int f18841c = 15;

    C7863f(BitArray bitArray) {
        super(bitArray);
    }

    public String parseInformation() throws NotFoundException {
        if (getInformation().getSize() == 60) {
            StringBuilder sb = new StringBuilder();
            mo58434b(sb, 5);
            mo58435b(sb, 45, 15);
            return sb.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
