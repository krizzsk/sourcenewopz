package atd.p045s;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import atd.p025i.C1050b;
import atd.p046s0.C1172a;
import org.json.JSONArray;

/* renamed from: atd.s.j */
public class C1171j implements C1050b {
    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-35622912084654L);
    }

    /* renamed from: a */
    public Object mo13780a(Context context) {
        JSONArray jSONArray = new JSONArray();
        String string = Settings.Secure.getString(context.getContentResolver(), C1172a.m764a(-35644386921134L));
        if (!TextUtils.isEmpty(string)) {
            for (String put : string.split(C1172a.m764a(-35730286267054L))) {
                jSONArray.put(put);
            }
        }
        return jSONArray;
    }
}
