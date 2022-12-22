package com.didi.component.driverbar.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/component/driverbar/model/DriverCarInfo2;", "", "icon", "", "licenseNum", "Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "licenseNumExt", "carTypeInfo", "carColorInfo", "(Ljava/lang/String;Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;)V", "getCarColorInfo", "()Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "getCarTypeInfo", "getIcon", "()Ljava/lang/String;", "getLicenseNum", "getLicenseNumExt", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "comp-driverbar_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DriverBarInfoData.kt */
public final class DriverCarInfo2 {
    @SerializedName("car_type_info_color")
    private final LEGORichInfo carColorInfo;
    @SerializedName("car_type_info_name")
    private final LEGORichInfo carTypeInfo;
    private final String icon;
    @SerializedName("license_num")
    private final LEGORichInfo licenseNum;
    @SerializedName("license_num_ext")
    private final LEGORichInfo licenseNumExt;

    public static /* synthetic */ DriverCarInfo2 copy$default(DriverCarInfo2 driverCarInfo2, String str, LEGORichInfo lEGORichInfo, LEGORichInfo lEGORichInfo2, LEGORichInfo lEGORichInfo3, LEGORichInfo lEGORichInfo4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = driverCarInfo2.icon;
        }
        if ((i & 2) != 0) {
            lEGORichInfo = driverCarInfo2.licenseNum;
        }
        LEGORichInfo lEGORichInfo5 = lEGORichInfo;
        if ((i & 4) != 0) {
            lEGORichInfo2 = driverCarInfo2.licenseNumExt;
        }
        LEGORichInfo lEGORichInfo6 = lEGORichInfo2;
        if ((i & 8) != 0) {
            lEGORichInfo3 = driverCarInfo2.carTypeInfo;
        }
        LEGORichInfo lEGORichInfo7 = lEGORichInfo3;
        if ((i & 16) != 0) {
            lEGORichInfo4 = driverCarInfo2.carColorInfo;
        }
        return driverCarInfo2.copy(str, lEGORichInfo5, lEGORichInfo6, lEGORichInfo7, lEGORichInfo4);
    }

    public final String component1() {
        return this.icon;
    }

    public final LEGORichInfo component2() {
        return this.licenseNum;
    }

    public final LEGORichInfo component3() {
        return this.licenseNumExt;
    }

    public final LEGORichInfo component4() {
        return this.carTypeInfo;
    }

    public final LEGORichInfo component5() {
        return this.carColorInfo;
    }

    public final DriverCarInfo2 copy(String str, LEGORichInfo lEGORichInfo, LEGORichInfo lEGORichInfo2, LEGORichInfo lEGORichInfo3, LEGORichInfo lEGORichInfo4) {
        return new DriverCarInfo2(str, lEGORichInfo, lEGORichInfo2, lEGORichInfo3, lEGORichInfo4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DriverCarInfo2)) {
            return false;
        }
        DriverCarInfo2 driverCarInfo2 = (DriverCarInfo2) obj;
        return Intrinsics.areEqual((Object) this.icon, (Object) driverCarInfo2.icon) && Intrinsics.areEqual((Object) this.licenseNum, (Object) driverCarInfo2.licenseNum) && Intrinsics.areEqual((Object) this.licenseNumExt, (Object) driverCarInfo2.licenseNumExt) && Intrinsics.areEqual((Object) this.carTypeInfo, (Object) driverCarInfo2.carTypeInfo) && Intrinsics.areEqual((Object) this.carColorInfo, (Object) driverCarInfo2.carColorInfo);
    }

    public int hashCode() {
        String str = this.icon;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        LEGORichInfo lEGORichInfo = this.licenseNum;
        int hashCode2 = (hashCode + (lEGORichInfo == null ? 0 : lEGORichInfo.hashCode())) * 31;
        LEGORichInfo lEGORichInfo2 = this.licenseNumExt;
        int hashCode3 = (hashCode2 + (lEGORichInfo2 == null ? 0 : lEGORichInfo2.hashCode())) * 31;
        LEGORichInfo lEGORichInfo3 = this.carTypeInfo;
        int hashCode4 = (hashCode3 + (lEGORichInfo3 == null ? 0 : lEGORichInfo3.hashCode())) * 31;
        LEGORichInfo lEGORichInfo4 = this.carColorInfo;
        if (lEGORichInfo4 != null) {
            i = lEGORichInfo4.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "DriverCarInfo2(icon=" + this.icon + ", licenseNum=" + this.licenseNum + ", licenseNumExt=" + this.licenseNumExt + ", carTypeInfo=" + this.carTypeInfo + ", carColorInfo=" + this.carColorInfo + VersionRange.RIGHT_OPEN;
    }

    public DriverCarInfo2(String str, LEGORichInfo lEGORichInfo, LEGORichInfo lEGORichInfo2, LEGORichInfo lEGORichInfo3, LEGORichInfo lEGORichInfo4) {
        this.icon = str;
        this.licenseNum = lEGORichInfo;
        this.licenseNumExt = lEGORichInfo2;
        this.carTypeInfo = lEGORichInfo3;
        this.carColorInfo = lEGORichInfo4;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final LEGORichInfo getLicenseNum() {
        return this.licenseNum;
    }

    public final LEGORichInfo getLicenseNumExt() {
        return this.licenseNumExt;
    }

    public final LEGORichInfo getCarTypeInfo() {
        return this.carTypeInfo;
    }

    public final LEGORichInfo getCarColorInfo() {
        return this.carColorInfo;
    }
}
