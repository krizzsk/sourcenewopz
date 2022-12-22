package com.cardinalcommerce.dependencies.internal.nimbusds.jose;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.cardinalcommerce.p060a.setButtonTintList;
import com.cardinalcommerce.p060a.setMinWidth;
import com.cardinalcommerce.p060a.setRendererPriorityPolicy;
import java.text.ParseException;

public class JWSObject extends setRendererPriorityPolicy {
    private C2156configure Cardinal;
    public final setButtonTintList configure;
    private Base64URL getInstance;
    private final String init;

    /* renamed from: com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSObject$configure */
    public enum C2156configure {
        UNSIGNED,
        SIGNED,
        VERIFIED
    }

    private JWSObject(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3) throws ParseException {
        this(base64URL, new Payload(base64URL2), base64URL3);
    }

    private JWSObject(Base64URL base64URL, Payload payload, Base64URL base64URL2) throws ParseException {
        String str;
        Base64URL base64URL3;
        Base64URL base64URL4;
        Base64URL base64URL5;
        if (base64URL != null) {
            try {
                this.configure = setButtonTintList.Cardinal(base64URL);
                this.cca_continue = payload;
                if (this.configure.Cardinal()) {
                    StringBuilder sb = new StringBuilder();
                    setButtonTintList setbuttontintlist = this.configure;
                    if (setbuttontintlist.getInstance == null) {
                        base64URL4 = Base64URL.init(setbuttontintlist.toString());
                    } else {
                        base64URL4 = setbuttontintlist.getInstance;
                    }
                    sb.append(base64URL4.toString());
                    sb.append('.');
                    Payload payload2 = this.cca_continue;
                    if (payload2.getInstance != null) {
                        base64URL5 = payload2.getInstance;
                    } else {
                        base64URL5 = Base64URL.cca_continue(payload2.getInstance());
                    }
                    sb.append(base64URL5.toString());
                    str = sb.toString();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    setButtonTintList setbuttontintlist2 = this.configure;
                    if (setbuttontintlist2.getInstance == null) {
                        base64URL3 = Base64URL.init(setbuttontintlist2.toString());
                    } else {
                        base64URL3 = setbuttontintlist2.getInstance;
                    }
                    sb2.append(base64URL3.toString());
                    sb2.append('.');
                    sb2.append(this.cca_continue.toString());
                    str = sb2.toString();
                }
                this.init = str;
                if (base64URL2 != null) {
                    this.getInstance = base64URL2;
                    this.Cardinal = C2156configure.SIGNED;
                    if (!this.configure.Cardinal()) {
                        new Base64URL("");
                    } else if (payload.getInstance != null) {
                        Base64URL base64URL6 = payload.getInstance;
                    } else {
                        Base64URL.cca_continue(payload.getInstance());
                    }
                } else {
                    throw new IllegalArgumentException("The third part must not be null");
                }
            } catch (ParseException e) {
                StringBuilder sb3 = new StringBuilder("Invalid JWS header: ");
                sb3.append(e.getMessage());
                throw new ParseException(sb3.toString(), 0);
            }
        } else {
            throw new IllegalArgumentException("The first part must not be null");
        }
    }

    private byte[] getInstance() {
        return this.init.getBytes(setMinWidth.getInstance);
    }

    public static JWSObject cca_continue(String str) throws ParseException {
        Base64URL[] configure2 = setRendererPriorityPolicy.configure(str);
        if (configure2.length == 3) {
            return new JWSObject(configure2[0], configure2[1], configure2[2]);
        }
        throw new ParseException("Unexpected number of Base64URL parts, must be three", 0);
    }

    public final synchronized boolean configure(JWSVerifier jWSVerifier) throws JOSEException {
        boolean configure2;
        if (this.Cardinal != C2156configure.SIGNED) {
            if (this.Cardinal != C2156configure.VERIFIED) {
                throw new IllegalStateException("The JWS object must be in a signed or verified state");
            }
        }
        try {
            configure2 = jWSVerifier.configure(this.configure, getInstance(), this.getInstance);
            if (configure2) {
                this.Cardinal = C2156configure.VERIFIED;
            }
        } catch (JOSEException e) {
            throw e;
        } catch (Exception e2) {
            throw new JOSEException(e2.getMessage(), e2);
        }
        return configure2;
    }
}
