package com.cardinalcommerce.dependencies.internal.nimbusds.jose;

import com.cardinalcommerce.p060a.setButtonTintBlendMode;
import com.cardinalcommerce.p060a.setDownloadListener;

public final class JWSAlgorithm extends setDownloadListener {
    public static final JWSAlgorithm Cardinal = new JWSAlgorithm("RS256", setButtonTintBlendMode.RECOMMENDED);
    public static final JWSAlgorithm CardinalActionCode = new JWSAlgorithm("PS512", setButtonTintBlendMode.OPTIONAL);
    private static JWSAlgorithm CardinalConfigurationParameters = new JWSAlgorithm("HS512", setButtonTintBlendMode.OPTIONAL);
    public static final JWSAlgorithm CardinalEnvironment = new JWSAlgorithm("EdDSA", setButtonTintBlendMode.OPTIONAL);
    public static final JWSAlgorithm CardinalError = new JWSAlgorithm("ES256K", setButtonTintBlendMode.OPTIONAL);
    public static final JWSAlgorithm CardinalRenderType = new JWSAlgorithm("PS384", setButtonTintBlendMode.OPTIONAL);
    private static JWSAlgorithm CardinalUiType = new JWSAlgorithm("HS384", setButtonTintBlendMode.OPTIONAL);
    public static final JWSAlgorithm cleanup = new JWSAlgorithm("ES512", setButtonTintBlendMode.OPTIONAL);
    public static final JWSAlgorithm getInstance = new JWSAlgorithm("RS384", setButtonTintBlendMode.OPTIONAL);
    public static final JWSAlgorithm getSDKVersion = new JWSAlgorithm("PS256", setButtonTintBlendMode.OPTIONAL);
    public static final JWSAlgorithm getWarnings = new JWSAlgorithm("ES256", setButtonTintBlendMode.RECOMMENDED);
    public static final JWSAlgorithm init = new JWSAlgorithm("RS512", setButtonTintBlendMode.OPTIONAL);
    private static JWSAlgorithm valueOf = new JWSAlgorithm("HS256", setButtonTintBlendMode.REQUIRED);
    public static final JWSAlgorithm values = new JWSAlgorithm("ES384", setButtonTintBlendMode.OPTIONAL);

    private JWSAlgorithm(String str, setButtonTintBlendMode setbuttontintblendmode) {
        super(str, (byte) 0);
    }

    private JWSAlgorithm(String str) {
        super(str, (byte) 0);
    }

    public static JWSAlgorithm cca_continue(String str) {
        if (str.equals(valueOf.cca_continue)) {
            return valueOf;
        }
        if (str.equals(CardinalUiType.cca_continue)) {
            return CardinalUiType;
        }
        if (str.equals(CardinalConfigurationParameters.cca_continue)) {
            return CardinalConfigurationParameters;
        }
        if (str.equals(Cardinal.cca_continue)) {
            return Cardinal;
        }
        if (str.equals(getInstance.cca_continue)) {
            return getInstance;
        }
        if (str.equals(init.cca_continue)) {
            return init;
        }
        if (str.equals(getWarnings.cca_continue)) {
            return getWarnings;
        }
        if (str.equals(CardinalError.cca_continue)) {
            return CardinalError;
        }
        if (str.equals(values.cca_continue)) {
            return values;
        }
        if (str.equals(cleanup.cca_continue)) {
            return cleanup;
        }
        if (str.equals(getSDKVersion.cca_continue)) {
            return getSDKVersion;
        }
        if (str.equals(CardinalRenderType.cca_continue)) {
            return CardinalRenderType;
        }
        if (str.equals(CardinalActionCode.cca_continue)) {
            return CardinalActionCode;
        }
        if (str.equals(CardinalEnvironment.cca_continue)) {
            return CardinalEnvironment;
        }
        return new JWSAlgorithm(str);
    }
}
