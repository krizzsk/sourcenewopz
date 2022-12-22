package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.cardinalcommerce.p060a.DSASigner;
import java.io.IOException;
import java.security.PrivateKey;

/* renamed from: com.cardinalcommerce.a.setLayoutParams */
public final class setLayoutParams implements PrivateKey {
    private setContextClickable Cardinal;

    public setLayoutParams(setContextClickable setcontextclickable) {
        this.Cardinal = setcontextclickable;
    }

    public final String getAlgorithm() {
        return "McEliece-CCA2";
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof setLayoutParams)) {
            setLayoutParams setlayoutparams = (setLayoutParams) obj;
            if (this.Cardinal.configure != setlayoutparams.Cardinal.configure || this.Cardinal.Cardinal != setlayoutparams.Cardinal.Cardinal || !this.Cardinal.cca_continue.equals(setlayoutparams.Cardinal.cca_continue) || !this.Cardinal.init.equals(setlayoutparams.Cardinal.init) || !this.Cardinal.CardinalError.equals(setlayoutparams.Cardinal.CardinalError) || !this.Cardinal.cleanup.equals(setlayoutparams.Cardinal.cleanup)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((this.Cardinal.Cardinal * 37) + this.Cardinal.configure) * 37) + this.Cardinal.cca_continue.hashCode()) * 37) + this.Cardinal.init.hashCode()) * 37) + this.Cardinal.CardinalError.hashCode()) * 37) + this.Cardinal.cleanup.hashCode();
    }

    public final byte[] getEncoded() {
        try {
            return new PrivateKeyInfo(new DSASigner.stdDSA(PQCObjectIdentifiers.cca_continue), new setSystemGestureExclusionRects(this.Cardinal.configure, this.Cardinal.Cardinal, this.Cardinal.cca_continue, this.Cardinal.init, this.Cardinal.CardinalError, setScrollBarDefaultDelayBeforeFade.getInstance(this.Cardinal.getInstance))).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }
}
