package com.didi.soda.home.topgun.model;

import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000  2\u00020\u0001:\u0001 B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J5\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006!"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/model/FilterItemParam;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "filterComponentType", "", "itemId", "", "sourceType", "activityId", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActivityId", "()Ljava/lang/String;", "setActivityId", "(Ljava/lang/String;)V", "getFilterComponentType", "()I", "setFilterComponentType", "(I)V", "getItemId", "setItemId", "getSourceType", "setSourceType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FilterItemParam.kt */
public final class FilterItemParam implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -4897823492434428607L;
    @SerializedName("activity_id")
    private String activityId;
    private int filterComponentType;
    private String itemId;
    private String sourceType;

    public static /* synthetic */ FilterItemParam copy$default(FilterItemParam filterItemParam, int i, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = filterItemParam.filterComponentType;
        }
        if ((i2 & 2) != 0) {
            str = filterItemParam.itemId;
        }
        if ((i2 & 4) != 0) {
            str2 = filterItemParam.sourceType;
        }
        if ((i2 & 8) != 0) {
            str3 = filterItemParam.activityId;
        }
        return filterItemParam.copy(i, str, str2, str3);
    }

    public final int component1() {
        return this.filterComponentType;
    }

    public final String component2() {
        return this.itemId;
    }

    public final String component3() {
        return this.sourceType;
    }

    public final String component4() {
        return this.activityId;
    }

    public final FilterItemParam copy(int i, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, BlocksConst.ACTION_PARAMS_ITEM_ID);
        return new FilterItemParam(i, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterItemParam)) {
            return false;
        }
        FilterItemParam filterItemParam = (FilterItemParam) obj;
        return this.filterComponentType == filterItemParam.filterComponentType && Intrinsics.areEqual((Object) this.itemId, (Object) filterItemParam.itemId) && Intrinsics.areEqual((Object) this.sourceType, (Object) filterItemParam.sourceType) && Intrinsics.areEqual((Object) this.activityId, (Object) filterItemParam.activityId);
    }

    public int hashCode() {
        int hashCode = ((this.filterComponentType * 31) + this.itemId.hashCode()) * 31;
        String str = this.sourceType;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.activityId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "FilterItemParam(filterComponentType=" + this.filterComponentType + ", itemId=" + this.itemId + ", sourceType=" + this.sourceType + ", activityId=" + this.activityId + VersionRange.RIGHT_OPEN;
    }

    public FilterItemParam(int i, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, BlocksConst.ACTION_PARAMS_ITEM_ID);
        this.filterComponentType = i;
        this.itemId = str;
        this.sourceType = str2;
        this.activityId = str3;
    }

    public final int getFilterComponentType() {
        return this.filterComponentType;
    }

    public final void setFilterComponentType(int i) {
        this.filterComponentType = i;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final void setItemId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.itemId = str;
    }

    public final String getSourceType() {
        return this.sourceType;
    }

    public final void setSourceType(String str) {
        this.sourceType = str;
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final void setActivityId(String str) {
        this.activityId = str;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/model/FilterItemParam$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FilterItemParam.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
