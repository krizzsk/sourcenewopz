package com.didichuxing.security.challenge.cookie;

import android.text.TextUtils;
import android.util.LruCache;
import java.net.URL;

public class ClgCookieStore {

    /* renamed from: a */
    private static volatile ClgCookieStore f48977a;

    /* renamed from: b */
    private LruCache<String, ClgCookie> f48978b = new LruCache<>(1000);

    public static ClgCookieStore getInstance() {
        if (f48977a == null) {
            synchronized (ClgCookieStore.class) {
                if (f48977a == null) {
                    f48977a = new ClgCookieStore();
                }
            }
        }
        return f48977a;
    }

    private ClgCookieStore() {
    }

    public void save(ClgCookie clgCookie) {
        if (clgCookie != null) {
            this.f48978b.put(m35198a(clgCookie.getDomain(), clgCookie.getPath()), clgCookie);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r2 = m35198a(r5, r1);
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002f A[PHI: r2 r3 
      PHI: (r2v1 java.lang.String) = (r2v0 java.lang.String), (r2v2 java.lang.String) binds: [B:10:0x001d, B:12:0x002c] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r3v3 com.didichuxing.security.challenge.cookie.ClgCookie) = (r3v2 com.didichuxing.security.challenge.cookie.ClgCookie), (r3v5 com.didichuxing.security.challenge.cookie.ClgCookie) binds: [B:10:0x001d, B:12:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didichuxing.security.challenge.cookie.ClgCookie load(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x000f }
            r1.<init>(r5)     // Catch:{ all -> 0x000f }
            java.lang.String r5 = r1.getHost()     // Catch:{ all -> 0x000f }
            java.lang.String r1 = r1.getPath()     // Catch:{ all -> 0x0010 }
            goto L_0x0011
        L_0x000f:
            r5 = r0
        L_0x0010:
            r1 = r0
        L_0x0011:
            java.lang.String r2 = r4.m35198a(r5, r0)
            android.util.LruCache<java.lang.String, com.didichuxing.security.challenge.cookie.ClgCookie> r3 = r4.f48978b
            java.lang.Object r3 = r3.get(r2)
            com.didichuxing.security.challenge.cookie.ClgCookie r3 = (com.didichuxing.security.challenge.cookie.ClgCookie) r3
            if (r3 != 0) goto L_0x002f
            java.lang.String r2 = r4.m35198a(r5, r1)
            android.util.LruCache<java.lang.String, com.didichuxing.security.challenge.cookie.ClgCookie> r5 = r4.f48978b
            java.lang.Object r5 = r5.get(r2)
            r3 = r5
            com.didichuxing.security.challenge.cookie.ClgCookie r3 = (com.didichuxing.security.challenge.cookie.ClgCookie) r3
            if (r3 != 0) goto L_0x002f
            return r0
        L_0x002f:
            boolean r5 = r3.hasExpired()
            if (r5 == 0) goto L_0x003b
            android.util.LruCache<java.lang.String, com.didichuxing.security.challenge.cookie.ClgCookie> r5 = r4.f48978b
            r5.remove(r2)
            return r0
        L_0x003b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.security.challenge.cookie.ClgCookieStore.load(java.lang.String):com.didichuxing.security.challenge.cookie.ClgCookie");
    }

    /* renamed from: a */
    private String m35197a(String str) {
        String str2;
        String str3 = null;
        try {
            URL url = new URL(str);
            str2 = url.getHost();
            try {
                str3 = url.getPath();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str2 = null;
        }
        return m35198a(str2, str3);
    }

    /* renamed from: a */
    private String m35198a(String str, String str2) {
        return m35201d(str) + m35202e(str2);
    }

    /* renamed from: b */
    private String m35199b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == '/') {
            i++;
        }
        if (i == 0) {
            return str;
        }
        return i <= str.length() + -1 ? str.substring(i) : "";
    }

    /* renamed from: c */
    private String m35200c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length() - 1;
        while (length >= 0 && str.charAt(length) == '/') {
            length--;
        }
        if (length == str.length() - 1) {
            return str;
        }
        return length >= 0 ? str.substring(0, length + 1) : "";
    }

    /* renamed from: d */
    private String m35201d(String str) {
        String c = m35200c(m35199b(str));
        return c != null ? c : "";
    }

    /* renamed from: e */
    private String m35202e(String str) {
        String c = m35200c(m35199b(str));
        if (c == null) {
            return "/";
        }
        return "/" + c;
    }
}
