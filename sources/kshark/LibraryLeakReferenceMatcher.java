package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\b\u0010\u001a\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, mo175978d2 = {"Lkshark/LibraryLeakReferenceMatcher;", "Lkshark/ReferenceMatcher;", "pattern", "Lkshark/ReferencePattern;", "description", "", "patternApplies", "Lkotlin/Function1;", "Lkshark/HeapGraph;", "", "(Lkshark/ReferencePattern;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getDescription", "()Ljava/lang/String;", "getPattern", "()Lkshark/ReferencePattern;", "getPatternApplies", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: ReferenceMatcher.kt */
public final class LibraryLeakReferenceMatcher extends ReferenceMatcher {

    /* renamed from: a */
    private final ReferencePattern f4599a;

    /* renamed from: b */
    private final String f4600b;

    /* renamed from: c */
    private final Function1<HeapGraph, Boolean> f4601c;

    public static /* synthetic */ LibraryLeakReferenceMatcher copy$default(LibraryLeakReferenceMatcher libraryLeakReferenceMatcher, ReferencePattern referencePattern, String str, Function1<HeapGraph, Boolean> function1, int i, Object obj) {
        if ((i & 1) != 0) {
            referencePattern = libraryLeakReferenceMatcher.getPattern();
        }
        if ((i & 2) != 0) {
            str = libraryLeakReferenceMatcher.f4600b;
        }
        if ((i & 4) != 0) {
            function1 = libraryLeakReferenceMatcher.f4601c;
        }
        return libraryLeakReferenceMatcher.copy(referencePattern, str, function1);
    }

    public final ReferencePattern component1() {
        return getPattern();
    }

    public final String component2() {
        return this.f4600b;
    }

    public final Function1<HeapGraph, Boolean> component3() {
        return this.f4601c;
    }

    public final LibraryLeakReferenceMatcher copy(ReferencePattern referencePattern, String str, Function1<? super HeapGraph, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(referencePattern, "pattern");
        Intrinsics.checkParameterIsNotNull(str, "description");
        Intrinsics.checkParameterIsNotNull(function1, "patternApplies");
        return new LibraryLeakReferenceMatcher(referencePattern, str, function1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LibraryLeakReferenceMatcher)) {
            return false;
        }
        LibraryLeakReferenceMatcher libraryLeakReferenceMatcher = (LibraryLeakReferenceMatcher) obj;
        return Intrinsics.areEqual((Object) getPattern(), (Object) libraryLeakReferenceMatcher.getPattern()) && Intrinsics.areEqual((Object) this.f4600b, (Object) libraryLeakReferenceMatcher.f4600b) && Intrinsics.areEqual((Object) this.f4601c, (Object) libraryLeakReferenceMatcher.f4601c);
    }

    public int hashCode() {
        ReferencePattern pattern = getPattern();
        int i = 0;
        int hashCode = (pattern != null ? pattern.hashCode() : 0) * 31;
        String str = this.f4600b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Function1<HeapGraph, Boolean> function1 = this.f4601c;
        if (function1 != null) {
            i = function1.hashCode();
        }
        return hashCode2 + i;
    }

    public ReferencePattern getPattern() {
        return this.f4599a;
    }

    public final String getDescription() {
        return this.f4600b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LibraryLeakReferenceMatcher(ReferencePattern referencePattern, String str, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(referencePattern, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? C23601.INSTANCE : function1);
    }

    public final Function1<HeapGraph, Boolean> getPatternApplies() {
        return this.f4601c;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LibraryLeakReferenceMatcher(ReferencePattern referencePattern, String str, Function1<? super HeapGraph, Boolean> function1) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkParameterIsNotNull(referencePattern, "pattern");
        Intrinsics.checkParameterIsNotNull(str, "description");
        Intrinsics.checkParameterIsNotNull(function1, "patternApplies");
        this.f4599a = referencePattern;
        this.f4600b = str;
        this.f4601c = function1;
    }

    public String toString() {
        return "library leak: " + getPattern();
    }
}
