package com.didi.soda.customer.blocks.card.suapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "sa_topic_price_v1")
@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J0\u0010\u0011\u001a\u00020\u00122&\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J0\u0010\u0017\u001a\u00020\u00182&\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u000bH\u0016R4\u0010\b\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00020\tj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0002`\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/suapp/SaTopicItemPriceWidget;", "Landroid/widget/LinearLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "mainContentTv", "Lcom/didi/soda/customer/widget/text/RichTextView;", "subContentTv", "bindProps", "", "props", "", "getView", "Landroid/view/View;", "shouldShow", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SaTopicItemPriceWidget.kt */
public final class SaTopicItemPriceWidget extends LinearLayout implements Buildable {

    /* renamed from: a */
    private RichTextView f40635a;

    /* renamed from: b */
    private RichTextView f40636b;

    /* renamed from: c */
    private final HashMap<String, Buildable> f40637c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SaTopicItemPriceWidget(Context context) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SaTopicItemPriceWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_suapp_item_price_layout, this);
        View findViewById = inflate.findViewById(R.id.customer_topic_main_content_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_topic_main_content_tv)");
        this.f40635a = (RichTextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_topic_sub_content_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_topic_sub_content_tv)");
        this.f40636b = (RichTextView) findViewById2;
        this.f40637c = new HashMap<>();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SaTopicItemPriceWidget(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40637c;
    }

    public View getView() {
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r1 = r3.get(com.didi.soda.customer.blocks.BlocksConst.WIDGET_PARAMS_MAIN_CONTENT);
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
            java.lang.String r1 = "main_content"
            java.lang.Object r1 = r3.get(r1)
            if (r1 != 0) goto L_0x000e
            goto L_0x0003
        L_0x000e:
            java.lang.String r1 = r1.toString()
        L_0x0012:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0036
            if (r3 != 0) goto L_0x001d
            goto L_0x002b
        L_0x001d:
            java.lang.String r1 = "sub_content"
            java.lang.Object r3 = r3.get(r1)
            if (r3 != 0) goto L_0x0027
            goto L_0x002b
        L_0x0027:
            java.lang.String r0 = r3.toString()
        L_0x002b:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r3 = 0
            goto L_0x0037
        L_0x0036:
            r3 = 1
        L_0x0037:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.card.suapp.SaTopicItemPriceWidget.shouldShow(java.util.HashMap):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r1 = r5.get(com.didi.soda.customer.blocks.BlocksConst.WIDGET_PARAMS_MAIN_CONTENT);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindProps(java.util.HashMap<java.lang.String, java.lang.Object> r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0005
        L_0x0003:
            r1 = r0
            goto L_0x0012
        L_0x0005:
            java.lang.String r1 = "main_content"
            java.lang.Object r1 = r5.get(r1)
            if (r1 != 0) goto L_0x000e
            goto L_0x0003
        L_0x000e:
            java.lang.String r1 = r1.toString()
        L_0x0012:
            if (r5 != 0) goto L_0x0015
            goto L_0x0023
        L_0x0015:
            java.lang.String r2 = "sub_content"
            java.lang.Object r5 = r5.get(r2)
            if (r5 != 0) goto L_0x001f
            goto L_0x0023
        L_0x001f:
            java.lang.String r0 = r5.toString()
        L_0x0023:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            r2 = 0
            r3 = 8
            if (r5 != 0) goto L_0x0039
            com.didi.soda.customer.widget.text.RichTextView r5 = r4.f40635a
            r5.setVisibility(r2)
            com.didi.soda.customer.widget.text.RichTextView r5 = r4.f40635a
            r5.setText(r1)
            goto L_0x003e
        L_0x0039:
            com.didi.soda.customer.widget.text.RichTextView r5 = r4.f40635a
            r5.setVisibility(r3)
        L_0x003e:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 != 0) goto L_0x0051
            com.didi.soda.customer.widget.text.RichTextView r5 = r4.f40636b
            r5.setVisibility(r2)
            com.didi.soda.customer.widget.text.RichTextView r5 = r4.f40636b
            r5.setText(r0)
            goto L_0x0056
        L_0x0051:
            com.didi.soda.customer.widget.text.RichTextView r5 = r4.f40636b
            r5.setVisibility(r3)
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.card.suapp.SaTopicItemPriceWidget.bindProps(java.util.HashMap):void");
    }
}
