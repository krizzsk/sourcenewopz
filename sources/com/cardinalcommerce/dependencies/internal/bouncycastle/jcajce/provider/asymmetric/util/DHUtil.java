package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p062dh.BCDHPublicKey;
import com.cardinalcommerce.p060a.BCElGamalPublicKey;
import com.cardinalcommerce.p060a.CipherSpi;
import com.cardinalcommerce.p060a.setKeyboardNavigationCluster;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;

public class DHUtil {
    public static setKeyboardNavigationCluster configure(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) privateKey;
            return new BCElGamalPublicKey(dHPrivateKey.getX(), new CipherSpi(dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG(), dHPrivateKey.getParams().getL()));
        }
        throw new InvalidKeyException("can't identify DH private key.");
    }

    public static setKeyboardNavigationCluster cca_continue(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCDHPublicKey) {
            return ((BCDHPublicKey) publicKey).cca_continue;
        }
        if (publicKey instanceof DHPublicKey) {
            DHPublicKey dHPublicKey = (DHPublicKey) publicKey;
            return new CipherSpi.PKCS1v1_5Padding(dHPublicKey.getY(), new CipherSpi(dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG(), dHPublicKey.getParams().getL()));
        }
        throw new InvalidKeyException("can't identify DH public key.");
    }
}
