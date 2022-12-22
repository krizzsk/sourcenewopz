package com.didi.soda.customer.blocks.card;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity;
import com.taxis99.R;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "topic_switch_tabs_v1")
@Metadata(mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ0\u0010\u0013\u001a\u00020\u00142&\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0016\u0010\u0019\u001a\u00020\u00142\f\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0016J(\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0018H\u0002J0\u0010\u001f\u001a\u00020 2&\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0010H\u0016R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R4\u0010\r\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00020\u000ej\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u0002`\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/TabsWidget;", "Landroid/widget/LinearLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "config", "Lcom/didi/soda/blocks/BinderRootConfig;", "Lcom/didi/soda/blocks/model/ComponentModel;", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "bindProps", "", "props", "", "getView", "Landroid/view/View;", "setBinderRootConfig", "setRadius", "index", "size", "radius", "view", "shouldShow", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TabsWidget.kt */
public final class TabsWidget extends LinearLayout implements Buildable {

    /* renamed from: a */
    private final HashMap<String, Buildable> f40587a;

    /* renamed from: b */
    private BinderRootConfig<ComponentModel> f40588b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TabsWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TabsWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        return true;
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

    public void setScope(IBlockScope iBlockScope) {
        Buildable.DefaultImpls.setScope(this, iBlockScope);
    }

    public void setWidgetNode(WidgetNodeModel widgetNodeModel) {
        Buildable.DefaultImpls.setWidgetNode(this, widgetNodeModel);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabsWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f40587a = new LinkedHashMap();
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.customer_shape_topic_landing_tabs_bg);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TabsWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40587a;
    }

    public View getView() {
        return this;
    }

    public void setBinderRootConfig(BinderRootConfig<?> binderRootConfig) {
        if (binderRootConfig == null) {
            binderRootConfig = null;
        }
        this.f40588b = binderRootConfig;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.util.ArrayList} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindProps(java.util.HashMap<java.lang.String, java.lang.Object> r15) {
        /*
            r14 = this;
            r14.removeAllViews()
            r0 = 0
            if (r15 != 0) goto L_0x0008
            r15 = r0
            goto L_0x000f
        L_0x0008:
            java.lang.String r1 = "tabs"
            java.lang.Object r15 = r15.get(r1)
        L_0x000f:
            boolean r1 = r15 instanceof com.google.gson.JsonArray
            if (r1 == 0) goto L_0x0016
            com.google.gson.JsonArray r15 = (com.google.gson.JsonArray) r15
            goto L_0x0017
        L_0x0016:
            r15 = r0
        L_0x0017:
            if (r15 != 0) goto L_0x001a
            goto L_0x0031
        L_0x001a:
            com.google.gson.Gson r0 = new com.google.gson.Gson
            r0.<init>()
            com.google.gson.JsonElement r15 = (com.google.gson.JsonElement) r15
            com.didi.soda.customer.blocks.card.TabsWidget$bindProps$tabList$1$1 r1 = new com.didi.soda.customer.blocks.card.TabsWidget$bindProps$tabList$1$1
            r1.<init>()
            java.lang.reflect.Type r1 = r1.getType()
            java.lang.Object r15 = r0.fromJson((com.google.gson.JsonElement) r15, (java.lang.reflect.Type) r1)
            r0 = r15
            java.util.ArrayList r0 = (java.util.ArrayList) r0
        L_0x0031:
            if (r0 != 0) goto L_0x0034
            goto L_0x0096
        L_0x0034:
            r15 = r0
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.Iterator r15 = r15.iterator()
            r1 = 0
            r2 = 0
        L_0x003d:
            boolean r3 = r15.hasNext()
            if (r3 == 0) goto L_0x0096
            java.lang.Object r3 = r15.next()
            int r4 = r2 + 1
            if (r2 >= 0) goto L_0x004e
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x004e:
            com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity r3 = (com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity) r3
            android.widget.LinearLayout$LayoutParams r5 = new android.widget.LinearLayout$LayoutParams
            r6 = -2
            r7 = 1065353216(0x3f800000, float:1.0)
            r5.<init>(r1, r6, r7)
            com.didi.soda.customer.blocks.view.TabItemView r6 = new com.didi.soda.customer.blocks.view.TabItemView
            android.content.Context r9 = r14.getContext()
            java.lang.String r7 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r7)
            r10 = 0
            r11 = 0
            r12 = 6
            r13 = 0
            r8 = r6
            r8.<init>(r9, r10, r11, r12, r13)
            r3.setIndex(r2)
            r6.bindProps(r3)
            android.view.ViewGroup$LayoutParams r5 = (android.view.ViewGroup.LayoutParams) r5
            r6.setLayoutParams(r5)
            com.didi.soda.customer.blocks.card.-$$Lambda$TabsWidget$c1I-g1Q1xjJlvqGUmmOu0MEgA44 r5 = new com.didi.soda.customer.blocks.card.-$$Lambda$TabsWidget$c1I-g1Q1xjJlvqGUmmOu0MEgA44
            r5.<init>(r14)
            r6.setOnClickListener(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r3 = r0.size()
            r5 = 2131165701(0x7f070205, float:1.7945627E38)
            int r5 = com.didi.soda.customer.foundation.util.ResourceHelper.getDimensionPixelSize(r5)
            android.view.View r6 = (android.view.View) r6
            r14.m28825a(r2, r3, r5, r6)
            r14.addView(r6)
            r2 = r4
            goto L_0x003d
        L_0x0096:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.card.TabsWidget.bindProps(java.util.HashMap):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28826a(TabInfoEntity tabInfoEntity, TabsWidget tabsWidget, View view) {
        BinderRootConfig<ComponentModel> binderRootConfig;
        Map<String, Function1<Object, Unit>> otherCallBacks;
        Function1 function1;
        Intrinsics.checkNotNullParameter(tabInfoEntity, "$tabInfoEntity");
        Intrinsics.checkNotNullParameter(tabsWidget, "this$0");
        if (tabInfoEntity.isSelect() != 1 && (binderRootConfig = tabsWidget.f40588b) != null && (otherCallBacks = binderRootConfig.getOtherCallBacks()) != null && (function1 = otherCallBacks.get(BlocksConst.CALLBACK_NAME_TAB_SWITCH)) != null) {
            function1.invoke(tabInfoEntity);
        }
    }

    /* renamed from: a */
    private final void m28825a(int i, int i2, int i3, View view) {
        GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground().mutate();
        if (i == 0) {
            if (i2 == 1) {
                gradientDrawable.setCornerRadius((float) i3);
            } else {
                float f = (float) i3;
                gradientDrawable.setCornerRadii(new float[]{f, f, 0.0f, 0.0f, 0.0f, 0.0f, f, f});
            }
        } else if (i == i2 - 1) {
            float f2 = (float) i3;
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, f2, f2, f2, f2, 0.0f, 0.0f});
        }
        view.setBackground(gradientDrawable);
    }
}
