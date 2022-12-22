package kshark;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kshark.HeapObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0018\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000b"}, mo175978d2 = {"Lkshark/AppSingletonInspector;", "Lkshark/ObjectInspector;", "singletonClasses", "", "", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: AppSingletonInspector.kt */
public final class AppSingletonInspector implements ObjectInspector {

    /* renamed from: a */
    private final String[] f4516a;

    public AppSingletonInspector(String... strArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "singletonClasses");
        this.f4516a = strArr;
    }

    public void inspect(ObjectReporter objectReporter) {
        Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
        if (objectReporter.getHeapObject() instanceof HeapObject.HeapInstance) {
            for (HeapObject.HeapClass next : ((HeapObject.HeapInstance) objectReporter.getHeapObject()).getInstanceClass().getClassHierarchy()) {
                if (ArraysKt.contains((T[]) this.f4516a, next.getName())) {
                    objectReporter.getNotLeakingReasons().add(next.getName() + " is an app singleton");
                }
            }
        }
    }
}
