package com.cardinalcommerce.p060a;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.Serializable;
import kotlin.text.Typography;

/* renamed from: com.cardinalcommerce.a.setDownloadListener */
public class setDownloadListener implements setMotionEventSplittingEnabled, Serializable {
    public static final setDownloadListener configure = new setDownloadListener("none", (byte) 0);
    public final String cca_continue;

    static {
        setButtonTintBlendMode setbuttontintblendmode = setButtonTintBlendMode.REQUIRED;
    }

    public setDownloadListener(String str, byte b) {
        if (str != null) {
            this.cca_continue = str;
            return;
        }
        throw new IllegalArgumentException("The algorithm name must not be null");
    }

    private setDownloadListener(String str) {
        this(str, (byte) 0);
    }

    public final int hashCode() {
        return this.cca_continue.hashCode();
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof setDownloadListener) && toString().equals(obj.toString());
    }

    public final String toString() {
        return this.cca_continue;
    }

    public final String configure() {
        StringBuilder sb = new StringBuilder(Const.jsQuote);
        sb.append(setLayoutTransition.cca_continue(this.cca_continue));
        sb.append(Typography.quote);
        return sb.toString();
    }

    public static setDownloadListener getInstance(String str) {
        if (str == null) {
            return null;
        }
        return new setDownloadListener(str);
    }
}
