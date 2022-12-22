package com.cardinalcommerce.p060a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encoding;

/* renamed from: com.cardinalcommerce.a.getJSON */
public final class getJSON extends setRequestTimeout {
    public getJSON(int i, setForegroundTintBlendMode setforegroundtintblendmode) {
        super(true, i, m1895a(setforegroundtintblendmode));
    }

    /* renamed from: a */
    private static byte[] m1895a(setForegroundTintBlendMode setforegroundtintblendmode) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i != setforegroundtintblendmode.cca_continue.size()) {
            try {
                byteArrayOutputStream.write(((getThreeDSRequestorAppURL) ((getProxyAddress) setforegroundtintblendmode.cca_continue.elementAt(i))).init(ASN1Encoding.BER));
                i++;
            } catch (IOException e) {
                throw new setUICustomization("malformed object: ".concat(String.valueOf(e)), e);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        setenabledfsync.cca_continue(this.init ? 96 : 64, this.cca_continue);
        setenabledfsync.configure(128);
        setenabledfsync.getInstance.write(this.getInstance);
        setenabledfsync.configure(0);
        setenabledfsync.configure(0);
    }
}
