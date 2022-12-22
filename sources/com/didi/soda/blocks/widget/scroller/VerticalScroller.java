package com.didi.soda.blocks.widget.scroller;

import android.content.Context;
import android.widget.ScrollView;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.style.BaseBinder;
import com.didi.soda.blocks.style.BlockLayout;
import com.didi.soda.blocks.style.StyleInterceptor;
import com.didi.soda.blocks.style.ValueManagerKt;
import com.didi.soda.blocks.utils.YogaNodeUtil;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaUnit;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

@StyleInterceptor(interceptList = {"padding", "paddingLeft", "paddingTop", "paddingRight", "paddingBottom", "paddingStart", "paddingEnd"})
@WidgetNameMeta(realTimeExposure = true, widgetName = "Scroller")
@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0016\u0010\u000e\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J0\u0010\u0012\u001a\u00020\f2&\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0017H\u0016J0\u0010\u0018\u001a\u00020\f2&\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J(\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!H\u0002J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u001eH\u0002J\u0012\u0010'\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J0\u0010*\u001a\u00020\u001e2&\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006+"}, mo175978d2 = {"Lcom/didi/soda/blocks/widget/scroller/VerticalScroller;", "Lcom/didi/soda/blocks/style/BaseBinder;", "Lcom/scwang/smart/refresh/layout/SmartRefreshLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "blockLayout", "Lcom/didi/soda/blocks/style/BlockLayout;", "refreshLayout", "scrollerView", "Landroid/widget/ScrollView;", "adjustMinMaxWidthAndHeight", "", "adjustWidthAndHeight", "bindChildren", "children", "", "Lcom/didi/soda/blocks/widget/Buildable;", "bindProps", "props", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "bindStyles", "styles", "createView", "initView", "setBounces", "bounces", "", "setContentInset", "left", "", "top", "right", "bottom", "setShowScrollBar", "isShow", "setWidgetNode", "widgetNode", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "shouldShow", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: VerticalScroller.kt */
public final class VerticalScroller extends BaseBinder<SmartRefreshLayout> {
    private BlockLayout blockLayout;
    private SmartRefreshLayout refreshLayout;
    private ScrollView scrollerView;

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerticalScroller(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    public SmartRefreshLayout createView(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        ScrollView scrollView = new ScrollView(context);
        this.scrollerView = scrollView;
        if (scrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
        }
        scrollView.setScrollBarStyle(33554432);
        ScrollView scrollView2 = this.scrollerView;
        if (scrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
        }
        scrollView2.setHorizontalScrollBarEnabled(true);
        BlockLayout blockLayout2 = new BlockLayout(getContext());
        this.blockLayout = blockLayout2;
        if (blockLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
        }
        YogaNode yogaNode = blockLayout2.getYogaNode();
        Intrinsics.checkExpressionValueIsNotNull(yogaNode, "blockLayout.yogaNode");
        yogaNode.setFlexDirection(YogaFlexDirection.ROW);
        BlockLayout blockLayout3 = this.blockLayout;
        if (blockLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
        }
        blockLayout3.addOnLayoutChangeListener(new VerticalScroller$createView$1(this));
        ScrollView scrollView3 = this.scrollerView;
        if (scrollView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
        }
        BlockLayout blockLayout4 = this.blockLayout;
        if (blockLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
        }
        scrollView3.addView(blockLayout4);
        SmartRefreshLayout smartRefreshLayout = new SmartRefreshLayout(context);
        this.refreshLayout = smartRefreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        smartRefreshLayout.setEnableRefresh(false);
        SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        smartRefreshLayout2.setEnableLoadMore(false);
        SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
        if (smartRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        smartRefreshLayout3.setEnableOverScrollDrag(true);
        SmartRefreshLayout smartRefreshLayout4 = this.refreshLayout;
        if (smartRefreshLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        ScrollView scrollView4 = this.scrollerView;
        if (scrollView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
        }
        smartRefreshLayout4.setRefreshContent(scrollView4);
        SmartRefreshLayout smartRefreshLayout5 = this.refreshLayout;
        if (smartRefreshLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        return smartRefreshLayout5;
    }

    public void initView() {
        YogaNode createYogaNode = YogaNodeUtil.createYogaNode();
        Intrinsics.checkExpressionValueIsNotNull(createYogaNode, "YogaNodeUtil.createYogaNode()");
        ScrollView scrollView = this.scrollerView;
        if (scrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
        }
        createYogaNode.setData(scrollView);
        BlockLayout blockLayout2 = this.blockLayout;
        if (blockLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
        }
        createYogaNode.addChildAt(blockLayout2.getYogaNode(), 0);
        createYogaNode.setOverflow(YogaOverflow.SCROLL);
        getYogaNode().setMeasureFunction((YogaMeasureFunction) null);
        getYogaNode().setFlexShrink(1.0f);
        getYogaNode().addChildAt(createYogaNode, 0);
    }

    public void setWidgetNode(WidgetNodeModel widgetNodeModel) {
        super.setWidgetNode(widgetNodeModel);
        BlockLayout blockLayout2 = this.blockLayout;
        if (blockLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
        }
        blockLayout2.setBlockNode(widgetNodeModel);
    }

    public void bindChildren(List<? extends Buildable> list) {
        Intrinsics.checkParameterIsNotNull(list, "children");
        for (Buildable buildable : list) {
            BlockLayout blockLayout2 = this.blockLayout;
            if (blockLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
            }
            if (buildable != null) {
                blockLayout2.addView((BaseBinder) buildable);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.didi.soda.blocks.style.BaseBinder<*>");
            }
        }
    }

    public void bindStyles(HashMap<String, Object> hashMap) {
        super.bindStyles(hashMap);
        BlockLayout blockLayout2 = this.blockLayout;
        if (blockLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
        }
        blockLayout2.getYogaNode().copyStyle(getYogaNode());
        adjustWidthAndHeight();
        adjustMinMaxWidthAndHeight();
    }

    /* access modifiers changed from: private */
    public final void adjustWidthAndHeight() {
        if (getYogaNode().getWidth().unit == YogaUnit.AUTO) {
            BlockLayout blockLayout2 = this.blockLayout;
            if (blockLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
            }
            blockLayout2.getYogaNode().setWidthAuto();
        } else {
            BlockLayout blockLayout3 = this.blockLayout;
            if (blockLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
            }
            blockLayout3.getYogaNode().setWidthPercent(100.0f);
        }
        if (getYogaNode().getHeight().unit == YogaUnit.AUTO) {
            BlockLayout blockLayout4 = this.blockLayout;
            if (blockLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
            }
            blockLayout4.getYogaNode().setHeightAuto();
            return;
        }
        BlockLayout blockLayout5 = this.blockLayout;
        if (blockLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
        }
        blockLayout5.getYogaNode().setHeightPercent(100.0f);
    }

    private final void adjustMinMaxWidthAndHeight() {
        BlockLayout blockLayout2 = this.blockLayout;
        if (blockLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
        }
        blockLayout2.getYogaNode().setMinWidth(FloatCompanionObject.INSTANCE.getNaN());
        BlockLayout blockLayout3 = this.blockLayout;
        if (blockLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
        }
        blockLayout3.getYogaNode().setMaxWidth(FloatCompanionObject.INSTANCE.getNaN());
        BlockLayout blockLayout4 = this.blockLayout;
        if (blockLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
        }
        blockLayout4.getYogaNode().setMinHeight(FloatCompanionObject.INSTANCE.getNaN());
        BlockLayout blockLayout5 = this.blockLayout;
        if (blockLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
        }
        blockLayout5.getYogaNode().setMaxHeight(FloatCompanionObject.INSTANCE.getNaN());
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                int hashCode = str.hashCode();
                if (hashCode != -223551607) {
                    if (hashCode != 70310635) {
                        if (hashCode == 811343908 && str.equals(Const.BlockParamConst.CONTENT_INSET)) {
                            List split$default = StringsKt.split$default((CharSequence) value.toString(), new String[]{" "}, false, 0, 6, (Object) null);
                            int[] iArr = new int[4];
                            int size = split$default.size();
                            for (int i = 0; i < size; i++) {
                                iArr[i] = MathKt.roundToInt(ValueManagerKt.convert2Num(split$default.get(i), str));
                            }
                            setContentInset(iArr[3], iArr[0], iArr[1], iArr[2]);
                        }
                    } else if (str.equals(Const.BlockParamConst.BOUNCES)) {
                        setBounces(Intrinsics.areEqual((Object) value.toString(), (Object) "1"));
                    }
                } else if (str.equals(Const.BlockParamConst.SHOW_SCROLL_BAR)) {
                    setShowScrollBar(Intrinsics.areEqual((Object) value.toString(), (Object) "1"));
                }
            }
            super.bindProps(hashMap);
        }
    }

    private final void setShowScrollBar(boolean z) {
        ScrollView scrollView = this.scrollerView;
        if (scrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
        }
        scrollView.setVerticalScrollBarEnabled(z);
    }

    private final void setBounces(boolean z) {
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        smartRefreshLayout.setEnableOverScrollDrag(z);
    }

    private final void setContentInset(int i, int i2, int i3, int i4) {
        ScrollView scrollView = this.scrollerView;
        if (scrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
        }
        scrollView.setPadding(i, i2, i3, i4);
    }
}
