package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.soda.blocks.scope.BlockScopeBase;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.blocks.widget.ScrollWidget;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.ActionInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.ButtonInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.home.topgun.binder.HomeTopicBinder;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.didi.soda.home.topgun.binder.model.HomeTopicRvModel;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.taxis99.R;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J.\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020\tJ\u001e\u00101\u001a\u00020#2\u0006\u0010)\u001a\u00020*2\u0006\u00102\u001a\u0002032\u0006\u0010/\u001a\u00020'R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000¨\u00064"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/HomeTopicView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "logic", "Lcom/didi/soda/home/topgun/binder/HomeTopicBinder$Companion$Logic;", "getLogic", "()Lcom/didi/soda/home/topgun/binder/HomeTopicBinder$Companion$Logic;", "setLogic", "(Lcom/didi/soda/home/topgun/binder/HomeTopicBinder$Companion$Logic;)V", "mBgLogo", "Landroid/widget/ImageView;", "mBgView", "mCardContainer", "Lcom/didi/soda/customer/blocks/widget/ScrollWidget;", "mCountDownView", "Lcom/didi/soda/home/topgun/widget/TopicCountDownView;", "mDescView", "Landroid/widget/TextView;", "mMoreArrow", "mRootView", "Landroid/view/View;", "mSceneTitle", "mTopLayout", "topRightImgView", "topRightLottieAnimationView", "Lcom/airbnb/lottie/LottieAnimationView;", "bindData", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "model", "Lcom/didi/soda/home/topgun/binder/model/HomeTopicRvModel;", "onGoodItemClick", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "isBtn", "", "good", "Lcom/didi/soda/business/model/BusinessGoodsItemRvModel;", "topic", "orderWay", "onShopItemClick", "shop", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeTopicView.kt */
public final class HomeTopicView extends RelativeLayout {

    /* renamed from: a */
    private LottieAnimationView f43171a;

    /* renamed from: b */
    private ImageView f43172b;

    /* renamed from: c */
    private TextView f43173c;

    /* renamed from: d */
    private ScrollWidget f43174d;

    /* renamed from: e */
    private View f43175e;

    /* renamed from: f */
    private TextView f43176f;

    /* renamed from: g */
    private TopicCountDownView f43177g;

    /* renamed from: h */
    private View f43178h;

    /* renamed from: i */
    private TextView f43179i;

    /* renamed from: j */
    private ImageView f43180j;

    /* renamed from: k */
    private ImageView f43181k;

    /* renamed from: l */
    private HomeTopicBinder.Companion.Logic f43182l;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30533a(View view) {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m30537b(View view) {
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeTopicView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeTopicView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeTopicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_binder_home_topic, this, true);
        View findViewById = inflate.findViewById(R.id.customer_tv_home_sence_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_tv_home_sence_title)");
        this.f43173c = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_fl__home_sence_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.custom…fl__home_sence_container)");
        ScrollWidget scrollWidget = (ScrollWidget) findViewById2;
        this.f43174d = scrollWidget;
        scrollWidget.getContentView().setPadding(CustomerExtentionKt.getPx(R.dimen.customer_25px), 0, CustomerExtentionKt.getPx(R.dimen.customer_25px), 0);
        View findViewById3 = inflate.findViewById(R.id.customer_la_home_sence_animator);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_la_home_sence_animator)");
        this.f43171a = (LottieAnimationView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.customer_tv_home_sence_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.customer_tv_home_sence_desc)");
        this.f43176f = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.customer_rl_home_sence_root);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.customer_rl_home_sence_root)");
        this.f43175e = findViewById5;
        View findViewById6 = inflate.findViewById(R.id.customer_rl_home_topic_bg);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.customer_rl_home_topic_bg)");
        this.f43180j = (ImageView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.customer_custom_home_sence_countdown);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.custom…tom_home_sence_countdown)");
        this.f43177g = (TopicCountDownView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.customer_custom_home_sence_top_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.custom…om_home_sence_top_layout)");
        this.f43178h = findViewById8;
        View findViewById9 = inflate.findViewById(R.id.customer_tv_title_more);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.customer_tv_title_more)");
        this.f43179i = (TextView) findViewById9;
        View findViewById10 = inflate.findViewById(R.id.customer_home_topic_rt_img);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.customer_home_topic_rt_img)");
        this.f43172b = (ImageView) findViewById10;
        View findViewById11 = inflate.findViewById(R.id.customer_rl_home_topic_logo);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.customer_rl_home_topic_logo)");
        this.f43181k = (ImageView) findViewById11;
    }

    public final HomeTopicBinder.Companion.Logic getLogic() {
        return this.f43182l;
    }

    public final void setLogic(HomeTopicBinder.Companion.Logic logic) {
        this.f43182l = logic;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0027, code lost:
        r1 = r1.title;
     */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02f7  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0342  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x038a A[LOOP:4: B:170:0x0384->B:172:0x038a, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bindData(com.didi.app.nova.skeleton.ScopeContext r20, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            java.lang.String r3 = "scopeContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "model"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            com.didi.soda.blocks.scope.BlockScopeBase r3 = new com.didi.soda.blocks.scope.BlockScopeBase
            r3.<init>()
            java.lang.String r4 = "scope_context"
            r3.attach(r4, r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r1 = r21.getData()
            r4 = 0
            if (r1 != 0) goto L_0x0027
        L_0x0025:
            r1 = r4
            goto L_0x002e
        L_0x0027:
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity$TitleBean r1 = r1.title
            if (r1 != 0) goto L_0x002c
            goto L_0x0025
        L_0x002c:
            java.lang.String r1 = r1.content
        L_0x002e:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r5 = 1
            r6 = 0
            if (r1 == 0) goto L_0x003d
            int r1 = r1.length()
            if (r1 != 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r1 = 0
            goto L_0x003e
        L_0x003d:
            r1 = 1
        L_0x003e:
            r7 = 2
            r8 = 8
            if (r1 == 0) goto L_0x004a
            android.view.View r1 = r0.f43178h
            r1.setVisibility(r8)
            goto L_0x015c
        L_0x004a:
            android.view.View r1 = r0.f43178h
            r1.setVisibility(r6)
            android.widget.TextView r1 = r0.f43173c
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r9 = r21.getData()
            if (r9 != 0) goto L_0x0059
        L_0x0057:
            r9 = r4
            goto L_0x0060
        L_0x0059:
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity$TitleBean r9 = r9.title
            if (r9 != 0) goto L_0x005e
            goto L_0x0057
        L_0x005e:
            java.lang.String r9 = r9.content
        L_0x0060:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r1.setText(r9)
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r1 = r21.getData()
            if (r1 != 0) goto L_0x006d
        L_0x006b:
            r1 = r4
            goto L_0x009e
        L_0x006d:
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity$TitleBean r1 = r1.title
            if (r1 != 0) goto L_0x0072
            goto L_0x006b
        L_0x0072:
            java.lang.String r1 = r1.icon
            if (r1 != 0) goto L_0x0077
            goto L_0x006b
        L_0x0077:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r9 = r1.length()
            if (r9 <= 0) goto L_0x0081
            r9 = 1
            goto L_0x0082
        L_0x0081:
            r9 = 0
        L_0x0082:
            if (r9 == 0) goto L_0x009b
            android.widget.TextView r9 = r0.f43179i
            r9.setText(r1)
            android.widget.TextView r1 = r0.f43179i
            r1.setVisibility(r6)
            android.view.View r1 = r0.f43178h
            com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicView$P_cp7-0K0AGihrAPaRVxjMYPG4k r9 = new com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicView$P_cp7-0K0AGihrAPaRVxjMYPG4k
            r9.<init>(r2)
            r1.setOnClickListener(r9)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x009e
        L_0x009b:
            r1 = r4
            kotlin.Unit r1 = (kotlin.Unit) r1
        L_0x009e:
            if (r1 != 0) goto L_0x00b1
            r1 = r0
            com.didi.soda.home.topgun.widget.HomeTopicView r1 = (com.didi.soda.home.topgun.widget.HomeTopicView) r1
            android.widget.TextView r1 = r0.f43179i
            r1.setVisibility(r8)
            android.view.View r1 = r0.f43178h
            com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicView$lAW5MGuDSp8jshRBaQXekp_dqbY r9 = com.didi.soda.home.topgun.widget.$$Lambda$HomeTopicView$lAW5MGuDSp8jshRBaQXekp_dqbY.INSTANCE
            r1.setOnClickListener(r9)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x00b1:
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r1 = r21.getData()
            if (r1 != 0) goto L_0x00b9
        L_0x00b7:
            r1 = r4
            goto L_0x00c6
        L_0x00b9:
            com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity r1 = r1.countDown
            if (r1 != 0) goto L_0x00be
            goto L_0x00b7
        L_0x00be:
            int r1 = r1.getTime()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x00c6:
            if (r1 == 0) goto L_0x0115
            com.didi.soda.home.topgun.widget.TopicCountDownView r1 = r0.f43177g
            long r9 = (long) r7
            long r11 = java.lang.System.currentTimeMillis()
            long r9 = r9 * r11
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r11 = r21.getData()
            r12 = 0
            if (r11 != 0) goto L_0x00da
            goto L_0x00e9
        L_0x00da:
            com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity r11 = r11.countDown
            if (r11 != 0) goto L_0x00df
            goto L_0x00e9
        L_0x00df:
            int r11 = r11.getTime()
            long r11 = (long) r11
            r13 = 1000(0x3e8, float:1.401E-42)
            long r13 = (long) r13
            long r12 = r11 * r13
        L_0x00e9:
            long r9 = r9 + r12
            long r11 = r21.getCreateTime()
            long r9 = r9 - r11
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r11 = r21.getData()
            if (r11 != 0) goto L_0x00f7
            r11 = r4
            goto L_0x00f9
        L_0x00f7:
            com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity r11 = r11.countDown
        L_0x00f9:
            r1.setupTimeEntity(r9, r11)
            com.didi.soda.home.topgun.widget.TopicCountDownView r1 = r0.f43177g
            com.didi.soda.home.topgun.widget.HomeTopicView$bindData$3 r9 = new com.didi.soda.home.topgun.widget.HomeTopicView$bindData$3
            r9.<init>(r0)
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r1.setOnTimerFinished(r9)
            com.didi.soda.home.topgun.widget.TopicCountDownView r1 = r0.f43177g
            r1.setVisibility(r6)
            com.didi.soda.home.topgun.widget.TopicCountDownView r1 = r0.f43177g
            com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicView$hZHrsuZ052y5Fku6WKo7WNfOJwg r9 = com.didi.soda.home.topgun.widget.$$Lambda$HomeTopicView$hZHrsuZ052y5Fku6WKo7WNfOJwg.INSTANCE
            r1.setOnClickListener(r9)
            goto L_0x011a
        L_0x0115:
            com.didi.soda.home.topgun.widget.TopicCountDownView r1 = r0.f43177g
            r1.setVisibility(r8)
        L_0x011a:
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r1 = r21.getData()
            if (r1 != 0) goto L_0x0122
        L_0x0120:
            r1 = r4
            goto L_0x0150
        L_0x0122:
            java.lang.String r1 = r1.ruleDesc
            if (r1 != 0) goto L_0x0127
            goto L_0x0120
        L_0x0127:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0131
            r1 = 1
            goto L_0x0132
        L_0x0131:
            r1 = 0
        L_0x0132:
            if (r1 == 0) goto L_0x014d
            android.widget.TextView r1 = r0.f43176f
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r9 = r21.getData()
            if (r9 != 0) goto L_0x013e
            r9 = r4
            goto L_0x0140
        L_0x013e:
            java.lang.String r9 = r9.ruleDesc
        L_0x0140:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r1.setText(r9)
            android.widget.TextView r1 = r0.f43176f
            r1.setVisibility(r6)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x0150
        L_0x014d:
            r1 = r4
            kotlin.Unit r1 = (kotlin.Unit) r1
        L_0x0150:
            if (r1 != 0) goto L_0x015c
            r1 = r0
            com.didi.soda.home.topgun.widget.HomeTopicView r1 = (com.didi.soda.home.topgun.widget.HomeTopicView) r1
            android.widget.TextView r1 = r0.f43176f
            r1.setVisibility(r8)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x015c:
            android.widget.ImageView r1 = r0.f43181k
            r1.setVisibility(r8)
            android.widget.ImageView r1 = r0.f43180j
            r1.setBackgroundColor(r6)
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r1 = r21.getData()
            if (r1 != 0) goto L_0x016e
            r1 = r4
            goto L_0x0170
        L_0x016e:
            java.lang.String r1 = r1.bgImg
        L_0x0170:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x017d
            int r1 = r1.length()
            if (r1 != 0) goto L_0x017b
            goto L_0x017d
        L_0x017b:
            r1 = 0
            goto L_0x017e
        L_0x017d:
            r1 = 1
        L_0x017e:
            if (r1 == 0) goto L_0x019d
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r1 = r21.getData()
            if (r1 != 0) goto L_0x0188
            r1 = r4
            goto L_0x018a
        L_0x0188:
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity$BgColorBean r1 = r1.bgColor
        L_0x018a:
            if (r1 != 0) goto L_0x019d
            android.view.View r1 = r0.f43175e
            int r9 = r1.getPaddingLeft()
            android.view.View r10 = r0.f43175e
            int r10 = r10.getPaddingRight()
            r1.setPadding(r9, r6, r10, r6)
            goto L_0x0270
        L_0x019d:
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r1 = r21.getData()
            if (r1 != 0) goto L_0x01a5
            r1 = r4
            goto L_0x01a7
        L_0x01a5:
            java.lang.String r1 = r1.bgImg
        L_0x01a7:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x01b4
            int r1 = r1.length()
            if (r1 != 0) goto L_0x01b2
            goto L_0x01b4
        L_0x01b2:
            r1 = 0
            goto L_0x01b5
        L_0x01b4:
            r1 = 1
        L_0x01b5:
            r9 = 2131167748(0x7f070a04, float:1.7949778E38)
            if (r1 != 0) goto L_0x01ed
            android.content.Context r1 = r19.getContext()
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r10 = r21.getData()
            if (r10 != 0) goto L_0x01c6
            r10 = r4
            goto L_0x01c8
        L_0x01c6:
            java.lang.String r10 = r10.bgImg
        L_0x01c8:
            com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r1 = com.didi.soda.customer.foundation.util.FlyImageLoader.loadImageUnspecified((android.content.Context) r1, (java.lang.String) r10)
            android.widget.ImageView r10 = r0.f43181k
            r1.into((android.widget.ImageView) r10)
            android.widget.ImageView r1 = r0.f43181k
            r1.setVisibility(r6)
            android.view.View r1 = r0.f43175e
            int r10 = r1.getPaddingLeft()
            int r11 = com.didi.soda.customer.foundation.util.ResourceHelper.getDimensionPixelSize(r9)
            android.view.View r12 = r0.f43175e
            int r12 = r12.getPaddingRight()
            int r13 = com.didi.soda.customer.foundation.util.ResourceHelper.getDimensionPixelSize(r9)
            r1.setPadding(r10, r11, r12, r13)
        L_0x01ed:
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r1 = r21.getData()
            if (r1 != 0) goto L_0x01f5
            r1 = r4
            goto L_0x01f7
        L_0x01f5:
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity$BgColorBean r1 = r1.bgColor
        L_0x01f7:
            if (r1 == 0) goto L_0x0270
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r1 = r21.getData()
            if (r1 != 0) goto L_0x0200
            goto L_0x0259
        L_0x0200:
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity$BgColorBean r1 = r1.bgColor
            if (r1 != 0) goto L_0x0205
            goto L_0x0259
        L_0x0205:
            android.widget.ImageView r10 = r0.f43180j
            android.graphics.drawable.GradientDrawable r11 = new android.graphics.drawable.GradientDrawable
            r11.<init>()
            java.util.List<java.lang.String> r12 = r1.color     // Catch:{ Exception -> 0x0241 }
            int r12 = r12.size()     // Catch:{ Exception -> 0x0241 }
            int[] r12 = new int[r12]     // Catch:{ Exception -> 0x0241 }
            java.util.List<java.lang.String> r13 = r1.color     // Catch:{ Exception -> 0x0241 }
            java.lang.String r14 = "it.color"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)     // Catch:{ Exception -> 0x0241 }
            java.lang.Iterable r13 = (java.lang.Iterable) r13     // Catch:{ Exception -> 0x0241 }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ Exception -> 0x0241 }
            r14 = 0
        L_0x0222:
            boolean r15 = r13.hasNext()     // Catch:{ Exception -> 0x0241 }
            if (r15 == 0) goto L_0x023e
            java.lang.Object r15 = r13.next()     // Catch:{ Exception -> 0x0241 }
            int r16 = r14 + 1
            if (r14 >= 0) goto L_0x0233
            kotlin.collections.CollectionsKt.throwIndexOverflow()     // Catch:{ Exception -> 0x0241 }
        L_0x0233:
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ Exception -> 0x0241 }
            int r15 = android.graphics.Color.parseColor(r15)     // Catch:{ Exception -> 0x0241 }
            r12[r14] = r15     // Catch:{ Exception -> 0x0241 }
            r14 = r16
            goto L_0x0222
        L_0x023e:
            r11.setColors(r12)     // Catch:{ Exception -> 0x0241 }
        L_0x0241:
            int r1 = r1.angle
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            android.graphics.drawable.GradientDrawable$Orientation r1 = com.didi.soda.customer.foundation.util.ExtentionsKt.updateAngle(r11, r1)
            r11.setOrientation(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            android.graphics.drawable.Drawable r11 = (android.graphics.drawable.Drawable) r11
            r10.setBackground(r11)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x0259:
            android.view.View r1 = r0.f43175e
            int r10 = r1.getPaddingLeft()
            int r11 = com.didi.soda.customer.foundation.util.ResourceHelper.getDimensionPixelSize(r9)
            android.view.View r12 = r0.f43175e
            int r12 = r12.getPaddingRight()
            int r9 = com.didi.soda.customer.foundation.util.ResourceHelper.getDimensionPixelSize(r9)
            r1.setPadding(r10, r11, r12, r9)
        L_0x0270:
            android.widget.ImageView r1 = r0.f43172b
            r1.setVisibility(r8)
            com.airbnb.lottie.LottieAnimationView r1 = r0.f43171a
            r1.setVisibility(r8)
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r1 = r21.getData()
            if (r1 != 0) goto L_0x0281
            goto L_0x02d9
        L_0x0281:
            java.lang.String r1 = r1.iconImg
            if (r1 != 0) goto L_0x0286
            goto L_0x02d9
        L_0x0286:
            r8 = r1
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            int r8 = r8.length()
            if (r8 <= 0) goto L_0x0291
            r8 = 1
            goto L_0x0292
        L_0x0291:
            r8 = 0
        L_0x0292:
            if (r8 == 0) goto L_0x02d5
            java.lang.String r8 = ".json"
            boolean r7 = kotlin.text.StringsKt.endsWith$default(r1, r8, r6, r7, r4)
            if (r7 == 0) goto L_0x02bf
            com.airbnb.lottie.LottieAnimationView r1 = r0.f43171a
            r1.setVisibility(r6)
            com.airbnb.lottie.LottieAnimationView r1 = r0.f43171a
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r7 = r21.getData()
            if (r7 != 0) goto L_0x02ab
            r7 = r4
            goto L_0x02ad
        L_0x02ab:
            java.lang.String r7 = r7.iconImg
        L_0x02ad:
            r1.setAnimationFromUrl(r7)
            boolean r1 = r21.isPlayingRightTopAnim()
            if (r1 != 0) goto L_0x02d5
            r2.setPlayingRightTopAnim(r5)
            com.airbnb.lottie.LottieAnimationView r1 = r0.f43171a
            r1.playAnimation()
            goto L_0x02d5
        L_0x02bf:
            android.widget.ImageView r7 = r0.f43172b
            r7.setVisibility(r6)
            android.content.Context r7 = r19.getContext()
            com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r1 = com.didi.soda.customer.foundation.util.FlyImageLoader.loadImageUnspecified((android.content.Context) r7, (java.lang.String) r1)
            com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r1 = r1.centerCrop()
            android.widget.ImageView r7 = r0.f43172b
            r1.into((android.widget.ImageView) r7)
        L_0x02d5:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x02d9:
            com.didi.soda.customer.blocks.widget.ScrollWidget r1 = r0.f43174d
            r1.clearChildren()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.ArrayList r7 = r21.getItemList()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
            r8 = 0
            r9 = 0
        L_0x02ef:
            boolean r10 = r7.hasNext()
            java.lang.String r11 = "context"
            if (r10 == 0) goto L_0x0340
            java.lang.Object r10 = r7.next()
            com.didi.soda.business.model.BusinessGoodsItemRvModel r10 = (com.didi.soda.business.model.BusinessGoodsItemRvModel) r10
            int r12 = r9 + 1
            r10.mIndexInModule = r9
            com.didi.soda.home.topgun.widget.HomeTopicGoodsItemView r9 = new com.didi.soda.home.topgun.widget.HomeTopicGoodsItemView
            android.content.Context r14 = r19.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r11)
            r15 = 0
            r16 = 0
            r17 = 6
            r18 = 0
            r13 = r9
            r13.<init>(r14, r15, r16, r17, r18)
            boolean r11 = r9.setData(r10)
            if (r11 != 0) goto L_0x0320
            if (r8 == 0) goto L_0x031e
            goto L_0x0320
        L_0x031e:
            r8 = 0
            goto L_0x0321
        L_0x0320:
            r8 = 1
        L_0x0321:
            r1.add(r9)
            com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicView$efwKmGiR_1E3ew0J3ZnRHQqk2f8 r11 = new com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicView$efwKmGiR_1E3ew0J3ZnRHQqk2f8
            r11.<init>(r3, r10, r2)
            r9.setBtnClickListener(r11)
            com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicView$yQNRFHDXh17bqlkMaGng2nW-ijo r11 = new com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicView$yQNRFHDXh17bqlkMaGng2nW-ijo
            r11.<init>(r3, r10, r2)
            r9.setOnClickListener(r11)
            com.didi.soda.home.topgun.widget.HomeTopicView$bindData$9$3 r11 = new com.didi.soda.home.topgun.widget.HomeTopicView$bindData$9$3
            r11.<init>(r0, r10)
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            r9.setAppearListener(r11)
            r9 = r12
            goto L_0x02ef
        L_0x0340:
            if (r8 == 0) goto L_0x037a
            r6 = r1
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r6 = r6.iterator()
        L_0x0350:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0362
            java.lang.Object r8 = r6.next()
            boolean r10 = r8 instanceof com.didi.soda.home.topgun.widget.HomeTopicGoodsItemView
            if (r10 == 0) goto L_0x0350
            r7.add(r8)
            goto L_0x0350
        L_0x0362:
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r6 = r7.iterator()
        L_0x036a:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x037a
            java.lang.Object r7 = r6.next()
            com.didi.soda.home.topgun.widget.HomeTopicGoodsItemView r7 = (com.didi.soda.home.topgun.widget.HomeTopicGoodsItemView) r7
            r7.setMsgOrientation(r5)
            goto L_0x036a
        L_0x037a:
            java.util.ArrayList r5 = r21.getShopList()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x0384:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x03c1
            java.lang.Object r6 = r5.next()
            com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel r6 = (com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel) r6
            int r7 = r9 + 1
            r6.mIndexInModule = r9
            com.didi.soda.home.topgun.widget.HomeTopicShopItemView r8 = new com.didi.soda.home.topgun.widget.HomeTopicShopItemView
            android.content.Context r13 = r19.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r11)
            r14 = 0
            r15 = 0
            r16 = 6
            r17 = 0
            r12 = r8
            r12.<init>(r13, r14, r15, r16, r17)
            r8.setData(r6)
            r1.add(r8)
            com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicView$TEyjLTyyDY5cRe6_HicJH9bQemQ r9 = new com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicView$TEyjLTyyDY5cRe6_HicJH9bQemQ
            r9.<init>(r3, r6, r2)
            r8.setOnClickListener(r9)
            com.didi.soda.home.topgun.widget.HomeTopicView$bindData$11$2 r9 = new com.didi.soda.home.topgun.widget.HomeTopicView$bindData$11$2
            r9.<init>(r0, r6)
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r8.setAppearListener(r9)
            r9 = r7
            goto L_0x0384
        L_0x03c1:
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r3 = r21.getData()
            if (r3 != 0) goto L_0x03c8
            goto L_0x03f0
        L_0x03c8:
            com.didi.soda.customer.foundation.rpc.entity.topgun.ViewMoreEntity r3 = r3.mViewMore
            if (r3 != 0) goto L_0x03cd
            goto L_0x03f0
        L_0x03cd:
            com.didi.soda.home.topgun.widget.HomeTopicMoreView r12 = new com.didi.soda.home.topgun.widget.HomeTopicMoreView
            android.content.Context r6 = r19.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r11)
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            r5 = r12
            r5.<init>(r6, r7, r8, r9, r10)
            r12.setData(r3)
            r1.add(r12)
            com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicView$cTNmJTpsCbvZz2MQIF98XvWEcq8 r3 = new com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicView$cTNmJTpsCbvZz2MQIF98XvWEcq8
            r3.<init>(r2)
            r12.setOnClickListener(r3)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x03f0:
            com.didi.soda.customer.blocks.widget.ScrollWidget r2 = r0.f43174d
            java.util.List r1 = (java.util.List) r1
            r2.bindChildren(r1)
            com.didi.soda.customer.blocks.widget.ScrollWidget r1 = r0.f43174d
            r1.onBindFinish(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.widget.HomeTopicView.bindData(com.didi.app.nova.skeleton.ScopeContext, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30536a(HomeTopicView homeTopicView, HomeTopicRvModel homeTopicRvModel, View view) {
        Intrinsics.checkNotNullParameter(homeTopicView, "this$0");
        Intrinsics.checkNotNullParameter(homeTopicRvModel, "$model");
        HomeTopicBinder.Companion.Logic logic = homeTopicView.getLogic();
        if (logic != null) {
            logic.toMorePage(homeTopicRvModel, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30534a(HomeTopicView homeTopicView, BlockScopeBase blockScopeBase, BusinessGoodsItemRvModel businessGoodsItemRvModel, HomeTopicRvModel homeTopicRvModel, View view) {
        Intrinsics.checkNotNullParameter(homeTopicView, "this$0");
        Intrinsics.checkNotNullParameter(blockScopeBase, "$scope");
        Intrinsics.checkNotNullParameter(businessGoodsItemRvModel, "$goodsItem");
        Intrinsics.checkNotNullParameter(homeTopicRvModel, "$model");
        IBlockScope iBlockScope = blockScopeBase;
        ButtonInfoEntity buttonInfoEntity = businessGoodsItemRvModel.mBtnInfo;
        homeTopicView.onGoodItemClick(iBlockScope, true, businessGoodsItemRvModel, homeTopicRvModel, buttonInfoEntity == null ? 0 : buttonInfoEntity.getOrderWay());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m30538b(HomeTopicView homeTopicView, BlockScopeBase blockScopeBase, BusinessGoodsItemRvModel businessGoodsItemRvModel, HomeTopicRvModel homeTopicRvModel, View view) {
        Intrinsics.checkNotNullParameter(homeTopicView, "this$0");
        Intrinsics.checkNotNullParameter(blockScopeBase, "$scope");
        Intrinsics.checkNotNullParameter(businessGoodsItemRvModel, "$goodsItem");
        Intrinsics.checkNotNullParameter(homeTopicRvModel, "$model");
        homeTopicView.onGoodItemClick(blockScopeBase, false, businessGoodsItemRvModel, homeTopicRvModel, businessGoodsItemRvModel.orderWay);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30535a(HomeTopicView homeTopicView, BlockScopeBase blockScopeBase, HomeBusinessInfoRvModel homeBusinessInfoRvModel, HomeTopicRvModel homeTopicRvModel, View view) {
        Intrinsics.checkNotNullParameter(homeTopicView, "this$0");
        Intrinsics.checkNotNullParameter(blockScopeBase, "$scope");
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "$shopModel");
        Intrinsics.checkNotNullParameter(homeTopicRvModel, "$model");
        homeTopicView.onShopItemClick(blockScopeBase, homeBusinessInfoRvModel, homeTopicRvModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m30539b(HomeTopicView homeTopicView, HomeTopicRvModel homeTopicRvModel, View view) {
        Intrinsics.checkNotNullParameter(homeTopicView, "this$0");
        Intrinsics.checkNotNullParameter(homeTopicRvModel, "$model");
        HomeTopicBinder.Companion.Logic logic = homeTopicView.getLogic();
        if (logic != null) {
            logic.toMorePage(homeTopicRvModel, false);
        }
    }

    public final void onGoodItemClick(IBlockScope iBlockScope, boolean z, BusinessGoodsItemRvModel businessGoodsItemRvModel, HomeTopicRvModel homeTopicRvModel, int i) {
        Serializable serializable;
        int i2;
        Serializable serializable2;
        Serializable serializable3;
        IBlockScope iBlockScope2 = iBlockScope;
        BusinessGoodsItemRvModel businessGoodsItemRvModel2 = businessGoodsItemRvModel;
        HomeTopicRvModel homeTopicRvModel2 = homeTopicRvModel;
        int i3 = i;
        Intrinsics.checkNotNullParameter(iBlockScope2, "scope");
        Intrinsics.checkNotNullParameter(businessGoodsItemRvModel2, "good");
        Intrinsics.checkNotNullParameter(homeTopicRvModel2, "topic");
        if (i3 == 1) {
            HomeTopicBinder.Companion.Logic logic = this.f43182l;
            if (logic != null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Pair[] pairArr = new Pair[10];
                pairArr[0] = TuplesKt.m42317to("fromType", 7);
                pairArr[1] = TuplesKt.m42317to("sceneType", 22);
                pairArr[2] = TuplesKt.m42317to("source", 1);
                pairArr[3] = TuplesKt.m42317to(BlocksConst.ACTION_PARAMS_ACT_VALIDATE_TYPE, 1);
                ActInfoEntity actInfoEntity = businessGoodsItemRvModel2.mActinfo;
                if (actInfoEntity == null) {
                    serializable = "";
                } else {
                    serializable = actInfoEntity;
                }
                pairArr[4] = TuplesKt.m42317to(BlocksConst.ACTION_PARAMS_ACT_INFO, GsonUtil.toJson(serializable));
                pairArr[5] = TuplesKt.m42317to("shopId", businessGoodsItemRvModel2.mBusinessId);
                pairArr[6] = TuplesKt.m42317to(BlocksConst.ACTION_PARAMS_ITEM_ID, businessGoodsItemRvModel2.mGoodsId);
                pairArr[7] = TuplesKt.m42317to(BlocksConst.ACTION_PARAMS_HAS_WINE, Integer.valueOf(businessGoodsItemRvModel2.mHasWine));
                if (!z) {
                    i2 = 2;
                } else {
                    i2 = businessGoodsItemRvModel2.mMaxLevel;
                }
                pairArr[8] = TuplesKt.m42317to(BlocksConst.ACTION_PARAMS_MAX_LEVEL, Integer.valueOf(i2));
                ItemNodeEntity itemNodeEntity = businessGoodsItemRvModel2.mNode;
                if (itemNodeEntity != null) {
                    serializable2 = itemNodeEntity;
                }
                pairArr[9] = TuplesKt.m42317to(BlocksConst.ACTION_PARAMS_ITEM_NODE, GsonUtil.toJson(serializable2));
                logic.fastBuy(context, iBlockScope2, MapsKt.hashMapOf(pairArr));
            }
            if (z) {
                HomeOmegaHelper.getInstance().traceTopicBtnBuyCK(homeTopicRvModel2, businessGoodsItemRvModel2);
            } else {
                HomeOmegaHelper.getInstance().traceTopicGoodsItemCK(homeTopicRvModel2, businessGoodsItemRvModel2);
            }
        } else if (i3 != 3) {
            Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.m42317to(Const.PageParams.SHOP_ID, businessGoodsItemRvModel2.mBusinessId));
            CharSequence charSequence = businessGoodsItemRvModel2.mGoodsId;
            if (!(charSequence == null || charSequence.length() == 0)) {
                ActionInfoEntity actionInfoEntity = new ActionInfoEntity();
                String str = businessGoodsItemRvModel2.mGoodsId;
                if (str == null) {
                    str = "";
                }
                actionInfoEntity.setItemId(str);
                actionInfoEntity.setType(z ? 3 : 2);
                mutableMapOf.put(Const.PageParams.ACTION_INFO_DICT, actionInfoEntity);
            }
            if (businessGoodsItemRvModel2.mActinfo != null) {
                String json = GsonUtil.toJson(businessGoodsItemRvModel2.mActinfo);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(good.mActinfo)");
                mutableMapOf.put(Const.PageParams.ACT_INFO, json);
            }
            HomeTopicBinder.Companion.Logic logic2 = this.f43182l;
            if (logic2 != null) {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                Pair[] pairArr2 = new Pair[6];
                pairArr2[0] = TuplesKt.m42317to("url", RoutePath.BUSINESS_HOME);
                pairArr2[1] = TuplesKt.m42317to(BlocksConst.ACTION_PARAMS_ENABLE_PAGE_RESULT, 1);
                pairArr2[2] = TuplesKt.m42317to("sceneType", 22);
                pairArr2[3] = TuplesKt.m42317to(BlocksConst.ACTION_PARAMS_ACT_VALIDATE_TYPE, 1);
                ActInfoEntity actInfoEntity2 = businessGoodsItemRvModel2.mActinfo;
                if (actInfoEntity2 != null) {
                    serializable3 = actInfoEntity2;
                }
                pairArr2[4] = TuplesKt.m42317to(BlocksConst.ACTION_PARAMS_ACT_INFO, GsonUtil.toJson(serializable3));
                pairArr2[5] = TuplesKt.m42317to("params", mutableMapOf);
                logic2.openPage(context2, iBlockScope2, MapsKt.hashMapOf(pairArr2));
            }
            if (z) {
                HomeOmegaHelper.getInstance().traceTopicBtnOpenStoreCK(homeTopicRvModel2, businessGoodsItemRvModel2);
            } else {
                HomeOmegaHelper.getInstance().traceTopicGoodsItemCK(homeTopicRvModel2, businessGoodsItemRvModel2);
            }
        } else {
            HomeTopicBinder.Companion.Logic logic3 = this.f43182l;
            if (logic3 != null) {
                logic3.toMorePage(homeTopicRvModel2);
            }
            if (z) {
                HomeOmegaHelper.getInstance().traceTopicBtnOpenStoreCK(homeTopicRvModel2, businessGoodsItemRvModel2);
            } else {
                HomeOmegaHelper.getInstance().traceTopicGoodsItemCK(homeTopicRvModel2, businessGoodsItemRvModel2);
            }
        }
    }

    public final void onShopItemClick(IBlockScope iBlockScope, HomeBusinessInfoRvModel homeBusinessInfoRvModel, HomeTopicRvModel homeTopicRvModel) {
        Serializable serializable;
        Serializable serializable2;
        Serializable serializable3;
        IBlockScope iBlockScope2 = iBlockScope;
        HomeBusinessInfoRvModel homeBusinessInfoRvModel2 = homeBusinessInfoRvModel;
        HomeTopicRvModel homeTopicRvModel2 = homeTopicRvModel;
        Intrinsics.checkNotNullParameter(iBlockScope2, "scope");
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel2, "shop");
        Intrinsics.checkNotNullParameter(homeTopicRvModel2, "topic");
        HomeOmegaHelper.getInstance().traceTopicShopItemCK(homeTopicRvModel2, homeBusinessInfoRvModel2);
        if (homeBusinessInfoRvModel2.orderWay == 1) {
            HomeTopicBinder.Companion.Logic logic = this.f43182l;
            if (logic != null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Pair[] pairArr = new Pair[10];
                pairArr[0] = TuplesKt.m42317to("fromType", 7);
                pairArr[1] = TuplesKt.m42317to("sceneType", 22);
                pairArr[2] = TuplesKt.m42317to("source", 1);
                pairArr[3] = TuplesKt.m42317to(BlocksConst.ACTION_PARAMS_ACT_VALIDATE_TYPE, 1);
                ActInfoEntity actInfoEntity = homeBusinessInfoRvModel2.mActInfo;
                if (actInfoEntity == null) {
                    serializable2 = "";
                } else {
                    serializable2 = actInfoEntity;
                }
                pairArr[4] = TuplesKt.m42317to(BlocksConst.ACTION_PARAMS_ACT_INFO, GsonUtil.toJson(serializable2));
                pairArr[5] = TuplesKt.m42317to("shopId", homeBusinessInfoRvModel2.mShopId);
                pairArr[6] = TuplesKt.m42317to(BlocksConst.ACTION_PARAMS_ITEM_ID, homeBusinessInfoRvModel2.mItemId);
                pairArr[7] = TuplesKt.m42317to(BlocksConst.ACTION_PARAMS_HAS_WINE, Integer.valueOf(homeBusinessInfoRvModel2.mHasWine));
                pairArr[8] = TuplesKt.m42317to(BlocksConst.ACTION_PARAMS_MAX_LEVEL, 2);
                ItemNodeEntity itemNodeEntity = homeBusinessInfoRvModel2.mNode;
                if (itemNodeEntity != null) {
                    serializable3 = itemNodeEntity;
                }
                pairArr[9] = TuplesKt.m42317to(BlocksConst.ACTION_PARAMS_ITEM_NODE, GsonUtil.toJson(serializable3));
                logic.fastBuy(context, iBlockScope2, MapsKt.hashMapOf(pairArr));
                return;
            }
            return;
        }
        Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.m42317to(Const.PageParams.SHOP_ID, homeBusinessInfoRvModel2.mShopId), TuplesKt.m42317to(Const.PageParams.BIDATA, HomeOmegaHelper.getInstance().getBusinessBiData(homeBusinessInfoRvModel2)));
        CharSequence charSequence = homeBusinessInfoRvModel2.mItemId;
        if (!(charSequence == null || charSequence.length() == 0)) {
            ActionInfoEntity actionInfoEntity = new ActionInfoEntity();
            String str = homeBusinessInfoRvModel2.mItemId;
            Intrinsics.checkNotNullExpressionValue(str, "shop.mItemId");
            actionInfoEntity.setItemId(str);
            actionInfoEntity.setType(2);
            mutableMapOf.put(Const.PageParams.ACTION_INFO_DICT, actionInfoEntity);
        }
        if (homeBusinessInfoRvModel2.mActInfo != null) {
            String json = GsonUtil.toJson(homeBusinessInfoRvModel2.mActInfo);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(shop.mActInfo)");
            mutableMapOf.put(Const.PageParams.ACT_INFO, json);
        }
        HomeTopicBinder.Companion.Logic logic2 = this.f43182l;
        if (logic2 != null) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            Pair[] pairArr2 = new Pair[6];
            pairArr2[0] = TuplesKt.m42317to("url", RoutePath.BUSINESS_HOME);
            pairArr2[1] = TuplesKt.m42317to(BlocksConst.ACTION_PARAMS_ENABLE_PAGE_RESULT, 1);
            pairArr2[2] = TuplesKt.m42317to("sceneType", 22);
            pairArr2[3] = TuplesKt.m42317to(BlocksConst.ACTION_PARAMS_ACT_VALIDATE_TYPE, 1);
            ActInfoEntity actInfoEntity2 = homeBusinessInfoRvModel2.mActInfo;
            if (actInfoEntity2 != null) {
                serializable = actInfoEntity2;
            }
            pairArr2[4] = TuplesKt.m42317to(BlocksConst.ACTION_PARAMS_ACT_INFO, GsonUtil.toJson(serializable));
            pairArr2[5] = TuplesKt.m42317to("params", mutableMapOf);
            logic2.openPage(context2, iBlockScope2, MapsKt.hashMapOf(pairArr2));
        }
    }
}
