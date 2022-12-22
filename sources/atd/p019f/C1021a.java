package atd.p019f;

import atd.p009a.C0943e;
import atd.p046s0.C1172a;
import com.adyen.threeds2.internal.C1395b;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.f.a */
public final class C1021a {
    /* renamed from: a */
    public static Map<String, List<String>> m346a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(C1172a.m764a(-18924079237806L), Arrays.asList(new String[]{C0943e.C0944a.APPLICATION_JOSE.mo13560a(C1395b.f995a).mo13565c()}));
        linkedHashMap.put(C1172a.m764a(-18979913812654L), Arrays.asList(new String[]{C0943e.C0944a.APPLICATION_JOSE.mo13561a(), C0943e.C0944a.APPLICATION_JSON.mo13561a()}));
        return linkedHashMap;
    }

    /* renamed from: b */
    public static Map<String, List<String>> m348b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(C1172a.m764a(-18838179891886L), Arrays.asList(new String[]{C0943e.C0944a.APPLICATION_JSON.mo13560a(C1395b.f995a).mo13565c()}));
        linkedHashMap.put(C1172a.m764a(-18894014466734L), Arrays.asList(new String[]{C0943e.C0944a.APPLICATION_JSON.mo13561a()}));
        return linkedHashMap;
    }

    /* renamed from: a */
    public static JSONObject m347a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            jSONObject3.put(next, jSONObject.get(next));
        }
        Iterator<String> keys2 = jSONObject2.keys();
        while (keys2.hasNext()) {
            String next2 = keys2.next();
            jSONObject3.put(next2, jSONObject2.get(next2));
        }
        return jSONObject3;
    }
}
