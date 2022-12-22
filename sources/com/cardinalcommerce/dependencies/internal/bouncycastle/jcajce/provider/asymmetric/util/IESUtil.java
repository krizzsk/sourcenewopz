package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util;

import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.getErrorMessage;

public class IESUtil {
    public static getErrorMessage Cardinal(KeyAgreementSpi.ECKAEGwithSHA256KDF eCKAEGwithSHA256KDF, byte[] bArr) {
        if (eCKAEGwithSHA256KDF == null) {
            return new getErrorMessage((byte[]) null, (byte[]) null, 128);
        }
        KeyAgreementSpi.DHwithSHA512KDFAndSharedInfo instance = eCKAEGwithSHA256KDF.getInstance();
        return (instance.Cardinal().equals("DES") || instance.Cardinal().equals("RC2") || instance.Cardinal().equals("RC5-32") || instance.Cardinal().equals("RC5-64")) ? new getErrorMessage((byte[]) null, (byte[]) null, 64, 64, bArr) : instance.Cardinal().equals("SKIPJACK") ? new getErrorMessage((byte[]) null, (byte[]) null, 80, 80, bArr) : instance.Cardinal().equals("GOST28147") ? new getErrorMessage((byte[]) null, (byte[]) null, 256, 256, bArr) : new getErrorMessage((byte[]) null, (byte[]) null, 128, 128, bArr);
    }
}
