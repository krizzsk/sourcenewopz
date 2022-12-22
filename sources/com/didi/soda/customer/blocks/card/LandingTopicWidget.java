package com.didi.soda.customer.blocks.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.blocks.ItemOperationListener;
import com.didi.soda.customer.blocks.widget.TopicMoreWidget;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "shop_items_card_v1")
@Metadata(mo175977d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0016\u0010\u0018\u001a\u00020\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\u0016J0\u0010\u001b\u001a\u00020\u00172&\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001d\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u000eH\u0016J\u001e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J\b\u0010$\u001a\u00020%H\u0016J0\u0010&\u001a\u00020\u00172&\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001d\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u000eH\u0016J\b\u0010'\u001a\u00020\u0017H\u0016J0\u0010(\u001a\u00020)2&\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001d\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u000eH\u0016R4\u0010\u000b\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00020\fj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u0002`\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006*"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/LandingTopicWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "<set-?>", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "mWidgetNode", "getMWidgetNode", "()Lcom/didi/soda/blocks/model/WidgetNodeModel;", "adjustChildrenHeight", "", "bindChildren", "children", "", "bindProps", "props", "", "findRelayoutTarget", "parent", "Landroid/view/ViewGroup;", "targetList", "", "Lcom/didi/soda/customer/blocks/ItemOperationListener;", "getView", "Landroid/view/View;", "onBindFinish", "onGlobalLayout", "shouldShow", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LandingTopicWidget.kt */
public final class LandingTopicWidget extends ConstraintLayout implements ViewTreeObserver.OnGlobalLayoutListener, Buildable {

    /* renamed from: a */
    private WidgetNodeModel f40573a;

    /* renamed from: b */
    private final HashMap<String, Buildable> f40574b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LandingTopicWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LandingTopicWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    public void bindProps(HashMap<String, Object> hashMap) {
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
    public /* synthetic */ LandingTopicWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LandingTopicWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.customer_widget_landing_topic_layout, this);
        this.f40574b = new HashMap<>();
    }

    public final WidgetNodeModel getMWidgetNode() {
        return this.f40573a;
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40574b;
    }

    public View getView() {
        return this;
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
            layoutParams.bottomMargin = CustomerExtentionKt.getPx(R.dimen.customer_24px);
            ((LinearLayout) findViewById(R.id.customer_landing_topic_container)).addView(addView, layoutParams);
        }
    }

    public void onBindFinish(HashMap<String, Object> hashMap) {
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public void onGlobalLayout() {
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
        m28812a();
    }

    /* renamed from: a */
    private final void m28812a() {
        List arrayList = new ArrayList();
        m28813a(this, arrayList);
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
    private final void m28813a(ViewGroup viewGroup, List<ItemOperationListener> list) {
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
                    m28813a((ViewGroup) childAt, list);
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
