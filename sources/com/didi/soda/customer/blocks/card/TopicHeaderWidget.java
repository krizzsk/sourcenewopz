package com.didi.soda.customer.blocks.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.blocks.view.AutoSizeTextView;
import com.didi.soda.customer.blocks.widget.TimerWidget;
import com.didi.soda.customer.foundation.rpc.entity.bill.RuleDescEntity;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.widget.text.IconRichTextView;
import com.didi.soda.customer.widget.text.RichTextView;
import com.didi.soda.router.DiRouter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@WidgetNameMeta(widgetName = "activity_header_image_card")
@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ0\u0010\u001b\u001a\u00020\u000e2&\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0016Jj\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0010\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010&2F\u0010(\u001aB\u0012\u0013\u0012\u00110$¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010&\u0012\u0004\u0012\u00020\u000e0)H\u0016J,\u0010-\u001a\u00020\u000e2\"\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001d0\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001d`\u0013H\u0002J,\u0010.\u001a\u00020\u000e2\"\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001d0\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001d`\u0013H\u0002J,\u0010/\u001a\u00020\u000e2\"\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001d0\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001d`\u0013H\u0002J,\u00100\u001a\u00020\u000e2\"\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001d0\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001d`\u0013H\u0002J\u0010\u00101\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u00102\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J0\u00103\u001a\u00020\"2&\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u0013H\u0016J0\u00104\u001a\u00020\u000e2&\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u0013H\u0002J0\u00105\u001a\u00020\u000e2&\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u0013H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0004\u0018\u0001`\u000fX\u000e¢\u0006\u0002\n\u0000R4\u0010\u0010\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u00020\u0011j\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u0002`\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u00067"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/TopicHeaderWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgAspect", "", "countDownCallback", "Lkotlin/Function0;", "", "Lcom/didi/soda/customer/foundation/util/VoidCallback;", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "headerType", "trackCkBean", "Lcom/didi/soda/customer/blocks/card/TrackCkBean;", "widgetNode", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "bindProps", "props", "", "fixImageAspect", "getView", "Landroid/view/View;", "handleClickTrigger", "", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "actions", "", "Lcom/didi/soda/blocks/action/BaseAction;", "handler", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "widget", "setBgImage", "setCountDown", "setLogImg", "setRule", "setScope", "setWidgetNode", "shouldShow", "updateBottomMargin", "updateMargin", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopicHeaderWidget.kt */
public final class TopicHeaderWidget extends ConstraintLayout implements Buildable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int HEADER_TYPE_BRAND = 1;
    public static final int HEADER_TYPE_NORMAL = 0;

    /* renamed from: a */
    private WidgetNodeModel f40590a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Function0<Unit> f40591b;

    /* renamed from: c */
    private int f40592c;

    /* renamed from: d */
    private float f40593d;

    /* renamed from: e */
    private C13681b f40594e;

    /* renamed from: f */
    private final HashMap<String, Buildable> f40595f;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TopicHeaderWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TopicHeaderWidget(Context context, AttributeSet attributeSet) {
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TopicHeaderWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopicHeaderWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.customer_item_activity_header, this);
        this.f40593d = ((float) DisplayUtils.getScreenWidth(context)) / 750.0f;
        this.f40595f = new HashMap<>();
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40595f;
    }

    public void setWidgetNode(WidgetNodeModel widgetNodeModel) {
        this.f40590a = widgetNodeModel;
        Buildable.DefaultImpls.setWidgetNode(this, widgetNodeModel);
    }

    public boolean handleClickTrigger(IBlockScope iBlockScope, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(function3, "handler");
        this.f40594e = new C13681b(iBlockScope, list, function3);
        return true;
    }

    public void setScope(IBlockScope iBlockScope) {
        Object obj;
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        ScopeContext scopeContext = (ScopeContext) iBlockScope.getObject(Const.BusinessConst.SCOPE_KEY_SCOPE_CONTEXT);
        Function0<Unit> function0 = null;
        if (scopeContext == null) {
            obj = null;
        } else {
            obj = scopeContext.getObject(Const.TopicActivity.KEY_COUNT_DOWN_CALLBACK);
        }
        if (TypeIntrinsics.isFunctionOfArity(obj, 0)) {
            function0 = (Function0) obj;
        }
        this.f40591b = function0;
    }

    private final void setBgImage(HashMap<String, Object> hashMap) {
        Object obj = hashMap.get(BlocksConst.WIDGET_PARAMS_BG_IMAGE);
        String str = null;
        String obj2 = obj == null ? null : obj.toString();
        CharSequence charSequence = obj2;
        if (charSequence == null || charSequence.length() == 0) {
            ((ImageView) findViewById(R.id.customer_activity_header_image)).setBackgroundColor(CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF));
        } else {
            ((ImageView) findViewById(R.id.customer_activity_header_image)).setBackgroundColor(CustomerExtentionKt.getColor(R.color.rf_color_white_100_alpha_0));
            FlyImageLoader.loadImage1x1(getContext(), obj2).dontAnimate().into((ImageView) findViewById(R.id.customer_activity_header_image));
        }
        Object obj3 = hashMap.get(BlocksConst.WIDGET_PARAMS_AMBIENT_IMG);
        if (obj3 != null) {
            str = obj3.toString();
        }
        FlyImageLoader.loadImageUnspecified(getContext(), str).dontAnimate().into((ImageView) findViewById(R.id.customer_activity_header_fro_img));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: kotlin.Unit} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: kotlin.Unit} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: java.lang.Long} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setCountDown(java.util.HashMap<java.lang.String, java.lang.Object> r7) {
        /*
            r6 = this;
            java.lang.String r0 = "countdown_timer"
            java.lang.Object r7 = r7.get(r0)
            r0 = 8
            r1 = 2131428457(0x7f0b0469, float:1.847856E38)
            r2 = 0
            if (r7 != 0) goto L_0x0010
            goto L_0x0094
        L_0x0010:
            android.view.View r3 = r6.findViewById(r1)
            com.didi.soda.customer.blocks.widget.TimerWidget r3 = (com.didi.soda.customer.blocks.widget.TimerWidget) r3
            r4 = 0
            r3.setVisibility(r4)
            boolean r3 = r7 instanceof com.google.gson.JsonObject
            if (r3 == 0) goto L_0x0021
            com.google.gson.JsonObject r7 = (com.google.gson.JsonObject) r7
            goto L_0x0022
        L_0x0021:
            r7 = r2
        L_0x0022:
            if (r7 != 0) goto L_0x0026
            r7 = r2
            goto L_0x0035
        L_0x0026:
            com.google.gson.Gson r3 = new com.google.gson.Gson
            r3.<init>()
            com.google.gson.JsonElement r7 = (com.google.gson.JsonElement) r7
            java.lang.Class<com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity> r4 = com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity.class
            java.lang.Object r7 = r3.fromJson((com.google.gson.JsonElement) r7, r4)
            com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity r7 = (com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity) r7
        L_0x0035:
            if (r7 == 0) goto L_0x0089
            com.didi.soda.blocks.model.WidgetNodeModel r3 = r6.f40590a
            java.lang.String r4 = "timerLocalDeadline"
            if (r3 != 0) goto L_0x0040
        L_0x003e:
            r3 = r2
            goto L_0x004b
        L_0x0040:
            java.util.HashMap r3 = r3.getContextParams()
            if (r3 != 0) goto L_0x0047
            goto L_0x003e
        L_0x0047:
            java.lang.Object r3 = r3.get(r4)
        L_0x004b:
            boolean r5 = r3 instanceof java.lang.Long
            if (r5 == 0) goto L_0x0052
            r2 = r3
            java.lang.Long r2 = (java.lang.Long) r2
        L_0x0052:
            if (r2 != 0) goto L_0x006b
            long r2 = r7.getLocalDeadline()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            com.didi.soda.blocks.model.WidgetNodeModel r3 = r6.f40590a
            if (r3 != 0) goto L_0x0061
            goto L_0x006b
        L_0x0061:
            java.util.HashMap r3 = r3.getContextParams()
            if (r3 != 0) goto L_0x0068
            goto L_0x006b
        L_0x0068:
            r3.put(r4, r2)
        L_0x006b:
            android.view.View r3 = r6.findViewById(r1)
            com.didi.soda.customer.blocks.widget.TimerWidget r3 = (com.didi.soda.customer.blocks.widget.TimerWidget) r3
            long r4 = r2.longValue()
            r3.setupTimeEntity(r4, r7)
            android.view.View r7 = r6.findViewById(r1)
            com.didi.soda.customer.blocks.widget.TimerWidget r7 = (com.didi.soda.customer.blocks.widget.TimerWidget) r7
            com.didi.soda.customer.blocks.card.TopicHeaderWidget$setCountDown$1$1 r2 = new com.didi.soda.customer.blocks.card.TopicHeaderWidget$setCountDown$1$1
            r2.<init>(r6)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r7.setOnTimerFinished(r2)
            goto L_0x0092
        L_0x0089:
            android.view.View r7 = r6.findViewById(r1)
            com.didi.soda.customer.blocks.widget.TimerWidget r7 = (com.didi.soda.customer.blocks.widget.TimerWidget) r7
            r7.setVisibility(r0)
        L_0x0092:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x0094:
            if (r2 != 0) goto L_0x009f
            android.view.View r7 = r6.findViewById(r1)
            com.didi.soda.customer.blocks.widget.TimerWidget r7 = (com.didi.soda.customer.blocks.widget.TimerWidget) r7
            r7.setVisibility(r0)
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.card.TopicHeaderWidget.setCountDown(java.util.HashMap):void");
    }

    private final void setLogImg(HashMap<String, Object> hashMap) {
        Object obj = hashMap.get(BlocksConst.WIDGET_PARAMS_ICON_IMAGE);
        String obj2 = obj == null ? null : obj.toString();
        CharSequence charSequence = obj2;
        if (charSequence == null || charSequence.length() == 0) {
            ((ImageView) findViewById(R.id.custom_activity_header_logo_img)).setVisibility(8);
            return;
        }
        ((ImageView) findViewById(R.id.custom_activity_header_logo_img)).setVisibility(0);
        FlyImageLoader.loadImage1x1(getContext(), obj2).dontAnimate().into((ImageView) findViewById(R.id.custom_activity_header_logo_img));
    }

    private final void setRule(HashMap<String, Object> hashMap) {
        String str;
        JsonElement jsonElement;
        Object obj = hashMap.get(BlocksConst.WIDGET_PARAMS_VIEW_RULES);
        if (obj == null) {
            ((RichTextView) findViewById(R.id.customer_activity_header_rule)).setVisibility(8);
            return;
        }
        String str2 = null;
        JsonObject jsonObject = obj instanceof JsonObject ? (JsonObject) obj : null;
        if (jsonObject == null || (jsonElement = jsonObject.get("content")) == null) {
            str = null;
        } else {
            str = jsonElement.getAsString();
        }
        if (jsonObject != null) {
            CharSequence charSequence = str;
            if (!(charSequence == null || charSequence.length() == 0)) {
                ((RichTextView) findViewById(R.id.customer_activity_header_rule)).setVisibility(0);
                ((RichTextView) findViewById(R.id.customer_activity_header_rule)).setText(charSequence);
                JsonElement jsonElement2 = jsonObject.get("icon");
                ((IconRichTextView) findViewById(R.id.customer_activity_header_rule_icon)).setText(jsonElement2 == null ? null : jsonElement2.getAsString());
                JsonElement jsonElement3 = jsonObject.get("url");
                String asString = jsonElement3 == null ? null : jsonElement3.getAsString();
                JsonElement jsonElement4 = jsonObject.get("details");
                if (jsonElement4 != null) {
                    str2 = jsonElement4.getAsString();
                }
                ((LinearLayout) findViewById(R.id.customer_activity_header_rule_layout)).setOnClickListener(new View.OnClickListener(str2, asString, this) {
                    public final /* synthetic */ String f$0;
                    public final /* synthetic */ String f$1;
                    public final /* synthetic */ TopicHeaderWidget f$2;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        TopicHeaderWidget.m28828a(this.f$0, this.f$1, this.f$2, view);
                    }
                });
                return;
            }
        }
        ((RichTextView) findViewById(R.id.customer_activity_header_rule)).setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28828a(String str, String str2, TopicHeaderWidget topicHeaderWidget, View view) {
        Intrinsics.checkNotNullParameter(topicHeaderWidget, "this$0");
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            RuleDescEntity ruleDescEntity = new RuleDescEntity();
            ruleDescEntity.content = str;
            ruleDescEntity.title = "";
            DiRouter.request().path("priceRuleDescPage").putParcelable("entity", ruleDescEntity).open();
        } else {
            SchemeHelper.dispatchMsg(str2);
        }
        C13681b bVar = topicHeaderWidget.f40594e;
        if (bVar != null) {
            bVar.mo102457c().invoke(bVar.mo102452a(), topicHeaderWidget, bVar.mo102456b());
        }
    }

    /* renamed from: a */
    private final void m28829a(HashMap<String, Object> hashMap) {
        m28830b(hashMap);
        ViewGroup.LayoutParams layoutParams = ((ConstraintLayout) findViewById(R.id.customer_activity_header_content_layout)).getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i = 194;
            if (((ImageView) findViewById(R.id.custom_activity_header_logo_img)).getVisibility() == 8 && ((TimerWidget) findViewById(R.id.customer_activity_header_count_down)).getVisibility() == 8 && ((RichTextView) findViewById(R.id.customer_activity_header_subtitle)).getVisibility() == 8) {
                i = 234;
            }
            marginLayoutParams.topMargin = (int) (((float) i) * this.f40593d);
            ViewGroup.LayoutParams layoutParams2 = ((AutoSizeTextView) findViewById(R.id.customer_activity_header_title)).getLayoutParams();
            if (layoutParams2 != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = (int) (((float) 48) * this.f40593d);
                ViewGroup.LayoutParams layoutParams3 = ((RichTextView) findViewById(R.id.customer_activity_header_subtitle)).getLayoutParams();
                if (layoutParams3 != null) {
                    float f = (float) 28;
                    ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = (int) (this.f40593d * f);
                    ViewGroup.LayoutParams layoutParams4 = ((TimerWidget) findViewById(R.id.customer_activity_header_count_down)).getLayoutParams();
                    if (layoutParams4 != null) {
                        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = (int) (f * this.f40593d);
                        ViewGroup.LayoutParams layoutParams5 = ((LinearLayout) findViewById(R.id.customer_activity_header_rule_layout)).getLayoutParams();
                        if (layoutParams5 != null) {
                            ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = (int) (((float) 40) * this.f40593d);
                            requestLayout();
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        int i;
        if (hashMap != null) {
            Object obj = hashMap.get(BlocksConst.WIDGET_PARAMS_TYPE_HEADER_TYPE);
            String str = null;
            String obj2 = obj == null ? null : obj.toString();
            boolean z = true;
            if (obj2 != null && Integer.parseInt(obj2) == 1) {
                i = 1;
            } else {
                i = 0;
            }
            this.f40592c = i;
            setBgImage(hashMap);
            int i2 = this.f40592c;
            if (i2 == 0) {
                ((ConstraintLayout) findViewById(R.id.customer_activity_header_content_layout)).setVisibility(0);
                m28827a();
                setCountDown(hashMap);
                Object obj3 = hashMap.get("title");
                CharSequence obj4 = obj3 == null ? null : obj3.toString();
                if (obj4 == null || obj4.length() == 0) {
                    ((AutoSizeTextView) findViewById(R.id.customer_activity_header_title)).setVisibility(8);
                } else {
                    ((AutoSizeTextView) findViewById(R.id.customer_activity_header_title)).setVisibility(0);
                    ((AutoSizeTextView) findViewById(R.id.customer_activity_header_title)).setText(obj4);
                }
                Object obj5 = hashMap.get(BlocksConst.WIDGET_PARAMS_TYPE_SUB_TITLE);
                if (obj5 != null) {
                    str = obj5.toString();
                }
                CharSequence charSequence = str;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    z = false;
                }
                if (z) {
                    ((RichTextView) findViewById(R.id.customer_activity_header_subtitle)).setVisibility(8);
                } else {
                    ((RichTextView) findViewById(R.id.customer_activity_header_subtitle)).setVisibility(0);
                    ((RichTextView) findViewById(R.id.customer_activity_header_subtitle)).setText(charSequence);
                }
                setLogImg(hashMap);
                setRule(hashMap);
                m28829a(hashMap);
            } else if (i2 == 1) {
                ((ConstraintLayout) findViewById(R.id.customer_activity_header_content_layout)).setVisibility(8);
                m28830b(hashMap);
            }
        }
    }

    /* renamed from: a */
    private final void m28827a() {
        ViewGroup.LayoutParams layoutParams = ((ImageView) findViewById(R.id.customer_activity_header_fro_img)).getLayoutParams();
        layoutParams.width = (int) (this.f40593d * 400.0f);
        ((ImageView) findViewById(R.id.customer_activity_header_fro_img)).setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    private final void m28830b(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            Object obj = hashMap.get(BlocksConst.WIDGET_PARAMS_MARGIN_BOTTOM);
            int i = 0;
            if (obj != null) {
                try {
                    i = DisplayUtils.dip2px(getContext(), Float.parseFloat(obj.toString()) / ((float) 2));
                } catch (Exception unused) {
                }
            }
            ViewGroup.LayoutParams layoutParams = ((ImageView) findViewById(R.id.customer_activity_header_image)).getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = i;
                int i2 = this.f40592c;
                if (i2 == 0) {
                    marginLayoutParams.height = (int) (((float) 534) * this.f40593d);
                } else if (i2 == 1) {
                    marginLayoutParams.height = (int) (((float) 774) * this.f40593d);
                }
                ((ImageView) findViewById(R.id.customer_activity_header_image)).setLayoutParams(marginLayoutParams);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
    }

    public View getView() {
        return this;
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        return hashMap != null && hashMap.size() > 0;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/TopicHeaderWidget$Companion;", "", "()V", "HEADER_TYPE_BRAND", "", "HEADER_TYPE_NORMAL", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TopicHeaderWidget.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
