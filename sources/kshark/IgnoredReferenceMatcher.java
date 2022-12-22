package kshark;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, mo175978d2 = {"Lkshark/IgnoredReferenceMatcher;", "Lkshark/ReferenceMatcher;", "pattern", "Lkshark/ReferencePattern;", "(Lkshark/ReferencePattern;)V", "getPattern", "()Lkshark/ReferencePattern;", "toString", "", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: ReferenceMatcher.kt */
public final class IgnoredReferenceMatcher extends ReferenceMatcher {

    /* renamed from: a */
    private final ReferencePattern f4598a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IgnoredReferenceMatcher(ReferencePattern referencePattern) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkParameterIsNotNull(referencePattern, "pattern");
        this.f4598a = referencePattern;
    }

    public ReferencePattern getPattern() {
        return this.f4598a;
    }

    public String toString() {
        return "ignored ref: " + getPattern();
    }
}
