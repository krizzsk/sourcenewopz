package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.JWK;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import java.net.URI;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.cardinalcommerce.a.setButtonTintList */
public final class setButtonTintList extends setWebChromeClient {
    private static final Set<String> init;
    private final boolean Cardinal;

    public final /* bridge */ /* synthetic */ List cca_continue() {
        return super.cca_continue();
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("alg");
        hashSet.add("jku");
        hashSet.add("jwk");
        hashSet.add("x5u");
        hashSet.add("x5t");
        hashSet.add("x5t#S256");
        hashSet.add("x5c");
        hashSet.add("kid");
        hashSet.add("typ");
        hashSet.add("cty");
        hashSet.add("crit");
        hashSet.add("b64");
        init = Collections.unmodifiableSet(hashSet);
    }

    /* renamed from: com.cardinalcommerce.a.setButtonTintList$init */
    public static class C2036init {
        final JWSAlgorithm Cardinal;
        Map<String, Object> CardinalEnvironment;
        List<Base64> CardinalError;
        Base64URL CardinalRenderType;
        boolean CardinalUiType = true;
        setDataDirectorySuffix cca_continue;
        Base64URL cleanup;
        URI configure;
        Set<String> getInstance;
        URI getSDKVersion;
        @Deprecated
        Base64URL getWarnings;
        String init;
        String valueOf;
        JWK values;

        public C2036init(JWSAlgorithm jWSAlgorithm) {
            if (!jWSAlgorithm.cca_continue.equals(setDownloadListener.configure.cca_continue)) {
                this.Cardinal = jWSAlgorithm;
                return;
            }
            throw new IllegalArgumentException("The JWS algorithm \"alg\" cannot be \"none\"");
        }
    }

    private setButtonTintList(JWSAlgorithm jWSAlgorithm, setDataDirectorySuffix setdatadirectorysuffix, String str, Set<String> set, URI uri, JWK jwk, URI uri2, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, String str2, boolean z, Map<String, Object> map, Base64URL base64URL3) {
        super(jWSAlgorithm, setdatadirectorysuffix, str, set, uri, jwk, uri2, base64URL, base64URL2, list, str2, map, base64URL3);
        if (!jWSAlgorithm.cca_continue.equals(setDownloadListener.configure.cca_continue)) {
            this.Cardinal = z;
            return;
        }
        throw new IllegalArgumentException("The JWS algorithm \"alg\" cannot be \"none\"");
    }

    public final JWSAlgorithm getInstance() {
        return (JWSAlgorithm) super.configure();
    }

    public final boolean Cardinal() {
        return this.Cardinal;
    }

    public final setLayoutTransition init() {
        setLayoutTransition init2 = super.init();
        if (!Cardinal()) {
            init2.put("b64", Boolean.FALSE);
        }
        return init2;
    }

    public static setButtonTintList Cardinal(Base64URL base64URL) throws ParseException {
        List list;
        setLayoutTransition init2 = valueOf.init(new String(base64URL.cca_continue(), setMinWidth.getInstance));
        setDownloadListener Cardinal2 = setMapTrackballToArrowKeys.Cardinal(init2);
        if (Cardinal2 instanceof JWSAlgorithm) {
            C2036init init3 = new C2036init((JWSAlgorithm) Cardinal2);
            init3.CardinalRenderType = base64URL;
            for (String str : init2.keySet()) {
                if (!"alg".equals(str)) {
                    if ("typ".equals(str)) {
                        String str2 = (String) valueOf.getInstance(init2, str, String.class);
                        if (str2 != null) {
                            init3.cca_continue = new setDataDirectorySuffix(str2);
                        }
                    } else if ("cty".equals(str)) {
                        init3.init = (String) valueOf.getInstance(init2, str, String.class);
                    } else if ("crit".equals(str)) {
                        String[] configure = valueOf.configure(init2, str);
                        if (configure == null) {
                            list = null;
                        } else {
                            list = Arrays.asList(configure);
                        }
                        if (list != null) {
                            init3.getInstance = new HashSet(list);
                        }
                    } else if ("jku".equals(str)) {
                        init3.configure = valueOf.getInstance(init2, str);
                    } else if ("jwk".equals(str)) {
                        setLayoutTransition setlayouttransition = (setLayoutTransition) valueOf.getInstance(init2, str, setLayoutTransition.class);
                        if (setlayouttransition != null) {
                            init3.values = JWK.cca_continue(setlayouttransition);
                        }
                    } else if ("x5u".equals(str)) {
                        init3.getSDKVersion = valueOf.getInstance(init2, str);
                    } else if ("x5t".equals(str)) {
                        init3.getWarnings = Base64URL.getInstance((String) valueOf.getInstance(init2, str, String.class));
                    } else if ("x5t#S256".equals(str)) {
                        init3.cleanup = Base64URL.getInstance((String) valueOf.getInstance(init2, str, String.class));
                    } else if ("x5c".equals(str)) {
                        init3.CardinalError = valueOf.Cardinal((setDescendantFocusability) valueOf.getInstance(init2, str, setDescendantFocusability.class));
                    } else if ("kid".equals(str)) {
                        init3.valueOf = (String) valueOf.getInstance(init2, str, String.class);
                    } else if ("b64".equals(str)) {
                        init3.CardinalUiType = valueOf.init(init2, str);
                    } else {
                        Object obj = init2.get(str);
                        if (!init.contains(str)) {
                            if (init3.CardinalEnvironment == null) {
                                init3.CardinalEnvironment = new HashMap();
                            }
                            init3.CardinalEnvironment.put(str, obj);
                        } else {
                            StringBuilder sb = new StringBuilder("The parameter name \"");
                            sb.append(str);
                            sb.append("\" matches a registered name");
                            throw new IllegalArgumentException(sb.toString());
                        }
                    }
                }
            }
            return new setButtonTintList(init3.Cardinal, init3.cca_continue, init3.init, init3.getInstance, init3.configure, init3.values, init3.getSDKVersion, init3.getWarnings, init3.cleanup, init3.CardinalError, init3.valueOf, init3.CardinalUiType, init3.CardinalEnvironment, init3.CardinalRenderType);
        }
        throw new ParseException("Not a JWS header", 0);
    }

    public final /* bridge */ /* synthetic */ setDownloadListener configure() {
        return (JWSAlgorithm) super.configure();
    }
}
