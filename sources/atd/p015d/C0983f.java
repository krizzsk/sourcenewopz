package atd.p015d;

import android.os.Parcel;
import android.os.Parcelable;
import atd.p010a0.C0956a;
import atd.p017e.C1014c;
import atd.p046s0.C1172a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.d.f */
public final class C0983f extends C0976a {
    public static final Parcelable.Creator<C0983f> CREATOR = new C0984a();

    /* renamed from: c */
    private final String f221c;

    /* renamed from: d */
    private final String f222d;

    /* renamed from: atd.d.f$a */
    static class C0984a implements Parcelable.Creator<C0983f> {
        C0984a() {
        }

        /* renamed from: a */
        public C0983f createFromParcel(Parcel parcel) {
            return new C0983f(parcel);
        }

        /* renamed from: a */
        public C0983f[] newArray(int i) {
            return new C0983f[i];
        }
    }

    C0983f(JSONObject jSONObject) throws C0956a {
        super(jSONObject);
        try {
            this.f221c = mo13676b(jSONObject, C1172a.m764a(-8203840866990L));
            this.f222d = mo13678d(jSONObject, C1172a.m764a(-8238200605358L));
        } catch (JSONException e) {
            throw new C0956a(C1172a.m764a(-8302625114798L), e, C1014c.DATA_ELEMENT_MISSING);
        }
    }

    /* renamed from: b */
    public String mo13645b() {
        return this.f221c;
    }

    /* renamed from: c */
    public String mo13646c() {
        return this.f222d;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0983f) || !super.equals(obj)) {
            return false;
        }
        C0983f fVar = (C0983f) obj;
        String str = this.f221c;
        if (str == null ? fVar.f221c != null : !str.equals(fVar.f221c)) {
            return false;
        }
        String str2 = this.f222d;
        String str3 = fVar.f222d;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f221c;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f222d;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f221c);
        parcel.writeString(this.f222d);
    }

    protected C0983f(Parcel parcel) {
        super(parcel);
        this.f221c = parcel.readString();
        this.f222d = parcel.readString();
    }
}
