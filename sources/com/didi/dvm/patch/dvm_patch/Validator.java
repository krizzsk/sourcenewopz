package com.didi.dvm.patch.dvm_patch;

import android.util.Base64;
import com.facebook.internal.security.OidcSecurityUtil;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Validator {

    /* renamed from: a */
    private static String f19310a = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx6oloMEp9h7qUdMJZy/9\nd9jXnim+Ss2N2oueTm2F4N6bWBJLKE2UNLahA0vJvJp25cZIWJX97p2qI3cuvb3G\nHcLFmXvkAkRHrU88daphkl91YioijAq0Qp0t5ftdLj4t8ecm5fg6FS2Wa9gSvihY\nRoZ4bD4jGTSBj7pRs0MkA3qNNs0LlZLB4fuM0sfs/vC7MBldLOHVrDakg7lIYz8z\nVkjiCrvoEz/R05Gl5sMAej0ZtGwNgryQ+XWq3dJ7h7nCrXFZcvbPsunyoqPbfpMJ\nfRPqxs0bLjesuN3bDzB79YGmPZQy1oCliywSwEueZc0RbxKPrEcJInc8O5NAcUs1\nKwIDAQAB";

    public static boolean verify(String str, String str2) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, UnsupportedEncodingException, NoSuchProviderException, SignatureException {
        Signature instance = Signature.getInstance(OidcSecurityUtil.SIGNATURE_ALGORITHM_SHA256);
        instance.initVerify(KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(f19310a, 0))));
        instance.update(str.getBytes());
        return instance.verify(Base64.decode(str2, 0));
    }
}
