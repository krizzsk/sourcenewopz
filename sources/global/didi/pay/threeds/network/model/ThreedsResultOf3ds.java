package global.didi.pay.threeds.network.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\""}, mo175978d2 = {"Lglobal/didi/pay/threeds/network/model/ThreedsResultOf3ds;", "Ljava/io/Serializable;", "cavv", "", "eci", "xid", "transactionId", "authenResponse", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthenResponse", "()Ljava/lang/String;", "setAuthenResponse", "(Ljava/lang/String;)V", "getCavv", "setCavv", "getEci", "setEci", "getTransactionId", "setTransactionId", "getXid", "setXid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThreedsResultResponse.kt */
public final class ThreedsResultOf3ds implements Serializable {
    private String authenResponse;
    private String cavv;
    private String eci;
    private String transactionId;
    private String xid;

    public static /* synthetic */ ThreedsResultOf3ds copy$default(ThreedsResultOf3ds threedsResultOf3ds, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = threedsResultOf3ds.cavv;
        }
        if ((i & 2) != 0) {
            str2 = threedsResultOf3ds.eci;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = threedsResultOf3ds.xid;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = threedsResultOf3ds.transactionId;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = threedsResultOf3ds.authenResponse;
        }
        return threedsResultOf3ds.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.cavv;
    }

    public final String component2() {
        return this.eci;
    }

    public final String component3() {
        return this.xid;
    }

    public final String component4() {
        return this.transactionId;
    }

    public final String component5() {
        return this.authenResponse;
    }

    public final ThreedsResultOf3ds copy(String str, String str2, String str3, String str4, String str5) {
        return new ThreedsResultOf3ds(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThreedsResultOf3ds)) {
            return false;
        }
        ThreedsResultOf3ds threedsResultOf3ds = (ThreedsResultOf3ds) obj;
        return Intrinsics.areEqual((Object) this.cavv, (Object) threedsResultOf3ds.cavv) && Intrinsics.areEqual((Object) this.eci, (Object) threedsResultOf3ds.eci) && Intrinsics.areEqual((Object) this.xid, (Object) threedsResultOf3ds.xid) && Intrinsics.areEqual((Object) this.transactionId, (Object) threedsResultOf3ds.transactionId) && Intrinsics.areEqual((Object) this.authenResponse, (Object) threedsResultOf3ds.authenResponse);
    }

    public int hashCode() {
        String str = this.cavv;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.eci;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.xid;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.transactionId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.authenResponse;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "ThreedsResultOf3ds(cavv=" + this.cavv + ", eci=" + this.eci + ", xid=" + this.xid + ", transactionId=" + this.transactionId + ", authenResponse=" + this.authenResponse + VersionRange.RIGHT_OPEN;
    }

    public ThreedsResultOf3ds(String str, String str2, String str3, String str4, String str5) {
        this.cavv = str;
        this.eci = str2;
        this.xid = str3;
        this.transactionId = str4;
        this.authenResponse = str5;
    }

    public final String getCavv() {
        return this.cavv;
    }

    public final void setCavv(String str) {
        this.cavv = str;
    }

    public final String getEci() {
        return this.eci;
    }

    public final void setEci(String str) {
        this.eci = str;
    }

    public final String getXid() {
        return this.xid;
    }

    public final void setXid(String str) {
        this.xid = str;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public final void setTransactionId(String str) {
        this.transactionId = str;
    }

    public final String getAuthenResponse() {
        return this.authenResponse;
    }

    public final void setAuthenResponse(String str) {
        this.authenResponse = str;
    }
}
