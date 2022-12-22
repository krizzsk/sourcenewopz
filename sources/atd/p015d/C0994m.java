package atd.p015d;

import android.os.Parcel;
import android.os.Parcelable;
import atd.p010a0.C0956a;
import atd.p017e.C1014c;
import atd.p046s0.C1172a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.d.m */
public class C0994m extends C0992l {
    public static final Parcelable.Creator<C0994m> CREATOR = new C0995a();

    /* renamed from: o */
    private final String f257o;

    /* renamed from: atd.d.m$a */
    static class C0995a implements Parcelable.Creator<C0994m> {
        C0995a() {
        }

        /* renamed from: a */
        public C0994m createFromParcel(Parcel parcel) {
            return new C0994m(parcel);
        }

        /* renamed from: a */
        public C0994m[] newArray(int i) {
            return new C0994m[i];
        }
    }

    C0994m(JSONObject jSONObject) throws C0956a {
        super(jSONObject);
        try {
            this.f257o = mo13676b(jSONObject, C1172a.m764a(-12898240121518L));
        } catch (JSONException e) {
            throw new C0956a(C1172a.m764a(-13009909271214L), e, C1014c.DATA_ELEMENT_MISSING);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        C0994m mVar = (C0994m) obj;
        String str = this.f257o;
        if (str != null) {
            return str.equals(mVar.f257o);
        }
        if (mVar.f257o == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f257o;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    /* renamed from: n */
    public String mo13697n() {
        return this.f257o;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f257o);
    }

    protected C0994m(Parcel parcel) {
        super(parcel);
        this.f257o = parcel.readString();
    }
}
