package com.cardinalcommerce.p060a;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1Encoding;

/* renamed from: com.cardinalcommerce.a.EdEC */
public final class EdEC extends isEnableDFSync {

    /* renamed from: com.cardinalcommerce.a.EdEC$Mappings */
    public final class Mappings implements getUICustomization {
        private IESCipher configure;

        public Mappings(IESCipher iESCipher) {
            this.configure = iESCipher;
        }

        public final setLocationDataConsentGiven getInstance() throws IOException {
            return new EdEC(this.configure.configure());
        }

        public final InputStream init() {
            return this.configure;
        }

        public final setLocationDataConsentGiven values() {
            try {
                return getInstance();
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder("IOException converting stream to byte array: ");
                sb.append(e.getMessage());
                throw new setUICustomization(sb.toString(), e);
            }
        }
    }

    public EdEC(getProxyAddress getproxyaddress) throws IOException {
        super(getproxyaddress.values().init(ASN1Encoding.DER));
    }

    public EdEC(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final int configure() {
        return KeyAgreementSpi.Cardinal(this.f2597b.length) + 1 + this.f2597b.length;
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        byte[] bArr = this.f2597b;
        setenabledfsync.configure(4);
        setenabledfsync.Cardinal(bArr.length);
        setenabledfsync.getInstance.write(bArr);
    }
}
