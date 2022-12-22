package global.didi.pay.threeds.network.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, mo175978d2 = {"Lglobal/didi/pay/threeds/network/model/ThreedsCybsResponse;", "Ljava/io/Serializable;", "errNo", "", "errMsg", "", "data", "Lglobal/didi/pay/threeds/network/model/ThreedsCybsResultResponse;", "(Ljava/lang/Integer;Ljava/lang/String;Lglobal/didi/pay/threeds/network/model/ThreedsCybsResultResponse;)V", "getData", "()Lglobal/didi/pay/threeds/network/model/ThreedsCybsResultResponse;", "setData", "(Lglobal/didi/pay/threeds/network/model/ThreedsCybsResultResponse;)V", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "getErrNo", "()Ljava/lang/Integer;", "setErrNo", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lglobal/didi/pay/threeds/network/model/ThreedsCybsResultResponse;)Lglobal/didi/pay/threeds/network/model/ThreedsCybsResponse;", "equals", "", "other", "", "hashCode", "toString", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThreedsResultResponse.kt */
public final class ThreedsCybsResponse implements Serializable {
    private ThreedsCybsResultResponse data;
    private String errMsg;
    private Integer errNo;

    public static /* synthetic */ ThreedsCybsResponse copy$default(ThreedsCybsResponse threedsCybsResponse, Integer num, String str, ThreedsCybsResultResponse threedsCybsResultResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            num = threedsCybsResponse.errNo;
        }
        if ((i & 2) != 0) {
            str = threedsCybsResponse.errMsg;
        }
        if ((i & 4) != 0) {
            threedsCybsResultResponse = threedsCybsResponse.data;
        }
        return threedsCybsResponse.copy(num, str, threedsCybsResultResponse);
    }

    public final Integer component1() {
        return this.errNo;
    }

    public final String component2() {
        return this.errMsg;
    }

    public final ThreedsCybsResultResponse component3() {
        return this.data;
    }

    public final ThreedsCybsResponse copy(Integer num, String str, ThreedsCybsResultResponse threedsCybsResultResponse) {
        return new ThreedsCybsResponse(num, str, threedsCybsResultResponse);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThreedsCybsResponse)) {
            return false;
        }
        ThreedsCybsResponse threedsCybsResponse = (ThreedsCybsResponse) obj;
        return Intrinsics.areEqual((Object) this.errNo, (Object) threedsCybsResponse.errNo) && Intrinsics.areEqual((Object) this.errMsg, (Object) threedsCybsResponse.errMsg) && Intrinsics.areEqual((Object) this.data, (Object) threedsCybsResponse.data);
    }

    public int hashCode() {
        Integer num = this.errNo;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.errMsg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        ThreedsCybsResultResponse threedsCybsResultResponse = this.data;
        if (threedsCybsResultResponse != null) {
            i = threedsCybsResultResponse.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ThreedsCybsResponse(errNo=" + this.errNo + ", errMsg=" + this.errMsg + ", data=" + this.data + VersionRange.RIGHT_OPEN;
    }

    public ThreedsCybsResponse(Integer num, String str, ThreedsCybsResultResponse threedsCybsResultResponse) {
        this.errNo = num;
        this.errMsg = str;
        this.data = threedsCybsResultResponse;
    }

    public final Integer getErrNo() {
        return this.errNo;
    }

    public final void setErrNo(Integer num) {
        this.errNo = num;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public final void setErrMsg(String str) {
        this.errMsg = str;
    }

    public final ThreedsCybsResultResponse getData() {
        return this.data;
    }

    public final void setData(ThreedsCybsResultResponse threedsCybsResultResponse) {
        this.data = threedsCybsResultResponse;
    }
}
