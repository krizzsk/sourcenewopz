package com.didi.component.driverbar.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/component/driverbar/model/DriverBarBenefitInfo;", "", "iconUrl", "", "info", "Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "linkUrl", "colorStart", "colorEnd", "(Ljava/lang/String;Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getColorEnd", "()Ljava/lang/String;", "getColorStart", "getIconUrl", "getInfo", "()Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "getLinkUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "comp-driverbar_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DriverBarInfoData.kt */
public final class DriverBarBenefitInfo {
    @SerializedName("color_end")
    private final String colorEnd;
    @SerializedName("color_start")
    private final String colorStart;
    @SerializedName("icon")
    private final String iconUrl;
    private final LEGORichInfo info;
    @SerializedName("link")
    private final String linkUrl;

    public static /* synthetic */ DriverBarBenefitInfo copy$default(DriverBarBenefitInfo driverBarBenefitInfo, String str, LEGORichInfo lEGORichInfo, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = driverBarBenefitInfo.iconUrl;
        }
        if ((i & 2) != 0) {
            lEGORichInfo = driverBarBenefitInfo.info;
        }
        LEGORichInfo lEGORichInfo2 = lEGORichInfo;
        if ((i & 4) != 0) {
            str2 = driverBarBenefitInfo.linkUrl;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = driverBarBenefitInfo.colorStart;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = driverBarBenefitInfo.colorEnd;
        }
        return driverBarBenefitInfo.copy(str, lEGORichInfo2, str5, str6, str4);
    }

    public final String component1() {
        return this.iconUrl;
    }

    public final LEGORichInfo component2() {
        return this.info;
    }

    public final String component3() {
        return this.linkUrl;
    }

    public final String component4() {
        return this.colorStart;
    }

    public final String component5() {
        return this.colorEnd;
    }

    public final DriverBarBenefitInfo copy(String str, LEGORichInfo lEGORichInfo, String str2, String str3, String str4) {
        return new DriverBarBenefitInfo(str, lEGORichInfo, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DriverBarBenefitInfo)) {
            return false;
        }
        DriverBarBenefitInfo driverBarBenefitInfo = (DriverBarBenefitInfo) obj;
        return Intrinsics.areEqual((Object) this.iconUrl, (Object) driverBarBenefitInfo.iconUrl) && Intrinsics.areEqual((Object) this.info, (Object) driverBarBenefitInfo.info) && Intrinsics.areEqual((Object) this.linkUrl, (Object) driverBarBenefitInfo.linkUrl) && Intrinsics.areEqual((Object) this.colorStart, (Object) driverBarBenefitInfo.colorStart) && Intrinsics.areEqual((Object) this.colorEnd, (Object) driverBarBenefitInfo.colorEnd);
    }

    public int hashCode() {
        String str = this.iconUrl;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        LEGORichInfo lEGORichInfo = this.info;
        int hashCode2 = (hashCode + (lEGORichInfo == null ? 0 : lEGORichInfo.hashCode())) * 31;
        String str2 = this.linkUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.colorStart;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.colorEnd;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "DriverBarBenefitInfo(iconUrl=" + this.iconUrl + ", info=" + this.info + ", linkUrl=" + this.linkUrl + ", colorStart=" + this.colorStart + ", colorEnd=" + this.colorEnd + VersionRange.RIGHT_OPEN;
    }

    public DriverBarBenefitInfo(String str, LEGORichInfo lEGORichInfo, String str2, String str3, String str4) {
        this.iconUrl = str;
        this.info = lEGORichInfo;
        this.linkUrl = str2;
        this.colorStart = str3;
        this.colorEnd = str4;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final LEGORichInfo getInfo() {
        return this.info;
    }

    public final String getLinkUrl() {
        return this.linkUrl;
    }

    public final String getColorStart() {
        return this.colorStart;
    }

    public final String getColorEnd() {
        return this.colorEnd;
    }
}
