package kshark;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kshark.HeapObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "Lkshark/ObjectReporter;", "instance", "Lkshark/HeapObject$HeapInstance;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: AndroidObjectInspectors.kt */
final class AndroidObjectInspectors$SUPPORT_FRAGMENT$inspect$1 extends Lambda implements Function2<ObjectReporter, HeapObject.HeapInstance, Unit> {
    public static final AndroidObjectInspectors$SUPPORT_FRAGMENT$inspect$1 INSTANCE = new AndroidObjectInspectors$SUPPORT_FRAGMENT$inspect$1();

    AndroidObjectInspectors$SUPPORT_FRAGMENT$inspect$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0048, code lost:
        r6 = r6.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(kshark.ObjectReporter r5, kshark.HeapObject.HeapInstance r6) {
        /*
            r4 = this;
            java.lang.String r0 = "$receiver"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.lang.String r0 = "instance"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            java.lang.String r0 = "androidx.fragment.app.Fragment"
            java.lang.String r1 = "mFragmentManager"
            kshark.HeapField r1 = r6.get((java.lang.String) r0, (java.lang.String) r1)
            if (r1 != 0) goto L_0x0017
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0017:
            kshark.HeapValue r2 = r1.getValue()
            boolean r2 = r2.isNullReference()
            if (r2 == 0) goto L_0x0031
            java.util.Set r2 = r5.getLeakingReasons()
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.String r3 = "null"
            java.lang.String r1 = kshark.AndroidObjectInspectorsKt.m2905a(r1, r3)
            r2.add(r1)
            goto L_0x0040
        L_0x0031:
            java.util.Set r2 = r5.getNotLeakingReasons()
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.String r3 = "not null"
            java.lang.String r1 = kshark.AndroidObjectInspectorsKt.m2905a(r1, r3)
            r2.add(r1)
        L_0x0040:
            java.lang.String r1 = "mTag"
            kshark.HeapField r6 = r6.get((java.lang.String) r0, (java.lang.String) r1)
            if (r6 == 0) goto L_0x0053
            kshark.HeapValue r6 = r6.getValue()
            if (r6 == 0) goto L_0x0053
            java.lang.String r6 = r6.readAsJavaString()
            goto L_0x0054
        L_0x0053:
            r6 = 0
        L_0x0054:
            r0 = r6
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0062
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0060
            goto L_0x0062
        L_0x0060:
            r0 = 0
            goto L_0x0063
        L_0x0062:
            r0 = 1
        L_0x0063:
            if (r0 != 0) goto L_0x007f
            java.util.LinkedHashSet r5 = r5.getLabels()
            java.util.Collection r5 = (java.util.Collection) r5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Fragment.mTag="
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r5.add(r6)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kshark.AndroidObjectInspectors$SUPPORT_FRAGMENT$inspect$1.invoke(kshark.ObjectReporter, kshark.HeapObject$HeapInstance):void");
    }
}
