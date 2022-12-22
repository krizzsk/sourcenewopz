package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encoding;

/* renamed from: com.cardinalcommerce.a.DH */
public final class C1895DH implements KeyAgreementSpi.DHUwithSHA1CKDF, getProxyAddress {

    /* renamed from: a */
    private DSASigner.dsaSha3_384 f2351a;

    /* renamed from: com.cardinalcommerce.a.DH$Mappings */
    public final class Mappings extends getRenderType {
        public Mappings(ASN1ObjectIdentifier aSN1ObjectIdentifier, setProxyAddress setproxyaddress, setLocationDataConsentGiven setlocationdataconsentgiven, int i, setLocationDataConsentGiven setlocationdataconsentgiven2) {
            super(aSN1ObjectIdentifier, setproxyaddress, setlocationdataconsentgiven, i, setlocationdataconsentgiven2);
        }

        /* access modifiers changed from: package-private */
        public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (this.configure != null) {
                byteArrayOutputStream.write(this.configure.init(ASN1Encoding.DER));
            }
            if (this.cca_continue != null) {
                byteArrayOutputStream.write(this.cca_continue.init(ASN1Encoding.DER));
            }
            if (this.Cardinal != null) {
                byteArrayOutputStream.write(this.Cardinal.init(ASN1Encoding.DER));
            }
            byteArrayOutputStream.write(new RSA(true, this.init, this.getInstance).init(ASN1Encoding.DER));
            setenabledfsync.getInstance(32, 8, byteArrayOutputStream.toByteArray());
        }

        /* access modifiers changed from: package-private */
        public final int configure() throws IOException {
            return getEncoded().length;
        }
    }

    public C1895DH(DSASigner.dsaSha3_384 dsasha3_384) {
        this.f2351a = dsasha3_384;
    }

    public final setLocationDataConsentGiven getInstance() throws IOException {
        try {
            return new BCDHPrivateKey(this.f2351a.configure());
        } catch (IllegalArgumentException e) {
            throw new getEnvironment(e.getMessage(), e);
        }
    }

    public final setLocationDataConsentGiven values() {
        try {
            return getInstance();
        } catch (IOException e) {
            throw new setUICustomization("unable to get DER object", e);
        } catch (IllegalArgumentException e2) {
            throw new setUICustomization("unable to get DER object", e2);
        }
    }
}
