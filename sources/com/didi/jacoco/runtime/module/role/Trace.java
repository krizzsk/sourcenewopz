package com.didi.jacoco.runtime.module.role;

import com.didi.payment.base.logger.PayLogParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jacoco.agent.p086rt.internal_8ff85ea.Offline;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/jacoco/runtime/module/role/Trace;", "", "spanid", "", "traceid", "(Ljava/lang/String;Ljava/lang/String;)V", "getSpanid", "()Ljava/lang/String;", "getTraceid", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "jacoco-runtime_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: Trace.kt */
public final class Trace {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String spanid;
    private final String traceid;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7428532158836844161L, "com/didi/jacoco/runtime/module/role/Trace", 25);
        $jacocoData = probes;
        return probes;
    }

    public static /* synthetic */ Trace copy$default(Trace trace, String str, String str2, int i, Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        if ((i & 1) == 0) {
            $jacocoInit[7] = true;
        } else {
            str = trace.spanid;
            $jacocoInit[8] = true;
        }
        if ((i & 2) == 0) {
            $jacocoInit[9] = true;
        } else {
            str2 = trace.traceid;
            $jacocoInit[10] = true;
        }
        Trace copy = trace.copy(str, str2);
        $jacocoInit[11] = true;
        return copy;
    }

    public final String component1() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.spanid;
        $jacocoInit[4] = true;
        return str;
    }

    public final String component2() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.traceid;
        $jacocoInit[5] = true;
        return str;
    }

    public final Trace copy(String str, String str2) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(str, PayLogParam.KEY_SPANID);
        Intrinsics.checkParameterIsNotNull(str2, "traceid");
        Trace trace = new Trace(str, str2);
        $jacocoInit[6] = true;
        return trace;
    }

    public boolean equals(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this == obj) {
            $jacocoInit[18] = true;
        } else {
            if (!(obj instanceof Trace)) {
                $jacocoInit[19] = true;
            } else {
                Trace trace = (Trace) obj;
                if (!Intrinsics.areEqual((Object) this.spanid, (Object) trace.spanid)) {
                    $jacocoInit[20] = true;
                } else if (!Intrinsics.areEqual((Object) this.traceid, (Object) trace.traceid)) {
                    $jacocoInit[21] = true;
                } else {
                    $jacocoInit[22] = true;
                }
            }
            $jacocoInit[24] = true;
            return false;
        }
        $jacocoInit[23] = true;
        return true;
    }

    public int hashCode() {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.spanid;
        int i2 = 0;
        if (str != null) {
            i = str.hashCode();
            $jacocoInit[13] = true;
        } else {
            $jacocoInit[14] = true;
            i = 0;
        }
        int i3 = i * 31;
        String str2 = this.traceid;
        if (str2 != null) {
            i2 = str2.hashCode();
            $jacocoInit[15] = true;
        } else {
            $jacocoInit[16] = true;
        }
        int i4 = i3 + i2;
        $jacocoInit[17] = true;
        return i4;
    }

    public String toString() {
        String str = "Trace(spanid=" + this.spanid + ", traceid=" + this.traceid + ")";
        $jacocoInit()[12] = true;
        return str;
    }

    public Trace(String str, String str2) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(str, PayLogParam.KEY_SPANID);
        Intrinsics.checkParameterIsNotNull(str2, "traceid");
        $jacocoInit[2] = true;
        this.spanid = str;
        this.traceid = str2;
        $jacocoInit[3] = true;
    }

    public final String getSpanid() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.spanid;
        $jacocoInit[0] = true;
        return str;
    }

    public final String getTraceid() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.traceid;
        $jacocoInit[1] = true;
        return str;
    }
}
