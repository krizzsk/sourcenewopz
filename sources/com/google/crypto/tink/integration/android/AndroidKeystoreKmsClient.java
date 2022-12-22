package com.google.crypto.tink.integration.android;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.stats.CodePackage;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KmsClient;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.KeyGenerator;

public final class AndroidKeystoreKmsClient implements KmsClient {
    public static final String PREFIX = "android-keystore://";
    private static final String TAG = AndroidKeystoreKmsClient.class.getSimpleName();
    private static final int WAIT_TIME_MILLISECONDS_BEFORE_RETRY = 20;
    private KeyStore keyStore;
    private final String keyUri;

    public AndroidKeystoreKmsClient() throws GeneralSecurityException {
        this(new Builder());
    }

    @Deprecated
    public AndroidKeystoreKmsClient(String str) {
        this(new Builder().setKeyUri(str));
    }

    private AndroidKeystoreKmsClient(Builder builder) {
        this.keyUri = builder.keyUri;
        this.keyStore = builder.keyStore;
    }

    public static final class Builder {
        KeyStore keyStore = null;
        String keyUri = null;

        public Builder() {
            if (AndroidKeystoreKmsClient.isAtLeastM()) {
                try {
                    KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
                    this.keyStore = instance;
                    instance.load((KeyStore.LoadStoreParameter) null);
                } catch (IOException | GeneralSecurityException e) {
                    throw new IllegalStateException(e);
                }
            } else {
                throw new IllegalStateException("need Android Keystore on Android M or newer");
            }
        }

        public Builder setKeyUri(String str) {
            if (str == null || !str.toLowerCase(Locale.US).startsWith(AndroidKeystoreKmsClient.PREFIX)) {
                throw new IllegalArgumentException("val must start with android-keystore://");
            }
            this.keyUri = str;
            return this;
        }

        public Builder setKeyStore(KeyStore keyStore2) {
            if (keyStore2 != null) {
                this.keyStore = keyStore2;
                return this;
            }
            throw new IllegalArgumentException("val cannot be null");
        }

        public AndroidKeystoreKmsClient build() {
            return new AndroidKeystoreKmsClient(this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean doesSupport(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = r2.keyUri     // Catch:{ all -> 0x0026 }
            r1 = 1
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r2.keyUri     // Catch:{ all -> 0x0026 }
            boolean r0 = r0.equals(r3)     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0010
            monitor-exit(r2)
            return r1
        L_0x0010:
            java.lang.String r0 = r2.keyUri     // Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x0023
            java.util.Locale r0 = java.util.Locale.US     // Catch:{ all -> 0x0026 }
            java.lang.String r3 = r3.toLowerCase(r0)     // Catch:{ all -> 0x0026 }
            java.lang.String r0 = "android-keystore://"
            boolean r3 = r3.startsWith(r0)     // Catch:{ all -> 0x0026 }
            if (r3 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r1 = 0
        L_0x0024:
            monitor-exit(r2)
            return r1
        L_0x0026:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient.doesSupport(java.lang.String):boolean");
    }

    public KmsClient withCredentials(String str) throws GeneralSecurityException {
        return new AndroidKeystoreKmsClient();
    }

    public KmsClient withDefaultCredentials() throws GeneralSecurityException {
        return new AndroidKeystoreKmsClient();
    }

    public synchronized Aead getAead(String str) throws GeneralSecurityException {
        if (this.keyUri != null) {
            if (!this.keyUri.equals(str)) {
                throw new GeneralSecurityException(String.format("this client is bound to %s, cannot load keys bound to %s", new Object[]{this.keyUri, str}));
            }
        }
        return validateAead(new AndroidKeystoreAesGcm(Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, str), this.keyStore));
    }

    public synchronized void deleteKey(String str) throws GeneralSecurityException {
        this.keyStore.deleteEntry(Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, str));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        java.lang.Thread.sleep(20);
        r0 = java.security.KeyStore.getInstance("AndroidKeyStore");
        r6.keyStore = r0;
        r0.load((java.security.KeyStore.LoadStoreParameter) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        return r6.keyStore.containsAlias(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        throw new java.security.GeneralSecurityException(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        com.didi.sdk.apm.SystemUtils.log(5, TAG, "Keystore is temporarily unavailable, wait 20ms, reinitialize Keystore and try again.", (java.lang.Throwable) null, "com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient", 181);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean hasKey(java.lang.String r7) throws java.security.GeneralSecurityException {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = "android-keystore://"
            java.lang.String r7 = com.google.crypto.tink.subtle.Validators.validateKmsKeyUriAndRemovePrefix(r0, r7)     // Catch:{ all -> 0x003c }
            java.security.KeyStore r0 = r6.keyStore     // Catch:{ NullPointerException -> 0x000f }
            boolean r7 = r0.containsAlias(r7)     // Catch:{ NullPointerException -> 0x000f }
            monitor-exit(r6)
            return r7
        L_0x000f:
            java.lang.String r1 = TAG     // Catch:{ all -> 0x003c }
            java.lang.String r2 = "Keystore is temporarily unavailable, wait 20ms, reinitialize Keystore and try again."
            r0 = 5
            r3 = 0
            java.lang.String r4 = "com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient"
            r5 = 181(0xb5, float:2.54E-43)
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)     // Catch:{ all -> 0x003c }
            r0 = 20
            java.lang.Thread.sleep(r0)     // Catch:{ IOException -> 0x0035, InterruptedException -> 0x002d }
            java.lang.String r0 = "AndroidKeyStore"
            java.security.KeyStore r0 = java.security.KeyStore.getInstance(r0)     // Catch:{ IOException -> 0x0035, InterruptedException -> 0x002d }
            r6.keyStore = r0     // Catch:{ IOException -> 0x0035, InterruptedException -> 0x002d }
            r1 = 0
            r0.load(r1)     // Catch:{ IOException -> 0x0035, InterruptedException -> 0x002d }
        L_0x002d:
            java.security.KeyStore r0 = r6.keyStore     // Catch:{ all -> 0x003c }
            boolean r7 = r0.containsAlias(r7)     // Catch:{ all -> 0x003c }
            monitor-exit(r6)
            return r7
        L_0x0035:
            r7 = move-exception
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x003c }
            r0.<init>(r7)     // Catch:{ all -> 0x003c }
            throw r0     // Catch:{ all -> 0x003c }
        L_0x003c:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient.hasKey(java.lang.String):boolean");
    }

    public static Aead getOrGenerateNewAeadKey(String str) throws GeneralSecurityException, IOException {
        AndroidKeystoreKmsClient androidKeystoreKmsClient = new AndroidKeystoreKmsClient();
        if (!androidKeystoreKmsClient.hasKey(str)) {
            SystemUtils.log(5, TAG, String.format("key URI %s doesn't exist, generating a new one", new Object[]{str}), (Throwable) null, "com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient", 206);
            generateNewAeadKey(str);
        }
        return androidKeystoreKmsClient.getAead(str);
    }

    public static void generateNewAeadKey(String str) throws GeneralSecurityException {
        if (!new AndroidKeystoreKmsClient().hasKey(str)) {
            String validateKmsKeyUriAndRemovePrefix = Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, str);
            KeyGenerator instance = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            instance.init(new KeyGenParameterSpec.Builder(validateKmsKeyUriAndRemovePrefix, 3).setKeySize(256).setBlockModes(new String[]{CodePackage.GCM}).setEncryptionPaddings(new String[]{"NoPadding"}).build());
            instance.generateKey();
            return;
        }
        throw new IllegalArgumentException(String.format("cannot generate a new key %s because it already exists; please delete it with deleteKey() and try again", new Object[]{str}));
    }

    private static Aead validateAead(Aead aead) throws GeneralSecurityException {
        byte[] randBytes = Random.randBytes(10);
        byte[] bArr = new byte[0];
        if (Arrays.equals(randBytes, aead.decrypt(aead.encrypt(randBytes, bArr), bArr))) {
            return aead;
        }
        throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
    }

    /* access modifiers changed from: private */
    public static boolean isAtLeastM() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
