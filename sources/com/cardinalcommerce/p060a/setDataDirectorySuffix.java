package com.cardinalcommerce.p060a;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.Serializable;
import kotlin.text.Typography;

/* renamed from: com.cardinalcommerce.a.setDataDirectorySuffix */
public final class setDataDirectorySuffix implements setMotionEventSplittingEnabled, Serializable {
    private final String Cardinal;

    static {
        new setDataDirectorySuffix("JOSE");
        new setDataDirectorySuffix("JOSE+JSON");
        new setDataDirectorySuffix("JWT");
    }

    public setDataDirectorySuffix(String str) {
        if (str != null) {
            this.Cardinal = str;
            return;
        }
        throw new IllegalArgumentException("The object type must not be null");
    }

    public final int hashCode() {
        return this.Cardinal.toLowerCase().hashCode();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof setDataDirectorySuffix) && this.Cardinal.toLowerCase().equals(((setDataDirectorySuffix) obj).Cardinal.toLowerCase());
    }

    public final String toString() {
        return this.Cardinal;
    }

    public final String configure() {
        StringBuilder sb = new StringBuilder(Const.jsQuote);
        sb.append(setLayoutTransition.cca_continue(this.Cardinal));
        sb.append(Typography.quote);
        return sb.toString();
    }
}
