package com.didi.soda.home.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.ViewSafeHelper;
import com.didi.soda.home.shimmer.ShimmerRecyclerView;
import com.didi.soda.home.shimmer.ShimmerViewType;
import com.didi.soda.home.topgun.widget.floatlayout.IStickHolder;
import com.didi.soda.home.topgun.widget.floatlayout.OnStickListener;
import com.didi.soda.home.topgun.widget.floatlayout.StickItemImp;
import com.taxis99.R;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001$B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000b\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u0007J\u0006\u0010\u001d\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u0019J\u0006\u0010\u001f\u001a\u00020\u0019J\u0006\u0010 \u001a\u00020\u0019J\u0010\u0010!\u001a\u00020\u00192\b\b\u0002\u0010\"\u001a\u00020#R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, mo175978d2 = {"Lcom/didi/soda/home/widget/LandingFloatLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "acceptScroll", "", "itemFloatContainer", "itemFloatContainerShadow", "Landroid/view/View;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "shimmerContainer", "shimmerView", "Lcom/didi/soda/home/shimmer/ShimmerRecyclerView;", "stickItemImp", "Lcom/didi/soda/home/topgun/widget/floatlayout/StickItemImp;", "getStickItemImp", "()Lcom/didi/soda/home/topgun/widget/floatlayout/StickItemImp;", "", "attachRecycleView", "banAcceptScroll", "getAnchorOffsetDistance", "getIntoFloatDistance", "hideShimmer", "intoFloating", "notifyScroll", "showShimmer", "type", "Lcom/didi/soda/home/shimmer/ShimmerViewType;", "SimpleOnStickListener", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LandingFloatView.kt */
public final class LandingFloatLayout extends FrameLayout {

    /* renamed from: a */
    private final String f43306a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public FrameLayout f43307b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f43308c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FrameLayout f43309d;

    /* renamed from: e */
    private ShimmerRecyclerView f43310e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public RecyclerView f43311f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f43312g;

    /* renamed from: h */
    private final StickItemImp f43313h;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LandingFloatLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LandingFloatLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LandingFloatLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LandingFloatLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f43306a = "FloatLayout";
        this.f43312g = true;
        LayoutInflater.from(context).inflate(R.layout.customer_component_labding_float_layout, this);
        View findViewById = findViewById(R.id.customer_ll_landing_binder_float);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.custom…_ll_landing_binder_float)");
        this.f43307b = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.customer_fl_landing_filter_shimmer_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.custom…filter_shimmer_container)");
        this.f43309d = (FrameLayout) findViewById2;
        View findViewById3 = findViewById(R.id.customer_ll_landing_float_shadow_view);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.custom…anding_float_shadow_view)");
        this.f43308c = findViewById3;
        StickItemImp stickItemImp = new StickItemImp();
        stickItemImp.setListener(new SimpleOnStickListener(this));
        stickItemImp.setGetStickLayoutHeight(LandingFloatLayout$stickItemImp$1$1.INSTANCE);
        Unit unit = Unit.INSTANCE;
        this.f43313h = stickItemImp;
    }

    public final StickItemImp getStickItemImp() {
        return this.f43313h;
    }

    public final void acceptScroll() {
        this.f43312g = true;
    }

    public final void banAcceptScroll() {
        this.f43312g = false;
    }

    public final int getIntoFloatDistance() {
        return this.f43313h.getIntoStickDistance(this.f43311f);
    }

    public final int getAnchorOffsetDistance() {
        int height = this.f43307b.getHeight();
        if (height <= 0) {
            height = DisplayUtils.dip2px(getContext(), 60.0f);
        }
        int px = height + CustomerExtentionKt.getPx(R.dimen.customer_home_filter_minus_margin);
        LogUtil.m29100d("TAG", Intrinsics.stringPlus(" >>>> filterH = ", Integer.valueOf(px)));
        return px;
    }

    public final void notifyScroll() {
        StickItemImp stickItemImp = this.f43313h;
        RecyclerView recyclerView = this.f43311f;
        Intrinsics.checkNotNull(recyclerView);
        stickItemImp.onRecycleScrolled(recyclerView);
        post(new Runnable() {
            public final void run() {
                LandingFloatLayout.m30628a(LandingFloatLayout.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30628a(LandingFloatLayout landingFloatLayout) {
        Intrinsics.checkNotNullParameter(landingFloatLayout, "this$0");
        landingFloatLayout.getStickItemImp().requestLayout();
    }

    public static /* synthetic */ void showShimmer$default(LandingFloatLayout landingFloatLayout, ShimmerViewType shimmerViewType, int i, Object obj) {
        if ((i & 1) != 0) {
            shimmerViewType = ShimmerViewType.SHOP_LAND;
        }
        landingFloatLayout.showShimmer(shimmerViewType);
    }

    public final void showShimmer(ShimmerViewType shimmerViewType) {
        Intrinsics.checkNotNullParameter(shimmerViewType, "type");
        post(new Runnable(shimmerViewType) {
            public final /* synthetic */ ShimmerViewType f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                LandingFloatLayout.m30629a(LandingFloatLayout.this, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30629a(LandingFloatLayout landingFloatLayout, ShimmerViewType shimmerViewType) {
        Intrinsics.checkNotNullParameter(landingFloatLayout, "this$0");
        Intrinsics.checkNotNullParameter(shimmerViewType, "$type");
        if (landingFloatLayout.f43310e == null) {
            landingFloatLayout.f43310e = new ShimmerRecyclerView(landingFloatLayout.getContext());
            landingFloatLayout.f43309d.addView(landingFloatLayout.f43310e, new FrameLayout.LayoutParams(-1, -1));
        }
        if (landingFloatLayout.f43309d.getVisibility() == 8) {
            landingFloatLayout.f43309d.setVisibility(0);
            ShimmerRecyclerView shimmerRecyclerView = landingFloatLayout.f43310e;
            if (shimmerRecyclerView != null) {
                shimmerRecyclerView.startShimmerAnimator(shimmerViewType);
            }
        }
    }

    public final void hideShimmer() {
        ShimmerRecyclerView shimmerRecyclerView;
        if (this.f43310e != null && this.f43309d.getVisibility() == 0 && (shimmerRecyclerView = this.f43310e) != null) {
            shimmerRecyclerView.stopShimmerAnimator(new LandingFloatLayout$hideShimmer$1(this));
        }
    }

    public final void intoFloating() {
        RecyclerView.LayoutManager layoutManager;
        Integer invoke;
        RecyclerView recyclerView = this.f43311f;
        if (recyclerView != null) {
            if (recyclerView == null) {
                layoutManager = null;
            } else {
                layoutManager = recyclerView.getLayoutManager();
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager != null) {
                Iterator it = new IntRange(linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition()).iterator();
                int i = 0;
                RecyclerView.ViewHolder viewHolder = null;
                int i2 = 0;
                while (it.hasNext()) {
                    int nextInt = ((IntIterator) it).nextInt();
                    RecyclerView recyclerView2 = this.f43311f;
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView2 == null ? null : recyclerView2.findViewHolderForAdapterPosition(nextInt);
                    if (findViewHolderForAdapterPosition instanceof IStickHolder) {
                        i2 = nextInt;
                        viewHolder = findViewHolderForAdapterPosition;
                    }
                }
                if (((IStickHolder) viewHolder) != null) {
                    Function0<Integer> getStickLayoutHeight = getStickItemImp().getGetStickLayoutHeight();
                    if (!(getStickLayoutHeight == null || (invoke = getStickLayoutHeight.invoke()) == null)) {
                        i = invoke.intValue();
                    }
                    linearLayoutManager.scrollToPositionWithOffset(i2, i);
                    RecyclerView recyclerView3 = this.f43311f;
                    Intrinsics.checkNotNull(recyclerView3);
                    recyclerView3.addOnLayoutChangeListener(new LandingFloatLayout$intoFloating$2$1(this));
                }
            }
        }
    }

    public final void attachRecycleView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.f43311f = recyclerView;
        recyclerView.addOnScrollListener(new LandingFloatLayout$attachRecycleView$1(this));
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.registerAdapterDataObserver(new LandingFloatLayout$attachRecycleView$2(this));
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/home/widget/LandingFloatLayout$SimpleOnStickListener;", "Lcom/didi/soda/home/topgun/widget/floatlayout/OnStickListener;", "(Lcom/didi/soda/home/widget/LandingFloatLayout;)V", "onStickEvent", "", "stickView", "Landroid/view/View;", "isStick", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LandingFloatView.kt */
    public final class SimpleOnStickListener implements OnStickListener {
        final /* synthetic */ LandingFloatLayout this$0;

        public SimpleOnStickListener(LandingFloatLayout landingFloatLayout) {
            Intrinsics.checkNotNullParameter(landingFloatLayout, "this$0");
            this.this$0 = landingFloatLayout;
        }

        public void onStickEvent(View view, boolean z) {
            Intrinsics.checkNotNullParameter(view, "stickView");
            if (z) {
                this.this$0.f43307b.setVisibility(0);
                if (!Intrinsics.areEqual((Object) view.getParent(), (Object) this.this$0.f43307b)) {
                    ViewSafeHelper.safeAddView(this.this$0.f43307b, view);
                }
                this.this$0.f43308c.setVisibility(0);
                return;
            }
            this.this$0.f43307b.setVisibility(8);
            if (Intrinsics.areEqual((Object) view.getParent(), (Object) this.this$0.f43307b)) {
                ViewSafeHelper.safeRemoveView(this.this$0.f43307b, view);
            }
            this.this$0.f43308c.setVisibility(8);
        }
    }
}
