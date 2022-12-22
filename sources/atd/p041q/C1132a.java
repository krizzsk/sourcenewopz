package atd.p041q;

import android.content.Context;
import atd.p025i.C1050b;
import atd.p025i.C1051c;

/* renamed from: atd.q.a */
public abstract class C1132a implements C1050b {

    /* renamed from: a */
    private final String f337a;

    /* renamed from: b */
    private final String f338b;

    /* renamed from: c */
    private C1133a f339c;

    /* renamed from: atd.q.a$a */
    protected enum C1133a {
        STRING,
        FLOAT,
        INTEGER,
        LONG
    }

    protected C1132a(String str, String str2) {
        this(str, str2, C1133a.STRING);
    }

    /* renamed from: a */
    public String mo13781a() {
        return this.f337a;
    }

    /* renamed from: b */
    public C1132a mo13867b() {
        this.f339c = C1133a.FLOAT;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract Object mo13868b(Context context) throws C1051c;

    /* renamed from: c */
    public C1132a mo13869c() {
        this.f339c = C1133a.INTEGER;
        return this;
    }

    /* renamed from: d */
    public C1132a mo13870d() {
        this.f339c = C1133a.LONG;
        return this;
    }

    /* renamed from: e */
    public String mo13871e() {
        return this.f338b;
    }

    /* renamed from: f */
    public C1133a mo13872f() {
        return this.f339c;
    }

    private C1132a(String str, String str2, C1133a aVar) {
        this.f337a = str;
        this.f338b = str2;
        this.f339c = aVar;
    }

    /* renamed from: a */
    public Object mo13780a(Context context) throws C1051c {
        return mo13868b(context);
    }
}
