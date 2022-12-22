package com.cardinalcommerce.p060a;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.Serializable;
import kotlin.text.Typography;

/* renamed from: com.cardinalcommerce.a.setBaselineAlignedChildIndex */
public final class setBaselineAlignedChildIndex implements setMotionEventSplittingEnabled, Serializable {
    public static final setBaselineAlignedChildIndex Cardinal = new setBaselineAlignedChildIndex("RSA");
    public static final setBaselineAlignedChildIndex cca_continue = new setBaselineAlignedChildIndex("OKP");
    public static final setBaselineAlignedChildIndex getInstance = new setBaselineAlignedChildIndex("EC");
    public static final setBaselineAlignedChildIndex init = new setBaselineAlignedChildIndex("oct");
    public final String configure;

    static {
        setButtonTintBlendMode setbuttontintblendmode = setButtonTintBlendMode.RECOMMENDED;
        setButtonTintBlendMode setbuttontintblendmode2 = setButtonTintBlendMode.REQUIRED;
        setButtonTintBlendMode setbuttontintblendmode3 = setButtonTintBlendMode.OPTIONAL;
        setButtonTintBlendMode setbuttontintblendmode4 = setButtonTintBlendMode.OPTIONAL;
    }

    private setBaselineAlignedChildIndex(String str) {
        if (str != null) {
            this.configure = str;
            return;
        }
        throw new IllegalArgumentException("The key type value must not be null");
    }

    public final int hashCode() {
        return this.configure.hashCode();
    }

    public final boolean equals(Object obj) {
        return obj != null && (obj instanceof setBaselineAlignedChildIndex) && toString().equals(obj.toString());
    }

    public final String toString() {
        return this.configure;
    }

    public final String configure() {
        StringBuilder sb = new StringBuilder(Const.jsQuote);
        sb.append(setLayoutTransition.cca_continue(this.configure));
        sb.append(Typography.quote);
        return sb.toString();
    }

    public static setBaselineAlignedChildIndex init(String str) {
        if (str == null) {
            throw new IllegalArgumentException("The key type to parse must not be null");
        } else if (str.equals(getInstance.configure)) {
            return getInstance;
        } else {
            if (str.equals(Cardinal.configure)) {
                return Cardinal;
            }
            if (str.equals(init.configure)) {
                return init;
            }
            if (str.equals(cca_continue.configure)) {
                return cca_continue;
            }
            return new setBaselineAlignedChildIndex(str);
        }
    }
}
