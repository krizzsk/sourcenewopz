package com.cardinalcommerce.dependencies.internal.nimbusds.jose;

import com.cardinalcommerce.p060a.setButtonTintBlendMode;
import com.cardinalcommerce.p060a.setDownloadListener;

public final class EncryptionMethod extends setDownloadListener {
    public static final EncryptionMethod CardinalActionCode = new EncryptionMethod("A256GCM", setButtonTintBlendMode.RECOMMENDED, 256);
    public static final EncryptionMethod CardinalError = new EncryptionMethod("A256CBC-HS512", setButtonTintBlendMode.REQUIRED, 512);
    public static final EncryptionMethod cleanup = new EncryptionMethod("A128GCM", setButtonTintBlendMode.RECOMMENDED, 128);
    public static final EncryptionMethod getInstance = new EncryptionMethod("A128CBC-HS256", setButtonTintBlendMode.REQUIRED, 256);
    public static final EncryptionMethod getSDKVersion = new EncryptionMethod("A128CBC+HS256", setButtonTintBlendMode.OPTIONAL, 256);
    public static final EncryptionMethod getWarnings = new EncryptionMethod("A256CBC+HS512", setButtonTintBlendMode.OPTIONAL, 512);
    public static final EncryptionMethod init = new EncryptionMethod("A192CBC-HS384", setButtonTintBlendMode.OPTIONAL, 384);
    public static final EncryptionMethod values = new EncryptionMethod("A192GCM", setButtonTintBlendMode.OPTIONAL, 192);
    public final int Cardinal;

    private EncryptionMethod(String str, setButtonTintBlendMode setbuttontintblendmode, int i) {
        super(str, (byte) 0);
        this.Cardinal = i;
    }

    private EncryptionMethod(String str) {
        this(str, (setButtonTintBlendMode) null, 0);
    }

    public static EncryptionMethod Cardinal(String str) {
        if (str.equals(getInstance.cca_continue)) {
            return getInstance;
        }
        if (str.equals(init.cca_continue)) {
            return init;
        }
        if (str.equals(CardinalError.cca_continue)) {
            return CardinalError;
        }
        if (str.equals(cleanup.cca_continue)) {
            return cleanup;
        }
        if (str.equals(values.cca_continue)) {
            return values;
        }
        if (str.equals(CardinalActionCode.cca_continue)) {
            return CardinalActionCode;
        }
        if (str.equals(getSDKVersion.cca_continue)) {
            return getSDKVersion;
        }
        if (str.equals(getWarnings.cca_continue)) {
            return getWarnings;
        }
        return new EncryptionMethod(str);
    }
}
