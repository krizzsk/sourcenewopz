package com.didi.soda.customer.blocks.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.blocks.ItemOperationListener;
import com.didi.soda.customer.blocks.card.TopicItemWidget;
import com.didi.soda.customer.blocks.card.suapp.IShadow;
import com.didi.soda.customer.blocks.card.suapp.SaShadowHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "topic_row_v1")
@Metadata(mo175977d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ0\u0010\u0010\u001a\u00020\u00112&\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\rH\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\u001e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J0\u0010\u001d\u001a\u00020\u00112&\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\rH\u0016J0\u0010\u001e\u001a\u00020\u001f2&\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\rH\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\bH\u0002R4\u0010\n\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00020\u000bj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u0002`\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/RowWidget;", "Landroid/widget/LinearLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "bindProps", "", "props", "", "doWrapIfNeed", "findRelayoutTarget", "parent", "Landroid/view/ViewGroup;", "targetList", "", "Lcom/didi/soda/customer/blocks/ItemOperationListener;", "getView", "Landroid/view/View;", "onBindFinish", "shouldShow", "", "updateChildrenMargin", "margin", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RowWidget.kt */
public final class RowWidget extends LinearLayout implements Buildable {

    /* renamed from: a */
    private final HashMap<String, Buildable> f40716a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RowWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RowWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    public void bindProps(HashMap<String, Object> hashMap) {
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
    public /* synthetic */ RowWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RowWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(0);
        this.f40716a = new LinkedHashMap();
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40716a;
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
                m28907a(0);
            }
        }
        m28907a(i);
        m28906a();
    }

    /* renamed from: a */
    private final void m28906a() {
        boolean z;
        List arrayList = new ArrayList();
        m28908a(this, arrayList);
        Iterable<ItemOperationListener> iterable = arrayList;
        Iterator it = iterable.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            ItemOperationListener itemOperationListener = (ItemOperationListener) it.next();
            if (itemOperationListener instanceof TopicItemWidget) {
                itemOperationListener.doWrapTextLine(false);
                itemOperationListener.doWrapButton(false);
            }
        }
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        boolean z2 = false;
        for (ItemOperationListener itemOperationListener2 : iterable) {
            if (!z) {
                z = itemOperationListener2.shouldWarpButton();
            }
            if (!z2) {
                z2 = itemOperationListener2.shouldWarpTextLine();
            }
        }
        for (ItemOperationListener itemOperationListener3 : iterable) {
            if (itemOperationListener3 instanceof TopicItemWidget) {
                if (z2) {
                    itemOperationListener3.doWrapTextLine(true);
                }
                if (z) {
                    itemOperationListener3.doWrapButton(true);
                }
            }
        }
    }

    /* renamed from: a */
    private final void m28908a(ViewGroup viewGroup, List<ItemOperationListener> list) {
        int childCount = viewGroup.getChildCount();
        if (childCount > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                View childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof ItemOperationListener) && childAt.getVisibility() == 0) {
                    list.add(childAt);
                }
                if (i2 < childCount) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private final void m28907a(int i) {
        View view;
        boolean z;
        Iterator<View> it = ViewGroupKt.getChildren(this).iterator();
        while (true) {
            if (!it.hasNext()) {
                view = null;
                break;
            }
            view = it.next();
            if (view.getVisibility() == 0) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        View view2 = view;
        for (Map.Entry entry : getDynamicChildren().entrySet()) {
            if (!Intrinsics.areEqual(entry.getValue(), (Object) view2)) {
                View view3 = ((Buildable) entry.getValue()).getView();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(((Buildable) entry.getValue()).getView().getLayoutParams());
                if (view3 instanceof IShadow) {
                    IShadow iShadow = (IShadow) view3;
                    layoutParams.leftMargin = SaShadowHelper.fixItemMargin(DisplayUtils.dip2px(getContext(), (((float) i) * 1.0f) / ((float) 2)), iShadow.getShadowPaddingLeft(), iShadow.getShadowPaddingRight());
                } else {
                    layoutParams.leftMargin = DisplayUtils.dip2px(getContext(), (((float) i) * 1.0f) / ((float) 2));
                }
                ((Buildable) entry.getValue()).getView().setLayoutParams(layoutParams);
            }
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
