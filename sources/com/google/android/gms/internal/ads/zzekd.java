package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekc;
import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzekd<T_WRAPPER extends zzekc<T_ENGINE>, T_ENGINE> {
    private static final Logger logger = Logger.getLogger(zzekd.class.getName());
    private static final List<Provider> zzini;
    public static final zzekd<zzekf, Cipher> zzinj = new zzekd<>(new zzekf());
    public static final zzekd<zzekj, Mac> zzink = new zzekd<>(new zzekj());
    private static final zzekd<zzekl, Signature> zzinl = new zzekd<>(new zzekl());
    private static final zzekd<zzeki, MessageDigest> zzinm = new zzekd<>(new zzeki());
    public static final zzekd<zzeke, KeyAgreement> zzinn = new zzekd<>(new zzeke());
    public static final zzekd<zzekg, KeyPairGenerator> zzino = new zzekd<>(new zzekg());
    public static final zzekd<zzekh, KeyFactory> zzinp = new zzekd<>(new zzekh());
    private T_WRAPPER zzinq;
    private List<Provider> zzinr = zzini;
    private boolean zzins = true;

    private zzekd(T_WRAPPER t_wrapper) {
        this.zzinq = t_wrapper;
    }

    public final T_ENGINE zzhx(String str) throws GeneralSecurityException {
        Exception exc = null;
        for (Provider zza : this.zzinr) {
            try {
                return this.zzinq.zza(str, zza);
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        if (this.zzins) {
            return this.zzinq.zza(str, (Provider) null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }

    static {
        if (zzekv.zzbgu()) {
            String[] strArr = {ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    logger.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", new Object[]{str}));
                }
            }
            zzini = arrayList;
        } else {
            zzini = new ArrayList();
        }
    }
}
