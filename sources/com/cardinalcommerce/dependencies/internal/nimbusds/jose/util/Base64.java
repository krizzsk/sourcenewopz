package com.cardinalcommerce.dependencies.internal.nimbusds.jose.util;

import com.cardinalcommerce.p060a.setAddStatesFromChildren;
import com.cardinalcommerce.p060a.setIndeterminateTintList;
import com.cardinalcommerce.p060a.setMotionEventSplittingEnabled;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.Serializable;

public class Base64 implements setMotionEventSplittingEnabled, Serializable {
    private final String configure;

    public Base64(String str) {
        if (str != null) {
            this.configure = str;
            return;
        }
        throw new IllegalArgumentException("The Base64 value must not be null");
    }

    public final byte[] cca_continue() {
        return setIndeterminateTintList.getInstance(this.configure);
    }

    public final String configure() {
        StringBuilder sb = new StringBuilder(Const.jsQuote);
        sb.append(setAddStatesFromChildren.configure(this.configure));
        sb.append(Const.jsQuote);
        return sb.toString();
    }

    public String toString() {
        return this.configure;
    }

    public int hashCode() {
        return this.configure.hashCode();
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof Base64) && toString().equals(obj.toString());
    }
}
