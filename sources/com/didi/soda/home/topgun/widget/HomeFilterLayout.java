package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.ExtentionsKt;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.extra.CustomerShadowConstraintLayout;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.home.topgun.component.filter.FilterDataManagerScene;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.home.topgun.manager.ShopCateLandingOmegaHelper;
import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.home.topgun.widget.HomeFilterLayout;
import com.didi.soda.search.helper.SearchNewOmegaHelper;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001/B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ*\u0010\"\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\r2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010%2\b\b\u0001\u0010&\u001a\u00020\u0007J \u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u001cH\u0002J\u0006\u0010*\u001a\u00020+JW\u0010,\u001a\u00020 2O\u0010-\u001aK\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 0\u0018j\u0002`!J\u0012\u0010.\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\rH\u0002R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R[\u0010\u0017\u001aO\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u0018j\u0004\u0018\u0001`!X\u000e¢\u0006\u0002\n\u0000¨\u00060"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/HomeFilterLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "filterAdapter", "Lcom/didi/soda/home/topgun/widget/HomeFilterLayout$FilterListAdapter;", "filters", "", "Lcom/didi/soda/home/topgun/model/FilterModel;", "mFromScene", "getMFromScene$annotations", "()V", "onBindListener", "Lcom/didi/soda/home/topgun/widget/BindViewHolderCallBack;", "getOnBindListener", "()Lcom/didi/soda/home/topgun/widget/BindViewHolderCallBack;", "setOnBindListener", "(Lcom/didi/soda/home/topgun/widget/BindViewHolderCallBack;)V", "onItemListener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "filterModel", "Landroid/view/View;", "item", "", "isReset", "", "Lcom/didi/soda/home/topgun/widget/OnFilterItemListener;", "bindData", "mainFilter", "list", "", "scene", "clickFilterItem", "pos", "view", "getRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "setFilterClickListener", "listener", "updateMainFilter", "FilterListAdapter", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeFilterLayout.kt */
public final class HomeFilterLayout extends ConstraintLayout {

    /* renamed from: a */
    private final FilterListAdapter f43124a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<FilterModel> f43125b;

    /* renamed from: c */
    private Function3<? super FilterModel, ? super View, ? super Boolean, Unit> f43126c;

    /* renamed from: d */
    private BindViewHolderCallBack f43127d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f43128e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeFilterLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeFilterLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @FilterDataManagerScene
    private static /* synthetic */ void getMFromScene$annotations() {
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeFilterLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFilterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f43125b = new ArrayList();
        this.f43128e = 1;
        LayoutInflater.from(context).inflate(R.layout.customer_home_filter_layout, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        ((RecyclerView) findViewById(R.id.customer_home_filter_rv)).setLayoutManager(linearLayoutManager);
        ((RecyclerView) findViewById(R.id.customer_home_filter_rv)).addItemDecoration(new C14063d());
        this.f43124a = new FilterListAdapter(this);
        ((RecyclerView) findViewById(R.id.customer_home_filter_rv)).setAdapter(this.f43124a);
        ((RecyclerView) findViewById(R.id.customer_home_filter_rv)).addOnScrollListener(new RecyclerView.OnScrollListener(this) {
            final /* synthetic */ HomeFilterLayout this$0;

            {
                this.this$0 = r1;
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, i, i2);
                this.this$0.findViewById(R.id.customer_home_filter_left_mask).setVisibility(recyclerView.canScrollHorizontally(-1) ? 0 : 8);
            }
        });
    }

    public final BindViewHolderCallBack getOnBindListener() {
        return this.f43127d;
    }

    public final void setOnBindListener(BindViewHolderCallBack bindViewHolderCallBack) {
        this.f43127d = bindViewHolderCallBack;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m30514a(int i, FilterModel filterModel, View view) {
        boolean z;
        boolean z2 = true;
        boolean z3 = filterModel.mShowType == 6;
        Function3<? super FilterModel, ? super View, ? super Boolean, Unit> function3 = this.f43126c;
        if (function3 != null) {
            function3.invoke(filterModel, view, Boolean.valueOf(z3));
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.customer_home_filter_rv);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (z3) {
            post(new Runnable() {
                public final void run() {
                    HomeFilterLayout.m30515a(RecyclerView.this);
                }
            });
            return;
        }
        if (linearLayoutManager != null && i == linearLayoutManager.findFirstVisibleItemPosition()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Rect rect = new Rect();
            view.getLocalVisibleRect(rect);
            recyclerView.smoothScrollBy(-(view.getWidth() - rect.width()), 0);
            return;
        }
        if (linearLayoutManager == null || i != linearLayoutManager.findLastVisibleItemPosition()) {
            z2 = false;
        }
        if (z2) {
            Rect rect2 = new Rect();
            view.getLocalVisibleRect(rect2);
            recyclerView.smoothScrollBy(view.getWidth() - rect2.width(), 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30515a(RecyclerView recyclerView) {
        recyclerView.smoothScrollToPosition(0);
    }

    public final RecyclerView getRecycleView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.customer_home_filter_rv);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "customer_home_filter_rv");
        return recyclerView;
    }

    public final void bindData(FilterModel filterModel, List<? extends FilterModel> list, @FilterDataManagerScene int i) {
        this.f43128e = i;
        if (!(list == null || list.isEmpty()) || filterModel != null) {
            setVisibility(0);
            m30516a(filterModel);
            this.f43125b.clear();
            if (list != null) {
                this.f43125b.addAll(list);
            }
            this.f43124a.notifyDataSetChanged();
            return;
        }
        setVisibility(8);
    }

    /* renamed from: a */
    private final void m30516a(FilterModel filterModel) {
        int i = 8;
        if (filterModel == null) {
            ((CustomerShadowConstraintLayout) findViewById(R.id.customer_home_filter_all_icon_shadow)).setVisibility(8);
            LogUtil.m29100d("fff", ((RecyclerView) findViewById(R.id.customer_home_filter_rv)).getLayoutParams().getClass().getName());
            if (((RecyclerView) findViewById(R.id.customer_home_filter_rv)).getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                ViewGroup.LayoutParams layoutParams = ((RecyclerView) findViewById(R.id.customer_home_filter_rv)).getLayoutParams();
                if (layoutParams != null) {
                    ((ConstraintLayout.LayoutParams) layoutParams).leftMargin = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_14);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            return;
        }
        ((CustomerShadowConstraintLayout) findViewById(R.id.customer_home_filter_all_icon_shadow)).setVisibility(0);
        if (((RecyclerView) findViewById(R.id.customer_home_filter_rv)).getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams2 = ((RecyclerView) findViewById(R.id.customer_home_filter_rv)).getLayoutParams();
            if (layoutParams2 != null) {
                ((ConstraintLayout.LayoutParams) layoutParams2).leftMargin = 0;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
        }
        if (filterModel.mHeadLineLight) {
            FlyImageLoader.loadImage1x1(getContext(), filterModel.mSelectedImage).fitCenter().placeholder((int) R.drawable.customer_filter_all_default_select_icon).error((int) R.drawable.customer_filter_all_default_select_icon).dontAnimate().into((ImageView) findViewById(R.id.customer_home_filter_all_icon));
        } else {
            FlyImageLoader.loadImage1x1(getContext(), filterModel.mImage).placeholder((int) R.drawable.customer_filter_all_default_icon).error((int) R.drawable.customer_filter_all_default_icon).fitCenter().dontAnimate().into((ImageView) findViewById(R.id.customer_home_filter_all_icon));
        }
        ((CustomerAppCompatTextView) findViewById(R.id.customer_home_filter_all_num)).setText(String.valueOf(filterModel.mNeedShowNum));
        CustomerAppCompatTextView customerAppCompatTextView = (CustomerAppCompatTextView) findViewById(R.id.customer_home_filter_all_num);
        if (filterModel.mNeedShowNum != 0) {
            i = 0;
        }
        customerAppCompatTextView.setVisibility(i);
        ((LinearLayout) findViewById(R.id.customer_home_filter_all_layout)).setOnClickListener(new View.OnClickListener(filterModel) {
            public final /* synthetic */ FilterModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                HomeFilterLayout.m30517a(HomeFilterLayout.this, this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30517a(HomeFilterLayout homeFilterLayout, FilterModel filterModel, View view) {
        Intrinsics.checkNotNullParameter(homeFilterLayout, "this$0");
        Function3<? super FilterModel, ? super View, ? super Boolean, Unit> function3 = homeFilterLayout.f43126c;
        if (function3 != null) {
            Intrinsics.checkNotNullExpressionValue(view, "it");
            function3.invoke(filterModel, view, false);
        }
    }

    public final void setFilterClickListener(Function3<? super FilterModel, ? super View, ? super Boolean, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "listener");
        this.f43126c = function3;
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/HomeFilterLayout$FilterListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didi/soda/home/topgun/widget/FilterListHolder;", "(Lcom/didi/soda/home/topgun/widget/HomeFilterLayout;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeFilterLayout.kt */
    private final class FilterListAdapter extends RecyclerView.Adapter<FilterListHolder> {
        final /* synthetic */ HomeFilterLayout this$0;

        public FilterListAdapter(HomeFilterLayout homeFilterLayout) {
            Intrinsics.checkNotNullParameter(homeFilterLayout, "this$0");
            this.this$0 = homeFilterLayout;
        }

        public FilterListHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            if (i == 6) {
                return new C14061b(viewGroup, R.layout.customer_home_filter_reset_item_shadow);
            }
            return new C14060a(viewGroup, R.layout.customer_home_filter_layout_item_shadow);
        }

        public void onBindViewHolder(FilterListHolder filterListHolder, int i) {
            Intrinsics.checkNotNullParameter(filterListHolder, "holder");
            FilterModel filterModel = (FilterModel) this.this$0.f43125b.get(i);
            filterListHolder.bindData(filterModel);
            filterListHolder.itemView.setOnClickListener(new View.OnClickListener(i, filterModel) {
                public final /* synthetic */ int f$1;
                public final /* synthetic */ FilterModel f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    HomeFilterLayout.FilterListAdapter.m46996onBindViewHolder$lambda0(HomeFilterLayout.this, this.f$1, this.f$2, view);
                }
            });
            if (filterModel.mShowType == 6) {
                HomeOmegaHelper.getInstance().traceFilterResetSW(String.valueOf(i));
            } else if (1 == this.this$0.f43128e) {
                HomeOmegaHelper.getInstance().headerFilterSw(filterModel.mResourceId, filterModel.getTrackTitle(), String.valueOf(i));
            } else if (3 == this.this$0.f43128e) {
                SearchNewOmegaHelper.getInstance().headerFilterSw(filterModel.mResourceId, filterModel.getTrackTitle(), String.valueOf(i));
            } else if (4 == this.this$0.f43128e) {
                filterModel.position = i;
                BindViewHolderCallBack onBindListener = this.this$0.getOnBindListener();
                if (onBindListener != null) {
                    onBindListener.onbind(filterModel, i);
                }
            } else {
                ShopCateLandingOmegaHelper.getInstance().headerFilterSw(filterModel.mResourceId, filterModel.getTrackTitle(), String.valueOf(i));
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
        public static final void m46996onBindViewHolder$lambda0(HomeFilterLayout homeFilterLayout, int i, FilterModel filterModel, View view) {
            Intrinsics.checkNotNullParameter(homeFilterLayout, "this$0");
            Intrinsics.checkNotNullParameter(filterModel, "$filterModel");
            Intrinsics.checkNotNullExpressionValue(view, "it");
            homeFilterLayout.m30514a(i, filterModel, view);
        }

        public int getItemViewType(int i) {
            return ExtentionsKt.orZero(Integer.valueOf(((FilterModel) this.this$0.f43125b.get(i)).mShowType));
        }

        public int getItemCount() {
            return this.this$0.f43125b.size();
        }
    }
}
