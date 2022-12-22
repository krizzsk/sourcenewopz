package com.didi.soda.blocks.widget.scroller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.didi.soda.blocks.action.RealTimeExposure;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.style.BaseBinder;
import com.didi.soda.blocks.style.BlockLayout;
import com.didi.soda.blocks.style.StyleInterceptor;
import com.didi.soda.blocks.style.ValueManagerKt;
import com.didi.soda.blocks.utils.YogaNodeUtil;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaUnit;
import com.scwang.smart.refresh.horizontal.SmartRefreshHorizontal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

@StyleInterceptor(interceptList = {"padding", "paddingLeft", "paddingTop", "paddingRight", "paddingBottom", "paddingStart", "paddingEnd"})
@WidgetNameMeta(realTimeExposure = true, widgetName = "HorizontalScroller")
@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\rH\u0002J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\rH\u0002J\u0016\u0010!\u001a\u00020\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016J0\u0010%\u001a\u00020\u001c2&\u0010&\u001a\"\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0018\u00010'j\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0018\u0001`*H\u0016J0\u0010+\u001a\u00020\u001c2&\u0010,\u001a\"\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0018\u00010'j\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0018\u0001`*H\u0016J\b\u0010-\u001a\u00020\u001cH\u0002J\u0010\u0010.\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0017J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020\u001cH\u0016J0\u00102\u001a\u00020\u001c2&\u0010&\u001a\"\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0018\u00010'j\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0018\u0001`*H\u0016J(\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020\r2\u0006\u00107\u001a\u00020\rH\u0016J\u0018\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020\u001cH\u0002J\b\u0010?\u001a\u00020\u001cH\u0002J\u0010\u0010@\u001a\u00020\u001c2\u0006\u0010A\u001a\u000209H\u0002J(\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020\r2\u0006\u0010D\u001a\u00020\r2\u0006\u0010E\u001a\u00020\r2\u0006\u0010F\u001a\u00020\rH\u0002J\u0010\u0010G\u001a\u00020\u001c2\u0006\u0010H\u001a\u000209H\u0002J\u0012\u0010I\u001a\u00020\u001c2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J0\u0010L\u001a\u0002092&\u0010&\u001a\"\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0018\u00010'j\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0018\u0001`*H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u000e\u0010\u0015\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000¨\u0006M"}, mo175978d2 = {"Lcom/didi/soda/blocks/widget/scroller/HorizontalScroller;", "Lcom/didi/soda/blocks/style/BaseBinder;", "Lcom/scwang/smart/refresh/horizontal/SmartRefreshHorizontal;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appearedViews", "", "Lcom/didi/soda/blocks/action/RealTimeExposure;", "blockLayout", "Lcom/didi/soda/blocks/style/BlockLayout;", "listeners", "mLastX", "", "getMLastX", "()I", "setMLastX", "(I)V", "mLastY", "getMLastY", "setMLastY", "mScolledX", "refreshLayout", "scrollViewNode", "Lcom/facebook/yoga/YogaNode;", "scrollerView", "Lcom/didi/soda/blocks/widget/scroller/ListenedHorizontalScrollView;", "adjustMinMaxWidthAndHeight", "", "adjustWidthAndHeight", "anchorToLeft", "index", "anchorToMiddle", "bindChildren", "children", "", "Lcom/didi/soda/blocks/widget/Buildable;", "bindProps", "props", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "bindStyles", "styles", "checkInVisible", "createView", "generateOnTouchListener", "Landroid/view/View$OnTouchListener;", "initView", "onBindFinish", "onScrollChanged", "l", "t", "oldl", "oldt", "onScrollerViewTouch", "", "v", "Landroid/view/View;", "ev", "Landroid/view/MotionEvent;", "scrollToAnchorPosition", "scrollToLastPosition", "setBounces", "bounces", "setContentInset", "left", "top", "right", "bottom", "setShowScrollBar", "isShow", "setWidgetNode", "widgetNode", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "shouldShow", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: HorizontalScroller.kt */
public class HorizontalScroller extends BaseBinder<SmartRefreshHorizontal> {
    private final List<RealTimeExposure> appearedViews = new ArrayList();
    private BlockLayout blockLayout;
    private final List<RealTimeExposure> listeners = new ArrayList();
    private int mLastX;
    private int mLastY;
    private int mScolledX;
    private SmartRefreshHorizontal refreshLayout;
    private YogaNode scrollViewNode;
    private ListenedHorizontalScrollView scrollerView;

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalScroller(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    public int getMLastX() {
        return this.mLastX;
    }

    public void setMLastX(int i) {
        this.mLastX = i;
    }

    public int getMLastY() {
        return this.mLastY;
    }

    public void setMLastY(int i) {
        this.mLastY = i;
    }

    public SmartRefreshHorizontal createView(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        ListenedHorizontalScrollView listenedHorizontalScrollView = new ListenedHorizontalScrollView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        listenedHorizontalScrollView.setOnScrollListener(new HorizontalScroller$createView$1$1(this));
        this.scrollerView = listenedHorizontalScrollView;
        if (listenedHorizontalScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
        }
        listenedHorizontalScrollView.setScrollBarStyle(33554432);
        ListenedHorizontalScrollView listenedHorizontalScrollView2 = this.scrollerView;
        if (listenedHorizontalScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
        }
        listenedHorizontalScrollView2.setHorizontalScrollBarEnabled(true);
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
        blockLayout3.addOnLayoutChangeListener(new HorizontalScroller$createView$2(this));
        ListenedHorizontalScrollView listenedHorizontalScrollView3 = this.scrollerView;
        if (listenedHorizontalScrollView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
        }
        BlockLayout blockLayout4 = this.blockLayout;
        if (blockLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
        }
        listenedHorizontalScrollView3.addView(blockLayout4);
        ListenedHorizontalScrollView listenedHorizontalScrollView4 = this.scrollerView;
        if (listenedHorizontalScrollView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
        }
        listenedHorizontalScrollView4.setOnTouchListener(generateOnTouchListener());
        SmartRefreshHorizontal smartRefreshHorizontal = new SmartRefreshHorizontal(context);
        this.refreshLayout = smartRefreshHorizontal;
        if (smartRefreshHorizontal == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        smartRefreshHorizontal.setEnableRefresh(false);
        SmartRefreshHorizontal smartRefreshHorizontal2 = this.refreshLayout;
        if (smartRefreshHorizontal2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        smartRefreshHorizontal2.setEnableLoadMore(false);
        SmartRefreshHorizontal smartRefreshHorizontal3 = this.refreshLayout;
        if (smartRefreshHorizontal3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        smartRefreshHorizontal3.setEnableOverScrollDrag(true);
        SmartRefreshHorizontal smartRefreshHorizontal4 = this.refreshLayout;
        if (smartRefreshHorizontal4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        ListenedHorizontalScrollView listenedHorizontalScrollView5 = this.scrollerView;
        if (listenedHorizontalScrollView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
        }
        smartRefreshHorizontal4.setRefreshContent(listenedHorizontalScrollView5);
        SmartRefreshHorizontal smartRefreshHorizontal5 = this.refreshLayout;
        if (smartRefreshHorizontal5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        return smartRefreshHorizontal5;
    }

    public View.OnTouchListener generateOnTouchListener() {
        return new HorizontalScroller$sam$android_view_View_OnTouchListener$0(new HorizontalScroller$generateOnTouchListener$1(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0026, code lost:
        if (r8 != 3) goto L_0x00cf;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onScrollerViewTouch(android.view.View r7, android.view.MotionEvent r8) {
        /*
            r6 = this;
            java.lang.String r0 = "v"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            java.lang.String r0 = "ev"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            float r0 = r8.getRawX()
            int r0 = (int) r0
            float r1 = r8.getRawY()
            int r1 = (int) r1
            int r8 = r8.getAction()
            r2 = 1
            r3 = 0
            java.lang.String r4 = "v.parent"
            if (r8 == 0) goto L_0x00ae
            if (r8 == r2) goto L_0x008c
            r5 = 2
            if (r8 == r5) goto L_0x002a
            r0 = 3
            if (r8 == r0) goto L_0x008c
            goto L_0x00cf
        L_0x002a:
            int r8 = r6.getMLastX()
            int r8 = r0 - r8
            int r8 = java.lang.Math.abs(r8)
            int r8 = r8 + r3
            int r5 = r6.getMLastY()
            int r5 = r1 - r5
            int r5 = java.lang.Math.abs(r5)
            int r5 = r5 + r3
            if (r8 < r5) goto L_0x0064
            android.view.ViewParent r8 = r7.getParent()
            if (r8 == 0) goto L_0x0085
            android.view.ViewParent r8 = r7.getParent()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r4)
            android.view.ViewParent r8 = r8.getParent()
            if (r8 == 0) goto L_0x0085
            android.view.ViewParent r7 = r7.getParent()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r4)
            android.view.ViewParent r7 = r7.getParent()
            r7.requestDisallowInterceptTouchEvent(r2)
            goto L_0x0085
        L_0x0064:
            android.view.ViewParent r8 = r7.getParent()
            if (r8 == 0) goto L_0x0085
            android.view.ViewParent r8 = r7.getParent()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r4)
            android.view.ViewParent r8 = r8.getParent()
            if (r8 == 0) goto L_0x0085
            android.view.ViewParent r7 = r7.getParent()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r4)
            android.view.ViewParent r7 = r7.getParent()
            r7.requestDisallowInterceptTouchEvent(r3)
        L_0x0085:
            r6.setMLastX(r0)
            r6.setMLastY(r1)
            goto L_0x00cf
        L_0x008c:
            android.view.ViewParent r8 = r7.getParent()
            if (r8 == 0) goto L_0x00cf
            android.view.ViewParent r8 = r7.getParent()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r4)
            android.view.ViewParent r8 = r8.getParent()
            if (r8 == 0) goto L_0x00cf
            android.view.ViewParent r7 = r7.getParent()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r4)
            android.view.ViewParent r7 = r7.getParent()
            r7.requestDisallowInterceptTouchEvent(r3)
            goto L_0x00cf
        L_0x00ae:
            android.view.ViewParent r8 = r7.getParent()
            if (r8 == 0) goto L_0x00cf
            android.view.ViewParent r8 = r7.getParent()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r4)
            android.view.ViewParent r8 = r8.getParent()
            if (r8 == 0) goto L_0x00cf
            android.view.ViewParent r7 = r7.getParent()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r4)
            android.view.ViewParent r7 = r7.getParent()
            r7.requestDisallowInterceptTouchEvent(r2)
        L_0x00cf:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.blocks.widget.scroller.HorizontalScroller.onScrollerViewTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void initView() {
        YogaNode createYogaNode = YogaNodeUtil.createYogaNode();
        Intrinsics.checkExpressionValueIsNotNull(createYogaNode, "YogaNodeUtil.createYogaNode()");
        this.scrollViewNode = createYogaNode;
        if (createYogaNode == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollViewNode");
        }
        ListenedHorizontalScrollView listenedHorizontalScrollView = this.scrollerView;
        if (listenedHorizontalScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
        }
        createYogaNode.setData(listenedHorizontalScrollView);
        YogaNode yogaNode = this.scrollViewNode;
        if (yogaNode == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollViewNode");
        }
        BlockLayout blockLayout2 = this.blockLayout;
        if (blockLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
        }
        yogaNode.addChildAt(blockLayout2.getYogaNode(), 0);
        YogaNode yogaNode2 = this.scrollViewNode;
        if (yogaNode2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollViewNode");
        }
        yogaNode2.setFlexDirection(YogaFlexDirection.ROW);
        YogaNode yogaNode3 = this.scrollViewNode;
        if (yogaNode3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollViewNode");
        }
        yogaNode3.setOverflow(YogaOverflow.SCROLL);
        getYogaNode().setMeasureFunction((YogaMeasureFunction) null);
        getYogaNode().setFlexShrink(1.0f);
        YogaNode yogaNode4 = getYogaNode();
        YogaNode yogaNode5 = this.scrollViewNode;
        if (yogaNode5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollViewNode");
        }
        yogaNode4.addChildAt(yogaNode5, 0);
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
        this.listeners.clear();
        this.appearedViews.clear();
        for (Buildable buildable : list) {
            BlockLayout blockLayout2 = this.blockLayout;
            if (blockLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
            }
            if (buildable != null) {
                blockLayout2.addView((BaseBinder) buildable);
                this.listeners.add((RealTimeExposure) buildable);
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
        BlockLayout blockLayout3 = this.blockLayout;
        if (blockLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
        }
        YogaNode yogaNode = blockLayout3.getYogaNode();
        Intrinsics.checkExpressionValueIsNotNull(yogaNode, "blockLayout.yogaNode");
        yogaNode.setFlexDirection(YogaFlexDirection.ROW);
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
        ListenedHorizontalScrollView listenedHorizontalScrollView = this.scrollerView;
        if (listenedHorizontalScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
        }
        listenedHorizontalScrollView.setHorizontalScrollBarEnabled(z);
    }

    private final void setBounces(boolean z) {
        SmartRefreshHorizontal smartRefreshHorizontal = this.refreshLayout;
        if (smartRefreshHorizontal == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        smartRefreshHorizontal.setEnableOverScrollDrag(z);
    }

    private final void setContentInset(int i, int i2, int i3, int i4) {
        BlockLayout blockLayout2 = this.blockLayout;
        if (blockLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
        }
        blockLayout2.getYogaNode().setPadding(YogaEdge.LEFT, (float) i);
        BlockLayout blockLayout3 = this.blockLayout;
        if (blockLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
        }
        blockLayout3.getYogaNode().setPadding(YogaEdge.TOP, (float) i2);
        BlockLayout blockLayout4 = this.blockLayout;
        if (blockLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
        }
        blockLayout4.getYogaNode().setPadding(YogaEdge.RIGHT, (float) i3);
        BlockLayout blockLayout5 = this.blockLayout;
        if (blockLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
        }
        blockLayout5.getYogaNode().setPadding(YogaEdge.BOTTOM, (float) i4);
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        HashMap<String, Object> contextParams;
        checkInVisible();
        ListenedHorizontalScrollView listenedHorizontalScrollView = this.scrollerView;
        if (listenedHorizontalScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
        }
        this.mScolledX = listenedHorizontalScrollView.getScrollX();
        WidgetNodeModel virtualNode = getVirtualNode();
        if (virtualNode != null && (contextParams = virtualNode.getContextParams()) != null) {
            contextParams.put(Const.BlockParamConst.LAST_OFFSET, Integer.valueOf(this.mScolledX));
        }
    }

    /* access modifiers changed from: private */
    public final void checkInVisible() {
        int[] iArr = {0, 0};
        ListenedHorizontalScrollView listenedHorizontalScrollView = this.scrollerView;
        if (listenedHorizontalScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
        }
        listenedHorizontalScrollView.getLocationOnScreen(iArr);
        int i = iArr[0];
        ListenedHorizontalScrollView listenedHorizontalScrollView2 = this.scrollerView;
        if (listenedHorizontalScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
        }
        int width = listenedHorizontalScrollView2.getWidth() + i;
        for (RealTimeExposure realTimeExposure : this.listeners) {
            if (realTimeExposure != null) {
                View view = ((BaseBinder) realTimeExposure).getView();
                int[] iArr2 = {0, 0};
                view.getLocationOnScreen(iArr2);
                int i2 = iArr2[0];
                if (view.getWidth() + i2 < i || i2 > width) {
                    this.appearedViews.remove(realTimeExposure);
                } else if (!this.appearedViews.contains(realTimeExposure)) {
                    realTimeExposure.doRealTimeExpose();
                    this.appearedViews.add(realTimeExposure);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.didi.soda.blocks.style.BaseBinder<*>");
            }
        }
    }

    public void onBindFinish(HashMap<String, Object> hashMap) {
        super.onBindFinish(hashMap);
        ListenedHorizontalScrollView listenedHorizontalScrollView = this.scrollerView;
        if (listenedHorizontalScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
        }
        listenedHorizontalScrollView.post(new HorizontalScroller$onBindFinish$1(this));
    }

    /* access modifiers changed from: private */
    public final void scrollToLastPosition() {
        HashMap<String, Object> contextParams;
        Object obj;
        WidgetNodeModel virtualNode = getVirtualNode();
        if (virtualNode == null || (contextParams = virtualNode.getContextParams()) == null || (obj = contextParams.get(Const.BlockParamConst.LAST_OFFSET)) == null) {
            scrollToAnchorPosition();
        } else if (obj != null) {
            Integer num = (Integer) obj;
            ListenedHorizontalScrollView listenedHorizontalScrollView = this.scrollerView;
            if (listenedHorizontalScrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
            }
            listenedHorizontalScrollView.scrollTo(((Number) obj).intValue(), 0);
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    private final void scrollToAnchorPosition() {
        HashMap<String, Object> props;
        Object obj;
        HashMap<String, Object> props2;
        Object obj2;
        String obj3;
        WidgetNodeModel virtualNode = getVirtualNode();
        int i = 0;
        if (virtualNode == null || (props = virtualNode.getProps()) == null || (obj = props.get(Const.BlockParamConst.ANCHOR_CHILD_INDEX)) == null) {
            ListenedHorizontalScrollView listenedHorizontalScrollView = this.scrollerView;
            if (listenedHorizontalScrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
            }
            listenedHorizontalScrollView.scrollTo(0, 0);
            return;
        }
        WidgetNodeModel virtualNode2 = getVirtualNode();
        if (!(virtualNode2 == null || (props2 = virtualNode2.getProps()) == null || (obj2 = props2.get(Const.BlockParamConst.ANCHOR_POSITION)) == null || (obj3 = obj2.toString()) == null)) {
            i = Integer.parseInt(obj3);
        }
        if (i == 1) {
            anchorToMiddle(Integer.parseInt(obj.toString()));
        } else {
            anchorToLeft(Integer.parseInt(obj.toString()));
        }
    }

    private final void anchorToMiddle(int i) {
        BlockLayout blockLayout2 = this.blockLayout;
        if (blockLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
        }
        if (blockLayout2.getChildCount() > i) {
            ListenedHorizontalScrollView listenedHorizontalScrollView = this.scrollerView;
            if (listenedHorizontalScrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
            }
            int width = listenedHorizontalScrollView.getWidth();
            BlockLayout blockLayout3 = this.blockLayout;
            if (blockLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
            }
            View childAt = blockLayout3.getChildAt(i);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "anchorChild");
            int left = (childAt.getLeft() + (childAt.getWidth() / 2)) - (width / 2);
            ListenedHorizontalScrollView listenedHorizontalScrollView2 = this.scrollerView;
            if (listenedHorizontalScrollView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
            }
            listenedHorizontalScrollView2.scrollTo(left, 0);
        }
    }

    private final void anchorToLeft(int i) {
        BlockLayout blockLayout2 = this.blockLayout;
        if (blockLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
        }
        if (blockLayout2.getChildCount() > i) {
            BlockLayout blockLayout3 = this.blockLayout;
            if (blockLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
            }
            View childAt = blockLayout3.getChildAt(i);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "anchorChild");
            int left = childAt.getLeft();
            ListenedHorizontalScrollView listenedHorizontalScrollView = this.scrollerView;
            if (listenedHorizontalScrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
            }
            listenedHorizontalScrollView.scrollTo(left, 0);
        }
    }
}
