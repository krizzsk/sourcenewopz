package com.didi.soda.customer.foundation.rpc.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/HomeEfoMoreEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "moreTitle", "", "moreUrl", "bgColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBgColor", "()Ljava/lang/String;", "setBgColor", "(Ljava/lang/String;)V", "getMoreTitle", "setMoreTitle", "getMoreUrl", "setMoreUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeEfoMoreEntity.kt */
public final class HomeEfoMoreEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -5314411396813218105L;
    private String bgColor;
    private String moreTitle;
    private String moreUrl;

    public HomeEfoMoreEntity() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ HomeEfoMoreEntity copy$default(HomeEfoMoreEntity homeEfoMoreEntity, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = homeEfoMoreEntity.moreTitle;
        }
        if ((i & 2) != 0) {
            str2 = homeEfoMoreEntity.moreUrl;
        }
        if ((i & 4) != 0) {
            str3 = homeEfoMoreEntity.bgColor;
        }
        return homeEfoMoreEntity.copy(str, str2, str3);
    }

    public final String component1() {
        return this.moreTitle;
    }

    public final String component2() {
        return this.moreUrl;
    }

    public final String component3() {
        return this.bgColor;
    }

    public final HomeEfoMoreEntity copy(String str, String str2, String str3) {
        return new HomeEfoMoreEntity(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeEfoMoreEntity)) {
            return false;
        }
        HomeEfoMoreEntity homeEfoMoreEntity = (HomeEfoMoreEntity) obj;
        return Intrinsics.areEqual((Object) this.moreTitle, (Object) homeEfoMoreEntity.moreTitle) && Intrinsics.areEqual((Object) this.moreUrl, (Object) homeEfoMoreEntity.moreUrl) && Intrinsics.areEqual((Object) this.bgColor, (Object) homeEfoMoreEntity.bgColor);
    }

    public int hashCode() {
        String str = this.moreTitle;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.moreUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.bgColor;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "HomeEfoMoreEntity(moreTitle=" + this.moreTitle + ", moreUrl=" + this.moreUrl + ", bgColor=" + this.bgColor + VersionRange.RIGHT_OPEN;
    }

    public HomeEfoMoreEntity(String str, String str2, String str3) {
        this.moreTitle = str;
        this.moreUrl = str2;
        this.bgColor = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeEfoMoreEntity(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    public final String getMoreTitle() {
        return this.moreTitle;
    }

    public final void setMoreTitle(String str) {
        this.moreTitle = str;
    }

    public final String getMoreUrl() {
        return this.moreUrl;
    }

    public final void setMoreUrl(String str) {
        this.moreUrl = str;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final void setBgColor(String str) {
        this.bgColor = str;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/HomeEfoMoreEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeEfoMoreEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
