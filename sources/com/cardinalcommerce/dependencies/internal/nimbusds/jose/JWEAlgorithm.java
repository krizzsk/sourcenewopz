package com.cardinalcommerce.dependencies.internal.nimbusds.jose;

import com.cardinalcommerce.p060a.setButtonTintBlendMode;
import com.cardinalcommerce.p060a.setDownloadListener;

public final class JWEAlgorithm extends setDownloadListener {
    @Deprecated
    public static final JWEAlgorithm Cardinal = new JWEAlgorithm("RSA-OAEP", setButtonTintBlendMode.OPTIONAL);
    private static JWEAlgorithm CardinalActionCode = new JWEAlgorithm("ECDH-ES+A256KW", setButtonTintBlendMode.RECOMMENDED);
    private static JWEAlgorithm CardinalEnvironment = new JWEAlgorithm("ECDH-ES+A192KW", setButtonTintBlendMode.OPTIONAL);
    private static JWEAlgorithm CardinalError = new JWEAlgorithm("ECDH-ES", setButtonTintBlendMode.RECOMMENDED);
    private static JWEAlgorithm CardinalRenderType = new JWEAlgorithm("A128GCMKW", setButtonTintBlendMode.OPTIONAL);
    private static JWEAlgorithm CardinalUiType = new JWEAlgorithm("A192GCMKW", setButtonTintBlendMode.OPTIONAL);
    public static final JWEAlgorithm cleanup = new JWEAlgorithm("dir", setButtonTintBlendMode.RECOMMENDED);
    private static JWEAlgorithm getActionCode = new JWEAlgorithm("A256GCMKW", setButtonTintBlendMode.OPTIONAL);
    public static final JWEAlgorithm getInstance = new JWEAlgorithm("RSA-OAEP-256", setButtonTintBlendMode.OPTIONAL);
    private static JWEAlgorithm getRequestTimeout = new JWEAlgorithm("PBES2-HS256+A128KW", setButtonTintBlendMode.OPTIONAL);
    private static JWEAlgorithm getSDKVersion = new JWEAlgorithm("A192KW", setButtonTintBlendMode.OPTIONAL);
    private static JWEAlgorithm getString = new JWEAlgorithm("PBES2-HS512+A256KW", setButtonTintBlendMode.OPTIONAL);
    private static JWEAlgorithm getWarnings = new JWEAlgorithm("A128KW", setButtonTintBlendMode.RECOMMENDED);
    @Deprecated
    public static final JWEAlgorithm init = new JWEAlgorithm("RSA1_5", setButtonTintBlendMode.REQUIRED);
    private static JWEAlgorithm setRequestTimeout = new JWEAlgorithm("PBES2-HS384+A192KW", setButtonTintBlendMode.OPTIONAL);
    private static JWEAlgorithm valueOf = new JWEAlgorithm("ECDH-ES+A128KW", setButtonTintBlendMode.RECOMMENDED);
    private static JWEAlgorithm values = new JWEAlgorithm("A256KW", setButtonTintBlendMode.RECOMMENDED);

    private JWEAlgorithm(String str, setButtonTintBlendMode setbuttontintblendmode) {
        super(str, (byte) 0);
    }

    private JWEAlgorithm(String str) {
        super(str, (byte) 0);
    }

    public static JWEAlgorithm cca_continue(String str) {
        if (str.equals(init.cca_continue)) {
            return init;
        }
        if (str.equals(Cardinal.cca_continue)) {
            return Cardinal;
        }
        if (str.equals(getInstance.cca_continue)) {
            return getInstance;
        }
        if (str.equals(getWarnings.cca_continue)) {
            return getWarnings;
        }
        if (str.equals(getSDKVersion.cca_continue)) {
            return getSDKVersion;
        }
        if (str.equals(values.cca_continue)) {
            return values;
        }
        if (str.equals(cleanup.cca_continue)) {
            return cleanup;
        }
        if (str.equals(CardinalError.cca_continue)) {
            return CardinalError;
        }
        if (str.equals(valueOf.cca_continue)) {
            return valueOf;
        }
        if (str.equals(CardinalEnvironment.cca_continue)) {
            return CardinalEnvironment;
        }
        if (str.equals(CardinalActionCode.cca_continue)) {
            return CardinalActionCode;
        }
        if (str.equals(CardinalRenderType.cca_continue)) {
            return CardinalRenderType;
        }
        if (str.equals(CardinalUiType.cca_continue)) {
            return CardinalUiType;
        }
        if (str.equals(getActionCode.cca_continue)) {
            return getActionCode;
        }
        if (str.equals(getRequestTimeout.cca_continue)) {
            return getRequestTimeout;
        }
        if (str.equals(setRequestTimeout.cca_continue)) {
            return setRequestTimeout;
        }
        if (str.equals(getString.cca_continue)) {
            return getString;
        }
        return new JWEAlgorithm(str);
    }
}
