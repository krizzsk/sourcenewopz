package p239if;

import android.content.Context;
import com.iproov.sdk.core.C19886final;
import org.json.JSONException;
import org.json.JSONObject;
import p055case.C1268case;
import p055case.C1272else;
import p092super.C3097else;
import p093switch.C3128try;
import p235for.C20839if;
import p235for.C20840new;

/* renamed from: if.if */
/* compiled from: ClaimResponse */
public final class C21001if {

    /* renamed from: a */
    private final String f57265a;

    /* renamed from: b */
    private final C20997for f57266b;

    /* renamed from: c */
    private final C20839if f57267c;

    /* renamed from: d */
    private final String f57268d;

    /* renamed from: e */
    private final String f57269e;

    /* renamed from: f */
    private final C3097else f57270f;

    /* renamed from: g */
    private final C20994do f57271g;

    /* renamed from: h */
    private final C1268case f57272h;

    /* renamed from: i */
    private final C20840new f57273i;

    /* renamed from: j */
    private final C19886final f57274j;

    /* renamed from: k */
    private final String f57275k;

    /* renamed from: l */
    private final double f57276l;

    /* renamed from: m */
    private final boolean f57277m;

    /* renamed from: n */
    private final boolean f57278n;

    public C21001if(Context context, JSONObject jSONObject) throws JSONException {
        this.f57265a = jSONObject.getString("token");
        this.f57266b = C20997for.m41061do(jSONObject.getString("type"));
        if (!jSONObject.isNull("flash_pattern")) {
            this.f57267c = new C20839if(jSONObject.getJSONArray("flash_pattern"));
        } else {
            this.f57267c = new C20839if(jSONObject.getString("flash_code"));
        }
        this.f57268d = C3128try.m4081if(jSONObject, "user_name");
        this.f57269e = jSONObject.optString("sp_name");
        this.f57276l = jSONObject.optDouble("omega", 0.0d);
        this.f57270f = C3097else.m3930do(context, jSONObject.optJSONObject("clux_parameters"));
        C19886final finalR = null;
        this.f57275k = C3128try.m4075do(jSONObject, "deprecation_warning", (String) null);
        this.f57278n = jSONObject.optBoolean("sim", false);
        this.f57277m = jSONObject.optBoolean("rtf", false);
        C20994do doVar = C20994do.m41060do(C3128try.m4075do(jSONObject, "assurance_type", (String) null));
        this.f57271g = doVar == null ? C20994do.GENUINE_PRESENCE_ASSURANCE : doVar;
        JSONObject optJSONObject = jSONObject.optJSONObject("lvn_parameters");
        this.f57274j = optJSONObject != null ? new C19886final(optJSONObject) : finalR;
        this.f57272h = new C1268case(C1272else.m985do(jSONObject.optString("codec", C1272else.AVC.f466do)), jSONObject.optJSONObject("factors"));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("gpa_parameters");
        this.f57273i = optJSONObject2 == null ? C20840new.m41058do() : new C20840new(optJSONObject2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo171507a() {
        return this.f57268d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo171508b() {
        return this.f57269e;
    }

    /* renamed from: break  reason: not valid java name */
    public String m47666break() {
        return this.f57265a;
    }

    /* renamed from: case  reason: not valid java name */
    public C3097else m47667case() {
        return this.f57270f;
    }

    /* renamed from: catch  reason: not valid java name */
    public C20997for m47668catch() {
        return this.f57266b;
    }

    /* renamed from: const  reason: not valid java name */
    public boolean m47669const() {
        return this.f57277m;
    }

    /* renamed from: do */
    public C20994do mo171513do() {
        return this.f57271g;
    }

    /* renamed from: else  reason: not valid java name */
    public C19886final m47670else() {
        return this.f57274j;
    }

    /* renamed from: final  reason: not valid java name */
    public boolean m47671final() {
        return this.f57278n;
    }

    /* renamed from: for  reason: not valid java name */
    public C1268case m47672for() {
        return this.f57272h;
    }

    /* renamed from: goto  reason: not valid java name */
    public double m47673goto() {
        return this.f57276l;
    }

    /* renamed from: if */
    public String mo171518if() {
        return this.f57275k;
    }

    /* renamed from: new  reason: not valid java name */
    public C20839if m47674new() {
        return this.f57267c;
    }

    /* renamed from: try  reason: not valid java name */
    public C20840new m47675try() {
        return this.f57273i;
    }
}
