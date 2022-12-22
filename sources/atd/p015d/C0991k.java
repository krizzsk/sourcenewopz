package atd.p015d;

import android.net.Uri;
import android.os.Parcel;
import atd.p010a0.C0956a;
import atd.p017e.C1014c;
import atd.p046s0.C1172a;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.d.k */
class C0991k {
    C0991k(JSONObject jSONObject) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo13675a(JSONObject jSONObject, String str) throws C0956a, JSONException {
        try {
            return jSONObject.getInt(str);
        } catch (NumberFormatException e) {
            throw new C0956a(C1172a.m764a(-10913965230766L) + str, e, C1014c.DATA_ELEMENT_MISSING);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo13676b(JSONObject jSONObject, String str) throws C0956a, JSONException {
        String string = jSONObject.getString(str);
        m266a(str, string, C1014c.DATA_ELEMENT_MISSING);
        return string;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo13677c(JSONObject jSONObject, String str) throws C0956a, JSONException {
        String string = jSONObject.getString(str);
        m266a(str, string, C1014c.DATA_ELEMENT_MISSING);
        return m265a(str, string);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo13678d(JSONObject jSONObject, String str) throws C0956a {
        String optString = jSONObject.optString(str, (String) null);
        m266a(str, optString, C1014c.DATA_ELEMENT_INVALID_FORMAT);
        return optString;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public Uri mo13679e(JSONObject jSONObject, String str) throws C0956a {
        String optString = jSONObject.optString(str, (String) null);
        if (optString == null) {
            return null;
        }
        m266a(str, optString, C1014c.DATA_ELEMENT_INVALID_FORMAT);
        Uri parse = Uri.parse(optString);
        if (parse.toString().equalsIgnoreCase(optString)) {
            return parse;
        }
        throw new C0956a(C1172a.m764a(-11034224315054L) + str, C1014c.DATA_ELEMENT_INVALID_FORMAT);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public String mo13680f(JSONObject jSONObject, String str) throws C0956a {
        String optString = jSONObject.optString(str, (String) null);
        m266a(str, optString, C1014c.DATA_ELEMENT_INVALID_FORMAT);
        if (optString == null) {
            return null;
        }
        return m265a(str, optString);
    }

    protected C0991k(Parcel parcel) {
    }

    /* renamed from: a */
    private String m265a(String str, String str2) throws C0956a {
        try {
            if (UUID.fromString(str2).toString().equalsIgnoreCase(str2)) {
                return str2;
            }
            throw new C0956a(C1172a.m764a(-11244677712558L) + str, C1014c.DATA_ELEMENT_INVALID_FORMAT);
        } catch (IllegalArgumentException e) {
            throw new C0956a(C1172a.m764a(-11137303530158L) + str, e, C1014c.DATA_ELEMENT_INVALID_FORMAT);
        }
    }

    /* renamed from: a */
    private void m266a(String str, String str2, C1014c cVar) throws C0956a {
        if (str2 != null && str2.length() == 0) {
            throw new C0956a(C1172a.m764a(-11352051894958L) + str, cVar);
        }
    }
}
