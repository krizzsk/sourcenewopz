package com.cardinalcommerce.p060a;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import rui.config.RConfigConstants;

/* renamed from: com.cardinalcommerce.a.isEnableDFSync */
public abstract class isEnableDFSync extends setLocationDataConsentGiven implements getUICustomization {

    /* renamed from: b */
    byte[] f2597b;

    public isEnableDFSync(byte[] bArr) {
        if (bArr != null) {
            this.f2597b = bArr;
            return;
        }
        throw new NullPointerException("string cannot be null");
    }

    public static isEnableDFSync init(Object obj) {
        if (obj == null || (obj instanceof isEnableDFSync)) {
            return (isEnableDFSync) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return init(setLocationDataConsentGiven.getInstance((byte[]) obj));
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder("failed to construct OCTET STRING from byte[]: ");
                sb.append(e.getMessage());
                throw new IllegalArgumentException(sb.toString());
            }
        } else {
            if (obj instanceof getProxyAddress) {
                setLocationDataConsentGiven values = ((getProxyAddress) obj).values();
                if (values instanceof isEnableDFSync) {
                    return (isEnableDFSync) values;
                }
            }
            StringBuilder sb2 = new StringBuilder("illegal object in getInstance: ");
            sb2.append(obj.getClass().getName());
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven) {
        if (!(setlocationdataconsentgiven instanceof isEnableDFSync)) {
            return false;
        }
        return setForegroundTintBlendMode.Cardinal(this.f2597b, ((isEnableDFSync) setlocationdataconsentgiven).f2597b);
    }

    /* access modifiers changed from: package-private */
    public abstract void cca_continue(setEnableDFSync setenabledfsync) throws IOException;

    public byte[] cca_continue() {
        return this.f2597b;
    }

    public final setLocationDataConsentGiven getInstance() {
        return values();
    }

    /* access modifiers changed from: package-private */
    public final setLocationDataConsentGiven getSDKVersion() {
        return new EdEC(this.f2597b);
    }

    /* access modifiers changed from: package-private */
    public final setLocationDataConsentGiven getWarnings() {
        return new EdEC(this.f2597b);
    }

    public int hashCode() {
        return setForegroundTintBlendMode.init(cca_continue());
    }

    public final InputStream init() {
        return new ByteArrayInputStream(this.f2597b);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(RConfigConstants.KEYWORD_COLOR_SIGN);
        sb.append(setAnimation.cca_continue(setTextDirection.configure(this.f2597b)));
        return sb.toString();
    }

    public static isEnableDFSync getInstance(getType gettype, boolean z) {
        setLocationDataConsentGiven values = gettype.getInstance != null ? gettype.getInstance.values() : null;
        if (z || (values instanceof isEnableDFSync)) {
            return init(values);
        }
        setThreeDSRequestorAppURL cca_continue = setThreeDSRequestorAppURL.cca_continue((Object) values);
        isEnableDFSync[] isenabledfsyncArr = new isEnableDFSync[cca_continue.getInstance()];
        Enumeration cca_continue2 = cca_continue.cca_continue();
        int i = 0;
        while (cca_continue2.hasMoreElements()) {
            isenabledfsyncArr[i] = (isEnableDFSync) cca_continue2.nextElement();
            i++;
        }
        return new getErrorNumber(isenabledfsyncArr);
    }
}
