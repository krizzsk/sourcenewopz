package kshark;

import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001d\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0013\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lkshark/AndroidResourceIdNames;", "", "resourceIds", "", "names", "", "", "([I[Ljava/lang/String;)V", "[Ljava/lang/String;", "get", "id", "", "Companion", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: AndroidResourceIdNames.kt */
public final class AndroidResourceIdNames {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int FIRST_APP_RESOURCE_ID = 2130771968;
    public static final int RESOURCE_ID_TYPE_ITERATOR = 65536;
    /* access modifiers changed from: private */
    public static volatile AndroidResourceIdNames holderField;
    private final String[] names;
    private final int[] resourceIds;

    private AndroidResourceIdNames(int[] iArr, String[] strArr) {
        this.resourceIds = iArr;
        this.names = strArr;
    }

    public /* synthetic */ AndroidResourceIdNames(int[] iArr, String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(iArr, strArr);
    }

    public final String get(int i) {
        int binarySearch$default = ArraysKt.binarySearch$default(this.resourceIds, i, 0, 0, 6, (Object) null);
        if (binarySearch$default >= 0) {
            return this.names[binarySearch$default];
        }
        return null;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\t\u001a\u0004\u0018\u00010\u00042\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0002¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\r\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J2\u0010\u0014\u001a\u00020\u00122\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002¨\u0006\u0016"}, mo175978d2 = {"Lkshark/AndroidResourceIdNames$Companion;", "", "()V", "FIRST_APP_RESOURCE_ID", "", "RESOURCE_ID_TYPE_ITERATOR", "holderField", "Lkshark/AndroidResourceIdNames;", "holderField$annotations", "findIdTypeResourceIdStart", "getResourceTypeName", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Integer;", "readFromHeap", "graph", "Lkshark/HeapGraph;", "resetForTests", "", "resetForTests$shark", "saveToMemory", "getResourceEntryName", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidResourceIdNames.kt */
    public static final class Companion {
        @JvmStatic
        private static /* synthetic */ void holderField$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized void saveToMemory(Function1<? super Integer, String> function1, Function1<? super Integer, String> function12) {
            Intrinsics.checkParameterIsNotNull(function1, "getResourceTypeName");
            Intrinsics.checkParameterIsNotNull(function12, "getResourceEntryName");
            if (AndroidResourceIdNames.holderField == null) {
                List arrayList = new ArrayList();
                Integer findIdTypeResourceIdStart = findIdTypeResourceIdStart(function1);
                if (findIdTypeResourceIdStart != null) {
                    int intValue = findIdTypeResourceIdStart.intValue();
                    while (true) {
                        String invoke = function12.invoke(Integer.valueOf(intValue));
                        if (invoke == null) {
                            break;
                        }
                        arrayList.add(TuplesKt.m42317to(Integer.valueOf(intValue), invoke));
                        intValue++;
                    }
                }
                Iterable<Pair> iterable = arrayList;
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (Pair first : iterable) {
                    arrayList2.add(Integer.valueOf(((Number) first.getFirst()).intValue()));
                }
                int[] intArray = CollectionsKt.toIntArray((List) arrayList2);
                Iterable<Pair> iterable2 = arrayList;
                Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
                for (Pair second : iterable2) {
                    arrayList3.add((String) second.getSecond());
                }
                Object[] array = ((List) arrayList3).toArray(new String[0]);
                if (array != null) {
                    AndroidResourceIdNames.holderField = new AndroidResourceIdNames(intArray, (String[]) array, (DefaultConstructorMarker) null);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }

        private final Integer findIdTypeResourceIdStart(Function1<? super Integer, String> function1) {
            int i = R.anim.abc_fade_in;
            while (true) {
                String invoke = function1.invoke(Integer.valueOf(i));
                if (invoke == null) {
                    return null;
                }
                if (invoke.hashCode() == 3355 && invoke.equals("id")) {
                    return Integer.valueOf(i);
                }
                i += 65536;
            }
        }

        public final AndroidResourceIdNames readFromHeap(HeapGraph heapGraph) {
            Intrinsics.checkParameterIsNotNull(heapGraph, "graph");
            GraphContext context = heapGraph.getContext();
            String name = AndroidResourceIdNames.class.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "AndroidResourceIdNames::class.java.name");
            return (AndroidResourceIdNames) context.getOrPut(name, new AndroidResourceIdNames$Companion$readFromHeap$1(heapGraph));
        }

        public final void resetForTests$shark() {
            AndroidResourceIdNames.holderField = null;
        }
    }
}
