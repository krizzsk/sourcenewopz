package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEHeader;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.RSAEncrypter;
import com.cardinalcommerce.dependencies.internal.nimbusds.jwt.EncryptedJWT;
import com.cardinalcommerce.dependencies.internal.nimbusds.jwt.JWTClaimsSet;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;

/* renamed from: com.cardinalcommerce.a.setSecondaryProgressTintList */
public final class setSecondaryProgressTintList {

    /* renamed from: a */
    private static int f2986a = 0;

    /* renamed from: b */
    private static int f2987b = 1;
    public String Cardinal;
    public String CardinalError;
    public String cca_continue;
    public String cleanup;
    public String configure;
    public String getInstance;
    public String getSDKVersion;
    public String getWarnings;
    public String init;
    public String values;

    public setSecondaryProgressTintList() {
    }

    public static String cca_continue(String str, RSAPublicKey rSAPublicKey) throws ParseException, JOSEException {
        EncryptedJWT encryptedJWT = new EncryptedJWT(new JWEHeader(JWEAlgorithm.getInstance, EncryptionMethod.getInstance), JWTClaimsSet.getInstance(str));
        encryptedJWT.init(new RSAEncrypter(rSAPublicKey));
        String init2 = encryptedJWT.init();
        int i = f2987b;
        int i2 = (i & 85) + (i | 85);
        f2986a = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return init2;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return init2;
    }

    public setSecondaryProgressTintList(String str) {
        this.Cardinal = "C";
        this.configure = "CRes";
        this.values = "Erro";
        this.getSDKVersion = "";
        this.CardinalError = "";
        this.getWarnings = "";
        this.cleanup = str;
    }

    public setSecondaryProgressTintList(char[] cArr) {
        this.Cardinal = "C";
        this.configure = "CRes";
        this.values = "Erro";
        this.getSDKVersion = "";
        this.CardinalError = "";
        this.getWarnings = "";
        this.cleanup = new String(cArr);
    }
}
