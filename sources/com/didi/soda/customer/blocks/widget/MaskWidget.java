package com.didi.soda.customer.blocks.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "masking_status_v1")
@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J0\u0010\u000e\u001a\u00020\u000f2&\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J0\u0010\u0017\u001a\u00020\u00182&\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u000bH\u0016R4\u0010\b\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00020\tj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0002`\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/MaskWidget;", "Landroid/widget/RelativeLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "bindProps", "", "props", "", "getView", "Landroid/view/View;", "setStyle", "style", "", "shouldShow", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MaskWidget.kt */
public final class MaskWidget extends RelativeLayout implements Buildable {

    /* renamed from: a */
    private final HashMap<String, Buildable> f40715a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaskWidget(Context context) {
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MaskWidget(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MaskWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.customer_widget_mask_layout, this);
        this.f40715a = new HashMap<>();
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40715a;
    }

    public View getView() {
        return this;
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            setVisibility(0);
            Object obj = hashMap.get(BlocksConst.WIDGET_PARAMS_TIMEDESC);
            String str = null;
            CharSequence obj2 = obj == null ? null : obj.toString();
            boolean z = true;
            if (obj2 == null || obj2.length() == 0) {
                ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_tips)).setVisibility(8);
            } else {
                ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_tips)).setVisibility(0);
                ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_tips)).setText(obj2);
            }
            Object obj3 = hashMap.get("statusDesc");
            if (obj3 != null) {
                str = obj3.toString();
            }
            CharSequence charSequence = str;
            if (!(charSequence == null || charSequence.length() == 0)) {
                z = false;
            }
            if (z) {
                ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_status)).setVisibility(8);
                return;
            }
            ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_status)).setVisibility(0);
            ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_status)).setText(charSequence);
            return;
        }
        setVisibility(8);
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return false;
        }
        Object obj = hashMap.get(BlocksConst.WIDGET_PARAMS_TIMEDESC);
        String str = null;
        boolean z = !TextUtils.isEmpty(obj == null ? null : obj.toString());
        Object obj2 = hashMap.get("statusDesc");
        if (obj2 != null) {
            str = obj2.toString();
        }
        boolean z2 = !TextUtils.isEmpty(str);
        if (z || z2) {
            return true;
        }
        return false;
    }

    public final void setStyle(int i) {
        if (i == 2) {
            ViewGroup.LayoutParams layoutParams = ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_tips)).getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin = ResourceHelper.getDimensionPixelSize(R.dimen.customer_42px);
                marginLayoutParams.rightMargin = ResourceHelper.getDimensionPixelSize(R.dimen.customer_42px);
                ViewGroup.LayoutParams layoutParams2 = ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_tips)).getLayoutParams();
                if (layoutParams2 != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    marginLayoutParams2.leftMargin = ResourceHelper.getDimensionPixelSize(R.dimen.customer_42px);
                    marginLayoutParams2.rightMargin = ResourceHelper.getDimensionPixelSize(R.dimen.customer_42px);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        } else if (i == 3) {
            ViewGroup.LayoutParams layoutParams3 = ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_tips)).getLayoutParams();
            if (layoutParams3 != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams3.leftMargin = ResourceHelper.getDimensionPixelSize(R.dimen.customer_18px);
                marginLayoutParams3.rightMargin = ResourceHelper.getDimensionPixelSize(R.dimen.customer_18px);
                ViewGroup.LayoutParams layoutParams4 = ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_tips)).getLayoutParams();
                if (layoutParams4 != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                    marginLayoutParams4.leftMargin = ResourceHelper.getDimensionPixelSize(R.dimen.customer_18px);
                    marginLayoutParams4.rightMargin = ResourceHelper.getDimensionPixelSize(R.dimen.customer_18px);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        } else if (i == 21) {
            ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_status)).setMinWidth(ResourceHelper.getDimensionPixelSize(R.dimen.customer_164px));
            ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_status)).setMaxWidth(ResourceHelper.getDimensionPixelSize(R.dimen.customer_264px));
            ViewGroup.LayoutParams layoutParams5 = ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_tips)).getLayoutParams();
            if (layoutParams5 != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams5;
                marginLayoutParams5.leftMargin = ResourceHelper.getDimensionPixelSize(R.dimen.customer_64px);
                marginLayoutParams5.rightMargin = ResourceHelper.getDimensionPixelSize(R.dimen.customer_64px);
                ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_tips)).setLayoutParams(marginLayoutParams5);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        } else if (i == 43) {
            ViewGroup.LayoutParams layoutParams6 = ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_status)).getLayoutParams();
            layoutParams6.width = ResourceHelper.getDimensionPixelSize(R.dimen.customer_164px);
            ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_status)).setLayoutParams(layoutParams6);
            ViewGroup.LayoutParams layoutParams7 = ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_tips)).getLayoutParams();
            if (layoutParams7 != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) layoutParams7;
                marginLayoutParams6.leftMargin = ResourceHelper.getDimensionPixelSize(R.dimen.customer_43px);
                marginLayoutParams6.rightMargin = ResourceHelper.getDimensionPixelSize(R.dimen.customer_43px);
                ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_tips)).setLayoutParams(marginLayoutParams6);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        } else if (i == 10000) {
            ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_status)).setWidth(ResourceHelper.getDimensionPixelSize(R.dimen.customer_162px));
            ViewGroup.LayoutParams layoutParams8 = ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_tips)).getLayoutParams();
            layoutParams8.width = ResourceHelper.getDimensionPixelSize(R.dimen.customer_162px);
            ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_tips)).setLayoutParams(layoutParams8);
        }
    }
}
