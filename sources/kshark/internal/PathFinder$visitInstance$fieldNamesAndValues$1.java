package kshark.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kshark.HeapField;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "it", "Lkshark/HeapField;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: PathFinder.kt */
final class PathFinder$visitInstance$fieldNamesAndValues$1 extends Lambda implements Function1<HeapField, Boolean> {
    public static final PathFinder$visitInstance$fieldNamesAndValues$1 INSTANCE = new PathFinder$visitInstance$fieldNamesAndValues$1();

    PathFinder$visitInstance$fieldNamesAndValues$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((HeapField) obj));
    }

    public final boolean invoke(HeapField heapField) {
        Intrinsics.checkParameterIsNotNull(heapField, "it");
        return heapField.getValue().isNonNullReference();
    }
}
