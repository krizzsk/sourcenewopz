package com.didi.component.driverbar.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/component/driverbar/model/DriverPersonalInfo;", "", "name", "Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "avatar", "", "score", "orderCount", "(Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;Ljava/lang/String;Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;)V", "getAvatar", "()Ljava/lang/String;", "getName", "()Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "getOrderCount", "getScore", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "comp-driverbar_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DriverBarInfoData.kt */
public final class DriverPersonalInfo {
    private final String avatar;
    private final LEGORichInfo name;
    @SerializedName("order_count")
    private final LEGORichInfo orderCount;
    private final LEGORichInfo score;

    public static /* synthetic */ DriverPersonalInfo copy$default(DriverPersonalInfo driverPersonalInfo, LEGORichInfo lEGORichInfo, String str, LEGORichInfo lEGORichInfo2, LEGORichInfo lEGORichInfo3, int i, Object obj) {
        if ((i & 1) != 0) {
            lEGORichInfo = driverPersonalInfo.name;
        }
        if ((i & 2) != 0) {
            str = driverPersonalInfo.avatar;
        }
        if ((i & 4) != 0) {
            lEGORichInfo2 = driverPersonalInfo.score;
        }
        if ((i & 8) != 0) {
            lEGORichInfo3 = driverPersonalInfo.orderCount;
        }
        return driverPersonalInfo.copy(lEGORichInfo, str, lEGORichInfo2, lEGORichInfo3);
    }

    public final LEGORichInfo component1() {
        return this.name;
    }

    public final String component2() {
        return this.avatar;
    }

    public final LEGORichInfo component3() {
        return this.score;
    }

    public final LEGORichInfo component4() {
        return this.orderCount;
    }

    public final DriverPersonalInfo copy(LEGORichInfo lEGORichInfo, String str, LEGORichInfo lEGORichInfo2, LEGORichInfo lEGORichInfo3) {
        return new DriverPersonalInfo(lEGORichInfo, str, lEGORichInfo2, lEGORichInfo3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DriverPersonalInfo)) {
            return false;
        }
        DriverPersonalInfo driverPersonalInfo = (DriverPersonalInfo) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) driverPersonalInfo.name) && Intrinsics.areEqual((Object) this.avatar, (Object) driverPersonalInfo.avatar) && Intrinsics.areEqual((Object) this.score, (Object) driverPersonalInfo.score) && Intrinsics.areEqual((Object) this.orderCount, (Object) driverPersonalInfo.orderCount);
    }

    public int hashCode() {
        LEGORichInfo lEGORichInfo = this.name;
        int i = 0;
        int hashCode = (lEGORichInfo == null ? 0 : lEGORichInfo.hashCode()) * 31;
        String str = this.avatar;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        LEGORichInfo lEGORichInfo2 = this.score;
        int hashCode3 = (hashCode2 + (lEGORichInfo2 == null ? 0 : lEGORichInfo2.hashCode())) * 31;
        LEGORichInfo lEGORichInfo3 = this.orderCount;
        if (lEGORichInfo3 != null) {
            i = lEGORichInfo3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "DriverPersonalInfo(name=" + this.name + ", avatar=" + this.avatar + ", score=" + this.score + ", orderCount=" + this.orderCount + VersionRange.RIGHT_OPEN;
    }

    public DriverPersonalInfo(LEGORichInfo lEGORichInfo, String str, LEGORichInfo lEGORichInfo2, LEGORichInfo lEGORichInfo3) {
        this.name = lEGORichInfo;
        this.avatar = str;
        this.score = lEGORichInfo2;
        this.orderCount = lEGORichInfo3;
    }

    public final LEGORichInfo getName() {
        return this.name;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final LEGORichInfo getScore() {
        return this.score;
    }

    public final LEGORichInfo getOrderCount() {
        return this.orderCount;
    }
}
