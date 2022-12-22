package com.iproov.sdk.crypto;

import android.content.Context;
import android.os.Build;
import android.security.KeyChain;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyInfo;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.iproov.sdk.logging.IPLog;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;
import p066native.C2381if;

/* renamed from: com.iproov.sdk.crypto.if */
/* compiled from: KeyStoreManager */
public final class C19915if {

    /* renamed from: a */
    private static final String f54353a = ("🗝 " + C19915if.class.getSimpleName());

    /* renamed from: b */
    private static C19915if f54354b;

    /* renamed from: c */
    private final Context f54355c;

    /* renamed from: d */
    private final KeyStore f54356d;

    /* renamed from: e */
    private final KeyPair f54357e;

    private C19915if(Context context) throws C19914for {
        this.f54355c = context.getApplicationContext();
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            this.f54356d = instance;
            instance.load((KeyStore.LoadStoreParameter) null);
            C2381if ifVar = new C2381if(context);
            if (m47540this() && ifVar.m46146catch() && m47539new()) {
                ifVar.m46154super();
            }
            KeyPair a = m39267a();
            this.f54357e = a;
            if (a.getPublic() == null) {
                throw new IllegalStateException("Public Key cannot be null");
            } else if (a.getPrivate() == null) {
                throw new IllegalStateException("Private Key cannot be null");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new C19914for(e);
        }
    }

    /* renamed from: a */
    private KeyPair m39267a() throws KeyStoreException, UnrecoverableEntryException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, C19914for {
        if (!this.f54356d.containsAlias("com.iproov.sdk")) {
            return m39272d();
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return m39269b(this.f54356d);
        }
        return m39268a(this.f54356d);
    }

    /* renamed from: b */
    private boolean m39270b() {
        PrivateKey privateKey = this.f54357e.getPrivate();
        try {
            return ((KeyInfo) KeyFactory.getInstance(privateKey.getAlgorithm(), "AndroidKeyStore").getKeySpec(privateKey, KeyInfo.class)).isInsideSecureHardware();
        } catch (Exception e) {
            IPLog.m39305w(f54353a, "Error retrieving key info");
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    private boolean m39271c() {
        return KeyChain.isBoundKeyAlgorithm("EC");
    }

    /* renamed from: d */
    private KeyPair m39272d() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec;
        int i = Build.VERSION.SDK_INT;
        KeyPairGenerator instance = KeyPairGenerator.getInstance(i > 23 ? "EC" : "RSA", "AndroidKeyStore");
        if (i > 23) {
            algorithmParameterSpec = m39275e();
        } else {
            algorithmParameterSpec = m39276f();
        }
        instance.initialize(algorithmParameterSpec);
        return instance.generateKeyPair();
    }

    /* renamed from: do */
    public static synchronized C19915if m39274do(Context context) throws C19914for {
        C19915if ifVar;
        synchronized (C19915if.class) {
            if (f54354b == null) {
                f54354b = new C19915if(context);
            }
            ifVar = f54354b;
        }
        return ifVar;
    }

    /* renamed from: e */
    private AlgorithmParameterSpec m39275e() {
        KeyGenParameterSpec.Builder digests = new KeyGenParameterSpec.Builder("com.iproov.sdk", 4).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setDigests(new String[]{"SHA-256"});
        if (Build.VERSION.SDK_INT >= 28 && this.f54355c.getPackageManager().hasSystemFeature("android.hardware.strongbox_keystore")) {
            digests.setIsStrongBoxBacked(false);
        }
        return digests.build();
    }

    /* renamed from: g */
    private Signature m39277g() throws NoSuchAlgorithmException {
        try {
            return Signature.getInstance("SHA256withECDSA", Build.VERSION.SDK_INT >= 23 ? "AndroidKeyStoreBCWorkaround" : "AndroidOpenSSL");
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            m39278h();
            return Signature.getInstance("SHA256withECDSA");
        }
    }

    /* renamed from: h */
    private static void m39278h() {
        Provider[] providers = Security.getProviders();
        StringBuilder sb = new StringBuilder();
        sb.append("Services available for SHA256withECDSA algorithm: [");
        for (Provider service : providers) {
            Provider.Service service2 = service.getService("Signature", "SHA256withECDSA");
            if (service2 != null) {
                sb.append(service2.toString());
            }
        }
        sb.append(Const.jaRight);
        IPLog.m39305w(f54353a, sb.toString());
    }

    /* renamed from: break  reason: not valid java name */
    public boolean m47537break() {
        synchronized (this) {
            if (Build.VERSION.SDK_INT < 23) {
                boolean c = m39271c();
                return c;
            }
            boolean b = m39270b();
            return b;
        }
    }

    /* renamed from: else  reason: not valid java name */
    public PublicKey m47538else() {
        return new PublicKey(this.f54357e.getPublic());
    }

    /* renamed from: new  reason: not valid java name */
    public boolean m47539new() {
        try {
            this.f54356d.deleteEntry("com.iproov.sdk");
            return true;
        } catch (KeyStoreException e) {
            IPLog.m39301e(f54353a, e.getLocalizedMessage());
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: this  reason: not valid java name */
    public boolean m47540this() {
        return Build.VERSION.SDK_INT >= 28 && this.f54355c.getPackageManager().hasSystemFeature("android.hardware.strongbox_keystore");
    }

    /* renamed from: try  reason: not valid java name */
    public Context m47541try() {
        return this.f54355c;
    }

    /* renamed from: do */
    public synchronized byte[] mo162128do(byte[] bArr) throws C19914for {
        Signature g;
        try {
            g = m39277g();
            g.initSign(this.f54357e.getPrivate());
            g.update(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new C19914for(e);
        }
        return g.sign();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0015, code lost:
        return r1;
     */
    /* renamed from: do */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.iproov.sdk.crypto.C19913do m39273do(com.iproov.sdk.crypto.C19915if r1) {
        /*
            java.lang.Class<com.iproov.sdk.crypto.if> r0 = com.iproov.sdk.crypto.C19915if.class
            monitor-enter(r0)
            if (r1 != 0) goto L_0x0009
            com.iproov.sdk.crypto.do r1 = com.iproov.sdk.crypto.C19913do.UNSUPPORTED     // Catch:{ all -> 0x0016 }
            monitor-exit(r0)
            return r1
        L_0x0009:
            boolean r1 = r1.m47537break()     // Catch:{ all -> 0x0016 }
            if (r1 == 0) goto L_0x0012
            com.iproov.sdk.crypto.do r1 = com.iproov.sdk.crypto.C19913do.HARDWARE     // Catch:{ all -> 0x0016 }
            goto L_0x0014
        L_0x0012:
            com.iproov.sdk.crypto.do r1 = com.iproov.sdk.crypto.C19913do.SOFTWARE     // Catch:{ all -> 0x0016 }
        L_0x0014:
            monitor-exit(r0)
            return r1
        L_0x0016:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.crypto.C19915if.m39273do(com.iproov.sdk.crypto.if):com.iproov.sdk.crypto.do");
    }

    /* renamed from: b */
    private KeyPair m39269b(KeyStore keyStore) throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException {
        Key key = keyStore.getKey("com.iproov.sdk", (char[]) null);
        Certificate certificate = keyStore.getCertificate("com.iproov.sdk");
        if (key instanceof PrivateKey) {
            return new KeyPair(certificate.getPublicKey(), (PrivateKey) key);
        }
        throw new IllegalStateException("Unsupported Key type");
    }

    /* renamed from: f */
    private AlgorithmParameterSpec m39276f() throws NoSuchAlgorithmException {
        return new KeyPairGeneratorSpec.Builder(this.f54355c).setAlias("com.iproov.sdk").setSubject(new X500Principal("CN=com.iproov.sdk")).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setSerialNumber(new BigInteger(25, new SecureRandom())).setStartDate(new Date(0)).setEndDate(new Date(2461449600000L)).setKeyType("EC").build();
    }

    /* renamed from: a */
    private KeyPair m39268a(KeyStore keyStore) throws KeyStoreException, UnrecoverableEntryException, NoSuchAlgorithmException, C19914for {
        try {
            KeyStore.Entry entry = keyStore.getEntry("com.iproov.sdk", (KeyStore.ProtectionParameter) null);
            if (entry instanceof KeyStore.PrivateKeyEntry) {
                KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) entry;
                return new KeyPair(privateKeyEntry.getCertificate().getPublicKey(), privateKeyEntry.getPrivateKey());
            }
            throw new IllegalStateException("Unsupported Key type");
        } catch (NullPointerException e) {
            throw new C19914for(e);
        }
    }
}
