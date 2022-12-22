package com.didi.dqr.oned.rss.expanded.decoders;

import com.didi.dqr.FormatException;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.BitArray;

/* renamed from: com.didi.dqr.oned.rss.expanded.decoders.j */
/* compiled from: AnyAIDecoder */
final class C7867j extends AbstractExpandedDecoder {

    /* renamed from: a */
    private static final int f18844a = 5;

    C7867j(BitArray bitArray) {
        super(bitArray);
    }

    public String parseInformation() throws NotFoundException, FormatException {
        return getGeneralDecoder().mo58452a(new StringBuilder(), 5);
    }
}
