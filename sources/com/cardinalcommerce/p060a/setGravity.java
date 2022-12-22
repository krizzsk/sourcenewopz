package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.Curve;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.JWK;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import java.net.URI;
import java.security.KeyStore;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* renamed from: com.cardinalcommerce.a.setGravity */
public final class setGravity extends JWK {
    private static Set<Curve> getInstance = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Curve[]{Curve.configure, Curve.CardinalError, Curve.getSDKVersion, Curve.cleanup})));
    private final Base64URL Cardinal;
    private final Base64URL cca_continue;
    private final Curve configure;
    private final byte[] init;
    private final byte[] values;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private setGravity(Curve curve, Base64URL base64URL, setVerticalGravity setverticalgravity, Set<setDividerPadding> set, setDownloadListener setdownloadlistener, String str, URI uri, Base64URL base64URL2, Base64URL base64URL3, List<Base64> list) {
        super(setBaselineAlignedChildIndex.cca_continue, setverticalgravity, set, setdownloadlistener, str, uri, base64URL2, base64URL3, list, (KeyStore) null);
        Curve curve2 = curve;
        Base64URL base64URL4 = base64URL;
        if (curve2 == null) {
            throw new IllegalArgumentException("The curve must not be null");
        } else if (getInstance.contains(curve)) {
            this.configure = curve2;
            if (base64URL4 != null) {
                this.cca_continue = base64URL4;
                this.init = base64URL.cca_continue();
                this.Cardinal = null;
                this.values = null;
                return;
            }
            throw new IllegalArgumentException("The 'x' parameter must not be null");
        } else {
            throw new IllegalArgumentException("Unknown / unsupported curve: ".concat(String.valueOf(curve)));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private setGravity(Curve curve, Base64URL base64URL, Base64URL base64URL2, setVerticalGravity setverticalgravity, Set<setDividerPadding> set, setDownloadListener setdownloadlistener, String str, URI uri, Base64URL base64URL3, Base64URL base64URL4, List<Base64> list) {
        super(setBaselineAlignedChildIndex.cca_continue, setverticalgravity, set, setdownloadlistener, str, uri, base64URL3, base64URL4, list, (KeyStore) null);
        Curve curve2 = curve;
        Base64URL base64URL5 = base64URL;
        Base64URL base64URL6 = base64URL2;
        if (curve2 == null) {
            throw new IllegalArgumentException("The curve must not be null");
        } else if (getInstance.contains(curve2)) {
            this.configure = curve2;
            if (base64URL5 != null) {
                this.cca_continue = base64URL5;
                this.init = base64URL.cca_continue();
                if (base64URL6 != null) {
                    this.Cardinal = base64URL6;
                    this.values = base64URL2.cca_continue();
                    return;
                }
                throw new IllegalArgumentException("The 'd' parameter must not be null");
            }
            throw new IllegalArgumentException("The 'x' parameter must not be null");
        } else {
            throw new IllegalArgumentException("Unknown / unsupported curve: ".concat(String.valueOf(curve)));
        }
    }

    public final boolean init() {
        return this.Cardinal != null;
    }

    public final setLayoutTransition cca_continue() {
        setLayoutTransition cca_continue2 = super.cca_continue();
        cca_continue2.put("crv", this.configure.toString());
        cca_continue2.put("x", this.cca_continue.toString());
        Base64URL base64URL = this.Cardinal;
        if (base64URL != null) {
            cca_continue2.put("d", base64URL.toString());
        }
        return cca_continue2;
    }

    public static setGravity init(setLayoutTransition setlayouttransition) throws ParseException {
        Base64URL base64URL;
        Base64URL base64URL2;
        List list;
        Base64URL base64URL3;
        List list2;
        Base64URL base64URL4;
        setLayoutTransition setlayouttransition2 = setlayouttransition;
        if (setBaselineAlignedChildIndex.cca_continue.equals(setBaselineAligned.init(setlayouttransition))) {
            try {
                Curve cca_continue2 = Curve.cca_continue((String) valueOf.getInstance(setlayouttransition2, "crv", String.class));
                String str = (String) valueOf.getInstance(setlayouttransition2, "x", String.class);
                Base64URL base64URL5 = null;
                if (str == null) {
                    base64URL = null;
                } else {
                    base64URL = new Base64URL(str);
                }
                String str2 = (String) valueOf.getInstance(setlayouttransition2, "d", String.class);
                if (str2 == null) {
                    base64URL2 = null;
                } else {
                    base64URL2 = new Base64URL(str2);
                }
                if (base64URL2 == null) {
                    try {
                        setVerticalGravity Cardinal2 = setVerticalGravity.Cardinal((String) valueOf.getInstance(setlayouttransition2, "use", String.class));
                        String[] configure2 = valueOf.configure(setlayouttransition2, "key_ops");
                        if (configure2 == null) {
                            list2 = null;
                        } else {
                            list2 = Arrays.asList(configure2);
                        }
                        Set<setDividerPadding> configure3 = setDividerPadding.configure(list2);
                        setDownloadListener instance = setDownloadListener.getInstance((String) valueOf.getInstance(setlayouttransition2, "alg", String.class));
                        String str3 = (String) valueOf.getInstance(setlayouttransition2, "kid", String.class);
                        URI instance2 = valueOf.getInstance(setlayouttransition2, "x5u");
                        String str4 = (String) valueOf.getInstance(setlayouttransition2, "x5t", String.class);
                        if (str4 == null) {
                            base64URL4 = null;
                        } else {
                            base64URL4 = new Base64URL(str4);
                        }
                        String str5 = (String) valueOf.getInstance(setlayouttransition2, "x5t#S256", String.class);
                        if (str5 != null) {
                            base64URL5 = new Base64URL(str5);
                        }
                        return new setGravity(cca_continue2, base64URL, Cardinal2, configure3, instance, str3, instance2, base64URL4, base64URL5, setBaselineAligned.Cardinal(setlayouttransition));
                    } catch (IllegalArgumentException e) {
                        throw new ParseException(e.getMessage(), 0);
                    }
                } else {
                    setVerticalGravity Cardinal3 = setVerticalGravity.Cardinal((String) valueOf.getInstance(setlayouttransition2, "use", String.class));
                    String[] configure4 = valueOf.configure(setlayouttransition2, "key_ops");
                    if (configure4 == null) {
                        list = null;
                    } else {
                        list = Arrays.asList(configure4);
                    }
                    Set<setDividerPadding> configure5 = setDividerPadding.configure(list);
                    setDownloadListener instance3 = setDownloadListener.getInstance((String) valueOf.getInstance(setlayouttransition2, "alg", String.class));
                    String str6 = (String) valueOf.getInstance(setlayouttransition2, "kid", String.class);
                    URI instance4 = valueOf.getInstance(setlayouttransition2, "x5u");
                    String str7 = (String) valueOf.getInstance(setlayouttransition2, "x5t", String.class);
                    if (str7 == null) {
                        base64URL3 = null;
                    } else {
                        base64URL3 = new Base64URL(str7);
                    }
                    String str8 = (String) valueOf.getInstance(setlayouttransition2, "x5t#S256", String.class);
                    if (str8 != null) {
                        base64URL5 = new Base64URL(str8);
                    }
                    return new setGravity(cca_continue2, base64URL, base64URL2, Cardinal3, configure5, instance3, str6, instance4, base64URL3, base64URL5, setBaselineAligned.Cardinal(setlayouttransition));
                }
            } catch (IllegalArgumentException e2) {
                throw new ParseException(e2.getMessage(), 0);
            }
        } else {
            throw new ParseException("The key type \"kty\" must be OKP", 0);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof setGravity) || !super.equals(obj)) {
            return false;
        }
        setGravity setgravity = (setGravity) obj;
        return Objects.equals(this.configure, setgravity.configure) && Objects.equals(this.cca_continue, setgravity.cca_continue) && Arrays.equals(this.init, setgravity.init) && Objects.equals(this.Cardinal, setgravity.Cardinal) && Arrays.equals(this.values, setgravity.values);
    }

    public final int hashCode() {
        return (((Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.configure, this.cca_continue, this.Cardinal}) * 31) + Arrays.hashCode(this.init)) * 31) + Arrays.hashCode(this.values);
    }
}
