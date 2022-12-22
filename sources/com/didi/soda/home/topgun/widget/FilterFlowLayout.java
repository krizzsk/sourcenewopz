package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.didi.nova.assembly.p127ui.flowlayout.NovaFlowLayout;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.home.topgun.widget.FilterGridLayout;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0012J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0002J\u0006\u0010\u0019\u001a\u00020\u0012J\u0014\u0010\u001a\u001a\u00020\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001cJ$\u0010\u001d\u001a\u00020\u00122\u001c\u0010\u001e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u000fj\u0002`\u0013J$\u0010\u001f\u001a\u00020\u00122\u001c\u0010\u001e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u000fj\u0002`\u0015R>\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR(\u0010\u000e\u001a\u001c\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000fj\u0004\u0018\u0001`\u0013X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0014\u001a\u001c\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000fj\u0004\u0018\u0001`\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/FilterFlowLayout;", "Lcom/didi/nova/assembly/ui/flowlayout/NovaFlowLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "<set-?>", "Ljava/util/ArrayList;", "Lcom/didi/soda/home/topgun/widget/FilterGridLayout$GridItem;", "Lkotlin/collections/ArrayList;", "mItemList", "getMItemList", "()Ljava/util/ArrayList;", "mOnClickFilterItemListener", "Lkotlin/Function2;", "Lcom/didi/soda/home/topgun/model/FilterModel$FilterItemRvModel;", "", "", "Lcom/didi/soda/home/topgun/component/filter/module/OnFilterItemClickListener;", "mOnSWFilterItemListener", "Lcom/didi/soda/home/topgun/component/filter/module/OnFilterItemSWListener;", "confirm", "itemSelectChanged", "gridItem", "reset", "setFilterItem", "filterItemRvModelList", "", "setOnClickFilterItemListener", "listener", "setOnSWFilterItemListener", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FilterFlowLayout.kt */
public final class FilterFlowLayout extends NovaFlowLayout {

    /* renamed from: a */
    private ArrayList<FilterGridLayout.GridItem> f43055a;

    /* renamed from: b */
    private Function2<? super FilterModel.FilterItemRvModel, ? super Boolean, Unit> f43056b;

    /* renamed from: c */
    private Function2<? super FilterModel.FilterItemRvModel, ? super Boolean, Unit> f43057c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FilterFlowLayout(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilterFlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f43055a = new ArrayList<>();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FilterFlowLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final ArrayList<FilterGridLayout.GridItem> getMItemList() {
        return this.f43055a;
    }

    public final void setOnClickFilterItemListener(Function2<? super FilterModel.FilterItemRvModel, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "listener");
        this.f43056b = function2;
    }

    public final void setOnSWFilterItemListener(Function2<? super FilterModel.FilterItemRvModel, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "listener");
        this.f43057c = function2;
    }

    public final void setFilterItem(List<? extends FilterModel.FilterItemRvModel> list) {
        Intrinsics.checkNotNullParameter(list, "filterItemRvModelList");
        this.f43055a.clear();
        removeAllViews();
        for (FilterModel.FilterItemRvModel filterItemRvModel : list) {
            FilterGridLayout.GridItem gridItem = new FilterGridLayout.GridItem(this, filterItemRvModel, new FilterGridLayout.SelectedChangeListener() {
                public final void onItemSelectedChanged(FilterGridLayout.GridItem gridItem) {
                    FilterFlowLayout.m30459a(FilterFlowLayout.this, gridItem);
                }
            });
            getMItemList().add(gridItem);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            marginLayoutParams.setMargins(0, CustomerExtentionKt.getPx(R.dimen.rf_dimen_12), CustomerExtentionKt.getPx(R.dimen.rf_dimen_20), CustomerExtentionKt.getPx(R.dimen.rf_dimen_12));
            addView(gridItem.itemView, marginLayoutParams);
            Function2<? super FilterModel.FilterItemRvModel, ? super Boolean, Unit> function2 = this.f43057c;
            if (function2 != null) {
                function2.invoke(filterItemRvModel, Boolean.valueOf(gridItem.isSelected()));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30459a(FilterFlowLayout filterFlowLayout, FilterGridLayout.GridItem gridItem) {
        Intrinsics.checkNotNullParameter(filterFlowLayout, "this$0");
        filterFlowLayout.m30460a(gridItem);
    }

    /* renamed from: a */
    private final void m30460a(FilterGridLayout.GridItem gridItem) {
        FilterModel.FilterItemRvModel itemRvModel;
        Function2<? super FilterModel.FilterItemRvModel, ? super Boolean, Unit> function2;
        if (gridItem != null && gridItem.getItemRvModel() != null) {
            Iterator<FilterGridLayout.GridItem> it = getMItemList().iterator();
            while (it.hasNext()) {
                FilterGridLayout.GridItem next = it.next();
                if (!Intrinsics.areEqual((Object) next, (Object) gridItem)) {
                    if (!gridItem.isMultipleChoice()) {
                        next.setViewSelected(false);
                    } else if (!next.isMultipleChoice()) {
                        next.setViewSelected(false);
                    }
                }
            }
            if (this.f43056b != null && (itemRvModel = gridItem.getItemRvModel()) != null && (function2 = this.f43056b) != null) {
                function2.invoke(itemRvModel, Boolean.valueOf(gridItem.isSelected()));
            }
        }
    }

    public final void confirm() {
        Iterator<FilterGridLayout.GridItem> it = this.f43055a.iterator();
        while (it.hasNext()) {
            FilterGridLayout.GridItem next = it.next();
            FilterModel.FilterItemRvModel itemRvModel = next.getItemRvModel();
            if (itemRvModel != null) {
                itemRvModel.mIsSelected = next.isSelected();
            }
        }
    }

    public final void reset() {
        Iterator<FilterGridLayout.GridItem> it = this.f43055a.iterator();
        while (it.hasNext()) {
            FilterGridLayout.GridItem next = it.next();
            FilterModel.FilterItemRvModel itemRvModel = next.getItemRvModel();
            next.setViewSelected(itemRvModel == null ? false : itemRvModel.mIsDefault);
        }
    }
}
