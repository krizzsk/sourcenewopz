package com.facebook.android.crypto.keychain;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.didi.sdk.apm.SystemUtils;
import com.facebook.crypto.exception.KeyChainException;
import com.facebook.crypto.keychain.KeyChain;
import java.security.SecureRandom;
import java.util.Arrays;

public class SharedPrefsBackedKeyChain implements KeyChain {
    static final String CIPHER_KEY_PREF = "cipher_key";
    static final String MAC_KEY_PREF = "mac_key";
    static final String SHARED_PREF_NAME = "crypto";
    private static final SecureRandomFix sSecureRandomFix = new SecureRandomFix();
    protected byte[] mCipherKey;
    protected byte[] mMacKey;
    private final SecureRandom mSecureRandom = new SecureRandom();
    protected boolean mSetCipherKey;
    protected boolean mSetMacKey;
    private final SharedPreferences mSharedPreferences;

    public SharedPrefsBackedKeyChain(Context context) {
        this.mSharedPreferences = SystemUtils.getSharedPreferences(context, SHARED_PREF_NAME, 0);
    }

    public synchronized byte[] getCipherKey() throws KeyChainException {
        if (!this.mSetCipherKey) {
            this.mCipherKey = maybeGenerateKey(CIPHER_KEY_PREF, 16);
        }
        this.mSetCipherKey = true;
        return this.mCipherKey;
    }

    public byte[] getMacKey() throws KeyChainException {
        if (!this.mSetMacKey) {
            this.mMacKey = maybeGenerateKey(MAC_KEY_PREF, 64);
        }
        this.mSetMacKey = true;
        return this.mMacKey;
    }

    public byte[] getNewIV() throws KeyChainException {
        sSecureRandomFix.tryApplyFixes();
        byte[] bArr = new byte[12];
        this.mSecureRandom.nextBytes(bArr);
        return bArr;
    }

    public synchronized void destroyKeys() {
        this.mSetCipherKey = false;
        this.mSetMacKey = false;
        if (this.mCipherKey != null) {
            Arrays.fill(this.mCipherKey, (byte) 0);
        }
        if (this.mMacKey != null) {
            Arrays.fill(this.mMacKey, (byte) 0);
        }
        this.mCipherKey = null;
        this.mMacKey = null;
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.remove(CIPHER_KEY_PREF);
        edit.remove(MAC_KEY_PREF);
        edit.commit();
    }

    private byte[] maybeGenerateKey(String str, int i) throws KeyChainException {
        String string = this.mSharedPreferences.getString(str, (String) null);
        if (string == null) {
            return generateAndSaveKey(str, i);
        }
        return decodeFromPrefs(string);
    }

    private byte[] generateAndSaveKey(String str, int i) throws KeyChainException {
        sSecureRandomFix.tryApplyFixes();
        byte[] bArr = new byte[i];
        this.mSecureRandom.nextBytes(bArr);
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putString(str, encodeForPrefs(bArr));
        edit.commit();
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public byte[] decodeFromPrefs(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    /* access modifiers changed from: package-private */
    public String encodeForPrefs(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 0);
    }
}
