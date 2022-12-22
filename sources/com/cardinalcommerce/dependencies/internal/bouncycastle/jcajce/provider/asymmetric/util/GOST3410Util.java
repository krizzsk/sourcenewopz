package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util;

import com.cardinalcommerce.p060a.AlgorithmSupportMessage;
import com.cardinalcommerce.p060a.AuthenticatedCipherText;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.setErrorCode;
import com.cardinalcommerce.p060a.setKeyboardNavigationCluster;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class GOST3410Util {
    public static setKeyboardNavigationCluster cca_continue(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof AuthenticatedCipherText) {
            AuthenticatedCipherText authenticatedCipherText = (AuthenticatedCipherText) publicKey;
            setErrorCode cca_continue = authenticatedCipherText.cca_continue().cca_continue();
            return new DigestSignatureSpi.SHA3_384(authenticatedCipherText.Cardinal(), new DigestSignatureSpi.SHA512_256(cca_continue.configure, cca_continue.init, cca_continue.getInstance));
        }
        StringBuilder sb = new StringBuilder("can't identify GOST3410 public key: ");
        sb.append(publicKey.getClass().getName());
        throw new InvalidKeyException(sb.toString());
    }

    public static setKeyboardNavigationCluster init(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof AlgorithmSupportMessage) {
            AlgorithmSupportMessage algorithmSupportMessage = (AlgorithmSupportMessage) privateKey;
            setErrorCode cca_continue = algorithmSupportMessage.cca_continue().cca_continue();
            return new DigestSignatureSpi.SHA512_224(algorithmSupportMessage.getInstance(), new DigestSignatureSpi.SHA512_256(cca_continue.configure, cca_continue.init, cca_continue.getInstance));
        }
        throw new InvalidKeyException("can't identify GOST3410 private key.");
    }
}
