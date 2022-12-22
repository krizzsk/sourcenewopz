package com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.jcajce.provider.rainbow;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import com.cardinalcommerce.p060a.setBackground;
import com.cardinalcommerce.p060a.setBackgroundResource;
import com.cardinalcommerce.p060a.setFitsSystemWindows;
import com.cardinalcommerce.p060a.setFocusable;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setRenderEffect;
import com.cardinalcommerce.p060a.setScrollBarSize;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RainbowKeyFactorySpi extends KeyFactorySpi implements AsymmetricKeyInfoConverter {
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof setBackground) {
            return new setRenderEffect((setBackground) keySpec);
        }
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                return cca_continue(PrivateKeyInfo.init(setLocationDataConsentGiven.getInstance(((PKCS8EncodedKeySpec) keySpec).getEncoded())));
            } catch (Exception e) {
                throw new InvalidKeySpecException(e.toString());
            }
        } else {
            StringBuilder sb = new StringBuilder("Unsupported key specification: ");
            sb.append(keySpec.getClass());
            sb.append(".");
            throw new InvalidKeySpecException(sb.toString());
        }
    }

    public final Key engineTranslateKey(Key key) throws InvalidKeyException {
        if ((key instanceof setRenderEffect) || (key instanceof setScrollBarSize)) {
            return key;
        }
        throw new InvalidKeyException("Unsupported key type");
    }

    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof setBackgroundResource) {
            return new setScrollBarSize((setBackgroundResource) keySpec);
        }
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                setLocationDataConsentGiven instance = setLocationDataConsentGiven.getInstance(SubjectPublicKeyInfo.init(((X509EncodedKeySpec) keySpec).getEncoded()).getInstance.cca_continue());
                setFocusable setfocusable = instance != null ? new setFocusable(setThreeDSRequestorAppURL.cca_continue((Object) instance)) : null;
                return new setScrollBarSize(new BigInteger(setfocusable.init.Cardinal).intValue(), setfocusable.init(), setfocusable.configure(), setfocusable.getInstance());
            } catch (Exception e) {
                throw new InvalidKeySpecException(e.toString());
            }
        } else {
            StringBuilder sb = new StringBuilder("Unknown key specification: ");
            sb.append(keySpec);
            sb.append(".");
            throw new InvalidKeySpecException(sb.toString());
        }
    }

    public final KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (key instanceof setRenderEffect) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
            if (setBackground.class.isAssignableFrom(cls)) {
                setRenderEffect setrendereffect = (setRenderEffect) key;
                return new setBackground(setrendereffect.Cardinal(), setrendereffect.cca_continue(), setrendereffect.init(), setrendereffect.getInstance(), setrendereffect.configure, setrendereffect.init);
            }
        } else if (!(key instanceof setScrollBarSize)) {
            StringBuilder sb = new StringBuilder("Unsupported key type: ");
            sb.append(key.getClass());
            sb.append(".");
            throw new InvalidKeySpecException(sb.toString());
        } else if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
            return new X509EncodedKeySpec(key.getEncoded());
        } else {
            if (setBackgroundResource.class.isAssignableFrom(cls)) {
                setScrollBarSize setscrollbarsize = (setScrollBarSize) key;
                return new setBackgroundResource(setscrollbarsize.Cardinal, setscrollbarsize.init(), setscrollbarsize.configure(), setscrollbarsize.cca_continue());
            }
        }
        StringBuilder sb2 = new StringBuilder("Unknown key specification: ");
        sb2.append(cls);
        sb2.append(".");
        throw new InvalidKeySpecException(sb2.toString());
    }

    public final PrivateKey cca_continue(PrivateKeyInfo privateKeyInfo) throws IOException {
        setLocationDataConsentGiven instance = setLocationDataConsentGiven.getInstance(privateKeyInfo.init.cca_continue());
        setFitsSystemWindows setfitssystemwindows = instance != null ? new setFitsSystemWindows(setThreeDSRequestorAppURL.cca_continue((Object) instance)) : null;
        return new setRenderEffect(setfitssystemwindows.Cardinal(), setfitssystemwindows.getInstance(), setfitssystemwindows.configure(), setfitssystemwindows.init(), setfitssystemwindows.cca_continue(), setfitssystemwindows.configure);
    }

    public final PublicKey getInstance(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        setLocationDataConsentGiven instance = setLocationDataConsentGiven.getInstance(subjectPublicKeyInfo.getInstance.cca_continue());
        setFocusable setfocusable = instance != null ? new setFocusable(setThreeDSRequestorAppURL.cca_continue((Object) instance)) : null;
        return new setScrollBarSize(new BigInteger(setfocusable.init.Cardinal).intValue(), setfocusable.init(), setfocusable.configure(), setfocusable.getInstance());
    }
}
