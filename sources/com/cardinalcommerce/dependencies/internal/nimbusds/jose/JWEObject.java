package com.cardinalcommerce.dependencies.internal.nimbusds.jose;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.cardinalcommerce.p060a.setChecked;
import com.cardinalcommerce.p060a.setRendererPriorityPolicy;
import com.cardinalcommerce.p060a.setTextClassifier;
import java.text.ParseException;

public class JWEObject extends setRendererPriorityPolicy {
    private Base64URL Cardinal;
    private Base64URL configure;
    private Base64URL getInstance;
    private Base64URL getSDKVersion;
    private cca_continue getWarnings;
    private JWEHeader init;

    public enum cca_continue {
        UNENCRYPTED,
        ENCRYPTED,
        DECRYPTED
    }

    public JWEObject(JWEHeader jWEHeader, Payload payload) {
        if (jWEHeader != null) {
            this.init = jWEHeader;
            this.cca_continue = payload;
            this.getInstance = null;
            this.configure = null;
            this.getWarnings = cca_continue.UNENCRYPTED;
            return;
        }
        throw new IllegalArgumentException("The JWE header must not be null");
    }

    private JWEObject(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4, Base64URL base64URL5) throws ParseException {
        if (base64URL != null) {
            try {
                this.init = JWEHeader.getInstance(base64URL);
                if (base64URL2 == null || base64URL2.toString().isEmpty()) {
                    this.getInstance = null;
                } else {
                    this.getInstance = base64URL2;
                }
                if (base64URL3 == null || base64URL3.toString().isEmpty()) {
                    this.Cardinal = null;
                } else {
                    this.Cardinal = base64URL3;
                }
                if (base64URL4 != null) {
                    this.configure = base64URL4;
                    if (base64URL5 == null || base64URL5.toString().isEmpty()) {
                        this.getSDKVersion = null;
                    } else {
                        this.getSDKVersion = base64URL5;
                    }
                    this.getWarnings = cca_continue.ENCRYPTED;
                    return;
                }
                throw new IllegalArgumentException("The fourth part must not be null");
            } catch (ParseException e) {
                StringBuilder sb = new StringBuilder("Invalid JWE header: ");
                sb.append(e.getMessage());
                throw new ParseException(sb.toString(), 0);
            }
        } else {
            throw new IllegalArgumentException("The first part must not be null");
        }
    }

    public static JWEObject Cardinal(String str) throws ParseException {
        Base64URL[] configure2 = setRendererPriorityPolicy.configure(str);
        if (configure2.length == 5) {
            return new JWEObject(configure2[0], configure2[1], configure2[2], configure2[3], configure2[4]);
        }
        throw new ParseException("Unexpected number of Base64URL parts, must be five", 0);
    }

    public final synchronized void init(setTextClassifier settextclassifier) throws JOSEException {
        if (this.getWarnings != cca_continue.UNENCRYPTED) {
            throw new IllegalStateException("The JWE object must be in an unencrypted state");
        } else if (!settextclassifier.configure().contains(this.init.Cardinal())) {
            StringBuilder sb = new StringBuilder("The \"");
            sb.append(this.init.Cardinal());
            sb.append("\" algorithm is not supported by the JWE encrypter: Supported algorithms: ");
            sb.append(settextclassifier.configure());
            throw new JOSEException(sb.toString());
        } else if (settextclassifier.getInstance().contains(this.init.init)) {
            try {
                JWECryptoParts Cardinal2 = settextclassifier.Cardinal(this.init, this.cca_continue.getInstance());
                if (Cardinal2.f3230a != null) {
                    this.init = Cardinal2.f3230a;
                }
                this.getInstance = Cardinal2.f3231b;
                this.Cardinal = Cardinal2.f3232c;
                this.configure = Cardinal2.f3233d;
                this.getSDKVersion = Cardinal2.f3234e;
                this.getWarnings = cca_continue.ENCRYPTED;
            } catch (JOSEException e) {
                throw e;
            } catch (Exception e2) {
                throw new JOSEException(e2.getMessage(), e2);
            }
        } else {
            StringBuilder sb2 = new StringBuilder("The \"");
            sb2.append(this.init.init);
            sb2.append("\" encryption method or key size is not supported by the JWE encrypter: Supported methods: ");
            sb2.append(settextclassifier.getInstance());
            throw new JOSEException(sb2.toString());
        }
    }

    public final synchronized void Cardinal(setChecked setchecked) throws JOSEException {
        if (this.getWarnings == cca_continue.ENCRYPTED) {
            try {
                this.cca_continue = new Payload(setchecked.configure(this.init, this.getInstance, this.Cardinal, this.configure, this.getSDKVersion));
                this.getWarnings = cca_continue.DECRYPTED;
            } catch (JOSEException e) {
                throw e;
            } catch (Exception e2) {
                throw new JOSEException(e2.getMessage(), e2);
            }
        } else {
            throw new IllegalStateException("The JWE object must be in an encrypted state");
        }
    }

    public final String init() {
        Base64URL base64URL;
        if (this.getWarnings == cca_continue.ENCRYPTED || this.getWarnings == cca_continue.DECRYPTED) {
            JWEHeader jWEHeader = this.init;
            if (jWEHeader.getInstance == null) {
                base64URL = Base64URL.init(jWEHeader.toString());
            } else {
                base64URL = jWEHeader.getInstance;
            }
            StringBuilder sb = new StringBuilder(base64URL.toString());
            sb.append('.');
            Base64URL base64URL2 = this.getInstance;
            if (base64URL2 != null) {
                sb.append(base64URL2.toString());
            }
            sb.append('.');
            Base64URL base64URL3 = this.Cardinal;
            if (base64URL3 != null) {
                sb.append(base64URL3.toString());
            }
            sb.append('.');
            sb.append(this.configure.toString());
            sb.append('.');
            Base64URL base64URL4 = this.getSDKVersion;
            if (base64URL4 != null) {
                sb.append(base64URL4.toString());
            }
            return sb.toString();
        }
        throw new IllegalStateException("The JWE object must be in an encrypted or decrypted state");
    }
}
