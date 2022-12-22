package com.didi.soda.customer.blocks.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "tag_line_corner_v1")
@Metadata(mo175977d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J0\u0010\u0016\u001a\u00020\u00172&\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0018\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0013H\u0014J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0013J0\u0010%\u001a\u00020&2&\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u000bH\u0016R4\u0010\b\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00020\tj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0002`\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/AdTagWidget;", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "radius", "", "rect", "Landroid/graphics/RectF;", "bindProps", "", "props", "", "buildPath", "getView", "Landroid/view/View;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setStyle", "style", "shouldShow", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AdTagWidget.kt */
public final class AdTagWidget extends CustomerAppCompatTextView implements Buildable {

    /* renamed from: a */
    private final Paint f40674a;

    /* renamed from: b */
    private Path f40675b;

    /* renamed from: c */
    private RectF f40676c;

    /* renamed from: d */
    private int f40677d;

    /* renamed from: e */
    private final HashMap<String, Buildable> f40678e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AdTagWidget(Context context) {
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
    public /* synthetic */ AdTagWidget(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdTagWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setTextSize(1, 10.0f);
        setFontType(IToolsService.FontType.LIGHT);
        setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_4_80_CCCCCC));
        setGravity(17);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth((float) ResourceHelper.getDimensionPixelSize(R.dimen.customer_1px));
        paint.setColor(ResourceHelper.getColor(R.color.rf_color_gery_4_80_CCCCCC));
        paint.setStrokeCap(Paint.Cap.ROUND);
        Unit unit = Unit.INSTANCE;
        this.f40674a = paint;
        this.f40675b = new Path();
        this.f40676c = new RectF();
        this.f40677d = ResourceHelper.getDimensionPixelSize(R.dimen.customer_12px);
        this.f40678e = new HashMap<>();
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40678e;
    }

    public View getView() {
        return this;
    }

    public final void setStyle(int i) {
        if (i == 21) {
            this.f40677d = ResourceHelper.getDimensionPixelSize(R.dimen.customer_8px);
            this.f40674a.setColor(ResourceHelper.getColor(R.color.rf_color_gery_4_80_CCCCCC));
            setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_4_80_CCCCCC));
            setBackgroundResource(R.drawable.customer_shape_bg_home_ad_tag);
        } else if (i != 43) {
            this.f40677d = ResourceHelper.getDimensionPixelSize(R.dimen.customer_12px);
            this.f40674a.setColor(ResourceHelper.getColor(R.color.rf_color_gery_6_90_E3E3E6));
            setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_6_90_E3E3E6));
            setBackground((Drawable) null);
        } else {
            this.f40677d = ResourceHelper.getDimensionPixelSize(R.dimen.customer_12px);
            this.f40674a.setColor(ResourceHelper.getColor(R.color.rf_color_gery_6_90_E3E3E6));
            setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_6_90_E3E3E6));
            setBackground((Drawable) null);
        }
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            Object obj = hashMap.get(BlocksConst.WIDGET_PARAMS_ADTAGDESC);
            if (!TextUtils.isEmpty(obj == null ? null : obj.toString())) {
                return true;
            }
        }
        return false;
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            setVisibility(8);
            return;
        }
        Object obj = hashMap.get(BlocksConst.WIDGET_PARAMS_ADTAGDESC);
        CharSequence obj2 = obj == null ? null : obj.toString();
        if (TextUtils.isEmpty(obj2)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        setText(obj2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f40675b.reset();
        float strokeWidth = this.f40674a.getStrokeWidth() / ((float) 2);
        float measuredHeight = ((float) getMeasuredHeight()) - strokeWidth;
        RectF rectF = this.f40676c;
        int i3 = this.f40677d;
        rectF.set(strokeWidth, measuredHeight - ((float) (i3 * 2)), ((float) (i3 * 2)) + strokeWidth, measuredHeight);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.f40675b.isEmpty()) {
            m28896a();
        }
        canvas.drawPath(this.f40675b, this.f40674a);
    }

    /* renamed from: a */
    private final void m28896a() {
        float f = (float) 2;
        float strokeWidth = this.f40674a.getStrokeWidth() / f;
        float measuredHeight = ((float) getMeasuredHeight()) - strokeWidth;
        this.f40675b.moveTo(strokeWidth, 0.0f);
        this.f40675b.lineTo(strokeWidth, measuredHeight - (this.f40676c.height() / f));
        this.f40675b.addArc(this.f40676c, 90.0f, 90.0f);
        this.f40675b.moveTo((this.f40676c.height() / f) + strokeWidth, measuredHeight);
        this.f40675b.lineTo((((float) getMeasuredWidth()) - strokeWidth) + strokeWidth, measuredHeight);
    }
}
