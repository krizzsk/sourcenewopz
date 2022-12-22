package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "element", "Lkshark/LeakTraceReference;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: LeakTrace.kt */
final class LeakTrace$signature$1 extends Lambda implements Function1<LeakTraceReference, String> {
    public static final LeakTrace$signature$1 INSTANCE = new LeakTrace$signature$1();

    LeakTrace$signature$1() {
        super(1);
    }

    public final String invoke(LeakTraceReference leakTraceReference) {
        Intrinsics.checkParameterIsNotNull(leakTraceReference, "element");
        return leakTraceReference.getOriginObject().getClassName() + leakTraceReference.getReferenceGenericName();
    }
}
