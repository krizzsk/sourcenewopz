package com.cardinalcommerce.p060a;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.Serializable;
import kotlin.text.Typography;

/* renamed from: com.cardinalcommerce.a.setPictureListener */
public final class setPictureListener implements setMotionEventSplittingEnabled, Serializable {
    public static final setPictureListener Cardinal = new setPictureListener("DEF");
    private final String getInstance;

    public setPictureListener(String str) {
        if (str != null) {
            this.getInstance = str;
            return;
        }
        throw new IllegalArgumentException("The compression algorithm name must not be null");
    }

    public final int hashCode() {
        return this.getInstance.hashCode();
    }

    public final boolean equals(Object obj) {
        return obj != null && (obj instanceof setPictureListener) && toString().equals(obj.toString());
    }

    public final String toString() {
        return this.getInstance;
    }

    public final String configure() {
        StringBuilder sb = new StringBuilder(Const.jsQuote);
        sb.append(setLayoutTransition.cca_continue(this.getInstance));
        sb.append(Typography.quote);
        return sb.toString();
    }
}
