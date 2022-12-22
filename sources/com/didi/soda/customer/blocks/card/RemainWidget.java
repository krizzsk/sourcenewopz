package com.didi.soda.customer.blocks.card;

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
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "activity_count_down_card")
@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ0\u0010\u0012\u001a\u00020\u00132&\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\rH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011H\u0016J0\u0010\u001a\u001a\u00020\u001b2&\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\rH\u0016R4\u0010\n\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00020\u000bj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u0002`\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/RemainWidget;", "Landroid/widget/LinearLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "mWidgetNode", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "bindProps", "", "props", "", "getView", "Landroid/view/View;", "setWidgetNode", "widgetNode", "shouldShow", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RemainWidget.kt */
public final class RemainWidget extends LinearLayout implements Buildable {

    /* renamed from: a */
    private WidgetNodeModel f40582a;

    /* renamed from: b */
    private final HashMap<String, Buildable> f40583b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RemainWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RemainWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        return hashMap != null;
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RemainWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RemainWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f40583b = new HashMap<>();
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.customer_widget_topic_remain_layout, this);
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40583b;
    }

    public void setWidgetNode(WidgetNodeModel widgetNodeModel) {
        Buildable.DefaultImpls.setWidgetNode(this, widgetNodeModel);
        this.f40582a = widgetNodeModel;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: kotlin.Unit} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.lang.Long} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindProps(java.util.HashMap<java.lang.String, java.lang.Object> r8) {
        /*
            r7 = this;
            r0 = 8
            r1 = 2131429490(0x7f0b0872, float:1.8480654E38)
            r2 = 0
            if (r8 != 0) goto L_0x000a
            goto L_0x00a4
        L_0x000a:
            java.lang.String r3 = "countdown_timer"
            java.lang.Object r8 = r8.get(r3)
            if (r8 != 0) goto L_0x0014
            goto L_0x00a4
        L_0x0014:
            android.view.View r3 = r7.findViewById(r1)
            com.didi.soda.customer.blocks.widget.TimerWidget r3 = (com.didi.soda.customer.blocks.widget.TimerWidget) r3
            r4 = 0
            r3.setVisibility(r4)
            boolean r3 = r8 instanceof com.google.gson.JsonObject
            if (r3 == 0) goto L_0x0025
            com.google.gson.JsonObject r8 = (com.google.gson.JsonObject) r8
            goto L_0x0026
        L_0x0025:
            r8 = r2
        L_0x0026:
            if (r8 != 0) goto L_0x002a
            r8 = r2
            goto L_0x0039
        L_0x002a:
            com.google.gson.Gson r3 = new com.google.gson.Gson
            r3.<init>()
            com.google.gson.JsonElement r8 = (com.google.gson.JsonElement) r8
            java.lang.Class<com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity> r4 = com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity.class
            java.lang.Object r8 = r3.fromJson((com.google.gson.JsonElement) r8, r4)
            com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity r8 = (com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity) r8
        L_0x0039:
            if (r8 == 0) goto L_0x0099
            com.didi.soda.blocks.model.WidgetNodeModel r3 = r7.f40582a
            java.lang.String r4 = "timerLocalDeadline"
            if (r3 != 0) goto L_0x0044
        L_0x0042:
            r3 = r2
            goto L_0x004f
        L_0x0044:
            java.util.HashMap r3 = r3.getContextParams()
            if (r3 != 0) goto L_0x004b
            goto L_0x0042
        L_0x004b:
            java.lang.Object r3 = r3.get(r4)
        L_0x004f:
            boolean r5 = r3 instanceof java.lang.Long
            if (r5 == 0) goto L_0x0056
            r2 = r3
            java.lang.Long r2 = (java.lang.Long) r2
        L_0x0056:
            if (r2 != 0) goto L_0x007e
            long r2 = r8.getTs()
            long r5 = com.didi.soda.customer.foundation.rpc.Clock.timeAtSeconds()
            long r2 = r2 - r5
            r5 = 1000(0x3e8, float:1.401E-42)
            long r5 = (long) r5
            long r2 = r2 * r5
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 + r2
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            com.didi.soda.blocks.model.WidgetNodeModel r3 = r7.f40582a
            if (r3 != 0) goto L_0x0074
            goto L_0x007e
        L_0x0074:
            java.util.HashMap r3 = r3.getContextParams()
            if (r3 != 0) goto L_0x007b
            goto L_0x007e
        L_0x007b:
            r3.put(r4, r2)
        L_0x007e:
            android.view.View r3 = r7.findViewById(r1)
            com.didi.soda.customer.blocks.widget.TimerWidget r3 = (com.didi.soda.customer.blocks.widget.TimerWidget) r3
            long r4 = r2.longValue()
            r3.setupTimeEntity(r4, r8)
            android.view.View r8 = r7.findViewById(r1)
            com.didi.soda.customer.blocks.widget.TimerWidget r8 = (com.didi.soda.customer.blocks.widget.TimerWidget) r8
            com.didi.soda.customer.blocks.card.RemainWidget$bindProps$1$1 r2 = com.didi.soda.customer.blocks.card.RemainWidget$bindProps$1$1.INSTANCE
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r8.setOnTimerFinished(r2)
            goto L_0x00a2
        L_0x0099:
            android.view.View r8 = r7.findViewById(r1)
            com.didi.soda.customer.blocks.widget.TimerWidget r8 = (com.didi.soda.customer.blocks.widget.TimerWidget) r8
            r8.setVisibility(r0)
        L_0x00a2:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x00a4:
            if (r2 != 0) goto L_0x00af
            android.view.View r8 = r7.findViewById(r1)
            com.didi.soda.customer.blocks.widget.TimerWidget r8 = (com.didi.soda.customer.blocks.widget.TimerWidget) r8
            r8.setVisibility(r0)
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.card.RemainWidget.bindProps(java.util.HashMap):void");
    }

    public View getView() {
        return this;
    }
}
