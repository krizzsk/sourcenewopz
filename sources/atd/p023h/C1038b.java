package atd.p023h;

import android.content.Context;
import atd.p025i.C1050b;
import atd.p025i.C1051c;
import atd.p046s0.C1172a;
import atd.p052y.C1225c;
import com.adyen.threeds2.Warning;
import com.adyen.threeds2.exception.InvalidInputException;
import com.adyen.threeds2.parameters.ConfigParameters;
import com.adyen.threeds2.util.AdyenConfigParameters;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.h.b */
public final class C1038b {

    /* renamed from: a */
    private final Map<C1037a, JSONObject> f294a = new LinkedHashMap();

    /* renamed from: atd.h.b$a */
    static /* synthetic */ class C1039a {

        /* renamed from: a */
        static final /* synthetic */ int[] f295a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                atd.h.a[] r0 = atd.p023h.C1037a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f295a = r0
                atd.h.a r1 = atd.p023h.C1037a.V1_1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f295a     // Catch:{ NoSuchFieldError -> 0x001d }
                atd.h.a r1 = atd.p023h.C1037a.V1_4     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: atd.p023h.C1038b.C1039a.<clinit>():void");
        }
    }

    private C1038b(Context context, ConfigParameters configParameters, List<Warning> list) throws InvalidInputException {
        JSONArray a = m386a(list);
        for (C1037a next : C1037a.m381a()) {
            try {
                JSONObject a2 = m387a(context, next, configParameters);
                a2.put(C1172a.m764a(-19246201785006L), a);
                this.f294a.put(next, a2);
            } catch (JSONException e) {
                throw C1225c.DEVICE_DATA_FAILURE.mo13983a(e);
            }
        }
    }

    /* renamed from: a */
    public static C1038b m384a(Context context, ConfigParameters configParameters, List<Warning> list) throws InvalidInputException {
        return new C1038b(context.getApplicationContext(), configParameters, list);
    }

    /* renamed from: b */
    private boolean m388b(Object obj) {
        if (obj == null) {
            return true;
        }
        if ((obj instanceof String) && ((String) obj).isEmpty()) {
            return true;
        }
        if ((obj instanceof JSONArray) && ((JSONArray) obj).length() == 0) {
            return true;
        }
        if (!(obj instanceof JSONObject) || ((JSONObject) obj).length() != 0) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public JSONObject mo13772a(C1037a aVar) {
        if (aVar.mo13770c()) {
            JSONObject jSONObject = this.f294a.get(aVar);
            if (jSONObject != null) {
                return jSONObject;
            }
            throw C1225c.DEVICE_DATA_FAILURE.mo13982a();
        }
        throw C1225c.DEVICE_DATA_FAILURE.mo13982a();
    }

    /* renamed from: a */
    private JSONObject m387a(Context context, C1037a aVar, ConfigParameters configParameters) throws JSONException, InvalidInputException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        List<C1050b> b = C1043f.m422a(aVar).mo13774b();
        Collection<String> paramValues = AdyenConfigParameters.getParamValues(configParameters, AdyenConfigParameters.DEVICE_PARAMETER_BLOCK_LIST);
        for (C1050b next : b) {
            String a = next.mo13781a();
            if (paramValues == null || !paramValues.contains(a)) {
                try {
                    Object a2 = next.mo13780a(context);
                    if (m388b(a2)) {
                        int i = C1039a.f295a[aVar.ordinal()];
                        if (i == 1) {
                            jSONObject.put(a, m385a(a2));
                        } else if (i != 2) {
                            throw new InvalidInputException(C1172a.m764a(-19259086686894L) + aVar.toString(), (Throwable) null);
                        } else {
                            throw new C1051c(C1051c.C1052a.PARAMETER_NULL_OR_BLANK, (Throwable) null);
                        }
                    } else {
                        if (aVar == C1037a.V1_4 && !(a2 instanceof JSONArray)) {
                            a2 = a2.toString();
                        }
                        jSONObject.put(a, a2);
                    }
                } catch (C1051c e) {
                    jSONObject2.put(a, e.mo13782a());
                }
            } else {
                jSONObject2.put(a, C1051c.C1052a.MARKET_OR_REGIONAL_RESTRICTION.mo13783a());
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(C1172a.m764a(-19362165901998L), aVar.mo13769b());
        jSONObject3.put(C1172a.m764a(-19375050803886L), jSONObject);
        jSONObject3.put(C1172a.m764a(-19387935705774L), jSONObject2);
        return jSONObject3;
    }

    /* renamed from: a */
    private JSONArray m386a(List<Warning> list) {
        JSONArray jSONArray = new JSONArray();
        for (Warning id : list) {
            jSONArray.put(id.getID());
        }
        return jSONArray;
    }

    /* renamed from: a */
    private Object m385a(Object obj) {
        if (obj == null || !(obj instanceof JSONArray) || ((JSONArray) obj).length() != 0) {
            return C1172a.m764a(-19409410542254L);
        }
        return obj;
    }
}
