package p235for;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: for.if */
/* compiled from: FlashPattern */
public final class C20839if {

    /* renamed from: a */
    private ArrayList<C20836do> f57253a = new ArrayList<>();

    public C20839if(JSONArray jSONArray) throws JSONException {
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONArray jSONArray2 = jSONArray.getJSONArray(i);
            int i2 = 0;
            while (true) {
                if (i2 >= jSONArray2.length()) {
                    break;
                }
                JSONObject optJSONObject = jSONArray2.optJSONObject(i2);
                String optString = optJSONObject.optString("type");
                String optString2 = optJSONObject.optString("colour");
                if (optString.toLowerCase().equals("flash") && optString2.length() > 0) {
                    this.f57253a.add(new C20836do(optString2.charAt(0)));
                    break;
                }
                i2++;
            }
        }
    }

    /* renamed from: a */
    private static C20836do m41056a() {
        return new C20836do('0');
    }

    /* renamed from: do */
    public List<C20836do> mo170688do(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i; i3++) {
            arrayList.add(m41056a());
        }
        arrayList.addAll(this.f57253a);
        for (int i4 = 0; i4 < i2; i4++) {
            arrayList.add(m41056a());
        }
        return arrayList;
    }

    @Deprecated
    public C20839if(String str) {
        for (int i = 0; i < str.length(); i++) {
            this.f57253a.add(new C20836do(str.charAt(i)));
        }
    }
}
