package com.didi.soda.customer.blocks.card.suapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.blocks.card.suapp.SaItemOperationListener;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "sa_topic_has_more_v1")
@Metadata(mo175977d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B%\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001e\u0010'\u001a\u00020(2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020*\u0018\u00010\rH\u0016J\u0010\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\nH\u0016J\b\u0010-\u001a\u00020\u001eH\u0016J\b\u0010.\u001a\u00020\nH\u0002J\b\u0010/\u001a\u00020\nH\u0016J\b\u00100\u001a\u00020\nH\u0016J\b\u00101\u001a\u00020\u001eH\u0016J\b\u00102\u001a\u00020(H\u0002J\b\u00103\u001a\u00020(H\u0016J(\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\nH\u0014J\u0012\u00109\u001a\u00020(2\b\u0010:\u001a\u0004\u0018\u00010 H\u0016J\u001e\u0010;\u001a\u00020<2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020*\u0018\u00010\rH\u0016J\u001a\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u000eH\u0002R\"\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/suapp/SaTopicMoreWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "Lcom/didi/soda/customer/blocks/card/suapp/SaItemOperationListener;", "Lcom/didi/soda/customer/blocks/card/suapp/IShadow;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dynamicChildren", "Ljava/util/HashMap;", "", "getDynamicChildren", "()Ljava/util/HashMap;", "mDescWidget", "Lcom/didi/soda/customer/widget/text/RichTextView;", "getMDescWidget", "()Lcom/didi/soda/customer/widget/text/RichTextView;", "setMDescWidget", "(Lcom/didi/soda/customer/widget/text/RichTextView;)V", "mIconWidget", "Lcom/didi/soda/customer/widget/text/IconRichTextView;", "getMIconWidget", "()Lcom/didi/soda/customer/widget/text/IconRichTextView;", "setMIconWidget", "(Lcom/didi/soda/customer/widget/text/IconRichTextView;)V", "mRootView", "Landroid/view/View;", "mWidgetNode", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "getMWidgetNode", "()Lcom/didi/soda/blocks/model/WidgetNodeModel;", "setMWidgetNode", "(Lcom/didi/soda/blocks/model/WidgetNodeModel;)V", "shadowHelper", "Lcom/didi/soda/customer/blocks/card/suapp/SaShadowHelper;", "bindProps", "", "props", "", "fixContentHeight", "height", "getContentView", "getResId", "getShadowPaddingLeft", "getShadowPaddingRight", "getView", "initView", "onAppear", "onSizeChanged", "w", "h", "oldw", "oldh", "setWidgetNode", "widgetNode", "shouldShow", "", "updateBackgroundColor", "drawable", "Landroid/graphics/drawable/Drawable;", "bgColor", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SaTopicMoreWidget.kt */
public final class SaTopicMoreWidget extends ConstraintLayout implements Buildable, IShadow, SaItemOperationListener {

    /* renamed from: a */
    private View f40649a;

    /* renamed from: b */
    private SaShadowHelper f40650b;

    /* renamed from: c */
    private final HashMap<String, Buildable> f40651c;

    /* renamed from: d */
    private WidgetNodeModel f40652d;
    public RichTextView mDescWidget;
    public IconRichTextView mIconWidget;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SaTopicMoreWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SaTopicMoreWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int getResId() {
        return R.layout.customer_su_item_topic_view_more_blocks;
    }

    public void _$_clearFindViewByIdCache() {
    }

    public void bindChildren(List<? extends Buildable> list) {
        Buildable.DefaultImpls.bindChildren(this, list);
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

    public boolean shouldWarpButton() {
        return SaItemOperationListener.DefaultImpls.shouldWarpButton(this);
    }

    public boolean shouldWarpTextLine() {
        return SaItemOperationListener.DefaultImpls.shouldWarpTextLine(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SaTopicMoreWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SaTopicMoreWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f40650b = new SaShadowHelper(this);
        m28885a();
        int dimensionPixelSize = ResourceHelper.getDimensionPixelSize(R.dimen.customer_18px);
        setPadding(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
        this.f40651c = new LinkedHashMap();
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40651c;
    }

    public final IconRichTextView getMIconWidget() {
        IconRichTextView iconRichTextView = this.mIconWidget;
        if (iconRichTextView != null) {
            return iconRichTextView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mIconWidget");
        return null;
    }

    public final void setMIconWidget(IconRichTextView iconRichTextView) {
        Intrinsics.checkNotNullParameter(iconRichTextView, "<set-?>");
        this.mIconWidget = iconRichTextView;
    }

    public final RichTextView getMDescWidget() {
        RichTextView richTextView = this.mDescWidget;
        if (richTextView != null) {
            return richTextView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDescWidget");
        return null;
    }

    public final void setMDescWidget(RichTextView richTextView) {
        Intrinsics.checkNotNullParameter(richTextView, "<set-?>");
        this.mDescWidget = richTextView;
    }

    public final WidgetNodeModel getMWidgetNode() {
        return this.f40652d;
    }

    public final void setMWidgetNode(WidgetNodeModel widgetNodeModel) {
        this.f40652d = widgetNodeModel;
    }

    /* renamed from: a */
    private final void m28885a() {
        View inflate = LayoutInflater.from(getContext()).inflate(getResId(), this, true);
        View findViewById = inflate.findViewById(R.id.customer_sa_topic_more_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_sa_topic_more_root)");
        this.f40649a = findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_icon_topic_view_more);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_icon_topic_view_more)");
        setMIconWidget((IconRichTextView) findViewById2);
        View findViewById3 = inflate.findViewById(R.id.customer_tv_topic_view_more);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_tv_topic_view_more)");
        setMDescWidget((RichTextView) findViewById3);
    }

    public int getShadowPaddingLeft() {
        return getPaddingLeft();
    }

    public int getShadowPaddingRight() {
        return getPaddingRight();
    }

    public View getContentView() {
        View view = this.f40649a;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    }

    public void fixContentHeight(int i) {
        View view = this.f40649a;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i;
            View view3 = this.f40649a;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                view2 = view3;
            }
            view2.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public void setWidgetNode(WidgetNodeModel widgetNodeModel) {
        Buildable.DefaultImpls.setWidgetNode(this, widgetNodeModel);
        this.f40652d = widgetNodeModel;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f40650b.onSizeChanged(i, i2, i3, i4);
    }

    public View getView() {
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r1 = r3.get("icon");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldShow(java.util.HashMap<java.lang.String, java.lang.Object> r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 != 0) goto L_0x0005
        L_0x0003:
            r1 = r0
            goto L_0x0012
        L_0x0005:
            java.lang.String r1 = "icon"
            java.lang.Object r1 = r3.get(r1)
            if (r1 != 0) goto L_0x000e
            goto L_0x0003
        L_0x000e:
            java.lang.String r1 = r1.toString()
        L_0x0012:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0034
            if (r3 != 0) goto L_0x001d
            goto L_0x002a
        L_0x001d:
            java.lang.String r1 = "content"
            java.lang.Object r3 = r3.get(r1)
            if (r3 != 0) goto L_0x0026
            goto L_0x002a
        L_0x0026:
            java.lang.String r0 = r3.toString()
        L_0x002a:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x0034
            r3 = 1
            goto L_0x0035
        L_0x0034:
            r3 = 0
        L_0x0035:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.card.suapp.SaTopicMoreWidget.shouldShow(java.util.HashMap):boolean");
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            Object obj = hashMap.get(BlocksConst.WIDGET_PARAMS_BG_COLOR);
            String str = null;
            String obj2 = obj == null ? null : obj.toString();
            View view = this.f40649a;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view = null;
            }
            Drawable background = view.getBackground();
            Intrinsics.checkNotNullExpressionValue(background, "mRootView.background");
            m28886a(background, obj2);
            Object obj3 = hashMap.get("icon");
            CharSequence obj4 = obj3 == null ? null : obj3.toString();
            boolean z = false;
            if (!(obj4 == null || obj4.length() == 0)) {
                getMIconWidget().setText(obj4);
            }
            Object obj5 = hashMap.get("content");
            CharSequence obj6 = obj5 == null ? null : obj5.toString();
            if (obj6 == null || obj6.length() == 0) {
                z = true;
            }
            if (!z) {
                RichTextView mDescWidget2 = getMDescWidget();
                Object obj7 = hashMap.get("content");
                mDescWidget2.setText(obj7 == null ? null : obj7.toString());
            }
            Object obj8 = hashMap.get(BlocksConst.WIDGET_PARAMS_ICON_BG_COLOR);
            if (obj8 != null) {
                str = obj8.toString();
            }
            Drawable background2 = getMIconWidget().getBackground();
            Intrinsics.checkNotNullExpressionValue(background2, "mIconWidget.background");
            m28886a(background2, str);
        }
    }

    public void onAppear() {
        LogUtil.m29100d("TopicMoreWidget", "onAppearedWhenScroll >>>> ");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017 A[Catch:{ Exception -> 0x001f }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m28886a(android.graphics.drawable.Drawable r2, java.lang.String r3) {
        /*
            r1 = this;
            android.graphics.drawable.Drawable r2 = r2.mutate()     // Catch:{ Exception -> 0x001f }
            android.graphics.drawable.GradientDrawable r2 = (android.graphics.drawable.GradientDrawable) r2     // Catch:{ Exception -> 0x001f }
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x001f }
            if (r0 == 0) goto L_0x0014
            int r0 = r0.length()     // Catch:{ Exception -> 0x001f }
            if (r0 != 0) goto L_0x0012
            goto L_0x0014
        L_0x0012:
            r0 = 0
            goto L_0x0015
        L_0x0014:
            r0 = 1
        L_0x0015:
            if (r0 != 0) goto L_0x0023
            int r3 = android.graphics.Color.parseColor(r3)     // Catch:{ Exception -> 0x001f }
            r2.setColor(r3)     // Catch:{ Exception -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0023:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.card.suapp.SaTopicMoreWidget.m28886a(android.graphics.drawable.Drawable, java.lang.String):void");
    }
}
