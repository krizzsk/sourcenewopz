package kshark;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kshark.HeapObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "Lkshark/ObjectReporter;", "instance", "Lkshark/HeapObject$HeapInstance;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: AndroidObjectInspectors.kt */
final class AndroidObjectInspectors$VIEW$inspect$1 extends Lambda implements Function2<ObjectReporter, HeapObject.HeapInstance, Unit> {
    public static final AndroidObjectInspectors$VIEW$inspect$1 INSTANCE = new AndroidObjectInspectors$VIEW$inspect$1();

    AndroidObjectInspectors$VIEW$inspect$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0232  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(kshark.ObjectReporter r17, kshark.HeapObject.HeapInstance r18) {
        /*
            r16 = this;
            r0 = r18
            java.lang.String r1 = "$receiver"
            r2 = r17
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r1)
            java.lang.String r1 = "instance"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r1)
            java.lang.String r1 = "android.view.View"
            java.lang.String r3 = "mParent"
            kshark.HeapField r3 = r0.get((java.lang.String) r1, (java.lang.String) r3)
            if (r3 != 0) goto L_0x001b
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x001b:
            kshark.HeapValue r3 = r3.getValue()
            boolean r4 = r3.isNonNullReference()
            java.lang.String r5 = "mWindowAttachCount"
            kshark.HeapField r5 = r0.get((java.lang.String) r1, (java.lang.String) r5)
            if (r5 == 0) goto L_0x0030
            kshark.HeapValue r5 = r5.getValue()
            goto L_0x0031
        L_0x0030:
            r5 = 0
        L_0x0031:
            if (r5 != 0) goto L_0x0036
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0036:
            java.lang.Integer r5 = r5.getAsInt()
            if (r5 != 0) goto L_0x003f
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x003f:
            int r5 = r5.intValue()
            java.lang.String r7 = "mAttachInfo"
            kshark.HeapField r8 = r0.get((java.lang.String) r1, (java.lang.String) r7)
            if (r8 != 0) goto L_0x004e
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x004e:
            kshark.HeapValue r8 = r8.getValue()
            boolean r8 = r8.isNullReference()
            java.lang.String r9 = "mContext"
            kshark.HeapField r9 = r0.get((java.lang.String) r1, (java.lang.String) r9)
            if (r9 != 0) goto L_0x0061
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0061:
            kshark.HeapValue r9 = r9.getValue()
            kshark.HeapObject r9 = r9.getAsObject()
            if (r9 != 0) goto L_0x006e
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x006e:
            kshark.HeapObject$HeapInstance r9 = r9.getAsInstance()
            if (r9 != 0) goto L_0x0077
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0077:
            kshark.HeapObject$HeapInstance r10 = kshark.AndroidObjectInspectorsKt.unwrapActivityContext(r9)
            java.util.LinkedHashSet r11 = r17.getLabels()
            java.util.Collection r11 = (java.util.Collection) r11
            java.lang.String r12 = "mDestroyed"
            java.lang.String r13 = "android.app.Activity"
            java.lang.String r14 = "mContext instance of "
            if (r10 != 0) goto L_0x00a3
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r14)
            java.lang.String r9 = r9.getInstanceClassName()
            r15.append(r9)
            java.lang.String r9 = ", not wrapping activity"
            r15.append(r9)
            java.lang.String r9 = r15.toString()
            goto L_0x011a
        L_0x00a3:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r6 = "with mDestroyed = "
            r15.append(r6)
            kshark.HeapField r6 = r10.get((java.lang.String) r13, (java.lang.String) r12)
            if (r6 == 0) goto L_0x00ca
            kshark.HeapValue r6 = r6.getValue()
            if (r6 == 0) goto L_0x00ca
            java.lang.Boolean r6 = r6.getAsBoolean()
            if (r6 == 0) goto L_0x00ca
            boolean r6 = r6.booleanValue()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            if (r6 == 0) goto L_0x00ca
            goto L_0x00cc
        L_0x00ca:
            java.lang.String r6 = "UNKNOWN"
        L_0x00cc:
            r15.append(r6)
            java.lang.String r6 = r15.toString()
            boolean r15 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r9)
            r2 = 32
            if (r15 == 0) goto L_0x00f5
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r14)
            java.lang.String r14 = r10.getInstanceClassName()
            r9.append(r14)
            r9.append(r2)
            r9.append(r6)
            java.lang.String r9 = r9.toString()
            goto L_0x011a
        L_0x00f5:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r14)
            java.lang.String r9 = r9.getInstanceClassName()
            r15.append(r9)
            java.lang.String r9 = ", wrapping activity "
            r15.append(r9)
            java.lang.String r9 = r10.getInstanceClassName()
            r15.append(r9)
            r15.append(r2)
            r15.append(r6)
            java.lang.String r9 = r15.toString()
        L_0x011a:
            r11.add(r9)
            if (r10 == 0) goto L_0x0149
            kshark.HeapField r2 = r10.get((java.lang.String) r13, (java.lang.String) r12)
            if (r2 == 0) goto L_0x0130
            kshark.HeapValue r2 = r2.getValue()
            if (r2 == 0) goto L_0x0130
            java.lang.Boolean r6 = r2.getAsBoolean()
            goto L_0x0131
        L_0x0130:
            r6 = 0
        L_0x0131:
            r2 = 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0149
            java.util.Set r2 = r17.getLeakingReasons()
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.String r3 = "View.mContext references a destroyed activity"
            r2.add(r3)
            goto L_0x0206
        L_0x0149:
            if (r4 == 0) goto L_0x0206
            if (r5 <= 0) goto L_0x0206
            if (r8 == 0) goto L_0x015c
            java.util.Set r2 = r17.getLeakingReasons()
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.String r3 = "View detached and has parent"
            r2.add(r3)
            goto L_0x0206
        L_0x015c:
            kshark.HeapObject r2 = r3.getAsObject()
            if (r2 != 0) goto L_0x0165
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0165:
            kshark.HeapObject$HeapInstance r2 = r2.getAsInstance()
            if (r2 != 0) goto L_0x016e
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x016e:
            boolean r3 = r2.instanceOf((java.lang.String) r1)
            java.lang.String r6 = "View attached"
            if (r3 == 0) goto L_0x01da
            kshark.HeapField r3 = r2.get((java.lang.String) r1, (java.lang.String) r7)
            if (r3 != 0) goto L_0x017f
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x017f:
            kshark.HeapValue r3 = r3.getValue()
            boolean r3 = r3.isNullReference()
            if (r3 == 0) goto L_0x01ad
            java.util.Set r3 = r17.getLeakingReasons()
            java.util.Collection r3 = (java.util.Collection) r3
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "View attached but parent "
            r6.append(r7)
            java.lang.String r2 = r2.getInstanceClassName()
            r6.append(r2)
            java.lang.String r2 = " detached (attach disorder)"
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r3.add(r2)
            goto L_0x0206
        L_0x01ad:
            java.util.Set r3 = r17.getNotLeakingReasons()
            java.util.Collection r3 = (java.util.Collection) r3
            r3.add(r6)
            java.util.LinkedHashSet r3 = r17.getLabels()
            java.util.Collection r3 = (java.util.Collection) r3
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "View.parent "
            r6.append(r7)
            java.lang.String r2 = r2.getInstanceClassName()
            r6.append(r2)
            java.lang.String r2 = " attached as well"
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r3.add(r2)
            goto L_0x0206
        L_0x01da:
            java.util.Set r3 = r17.getNotLeakingReasons()
            java.util.Collection r3 = (java.util.Collection) r3
            r3.add(r6)
            java.util.LinkedHashSet r3 = r17.getLabels()
            java.util.Collection r3 = (java.util.Collection) r3
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Parent "
            r6.append(r7)
            java.lang.String r2 = r2.getInstanceClassName()
            r6.append(r2)
            java.lang.String r2 = " not a android.view.View"
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r3.add(r2)
        L_0x0206:
            java.util.LinkedHashSet r2 = r17.getLabels()
            java.util.Collection r2 = (java.util.Collection) r2
            if (r4 == 0) goto L_0x0211
            java.lang.String r3 = "View#mParent is set"
            goto L_0x0213
        L_0x0211:
            java.lang.String r3 = "View#mParent is null"
        L_0x0213:
            r2.add(r3)
            java.util.LinkedHashSet r2 = r17.getLabels()
            java.util.Collection r2 = (java.util.Collection) r2
            if (r8 == 0) goto L_0x0221
            java.lang.String r3 = "View#mAttachInfo is null (view detached)"
            goto L_0x0223
        L_0x0221:
            java.lang.String r3 = "View#mAttachInfo is not null (view attached)"
        L_0x0223:
            r2.add(r3)
            kshark.AndroidResourceIdNames$Companion r2 = kshark.AndroidResourceIdNames.Companion
            kshark.HeapGraph r3 = r18.getGraph()
            kshark.AndroidResourceIdNames r2 = r2.readFromHeap(r3)
            if (r2 == 0) goto L_0x026f
            java.lang.String r3 = "mID"
            kshark.HeapField r0 = r0.get((java.lang.String) r1, (java.lang.String) r3)
            if (r0 != 0) goto L_0x023d
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x023d:
            kshark.HeapValue r0 = r0.getValue()
            java.lang.Integer r0 = r0.getAsInt()
            if (r0 != 0) goto L_0x024a
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x024a:
            int r0 = r0.intValue()
            r1 = -1
            if (r0 == r1) goto L_0x026f
            java.lang.String r0 = r2.get(r0)
            java.util.LinkedHashSet r1 = r17.getLabels()
            java.util.Collection r1 = (java.util.Collection) r1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "View.mID = R.id."
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.add(r0)
        L_0x026f:
            java.util.LinkedHashSet r0 = r17.getLabels()
            java.util.Collection r0 = (java.util.Collection) r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "View.mWindowAttachCount = "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.add(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kshark.AndroidObjectInspectors$VIEW$inspect$1.invoke(kshark.ObjectReporter, kshark.HeapObject$HeapInstance):void");
    }
}
