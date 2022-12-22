package com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.cardinalcommerce.p060a.setBaselineAligned;
import com.cardinalcommerce.p060a.setBaselineAlignedChildIndex;
import com.cardinalcommerce.p060a.setDividerDrawable;
import com.cardinalcommerce.p060a.setDividerPadding;
import com.cardinalcommerce.p060a.setDownloadListener;
import com.cardinalcommerce.p060a.setLayoutTransition;
import com.cardinalcommerce.p060a.setVerticalGravity;
import com.cardinalcommerce.p060a.valueOf;
import com.didi.dimina.container.p106ui.custom.SameLayerRenderingUtil;
import java.math.BigInteger;
import java.net.URI;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class ECKey extends JWK {
    private static Set<Curve> init = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Curve[]{Curve.getInstance, Curve.Cardinal, Curve.init, Curve.cca_continue})));
    private final Curve Cardinal;
    private final Base64URL cca_continue;
    private final PrivateKey cleanup;
    private final Base64URL configure;
    private final Base64URL getInstance;

    public static class cca_continue {
        private final Base64URL Cardinal;
        private final Curve getInstance;
        private final Base64URL init;

        private cca_continue(Curve curve, Base64URL base64URL, Base64URL base64URL2) {
            if (curve != null) {
                this.getInstance = curve;
                if (base64URL != null) {
                    this.init = base64URL;
                    if (base64URL2 != null) {
                        this.Cardinal = base64URL2;
                        return;
                    }
                    throw new IllegalArgumentException("The 'y' coordinate must not be null");
                }
                throw new IllegalArgumentException("The 'x' coordinate must not be null");
            }
            throw new IllegalArgumentException("The curve must not be null");
        }

        public cca_continue(Curve curve, ECPublicKey eCPublicKey) {
            this(curve, ECKey.configure(eCPublicKey.getParams().getCurve().getField().getFieldSize(), eCPublicKey.getW().getAffineX()), ECKey.configure(eCPublicKey.getParams().getCurve().getField().getFieldSize(), eCPublicKey.getW().getAffineY()));
        }

        public final ECKey Cardinal() {
            try {
                return new ECKey(this.getInstance, this.init, this.Cardinal, (setVerticalGravity) null, (Set<setDividerPadding>) null, (setDownloadListener) null, (String) null, (URI) null, (Base64URL) null, (Base64URL) null, (List<Base64>) null, (KeyStore) null);
            } catch (IllegalArgumentException e) {
                throw new IllegalStateException(e.getMessage(), e);
            }
        }
    }

    public static Base64URL configure(int i, BigInteger bigInteger) {
        byte[] init2 = valueOf.init(bigInteger);
        int i2 = (i + 7) / 8;
        if (init2.length >= i2) {
            return Base64URL.cca_continue(init2);
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(init2, 0, bArr, i2 - init2.length, init2.length);
        return Base64URL.cca_continue(bArr);
    }

    private static void Cardinal(Curve curve, Base64URL base64URL, Base64URL base64URL2) {
        if (!init.contains(curve)) {
            throw new IllegalArgumentException("Unknown / unsupported curve: ".concat(String.valueOf(curve)));
        } else if (!valueOf.configure(new BigInteger(1, base64URL.cca_continue()), new BigInteger(1, base64URL2.cca_continue()), setDividerDrawable.Cardinal(curve))) {
            StringBuilder sb = new StringBuilder("Invalid EC JWK: The 'x' and 'y' public coordinates are not on the ");
            sb.append(curve);
            sb.append(" curve");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ECKey(Curve curve, Base64URL base64URL, Base64URL base64URL2, setVerticalGravity setverticalgravity, Set<setDividerPadding> set, setDownloadListener setdownloadlistener, String str, URI uri, Base64URL base64URL3, Base64URL base64URL4, List<Base64> list, KeyStore keyStore) {
        super(setBaselineAlignedChildIndex.getInstance, setverticalgravity, set, setdownloadlistener, str, uri, base64URL3, base64URL4, list, (KeyStore) null);
        Curve curve2 = curve;
        Base64URL base64URL5 = base64URL;
        Base64URL base64URL6 = base64URL2;
        if (curve2 != null) {
            this.Cardinal = curve2;
            if (base64URL5 != null) {
                this.configure = base64URL5;
                if (base64URL6 != null) {
                    this.getInstance = base64URL6;
                    Cardinal(curve, base64URL, base64URL2);
                    List<X509Certificate> instance = getInstance();
                    if (instance != null) {
                        instance.get(0);
                        if (!Cardinal()) {
                            throw new IllegalArgumentException("The public subject key info of the first X.509 certificate in the chain must match the JWK type and public parameters");
                        }
                    }
                    this.cca_continue = null;
                    this.cleanup = null;
                    return;
                }
                throw new IllegalArgumentException("The 'y' coordinate must not be null");
            }
            throw new IllegalArgumentException("The 'x' coordinate must not be null");
        }
        throw new IllegalArgumentException("The curve must not be null");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ECKey(Curve curve, Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, setVerticalGravity setverticalgravity, Set<setDividerPadding> set, setDownloadListener setdownloadlistener, String str, URI uri, Base64URL base64URL4, Base64URL base64URL5, List<Base64> list, KeyStore keyStore) {
        super(setBaselineAlignedChildIndex.getInstance, setverticalgravity, set, setdownloadlistener, str, uri, base64URL4, base64URL5, list, (KeyStore) null);
        Curve curve2 = curve;
        Base64URL base64URL6 = base64URL;
        Base64URL base64URL7 = base64URL2;
        Base64URL base64URL8 = base64URL3;
        if (curve2 != null) {
            this.Cardinal = curve2;
            if (base64URL6 != null) {
                this.configure = base64URL6;
                if (base64URL7 != null) {
                    this.getInstance = base64URL7;
                    Cardinal(curve, base64URL, base64URL2);
                    List<X509Certificate> instance = getInstance();
                    if (instance != null) {
                        instance.get(0);
                        if (!Cardinal()) {
                            throw new IllegalArgumentException("The public subject key info of the first X.509 certificate in the chain must match the JWK type and public parameters");
                        }
                    }
                    if (base64URL8 != null) {
                        this.cca_continue = base64URL8;
                        this.cleanup = null;
                        return;
                    }
                    throw new IllegalArgumentException("The 'd' coordinate must not be null");
                }
                throw new IllegalArgumentException("The 'y' coordinate must not be null");
            }
            throw new IllegalArgumentException("The 'x' coordinate must not be null");
        }
        throw new IllegalArgumentException("The curve must not be null");
    }

    private boolean Cardinal() {
        try {
            ECPublicKey eCPublicKey = (ECPublicKey) getInstance().get(0).getPublicKey();
            if (new BigInteger(1, this.configure.cca_continue()).equals(eCPublicKey.getW().getAffineX()) && new BigInteger(1, this.getInstance.cca_continue()).equals(eCPublicKey.getW().getAffineY())) {
                return true;
            }
            return false;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final boolean init() {
        return this.cca_continue != null;
    }

    public final setLayoutTransition cca_continue() {
        setLayoutTransition cca_continue2 = super.cca_continue();
        cca_continue2.put("crv", this.Cardinal.toString());
        cca_continue2.put("x", this.configure.toString());
        cca_continue2.put(SameLayerRenderingUtil.KEY_COMP_Y, this.getInstance.toString());
        Base64URL base64URL = this.cca_continue;
        if (base64URL != null) {
            cca_continue2.put("d", base64URL.toString());
        }
        return cca_continue2;
    }

    public static ECKey Cardinal(String str) throws ParseException {
        return init(valueOf.init(str));
    }

    public static ECKey init(setLayoutTransition setlayouttransition) throws ParseException {
        Base64URL base64URL;
        Base64URL base64URL2;
        Base64URL base64URL3;
        List list;
        Base64URL base64URL4;
        List list2;
        Base64URL base64URL5;
        setLayoutTransition setlayouttransition2 = setlayouttransition;
        if (setBaselineAlignedChildIndex.getInstance.equals(setBaselineAligned.init(setlayouttransition))) {
            try {
                Curve cca_continue2 = Curve.cca_continue((String) valueOf.getInstance(setlayouttransition2, "crv", String.class));
                String str = (String) valueOf.getInstance(setlayouttransition2, "x", String.class);
                Base64URL base64URL6 = null;
                if (str == null) {
                    base64URL = null;
                } else {
                    base64URL = new Base64URL(str);
                }
                String str2 = (String) valueOf.getInstance(setlayouttransition2, SameLayerRenderingUtil.KEY_COMP_Y, String.class);
                if (str2 == null) {
                    base64URL2 = null;
                } else {
                    base64URL2 = new Base64URL(str2);
                }
                String str3 = (String) valueOf.getInstance(setlayouttransition2, "d", String.class);
                if (str3 == null) {
                    base64URL3 = null;
                } else {
                    base64URL3 = new Base64URL(str3);
                }
                if (base64URL3 == null) {
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
                        String str4 = (String) valueOf.getInstance(setlayouttransition2, "kid", String.class);
                        URI instance2 = valueOf.getInstance(setlayouttransition2, "x5u");
                        String str5 = (String) valueOf.getInstance(setlayouttransition2, "x5t", String.class);
                        if (str5 == null) {
                            base64URL5 = null;
                        } else {
                            base64URL5 = new Base64URL(str5);
                        }
                        String str6 = (String) valueOf.getInstance(setlayouttransition2, "x5t#S256", String.class);
                        if (str6 != null) {
                            base64URL6 = new Base64URL(str6);
                        }
                        return new ECKey(cca_continue2, base64URL, base64URL2, Cardinal2, configure3, instance, str4, instance2, base64URL5, base64URL6, setBaselineAligned.Cardinal(setlayouttransition), (KeyStore) null);
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
                    String str7 = (String) valueOf.getInstance(setlayouttransition2, "kid", String.class);
                    URI instance4 = valueOf.getInstance(setlayouttransition2, "x5u");
                    String str8 = (String) valueOf.getInstance(setlayouttransition2, "x5t", String.class);
                    if (str8 == null) {
                        base64URL4 = null;
                    } else {
                        base64URL4 = new Base64URL(str8);
                    }
                    String str9 = (String) valueOf.getInstance(setlayouttransition2, "x5t#S256", String.class);
                    if (str9 != null) {
                        base64URL6 = new Base64URL(str9);
                    }
                    return new ECKey(cca_continue2, base64URL, base64URL2, base64URL3, Cardinal3, configure5, instance3, str7, instance4, base64URL4, base64URL6, setBaselineAligned.Cardinal(setlayouttransition), (KeyStore) null);
                }
            } catch (IllegalArgumentException e2) {
                throw new ParseException(e2.getMessage(), 0);
            }
        } else {
            throw new ParseException("The key type \"kty\" must be EC", 0);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ECKey) || !super.equals(obj)) {
            return false;
        }
        ECKey eCKey = (ECKey) obj;
        return Objects.equals(this.Cardinal, eCKey.Cardinal) && Objects.equals(this.configure, eCKey.configure) && Objects.equals(this.getInstance, eCKey.getInstance) && Objects.equals(this.cca_continue, eCKey.cca_continue) && Objects.equals((Object) null, (Object) null);
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.Cardinal, this.configure, this.getInstance, this.cca_continue, null});
    }
}
