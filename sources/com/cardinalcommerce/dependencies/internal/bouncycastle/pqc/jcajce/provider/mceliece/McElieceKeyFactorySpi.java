package com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.jcajce.provider.mceliece;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.cardinalcommerce.p060a.setAutofillHints;
import com.cardinalcommerce.p060a.setBackgroundDrawable;
import com.cardinalcommerce.p060a.setBackgroundTintList;
import com.cardinalcommerce.p060a.setEnabled;
import com.cardinalcommerce.p060a.setForegroundGravity;
import com.cardinalcommerce.p060a.setForegroundTintMode;
import com.cardinalcommerce.p060a.setHorizontalScrollBarEnabled;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setSaveFromParentEnabled;
import com.cardinalcommerce.p060a.setScreenReaderFocusable;
import com.cardinalcommerce.p060a.setScrollBarFadeDuration;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class McElieceKeyFactorySpi extends KeyFactorySpi implements AsymmetricKeyInfoConverter {
    /* access modifiers changed from: protected */
    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        return null;
    }

    /* access modifiers changed from: protected */
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        return null;
    }

    /* access modifiers changed from: protected */
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                SubjectPublicKeyInfo init = SubjectPublicKeyInfo.init(setLocationDataConsentGiven.getInstance(((X509EncodedKeySpec) keySpec).getEncoded()));
                try {
                    if (PQCObjectIdentifiers.init.equals(init.init.init)) {
                        setLocationDataConsentGiven instance = setLocationDataConsentGiven.getInstance(init.getInstance.cca_continue());
                        setEnabled setenabled = instance != null ? new setEnabled(setThreeDSRequestorAppURL.cca_continue((Object) instance)) : null;
                        return new setHorizontalScrollBarEnabled(new setSaveFromParentEnabled(setenabled.getInstance, setenabled.Cardinal, new setBackgroundDrawable(setenabled.configure)));
                    }
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece public key");
                } catch (IOException e) {
                    StringBuilder sb = new StringBuilder("Unable to decode X509EncodedKeySpec: ");
                    sb.append(e.getMessage());
                    throw new InvalidKeySpecException(sb.toString());
                }
            } catch (IOException e2) {
                throw new InvalidKeySpecException(e2.toString());
            }
        } else {
            StringBuilder sb2 = new StringBuilder("Unsupported key specification: ");
            sb2.append(keySpec.getClass());
            sb2.append(".");
            throw new InvalidKeySpecException(sb2.toString());
        }
    }

    /* access modifiers changed from: protected */
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                PrivateKeyInfo init = PrivateKeyInfo.init(setLocationDataConsentGiven.getInstance(((PKCS8EncodedKeySpec) keySpec).getEncoded()));
                try {
                    if (PQCObjectIdentifiers.init.equals(init.cca_continue.init)) {
                        setLocationDataConsentGiven instance = setLocationDataConsentGiven.getInstance(init.init.cca_continue());
                        setAutofillHints setautofillhints = instance != null ? new setAutofillHints(setThreeDSRequestorAppURL.cca_continue((Object) instance)) : null;
                        return new setScrollBarFadeDuration(new setScreenReaderFocusable(setautofillhints.configure, setautofillhints.init, new setBackgroundTintList(setautofillhints.cca_continue), new setForegroundTintMode(new setBackgroundTintList(setautofillhints.cca_continue), setautofillhints.Cardinal), new setForegroundGravity(setautofillhints.values), new setForegroundGravity(setautofillhints.cleanup), new setBackgroundDrawable(setautofillhints.getInstance)));
                    }
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece private key");
                } catch (IOException unused) {
                    throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec.");
                }
            } catch (IOException e) {
                throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec: ".concat(String.valueOf(e)));
            }
        } else {
            StringBuilder sb = new StringBuilder("Unsupported key specification: ");
            sb.append(keySpec.getClass());
            sb.append(".");
            throw new InvalidKeySpecException(sb.toString());
        }
    }

    public final PublicKey getInstance(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        setLocationDataConsentGiven instance = setLocationDataConsentGiven.getInstance(subjectPublicKeyInfo.getInstance.cca_continue());
        setEnabled setenabled = instance != null ? new setEnabled(setThreeDSRequestorAppURL.cca_continue((Object) instance)) : null;
        return new setHorizontalScrollBarEnabled(new setSaveFromParentEnabled(setenabled.getInstance, setenabled.Cardinal, new setBackgroundDrawable(setenabled.configure)));
    }

    public final PrivateKey cca_continue(PrivateKeyInfo privateKeyInfo) throws IOException {
        setLocationDataConsentGiven values = setLocationDataConsentGiven.getInstance(privateKeyInfo.init.cca_continue()).values();
        setAutofillHints setautofillhints = values != null ? new setAutofillHints(setThreeDSRequestorAppURL.cca_continue((Object) values)) : null;
        return new setScrollBarFadeDuration(new setScreenReaderFocusable(setautofillhints.configure, setautofillhints.init, new setBackgroundTintList(setautofillhints.cca_continue), new setForegroundTintMode(new setBackgroundTintList(setautofillhints.cca_continue), setautofillhints.Cardinal), new setForegroundGravity(setautofillhints.values), new setForegroundGravity(setautofillhints.cleanup), new setBackgroundDrawable(setautofillhints.getInstance)));
    }
}
