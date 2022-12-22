package com.didi.soda.customer.blocks.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
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

@WidgetNameMeta(widgetName = "tag_corner_style_v1")
@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ0\u0010\u0010\u001a\u00020\u00112&\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\rH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002J0\u0010\u0018\u001a\u00020\u00172&\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\rH\u0016R4\u0010\n\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00020\u000bj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u0002`\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/TagWidget;", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "bindProps", "", "props", "", "getView", "Landroid/view/View;", "isOverSize", "", "shouldShow", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TagWidget.kt */
public final class TagWidget extends CustomerAppCompatTextView implements Buildable {

    /* renamed from: a */
    private final HashMap<String, Buildable> f40725a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TagWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TagWidget(Context context, AttributeSet attributeSet) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TagWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setMaxLines(1);
        setFontType(IToolsService.FontType.MEDIUM);
        this.f40725a = new HashMap<>();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TagWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40725a;
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
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !m28912a();
    }

    /* renamed from: a */
    private final boolean m28912a() {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        if (getMeasuredWidth() > ResourceHelper.getDimensionPixelSize(R.dimen.customer_182px)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r1 = r8.get("style");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindProps(java.util.HashMap<java.lang.String, java.lang.Object> r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L_0x0005
        L_0x0003:
            r1 = r0
            goto L_0x0013
        L_0x0005:
            java.lang.String r1 = "style"
            java.lang.Object r1 = r8.get(r1)
            if (r1 != 0) goto L_0x000f
            goto L_0x0003
        L_0x000f:
            java.lang.String r1 = r1.toString()
        L_0x0013:
            java.lang.String r2 = "1"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0039
            android.content.Context r1 = r7.getContext()
            android.content.res.Resources r1 = r1.getResources()
            r2 = 2131232312(0x7f080638, float:1.808073E38)
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)
            r7.setBackground(r1)
            r1 = 2131101464(0x7f060718, float:1.7815338E38)
            int r1 = com.didi.soda.customer.foundation.util.ResourceHelper.getColor(r1)
            r7.setTextColor(r1)
            goto L_0x00d9
        L_0x0039:
            java.lang.String r2 = "2"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            r2 = 2131232152(0x7f080598, float:1.8080405E38)
            r3 = 2131101608(0x7f0607a8, float:1.781563E38)
            if (r1 == 0) goto L_0x005f
            android.content.Context r1 = r7.getContext()
            android.content.res.Resources r1 = r1.getResources()
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)
            r7.setBackground(r1)
            int r1 = com.didi.soda.customer.foundation.util.ResourceHelper.getColor(r3)
            r7.setTextColor(r1)
            goto L_0x00d9
        L_0x005f:
            r1 = 0
            if (r8 != 0) goto L_0x0065
        L_0x0062:
            r5 = r0
            r4 = 0
            goto L_0x0081
        L_0x0065:
            java.lang.String r4 = "text_color"
            java.lang.Object r4 = r8.get(r4)
            if (r4 != 0) goto L_0x006f
            goto L_0x0062
        L_0x006f:
            java.lang.String r4 = r4.toString()
            if (r4 != 0) goto L_0x0076
            goto L_0x0062
        L_0x0076:
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ Exception -> 0x007b }
            goto L_0x007f
        L_0x007b:
            int r4 = com.didi.soda.customer.foundation.util.ResourceHelper.getColor(r3)
        L_0x007f:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
        L_0x0081:
            if (r5 != 0) goto L_0x008a
            r4 = r7
            com.didi.soda.customer.blocks.widget.TagWidget r4 = (com.didi.soda.customer.blocks.widget.TagWidget) r4
            int r4 = com.didi.soda.customer.foundation.util.ResourceHelper.getColor(r3)
        L_0x008a:
            r3 = 2131101484(0x7f06072c, float:1.781538E38)
            if (r8 != 0) goto L_0x0092
        L_0x008f:
            r6 = r0
            r5 = 0
            goto L_0x00ad
        L_0x0092:
            java.lang.String r5 = "bg_color"
            java.lang.Object r5 = r8.get(r5)
            if (r5 != 0) goto L_0x009b
            goto L_0x008f
        L_0x009b:
            java.lang.String r5 = r5.toString()
            if (r5 != 0) goto L_0x00a2
            goto L_0x008f
        L_0x00a2:
            int r5 = android.graphics.Color.parseColor(r5)     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00ab
        L_0x00a7:
            int r5 = com.didi.soda.customer.foundation.util.ResourceHelper.getColor(r3)
        L_0x00ab:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
        L_0x00ad:
            if (r6 != 0) goto L_0x00b6
            r5 = r7
            com.didi.soda.customer.blocks.widget.TagWidget r5 = (com.didi.soda.customer.blocks.widget.TagWidget) r5
            int r5 = com.didi.soda.customer.foundation.util.ResourceHelper.getColor(r3)
        L_0x00b6:
            android.content.Context r3 = r7.getContext()
            android.content.res.Resources r3 = r3.getResources()
            android.graphics.drawable.Drawable r2 = r3.getDrawable(r2)
            if (r2 == 0) goto L_0x00f4
            android.graphics.drawable.GradientDrawable r2 = (android.graphics.drawable.GradientDrawable) r2
            r3 = 2
            int[] r3 = new int[r3]
            r3[r1] = r5
            r1 = 1
            r3[r1] = r5
            r2.setColors(r3)
            android.graphics.drawable.Drawable r2 = (android.graphics.drawable.Drawable) r2
            r7.setBackground(r2)
            r7.setTextColor(r4)
        L_0x00d9:
            if (r8 != 0) goto L_0x00dc
            goto L_0x00e9
        L_0x00dc:
            java.lang.String r1 = "content"
            java.lang.Object r8 = r8.get(r1)
            if (r8 != 0) goto L_0x00e5
            goto L_0x00e9
        L_0x00e5:
            java.lang.String r0 = r8.toString()
        L_0x00e9:
            if (r0 == 0) goto L_0x00ec
            goto L_0x00ee
        L_0x00ec:
            java.lang.String r0 = ""
        L_0x00ee:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r7.setText(r0)
            return
        L_0x00f4:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.widget.TagWidget.bindProps(java.util.HashMap):void");
    }
}
