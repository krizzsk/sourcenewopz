package com.didi.soda.home.topgun.model;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.home.topgun.model.FilterModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/model/FilterItemState;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "activityId", "", "getActivityId", "()Ljava/lang/String;", "setActivityId", "(Ljava/lang/String;)V", "isMultipleChoice", "", "()Ljava/lang/Boolean;", "setMultipleChoice", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "itemId", "getItemId", "setItemId", "sourceType", "getSourceType", "setSourceType", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FilterItemState.kt */
public final class FilterItemState implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long serialVersionUID = -4024686512385493332L;
    private String activityId;
    private Boolean isMultipleChoice = false;
    private String itemId;
    private String sourceType;

    @JvmStatic
    public static final FilterItemState convert(FilterModel.FilterItemRvModel filterItemRvModel) {
        return Companion.convert(filterItemRvModel);
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final void setItemId(String str) {
        this.itemId = str;
    }

    public final Boolean isMultipleChoice() {
        return this.isMultipleChoice;
    }

    public final void setMultipleChoice(Boolean bool) {
        this.isMultipleChoice = bool;
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

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/model/FilterItemState$Companion;", "", "()V", "serialVersionUID", "", "convert", "Lcom/didi/soda/home/topgun/model/FilterItemState;", "model", "Lcom/didi/soda/home/topgun/model/FilterModel$FilterItemRvModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FilterItemState.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FilterItemState convert(FilterModel.FilterItemRvModel filterItemRvModel) {
            Intrinsics.checkNotNullParameter(filterItemRvModel, "model");
            FilterItemState filterItemState = new FilterItemState();
            filterItemState.setItemId(filterItemRvModel.mId);
            filterItemState.setMultipleChoice(Boolean.valueOf(filterItemRvModel.mIsMultipleChoice));
            filterItemState.setSourceType(filterItemRvModel.mSourceType);
            filterItemState.setActivityId(filterItemRvModel.mActivityId);
            return filterItemState;
        }
    }
}
