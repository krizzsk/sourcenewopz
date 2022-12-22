package kshark;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kshark.GcRoot;
import kshark.LeakTraceObject;
import kshark.LeakTraceReference;
import kshark.internal.StringsKt;
import org.osgi.framework.VersionRange;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r\b\b\u0018\u0000 32\u00020\u0001:\u000234B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015J>\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\u0019\u0010)\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0004\b*\u0010+J\t\u0010,\u001a\u00020\nHÖ\u0001J\u0010\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020&H\u0002J\u000e\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020\nJ\u0006\u00101\u001a\u00020\u0018J\b\u00102\u001a\u00020\u0018H\u0016R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u00065"}, mo175978d2 = {"Lkshark/LeakTrace;", "Ljava/io/Serializable;", "gcRootType", "Lkshark/LeakTrace$GcRootType;", "referencePath", "", "Lkshark/LeakTraceReference;", "leakingObject", "Lkshark/LeakTraceObject;", "retainedHeapByteSize", "", "(Lkshark/LeakTrace$GcRootType;Ljava/util/List;Lkshark/LeakTraceObject;Ljava/lang/Integer;)V", "elements", "Lkshark/LeakTraceElement;", "getGcRootType", "()Lkshark/LeakTrace$GcRootType;", "getLeakingObject", "()Lkshark/LeakTraceObject;", "getReferencePath", "()Ljava/util/List;", "getRetainedHeapByteSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "signature", "", "getSignature", "()Ljava/lang/String;", "suspectReferenceSubpath", "Lkotlin/sequences/Sequence;", "getSuspectReferenceSubpath", "()Lkotlin/sequences/Sequence;", "component1", "component2", "component3", "component4", "copy", "(Lkshark/LeakTrace$GcRootType;Ljava/util/List;Lkshark/LeakTraceObject;Ljava/lang/Integer;)Lkshark/LeakTrace;", "equals", "", "other", "", "fromV20", "fromV20$shark", "(Ljava/lang/Integer;)Lkshark/LeakTrace;", "hashCode", "leakTraceAsString", "showLeakingStatus", "referencePathElementIsSuspect", "index", "toSimplePathString", "toString", "Companion", "GcRootType", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: LeakTrace.kt */
public final class LeakTrace implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final char ZERO_WIDTH_SPACE = '​';
    private static final long serialVersionUID = -6315725584154386429L;
    private final List<LeakTraceElement> elements;
    private final GcRootType gcRootType;
    private final LeakTraceObject leakingObject;
    private final List<LeakTraceReference> referencePath;
    private final Integer retainedHeapByteSize;

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LeakTraceObject.LeakingStatus.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[LeakTraceObject.LeakingStatus.UNKNOWN.ordinal()] = 1;
            $EnumSwitchMapping$0[LeakTraceObject.LeakingStatus.NOT_LEAKING.ordinal()] = 2;
            int[] iArr2 = new int[LeakTraceObject.LeakingStatus.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[LeakTraceObject.LeakingStatus.UNKNOWN.ordinal()] = 1;
            $EnumSwitchMapping$1[LeakTraceObject.LeakingStatus.NOT_LEAKING.ordinal()] = 2;
            $EnumSwitchMapping$1[LeakTraceObject.LeakingStatus.LEAKING.ordinal()] = 3;
        }
    }

    public static /* synthetic */ LeakTrace copy$default(LeakTrace leakTrace, GcRootType gcRootType2, List<LeakTraceReference> list, LeakTraceObject leakTraceObject, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            gcRootType2 = leakTrace.gcRootType;
        }
        if ((i & 2) != 0) {
            list = leakTrace.referencePath;
        }
        if ((i & 4) != 0) {
            leakTraceObject = leakTrace.leakingObject;
        }
        if ((i & 8) != 0) {
            num = leakTrace.retainedHeapByteSize;
        }
        return leakTrace.copy(gcRootType2, list, leakTraceObject, num);
    }

    public final GcRootType component1() {
        return this.gcRootType;
    }

    public final List<LeakTraceReference> component2() {
        return this.referencePath;
    }

    public final LeakTraceObject component3() {
        return this.leakingObject;
    }

    public final Integer component4() {
        return this.retainedHeapByteSize;
    }

    public final LeakTrace copy(GcRootType gcRootType2, List<LeakTraceReference> list, LeakTraceObject leakTraceObject, Integer num) {
        Intrinsics.checkParameterIsNotNull(gcRootType2, "gcRootType");
        Intrinsics.checkParameterIsNotNull(list, "referencePath");
        Intrinsics.checkParameterIsNotNull(leakTraceObject, "leakingObject");
        return new LeakTrace(gcRootType2, list, leakTraceObject, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LeakTrace)) {
            return false;
        }
        LeakTrace leakTrace = (LeakTrace) obj;
        return Intrinsics.areEqual((Object) this.gcRootType, (Object) leakTrace.gcRootType) && Intrinsics.areEqual((Object) this.referencePath, (Object) leakTrace.referencePath) && Intrinsics.areEqual((Object) this.leakingObject, (Object) leakTrace.leakingObject) && Intrinsics.areEqual((Object) this.retainedHeapByteSize, (Object) leakTrace.retainedHeapByteSize);
    }

    public int hashCode() {
        GcRootType gcRootType2 = this.gcRootType;
        int i = 0;
        int hashCode = (gcRootType2 != null ? gcRootType2.hashCode() : 0) * 31;
        List<LeakTraceReference> list = this.referencePath;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        LeakTraceObject leakTraceObject = this.leakingObject;
        int hashCode3 = (hashCode2 + (leakTraceObject != null ? leakTraceObject.hashCode() : 0)) * 31;
        Integer num = this.retainedHeapByteSize;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode3 + i;
    }

    public LeakTrace(GcRootType gcRootType2, List<LeakTraceReference> list, LeakTraceObject leakTraceObject, Integer num) {
        Intrinsics.checkParameterIsNotNull(gcRootType2, "gcRootType");
        Intrinsics.checkParameterIsNotNull(list, "referencePath");
        Intrinsics.checkParameterIsNotNull(leakTraceObject, "leakingObject");
        this.gcRootType = gcRootType2;
        this.referencePath = list;
        this.leakingObject = leakTraceObject;
        this.retainedHeapByteSize = num;
    }

    public final GcRootType getGcRootType() {
        return this.gcRootType;
    }

    public final List<LeakTraceReference> getReferencePath() {
        return this.referencePath;
    }

    public final LeakTraceObject getLeakingObject() {
        return this.leakingObject;
    }

    public final Integer getRetainedHeapByteSize() {
        return this.retainedHeapByteSize;
    }

    public final Sequence<LeakTraceReference> getSuspectReferenceSubpath() {
        return SequencesKt.filterIndexed(CollectionsKt.asSequence(this.referencePath), new LeakTrace$suspectReferenceSubpath$1(this));
    }

    public final String getSignature() {
        return StringsKt.createSHA1Hash(SequencesKt.joinToString$default(getSuspectReferenceSubpath(), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, LeakTrace$signature$1.INSTANCE, 30, (Object) null));
    }

    public final boolean referencePathElementIsSuspect(int i) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.referencePath.get(i).getOriginObject().getLeakingStatus().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return false;
            }
            if (i == CollectionsKt.getLastIndex(this.referencePath) || this.referencePath.get(i + 1).getOriginObject().getLeakingStatus() != LeakTraceObject.LeakingStatus.NOT_LEAKING) {
                return true;
            }
            return false;
        }
        return true;
    }

    public String toString() {
        return leakTraceAsString(true);
    }

    public final String toSimplePathString() {
        return leakTraceAsString(false);
    }

    private final String leakTraceAsString(boolean z) {
        String str;
        String trimIndent = kotlin.text.StringsKt.trimIndent("\n        ┬───\n        │ GC Root: " + this.gcRootType.getDescription() + "\n        │\n      ");
        int i = 0;
        for (Object next : this.referencePath) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            LeakTraceReference leakTraceReference = (LeakTraceReference) next;
            int i3 = WhenMappings.$EnumSwitchMapping$1[this.referencePath.get(i).getOriginObject().getLeakingStatus().ordinal()];
            if (i3 == 1) {
                str = "UNKNOWN";
            } else if (i3 == 2) {
                str = "NO (" + this.referencePath.get(i).getOriginObject().getLeakingStatusReason() + VersionRange.RIGHT_OPEN;
            } else if (i3 == 3) {
                str = "YES (" + this.referencePath.get(i).getOriginObject().getLeakingStatusReason() + VersionRange.RIGHT_OPEN;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            String str2 = trimIndent + "\n├─ " + leakTraceReference.getOriginObject().getClassName() + ' ' + ((i == 0 && this.gcRootType == GcRootType.JAVA_FRAME) ? "thread" : leakTraceReference.getOriginObject().getTypeName());
            if (z) {
                str2 = str2 + "\n│    Leaking: " + str;
            }
            for (String str3 : leakTraceReference.getOriginObject().getLabels()) {
                str2 = str2 + "\n│    " + str3;
            }
            trimIndent = str2 + Companion.getNextElementString(this, leakTraceReference, i, z);
            i = i2;
        }
        String str4 = (trimIndent + "\n") + "╰→ " + this.leakingObject.getClassName() + ' ' + this.leakingObject.getTypeName();
        if (z) {
            str4 = (str4 + "\n​") + "     Leaking: YES (" + this.leakingObject.getLeakingStatusReason() + VersionRange.RIGHT_OPEN;
        }
        for (String str5 : this.leakingObject.getLabels()) {
            str4 = (str4 + "\n​") + "     " + str5;
        }
        return str4;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, mo175978d2 = {"Lkshark/LeakTrace$GcRootType;", "", "description", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "JNI_GLOBAL", "JNI_LOCAL", "JAVA_FRAME", "NATIVE_STACK", "STICKY_CLASS", "THREAD_BLOCK", "MONITOR_USED", "THREAD_OBJECT", "JNI_MONITOR", "Companion", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: LeakTrace.kt */
    public enum GcRootType {
        JNI_GLOBAL("Global variable in native code"),
        JNI_LOCAL("Local variable in native code"),
        JAVA_FRAME("Java local variable"),
        NATIVE_STACK("Input or output parameters in native code"),
        STICKY_CLASS("System class"),
        THREAD_BLOCK("Thread block"),
        MONITOR_USED("Monitor (anything that called the wait() or notify() methods, or that is synchronized.)"),
        THREAD_OBJECT("Thread object"),
        JNI_MONITOR("Root JNI monitor");
        
        public static final Companion Companion = null;
        private final String description;

        private GcRootType(String str) {
            this.description = str;
        }

        public final String getDescription() {
            return this.description;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lkshark/LeakTrace$GcRootType$Companion;", "", "()V", "fromGcRoot", "Lkshark/LeakTrace$GcRootType;", "gcRoot", "Lkshark/GcRoot;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
        /* compiled from: LeakTrace.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final GcRootType fromGcRoot(GcRoot gcRoot) {
                Intrinsics.checkParameterIsNotNull(gcRoot, "gcRoot");
                if (gcRoot instanceof GcRoot.JniGlobal) {
                    return GcRootType.JNI_GLOBAL;
                }
                if (gcRoot instanceof GcRoot.JniLocal) {
                    return GcRootType.JNI_LOCAL;
                }
                if (gcRoot instanceof GcRoot.JavaFrame) {
                    return GcRootType.JAVA_FRAME;
                }
                if (gcRoot instanceof GcRoot.NativeStack) {
                    return GcRootType.NATIVE_STACK;
                }
                if (gcRoot instanceof GcRoot.StickyClass) {
                    return GcRootType.STICKY_CLASS;
                }
                if (gcRoot instanceof GcRoot.ThreadBlock) {
                    return GcRootType.THREAD_BLOCK;
                }
                if (gcRoot instanceof GcRoot.MonitorUsed) {
                    return GcRootType.MONITOR_USED;
                }
                if (gcRoot instanceof GcRoot.ThreadObject) {
                    return GcRootType.THREAD_OBJECT;
                }
                if (gcRoot instanceof GcRoot.JniMonitor) {
                    return GcRootType.JNI_MONITOR;
                }
                throw new IllegalStateException("Unexpected gc root " + gcRoot);
            }
        }
    }

    public final LeakTrace fromV20$shark(Integer num) {
        List<LeakTraceElement> list = this.elements;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        GcRootType gcRootTypeFromV20 = ((LeakTraceElement) CollectionsKt.first(list)).gcRootTypeFromV20();
        List<LeakTraceElement> list2 = this.elements;
        Iterable<LeakTraceElement> subList = list2.subList(0, CollectionsKt.getLastIndex(list2) - 1);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subList, 10));
        for (LeakTraceElement referencePathElementFromV20 : subList) {
            arrayList.add(referencePathElementFromV20.referencePathElementFromV20());
        }
        return new LeakTrace(gcRootTypeFromV20, (List) arrayList, ((LeakTraceElement) CollectionsKt.last(this.elements)).originObjectFromV20(), num);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lkshark/LeakTrace$Companion;", "", "()V", "ZERO_WIDTH_SPACE", "", "serialVersionUID", "", "getNextElementString", "", "leakTrace", "Lkshark/LeakTrace;", "reference", "Lkshark/LeakTraceReference;", "index", "", "showLeakingStatus", "", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: LeakTrace.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final String getNextElementString(LeakTrace leakTrace, LeakTraceReference leakTraceReference, int i, boolean z) {
            String str = "    ↓" + (leakTraceReference.getReferenceType() == LeakTraceReference.ReferenceType.STATIC_FIELD ? " static" : "") + ' ' + leakTraceReference.getOriginObject().getClassSimpleName() + '.' + leakTraceReference.getReferenceDisplayName();
            if (!z || !leakTrace.referencePathElementIsSuspect(i)) {
                return "\n│" + str;
            }
            int lastIndexOf$default = kotlin.text.StringsKt.lastIndexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null) + 1;
            int length = str.length() - lastIndexOf$default;
            return "\n│" + str + "\n│" + kotlin.text.StringsKt.repeat(" ", lastIndexOf$default) + kotlin.text.StringsKt.repeat("~", length);
        }
    }
}
