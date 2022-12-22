package com.koushikdutta.async.http.cache;

import android.net.Uri;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.http.HttpDate;
import com.koushikdutta.async.http.cache.HeaderParser;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* renamed from: com.koushikdutta.async.http.cache.c */
/* compiled from: RequestHeaders */
final class C20218c {

    /* renamed from: a */
    private final Uri f55355a;

    /* renamed from: b */
    private final C20217b f55356b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f55357c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f55358d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f55359e = -1;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f55360f = -1;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f55361g;

    /* renamed from: h */
    private boolean f55362h;

    /* renamed from: i */
    private int f55363i = -1;

    /* renamed from: j */
    private String f55364j;

    /* renamed from: k */
    private String f55365k;

    /* renamed from: l */
    private String f55366l;

    /* renamed from: m */
    private String f55367m;

    /* renamed from: n */
    private String f55368n;

    /* renamed from: o */
    private String f55369o;

    /* renamed from: p */
    private String f55370p;

    /* renamed from: q */
    private String f55371q;

    /* renamed from: r */
    private String f55372r;

    public C20218c(Uri uri, C20217b bVar) {
        this.f55355a = uri;
        this.f55356b = bVar;
        RequestHeaders$1 requestHeaders$1 = new RequestHeaders$1(this);
        for (int i = 0; i < bVar.mo164295e(); i++) {
            String a = bVar.mo164282a(i);
            String b = bVar.mo164288b(i);
            if (HttpHeaders.CACHE_CONTROL.equalsIgnoreCase(a)) {
                HeaderParser.m39882a(b, (HeaderParser.CacheControlHandler) requestHeaders$1);
            } else if (HttpHeaders.PRAGMA.equalsIgnoreCase(a)) {
                if (b.equalsIgnoreCase("no-cache")) {
                    this.f55357c = true;
                }
            } else if (HttpHeaders.IF_NONE_MATCH.equalsIgnoreCase(a)) {
                this.f55371q = b;
            } else if (HttpHeaders.IF_MODIFIED_SINCE.equalsIgnoreCase(a)) {
                this.f55370p = b;
            } else if (HttpHeaders.AUTHORIZATION.equalsIgnoreCase(a)) {
                this.f55362h = true;
            } else if (HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(a)) {
                try {
                    this.f55363i = Integer.parseInt(b);
                } catch (NumberFormatException unused) {
                }
            } else if (HttpHeaders.TRANSFER_ENCODING.equalsIgnoreCase(a)) {
                this.f55364j = b;
            } else if ("User-Agent".equalsIgnoreCase(a)) {
                this.f55365k = b;
            } else if (HttpHeaders.HOST.equalsIgnoreCase(a)) {
                this.f55366l = b;
            } else if (HttpHeaders.CONNECTION.equalsIgnoreCase(a)) {
                this.f55367m = b;
            } else if (HttpHeaders.ACCEPT_ENCODING.equalsIgnoreCase(a)) {
                this.f55368n = b;
            } else if ("Content-Type".equalsIgnoreCase(a)) {
                this.f55369o = b;
            } else if (HttpHeaders.PROXY_AUTHORIZATION.equalsIgnoreCase(a)) {
                this.f55372r = b;
            }
        }
    }

    /* renamed from: a */
    public boolean mo164302a() {
        return "chunked".equalsIgnoreCase(this.f55364j);
    }

    /* renamed from: b */
    public boolean mo164304b() {
        return "close".equalsIgnoreCase(this.f55367m);
    }

    /* renamed from: c */
    public Uri mo164305c() {
        return this.f55355a;
    }

    /* renamed from: d */
    public C20217b mo164307d() {
        return this.f55356b;
    }

    /* renamed from: e */
    public boolean mo164310e() {
        return this.f55357c;
    }

    /* renamed from: f */
    public int mo164311f() {
        return this.f55358d;
    }

    /* renamed from: g */
    public int mo164313g() {
        return this.f55359e;
    }

    /* renamed from: h */
    public int mo164314h() {
        return this.f55360f;
    }

    /* renamed from: i */
    public boolean mo164315i() {
        return this.f55361g;
    }

    /* renamed from: j */
    public boolean mo164316j() {
        return this.f55362h;
    }

    /* renamed from: k */
    public int mo164317k() {
        return this.f55363i;
    }

    /* renamed from: l */
    public String mo164318l() {
        return this.f55364j;
    }

    /* renamed from: m */
    public String mo164319m() {
        return this.f55365k;
    }

    /* renamed from: n */
    public String mo164320n() {
        return this.f55366l;
    }

    /* renamed from: o */
    public String mo164321o() {
        return this.f55367m;
    }

    /* renamed from: p */
    public String mo164322p() {
        return this.f55368n;
    }

    /* renamed from: q */
    public String mo164323q() {
        return this.f55369o;
    }

    /* renamed from: r */
    public String mo164324r() {
        return this.f55370p;
    }

    /* renamed from: s */
    public String mo164325s() {
        return this.f55371q;
    }

    /* renamed from: t */
    public String mo164326t() {
        return this.f55372r;
    }

    /* renamed from: u */
    public void mo164327u() {
        if (this.f55364j != null) {
            this.f55356b.mo164292c(HttpHeaders.TRANSFER_ENCODING);
        }
        this.f55356b.mo164285a(HttpHeaders.TRANSFER_ENCODING, "chunked");
        this.f55364j = "chunked";
    }

    /* renamed from: a */
    public void mo164298a(int i) {
        if (this.f55363i != -1) {
            this.f55356b.mo164292c(HttpHeaders.CONTENT_LENGTH);
        }
        if (i != -1) {
            this.f55356b.mo164285a(HttpHeaders.CONTENT_LENGTH, Integer.toString(i));
        }
        this.f55363i = i;
    }

    /* renamed from: a */
    public void mo164299a(String str) {
        if (this.f55365k != null) {
            this.f55356b.mo164292c("User-Agent");
        }
        this.f55356b.mo164285a("User-Agent", str);
        this.f55365k = str;
    }

    /* renamed from: b */
    public void mo164303b(String str) {
        if (this.f55366l != null) {
            this.f55356b.mo164292c(HttpHeaders.HOST);
        }
        this.f55356b.mo164285a(HttpHeaders.HOST, str);
        this.f55366l = str;
    }

    /* renamed from: c */
    public void mo164306c(String str) {
        if (this.f55367m != null) {
            this.f55356b.mo164292c(HttpHeaders.CONNECTION);
        }
        this.f55356b.mo164285a(HttpHeaders.CONNECTION, str);
        this.f55367m = str;
    }

    /* renamed from: d */
    public void mo164308d(String str) {
        if (this.f55368n != null) {
            this.f55356b.mo164292c(HttpHeaders.ACCEPT_ENCODING);
        }
        this.f55356b.mo164285a(HttpHeaders.ACCEPT_ENCODING, str);
        this.f55368n = str;
    }

    /* renamed from: e */
    public void mo164309e(String str) {
        if (this.f55369o != null) {
            this.f55356b.mo164292c("Content-Type");
        }
        this.f55356b.mo164285a("Content-Type", str);
        this.f55369o = str;
    }

    /* renamed from: a */
    public void mo164300a(Date date) {
        if (this.f55370p != null) {
            this.f55356b.mo164292c(HttpHeaders.IF_MODIFIED_SINCE);
        }
        String format = HttpDate.format(date);
        this.f55356b.mo164285a(HttpHeaders.IF_MODIFIED_SINCE, format);
        this.f55370p = format;
    }

    /* renamed from: f */
    public void mo164312f(String str) {
        if (this.f55371q != null) {
            this.f55356b.mo164292c(HttpHeaders.IF_NONE_MATCH);
        }
        this.f55356b.mo164285a(HttpHeaders.IF_NONE_MATCH, str);
        this.f55371q = str;
    }

    /* renamed from: v */
    public boolean mo164328v() {
        return (this.f55370p == null && this.f55371q == null) ? false : true;
    }

    /* renamed from: a */
    public void mo164301a(Map<String, List<String>> map) {
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            if (HttpHeaders.COOKIE.equalsIgnoreCase(str) || "Cookie2".equalsIgnoreCase(str)) {
                this.f55356b.mo164286a(str, (List<String>) (List) next.getValue());
            }
        }
    }
}
