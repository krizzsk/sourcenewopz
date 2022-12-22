package com.cardinalcommerce.p060a;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Objects;

/* renamed from: com.cardinalcommerce.a.setVerticalGravity */
public final class setVerticalGravity implements Serializable {
    public static final setVerticalGravity getInstance = new setVerticalGravity("enc");
    public static final setVerticalGravity init = new setVerticalGravity("sig");
    public final String configure;

    private setVerticalGravity(String str) {
        if (str != null) {
            this.configure = str;
            return;
        }
        throw new IllegalArgumentException("The key use identifier must not be null");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof setVerticalGravity)) {
            return false;
        }
        return Objects.equals(this.configure, ((setVerticalGravity) obj).configure);
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.configure});
    }

    public static setVerticalGravity Cardinal(String str) throws ParseException {
        if (str == null) {
            return null;
        }
        if (str.equals(init.configure)) {
            return init;
        }
        if (str.equals(getInstance.configure)) {
            return getInstance;
        }
        if (!str.trim().isEmpty()) {
            return new setVerticalGravity(str);
        }
        throw new ParseException("JWK use value must not be empty or blank", 0);
    }

    public final String toString() {
        return this.configure;
    }
}
