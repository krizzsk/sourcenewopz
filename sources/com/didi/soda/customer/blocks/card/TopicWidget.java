package com.didi.soda.customer.blocks.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.blocks.ItemOperationListener;
import com.didi.soda.customer.blocks.widget.ScrollWidget;
import com.didi.soda.customer.blocks.widget.TimerWidget;
import com.didi.soda.customer.blocks.widget.TopicMoreWidget;
import com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.widget.text.IconRichTextView;
import com.didi.soda.customer.widget.text.RichTextView;
import com.didi.soda.home.topgun.binder.model.HomeHorizontalScrollTopicRvModel;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.Request;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "topic_card_v1")
@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0016\u0010\u001f\u001a\u00020\u001d2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020!H\u0016J0\u0010\"\u001a\u00020\u001d2&\u0010#\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$\u0018\u0001`\u000eH\u0016J\u001e\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002J\b\u0010+\u001a\u00020,H\u0016Jj\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0010\u00101\u001a\f\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u00010!2F\u00103\u001aB\u0012\u0013\u0012\u001100¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u00010!\u0012\u0004\u0012\u00020\u001d04H\u0016J0\u00108\u001a\u00020\u001d2&\u0010#\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$\u0018\u0001`\u000eH\u0016J\b\u00109\u001a\u00020\u001dH\u0016J\b\u0010:\u001a\u00020\u001dH\u0002J\u0012\u0010;\u001a\u00020\u001d2\b\u0010<\u001a\u0004\u0018\u00010\u0012H\u0016J0\u0010=\u001a\u00020.2&\u0010#\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$\u0018\u0001`\u000eH\u0016R4\u0010\u000b\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00020\fj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u0002`\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u0016@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/TopicWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "<set-?>", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "mWidgetNode", "getMWidgetNode", "()Lcom/didi/soda/blocks/model/WidgetNodeModel;", "Lcom/didi/soda/home/topgun/binder/model/HomeHorizontalScrollTopicRvModel;", "rvModel", "getRvModel", "()Lcom/didi/soda/home/topgun/binder/model/HomeHorizontalScrollTopicRvModel;", "skin", "Lcom/didi/soda/customer/blocks/card/Skin;", "addOnScrollListener", "", "adjustChildrenHeight", "bindChildren", "children", "", "bindProps", "props", "", "findRelayoutTarget", "parent", "Landroid/view/ViewGroup;", "targetList", "", "Lcom/didi/soda/customer/blocks/ItemOperationListener;", "getView", "Landroid/view/View;", "handleClickTrigger", "", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "actions", "Lcom/didi/soda/blocks/action/BaseAction;", "handler", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "widget", "onBindFinish", "onGlobalLayout", "scrollOffset", "setWidgetNode", "widgetNode", "shouldShow", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopicWidget.kt */
public final class TopicWidget extends ConstraintLayout implements ViewTreeObserver.OnGlobalLayoutListener, Buildable {

    /* renamed from: a */
    private HomeHorizontalScrollTopicRvModel f40604a;

    /* renamed from: b */
    private WidgetNodeModel f40605b;

    /* renamed from: c */
    private final C13680a f40606c;

    /* renamed from: d */
    private final HashMap<String, Buildable> f40607d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TopicWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TopicWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        return hashMap != null;
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
    public /* synthetic */ TopicWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopicWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f40606c = new C13680a(this);
        LayoutInflater.from(context).inflate(R.layout.customer_widget_topic_layout, this);
        this.f40607d = new HashMap<>();
    }

    public final HomeHorizontalScrollTopicRvModel getRvModel() {
        return this.f40604a;
    }

    public final WidgetNodeModel getMWidgetNode() {
        return this.f40605b;
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40607d;
    }

    public View getView() {
        return this;
    }

    public boolean handleClickTrigger(IBlockScope iBlockScope, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(function3, "handler");
        ((RelativeLayout) findViewById(R.id.customer_home_topic_title_container)).setOnClickListener(new View.OnClickListener(iBlockScope, this, list) {
            public final /* synthetic */ IBlockScope f$1;
            public final /* synthetic */ TopicWidget f$2;
            public final /* synthetic */ List f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onClick(View view) {
                TopicWidget.m28850a(Function3.this, this.f$1, this.f$2, this.f$3, view);
            }
        });
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28850a(Function3 function3, IBlockScope iBlockScope, TopicWidget topicWidget, List list, View view) {
        Intrinsics.checkNotNullParameter(function3, "$handler");
        Intrinsics.checkNotNullParameter(iBlockScope, "$scope");
        Intrinsics.checkNotNullParameter(topicWidget, "this$0");
        function3.invoke(iBlockScope, topicWidget, list);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x005a, code lost:
        if (((r0 == null || (r0 = r0.mGoodsInfoRvModels) == null) ? 0 : r0.size()) > 0) goto L_0x005e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setWidgetNode(com.didi.soda.blocks.model.WidgetNodeModel r5) {
        /*
            r4 = this;
            r4.f40605b = r5
            r0 = 0
            if (r5 != 0) goto L_0x0007
            r1 = r0
            goto L_0x000b
        L_0x0007:
            java.lang.Object r1 = r5.getDataModel()
        L_0x000b:
            boolean r2 = r1 instanceof com.didi.soda.blocks.model.ComponentModel
            if (r2 == 0) goto L_0x0012
            com.didi.soda.blocks.model.ComponentModel r1 = (com.didi.soda.blocks.model.ComponentModel) r1
            goto L_0x0013
        L_0x0012:
            r1 = r0
        L_0x0013:
            if (r1 != 0) goto L_0x0017
            r1 = r0
            goto L_0x001b
        L_0x0017:
            java.lang.Object r1 = r1.getDataModel()
        L_0x001b:
            boolean r2 = r1 instanceof com.didi.soda.home.topgun.binder.model.HomeHorizontalScrollTopicRvModel
            if (r2 == 0) goto L_0x0022
            com.didi.soda.home.topgun.binder.model.HomeHorizontalScrollTopicRvModel r1 = (com.didi.soda.home.topgun.binder.model.HomeHorizontalScrollTopicRvModel) r1
            goto L_0x0023
        L_0x0022:
            r1 = r0
        L_0x0023:
            r4.f40604a = r1
            if (r1 != 0) goto L_0x0029
            r1 = r0
            goto L_0x002b
        L_0x0029:
            java.util.List<com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel> r1 = r1.mBusinessInfoRvModels
        L_0x002b:
            r2 = 0
            if (r1 == 0) goto L_0x0041
            com.didi.soda.home.topgun.binder.model.HomeHorizontalScrollTopicRvModel r1 = r4.f40604a
            if (r1 != 0) goto L_0x0034
        L_0x0032:
            r1 = 0
            goto L_0x003d
        L_0x0034:
            java.util.List<com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel> r1 = r1.mBusinessInfoRvModels
            if (r1 != 0) goto L_0x0039
            goto L_0x0032
        L_0x0039:
            int r1 = r1.size()
        L_0x003d:
            if (r1 <= 0) goto L_0x0041
            r1 = 1
            goto L_0x0042
        L_0x0041:
            r1 = 0
        L_0x0042:
            com.didi.soda.home.topgun.binder.model.HomeHorizontalScrollTopicRvModel r3 = r4.f40604a
            if (r3 != 0) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            java.util.List<com.didi.soda.business.model.BusinessGoodsItemRvModel> r0 = r3.mGoodsInfoRvModels
        L_0x0049:
            if (r0 == 0) goto L_0x005d
            com.didi.soda.home.topgun.binder.model.HomeHorizontalScrollTopicRvModel r0 = r4.f40604a
            if (r0 != 0) goto L_0x0051
        L_0x004f:
            r0 = 0
            goto L_0x005a
        L_0x0051:
            java.util.List<com.didi.soda.business.model.BusinessGoodsItemRvModel> r0 = r0.mGoodsInfoRvModels
            if (r0 != 0) goto L_0x0056
            goto L_0x004f
        L_0x0056:
            int r0 = r0.size()
        L_0x005a:
            if (r0 <= 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r2 = r1
        L_0x005e:
            if (r5 != 0) goto L_0x0061
            goto L_0x0071
        L_0x0061:
            java.util.HashMap r5 = r5.getContextParams()
            if (r5 != 0) goto L_0x0068
            goto L_0x0071
        L_0x0068:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            java.lang.String r1 = "itemIsShop"
            r5.put(r1, r0)
        L_0x0071:
            if (r2 == 0) goto L_0x0084
            r5 = 2131429023(0x7f0b069f, float:1.8479707E38)
            android.view.View r5 = r4.findViewById(r5)
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            com.didi.soda.customer.blocks.card.-$$Lambda$TopicWidget$pRZUD_J-XnXbSul6oeY09NTflvY r0 = new com.didi.soda.customer.blocks.card.-$$Lambda$TopicWidget$pRZUD_J-XnXbSul6oeY09NTflvY
            r0.<init>()
            r5.setOnClickListener(r0)
        L_0x0084:
            r4.m28847a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.card.TopicWidget.setWidgetNode(com.didi.soda.blocks.model.WidgetNodeModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28849a(TopicWidget topicWidget, View view) {
        Intrinsics.checkNotNullParameter(topicWidget, "this$0");
        Request.Builder path = DiRouter.request().path(RoutePath.BLOCKS_LANDING_PAGE);
        HomeHorizontalScrollTopicRvModel rvModel = topicWidget.getRvModel();
        String str = null;
        Request.Builder putString = path.putString(Const.PageParams.COMPONENT_ID, rvModel == null ? null : rvModel.mComponentId);
        HomeHorizontalScrollTopicRvModel rvModel2 = topicWidget.getRvModel();
        Request.Builder putString2 = putString.putString("recid", rvModel2 == null ? null : rvModel2.mRecId);
        HomeHorizontalScrollTopicRvModel rvModel3 = topicWidget.getRvModel();
        Request.Builder putString3 = putString2.putString("scene", rvModel3 == null ? null : Integer.valueOf(rvModel3.mScene).toString());
        HomeHorizontalScrollTopicRvModel rvModel4 = topicWidget.getRvModel();
        if (rvModel4 != null) {
            str = rvModel4.mTopicTitle;
        }
        putString3.putString(Const.PageParams.TOPIC_TITLE, str).open();
        HomeOmegaHelper.getInstance().trackShowAllClick();
    }

    /* renamed from: a */
    private final void m28847a() {
        ScrollWidget scrollWidget;
        Object obj;
        Collection<Buildable> values = getDynamicChildren().values();
        Intrinsics.checkNotNullExpressionValue(values, "dynamicChildren.values");
        Iterator it = values.iterator();
        while (true) {
            scrollWidget = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Buildable) obj) instanceof ScrollWidget) {
                break;
            }
        }
        if (obj instanceof ScrollWidget) {
            scrollWidget = (ScrollWidget) obj;
        }
        if (scrollWidget != null) {
            HomeHorizontalScrollTopicRvModel homeHorizontalScrollTopicRvModel = this.f40604a;
            scrollWidget.scrollTo(homeHorizontalScrollTopicRvModel == null ? 0 : homeHorizontalScrollTopicRvModel.mScrollX, 0);
        }
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        Unit unit;
        Unit unit2;
        Object obj;
        CountDownEntity countDownEntity;
        HashMap<String, Object> contextParams;
        HashMap<String, Object> contextParams2;
        String str;
        String str2;
        Object obj2;
        Object obj3;
        if (hashMap != null) {
            Object obj4 = hashMap.get("title");
            boolean z = false;
            Object obj5 = null;
            if (obj4 == null) {
                unit = null;
            } else {
                ((LinearLayout) findViewById(R.id.customer_home_topic_title_layout)).setVisibility(0);
                HashMap hashMap2 = obj4 instanceof HashMap ? (HashMap) obj4 : null;
                if (hashMap2 == null || (obj3 = hashMap2.get("content")) == null) {
                    str = null;
                } else {
                    str = obj3.toString();
                }
                if (hashMap2 == null || (obj2 = hashMap2.get("icon")) == null) {
                    str2 = null;
                } else {
                    str2 = obj2.toString();
                }
                ((RichTextView) findViewById(R.id.customer_home_topic_title)).setText(str);
                ((IconRichTextView) findViewById(R.id.customer_home_topic_icon)).setText(str2);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                ((LinearLayout) findViewById(R.id.customer_home_topic_title_layout)).setVisibility(8);
            }
            Object obj6 = hashMap.get(BlocksConst.WIDGET_PARAMS_TYPE_COUNTDOWN_TIMER);
            if (obj6 == null) {
                unit2 = null;
            } else {
                ((TimerWidget) findViewById(R.id.customer_home_topic_timer)).setVisibility(0);
                JsonObject jsonObject = obj6 instanceof JsonObject ? (JsonObject) obj6 : null;
                if (jsonObject == null) {
                    countDownEntity = null;
                } else {
                    countDownEntity = (CountDownEntity) new Gson().fromJson((JsonElement) jsonObject, CountDownEntity.class);
                }
                if (countDownEntity != null) {
                    WidgetNodeModel mWidgetNode = getMWidgetNode();
                    Object obj7 = (mWidgetNode == null || (contextParams2 = mWidgetNode.getContextParams()) == null) ? null : contextParams2.get(BlocksConst.KEY_TIMER_LOCAL_DEADLINE);
                    Long l = obj7 instanceof Long ? (Long) obj7 : null;
                    if (l == null) {
                        l = Long.valueOf(countDownEntity.getLocalDeadline());
                        WidgetNodeModel mWidgetNode2 = getMWidgetNode();
                        if (!(mWidgetNode2 == null || (contextParams = mWidgetNode2.getContextParams()) == null)) {
                            contextParams.put(BlocksConst.KEY_TIMER_LOCAL_DEADLINE, l);
                        }
                    }
                    ((TimerWidget) findViewById(R.id.customer_home_topic_timer)).setAntiShake(true);
                    ((TimerWidget) findViewById(R.id.customer_home_topic_timer)).setupTimeEntity(l.longValue(), countDownEntity);
                    ((TimerWidget) findViewById(R.id.customer_home_topic_timer)).setOnTimerFinished(TopicWidget$bindProps$3$1.INSTANCE);
                } else {
                    ((TimerWidget) findViewById(R.id.customer_home_topic_timer)).setVisibility(8);
                }
                unit2 = Unit.INSTANCE;
            }
            if (unit2 == null) {
                ((TimerWidget) findViewById(R.id.customer_home_topic_timer)).setVisibility(8);
            }
            Object obj8 = hashMap.get(BlocksConst.WIDGET_PARAMS_TYPE_SUB_TITLE);
            if (obj8 != null) {
                ((RichTextView) findViewById(R.id.customer_home_topic_subtitle)).setVisibility(0);
                HashMap hashMap3 = obj8 instanceof HashMap ? (HashMap) obj8 : null;
                if (!(hashMap3 == null || (obj = hashMap3.get("content")) == null)) {
                    obj5 = obj.toString();
                }
                CharSequence charSequence = (CharSequence) obj5;
                if (charSequence == null || charSequence.length() == 0) {
                    z = true;
                }
                if (z) {
                    ((RichTextView) findViewById(R.id.customer_home_topic_subtitle)).setVisibility(8);
                } else {
                    ((RichTextView) findViewById(R.id.customer_home_topic_subtitle)).setText(charSequence);
                }
                obj5 = Unit.INSTANCE;
            }
            if (obj5 == null) {
                ((RichTextView) findViewById(R.id.customer_home_topic_subtitle)).setVisibility(8);
            }
            ViewGroup.LayoutParams layoutParams = ((LinearLayout) findViewById(R.id.customer_home_topic_title_layout)).getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                ViewGroup.LayoutParams layoutParams2 = ((RichTextView) findViewById(R.id.customer_home_topic_subtitle)).getLayoutParams();
                if (layoutParams2 != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    marginLayoutParams.rightMargin = CustomerExtentionKt.getPx(R.dimen.customer_210px);
                    marginLayoutParams2.rightMargin = CustomerExtentionKt.getPx(R.dimen.customer_210px);
                    ((LinearLayout) findViewById(R.id.customer_home_topic_title_layout)).setLayoutParams(marginLayoutParams);
                    ((RichTextView) findViewById(R.id.customer_home_topic_subtitle)).setLayoutParams(marginLayoutParams2);
                    this.f40606c.mo102451a(hashMap);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        setVisibility(8);
    }

    public final void addOnScrollListener() {
        ScrollWidget scrollWidget;
        Object obj;
        Collection<Buildable> values = getDynamicChildren().values();
        Intrinsics.checkNotNullExpressionValue(values, "dynamicChildren.values");
        Iterator it = values.iterator();
        while (true) {
            scrollWidget = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Buildable) obj) instanceof ScrollWidget) {
                break;
            }
        }
        if (obj instanceof ScrollWidget) {
            scrollWidget = (ScrollWidget) obj;
        }
        if (scrollWidget != null) {
            scrollWidget.setOnScrollListener(new TopicWidget$addOnScrollListener$1(this));
        }
    }

    public void bindChildren(List<? extends Buildable> list) {
        Intrinsics.checkNotNullParameter(list, "children");
        Iterable<Buildable> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Buildable view : iterable) {
            arrayList.add(view.getView());
        }
        for (View addView : (List) arrayList) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = CustomerExtentionKt.getPx(R.dimen.customer_20px);
            ((LinearLayout) findViewById(R.id.customer_home_topic_container)).addView(addView, layoutParams);
        }
        addOnScrollListener();
    }

    public void onBindFinish(HashMap<String, Object> hashMap) {
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public void onGlobalLayout() {
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
        m28851b();
    }

    /* renamed from: b */
    private final void m28851b() {
        List arrayList = new ArrayList();
        m28848a((ViewGroup) this, (List<ItemOperationListener>) arrayList);
        Iterable<ItemOperationListener> iterable = arrayList;
        int i = 0;
        int i2 = 0;
        for (ItemOperationListener itemOperationListener : iterable) {
            View view = (View) itemOperationListener;
            int measuredHeight = view.getMeasuredHeight();
            if (measuredHeight > i) {
                i = measuredHeight;
            }
            if (view instanceof TopicItemWidget) {
                i2 = ((TopicItemWidget) view).getImageHeight();
            }
        }
        for (ItemOperationListener itemOperationListener2 : iterable) {
            if (itemOperationListener2 instanceof TopicItemWidget) {
                View view2 = (View) itemOperationListener2;
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = i;
                    view2.setLayoutParams(layoutParams);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
            }
            if (itemOperationListener2 instanceof TopicMoreWidget) {
                View view3 = (View) itemOperationListener2;
                ViewGroup.LayoutParams layoutParams2 = view3.getLayoutParams();
                if (layoutParams2 != null) {
                    if (itemOperationListener2.getWidgetType() == 0) {
                        layoutParams2.height = i2;
                    } else if (itemOperationListener2.getWidgetType() == 1) {
                        layoutParams2.height = i;
                    }
                    view3.setLayoutParams(layoutParams2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
            }
        }
        arrayList.clear();
    }

    /* renamed from: a */
    private final void m28848a(ViewGroup viewGroup, List<ItemOperationListener> list) {
        int childCount = viewGroup.getChildCount();
        if (childCount > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                View childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof ItemOperationListener) && childAt.getVisibility() == 0) {
                    list.add(childAt);
                }
                if (childAt instanceof ViewGroup) {
                    m28848a((ViewGroup) childAt, list);
                }
                if (i2 < childCount) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }
}
