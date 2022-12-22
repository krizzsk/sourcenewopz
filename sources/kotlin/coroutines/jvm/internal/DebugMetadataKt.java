package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.p071io.IOUtils;

@Metadata(mo175977d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0002\u001a\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b*\u00020\bH\u0001¢\u0006\u0002\u0010\r\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\bH\u0001¢\u0006\u0002\b\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"COROUTINES_DEBUG_METADATA_VERSION", "", "checkDebugMetadataVersion", "", "expected", "actual", "getDebugMetadataAnnotation", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getLabel", "getSpilledVariableFieldMapping", "", "", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "kotlin-stdlib"}, mo175979k = 2, mo175980mv = {1, 5, 1})
/* compiled from: DebugMetadata.kt */
public final class DebugMetadataKt {

    /* renamed from: a */
    private static final int f59868a = 1;

    public static final StackTraceElement getStackTraceElement(BaseContinuationImpl baseContinuationImpl) {
        int i;
        String str;
        Intrinsics.checkNotNullParameter(baseContinuationImpl, "$this$getStackTraceElementImpl");
        DebugMetadata a = m43980a(baseContinuationImpl);
        if (a == null) {
            return null;
        }
        m43981a(1, a.mo176693v());
        int b = m43982b(baseContinuationImpl);
        if (b < 0) {
            i = -1;
        } else {
            i = a.mo176689l()[b];
        }
        String a2 = ModuleNameRetriever.f59869a.mo176694a(baseContinuationImpl);
        if (a2 == null) {
            str = a.mo176686c();
        } else {
            str = a2 + IOUtils.DIR_SEPARATOR_UNIX + a.mo176686c();
        }
        return new StackTraceElement(str, a.mo176690m(), a.mo176687f(), i);
    }

    /* renamed from: a */
    private static final DebugMetadata m43980a(BaseContinuationImpl baseContinuationImpl) {
        return (DebugMetadata) baseContinuationImpl.getClass().getAnnotation(DebugMetadata.class);
    }

    /* renamed from: b */
    private static final int m43982b(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            Intrinsics.checkNotNullExpressionValue(declaredField, "field");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: a */
    private static final void m43981a(int i, int i2) {
        if (i2 > i) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
        }
    }

    public static final String[] getSpilledVariableFieldMapping(BaseContinuationImpl baseContinuationImpl) {
        Intrinsics.checkNotNullParameter(baseContinuationImpl, "$this$getSpilledVariableFieldMapping");
        DebugMetadata a = m43980a(baseContinuationImpl);
        if (a == null) {
            return null;
        }
        m43981a(1, a.mo176693v());
        ArrayList arrayList = new ArrayList();
        int b = m43982b(baseContinuationImpl);
        int[] i = a.mo176688i();
        int length = i.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i[i2] == b) {
                arrayList.add(a.mo176692s()[i2]);
                arrayList.add(a.mo176691n()[i2]);
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
