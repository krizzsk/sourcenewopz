package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.JWK;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.cardinalcommerce.a.setWebChromeClient */
public abstract class setWebChromeClient extends setMapTrackballToArrowKeys {
    private final URI Cardinal;
    private final URI CardinalError;
    private final List<Base64> cleanup;
    private final Base64URL getSDKVersion;
    private final Base64URL getWarnings;
    private final JWK init;
    private final String values;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public setWebChromeClient(setDownloadListener setdownloadlistener, setDataDirectorySuffix setdatadirectorysuffix, String str, Set<String> set, URI uri, JWK jwk, URI uri2, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, String str2, Map<String, Object> map, Base64URL base64URL3) {
        super(setdownloadlistener, setdatadirectorysuffix, str, set, map, base64URL3);
        List<Base64> list2 = list;
        this.Cardinal = uri;
        this.init = jwk;
        this.CardinalError = uri2;
        this.getSDKVersion = base64URL;
        this.getWarnings = base64URL2;
        if (list2 != null) {
            this.cleanup = Collections.unmodifiableList(new ArrayList(list2));
        } else {
            this.cleanup = null;
        }
        this.values = str2;
    }

    public List<Base64> cca_continue() {
        return this.cleanup;
    }

    public setLayoutTransition init() {
        setLayoutTransition init2 = super.init();
        URI uri = this.Cardinal;
        if (uri != null) {
            init2.put("jku", uri.toString());
        }
        JWK jwk = this.init;
        if (jwk != null) {
            init2.put("jwk", jwk.cca_continue());
        }
        URI uri2 = this.CardinalError;
        if (uri2 != null) {
            init2.put("x5u", uri2.toString());
        }
        Base64URL base64URL = this.getSDKVersion;
        if (base64URL != null) {
            init2.put("x5t", base64URL.toString());
        }
        Base64URL base64URL2 = this.getWarnings;
        if (base64URL2 != null) {
            init2.put("x5t#S256", base64URL2.toString());
        }
        List<Base64> list = this.cleanup;
        if (list != null && !list.isEmpty()) {
            init2.put("x5c", this.cleanup);
        }
        String str = this.values;
        if (str != null) {
            init2.put("kid", str);
        }
        return init2;
    }
}
