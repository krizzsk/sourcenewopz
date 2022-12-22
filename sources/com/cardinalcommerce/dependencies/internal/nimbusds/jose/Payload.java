package com.cardinalcommerce.dependencies.internal.nimbusds.jose;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.cardinalcommerce.p060a.setLayoutTransition;
import com.cardinalcommerce.p060a.setMinWidth;
import java.io.Serializable;

public final class Payload implements Serializable {
    private final setLayoutTransition Cardinal;
    private final String cca_continue;
    final Base64URL getInstance;
    private final byte[] init;

    /* renamed from: com.cardinalcommerce.dependencies.internal.nimbusds.jose.Payload$configure */
    public enum C2157configure {
        JSON,
        STRING,
        BYTE_ARRAY,
        BASE64URL,
        JWS_OBJECT,
        SIGNED_JWT
    }

    private static byte[] init(String str) {
        if (str != null) {
            return str.getBytes(setMinWidth.getInstance);
        }
        return null;
    }

    public Payload(setLayoutTransition setlayouttransition) {
        if (setlayouttransition != null) {
            this.Cardinal = setlayouttransition;
            this.cca_continue = null;
            this.init = null;
            this.getInstance = null;
            C2157configure configure = C2157configure.JSON;
            return;
        }
        throw new IllegalArgumentException("The JSON object must not be null");
    }

    public Payload(String str) {
        if (str != null) {
            this.Cardinal = null;
            this.cca_continue = str;
            this.init = null;
            this.getInstance = null;
            C2157configure configure = C2157configure.STRING;
            return;
        }
        throw new IllegalArgumentException("The string must not be null");
    }

    public Payload(byte[] bArr) {
        if (bArr != null) {
            this.Cardinal = null;
            this.cca_continue = null;
            this.init = bArr;
            this.getInstance = null;
            C2157configure configure = C2157configure.BYTE_ARRAY;
            return;
        }
        throw new IllegalArgumentException("The byte array must not be null");
    }

    public Payload(Base64URL base64URL) {
        if (base64URL != null) {
            this.Cardinal = null;
            this.cca_continue = null;
            this.init = null;
            this.getInstance = base64URL;
            C2157configure configure = C2157configure.BASE64URL;
            return;
        }
        throw new IllegalArgumentException("The Base64URL-encoded object must not be null");
    }

    public final String toString() {
        String str = this.cca_continue;
        if (str != null) {
            return str;
        }
        setLayoutTransition setlayouttransition = this.Cardinal;
        if (setlayouttransition != null) {
            return setlayouttransition.toString();
        }
        byte[] bArr = this.init;
        if (bArr == null) {
            Base64URL base64URL = this.getInstance;
            if (base64URL != null) {
                return new String(base64URL.cca_continue(), setMinWidth.getInstance);
            }
            return null;
        } else if (bArr != null) {
            return new String(bArr, setMinWidth.getInstance);
        } else {
            return null;
        }
    }

    public final byte[] getInstance() {
        byte[] bArr = this.init;
        if (bArr != null) {
            return bArr;
        }
        Base64URL base64URL = this.getInstance;
        if (base64URL != null) {
            return base64URL.cca_continue();
        }
        return init(toString());
    }
}
