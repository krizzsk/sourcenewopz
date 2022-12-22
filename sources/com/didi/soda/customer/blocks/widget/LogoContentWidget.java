package com.didi.soda.customer.blocks.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.text.IconRichTextView;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;
import java.util.ArrayList;
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

@WidgetNameMeta(widgetName = "shop_items_header_v1")
@Metadata(mo175977d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001fH\u0016J0\u0010 \u001a\u00020\u001d2&\u0010!\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020#\u0018\u00010\"j\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020#\u0018\u0001`$H\u0016J\b\u0010%\u001a\u00020&H\u0016J0\u0010'\u001a\u00020(2&\u0010!\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020#\u0018\u00010\"j\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020#\u0018\u0001`$H\u0016R4\u0010\n\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00020\u000bj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u0002`\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/LogoContentWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dynamicChildren", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "getDynamicChildren", "()Ljava/util/LinkedHashMap;", "mBizTimeWidget", "Lcom/didi/soda/customer/widget/text/RichTextView;", "mBusinessLayout", "Landroid/widget/LinearLayout;", "mContainer", "mIconWidget", "Lcom/didi/soda/customer/widget/text/IconRichTextView;", "mImageWidget", "Lcom/didi/soda/customer/blocks/widget/ImageWidget;", "mStatusWidget", "mTagContainer", "mTitleWidget", "bindChildren", "", "children", "", "bindProps", "props", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getView", "Landroid/view/View;", "shouldShow", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LogoContentWidget.kt */
public final class LogoContentWidget extends ConstraintLayout implements Buildable {

    /* renamed from: a */
    private ImageWidget f40702a;

    /* renamed from: b */
    private RichTextView f40703b;

    /* renamed from: c */
    private IconRichTextView f40704c;

    /* renamed from: d */
    private LinearLayout f40705d;

    /* renamed from: e */
    private LinearLayout f40706e;

    /* renamed from: f */
    private LinearLayout f40707f;

    /* renamed from: g */
    private RichTextView f40708g;

    /* renamed from: h */
    private RichTextView f40709h;

    /* renamed from: i */
    private final LinkedHashMap<String, Buildable> f40710i;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LogoContentWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LogoContentWidget(Context context, AttributeSet attributeSet) {
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
    public LogoContentWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.customer_widget_left_img_right_content_layout, this);
        View findViewById = inflate.findViewById(R.id.customer_business_logo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_business_logo)");
        this.f40702a = (ImageWidget) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_business_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_business_title)");
        this.f40703b = (RichTextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_iv_business_arrow);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_iv_business_arrow)");
        this.f40704c = (IconRichTextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.business_area);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.business_area)");
        this.f40705d = (LinearLayout) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.customer_ll_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.customer_ll_container)");
        this.f40706e = (LinearLayout) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.customer_ll_tag_parent);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.customer_ll_tag_parent)");
        this.f40707f = (LinearLayout) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.customer_info_tag_status_text);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.customer_info_tag_status_text)");
        this.f40708g = (RichTextView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.customer_info_tag_biztime_text);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.customer_info_tag_biztime_text)");
        this.f40709h = (RichTextView) findViewById8;
        this.f40710i = new LinkedHashMap<>();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LogoContentWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public LinkedHashMap<String, Buildable> getDynamicChildren() {
        return this.f40710i;
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
            this.f40706e.addView(addView);
        }
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        Object obj;
        String str = null;
        if (!(hashMap == null || (obj = hashMap.get("title")) == null)) {
            str = obj.toString();
        }
        return !TextUtils.isEmpty(str);
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        Unit unit;
        Unit unit2;
        String str;
        String str2;
        Object obj;
        Object obj2;
        if (hashMap != null) {
            Object obj3 = hashMap.get("logo_img");
            String str3 = null;
            if (obj3 == null) {
                unit = null;
            } else {
                this.f40702a.setMStyle(110);
                this.f40702a.setMImageRadius(ResourceHelper.getDimensionPixelSize(R.dimen.customer_8px));
                this.f40702a.setMDrawableId(R.drawable.customer_skin_img_business_goods_item_x11);
                boolean z = obj3 instanceof HashMap;
                this.f40702a.bindProps(z ? (HashMap) obj3 : null);
                ImageWidget imageWidget = this.f40702a;
                imageWidget.setVisibility(imageWidget.shouldShow(z ? (HashMap) obj3 : null) ? 0 : 8);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                this.f40702a.setVisibility(8);
            }
            Object obj4 = hashMap.get("title");
            boolean z2 = true;
            if (obj4 == null) {
                unit2 = null;
            } else {
                HashMap hashMap2 = obj4 instanceof HashMap ? (HashMap) obj4 : null;
                if (hashMap2 == null || (obj2 = hashMap2.get("content")) == null) {
                    str = null;
                } else {
                    str = obj2.toString();
                }
                CharSequence charSequence = str;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    this.f40703b.setVisibility(0);
                    this.f40703b.setText(charSequence);
                } else {
                    this.f40705d.setVisibility(8);
                }
                if (hashMap2 == null || (obj = hashMap2.get("icon")) == null) {
                    str2 = null;
                } else {
                    str2 = obj.toString();
                }
                CharSequence charSequence2 = str2;
                if (!(charSequence2 == null || charSequence2.length() == 0)) {
                    this.f40704c.setText(charSequence2);
                }
                unit2 = Unit.INSTANCE;
            }
            if (unit2 == null) {
                this.f40705d.setVisibility(8);
            }
            Object obj5 = hashMap.get("statusDesc");
            String obj6 = obj5 == null ? null : obj5.toString();
            Object obj7 = hashMap.get(BlocksConst.WIDGET_PARAMS_TIMEDESC);
            if (obj7 != null) {
                str3 = obj7.toString();
            }
            CharSequence charSequence3 = obj6;
            if (charSequence3 == null || charSequence3.length() == 0) {
                CharSequence charSequence4 = str3;
                if (charSequence4 == null || charSequence4.length() == 0) {
                    this.f40707f.setVisibility(8);
                    return;
                }
            }
            this.f40707f.setVisibility(0);
            if (!(charSequence3 == null || charSequence3.length() == 0)) {
                this.f40708g.setVisibility(0);
            } else {
                this.f40708g.setVisibility(8);
            }
            if (!(charSequence3 == null || charSequence3.length() == 0)) {
                z2 = false;
            }
            if (!z2) {
                this.f40709h.setVisibility(0);
            } else {
                this.f40709h.setVisibility(8);
            }
        }
    }
}
