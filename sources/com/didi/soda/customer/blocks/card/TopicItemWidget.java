package com.didi.soda.customer.blocks.card;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.blocks.ItemOperationListener;
import com.didi.soda.customer.blocks.widget.ImageWidget;
import com.didi.soda.customer.blocks.widget.MaskWidget;
import com.didi.soda.customer.blocks.widget.TagWidget;
import com.didi.soda.customer.blocks.widget.TitleWidget;
import com.didi.soda.customer.blocks.widget.TopicPriceActionWidget;
import com.didi.soda.customer.foundation.util.ColorUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.text.RichTextView;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.didi.soda.home.topgun.binder.model.HomeHorizontalScrollTopicRvModel;
import com.didi.soda.home.topgun.manager.HomeBusinessPool;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.router.DiRouter;
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

@WidgetNameMeta(widgetName = "topic_row_item_v1")
@Metadata(mo175977d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0007\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0001B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010]\u001a\u00020^2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00020`H\u0016J0\u0010a\u001a\u00020^2&\u0010b\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0014H\u0016J\u0016\u0010c\u001a\u00020d2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\t0`H\u0002J\u0010\u0010f\u001a\u00020^2\u0006\u0010g\u001a\u00020\u001eH\u0016J\u0010\u0010h\u001a\u00020^2\u0006\u0010g\u001a\u00020\u001eH\u0016J\b\u0010i\u001a\u0004\u0018\u00010jJ\u0012\u0010k\u001a\u00020\t2\b\u0010X\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010l\u001a\u00020\t2\b\u0010X\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010m\u001a\u00020\t2\u0006\u0010n\u001a\u00020oH\u0002J\b\u0010p\u001a\u00020\tH\u0016J\u0012\u0010q\u001a\u00020\t2\b\u0010X\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010r\u001a\u00020\t2\u0006\u0010n\u001a\u00020oH\u0002J\b\u0010s\u001a\u00020\tH\u0002J\b\u0010t\u001a\u00020uH\u0016J\b\u0010Y\u001a\u00020\tH\u0016J\u0001\u0010v\u001a\u00020\u001e2\u0006\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020z2\u0010\u0010{\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010|\u0018\u00010`2b\u0010}\u001a^\u0012\u0014\u0012\u00120x¢\u0006\r\b\u0012\t\b\u0001\u0012\u0004\b\b(w\u0012\u0017\u0012\u0015\u0018\u00010z¢\u0006\u000e\b\u0012\n\b\u0001\u0012\u0005\b\b(\u0001\u0012\u0015\u0012\u00130\u0002¢\u0006\u000e\b\u0012\n\b\u0001\u0012\u0005\b\b(\u0001\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010|\u0018\u00010`\u0012\u0004\u0012\u00020^0~H\u0016J\t\u0010\u0001\u001a\u00020^H\u0002J\t\u0010\u0001\u001a\u00020^H\u0016J1\u0010\u0001\u001a\u00020^2&\u0010b\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0014H\u0016J\u0012\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020\fH\u0002J\u0013\u0010\u0001\u001a\u00020^2\b\u0010X\u001a\u0004\u0018\u00010\u0013H\u0002J\u0014\u0010\u0001\u001a\u00020^2\t\u0010\u0001\u001a\u0004\u0018\u00010zH\u0016J1\u0010\u0001\u001a\u00020\u001e2&\u0010b\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0014H\u0016J\t\u0010\u0001\u001a\u00020\u001eH\u0016J\t\u0010\u0001\u001a\u00020\u001eH\u0016J\u001f\u0010\u0001\u001a\u00020^2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00132\t\u0010\u0001\u001a\u0004\u0018\u00010\u0013H\u0002J\u0013\u0010\u0001\u001a\u00020^2\b\u0010X\u001a\u0004\u0018\u00010\u0013H\u0002J\u001b\u0010\u0001\u001a\u00020^2\b\u0010X\u001a\u0004\u0018\u00010\u00132\u0006\u0010n\u001a\u00020oH\u0002J\u0010\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020\tJ\u0013\u0010\u0001\u001a\u00020^2\b\u0010X\u001a\u0004\u0018\u00010\u0013H\u0002J\u0013\u0010\u0001\u001a\u00020^2\b\u0010X\u001a\u0004\u0018\u00010\u0013H\u0002J\u0013\u0010\u0001\u001a\u00020^2\b\u0010X\u001a\u0004\u0018\u00010\u0013H\u0002R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R4\u0010\u0011\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00020\u0012j\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0002`\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020+X.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\u001a\u00103\u001a\u000204X.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020:X.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020\u0001X.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020EX.¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020KX.¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001c\u0010P\u001a\u0004\u0018\u00010QX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0010\u0010V\u001a\u0004\u0018\u00010WX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010X\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\¨\u0006\u0001"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/TopicItemWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "Lcom/didi/soda/customer/blocks/ItemOperationListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "businessInfoRvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "getBusinessInfoRvModel", "()Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "setBusinessInfoRvModel", "(Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;)V", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "imageMap", "", "getImageMap", "()Ljava/lang/Object;", "setImageMap", "(Ljava/lang/Object;)V", "isShop", "", "mBannerWidget", "Lcom/didi/soda/customer/widget/text/RichTextView;", "getMBannerWidget", "()Lcom/didi/soda/customer/widget/text/RichTextView;", "setMBannerWidget", "(Lcom/didi/soda/customer/widget/text/RichTextView;)V", "mImageHeight", "getMImageHeight", "()I", "setMImageHeight", "(I)V", "mImageWidget", "Lcom/didi/soda/customer/blocks/widget/ImageWidget;", "getMImageWidget", "()Lcom/didi/soda/customer/blocks/widget/ImageWidget;", "setMImageWidget", "(Lcom/didi/soda/customer/blocks/widget/ImageWidget;)V", "mLogoWidget", "getMLogoWidget", "setMLogoWidget", "mMaskWidget", "Lcom/didi/soda/customer/blocks/widget/MaskWidget;", "getMMaskWidget", "()Lcom/didi/soda/customer/blocks/widget/MaskWidget;", "setMMaskWidget", "(Lcom/didi/soda/customer/blocks/widget/MaskWidget;)V", "mMessageContainer", "Landroid/widget/LinearLayout;", "getMMessageContainer", "()Landroid/widget/LinearLayout;", "setMMessageContainer", "(Landroid/widget/LinearLayout;)V", "mRoot", "getMRoot", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMRoot", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "mTagWidget", "Lcom/didi/soda/customer/blocks/widget/TagWidget;", "getMTagWidget", "()Lcom/didi/soda/customer/blocks/widget/TagWidget;", "setMTagWidget", "(Lcom/didi/soda/customer/blocks/widget/TagWidget;)V", "mTitleWidget", "Lcom/didi/soda/customer/blocks/widget/TitleWidget;", "getMTitleWidget", "()Lcom/didi/soda/customer/blocks/widget/TitleWidget;", "setMTitleWidget", "(Lcom/didi/soda/customer/blocks/widget/TitleWidget;)V", "mTopicRvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeHorizontalScrollTopicRvModel;", "getMTopicRvModel", "()Lcom/didi/soda/home/topgun/binder/model/HomeHorizontalScrollTopicRvModel;", "setMTopicRvModel", "(Lcom/didi/soda/home/topgun/binder/model/HomeHorizontalScrollTopicRvModel;)V", "trackSwBean", "Lcom/didi/soda/customer/blocks/card/TrackSwBean;", "widgetType", "getWidgetType", "()Ljava/lang/String;", "setWidgetType", "(Ljava/lang/String;)V", "bindChildren", "", "children", "", "bindProps", "props", "createRectangleDrawable", "Landroid/graphics/drawable/GradientDrawable;", "colors", "doWrapButton", "needWrap", "doWrapTextLine", "findPriceActionWidget", "Lcom/didi/soda/customer/blocks/widget/TopicPriceActionWidget;", "getContainerPadding", "getContainerWidth", "getImageDrawable", "ratio", "", "getImageHeight", "getImageRadius", "getImageStyle", "getResId", "getView", "Landroid/view/View;", "handleShownTrigger", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "widgetNodeModel", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "actions", "Lcom/didi/soda/blocks/action/BaseAction;", "handler", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "widgetNode", "widget", "initView", "onAppear", "onBindFinish", "openBusinessHomePage", "rvModel", "setMaskStyle", "setWidgetNode", "shouldShow", "shouldWarpButton", "shouldWarpTextLine", "updateBannerText", "content", "colorsStr", "updateContainerPadding", "updateImageWidget", "updateImageWidgetHeight", "gapHeight", "updateRootContainer", "updateRootRadius", "updateTitleWidget", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopicItemWidget.kt */
public final class TopicItemWidget extends ConstraintLayout implements Buildable, ItemOperationListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final float MID_MARGIN = 20.0f;
    public static final int TYPE_ATMOSPHERE = 1;
    public static final int TYPE_LANDING_ATMOSPHERE = 2;
    public static final int TYPE_LANDING_NORMAL = 3;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_TOPIC_MASK = 10000;

    /* renamed from: a */
    private final HashMap<String, Buildable> f40596a;

    /* renamed from: b */
    private HomeHorizontalScrollTopicRvModel f40597b;

    /* renamed from: c */
    private int f40598c;

    /* renamed from: d */
    private HomeBusinessInfoRvModel f40599d;

    /* renamed from: e */
    private Object f40600e;

    /* renamed from: f */
    private String f40601f;

    /* renamed from: g */
    private C13682c f40602g;

    /* renamed from: h */
    private boolean f40603h;
    public RichTextView mBannerWidget;
    public ImageWidget mImageWidget;
    public ImageWidget mLogoWidget;
    public MaskWidget mMaskWidget;
    public LinearLayout mMessageContainer;
    public ConstraintLayout mRoot;
    public TagWidget mTagWidget;
    public TitleWidget mTitleWidget;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TopicItemWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TopicItemWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* renamed from: a */
    private final int m28831a(float f) {
        boolean z = true;
        if (f == 1.0f) {
            return 115;
        }
        if (f != 1.333333f) {
            z = false;
        }
        return z ? 435 : 0;
    }

    /* renamed from: b */
    private final int m28840b(float f) {
        return (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1)) == 0 ? R.drawable.customer_skin_img_business_goods_item_x11 : R.drawable.customer_skin_img_topgun_placeholder_business_item;
    }

    private final int getResId() {
        return R.layout.customer_item_topic_blocks;
    }

    public void _$_clearFindViewByIdCache() {
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TopicItemWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopicItemWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f40596a = new LinkedHashMap();
        m28834a();
        setBackgroundResource(R.drawable.customer_shape_topic_item_bg);
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40596a;
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

    public final TagWidget getMTagWidget() {
        TagWidget tagWidget = this.mTagWidget;
        if (tagWidget != null) {
            return tagWidget;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTagWidget");
        return null;
    }

    public final void setMTagWidget(TagWidget tagWidget) {
        Intrinsics.checkNotNullParameter(tagWidget, "<set-?>");
        this.mTagWidget = tagWidget;
    }

    public final RichTextView getMBannerWidget() {
        RichTextView richTextView = this.mBannerWidget;
        if (richTextView != null) {
            return richTextView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBannerWidget");
        return null;
    }

    public final void setMBannerWidget(RichTextView richTextView) {
        Intrinsics.checkNotNullParameter(richTextView, "<set-?>");
        this.mBannerWidget = richTextView;
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

    public final MaskWidget getMMaskWidget() {
        MaskWidget maskWidget = this.mMaskWidget;
        if (maskWidget != null) {
            return maskWidget;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMaskWidget");
        return null;
    }

    public final void setMMaskWidget(MaskWidget maskWidget) {
        Intrinsics.checkNotNullParameter(maskWidget, "<set-?>");
        this.mMaskWidget = maskWidget;
    }

    public final HomeHorizontalScrollTopicRvModel getMTopicRvModel() {
        return this.f40597b;
    }

    public final void setMTopicRvModel(HomeHorizontalScrollTopicRvModel homeHorizontalScrollTopicRvModel) {
        this.f40597b = homeHorizontalScrollTopicRvModel;
    }

    public final int getMImageHeight() {
        return this.f40598c;
    }

    public final void setMImageHeight(int i) {
        this.f40598c = i;
    }

    public final HomeBusinessInfoRvModel getBusinessInfoRvModel() {
        return this.f40599d;
    }

    public final void setBusinessInfoRvModel(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        this.f40599d = homeBusinessInfoRvModel;
    }

    public final Object getImageMap() {
        return this.f40600e;
    }

    public final void setImageMap(Object obj) {
        this.f40600e = obj;
    }

    /* renamed from: getWidgetType  reason: collision with other method in class */
    public final String m46880getWidgetType() {
        return this.f40601f;
    }

    public final void setWidgetType(String str) {
        this.f40601f = str;
    }

    public boolean handleShownTrigger(IBlockScope iBlockScope, WidgetNodeModel widgetNodeModel, List<? extends BaseAction> list, Function4<? super IBlockScope, ? super WidgetNodeModel, ? super Buildable, ? super List<? extends BaseAction>, Unit> function4) {
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(widgetNodeModel, "widgetNodeModel");
        Intrinsics.checkNotNullParameter(function4, "handler");
        this.f40602g = new C13682c(iBlockScope, widgetNodeModel, list, function4);
        return true;
    }

    /* renamed from: a */
    private final void m28834a() {
        setMRoot((ConstraintLayout) getView());
        View inflate = LayoutInflater.from(getContext()).inflate(getResId(), this, true);
        View findViewById = inflate.findViewById(R.id.customer_topic_shop_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_topic_shop_image)");
        setMImageWidget((ImageWidget) findViewById);
        View findViewById2 = inflate.findViewById(R.id.customer_iv_topic_shop_logo);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_iv_topic_shop_logo)");
        setMLogoWidget((ImageWidget) findViewById2);
        View findViewById3 = inflate.findViewById(R.id.customer_topic_shop_tag);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_topic_shop_tag)");
        setMTagWidget((TagWidget) findViewById3);
        View findViewById4 = inflate.findViewById(R.id.customer_tv_topic_banner_text);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.customer_tv_topic_banner_text)");
        setMBannerWidget((RichTextView) findViewById4);
        View findViewById5 = inflate.findViewById(R.id.customer_topic_shop_name);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.customer_topic_shop_name)");
        setMTitleWidget((TitleWidget) findViewById5);
        getMTitleWidget().setLineSpacingExtra(ResourceHelper.getDimensionPixelSize(R.dimen.customer_4px));
        View findViewById6 = inflate.findViewById(R.id.customer_ll_topic_shop_message_container);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.custom…c_shop_message_container)");
        setMMessageContainer((LinearLayout) findViewById6);
        View findViewById7 = inflate.findViewById(R.id.customer_custom_shop_status_mask);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.custom…_custom_shop_status_mask)");
        setMMaskWidget((MaskWidget) findViewById7);
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
        Object obj3;
        HashMap contextParams;
        Buildable.DefaultImpls.setWidgetNode(this, widgetNodeModel);
        Boolean bool = null;
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
        this.f40597b = obj2 instanceof HomeHorizontalScrollTopicRvModel ? (HomeHorizontalScrollTopicRvModel) obj2 : null;
        if (widgetNodeModel == null || (contextParams = widgetNodeModel.getContextParams()) == null) {
            obj3 = null;
        } else {
            obj3 = contextParams.get(BlocksConst.KEY_TOPIC_ITEM_ISSHOP);
        }
        if (obj3 instanceof Boolean) {
            bool = (Boolean) obj3;
        }
        this.f40603h = Intrinsics.areEqual((Object) bool, (Object) true);
    }

    public void bindChildren(List<? extends Buildable> list) {
        Intrinsics.checkNotNullParameter(list, "children");
        Iterable<Buildable> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Buildable view : iterable) {
            arrayList.add(view.getView());
        }
        for (View addView : (List) arrayList) {
            getMMessageContainer().addView(addView);
        }
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        Object obj;
        Unit unit;
        Unit unit2;
        Unit unit3;
        String str;
        String str2;
        Object obj2;
        Object obj3;
        String str3;
        Object obj4;
        boolean z = true;
        HomeBusinessInfoRvModel homeBusinessInfoRvModel = null;
        if (hashMap != null) {
            Object obj5 = hashMap.get(BlocksConst.WIDGET_PARAMS_TYPE_WIDGET_TYPE);
            setWidgetType(obj5 == null ? null : obj5.toString());
            setLayoutParams(new LinearLayout.LayoutParams(m28846g(getWidgetType()), -2));
            m28841b(getWidgetType());
            setMaskStyle(getWidgetType());
            Object obj6 = hashMap.get("image");
            if (obj6 != null) {
                getMImageWidget().setMStyle(43);
                getMImageWidget().setMDrawableId(R.drawable.customer_skin_img_topgun_placeholder_business_item);
                boolean z2 = obj6 instanceof HashMap;
                HashMap hashMap2 = z2 ? (HashMap) obj6 : null;
                if (hashMap2 == null || (obj4 = hashMap2.get(BlocksConst.WIDGET_PARAMS_IMAGE_ASPECT_ASTIO)) == null) {
                    str3 = null;
                } else {
                    str3 = obj4.toString();
                }
                CharSequence charSequence = str3;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    m28838a(getWidgetType(), Float.parseFloat(str3));
                }
                String widgetType = getWidgetType();
                if (widgetType != null && Integer.parseInt(widgetType) == 2) {
                    setImageMap(obj6);
                } else {
                    getMImageWidget().bindProps(z2 ? (HashMap) obj6 : null);
                }
            }
            Object obj7 = hashMap.get(BlocksConst.WIDGET_PARAMS_TYPE_TAG);
            if (obj7 == null) {
                unit = null;
            } else {
                boolean z3 = obj7 instanceof HashMap;
                getMTagWidget().bindProps(z3 ? (HashMap) obj7 : null);
                getMTagWidget().setVisibility(getMTagWidget().shouldShow(z3 ? (HashMap) obj7 : null) ? 0 : 8);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                getMTagWidget().setVisibility(8);
            }
            if (getMTagWidget().getVisibility() == 8) {
                Object obj8 = hashMap.get(BlocksConst.WIDGET_PARAMS_TYPE_TOP_IMG);
                if (obj8 != null) {
                    getMLogoWidget().setVisibility(0);
                    getMLogoWidget().setMStyle(110);
                    getMLogoWidget().setMImageRadius(ResourceHelper.getDimensionPixelSize(R.dimen.customer_4px));
                    getMLogoWidget().setMCornerType(RoundedCornersTransformation.CornerType.BOTTOM);
                    getMLogoWidget().bindProps(obj8 instanceof HashMap ? (HashMap) obj8 : null);
                }
            } else {
                getMLogoWidget().setVisibility(8);
            }
            Object obj9 = hashMap.get(BlocksConst.WIDGET_PARAMS_TYPE_IMAGE_TEXT_BANNER);
            if (obj9 == null) {
                unit2 = null;
            } else {
                HashMap hashMap3 = obj9 instanceof HashMap ? (HashMap) obj9 : null;
                if (hashMap3 == null || (obj3 = hashMap3.get("content")) == null) {
                    str = null;
                } else {
                    str = obj3.toString();
                }
                if (hashMap3 == null || (obj2 = hashMap3.get(BlocksConst.WIDGET_PARAMS_GRADIENT_COLORS)) == null) {
                    str2 = null;
                } else {
                    str2 = obj2.toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    m28839a(str, str2);
                    getMBannerWidget().setVisibility(0);
                } else {
                    getMBannerWidget().setVisibility(8);
                }
                unit2 = Unit.INSTANCE;
            }
            if (unit2 == null) {
                getMBannerWidget().setVisibility(8);
            }
            Object obj10 = hashMap.get("title");
            if (obj10 != null) {
                m28844e(getWidgetType());
                getMTitleWidget().bindProps(obj10 instanceof HashMap ? (HashMap) obj10 : null);
            }
            Object obj11 = hashMap.get(BlocksConst.WIDGET_PARAMS_TYPE_MASKING_STATUS);
            if (obj11 == null) {
                unit3 = null;
            } else {
                boolean z4 = obj11 instanceof HashMap;
                getMMaskWidget().bindProps(z4 ? (HashMap) obj11 : null);
                getMMaskWidget().setVisibility(getMMaskWidget().shouldShow(z4 ? (HashMap) obj11 : null) ? 0 : 8);
                unit3 = Unit.INSTANCE;
            }
            if (unit3 == null) {
                getMMaskWidget().setVisibility(8);
            }
        }
        if (hashMap == null) {
            obj = null;
        } else {
            obj = hashMap.get("native_index");
        }
        String valueOf = String.valueOf(obj);
        if (valueOf.length() > 0) {
            try {
                HomeHorizontalScrollTopicRvModel homeHorizontalScrollTopicRvModel = this.f40597b;
                Collection collection = homeHorizontalScrollTopicRvModel == null ? null : homeHorizontalScrollTopicRvModel.mBusinessInfoRvModels;
                if (collection != null) {
                    if (!collection.isEmpty()) {
                        z = false;
                    }
                }
                if (!z) {
                    HomeHorizontalScrollTopicRvModel homeHorizontalScrollTopicRvModel2 = this.f40597b;
                    if (homeHorizontalScrollTopicRvModel2 != null) {
                        List<HomeBusinessInfoRvModel> list = homeHorizontalScrollTopicRvModel2.mBusinessInfoRvModels;
                        if (list != null) {
                            homeBusinessInfoRvModel = list.get(Integer.parseInt(valueOf));
                        }
                    }
                    this.f40599d = homeBusinessInfoRvModel;
                    getView().setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            TopicItemWidget.m28836a(TopicItemWidget.this, view);
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28836a(TopicItemWidget topicItemWidget, View view) {
        Intrinsics.checkNotNullParameter(topicItemWidget, "this$0");
        HomeBusinessInfoRvModel businessInfoRvModel = topicItemWidget.getBusinessInfoRvModel();
        if (businessInfoRvModel != null) {
            HomeOmegaHelper.getInstance().setOmegaGuideParam(businessInfoRvModel);
            HomeOmegaHelper.getInstance().onOmegaBusinessCk(businessInfoRvModel, true);
            topicItemWidget.m28837a(businessInfoRvModel);
        }
    }

    private final void setMaskStyle(String str) {
        boolean z = false;
        if (str != null && Integer.parseInt(str) == 2) {
            z = true;
        }
        if (z) {
            getMMaskWidget().setStyle(2);
        } else {
            getMMaskWidget().setStyle(10000);
        }
    }

    /* renamed from: a */
    private final void m28838a(String str, float f) {
        getMImageWidget().setMStyle(m28831a(f));
        getMImageWidget().setMDrawableId(m28840b(f));
        getMImageWidget().setMImageRadius(m28832a(str));
        int g = m28846g(str) - (m28845f(str) * 2);
        int i = (int) (((float) g) / f);
        this.f40598c = i;
        ViewGroup.LayoutParams layoutParams = getMImageWidget().getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.height = i;
            getMImageWidget().setLayoutParams(layoutParams2);
            getMImageWidget().setMWidth(g);
            getMImageWidget().setMHeight(i);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void updateImageWidgetHeight(int i) {
        String str = this.f40601f;
        if (str != null && Integer.parseInt(str) == 2) {
            if (i > 0) {
                getMImageWidget().setMStyle(0);
                ViewGroup.LayoutParams layoutParams = getMImageWidget().getLayoutParams();
                layoutParams.height += i;
                getMImageWidget().setLayoutParams(layoutParams);
            }
            post(new Runnable() {
                public final void run() {
                    TopicItemWidget.m28835a(TopicItemWidget.this);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28835a(TopicItemWidget topicItemWidget) {
        Intrinsics.checkNotNullParameter(topicItemWidget, "this$0");
        ImageWidget mImageWidget2 = topicItemWidget.getMImageWidget();
        Object imageMap = topicItemWidget.getImageMap();
        mImageWidget2.bindProps(imageMap instanceof HashMap ? (HashMap) imageMap : null);
    }

    /* renamed from: a */
    private final int m28832a(String str) {
        boolean z = false;
        if (str != null && Integer.parseInt(str) == 3) {
            z = true;
        }
        if (z) {
            return ResourceHelper.getDimensionPixelSize(R.dimen.customer_12px);
        }
        return ResourceHelper.getDimensionPixelSize(R.dimen.customer_8px);
    }

    public void onBindFinish(HashMap<String, Object> hashMap) {
        int i;
        Map linkedHashMap = new LinkedHashMap();
        Iterator it = getDynamicChildren().entrySet().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            if (((Buildable) entry.getValue()).getView().getVisibility() != 0) {
                z = false;
            }
            if (z) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        int i2 = 0;
        for (Object next : MapsKt.toList(linkedHashMap)) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) next;
            String widgetType = getWidgetType();
            if (!(widgetType != null && Integer.parseInt(widgetType) == 2)) {
                String widgetType2 = getWidgetType();
                if (!(widgetType2 != null && Integer.parseInt(widgetType2) == 0)) {
                    i = ResourceHelper.getDimensionPixelSize(R.dimen.customer_9px);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.setMargins(0, i, 0, 0);
                    ((Buildable) pair.getSecond()).getView().setLayoutParams(layoutParams);
                    i2 = i3;
                }
            }
            i = ResourceHelper.getDimensionPixelSize(R.dimen.customer_12px);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(0, i, 0, 0);
            ((Buildable) pair.getSecond()).getView().setLayoutParams(layoutParams2);
            i2 = i3;
        }
    }

    public int getImageHeight() {
        return this.f40598c;
    }

    public boolean shouldWarpTextLine() {
        boolean z = false;
        for (Map.Entry value : getDynamicChildren().entrySet()) {
            View view = ((Buildable) value.getValue()).getView();
            TopicPriceActionWidget topicPriceActionWidget = view instanceof TopicPriceActionWidget ? (TopicPriceActionWidget) view : null;
            if (topicPriceActionWidget != null && topicPriceActionWidget.isPriceTextWrapNeed()) {
                z = true;
            }
        }
        return z;
    }

    public boolean shouldWarpButton() {
        boolean z = false;
        for (Map.Entry value : getDynamicChildren().entrySet()) {
            View view = ((Buildable) value.getValue()).getView();
            TopicPriceActionWidget topicPriceActionWidget = view instanceof TopicPriceActionWidget ? (TopicPriceActionWidget) view : null;
            if (topicPriceActionWidget != null && topicPriceActionWidget.isButtonWrapNeed()) {
                z = true;
            }
        }
        return z;
    }

    public final TopicPriceActionWidget findPriceActionWidget() {
        for (Map.Entry value : getDynamicChildren().entrySet()) {
            View view = ((Buildable) value.getValue()).getView();
            if (view instanceof TopicPriceActionWidget) {
                return (TopicPriceActionWidget) view;
            }
        }
        return null;
    }

    public void doWrapButton(boolean z) {
        for (Map.Entry value : getDynamicChildren().entrySet()) {
            View view = ((Buildable) value.getValue()).getView();
            TopicPriceActionWidget topicPriceActionWidget = view instanceof TopicPriceActionWidget ? (TopicPriceActionWidget) view : null;
            if (topicPriceActionWidget != null) {
                topicPriceActionWidget.setButtonWrap(z);
            }
        }
    }

    public void doWrapTextLine(boolean z) {
        for (Map.Entry value : getDynamicChildren().entrySet()) {
            View view = ((Buildable) value.getValue()).getView();
            TopicPriceActionWidget topicPriceActionWidget = view instanceof TopicPriceActionWidget ? (TopicPriceActionWidget) view : null;
            if (topicPriceActionWidget != null) {
                topicPriceActionWidget.setPriceTextWrap(z);
            }
        }
    }

    public int getWidgetType() {
        Integer num;
        String str = this.f40601f;
        if (str == null) {
            return 0;
        }
        if (str == null) {
            num = null;
        } else {
            num = Integer.valueOf(Integer.parseInt(str));
        }
        if ((num != null && num.intValue() == 1) || num == null) {
            return 0;
        }
        num.intValue();
        return 0;
    }

    public void onAppear() {
        if (!this.f40603h) {
            C13682c cVar = this.f40602g;
            if (cVar != null) {
                cVar.mo102465d().invoke(cVar.mo102458a(), cVar.mo102463b(), this, cVar.mo102464c());
            }
        } else if (this.f40599d != null) {
            HomeOmegaHelper.getInstance().onOmegaBusinessSw(this.f40599d, true);
        }
    }

    /* renamed from: b */
    private final void m28841b(String str) {
        m28842c(str);
        m28843d(str);
    }

    /* renamed from: c */
    private final void m28842c(String str) {
        int i;
        boolean z = true;
        if (str == null || !(Integer.parseInt(str) == 1 || Integer.parseInt(str) == 2)) {
            if (str == null || Integer.parseInt(str) != 0) {
                z = false;
            }
            if (z) {
                i = ResourceHelper.getDimensionPixelSize(R.dimen.customer_8px);
            } else {
                i = ResourceHelper.getDimensionPixelSize(R.dimen.customer_0px);
            }
        } else {
            i = ResourceHelper.getDimensionPixelSize(R.dimen.customer_12px);
        }
        Drawable background = getBackground();
        if (background != null) {
            ((GradientDrawable) background).setCornerRadius((float) i);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }

    /* renamed from: d */
    private final void m28843d(String str) {
        int f = m28845f(str);
        getView().setPadding(f, f, f, f);
    }

    /* renamed from: e */
    private final void m28844e(String str) {
        boolean z = false;
        if (str != null && Integer.parseInt(str) == 2) {
            z = true;
        }
        if (z) {
            getMTitleWidget().setMaxLines(2);
        } else {
            getMTitleWidget().setMaxLines(1);
        }
    }

    /* renamed from: f */
    private final int m28845f(String str) {
        if (str == null || (Integer.parseInt(str) != 1 && Integer.parseInt(str) != 2)) {
            return DisplayUtils.dip2px(getContext(), 0.0f);
        }
        return DisplayUtils.dip2px(getContext(), 8.5f);
    }

    /* renamed from: g */
    private final int m28846g(String str) {
        if (str != null && Integer.parseInt(str) == 2) {
            return ((DisplayUtils.getScreenWidth(getContext()) - (DisplayUtils.dip2px(GlobalContext.getContext(), 12.0f) * 2)) - DisplayUtils.dip2px(GlobalContext.getContext(), 10.0f)) / 2;
        } else if (str == null || Integer.parseInt(str) != 3) {
            return DisplayUtils.dip2px(getContext(), 151.0f);
        } else {
            return DisplayUtils.dip2px(getContext(), 130.0f);
        }
    }

    /* renamed from: a */
    private final void m28839a(String str, String str2) {
        List<Integer> parseColors = ColorUtil.parseColors(str2);
        CharSequence charSequence = str;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            getMBannerWidget().setText(charSequence);
            Collection collection = parseColors;
            if (collection == null || collection.isEmpty()) {
                z = true;
            }
            if (!z) {
                Intrinsics.checkNotNullExpressionValue(parseColors, "colors");
                getMBannerWidget().setBackground(m28833a(parseColors));
                return;
            }
            return;
        }
        getMBannerWidget().setVisibility(8);
    }

    /* renamed from: a */
    private final GradientDrawable m28833a(List<Integer> list) {
        int i;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, CollectionsKt.toIntArray(list));
        gradientDrawable.setShape(0);
        String str = this.f40601f;
        if (str != null && Integer.parseInt(str) == 3) {
            i = ResourceHelper.getDimensionPixelSize(R.dimen.customer_12px);
        } else {
            i = ResourceHelper.getDimensionPixelSize(R.dimen.customer_8px);
        }
        float f = (float) i;
        gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f, f, f, f});
        return gradientDrawable;
    }

    /* renamed from: a */
    private final void m28837a(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        String str;
        if (Intrinsics.areEqual((Object) homeBusinessInfoRvModel.mPageId, (Object) "homePage") || Intrinsics.areEqual((Object) homeBusinessInfoRvModel.mPageId, (Object) "showAll")) {
            str = HomeOmegaHelper.getInstance().getBusinessBiData(homeBusinessInfoRvModel);
            Intrinsics.checkNotNullExpressionValue(str, "getInstance().getBusinessBiData(rvModel)");
        } else {
            str = "";
        }
        DiRouter.request().path(RoutePath.BUSINESS_HOME).putString(Const.PageParams.SHOP_ID, homeBusinessInfoRvModel.mShopId).putSerializable(Const.PageParams.SHOP_INFO_ENTITY, HomeBusinessPool.getPool().getBusiness(homeBusinessInfoRvModel.mShopId)).putString(Const.PageParams.BIDATA, str).open();
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/TopicItemWidget$Companion;", "", "()V", "MID_MARGIN", "", "TYPE_ATMOSPHERE", "", "TYPE_LANDING_ATMOSPHERE", "TYPE_LANDING_NORMAL", "TYPE_NORMAL", "TYPE_TOPIC_MASK", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TopicItemWidget.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
