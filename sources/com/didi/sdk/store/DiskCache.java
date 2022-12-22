package com.didi.sdk.store;

import android.content.Context;
import com.didi.sdk.cache.Cache;
import com.didi.sdk.cache.DiskBasedCache;
import com.facebook.android.crypto.keychain.SharedPrefsBackedKeyChain;
import com.facebook.crypto.Crypto;
import com.facebook.crypto.Entity;
import com.facebook.crypto.exception.CryptoInitializationException;
import com.facebook.crypto.exception.KeyChainException;
import com.facebook.crypto.util.SystemNativeCryptoLibrary;
import java.io.File;
import java.io.IOException;

public class DiskCache implements Cache {

    /* renamed from: a */
    private static final int f37537a = 2097152;

    /* renamed from: b */
    private DiskBasedCache f37538b;

    /* renamed from: c */
    private Crypto f37539c;

    /* renamed from: d */
    private File f37540d;

    /* renamed from: e */
    private boolean f37541e;

    public static class DEntry extends Cache.Entry {
        public boolean isExpired() {
            return false;
        }

        public boolean refreshNeeded() {
            return false;
        }
    }

    public DiskCache(Context context, String str) {
        this.f37539c = new Crypto(new SharedPrefsBackedKeyChain(context), new SystemNativeCryptoLibrary());
        File file = new File(context.getFilesDir().getAbsolutePath(), str);
        this.f37540d = file;
        if (file.exists()) {
            this.f37541e = true;
            this.f37538b = new DiskBasedCache(this.f37540d, 2097152);
            initialize();
        }
    }

    /* renamed from: a */
    private void m26661a() {
        this.f37541e = true;
        this.f37540d.mkdirs();
        this.f37538b = new DiskBasedCache(this.f37540d, 2097152);
        initialize();
    }

    /* renamed from: b */
    private void m26662b() {
        if (!this.f37541e) {
            m26661a();
        }
    }

    public synchronized Cache.Entry get(String str) {
        m26662b();
        if (str == null) {
            return null;
        }
        if (!this.f37539c.isAvailable()) {
            return null;
        }
        Cache.Entry entry = this.f37538b.get(str);
        if (!(entry == null || entry.data == null || entry.data.length <= 1)) {
            try {
                entry.data = this.f37539c.decrypt(entry.data, new Entity(""));
                return entry;
            } catch (KeyChainException e) {
                e.printStackTrace();
                return null;
            } catch (CryptoInitializationException e2) {
                e2.printStackTrace();
                return null;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            } catch (UnsatisfiedLinkError e5) {
                e5.printStackTrace();
                return null;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void put(java.lang.String r5, com.didi.sdk.cache.Cache.Entry r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            r4.m26662b()     // Catch:{ all -> 0x0041 }
            if (r5 == 0) goto L_0x003f
            if (r6 != 0) goto L_0x0009
            goto L_0x003f
        L_0x0009:
            com.facebook.crypto.Crypto r0 = r4.f37539c     // Catch:{ all -> 0x0041 }
            boolean r0 = r0.isAvailable()     // Catch:{ all -> 0x0041 }
            if (r0 != 0) goto L_0x0013
            monitor-exit(r4)
            return
        L_0x0013:
            com.facebook.crypto.Crypto r0 = r4.f37539c     // Catch:{ KeyChainException -> 0x0039, CryptoInitializationException -> 0x0034, IOException -> 0x002f, UnsatisfiedLinkError -> 0x002a }
            byte[] r1 = r6.data     // Catch:{ KeyChainException -> 0x0039, CryptoInitializationException -> 0x0034, IOException -> 0x002f, UnsatisfiedLinkError -> 0x002a }
            com.facebook.crypto.Entity r2 = new com.facebook.crypto.Entity     // Catch:{ KeyChainException -> 0x0039, CryptoInitializationException -> 0x0034, IOException -> 0x002f, UnsatisfiedLinkError -> 0x002a }
            java.lang.String r3 = ""
            r2.<init>(r3)     // Catch:{ KeyChainException -> 0x0039, CryptoInitializationException -> 0x0034, IOException -> 0x002f, UnsatisfiedLinkError -> 0x002a }
            byte[] r0 = r0.encrypt(r1, r2)     // Catch:{ KeyChainException -> 0x0039, CryptoInitializationException -> 0x0034, IOException -> 0x002f, UnsatisfiedLinkError -> 0x002a }
            r6.data = r0     // Catch:{ KeyChainException -> 0x0039, CryptoInitializationException -> 0x0034, IOException -> 0x002f, UnsatisfiedLinkError -> 0x002a }
            com.didi.sdk.cache.DiskBasedCache r0 = r4.f37538b     // Catch:{ KeyChainException -> 0x0039, CryptoInitializationException -> 0x0034, IOException -> 0x002f, UnsatisfiedLinkError -> 0x002a }
            r0.put(r5, r6)     // Catch:{ KeyChainException -> 0x0039, CryptoInitializationException -> 0x0034, IOException -> 0x002f, UnsatisfiedLinkError -> 0x002a }
            goto L_0x003d
        L_0x002a:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x0041 }
            goto L_0x003d
        L_0x002f:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x0041 }
            goto L_0x003d
        L_0x0034:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x0041 }
            goto L_0x003d
        L_0x0039:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x0041 }
        L_0x003d:
            monitor-exit(r4)
            return
        L_0x003f:
            monitor-exit(r4)
            return
        L_0x0041:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.store.DiskCache.put(java.lang.String, com.didi.sdk.cache.Cache$Entry):void");
    }

    public synchronized void initialize() {
        m26662b();
        this.f37538b.initialize();
    }

    public synchronized void invalidate(String str, boolean z) {
        m26662b();
        this.f37538b.invalidate(str, z);
    }

    public synchronized void remove(String str) {
        m26662b();
        this.f37538b.remove(str);
    }

    public synchronized void clear() {
        m26662b();
        this.f37538b.clear();
    }
}
