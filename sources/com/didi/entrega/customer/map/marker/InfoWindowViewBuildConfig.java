package com.didi.entrega.customer.map.marker;

import com.didi.entrega.customer.map.marker.InfoWindowViewFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0001#B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ<\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015¨\u0006$"}, mo175978d2 = {"Lcom/didi/entrega/customer/map/marker/InfoWindowViewBuildConfig;", "", "category", "", "title", "", "subDesc", "orderStatus", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getCategory", "()I", "setCategory", "(I)V", "getOrderStatus", "()Ljava/lang/Integer;", "setOrderStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSubDesc", "()Ljava/lang/String;", "setSubDesc", "(Ljava/lang/String;)V", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/didi/entrega/customer/map/marker/InfoWindowViewBuildConfig;", "equals", "", "other", "hashCode", "toString", "Builder", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InfoWindowViewFactory.kt */
public final class InfoWindowViewBuildConfig {

    /* renamed from: a */
    private int f20197a;

    /* renamed from: b */
    private String f20198b;

    /* renamed from: c */
    private String f20199c;

    /* renamed from: d */
    private Integer f20200d;

    public /* synthetic */ InfoWindowViewBuildConfig(int i, String str, String str2, Integer num, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, num);
    }

    public static /* synthetic */ InfoWindowViewBuildConfig copy$default(InfoWindowViewBuildConfig infoWindowViewBuildConfig, int i, String str, String str2, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = infoWindowViewBuildConfig.f20197a;
        }
        if ((i2 & 2) != 0) {
            str = infoWindowViewBuildConfig.f20198b;
        }
        if ((i2 & 4) != 0) {
            str2 = infoWindowViewBuildConfig.f20199c;
        }
        if ((i2 & 8) != 0) {
            num = infoWindowViewBuildConfig.f20200d;
        }
        return infoWindowViewBuildConfig.copy(i, str, str2, num);
    }

    public final int component1() {
        return this.f20197a;
    }

    public final String component2() {
        return this.f20198b;
    }

    public final String component3() {
        return this.f20199c;
    }

    public final Integer component4() {
        return this.f20200d;
    }

    public final InfoWindowViewBuildConfig copy(int i, String str, String str2, Integer num) {
        return new InfoWindowViewBuildConfig(i, str, str2, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InfoWindowViewBuildConfig)) {
            return false;
        }
        InfoWindowViewBuildConfig infoWindowViewBuildConfig = (InfoWindowViewBuildConfig) obj;
        return this.f20197a == infoWindowViewBuildConfig.f20197a && Intrinsics.areEqual((Object) this.f20198b, (Object) infoWindowViewBuildConfig.f20198b) && Intrinsics.areEqual((Object) this.f20199c, (Object) infoWindowViewBuildConfig.f20199c) && Intrinsics.areEqual((Object) this.f20200d, (Object) infoWindowViewBuildConfig.f20200d);
    }

    public int hashCode() {
        int i = this.f20197a * 31;
        String str = this.f20198b;
        int i2 = 0;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f20199c;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.f20200d;
        if (num != null) {
            i2 = num.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "InfoWindowViewBuildConfig(category=" + this.f20197a + ", title=" + this.f20198b + ", subDesc=" + this.f20199c + ", orderStatus=" + this.f20200d + VersionRange.RIGHT_OPEN;
    }

    private InfoWindowViewBuildConfig(int i, String str, String str2, Integer num) {
        this.f20197a = i;
        this.f20198b = str;
        this.f20199c = str2;
        this.f20200d = num;
    }

    public final int getCategory() {
        return this.f20197a;
    }

    public final void setCategory(int i) {
        this.f20197a = i;
    }

    public final String getTitle() {
        return this.f20198b;
    }

    public final void setTitle(String str) {
        this.f20198b = str;
    }

    public final String getSubDesc() {
        return this.f20199c;
    }

    public final void setSubDesc(String str) {
        this.f20199c = str;
    }

    public final Integer getOrderStatus() {
        return this.f20200d;
    }

    public final void setOrderStatus(Integer num) {
        this.f20200d = num;
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\rR&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048\u0006@BX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/entrega/customer/map/marker/InfoWindowViewBuildConfig$Builder;", "", "()V", "<set-?>", "", "category", "getCategory$annotations", "getCategory", "()I", "orderStatus", "getOrderStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "", "subDesc", "getSubDesc", "()Ljava/lang/String;", "title", "getTitle", "build", "Lcom/didi/entrega/customer/map/marker/InfoWindowViewBuildConfig;", "setCategory", "setOrderStatus", "setSubDesc", "setTitle", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: InfoWindowViewFactory.kt */
    public static final class Builder {
        private int category;
        private Integer orderStatus;
        private String subDesc;
        private String title;

        @InfoWindowViewFactory.InfoViewCategory
        public static /* synthetic */ void getCategory$annotations() {
        }

        public final int getCategory() {
            return this.category;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getSubDesc() {
            return this.subDesc;
        }

        public final Integer getOrderStatus() {
            return this.orderStatus;
        }

        public final Builder setCategory(int i) {
            this.category = i;
            return this;
        }

        public final Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public final Builder setSubDesc(String str) {
            this.subDesc = str;
            return this;
        }

        public final Builder setOrderStatus(int i) {
            this.orderStatus = Integer.valueOf(i);
            return this;
        }

        public final InfoWindowViewBuildConfig build() {
            return new InfoWindowViewBuildConfig(this.category, this.title, this.subDesc, this.orderStatus, (DefaultConstructorMarker) null);
        }
    }
}
