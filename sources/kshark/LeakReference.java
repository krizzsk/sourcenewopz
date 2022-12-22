package kshark;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kshark.LeakTraceElement;
import kshark.LeakTraceReference;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lkshark/LeakReference;", "Ljava/io/Serializable;", "()V", "name", "", "type", "Lkshark/LeakTraceElement$Type;", "fromV20", "Lkshark/LeakTraceReference;", "originObject", "Lkshark/LeakTraceObject;", "Companion", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: LeakReference.kt */
public final class LeakReference implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 2028550902155599651L;
    private final String name;
    private final LeakTraceElement.Type type;

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LeakTraceElement.Type.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[LeakTraceElement.Type.INSTANCE_FIELD.ordinal()] = 1;
            $EnumSwitchMapping$0[LeakTraceElement.Type.STATIC_FIELD.ordinal()] = 2;
            $EnumSwitchMapping$0[LeakTraceElement.Type.LOCAL.ordinal()] = 3;
            $EnumSwitchMapping$0[LeakTraceElement.Type.ARRAY_ENTRY.ordinal()] = 4;
        }
    }

    public final LeakTraceReference fromV20(LeakTraceObject leakTraceObject) {
        LeakTraceReference.ReferenceType referenceType;
        Intrinsics.checkParameterIsNotNull(leakTraceObject, "originObject");
        LeakTraceElement.Type type2 = this.type;
        if (type2 == null) {
            Intrinsics.throwNpe();
        }
        int i = WhenMappings.$EnumSwitchMapping$0[type2.ordinal()];
        if (i == 1) {
            referenceType = LeakTraceReference.ReferenceType.INSTANCE_FIELD;
        } else if (i == 2) {
            referenceType = LeakTraceReference.ReferenceType.STATIC_FIELD;
        } else if (i == 3) {
            referenceType = LeakTraceReference.ReferenceType.LOCAL;
        } else if (i == 4) {
            referenceType = LeakTraceReference.ReferenceType.ARRAY_ENTRY;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        String str = this.name;
        if (str == null) {
            Intrinsics.throwNpe();
        }
        return new LeakTraceReference(leakTraceObject, referenceType, str, "");
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lkshark/LeakReference$Companion;", "", "()V", "serialVersionUID", "", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: LeakReference.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
