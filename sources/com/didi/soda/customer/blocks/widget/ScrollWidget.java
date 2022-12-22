package com.didi.soda.customer.blocks.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
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
import com.didi.soda.customer.blocks.card.suapp.IShadow;
import com.didi.soda.customer.blocks.card.suapp.SaShadowHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
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

@WidgetNameMeta(widgetName = "topic_scroll_v1")
@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020%H\u0016J0\u0010&\u001a\u00020#2&\u0010'\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020(\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020(\u0018\u0001`\u0016H\u0016J\b\u0010)\u001a\u00020#H\u0002J\u0006\u0010*\u001a\u00020#J\u0018\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\bH\u0002J\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\b\u00100\u001a\u000201H\u0016J0\u00102\u001a\u00020#2&\u0010'\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020(\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020(\u0018\u0001`\u0016H\u0016J0\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\bH\u0014J(\u00109\u001a\u00020#2\u0006\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\b2\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\bH\u0014J\u0012\u0010<\u001a\u00020\u000e2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J0\u0010?\u001a\u00020\u000e2&\u0010'\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020(\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020(\u0018\u0001`\u0016H\u0016J\u0010\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020\bH\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R4\u0010\u0013\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00020\u0014j\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u0002`\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006B"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/ScrollWidget;", "Landroid/widget/HorizontalScrollView;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "appearedViews", "", "Lcom/didi/soda/customer/blocks/ItemOperationListener;", "checkVisibleWhenLayout", "", "contentView", "Landroid/widget/LinearLayout;", "getContentView", "()Landroid/widget/LinearLayout;", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "listeners", "maxFindDeep", "needFindListener", "onScrollListener", "Lcom/didi/soda/customer/blocks/widget/OnScrollListener;", "getOnScrollListener", "()Lcom/didi/soda/customer/blocks/widget/OnScrollListener;", "setOnScrollListener", "(Lcom/didi/soda/customer/blocks/widget/OnScrollListener;)V", "bindChildren", "", "children", "", "bindProps", "props", "", "checkInVisible", "clearChildren", "findListener", "parent", "Landroid/view/ViewGroup;", "deep", "getItemOperationListener", "getView", "Landroid/view/View;", "onBindFinish", "onLayout", "changed", "l", "t", "r", "b", "onScrollChanged", "oldl", "oldt", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "shouldShow", "updateChildrenMargin", "margin", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ScrollWidget.kt */
public final class ScrollWidget extends HorizontalScrollView implements Buildable {

    /* renamed from: a */
    private final LinearLayout f40717a;

    /* renamed from: b */
    private boolean f40718b;

    /* renamed from: c */
    private int f40719c;

    /* renamed from: d */
    private final List<ItemOperationListener> f40720d;

    /* renamed from: e */
    private final List<ItemOperationListener> f40721e;

    /* renamed from: f */
    private OnScrollListener f40722f;

    /* renamed from: g */
    private boolean f40723g;

    /* renamed from: h */
    private final HashMap<String, Buildable> f40724h;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScrollWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScrollWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    public void bindProps(HashMap<String, Object> hashMap) {
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        return true;
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
    public /* synthetic */ ScrollWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f40717a = new LinearLayout(context);
        this.f40718b = true;
        this.f40719c = 2;
        this.f40720d = new ArrayList();
        this.f40721e = new ArrayList();
        this.f40723g = true;
        this.f40717a.setPadding(CustomerExtentionKt.getPx(R.dimen.customer_18px), 0, CustomerExtentionKt.getPx(R.dimen.customer_18px), 0);
        this.f40717a.setOrientation(0);
        addView(this.f40717a);
        this.f40724h = new LinkedHashMap();
    }

    public final LinearLayout getContentView() {
        return this.f40717a;
    }

    public final OnScrollListener getOnScrollListener() {
        return this.f40722f;
    }

    public final void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f40722f = onScrollListener;
    }

    public final List<ItemOperationListener> getItemOperationListener() {
        return this.f40720d;
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40724h;
    }

    public void bindChildren(List<? extends Buildable> list) {
        Intrinsics.checkNotNullParameter(list, "children");
        Iterable<Buildable> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Buildable view : iterable) {
            arrayList.add(view.getView());
        }
        for (View addView : (List) arrayList) {
            getContentView().addView(addView);
        }
    }

    public final void clearChildren() {
        this.f40717a.removeAllViews();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f40723g) {
            m28909a();
            this.f40723g = false;
        }
    }

    public void onBindFinish(HashMap<String, Object> hashMap) {
        String str;
        Object obj;
        int i;
        Object obj2;
        Buildable.DefaultImpls.onBindFinish(this, hashMap);
        String str2 = null;
        if (hashMap == null || (obj2 = hashMap.get(BlocksConst.WIDGET_PARAMS_ITEM_SPACE)) == null) {
            str = null;
        } else {
            str = obj2.toString();
        }
        if (str == null) {
            i = 0;
        } else {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                LogUtil.m29102e("ScrollWidget", Intrinsics.stringPlus("itemSpacing 入参不能转成Int str = ", str));
                e.printStackTrace();
                m28910a(0);
            }
        }
        m28910a(i);
        if (!(hashMap == null || (obj = hashMap.get("paddingHorizontal")) == null)) {
            str2 = obj.toString();
        }
        if (str2 != null) {
            try {
                int dip2px = DisplayUtils.dip2px(getContext(), (((float) Integer.parseInt(str2)) * 1.0f) / ((float) 2));
                this.f40717a.setPadding(dip2px, 0, dip2px, 0);
            } catch (NumberFormatException e2) {
                LogUtil.m29102e("ScrollWidget", Intrinsics.stringPlus("paddingHorizontal 入参不能转成Int str = ", str2));
                e2.printStackTrace();
            }
        }
        this.f40718b = true;
        this.f40723g = true;
        this.f40720d.clear();
        this.f40721e.clear();
        m28911a(this, 1);
    }

    public View getView() {
        return this;
    }

    /* renamed from: a */
    private final void m28910a(int i) {
        View view;
        boolean z;
        Iterator<View> it = ViewGroupKt.getChildren(this.f40717a).iterator();
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
                ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
                if (layoutParams != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (view3 instanceof IShadow) {
                        IShadow iShadow = (IShadow) view3;
                        marginLayoutParams.leftMargin = SaShadowHelper.fixItemMargin(DisplayUtils.dip2px(getContext(), (((float) i) * 1.0f) / ((float) 2)), iShadow.getShadowPaddingLeft(), iShadow.getShadowPaddingRight());
                    } else {
                        marginLayoutParams.leftMargin = DisplayUtils.dip2px(getContext(), (((float) i) * 1.0f) / ((float) 2));
                    }
                    ((Buildable) entry.getValue()).getView().setLayoutParams(marginLayoutParams);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
            }
        }
    }

    /* renamed from: a */
    private final void m28911a(ViewGroup viewGroup, int i) {
        for (View next : ViewGroupKt.getChildren(viewGroup)) {
            LogUtil.m29102e("TAG", Intrinsics.stringPlus("deep == ", Integer.valueOf(i)));
            if (next instanceof ItemOperationListener) {
                this.f40720d.add(next);
            }
            if ((next instanceof ViewGroup) && i <= this.f40719c) {
                m28911a((ViewGroup) next, i + 1);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent != null && motionEvent.getAction() == 0) && this.f40718b) {
            this.f40720d.clear();
            m28911a(this, 1);
            this.f40718b = false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        OnScrollListener onScrollListener = this.f40722f;
        if (onScrollListener != null) {
            onScrollListener.onScroll(getScrollX(), getScrollY());
        }
        return onTouchEvent;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        m28909a();
    }

    /* renamed from: a */
    private final void m28909a() {
        int[] iArr = {0, 0};
        getLocationOnScreen(iArr);
        int i = iArr[0];
        int width = getWidth() + i;
        for (ItemOperationListener itemOperationListener : this.f40720d) {
            View view = (View) itemOperationListener;
            int[] iArr2 = {0, 0};
            view.getLocationOnScreen(iArr2);
            int i2 = iArr2[0];
            if (view.getWidth() + i2 < i || i2 > width) {
                this.f40721e.remove(itemOperationListener);
            } else if (!this.f40721e.contains(itemOperationListener)) {
                itemOperationListener.onAppear();
                this.f40721e.add(itemOperationListener);
            }
        }
    }
}
