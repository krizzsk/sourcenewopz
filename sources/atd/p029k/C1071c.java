package atd.p029k;

import android.content.Context;
import android.os.Build;
import atd.p025i.C1050b;
import atd.p025i.C1051c;
import atd.p046s0.C1172a;
import org.json.JSONArray;

/* renamed from: atd.k.c */
public class C1071c implements C1050b {
    /* renamed from: b */
    public JSONArray mo13780a(Context context) throws C1051c {
        if (Build.VERSION.SDK_INT >= 21) {
            JSONArray jSONArray = new JSONArray();
            String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
            if (strArr != null) {
                for (String put : strArr) {
                    jSONArray.put(put);
                }
            }
            return jSONArray;
        }
        throw new C1051c(C1051c.C1052a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }

    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-31684427074222L);
    }
}
