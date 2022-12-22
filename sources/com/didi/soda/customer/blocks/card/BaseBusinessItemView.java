package com.didi.soda.customer.blocks.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.business.BusinessOpen;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.blocks.widget.AdTagWidget;
import com.didi.soda.customer.blocks.widget.ImageWidget;
import com.didi.soda.customer.blocks.widget.MaskWidget;
import com.didi.soda.customer.blocks.widget.TagWidget;
import com.didi.soda.customer.blocks.widget.TitleWidget;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.search.SearchFoodItemView;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.didi.soda.home.topgun.manager.HomeBusinessPool;
import com.didi.soda.home.topgun.manager.HomeLogTrackerHelper;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.search.helper.SearchNewOmegaHelper;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 B2\u00020\u0001:\u0001BB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010=\u001a\u00020\u0007H\u0014J\b\u0010>\u001a\u00020;H\u0014J\u0010\u0010?\u001a\u00020;2\u0006\u0010@\u001a\u00020AH\u0002R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u000205X.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006C"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/BaseBusinessItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "config", "Lcom/didi/soda/blocks/BinderRootConfig;", "Lcom/didi/soda/blocks/model/ComponentModel;", "getConfig", "()Lcom/didi/soda/blocks/BinderRootConfig;", "setConfig", "(Lcom/didi/soda/blocks/BinderRootConfig;)V", "mAdTagWidget", "Lcom/didi/soda/customer/blocks/widget/AdTagWidget;", "getMAdTagWidget", "()Lcom/didi/soda/customer/blocks/widget/AdTagWidget;", "setMAdTagWidget", "(Lcom/didi/soda/customer/blocks/widget/AdTagWidget;)V", "mImageWidget", "Lcom/didi/soda/customer/blocks/widget/ImageWidget;", "getMImageWidget", "()Lcom/didi/soda/customer/blocks/widget/ImageWidget;", "setMImageWidget", "(Lcom/didi/soda/customer/blocks/widget/ImageWidget;)V", "mItemMaskContainer", "Landroid/view/View;", "getMItemMaskContainer", "()Landroid/view/View;", "setMItemMaskContainer", "(Landroid/view/View;)V", "mItemRightView", "Landroid/widget/TextView;", "getMItemRightView", "()Landroid/widget/TextView;", "setMItemRightView", "(Landroid/widget/TextView;)V", "mMaskWidget", "Lcom/didi/soda/customer/blocks/widget/MaskWidget;", "getMMaskWidget", "()Lcom/didi/soda/customer/blocks/widget/MaskWidget;", "setMMaskWidget", "(Lcom/didi/soda/customer/blocks/widget/MaskWidget;)V", "mTagWidget", "Lcom/didi/soda/customer/blocks/widget/TagWidget;", "getMTagWidget", "()Lcom/didi/soda/customer/blocks/widget/TagWidget;", "setMTagWidget", "(Lcom/didi/soda/customer/blocks/widget/TagWidget;)V", "mTitleWidget", "Lcom/didi/soda/customer/blocks/widget/TitleWidget;", "getMTitleWidget", "()Lcom/didi/soda/customer/blocks/widget/TitleWidget;", "setMTitleWidget", "(Lcom/didi/soda/customer/blocks/widget/TitleWidget;)V", "bindActions", "", "componentModel", "getResId", "initView", "openBusinessHomePage", "rvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BaseBusinessItemView.kt */
public class BaseBusinessItemView extends ConstraintLayout {
    public static final int BUSINESS_STYLE_LARGE = 21;
    public static final int BUSINESS_STYLE_SMALL = 43;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private BinderRootConfig<ComponentModel> f40571a;
    protected AdTagWidget mAdTagWidget;
    protected ImageWidget mImageWidget;
    protected View mItemMaskContainer;
    protected TextView mItemRightView;
    protected MaskWidget mMaskWidget;
    protected TagWidget mTagWidget;
    protected TitleWidget mTitleWidget;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseBusinessItemView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseBusinessItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* access modifiers changed from: protected */
    public int getResId() {
        return R.layout.customer_item_feed_business_large_blocks;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseBusinessItemView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseBusinessItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        initView();
    }

    /* access modifiers changed from: protected */
    public final View getMItemMaskContainer() {
        View view = this.mItemMaskContainer;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mItemMaskContainer");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setMItemMaskContainer(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mItemMaskContainer = view;
    }

    /* access modifiers changed from: protected */
    public final ImageWidget getMImageWidget() {
        ImageWidget imageWidget = this.mImageWidget;
        if (imageWidget != null) {
            return imageWidget;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mImageWidget");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setMImageWidget(ImageWidget imageWidget) {
        Intrinsics.checkNotNullParameter(imageWidget, "<set-?>");
        this.mImageWidget = imageWidget;
    }

    /* access modifiers changed from: protected */
    public final TagWidget getMTagWidget() {
        TagWidget tagWidget = this.mTagWidget;
        if (tagWidget != null) {
            return tagWidget;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTagWidget");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setMTagWidget(TagWidget tagWidget) {
        Intrinsics.checkNotNullParameter(tagWidget, "<set-?>");
        this.mTagWidget = tagWidget;
    }

    /* access modifiers changed from: protected */
    public final MaskWidget getMMaskWidget() {
        MaskWidget maskWidget = this.mMaskWidget;
        if (maskWidget != null) {
            return maskWidget;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMaskWidget");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setMMaskWidget(MaskWidget maskWidget) {
        Intrinsics.checkNotNullParameter(maskWidget, "<set-?>");
        this.mMaskWidget = maskWidget;
    }

    /* access modifiers changed from: protected */
    public final TitleWidget getMTitleWidget() {
        TitleWidget titleWidget = this.mTitleWidget;
        if (titleWidget != null) {
            return titleWidget;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTitleWidget");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setMTitleWidget(TitleWidget titleWidget) {
        Intrinsics.checkNotNullParameter(titleWidget, "<set-?>");
        this.mTitleWidget = titleWidget;
    }

    /* access modifiers changed from: protected */
    public final AdTagWidget getMAdTagWidget() {
        AdTagWidget adTagWidget = this.mAdTagWidget;
        if (adTagWidget != null) {
            return adTagWidget;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAdTagWidget");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setMAdTagWidget(AdTagWidget adTagWidget) {
        Intrinsics.checkNotNullParameter(adTagWidget, "<set-?>");
        this.mAdTagWidget = adTagWidget;
    }

    /* access modifiers changed from: protected */
    public final TextView getMItemRightView() {
        TextView textView = this.mItemRightView;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mItemRightView");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setMItemRightView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mItemRightView = textView;
    }

    /* access modifiers changed from: protected */
    public final BinderRootConfig<ComponentModel> getConfig() {
        return this.f40571a;
    }

    /* access modifiers changed from: protected */
    public final void setConfig(BinderRootConfig<ComponentModel> binderRootConfig) {
        this.f40571a = binderRootConfig;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(getResId(), this, true);
        View findViewById = inflate.findViewById(R.id.customer_view_layout_mark);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_view_layout_mark)");
        setMItemMaskContainer(findViewById);
        View findViewById2 = inflate.findViewById(R.id.customer_custom_shop_image);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_custom_shop_image)");
        setMImageWidget((ImageWidget) findViewById2);
        View findViewById3 = inflate.findViewById(R.id.customer_custom_shop_tag);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_custom_shop_tag)");
        setMTagWidget((TagWidget) findViewById3);
        View findViewById4 = inflate.findViewById(R.id.customer_custom_shop_status_mask);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.custom…_custom_shop_status_mask)");
        setMMaskWidget((MaskWidget) findViewById4);
        View findViewById5 = inflate.findViewById(R.id.customer_custom_shop_name);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.customer_custom_shop_name)");
        setMTitleWidget((TitleWidget) findViewById5);
        getMTitleWidget().setLineSpacingExtra(ResourceHelper.getDimensionPixelSize(R.dimen.customer_4px));
        View findViewById6 = inflate.findViewById(R.id.customer_home_ad_tag);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.customer_home_ad_tag)");
        setMAdTagWidget((AdTagWidget) findViewById6);
        View findViewById7 = inflate.findViewById(R.id.customer_blocks_binder_item_right);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.custom…blocks_binder_item_right)");
        setMItemRightView((TextView) findViewById7);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindActions(com.didi.soda.blocks.model.ComponentModel r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0005
            r1 = r0
            goto L_0x0009
        L_0x0005:
            java.lang.Object r1 = r6.getDataModel()
        L_0x0009:
            boolean r2 = r1 instanceof com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel
            if (r2 == 0) goto L_0x0010
            com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel r1 = (com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel) r1
            goto L_0x0011
        L_0x0010:
            r1 = r0
        L_0x0011:
            if (r1 != 0) goto L_0x0015
            goto L_0x00b4
        L_0x0015:
            java.lang.String r2 = r1.mPageId
            r3 = 1
            if (r2 == 0) goto L_0x00ad
            int r4 = r2.hashCode()
            switch(r4) {
                case -710596521: goto L_0x0096;
                case -625398383: goto L_0x0083;
                case 526384683: goto L_0x005d;
                case 2067261796: goto L_0x0023;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x00ad
        L_0x0023:
            java.lang.String r4 = "showAll"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x002e
            goto L_0x00ad
        L_0x002e:
            com.didi.soda.blocks.BinderRootConfig r2 = r5.getConfig()
            if (r2 != 0) goto L_0x0036
        L_0x0034:
            r2 = r0
            goto L_0x0044
        L_0x0036:
            java.util.Map r2 = r2.getConfigs()
            if (r2 != 0) goto L_0x003d
            goto L_0x0034
        L_0x003d:
            java.lang.String r3 = "scene"
            java.lang.Object r2 = r2.get(r3)
        L_0x0044:
            boolean r3 = r2 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x004b
            r0 = r2
            java.lang.Integer r0 = (java.lang.Integer) r0
        L_0x004b:
            if (r0 != 0) goto L_0x004f
            r0 = 0
            goto L_0x0053
        L_0x004f:
            int r0 = r0.intValue()
        L_0x0053:
            com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper$Companion r2 = com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper.Companion
            com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper r2 = r2.getInstance()
            r2.landingitemExposure(r1, r0)
            goto L_0x00b4
        L_0x005d:
            java.lang.String r0 = "favoritepage"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0066
            goto L_0x00ad
        L_0x0066:
            com.didi.soda.blocks.BinderRootConfig r0 = r5.getConfig()
            if (r0 != 0) goto L_0x006d
            goto L_0x00b4
        L_0x006d:
            java.util.Map r0 = r0.getOtherCallBacks()
            if (r0 != 0) goto L_0x0074
            goto L_0x00b4
        L_0x0074:
            java.lang.String r2 = "itemshow"
            java.lang.Object r0 = r0.get(r2)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            if (r0 != 0) goto L_0x007f
            goto L_0x00b4
        L_0x007f:
            r0.invoke(r1)
            goto L_0x00b4
        L_0x0083:
            java.lang.String r0 = "launchActivityPage"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x008c
            goto L_0x00ad
        L_0x008c:
            com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper$Companion r0 = com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper.Companion
            com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper r0 = r0.getInstance()
            r0.itemExposure(r1)
            goto L_0x00b4
        L_0x0096:
            java.lang.String r0 = "searchPage"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x00a0
            goto L_0x00ad
        L_0x00a0:
            int r0 = r1.mSource
            r2 = 2
            if (r0 != r2) goto L_0x00b4
            com.didi.soda.search.helper.SearchNewOmegaHelper r0 = com.didi.soda.search.helper.SearchNewOmegaHelper.getInstance()
            r0.itemExposure(r1, r3)
            goto L_0x00b4
        L_0x00ad:
            com.didi.soda.home.topgun.manager.HomeOmegaHelper r0 = com.didi.soda.home.topgun.manager.HomeOmegaHelper.getInstance()
            r0.onOmegaBusinessSw(r1, r3)
        L_0x00b4:
            android.view.View r0 = r5.getMItemMaskContainer()
            com.didi.soda.customer.blocks.card.-$$Lambda$BaseBusinessItemView$tVNXdKKbPqO-Hl3X_qoQNtwj7nQ r2 = new com.didi.soda.customer.blocks.card.-$$Lambda$BaseBusinessItemView$tVNXdKKbPqO-Hl3X_qoQNtwj7nQ
            r2.<init>(r5)
            r0.setOnClickListener(r2)
            android.widget.TextView r0 = r5.getMItemRightView()
            com.didi.soda.customer.blocks.card.-$$Lambda$BaseBusinessItemView$JVU0pXsDlp-zWrAhJcdfN5R0gPk r1 = new com.didi.soda.customer.blocks.card.-$$Lambda$BaseBusinessItemView$JVU0pXsDlp-zWrAhJcdfN5R0gPk
            r1.<init>(r5)
            r0.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.card.BaseBusinessItemView.bindActions(com.didi.soda.blocks.model.ComponentModel):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        r5 = r5.getConfigs();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m28811a(com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel r3, com.didi.soda.customer.blocks.card.BaseBusinessItemView r4, android.view.View r5) {
        /*
            java.lang.String r5 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            if (r3 != 0) goto L_0x000a
            goto L_0x00c5
        L_0x000a:
            java.lang.String r5 = r3.mPageId
            r0 = 1
            if (r5 == 0) goto L_0x00b4
            int r1 = r5.hashCode()
            r2 = 0
            switch(r1) {
                case -710596521: goto L_0x0096;
                case -625398383: goto L_0x0083;
                case 526384683: goto L_0x005d;
                case 2067261796: goto L_0x0019;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x00b4
        L_0x0019:
            java.lang.String r1 = "showAll"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x0024
            goto L_0x00b4
        L_0x0024:
            com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper$Companion r5 = com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper.Companion
            com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper r5 = r5.getInstance()
            r5.setOmegaGuideParam(r3)
            com.didi.soda.blocks.BinderRootConfig r5 = r4.getConfig()
            if (r5 != 0) goto L_0x0035
        L_0x0033:
            r5 = r2
            goto L_0x0043
        L_0x0035:
            java.util.Map r5 = r5.getConfigs()
            if (r5 != 0) goto L_0x003c
            goto L_0x0033
        L_0x003c:
            java.lang.String r0 = "scene"
            java.lang.Object r5 = r5.get(r0)
        L_0x0043:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 == 0) goto L_0x004a
            r2 = r5
            java.lang.Integer r2 = (java.lang.Integer) r2
        L_0x004a:
            if (r2 != 0) goto L_0x004e
            r5 = 0
            goto L_0x0052
        L_0x004e:
            int r5 = r2.intValue()
        L_0x0052:
            com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper$Companion r0 = com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper.Companion
            com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper r0 = r0.getInstance()
            r0.trackLandingItemClick(r3, r5)
            goto L_0x00c2
        L_0x005d:
            java.lang.String r1 = "favoritepage"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x0066
            goto L_0x00b4
        L_0x0066:
            com.didi.soda.blocks.BinderRootConfig r5 = r4.getConfig()
            if (r5 != 0) goto L_0x006d
            goto L_0x00c2
        L_0x006d:
            java.util.Map r5 = r5.getOtherCallBacks()
            if (r5 != 0) goto L_0x0074
            goto L_0x00c2
        L_0x0074:
            java.lang.String r0 = "itemclick"
            java.lang.Object r5 = r5.get(r0)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            if (r5 != 0) goto L_0x007f
            goto L_0x00c2
        L_0x007f:
            r5.invoke(r3)
            goto L_0x00c2
        L_0x0083:
            java.lang.String r1 = "launchActivityPage"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x008c
            goto L_0x00b4
        L_0x008c:
            com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper$Companion r5 = com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper.Companion
            com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper r5 = r5.getInstance()
            r5.trackItemClick(r3)
            goto L_0x00c2
        L_0x0096:
            java.lang.String r1 = "searchPage"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x00a0
            goto L_0x00b4
        L_0x00a0:
            int r5 = r3.mSource
            r1 = 2
            if (r5 != r1) goto L_0x00c2
            com.didi.soda.search.helper.SearchNewOmegaHelper r5 = com.didi.soda.search.helper.SearchNewOmegaHelper.getInstance()
            r5.setBusinessGuideParam(r3)
            com.didi.soda.search.helper.SearchNewOmegaHelper r5 = com.didi.soda.search.helper.SearchNewOmegaHelper.getInstance()
            r5.trackBusinessOrGoodsClick(r3, r2, r0)
            goto L_0x00c2
        L_0x00b4:
            com.didi.soda.home.topgun.manager.HomeOmegaHelper r5 = com.didi.soda.home.topgun.manager.HomeOmegaHelper.getInstance()
            r5.setOmegaGuideParam(r3)
            com.didi.soda.home.topgun.manager.HomeOmegaHelper r5 = com.didi.soda.home.topgun.manager.HomeOmegaHelper.getInstance()
            r5.onOmegaBusinessCk(r3, r0)
        L_0x00c2:
            r4.m28810a(r3)
        L_0x00c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.card.BaseBusinessItemView.m28811a(com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel, com.didi.soda.customer.blocks.card.BaseBusinessItemView, android.view.View):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28809a(ComponentModel componentModel, BaseBusinessItemView baseBusinessItemView, View view) {
        BinderRootConfig<ComponentModel> config;
        Map<String, Function1<Object, Unit>> otherCallBacks;
        Function1 function1;
        Intrinsics.checkNotNullParameter(baseBusinessItemView, "this$0");
        if (componentModel != null && (config = baseBusinessItemView.getConfig()) != null && (otherCallBacks = config.getOtherCallBacks()) != null && (function1 = otherCallBacks.get(BlocksConst.CALLBACK_NAME_SLIDECLICK)) != null) {
            function1.invoke(componentModel);
        }
    }

    /* renamed from: a */
    private final void m28810a(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        String str;
        if (Intrinsics.areEqual((Object) homeBusinessInfoRvModel.mPageId, (Object) Const.FavorPage.PAGE_FAVOR)) {
            if (this.f40571a != null) {
                BusinessOpen.Companion.create(homeBusinessInfoRvModel.mShopId).shopInfoEntity(HomeBusinessPool.getPool().getBusiness(homeBusinessInfoRvModel.mShopId)).businessType(homeBusinessInfoRvModel.businessType).url(homeBusinessInfoRvModel.url).open();
            }
        } else if (Intrinsics.areEqual((Object) homeBusinessInfoRvModel.mPageId, (Object) RoutePath.SEARCH_HOME)) {
            BusinessOpen.Companion.create(homeBusinessInfoRvModel.mShopId).transitionName(homeBusinessInfoRvModel.mTransitionNameSet).businessAnimationSource(Integer.valueOf(homeBusinessInfoRvModel.mSource)).biData(SearchNewOmegaHelper.genBusinessBiData(homeBusinessInfoRvModel, (SearchFoodItemView.SearchFoodItemModel) null)).businessType(homeBusinessInfoRvModel.businessType).url(homeBusinessInfoRvModel.url).open();
        } else {
            if (homeBusinessInfoRvModel.mPageId.equals("homePage") || homeBusinessInfoRvModel.mPageId.equals("showAll")) {
                str = HomeOmegaHelper.getInstance().getBusinessBiData(homeBusinessInfoRvModel);
                Intrinsics.checkNotNullExpressionValue(str, "getInstance().getBusinessBiData(rvModel)");
            } else {
                str = "";
            }
            BusinessOpen.Companion.create(homeBusinessInfoRvModel.mShopId).shopInfoEntity(HomeBusinessPool.getPool().getBusiness(homeBusinessInfoRvModel.mShopId)).biData(str).businessType(homeBusinessInfoRvModel.businessType).url(homeBusinessInfoRvModel.url).open();
            HashMap hashMap = new HashMap();
            Map map = hashMap;
            String str2 = homeBusinessInfoRvModel.mShopId;
            Intrinsics.checkNotNullExpressionValue(str2, "rvModel.mShopId");
            map.put("shopId", str2);
            String str3 = homeBusinessInfoRvModel.mShopName;
            Intrinsics.checkNotNullExpressionValue(str3, "rvModel.mShopName");
            map.put("shopName", str3);
            HomeLogTrackerHelper.setLogTracker("onBusinessClick", "c-act|", hashMap);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/BaseBusinessItemView$Companion;", "", "()V", "BUSINESS_STYLE_LARGE", "", "BUSINESS_STYLE_SMALL", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BaseBusinessItemView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
