package p055case;

import org.json.JSONObject;

/* renamed from: case.case */
/* compiled from: EncoderParameters */
public class C1268case {

    /* renamed from: a */
    private final C1272else f455a;

    /* renamed from: b */
    private final C1266a f456b;

    public C1268case(C1272else elseR, JSONObject jSONObject) {
        this(elseR, m962a(jSONObject));
    }

    /* renamed from: a */
    private static C1266a m962a(JSONObject jSONObject) {
        C1266a aVar = new C1266a();
        if (jSONObject == null) {
            return aVar;
        }
        aVar.mo14131a(jSONObject);
        return aVar;
    }

    /* renamed from: if */
    public C1266a mo14137if() {
        return this.f456b;
    }

    public C1268case(C1272else elseR, C1266a aVar) {
        this.f455a = elseR;
        this.f456b = aVar;
    }

    /* renamed from: do */
    public C1272else mo14136do() {
        return this.f455a;
    }
}
