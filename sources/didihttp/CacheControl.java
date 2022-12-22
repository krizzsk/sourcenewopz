package didihttp;

import java.util.concurrent.TimeUnit;

public final class CacheControl {
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();

    /* renamed from: a */
    String f56330a;

    /* renamed from: b */
    private final boolean f56331b;

    /* renamed from: c */
    private final boolean f56332c;

    /* renamed from: d */
    private final int f56333d;

    /* renamed from: e */
    private final int f56334e;

    /* renamed from: f */
    private final boolean f56335f;

    /* renamed from: g */
    private final boolean f56336g;

    /* renamed from: h */
    private final boolean f56337h;

    /* renamed from: i */
    private final int f56338i;

    /* renamed from: j */
    private final int f56339j;

    /* renamed from: k */
    private final boolean f56340k;

    /* renamed from: l */
    private final boolean f56341l;

    private CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, String str) {
        this.f56331b = z;
        this.f56332c = z2;
        this.f56333d = i;
        this.f56334e = i2;
        this.f56335f = z3;
        this.f56336g = z4;
        this.f56337h = z5;
        this.f56338i = i3;
        this.f56339j = i4;
        this.f56340k = z6;
        this.f56341l = z7;
        this.f56330a = str;
    }

    CacheControl(Builder builder) {
        this.f56331b = builder.noCache;
        this.f56332c = builder.noStore;
        this.f56333d = builder.maxAgeSeconds;
        this.f56334e = -1;
        this.f56335f = false;
        this.f56336g = false;
        this.f56337h = false;
        this.f56338i = builder.maxStaleSeconds;
        this.f56339j = builder.minFreshSeconds;
        this.f56340k = builder.onlyIfCached;
        this.f56341l = builder.noTransform;
    }

    public boolean noCache() {
        return this.f56331b;
    }

    public boolean noStore() {
        return this.f56332c;
    }

    public int maxAgeSeconds() {
        return this.f56333d;
    }

    public int sMaxAgeSeconds() {
        return this.f56334e;
    }

    public boolean isPrivate() {
        return this.f56335f;
    }

    public boolean isPublic() {
        return this.f56336g;
    }

    public boolean mustRevalidate() {
        return this.f56337h;
    }

    public int maxStaleSeconds() {
        return this.f56338i;
    }

    public int minFreshSeconds() {
        return this.f56339j;
    }

    public boolean onlyIfCached() {
        return this.f56340k;
    }

    public boolean noTransform() {
        return this.f56341l;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static didihttp.CacheControl parse(didihttp.Headers r21) {
        /*
            r0 = r21
            int r1 = r21.size()
            r6 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = -1
            r12 = -1
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = -1
            r17 = -1
            r18 = 0
            r19 = 0
        L_0x0018:
            if (r6 >= r1) goto L_0x0131
            java.lang.String r2 = r0.name(r6)
            java.lang.String r4 = r0.value(r6)
            java.lang.String r3 = "Cache-Control"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x002f
            if (r8 == 0) goto L_0x002d
            goto L_0x0037
        L_0x002d:
            r8 = r4
            goto L_0x0038
        L_0x002f:
            java.lang.String r3 = "Pragma"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x012a
        L_0x0037:
            r7 = 0
        L_0x0038:
            r2 = 0
        L_0x0039:
            int r3 = r4.length()
            if (r2 >= r3) goto L_0x012a
            java.lang.String r3 = "=,;"
            int r3 = didihttp.internal.http.HttpHeaders.skipUntil(r4, r2, r3)
            java.lang.String r2 = r4.substring(r2, r3)
            java.lang.String r2 = r2.trim()
            int r5 = r4.length()
            if (r3 == r5) goto L_0x0097
            char r5 = r4.charAt(r3)
            r0 = 44
            if (r5 == r0) goto L_0x0097
            char r0 = r4.charAt(r3)
            r5 = 59
            if (r0 != r5) goto L_0x0064
            goto L_0x0097
        L_0x0064:
            int r3 = r3 + 1
            int r0 = didihttp.internal.http.HttpHeaders.skipWhitespace(r4, r3)
            int r3 = r4.length()
            if (r0 >= r3) goto L_0x0087
            char r3 = r4.charAt(r0)
            r5 = 34
            if (r3 != r5) goto L_0x0087
            int r0 = r0 + 1
            java.lang.String r3 = "\""
            int r3 = didihttp.internal.http.HttpHeaders.skipUntil(r4, r0, r3)
            java.lang.String r0 = r4.substring(r0, r3)
            r5 = 1
            int r3 = r3 + r5
            goto L_0x009b
        L_0x0087:
            r5 = 1
            java.lang.String r3 = ",;"
            int r3 = didihttp.internal.http.HttpHeaders.skipUntil(r4, r0, r3)
            java.lang.String r0 = r4.substring(r0, r3)
            java.lang.String r0 = r0.trim()
            goto L_0x009b
        L_0x0097:
            r5 = 1
            int r3 = r3 + 1
            r0 = 0
        L_0x009b:
            java.lang.String r5 = "no-cache"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00a7
            r5 = -1
            r9 = 1
            goto L_0x0125
        L_0x00a7:
            java.lang.String r5 = "no-store"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00b3
            r5 = -1
            r10 = 1
            goto L_0x0125
        L_0x00b3:
            java.lang.String r5 = "max-age"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00c1
            r5 = -1
            int r11 = didihttp.internal.http.HttpHeaders.parseSeconds(r0, r5)
            goto L_0x0125
        L_0x00c1:
            java.lang.String r5 = "s-maxage"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00cf
            r5 = -1
            int r12 = didihttp.internal.http.HttpHeaders.parseSeconds(r0, r5)
            goto L_0x0125
        L_0x00cf:
            java.lang.String r5 = "private"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00da
            r5 = -1
            r13 = 1
            goto L_0x0125
        L_0x00da:
            java.lang.String r5 = "public"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00e5
            r5 = -1
            r14 = 1
            goto L_0x0125
        L_0x00e5:
            java.lang.String r5 = "must-revalidate"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00f0
            r5 = -1
            r15 = 1
            goto L_0x0125
        L_0x00f0:
            java.lang.String r5 = "max-stale"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0101
            r2 = 2147483647(0x7fffffff, float:NaN)
            int r16 = didihttp.internal.http.HttpHeaders.parseSeconds(r0, r2)
            r5 = -1
            goto L_0x0125
        L_0x0101:
            java.lang.String r5 = "min-fresh"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x010f
            r5 = -1
            int r17 = didihttp.internal.http.HttpHeaders.parseSeconds(r0, r5)
            goto L_0x0125
        L_0x010f:
            r5 = -1
            java.lang.String r0 = "only-if-cached"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x011b
            r18 = 1
            goto L_0x0125
        L_0x011b:
            java.lang.String r0 = "no-transform"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0125
            r19 = 1
        L_0x0125:
            r0 = r21
            r2 = r3
            goto L_0x0039
        L_0x012a:
            r5 = -1
            int r6 = r6 + 1
            r0 = r21
            goto L_0x0018
        L_0x0131:
            if (r7 != 0) goto L_0x0136
            r20 = 0
            goto L_0x0138
        L_0x0136:
            r20 = r8
        L_0x0138:
            didihttp.CacheControl r0 = new didihttp.CacheControl
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttp.CacheControl.parse(didihttp.Headers):didihttp.CacheControl");
    }

    public String toString() {
        String str = this.f56330a;
        if (str != null) {
            return str;
        }
        String a = m40560a();
        this.f56330a = a;
        return a;
    }

    /* renamed from: a */
    private String m40560a() {
        StringBuilder sb = new StringBuilder();
        if (this.f56331b) {
            sb.append("no-cache, ");
        }
        if (this.f56332c) {
            sb.append("no-store, ");
        }
        if (this.f56333d != -1) {
            sb.append("max-age=");
            sb.append(this.f56333d);
            sb.append(", ");
        }
        if (this.f56334e != -1) {
            sb.append("s-maxage=");
            sb.append(this.f56334e);
            sb.append(", ");
        }
        if (this.f56335f) {
            sb.append("private, ");
        }
        if (this.f56336g) {
            sb.append("public, ");
        }
        if (this.f56337h) {
            sb.append("must-revalidate, ");
        }
        if (this.f56338i != -1) {
            sb.append("max-stale=");
            sb.append(this.f56338i);
            sb.append(", ");
        }
        if (this.f56339j != -1) {
            sb.append("min-fresh=");
            sb.append(this.f56339j);
            sb.append(", ");
        }
        if (this.f56340k) {
            sb.append("only-if-cached, ");
        }
        if (this.f56341l) {
            sb.append("no-transform, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public static final class Builder {
        int maxAgeSeconds = -1;
        int maxStaleSeconds = -1;
        int minFreshSeconds = -1;
        boolean noCache;
        boolean noStore;
        boolean noTransform;
        boolean onlyIfCached;

        public Builder noCache() {
            this.noCache = true;
            return this;
        }

        public Builder noStore() {
            this.noStore = true;
            return this;
        }

        public Builder maxAge(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds((long) i);
                this.maxAgeSeconds = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxAge < 0: " + i);
        }

        public Builder maxStale(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds((long) i);
                this.maxStaleSeconds = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }

        public Builder minFresh(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds((long) i);
                this.minFreshSeconds = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("minFresh < 0: " + i);
        }

        public Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }

        public Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public CacheControl build() {
            return new CacheControl(this);
        }
    }
}
