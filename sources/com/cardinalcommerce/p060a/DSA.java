package com.cardinalcommerce.p060a;

import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.DSA */
public final class DSA extends setRequestTimeout {

    /* renamed from: com.cardinalcommerce.a.DSA$Mappings */
    public class Mappings extends setLocationDataConsentGiven implements getExtendedData {
        private final byte[] configure;

        public Mappings(String str) {
            this(str, (byte) 0);
        }

        private Mappings(String str, byte b) {
            if (str != null) {
                this.configure = setAnimation.configure(str);
                return;
            }
            throw new NullPointerException("string cannot be null");
        }

        Mappings(byte[] bArr) {
            this.configure = bArr;
        }

        public static Mappings init(Object obj) {
            if (obj == null || (obj instanceof Mappings)) {
                return (Mappings) obj;
            }
            StringBuilder sb = new StringBuilder("illegal object in getInstance: ");
            sb.append(obj.getClass().getName());
            throw new IllegalArgumentException(sb.toString());
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
            return setForegroundTintBlendMode.Cardinal(this.configure, ((Mappings) setlocationdataconsentgiven).configure);
        }

        /* access modifiers changed from: package-private */
        public final int configure() {
            return KeyAgreementSpi.Cardinal(this.configure.length) + 1 + this.configure.length;
        }

        public int hashCode() {
            return setForegroundTintBlendMode.init(this.configure);
        }

        public final String init() {
            return setAnimation.cca_continue(this.configure);
        }

        public String toString() {
            return init();
        }

        public static Mappings Cardinal(getType gettype) {
            setLocationDataConsentGiven values = gettype.getInstance != null ? gettype.getInstance.values() : null;
            return values instanceof Mappings ? init(values) : new Mappings(((isEnableDFSync) values).cca_continue());
        }

        /* access modifiers changed from: package-private */
        public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
            byte[] bArr = this.configure;
            setenabledfsync.configure(22);
            setenabledfsync.Cardinal(bArr.length);
            setenabledfsync.getInstance.write(bArr);
        }
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        int i = this.init ? 96 : 64;
        int i2 = this.cca_continue;
        byte[] bArr = this.getInstance;
        setenabledfsync.cca_continue(i, i2);
        setenabledfsync.Cardinal(bArr.length);
        setenabledfsync.getInstance.write(bArr);
    }
}
