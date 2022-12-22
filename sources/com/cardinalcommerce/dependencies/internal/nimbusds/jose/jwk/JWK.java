package com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.cardinalcommerce.p060a.setBaselineAlignedChildIndex;
import com.cardinalcommerce.p060a.setDescendantFocusability;
import com.cardinalcommerce.p060a.setDividerPadding;
import com.cardinalcommerce.p060a.setDownloadListener;
import com.cardinalcommerce.p060a.setGravity;
import com.cardinalcommerce.p060a.setHorizontalGravity;
import com.cardinalcommerce.p060a.setLayoutTransition;
import com.cardinalcommerce.p060a.setMotionEventSplittingEnabled;
import com.cardinalcommerce.p060a.setOrientation;
import com.cardinalcommerce.p060a.setVerticalGravity;
import com.cardinalcommerce.p060a.setWeightSum;
import com.cardinalcommerce.p060a.valueOf;
import java.io.Serializable;
import java.net.URI;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public abstract class JWK implements setMotionEventSplittingEnabled, Serializable {
    private final Set<setDividerPadding> Cardinal;
    private final URI CardinalError;
    private final KeyStore CardinalUiType;
    private final setBaselineAlignedChildIndex cca_continue;
    private final List<Base64> cleanup;
    private final String configure;
    private final setVerticalGravity getInstance;
    @Deprecated
    private final Base64URL getSDKVersion;
    private Base64URL getWarnings;
    private final setDownloadListener init;
    private final List<X509Certificate> values;

    public abstract boolean init();

    public JWK(setBaselineAlignedChildIndex setbaselinealignedchildindex, setVerticalGravity setverticalgravity, Set<setDividerPadding> set, setDownloadListener setdownloadlistener, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, KeyStore keyStore) {
        if (setbaselinealignedchildindex != null) {
            this.cca_continue = setbaselinealignedchildindex;
            if (setWeightSum.cca_continue(setverticalgravity, set)) {
                this.getInstance = setverticalgravity;
                this.Cardinal = set;
                this.init = setdownloadlistener;
                this.configure = str;
                this.CardinalError = uri;
                this.getSDKVersion = base64URL;
                this.getWarnings = base64URL2;
                if (list == null || !list.isEmpty()) {
                    this.cleanup = list;
                    try {
                        this.values = valueOf.getInstance(list);
                        this.CardinalUiType = keyStore;
                    } catch (ParseException e) {
                        StringBuilder sb = new StringBuilder("Invalid X.509 certificate chain \"x5c\": ");
                        sb.append(e.getMessage());
                        throw new IllegalArgumentException(sb.toString(), e);
                    }
                } else {
                    throw new IllegalArgumentException("The X.509 certificate chain \"x5c\" must not be empty");
                }
            } else {
                throw new IllegalArgumentException("The key use \"use\" and key options \"key_opts\" parameters are not consistent, see RFC 7517, section 4.3");
            }
        } else {
            throw new IllegalArgumentException("The key type \"kty\" parameter must not be null");
        }
    }

    public final List<X509Certificate> getInstance() {
        List<X509Certificate> list = this.values;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public setLayoutTransition cca_continue() {
        setLayoutTransition setlayouttransition = new setLayoutTransition();
        setlayouttransition.put("kty", this.cca_continue.configure);
        setVerticalGravity setverticalgravity = this.getInstance;
        if (setverticalgravity != null) {
            setlayouttransition.put("use", setverticalgravity.configure);
        }
        if (this.Cardinal != null) {
            setDescendantFocusability setdescendantfocusability = new setDescendantFocusability();
            for (setDividerPadding setdividerpadding : this.Cardinal) {
                setdescendantfocusability.add(setdividerpadding.identifier);
            }
            setlayouttransition.put("key_ops", setdescendantfocusability);
        }
        setDownloadListener setdownloadlistener = this.init;
        if (setdownloadlistener != null) {
            setlayouttransition.put("alg", setdownloadlistener.cca_continue);
        }
        String str = this.configure;
        if (str != null) {
            setlayouttransition.put("kid", str);
        }
        URI uri = this.CardinalError;
        if (uri != null) {
            setlayouttransition.put("x5u", uri.toString());
        }
        Base64URL base64URL = this.getSDKVersion;
        if (base64URL != null) {
            setlayouttransition.put("x5t", base64URL.toString());
        }
        Base64URL base64URL2 = this.getWarnings;
        if (base64URL2 != null) {
            setlayouttransition.put("x5t#S256", base64URL2.toString());
        }
        if (this.cleanup != null) {
            setDescendantFocusability setdescendantfocusability2 = new setDescendantFocusability();
            for (Base64 obj : this.cleanup) {
                setdescendantfocusability2.add(obj.toString());
            }
            setlayouttransition.put("x5c", setdescendantfocusability2);
        }
        return setlayouttransition;
    }

    public final String configure() {
        return cca_continue().toString();
    }

    public String toString() {
        return cca_continue().toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JWK)) {
            return false;
        }
        JWK jwk = (JWK) obj;
        return Objects.equals(this.cca_continue, jwk.cca_continue) && Objects.equals(this.getInstance, jwk.getInstance) && Objects.equals(this.Cardinal, jwk.Cardinal) && Objects.equals(this.init, jwk.init) && Objects.equals(this.configure, jwk.configure) && Objects.equals(this.CardinalError, jwk.CardinalError) && Objects.equals(this.getSDKVersion, jwk.getSDKVersion) && Objects.equals(this.getWarnings, jwk.getWarnings) && Objects.equals(this.cleanup, jwk.cleanup) && Objects.equals(this.CardinalUiType, jwk.CardinalUiType);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.cca_continue, this.getInstance, this.Cardinal, this.init, this.configure, this.CardinalError, this.getSDKVersion, this.getWarnings, this.cleanup, this.CardinalUiType});
    }

    public static JWK cca_continue(setLayoutTransition setlayouttransition) throws ParseException {
        setBaselineAlignedChildIndex init2 = setBaselineAlignedChildIndex.init((String) valueOf.getInstance(setlayouttransition, "kty", String.class));
        if (init2 == setBaselineAlignedChildIndex.getInstance) {
            return ECKey.init(setlayouttransition);
        }
        if (init2 == setBaselineAlignedChildIndex.Cardinal) {
            return setOrientation.getInstance(setlayouttransition);
        }
        if (init2 == setBaselineAlignedChildIndex.init) {
            return setHorizontalGravity.init(setlayouttransition);
        }
        if (init2 == setBaselineAlignedChildIndex.cca_continue) {
            return setGravity.init(setlayouttransition);
        }
        throw new ParseException("Unsupported key type \"kty\" parameter: ".concat(String.valueOf(init2)), 0);
    }
}
