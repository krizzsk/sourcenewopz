package jumio.core;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

/* renamed from: jumio.core.h0 */
/* compiled from: RejectReason.kt */
public final class C21356h0 implements Serializable {

    /* renamed from: a */
    public String f59623a;

    /* renamed from: b */
    public String f59624b;

    public C21356h0() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public C21356h0(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "label");
        Intrinsics.checkNotNullParameter(str2, "reasonDetailCode");
        this.f59623a = str;
        this.f59624b = str2;
    }

    /* renamed from: a */
    public final String mo175800a() {
        return this.f59624b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C21356h0)) {
            return false;
        }
        C21356h0 h0Var = (C21356h0) obj;
        return Intrinsics.areEqual((Object) this.f59623a, (Object) h0Var.f59623a) && Intrinsics.areEqual((Object) this.f59624b, (Object) h0Var.f59624b);
    }

    public int hashCode() {
        return (this.f59623a.hashCode() * 31) + this.f59624b.hashCode();
    }

    public String toString() {
        return "RejectReasonDetail(label=" + this.f59623a + ", reasonDetailCode=" + this.f59624b + VersionRange.RIGHT_OPEN;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C21356h0(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}
