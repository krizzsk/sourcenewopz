package com.didi.component.driverbar.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/component/driverbar/model/DriverBarFieldInfo;", "", "carInfo", "Lcom/didi/component/driverbar/model/DriverCarInfo2;", "driverInfo", "Lcom/didi/component/driverbar/model/DriverPersonalInfo;", "(Lcom/didi/component/driverbar/model/DriverCarInfo2;Lcom/didi/component/driverbar/model/DriverPersonalInfo;)V", "getCarInfo", "()Lcom/didi/component/driverbar/model/DriverCarInfo2;", "getDriverInfo", "()Lcom/didi/component/driverbar/model/DriverPersonalInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "comp-driverbar_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DriverBarInfoData.kt */
public final class DriverBarFieldInfo {
    @SerializedName("car_info")
    private final DriverCarInfo2 carInfo;
    @SerializedName("driver_info")
    private final DriverPersonalInfo driverInfo;

    public static /* synthetic */ DriverBarFieldInfo copy$default(DriverBarFieldInfo driverBarFieldInfo, DriverCarInfo2 driverCarInfo2, DriverPersonalInfo driverPersonalInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            driverCarInfo2 = driverBarFieldInfo.carInfo;
        }
        if ((i & 2) != 0) {
            driverPersonalInfo = driverBarFieldInfo.driverInfo;
        }
        return driverBarFieldInfo.copy(driverCarInfo2, driverPersonalInfo);
    }

    public final DriverCarInfo2 component1() {
        return this.carInfo;
    }

    public final DriverPersonalInfo component2() {
        return this.driverInfo;
    }

    public final DriverBarFieldInfo copy(DriverCarInfo2 driverCarInfo2, DriverPersonalInfo driverPersonalInfo) {
        return new DriverBarFieldInfo(driverCarInfo2, driverPersonalInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DriverBarFieldInfo)) {
            return false;
        }
        DriverBarFieldInfo driverBarFieldInfo = (DriverBarFieldInfo) obj;
        return Intrinsics.areEqual((Object) this.carInfo, (Object) driverBarFieldInfo.carInfo) && Intrinsics.areEqual((Object) this.driverInfo, (Object) driverBarFieldInfo.driverInfo);
    }

    public int hashCode() {
        DriverCarInfo2 driverCarInfo2 = this.carInfo;
        int i = 0;
        int hashCode = (driverCarInfo2 == null ? 0 : driverCarInfo2.hashCode()) * 31;
        DriverPersonalInfo driverPersonalInfo = this.driverInfo;
        if (driverPersonalInfo != null) {
            i = driverPersonalInfo.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "DriverBarFieldInfo(carInfo=" + this.carInfo + ", driverInfo=" + this.driverInfo + VersionRange.RIGHT_OPEN;
    }

    public DriverBarFieldInfo(DriverCarInfo2 driverCarInfo2, DriverPersonalInfo driverPersonalInfo) {
        this.carInfo = driverCarInfo2;
        this.driverInfo = driverPersonalInfo;
    }

    public final DriverCarInfo2 getCarInfo() {
        return this.carInfo;
    }

    public final DriverPersonalInfo getDriverInfo() {
        return this.driverInfo;
    }
}
