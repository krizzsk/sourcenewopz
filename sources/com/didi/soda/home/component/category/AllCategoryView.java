package com.didi.soda.home.component.category;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.home.component.category.Contract;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/home/component/category/AllCategoryView;", "Lcom/didi/soda/home/component/category/Contract$AbsAllCategoryView;", "()V", "mRecyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;", "generateNovaRecyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/INovaRecyclerView;", "inflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initItemBinders", "", "onCreate", "useLinearLayout", "", "SpaceItemDecoration", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AllCategoryView.kt */
public final class AllCategoryView extends Contract.AbsAllCategoryView {

    /* renamed from: a */
    private NovaRecyclerView f42559a;

    /* access modifiers changed from: protected */
    public boolean useLinearLayout() {
        return false;
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        NovaRecyclerView novaRecyclerView = this.f42559a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            novaRecyclerView = null;
        }
        return novaRecyclerView;
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        NovaRecyclerView novaRecyclerView = new NovaRecyclerView(getContext());
        novaRecyclerView.addItemDecoration(new SpaceItemDecoration());
        Unit unit = Unit.INSTANCE;
        this.f42559a = novaRecyclerView;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        NovaRecyclerView novaRecyclerView2 = this.f42559a;
        NovaRecyclerView novaRecyclerView3 = null;
        if (novaRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            novaRecyclerView2 = null;
        }
        novaRecyclerView2.setBackgroundColor(ResourceHelper.getColor(R.color.rf_color_gery_7_97_F5F5F7));
        NovaRecyclerView novaRecyclerView4 = this.f42559a;
        if (novaRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            novaRecyclerView3 = novaRecyclerView4;
        }
        viewGroup.addView(novaRecyclerView3, layoutParams);
        return viewGroup;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0011, code lost:
        r1 = r1.getBundle();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initItemBinders() {
        /*
            r5 = this;
            com.didi.app.nova.skeleton.mvp.IPresenter r0 = r5.getPresenter()
            com.didi.soda.home.component.category.Contract$AbsAllCategoryPresenter r0 = (com.didi.soda.home.component.category.Contract.AbsAllCategoryPresenter) r0
            com.didi.app.nova.skeleton.ScopeContext r1 = r5.getScopeContext()
            java.lang.String r2 = "PageName"
            r3 = 0
            if (r1 != 0) goto L_0x0011
        L_0x000f:
            r1 = r3
            goto L_0x001c
        L_0x0011:
            android.os.Bundle r1 = r1.getBundle()
            if (r1 != 0) goto L_0x0018
            goto L_0x000f
        L_0x0018:
            java.lang.String r1 = r1.getString(r2)
        L_0x001c:
            r0.setFromPage(r1)
            com.didi.app.nova.skeleton.mvp.IPresenter r0 = r5.getPresenter()
            com.didi.soda.home.component.category.Contract$AbsAllCategoryPresenter r0 = (com.didi.soda.home.component.category.Contract.AbsAllCategoryPresenter) r0
            java.lang.String r0 = r0.getFromPage()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0055
            com.didi.app.nova.skeleton.mvp.IPresenter r0 = r5.getPresenter()
            com.didi.soda.home.component.category.Contract$AbsAllCategoryPresenter r0 = (com.didi.soda.home.component.category.Contract.AbsAllCategoryPresenter) r0
            com.didi.app.nova.skeleton.ScopeContext r1 = r5.getScopeContext()
            if (r1 != 0) goto L_0x003e
            goto L_0x0052
        L_0x003e:
            android.os.Bundle r1 = r1.getBundle()
            if (r1 != 0) goto L_0x0045
            goto L_0x0052
        L_0x0045:
            java.lang.String r2 = r2.toLowerCase()
            java.lang.String r3 = "(this as java.lang.String).toLowerCase()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.String r3 = r1.getString(r2)
        L_0x0052:
            r0.setFromPage(r3)
        L_0x0055:
            com.didi.soda.home.binder.AllCategoryItemBinder r0 = new com.didi.soda.home.binder.AllCategoryItemBinder
            com.didi.app.nova.skeleton.ScopeContext r1 = r5.getScopeContext()
            java.lang.String r2 = "scopeContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.didi.app.nova.skeleton.mvp.IPresenter r2 = r5.getPresenter()
            com.didi.soda.home.component.category.Contract$AbsAllCategoryPresenter r2 = (com.didi.soda.home.component.category.Contract.AbsAllCategoryPresenter) r2
            int r2 = r2.getColumnCount()
            com.didi.app.nova.skeleton.mvp.IPresenter r3 = r5.getPresenter()
            com.didi.soda.home.component.category.Contract$AbsAllCategoryPresenter r3 = (com.didi.soda.home.component.category.Contract.AbsAllCategoryPresenter) r3
            com.didi.soda.customer.base.binder.ComponentLogicUnit r3 = r3.provideComponentLogicUnit()
            java.lang.String r4 = "presenter.provideComponentLogicUnit()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.<init>(r1, r2, r3)
            com.didi.app.nova.skeleton.mvp.IPresenter r1 = r5.getPresenter()
            com.didi.soda.home.component.category.Contract$AbsAllCategoryPresenter r1 = (com.didi.soda.home.component.category.Contract.AbsAllCategoryPresenter) r1
            java.lang.String r1 = r1.getFromPage()
            r0.setFromPage(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            com.didi.app.nova.support.view.recyclerview.binder.ItemBinder r0 = (com.didi.app.nova.support.view.recyclerview.binder.ItemBinder) r0
            r5.registerBinder(r0)
            com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalViewBinder r0 = new com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalViewBinder
            r0.<init>()
            com.didi.app.nova.support.view.recyclerview.binder.ItemBinder r0 = (com.didi.app.nova.support.view.recyclerview.binder.ItemBinder) r0
            r5.registerBinder(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.component.category.AllCategoryView.initItemBinders():void");
    }

    public void onCreate() {
        super.onCreate();
    }

    @Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/home/component/category/AllCategoryView$SpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AllCategoryView.kt */
    public static final class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(rect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(recyclerView, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            Resources resources = recyclerView.getContext().getResources();
            int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
            rect.bottom = (int) resources.getDimension(R.dimen.rf_dimen_2);
            rect.top = (int) resources.getDimension(R.dimen.rf_dimen_2);
            if (childLayoutPosition % 2 == 0) {
                rect.left = (int) resources.getDimension(R.dimen.rf_dimen_22);
                rect.right = (int) resources.getDimension(R.dimen.rf_dimen_0);
            } else {
                rect.right = (int) resources.getDimension(R.dimen.rf_dimen_22);
                rect.left = (int) resources.getDimension(R.dimen.rf_dimen_0);
            }
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            Intrinsics.checkNotNull(adapter);
            int itemCount = adapter.getItemCount();
            if (childLayoutPosition >= itemCount - 2) {
                if (itemCount % 2 == 0) {
                    rect.bottom = (int) resources.getDimension(R.dimen.rf_dimen_24);
                } else if (childLayoutPosition == itemCount - 1) {
                    rect.bottom = (int) resources.getDimension(R.dimen.rf_dimen_24);
                }
            }
            if (childLayoutPosition == 0 || childLayoutPosition == 1) {
                rect.top = (int) resources.getDimension(R.dimen.rf_dimen_14);
            }
        }
    }
}
