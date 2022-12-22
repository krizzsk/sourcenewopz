package com.didi.soda.business.model;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/business/model/BusinessTabTipRvModel;", "Lcom/didi/soda/business/model/BaseBusinessRvModel;", "topContent", "", "(Ljava/lang/String;)V", "getTopContent", "()Ljava/lang/String;", "setTopContent", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessTabTipRvModel.kt */
public final class BusinessTabTipRvModel extends BaseBusinessRvModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private String f39718a;

    public static /* synthetic */ BusinessTabTipRvModel copy$default(BusinessTabTipRvModel businessTabTipRvModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = businessTabTipRvModel.f39718a;
        }
        return businessTabTipRvModel.copy(str);
    }

    @JvmStatic
    public static final BusinessTabTipRvModel newInstance(String str) {
        return Companion.newInstance(str);
    }

    public final String component1() {
        return this.f39718a;
    }

    public final BusinessTabTipRvModel copy(String str) {
        return new BusinessTabTipRvModel(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BusinessTabTipRvModel) && Intrinsics.areEqual((Object) this.f39718a, (Object) ((BusinessTabTipRvModel) obj).f39718a);
    }

    public int hashCode() {
        String str = this.f39718a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "BusinessTabTipRvModel(topContent=" + this.f39718a + VersionRange.RIGHT_OPEN;
    }

    public BusinessTabTipRvModel(String str) {
        this.f39718a = str;
    }

    public final String getTopContent() {
        return this.f39718a;
    }

    public final void setTopContent(String str) {
        this.f39718a = str;
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/business/model/BusinessTabTipRvModel$Companion;", "", "()V", "newInstance", "Lcom/didi/soda/business/model/BusinessTabTipRvModel;", "topContent", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BusinessTabTipRvModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BusinessTabTipRvModel newInstance(String str) {
            return new BusinessTabTipRvModel(str);
        }
    }
}
