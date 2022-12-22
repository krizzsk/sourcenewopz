package com.didi.soda.customer.blocks.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.blocks.view.PriceActionInnerView;
import com.didi.soda.customer.blocks.view.PriceActionOuterView;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.text.IconRichTextView;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "topic_price_action_v1")
@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u0000 42\u00020\u00012\u00020\u00022\u00020\u0003:\u00014B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J0\u0010 \u001a\u00020\u001f2&\u0010!\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020#\u0018\u00010\"j\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020#\u0018\u0001`$H\u0016J\u0016\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0(H\u0002J\b\u0010)\u001a\u00020*H\u0016J\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020,J\b\u0010.\u001a\u00020\u001fH\u0016J\b\u0010/\u001a\u00020\u001fH\u0002J\u000e\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020,J\u000e\u00102\u001a\u00020\u001f2\u0006\u00101\u001a\u00020,J0\u00103\u001a\u00020,2&\u0010!\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020#\u0018\u00010\"j\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020#\u0018\u0001`$H\u0016R4\u0010\u000b\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00020\fj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u0002`\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000¨\u00065"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/TopicPriceActionWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dynamicChildren", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "getDynamicChildren", "()Ljava/util/LinkedHashMap;", "mButtonRl", "Landroid/widget/RelativeLayout;", "mIconButton", "Lcom/didi/soda/customer/widget/text/IconRichTextView;", "mInnerView", "Lcom/didi/soda/customer/blocks/view/PriceActionInnerView;", "mOriginPriceTv", "Lcom/didi/soda/customer/widget/text/RichTextView;", "mOuterView", "Lcom/didi/soda/customer/blocks/view/PriceActionOuterView;", "mRealPriceTv", "mTextButton", "Lcom/didi/rfusion/widget/button/RFMainButton;", "adjustTextBtnWidth", "", "bindProps", "props", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "createOvalDrawable", "Landroid/graphics/drawable/GradientDrawable;", "colors", "", "getView", "Landroid/view/View;", "isButtonWrapNeed", "", "isPriceTextWrapNeed", "onGlobalLayout", "resetTextBtnWidth", "setButtonWrap", "needWrap", "setPriceTextWrap", "shouldShow", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopicPriceActionWidget.kt */
public final class TopicPriceActionWidget extends ConstraintLayout implements ViewTreeObserver.OnGlobalLayoutListener, Buildable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int LEFT_MARGIN = 12;

    /* renamed from: a */
    private PriceActionOuterView f40745a;

    /* renamed from: b */
    private RichTextView f40746b;

    /* renamed from: c */
    private RichTextView f40747c;

    /* renamed from: d */
    private PriceActionInnerView f40748d;

    /* renamed from: e */
    private RelativeLayout f40749e;

    /* renamed from: f */
    private RFMainButton f40750f;

    /* renamed from: g */
    private IconRichTextView f40751g;

    /* renamed from: h */
    private final LinkedHashMap<String, Buildable> f40752h;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TopicPriceActionWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TopicPriceActionWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
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
    public /* synthetic */ TopicPriceActionWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopicPriceActionWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.customer_widget_topic_price_layout_back, this);
        View findViewById = inflate.findViewById(R.id.customer_topic_price_outer_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_topic_price_outer_view)");
        this.f40745a = (PriceActionOuterView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_topic_price_inner_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_topic_price_inner_view)");
        this.f40748d = (PriceActionInnerView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_topic_real_price_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_topic_real_price_tv)");
        this.f40746b = (RichTextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.customer_topic_origin_price_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.customer_topic_origin_price_tv)");
        this.f40747c = (RichTextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.customer_topic_button_group);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.customer_topic_button_group)");
        this.f40749e = (RelativeLayout) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.customer_topic_tv_button);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.customer_topic_tv_button)");
        this.f40750f = (RFMainButton) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.customer_topic_icon_button);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.customer_topic_icon_button)");
        this.f40751g = (IconRichTextView) findViewById7;
        this.f40752h = new LinkedHashMap<>();
    }

    public LinkedHashMap<String, Buildable> getDynamicChildren() {
        return this.f40752h;
    }

    public View getView() {
        return this;
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        Object obj;
        String str = null;
        if (!(hashMap == null || (obj = hashMap.get(BlocksConst.WIDGET_PARAMS_MAIN_CONTENT)) == null)) {
            str = obj.toString();
        }
        return !TextUtils.isEmpty(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x015e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindProps(java.util.HashMap<java.lang.String, java.lang.Object> r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L_0x0004
            goto L_0x016b
        L_0x0004:
            java.lang.String r0 = "button_type"
            java.lang.Object r0 = r11.get(r0)
            java.lang.String r1 = "action_title"
            java.lang.Object r1 = r11.get(r1)
            r2 = 0
            if (r1 != 0) goto L_0x0015
            r1 = r2
            goto L_0x0019
        L_0x0015:
            java.lang.String r1 = r1.toString()
        L_0x0019:
            java.lang.String r3 = "action_icon"
            java.lang.Object r3 = r11.get(r3)
            if (r3 != 0) goto L_0x0023
            r3 = r2
            goto L_0x0027
        L_0x0023:
            java.lang.String r3 = r3.toString()
        L_0x0027:
            java.lang.String r4 = "action_color"
            java.lang.Object r4 = r11.get(r4)
            if (r4 != 0) goto L_0x0031
            r4 = r2
            goto L_0x0035
        L_0x0031:
            java.lang.String r4 = r4.toString()
        L_0x0035:
            r5 = 1
            r6 = 0
            if (r0 != 0) goto L_0x003b
        L_0x0039:
            r7 = 0
            goto L_0x0049
        L_0x003b:
            java.lang.String r7 = r0.toString()
            if (r7 != 0) goto L_0x0042
            goto L_0x0039
        L_0x0042:
            int r7 = java.lang.Integer.parseInt(r7)
            if (r7 != r5) goto L_0x0039
            r7 = 1
        L_0x0049:
            r8 = 2
            r9 = 8
            if (r7 == 0) goto L_0x0079
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x005b
            int r7 = r1.length()
            if (r7 != 0) goto L_0x0059
            goto L_0x005b
        L_0x0059:
            r7 = 0
            goto L_0x005c
        L_0x005b:
            r7 = 1
        L_0x005c:
            if (r7 != 0) goto L_0x0079
            com.didi.rfusion.widget.button.RFMainButton r0 = r10.f40750f
            r0.setVisibility(r6)
            com.didi.rfusion.widget.button.RFMainButton r0 = r10.f40750f
            r0.setText(r1)
            com.didi.soda.customer.widget.text.IconRichTextView r0 = r10.f40751g
            r0.setVisibility(r9)
            android.widget.RelativeLayout r0 = r10.f40749e
            r0.setVisibility(r6)
            com.didi.soda.customer.blocks.view.PriceActionOuterView r0 = r10.f40745a
            r0.setBtnType(r5)
            goto L_0x00f0
        L_0x0079:
            if (r0 != 0) goto L_0x007d
        L_0x007b:
            r0 = 0
            goto L_0x008b
        L_0x007d:
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x0084
            goto L_0x007b
        L_0x0084:
            int r0 = java.lang.Integer.parseInt(r0)
            if (r0 != r8) goto L_0x007b
            r0 = 1
        L_0x008b:
            if (r0 == 0) goto L_0x00dc
            com.didi.rfusion.widget.button.RFMainButton r0 = r10.f40750f
            r0.setVisibility(r9)
            com.didi.soda.customer.widget.text.IconRichTextView r0 = r10.f40751g
            r0.setVisibility(r6)
            android.widget.RelativeLayout r0 = r10.f40749e
            r0.setVisibility(r6)
            com.didi.soda.customer.blocks.view.PriceActionOuterView r0 = r10.f40745a
            r0.setBtnType(r8)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x00ae
            int r0 = r3.length()
            if (r0 != 0) goto L_0x00ac
            goto L_0x00ae
        L_0x00ac:
            r0 = 0
            goto L_0x00af
        L_0x00ae:
            r0 = 1
        L_0x00af:
            if (r0 != 0) goto L_0x00b6
            com.didi.soda.customer.widget.text.IconRichTextView r0 = r10.f40751g
            r0.setText(r3)
        L_0x00b6:
            java.util.List r0 = com.didi.soda.customer.foundation.util.ColorUtil.parseColors(r4)
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            if (r1 == 0) goto L_0x00c8
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x00c6
            goto L_0x00c8
        L_0x00c6:
            r1 = 0
            goto L_0x00c9
        L_0x00c8:
            r1 = 1
        L_0x00c9:
            if (r1 != 0) goto L_0x00f0
            java.lang.String r1 = "colors"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.graphics.drawable.GradientDrawable r0 = r10.m28925a(r0)
            com.didi.soda.customer.widget.text.IconRichTextView r1 = r10.f40751g
            android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0
            r1.setBackground(r0)
            goto L_0x00f0
        L_0x00dc:
            com.didi.rfusion.widget.button.RFMainButton r0 = r10.f40750f
            r0.setVisibility(r9)
            com.didi.soda.customer.widget.text.IconRichTextView r0 = r10.f40751g
            r0.setVisibility(r9)
            android.widget.RelativeLayout r0 = r10.f40749e
            r0.setVisibility(r9)
            com.didi.soda.customer.blocks.view.PriceActionOuterView r0 = r10.f40745a
            r0.setBtnType(r6)
        L_0x00f0:
            java.lang.String r0 = "main_content"
            java.lang.Object r0 = r11.get(r0)
            if (r0 != 0) goto L_0x00fa
            r0 = r2
            goto L_0x00fe
        L_0x00fa:
            java.lang.String r0 = r0.toString()
        L_0x00fe:
            java.lang.String r1 = "sub_content"
            java.lang.Object r11 = r11.get(r1)
            if (r11 != 0) goto L_0x0108
            goto L_0x010c
        L_0x0108:
            java.lang.String r2 = r11.toString()
        L_0x010c:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r11 = android.text.TextUtils.isEmpty(r0)
            if (r11 != 0) goto L_0x011f
            com.didi.soda.customer.widget.text.RichTextView r11 = r10.f40746b
            r11.setText(r0)
            com.didi.soda.customer.widget.text.RichTextView r11 = r10.f40746b
            r11.setVisibility(r6)
            goto L_0x0124
        L_0x011f:
            com.didi.soda.customer.widget.text.RichTextView r11 = r10.f40746b
            r11.setVisibility(r9)
        L_0x0124:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r11 = android.text.TextUtils.isEmpty(r2)
            if (r11 != 0) goto L_0x0137
            com.didi.soda.customer.widget.text.RichTextView r11 = r10.f40747c
            r11.setText(r2)
            com.didi.soda.customer.widget.text.RichTextView r11 = r10.f40747c
            r11.setVisibility(r6)
            goto L_0x013c
        L_0x0137:
            com.didi.soda.customer.widget.text.RichTextView r11 = r10.f40747c
            r11.setVisibility(r9)
        L_0x013c:
            boolean r11 = android.text.TextUtils.isEmpty(r0)
            if (r11 != 0) goto L_0x016b
            boolean r11 = android.text.TextUtils.isEmpty(r2)
            if (r11 != 0) goto L_0x016b
            android.widget.RelativeLayout r11 = r10.f40749e
            int r11 = r11.getVisibility()
            if (r11 != 0) goto L_0x016b
            com.didi.rfusion.widget.button.RFMainButton r11 = r10.f40750f
            int r11 = r11.getVisibility()
            if (r11 != 0) goto L_0x015e
            com.didi.soda.customer.blocks.view.PriceActionInnerView r11 = r10.f40748d
            r11.setBtnType(r5)
            goto L_0x016b
        L_0x015e:
            com.didi.soda.customer.widget.text.IconRichTextView r11 = r10.f40751g
            int r11 = r11.getVisibility()
            if (r11 != 0) goto L_0x016b
            com.didi.soda.customer.blocks.view.PriceActionInnerView r11 = r10.f40748d
            r11.setBtnType(r8)
        L_0x016b:
            r10.m28926a()
            android.view.ViewTreeObserver r11 = r10.getViewTreeObserver()
            r0 = r10
            android.view.ViewTreeObserver$OnGlobalLayoutListener r0 = (android.view.ViewTreeObserver.OnGlobalLayoutListener) r0
            r11.addOnGlobalLayoutListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.widget.TopicPriceActionWidget.bindProps(java.util.HashMap):void");
    }

    public void onGlobalLayout() {
        LogUtil.m29100d("Feed", "TopicPriceActionWidget onGlobalLayout");
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
        m28927b();
    }

    /* renamed from: a */
    private final GradientDrawable m28925a(List<Integer> list) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, CollectionsKt.toIntArray(list));
        gradientDrawable.setShape(1);
        int dimensionPixelSize = ResourceHelper.getDimensionPixelSize(R.dimen.customer_60px);
        gradientDrawable.setSize(dimensionPixelSize, dimensionPixelSize);
        gradientDrawable.setCornerRadius((float) ResourceHelper.getDimensionPixelSize(R.dimen.customer_33px));
        return gradientDrawable;
    }

    /* renamed from: a */
    private final void m28926a() {
        if ((this.f40745a.getBtnType() == 1 && this.f40745a.isBtnWrapNeed()) || this.f40745a.isBtnWrapSet()) {
            ViewGroup.LayoutParams layoutParams = this.f40749e.getLayoutParams();
            if (layoutParams != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.leftMargin = 12;
                layoutParams2.rightMargin = 0;
                this.f40749e.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.f40750f.getLayoutParams();
                layoutParams3.width = -2;
                this.f40751g.setLayoutParams(layoutParams3);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
    }

    /* renamed from: b */
    private final void m28927b() {
        if (this.f40745a.getBtnType() != 1) {
            return;
        }
        if (this.f40745a.isBtnWrapNeed() || this.f40745a.isBtnWrapSet()) {
            ViewGroup.LayoutParams layoutParams = this.f40749e.getLayoutParams();
            if (layoutParams != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                this.f40749e.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.f40750f.getLayoutParams();
                layoutParams3.width = -1;
                this.f40751g.setLayoutParams(layoutParams3);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
    }

    public final boolean isPriceTextWrapNeed() {
        return this.f40748d.isPriceTextWrapNeed();
    }

    public final boolean isButtonWrapNeed() {
        return this.f40745a.isButtonWrapNeed();
    }

    public final void setPriceTextWrap(boolean z) {
        this.f40748d.setPriceTextWrap(z);
    }

    public final void setButtonWrap(boolean z) {
        this.f40745a.setButtonWrap(z);
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/TopicPriceActionWidget$Companion;", "", "()V", "LEFT_MARGIN", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TopicPriceActionWidget.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
