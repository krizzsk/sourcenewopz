package kshark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kshark.HeapObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002\u001a\u0015\u0010\u0007\u001a\u00020\b*\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0004\u001a\u000e\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u000bH\u0000¨\u0006\f"}, mo175978d2 = {"applyFromField", "", "Lkshark/ObjectReporter;", "inspector", "Lkshark/ObjectInspector;", "field", "Lkshark/HeapField;", "describedWithValue", "", "valueDescription", "unwrapActivityContext", "Lkshark/HeapObject$HeapInstance;", "shark"}, mo175979k = 2, mo175980mv = {1, 1, 15})
/* compiled from: AndroidObjectInspectors.kt */
public final class AndroidObjectInspectorsKt {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final String m2905a(HeapField heapField, String str) {
        return heapField.getDeclaringClass().getSimpleName() + '#' + heapField.getName() + " is " + str;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m2906a(ObjectReporter objectReporter, ObjectInspector objectInspector, HeapField heapField) {
        if (heapField != null && !heapField.getValue().isNullReference()) {
            HeapObject asObject = heapField.getValue().getAsObject();
            if (asObject == null) {
                Intrinsics.throwNpe();
            }
            ObjectReporter objectReporter2 = new ObjectReporter(asObject);
            objectInspector.inspect(objectReporter2);
            String str = heapField.getDeclaringClass().getSimpleName() + '#' + heapField.getName() + ':';
            Collection labels = objectReporter.getLabels();
            Iterable<String> labels2 = objectReporter2.getLabels();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(labels2, 10));
            for (String str2 : labels2) {
                arrayList.add(str + ' ' + str2);
            }
            CollectionsKt.addAll(labels, (List) arrayList);
            Collection leakingReasons = objectReporter.getLeakingReasons();
            Iterable<String> leakingReasons2 = objectReporter2.getLeakingReasons();
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(leakingReasons2, 10));
            for (String str3 : leakingReasons2) {
                arrayList2.add(str + ' ' + str3);
            }
            CollectionsKt.addAll(leakingReasons, (List) arrayList2);
            Collection notLeakingReasons = objectReporter.getNotLeakingReasons();
            Iterable<String> notLeakingReasons2 = objectReporter2.getNotLeakingReasons();
            Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(notLeakingReasons2, 10));
            for (String str4 : notLeakingReasons2) {
                arrayList3.add(str + ' ' + str4);
            }
            CollectionsKt.addAll(notLeakingReasons, (List) arrayList3);
        }
    }

    public static final HeapObject.HeapInstance unwrapActivityContext(HeapObject.HeapInstance heapInstance) {
        HeapField heapField;
        Intrinsics.checkParameterIsNotNull(heapInstance, "$this$unwrapActivityContext");
        if (heapInstance.instanceOf("android.app.Activity")) {
            return heapInstance;
        }
        if (!heapInstance.instanceOf("android.content.ContextWrapper")) {
            return null;
        }
        List arrayList = new ArrayList();
        while (true) {
            boolean z = true;
            while (z) {
                arrayList.add(Long.valueOf(heapInstance.getObjectId()));
                z = false;
                HeapField heapField2 = heapInstance.get("android.content.ContextWrapper", "mBase");
                if (heapField2 == null) {
                    Intrinsics.throwNpe();
                }
                HeapValue value = heapField2.getValue();
                if (value.isNonNullReference()) {
                    HeapObject asObject = value.getAsObject();
                    if (asObject == null) {
                        Intrinsics.throwNpe();
                    }
                    HeapObject.HeapInstance asInstance = asObject.getAsInstance();
                    if (asInstance == null) {
                        Intrinsics.throwNpe();
                    }
                    if (asInstance.instanceOf("android.app.Activity")) {
                        return asInstance;
                    }
                    if (heapInstance.instanceOf("com.android.internal.policy.DecorContext") && (heapField = heapInstance.get("com.android.internal.policy.DecorContext", "mPhoneWindow")) != null) {
                        HeapObject.HeapInstance valueAsInstance = heapField.getValueAsInstance();
                        if (valueAsInstance == null) {
                            Intrinsics.throwNpe();
                        }
                        HeapField heapField3 = valueAsInstance.get("android.view.Window", "mContext");
                        if (heapField3 == null) {
                            Intrinsics.throwNpe();
                        }
                        asInstance = heapField3.getValueAsInstance();
                        if (asInstance == null) {
                            Intrinsics.throwNpe();
                        }
                        if (asInstance.instanceOf("android.app.Activity")) {
                            return asInstance;
                        }
                    }
                    if (!asInstance.instanceOf("android.content.ContextWrapper") || arrayList.contains(Long.valueOf(asInstance.getObjectId()))) {
                        heapInstance = asInstance;
                    } else {
                        heapInstance = asInstance;
                    }
                }
            }
            return null;
        }
    }
}
