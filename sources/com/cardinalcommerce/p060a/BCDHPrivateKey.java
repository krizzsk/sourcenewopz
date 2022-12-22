package com.cardinalcommerce.p060a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encoding;

/* renamed from: com.cardinalcommerce.a.BCDHPrivateKey */
public final class BCDHPrivateKey extends getRenderType {
    public BCDHPrivateKey(setForegroundTintBlendMode setforegroundtintblendmode) {
        super(setforegroundtintblendmode);
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (this.configure != null) {
            byteArrayOutputStream.write(this.configure.init(ASN1Encoding.f5639DL));
        }
        if (this.cca_continue != null) {
            byteArrayOutputStream.write(this.cca_continue.init(ASN1Encoding.f5639DL));
        }
        if (this.Cardinal != null) {
            byteArrayOutputStream.write(this.Cardinal.init(ASN1Encoding.f5639DL));
        }
        byteArrayOutputStream.write(new RSA(true, this.init, this.getInstance).init(ASN1Encoding.f5639DL));
        setenabledfsync.getInstance(32, 8, byteArrayOutputStream.toByteArray());
    }

    /* access modifiers changed from: package-private */
    public final int configure() throws IOException {
        return getEncoded().length;
    }
}
