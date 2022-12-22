package com.didi.jacoco.p120ec;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\u000e\u0010\"\u001a\n #*\u0004\u0018\u00010\u00030\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006%"}, mo175978d2 = {"Lcom/didi/jacoco/ec/DeviceInfo;", "", "brand", "", "model", "device", "sdkInt", "", "osVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getBrand", "()Ljava/lang/String;", "setBrand", "(Ljava/lang/String;)V", "getDevice", "setDevice", "getModel", "setModel", "getOsVersion", "setOsVersion", "getSdkInt", "()I", "setSdkInt", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toJson", "kotlin.jvm.PlatformType", "toString", "jacoco-store"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didi.jacoco.ec.DeviceInfo */
/* compiled from: DeviceInfo.kt */
public final class DeviceInfo {
    private String brand;
    private String device;
    private String model;
    private String osVersion;
    private int sdkInt;

    public static /* synthetic */ DeviceInfo copy$default(DeviceInfo deviceInfo, String str, String str2, String str3, int i, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = deviceInfo.brand;
        }
        if ((i2 & 2) != 0) {
            str2 = deviceInfo.model;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = deviceInfo.device;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            i = deviceInfo.sdkInt;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            str4 = deviceInfo.osVersion;
        }
        return deviceInfo.copy(str, str5, str6, i3, str4);
    }

    public final String component1() {
        return this.brand;
    }

    public final String component2() {
        return this.model;
    }

    public final String component3() {
        return this.device;
    }

    public final int component4() {
        return this.sdkInt;
    }

    public final String component5() {
        return this.osVersion;
    }

    public final DeviceInfo copy(String str, String str2, String str3, int i, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "brand");
        Intrinsics.checkParameterIsNotNull(str2, "model");
        Intrinsics.checkParameterIsNotNull(str3, "device");
        Intrinsics.checkParameterIsNotNull(str4, "osVersion");
        return new DeviceInfo(str, str2, str3, i, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        return Intrinsics.areEqual((Object) this.brand, (Object) deviceInfo.brand) && Intrinsics.areEqual((Object) this.model, (Object) deviceInfo.model) && Intrinsics.areEqual((Object) this.device, (Object) deviceInfo.device) && this.sdkInt == deviceInfo.sdkInt && Intrinsics.areEqual((Object) this.osVersion, (Object) deviceInfo.osVersion);
    }

    public int hashCode() {
        String str = this.brand;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.model;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.device;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.sdkInt) * 31;
        String str4 = this.osVersion;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "DeviceInfo(brand=" + this.brand + ", model=" + this.model + ", device=" + this.device + ", sdkInt=" + this.sdkInt + ", osVersion=" + this.osVersion + ")";
    }

    public DeviceInfo(String str, String str2, String str3, int i, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "brand");
        Intrinsics.checkParameterIsNotNull(str2, "model");
        Intrinsics.checkParameterIsNotNull(str3, "device");
        Intrinsics.checkParameterIsNotNull(str4, "osVersion");
        this.brand = str;
        this.model = str2;
        this.device = str3;
        this.sdkInt = i;
        this.osVersion = str4;
    }

    public final String getBrand() {
        return this.brand;
    }

    public final void setBrand(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.brand = str;
    }

    public final String getModel() {
        return this.model;
    }

    public final void setModel(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.model = str;
    }

    public final String getDevice() {
        return this.device;
    }

    public final void setDevice(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.device = str;
    }

    public final int getSdkInt() {
        return this.sdkInt;
    }

    public final void setSdkInt(int i) {
        this.sdkInt = i;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final void setOsVersion(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.osVersion = str;
    }

    public final String toJson() {
        return new Gson().toJson((Object) this);
    }
}
