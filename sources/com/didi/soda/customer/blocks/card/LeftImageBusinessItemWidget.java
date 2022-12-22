package com.didi.soda.customer.blocks.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.blocks.widget.ImageWidget;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "left_image_right_text_card")
@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001GB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020*H\u0016J0\u0010+\u001a\u00020(2&\u0010,\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020-\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020-\u0018\u0001`\rH\u0016J\u0010\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u000200H\u0002J\u001e\u00101\u001a\u00020$2\u0014\u00102\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u000203H\u0002J\u0010\u00104\u001a\u00020$2\u0006\u0010/\u001a\u000200H\u0002J\b\u00105\u001a\u00020\bH\u0014J\b\u00106\u001a\u000200H\u0016J\b\u00107\u001a\u00020\bH\u0004J\b\u00108\u001a\u00020(H\u0014J\u001e\u00109\u001a\u00020(2\u0014\u00102\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u000203H\u0002J.\u0010:\u001a\u00020(2\u0014\u00102\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u0002032\u0006\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020$H\u0002J0\u0010=\u001a\u00020(2&\u0010,\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020-\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020-\u0018\u0001`\rH\u0016J\u0016\u0010>\u001a\u00020(2\f\u0010?\u001a\b\u0012\u0002\b\u0003\u0018\u00010@H\u0016J\u0012\u0010A\u001a\u00020(2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u001e\u0010D\u001a\u00020E2\u0014\u00102\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u000203H\u0002J0\u0010F\u001a\u00020E2&\u0010,\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020-\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020-\u0018\u0001`\rH\u0016R4\u0010\n\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00020\u000bj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u0002`\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0019X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u000e\u0010\"\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020$0&X\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/LeftImageBusinessItemWidget;", "Lcom/didi/soda/customer/blocks/card/BaseBusinessItemView;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "mAlignOffset", "mContainer", "Landroid/widget/LinearLayout;", "getMContainer", "()Landroid/widget/LinearLayout;", "setMContainer", "(Landroid/widget/LinearLayout;)V", "mFirstDividerHeight", "mHonorWidget", "Lcom/didi/soda/customer/blocks/widget/ImageWidget;", "getMHonorWidget", "()Lcom/didi/soda/customer/blocks/widget/ImageWidget;", "setMHonorWidget", "(Lcom/didi/soda/customer/blocks/widget/ImageWidget;)V", "mImageHeight", "mLogoWidget", "getMLogoWidget", "setMLogoWidget", "mOtherDividerHeight", "mTitleHeight", "", "mVisiableChildrenHeightList", "", "bindChildren", "", "children", "", "bindProps", "props", "", "geTitleMeasureHeight", "view", "Landroid/view/View;", "getAllChildHeight", "childMap", "", "getMeasureHeight", "getResId", "getView", "getViewWidth", "initView", "layoutDesignRegulation", "layoutFromTop2Bottom", "firstDividerHeight", "otherDividerHeight", "onBindFinish", "setBinderRootConfig", "config", "Lcom/didi/soda/blocks/BinderRootConfig;", "setWidgetNode", "widgetNode", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "shouldOrderLayout", "", "shouldShow", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LeftImageBusinessItemWidget.kt */
public final class LeftImageBusinessItemWidget extends BaseBusinessItemView implements Buildable {
    public static final float ALIGN_OFFSET = 0.5f;
    public static final float COMMON_DIVIDER_HEIGHT = 5.5f;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final float FIRST_DIVIDER_HEIGHT = 8.5f;
    public static final float IMAGE_HEIGHT = 94.0f;

    /* renamed from: a */
    private final HashMap<String, Buildable> f40575a;

    /* renamed from: b */
    private List<Float> f40576b;

    /* renamed from: c */
    private int f40577c;

    /* renamed from: d */
    private float f40578d;

    /* renamed from: e */
    private int f40579e;

    /* renamed from: f */
    private int f40580f;

    /* renamed from: g */
    private int f40581g;
    public LinearLayout mContainer;
    public ImageWidget mHonorWidget;
    public ImageWidget mLogoWidget;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LeftImageBusinessItemWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LeftImageBusinessItemWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* access modifiers changed from: protected */
    public int getResId() {
        return R.layout.customer_item_feed_business_small_blocks;
    }

    public void bindStyles(HashMap<String, Object> hashMap) {
        Buildable.DefaultImpls.bindStyles(this, hashMap);
    }

    public Buildable findWidgetByComponentId(String str, int i) {
        return Buildable.DefaultImpls.findWidgetByComponentId(this, str, i);
    }

    public Buildable getParentWidget() {
        return Buildable.DefaultImpls.getParentWidget(this);
    }

    public Buildable getRoot() {
        return Buildable.DefaultImpls.getRoot(this);
    }

    public boolean handleClickTrigger(IBlockScope iBlockScope, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        return Buildable.DefaultImpls.handleClickTrigger(this, iBlockScope, list, function3);
    }

    public boolean handleOtherTrigger(IBlockScope iBlockScope, String str, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        return Buildable.DefaultImpls.handleOtherTrigger(this, iBlockScope, str, list, function3);
    }

    public boolean handleShownTrigger(IBlockScope iBlockScope, WidgetNodeModel widgetNodeModel, List<? extends BaseAction> list, Function4<? super IBlockScope, ? super WidgetNodeModel, ? super Buildable, ? super List<? extends BaseAction>, Unit> function4) {
        return Buildable.DefaultImpls.handleShownTrigger(this, iBlockScope, widgetNodeModel, list, function4);
    }

    public boolean isRoot() {
        return Buildable.DefaultImpls.isRoot(this);
    }

    public void refreshLayout() {
        Buildable.DefaultImpls.refreshLayout(this);
    }

    public void setScope(IBlockScope iBlockScope) {
        Buildable.DefaultImpls.setScope(this, iBlockScope);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LeftImageBusinessItemWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f40575a = new LinkedHashMap();
        this.f40576b = new ArrayList();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LeftImageBusinessItemWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40575a;
    }

    public final LinearLayout getMContainer() {
        LinearLayout linearLayout = this.mContainer;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        return null;
    }

    public final void setMContainer(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.mContainer = linearLayout;
    }

    public final ImageWidget getMLogoWidget() {
        ImageWidget imageWidget = this.mLogoWidget;
        if (imageWidget != null) {
            return imageWidget;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mLogoWidget");
        return null;
    }

    public final void setMLogoWidget(ImageWidget imageWidget) {
        Intrinsics.checkNotNullParameter(imageWidget, "<set-?>");
        this.mLogoWidget = imageWidget;
    }

    public final ImageWidget getMHonorWidget() {
        ImageWidget imageWidget = this.mHonorWidget;
        if (imageWidget != null) {
            return imageWidget;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mHonorWidget");
        return null;
    }

    public final void setMHonorWidget(ImageWidget imageWidget) {
        Intrinsics.checkNotNullParameter(imageWidget, "<set-?>");
        this.mHonorWidget = imageWidget;
    }

    public View getView() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        super.initView();
        this.f40577c = DisplayUtils.dip2px(getContext(), 94.0f);
        this.f40579e = DisplayUtils.dip2px(getContext(), 8.5f);
        this.f40580f = DisplayUtils.dip2px(getContext(), 5.5f);
        this.f40581g = DisplayUtils.dip2px(getContext(), 0.5f);
        View findViewById = findViewById(R.id.customer_ll_shop_message_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.custom…l_shop_message_container)");
        setMContainer((LinearLayout) findViewById);
        View findViewById2 = findViewById(R.id.customer_custom_shop_logo);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_custom_shop_logo)");
        setMLogoWidget((ImageWidget) findViewById2);
        View findViewById3 = findViewById(R.id.customer_custom_shop_honor);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_custom_shop_honor)");
        setMHonorWidget((ImageWidget) findViewById3);
        getMImageWidget().setMStyle(43);
        getMImageWidget().setMDrawableId(R.drawable.customer_skin_img_topgun_placeholder_business_item);
        getMMaskWidget().setStyle(43);
        getMAdTagWidget().setStyle(43);
    }

    public void setBinderRootConfig(BinderRootConfig<?> binderRootConfig) {
        if (binderRootConfig == null) {
            binderRootConfig = null;
        }
        setConfig(binderRootConfig);
    }

    public void setWidgetNode(WidgetNodeModel widgetNodeModel) {
        ComponentModel componentModel = null;
        Object dataModel = widgetNodeModel == null ? null : widgetNodeModel.getDataModel();
        if (dataModel instanceof ComponentModel) {
            componentModel = (ComponentModel) dataModel;
        }
        bindActions(componentModel);
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        Map map = hashMap;
        return !(map == null || map.isEmpty());
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [kotlin.Unit] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindProps(java.util.HashMap<java.lang.String, java.lang.Object> r9) {
        /*
            r8 = this;
            if (r9 != 0) goto L_0x0004
            goto L_0x01cf
        L_0x0004:
            java.lang.String r0 = "image"
            java.lang.Object r0 = r9.get(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000e
            goto L_0x001d
        L_0x000e:
            com.didi.soda.customer.blocks.widget.ImageWidget r2 = r8.getMImageWidget()
            boolean r3 = r0 instanceof java.util.HashMap
            if (r3 == 0) goto L_0x0019
            java.util.HashMap r0 = (java.util.HashMap) r0
            goto L_0x001a
        L_0x0019:
            r0 = r1
        L_0x001a:
            r2.bindProps(r0)
        L_0x001d:
            java.lang.String r0 = "left_top_tag"
            java.lang.Object r0 = r9.get(r0)
            r2 = 0
            r3 = 8
            if (r0 != 0) goto L_0x002a
            r0 = r1
            goto L_0x0057
        L_0x002a:
            com.didi.soda.customer.blocks.widget.TagWidget r4 = r8.getMTagWidget()
            boolean r5 = r0 instanceof java.util.HashMap
            if (r5 == 0) goto L_0x0036
            r6 = r0
            java.util.HashMap r6 = (java.util.HashMap) r6
            goto L_0x0037
        L_0x0036:
            r6 = r1
        L_0x0037:
            r4.bindProps(r6)
            com.didi.soda.customer.blocks.widget.TagWidget r4 = r8.getMTagWidget()
            com.didi.soda.customer.blocks.widget.TagWidget r6 = r8.getMTagWidget()
            if (r5 == 0) goto L_0x0047
            java.util.HashMap r0 = (java.util.HashMap) r0
            goto L_0x0048
        L_0x0047:
            r0 = r1
        L_0x0048:
            boolean r0 = r6.shouldShow(r0)
            if (r0 == 0) goto L_0x0050
            r0 = 0
            goto L_0x0052
        L_0x0050:
            r0 = 8
        L_0x0052:
            r4.setVisibility(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0057:
            if (r0 != 0) goto L_0x0063
            r0 = r8
            com.didi.soda.customer.blocks.card.LeftImageBusinessItemWidget r0 = (com.didi.soda.customer.blocks.card.LeftImageBusinessItemWidget) r0
            com.didi.soda.customer.blocks.widget.TagWidget r0 = r0.getMTagWidget()
            r0.setVisibility(r3)
        L_0x0063:
            com.didi.soda.customer.blocks.widget.TagWidget r0 = r8.getMTagWidget()
            int r0 = r0.getVisibility()
            r4 = 110(0x6e, float:1.54E-43)
            if (r0 != r3) goto L_0x00d1
            java.lang.String r0 = "logo_img"
            java.lang.Object r0 = r9.get(r0)
            if (r0 != 0) goto L_0x0079
            r0 = r1
            goto L_0x00c4
        L_0x0079:
            com.didi.soda.customer.blocks.widget.ImageWidget r5 = r8.getMLogoWidget()
            r5.setMStyle(r4)
            com.didi.soda.customer.blocks.widget.ImageWidget r5 = r8.getMLogoWidget()
            r6 = 2131165622(0x7f0701b6, float:1.7945466E38)
            int r6 = com.didi.soda.customer.foundation.util.ResourceHelper.getDimensionPixelSize(r6)
            r5.setMImageRadius(r6)
            com.didi.soda.customer.blocks.widget.ImageWidget r5 = r8.getMLogoWidget()
            com.didi.app.nova.skeleton.image.RoundedCornersTransformation$CornerType r6 = com.didi.app.nova.skeleton.image.RoundedCornersTransformation.CornerType.BOTTOM
            r5.setMCornerType(r6)
            com.didi.soda.customer.blocks.widget.ImageWidget r5 = r8.getMLogoWidget()
            boolean r6 = r0 instanceof java.util.HashMap
            if (r6 == 0) goto L_0x00a3
            r7 = r0
            java.util.HashMap r7 = (java.util.HashMap) r7
            goto L_0x00a4
        L_0x00a3:
            r7 = r1
        L_0x00a4:
            r5.bindProps(r7)
            com.didi.soda.customer.blocks.widget.ImageWidget r5 = r8.getMLogoWidget()
            com.didi.soda.customer.blocks.widget.ImageWidget r7 = r8.getMLogoWidget()
            if (r6 == 0) goto L_0x00b4
            java.util.HashMap r0 = (java.util.HashMap) r0
            goto L_0x00b5
        L_0x00b4:
            r0 = r1
        L_0x00b5:
            boolean r0 = r7.shouldShow(r0)
            if (r0 == 0) goto L_0x00bd
            r0 = 0
            goto L_0x00bf
        L_0x00bd:
            r0 = 8
        L_0x00bf:
            r5.setVisibility(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x00c4:
            if (r0 != 0) goto L_0x00d8
            r0 = r8
            com.didi.soda.customer.blocks.card.LeftImageBusinessItemWidget r0 = (com.didi.soda.customer.blocks.card.LeftImageBusinessItemWidget) r0
            com.didi.soda.customer.blocks.widget.ImageWidget r0 = r0.getMLogoWidget()
            r0.setVisibility(r3)
            goto L_0x00d8
        L_0x00d1:
            com.didi.soda.customer.blocks.widget.ImageWidget r0 = r8.getMLogoWidget()
            r0.setVisibility(r3)
        L_0x00d8:
            java.lang.String r0 = "right_top_icon"
            java.lang.Object r0 = r9.get(r0)
            if (r0 != 0) goto L_0x00e3
            r0 = r1
            goto L_0x0125
        L_0x00e3:
            com.didi.soda.customer.blocks.widget.ImageWidget r5 = r8.getMHonorWidget()
            r5.setMStyle(r4)
            com.didi.soda.customer.blocks.widget.ImageWidget r4 = r8.getMHonorWidget()
            r5 = 2131165436(0x7f0700fc, float:1.794509E38)
            int r5 = com.didi.soda.customer.foundation.util.ResourceHelper.getDimensionPixelSize(r5)
            r4.setMImageRadius(r5)
            com.didi.soda.customer.blocks.widget.ImageWidget r4 = r8.getMHonorWidget()
            boolean r5 = r0 instanceof java.util.HashMap
            if (r5 == 0) goto L_0x0104
            r6 = r0
            java.util.HashMap r6 = (java.util.HashMap) r6
            goto L_0x0105
        L_0x0104:
            r6 = r1
        L_0x0105:
            r4.bindProps(r6)
            com.didi.soda.customer.blocks.widget.ImageWidget r4 = r8.getMHonorWidget()
            com.didi.soda.customer.blocks.widget.ImageWidget r6 = r8.getMHonorWidget()
            if (r5 == 0) goto L_0x0115
            java.util.HashMap r0 = (java.util.HashMap) r0
            goto L_0x0116
        L_0x0115:
            r0 = r1
        L_0x0116:
            boolean r0 = r6.shouldShow(r0)
            if (r0 == 0) goto L_0x011e
            r0 = 0
            goto L_0x0120
        L_0x011e:
            r0 = 8
        L_0x0120:
            r4.setVisibility(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0125:
            if (r0 != 0) goto L_0x0131
            r0 = r8
            com.didi.soda.customer.blocks.card.LeftImageBusinessItemWidget r0 = (com.didi.soda.customer.blocks.card.LeftImageBusinessItemWidget) r0
            com.didi.soda.customer.blocks.widget.ImageWidget r0 = r0.getMHonorWidget()
            r0.setVisibility(r3)
        L_0x0131:
            java.lang.String r0 = "status_mask"
            java.lang.Object r0 = r9.get(r0)
            if (r0 != 0) goto L_0x013c
            r0 = r1
            goto L_0x0169
        L_0x013c:
            com.didi.soda.customer.blocks.widget.MaskWidget r4 = r8.getMMaskWidget()
            boolean r5 = r0 instanceof java.util.HashMap
            if (r5 == 0) goto L_0x0148
            r6 = r0
            java.util.HashMap r6 = (java.util.HashMap) r6
            goto L_0x0149
        L_0x0148:
            r6 = r1
        L_0x0149:
            r4.bindProps(r6)
            com.didi.soda.customer.blocks.widget.MaskWidget r4 = r8.getMMaskWidget()
            com.didi.soda.customer.blocks.widget.MaskWidget r6 = r8.getMMaskWidget()
            if (r5 == 0) goto L_0x0159
            java.util.HashMap r0 = (java.util.HashMap) r0
            goto L_0x015a
        L_0x0159:
            r0 = r1
        L_0x015a:
            boolean r0 = r6.shouldShow(r0)
            if (r0 == 0) goto L_0x0162
            r0 = 0
            goto L_0x0164
        L_0x0162:
            r0 = 8
        L_0x0164:
            r4.setVisibility(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0169:
            if (r0 != 0) goto L_0x0175
            r0 = r8
            com.didi.soda.customer.blocks.card.LeftImageBusinessItemWidget r0 = (com.didi.soda.customer.blocks.card.LeftImageBusinessItemWidget) r0
            com.didi.soda.customer.blocks.widget.MaskWidget r0 = r0.getMMaskWidget()
            r0.setVisibility(r3)
        L_0x0175:
            java.lang.String r0 = "title"
            java.lang.Object r0 = r9.get(r0)
            if (r0 != 0) goto L_0x017f
            goto L_0x018e
        L_0x017f:
            com.didi.soda.customer.blocks.widget.TitleWidget r4 = r8.getMTitleWidget()
            boolean r5 = r0 instanceof java.util.HashMap
            if (r5 == 0) goto L_0x018a
            java.util.HashMap r0 = (java.util.HashMap) r0
            goto L_0x018b
        L_0x018a:
            r0 = r1
        L_0x018b:
            r4.bindProps(r0)
        L_0x018e:
            java.lang.String r0 = "right_top_tag"
            java.lang.Object r9 = r9.get(r0)
            if (r9 != 0) goto L_0x0198
            goto L_0x01c3
        L_0x0198:
            com.didi.soda.customer.blocks.widget.AdTagWidget r0 = r8.getMAdTagWidget()
            boolean r4 = r9 instanceof java.util.HashMap
            if (r4 == 0) goto L_0x01a4
            r5 = r9
            java.util.HashMap r5 = (java.util.HashMap) r5
            goto L_0x01a5
        L_0x01a4:
            r5 = r1
        L_0x01a5:
            r0.bindProps(r5)
            com.didi.soda.customer.blocks.widget.AdTagWidget r0 = r8.getMAdTagWidget()
            com.didi.soda.customer.blocks.widget.AdTagWidget r5 = r8.getMAdTagWidget()
            if (r4 == 0) goto L_0x01b5
            r1 = r9
            java.util.HashMap r1 = (java.util.HashMap) r1
        L_0x01b5:
            boolean r9 = r5.shouldShow(r1)
            if (r9 == 0) goto L_0x01bc
            goto L_0x01be
        L_0x01bc:
            r2 = 8
        L_0x01be:
            r0.setVisibility(r2)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x01c3:
            if (r1 != 0) goto L_0x01cf
            r9 = r8
            com.didi.soda.customer.blocks.card.LeftImageBusinessItemWidget r9 = (com.didi.soda.customer.blocks.card.LeftImageBusinessItemWidget) r9
            com.didi.soda.customer.blocks.widget.AdTagWidget r9 = r9.getMAdTagWidget()
            r9.setVisibility(r3)
        L_0x01cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.card.LeftImageBusinessItemWidget.bindProps(java.util.HashMap):void");
    }

    public void bindChildren(List<? extends Buildable> list) {
        Intrinsics.checkNotNullParameter(list, "children");
        Iterable<Buildable> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Buildable view : iterable) {
            arrayList.add(view.getView());
        }
        for (View addView : (List) arrayList) {
            getMContainer().addView(addView);
        }
    }

    public void onBindFinish(HashMap<String, Object> hashMap) {
        Map linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : getDynamicChildren().entrySet()) {
            if (((Buildable) entry.getValue()).getView().getVisibility() == 0) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (linkedHashMap.size() != 0) {
            if (m28819c(linkedHashMap)) {
                m28816a(linkedHashMap, (float) this.f40579e, (float) this.f40580f);
            } else {
                m28815a((Map<String, ? extends Buildable>) linkedHashMap);
            }
        }
    }

    /* renamed from: a */
    private final void m28816a(Map<String, ? extends Buildable> map, float f, float f2) {
        int i = 0;
        for (Object next : MapsKt.toList(map)) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) next;
            int i3 = i == 0 ? (int) f : (int) f2;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, i3, 0, 0);
            ((Buildable) pair.getSecond()).getView().setLayoutParams(layoutParams);
            i = i2;
        }
    }

    /* renamed from: a */
    private final void m28815a(Map<String, ? extends Buildable> map) {
        float f = (float) this.f40579e;
        float f2 = (float) this.f40580f;
        int size = map.size();
        if (size != 0) {
            if (size != 1) {
                Iterator it = this.f40576b.iterator();
                if (it.hasNext()) {
                    Object next = it.next();
                    while (it.hasNext()) {
                        next = Float.valueOf(((Number) next).floatValue() + ((Number) it.next()).floatValue());
                    }
                    f2 = ((((((float) this.f40577c) - this.f40578d) - ((Number) next).floatValue()) - ((float) this.f40579e)) - ((float) (this.f40581g * 2))) / ((float) (map.size() - 1));
                } else {
                    throw new UnsupportedOperationException("Empty collection can't be reduced.");
                }
            } else {
                f = ((((float) this.f40577c) - this.f40578d) - this.f40576b.get(0).floatValue()) - ((float) (this.f40581g * 2));
            }
            m28816a(map, f, f2);
        }
    }

    /* renamed from: a */
    private final float m28814a(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(getViewWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        return (float) view.getMeasuredHeight();
    }

    /* renamed from: b */
    private final float m28817b(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(getViewWidth() - DisplayUtils.dip2px(getContext(), 20.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        return (float) view.getMeasuredHeight();
    }

    /* access modifiers changed from: protected */
    public final int getViewWidth() {
        return CustomerSystemUtil.getScreenWidth(getContext()) - DisplayUtils.dip2px(getContext(), 176.0f);
    }

    /* renamed from: b */
    private final float m28818b(Map<String, ? extends Buildable> map) {
        this.f40576b.clear();
        float f = 0.0f;
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            float a = m28814a(((Buildable) next.getValue()).getView());
            f += a;
            this.f40576b.add(Float.valueOf(a));
        }
        return f;
    }

    /* renamed from: c */
    private final boolean m28819c(Map<String, ? extends Buildable> map) {
        float b = m28817b((View) getMTitleWidget());
        this.f40578d = b;
        if (m28818b(map) + ((float) (((map.size() - 1) * this.f40580f) + this.f40579e)) > (((float) this.f40577c) - b) - ((float) (this.f40581g * 2))) {
            return true;
        }
        return false;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/LeftImageBusinessItemWidget$Companion;", "", "()V", "ALIGN_OFFSET", "", "COMMON_DIVIDER_HEIGHT", "FIRST_DIVIDER_HEIGHT", "IMAGE_HEIGHT", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LeftImageBusinessItemWidget.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
