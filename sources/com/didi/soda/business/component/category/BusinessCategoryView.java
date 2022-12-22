package com.didi.soda.business.component.category;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.NovaLinearLayoutManager;
import com.didi.soda.business.component.category.Contract;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 -2\u00020\u0001:\u0002-.B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020\u0016H\u0002J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0004H\u0002J\b\u0010%\u001a\u00020\u0016H\u0014J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u0016H\u0002J\u0010\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020,H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000¨\u0006/"}, mo175978d2 = {"Lcom/didi/soda/business/component/category/BusinessCategoryView;", "Lcom/didi/soda/business/component/category/Contract$AbsCategoryView;", "()V", "backView", "Landroid/view/View;", "backgroundView", "categoryAnimator", "Lcom/didi/soda/business/component/category/CategoryAnimator;", "getCategoryAnimator", "()Lcom/didi/soda/business/component/category/CategoryAnimator;", "categoryAnimator$delegate", "Lkotlin/Lazy;", "dataListManager", "Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataListManager;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "nameView", "Landroid/widget/TextView;", "recyclerAdapter", "Lcom/didi/app/nova/support/view/recyclerview/adapter/NovaRecyclerAdapter;", "recyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;", "bindCategoryList", "", "categoryList", "", "Lcom/didi/soda/business/model/BusinessCategoryRvModel;", "dismissCategory", "selectedIndex", "", "inflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initRecyclerView", "initViews", "root", "onCreate", "setShopName", "shopName", "", "startWithAnimation", "updateContainerTopPadding", "isShow", "", "Companion", "SpaceItemDecoration", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessCategoryView.kt */
public final class BusinessCategoryView extends Contract.AbsCategoryView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_CLICK_CLOSE = 0;
    public static final int TYPE_CLICK_EMPTY_CLOSE = 1;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public NovaRecyclerView f39381a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f39382b;

    /* renamed from: c */
    private View f39383c;

    /* renamed from: d */
    private TextView f39384d;

    /* renamed from: e */
    private final NovaRecyclerAdapter f39385e = new NovaRecyclerAdapter();

    /* renamed from: f */
    private ChildDataListManager<RecyclerModel> f39386f;

    /* renamed from: g */
    private final Lazy f39387g = LazyKt.lazy(new BusinessCategoryView$categoryAnimator$2(this));

    /* renamed from: a */
    private final CategoryAnimator m27867a() {
        return (CategoryAnimator) this.f39387g.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        m27871b();
        m27873c();
        View view = this.f39383c;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backView");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BusinessCategoryView.m27870a(BusinessCategoryView.this, view);
            }
        });
        View view3 = this.f39382b;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundView");
        } else {
            view2 = view3;
        }
        view2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BusinessCategoryView.m27872b(BusinessCategoryView.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27870a(BusinessCategoryView businessCategoryView, View view) {
        Intrinsics.checkNotNullParameter(businessCategoryView, "this$0");
        businessCategoryView.dismissCategory();
        ((Contract.AbsCategoryPresenter) businessCategoryView.getPresenter()).onDismiss(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m27872b(BusinessCategoryView businessCategoryView, View view) {
        Intrinsics.checkNotNullParameter(businessCategoryView, "this$0");
        businessCategoryView.dismissCategory();
        ((Contract.AbsCategoryPresenter) businessCategoryView.getPresenter()).onDismiss(1);
    }

    /* renamed from: b */
    private final void m27871b() {
        this.f39385e.registerBinder(new BusinessCategoryView$initRecyclerView$1(this));
        ChildDataListManager<RecyclerModel> childDataListManager = new ChildDataListManager<>(this.f39385e);
        this.f39386f = childDataListManager;
        NovaRecyclerAdapter novaRecyclerAdapter = this.f39385e;
        NovaRecyclerView novaRecyclerView = null;
        if (childDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataListManager");
            childDataListManager = null;
        }
        novaRecyclerAdapter.addDataManager(childDataListManager);
        NovaRecyclerView novaRecyclerView2 = this.f39381a;
        if (novaRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            novaRecyclerView = novaRecyclerView2;
        }
        novaRecyclerView.setLayoutManager(new NovaLinearLayoutManager(novaRecyclerView.getContext()));
        novaRecyclerView.setAdapter(this.f39385e);
        novaRecyclerView.addItemDecoration(new SpaceItemDecoration());
    }

    /* renamed from: c */
    private final void m27873c() {
        m27867a().start(BusinessCategoryView$startWithAnimation$1.INSTANCE);
    }

    public void dismissCategory() {
        m27868a(-1);
    }

    public void bindCategoryList(List<? extends BusinessCategoryRvModel> list) {
        Intrinsics.checkNotNullParameter(list, "categoryList");
        ChildDataListManager<RecyclerModel> childDataListManager = this.f39386f;
        if (childDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataListManager");
            childDataListManager = null;
        }
        childDataListManager.addAll(list);
    }

    public void setShopName(String str) {
        Intrinsics.checkNotNullParameter(str, "shopName");
        TextView textView = this.f39384d;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nameView");
            textView = null;
        }
        textView.setText(str);
    }

    public void updateContainerTopPadding(boolean z) {
        getView().setPadding(getView().getPaddingLeft(), z ? 0 : CustomerSystemUtil.getImmersiveStatusBarHeight(getContext()), getView().getPaddingRight(), getView().getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_component_business_category_view, viewGroup);
        Intrinsics.checkNotNullExpressionValue(inflate, "it");
        m27869a(inflate);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…itViews(it)\n            }");
        return inflate;
    }

    /* renamed from: a */
    private final void m27869a(View view) {
        View findViewById = view.findViewById(R.id.customer_rv_business_category_list);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.c…v_business_category_list)");
        this.f39381a = (NovaRecyclerView) findViewById;
        View findViewById2 = view.findViewById(R.id.customer_cl_category_background);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.c…r_cl_category_background)");
        this.f39382b = findViewById2;
        View findViewById3 = view.findViewById(R.id.customer_cl_category_back);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.customer_cl_category_back)");
        this.f39383c = findViewById3;
        View findViewById4 = view.findViewById(R.id.customer_cl_category_title);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.customer_cl_category_title)");
        this.f39384d = (TextView) findViewById4;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m27868a(int i) {
        m27867a().reverse(new BusinessCategoryView$dismissCategory$1(this, i));
    }

    @Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/business/component/category/BusinessCategoryView$SpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BusinessCategoryView.kt */
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

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/business/component/category/BusinessCategoryView$Companion;", "", "()V", "TYPE_CLICK_CLOSE", "", "TYPE_CLICK_EMPTY_CLOSE", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BusinessCategoryView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
