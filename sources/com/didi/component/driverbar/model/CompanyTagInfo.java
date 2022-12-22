package com.didi.component.driverbar.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005JD\u0010\t\u001a\u00020\n26\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\n0\fH\bø\u0001\u0000J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/component/driverbar/model/CompanyTagInfo;", "", "imageUrl", "", "text", "(Ljava/lang/String;Ljava/lang/String;)V", "getImageUrl", "()Ljava/lang/String;", "getText", "asComponent", "", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "label", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "comp-driverbar_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DriverBarInfoData.kt */
public final class CompanyTagInfo {
    @SerializedName("image")
    private final String imageUrl;
    @SerializedName("text")
    private final String text;

    public static /* synthetic */ CompanyTagInfo copy$default(CompanyTagInfo companyTagInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = companyTagInfo.imageUrl;
        }
        if ((i & 2) != 0) {
            str2 = companyTagInfo.text;
        }
        return companyTagInfo.copy(str, str2);
    }

    public final String component1() {
        return this.imageUrl;
    }

    public final String component2() {
        return this.text;
    }

    public final CompanyTagInfo copy(String str, String str2) {
        return new CompanyTagInfo(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompanyTagInfo)) {
            return false;
        }
        CompanyTagInfo companyTagInfo = (CompanyTagInfo) obj;
        return Intrinsics.areEqual((Object) this.imageUrl, (Object) companyTagInfo.imageUrl) && Intrinsics.areEqual((Object) this.text, (Object) companyTagInfo.text);
    }

    public int hashCode() {
        String str = this.imageUrl;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.text;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CompanyTagInfo(imageUrl=" + this.imageUrl + ", text=" + this.text + VersionRange.RIGHT_OPEN;
    }

    public CompanyTagInfo(String str, String str2) {
        this.imageUrl = str;
        this.text = str2;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getText() {
        return this.text;
    }

    public final void asComponent(Function2<? super String, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        String text2 = getText();
        String str = "";
        if (text2 == null) {
            text2 = str;
        }
        String imageUrl2 = getImageUrl();
        if (imageUrl2 != null) {
            str = imageUrl2;
        }
        function2.invoke(text2, str);
    }
}
