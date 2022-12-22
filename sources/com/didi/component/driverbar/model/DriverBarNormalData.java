package com.didi.component.driverbar.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00108\u001a\u00020\fHÆ\u0003J\t\u00109\u001a\u00020\fHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u000fHÆ\u0003J§\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÆ\u0001J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\fHÖ\u0001J\t\u0010@\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0016\u0010\r\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,¨\u0006A"}, mo175978d2 = {"Lcom/didi/component/driverbar/model/DriverBarNormalData;", "", "oid", "", "carLabel", "Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "driverProfileUrl", "farInfo", "Lcom/didi/component/driverbar/model/DriverBarFieldInfo;", "nearInfo", "requireLevel", "showControlOptions", "", "switchNearEnable", "benefits", "Lcom/didi/component/driverbar/model/DriverBarBenefitInfo;", "operations", "", "Lcom/google/gson/JsonObject;", "cardStyle", "Lcom/didi/component/driverbar/model/DriverBarStyle;", "companyLogoUrl", "companyTags", "Lcom/didi/component/driverbar/model/CompanyTagsData;", "(Ljava/lang/String;Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;Ljava/lang/String;Lcom/didi/component/driverbar/model/DriverBarFieldInfo;Lcom/didi/component/driverbar/model/DriverBarFieldInfo;Ljava/lang/String;IILcom/didi/component/driverbar/model/DriverBarBenefitInfo;Ljava/util/List;Lcom/didi/component/driverbar/model/DriverBarStyle;Ljava/lang/String;Lcom/didi/component/driverbar/model/CompanyTagsData;)V", "getBenefits", "()Lcom/didi/component/driverbar/model/DriverBarBenefitInfo;", "getCarLabel", "()Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "getCardStyle", "()Lcom/didi/component/driverbar/model/DriverBarStyle;", "getCompanyLogoUrl", "()Ljava/lang/String;", "getCompanyTags", "()Lcom/didi/component/driverbar/model/CompanyTagsData;", "getDriverProfileUrl", "getFarInfo", "()Lcom/didi/component/driverbar/model/DriverBarFieldInfo;", "getNearInfo", "getOid", "getOperations", "()Ljava/util/List;", "getRequireLevel", "getShowControlOptions", "()I", "getSwitchNearEnable", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "comp-driverbar_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DriverBarInfoData.kt */
public final class DriverBarNormalData {
    private final DriverBarBenefitInfo benefits;
    @SerializedName("car_label_name")
    private final LEGORichInfo carLabel;
    @SerializedName("card_style")
    private final DriverBarStyle cardStyle;
    @SerializedName("company_logo")
    private final String companyLogoUrl;
    @SerializedName("company_tags")
    private final CompanyTagsData companyTags;
    @SerializedName("driver_homepage_url")
    private final String driverProfileUrl;
    @SerializedName("far_info")
    private final DriverBarFieldInfo farInfo;
    @SerializedName("near_info")
    private final DriverBarFieldInfo nearInfo;
    private final String oid;
    private final List<JsonObject> operations;
    @SerializedName("require_level")
    private final String requireLevel;
    @SerializedName("show_control_options")
    private final int showControlOptions;
    @SerializedName("switch_near_scene_enable")
    private final int switchNearEnable;

    public static /* synthetic */ DriverBarNormalData copy$default(DriverBarNormalData driverBarNormalData, String str, LEGORichInfo lEGORichInfo, String str2, DriverBarFieldInfo driverBarFieldInfo, DriverBarFieldInfo driverBarFieldInfo2, String str3, int i, int i2, DriverBarBenefitInfo driverBarBenefitInfo, List list, DriverBarStyle driverBarStyle, String str4, CompanyTagsData companyTagsData, int i3, Object obj) {
        DriverBarNormalData driverBarNormalData2 = driverBarNormalData;
        int i4 = i3;
        return driverBarNormalData.copy((i4 & 1) != 0 ? driverBarNormalData2.oid : str, (i4 & 2) != 0 ? driverBarNormalData2.carLabel : lEGORichInfo, (i4 & 4) != 0 ? driverBarNormalData2.driverProfileUrl : str2, (i4 & 8) != 0 ? driverBarNormalData2.farInfo : driverBarFieldInfo, (i4 & 16) != 0 ? driverBarNormalData2.nearInfo : driverBarFieldInfo2, (i4 & 32) != 0 ? driverBarNormalData2.requireLevel : str3, (i4 & 64) != 0 ? driverBarNormalData2.showControlOptions : i, (i4 & 128) != 0 ? driverBarNormalData2.switchNearEnable : i2, (i4 & 256) != 0 ? driverBarNormalData2.benefits : driverBarBenefitInfo, (i4 & 512) != 0 ? driverBarNormalData2.operations : list, (i4 & 1024) != 0 ? driverBarNormalData2.cardStyle : driverBarStyle, (i4 & 2048) != 0 ? driverBarNormalData2.companyLogoUrl : str4, (i4 & 4096) != 0 ? driverBarNormalData2.companyTags : companyTagsData);
    }

    public final String component1() {
        return this.oid;
    }

    public final List<JsonObject> component10() {
        return this.operations;
    }

    public final DriverBarStyle component11() {
        return this.cardStyle;
    }

    public final String component12() {
        return this.companyLogoUrl;
    }

    public final CompanyTagsData component13() {
        return this.companyTags;
    }

    public final LEGORichInfo component2() {
        return this.carLabel;
    }

    public final String component3() {
        return this.driverProfileUrl;
    }

    public final DriverBarFieldInfo component4() {
        return this.farInfo;
    }

    public final DriverBarFieldInfo component5() {
        return this.nearInfo;
    }

    public final String component6() {
        return this.requireLevel;
    }

    public final int component7() {
        return this.showControlOptions;
    }

    public final int component8() {
        return this.switchNearEnable;
    }

    public final DriverBarBenefitInfo component9() {
        return this.benefits;
    }

    public final DriverBarNormalData copy(String str, LEGORichInfo lEGORichInfo, String str2, DriverBarFieldInfo driverBarFieldInfo, DriverBarFieldInfo driverBarFieldInfo2, String str3, int i, int i2, DriverBarBenefitInfo driverBarBenefitInfo, List<JsonObject> list, DriverBarStyle driverBarStyle, String str4, CompanyTagsData companyTagsData) {
        return new DriverBarNormalData(str, lEGORichInfo, str2, driverBarFieldInfo, driverBarFieldInfo2, str3, i, i2, driverBarBenefitInfo, list, driverBarStyle, str4, companyTagsData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DriverBarNormalData)) {
            return false;
        }
        DriverBarNormalData driverBarNormalData = (DriverBarNormalData) obj;
        return Intrinsics.areEqual((Object) this.oid, (Object) driverBarNormalData.oid) && Intrinsics.areEqual((Object) this.carLabel, (Object) driverBarNormalData.carLabel) && Intrinsics.areEqual((Object) this.driverProfileUrl, (Object) driverBarNormalData.driverProfileUrl) && Intrinsics.areEqual((Object) this.farInfo, (Object) driverBarNormalData.farInfo) && Intrinsics.areEqual((Object) this.nearInfo, (Object) driverBarNormalData.nearInfo) && Intrinsics.areEqual((Object) this.requireLevel, (Object) driverBarNormalData.requireLevel) && this.showControlOptions == driverBarNormalData.showControlOptions && this.switchNearEnable == driverBarNormalData.switchNearEnable && Intrinsics.areEqual((Object) this.benefits, (Object) driverBarNormalData.benefits) && Intrinsics.areEqual((Object) this.operations, (Object) driverBarNormalData.operations) && this.cardStyle == driverBarNormalData.cardStyle && Intrinsics.areEqual((Object) this.companyLogoUrl, (Object) driverBarNormalData.companyLogoUrl) && Intrinsics.areEqual((Object) this.companyTags, (Object) driverBarNormalData.companyTags);
    }

    public int hashCode() {
        String str = this.oid;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        LEGORichInfo lEGORichInfo = this.carLabel;
        int hashCode2 = (hashCode + (lEGORichInfo == null ? 0 : lEGORichInfo.hashCode())) * 31;
        String str2 = this.driverProfileUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        DriverBarFieldInfo driverBarFieldInfo = this.farInfo;
        int hashCode4 = (hashCode3 + (driverBarFieldInfo == null ? 0 : driverBarFieldInfo.hashCode())) * 31;
        DriverBarFieldInfo driverBarFieldInfo2 = this.nearInfo;
        int hashCode5 = (hashCode4 + (driverBarFieldInfo2 == null ? 0 : driverBarFieldInfo2.hashCode())) * 31;
        String str3 = this.requireLevel;
        int hashCode6 = (((((hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.showControlOptions) * 31) + this.switchNearEnable) * 31;
        DriverBarBenefitInfo driverBarBenefitInfo = this.benefits;
        int hashCode7 = (hashCode6 + (driverBarBenefitInfo == null ? 0 : driverBarBenefitInfo.hashCode())) * 31;
        List<JsonObject> list = this.operations;
        int hashCode8 = (hashCode7 + (list == null ? 0 : list.hashCode())) * 31;
        DriverBarStyle driverBarStyle = this.cardStyle;
        int hashCode9 = (hashCode8 + (driverBarStyle == null ? 0 : driverBarStyle.hashCode())) * 31;
        String str4 = this.companyLogoUrl;
        int hashCode10 = (hashCode9 + (str4 == null ? 0 : str4.hashCode())) * 31;
        CompanyTagsData companyTagsData = this.companyTags;
        if (companyTagsData != null) {
            i = companyTagsData.hashCode();
        }
        return hashCode10 + i;
    }

    public String toString() {
        return "DriverBarNormalData(oid=" + this.oid + ", carLabel=" + this.carLabel + ", driverProfileUrl=" + this.driverProfileUrl + ", farInfo=" + this.farInfo + ", nearInfo=" + this.nearInfo + ", requireLevel=" + this.requireLevel + ", showControlOptions=" + this.showControlOptions + ", switchNearEnable=" + this.switchNearEnable + ", benefits=" + this.benefits + ", operations=" + this.operations + ", cardStyle=" + this.cardStyle + ", companyLogoUrl=" + this.companyLogoUrl + ", companyTags=" + this.companyTags + VersionRange.RIGHT_OPEN;
    }

    public DriverBarNormalData(String str, LEGORichInfo lEGORichInfo, String str2, DriverBarFieldInfo driverBarFieldInfo, DriverBarFieldInfo driverBarFieldInfo2, String str3, int i, int i2, DriverBarBenefitInfo driverBarBenefitInfo, List<JsonObject> list, DriverBarStyle driverBarStyle, String str4, CompanyTagsData companyTagsData) {
        this.oid = str;
        this.carLabel = lEGORichInfo;
        this.driverProfileUrl = str2;
        this.farInfo = driverBarFieldInfo;
        this.nearInfo = driverBarFieldInfo2;
        this.requireLevel = str3;
        this.showControlOptions = i;
        this.switchNearEnable = i2;
        this.benefits = driverBarBenefitInfo;
        this.operations = list;
        this.cardStyle = driverBarStyle;
        this.companyLogoUrl = str4;
        this.companyTags = companyTagsData;
    }

    public final String getOid() {
        return this.oid;
    }

    public final LEGORichInfo getCarLabel() {
        return this.carLabel;
    }

    public final String getDriverProfileUrl() {
        return this.driverProfileUrl;
    }

    public final DriverBarFieldInfo getFarInfo() {
        return this.farInfo;
    }

    public final DriverBarFieldInfo getNearInfo() {
        return this.nearInfo;
    }

    public final String getRequireLevel() {
        return this.requireLevel;
    }

    public final int getShowControlOptions() {
        return this.showControlOptions;
    }

    public final int getSwitchNearEnable() {
        return this.switchNearEnable;
    }

    public final DriverBarBenefitInfo getBenefits() {
        return this.benefits;
    }

    public final List<JsonObject> getOperations() {
        return this.operations;
    }

    public final DriverBarStyle getCardStyle() {
        return this.cardStyle;
    }

    public final String getCompanyLogoUrl() {
        return this.companyLogoUrl;
    }

    public final CompanyTagsData getCompanyTags() {
        return this.companyTags;
    }
}
