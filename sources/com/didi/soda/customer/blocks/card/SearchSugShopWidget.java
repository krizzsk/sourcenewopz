package com.didi.soda.customer.blocks.card;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.blocks.widget.ImageWidget;
import com.didi.soda.customer.blocks.widget.TagWidget;
import com.didi.soda.customer.blocks.widget.TitleWidget;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "sug_shop_card_v1")
@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0001OB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010:\u001a\u00020;2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00020=H\u0016J0\u0010>\u001a\u00020;2&\u0010?\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020@\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020@\u0018\u0001`\rH\u0016J\b\u0010A\u001a\u00020\bH\u0014J\b\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020;H\u0002J&\u0010E\u001a\u00020;2\u0014\u0010F\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00020G2\u0006\u0010H\u001a\u00020IH\u0002J0\u0010J\u001a\u00020;2&\u0010?\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020@\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020@\u0018\u0001`\rH\u0016J\u0010\u0010K\u001a\u00020;2\u0006\u0010L\u001a\u00020MH\u0002J0\u0010N\u001a\u00020M2&\u0010?\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020@\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020@\u0018\u0001`\rH\u0016R4\u0010\n\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00020\u000bj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u0002`\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0001X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0015R\u001a\u0010+\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001bR\u001a\u0010.\u001a\u00020/X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u000205X.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006P"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/SearchSugShopWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "mBizTime", "Lcom/didi/soda/customer/widget/text/RichTextView;", "getMBizTime", "()Lcom/didi/soda/customer/widget/text/RichTextView;", "setMBizTime", "(Lcom/didi/soda/customer/widget/text/RichTextView;)V", "mContainer", "Landroid/widget/LinearLayout;", "getMContainer", "()Landroid/widget/LinearLayout;", "setMContainer", "(Landroid/widget/LinearLayout;)V", "mLineSpaceHeight", "mLogoWidget", "Lcom/didi/soda/customer/blocks/widget/ImageWidget;", "getMLogoWidget", "()Lcom/didi/soda/customer/blocks/widget/ImageWidget;", "setMLogoWidget", "(Lcom/didi/soda/customer/blocks/widget/ImageWidget;)V", "mRoot", "getMRoot", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMRoot", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "mShopStatu", "getMShopStatu", "setMShopStatu", "mStatuParent", "getMStatuParent", "setMStatuParent", "mTagWidget", "Lcom/didi/soda/customer/blocks/widget/TagWidget;", "getMTagWidget", "()Lcom/didi/soda/customer/blocks/widget/TagWidget;", "setMTagWidget", "(Lcom/didi/soda/customer/blocks/widget/TagWidget;)V", "mTitleWidget", "Lcom/didi/soda/customer/blocks/widget/TitleWidget;", "getMTitleWidget", "()Lcom/didi/soda/customer/blocks/widget/TitleWidget;", "setMTitleWidget", "(Lcom/didi/soda/customer/blocks/widget/TitleWidget;)V", "bindChildren", "", "children", "", "bindProps", "props", "", "getResId", "getView", "Landroid/view/View;", "initView", "layoutFromTop2Bottom", "childMap", "", "lineHeight", "", "onBindFinish", "setNameMargin", "isSingleLine", "", "shouldShow", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SearchSugShopWidget.kt */
public final class SearchSugShopWidget extends ConstraintLayout implements Buildable {
    public static final float COMMON_DIVIDER_HEIGHT = 5.5f;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final HashMap<String, Buildable> f40585a;

    /* renamed from: b */
    private int f40586b;
    public RichTextView mBizTime;
    public LinearLayout mContainer;
    public ImageWidget mLogoWidget;
    public ConstraintLayout mRoot;
    public RichTextView mShopStatu;
    public LinearLayout mStatuParent;
    public TagWidget mTagWidget;
    public TitleWidget mTitleWidget;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SearchSugShopWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SearchSugShopWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* access modifiers changed from: protected */
    public int getResId() {
        return R.layout.customer_item_feed_search_sug_shop_blocks;
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
    public SearchSugShopWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f40585a = new LinkedHashMap();
        m28823a();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchSugShopWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40585a;
    }

    public final ConstraintLayout getMRoot() {
        ConstraintLayout constraintLayout = this.mRoot;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
        return null;
    }

    public final void setMRoot(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.mRoot = constraintLayout;
    }

    public final LinearLayout getMContainer() {
        LinearLayout linearLayout = this.mContainer;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        return null;
    }

    public final void setMContainer(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.mContainer = linearLayout;
    }

    public final ImageWidget getMLogoWidget() {
        ImageWidget imageWidget = this.mLogoWidget;
        if (imageWidget != null) {
            return imageWidget;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mLogoWidget");
        return null;
    }

    public final void setMLogoWidget(ImageWidget imageWidget) {
        Intrinsics.checkNotNullParameter(imageWidget, "<set-?>");
        this.mLogoWidget = imageWidget;
    }

    public final TagWidget getMTagWidget() {
        TagWidget tagWidget = this.mTagWidget;
        if (tagWidget != null) {
            return tagWidget;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTagWidget");
        return null;
    }

    public final void setMTagWidget(TagWidget tagWidget) {
        Intrinsics.checkNotNullParameter(tagWidget, "<set-?>");
        this.mTagWidget = tagWidget;
    }

    public final TitleWidget getMTitleWidget() {
        TitleWidget titleWidget = this.mTitleWidget;
        if (titleWidget != null) {
            return titleWidget;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTitleWidget");
        return null;
    }

    public final void setMTitleWidget(TitleWidget titleWidget) {
        Intrinsics.checkNotNullParameter(titleWidget, "<set-?>");
        this.mTitleWidget = titleWidget;
    }

    public final LinearLayout getMStatuParent() {
        LinearLayout linearLayout = this.mStatuParent;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mStatuParent");
        return null;
    }

    public final void setMStatuParent(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.mStatuParent = linearLayout;
    }

    public final RichTextView getMShopStatu() {
        RichTextView richTextView = this.mShopStatu;
        if (richTextView != null) {
            return richTextView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mShopStatu");
        return null;
    }

    public final void setMShopStatu(RichTextView richTextView) {
        Intrinsics.checkNotNullParameter(richTextView, "<set-?>");
        this.mShopStatu = richTextView;
    }

    public final RichTextView getMBizTime() {
        RichTextView richTextView = this.mBizTime;
        if (richTextView != null) {
            return richTextView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBizTime");
        return null;
    }

    public final void setMBizTime(RichTextView richTextView) {
        Intrinsics.checkNotNullParameter(richTextView, "<set-?>");
        this.mBizTime = richTextView;
    }

    public View getView() {
        return this;
    }

    /* renamed from: a */
    private final void m28823a() {
        View inflate = LayoutInflater.from(getContext()).inflate(getResId(), this);
        View findViewById = inflate.findViewById(R.id.customer_cl_blocks_search_sug_shop_item);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.custom…cks_search_sug_shop_item)");
        setMRoot((ConstraintLayout) findViewById);
        View findViewById2 = inflate.findViewById(R.id.customer_custom_search_sug_shop_logo);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.custom…tom_search_sug_shop_logo)");
        setMLogoWidget((ImageWidget) findViewById2);
        View findViewById3 = inflate.findViewById(R.id.customer_custom_search_sug_shop_name);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.custom…tom_search_sug_shop_name)");
        setMTitleWidget((TitleWidget) findViewById3);
        getMTitleWidget().setLineSpacingExtra(ResourceHelper.getDimensionPixelSize(R.dimen.customer_4px));
        View findViewById4 = inflate.findViewById(R.id.customer_custom_search_sug_shop_tag);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.custom…stom_search_sug_shop_tag)");
        setMTagWidget((TagWidget) findViewById4);
        View findViewById5 = inflate.findViewById(R.id.customer_ll_search_sug_shop_message_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.custom…g_shop_message_container)");
        setMContainer((LinearLayout) findViewById5);
        View findViewById6 = inflate.findViewById(R.id.customer_ll_search_sug_shop_statu_parent);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.custom…ch_sug_shop_statu_parent)");
        setMStatuParent((LinearLayout) findViewById6);
        View findViewById7 = inflate.findViewById(R.id.customer_custom_sug_shop_statu);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.customer_custom_sug_shop_statu)");
        setMShopStatu((RichTextView) findViewById7);
        View findViewById8 = inflate.findViewById(R.id.customer_custom_sug_shop_statu_biztime_text);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.custom…_shop_statu_biztime_text)");
        setMBizTime((RichTextView) findViewById8);
        this.f40586b = DisplayUtils.dip2px(getContext(), 5.5f);
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        Map map = hashMap;
        return !(map == null || map.isEmpty());
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        Unit unit;
        Unit unit2;
        if (hashMap != null) {
            getMLogoWidget().setMStyle(11);
            getMLogoWidget().setMDrawableId(R.drawable.customer_img_search_shop_default_logo);
            getMLogoWidget().setMImageRadius(ResourceHelper.getDimensionPixelSize(R.dimen.customer_8px));
            ImageWidget mLogoWidget2 = getMLogoWidget();
            Object obj = hashMap.get("logo_img");
            String str = null;
            mLogoWidget2.bindProps(obj instanceof HashMap ? (HashMap) obj : null);
            Object obj2 = hashMap.get("title");
            if (obj2 == null) {
                unit = null;
            } else {
                getMTitleWidget().bindProps(obj2 instanceof HashMap ? (HashMap) obj2 : null);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                getMTitleWidget().setVisibility(8);
            }
            Object obj3 = hashMap.get(BlocksConst.WIDGET_PARAMS_TYPE_TAG);
            if (obj3 == null) {
                unit2 = null;
            } else {
                boolean z = obj3 instanceof HashMap;
                getMTagWidget().bindProps(z ? (HashMap) obj3 : null);
                getMTagWidget().setVisibility(getMTagWidget().shouldShow(z ? (HashMap) obj3 : null) ? 0 : 8);
                unit2 = Unit.INSTANCE;
            }
            if (unit2 == null) {
                getMTagWidget().setVisibility(8);
            }
            Object obj4 = hashMap.get("statusDesc");
            String obj5 = obj4 == null ? null : obj4.toString();
            Object obj6 = hashMap.get(BlocksConst.WIDGET_PARAMS_TIMEDESC);
            if (obj6 != null) {
                str = obj6.toString();
            }
            CharSequence charSequence = obj5;
            boolean z2 = true;
            if (!(charSequence == null || charSequence.length() == 0)) {
                getMStatuParent().setVisibility(0);
                getMContainer().setVisibility(8);
                if (!(charSequence == null || charSequence.length() == 0)) {
                    getMShopStatu().setText(charSequence);
                    getMShopStatu().setVisibility(0);
                } else {
                    getMShopStatu().setVisibility(8);
                }
                CharSequence charSequence2 = str;
                if (!(charSequence2 == null || charSequence2.length() == 0)) {
                    z2 = false;
                }
                if (!z2) {
                    getMBizTime().setText(charSequence2);
                    getMBizTime().setVisibility(0);
                } else {
                    getMBizTime().setVisibility(8);
                }
                if (getMTagWidget().getVisibility() == 0) {
                    getMTagWidget().setVisibility(8);
                    return;
                }
                return;
            }
            getMStatuParent().setVisibility(8);
            getMContainer().setVisibility(0);
        }
    }

    private final void setNameMargin(boolean z) {
        Resources resources;
        int i;
        if (z) {
            resources = getResources();
            i = R.dimen.customer_34px;
        } else {
            resources = getResources();
            i = R.dimen.customer_26px;
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(i);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(getMRoot());
        constraintSet.setMargin(getMTitleWidget().getId(), 3, dimensionPixelSize);
        constraintSet.applyTo(getMRoot());
    }

    public void bindChildren(List<? extends Buildable> list) {
        Intrinsics.checkNotNullParameter(list, "children");
        Iterable<Buildable> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Buildable view : iterable) {
            arrayList.add(view.getView());
        }
        for (View addView : (List) arrayList) {
            getMContainer().addView(addView);
        }
    }

    public void onBindFinish(HashMap<String, Object> hashMap) {
        Map linkedHashMap = new LinkedHashMap();
        Iterator it = getDynamicChildren().entrySet().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            if (((Buildable) entry.getValue()).getView().getVisibility() != 0) {
                z = false;
            }
            if (z) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (linkedHashMap.size() == 0) {
            getMContainer().setVisibility(8);
        }
        if (getMContainer().getVisibility() == 0) {
            m28824a(linkedHashMap, (float) this.f40586b);
        }
        if (getMStatuParent().getVisibility() == 8 && getMContainer().getVisibility() == 8) {
            setNameMargin(true);
        } else {
            setNameMargin(false);
        }
    }

    /* renamed from: a */
    private final void m28824a(Map<String, ? extends Buildable> map, float f) {
        int i = 0;
        for (Object next : MapsKt.toList(map)) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, (int) f, 0, 0);
            ((Buildable) ((Pair) next).getSecond()).getView().setLayoutParams(layoutParams);
            i = i2;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/SearchSugShopWidget$Companion;", "", "()V", "COMMON_DIVIDER_HEIGHT", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SearchSugShopWidget.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
