package didihttp;

import didihttp.internal.C20747Util;
import didihttp.internal.http.HttpDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Cookie {

    /* renamed from: a */
    private static final Pattern f56361a = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: b */
    private static final Pattern f56362b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: c */
    private static final Pattern f56363c = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: d */
    private static final Pattern f56364d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: e */
    private final String f56365e;

    /* renamed from: f */
    private final String f56366f;

    /* renamed from: g */
    private final long f56367g;

    /* renamed from: h */
    private final String f56368h;

    /* renamed from: i */
    private final String f56369i;

    /* renamed from: j */
    private final boolean f56370j;

    /* renamed from: k */
    private final boolean f56371k;

    /* renamed from: l */
    private final boolean f56372l;

    /* renamed from: m */
    private final boolean f56373m;

    private Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f56365e = str;
        this.f56366f = str2;
        this.f56367g = j;
        this.f56368h = str3;
        this.f56369i = str4;
        this.f56370j = z;
        this.f56371k = z2;
        this.f56373m = z3;
        this.f56372l = z4;
    }

    Cookie(Builder builder) {
        if (builder.name == null) {
            throw new NullPointerException("builder.name == null");
        } else if (builder.value == null) {
            throw new NullPointerException("builder.value == null");
        } else if (builder.domain != null) {
            this.f56365e = builder.name;
            this.f56366f = builder.value;
            this.f56367g = builder.expiresAt;
            this.f56368h = builder.domain;
            this.f56369i = builder.path;
            this.f56370j = builder.secure;
            this.f56371k = builder.httpOnly;
            this.f56372l = builder.persistent;
            this.f56373m = builder.hostOnly;
        } else {
            throw new NullPointerException("builder.domain == null");
        }
    }

    public String name() {
        return this.f56365e;
    }

    public String value() {
        return this.f56366f;
    }

    public boolean persistent() {
        return this.f56372l;
    }

    public long expiresAt() {
        return this.f56367g;
    }

    public boolean hostOnly() {
        return this.f56373m;
    }

    public String domain() {
        return this.f56368h;
    }

    public String path() {
        return this.f56369i;
    }

    public boolean httpOnly() {
        return this.f56371k;
    }

    public boolean secure() {
        return this.f56370j;
    }

    public boolean matches(HttpUrl httpUrl) {
        boolean z;
        if (this.f56373m) {
            z = httpUrl.host().equals(this.f56368h);
        } else {
            z = m40579a(httpUrl, this.f56368h);
        }
        if (!z || !m40581b(httpUrl, this.f56369i)) {
            return false;
        }
        if (!this.f56370j || httpUrl.isHttps()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m40579a(HttpUrl httpUrl, String str) {
        String host = httpUrl.host();
        if (host.equals(str)) {
            return true;
        }
        if (!host.endsWith(str) || host.charAt((host.length() - str.length()) - 1) != '.' || C20747Util.verifyAsIpAddress(host)) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private static boolean m40581b(HttpUrl httpUrl, String str) {
        String encodedPath = httpUrl.encodedPath();
        if (encodedPath.equals(str)) {
            return true;
        }
        if (!encodedPath.startsWith(str)) {
            return false;
        }
        if (!str.endsWith("/") && encodedPath.charAt(str.length()) != '/') {
            return false;
        }
        return true;
    }

    public static Cookie parse(HttpUrl httpUrl, String str) {
        return m40578a(System.currentTimeMillis(), httpUrl, str);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x010a  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static didihttp.Cookie m40578a(long r23, didihttp.HttpUrl r25, java.lang.String r26) {
        /*
            r0 = r26
            int r1 = r26.length()
            r2 = 0
            r3 = 59
            int r4 = didihttp.internal.C20747Util.delimiterOffset((java.lang.String) r0, (int) r2, (int) r1, (char) r3)
            r5 = 61
            int r6 = didihttp.internal.C20747Util.delimiterOffset((java.lang.String) r0, (int) r2, (int) r4, (char) r5)
            r7 = 0
            if (r6 != r4) goto L_0x0017
            return r7
        L_0x0017:
            java.lang.String r9 = didihttp.internal.C20747Util.trimSubstring(r0, r2, r6)
            boolean r8 = r9.isEmpty()
            if (r8 != 0) goto L_0x0123
            int r8 = didihttp.internal.C20747Util.indexOfControlOrNonAscii(r9)
            r10 = -1
            if (r8 == r10) goto L_0x002a
            goto L_0x0123
        L_0x002a:
            r8 = 1
            int r6 = r6 + r8
            java.lang.String r6 = didihttp.internal.C20747Util.trimSubstring(r0, r6, r4)
            int r11 = didihttp.internal.C20747Util.indexOfControlOrNonAscii(r6)
            if (r11 == r10) goto L_0x0037
            return r7
        L_0x0037:
            int r4 = r4 + r8
            r10 = -1
            r12 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            r8 = r7
            r14 = r8
            r19 = r10
            r21 = r12
            r15 = 0
            r16 = 0
            r17 = 1
            r18 = 0
        L_0x004c:
            if (r4 >= r1) goto L_0x00bb
            int r7 = didihttp.internal.C20747Util.delimiterOffset((java.lang.String) r0, (int) r4, (int) r1, (char) r3)
            int r3 = didihttp.internal.C20747Util.delimiterOffset((java.lang.String) r0, (int) r4, (int) r7, (char) r5)
            java.lang.String r4 = didihttp.internal.C20747Util.trimSubstring(r0, r4, r3)
            if (r3 >= r7) goto L_0x0063
            int r3 = r3 + 1
            java.lang.String r3 = didihttp.internal.C20747Util.trimSubstring(r0, r3, r7)
            goto L_0x0065
        L_0x0063:
            java.lang.String r3 = ""
        L_0x0065:
            java.lang.String r5 = "expires"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0076
            int r4 = r3.length()     // Catch:{ IllegalArgumentException -> 0x00b3 }
            long r21 = m40577a((java.lang.String) r3, (int) r2, (int) r4)     // Catch:{ IllegalArgumentException -> 0x00b3 }
            goto L_0x0082
        L_0x0076:
            java.lang.String r5 = "max-age"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0085
            long r19 = m40576a((java.lang.String) r3)     // Catch:{  }
        L_0x0082:
            r18 = 1
            goto L_0x00b3
        L_0x0085:
            java.lang.String r5 = "domain"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0094
            java.lang.String r14 = m40580b(r3)     // Catch:{ IllegalArgumentException -> 0x00b3 }
            r17 = 0
            goto L_0x00b3
        L_0x0094:
            java.lang.String r5 = "path"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x009e
            r8 = r3
            goto L_0x00b3
        L_0x009e:
            java.lang.String r3 = "secure"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x00a9
            r15 = 1
            goto L_0x00b3
        L_0x00a9:
            java.lang.String r3 = "httponly"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x00b3
            r16 = 1
        L_0x00b3:
            int r4 = r7 + 1
            r3 = 59
            r5 = 61
            r7 = 0
            goto L_0x004c
        L_0x00bb:
            r0 = -9223372036854775808
            int r3 = (r19 > r0 ? 1 : (r19 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x00c3
        L_0x00c1:
            r11 = r0
            goto L_0x00e8
        L_0x00c3:
            int r0 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x00e6
            r0 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r3 = (r19 > r0 ? 1 : (r19 == r0 ? 0 : -1))
            if (r3 > 0) goto L_0x00d5
            r0 = 1000(0x3e8, double:4.94E-321)
            long r19 = r19 * r0
            goto L_0x00da
        L_0x00d5:
            r19 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x00da:
            long r0 = r23 + r19
            int r3 = (r0 > r23 ? 1 : (r0 == r23 ? 0 : -1))
            if (r3 < 0) goto L_0x00e4
            int r3 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r3 <= 0) goto L_0x00c1
        L_0x00e4:
            r11 = r12
            goto L_0x00e8
        L_0x00e6:
            r11 = r21
        L_0x00e8:
            if (r14 != 0) goto L_0x00f2
            java.lang.String r0 = r25.host()
            r13 = r0
            r0 = r25
            goto L_0x00fd
        L_0x00f2:
            r0 = r25
            boolean r1 = m40579a(r0, r14)
            if (r1 != 0) goto L_0x00fc
            r1 = 0
            return r1
        L_0x00fc:
            r13 = r14
        L_0x00fd:
            java.lang.String r1 = "/"
            if (r8 == 0) goto L_0x010a
            boolean r3 = r8.startsWith(r1)
            if (r3 != 0) goto L_0x0108
            goto L_0x010a
        L_0x0108:
            r14 = r8
            goto L_0x011b
        L_0x010a:
            java.lang.String r0 = r25.encodedPath()
            r3 = 47
            int r3 = r0.lastIndexOf(r3)
            if (r3 == 0) goto L_0x011a
            java.lang.String r1 = r0.substring(r2, r3)
        L_0x011a:
            r14 = r1
        L_0x011b:
            didihttp.Cookie r0 = new didihttp.Cookie
            r8 = r0
            r10 = r6
            r8.<init>(r9, r10, r11, r13, r14, r15, r16, r17, r18)
            return r0
        L_0x0123:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttp.Cookie.m40578a(long, didihttp.HttpUrl, java.lang.String):didihttp.Cookie");
    }

    /* renamed from: a */
    private static long m40577a(String str, int i, int i2) {
        int a = m40575a(str, i, i2, false);
        Matcher matcher = f56364d.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (a < i2) {
            int a2 = m40575a(str, a + 1, i2, true);
            matcher.region(a, a2);
            if (i4 == -1 && matcher.usePattern(f56364d).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
                i7 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
            } else if (i5 == -1 && matcher.usePattern(f56363c).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (i6 == -1 && matcher.usePattern(f56362b).matches()) {
                i6 = f56362b.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i3 == -1 && matcher.usePattern(f56361a).matches()) {
                i3 = Integer.parseInt(matcher.group(1));
            }
            a = m40575a(str, a2 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += 2000;
        }
        if (i3 < 1601) {
            throw new IllegalArgumentException();
        } else if (i6 == -1) {
            throw new IllegalArgumentException();
        } else if (i5 < 1 || i5 > 31) {
            throw new IllegalArgumentException();
        } else if (i4 < 0 || i4 > 23) {
            throw new IllegalArgumentException();
        } else if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(C20747Util.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i3);
            gregorianCalendar.set(2, i6 - 1);
            gregorianCalendar.set(5, i5);
            gregorianCalendar.set(11, i4);
            gregorianCalendar.set(12, i7);
            gregorianCalendar.set(13, i8);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    /* renamed from: a */
    private static int m40575a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != 9) || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    private static long m40576a(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (!str.matches("-?\\d+")) {
                throw e;
            } else if (str.startsWith("-")) {
                return Long.MIN_VALUE;
            } else {
                return Long.MAX_VALUE;
            }
        }
    }

    /* renamed from: b */
    private static String m40580b(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String domainToAscii = C20747Util.domainToAscii(str);
            if (domainToAscii != null) {
                return domainToAscii;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public static List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        List<String> values = headers.values("Set-Cookie");
        int size = values.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            Cookie parse = parse(httpUrl, values.get(i));
            if (parse != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(parse);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public static final class Builder {
        String domain;
        long expiresAt = 253402300799999L;
        boolean hostOnly;
        boolean httpOnly;
        String name;
        String path = "/";
        boolean persistent;
        boolean secure;
        String value;

        public Builder name(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str.trim().equals(str)) {
                this.name = str;
                return this;
            } else {
                throw new IllegalArgumentException("name is not trimmed");
            }
        }

        public Builder value(String str) {
            if (str == null) {
                throw new NullPointerException("value == null");
            } else if (str.trim().equals(str)) {
                this.value = str;
                return this;
            } else {
                throw new IllegalArgumentException("value is not trimmed");
            }
        }

        public Builder expiresAt(long j) {
            if (j <= 0) {
                j = Long.MIN_VALUE;
            }
            if (j > 253402300799999L) {
                j = 253402300799999L;
            }
            this.expiresAt = j;
            this.persistent = true;
            return this;
        }

        public Builder domain(String str) {
            return domain(str, false);
        }

        public Builder hostOnlyDomain(String str) {
            return domain(str, true);
        }

        private Builder domain(String str, boolean z) {
            if (str != null) {
                String domainToAscii = C20747Util.domainToAscii(str);
                if (domainToAscii != null) {
                    this.domain = domainToAscii;
                    this.hostOnly = z;
                    return this;
                }
                throw new IllegalArgumentException("unexpected domain: " + str);
            }
            throw new NullPointerException("domain == null");
        }

        public Builder path(String str) {
            if (str.startsWith("/")) {
                this.path = str;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'");
        }

        public Builder secure() {
            this.secure = true;
            return this;
        }

        public Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public Cookie build() {
            return new Cookie(this);
        }
    }

    public String toString() {
        return mo169450a(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo169450a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f56365e);
        sb.append('=');
        sb.append(this.f56366f);
        if (this.f56372l) {
            if (this.f56367g == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(HttpDate.format(new Date(this.f56367g)));
            }
        }
        if (!this.f56373m) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f56368h);
        }
        sb.append("; path=");
        sb.append(this.f56369i);
        if (this.f56370j) {
            sb.append("; secure");
        }
        if (this.f56371k) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        if (cookie.f56365e.equals(this.f56365e) && cookie.f56366f.equals(this.f56366f) && cookie.f56368h.equals(this.f56368h) && cookie.f56369i.equals(this.f56369i) && cookie.f56367g == this.f56367g && cookie.f56370j == this.f56370j && cookie.f56371k == this.f56371k && cookie.f56372l == this.f56372l && cookie.f56373m == this.f56373m) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f56367g;
        return ((((((((((((((((527 + this.f56365e.hashCode()) * 31) + this.f56366f.hashCode()) * 31) + this.f56368h.hashCode()) * 31) + this.f56369i.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (this.f56370j ^ true ? 1 : 0)) * 31) + (this.f56371k ^ true ? 1 : 0)) * 31) + (this.f56372l ^ true ? 1 : 0)) * 31) + (this.f56373m ^ true ? 1 : 0);
    }
}
