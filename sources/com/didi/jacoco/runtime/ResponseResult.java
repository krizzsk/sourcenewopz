package com.didi.jacoco.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jacoco.agent.p086rt.internal_8ff85ea.Offline;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/jacoco/runtime/ResponseResult;", "", "errno", "", "errmsg", "", "(ILjava/lang/String;)V", "getErrmsg", "()Ljava/lang/String;", "setErrmsg", "(Ljava/lang/String;)V", "getErrno", "()I", "setErrno", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "jacoco-runtime_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: Entity.kt */
public final class ResponseResult {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String errmsg;
    private int errno;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8287059418073153831L, "com/didi/jacoco/runtime/ResponseResult", 25);
        $jacocoData = probes;
        return probes;
    }

    public static /* synthetic */ ResponseResult copy$default(ResponseResult responseResult, int i, String str, int i2, Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        if ((i2 & 1) == 0) {
            $jacocoInit[9] = true;
        } else {
            i = responseResult.errno;
            $jacocoInit[10] = true;
        }
        if ((i2 & 2) == 0) {
            $jacocoInit[11] = true;
        } else {
            str = responseResult.errmsg;
            $jacocoInit[12] = true;
        }
        ResponseResult copy = responseResult.copy(i, str);
        $jacocoInit[13] = true;
        return copy;
    }

    public final int component1() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.errno;
        $jacocoInit[6] = true;
        return i;
    }

    public final String component2() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.errmsg;
        $jacocoInit[7] = true;
        return str;
    }

    public final ResponseResult copy(int i, String str) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(str, "errmsg");
        ResponseResult responseResult = new ResponseResult(i, str);
        $jacocoInit[8] = true;
        return responseResult;
    }

    public boolean equals(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this == obj) {
            $jacocoInit[18] = true;
        } else {
            if (!(obj instanceof ResponseResult)) {
                $jacocoInit[19] = true;
            } else {
                ResponseResult responseResult = (ResponseResult) obj;
                if (this.errno != responseResult.errno) {
                    $jacocoInit[20] = true;
                } else if (!Intrinsics.areEqual((Object) this.errmsg, (Object) responseResult.errmsg)) {
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
        int i2 = this.errno * 31;
        String str = this.errmsg;
        if (str != null) {
            i = str.hashCode();
            $jacocoInit[15] = true;
        } else {
            i = 0;
            $jacocoInit[16] = true;
        }
        int i3 = i2 + i;
        $jacocoInit[17] = true;
        return i3;
    }

    public String toString() {
        String str = "ResponseResult(errno=" + this.errno + ", errmsg=" + this.errmsg + ")";
        $jacocoInit()[14] = true;
        return str;
    }

    public ResponseResult(int i, String str) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(str, "errmsg");
        $jacocoInit[4] = true;
        this.errno = i;
        this.errmsg = str;
        $jacocoInit[5] = true;
    }

    public final String getErrmsg() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.errmsg;
        $jacocoInit[2] = true;
        return str;
    }

    public final int getErrno() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.errno;
        $jacocoInit[0] = true;
        return i;
    }

    public final void setErrmsg(String str) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.errmsg = str;
        $jacocoInit[3] = true;
    }

    public final void setErrno(int i) {
        boolean[] $jacocoInit = $jacocoInit();
        this.errno = i;
        $jacocoInit[1] = true;
    }
}
