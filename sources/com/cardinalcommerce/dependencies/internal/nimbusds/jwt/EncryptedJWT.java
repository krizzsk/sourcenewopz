package com.cardinalcommerce.dependencies.internal.nimbusds.jwt;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEHeader;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEObject;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.Payload;
import com.cardinalcommerce.p060a.setIndeterminate;

public class EncryptedJWT extends JWEObject implements setIndeterminate {
    public EncryptedJWT(JWEHeader jWEHeader, JWTClaimsSet jWTClaimsSet) {
        super(jWEHeader, new Payload(jWTClaimsSet.getInstance()));
    }
}
