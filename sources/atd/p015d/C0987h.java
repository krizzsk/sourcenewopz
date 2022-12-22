package atd.p015d;

import atd.p010a0.C0956a;
import atd.p017e.C1014c;
import atd.p046s0.C1172a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.d.h */
class C0987h extends C0991k {

    /* renamed from: e */
    private static final Collection<String> f226e = Collections.emptyList();

    /* renamed from: a */
    private final String f227a;

    /* renamed from: b */
    private final String f228b;

    /* renamed from: c */
    private final boolean f229c;

    /* renamed from: d */
    private final JSONObject f230d;

    C0987h(JSONObject jSONObject) throws C0956a {
        super(jSONObject);
        try {
            String b = mo13676b(jSONObject, C1172a.m764a(-8753596680878L));
            this.f227a = b;
            if (b.length() <= 64) {
                String b2 = mo13676b(jSONObject, C1172a.m764a(-8865265830574L));
                this.f228b = b2;
                if (b2.length() <= 64) {
                    boolean z = jSONObject.getBoolean(C1172a.m764a(-8968345045678L));
                    this.f229c = z;
                    if (z) {
                        if (!f226e.contains(this.f228b)) {
                            throw new C0956a(C1172a.m764a(-9058539358894L), C1014c.MESSAGE_EXTENSION_MISSING);
                        }
                    }
                    JSONObject jSONObject2 = jSONObject.getJSONObject(C1172a.m764a(-9234633018030L));
                    this.f230d = jSONObject2;
                    if (jSONObject2.toString().length() > 8059) {
                        throw new C0956a(C1172a.m764a(-9256107854510L), C1014c.DATA_ELEMENT_INVALID_FORMAT);
                    }
                    return;
                }
                throw new C0956a(C1172a.m764a(-8878150732462L), C1014c.DATA_ELEMENT_INVALID_FORMAT);
            }
            throw new C0956a(C1172a.m764a(-8775071517358L), C1014c.DATA_ELEMENT_INVALID_FORMAT);
        } catch (JSONException e) {
            throw new C0956a(C1172a.m764a(-9346302167726L), e, C1014c.DATA_ELEMENT_MISSING);
        }
    }

    /* renamed from: a */
    static List<C0987h> m246a(JSONArray jSONArray) throws JSONException, C0956a {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new C0987h(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }
}
