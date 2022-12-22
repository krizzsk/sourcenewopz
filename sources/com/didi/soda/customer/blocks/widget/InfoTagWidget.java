package com.didi.soda.customer.blocks.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "tag_multi_style_v1")
@Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J0\u0010\u000e\u001a\u00020\u000f2&\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u000bH\u0016J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J8\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\nH\u0002J0\u0010\u001d\u001a\u00020\u001e2&\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u000bH\u0016R4\u0010\b\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00020\tj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0002`\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/InfoTagWidget;", "Landroid/widget/LinearLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "bindProps", "", "props", "", "getGradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "colors", "getView", "Landroid/view/View;", "internalSetting", "type", "content", "iconUrl", "bgColor", "textColor", "shouldShow", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InfoTagWidget.kt */
public final class InfoTagWidget extends LinearLayout implements Buildable {

    /* renamed from: a */
    private final HashMap<String, Buildable> f40701a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InfoTagWidget(Context context) {
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
    public /* synthetic */ InfoTagWidget(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InfoTagWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.customer_widget_info_tag_layout, this);
        this.f40701a = new HashMap<>();
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40701a;
    }

    public View getView() {
        return this;
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            Object obj = hashMap.get("style");
            String str = null;
            String obj2 = obj == null ? null : obj.toString();
            if (obj2 == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            Object obj3 = hashMap.get("content");
            String obj4 = obj3 == null ? null : obj3.toString();
            Object obj5 = hashMap.get("icon_url");
            String obj6 = obj5 == null ? null : obj5.toString();
            Object obj7 = hashMap.get(BlocksConst.WIDGET_PARAMS_BG_COLOR);
            String obj8 = obj7 == null ? null : obj7.toString();
            Object obj9 = hashMap.get(BlocksConst.WIDGET_PARAMS_TEXT_COLOR);
            if (obj9 != null) {
                str = obj9.toString();
            }
            m28905a(obj2, obj4, obj6, obj8, str);
            return;
        }
        setVisibility(8);
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return false;
        }
        Object obj = hashMap.get("style");
        String str = null;
        String obj2 = obj == null ? null : obj.toString();
        int i = -1;
        if (obj2 != null) {
            try {
                i = Integer.parseInt(obj2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!(1 <= i && i <= 4)) {
            return false;
        }
        Object obj3 = hashMap.get("content");
        if (obj3 != null) {
            str = obj3.toString();
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private final void m28905a(String str, String str2, String str3, String str4, String str5) {
        GradientDrawable gradientDrawable;
        int color;
        String str6 = str;
        String str7 = str3;
        String str8 = str4;
        int i = 0;
        switch (str.hashCode()) {
            case 49:
                if (str6.equals("1")) {
                    ((ImageView) findViewById(R.id.customer_info_tag_img1)).setVisibility(8);
                    ((FrameLayout) findViewById(R.id.customer_info_tag_img_background)).setVisibility(8);
                    ((RichTextView) findViewById(R.id.customer_info_tag_text)).setText(str2);
                    ViewGroup.LayoutParams layoutParams = ((RichTextView) findViewById(R.id.customer_info_tag_text)).getLayoutParams();
                    if (layoutParams != null) {
                        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                        layoutParams2.setMarginStart(ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_16));
                        ((ConstraintLayout) findViewById(R.id.customer_info_tag_parent)).setBackgroundResource(R.drawable.customer_skin_info_tag_bg_style1);
                        ((RichTextView) findViewById(R.id.customer_info_tag_text)).setLayoutParams(layoutParams2);
                        ((RichTextView) findViewById(R.id.customer_info_tag_text)).setTextColor(ResourceHelper.getColor(R.color.rf_color_brands_1_100));
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                break;
            case 50:
                if (str6.equals("2")) {
                    ((ImageView) findViewById(R.id.customer_info_tag_img1)).setVisibility(8);
                    ((FrameLayout) findViewById(R.id.customer_info_tag_img_background)).setVisibility(0);
                    ((ConstraintLayout) findViewById(R.id.customer_info_tag_parent)).setBackgroundResource(R.drawable.customer_skin_info_tag_bg_style1);
                    ViewGroup.LayoutParams layoutParams3 = ((RichTextView) findViewById(R.id.customer_info_tag_text)).getLayoutParams();
                    if (layoutParams3 != null) {
                        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
                        if (str7 != null) {
                            FlyImageLoader.loadImage1x1(getContext(), str7).dontAnimate().centerCrop().into((ImageView) findViewById(R.id.customer_info_tag_img));
                            layoutParams4.setMarginStart(ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_8));
                        } else {
                            ((FrameLayout) findViewById(R.id.customer_info_tag_img_background)).setVisibility(8);
                            layoutParams4.setMarginStart(ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_16));
                        }
                        ((RichTextView) findViewById(R.id.customer_info_tag_text)).setLayoutParams(layoutParams4);
                        ((RichTextView) findViewById(R.id.customer_info_tag_text)).setText(str2);
                        ((RichTextView) findViewById(R.id.customer_info_tag_text)).setTextColor(ResourceHelper.getColor(R.color.rf_color_brands_1_100));
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                break;
            case 51:
                if (str6.equals("3")) {
                    ((ImageView) findViewById(R.id.customer_info_tag_img1)).setVisibility(8);
                    ((FrameLayout) findViewById(R.id.customer_info_tag_img_background)).setVisibility(8);
                    CharSequence charSequence = str2;
                    ((RichTextView) findViewById(R.id.customer_info_tag_text)).setText(charSequence);
                    ViewGroup.LayoutParams layoutParams5 = ((RichTextView) findViewById(R.id.customer_info_tag_text)).getLayoutParams();
                    if (layoutParams5 != null) {
                        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
                        layoutParams6.setMarginStart(ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_16));
                        ((RichTextView) findViewById(R.id.customer_info_tag_text)).setLayoutParams(layoutParams6);
                        ((ConstraintLayout) findViewById(R.id.customer_info_tag_parent)).setBackgroundResource(R.drawable.customer_home_info_tag_bg);
                        ((RichTextView) findViewById(R.id.customer_info_tag_text)).setText(charSequence);
                        ((RichTextView) findViewById(R.id.customer_info_tag_text)).setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_3_60_999999));
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                break;
            case 52:
                if (str6.equals("4")) {
                    ((FrameLayout) findViewById(R.id.customer_info_tag_img_background)).setVisibility(8);
                    if (str7 != null) {
                        ((ImageView) findViewById(R.id.customer_info_tag_img1)).setVisibility(0);
                        FlyImageLoader.loadImage1x1(getContext(), str7).dontAnimate().centerCrop().into((ImageView) findViewById(R.id.customer_info_tag_img1));
                    } else {
                        ((ImageView) findViewById(R.id.customer_info_tag_img1)).setVisibility(8);
                    }
                    ViewGroup.LayoutParams layoutParams7 = ((RichTextView) findViewById(R.id.customer_info_tag_text)).getLayoutParams();
                    if (layoutParams7 != null) {
                        ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) layoutParams7;
                        layoutParams8.setMarginStart(ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_16));
                        ((RichTextView) findViewById(R.id.customer_info_tag_text)).setLayoutParams(layoutParams8);
                        ((RichTextView) findViewById(R.id.customer_info_tag_text)).setText(str2);
                        Unit unit = null;
                        if (str8 == null) {
                            gradientDrawable = null;
                        } else {
                            gradientDrawable = m28904a(str8);
                        }
                        if (gradientDrawable != null) {
                            ((ConstraintLayout) findViewById(R.id.customer_info_tag_parent)).setBackground(gradientDrawable);
                        }
                        if (str5 != null) {
                            try {
                                color = Color.parseColor(str5);
                            } catch (Exception unused) {
                                color = ResourceHelper.getColor(R.color.rf_color_brands_1_100);
                            }
                            i = color;
                            unit = Unit.INSTANCE;
                        }
                        if (unit == null) {
                            InfoTagWidget infoTagWidget = this;
                            i = ResourceHelper.getColor(R.color.rf_color_brands_1_100);
                        }
                        ((RichTextView) findViewById(R.id.customer_info_tag_text)).setTextColor(i);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                break;
        }
        LogUtil.m29104i("InfoTagWidget", Intrinsics.stringPlus("不支持的类型 type = ", str6));
        setVisibility(8);
    }

    /* renamed from: a */
    private final GradientDrawable m28904a(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        try {
            ArrayList arrayList = (ArrayList) GsonUtil.fromJson(str, (Type) ArrayList.class);
            if (arrayList.size() <= 1) {
                return null;
            }
            int[] iArr = new int[arrayList.size()];
            Intrinsics.checkNotNullExpressionValue(arrayList, "colorSplits");
            int i = 0;
            for (Object next : arrayList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                iArr[i] = Color.parseColor((String) next);
                i = i2;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColors(iArr);
            gradientDrawable.setGradientType(0);
            gradientDrawable.setCornerRadius((float) ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_4));
            return gradientDrawable;
        } catch (Exception unused) {
            return null;
        }
    }
}
