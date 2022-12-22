package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.elgamal;

import com.cardinalcommerce.p060a.AESCBC;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.RSASSAVerifier;
import com.cardinalcommerce.p060a.setKeyboardNavigationCluster;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;

public class ElGamalUtil {
    public static setKeyboardNavigationCluster configure(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof RSASSAVerifier) {
            RSASSAVerifier rSASSAVerifier = (RSASSAVerifier) publicKey;
            return new DigestSignatureSpi.SHA384(rSASSAVerifier.getY(), new DigestSignatureSpi.SHA224(rSASSAVerifier.getInstance().configure, rSASSAVerifier.getInstance().Cardinal));
        } else if (publicKey instanceof DHPublicKey) {
            DHPublicKey dHPublicKey = (DHPublicKey) publicKey;
            return new DigestSignatureSpi.SHA384(dHPublicKey.getY(), new DigestSignatureSpi.SHA224(dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG()));
        } else {
            throw new InvalidKeyException("can't identify public key for El Gamal.");
        }
    }

    public static setKeyboardNavigationCluster cca_continue(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof AESCBC) {
            AESCBC aescbc = (AESCBC) privateKey;
            return new DigestSignatureSpi.SHA3_256(aescbc.getX(), new DigestSignatureSpi.SHA224(aescbc.getInstance().configure, aescbc.getInstance().Cardinal));
        } else if (privateKey instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) privateKey;
            return new DigestSignatureSpi.SHA3_256(dHPrivateKey.getX(), new DigestSignatureSpi.SHA224(dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG()));
        } else {
            throw new InvalidKeyException("can't identify private key for El Gamal.");
        }
    }
}
