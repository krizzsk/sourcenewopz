package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException;
import java.security.AlgorithmParameters;
import java.security.Provider;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

/* renamed from: com.cardinalcommerce.a.setBaseline */
public final class setBaseline {
    public String Cardinal;
    public String cca_continue;
    public String configure;
    public String getInstance;
    public Boolean init;

    public static byte[] cca_continue(RSAPublicKey rSAPublicKey, SecretKey secretKey, Provider provider) throws JOSEException {
        AlgorithmParameters algorithmParameters;
        Cipher cipher;
        if (provider == null) {
            try {
                algorithmParameters = AlgorithmParameters.getInstance("OAEP");
            } catch (IllegalBlockSizeException e) {
                throw new JOSEException("RSA block size exception: The RSA key is too short, try a longer one", e);
            } catch (Exception e2) {
                throw new JOSEException(e2.getMessage(), e2);
            }
        } else {
            algorithmParameters = AlgorithmParameters.getInstance("OAEP", provider);
        }
        algorithmParameters.init(new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
        if (provider == null) {
            cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        } else {
            cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding", provider);
        }
        cipher.init(1, rSAPublicKey, algorithmParameters);
        return cipher.doFinal(secretKey.getEncoded());
    }
}
