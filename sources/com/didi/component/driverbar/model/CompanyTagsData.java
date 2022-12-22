package com.didi.component.driverbar.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/component/driverbar/model/CompanyTagsData;", "", "companyStatement", "", "list", "", "Lcom/didi/component/driverbar/model/CompanyTagInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getCompanyStatement", "()Ljava/lang/String;", "getList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "comp-driverbar_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DriverBarInfoData.kt */
public final class CompanyTagsData {
    @SerializedName("company_fixed_text")
    private final String companyStatement;
    @SerializedName("tags")
    private final List<CompanyTagInfo> list;

    public static /* synthetic */ CompanyTagsData copy$default(CompanyTagsData companyTagsData, String str, List<CompanyTagInfo> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = companyTagsData.companyStatement;
        }
        if ((i & 2) != 0) {
            list2 = companyTagsData.list;
        }
        return companyTagsData.copy(str, list2);
    }

    public final String component1() {
        return this.companyStatement;
    }

    public final List<CompanyTagInfo> component2() {
        return this.list;
    }

    public final CompanyTagsData copy(String str, List<CompanyTagInfo> list2) {
        return new CompanyTagsData(str, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompanyTagsData)) {
            return false;
        }
        CompanyTagsData companyTagsData = (CompanyTagsData) obj;
        return Intrinsics.areEqual((Object) this.companyStatement, (Object) companyTagsData.companyStatement) && Intrinsics.areEqual((Object) this.list, (Object) companyTagsData.list);
    }

    public int hashCode() {
        String str = this.companyStatement;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<CompanyTagInfo> list2 = this.list;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CompanyTagsData(companyStatement=" + this.companyStatement + ", list=" + this.list + VersionRange.RIGHT_OPEN;
    }

    public CompanyTagsData(String str, List<CompanyTagInfo> list2) {
        this.companyStatement = str;
        this.list = list2;
    }

    public final String getCompanyStatement() {
        return this.companyStatement;
    }

    public final List<CompanyTagInfo> getList() {
        return this.list;
    }
}
