package com.didi.dqr.oned.rss.expanded.decoders;

import com.didi.dqr.FormatException;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.BitArray;
import com.didichuxing.diface.logger.DiFaceLogger;

public abstract class AbstractExpandedDecoder {

    /* renamed from: a */
    private final BitArray f18826a;

    /* renamed from: b */
    private final C7874q f18827b;

    public abstract String parseInformation() throws NotFoundException, FormatException;

    AbstractExpandedDecoder(BitArray bitArray) {
        this.f18826a = bitArray;
        this.f18827b = new C7874q(bitArray);
    }

    /* access modifiers changed from: protected */
    public final BitArray getInformation() {
        return this.f18826a;
    }

    /* access modifiers changed from: protected */
    public final C7874q getGeneralDecoder() {
        return this.f18827b;
    }

    public static AbstractExpandedDecoder createDecoder(BitArray bitArray) {
        if (bitArray.get(1)) {
            return new C7864g(bitArray);
        }
        if (!bitArray.get(2)) {
            return new C7867j(bitArray);
        }
        int a = C7874q.m14020a(bitArray, 1, 4);
        if (a == 4) {
            return new C7858a(bitArray);
        }
        if (a == 5) {
            return new C7859b(bitArray);
        }
        int a2 = C7874q.m14020a(bitArray, 1, 5);
        if (a2 == 12) {
            return new C7860c(bitArray);
        }
        if (a2 == 13) {
            return new C7861d(bitArray);
        }
        switch (C7874q.m14020a(bitArray, 1, 7)) {
            case 56:
                return new C7862e(bitArray, "310", "11");
            case 57:
                return new C7862e(bitArray, "320", "11");
            case 58:
                return new C7862e(bitArray, "310", DiFaceLogger.EVENT_ID_BIOASSAY_ACTION_SUCCESS);
            case 59:
                return new C7862e(bitArray, "320", DiFaceLogger.EVENT_ID_BIOASSAY_ACTION_SUCCESS);
            case 60:
                return new C7862e(bitArray, "310", DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH);
            case 61:
                return new C7862e(bitArray, "320", DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH);
            case 62:
                return new C7862e(bitArray, "310", DiFaceLogger.EVENT_ID_BIOASSAY_EXIT);
            case 63:
                return new C7862e(bitArray, "320", DiFaceLogger.EVENT_ID_BIOASSAY_EXIT);
            default:
                throw new IllegalStateException("unknown decoder: " + bitArray);
        }
    }
}
