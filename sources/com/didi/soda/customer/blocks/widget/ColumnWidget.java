package com.didi.soda.customer.blocks.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "column_container")
@Metadata(mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J0\u0010\u0015\u001a\u00020\u00122&\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\rH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0002J0\u0010\u001b\u001a\u00020\u00122&\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\rH\u0016J0\u0010\u001c\u001a\u00020\u001d2&\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\rH\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\bH\u0002R4\u0010\n\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00020\u000bj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u0002`\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0001X.¢\u0006\u0002\n\u0000¨\u0006 "}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/ColumnWidget;", "Landroid/widget/LinearLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "mContainer", "bindChildren", "", "children", "", "bindProps", "props", "", "getView", "Landroid/view/View;", "initView", "onBindFinish", "shouldShow", "", "updateChildrenMargin", "margin", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ColumnWidget.kt */
public final class ColumnWidget extends LinearLayout implements Buildable {

    /* renamed from: a */
    private LinearLayout f40679a;

    /* renamed from: b */
    private final HashMap<String, Buildable> f40680b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ColumnWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ColumnWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
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

    public boolean handleShownTrigger(IBlockScope iBlockScope, WidgetNodeModel widgetNodeModel, List<? extends BaseAction> list, Function4<? super IBlockScope, ? super WidgetNodeModel, ? super Buildable, ? super List<? extends BaseAction>, Unit> function4) {
        return Buildable.DefaultImpls.handleShownTrigger(this, iBlockScope, widgetNodeModel, list, function4);
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

    public void setWidgetNode(WidgetNodeModel widgetNodeModel) {
        Buildable.DefaultImpls.setWidgetNode(this, widgetNodeModel);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ColumnWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ColumnWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        m28897a();
        this.f40680b = new LinkedHashMap();
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40680b;
    }

    /* renamed from: a */
    private final void m28897a() {
        View findViewById = LayoutInflater.from(getContext()).inflate(R.layout.customer_item_column_widget_blocks, this, true).findViewById(R.id.customer_ll_column_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_ll_column_container)");
        this.f40679a = (LinearLayout) findViewById;
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x0145 A[SYNTHETIC, Splitter:B:75:0x0145] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0162 A[SYNTHETIC, Splitter:B:81:0x0162] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x017e A[SYNTHETIC, Splitter:B:85:0x017e] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x019b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindProps(java.util.HashMap<java.lang.String, java.lang.Object> r10) {
        /*
            r9 = this;
            if (r10 != 0) goto L_0x0004
            goto L_0x01a3
        L_0x0004:
            java.lang.String r0 = "style"
            java.lang.Object r10 = r10.get(r0)
            boolean r0 = r10 instanceof java.util.HashMap
            r1 = 0
            if (r0 == 0) goto L_0x0013
            java.util.HashMap r10 = (java.util.HashMap) r10
            goto L_0x0014
        L_0x0013:
            r10 = r1
        L_0x0014:
            if (r10 != 0) goto L_0x0018
            goto L_0x01a3
        L_0x0018:
            java.util.Map r10 = (java.util.Map) r10
            java.lang.String r0 = "backgroundColor"
            java.lang.Object r0 = r10.get(r0)
            r2 = 2131101608(0x7f0607a8, float:1.781563E38)
            r3 = 0
            if (r0 != 0) goto L_0x0029
        L_0x0026:
            r4 = r1
            r0 = 0
            goto L_0x003d
        L_0x0029:
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x0030
            goto L_0x0026
        L_0x0030:
            int r0 = android.graphics.Color.parseColor(r0)     // Catch:{ Exception -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            int r0 = com.didi.soda.customer.foundation.util.ResourceHelper.getColor(r2)
        L_0x0039:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L_0x003d:
            if (r4 != 0) goto L_0x0048
            r0 = r9
            com.didi.soda.customer.blocks.widget.ColumnWidget r0 = (com.didi.soda.customer.blocks.widget.ColumnWidget) r0
            int r0 = com.didi.soda.customer.foundation.util.ResourceHelper.getColor(r2)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x0048:
            java.lang.String r2 = "borderRadius"
            java.lang.Object r2 = r10.get(r2)
            if (r2 != 0) goto L_0x0052
            r2 = 0
            goto L_0x0060
        L_0x0052:
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x005b }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x005b }
            goto L_0x005c
        L_0x005b:
            r2 = 0
        L_0x005c:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L_0x0060:
            android.widget.LinearLayout r4 = r9.f40679a
            java.lang.String r5 = "mContainer"
            if (r4 != 0) goto L_0x006a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r4 = r1
        L_0x006a:
            android.graphics.drawable.GradientDrawable r0 = com.didi.soda.customer.foundation.util.BitmapUtil.getRoundRectDrawable(r2, r0)
            android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0
            r4.setBackground(r0)
            android.widget.LinearLayout r0 = r9.f40679a
            if (r0 != 0) goto L_0x007b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r0 = r1
        L_0x007b:
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            if (r0 == 0) goto L_0x01a4
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            java.lang.String r2 = "marginLeft"
            java.lang.Object r2 = r10.get(r2)
            r4 = 2
            if (r2 != 0) goto L_0x008d
            goto L_0x00a7
        L_0x008d:
            android.content.Context r6 = r9.getContext()     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00a0 }
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ Exception -> 0x00a0 }
            float r7 = (float) r4     // Catch:{ Exception -> 0x00a0 }
            float r2 = r2 / r7
            int r2 = com.didi.app.nova.support.util.DisplayUtils.dip2px(r6, r2)     // Catch:{ Exception -> 0x00a0 }
            goto L_0x00a1
        L_0x00a0:
            r2 = 0
        L_0x00a1:
            r0.leftMargin = r2
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x00a7:
            java.lang.String r2 = "marginRight"
            java.lang.Object r2 = r10.get(r2)
            if (r2 != 0) goto L_0x00b0
            goto L_0x00ca
        L_0x00b0:
            android.content.Context r6 = r9.getContext()     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00c3 }
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ Exception -> 0x00c3 }
            float r7 = (float) r4     // Catch:{ Exception -> 0x00c3 }
            float r2 = r2 / r7
            int r2 = com.didi.app.nova.support.util.DisplayUtils.dip2px(r6, r2)     // Catch:{ Exception -> 0x00c3 }
            goto L_0x00c4
        L_0x00c3:
            r2 = 0
        L_0x00c4:
            r0.rightMargin = r2
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x00ca:
            java.lang.String r2 = "marginTop"
            java.lang.Object r2 = r10.get(r2)
            if (r2 != 0) goto L_0x00d3
            goto L_0x00ed
        L_0x00d3:
            android.content.Context r6 = r9.getContext()     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00e6 }
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ Exception -> 0x00e6 }
            float r7 = (float) r4     // Catch:{ Exception -> 0x00e6 }
            float r2 = r2 / r7
            int r2 = com.didi.app.nova.support.util.DisplayUtils.dip2px(r6, r2)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00e7
        L_0x00e6:
            r2 = 0
        L_0x00e7:
            r0.topMargin = r2
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x00ed:
            java.lang.String r2 = "bottomMargin"
            java.lang.Object r2 = r10.get(r2)
            if (r2 != 0) goto L_0x00f6
            goto L_0x0110
        L_0x00f6:
            android.content.Context r6 = r9.getContext()     // Catch:{ Exception -> 0x0109 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0109 }
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ Exception -> 0x0109 }
            float r7 = (float) r4     // Catch:{ Exception -> 0x0109 }
            float r2 = r2 / r7
            int r2 = com.didi.app.nova.support.util.DisplayUtils.dip2px(r6, r2)     // Catch:{ Exception -> 0x0109 }
            goto L_0x010a
        L_0x0109:
            r2 = 0
        L_0x010a:
            r0.bottomMargin = r2
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x0110:
            android.widget.LinearLayout r2 = r9.f40679a
            if (r2 != 0) goto L_0x0118
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r2 = r1
        L_0x0118:
            android.view.ViewGroup$LayoutParams r0 = (android.view.ViewGroup.LayoutParams) r0
            r2.setLayoutParams(r0)
            java.lang.String r0 = "paddingLeft"
            java.lang.Object r0 = r10.get(r0)
            if (r0 != 0) goto L_0x0128
        L_0x0126:
            r0 = 0
            goto L_0x013a
        L_0x0128:
            android.content.Context r2 = r9.getContext()     // Catch:{ Exception -> 0x0126 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0126 }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ Exception -> 0x0126 }
            float r6 = (float) r4     // Catch:{ Exception -> 0x0126 }
            float r0 = r0 / r6
            int r0 = com.didi.app.nova.support.util.DisplayUtils.dip2px(r2, r0)     // Catch:{ Exception -> 0x0126 }
        L_0x013a:
            java.lang.String r2 = "paddingTop"
            java.lang.Object r2 = r10.get(r2)
            if (r2 != 0) goto L_0x0145
        L_0x0143:
            r2 = 0
            goto L_0x0157
        L_0x0145:
            android.content.Context r6 = r9.getContext()     // Catch:{ Exception -> 0x0143 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0143 }
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ Exception -> 0x0143 }
            float r7 = (float) r4     // Catch:{ Exception -> 0x0143 }
            float r2 = r2 / r7
            int r2 = com.didi.app.nova.support.util.DisplayUtils.dip2px(r6, r2)     // Catch:{ Exception -> 0x0143 }
        L_0x0157:
            java.lang.String r6 = "paddingRight"
            java.lang.Object r6 = r10.get(r6)
            if (r6 != 0) goto L_0x0162
        L_0x0160:
            r6 = 0
            goto L_0x0174
        L_0x0162:
            android.content.Context r7 = r9.getContext()     // Catch:{ Exception -> 0x0160 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0160 }
            float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ Exception -> 0x0160 }
            float r8 = (float) r4     // Catch:{ Exception -> 0x0160 }
            float r6 = r6 / r8
            int r6 = com.didi.app.nova.support.util.DisplayUtils.dip2px(r7, r6)     // Catch:{ Exception -> 0x0160 }
        L_0x0174:
            java.lang.String r7 = "paddingBottom"
            java.lang.Object r10 = r10.get(r7)
            if (r10 != 0) goto L_0x017e
            goto L_0x0193
        L_0x017e:
            android.content.Context r7 = r9.getContext()     // Catch:{ Exception -> 0x0192 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0192 }
            float r10 = java.lang.Float.parseFloat(r10)     // Catch:{ Exception -> 0x0192 }
            float r4 = (float) r4     // Catch:{ Exception -> 0x0192 }
            float r10 = r10 / r4
            int r10 = com.didi.app.nova.support.util.DisplayUtils.dip2px(r7, r10)     // Catch:{ Exception -> 0x0192 }
            r3 = r10
            goto L_0x0193
        L_0x0192:
        L_0x0193:
            android.widget.LinearLayout r10 = r9.f40679a
            if (r10 != 0) goto L_0x019b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            goto L_0x019c
        L_0x019b:
            r1 = r10
        L_0x019c:
            r1.setPadding(r0, r2, r6, r3)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
        L_0x01a3:
            return
        L_0x01a4:
            java.lang.NullPointerException r10 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams"
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.widget.ColumnWidget.bindProps(java.util.HashMap):void");
    }

    public void bindChildren(List<? extends Buildable> list) {
        Intrinsics.checkNotNullParameter(list, "children");
        Iterable<Buildable> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Buildable view : iterable) {
            arrayList.add(view.getView());
        }
        for (View view2 : (List) arrayList) {
            LinearLayout linearLayout = this.f40679a;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                linearLayout = null;
            }
            linearLayout.addView(view2);
        }
    }

    public void onBindFinish(HashMap<String, Object> hashMap) {
        int i;
        Object obj;
        Buildable.DefaultImpls.onBindFinish(this, hashMap);
        String str = null;
        if (!(hashMap == null || (obj = hashMap.get(BlocksConst.WIDGET_PARAMS_ITEM_SPACE)) == null)) {
            str = obj.toString();
        }
        if (str == null) {
            i = 0;
        } else {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                LogUtil.m29102e("RowWidget", Intrinsics.stringPlus("itemSpacing 入参不能转成Int str = ", str));
                e.printStackTrace();
                m28898a(0);
                return;
            }
        }
        m28898a(DisplayUtils.dip2px(getContext(), Float.parseFloat(String.valueOf(i)) / ((float) 2)));
    }

    /* renamed from: a */
    private final void m28898a(int i) {
        int i2;
        Map linkedHashMap = new LinkedHashMap();
        Iterator it = getDynamicChildren().entrySet().iterator();
        while (true) {
            i2 = 0;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            if (((Buildable) entry.getValue()).getView().getVisibility() == 0) {
                i2 = 1;
            }
            if (i2 != 0) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Object next : linkedHashMap.values()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Buildable buildable = (Buildable) next;
            if (i2 > 0) {
                ViewGroup.LayoutParams layoutParams = buildable.getView().getLayoutParams();
                if (layoutParams != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.topMargin = i;
                    buildable.getView().setLayoutParams(marginLayoutParams);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
            }
            i2 = i3;
        }
    }

    public View getView() {
        return this;
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        Map linkedHashMap = new LinkedHashMap();
        Iterator it = getDynamicChildren().entrySet().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                return !linkedHashMap.isEmpty();
            }
            Map.Entry entry = (Map.Entry) it.next();
            if (((Buildable) entry.getValue()).getView().getVisibility() != 0) {
                z = false;
            }
            if (z) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
    }
}
