package atd.p015d;

import atd.p010a0.C0956a;
import atd.p017e.C1014c;
import atd.p017e.C1015d;
import atd.p046s0.C1172a;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.d.j */
public abstract class C0989j extends C0991k {

    /* renamed from: a */
    private final C1015d f238a;

    /* renamed from: b */
    private final String f239b;

    /* renamed from: c */
    private final String f240c;

    /* renamed from: d */
    private final String f241d;

    /* renamed from: e */
    private final String f242e;

    /* renamed from: f */
    private final List<C0987h> f243f;

    /* renamed from: atd.d.j$a */
    static /* synthetic */ class C0990a {

        /* renamed from: a */
        static final /* synthetic */ int[] f244a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                atd.e.d[] r0 = atd.p017e.C1015d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f244a = r0
                atd.e.d r1 = atd.p017e.C1015d.CHALLENGE_RESPONSE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f244a     // Catch:{ NoSuchFieldError -> 0x001d }
                atd.e.d r1 = atd.p017e.C1015d.ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: atd.p015d.C0989j.C0990a.<clinit>():void");
        }
    }

    C0989j(JSONObject jSONObject) throws C0956a {
        super(jSONObject);
        try {
            this.f238a = C1015d.m333a(mo13676b(jSONObject, C1172a.m764a(-10282605038254L)));
            this.f239b = mo13676b(jSONObject, C1172a.m764a(-10334144645806L));
            this.f240c = mo13677c(jSONObject, C1172a.m764a(-10398569155246L));
            this.f241d = mo13638g(jSONObject, C1172a.m764a(-10488763468462L));
            this.f242e = mo13677c(jSONObject, C1172a.m764a(-10536008108718L));
            JSONArray optJSONArray = jSONObject.optJSONArray(C1172a.m764a(-10583252748974L));
            List<C0987h> a = optJSONArray != null ? C0987h.m246a(optJSONArray) : null;
            this.f243f = a;
            if (a == null) {
                return;
            }
            if (a.size() > 10) {
                throw new C0956a(String.format(Locale.ENGLISH, C1172a.m764a(-10656267193006L), new Object[]{Integer.valueOf(this.f243f.size())}), C1014c.DATA_ELEMENT_INVALID_FORMAT);
            }
        } catch (JSONException e) {
            throw new C0956a(C1172a.m764a(-10767936342702L), e, C1014c.DATA_ELEMENT_MISSING);
        }
    }

    /* renamed from: a */
    public static C0989j m257a(JSONObject jSONObject) throws C0956a {
        try {
            String string = jSONObject.getString(C1172a.m764a(-9981957327534L));
            int i = C0990a.f244a[C1015d.m333a(string).ordinal()];
            if (i == 1) {
                return new C0980c(jSONObject);
            }
            if (i == 2) {
                return new C0982e(jSONObject);
            }
            throw new C0956a(C1172a.m764a(-10179525823150L) + string, C1014c.MESSAGE_RECEIVED_INVALID);
        } catch (JSONException e) {
            throw new C0956a(C1172a.m764a(-10033496935086L), e, C1014c.MESSAGE_RECEIVED_INVALID);
        }
    }

    /* renamed from: b */
    public C1015d mo13671b() {
        return this.f238a;
    }

    /* renamed from: c */
    public String mo13672c() {
        return this.f239b;
    }

    /* renamed from: d */
    public String mo13673d() {
        return this.f242e;
    }

    /* renamed from: e */
    public String mo13674e() {
        return this.f240c;
    }

    /* renamed from: f */
    public abstract boolean mo13636f();

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public abstract String mo13638g(JSONObject jSONObject, String str) throws C0956a, JSONException;

    /* renamed from: a */
    public String mo13670a() {
        return this.f241d;
    }
}
