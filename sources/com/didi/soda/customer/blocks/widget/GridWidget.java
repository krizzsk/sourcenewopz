package com.didi.soda.customer.blocks.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.nova.assembly.p127ui.flowlayout.NovaFlowLayout;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.util.CustomerTypeFaceSpan;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
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
import kotlin.math.MathKt;

@WidgetNameMeta(widgetName = "grid")
@Metadata(mo175977d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0016J0\u0010\u0017\u001a\u00020\u00142&\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\rH\u0016J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\bH\u0002J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010 \u001a\u00020\u001eH\u0016J0\u0010!\u001a\u00020\u00142&\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\rH\u0016J\u0018\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\bH\u0014J\u0006\u0010%\u001a\u00020\u0014J0\u0010&\u001a\u00020'2&\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\rH\u0016R4\u0010\n\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00020\u000bj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u0002`\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R.\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\rX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/GridWidget;", "Lcom/didi/nova/assembly/ui/flowlayout/NovaFlowLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "mDivider", "mProps", "", "bindChildren", "", "childrens", "", "bindProps", "props", "createDividerSpanString", "", "divider", "textSize", "getDividerView", "Landroid/view/View;", "type", "getView", "onBindFinish", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "recalculateDivider", "shouldShow", "", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GridWidget.kt */
public final class GridWidget extends NovaFlowLayout implements Buildable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DIVIDER_DOT = "dot";

    /* renamed from: a */
    private HashMap<String, Object> f40686a;

    /* renamed from: b */
    private String f40687b;

    /* renamed from: c */
    private final HashMap<String, Buildable> f40688c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GridWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GridWidget(Context context, AttributeSet attributeSet) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GridWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setChildSpacing((int) context.getResources().getDimension(R.dimen.customer_14px));
        setRowSpacing(context.getResources().getDimension(R.dimen.customer_14px));
        this.f40688c = new LinkedHashMap();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GridWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40688c;
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

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        recalculateDivider();
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        Object obj;
        int i;
        Object obj2;
        Object obj3;
        Object obj4;
        int i2;
        float f;
        this.f40686a = hashMap;
        String str = null;
        if (hashMap == null) {
            obj = null;
        } else {
            obj = hashMap.get(BlocksConst.WIDGET_PARAMS_MAXLINE);
        }
        String str2 = obj instanceof String ? (String) obj : null;
        if (!TextUtils.isEmpty(str2)) {
            Intrinsics.checkNotNull(str2);
            i = Integer.parseInt(str2);
        } else {
            i = 2;
        }
        setMaxRows(i);
        if (hashMap == null) {
            obj2 = null;
        } else {
            obj2 = hashMap.get(BlocksConst.WIDGET_PARAMS_DIVIDER);
        }
        this.f40687b = obj2 instanceof String ? (String) obj2 : null;
        if (hashMap == null) {
            obj3 = null;
        } else {
            obj3 = hashMap.get(BlocksConst.WIDGET_PARAMS_ITEM_SPACE);
        }
        String str3 = obj3 instanceof String ? (String) obj3 : null;
        if (hashMap == null) {
            obj4 = null;
        } else {
            obj4 = hashMap.get(BlocksConst.WIDGET_PARAMS_LINE_SPACE);
        }
        if (obj4 instanceof String) {
            str = (String) obj4;
        }
        if (str3 != null) {
            i2 = DisplayUtils.dip2px(getContext(), Float.parseFloat(str3) / ((float) 2));
        } else {
            i2 = MathKt.roundToInt(getContext().getResources().getDimension(R.dimen.customer_4px));
        }
        setChildSpacing(i2);
        if (str != null) {
            f = (float) DisplayUtils.dip2px(getContext(), Float.parseFloat(str) / ((float) 2));
        } else {
            f = getContext().getResources().getDimension(R.dimen.customer_14px);
        }
        setRowSpacing(f);
    }

    public void bindChildren(List<? extends Buildable> list) {
        View a;
        Intrinsics.checkNotNullParameter(list, "childrens");
        ViewGroup viewGroup = this;
        int childCount = viewGroup.getChildCount();
        int i = 0;
        boolean z = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(index)");
            if (!Intrinsics.areEqual(childAt.getTag(), (Object) "dot") && childAt.getVisibility() == 0) {
                z = true;
            }
        }
        Iterable<Buildable> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Buildable view : iterable) {
            arrayList.add(view.getView());
        }
        for (Object next : (List) arrayList) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view2 = (View) next;
            if ((z || i > 0) && (a = m28901a(this.f40687b)) != null) {
                a.setVisibility(view2.getVisibility());
                addView(a);
            }
            addView(view2);
            i = i3;
        }
    }

    public void onBindFinish(HashMap<String, Object> hashMap) {
        Buildable.DefaultImpls.onBindFinish(this, hashMap);
    }

    /* renamed from: a */
    private final View m28901a(String str) {
        if (!Intrinsics.areEqual((Object) "dot", (Object) str)) {
            return null;
        }
        CharSequence a = m28902a("·", 14);
        TextView textView = new TextView(getContext());
        textView.setTag("dot");
        textView.setText(a);
        return textView;
    }

    /* renamed from: a */
    private final CharSequence m28902a(String str, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(i, true), 0, spannableString.length(), 33);
        spannableString.setSpan(new CustomerTypeFaceSpan(((IToolsService) CustomerServiceManager.getService(IToolsService.class)).getFontTypeFace(IToolsService.FontType.BOLD)), 0, spannableString.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(ResourceHelper.getColor(R.color.rf_color_gery_4_80_CCCCCC)), 0, spannableString.length(), 33);
        spannableStringBuilder.append(spannableString);
        return spannableStringBuilder;
    }

    public final void recalculateDivider() {
        if (Intrinsics.areEqual((Object) "dot", (Object) this.f40687b)) {
            ViewGroup viewGroup = this;
            int childCount = viewGroup.getChildCount();
            int i = 0;
            boolean z = false;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(index)");
                if (childAt.getVisibility() == 0) {
                    i++;
                    if (!Intrinsics.areEqual(childAt.getTag(), (Object) "dot")) {
                        z = true;
                    }
                }
                if (i2 > 0 && i2 < getChildCount() - 1 && Intrinsics.areEqual(childAt.getTag(), (Object) "dot") && i <= getVisibleViewCount()) {
                    childAt.setVisibility(getViewByIndex(i2 + 1).getVisibility());
                    if ((!z && childAt.getVisibility() == 0) || i == getVisibleViewCount()) {
                        childAt.setVisibility(8);
                    }
                }
                if (i > getVisibleViewCount()) {
                    childAt.setVisibility(8);
                }
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/GridWidget$Companion;", "", "()V", "DIVIDER_DOT", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GridWidget.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
