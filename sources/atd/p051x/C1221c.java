package atd.p051x;

import atd.p022g0.C1033b;
import atd.p044r0.C1154a;
import atd.p044r0.C1159f;
import atd.p046s0.C1172a;
import atd.p052y.C1223a;
import atd.p052y.C1225c;
import com.adyen.threeds2.parameters.ConfigParameters;
import com.adyen.threeds2.util.AdyenConfigParameters;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.x.c */
public final class C1221c {
    /* renamed from: a */
    public static C1033b m904a(String str, ConfigParameters configParameters) {
        if (str == null || str.isEmpty()) {
            return m902a(configParameters);
        }
        return m903a(str);
    }

    /* renamed from: a */
    private static C1033b m902a(ConfigParameters configParameters) {
        C1159f.m731a((Object) configParameters, C1223a.CONFIG_PARAMETERS);
        try {
            return m905a(C1154a.m709a().mo13922b(AdyenConfigParameters.getParamValue(configParameters, AdyenConfigParameters.DIRECTORY_SERVER_PUBLIC_KEY)), AdyenConfigParameters.getParamValue(configParameters, AdyenConfigParameters.DIRECTORY_SERVER_ID));
        } catch (JSONException e) {
            throw C1225c.UNKNOWN_DIRECTORY_SERVER.mo13983a(e);
        } catch (IllegalArgumentException unused) {
            throw C1223a.CONFIG_PARAMETERS.mo13978a();
        }
    }

    /* renamed from: a */
    private static C1033b m903a(String str) {
        C1159f.m732a(str, C1223a.DIRECTORY_SERVER_ID);
        try {
            return m905a(new JSONObject(C1222d.m908b(str)), str);
        } catch (JSONException e) {
            throw C1225c.UNKNOWN_DIRECTORY_SERVER.mo13983a(e);
        }
    }

    /* renamed from: a */
    private static C1033b m905a(JSONObject jSONObject, String str) throws JSONException {
        if (!jSONObject.has(C1172a.m764a(-634491677002414L))) {
            jSONObject.put(C1172a.m764a(-634508856871598L), str);
        }
        return C1033b.m371a(jSONObject);
    }
}
