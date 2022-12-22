package com.didi.component.driverbar.model;

import com.didi.component.common.model.DataFieldWrapper;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00102\u001a\u00020\"2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000e8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00158Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001b8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0012\u0010\u001f\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b \u0010\u0013R\u0012\u0010!\u001a\u00020\"8Æ\u0002¢\u0006\u0006\u001a\u0004\b!\u0010#R\u0014\u0010$\u001a\u0004\u0018\u00010\u001b8Æ\u0002¢\u0006\u0006\u001a\u0004\b%\u0010\u001dR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u0004\u0018\u00010\u00068Æ\u0002¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0012\u0010+\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b,\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0013¨\u00067"}, mo175978d2 = {"Lcom/didi/component/driverbar/model/DriverBarCardInfo;", "", "id", "", "normal", "Lcom/didi/component/common/model/DataFieldWrapper;", "Lcom/didi/component/driverbar/model/DriverBarNormalData;", "template", "(Ljava/lang/String;Lcom/didi/component/common/model/DataFieldWrapper;Ljava/lang/String;)V", "benefitInfo", "Lcom/didi/component/driverbar/model/DriverBarBenefitInfo;", "getBenefitInfo", "()Lcom/didi/component/driverbar/model/DriverBarBenefitInfo;", "cardStyle", "Lcom/didi/component/driverbar/model/DriverBarStyle;", "getCardStyle", "()Lcom/didi/component/driverbar/model/DriverBarStyle;", "companyLogoUrl", "getCompanyLogoUrl", "()Ljava/lang/String;", "companyTags", "Lcom/didi/component/driverbar/model/CompanyTagsData;", "getCompanyTags", "()Lcom/didi/component/driverbar/model/CompanyTagsData;", "driverProfileUrl", "getDriverProfileUrl", "farInfo", "Lcom/didi/component/driverbar/model/DriverBarFieldInfo;", "getFarInfo", "()Lcom/didi/component/driverbar/model/DriverBarFieldInfo;", "getId", "imOption", "getImOption", "isNearEnable", "", "()Z", "nearInfo", "getNearInfo", "getNormal", "()Lcom/didi/component/common/model/DataFieldWrapper;", "normalData", "getNormalData", "()Lcom/didi/component/driverbar/model/DriverBarNormalData;", "phoneOption", "getPhoneOption", "getTemplate", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "comp-driverbar_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DriverBarCardInfo.kt */
public final class DriverBarCardInfo {
    @SerializedName("id")

    /* renamed from: id */
    private final String f13000id;
    @SerializedName("normal")
    private final DataFieldWrapper<DriverBarNormalData> normal;
    @SerializedName("template")
    private final String template;

    public static /* synthetic */ DriverBarCardInfo copy$default(DriverBarCardInfo driverBarCardInfo, String str, DataFieldWrapper<DriverBarNormalData> dataFieldWrapper, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = driverBarCardInfo.f13000id;
        }
        if ((i & 2) != 0) {
            dataFieldWrapper = driverBarCardInfo.normal;
        }
        if ((i & 4) != 0) {
            str2 = driverBarCardInfo.template;
        }
        return driverBarCardInfo.copy(str, dataFieldWrapper, str2);
    }

    public final String component1() {
        return this.f13000id;
    }

    public final DataFieldWrapper<DriverBarNormalData> component2() {
        return this.normal;
    }

    public final String component3() {
        return this.template;
    }

    public final DriverBarCardInfo copy(String str, DataFieldWrapper<DriverBarNormalData> dataFieldWrapper, String str2) {
        return new DriverBarCardInfo(str, dataFieldWrapper, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DriverBarCardInfo)) {
            return false;
        }
        DriverBarCardInfo driverBarCardInfo = (DriverBarCardInfo) obj;
        return Intrinsics.areEqual((Object) this.f13000id, (Object) driverBarCardInfo.f13000id) && Intrinsics.areEqual((Object) this.normal, (Object) driverBarCardInfo.normal) && Intrinsics.areEqual((Object) this.template, (Object) driverBarCardInfo.template);
    }

    public int hashCode() {
        String str = this.f13000id;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        DataFieldWrapper<DriverBarNormalData> dataFieldWrapper = this.normal;
        int hashCode2 = (hashCode + (dataFieldWrapper == null ? 0 : dataFieldWrapper.hashCode())) * 31;
        String str2 = this.template;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "DriverBarCardInfo(id=" + this.f13000id + ", normal=" + this.normal + ", template=" + this.template + VersionRange.RIGHT_OPEN;
    }

    public DriverBarCardInfo(String str, DataFieldWrapper<DriverBarNormalData> dataFieldWrapper, String str2) {
        this.f13000id = str;
        this.normal = dataFieldWrapper;
        this.template = str2;
    }

    public final String getId() {
        return this.f13000id;
    }

    public final DataFieldWrapper<DriverBarNormalData> getNormal() {
        return this.normal;
    }

    public final String getTemplate() {
        return this.template;
    }

    public final DriverBarNormalData getNormalData() {
        DataFieldWrapper<DriverBarNormalData> normal2 = getNormal();
        if (normal2 == null) {
            return null;
        }
        return normal2.getData();
    }

    public final DriverBarStyle getCardStyle() {
        DataFieldWrapper<DriverBarNormalData> normal2 = getNormal();
        DriverBarStyle driverBarStyle = null;
        DriverBarNormalData data = normal2 == null ? null : normal2.getData();
        if (data != null) {
            driverBarStyle = data.getCardStyle();
        }
        return driverBarStyle == null ? DriverBarStyle.DEFAULT_STYLE : driverBarStyle;
    }

    public final String getDriverProfileUrl() {
        DataFieldWrapper<DriverBarNormalData> normal2 = getNormal();
        String str = null;
        DriverBarNormalData data = normal2 == null ? null : normal2.getData();
        if (data != null) {
            str = data.getDriverProfileUrl();
        }
        return str == null ? "" : str;
    }

    public final DriverBarFieldInfo getFarInfo() {
        DataFieldWrapper<DriverBarNormalData> normal2 = getNormal();
        DriverBarNormalData data = normal2 == null ? null : normal2.getData();
        if (data == null) {
            return null;
        }
        return data.getFarInfo();
    }

    public final DriverBarFieldInfo getNearInfo() {
        DataFieldWrapper<DriverBarNormalData> normal2 = getNormal();
        DriverBarNormalData data = normal2 == null ? null : normal2.getData();
        if (data == null) {
            return null;
        }
        return data.getNearInfo();
    }

    public final DriverBarBenefitInfo getBenefitInfo() {
        DataFieldWrapper<DriverBarNormalData> normal2 = getNormal();
        DriverBarNormalData data = normal2 == null ? null : normal2.getData();
        if (data == null) {
            return null;
        }
        return data.getBenefits();
    }

    public final boolean isNearEnable() {
        DataFieldWrapper<DriverBarNormalData> normal2 = getNormal();
        DriverBarNormalData data = normal2 == null ? null : normal2.getData();
        return data != null && data.getSwitchNearEnable() == 1;
    }

    public final String getCompanyLogoUrl() {
        DataFieldWrapper<DriverBarNormalData> normal2 = getNormal();
        String str = null;
        DriverBarNormalData data = normal2 == null ? null : normal2.getData();
        if (data != null) {
            str = data.getCompanyLogoUrl();
        }
        return str == null ? "" : str;
    }

    public final CompanyTagsData getCompanyTags() {
        DataFieldWrapper<DriverBarNormalData> normal2 = getNormal();
        DriverBarNormalData data = normal2 == null ? null : normal2.getData();
        if (data == null) {
            return null;
        }
        return data.getCompanyTags();
    }

    public final String getImOption() {
        List<JsonObject> operations;
        JsonObject jsonObject;
        DataFieldWrapper<DriverBarNormalData> normal2 = getNormal();
        String str = null;
        DriverBarNormalData data = normal2 == null ? null : normal2.getData();
        if (!(data == null || (operations = data.getOperations()) == null || (jsonObject = (JsonObject) CollectionsKt.getOrNull(operations, 0)) == null)) {
            str = jsonObject.toString();
        }
        return str == null ? "" : str;
    }

    public final String getPhoneOption() {
        List<JsonObject> operations;
        JsonObject jsonObject;
        DataFieldWrapper<DriverBarNormalData> normal2 = getNormal();
        String str = null;
        DriverBarNormalData data = normal2 == null ? null : normal2.getData();
        if (!(data == null || (operations = data.getOperations()) == null || (jsonObject = (JsonObject) CollectionsKt.getOrNull(operations, 1)) == null)) {
            str = jsonObject.toString();
        }
        return str == null ? "" : str;
    }
}
