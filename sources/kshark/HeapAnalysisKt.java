package kshark;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\b\u0010\u0004\u001a\u00020\u0001H\u0002¨\u0006\u0005"}, mo175978d2 = {"androidManufacturer", "", "androidSdkInt", "", "leakCanaryVersion", "shark"}, mo175979k = 2, mo175980mv = {1, 1, 15})
/* compiled from: HeapAnalysis.kt */
public final class HeapAnalysisKt {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final int m2907a() {
        try {
            Object obj = Class.forName("android.os.Build$VERSION").getDeclaredField("SDK_INT").get((Object) null);
            if (obj != null) {
                return ((Integer) obj).intValue();
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        } catch (Exception unused) {
            return -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final String m2908b() {
        try {
            Object obj = Class.forName("android.os.Build").getDeclaredField("MANUFACTURER").get((Object) null);
            if (obj != null) {
                return (String) obj;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception unused) {
            return "Unknown";
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final String m2909c() {
        try {
            Field declaredField = Class.forName("leakcanary.internal.InternalLeakCanary").getDeclaredField("version");
            Intrinsics.checkExpressionValueIsNotNull(declaredField, "versionField");
            declaredField.setAccessible(true);
            Object obj = declaredField.get((Object) null);
            if (obj != null) {
                return (String) obj;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception unused) {
            return "Unknown";
        }
    }
}
