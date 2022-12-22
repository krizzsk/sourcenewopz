package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "heapObject", "Lkshark/HeapObject;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: AndroidObjectInspectors.kt */
final class AndroidObjectInspectors$ACTIVITY$leakingObjectFilter$1 extends Lambda implements Function1<HeapObject, Boolean> {
    public static final AndroidObjectInspectors$ACTIVITY$leakingObjectFilter$1 INSTANCE = new AndroidObjectInspectors$ACTIVITY$leakingObjectFilter$1();

    AndroidObjectInspectors$ACTIVITY$leakingObjectFilter$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((HeapObject) obj));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        r4 = r4.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean invoke(kshark.HeapObject r4) {
        /*
            r3 = this;
            java.lang.String r0 = "heapObject"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            boolean r0 = r4 instanceof kshark.HeapObject.HeapInstance
            r1 = 1
            if (r0 == 0) goto L_0x0033
            kshark.HeapObject$HeapInstance r4 = (kshark.HeapObject.HeapInstance) r4
            java.lang.String r0 = "android.app.Activity"
            boolean r2 = r4.instanceOf((java.lang.String) r0)
            if (r2 == 0) goto L_0x0033
            java.lang.String r2 = "mDestroyed"
            kshark.HeapField r4 = r4.get((java.lang.String) r0, (java.lang.String) r2)
            if (r4 == 0) goto L_0x0027
            kshark.HeapValue r4 = r4.getValue()
            if (r4 == 0) goto L_0x0027
            java.lang.Boolean r4 = r4.getAsBoolean()
            goto L_0x0028
        L_0x0027:
            r4 = 0
        L_0x0028:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r0)
            if (r4 == 0) goto L_0x0033
            goto L_0x0034
        L_0x0033:
            r1 = 0
        L_0x0034:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kshark.AndroidObjectInspectors$ACTIVITY$leakingObjectFilter$1.invoke(kshark.HeapObject):boolean");
    }
}
