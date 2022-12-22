package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.wallet.flutter.wallet_flutter.function.FlutterShareMethod;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.osgi.framework.VersionRange;

/* compiled from: IncompatibleVersionErrorData.kt */
public final class IncompatibleVersionErrorData<T> {

    /* renamed from: a */
    private final T f60994a;

    /* renamed from: b */
    private final T f60995b;

    /* renamed from: c */
    private final String f60996c;

    /* renamed from: d */
    private final ClassId f60997d;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IncompatibleVersionErrorData)) {
            return false;
        }
        IncompatibleVersionErrorData incompatibleVersionErrorData = (IncompatibleVersionErrorData) obj;
        return Intrinsics.areEqual((Object) this.f60994a, (Object) incompatibleVersionErrorData.f60994a) && Intrinsics.areEqual((Object) this.f60995b, (Object) incompatibleVersionErrorData.f60995b) && Intrinsics.areEqual((Object) this.f60996c, (Object) incompatibleVersionErrorData.f60996c) && Intrinsics.areEqual((Object) this.f60997d, (Object) incompatibleVersionErrorData.f60997d);
    }

    public int hashCode() {
        T t = this.f60994a;
        int i = 0;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.f60995b;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return ((((hashCode + i) * 31) + this.f60996c.hashCode()) * 31) + this.f60997d.hashCode();
    }

    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.f60994a + ", expectedVersion=" + this.f60995b + ", filePath=" + this.f60996c + ", classId=" + this.f60997d + VersionRange.RIGHT_OPEN;
    }

    public IncompatibleVersionErrorData(T t, T t2, String str, ClassId classId) {
        Intrinsics.checkNotNullParameter(str, FlutterShareMethod.filePathKey);
        Intrinsics.checkNotNullParameter(classId, "classId");
        this.f60994a = t;
        this.f60995b = t2;
        this.f60996c = str;
        this.f60997d = classId;
    }
}
