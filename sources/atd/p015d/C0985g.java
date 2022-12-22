package atd.p015d;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import atd.p010a0.C0956a;
import atd.p017e.C1014c;
import atd.p046s0.C1172a;
import org.json.JSONObject;

/* renamed from: atd.d.g */
public final class C0985g extends C0991k implements Parcelable {
    public static final Parcelable.Creator<C0985g> CREATOR = new C0986a();

    /* renamed from: a */
    private final Uri f223a;

    /* renamed from: b */
    private final Uri f224b;

    /* renamed from: c */
    private final Uri f225c;

    /* renamed from: atd.d.g$a */
    static class C0986a implements Parcelable.Creator<C0985g> {
        C0986a() {
        }

        /* renamed from: a */
        public C0985g createFromParcel(Parcel parcel) {
            return new C0985g(parcel);
        }

        /* renamed from: a */
        public C0985g[] newArray(int i) {
            return new C0985g[i];
        }
    }

    C0985g(JSONObject jSONObject) throws C0956a {
        super(jSONObject);
        this.f223a = mo13679e(jSONObject, C1172a.m764a(-8551733217966L));
        this.f224b = mo13679e(jSONObject, C1172a.m764a(-8581797989038L));
        Uri e = mo13679e(jSONObject, C1172a.m764a(-8603272825518L));
        this.f225c = e;
        if (this.f223a == null && this.f224b == null && e == null) {
            throw new C0956a(C1172a.m764a(-8646222498478L), C1014c.DATA_ELEMENT_INVALID_FORMAT);
        }
    }

    /* renamed from: g */
    public static C0985g m240g(JSONObject jSONObject, String str) throws C0956a {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return null;
        }
        try {
            return new C0985g(optJSONObject);
        } catch (C0956a e) {
            throw new C0956a(C1172a.m764a(-8440064068270L) + str, e, C1014c.DATA_ELEMENT_INVALID_FORMAT);
        }
    }

    /* renamed from: a */
    public Uri mo13651a() {
        return this.f225c;
    }

    /* renamed from: b */
    public Uri mo13652b() {
        return this.f224b;
    }

    /* renamed from: c */
    public Uri mo13653c() {
        return this.f223a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0985g.class != obj.getClass()) {
            return false;
        }
        C0985g gVar = (C0985g) obj;
        Uri uri = this.f223a;
        if (uri == null ? gVar.f223a != null : !uri.equals(gVar.f223a)) {
            return false;
        }
        Uri uri2 = this.f224b;
        if (uri2 == null ? gVar.f224b != null : !uri2.equals(gVar.f224b)) {
            return false;
        }
        Uri uri3 = this.f225c;
        Uri uri4 = gVar.f225c;
        if (uri3 != null) {
            return uri3.equals(uri4);
        }
        if (uri4 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Uri uri = this.f223a;
        int i = 0;
        int hashCode = (uri != null ? uri.hashCode() : 0) * 31;
        Uri uri2 = this.f224b;
        int hashCode2 = (hashCode + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        Uri uri3 = this.f225c;
        if (uri3 != null) {
            i = uri3.hashCode();
        }
        return hashCode2 + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        m239a(parcel, this.f223a);
        m239a(parcel, this.f224b);
        m239a(parcel, this.f225c);
    }

    /* renamed from: a */
    private Uri m238a(Parcel parcel) {
        String readString = parcel.readString();
        if (!TextUtils.isEmpty(readString)) {
            return Uri.parse(readString);
        }
        return null;
    }

    /* renamed from: a */
    private void m239a(Parcel parcel, Uri uri) {
        if (uri != null) {
            parcel.writeString(uri.toString());
        } else {
            parcel.writeString((String) null);
        }
    }

    protected C0985g(Parcel parcel) {
        super(parcel);
        this.f223a = m238a(parcel);
        this.f224b = m238a(parcel);
        this.f225c = m238a(parcel);
    }
}
