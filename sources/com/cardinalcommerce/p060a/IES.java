package com.cardinalcommerce.p060a;

import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import rui.config.RConfigConstants;

/* renamed from: com.cardinalcommerce.a.IES */
public final class IES extends setLocationDataConsentGiven implements getExtendedData {

    /* renamed from: a */
    private static final char[] f2439a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b */
    private final byte[] f2440b;

    public IES(byte[] bArr) {
        this.f2440b = setForegroundTintBlendMode.cca_continue(bArr);
    }

    /* renamed from: a */
    private byte[] m1815a() {
        return setForegroundTintBlendMode.cca_continue(this.f2440b);
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven) {
        if (!(setlocationdataconsentgiven instanceof IES)) {
            return false;
        }
        return setForegroundTintBlendMode.Cardinal(this.f2440b, ((IES) setlocationdataconsentgiven).f2440b);
    }

    /* access modifiers changed from: package-private */
    public final int configure() {
        return KeyAgreementSpi.Cardinal(this.f2440b.length) + 1 + this.f2440b.length;
    }

    public final int hashCode() {
        return setForegroundTintBlendMode.init(this.f2440b);
    }

    public final String init() {
        StringBuffer stringBuffer = new StringBuffer(RConfigConstants.KEYWORD_COLOR_SIGN);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new setEnableDFSync(byteArrayOutputStream).init(this);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            for (int i = 0; i != byteArray.length; i++) {
                stringBuffer.append(f2439a[(byteArray[i] >>> 4) & 15]);
                stringBuffer.append(f2439a[byteArray[i] & Ascii.f53593SI]);
            }
            return stringBuffer.toString();
        } catch (IOException unused) {
            throw new setUICustomization("internal error encoding UniversalString");
        }
    }

    public final String toString() {
        return init();
    }

    /* renamed from: com.cardinalcommerce.a.IES$Mappings */
    public final class Mappings extends setLocationDataConsentGiven implements getExtendedData {
        private byte[] Cardinal;

        public Mappings(byte[] bArr) {
            this.Cardinal = setForegroundTintBlendMode.cca_continue(bArr);
        }

        /* access modifiers changed from: package-private */
        public final boolean Cardinal() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public final boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven) {
            if (!(setlocationdataconsentgiven instanceof Mappings)) {
                return false;
            }
            return setForegroundTintBlendMode.Cardinal(this.Cardinal, ((Mappings) setlocationdataconsentgiven).Cardinal);
        }

        /* access modifiers changed from: package-private */
        public final int configure() {
            return KeyAgreementSpi.Cardinal(this.Cardinal.length) + 1 + this.Cardinal.length;
        }

        public final int hashCode() {
            return setForegroundTintBlendMode.init(this.Cardinal);
        }

        public final String init() {
            return setAnimation.cca_continue(this.Cardinal);
        }

        public final String toString() {
            return init();
        }

        /* access modifiers changed from: package-private */
        public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
            byte[] bArr = this.Cardinal;
            setenabledfsync.configure(20);
            setenabledfsync.Cardinal(bArr.length);
            setenabledfsync.getInstance.write(bArr);
        }
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        byte[] a = m1815a();
        setenabledfsync.configure(28);
        setenabledfsync.Cardinal(a.length);
        setenabledfsync.getInstance.write(a);
    }
}
