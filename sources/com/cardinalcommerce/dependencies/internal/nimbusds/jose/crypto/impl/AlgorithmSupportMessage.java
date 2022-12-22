package com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm;
import java.util.Collection;

public class AlgorithmSupportMessage {
    /* renamed from: a */
    private static String m2220a(Collection collection) {
        StringBuilder sb = new StringBuilder();
        Object[] array = collection.toArray();
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                if (i < array.length - 1) {
                    sb.append(", ");
                } else if (i == array.length - 1) {
                    sb.append(" or ");
                }
            }
            sb.append(array[i].toString());
        }
        return sb.toString();
    }

    public static String init(JWSAlgorithm jWSAlgorithm, Collection<JWSAlgorithm> collection) {
        StringBuilder sb = new StringBuilder("Unsupported JWS algorithm ");
        sb.append(jWSAlgorithm);
        sb.append(", must be ");
        sb.append(m2220a(collection));
        return sb.toString();
    }

    public static String configure(JWEAlgorithm jWEAlgorithm, Collection<JWEAlgorithm> collection) {
        StringBuilder sb = new StringBuilder("Unsupported JWE algorithm ");
        sb.append(jWEAlgorithm);
        sb.append(", must be ");
        sb.append(m2220a(collection));
        return sb.toString();
    }

    public static String configure(EncryptionMethod encryptionMethod, Collection<EncryptionMethod> collection) {
        StringBuilder sb = new StringBuilder("Unsupported JWE encryption method ");
        sb.append(encryptionMethod);
        sb.append(", must be ");
        sb.append(m2220a(collection));
        return sb.toString();
    }

    private AlgorithmSupportMessage() {
    }
}
