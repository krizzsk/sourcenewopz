package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.raven.config.RavenKey;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.home.topgun.binder.model.HomeEfoRvModel;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 D2\u00020\u0001:\u0001DB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010<\u001a\u00020=H&J\u000e\u0010>\u001a\u0002092\u0006\u0010<\u001a\u00020=J\u0010\u0010?\u001a\u00020;2\u0006\u0010\u0002\u001a\u00020\u0003H&J\b\u0010@\u001a\u00020\u0007H\u0014J\b\u0010A\u001a\u000209H\u0002J\u0018\u0010B\u001a\u0002092\u0006\u0010C\u001a\u00020;2\u0006\u0010<\u001a\u00020=H&R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0001X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR\u001a\u0010,\u001a\u00020\u0019X.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001b\"\u0004\b.\u0010\u001dR\u000e\u0010/\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u000203X.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006E"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/HomeSceneView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomPercent", "flTrapezoid", "Landroid/widget/FrameLayout;", "getFlTrapezoid", "()Landroid/widget/FrameLayout;", "setFlTrapezoid", "(Landroid/widget/FrameLayout;)V", "gradientColors", "", "mCountDownContainer", "Landroid/widget/LinearLayout;", "getMCountDownContainer", "()Landroid/widget/LinearLayout;", "setMCountDownContainer", "(Landroid/widget/LinearLayout;)V", "mCountDownDesc", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "getMCountDownDesc", "()Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "setMCountDownDesc", "(Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;)V", "mCountDownView", "Lcom/didi/soda/home/topgun/widget/CountDownView;", "getMCountDownView", "()Lcom/didi/soda/home/topgun/widget/CountDownView;", "setMCountDownView", "(Lcom/didi/soda/home/topgun/widget/CountDownView;)V", "mRootView", "getMRootView", "()Landroid/widget/RelativeLayout;", "setMRootView", "(Landroid/widget/RelativeLayout;)V", "mSceneContainer", "getMSceneContainer", "setMSceneContainer", "mSceneTitle", "getMSceneTitle", "setMSceneTitle", "rightColor", "roundRadius", "topPercent", "topRightLottieAnimationView", "Lcom/airbnb/lottie/LottieAnimationView;", "getTopRightLottieAnimationView", "()Lcom/airbnb/lottie/LottieAnimationView;", "setTopRightLottieAnimationView", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "bindContentView", "", "contentView", "Landroid/view/View;", "homeEfoRvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeEfoRvModel;", "bindData", "generateContentView", "getResId", "initView", "onTitleClicked", "v", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeSceneView.kt */
public abstract class HomeSceneView extends RelativeLayout {
    private static final int BOTTOM_PERCENT = 50;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int TOP_PERCENT = 25;
    /* access modifiers changed from: private */
    public int bottomPercent;
    public FrameLayout flTrapezoid;
    private int[] gradientColors;
    public LinearLayout mCountDownContainer;
    public CustomerAppCompatTextView mCountDownDesc;
    public CountDownView mCountDownView;
    public RelativeLayout mRootView;
    public FrameLayout mSceneContainer;
    public CustomerAppCompatTextView mSceneTitle;
    /* access modifiers changed from: private */
    public int rightColor;
    /* access modifiers changed from: private */
    public int roundRadius;
    /* access modifiers changed from: private */
    public int topPercent;
    public LottieAnimationView topRightLottieAnimationView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeSceneView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeSceneView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    public abstract void bindContentView(View view, Context context, HomeEfoRvModel homeEfoRvModel);

    public abstract View generateContentView(Context context);

    /* access modifiers changed from: protected */
    public int getResId() {
        return R.layout.customer_binder_home_sence;
    }

    public abstract void onTitleClicked(View view, HomeEfoRvModel homeEfoRvModel);

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeSceneView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeSceneView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.topPercent = 25;
        this.bottomPercent = 50;
        this.gradientColors = new int[0];
        this.roundRadius = ResourceHelper.getDimensionPixelSize(R.dimen.customer_12px);
        initView();
    }

    public final FrameLayout getFlTrapezoid() {
        FrameLayout frameLayout = this.flTrapezoid;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("flTrapezoid");
        return null;
    }

    public final void setFlTrapezoid(FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.flTrapezoid = frameLayout;
    }

    public final LottieAnimationView getTopRightLottieAnimationView() {
        LottieAnimationView lottieAnimationView = this.topRightLottieAnimationView;
        if (lottieAnimationView != null) {
            return lottieAnimationView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("topRightLottieAnimationView");
        return null;
    }

    public final void setTopRightLottieAnimationView(LottieAnimationView lottieAnimationView) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "<set-?>");
        this.topRightLottieAnimationView = lottieAnimationView;
    }

    public final CustomerAppCompatTextView getMSceneTitle() {
        CustomerAppCompatTextView customerAppCompatTextView = this.mSceneTitle;
        if (customerAppCompatTextView != null) {
            return customerAppCompatTextView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSceneTitle");
        return null;
    }

    public final void setMSceneTitle(CustomerAppCompatTextView customerAppCompatTextView) {
        Intrinsics.checkNotNullParameter(customerAppCompatTextView, "<set-?>");
        this.mSceneTitle = customerAppCompatTextView;
    }

    public final FrameLayout getMSceneContainer() {
        FrameLayout frameLayout = this.mSceneContainer;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSceneContainer");
        return null;
    }

    public final void setMSceneContainer(FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.mSceneContainer = frameLayout;
    }

    public final RelativeLayout getMRootView() {
        RelativeLayout relativeLayout = this.mRootView;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    }

    public final void setMRootView(RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.mRootView = relativeLayout;
    }

    public final LinearLayout getMCountDownContainer() {
        LinearLayout linearLayout = this.mCountDownContainer;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mCountDownContainer");
        return null;
    }

    public final void setMCountDownContainer(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.mCountDownContainer = linearLayout;
    }

    public final CustomerAppCompatTextView getMCountDownDesc() {
        CustomerAppCompatTextView customerAppCompatTextView = this.mCountDownDesc;
        if (customerAppCompatTextView != null) {
            return customerAppCompatTextView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mCountDownDesc");
        return null;
    }

    public final void setMCountDownDesc(CustomerAppCompatTextView customerAppCompatTextView) {
        Intrinsics.checkNotNullParameter(customerAppCompatTextView, "<set-?>");
        this.mCountDownDesc = customerAppCompatTextView;
    }

    public final CountDownView getMCountDownView() {
        CountDownView countDownView = this.mCountDownView;
        if (countDownView != null) {
            return countDownView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mCountDownView");
        return null;
    }

    public final void setMCountDownView(CountDownView countDownView) {
        Intrinsics.checkNotNullParameter(countDownView, "<set-?>");
        this.mCountDownView = countDownView;
    }

    private final void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(getResId(), this, true);
        View findViewById = inflate.findViewById(R.id.customer_fl_home_trapezoid);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_fl_home_trapezoid)");
        setFlTrapezoid((FrameLayout) findViewById);
        View findViewById2 = inflate.findViewById(R.id.customer_la_home_sence_animator);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_la_home_sence_animator)");
        setTopRightLottieAnimationView((LottieAnimationView) findViewById2);
        View findViewById3 = inflate.findViewById(R.id.customer_tv_home_sence_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_tv_home_sence_title)");
        setMSceneTitle((CustomerAppCompatTextView) findViewById3);
        View findViewById4 = inflate.findViewById(R.id.customer_fl__home_sence_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.custom…fl__home_sence_container)");
        setMSceneContainer((FrameLayout) findViewById4);
        FrameLayout mSceneContainer2 = getMSceneContainer();
        Context context = inflate.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        mSceneContainer2.addView(generateContentView(context));
        View findViewById5 = inflate.findViewById(R.id.customer_rl_home_sence_root);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.customer_rl_home_sence_root)");
        setMRootView((RelativeLayout) findViewById5);
        View findViewById6 = inflate.findViewById(R.id.customer_ll_home_sence_countdown);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.custom…_ll_home_sence_countdown)");
        setMCountDownContainer((LinearLayout) findViewById6);
        View findViewById7 = inflate.findViewById(R.id.customer_tv_home_sence_countdown_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.custom…ome_sence_countdown_desc)");
        setMCountDownDesc((CustomerAppCompatTextView) findViewById7);
        View findViewById8 = inflate.findViewById(R.id.customer_custom_home_sence_countdown);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.custom…tom_home_sence_countdown)");
        setMCountDownView((CountDownView) findViewById8);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindData$lambda-1  reason: not valid java name */
    public static final void m46997bindData$lambda1(HomeSceneView homeSceneView, HomeEfoRvModel homeEfoRvModel, View view) {
        Intrinsics.checkNotNullParameter(homeSceneView, "this$0");
        Intrinsics.checkNotNullParameter(homeEfoRvModel, "$homeEfoRvModel");
        Intrinsics.checkNotNullExpressionValue(view, RavenKey.VERSION);
        homeSceneView.onTitleClicked(view, homeEfoRvModel);
    }

    public final void bindData(HomeEfoRvModel homeEfoRvModel) {
        Unit unit;
        int i;
        int[] iArr;
        Intrinsics.checkNotNullParameter(homeEfoRvModel, "homeEfoRvModel");
        getMSceneTitle().setOnClickListener(new View.OnClickListener(homeEfoRvModel) {
            public final /* synthetic */ HomeEfoRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                HomeSceneView.m46997bindData$lambda1(HomeSceneView.this, this.f$1, view);
            }
        });
        if (homeEfoRvModel.mBgcolor == null || homeEfoRvModel.mBgcolor.size() <= 1) {
            this.gradientColors = new int[]{ResourceHelper.getColor(R.color.rf_color_jianbian_2), ResourceHelper.getColor(R.color.rf_color_jianbian_2)};
        } else {
            try {
                iArr = new int[]{Color.parseColor(homeEfoRvModel.mBgcolor.get(0)), Color.parseColor(homeEfoRvModel.mBgcolor.get(1))};
            } catch (Exception unused) {
                iArr = new int[]{ResourceHelper.getColor(R.color.rf_color_jianbian_2), ResourceHelper.getColor(R.color.rf_color_jianbian_2)};
            }
            this.gradientColors = iArr;
        }
        String str = homeEfoRvModel.mBevelColor;
        if (str == null) {
            unit = null;
        } else {
            try {
                i = Color.parseColor(str);
            } catch (Exception unused2) {
                i = ResourceHelper.getColor(R.color.rf_color_jianbian_2);
            }
            this.rightColor = i;
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.rightColor = ResourceHelper.getColor(R.color.rf_color_jianbian_2);
        }
        CustomerAppCompatTextView mSceneTitle2 = getMSceneTitle();
        CharSequence charSequence = homeEfoRvModel.mTitle;
        if (charSequence == null) {
        }
        mSceneTitle2.setText(charSequence);
        if (homeEfoRvModel.mCountDownSecond <= 0 || TextUtils.isEmpty(homeEfoRvModel.mCountDownDesc)) {
            getMCountDownView().cancel();
            getMCountDownContainer().setVisibility(8);
        } else {
            getMCountDownView().cancel();
            getMCountDownView().setTimeoutCallBack(HomeSceneView$bindData$4.INSTANCE);
            getMCountDownView().start(((((long) homeEfoRvModel.mCountDownSecond) * 1000) + homeEfoRvModel.mSourceSysTime) - System.currentTimeMillis());
            getMCountDownDesc().setText(homeEfoRvModel.mCountDownDesc);
            getMCountDownContainer().setVisibility(0);
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, this.gradientColors);
        gradientDrawable.setCornerRadius((float) this.roundRadius);
        gradientDrawable.setGradientType(0);
        getMRootView().setBackground(gradientDrawable);
        if (getMSceneContainer().getChildCount() > 0) {
            View childAt = getMSceneContainer().getChildAt(0);
            Intrinsics.checkNotNullExpressionValue(childAt, "mSceneContainer.getChildAt(0)");
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            bindContentView(childAt, context, homeEfoRvModel);
        }
        getViewTreeObserver().addOnPreDrawListener(new HomeSceneView$bindData$5(this));
        if (!homeEfoRvModel.mHasLoadAnimate) {
            getTopRightLottieAnimationView().playAnimation();
            homeEfoRvModel.mHasLoadAnimate = true;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/HomeSceneView$Companion;", "", "()V", "BOTTOM_PERCENT", "", "TOP_PERCENT", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeSceneView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
