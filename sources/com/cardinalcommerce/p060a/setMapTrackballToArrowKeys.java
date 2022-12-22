package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.cardinalcommerce.a.setMapTrackballToArrowKeys */
public abstract class setMapTrackballToArrowKeys implements Serializable {
    private static final Map<String, Object> CardinalError = Collections.unmodifiableMap(new HashMap());
    private final setDataDirectorySuffix Cardinal;
    public final Map<String, Object> cca_continue;
    public final Set<String> configure;
    public final Base64URL getInstance;
    private final String getSDKVersion;
    private final setDownloadListener init;

    protected setMapTrackballToArrowKeys(setDownloadListener setdownloadlistener, setDataDirectorySuffix setdatadirectorysuffix, String str, Set<String> set, Map<String, Object> map, Base64URL base64URL) {
        if (setdownloadlistener != null) {
            this.init = setdownloadlistener;
            this.Cardinal = setdatadirectorysuffix;
            this.getSDKVersion = str;
            if (set != null) {
                this.configure = Collections.unmodifiableSet(new HashSet(set));
            } else {
                this.configure = null;
            }
            if (map != null) {
                this.cca_continue = Collections.unmodifiableMap(new HashMap(map));
            } else {
                this.cca_continue = CardinalError;
            }
            this.getInstance = base64URL;
            return;
        }
        throw new IllegalArgumentException("The algorithm \"alg\" header parameter must not be null");
    }

    public setDownloadListener configure() {
        return this.init;
    }

    public setLayoutTransition init() {
        setLayoutTransition setlayouttransition = new setLayoutTransition(this.cca_continue);
        setlayouttransition.put("alg", this.init.toString());
        setDataDirectorySuffix setdatadirectorysuffix = this.Cardinal;
        if (setdatadirectorysuffix != null) {
            setlayouttransition.put("typ", setdatadirectorysuffix.toString());
        }
        String str = this.getSDKVersion;
        if (str != null) {
            setlayouttransition.put("cty", str);
        }
        Set<String> set = this.configure;
        if (set != null && !set.isEmpty()) {
            setDescendantFocusability setdescendantfocusability = new setDescendantFocusability();
            for (String add : this.configure) {
                setdescendantfocusability.add(add);
            }
            setlayouttransition.put("crit", setdescendantfocusability);
        }
        return setlayouttransition;
    }

    public String toString() {
        return init().toString();
    }

    public static setDownloadListener Cardinal(setLayoutTransition setlayouttransition) throws ParseException {
        String str = (String) valueOf.getInstance(setlayouttransition, "alg", String.class);
        if (str == null) {
            throw new ParseException("Missing \"alg\" in header JSON object", 0);
        } else if (str.equals(setDownloadListener.configure.cca_continue)) {
            return setDownloadListener.configure;
        } else {
            if (setlayouttransition.containsKey("enc")) {
                return JWEAlgorithm.cca_continue(str);
            }
            return JWSAlgorithm.cca_continue(str);
        }
    }
}
