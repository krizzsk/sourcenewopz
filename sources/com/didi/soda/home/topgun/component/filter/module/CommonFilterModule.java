package com.didi.soda.home.topgun.component.filter.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.home.topgun.widget.FilterGridLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J6\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u001c\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000e0\u0016j\u0002`\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/filter/module/CommonFilterModule;", "Lcom/didi/soda/home/topgun/component/filter/module/AbsFilterModule;", "parent", "Landroid/view/ViewGroup;", "scene", "", "(Landroid/view/ViewGroup;I)V", "filterGridLayout", "Lcom/didi/soda/home/topgun/widget/FilterGridLayout;", "getFilterGridLayout", "()Lcom/didi/soda/home/topgun/widget/FilterGridLayout;", "setFilterGridLayout", "(Lcom/didi/soda/home/topgun/widget/FilterGridLayout;)V", "confirmFilterModule", "", "createFilterItemsListView", "Landroid/view/View;", "mContext", "Landroid/content/Context;", "componentModel", "Lcom/didi/soda/home/topgun/model/FilterModel$FilterComponentModel;", "listener", "Lkotlin/Function2;", "Lcom/didi/soda/home/topgun/model/FilterModel$FilterItemRvModel;", "", "Lcom/didi/soda/home/topgun/component/filter/module/OnFilterItemClickListener;", "isOriginal", "resetFilterModule", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CommonFilterModule.kt */
public final class CommonFilterModule extends AbsFilterModule {

    /* renamed from: a */
    private FilterGridLayout f42856a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommonFilterModule(ViewGroup viewGroup, int i) {
        super(viewGroup, i);
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    public final FilterGridLayout getFilterGridLayout() {
        return this.f42856a;
    }

    public final void setFilterGridLayout(FilterGridLayout filterGridLayout) {
        this.f42856a = filterGridLayout;
    }

    public View createFilterItemsListView(Context context, FilterModel.FilterComponentModel filterComponentModel, Function2<? super FilterModel.FilterItemRvModel, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(filterComponentModel, "componentModel");
        Intrinsics.checkNotNullParameter(function2, "listener");
        FilterGridLayout filterGridLayout = new FilterGridLayout(context);
        filterGridLayout.setOnClickFilterItemListener(new FilterGridLayout.OnClickFilterItemListener() {
            public final void onItemSelectChanged(FilterModel.FilterItemRvModel filterItemRvModel, boolean z) {
                CommonFilterModule.m30315a(Function2.this, filterItemRvModel, z);
            }
        });
        filterGridLayout.setColumnCount(filterComponentModel.mColNum > 0 ? filterComponentModel.mColNum : 2);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.setMargins(0, DisplayUtils.dip2px(context, 16.0f), 0, DisplayUtils.dip2px(context, 17.0f));
        Unit unit = Unit.INSTANCE;
        filterGridLayout.setLayoutParams(marginLayoutParams);
        filterGridLayout.setFilterItem(filterComponentModel.mItems);
        Unit unit2 = Unit.INSTANCE;
        this.f42856a = filterGridLayout;
        Intrinsics.checkNotNull(filterGridLayout);
        return filterGridLayout;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30315a(Function2 function2, FilterModel.FilterItemRvModel filterItemRvModel, boolean z) {
        Intrinsics.checkNotNullParameter(function2, "$tmp0");
        function2.invoke(filterItemRvModel, Boolean.valueOf(z));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.didi.soda.home.topgun.widget.FilterGridLayout$GridItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.didi.soda.home.topgun.widget.FilterGridLayout$GridItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.didi.soda.home.topgun.widget.FilterGridLayout$GridItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: com.didi.soda.home.topgun.widget.FilterGridLayout$GridItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.didi.soda.home.topgun.widget.FilterGridLayout$GridItem} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isOriginal() {
        /*
            r7 = this;
            com.didi.soda.home.topgun.widget.FilterGridLayout r0 = r7.f42856a
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
            com.didi.soda.home.topgun.widget.FilterGridLayout$GridItem r5 = (com.didi.soda.home.topgun.widget.FilterGridLayout.GridItem) r5
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
            com.didi.soda.home.topgun.widget.FilterGridLayout$GridItem r3 = (com.didi.soda.home.topgun.widget.FilterGridLayout.GridItem) r3
        L_0x0039:
            if (r3 != 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r1 = 0
        L_0x003d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.component.filter.module.CommonFilterModule.isOriginal():boolean");
    }

    public void resetFilterModule() {
        FilterGridLayout filterGridLayout = this.f42856a;
        if (filterGridLayout != null) {
            filterGridLayout.reset();
        }
    }

    public void confirmFilterModule() {
        FilterGridLayout filterGridLayout = this.f42856a;
        if (filterGridLayout != null) {
            filterGridLayout.confirm();
        }
    }
}
