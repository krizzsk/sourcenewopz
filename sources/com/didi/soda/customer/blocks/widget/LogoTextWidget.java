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

@WidgetNameMeta(widgetName = "topic_logo_text_card")
@Metadata(mo175977d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019H\u0016J0\u0010\u001a\u001a\u00020\u00172&\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J0\u0010!\u001a\u00020\"2&\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u001eH\u0016R4\u0010\n\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00020\u000bj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u0002`\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/LogoTextWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dynamicChildren", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "getDynamicChildren", "()Ljava/util/LinkedHashMap;", "mContainer", "Landroid/widget/LinearLayout;", "mImageWidget", "Lcom/didi/soda/customer/blocks/widget/ImageWidget;", "mTitleWidget", "Lcom/didi/soda/customer/widget/text/RichTextView;", "bindChildren", "", "children", "", "bindProps", "props", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getView", "Landroid/view/View;", "shouldShow", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LogoTextWidget.kt */
public final class LogoTextWidget extends ConstraintLayout implements Buildable {

    /* renamed from: a */
    private ImageWidget f40711a;

    /* renamed from: b */
    private RichTextView f40712b;

    /* renamed from: c */
    private LinearLayout f40713c;

    /* renamed from: d */
    private final LinkedHashMap<String, Buildable> f40714d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LogoTextWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LogoTextWidget(Context context, AttributeSet attributeSet) {
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
    public LogoTextWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.customer_widget_left_img_right_text_layout, this);
        View findViewById = inflate.findViewById(R.id.customer_business_logo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_business_logo)");
        this.f40711a = (ImageWidget) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_business_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_business_title)");
        this.f40712b = (RichTextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_ll_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_ll_container)");
        this.f40713c = (LinearLayout) findViewById3;
        this.f40714d = new LinkedHashMap<>();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LogoTextWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public LinkedHashMap<String, Buildable> getDynamicChildren() {
        return this.f40714d;
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
            this.f40713c.addView(addView);
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
        String str;
        Object obj;
        if (hashMap != null) {
            Object obj2 = hashMap.get("image");
            boolean z = true;
            String str2 = null;
            if (obj2 == null) {
                unit = null;
            } else {
                boolean z2 = obj2 instanceof HashMap;
                HashMap hashMap2 = z2 ? (HashMap) obj2 : null;
                if (hashMap2 == null || (obj = hashMap2.get(BlocksConst.WIDGET_PARAMS_IMAGE_URL)) == null) {
                    str = null;
                } else {
                    str = obj.toString();
                }
                CharSequence charSequence = str;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    this.f40711a.setVisibility(0);
                    this.f40711a.setMStyle(110);
                    this.f40711a.setMImageRadius(ResourceHelper.getDimensionPixelSize(R.dimen.customer_4px));
                    this.f40711a.setMDrawableId(R.drawable.customer_skin_img_business_goods_item_x11);
                    this.f40711a.bindProps(z2 ? (HashMap) obj2 : null);
                } else {
                    this.f40711a.setVisibility(8);
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                this.f40711a.setVisibility(8);
            }
            Object obj3 = hashMap.get("title");
            if (obj3 != null) {
                str2 = obj3.toString();
            }
            CharSequence charSequence2 = str2;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                z = false;
            }
            if (!z) {
                this.f40712b.setVisibility(0);
                this.f40712b.setText(charSequence2);
                return;
            }
            this.f40712b.setVisibility(8);
        }
    }
}
