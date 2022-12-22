package com.didi.soda.business.component.dynamic.category;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.NovaLinearLayoutManager;
import com.didi.soda.business.component.dynamic.category.Contract;
import com.didi.soda.business.model.BusinessCategoryMenuRvModel;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u000bH\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0014J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000eH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006!"}, mo175978d2 = {"Lcom/didi/soda/business/component/dynamic/category/BusinessDyCategoryView;", "Lcom/didi/soda/business/component/dynamic/category/Contract$AbsCategoryView;", "()V", "dataListManager", "Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataListManager;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "recyclerAdapter", "Lcom/didi/app/nova/support/view/recyclerview/adapter/NovaRecyclerAdapter;", "recyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;", "bindCategoryList", "", "categoryList", "", "Lcom/didi/soda/business/model/BusinessCategoryMenuRvModel;", "dismissCategory", "selectedIndex", "", "inflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initRecyclerView", "initViews", "root", "onCreate", "setCategoryItemSelected", "index", "item", "Companion", "SpaceItemDecoration", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessDyCategoryView.kt */
public final class BusinessDyCategoryView extends Contract.AbsCategoryView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_CLICK_CLOSE = 0;
    public static final int TYPE_CLICK_EMPTY_CLOSE = 1;

    /* renamed from: a */
    private NovaRecyclerView f39462a;

    /* renamed from: b */
    private final NovaRecyclerAdapter f39463b = new NovaRecyclerAdapter();

    /* renamed from: c */
    private ChildDataListManager<RecyclerModel> f39464c;

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        m27991a();
    }

    /* renamed from: a */
    private final void m27991a() {
        this.f39463b.registerBinder(new BusinessDyCategoryView$initRecyclerView$1(this));
        ChildDataListManager<RecyclerModel> childDataListManager = new ChildDataListManager<>(this.f39463b);
        this.f39464c = childDataListManager;
        NovaRecyclerAdapter novaRecyclerAdapter = this.f39463b;
        NovaRecyclerView novaRecyclerView = null;
        if (childDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataListManager");
            childDataListManager = null;
        }
        novaRecyclerAdapter.addDataManager(childDataListManager);
        NovaRecyclerView novaRecyclerView2 = this.f39462a;
        if (novaRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            novaRecyclerView = novaRecyclerView2;
        }
        novaRecyclerView.setLayoutManager(new NovaLinearLayoutManager(novaRecyclerView.getContext()));
        novaRecyclerView.setAdapter(this.f39463b);
        novaRecyclerView.addItemDecoration(new SpaceItemDecoration());
    }

    public void dismissCategory() {
        m27992a(-1);
    }

    public void bindCategoryList(List<? extends BusinessCategoryMenuRvModel> list) {
        Intrinsics.checkNotNullParameter(list, "categoryList");
        ChildDataListManager<RecyclerModel> childDataListManager = this.f39464c;
        if (childDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataListManager");
            childDataListManager = null;
        }
        childDataListManager.addAll(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m27993a(int i, BusinessCategoryMenuRvModel businessCategoryMenuRvModel) {
        ChildDataListManager<RecyclerModel> childDataListManager = this.f39464c;
        ChildDataListManager<RecyclerModel> childDataListManager2 = null;
        if (childDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataListManager");
            childDataListManager = null;
        }
        if (i < childDataListManager.size()) {
            int defaultSelectedIndex = ((Contract.AbsCategoryPresenter) getPresenter()).getDefaultSelectedIndex();
            ChildDataListManager<RecyclerModel> childDataListManager3 = this.f39464c;
            if (childDataListManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataListManager");
                childDataListManager3 = null;
            }
            if (defaultSelectedIndex < childDataListManager3.size() && businessCategoryMenuRvModel != null) {
                ChildDataListManager<RecyclerModel> childDataListManager4 = this.f39464c;
                if (childDataListManager4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataListManager");
                    childDataListManager4 = null;
                }
                RecyclerModel recyclerModel = childDataListManager4.get(((Contract.AbsCategoryPresenter) getPresenter()).getDefaultSelectedIndex());
                if (recyclerModel != null) {
                    BusinessCategoryMenuRvModel businessCategoryMenuRvModel2 = (BusinessCategoryMenuRvModel) recyclerModel;
                    businessCategoryMenuRvModel2.isSelected = false;
                    ChildDataListManager<RecyclerModel> childDataListManager5 = this.f39464c;
                    if (childDataListManager5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dataListManager");
                        childDataListManager5 = null;
                    }
                    childDataListManager5.set(((Contract.AbsCategoryPresenter) getPresenter()).getDefaultSelectedIndex(), businessCategoryMenuRvModel2);
                    businessCategoryMenuRvModel.isSelected = true;
                    ChildDataListManager<RecyclerModel> childDataListManager6 = this.f39464c;
                    if (childDataListManager6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dataListManager");
                    } else {
                        childDataListManager2 = childDataListManager6;
                    }
                    childDataListManager2.set(i, businessCategoryMenuRvModel);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.business.model.BusinessCategoryMenuRvModel");
            }
        }
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_component_business_dy_category_view, viewGroup);
        Intrinsics.checkNotNullExpressionValue(inflate, "it");
        m27994a(inflate);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…itViews(it)\n            }");
        return inflate;
    }

    /* renamed from: a */
    private final void m27994a(View view) {
        View findViewById = view.findViewById(R.id.customer_rv_business_category_list);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.c…v_business_category_list)");
        this.f39462a = (NovaRecyclerView) findViewById;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m27992a(int i) {
        Integer valueOf = Integer.valueOf(i);
        Unit unit = null;
        if (!(valueOf.intValue() >= 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            ((Contract.AbsCategoryPresenter) getPresenter()).selectedCategory(valueOf.intValue());
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            getScopeContext().getNavigator().finish();
        }
    }

    @Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/business/component/dynamic/category/BusinessDyCategoryView$SpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BusinessDyCategoryView.kt */
    public static final class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(rect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(recyclerView, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            Integer valueOf = Integer.valueOf(recyclerView.getChildAdapterPosition(view));
            if (!(valueOf.intValue() == 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                valueOf.intValue();
                rect.top = ResourceHelper.getDimensionPixelSize(R.dimen.customer_13px);
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/business/component/dynamic/category/BusinessDyCategoryView$Companion;", "", "()V", "TYPE_CLICK_CLOSE", "", "TYPE_CLICK_EMPTY_CLOSE", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BusinessDyCategoryView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
