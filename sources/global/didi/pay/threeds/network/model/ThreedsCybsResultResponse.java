package global.didi.pay.threeds.network.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, mo175978d2 = {"Lglobal/didi/pay/threeds/network/model/ThreedsCybsResultResponse;", "Ljava/io/Serializable;", "result3Ds", "Lglobal/didi/pay/threeds/network/model/ThreedsCybsInnerResponse;", "(Lglobal/didi/pay/threeds/network/model/ThreedsCybsInnerResponse;)V", "getResult3Ds", "()Lglobal/didi/pay/threeds/network/model/ThreedsCybsInnerResponse;", "setResult3Ds", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThreedsResultResponse.kt */
public final class ThreedsCybsResultResponse implements Serializable {
    private ThreedsCybsInnerResponse result3Ds;

    public static /* synthetic */ ThreedsCybsResultResponse copy$default(ThreedsCybsResultResponse threedsCybsResultResponse, ThreedsCybsInnerResponse threedsCybsInnerResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            threedsCybsInnerResponse = threedsCybsResultResponse.result3Ds;
        }
        return threedsCybsResultResponse.copy(threedsCybsInnerResponse);
    }

    public final ThreedsCybsInnerResponse component1() {
        return this.result3Ds;
    }

    public final ThreedsCybsResultResponse copy(ThreedsCybsInnerResponse threedsCybsInnerResponse) {
        return new ThreedsCybsResultResponse(threedsCybsInnerResponse);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ThreedsCybsResultResponse) && Intrinsics.areEqual((Object) this.result3Ds, (Object) ((ThreedsCybsResultResponse) obj).result3Ds);
    }

    public int hashCode() {
        ThreedsCybsInnerResponse threedsCybsInnerResponse = this.result3Ds;
        if (threedsCybsInnerResponse == null) {
            return 0;
        }
        return threedsCybsInnerResponse.hashCode();
    }

    public String toString() {
        return "ThreedsCybsResultResponse(result3Ds=" + this.result3Ds + VersionRange.RIGHT_OPEN;
    }

    public ThreedsCybsResultResponse(ThreedsCybsInnerResponse threedsCybsInnerResponse) {
        this.result3Ds = threedsCybsInnerResponse;
    }

    public final ThreedsCybsInnerResponse getResult3Ds() {
        return this.result3Ds;
    }

    public final void setResult3Ds(ThreedsCybsInnerResponse threedsCybsInnerResponse) {
        this.result3Ds = threedsCybsInnerResponse;
    }
}
