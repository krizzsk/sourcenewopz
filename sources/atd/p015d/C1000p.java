package atd.p015d;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.d.p */
public final class C1000p extends C0991k implements Parcelable {
    public static final Parcelable.Creator<C1000p> CREATOR = new C1001a();

    /* renamed from: a */
    private final String f263a;

    /* renamed from: b */
    private final String f264b;

    /* renamed from: atd.d.p$a */
    static class C1001a implements Parcelable.Creator<C1000p> {
        C1001a() {
        }

        /* renamed from: a */
        public C1000p createFromParcel(Parcel parcel) {
            return new C1000p(parcel);
        }

        /* renamed from: a */
        public C1000p[] newArray(int i) {
            return new C1000p[i];
        }
    }

    C1000p(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        String next = jSONObject.keys().next();
        this.f263a = next;
        this.f264b = jSONObject.getString(next);
    }

    /* renamed from: a */
    static List<C1000p> m299a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new C1000p(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    /* renamed from: b */
    public String mo13716b() {
        return this.f264b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1000p.class != obj.getClass()) {
            return false;
        }
        C1000p pVar = (C1000p) obj;
        String str = this.f263a;
        if (str == null ? pVar.f263a != null : !str.equals(pVar.f263a)) {
            return false;
        }
        String str2 = this.f264b;
        String str3 = pVar.f264b;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f263a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f264b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f263a);
        parcel.writeString(this.f264b);
    }

    protected C1000p(Parcel parcel) {
        super(parcel);
        this.f263a = parcel.readString();
        this.f264b = parcel.readString();
    }

    /* renamed from: a */
    public String mo13715a() {
        return this.f263a;
    }
}
