package atd.p015d;

import android.os.Parcel;
import android.os.Parcelable;
import atd.p010a0.C0956a;
import atd.p017e.C1014c;
import atd.p046s0.C1172a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.d.n */
public final class C0996n extends C0992l {
    public static final Parcelable.Creator<C0996n> CREATOR = new C0997a();

    /* renamed from: o */
    private final String f258o;

    /* renamed from: p */
    private final String f259p;

    /* renamed from: q */
    private final String f260q;

    /* renamed from: r */
    private final String f261r;

    /* renamed from: atd.d.n$a */
    static class C0997a implements Parcelable.Creator<C0996n> {
        C0997a() {
        }

        /* renamed from: a */
        public C0996n createFromParcel(Parcel parcel) {
            return new C0996n(parcel);
        }

        /* renamed from: a */
        public C0996n[] newArray(int i) {
            return new C0996n[i];
        }
    }

    C0996n(JSONObject jSONObject) throws C0956a {
        super(jSONObject);
        this.f258o = mo13678d(jSONObject, C1172a.m764a(-13194592864942L));
        this.f259p = mo13678d(jSONObject, C1172a.m764a(-13267607308974L));
        this.f260q = mo13678d(jSONObject, C1172a.m764a(-13319146916526L));
        try {
            this.f261r = mo13676b(jSONObject, C1172a.m764a(-13362096589486L));
        } catch (JSONException e) {
            throw new C0956a(C1172a.m764a(-13435111033518L), e, C1014c.DATA_ELEMENT_MISSING);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0996n.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        C0996n nVar = (C0996n) obj;
        String str = this.f258o;
        if (str == null ? nVar.f258o != null : !str.equals(nVar.f258o)) {
            return false;
        }
        String str2 = this.f259p;
        if (str2 == null ? nVar.f259p != null : !str2.equals(nVar.f259p)) {
            return false;
        }
        String str3 = this.f260q;
        if (str3 == null ? nVar.f260q != null : !str3.equals(nVar.f260q)) {
            return false;
        }
        String str4 = this.f261r;
        String str5 = nVar.f261r;
        if (str4 != null) {
            return str4.equals(str5);
        }
        if (str5 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f258o;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f259p;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f260q;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f261r;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode4 + i;
    }

    /* renamed from: n */
    public String mo13702n() {
        return this.f258o;
    }

    /* renamed from: o */
    public String mo13703o() {
        return this.f259p;
    }

    /* renamed from: p */
    public String mo13704p() {
        return this.f260q;
    }

    /* renamed from: q */
    public String mo13705q() {
        return this.f261r;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f258o);
        parcel.writeString(this.f259p);
        parcel.writeString(this.f260q);
        parcel.writeString(this.f261r);
    }

    protected C0996n(Parcel parcel) {
        super(parcel);
        this.f258o = parcel.readString();
        this.f259p = parcel.readString();
        this.f260q = parcel.readString();
        this.f261r = parcel.readString();
    }
}
