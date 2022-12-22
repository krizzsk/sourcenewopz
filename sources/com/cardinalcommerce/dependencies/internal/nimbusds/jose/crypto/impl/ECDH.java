package com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.interfaces.ECPublicKey;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class ECDH {
    public static SecretKey cca_continue(ECPublicKey eCPublicKey, PrivateKey privateKey, Provider provider) throws JOSEException {
        KeyAgreement keyAgreement;
        if (provider != null) {
            try {
                keyAgreement = KeyAgreement.getInstance("ECDH", provider);
            } catch (NoSuchAlgorithmException e) {
                StringBuilder sb = new StringBuilder("Couldn't get an ECDH key agreement instance: ");
                sb.append(e.getMessage());
                throw new JOSEException(sb.toString(), e);
            }
        } else {
            keyAgreement = KeyAgreement.getInstance("ECDH");
        }
        try {
            keyAgreement.init(privateKey);
            keyAgreement.doPhase(eCPublicKey, true);
            return new SecretKeySpec(keyAgreement.generateSecret(), "AES");
        } catch (InvalidKeyException e2) {
            StringBuilder sb2 = new StringBuilder("Invalid key for ECDH key agreement: ");
            sb2.append(e2.getMessage());
            throw new JOSEException(sb2.toString(), e2);
        }
    }

    private ECDH() {
    }
}
