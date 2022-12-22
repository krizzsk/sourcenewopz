package com.didi.soda.home.topgun.binder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.style.BlockLayout;
import com.didi.soda.blocks.utils.DPUtil;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.customer.blocks.binderpool.BinderRoot;
import com.didi.soda.customer.blocks.binderpool.RecyclerBinder;
import com.didi.soda.customer.blocks.binderpool.RecyclerViewHolder;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaNode;
import com.taxis99.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016J \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001e\u0010\u0015\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0017J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\u0011\u0010\u001e\u001a\u00020\u001f*\u00020 H\u0000¢\u0006\u0002\b!R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\""}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/DynamicRecyclerBinder;", "Lcom/didi/soda/customer/blocks/binderpool/RecyclerBinder;", "Lcom/didi/soda/blocks/model/ComponentModel;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "(Lcom/didi/soda/blocks/scope/IBlockScope;)V", "getScope", "()Lcom/didi/soda/blocks/scope/IBlockScope;", "setScope", "bind", "", "holder", "Lcom/didi/soda/customer/blocks/binderpool/RecyclerViewHolder;", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "createBinderRoot", "Lcom/didi/soda/customer/blocks/binderpool/BinderRoot;", "Lcom/didi/soda/blocks/widget/Buildable;", "type", "", "extraCanBindCondition", "", "getBinderRootType", "data", "convert2Num", "", "", "convert2Num$customer_aar_brazilEmbedRelease", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DynamicRecyclerBinder.kt */
public final class DynamicRecyclerBinder extends RecyclerBinder<ComponentModel> {

    /* renamed from: a */
    private IBlockScope f42750a;

    public Class<ComponentModel> bindDataType() {
        return ComponentModel.class;
    }

    public DynamicRecyclerBinder(IBlockScope iBlockScope) {
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        this.f42750a = iBlockScope;
    }

    public final IBlockScope getScope() {
        return this.f42750a;
    }

    public final void setScope(IBlockScope iBlockScope) {
        Intrinsics.checkNotNullParameter(iBlockScope, "<set-?>");
        this.f42750a = iBlockScope;
    }

    public RecyclerViewHolder<ComponentModel> create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        BlockLayout blockLayout = new BlockLayout(viewGroup.getContext());
        blockLayout.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
        return new RecyclerViewHolder<>(blockLayout);
    }

    public void bind(RecyclerViewHolder<ComponentModel> recyclerViewHolder, ComponentModel componentModel) {
        HashMap<String, Object> styles;
        float f;
        float f2;
        float f3;
        YogaNode yogaNode;
        HashMap<String, Object> contextParams;
        HashMap<String, Object> contextParams2;
        HashMap<String, Object> contextParams3;
        HashMap<String, Object> contextParams4;
        HashMap<String, Object> contextParams5;
        HashMap<String, Object> contextParams6;
        HashMap<String, Object> contextParams7;
        YogaNode yogaNode2;
        Intrinsics.checkNotNullParameter(recyclerViewHolder, "holder");
        Intrinsics.checkNotNullParameter(componentModel, "item");
        ViewGroup itemParentView = recyclerViewHolder.getItemParentView();
        BlockLayout blockLayout = itemParentView instanceof BlockLayout ? (BlockLayout) itemParentView : null;
        if (!(blockLayout == null || (yogaNode2 = blockLayout.getYogaNode()) == null)) {
            yogaNode2.setPadding(YogaEdge.ALL, Float.NaN);
            yogaNode2.setPadding(YogaEdge.LEFT, Float.NaN);
            yogaNode2.setPadding(YogaEdge.TOP, Float.NaN);
            yogaNode2.setPadding(YogaEdge.RIGHT, Float.NaN);
            yogaNode2.setPadding(YogaEdge.BOTTOM, Float.NaN);
        }
        WidgetNodeModel widgetNodeModel = componentModel.getWidgetNodeModel();
        if (!(widgetNodeModel == null || (styles = widgetNodeModel.getStyles()) == null)) {
            if (!styles.containsKey(Const.StyleConst.BOX_SHADOW)) {
                styles = null;
            }
            if (styles != null) {
                float dimensionPixelSize = (float) ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_10);
                WidgetNodeModel widgetNodeModel2 = componentModel.getWidgetNodeModel();
                boolean z = false;
                if (!(widgetNodeModel2 == null || (contextParams7 = widgetNodeModel2.getContextParams()) == null)) {
                    z = Intrinsics.areEqual(contextParams7.get("hasConvertMargin2Padding"), (Object) true);
                }
                float f4 = 0.0f;
                if (z) {
                    WidgetNodeModel widgetNodeModel3 = componentModel.getWidgetNodeModel();
                    Object obj = (widgetNodeModel3 == null || (contextParams6 = widgetNodeModel3.getContextParams()) == null) ? null : contextParams6.get("marginLeft");
                    Float f5 = obj instanceof Float ? (Float) obj : null;
                    f3 = f5 == null ? 0.0f : f5.floatValue();
                    WidgetNodeModel widgetNodeModel4 = componentModel.getWidgetNodeModel();
                    Object obj2 = (widgetNodeModel4 == null || (contextParams5 = widgetNodeModel4.getContextParams()) == null) ? null : contextParams5.get("marginRight");
                    Float f6 = obj2 instanceof Float ? (Float) obj2 : null;
                    f2 = f6 == null ? 0.0f : f6.floatValue();
                    WidgetNodeModel widgetNodeModel5 = componentModel.getWidgetNodeModel();
                    Object obj3 = (widgetNodeModel5 == null || (contextParams4 = widgetNodeModel5.getContextParams()) == null) ? null : contextParams4.get("marginTop");
                    Float f7 = obj3 instanceof Float ? (Float) obj3 : null;
                    f = f7 == null ? 0.0f : f7.floatValue();
                    WidgetNodeModel widgetNodeModel6 = componentModel.getWidgetNodeModel();
                    Object obj4 = (widgetNodeModel6 == null || (contextParams3 = widgetNodeModel6.getContextParams()) == null) ? null : contextParams3.get(Const.YogaConst.MARGIN_BOTTOM);
                    Float f8 = obj4 instanceof Float ? (Float) obj4 : null;
                    if (f8 != null) {
                        f4 = f8.floatValue();
                    }
                } else {
                    Object remove = styles.remove("marginLeft");
                    float convert2Num$customer_aar_brazilEmbedRelease = remove == null ? 0.0f : convert2Num$customer_aar_brazilEmbedRelease(remove);
                    Object remove2 = styles.remove("marginRight");
                    float convert2Num$customer_aar_brazilEmbedRelease2 = remove2 == null ? 0.0f : convert2Num$customer_aar_brazilEmbedRelease(remove2);
                    Object remove3 = styles.remove("marginTop");
                    float convert2Num$customer_aar_brazilEmbedRelease3 = remove3 == null ? 0.0f : convert2Num$customer_aar_brazilEmbedRelease(remove3);
                    Object remove4 = styles.remove(Const.YogaConst.MARGIN_BOTTOM);
                    if (remove4 != null) {
                        f4 = convert2Num$customer_aar_brazilEmbedRelease(remove4);
                    }
                    WidgetNodeModel widgetNodeModel7 = componentModel.getWidgetNodeModel();
                    if (!(widgetNodeModel7 == null || (contextParams2 = widgetNodeModel7.getContextParams()) == null)) {
                        contextParams2.put("marginLeft", Float.valueOf(convert2Num$customer_aar_brazilEmbedRelease));
                        contextParams2.put("marginRight", Float.valueOf(convert2Num$customer_aar_brazilEmbedRelease2));
                        contextParams2.put("marginTop", Float.valueOf(convert2Num$customer_aar_brazilEmbedRelease3));
                        contextParams2.put(Const.YogaConst.MARGIN_BOTTOM, Float.valueOf(f4));
                    }
                    WidgetNodeModel widgetNodeModel8 = componentModel.getWidgetNodeModel();
                    if (!(widgetNodeModel8 == null || (contextParams = widgetNodeModel8.getContextParams()) == null)) {
                        contextParams.put("hasConvertMargin2Padding", true);
                    }
                    f3 = convert2Num$customer_aar_brazilEmbedRelease;
                    f2 = convert2Num$customer_aar_brazilEmbedRelease2;
                    f = convert2Num$customer_aar_brazilEmbedRelease3;
                }
                ViewGroup itemParentView2 = recyclerViewHolder.getItemParentView();
                BlockLayout blockLayout2 = itemParentView2 instanceof BlockLayout ? (BlockLayout) itemParentView2 : null;
                if (!(blockLayout2 == null || (yogaNode = blockLayout2.getYogaNode()) == null)) {
                    yogaNode.setPadding(YogaEdge.LEFT, f3);
                    yogaNode.setPadding(YogaEdge.TOP, f + dimensionPixelSize);
                    yogaNode.setPadding(YogaEdge.RIGHT, f2);
                    yogaNode.setPadding(YogaEdge.BOTTOM, f4 + dimensionPixelSize);
                }
            }
        }
        super.bind(recyclerViewHolder, componentModel);
    }

    public final float convert2Num$customer_aar_brazilEmbedRelease(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        String obj2 = obj.toString();
        if (!StringsKt.endsWith$default(obj2, "px", false, 2, (Object) null)) {
            return DPUtil.INSTANCE.dp2pxF(BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getContext(), Float.parseFloat(obj2));
        }
        int length = obj2.length() - 2;
        if (obj2 != null) {
            String substring = obj2.substring(0, length);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return DPUtil.INSTANCE.dp2pxF(BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getContext(), Float.parseFloat(substring) / 2.0f);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public String getBinderRootType(ComponentModel componentModel) {
        Intrinsics.checkNotNullParameter(componentModel, "data");
        String templateId = componentModel.getTemplateId();
        Intrinsics.checkNotNull(templateId);
        return templateId;
    }

    public boolean extraCanBindCondition(ComponentModel componentModel) {
        WidgetNodeModel widgetNodeModel;
        String version;
        String str = "1";
        if (!(componentModel == null || (widgetNodeModel = componentModel.getWidgetNodeModel()) == null || (version = widgetNodeModel.getVersion()) == null)) {
            str = version;
        }
        return Integer.parseInt(str) > 1;
    }

    public BinderRoot<? extends Buildable, ComponentModel> createBinderRoot(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        return new DynamicBinderRoot(this.f42750a, str, getConfig());
    }
}
