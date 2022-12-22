package com.cardinalcommerce.p060a;

import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setErrorCode */
public class setErrorCode {
    public BigInteger configure;
    public BigInteger getInstance;
    public BigInteger init;

    public setErrorCode(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.configure = bigInteger;
        this.init = bigInteger2;
        this.getInstance = bigInteger3;
    }

    public boolean equals(Object obj) {
        if (obj instanceof setErrorCode) {
            setErrorCode seterrorcode = (setErrorCode) obj;
            return this.getInstance.equals(seterrorcode.getInstance) && this.configure.equals(seterrorcode.configure) && this.init.equals(seterrorcode.init);
        }
    }

    public int hashCode() {
        return (this.getInstance.hashCode() ^ this.configure.hashCode()) ^ this.init.hashCode();
    }
}
