package com.didi.soda.customer.blocks.card.suapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.blocks.card.suapp.SaItemOperationListener;
import com.didi.soda.customer.blocks.widget.ImageWidget;
import com.didi.soda.customer.blocks.widget.TitleWidget;
import com.didi.soda.customer.foundation.rpc.entity.address.HomeAddressEntity;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IOneSdkService;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.CustomerRoundDrawable;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.google.android.material.badge.BadgeDrawable;
import com.taxis99.R;
import java.io.Serializable;
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

@WidgetNameMeta(widgetName = "sa_topic_row_item_v1")
@Metadata(mo175977d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 l2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001lB%\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0016\u00109\u001a\u00020:2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00020<H\u0016J0\u0010=\u001a\u00020:2&\u0010>\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020?\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020?\u0018\u0001`\u000fH\u0002J0\u0010@\u001a\u00020:2&\u0010>\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020?\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020?\u0018\u0001`\u000fH\u0016J\u0010\u0010A\u001a\u00020:2\u0006\u0010B\u001a\u00020\nH\u0016J\b\u0010C\u001a\u00020\nH\u0002J\b\u0010D\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u00020\n2\u0006\u0010G\u001a\u00020HH\u0002J\b\u0010J\u001a\u00020\nH\u0002J\b\u0010K\u001a\u00020\nH\u0016J\b\u0010L\u001a\u00020\nH\u0016J\b\u0010M\u001a\u00020EH\u0016J\u0010\u0010N\u001a\u00020:2\u0006\u0010O\u001a\u00020\nH\u0002J\u0001\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0010\u0010V\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010W\u0018\u00010<2]\u0010X\u001aY\u0012\u0013\u0012\u00110S¢\u0006\f\bZ\u0012\b\b[\u0012\u0004\b\b(R\u0012\u0015\u0012\u0013\u0018\u00010U¢\u0006\f\bZ\u0012\b\b[\u0012\u0004\b\b(\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\bZ\u0012\b\b[\u0012\u0004\b\b(]\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010W\u0018\u00010<\u0012\u0004\u0012\u00020:0YH\u0016J\b\u0010^\u001a\u00020:H\u0002J\b\u0010_\u001a\u00020:H\u0016J0\u0010`\u001a\u00020:2&\u0010>\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020?\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020?\u0018\u0001`\u000fH\u0016J(\u0010a\u001a\u00020:2\u0006\u0010b\u001a\u00020\n2\u0006\u0010c\u001a\u00020\n2\u0006\u0010d\u001a\u00020\n2\u0006\u0010e\u001a\u00020\nH\u0014J\u000e\u0010f\u001a\u00020:2\u0006\u0010g\u001a\u00020hJ\u0012\u0010i\u001a\u00020:2\b\u0010\\\u001a\u0004\u0018\u00010UH\u0016J0\u0010j\u001a\u00020Q2&\u0010>\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020?\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020?\u0018\u0001`\u000fH\u0016J\u0010\u0010k\u001a\u00020:2\u0006\u0010G\u001a\u00020HH\u0002R4\u0010\f\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00020\rj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0002`\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020!X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0001X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000¨\u0006m"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/suapp/SaTopicItemWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "Lcom/didi/soda/customer/blocks/card/suapp/SaItemOperationListener;", "Lcom/didi/soda/customer/blocks/card/suapp/IShadow;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "mImageHeight", "getMImageHeight", "()I", "setMImageHeight", "(I)V", "mImageWidget", "Lcom/didi/soda/customer/blocks/widget/ImageWidget;", "getMImageWidget", "()Lcom/didi/soda/customer/blocks/widget/ImageWidget;", "setMImageWidget", "(Lcom/didi/soda/customer/blocks/widget/ImageWidget;)V", "mLogoWidget", "getMLogoWidget", "setMLogoWidget", "mMessageContainer", "Landroid/widget/LinearLayout;", "getMMessageContainer", "()Landroid/widget/LinearLayout;", "setMMessageContainer", "(Landroid/widget/LinearLayout;)V", "mRoot", "getMRoot", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMRoot", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "mTitleWidget", "Lcom/didi/soda/customer/blocks/widget/TitleWidget;", "getMTitleWidget", "()Lcom/didi/soda/customer/blocks/widget/TitleWidget;", "setMTitleWidget", "(Lcom/didi/soda/customer/blocks/widget/TitleWidget;)V", "shadowHelper", "Lcom/didi/soda/customer/blocks/card/suapp/SaShadowHelper;", "shopRvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "topicModel", "Lcom/didi/soda/customer/blocks/card/suapp/SaTopicModel;", "trackSwBean", "Lcom/didi/soda/customer/blocks/card/suapp/TrackSwBean;", "bindChildren", "", "children", "", "bindImageData", "props", "", "bindProps", "fixContentHeight", "height", "getContainerWidth", "getContentView", "Landroid/view/View;", "getImageDrawable", "ratio", "", "getImageStyle", "getResId", "getShadowPaddingLeft", "getShadowPaddingRight", "getView", "handleClick", "index", "handleShownTrigger", "", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "widgetNodeModel", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "actions", "Lcom/didi/soda/blocks/action/BaseAction;", "handler", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "widgetNode", "widget", "initView", "onAppear", "onBindFinish", "onSizeChanged", "w", "h", "oldw", "oldh", "resetBtnStyle", "actionView", "Lcom/didi/soda/customer/blocks/card/suapp/SaTopicItemActionWidget;", "setWidgetNode", "shouldShow", "updateImageWidget", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SaTopicItemWidget.kt */
public final class SaTopicItemWidget extends ConstraintLayout implements Buildable, IShadow, SaItemOperationListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_NORMAL = 0;

    /* renamed from: a */
    private final HashMap<String, Buildable> f40638a;

    /* renamed from: b */
    private int f40639b;

    /* renamed from: c */
    private SaTopicModel f40640c;

    /* renamed from: d */
    private HomeBusinessInfoRvModel f40641d;

    /* renamed from: e */
    private C13683a f40642e;

    /* renamed from: f */
    private SaShadowHelper f40643f;
    public ImageWidget mImageWidget;
    public ImageWidget mLogoWidget;
    public LinearLayout mMessageContainer;
    public ConstraintLayout mRoot;
    public TitleWidget mTitleWidget;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SaTopicItemWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SaTopicItemWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* renamed from: c */
    private final int m28884c(float f) {
        return R.drawable.customer_skin_img_sa_placeholder;
    }

    private final int getResId() {
        return R.layout.customer_suapp_item_topic_blocks;
    }

    public void _$_clearFindViewByIdCache() {
    }

    public void bindStyles(HashMap<String, Object> hashMap) {
        Buildable.DefaultImpls.bindStyles(this, hashMap);
    }

    public void doWrapButton(boolean z) {
        SaItemOperationListener.DefaultImpls.doWrapButton(this, z);
    }

    public void doWrapTextLine(boolean z) {
        SaItemOperationListener.DefaultImpls.doWrapTextLine(this, z);
    }

    public Buildable findWidgetByComponentId(String str, int i) {
        return Buildable.DefaultImpls.findWidgetByComponentId(this, str, i);
    }

    public int getImageHeight() {
        return SaItemOperationListener.DefaultImpls.getImageHeight(this);
    }

    public Buildable getParentWidget() {
        return Buildable.DefaultImpls.getParentWidget(this);
    }

    public Buildable getRoot() {
        return Buildable.DefaultImpls.getRoot(this);
    }

    public int getWidgetType() {
        return SaItemOperationListener.DefaultImpls.getWidgetType(this);
    }

    public boolean handleClickTrigger(IBlockScope iBlockScope, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        return Buildable.DefaultImpls.handleClickTrigger(this, iBlockScope, list, function3);
    }

    public boolean handleOtherTrigger(IBlockScope iBlockScope, String str, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        return Buildable.DefaultImpls.handleOtherTrigger(this, iBlockScope, str, list, function3);
    }

    public boolean isRoot() {
        return Buildable.DefaultImpls.isRoot(this);
    }

    public void refreshLayout() {
        Buildable.DefaultImpls.refreshLayout(this);
    }

    public void setBinderRootConfig(BinderRootConfig<?> binderRootConfig) {
        Buildable.DefaultImpls.setBinderRootConfig(this, binderRootConfig);
    }

    public void setScope(IBlockScope iBlockScope) {
        Buildable.DefaultImpls.setScope(this, iBlockScope);
    }

    public boolean shouldWarpButton() {
        return SaItemOperationListener.DefaultImpls.shouldWarpButton(this);
    }

    public boolean shouldWarpTextLine() {
        return SaItemOperationListener.DefaultImpls.shouldWarpTextLine(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SaTopicItemWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SaTopicItemWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f40638a = new LinkedHashMap();
        m28878a();
        this.f40643f = new SaShadowHelper(this);
        int dimensionPixelSize = ResourceHelper.getDimensionPixelSize(R.dimen.customer_18px);
        setPadding(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40638a;
    }

    public final ConstraintLayout getMRoot() {
        ConstraintLayout constraintLayout = this.mRoot;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
        return null;
    }

    public final void setMRoot(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.mRoot = constraintLayout;
    }

    public final ImageWidget getMImageWidget() {
        ImageWidget imageWidget = this.mImageWidget;
        if (imageWidget != null) {
            return imageWidget;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mImageWidget");
        return null;
    }

    public final void setMImageWidget(ImageWidget imageWidget) {
        Intrinsics.checkNotNullParameter(imageWidget, "<set-?>");
        this.mImageWidget = imageWidget;
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

    public final TitleWidget getMTitleWidget() {
        TitleWidget titleWidget = this.mTitleWidget;
        if (titleWidget != null) {
            return titleWidget;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTitleWidget");
        return null;
    }

    public final void setMTitleWidget(TitleWidget titleWidget) {
        Intrinsics.checkNotNullParameter(titleWidget, "<set-?>");
        this.mTitleWidget = titleWidget;
    }

    public final LinearLayout getMMessageContainer() {
        LinearLayout linearLayout = this.mMessageContainer;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMessageContainer");
        return null;
    }

    public final void setMMessageContainer(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.mMessageContainer = linearLayout;
    }

    public final int getMImageHeight() {
        return this.f40639b;
    }

    public final void setMImageHeight(int i) {
        this.f40639b = i;
    }

    /* renamed from: a */
    private final void m28878a() {
        View inflate = LayoutInflater.from(getContext()).inflate(getResId(), this, true);
        View findViewById = inflate.findViewById(R.id.customer_su_topic_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_su_topic_root)");
        setMRoot((ConstraintLayout) findViewById);
        View findViewById2 = inflate.findViewById(R.id.customer_su_topic_image);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_su_topic_image)");
        setMImageWidget((ImageWidget) findViewById2);
        View findViewById3 = inflate.findViewById(R.id.customer_iv_su_topic_logo);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_iv_su_topic_logo)");
        setMLogoWidget((ImageWidget) findViewById3);
        View findViewById4 = inflate.findViewById(R.id.customer_su_topic_title);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.customer_su_topic_title)");
        setMTitleWidget((TitleWidget) findViewById4);
        getMTitleWidget().setLineSpacingExtra(ResourceHelper.getDimensionPixelSize(R.dimen.customer_4px));
        getMTitleWidget().setFontType(IToolsService.FontType.BOLD);
        View findViewById5 = inflate.findViewById(R.id.customer_ll_su_topic_message_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.custom…_topic_message_container)");
        setMMessageContainer((LinearLayout) findViewById5);
    }

    public int getShadowPaddingLeft() {
        return getPaddingLeft();
    }

    public int getShadowPaddingRight() {
        return getPaddingRight();
    }

    public View getContentView() {
        return getMRoot();
    }

    /* JADX WARNING: type inference failed for: r5v10, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void fixContentHeight(int r5) {
        /*
            r4 = this;
            androidx.constraintlayout.widget.ConstraintLayout r0 = r4.getMRoot()
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            if (r0 == 0) goto L_0x0087
            androidx.constraintlayout.widget.ConstraintLayout r1 = r4.getMRoot()
            int r1 = r1.getMeasuredHeight()
            int r1 = r5 - r1
            r0.height = r5
            androidx.constraintlayout.widget.ConstraintLayout r5 = r4.getMRoot()
            r5.setLayoutParams(r0)
            java.util.HashMap r5 = r4.getDynamicChildren()
            java.util.Collection r5 = r5.values()
            java.lang.String r0 = "dynamicChildren.values"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x0030:
            boolean r0 = r5.hasNext()
            r2 = 0
            if (r0 == 0) goto L_0x0047
            java.lang.Object r0 = r5.next()
            r3 = r0
            com.didi.soda.blocks.widget.Buildable r3 = (com.didi.soda.blocks.widget.Buildable) r3
            android.view.View r3 = r3.getView()
            boolean r3 = r3 instanceof com.didi.soda.customer.blocks.card.suapp.SaTopicItemActionWidget
            if (r3 == 0) goto L_0x0030
            goto L_0x0048
        L_0x0047:
            r0 = r2
        L_0x0048:
            com.didi.soda.blocks.widget.Buildable r0 = (com.didi.soda.blocks.widget.Buildable) r0
            if (r1 <= 0) goto L_0x0086
            if (r0 == 0) goto L_0x0086
            android.view.View r5 = r0.getView()
            int r5 = r5.getVisibility()
            if (r5 != 0) goto L_0x0086
            android.view.View r5 = r0.getView()
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
            boolean r3 = r5 instanceof android.widget.LinearLayout.LayoutParams
            if (r3 == 0) goto L_0x0067
            r2 = r5
            android.widget.LinearLayout$LayoutParams r2 = (android.widget.LinearLayout.LayoutParams) r2
        L_0x0067:
            r5 = r0
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            r3 = 80
            r5.setGravity(r3)
            if (r2 != 0) goto L_0x0072
            goto L_0x0086
        L_0x0072:
            android.view.View r5 = r0.getView()
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r1
            r2.height = r5
            android.view.View r5 = r0.getView()
            android.view.ViewGroup$LayoutParams r2 = (android.view.ViewGroup.LayoutParams) r2
            r5.setLayoutParams(r2)
        L_0x0086:
            return
        L_0x0087:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.card.suapp.SaTopicItemWidget.fixContentHeight(int):void");
    }

    public final void resetBtnStyle(SaTopicItemActionWidget saTopicItemActionWidget) {
        Intrinsics.checkNotNullParameter(saTopicItemActionWidget, "actionView");
        ViewGroup.LayoutParams layoutParams = saTopicItemActionWidget.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        saTopicItemActionWidget.setGravity(BadgeDrawable.TOP_START);
        if (layoutParams2 != null) {
            layoutParams2.height = -2;
            saTopicItemActionWidget.setLayoutParams(layoutParams2);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f40643f.onSizeChanged(i, i2, i3, i4);
    }

    public View getView() {
        return this;
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        Map map = hashMap;
        return !(map == null || map.isEmpty());
    }

    public void setWidgetNode(WidgetNodeModel widgetNodeModel) {
        Object obj;
        Object obj2;
        Buildable.DefaultImpls.setWidgetNode(this, widgetNodeModel);
        SaTopicModel saTopicModel = null;
        if (widgetNodeModel == null) {
            obj = null;
        } else {
            obj = widgetNodeModel.getDataModel();
        }
        ComponentModel componentModel = obj instanceof ComponentModel ? (ComponentModel) obj : null;
        if (componentModel == null) {
            obj2 = null;
        } else {
            obj2 = componentModel.getDataModel();
        }
        if (obj2 instanceof SaTopicModel) {
            saTopicModel = (SaTopicModel) obj2;
        }
        this.f40640c = saTopicModel;
    }

    public boolean handleShownTrigger(IBlockScope iBlockScope, WidgetNodeModel widgetNodeModel, List<? extends BaseAction> list, Function4<? super IBlockScope, ? super WidgetNodeModel, ? super Buildable, ? super List<? extends BaseAction>, Unit> function4) {
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(widgetNodeModel, "widgetNodeModel");
        Intrinsics.checkNotNullParameter(function4, "handler");
        this.f40642e = new C13683a(iBlockScope, widgetNodeModel, list, function4);
        return true;
    }

    public void bindChildren(List<? extends Buildable> list) {
        Intrinsics.checkNotNullParameter(list, "children");
        for (Buildable view : list) {
            getMMessageContainer().addView(view.getView());
        }
    }

    /* renamed from: a */
    private final void m28882a(HashMap<String, Object> hashMap) {
        Object obj;
        String str = null;
        if (!(hashMap == null || (obj = hashMap.get(BlocksConst.WIDGET_PARAMS_IMAGE_URL)) == null)) {
            str = obj.toString();
        }
        Context context = getContext();
        int mDrawableId = getMImageWidget().getMDrawableId();
        CustomerRoundDrawable.Corner corner = new CustomerRoundDrawable.Corner();
        corner.setLeftTopCorner((float) CustomerExtentionKt.getPx(R.dimen.rf_dimen_40));
        corner.setRightTopCorner((float) CustomerExtentionKt.getPx(R.dimen.rf_dimen_40));
        Unit unit = Unit.INSTANCE;
        Drawable customerRoundDrawable = new CustomerRoundDrawable(context, mDrawableId, corner);
        FlyImageLoader.loadImage4x3(getContext(), str).placeholder(customerRoundDrawable).error(customerRoundDrawable).transform(new RoundedCornersTransformation(getContext(), getMImageWidget().getMImageRadius(), 0, getMImageWidget().getMCornerType(), true)).into((ImageView) getMImageWidget());
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        Unit unit;
        Object obj;
        List<HomeBusinessInfoRvModel> shopRvList;
        String str;
        Object obj2;
        if (hashMap != null) {
            getMRoot().setLayoutParams(new ConstraintLayout.LayoutParams(getContainerWidth(), -2));
            boolean z = false;
            getMRoot().setPadding(0, 0, 0, ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_36));
            Object obj3 = hashMap.get("image");
            HomeBusinessInfoRvModel homeBusinessInfoRvModel = null;
            if (obj3 != null) {
                getMImageWidget().setMStyle(43);
                getMImageWidget().setMDrawableId(R.drawable.customer_skin_img_sa_placeholder);
                getMImageWidget().setMCornerType(RoundedCornersTransformation.CornerType.TOP);
                boolean z2 = obj3 instanceof HashMap;
                HashMap hashMap2 = z2 ? (HashMap) obj3 : null;
                if (hashMap2 == null || (obj2 = hashMap2.get(BlocksConst.WIDGET_PARAMS_IMAGE_ASPECT_ASTIO)) == null) {
                    str = null;
                } else {
                    str = obj2.toString();
                }
                CharSequence charSequence = str;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    m28879a(Float.parseFloat(str));
                }
                m28882a((HashMap<String, Object>) z2 ? (HashMap) obj3 : null);
            }
            Object obj4 = hashMap.get(BlocksConst.WIDGET_PARAMS_TYPE_TOP_IMG);
            if (obj4 == null) {
                unit = null;
            } else {
                getMLogoWidget().setVisibility(0);
                getMLogoWidget().setMStyle(110);
                getMLogoWidget().setMImageRadius(ResourceHelper.getDimensionPixelSize(R.dimen.customer_20px));
                getMLogoWidget().setMCornerType(RoundedCornersTransformation.CornerType.ALL);
                getMLogoWidget().bindProps(obj4 instanceof HashMap ? (HashMap) obj4 : null);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                getMLogoWidget().setVisibility(8);
            }
            Object obj5 = hashMap.get("title");
            if (obj5 != null) {
                getMTitleWidget().setMaxLines(1);
                getMTitleWidget().bindProps(obj5 instanceof HashMap ? (HashMap) obj5 : null);
            }
            if (hashMap == null) {
                obj = null;
            } else {
                obj = hashMap.get("native_index");
            }
            String valueOf = String.valueOf(obj);
            SaTopicModel saTopicModel = this.f40640c;
            if (!(saTopicModel == null || (shopRvList = saTopicModel.getShopRvList()) == null)) {
                homeBusinessInfoRvModel = shopRvList.get(Integer.parseInt(valueOf));
            }
            this.f40641d = homeBusinessInfoRvModel;
            if (valueOf.length() > 0) {
                z = true;
            }
            if (z) {
                setOnClickListener(new View.OnClickListener(valueOf) {
                    public final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        SaTopicItemWidget.m28881a(SaTopicItemWidget.this, this.f$1, view);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28881a(SaTopicItemWidget saTopicItemWidget, String str, View view) {
        Intrinsics.checkNotNullParameter(saTopicItemWidget, "this$0");
        Intrinsics.checkNotNullParameter(str, "$indexStr");
        saTopicItemWidget.m28880a(Integer.parseInt(str));
    }

    /* renamed from: a */
    private final void m28880a(int i) {
        Serializable serializable;
        HomeAddressEntity addressInfo;
        if (this.f40641d != null) {
            Uri.Builder appendPath = Uri.parse("taxis99OneTravel://soda").buildUpon().appendPath(RoutePath.BUSINESS_HOME);
            SaTopicModel saTopicModel = this.f40640c;
            String str = "";
            if (saTopicModel == null || (addressInfo = saTopicModel.getAddressInfo()) == null) {
                serializable = str;
            } else {
                serializable = addressInfo;
            }
            Uri.Builder appendQueryParameter = appendPath.appendQueryParameter("addressInfo", GsonUtil.toJson(serializable)).appendQueryParameter(Const.SABusiness.KEY_DIRECT_OPEN, "1").appendQueryParameter("from_channel", "1");
            HomeBusinessInfoRvModel homeBusinessInfoRvModel = this.f40641d;
            String str2 = null;
            ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).open(appendQueryParameter.appendQueryParameter(Const.PageParams.SHOP_ID, homeBusinessInfoRvModel == null ? null : homeBusinessInfoRvModel.mShopId).appendQueryParameter("action_type", "support").toString());
            SaOmegaHelper instance = SaOmegaHelper.Companion.getInstance();
            HomeBusinessInfoRvModel homeBusinessInfoRvModel2 = this.f40641d;
            Intrinsics.checkNotNull(homeBusinessInfoRvModel2);
            SaTopicModel saTopicModel2 = this.f40640c;
            int orZero = CustomerExtentionKt.getOrZero(saTopicModel2 == null ? null : Integer.valueOf(saTopicModel2.getScene()));
            SaTopicModel saTopicModel3 = this.f40640c;
            String actId = saTopicModel3 == null ? null : saTopicModel3.getActId();
            if (actId != null) {
                str = actId;
            }
            SaTopicModel saTopicModel4 = this.f40640c;
            if (saTopicModel4 != null) {
                str2 = saTopicModel4.getComponentId();
            }
            instance.trackLandingItemClick(homeBusinessInfoRvModel2, orZero, str, str2);
        }
    }

    /* renamed from: a */
    private final void m28879a(float f) {
        getMImageWidget().setMStyle(m28883b(f));
        getMImageWidget().setMDrawableId(m28884c(f));
        getMImageWidget().setMImageRadius(ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_40));
        int containerWidth = getContainerWidth();
        int i = (int) (((float) containerWidth) / f);
        this.f40639b = i;
        ViewGroup.LayoutParams layoutParams = getMImageWidget().getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.height = i;
            getMImageWidget().setLayoutParams(layoutParams2);
            getMImageWidget().setMWidth(containerWidth);
            getMImageWidget().setMHeight(i);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    /* renamed from: b */
    private final int m28883b(float f) {
        if (f == 1.0f) {
            return 115;
        }
        return ((double) Math.abs(f - 1.333333f)) <= 0.01d ? 435 : 0;
    }

    public void onBindFinish(HashMap<String, Object> hashMap) {
        Map linkedHashMap = new LinkedHashMap();
        Iterator it = getDynamicChildren().entrySet().iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            if (((Buildable) entry.getValue()).getView().getVisibility() == 0) {
                z = true;
            }
            if (z) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        int i = 0;
        for (Object next : MapsKt.toList(linkedHashMap)) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) next;
            int dimensionPixelSize = ResourceHelper.getDimensionPixelSize(R.dimen.customer_8px);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, dimensionPixelSize, 0, 0);
            ((Buildable) pair.getSecond()).getView().setLayoutParams(layoutParams);
            View view = ((Buildable) pair.getSecond()).getView();
            if (view instanceof SaTopicItemActionWidget) {
                resetBtnStyle((SaTopicItemActionWidget) view);
            }
            i = i2;
        }
    }

    public void onAppear() {
        if (this.f40641d != null) {
            SaOmegaHelper instance = SaOmegaHelper.Companion.getInstance();
            HomeBusinessInfoRvModel homeBusinessInfoRvModel = this.f40641d;
            Intrinsics.checkNotNull(homeBusinessInfoRvModel);
            SaTopicModel saTopicModel = this.f40640c;
            String str = null;
            int orZero = CustomerExtentionKt.getOrZero(saTopicModel == null ? null : Integer.valueOf(saTopicModel.getScene()));
            SaTopicModel saTopicModel2 = this.f40640c;
            String actId = saTopicModel2 == null ? null : saTopicModel2.getActId();
            if (actId == null) {
                actId = "";
            }
            SaTopicModel saTopicModel3 = this.f40640c;
            if (saTopicModel3 != null) {
                str = saTopicModel3.getComponentId();
            }
            instance.landingitemExposure(homeBusinessInfoRvModel, orZero, actId, str);
            return;
        }
        C13683a aVar = this.f40642e;
        if (aVar != null) {
            aVar.mo102525d().invoke(aVar.mo102518a(), aVar.mo102523b(), this, aVar.mo102524c());
        }
    }

    private final int getContainerWidth() {
        return ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_301);
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/suapp/SaTopicItemWidget$Companion;", "", "()V", "TYPE_NORMAL", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SaTopicItemWidget.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
