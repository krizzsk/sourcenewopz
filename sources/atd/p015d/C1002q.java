package atd.p015d;

import android.os.Parcel;
import android.os.Parcelable;
import atd.p010a0.C0956a;
import org.json.JSONObject;

/* renamed from: atd.d.q */
public final class C1002q extends C0994m implements Parcelable {
    public static final Parcelable.Creator<C1002q> CREATOR = new C1003a();

    /* renamed from: atd.d.q$a */
    static class C1003a implements Parcelable.Creator<C1002q> {
        C1003a() {
        }

        /* renamed from: a */
        public C1002q createFromParcel(Parcel parcel) {
            return new C1002q(parcel);
        }

        /* renamed from: a */
        public C1002q[] newArray(int i) {
            return new C1002q[i];
        }
    }

    C1002q(JSONObject jSONObject) throws C0956a {
        super(jSONObject);
    }

    protected C1002q(Parcel parcel) {
        super(parcel);
    }
}
