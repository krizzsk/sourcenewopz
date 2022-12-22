package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.security.PrivateKey;

/* renamed from: com.cardinalcommerce.a.setScrollBarFadeDuration */
public final class setScrollBarFadeDuration implements KeyAgreementSpi.ECKAEGwithSHA512KDF, PrivateKey {
    private setScreenReaderFocusable init;

    public setScrollBarFadeDuration(setScreenReaderFocusable setscreenreaderfocusable) {
        this.init = setscreenreaderfocusable;
    }

    public final String getAlgorithm() {
        return "McEliece";
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof setScrollBarFadeDuration)) {
            return false;
        }
        setScrollBarFadeDuration setscrollbarfadeduration = (setScrollBarFadeDuration) obj;
        if (this.init.cca_continue != setscrollbarfadeduration.init.cca_continue || this.init.configure != setscrollbarfadeduration.init.configure || !this.init.getInstance.equals(setscrollbarfadeduration.init.getInstance) || !this.init.init.equals(setscrollbarfadeduration.init.init) || !this.init.Cardinal.equals(setscrollbarfadeduration.init.Cardinal) || !this.init.CardinalError.equals(setscrollbarfadeduration.init.CardinalError) || !this.init.cleanup.equals(setscrollbarfadeduration.init.cleanup)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.init.configure * 37) + this.init.cca_continue) * 37) + this.init.getInstance.hashCode()) * 37) + this.init.init.hashCode()) * 37) + this.init.CardinalError.hashCode()) * 37) + this.init.cleanup.hashCode()) * 37) + this.init.Cardinal.hashCode();
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] getEncoded() {
        /*
            r9 = this;
            com.cardinalcommerce.a.setAutofillHints r8 = new com.cardinalcommerce.a.setAutofillHints
            com.cardinalcommerce.a.setScreenReaderFocusable r0 = r9.init
            int r1 = r0.cca_continue
            com.cardinalcommerce.a.setScreenReaderFocusable r0 = r9.init
            int r2 = r0.configure
            com.cardinalcommerce.a.setScreenReaderFocusable r0 = r9.init
            com.cardinalcommerce.a.setBackgroundTintList r3 = r0.getInstance
            com.cardinalcommerce.a.setScreenReaderFocusable r0 = r9.init
            com.cardinalcommerce.a.setForegroundTintMode r4 = r0.init
            com.cardinalcommerce.a.setScreenReaderFocusable r0 = r9.init
            com.cardinalcommerce.a.setForegroundGravity r5 = r0.CardinalError
            com.cardinalcommerce.a.setScreenReaderFocusable r0 = r9.init
            com.cardinalcommerce.a.setForegroundGravity r6 = r0.cleanup
            com.cardinalcommerce.a.setScreenReaderFocusable r0 = r9.init
            com.cardinalcommerce.a.setBackgroundDrawable r7 = r0.Cardinal
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = 0
            com.cardinalcommerce.a.DSASigner$stdDSA r1 = new com.cardinalcommerce.a.DSASigner$stdDSA     // Catch:{ IOException -> 0x0033 }
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r2 = com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.asn1.PQCObjectIdentifiers.init     // Catch:{ IOException -> 0x0033 }
            r1.<init>((com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier) r2)     // Catch:{ IOException -> 0x0033 }
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo r2 = new com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo     // Catch:{ IOException -> 0x0033 }
            r2.<init>(r1, r8)     // Catch:{ IOException -> 0x0033 }
            byte[] r0 = r2.getEncoded()     // Catch:{  }
        L_0x0033:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setScrollBarFadeDuration.getEncoded():byte[]");
    }
}
