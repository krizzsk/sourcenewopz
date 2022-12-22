package com.didi.soda.home.topgun.component.filter.module;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.home.topgun.widget.FilterSingleLineListLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J6\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u001c\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000e0\u0016j\u0002`\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/filter/module/SingleLineWithIconFilterModule;", "Lcom/didi/soda/home/topgun/component/filter/module/AbsFilterModule;", "parent", "Landroid/view/ViewGroup;", "scene", "", "(Landroid/view/ViewGroup;I)V", "filterListLayout", "Lcom/didi/soda/home/topgun/widget/FilterSingleLineListLayout;", "getFilterListLayout", "()Lcom/didi/soda/home/topgun/widget/FilterSingleLineListLayout;", "setFilterListLayout", "(Lcom/didi/soda/home/topgun/widget/FilterSingleLineListLayout;)V", "confirmFilterModule", "", "createFilterItemsListView", "Landroid/view/View;", "mContext", "Landroid/content/Context;", "componentModel", "Lcom/didi/soda/home/topgun/model/FilterModel$FilterComponentModel;", "listener", "Lkotlin/Function2;", "Lcom/didi/soda/home/topgun/model/FilterModel$FilterItemRvModel;", "", "Lcom/didi/soda/home/topgun/component/filter/module/OnFilterItemClickListener;", "isOriginal", "resetFilterModule", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SingleLineWithIconFilterModule.kt */
public final class SingleLineWithIconFilterModule extends AbsFilterModule {

    /* renamed from: a */
    private FilterSingleLineListLayout f42858a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleLineWithIconFilterModule(ViewGroup viewGroup, int i) {
        super(viewGroup, i);
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    public final FilterSingleLineListLayout getFilterListLayout() {
        return this.f42858a;
    }

    public final void setFilterListLayout(FilterSingleLineListLayout filterSingleLineListLayout) {
        this.f42858a = filterSingleLineListLayout;
    }

    public View createFilterItemsListView(Context context, FilterModel.FilterComponentModel filterComponentModel, Function2<? super FilterModel.FilterItemRvModel, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(filterComponentModel, "componentModel");
        Intrinsics.checkNotNullParameter(function2, "listener");
        FilterSingleLineListLayout filterSingleLineListLayout = new FilterSingleLineListLayout(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        filterSingleLineListLayout.setOnClickFilterItemListener(function2);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.setMargins(0, DisplayUtils.dip2px(context, 1.0f), 0, 0);
        Unit unit = Unit.INSTANCE;
        filterSingleLineListLayout.setLayoutParams(marginLayoutParams);
        List<FilterModel.FilterItemRvModel> list = filterComponentModel.mItems;
        Intrinsics.checkNotNullExpressionValue(list, "componentModel.mItems");
        filterSingleLineListLayout.setFilterItem(list, filterComponentModel.mNotAllowEmpty);
        Unit unit2 = Unit.INSTANCE;
        this.f42858a = filterSingleLineListLayout;
        Intrinsics.checkNotNull(filterSingleLineListLayout);
        return filterSingleLineListLayout;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.didi.soda.home.topgun.widget.FilterSingleLineListLayout$ListItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.didi.soda.home.topgun.widget.FilterSingleLineListLayout$ListItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.didi.soda.home.topgun.widget.FilterSingleLineListLayout$ListItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: com.didi.soda.home.topgun.widget.FilterSingleLineListLayout$ListItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.didi.soda.home.topgun.widget.FilterSingleLineListLayout$ListItem} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isOriginal() {
        /*
            r7 = this;
            com.didi.soda.home.topgun.widget.FilterSingleLineListLayout r0 = r7.f42858a
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L_0x0008
            goto L_0x0039
        L_0x0008:
            java.util.List r0 = r0.getUIItemList()
            if (r0 != 0) goto L_0x000f
            goto L_0x0039
        L_0x000f:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0015:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0037
            java.lang.Object r4 = r0.next()
            r5 = r4
            com.didi.soda.home.topgun.widget.FilterSingleLineListLayout$ListItem r5 = (com.didi.soda.home.topgun.widget.FilterSingleLineListLayout.ListItem) r5
            boolean r6 = r5.isSelected()
            com.didi.soda.home.topgun.model.FilterModel$FilterItemRvModel r5 = r5.getItemRvModel()
            if (r5 != 0) goto L_0x002e
        L_0x002c:
            r5 = 0
            goto L_0x0033
        L_0x002e:
            boolean r5 = r5.mIsDefault
            if (r6 != r5) goto L_0x002c
            r5 = 1
        L_0x0033:
            r5 = r5 ^ r1
            if (r5 == 0) goto L_0x0015
            r3 = r4
        L_0x0037:
            com.didi.soda.home.topgun.widget.FilterSingleLineListLayout$ListItem r3 = (com.didi.soda.home.topgun.widget.FilterSingleLineListLayout.ListItem) r3
        L_0x0039:
            if (r3 != 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r1 = 0
        L_0x003d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.component.filter.module.SingleLineWithIconFilterModule.isOriginal():boolean");
    }

    public void resetFilterModule() {
        FilterSingleLineListLayout filterSingleLineListLayout = this.f42858a;
        if (filterSingleLineListLayout != null) {
            filterSingleLineListLayout.reset();
        }
    }

    public void confirmFilterModule() {
        FilterSingleLineListLayout filterSingleLineListLayout = this.f42858a;
        if (filterSingleLineListLayout != null) {
            filterSingleLineListLayout.confirm();
        }
    }
}
