package com.didi.component.framework.pages.invitation.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/model/AreaVo;", "", "cityName", "", "cityId", "(Ljava/lang/String;Ljava/lang/String;)V", "getCityId", "()Ljava/lang/String;", "setCityId", "(Ljava/lang/String;)V", "getCityName", "setCityName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitePageModel.kt */
public final class AreaVo {
    private String cityId;
    private String cityName;

    public static /* synthetic */ AreaVo copy$default(AreaVo areaVo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = areaVo.cityName;
        }
        if ((i & 2) != 0) {
            str2 = areaVo.cityId;
        }
        return areaVo.copy(str, str2);
    }

    public final String component1() {
        return this.cityName;
    }

    public final String component2() {
        return this.cityId;
    }

    public final AreaVo copy(String str, String str2) {
        return new AreaVo(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AreaVo)) {
            return false;
        }
        AreaVo areaVo = (AreaVo) obj;
        return Intrinsics.areEqual((Object) this.cityName, (Object) areaVo.cityName) && Intrinsics.areEqual((Object) this.cityId, (Object) areaVo.cityId);
    }

    public int hashCode() {
        String str = this.cityName;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.cityId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "AreaVo(cityName=" + this.cityName + ", cityId=" + this.cityId + VersionRange.RIGHT_OPEN;
    }

    public AreaVo(String str, String str2) {
        this.cityName = str;
        this.cityId = str2;
    }

    public final String getCityId() {
        return this.cityId;
    }

    public final String getCityName() {
        return this.cityName;
    }

    public final void setCityId(String str) {
        this.cityId = str;
    }

    public final void setCityName(String str) {
        this.cityName = str;
    }
}
