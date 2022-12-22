package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.foundation.util.CustomeRvExposeUtil;
import com.didi.soda.home.component.feed.adapter.HomeEfoListAdapter;
import com.didi.soda.home.topgun.binder.model.HomeEfoRvModel;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/HomeEfoListView;", "Lcom/didi/soda/home/topgun/widget/HorizontalRecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bindData", "", "homeEfoRvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeEfoRvModel;", "efoListener", "Lcom/didi/soda/home/component/feed/adapter/HomeEfoListAdapter$EfoListener;", "EfoItemDecoration", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeEfoListView.kt */
public final class HomeEfoListView extends HorizontalRecyclerView {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeEfoListView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeEfoListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeEfoListView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeEfoListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        setLayoutManager(linearLayoutManager);
        addItemDecoration(new EfoItemDecoration(this));
    }

    public final void bindData(HomeEfoRvModel homeEfoRvModel, HomeEfoListAdapter.EfoListener efoListener) {
        Intrinsics.checkNotNullParameter(homeEfoRvModel, "homeEfoRvModel");
        Intrinsics.checkNotNullParameter(efoListener, "efoListener");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setAdapter(new HomeEfoListAdapter(context, homeEfoRvModel, efoListener));
        new CustomeRvExposeUtil().setRecyclerItemExposeListener(this, new CustomeRvExposeUtil.OnItemExposeListener(efoListener) {
            public final /* synthetic */ HomeEfoListAdapter.EfoListener f$1;

            {
                this.f$1 = r2;
            }

            public final void onItemViewVisible(int i) {
                HomeEfoListView.m30509a(HomeEfoRvModel.this, this.f$1, i);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30509a(HomeEfoRvModel homeEfoRvModel, HomeEfoListAdapter.EfoListener efoListener, int i) {
        Intrinsics.checkNotNullParameter(homeEfoRvModel, "$homeEfoRvModel");
        Intrinsics.checkNotNullParameter(efoListener, "$efoListener");
        if (i < homeEfoRvModel.mEfoGoodsList.size()) {
            BusinessGoodsItemRvModel businessGoodsItemRvModel = homeEfoRvModel.mEfoGoodsList.get(i);
            Intrinsics.checkNotNullExpressionValue(businessGoodsItemRvModel, "homeEfoRvModel.mEfoGoodsList[it]");
            efoListener.onEfoItemExposured(i, businessGoodsItemRvModel);
        }
    }

    @Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/HomeEfoListView$EfoItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "(Lcom/didi/soda/home/topgun/widget/HomeEfoListView;)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeEfoListView.kt */
    public final class EfoItemDecoration extends RecyclerView.ItemDecoration {
        final /* synthetic */ HomeEfoListView this$0;

        public EfoItemDecoration(HomeEfoListView homeEfoListView) {
            Intrinsics.checkNotNullParameter(homeEfoListView, "this$0");
            this.this$0 = homeEfoListView;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(rect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(recyclerView, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.customer_9px);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                int viewAdapterPosition = ((RecyclerView.LayoutParams) layoutParams).getViewAdapterPosition();
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                Intrinsics.checkNotNull(adapter);
                if (viewAdapterPosition == adapter.getItemCount() - 1) {
                    int i = dimensionPixelOffset * 2;
                    rect.set(i, 0, i, 0);
                    return;
                }
                rect.set(dimensionPixelOffset * 2, 0, 0, 0);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        }
    }
}
