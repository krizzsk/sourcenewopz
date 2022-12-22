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
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "back_icon_text_v1")
@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J0\u0010\u000e\u001a\u00020\u000f2&\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J0\u0010\u0014\u001a\u00020\u00152&\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u000bH\u0016R4\u0010\b\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00020\tj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0002`\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/InfoTagCommonWidget;", "Landroid/widget/LinearLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "bindProps", "", "props", "", "getView", "Landroid/view/View;", "shouldShow", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InfoTagCommonWidget.kt */
public final class InfoTagCommonWidget extends LinearLayout implements Buildable {

    /* renamed from: a */
    private final HashMap<String, Buildable> f40700a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InfoTagCommonWidget(Context context) {
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
    public /* synthetic */ InfoTagCommonWidget(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InfoTagCommonWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.customer_widget_info_tag_common_layout, this);
        this.f40700a = new HashMap<>();
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40700a;
    }

    public View getView() {
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0097 A[SYNTHETIC, Splitter:B:34:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b6 A[SYNTHETIC, Splitter:B:41:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d5 A[SYNTHETIC, Splitter:B:48:0x00d5] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f4 A[SYNTHETIC, Splitter:B:55:0x00f4] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0120 A[SYNTHETIC, Splitter:B:64:0x0120] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x013e A[SYNTHETIC, Splitter:B:70:0x013e] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x015d A[SYNTHETIC, Splitter:B:76:0x015d] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0179 A[SYNTHETIC, Splitter:B:80:0x0179] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindProps(java.util.HashMap<java.lang.String, java.lang.Object> r14) {
        /*
            r13 = this;
            r0 = 8
            if (r14 == 0) goto L_0x01d0
            java.lang.String r1 = "style"
            java.lang.Object r1 = r14.get(r1)
            boolean r2 = r1 instanceof java.util.HashMap
            r3 = 0
            if (r2 == 0) goto L_0x0013
            java.util.HashMap r1 = (java.util.HashMap) r1
            goto L_0x0014
        L_0x0013:
            r1 = r3
        L_0x0014:
            r2 = 2131101608(0x7f0607a8, float:1.781563E38)
            if (r1 != 0) goto L_0x001b
            goto L_0x0197
        L_0x001b:
            java.util.Map r1 = (java.util.Map) r1
            java.lang.String r4 = "backgroundColor"
            java.lang.Object r4 = r1.get(r4)
            r5 = 0
            if (r4 != 0) goto L_0x0029
        L_0x0026:
            r6 = r3
            r4 = 0
            goto L_0x003b
        L_0x0029:
            java.lang.String r4 = r4.toString()
            if (r4 != 0) goto L_0x0030
            goto L_0x0026
        L_0x0030:
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ Exception -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            int r4 = com.didi.soda.customer.foundation.util.ResourceHelper.getColor(r2)
        L_0x0039:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
        L_0x003b:
            if (r6 != 0) goto L_0x0044
            r4 = r13
            com.didi.soda.customer.blocks.widget.InfoTagCommonWidget r4 = (com.didi.soda.customer.blocks.widget.InfoTagCommonWidget) r4
            int r4 = com.didi.soda.customer.foundation.util.ResourceHelper.getColor(r2)
        L_0x0044:
            java.lang.String r6 = "borderRadius"
            java.lang.Object r6 = r1.get(r6)
            r7 = 2
            if (r6 != 0) goto L_0x004f
        L_0x004d:
            r6 = 0
            goto L_0x0061
        L_0x004f:
            android.content.Context r8 = r13.getContext()     // Catch:{ Exception -> 0x004d }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x004d }
            float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ Exception -> 0x004d }
            float r9 = (float) r7     // Catch:{ Exception -> 0x004d }
            float r6 = r6 / r9
            int r6 = com.didi.app.nova.support.util.DisplayUtils.dip2px(r8, r6)     // Catch:{ Exception -> 0x004d }
        L_0x0061:
            r8 = 2131429313(0x7f0b07c1, float:1.8480295E38)
            android.view.View r9 = r13.findViewById(r8)
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            android.graphics.drawable.GradientDrawable r4 = com.didi.soda.customer.foundation.util.BitmapUtil.getRoundRectDrawable(r6, r4)
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4
            r9.setBackground(r4)
            android.view.View r4 = r13.findViewById(r8)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            boolean r6 = r4 instanceof android.widget.LinearLayout.LayoutParams
            if (r6 == 0) goto L_0x0084
            android.widget.LinearLayout$LayoutParams r4 = (android.widget.LinearLayout.LayoutParams) r4
            goto L_0x0085
        L_0x0084:
            r4 = r3
        L_0x0085:
            if (r4 != 0) goto L_0x008e
            android.widget.LinearLayout$LayoutParams r4 = new android.widget.LinearLayout$LayoutParams
            r6 = -1
            r9 = -2
            r4.<init>(r6, r9)
        L_0x008e:
            java.lang.String r6 = "marginLeft"
            java.lang.Object r6 = r1.get(r6)
            if (r6 != 0) goto L_0x0097
            goto L_0x00ad
        L_0x0097:
            android.content.Context r9 = r13.getContext()     // Catch:{ Exception -> 0x00aa }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00aa }
            float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ Exception -> 0x00aa }
            float r10 = (float) r7     // Catch:{ Exception -> 0x00aa }
            float r6 = r6 / r10
            int r6 = com.didi.app.nova.support.util.DisplayUtils.dip2px(r9, r6)     // Catch:{ Exception -> 0x00aa }
            goto L_0x00ab
        L_0x00aa:
            r6 = 0
        L_0x00ab:
            r4.leftMargin = r6
        L_0x00ad:
            java.lang.String r6 = "marginRight"
            java.lang.Object r6 = r1.get(r6)
            if (r6 != 0) goto L_0x00b6
            goto L_0x00cc
        L_0x00b6:
            android.content.Context r9 = r13.getContext()     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00c9 }
            float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ Exception -> 0x00c9 }
            float r10 = (float) r7     // Catch:{ Exception -> 0x00c9 }
            float r6 = r6 / r10
            int r6 = com.didi.app.nova.support.util.DisplayUtils.dip2px(r9, r6)     // Catch:{ Exception -> 0x00c9 }
            goto L_0x00ca
        L_0x00c9:
            r6 = 0
        L_0x00ca:
            r4.rightMargin = r6
        L_0x00cc:
            java.lang.String r6 = "marginTop"
            java.lang.Object r6 = r1.get(r6)
            if (r6 != 0) goto L_0x00d5
            goto L_0x00eb
        L_0x00d5:
            android.content.Context r9 = r13.getContext()     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00e8 }
            float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ Exception -> 0x00e8 }
            float r10 = (float) r7     // Catch:{ Exception -> 0x00e8 }
            float r6 = r6 / r10
            int r6 = com.didi.app.nova.support.util.DisplayUtils.dip2px(r9, r6)     // Catch:{ Exception -> 0x00e8 }
            goto L_0x00e9
        L_0x00e8:
            r6 = 0
        L_0x00e9:
            r4.topMargin = r6
        L_0x00eb:
            java.lang.String r6 = "bottomMargin"
            java.lang.Object r6 = r1.get(r6)
            if (r6 != 0) goto L_0x00f4
            goto L_0x010a
        L_0x00f4:
            android.content.Context r9 = r13.getContext()     // Catch:{ Exception -> 0x0107 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0107 }
            float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ Exception -> 0x0107 }
            float r10 = (float) r7     // Catch:{ Exception -> 0x0107 }
            float r6 = r6 / r10
            int r6 = com.didi.app.nova.support.util.DisplayUtils.dip2px(r9, r6)     // Catch:{ Exception -> 0x0107 }
            goto L_0x0108
        L_0x0107:
            r6 = 0
        L_0x0108:
            r4.bottomMargin = r6
        L_0x010a:
            android.view.View r6 = r13.findViewById(r8)
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            android.view.ViewGroup$LayoutParams r4 = (android.view.ViewGroup.LayoutParams) r4
            r6.setLayoutParams(r4)
            java.lang.String r4 = "paddingLeft"
            java.lang.Object r4 = r1.get(r4)
            if (r4 != 0) goto L_0x0120
        L_0x011e:
            r4 = 0
            goto L_0x0132
        L_0x0120:
            android.content.Context r6 = r13.getContext()     // Catch:{ Exception -> 0x011e }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x011e }
            float r4 = java.lang.Float.parseFloat(r4)     // Catch:{ Exception -> 0x011e }
            float r9 = (float) r7     // Catch:{ Exception -> 0x011e }
            float r4 = r4 / r9
            int r4 = com.didi.app.nova.support.util.DisplayUtils.dip2px(r6, r4)     // Catch:{ Exception -> 0x011e }
        L_0x0132:
            java.lang.String r6 = "paddingTop"
            java.lang.Object r6 = r1.get(r6)
            r9 = 1
            if (r6 != 0) goto L_0x013e
        L_0x013c:
            r6 = 0
            goto L_0x0152
        L_0x013e:
            android.content.Context r10 = r13.getContext()     // Catch:{ Exception -> 0x013c }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x013c }
            float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ Exception -> 0x013c }
            float r11 = (float) r9     // Catch:{ Exception -> 0x013c }
            float r6 = r6 - r11
            float r11 = (float) r7     // Catch:{ Exception -> 0x013c }
            float r6 = r6 / r11
            int r6 = com.didi.app.nova.support.util.DisplayUtils.dip2px(r10, r6)     // Catch:{ Exception -> 0x013c }
        L_0x0152:
            java.lang.String r10 = "paddingRight"
            java.lang.Object r10 = r1.get(r10)
            if (r10 != 0) goto L_0x015d
        L_0x015b:
            r10 = 0
            goto L_0x016f
        L_0x015d:
            android.content.Context r11 = r13.getContext()     // Catch:{ Exception -> 0x015b }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x015b }
            float r10 = java.lang.Float.parseFloat(r10)     // Catch:{ Exception -> 0x015b }
            float r12 = (float) r7     // Catch:{ Exception -> 0x015b }
            float r10 = r10 / r12
            int r10 = com.didi.app.nova.support.util.DisplayUtils.dip2px(r11, r10)     // Catch:{ Exception -> 0x015b }
        L_0x016f:
            java.lang.String r11 = "paddingBottom"
            java.lang.Object r1 = r1.get(r11)
            if (r1 != 0) goto L_0x0179
            goto L_0x018e
        L_0x0179:
            android.content.Context r11 = r13.getContext()     // Catch:{ Exception -> 0x018e }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x018e }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ Exception -> 0x018e }
            float r9 = (float) r9     // Catch:{ Exception -> 0x018e }
            float r1 = r1 - r9
            float r7 = (float) r7     // Catch:{ Exception -> 0x018e }
            float r1 = r1 / r7
            int r1 = com.didi.app.nova.support.util.DisplayUtils.dip2px(r11, r1)     // Catch:{ Exception -> 0x018e }
            r5 = r1
        L_0x018e:
            android.view.View r1 = r13.findViewById(r8)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r1.setPadding(r4, r6, r10, r5)
        L_0x0197:
            r1 = 2131429054(0x7f0b06be, float:1.847977E38)
            android.view.View r4 = r13.findViewById(r1)
            com.didi.soda.customer.widget.text.RichTextView r4 = (com.didi.soda.customer.widget.text.RichTextView) r4
            java.lang.String r5 = "content"
            java.lang.Object r14 = r14.get(r5)
            if (r14 != 0) goto L_0x01a9
            goto L_0x01ad
        L_0x01a9:
            java.lang.String r3 = r14.toString()
        L_0x01ad:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r4.setText(r3)
            android.view.View r14 = r13.findViewById(r1)
            com.didi.soda.customer.widget.text.RichTextView r14 = (com.didi.soda.customer.widget.text.RichTextView) r14
            android.content.res.Resources r1 = r13.getResources()
            int r1 = r1.getColor(r2)
            r14.setTextColor(r1)
            r14 = 2131429049(0x7f0b06b9, float:1.847976E38)
            android.view.View r14 = r13.findViewById(r14)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            r14.setVisibility(r0)
            goto L_0x01d3
        L_0x01d0:
            r13.setVisibility(r0)
        L_0x01d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.widget.InfoTagCommonWidget.bindProps(java.util.HashMap):void");
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return false;
        }
        Object obj = hashMap.get("content");
        return !TextUtils.isEmpty(obj == null ? null : obj.toString());
    }
}
