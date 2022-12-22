package com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.jcajce.provider.mceliece;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.cardinalcommerce.p060a.setBackgroundTintList;
import com.cardinalcommerce.p060a.setContextClickable;
import com.cardinalcommerce.p060a.setForegroundGravity;
import com.cardinalcommerce.p060a.setForegroundTintMode;
import com.cardinalcommerce.p060a.setLayoutParams;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setLongClickable;
import com.cardinalcommerce.p060a.setOnApplyWindowInsetsListener;
import com.cardinalcommerce.p060a.setOutlineSpotShadowColor;
import com.cardinalcommerce.p060a.setScrollBarDefaultDelayBeforeFade;
import com.cardinalcommerce.p060a.setSystemGestureExclusionRects;
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

public class McElieceCCA2KeyFactorySpi extends KeyFactorySpi implements AsymmetricKeyInfoConverter {
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
                    if (PQCObjectIdentifiers.cca_continue.equals(init.init.init)) {
                        setLocationDataConsentGiven instance = setLocationDataConsentGiven.getInstance(init.getInstance.cca_continue());
                        setOnApplyWindowInsetsListener setonapplywindowinsetslistener = instance != null ? new setOnApplyWindowInsetsListener(setThreeDSRequestorAppURL.cca_continue((Object) instance)) : null;
                        return new setOutlineSpotShadowColor(new setLongClickable(setonapplywindowinsetslistener.init, setonapplywindowinsetslistener.configure, setonapplywindowinsetslistener.cca_continue, setScrollBarDefaultDelayBeforeFade.getInstance(setonapplywindowinsetslistener.Cardinal).configure()));
                    }
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece private key");
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
                    if (PQCObjectIdentifiers.cca_continue.equals(init.cca_continue.init)) {
                        setLocationDataConsentGiven instance = setLocationDataConsentGiven.getInstance(init.init.cca_continue());
                        setSystemGestureExclusionRects setsystemgestureexclusionrects = instance != null ? new setSystemGestureExclusionRects(setThreeDSRequestorAppURL.cca_continue((Object) instance)) : null;
                        return new setLayoutParams(new setContextClickable(setsystemgestureexclusionrects.cca_continue, setsystemgestureexclusionrects.Cardinal, new setBackgroundTintList(setsystemgestureexclusionrects.getInstance), new setForegroundTintMode(new setBackgroundTintList(setsystemgestureexclusionrects.getInstance), setsystemgestureexclusionrects.init), new setForegroundGravity(setsystemgestureexclusionrects.configure), setScrollBarDefaultDelayBeforeFade.getInstance(setsystemgestureexclusionrects.values).configure()));
                    }
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece public key");
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
        setOnApplyWindowInsetsListener setonapplywindowinsetslistener = instance != null ? new setOnApplyWindowInsetsListener(setThreeDSRequestorAppURL.cca_continue((Object) instance)) : null;
        return new setOutlineSpotShadowColor(new setLongClickable(setonapplywindowinsetslistener.init, setonapplywindowinsetslistener.configure, setonapplywindowinsetslistener.cca_continue, setScrollBarDefaultDelayBeforeFade.getInstance(setonapplywindowinsetslistener.Cardinal).configure()));
    }

    public final PrivateKey cca_continue(PrivateKeyInfo privateKeyInfo) throws IOException {
        setLocationDataConsentGiven values = setLocationDataConsentGiven.getInstance(privateKeyInfo.init.cca_continue()).values();
        setSystemGestureExclusionRects setsystemgestureexclusionrects = values != null ? new setSystemGestureExclusionRects(setThreeDSRequestorAppURL.cca_continue((Object) values)) : null;
        return new setLayoutParams(new setContextClickable(setsystemgestureexclusionrects.cca_continue, setsystemgestureexclusionrects.Cardinal, new setBackgroundTintList(setsystemgestureexclusionrects.getInstance), new setForegroundTintMode(new setBackgroundTintList(setsystemgestureexclusionrects.getInstance), setsystemgestureexclusionrects.init), new setForegroundGravity(setsystemgestureexclusionrects.configure), (String) null));
    }
}
