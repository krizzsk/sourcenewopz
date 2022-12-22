package com.didi.soda.customer.blocks.widget;

import android.content.Context;
import android.text.TextUtils;
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
import com.didi.soda.customer.widget.text.IconRichTextView;
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

@WidgetNameMeta(widgetName = "icon_text_v1")
@Metadata(mo175977d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ0\u0010\u0015\u001a\u00020\u00162&\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\rH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0002J0\u0010\u001c\u001a\u00020\u001d2&\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\rH\u0016R4\u0010\n\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00020\u000bj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u0002`\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/IconAndTextWidget;", "Landroid/widget/LinearLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "mIconView", "Lcom/didi/soda/customer/widget/text/IconRichTextView;", "mLinearLayout", "mTextView", "Lcom/didi/soda/customer/widget/text/RichTextView;", "bindProps", "", "props", "", "getView", "Landroid/view/View;", "restoreDefaultLayout", "shouldShow", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IconAndTextWidget.kt */
public class IconAndTextWidget extends LinearLayout implements Buildable {

    /* renamed from: a */
    private LinearLayout f40689a;

    /* renamed from: b */
    private IconRichTextView f40690b;

    /* renamed from: c */
    private RichTextView f40691c;

    /* renamed from: d */
    private final HashMap<String, Buildable> f40692d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public IconAndTextWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public IconAndTextWidget(Context context, AttributeSet attributeSet) {
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
    public /* synthetic */ IconAndTextWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconAndTextWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_icon_text, this);
        View findViewById = inflate.findViewById(R.id.customer_widget_icon_text_ll);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_widget_icon_text_ll)");
        this.f40689a = (LinearLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_custom_business_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_custom_business_icon)");
        this.f40690b = (IconRichTextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_custom_business_text);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_custom_business_text)");
        this.f40691c = (RichTextView) findViewById3;
        this.f40692d = new HashMap<>();
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40692d;
    }

    public View getView() {
        return this;
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        Object obj;
        String str = null;
        if (!(hashMap == null || (obj = hashMap.get("content")) == null)) {
            str = obj.toString();
        }
        return !TextUtils.isEmpty(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r1 = r6.get("icon");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindProps(java.util.HashMap<java.lang.String, java.lang.Object> r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0005
        L_0x0003:
            r1 = r0
            goto L_0x0012
        L_0x0005:
            java.lang.String r1 = "icon"
            java.lang.Object r1 = r6.get(r1)
            if (r1 != 0) goto L_0x000e
            goto L_0x0003
        L_0x000e:
            java.lang.String r1 = r1.toString()
        L_0x0012:
            if (r6 != 0) goto L_0x0016
        L_0x0014:
            r2 = r0
            goto L_0x0023
        L_0x0016:
            java.lang.String r2 = "content"
            java.lang.Object r2 = r6.get(r2)
            if (r2 != 0) goto L_0x001f
            goto L_0x0014
        L_0x001f:
            java.lang.String r2 = r2.toString()
        L_0x0023:
            if (r6 != 0) goto L_0x0026
            goto L_0x0033
        L_0x0026:
            java.lang.String r3 = "maxline"
            java.lang.Object r6 = r6.get(r3)
            if (r6 != 0) goto L_0x002f
            goto L_0x0033
        L_0x002f:
            java.lang.String r0 = r6.toString()
        L_0x0033:
            r5.m28903a()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            r3 = 8
            if (r6 != 0) goto L_0x007f
            com.didi.soda.customer.widget.text.RichTextView r6 = r5.f40691c
            r4 = 0
            r6.setVisibility(r4)
            com.didi.soda.customer.widget.text.RichTextView r6 = r5.f40691c
            r6.setText(r2)
            if (r0 == 0) goto L_0x0066
            int r6 = java.lang.Integer.parseInt(r0)
            r2 = 1
            if (r6 <= r2) goto L_0x0066
            com.didi.soda.customer.widget.text.RichTextView r6 = r5.f40691c
            int r0 = java.lang.Integer.parseInt(r0)
            r6.setMaxLines(r0)
            android.widget.LinearLayout r6 = r5.f40689a
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            r6.setTag(r0)
        L_0x0066:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            if (r6 != 0) goto L_0x0079
            com.didi.soda.customer.widget.text.IconRichTextView r6 = r5.f40690b
            r6.setVisibility(r4)
            com.didi.soda.customer.widget.text.IconRichTextView r6 = r5.f40690b
            r6.setText(r1)
            goto L_0x0089
        L_0x0079:
            com.didi.soda.customer.widget.text.IconRichTextView r6 = r5.f40690b
            r6.setVisibility(r3)
            goto L_0x0089
        L_0x007f:
            com.didi.soda.customer.widget.text.IconRichTextView r6 = r5.f40690b
            r6.setVisibility(r3)
            com.didi.soda.customer.widget.text.RichTextView r6 = r5.f40691c
            r6.setVisibility(r3)
        L_0x0089:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.widget.IconAndTextWidget.bindProps(java.util.HashMap):void");
    }

    /* renamed from: a */
    private final void m28903a() {
        if (this.f40689a.getTag() != null) {
            this.f40691c.setMaxLines(1);
            this.f40689a.setTag((Object) null);
        }
    }
}
