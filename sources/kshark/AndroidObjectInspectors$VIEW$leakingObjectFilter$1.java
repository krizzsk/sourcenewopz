package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "heapObject", "Lkshark/HeapObject;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: AndroidObjectInspectors.kt */
final class AndroidObjectInspectors$VIEW$leakingObjectFilter$1 extends Lambda implements Function1<HeapObject, Boolean> {
    public static final AndroidObjectInspectors$VIEW$leakingObjectFilter$1 INSTANCE = new AndroidObjectInspectors$VIEW$leakingObjectFilter$1();

    AndroidObjectInspectors$VIEW$leakingObjectFilter$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((HeapObject) obj));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
        r5 = r5.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean invoke(kshark.HeapObject r5) {
        /*
            r4 = this;
            java.lang.String r0 = "heapObject"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            boolean r0 = r5 instanceof kshark.HeapObject.HeapInstance
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x005d
            kshark.HeapObject$HeapInstance r5 = (kshark.HeapObject.HeapInstance) r5
            java.lang.String r0 = "android.view.View"
            boolean r3 = r5.instanceOf((java.lang.String) r0)
            if (r3 == 0) goto L_0x005d
            java.lang.String r3 = "mContext"
            kshark.HeapField r5 = r5.get((java.lang.String) r0, (java.lang.String) r3)
            if (r5 != 0) goto L_0x0020
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0020:
            kshark.HeapValue r5 = r5.getValue()
            kshark.HeapObject r5 = r5.getAsObject()
            if (r5 != 0) goto L_0x002d
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x002d:
            kshark.HeapObject$HeapInstance r5 = r5.getAsInstance()
            if (r5 != 0) goto L_0x0036
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0036:
            kshark.HeapObject$HeapInstance r5 = kshark.AndroidObjectInspectorsKt.unwrapActivityContext(r5)
            if (r5 == 0) goto L_0x005d
            java.lang.String r0 = "android.app.Activity"
            java.lang.String r3 = "mDestroyed"
            kshark.HeapField r5 = r5.get((java.lang.String) r0, (java.lang.String) r3)
            if (r5 == 0) goto L_0x0051
            kshark.HeapValue r5 = r5.getValue()
            if (r5 == 0) goto L_0x0051
            java.lang.Boolean r5 = r5.getAsBoolean()
            goto L_0x0052
        L_0x0051:
            r5 = 0
        L_0x0052:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r0)
            if (r5 == 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r1 = 0
        L_0x005e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kshark.AndroidObjectInspectors$VIEW$leakingObjectFilter$1.invoke(kshark.HeapObject):boolean");
    }
}
