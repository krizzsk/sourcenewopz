package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.KeyFactorySpi;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.cardinalcommerce.a.RSAUtil */
public final class RSAUtil implements KeyFactorySpi.ECGOST3410 {

    /* renamed from: a */
    private BCRSAPublicKey f2475a;

    public RSAUtil(BCRSAPublicKey bCRSAPublicKey) {
        this.f2475a = bCRSAPublicKey;
    }

    public final setKeyboardNavigationCluster Cardinal(InputStream inputStream) throws IOException {
        byte[] bArr;
        int read = inputStream.read();
        if (read != 0) {
            if (read == 2 || read == 3) {
                bArr = new byte[(((this.f2475a.Cardinal.configure() + 7) / 8) + 1)];
            } else if (read == 4 || read == 6 || read == 7) {
                bArr = new byte[((((this.f2475a.Cardinal.configure() + 7) / 8) * 2) + 1)];
            } else {
                StringBuilder sb = new StringBuilder("Sender's public key has invalid point encoding 0x");
                sb.append(Integer.toString(read, 16));
                throw new IOException(sb.toString());
            }
            bArr[0] = (byte) read;
            setTooltipText.init(inputStream, bArr, 1, bArr.length - 1);
            return new DigestSignatureSpi(this.f2475a.Cardinal.configure(bArr), this.f2475a);
        }
        throw new IOException("Sender's public key invalid.");
    }
}
