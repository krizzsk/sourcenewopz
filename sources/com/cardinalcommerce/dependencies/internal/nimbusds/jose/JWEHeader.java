package com.cardinalcommerce.dependencies.internal.nimbusds.jose;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.JWK;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.cardinalcommerce.p060a.setDataDirectorySuffix;
import com.cardinalcommerce.p060a.setDescendantFocusability;
import com.cardinalcommerce.p060a.setDownloadListener;
import com.cardinalcommerce.p060a.setLayoutTransition;
import com.cardinalcommerce.p060a.setMapTrackballToArrowKeys;
import com.cardinalcommerce.p060a.setMinWidth;
import com.cardinalcommerce.p060a.setPictureListener;
import com.cardinalcommerce.p060a.setWebChromeClient;
import com.cardinalcommerce.p060a.valueOf;
import com.didi.dynamic.manager.DownloadManager;
import java.net.URI;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class JWEHeader extends setWebChromeClient {
    private static final Set<String> CardinalError;
    public final setPictureListener Cardinal;
    private final Base64URL CardinalActionCode;
    private final int CardinalEnvironment;
    private final Base64URL cleanup;
    private final JWK getSDKVersion;
    private final Base64URL getWarnings;
    public final EncryptionMethod init;
    private final Base64URL valueOf;
    private final Base64URL values;

    public final /* bridge */ /* synthetic */ List cca_continue() {
        return super.cca_continue();
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("alg");
        hashSet.add("enc");
        hashSet.add("epk");
        hashSet.add(DownloadManager.MODULE_DIR_ZIP);
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
        hashSet.add("apu");
        hashSet.add("apv");
        hashSet.add("p2s");
        hashSet.add("p2c");
        hashSet.add("iv");
        hashSet.add("authTag");
        CardinalError = Collections.unmodifiableSet(hashSet);
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEHeader$configure */
    public static class C2155configure {
        URI Cardinal;
        Base64URL CardinalActionCode;
        int CardinalConfigurationParameters;
        public JWK CardinalEnvironment;
        public String CardinalError;
        Base64URL CardinalRenderType;
        setPictureListener CardinalUiType;
        setDataDirectorySuffix cca_continue;
        Base64URL cleanup;
        JWK configure;
        Map<String, Object> getActionCode;
        private final EncryptionMethod getChallengeTimeout;
        String getInstance;
        Base64URL getRequestTimeout;
        URI getSDKVersion;
        Base64URL getString;
        @Deprecated
        Base64URL getWarnings;
        Set<String> init;
        private final JWEAlgorithm setChallengeTimeout;
        Base64URL setRequestTimeout;
        Base64URL valueOf;
        List<Base64> values;

        public C2155configure(JWEAlgorithm jWEAlgorithm, EncryptionMethod encryptionMethod) {
            if (!jWEAlgorithm.cca_continue.equals(setDownloadListener.configure.cca_continue)) {
                this.setChallengeTimeout = jWEAlgorithm;
                if (encryptionMethod != null) {
                    this.getChallengeTimeout = encryptionMethod;
                    return;
                }
                throw new IllegalArgumentException("The encryption method \"enc\" parameter must not be null");
            }
            throw new IllegalArgumentException("The JWE algorithm \"alg\" cannot be \"none\"");
        }

        public final JWEHeader cca_continue() {
            return new JWEHeader(this.setChallengeTimeout, this.getChallengeTimeout, this.cca_continue, this.getInstance, this.init, this.Cardinal, this.configure, this.getSDKVersion, this.getWarnings, this.cleanup, this.values, this.CardinalError, this.CardinalEnvironment, this.CardinalUiType, this.CardinalActionCode, this.valueOf, this.CardinalRenderType, this.CardinalConfigurationParameters, this.getString, this.setRequestTimeout, this.getActionCode, this.getRequestTimeout);
        }
    }

    public JWEHeader(JWEAlgorithm jWEAlgorithm, EncryptionMethod encryptionMethod) {
        this(jWEAlgorithm, encryptionMethod, (setDataDirectorySuffix) null, (String) null, (Set<String>) null, (URI) null, (JWK) null, (URI) null, (Base64URL) null, (Base64URL) null, (List<Base64>) null, (String) null, (JWK) null, (setPictureListener) null, (Base64URL) null, (Base64URL) null, (Base64URL) null, 0, (Base64URL) null, (Base64URL) null, (Map<String, Object>) null, (Base64URL) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JWEHeader(setDownloadListener setdownloadlistener, EncryptionMethod encryptionMethod, setDataDirectorySuffix setdatadirectorysuffix, String str, Set<String> set, URI uri, JWK jwk, URI uri2, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, String str2, JWK jwk2, setPictureListener setpicturelistener, Base64URL base64URL3, Base64URL base64URL4, Base64URL base64URL5, int i, Base64URL base64URL6, Base64URL base64URL7, Map<String, Object> map, Base64URL base64URL8) {
        super(setdownloadlistener, setdatadirectorysuffix, str, set, uri, jwk, uri2, base64URL, base64URL2, list, str2, map, base64URL8);
        EncryptionMethod encryptionMethod2 = encryptionMethod;
        JWK jwk3 = jwk2;
        if (setdownloadlistener.cca_continue.equals(setDownloadListener.configure.cca_continue)) {
            throw new IllegalArgumentException("The JWE algorithm cannot be \"none\"");
        } else if (encryptionMethod2 == null) {
            throw new IllegalArgumentException("The encryption method \"enc\" parameter must not be null");
        } else if (jwk3 == null || !jwk2.init()) {
            this.init = encryptionMethod2;
            this.getSDKVersion = jwk3;
            this.Cardinal = setpicturelistener;
            this.values = base64URL3;
            this.getWarnings = base64URL4;
            this.cleanup = base64URL5;
            this.CardinalEnvironment = i;
            this.valueOf = base64URL6;
            this.CardinalActionCode = base64URL7;
        } else {
            throw new IllegalArgumentException("Ephemeral public key should not be a private key");
        }
    }

    public final JWEAlgorithm Cardinal() {
        return (JWEAlgorithm) super.configure();
    }

    public final setLayoutTransition init() {
        setLayoutTransition init2 = super.init();
        EncryptionMethod encryptionMethod = this.init;
        if (encryptionMethod != null) {
            init2.put("enc", encryptionMethod.toString());
        }
        JWK jwk = this.getSDKVersion;
        if (jwk != null) {
            init2.put("epk", jwk.cca_continue());
        }
        setPictureListener setpicturelistener = this.Cardinal;
        if (setpicturelistener != null) {
            init2.put(DownloadManager.MODULE_DIR_ZIP, setpicturelistener.toString());
        }
        Base64URL base64URL = this.values;
        if (base64URL != null) {
            init2.put("apu", base64URL.toString());
        }
        Base64URL base64URL2 = this.getWarnings;
        if (base64URL2 != null) {
            init2.put("apv", base64URL2.toString());
        }
        Base64URL base64URL3 = this.cleanup;
        if (base64URL3 != null) {
            init2.put("p2s", base64URL3.toString());
        }
        int i = this.CardinalEnvironment;
        if (i > 0) {
            init2.put("p2c", Integer.valueOf(i));
        }
        Base64URL base64URL4 = this.valueOf;
        if (base64URL4 != null) {
            init2.put("iv", base64URL4.toString());
        }
        Base64URL base64URL5 = this.CardinalActionCode;
        if (base64URL5 != null) {
            init2.put("tag", base64URL5.toString());
        }
        return init2;
    }

    public static JWEHeader getInstance(Base64URL base64URL) throws ParseException {
        List list;
        setLayoutTransition init2 = valueOf.init(new String(base64URL.cca_continue(), setMinWidth.getInstance));
        setDownloadListener Cardinal2 = setMapTrackballToArrowKeys.Cardinal(init2);
        if (Cardinal2 instanceof JWEAlgorithm) {
            C2155configure configure = new C2155configure((JWEAlgorithm) Cardinal2, EncryptionMethod.Cardinal((String) valueOf.getInstance(init2, "enc", String.class)));
            configure.getRequestTimeout = base64URL;
            for (String str : init2.keySet()) {
                if (!"alg".equals(str) && !"enc".equals(str)) {
                    if ("typ".equals(str)) {
                        String str2 = (String) valueOf.getInstance(init2, str, String.class);
                        if (str2 != null) {
                            configure.cca_continue = new setDataDirectorySuffix(str2);
                        }
                    } else if ("cty".equals(str)) {
                        configure.getInstance = (String) valueOf.getInstance(init2, str, String.class);
                    } else if ("crit".equals(str)) {
                        String[] configure2 = valueOf.configure(init2, str);
                        if (configure2 == null) {
                            list = null;
                        } else {
                            list = Arrays.asList(configure2);
                        }
                        if (list != null) {
                            configure.init = new HashSet(list);
                        }
                    } else if ("jku".equals(str)) {
                        configure.Cardinal = valueOf.getInstance(init2, str);
                    } else if ("jwk".equals(str)) {
                        setLayoutTransition setlayouttransition = (setLayoutTransition) valueOf.getInstance(init2, str, setLayoutTransition.class);
                        if (setlayouttransition != null) {
                            configure.configure = JWK.cca_continue(setlayouttransition);
                        }
                    } else if ("x5u".equals(str)) {
                        configure.getSDKVersion = valueOf.getInstance(init2, str);
                    } else if ("x5t".equals(str)) {
                        configure.getWarnings = Base64URL.getInstance((String) valueOf.getInstance(init2, str, String.class));
                    } else if ("x5t#S256".equals(str)) {
                        configure.cleanup = Base64URL.getInstance((String) valueOf.getInstance(init2, str, String.class));
                    } else if ("x5c".equals(str)) {
                        configure.values = valueOf.Cardinal((setDescendantFocusability) valueOf.getInstance(init2, str, setDescendantFocusability.class));
                    } else if ("kid".equals(str)) {
                        configure.CardinalError = (String) valueOf.getInstance(init2, str, String.class);
                    } else if ("epk".equals(str)) {
                        configure.CardinalEnvironment = JWK.cca_continue((setLayoutTransition) valueOf.getInstance(init2, str, setLayoutTransition.class));
                    } else if (DownloadManager.MODULE_DIR_ZIP.equals(str)) {
                        String str3 = (String) valueOf.getInstance(init2, str, String.class);
                        if (str3 != null) {
                            configure.CardinalUiType = new setPictureListener(str3);
                        }
                    } else if ("apu".equals(str)) {
                        configure.CardinalActionCode = Base64URL.getInstance((String) valueOf.getInstance(init2, str, String.class));
                    } else if ("apv".equals(str)) {
                        configure.valueOf = Base64URL.getInstance((String) valueOf.getInstance(init2, str, String.class));
                    } else if ("p2s".equals(str)) {
                        configure.CardinalRenderType = Base64URL.getInstance((String) valueOf.getInstance(init2, str, String.class));
                    } else if ("p2c".equals(str)) {
                        Number number = (Number) valueOf.getInstance(init2, str, Number.class);
                        if (number != null) {
                            int intValue = number.intValue();
                            if (intValue >= 0) {
                                configure.CardinalConfigurationParameters = intValue;
                            } else {
                                throw new IllegalArgumentException("The PBES2 count parameter must not be negative");
                            }
                        } else {
                            StringBuilder sb = new StringBuilder("JSON object member with key \"");
                            sb.append(str);
                            sb.append("\" is missing or null");
                            throw new ParseException(sb.toString(), 0);
                        }
                    } else if ("iv".equals(str)) {
                        configure.getString = Base64URL.getInstance((String) valueOf.getInstance(init2, str, String.class));
                    } else if ("tag".equals(str)) {
                        configure.setRequestTimeout = Base64URL.getInstance((String) valueOf.getInstance(init2, str, String.class));
                    } else {
                        Object obj = init2.get(str);
                        if (!CardinalError.contains(str)) {
                            if (configure.getActionCode == null) {
                                configure.getActionCode = new HashMap();
                            }
                            configure.getActionCode.put(str, obj);
                        } else {
                            StringBuilder sb2 = new StringBuilder("The parameter name \"");
                            sb2.append(str);
                            sb2.append("\" matches a registered name");
                            throw new IllegalArgumentException(sb2.toString());
                        }
                    }
                }
            }
            return configure.cca_continue();
        }
        throw new ParseException("The algorithm \"alg\" header parameter must be for encryption", 0);
    }

    public final /* bridge */ /* synthetic */ setDownloadListener configure() {
        return (JWEAlgorithm) super.configure();
    }
}
