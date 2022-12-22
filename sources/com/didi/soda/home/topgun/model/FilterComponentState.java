package com.didi.soda.home.topgun.model;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.home.topgun.model.FilterItemState;
import com.didi.soda.home.topgun.model.FilterModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002R6\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/model/FilterComponentState;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "filterItemStates", "Ljava/util/HashMap;", "", "Lcom/didi/soda/home/topgun/model/FilterItemState;", "Lkotlin/collections/HashMap;", "getFilterItemStates", "()Ljava/util/HashMap;", "setFilterItemStates", "(Ljava/util/HashMap;)V", "type", "", "getType", "()I", "setType", "(I)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FilterComponentState.kt */
public final class FilterComponentState implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long serialVersionUID = -1549581044140314270L;
    private HashMap<String, FilterItemState> filterItemStates = new HashMap<>();
    private int type;

    @JvmStatic
    public static final FilterComponentState convert(FilterModel.FilterComponentModel filterComponentModel) {
        return Companion.convert(filterComponentModel);
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final HashMap<String, FilterItemState> getFilterItemStates() {
        return this.filterItemStates;
    }

    public final void setFilterItemStates(HashMap<String, FilterItemState> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.filterItemStates = hashMap;
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/model/FilterComponentState$Companion;", "", "()V", "serialVersionUID", "", "convert", "Lcom/didi/soda/home/topgun/model/FilterComponentState;", "model", "Lcom/didi/soda/home/topgun/model/FilterModel$FilterComponentModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FilterComponentState.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FilterComponentState convert(FilterModel.FilterComponentModel filterComponentModel) {
            Intrinsics.checkNotNullParameter(filterComponentModel, "model");
            FilterComponentState filterComponentState = new FilterComponentState();
            filterComponentState.setType(filterComponentModel.mType);
            List<FilterModel.FilterItemRvModel> list = filterComponentModel.mItems;
            Intrinsics.checkNotNullExpressionValue(list, "model.mItems");
            Collection arrayList = new ArrayList();
            for (Object next : list) {
                if (((FilterModel.FilterItemRvModel) next).mIsSelected) {
                    arrayList.add(next);
                }
            }
            for (FilterModel.FilterItemRvModel filterItemRvModel : (List) arrayList) {
                HashMap<String, FilterItemState> filterItemStates = filterComponentState.getFilterItemStates();
                String str = filterItemRvModel.mId;
                FilterItemState.Companion companion = FilterItemState.Companion;
                Intrinsics.checkNotNullExpressionValue(filterItemRvModel, "itemModel");
                filterItemStates.put(str, companion.convert(filterItemRvModel));
            }
            return filterComponentState;
        }
    }
}
