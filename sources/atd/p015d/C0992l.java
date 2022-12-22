package atd.p015d;

import android.os.Parcel;
import android.os.Parcelable;
import atd.p010a0.C0956a;
import atd.p017e.C1012a;
import atd.p017e.C1013b;
import atd.p017e.C1014c;
import atd.p044r0.C1157d;
import atd.p046s0.C1172a;
import com.adyen.threeds2.internal.C1397d;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.d.l */
public class C0992l extends C0976a {
    public static final Parcelable.Creator<C0992l> CREATOR = new C0993a();

    /* renamed from: c */
    private final String f245c;

    /* renamed from: d */
    private final String f246d;

    /* renamed from: e */
    private final String f247e;

    /* renamed from: f */
    private final C1012a f248f;

    /* renamed from: g */
    private final String f249g;

    /* renamed from: h */
    private final String f250h;

    /* renamed from: i */
    private final String f251i;

    /* renamed from: j */
    private final String f252j;

    /* renamed from: k */
    private final String f253k;

    /* renamed from: l */
    private final C0985g f254l;

    /* renamed from: m */
    private final C0985g f255m;

    /* renamed from: n */
    private final String f256n;

    /* renamed from: atd.d.l$a */
    static class C0993a implements Parcelable.Creator<C0992l> {
        C0993a() {
        }

        /* renamed from: a */
        public C0992l createFromParcel(Parcel parcel) {
            return new C0992l(parcel);
        }

        /* renamed from: a */
        public C0992l[] newArray(int i) {
            return new C0992l[i];
        }
    }

    C0992l(JSONObject jSONObject) throws C0956a {
        super(jSONObject);
        try {
            String b = mo13676b(jSONObject, C1172a.m764a(-11446541175470L));
            this.f245c = mo13676b(jSONObject, C1172a.m764a(-11510965684910L));
            this.f246d = mo13676b(jSONObject, C1172a.m764a(-11596865030830L));
            if (b.equals(C1397d.V2_1_0.mo14848c())) {
                this.f247e = mo13678d(jSONObject, C1172a.m764a(-11674174442158L));
            } else if (mo13625a() == C1013b.OUT_OF_BAND) {
                this.f247e = mo13678d(jSONObject, C1172a.m764a(-11755778820782L));
            } else {
                this.f247e = mo13676b(jSONObject, C1172a.m764a(-11837383199406L));
            }
            this.f248f = C1012a.m320a(mo13678d(jSONObject, C1172a.m764a(-11918987578030L)));
            this.f249g = mo13678d(jSONObject, C1172a.m764a(-12034951695022L));
            this.f250h = mo13678d(jSONObject, C1172a.m764a(-12133735942830L));
            this.f251i = mo13678d(jSONObject, C1172a.m764a(-12189570517678L));
            this.f252j = mo13678d(jSONObject, C1172a.m764a(-12241110125230L));
            this.f253k = mo13678d(jSONObject, C1172a.m764a(-12309829601966L));
            this.f254l = C0985g.m240g(jSONObject, C1172a.m764a(-12374254111406L));
            this.f255m = C0985g.m240g(jSONObject, C1172a.m764a(-12425793718958L));
            String d = mo13678d(jSONObject, C1172a.m764a(-12460153457326L));
            this.f256n = d;
            if (d == null) {
                return;
            }
            if (d.length() > 64) {
                throw new C0956a(C1172a.m764a(-12550347770542L), C1014c.DATA_ELEMENT_INVALID_FORMAT);
            }
        } catch (JSONException e) {
            throw new C0956a(C1172a.m764a(-12752211233454L), e, C1014c.DATA_ELEMENT_MISSING);
        }
    }

    /* renamed from: b */
    public String mo13681b() {
        return this.f245c;
    }

    /* renamed from: c */
    public String mo13682c() {
        return this.f247e;
    }

    /* renamed from: d */
    public String mo13683d() {
        return this.f246d;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public String mo13684e() {
        return this.f252j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        C0992l lVar = (C0992l) obj;
        if (C1157d.m727a(this.f245c, lVar.f245c) && C1157d.m727a(this.f246d, lVar.f246d) && C1157d.m727a(this.f247e, lVar.f247e) && this.f248f == lVar.f248f) {
            return C1157d.m727a(this.f249g, lVar.f249g);
        }
        return false;
    }

    /* renamed from: f */
    public String mo13685f() {
        return this.f253k;
    }

    /* renamed from: g */
    public C0985g mo13686g() {
        return this.f254l;
    }

    /* renamed from: h */
    public C0985g mo13687h() {
        return this.f255m;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f245c;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f246d;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f247e;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        C1012a aVar = this.f248f;
        int hashCode5 = (hashCode4 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        String str4 = this.f249g;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode5 + i;
    }

    /* renamed from: i */
    public String mo13688i() {
        return this.f249g;
    }

    /* renamed from: j */
    public String mo13689j() {
        return this.f256n;
    }

    /* renamed from: k */
    public String mo13690k() {
        return this.f250h;
    }

    /* renamed from: l */
    public String mo13691l() {
        return this.f251i;
    }

    /* renamed from: m */
    public boolean mo13692m() {
        return this.f248f.mo13735b();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f245c);
        parcel.writeString(this.f246d);
        parcel.writeString(this.f247e);
        parcel.writeString(this.f248f.name());
        parcel.writeString(this.f249g);
        parcel.writeString(this.f250h);
        parcel.writeString(this.f251i);
        parcel.writeString(this.f252j);
        parcel.writeString(this.f253k);
        parcel.writeParcelable(this.f254l, i);
        parcel.writeParcelable(this.f255m, i);
        parcel.writeString(this.f256n);
    }

    protected C0992l(Parcel parcel) {
        super(parcel);
        this.f245c = parcel.readString();
        this.f246d = parcel.readString();
        this.f247e = parcel.readString();
        try {
            this.f248f = C1012a.m320a(parcel.readString());
            this.f249g = parcel.readString();
            this.f250h = parcel.readString();
            this.f251i = parcel.readString();
            this.f252j = parcel.readString();
            this.f253k = parcel.readString();
            this.f254l = (C0985g) parcel.readParcelable(C0985g.class.getClassLoader());
            this.f255m = (C0985g) parcel.readParcelable(C0985g.class.getClassLoader());
            this.f256n = parcel.readString();
        } catch (C0956a e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
