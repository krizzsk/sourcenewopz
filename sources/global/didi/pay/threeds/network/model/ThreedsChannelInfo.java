package global.didi.pay.threeds.network.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, mo175978d2 = {"Lglobal/didi/pay/threeds/network/model/ThreedsChannelInfo;", "Ljava/io/Serializable;", "jwt", "", "refId", "(Ljava/lang/String;Ljava/lang/String;)V", "getJwt", "()Ljava/lang/String;", "setJwt", "(Ljava/lang/String;)V", "getRefId", "setRefId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThreedsResultResponse.kt */
public final class ThreedsChannelInfo implements Serializable {
    private String jwt;
    private String refId;

    public static /* synthetic */ ThreedsChannelInfo copy$default(ThreedsChannelInfo threedsChannelInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = threedsChannelInfo.jwt;
        }
        if ((i & 2) != 0) {
            str2 = threedsChannelInfo.refId;
        }
        return threedsChannelInfo.copy(str, str2);
    }

    public final String component1() {
        return this.jwt;
    }

    public final String component2() {
        return this.refId;
    }

    public final ThreedsChannelInfo copy(String str, String str2) {
        return new ThreedsChannelInfo(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThreedsChannelInfo)) {
            return false;
        }
        ThreedsChannelInfo threedsChannelInfo = (ThreedsChannelInfo) obj;
        return Intrinsics.areEqual((Object) this.jwt, (Object) threedsChannelInfo.jwt) && Intrinsics.areEqual((Object) this.refId, (Object) threedsChannelInfo.refId);
    }

    public int hashCode() {
        String str = this.jwt;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.refId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ThreedsChannelInfo(jwt=" + this.jwt + ", refId=" + this.refId + VersionRange.RIGHT_OPEN;
    }

    public ThreedsChannelInfo(String str, String str2) {
        this.jwt = str;
        this.refId = str2;
    }

    public final String getJwt() {
        return this.jwt;
    }

    public final void setJwt(String str) {
        this.jwt = str;
    }

    public final String getRefId() {
        return this.refId;
    }

    public final void setRefId(String str) {
        this.refId = str;
    }
}
