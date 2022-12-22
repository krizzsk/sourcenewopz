package atd.p015d;

import android.os.Parcel;
import android.os.Parcelable;
import atd.p010a0.C0956a;
import atd.p017e.C1014c;
import atd.p046s0.C1172a;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.d.o */
public final class C0998o extends C0994m {
    public static final Parcelable.Creator<C0998o> CREATOR = new C0999a();

    /* renamed from: p */
    private final List<C1000p> f262p;

    /* renamed from: atd.d.o$a */
    static class C0999a implements Parcelable.Creator<C0998o> {
        C0999a() {
        }

        /* renamed from: a */
        public C0998o createFromParcel(Parcel parcel) {
            return new C0998o(parcel);
        }

        /* renamed from: a */
        public C0998o[] newArray(int i) {
            return new C0998o[i];
        }
    }

    C0998o(JSONObject jSONObject) throws C0956a {
        super(jSONObject);
        try {
            List<C1000p> a = C1000p.m299a(jSONObject.getJSONArray(C1172a.m764a(-13594024823470L)));
            this.f262p = a;
            if (a.isEmpty()) {
                throw new C0956a(C1172a.m764a(-13679924169390L), C1014c.DATA_ELEMENT_MISSING);
            }
        } catch (JSONException e) {
            throw new C0956a(C1172a.m764a(-13770118482606L), e, C1014c.DATA_ELEMENT_MISSING);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0998o.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        List<C1000p> list = this.f262p;
        List<C1000p> list2 = ((C0998o) obj).f262p;
        if (list != null) {
            return list.equals(list2);
        }
        if (list2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        List<C1000p> list = this.f262p;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    /* renamed from: o */
    public List<C1000p> mo13710o() {
        return this.f262p;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f262p);
    }

    protected C0998o(Parcel parcel) {
        super(parcel);
        this.f262p = parcel.createTypedArrayList(C1000p.CREATOR);
    }
}
