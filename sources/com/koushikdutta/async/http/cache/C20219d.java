package com.koushikdutta.async.http.cache;

import android.net.Uri;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.http.HttpDate;
import com.koushikdutta.async.http.cache.HeaderParser;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

/* renamed from: com.koushikdutta.async.http.cache.d */
/* compiled from: ResponseHeaders */
final class C20219d {

    /* renamed from: a */
    private static final String f55373a = "X-Android-Sent-Millis";

    /* renamed from: b */
    private static final String f55374b = "X-Android-Received-Millis";

    /* renamed from: c */
    private final Uri f55375c;

    /* renamed from: d */
    private final C20217b f55376d;

    /* renamed from: e */
    private Date f55377e;

    /* renamed from: f */
    private Date f55378f;

    /* renamed from: g */
    private Date f55379g;

    /* renamed from: h */
    private long f55380h;

    /* renamed from: i */
    private long f55381i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f55382j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f55383k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f55384l = -1;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f55385m = -1;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f55386n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f55387o;

    /* renamed from: p */
    private String f55388p;

    /* renamed from: q */
    private int f55389q = -1;

    /* renamed from: r */
    private Set<String> f55390r = Collections.emptySet();

    /* renamed from: s */
    private String f55391s;

    /* renamed from: t */
    private String f55392t;

    /* renamed from: u */
    private long f55393u = -1;

    /* renamed from: v */
    private String f55394v;

    /* renamed from: w */
    private String f55395w;

    /* renamed from: x */
    private String f55396x;

    public C20219d(Uri uri, C20217b bVar) {
        this.f55375c = uri;
        this.f55376d = bVar;
        ResponseHeaders$1 responseHeaders$1 = new ResponseHeaders$1(this);
        for (int i = 0; i < bVar.mo164295e(); i++) {
            String a = bVar.mo164282a(i);
            String b = bVar.mo164288b(i);
            if (HttpHeaders.CACHE_CONTROL.equalsIgnoreCase(a)) {
                HeaderParser.m39882a(b, (HeaderParser.CacheControlHandler) responseHeaders$1);
            } else if (HttpHeaders.DATE.equalsIgnoreCase(a)) {
                this.f55377e = HttpDate.parse(b);
            } else if (HttpHeaders.EXPIRES.equalsIgnoreCase(a)) {
                this.f55379g = HttpDate.parse(b);
            } else if (HttpHeaders.LAST_MODIFIED.equalsIgnoreCase(a)) {
                this.f55378f = HttpDate.parse(b);
            } else if (HttpHeaders.ETAG.equalsIgnoreCase(a)) {
                this.f55388p = b;
            } else if (HttpHeaders.PRAGMA.equalsIgnoreCase(a)) {
                if (b.equalsIgnoreCase("no-cache")) {
                    this.f55382j = true;
                }
            } else if (HttpHeaders.AGE.equalsIgnoreCase(a)) {
                this.f55389q = HeaderParser.m39879a(b);
            } else if (HttpHeaders.VARY.equalsIgnoreCase(a)) {
                if (this.f55390r.isEmpty()) {
                    this.f55390r = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String trim : b.split(",")) {
                    this.f55390r.add(trim.trim().toLowerCase(Locale.US));
                }
            } else if (HttpHeaders.CONTENT_ENCODING.equalsIgnoreCase(a)) {
                this.f55391s = b;
            } else if (HttpHeaders.TRANSFER_ENCODING.equalsIgnoreCase(a)) {
                this.f55392t = b;
            } else if (HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(a)) {
                try {
                    this.f55393u = Long.parseLong(b);
                } catch (NumberFormatException unused) {
                }
            } else if (HttpHeaders.CONNECTION.equalsIgnoreCase(a)) {
                this.f55394v = b;
            } else if (HttpHeaders.PROXY_AUTHENTICATE.equalsIgnoreCase(a)) {
                this.f55395w = b;
            } else if (HttpHeaders.WWW_AUTHENTICATE.equalsIgnoreCase(a)) {
                this.f55396x = b;
            } else if (f55373a.equalsIgnoreCase(a)) {
                this.f55380h = Long.parseLong(b);
            } else if (f55374b.equalsIgnoreCase(a)) {
                this.f55381i = Long.parseLong(b);
            }
        }
    }

    /* renamed from: a */
    public boolean mo164331a() {
        return "gzip".equalsIgnoreCase(this.f55391s);
    }

    /* renamed from: b */
    public void mo164336b() {
        this.f55391s = null;
        this.f55376d.mo164292c(HttpHeaders.CONTENT_ENCODING);
    }

    /* renamed from: c */
    public boolean mo164337c() {
        return "chunked".equalsIgnoreCase(this.f55392t);
    }

    /* renamed from: d */
    public boolean mo164338d() {
        return "close".equalsIgnoreCase(this.f55394v);
    }

    /* renamed from: e */
    public Uri mo164339e() {
        return this.f55375c;
    }

    /* renamed from: f */
    public C20217b mo164340f() {
        return this.f55376d;
    }

    /* renamed from: g */
    public Date mo164341g() {
        return this.f55377e;
    }

    /* renamed from: h */
    public Date mo164342h() {
        return this.f55378f;
    }

    /* renamed from: i */
    public Date mo164343i() {
        return this.f55379g;
    }

    /* renamed from: j */
    public boolean mo164344j() {
        return this.f55382j;
    }

    /* renamed from: k */
    public boolean mo164345k() {
        return this.f55383k;
    }

    /* renamed from: l */
    public int mo164346l() {
        return this.f55384l;
    }

    /* renamed from: m */
    public int mo164347m() {
        return this.f55385m;
    }

    /* renamed from: n */
    public boolean mo164348n() {
        return this.f55386n;
    }

    /* renamed from: o */
    public boolean mo164349o() {
        return this.f55387o;
    }

    /* renamed from: p */
    public String mo164350p() {
        return this.f55388p;
    }

    /* renamed from: q */
    public Set<String> mo164351q() {
        return this.f55390r;
    }

    /* renamed from: r */
    public String mo164352r() {
        return this.f55391s;
    }

    /* renamed from: s */
    public long mo164353s() {
        return this.f55393u;
    }

    /* renamed from: t */
    public String mo164354t() {
        return this.f55394v;
    }

    /* renamed from: u */
    public String mo164355u() {
        return this.f55395w;
    }

    /* renamed from: v */
    public String mo164356v() {
        return this.f55396x;
    }

    /* renamed from: a */
    public void mo164330a(long j, long j2) {
        this.f55380h = j;
        this.f55376d.mo164285a(f55373a, Long.toString(j));
        this.f55381i = j2;
        this.f55376d.mo164285a(f55374b, Long.toString(j2));
    }

    /* renamed from: a */
    private long m39946a(long j) {
        Date date = this.f55377e;
        long j2 = 0;
        if (date != null) {
            j2 = Math.max(0, this.f55381i - date.getTime());
        }
        if (this.f55389q != -1) {
            j2 = Math.max(j2, TimeUnit.SECONDS.toMillis((long) this.f55389q));
        }
        long j3 = this.f55381i;
        return j2 + (j3 - this.f55380h) + (j - j3);
    }

    /* renamed from: x */
    private long m39953x() {
        if (this.f55384l != -1) {
            return TimeUnit.SECONDS.toMillis((long) this.f55384l);
        }
        if (this.f55379g != null) {
            Date date = this.f55377e;
            long time = this.f55379g.getTime() - (date != null ? date.getTime() : this.f55381i);
            if (time > 0) {
                return time;
            }
            return 0;
        } else if (this.f55378f == null || this.f55375c.getEncodedQuery() != null) {
            return 0;
        } else {
            Date date2 = this.f55377e;
            long time2 = (date2 != null ? date2.getTime() : this.f55380h) - this.f55378f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0;
        }
    }

    /* renamed from: y */
    private boolean m39954y() {
        return this.f55384l == -1 && this.f55379g == null;
    }

    /* renamed from: a */
    public boolean mo164332a(C20218c cVar) {
        int c = this.f55376d.mo164291c();
        if (c != 200 && c != 203 && c != 300 && c != 301 && c != 410) {
            return false;
        }
        if ((!cVar.mo164316j() || this.f55386n || this.f55387o || this.f55385m != -1) && !this.f55383k) {
            return true;
        }
        return false;
    }

    /* renamed from: w */
    public boolean mo164357w() {
        return this.f55390r.contains("*");
    }

    /* renamed from: a */
    public boolean mo164334a(Map<String, List<String>> map, Map<String, List<String>> map2) {
        for (String next : this.f55390r) {
            if (!C20216a.m39888a(map.get(next), map2.get(next))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public ResponseSource mo164329a(long j, C20218c cVar) {
        if (!mo164332a(cVar)) {
            return ResponseSource.NETWORK;
        }
        if (cVar.mo164310e() || cVar.mo164328v()) {
            return ResponseSource.NETWORK;
        }
        long a = m39946a(j);
        long x = m39953x();
        if (cVar.mo164311f() != -1) {
            x = Math.min(x, TimeUnit.SECONDS.toMillis((long) cVar.mo164311f()));
        }
        long j2 = 0;
        long millis = cVar.mo164314h() != -1 ? TimeUnit.SECONDS.toMillis((long) cVar.mo164314h()) : 0;
        if (!this.f55387o && cVar.mo164313g() != -1) {
            j2 = TimeUnit.SECONDS.toMillis((long) cVar.mo164313g());
        }
        if (!this.f55382j) {
            long j3 = millis + a;
            if (j3 < j2 + x) {
                if (j3 >= x) {
                    this.f55376d.mo164285a(HttpHeaders.WARNING, "110 HttpURLConnection \"Response is stale\"");
                }
                if (a > 86400000 && m39954y()) {
                    this.f55376d.mo164285a(HttpHeaders.WARNING, "113 HttpURLConnection \"Heuristic expiration\"");
                }
                return ResponseSource.CACHE;
            }
        }
        String str = this.f55388p;
        if (str != null) {
            cVar.mo164312f(str);
        } else {
            Date date = this.f55378f;
            if (date != null) {
                cVar.mo164300a(date);
            } else {
                Date date2 = this.f55377e;
                if (date2 != null) {
                    cVar.mo164300a(date2);
                }
            }
        }
        return cVar.mo164328v() ? ResponseSource.CONDITIONAL_CACHE : ResponseSource.NETWORK;
    }

    /* renamed from: a */
    public boolean mo164333a(C20219d dVar) {
        Date date;
        if (dVar.f55376d.mo164291c() == 304) {
            return true;
        }
        if (this.f55378f == null || (date = dVar.f55378f) == null || date.getTime() >= this.f55378f.getTime()) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public C20219d mo164335b(C20219d dVar) {
        C20217b bVar = new C20217b();
        for (int i = 0; i < this.f55376d.mo164295e(); i++) {
            String a = this.f55376d.mo164282a(i);
            String b = this.f55376d.mo164288b(i);
            if ((!a.equals(HttpHeaders.WARNING) || !b.startsWith("1")) && (!m39948a(a) || dVar.f55376d.mo164294d(a) == null)) {
                bVar.mo164285a(a, b);
            }
        }
        for (int i2 = 0; i2 < dVar.f55376d.mo164295e(); i2++) {
            String a2 = dVar.f55376d.mo164282a(i2);
            if (m39948a(a2)) {
                bVar.mo164285a(a2, dVar.f55376d.mo164288b(i2));
            }
        }
        return new C20219d(this.f55375c, bVar);
    }

    /* renamed from: a */
    private static boolean m39948a(String str) {
        return !str.equalsIgnoreCase(HttpHeaders.CONNECTION) && !str.equalsIgnoreCase("Keep-Alive") && !str.equalsIgnoreCase(HttpHeaders.PROXY_AUTHENTICATE) && !str.equalsIgnoreCase(HttpHeaders.PROXY_AUTHORIZATION) && !str.equalsIgnoreCase(HttpHeaders.f53667TE) && !str.equalsIgnoreCase("Trailers") && !str.equalsIgnoreCase(HttpHeaders.TRANSFER_ENCODING) && !str.equalsIgnoreCase(HttpHeaders.UPGRADE);
    }
}
