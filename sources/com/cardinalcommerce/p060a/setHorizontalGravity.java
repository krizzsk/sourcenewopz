package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.JWK;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import java.net.URI;
import java.security.KeyStore;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* renamed from: com.cardinalcommerce.a.setHorizontalGravity */
public final class setHorizontalGravity extends JWK {
    private final Base64URL getInstance;

    public final boolean init() {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private setHorizontalGravity(Base64URL base64URL, setVerticalGravity setverticalgravity, Set<setDividerPadding> set, setDownloadListener setdownloadlistener, String str, URI uri, Base64URL base64URL2, Base64URL base64URL3, List<Base64> list) {
        super(setBaselineAlignedChildIndex.init, setverticalgravity, set, setdownloadlistener, str, uri, base64URL2, base64URL3, list, (KeyStore) null);
        Base64URL base64URL4 = base64URL;
        if (base64URL4 != null) {
            this.getInstance = base64URL4;
        } else {
            throw new IllegalArgumentException("The key value must not be null");
        }
    }

    public final setLayoutTransition cca_continue() {
        setLayoutTransition cca_continue = super.cca_continue();
        cca_continue.put("k", this.getInstance.toString());
        return cca_continue;
    }

    public static setHorizontalGravity init(setLayoutTransition setlayouttransition) throws ParseException {
        Base64URL base64URL;
        List list;
        Base64URL base64URL2;
        if (setBaselineAlignedChildIndex.init.equals(setBaselineAligned.init(setlayouttransition))) {
            String str = (String) valueOf.getInstance(setlayouttransition, "k", String.class);
            Base64URL base64URL3 = null;
            if (str == null) {
                base64URL = null;
            } else {
                base64URL = new Base64URL(str);
            }
            try {
                setVerticalGravity Cardinal = setVerticalGravity.Cardinal((String) valueOf.getInstance(setlayouttransition, "use", String.class));
                String[] configure = valueOf.configure(setlayouttransition, "key_ops");
                if (configure == null) {
                    list = null;
                } else {
                    list = Arrays.asList(configure);
                }
                Set<setDividerPadding> configure2 = setDividerPadding.configure(list);
                setDownloadListener instance = setDownloadListener.getInstance((String) valueOf.getInstance(setlayouttransition, "alg", String.class));
                String str2 = (String) valueOf.getInstance(setlayouttransition, "kid", String.class);
                URI instance2 = valueOf.getInstance(setlayouttransition, "x5u");
                String str3 = (String) valueOf.getInstance(setlayouttransition, "x5t", String.class);
                if (str3 == null) {
                    base64URL2 = null;
                } else {
                    base64URL2 = new Base64URL(str3);
                }
                String str4 = (String) valueOf.getInstance(setlayouttransition, "x5t#S256", String.class);
                if (str4 != null) {
                    base64URL3 = new Base64URL(str4);
                }
                return new setHorizontalGravity(base64URL, Cardinal, configure2, instance, str2, instance2, base64URL2, base64URL3, setBaselineAligned.Cardinal(setlayouttransition));
            } catch (IllegalArgumentException e) {
                throw new ParseException(e.getMessage(), 0);
            }
        } else {
            throw new ParseException("The key type \"kty\" must be oct", 0);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof setHorizontalGravity) && super.equals(obj)) {
            return Objects.equals(this.getInstance, ((setHorizontalGravity) obj).getInstance);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.getInstance});
    }
}
