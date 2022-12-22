package kshark;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, mo175978d2 = {"Lkshark/AndroidBuildMirror;", "", "manufacturer", "", "sdkInt", "", "(Ljava/lang/String;I)V", "getManufacturer", "()Ljava/lang/String;", "getSdkInt", "()I", "Companion", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: AndroidBuildMirror.kt */
public final class AndroidBuildMirror {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final String f4513a;

    /* renamed from: b */
    private final int f4514b;

    public AndroidBuildMirror() {
        this((String) null, 0, 3, (DefaultConstructorMarker) null);
    }

    public AndroidBuildMirror(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "manufacturer");
        this.f4513a = str;
        this.f4514b = i;
    }

    public final String getManufacturer() {
        return this.f4513a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AndroidBuildMirror(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "Crop" : str, (i2 & 2) != 0 ? 21 : i);
    }

    public final int getSdkInt() {
        return this.f4514b;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lkshark/AndroidBuildMirror$Companion;", "", "()V", "fromHeapGraph", "Lkshark/AndroidBuildMirror;", "graph", "Lkshark/HeapGraph;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidBuildMirror.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AndroidBuildMirror fromHeapGraph(HeapGraph heapGraph) {
            Intrinsics.checkParameterIsNotNull(heapGraph, "graph");
            GraphContext context = heapGraph.getContext();
            String name = AndroidBuildMirror.class.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "AndroidBuildMirror::class.java.name");
            return (AndroidBuildMirror) context.getOrPut(name, new AndroidBuildMirror$Companion$fromHeapGraph$1(heapGraph));
        }
    }
}
