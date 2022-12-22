package global.didi.pay.threeds.network.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bq\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\f¢\u0006\u0002\u0010\u0011J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u00105\u001a\u00020\fHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u0010>\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010?J\u0013\u0010@\u001a\u00020\f2\b\u0010A\u001a\u0004\u0018\u00010BHÖ\u0003J\t\u0010C\u001a\u00020DHÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010\u0015R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0013\"\u0004\b0\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0013\"\u0004\b2\u0010\u0015¨\u0006F"}, mo175978d2 = {"Lglobal/didi/pay/threeds/network/model/ThreedsCybsDataResponse;", "Ljava/io/Serializable;", "status", "", "channelInfo", "Lglobal/didi/pay/threeds/network/model/ThreedsChannelInfo;", "description", "authId", "payload", "urlOf3ds", "version", "liabilityShift", "", "channelNameOf3ds", "resultOf3ds", "Lglobal/didi/pay/threeds/network/model/ThreedsResultOf3ds;", "needCvv", "(Ljava/lang/String;Lglobal/didi/pay/threeds/network/model/ThreedsChannelInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lglobal/didi/pay/threeds/network/model/ThreedsResultOf3ds;Z)V", "getAuthId", "()Ljava/lang/String;", "setAuthId", "(Ljava/lang/String;)V", "getChannelInfo", "()Lglobal/didi/pay/threeds/network/model/ThreedsChannelInfo;", "setChannelInfo", "(Lglobal/didi/pay/threeds/network/model/ThreedsChannelInfo;)V", "getChannelNameOf3ds", "setChannelNameOf3ds", "getDescription", "setDescription", "getLiabilityShift", "()Ljava/lang/Boolean;", "setLiabilityShift", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getNeedCvv", "()Z", "setNeedCvv", "(Z)V", "getPayload", "setPayload", "getResultOf3ds", "()Lglobal/didi/pay/threeds/network/model/ThreedsResultOf3ds;", "setResultOf3ds", "(Lglobal/didi/pay/threeds/network/model/ThreedsResultOf3ds;)V", "getStatus", "setStatus", "getUrlOf3ds", "setUrlOf3ds", "getVersion", "setVersion", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lglobal/didi/pay/threeds/network/model/ThreedsChannelInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lglobal/didi/pay/threeds/network/model/ThreedsResultOf3ds;Z)Lglobal/didi/pay/threeds/network/model/ThreedsCybsDataResponse;", "equals", "other", "", "hashCode", "", "toString", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThreedsResultResponse.kt */
public final class ThreedsCybsDataResponse implements Serializable {
    private String authId;
    private ThreedsChannelInfo channelInfo;
    private String channelNameOf3ds;
    private String description;
    private Boolean liabilityShift;
    private boolean needCvv;
    private String payload;
    private ThreedsResultOf3ds resultOf3ds;
    private String status;
    private String urlOf3ds;
    private String version;

    public static /* synthetic */ ThreedsCybsDataResponse copy$default(ThreedsCybsDataResponse threedsCybsDataResponse, String str, ThreedsChannelInfo threedsChannelInfo, String str2, String str3, String str4, String str5, String str6, Boolean bool, String str7, ThreedsResultOf3ds threedsResultOf3ds, boolean z, int i, Object obj) {
        ThreedsCybsDataResponse threedsCybsDataResponse2 = threedsCybsDataResponse;
        int i2 = i;
        return threedsCybsDataResponse.copy((i2 & 1) != 0 ? threedsCybsDataResponse2.status : str, (i2 & 2) != 0 ? threedsCybsDataResponse2.channelInfo : threedsChannelInfo, (i2 & 4) != 0 ? threedsCybsDataResponse2.description : str2, (i2 & 8) != 0 ? threedsCybsDataResponse2.authId : str3, (i2 & 16) != 0 ? threedsCybsDataResponse2.payload : str4, (i2 & 32) != 0 ? threedsCybsDataResponse2.urlOf3ds : str5, (i2 & 64) != 0 ? threedsCybsDataResponse2.version : str6, (i2 & 128) != 0 ? threedsCybsDataResponse2.liabilityShift : bool, (i2 & 256) != 0 ? threedsCybsDataResponse2.channelNameOf3ds : str7, (i2 & 512) != 0 ? threedsCybsDataResponse2.resultOf3ds : threedsResultOf3ds, (i2 & 1024) != 0 ? threedsCybsDataResponse2.needCvv : z);
    }

    public final String component1() {
        return this.status;
    }

    public final ThreedsResultOf3ds component10() {
        return this.resultOf3ds;
    }

    public final boolean component11() {
        return this.needCvv;
    }

    public final ThreedsChannelInfo component2() {
        return this.channelInfo;
    }

    public final String component3() {
        return this.description;
    }

    public final String component4() {
        return this.authId;
    }

    public final String component5() {
        return this.payload;
    }

    public final String component6() {
        return this.urlOf3ds;
    }

    public final String component7() {
        return this.version;
    }

    public final Boolean component8() {
        return this.liabilityShift;
    }

    public final String component9() {
        return this.channelNameOf3ds;
    }

    public final ThreedsCybsDataResponse copy(String str, ThreedsChannelInfo threedsChannelInfo, String str2, String str3, String str4, String str5, String str6, Boolean bool, String str7, ThreedsResultOf3ds threedsResultOf3ds, boolean z) {
        return new ThreedsCybsDataResponse(str, threedsChannelInfo, str2, str3, str4, str5, str6, bool, str7, threedsResultOf3ds, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThreedsCybsDataResponse)) {
            return false;
        }
        ThreedsCybsDataResponse threedsCybsDataResponse = (ThreedsCybsDataResponse) obj;
        return Intrinsics.areEqual((Object) this.status, (Object) threedsCybsDataResponse.status) && Intrinsics.areEqual((Object) this.channelInfo, (Object) threedsCybsDataResponse.channelInfo) && Intrinsics.areEqual((Object) this.description, (Object) threedsCybsDataResponse.description) && Intrinsics.areEqual((Object) this.authId, (Object) threedsCybsDataResponse.authId) && Intrinsics.areEqual((Object) this.payload, (Object) threedsCybsDataResponse.payload) && Intrinsics.areEqual((Object) this.urlOf3ds, (Object) threedsCybsDataResponse.urlOf3ds) && Intrinsics.areEqual((Object) this.version, (Object) threedsCybsDataResponse.version) && Intrinsics.areEqual((Object) this.liabilityShift, (Object) threedsCybsDataResponse.liabilityShift) && Intrinsics.areEqual((Object) this.channelNameOf3ds, (Object) threedsCybsDataResponse.channelNameOf3ds) && Intrinsics.areEqual((Object) this.resultOf3ds, (Object) threedsCybsDataResponse.resultOf3ds) && this.needCvv == threedsCybsDataResponse.needCvv;
    }

    public int hashCode() {
        String str = this.status;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ThreedsChannelInfo threedsChannelInfo = this.channelInfo;
        int hashCode2 = (hashCode + (threedsChannelInfo == null ? 0 : threedsChannelInfo.hashCode())) * 31;
        String str2 = this.description;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.authId;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.payload;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.urlOf3ds;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.version;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Boolean bool = this.liabilityShift;
        int hashCode8 = (hashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str7 = this.channelNameOf3ds;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        ThreedsResultOf3ds threedsResultOf3ds = this.resultOf3ds;
        if (threedsResultOf3ds != null) {
            i = threedsResultOf3ds.hashCode();
        }
        int i2 = (hashCode9 + i) * 31;
        boolean z = this.needCvv;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        return "ThreedsCybsDataResponse(status=" + this.status + ", channelInfo=" + this.channelInfo + ", description=" + this.description + ", authId=" + this.authId + ", payload=" + this.payload + ", urlOf3ds=" + this.urlOf3ds + ", version=" + this.version + ", liabilityShift=" + this.liabilityShift + ", channelNameOf3ds=" + this.channelNameOf3ds + ", resultOf3ds=" + this.resultOf3ds + ", needCvv=" + this.needCvv + VersionRange.RIGHT_OPEN;
    }

    public ThreedsCybsDataResponse(String str, ThreedsChannelInfo threedsChannelInfo, String str2, String str3, String str4, String str5, String str6, Boolean bool, String str7, ThreedsResultOf3ds threedsResultOf3ds, boolean z) {
        this.status = str;
        this.channelInfo = threedsChannelInfo;
        this.description = str2;
        this.authId = str3;
        this.payload = str4;
        this.urlOf3ds = str5;
        this.version = str6;
        this.liabilityShift = bool;
        this.channelNameOf3ds = str7;
        this.resultOf3ds = threedsResultOf3ds;
        this.needCvv = z;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final ThreedsChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    public final void setChannelInfo(ThreedsChannelInfo threedsChannelInfo) {
        this.channelInfo = threedsChannelInfo;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final String getAuthId() {
        return this.authId;
    }

    public final void setAuthId(String str) {
        this.authId = str;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final void setPayload(String str) {
        this.payload = str;
    }

    public final String getUrlOf3ds() {
        return this.urlOf3ds;
    }

    public final void setUrlOf3ds(String str) {
        this.urlOf3ds = str;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final Boolean getLiabilityShift() {
        return this.liabilityShift;
    }

    public final void setLiabilityShift(Boolean bool) {
        this.liabilityShift = bool;
    }

    public final String getChannelNameOf3ds() {
        return this.channelNameOf3ds;
    }

    public final void setChannelNameOf3ds(String str) {
        this.channelNameOf3ds = str;
    }

    public final ThreedsResultOf3ds getResultOf3ds() {
        return this.resultOf3ds;
    }

    public final void setResultOf3ds(ThreedsResultOf3ds threedsResultOf3ds) {
        this.resultOf3ds = threedsResultOf3ds;
    }

    public final boolean getNeedCvv() {
        return this.needCvv;
    }

    public final void setNeedCvv(boolean z) {
        this.needCvv = z;
    }
}
