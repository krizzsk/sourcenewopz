package com.didi.soda.customer.blocks.card.suapp;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.ColorUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.text.IconRichTextView;
import com.taxis99.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "sa_topic_btn_action_v1")
@Metadata(mo175977d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J0\u0010\u0012\u001a\u00020\u00132&\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0017H\u0016J\u0016\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J0\u0010\u001f\u001a\u00020 2&\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0017H\u0016R4\u0010\b\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00020\tj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0002`\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/suapp/SaTopicItemActionWidget;", "Landroid/widget/LinearLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dynamicChildren", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "getDynamicChildren", "()Ljava/util/LinkedHashMap;", "iconButton", "Lcom/didi/soda/customer/widget/text/IconRichTextView;", "textButton", "Landroid/widget/TextView;", "bindProps", "", "props", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "createOvalDrawable", "Landroid/graphics/drawable/StateListDrawable;", "colors", "", "", "getView", "Landroid/view/View;", "shouldShow", "", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SaTopicItemActionWidget.kt */
public final class SaTopicItemActionWidget extends LinearLayout implements Buildable {
    public static final int BTN_TYPE_ICON = 2;
    public static final int BTN_TYPE_NONE = 0;
    public static final int BTN_TYPE_TEXT = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private TextView f40632a;

    /* renamed from: b */
    private IconRichTextView f40633b;

    /* renamed from: c */
    private final LinkedHashMap<String, Buildable> f40634c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SaTopicItemActionWidget(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
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
    public SaTopicItemActionWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.customer_widget_suapp_item_action_layout, this);
        View findViewById = inflate.findViewById(R.id.customer_su_topic_text_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_su_topic_text_button)");
        this.f40632a = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_su_topic_icon_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_su_topic_icon_button)");
        this.f40633b = (IconRichTextView) findViewById2;
        this.f40634c = new LinkedHashMap<>();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SaTopicItemActionWidget(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public LinkedHashMap<String, Buildable> getDynamicChildren() {
        return this.f40634c;
    }

    public View getView() {
        return this;
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        return hashMap != null && (hashMap.isEmpty() ^ true);
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        boolean z;
        boolean z2;
        String obj;
        String obj2;
        if (hashMap != null) {
            Object obj3 = hashMap.get("button_type");
            Object obj4 = hashMap.get(BlocksConst.WIDGET_PARAMS_ACTION_TITLE);
            String str = null;
            String obj5 = obj4 == null ? null : obj4.toString();
            Object obj6 = hashMap.get(BlocksConst.WIDGET_PARAMS_ACTION_ICON);
            String obj7 = obj6 == null ? null : obj6.toString();
            Object obj8 = hashMap.get(BlocksConst.WIDGET_PARAMS_ACTION_COLOR);
            if (obj8 != null) {
                str = obj8.toString();
            }
            boolean z3 = true;
            if (obj3 == null || (obj2 = obj3.toString()) == null || Integer.parseInt(obj2) != 1) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                CharSequence charSequence = obj5;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    this.f40632a.setVisibility(0);
                    this.f40632a.setText(charSequence);
                    this.f40633b.setVisibility(8);
                    return;
                }
            }
            if (obj3 == null || (obj = obj3.toString()) == null || Integer.parseInt(obj) != 2) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                this.f40632a.setVisibility(8);
                this.f40633b.setVisibility(0);
                CharSequence charSequence2 = obj7;
                if (!(charSequence2 == null || charSequence2.length() == 0)) {
                    this.f40633b.setText(charSequence2);
                }
                List<Integer> parseColors = ColorUtil.parseColors(str);
                Collection collection = parseColors;
                if (collection != null && !collection.isEmpty()) {
                    z3 = false;
                }
                if (!z3) {
                    Intrinsics.checkNotNullExpressionValue(parseColors, "colors");
                    this.f40633b.setBackground(m28877a(parseColors));
                    return;
                }
                return;
            }
            this.f40632a.setVisibility(8);
            this.f40633b.setVisibility(8);
        }
    }

    /* renamed from: a */
    private final StateListDrawable m28877a(List<Integer> list) {
        int[] intArray = CollectionsKt.toIntArray(list);
        float dimensionPixelSize = (float) ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_30);
        int dimensionPixelSize2 = ResourceHelper.getDimensionPixelSize(R.dimen.customer_60px);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, intArray);
        gradientDrawable.setShape(1);
        gradientDrawable.setSize(dimensionPixelSize2, dimensionPixelSize2);
        gradientDrawable.setCornerRadius(dimensionPixelSize);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(ColorUtil.getColorWithAlpha(0.08f, SkinUtil.getBrandPrimaryColor()));
        gradientDrawable2.setShape(1);
        gradientDrawable2.setSize(dimensionPixelSize2, dimensionPixelSize2);
        gradientDrawable2.setCornerRadius(dimensionPixelSize);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
        stateListDrawable.addState(new int[]{-16842919}, gradientDrawable);
        return stateListDrawable;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/suapp/SaTopicItemActionWidget$Companion;", "", "()V", "BTN_TYPE_ICON", "", "BTN_TYPE_NONE", "BTN_TYPE_TEXT", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SaTopicItemActionWidget.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
