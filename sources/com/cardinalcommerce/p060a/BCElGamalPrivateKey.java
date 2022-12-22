package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.BCElGamalPrivateKey */
public class BCElGamalPrivateKey extends setKeyboardNavigationCluster {
    public CipherSpi configure;

    protected BCElGamalPrivateKey(boolean z, CipherSpi cipherSpi) {
        super(z);
        this.configure = cipherSpi;
    }

    public int hashCode() {
        boolean z = !getInstance();
        CipherSpi cipherSpi = this.configure;
        return cipherSpi != null ? z ^ cipherSpi.hashCode() ? 1 : 0 : z ? 1 : 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCElGamalPrivateKey)) {
            return false;
        }
        BCElGamalPrivateKey bCElGamalPrivateKey = (BCElGamalPrivateKey) obj;
        CipherSpi cipherSpi = this.configure;
        if (cipherSpi != null) {
            return cipherSpi.equals(bCElGamalPrivateKey.configure);
        }
        if (bCElGamalPrivateKey.configure == null) {
            return true;
        }
        return false;
    }
}
