package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kshark.HeapObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "Lkshark/AndroidBuildMirror;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: AndroidBuildMirror.kt */
final class AndroidBuildMirror$Companion$fromHeapGraph$1 extends Lambda implements Function0<AndroidBuildMirror> {
    final /* synthetic */ HeapGraph $graph;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidBuildMirror$Companion$fromHeapGraph$1(HeapGraph heapGraph) {
        super(0);
        this.$graph = heapGraph;
    }

    public final AndroidBuildMirror invoke() {
        HeapObject.HeapClass findClassByName = this.$graph.findClassByName("android.os.Build");
        if (findClassByName == null) {
            Intrinsics.throwNpe();
        }
        HeapObject.HeapClass findClassByName2 = this.$graph.findClassByName("android.os.Build$VERSION");
        if (findClassByName2 == null) {
            Intrinsics.throwNpe();
        }
        HeapField heapField = findClassByName.get("MANUFACTURER");
        if (heapField == null) {
            Intrinsics.throwNpe();
        }
        HeapValue value = heapField.getValue();
        if (!value.isNonNullReference()) {
            CharSequence readAsJavaString = value.readAsJavaString();
            if (!(readAsJavaString == null || readAsJavaString.length() == 0)) {
                HeapField heapField2 = findClassByName2.get("SDK_INT");
                if (heapField2 == null) {
                    Intrinsics.throwNpe();
                }
                Integer asInt = heapField2.getValue().getAsInt();
                if (asInt == null) {
                    Intrinsics.throwNpe();
                }
                int intValue = asInt.intValue();
                String readAsJavaString2 = value.readAsJavaString();
                if (readAsJavaString2 == null) {
                    Intrinsics.throwNpe();
                }
                return new AndroidBuildMirror(readAsJavaString2, intValue);
            }
        }
        return new AndroidBuildMirror((String) null, 0, 3, (DefaultConstructorMarker) null);
    }
}
