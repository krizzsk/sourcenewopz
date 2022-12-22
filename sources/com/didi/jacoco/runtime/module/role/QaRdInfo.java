package com.didi.jacoco.runtime.module.role;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jacoco.agent.p086rt.internal_8ff85ea.Offline;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/jacoco/runtime/module/role/QaRdInfo;", "", "data", "", "Lcom/didi/jacoco/runtime/module/role/Data;", "errmsg", "", "errno", "", "trace", "Lcom/didi/jacoco/runtime/module/role/Trace;", "(Ljava/util/List;Ljava/lang/String;ILcom/didi/jacoco/runtime/module/role/Trace;)V", "getData", "()Ljava/util/List;", "getErrmsg", "()Ljava/lang/String;", "getErrno", "()I", "getTrace", "()Lcom/didi/jacoco/runtime/module/role/Trace;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "jacoco-runtime_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: QaRdInfo.kt */
public final class QaRdInfo {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final List<Data> data;
    private final String errmsg;
    private final int errno;
    private final Trace trace;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8976232145828750192L, "com/didi/jacoco/runtime/module/role/QaRdInfo", 37);
        $jacocoData = probes;
        return probes;
    }

    public static /* synthetic */ QaRdInfo copy$default(QaRdInfo qaRdInfo, List<Data> list, String str, int i, Trace trace2, int i2, Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        if ((i2 & 1) == 0) {
            $jacocoInit[11] = true;
        } else {
            list = qaRdInfo.data;
            $jacocoInit[12] = true;
        }
        if ((i2 & 2) == 0) {
            $jacocoInit[13] = true;
        } else {
            str = qaRdInfo.errmsg;
            $jacocoInit[14] = true;
        }
        if ((i2 & 4) == 0) {
            $jacocoInit[15] = true;
        } else {
            i = qaRdInfo.errno;
            $jacocoInit[16] = true;
        }
        if ((i2 & 8) == 0) {
            $jacocoInit[17] = true;
        } else {
            trace2 = qaRdInfo.trace;
            $jacocoInit[18] = true;
        }
        QaRdInfo copy = qaRdInfo.copy(list, str, i, trace2);
        $jacocoInit[19] = true;
        return copy;
    }

    public final List<Data> component1() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Data> list = this.data;
        $jacocoInit[6] = true;
        return list;
    }

    public final String component2() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.errmsg;
        $jacocoInit[7] = true;
        return str;
    }

    public final int component3() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.errno;
        $jacocoInit[8] = true;
        return i;
    }

    public final Trace component4() {
        boolean[] $jacocoInit = $jacocoInit();
        Trace trace2 = this.trace;
        $jacocoInit[9] = true;
        return trace2;
    }

    public final QaRdInfo copy(List<Data> list, String str, int i, Trace trace2) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(list, "data");
        Intrinsics.checkParameterIsNotNull(str, "errmsg");
        Intrinsics.checkParameterIsNotNull(trace2, "trace");
        QaRdInfo qaRdInfo = new QaRdInfo(list, str, i, trace2);
        $jacocoInit[10] = true;
        return qaRdInfo;
    }

    public boolean equals(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this == obj) {
            $jacocoInit[28] = true;
        } else {
            if (!(obj instanceof QaRdInfo)) {
                $jacocoInit[29] = true;
            } else {
                QaRdInfo qaRdInfo = (QaRdInfo) obj;
                if (!Intrinsics.areEqual((Object) this.data, (Object) qaRdInfo.data)) {
                    $jacocoInit[30] = true;
                } else if (!Intrinsics.areEqual((Object) this.errmsg, (Object) qaRdInfo.errmsg)) {
                    $jacocoInit[31] = true;
                } else if (this.errno != qaRdInfo.errno) {
                    $jacocoInit[32] = true;
                } else if (!Intrinsics.areEqual((Object) this.trace, (Object) qaRdInfo.trace)) {
                    $jacocoInit[33] = true;
                } else {
                    $jacocoInit[34] = true;
                }
            }
            $jacocoInit[36] = true;
            return false;
        }
        $jacocoInit[35] = true;
        return true;
    }

    public int hashCode() {
        int i;
        int i2;
        boolean[] $jacocoInit = $jacocoInit();
        List<Data> list = this.data;
        int i3 = 0;
        if (list != null) {
            i = list.hashCode();
            $jacocoInit[21] = true;
        } else {
            $jacocoInit[22] = true;
            i = 0;
        }
        int i4 = i * 31;
        String str = this.errmsg;
        if (str != null) {
            i2 = str.hashCode();
            $jacocoInit[23] = true;
        } else {
            $jacocoInit[24] = true;
            i2 = 0;
        }
        int i5 = (((i4 + i2) * 31) + this.errno) * 31;
        Trace trace2 = this.trace;
        if (trace2 != null) {
            i3 = trace2.hashCode();
            $jacocoInit[25] = true;
        } else {
            $jacocoInit[26] = true;
        }
        int i6 = i5 + i3;
        $jacocoInit[27] = true;
        return i6;
    }

    public String toString() {
        String str = "QaRdInfo(data=" + this.data + ", errmsg=" + this.errmsg + ", errno=" + this.errno + ", trace=" + this.trace + ")";
        $jacocoInit()[20] = true;
        return str;
    }

    public QaRdInfo(List<Data> list, String str, int i, Trace trace2) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(list, "data");
        Intrinsics.checkParameterIsNotNull(str, "errmsg");
        Intrinsics.checkParameterIsNotNull(trace2, "trace");
        $jacocoInit[4] = true;
        this.data = list;
        this.errmsg = str;
        this.errno = i;
        this.trace = trace2;
        $jacocoInit[5] = true;
    }

    public final List<Data> getData() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Data> list = this.data;
        $jacocoInit[0] = true;
        return list;
    }

    public final String getErrmsg() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.errmsg;
        $jacocoInit[1] = true;
        return str;
    }

    public final int getErrno() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.errno;
        $jacocoInit[2] = true;
        return i;
    }

    public final Trace getTrace() {
        boolean[] $jacocoInit = $jacocoInit();
        Trace trace2 = this.trace;
        $jacocoInit[3] = true;
        return trace2;
    }
}
