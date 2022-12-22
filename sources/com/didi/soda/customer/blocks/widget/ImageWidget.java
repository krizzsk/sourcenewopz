package com.didi.soda.customer.blocks.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.util.BitmapUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.support.CustomerAppCompatImageView;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "image_corner_v1")
@Metadata(mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J0\u0010&\u001a\u00020'2&\u0010(\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020)\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020)\u0018\u0001`\u000bH\u0016J\b\u0010*\u001a\u00020+H\u0016J0\u0010,\u001a\u00020-2&\u0010(\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020)\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020)\u0018\u0001`\u000bH\u0016R4\u0010\b\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00020\tj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0002`\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010 \u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u001a\u0010#\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019¨\u0006/"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/ImageWidget;", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatImageView;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "mCornerType", "Lcom/didi/app/nova/skeleton/image/RoundedCornersTransformation$CornerType;", "getMCornerType", "()Lcom/didi/app/nova/skeleton/image/RoundedCornersTransformation$CornerType;", "setMCornerType", "(Lcom/didi/app/nova/skeleton/image/RoundedCornersTransformation$CornerType;)V", "mDrawableId", "", "getMDrawableId", "()I", "setMDrawableId", "(I)V", "mHeight", "getMHeight", "setMHeight", "mImageRadius", "getMImageRadius", "setMImageRadius", "mStyle", "getMStyle", "setMStyle", "mWidth", "getMWidth", "setMWidth", "bindProps", "", "props", "", "getView", "Landroid/view/View;", "shouldShow", "", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ImageWidget.kt */
public final class ImageWidget extends CustomerAppCompatImageView implements Buildable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final float RATIO_TOPIC_1x1 = 1.0f;
    public static final float RATIO_TOPIC_4x3 = 1.333333f;
    public static final int STYLE_TOPIC_1x1 = 11;
    public static final int STYLE_TOPIC_1x1_WH = 115;
    public static final int STYLE_TOPIC_4x3 = 43;
    public static final int STYLE_TOPIC_4x3_WH = 435;
    public static final int STYLE_TOPIC_NO_PLACEHOLDER_1x1 = 110;
    public static final int STYLE_TOPIC_UNSPECIFIED = 0;

    /* renamed from: a */
    private int f40693a;

    /* renamed from: b */
    private RoundedCornersTransformation.CornerType f40694b;

    /* renamed from: c */
    private int f40695c;

    /* renamed from: d */
    private int f40696d;

    /* renamed from: e */
    private int f40697e;

    /* renamed from: f */
    private int f40698f;

    /* renamed from: g */
    private final HashMap<String, Buildable> f40699g;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImageWidget(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    public void bindChildren(List<? extends Buildable> list) {
        Buildable.DefaultImpls.bindChildren(this, list);
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

    public void onBindFinish(HashMap<String, Object> hashMap) {
        Buildable.DefaultImpls.onBindFinish(this, hashMap);
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

    public void setWidgetNode(WidgetNodeModel widgetNodeModel) {
        Buildable.DefaultImpls.setWidgetNode(this, widgetNodeModel);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageWidget(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f40694b = RoundedCornersTransformation.CornerType.ALL;
        this.f40695c = ResourceHelper.getDimensionPixelSize(R.dimen.customer_8px);
        this.f40699g = new HashMap<>();
    }

    public final int getMStyle() {
        return this.f40693a;
    }

    public final void setMStyle(int i) {
        this.f40693a = i;
    }

    public final RoundedCornersTransformation.CornerType getMCornerType() {
        return this.f40694b;
    }

    public final void setMCornerType(RoundedCornersTransformation.CornerType cornerType) {
        Intrinsics.checkNotNullParameter(cornerType, "<set-?>");
        this.f40694b = cornerType;
    }

    public final int getMImageRadius() {
        return this.f40695c;
    }

    public final void setMImageRadius(int i) {
        this.f40695c = i;
    }

    public final int getMDrawableId() {
        return this.f40696d;
    }

    public final void setMDrawableId(int i) {
        this.f40696d = i;
    }

    public final int getMWidth() {
        return this.f40697e;
    }

    public final void setMWidth(int i) {
        this.f40697e = i;
    }

    public final int getMHeight() {
        return this.f40698f;
    }

    public final void setMHeight(int i) {
        this.f40698f = i;
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40699g;
    }

    public View getView() {
        return this;
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        Object obj;
        String str = null;
        if (!(hashMap == null || (obj = hashMap.get(BlocksConst.WIDGET_PARAMS_IMAGE_URL)) == null)) {
            str = obj.toString();
        }
        return !TextUtils.isEmpty(str);
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        Object obj;
        String str = null;
        if (!(hashMap == null || (obj = hashMap.get(BlocksConst.WIDGET_PARAMS_IMAGE_URL)) == null)) {
            str = obj.toString();
        }
        RoundedBitmapDrawable roundedDrawable = BitmapUtil.getRoundedDrawable(getContext(), this.f40696d, this.f40695c);
        int i = this.f40693a;
        if (i == 11) {
            Drawable drawable = roundedDrawable;
            FlyImageLoader.loadImage1x1(getContext(), str).placeholder(drawable).error(drawable).transform(new RoundedCornersTransformation(getContext(), this.f40695c, 0, this.f40694b, true)).into((ImageView) this);
        } else if (i == 43) {
            Drawable drawable2 = roundedDrawable;
            FlyImageLoader.loadImage4x3(getContext(), str).placeholder(drawable2).error(drawable2).transform(new RoundedCornersTransformation(getContext(), this.f40695c, 0, this.f40694b, true)).into((ImageView) this);
        } else if (i == 110) {
            FlyImageLoader.loadImage1x1(getContext(), str).transform(new RoundedCornersTransformation(getContext(), this.f40695c, 0, this.f40694b, true)).into((ImageView) this);
        } else if (i == 115) {
            Drawable drawable3 = roundedDrawable;
            FlyImageLoader.loadImage1x1(getContext(), str).override(this.f40697e, this.f40698f).placeholder(drawable3).error(drawable3).transform(new RoundedCornersTransformation(getContext(), this.f40695c, 0, this.f40694b, true)).into((ImageView) this);
        } else if (i != 435) {
            Drawable drawable4 = roundedDrawable;
            FlyImageLoader.loadImageUnspecified(getContext(), str).placeholder(drawable4).error(drawable4).transform(new RoundedCornersTransformation(getContext(), this.f40695c, 0, this.f40694b, true)).into((ImageView) this);
        } else {
            Drawable drawable5 = roundedDrawable;
            FlyImageLoader.loadImage4x3(getContext(), str).override(this.f40697e, this.f40698f).placeholder(drawable5).error(drawable5).transform(new RoundedCornersTransformation(getContext(), this.f40695c, 0, this.f40694b, true)).into((ImageView) this);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/ImageWidget$Companion;", "", "()V", "RATIO_TOPIC_1x1", "", "RATIO_TOPIC_4x3", "STYLE_TOPIC_1x1", "", "STYLE_TOPIC_1x1_WH", "STYLE_TOPIC_4x3", "STYLE_TOPIC_4x3_WH", "STYLE_TOPIC_NO_PLACEHOLDER_1x1", "STYLE_TOPIC_UNSPECIFIED", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ImageWidget.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
