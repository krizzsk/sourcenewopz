package atd.p015d;

import android.os.Parcel;
import android.os.Parcelable;
import atd.p010a0.C0956a;
import atd.p017e.C1012a;
import atd.p017e.C1013b;
import atd.p017e.C1014c;
import atd.p046s0.C1172a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.d.a */
public class C0976a extends C0991k implements Parcelable {
    public static final Parcelable.Creator<C0976a> CREATOR = new C0977a();

    /* renamed from: a */
    private final C1013b f207a;

    /* renamed from: b */
    private final C1012a f208b;

    /* renamed from: atd.d.a$a */
    static class C0977a implements Parcelable.Creator<C0976a> {
        C0977a() {
        }

        /* renamed from: a */
        public C0976a createFromParcel(Parcel parcel) {
            return new C0976a(parcel);
        }

        /* renamed from: a */
        public C0976a[] newArray(int i) {
            return new C0976a[i];
        }
    }

    /* renamed from: atd.d.a$b */
    static /* synthetic */ class C0978b {

        /* renamed from: a */
        static final /* synthetic */ int[] f209a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                atd.e.b[] r0 = atd.p017e.C1013b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f209a = r0
                atd.e.b r1 = atd.p017e.C1013b.SINGLE_TEXT_INPUT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f209a     // Catch:{ NoSuchFieldError -> 0x001d }
                atd.e.b r1 = atd.p017e.C1013b.SINGLE_SELECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f209a     // Catch:{ NoSuchFieldError -> 0x0028 }
                atd.e.b r1 = atd.p017e.C1013b.MULTI_SELECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f209a     // Catch:{ NoSuchFieldError -> 0x0033 }
                atd.e.b r1 = atd.p017e.C1013b.OUT_OF_BAND     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f209a     // Catch:{ NoSuchFieldError -> 0x003e }
                atd.e.b r1 = atd.p017e.C1013b.HTML_UI     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: atd.p015d.C0976a.C0978b.<clinit>():void");
        }
    }

    C0976a(JSONObject jSONObject) throws C0956a {
        super(jSONObject);
        try {
            this.f207a = C1013b.m323a(jSONObject.getInt(C1172a.m764a(-6533098588846L)));
            this.f208b = C1012a.m320a(mo13676b(jSONObject, C1172a.m764a(-6576048261806L)));
        } catch (JSONException e) {
            throw new C0956a(C1172a.m764a(-6674832509614L), e, C1014c.DATA_ELEMENT_MISSING);
        }
    }

    /* renamed from: a */
    public static C0976a m214a(JSONObject jSONObject) throws C0956a {
        try {
            int i = jSONObject.getInt(C1172a.m764a(-6326940158638L));
            int i2 = C0978b.f209a[C1013b.m323a(i).ordinal()];
            if (i2 == 1) {
                return new C1002q(jSONObject);
            }
            if (i2 == 2 || i2 == 3) {
                return new C0998o(jSONObject);
            }
            if (i2 == 4) {
                return new C0996n(jSONObject);
            }
            if (i2 == 5) {
                return new C0983f(jSONObject);
            }
            throw new RuntimeException(C1172a.m764a(-6430019373742L) + i);
        } catch (JSONException e) {
            throw new C0956a(C1172a.m764a(-6369889831598L), e, C1014c.MESSAGE_RECEIVED_INVALID);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0976a aVar = (C0976a) obj;
        if (this.f207a == aVar.f207a && this.f208b == aVar.f208b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        C1013b bVar = this.f207a;
        int i = 0;
        int hashCode = (bVar != null ? bVar.hashCode() : 0) * 31;
        C1012a aVar = this.f208b;
        if (aVar != null) {
            i = aVar.hashCode();
        }
        return hashCode + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f207a.mo13736a());
        parcel.writeString(this.f208b.name());
    }

    protected C0976a(Parcel parcel) {
        super(parcel);
        try {
            this.f207a = C1013b.m323a(parcel.readInt());
            this.f208b = C1012a.m320a(parcel.readString());
        } catch (C0956a e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* renamed from: a */
    public C1013b mo13625a() {
        return this.f207a;
    }
}
