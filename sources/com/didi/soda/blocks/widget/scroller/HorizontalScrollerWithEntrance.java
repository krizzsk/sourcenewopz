package com.didi.soda.blocks.widget.scroller;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.action.RealTimeExposure;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.style.BaseBinder;
import com.didi.soda.blocks.style.BlockLayout;
import com.didi.soda.blocks.style.StyleInterceptor;
import com.didi.soda.blocks.style.ValueManagerKt;
import com.didi.soda.blocks.utils.ColorUtils;
import com.didi.soda.blocks.utils.YogaNodeUtil;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.blocks.widget.image.BackgroundHelper;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

@StyleInterceptor(interceptList = {"padding", "paddingLeft", "paddingTop", "paddingRight", "paddingBottom", "paddingStart", "paddingEnd"})
@WidgetNameMeta(realTimeExposure = true, widgetName = "ChevronHorizontalScroller")
@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010N\u001a\u00020OJ\u0006\u0010P\u001a\u00020OJ\u0010\u0010Q\u001a\u00020O2\u0006\u0010R\u001a\u00020*H\u0002J\u0010\u0010S\u001a\u00020O2\u0006\u0010R\u001a\u00020*H\u0002J\u0016\u0010T\u001a\u00020O2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020W0VH\u0016J0\u0010X\u001a\u00020O2&\u0010Y\u001a\"\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020[\u0018\u00010Zj\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020[\u0018\u0001`\\H\u0016J0\u0010]\u001a\u00020O2&\u0010^\u001a\"\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020[\u0018\u00010Zj\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020[\u0018\u0001`\\H\u0016J\u0006\u0010_\u001a\u00020OJ\u0010\u0010`\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010a\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0017J\u0010\u0010b\u001a\u00020O2\u0006\u0010c\u001a\u00020\u0007H\u0016J\u0010\u0010d\u001a\u00020O2\u0006\u0010c\u001a\u00020\u0007H\u0016J\u0010\u0010e\u001a\u00020O2\u0006\u0010f\u001a\u00020\u001eH\u0016J\b\u0010g\u001a\u00020hH\u0016Jt\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020l2\b\u0010m\u001a\u0004\u0018\u00010\u00182\u0010\u0010n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010o\u0018\u00010V2F\u0010p\u001aB\u0012\u0013\u0012\u00110l¢\u0006\f\br\u0012\b\bs\u0012\u0004\b\b(k\u0012\u0013\u0012\u00110W¢\u0006\f\br\u0012\b\bs\u0012\u0004\b\b(t\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010o\u0018\u00010V\u0012\u0004\u0012\u00020O0qH\u0016J\b\u0010u\u001a\u00020OH\u0016J0\u0010v\u001a\u00020O2&\u0010Y\u001a\"\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020[\u0018\u00010Zj\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020[\u0018\u0001`\\H\u0016J(\u0010w\u001a\u00020O2\u0006\u0010x\u001a\u00020*2\u0006\u0010y\u001a\u00020*2\u0006\u0010z\u001a\u00020*2\u0006\u0010{\u001a\u00020*H\u0016J0\u0010|\u001a\u00020O2&\u0010Y\u001a\"\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020[\u0018\u00010Zj\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020[\u0018\u0001`\\H\u0016J(\u0010}\u001a\u00020O2\u0006\u0010x\u001a\u00020*2\u0006\u0010y\u001a\u00020*2\u0006\u0010z\u001a\u00020*2\u0006\u0010{\u001a\u00020*H\u0016J\u001b\u0010~\u001a\u00020j2\u0007\u0010\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u00020OH\u0002J\t\u0010\u0001\u001a\u00020OH\u0002J\u0014\u0010\u0001\u001a\u00020O2\t\u0010\u0001\u001a\u0004\u0018\u00010[H\u0016J\u0010\u0010\u0001\u001a\u00020O2\u0007\u0010\u0001\u001a\u00020jJ+\u0010\u0001\u001a\u00020O2\u0007\u0010\u0001\u001a\u00020*2\u0007\u0010\u0001\u001a\u00020*2\u0007\u0010\u0001\u001a\u00020*2\u0007\u0010\u0001\u001a\u00020*J\u0014\u0010\u0001\u001a\u00020O2\t\u0010\u0001\u001a\u0004\u0018\u00010[H\u0016J\u0014\u0010\u0001\u001a\u00020O2\t\u0010\u0001\u001a\u0004\u0018\u00010[H\u0016J\u0011\u0010\u0001\u001a\u00020O2\u0006\u0010c\u001a\u00020\u0007H\u0016J\u0011\u0010\u0001\u001a\u00020O2\u0006\u0010c\u001a\u00020\u0007H\u0016J\u0012\u0010\u0001\u001a\u00020O2\u0007\u0010\u0001\u001a\u00020\u0018H\u0016J\u0010\u0010\u0001\u001a\u00020O2\u0007\u0010\u0001\u001a\u00020jJ\u0015\u0010\u0001\u001a\u00020O2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J1\u0010\u0001\u001a\u00020j2&\u0010Y\u001a\"\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020[\u0018\u00010Zj\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020[\u0018\u0001`\\H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0010R\u001a\u00100\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010+\"\u0004\b2\u0010-R\u001a\u00103\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010+\"\u0004\b5\u0010-R\u001a\u00106\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010+\"\u0004\b8\u0010-R\u001a\u00109\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001a\"\u0004\b;\u0010\u001cR\u001a\u0010<\u001a\u00020=X.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020CX.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020IX.¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006\u0001"}, mo175978d2 = {"Lcom/didi/soda/blocks/widget/scroller/HorizontalScrollerWithEntrance;", "Lcom/didi/soda/blocks/style/BaseBinder;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appearThreshold", "", "getAppearThreshold", "()F", "setAppearThreshold", "(F)V", "appearedViews", "", "Lcom/didi/soda/blocks/action/RealTimeExposure;", "getAppearedViews", "()Ljava/util/List;", "blockLayout", "Lcom/didi/soda/blocks/style/BlockLayout;", "getBlockLayout", "()Lcom/didi/soda/blocks/style/BlockLayout;", "setBlockLayout", "(Lcom/didi/soda/blocks/style/BlockLayout;)V", "changeDistance", "", "getChangeDistance", "()Ljava/lang/String;", "setChangeDistance", "(Ljava/lang/String;)V", "entrance", "Landroid/view/ViewGroup;", "getEntrance", "()Landroid/view/ViewGroup;", "setEntrance", "(Landroid/view/ViewGroup;)V", "entranceBgHelper", "Lcom/didi/soda/blocks/widget/image/BackgroundHelper;", "getEntranceBgHelper", "()Lcom/didi/soda/blocks/widget/image/BackgroundHelper;", "setEntranceBgHelper", "(Lcom/didi/soda/blocks/widget/image/BackgroundHelper;)V", "isShowArrow", "", "()I", "setShowArrow", "(I)V", "listeners", "getListeners", "mLastX", "getMLastX", "setMLastX", "mLastY", "getMLastY", "setMLastY", "mScolledX", "getMScolledX", "setMScolledX", "onArrowClick", "getOnArrowClick", "setOnArrowClick", "refreshLayout", "Lcom/scwang/smart/refresh/horizontal/SmartRefreshHorizontal;", "getRefreshLayout", "()Lcom/scwang/smart/refresh/horizontal/SmartRefreshHorizontal;", "setRefreshLayout", "(Lcom/scwang/smart/refresh/horizontal/SmartRefreshHorizontal;)V", "scrollViewNode", "Lcom/facebook/yoga/YogaNode;", "getScrollViewNode", "()Lcom/facebook/yoga/YogaNode;", "setScrollViewNode", "(Lcom/facebook/yoga/YogaNode;)V", "scrollerView", "Lcom/didi/soda/blocks/widget/scroller/ListenedHorizontalScrollView;", "getScrollerView", "()Lcom/didi/soda/blocks/widget/scroller/ListenedHorizontalScrollView;", "setScrollerView", "(Lcom/didi/soda/blocks/widget/scroller/ListenedHorizontalScrollView;)V", "adjustMinMaxWidthAndHeight", "", "adjustWidthAndHeight", "anchorToLeft", "index", "anchorToMiddle", "bindChildren", "children", "", "Lcom/didi/soda/blocks/widget/Buildable;", "bindProps", "props", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "bindStyles", "styles", "checkInVisible", "createMRootView", "createView", "dealDistance", "float", "dealThreHold", "generateEntrance", "root", "generateOnTouchListener", "Landroid/view/View$OnTouchListener;", "handleOtherTrigger", "", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "callBackType", "actions", "Lcom/didi/soda/blocks/action/BaseAction;", "handler", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "widget", "initView", "mBindProps", "mOnScrollChanged", "l", "t", "oldl", "oldt", "onBindFinish", "onScrollChanged", "onScrollerViewTouch", "v", "Landroid/view/View;", "ev", "Landroid/view/MotionEvent;", "scrollToAnchorPosition", "scrollToLastPosition", "setArrowBgColor", "color", "setBounces", "bounces", "setContentInset", "left", "top", "right", "bottom", "setEntranceIconColor", "setEntranceIconFont", "varue", "setEntranceIconSize", "setEntranceWidth", "setIsShowArrow", "showArrow", "setShowScrollBar", "isShow", "setWidgetNode", "widgetNode", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "shouldShow", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: HorizontalScrollerWithEntrance.kt */
public class HorizontalScrollerWithEntrance extends BaseBinder<FrameLayout> {
    private float appearThreshold;
    private final List<RealTimeExposure> appearedViews = new ArrayList();
    public BlockLayout blockLayout;
    private String changeDistance = "";
    private ViewGroup entrance;
    private BackgroundHelper entranceBgHelper;
    private int isShowArrow;
    private final List<RealTimeExposure> listeners = new ArrayList();
    private int mLastX;
    private int mLastY;
    private int mScolledX;
    private String onArrowClick = Const.BlockParamConst.ON_ARROW_CLICK;
    public SmartRefreshHorizontal refreshLayout;
    public YogaNode scrollViewNode;
    public ListenedHorizontalScrollView scrollerView;

    public void dealDistance(float f) {
    }

    public void setEntranceIconColor(Object obj) {
    }

    public void setEntranceIconSize(float f) {
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalScrollerWithEntrance(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    public int isShowArrow() {
        return this.isShowArrow;
    }

    public void setShowArrow(int i) {
        this.isShowArrow = i;
    }

    public float getAppearThreshold() {
        return this.appearThreshold;
    }

    public void setAppearThreshold(float f) {
        this.appearThreshold = f;
    }

    public String getChangeDistance() {
        return this.changeDistance;
    }

    public void setChangeDistance(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.changeDistance = str;
    }

    public String getOnArrowClick() {
        return this.onArrowClick;
    }

    public void setOnArrowClick(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.onArrowClick = str;
    }

    public ViewGroup getEntrance() {
        return this.entrance;
    }

    public void setEntrance(ViewGroup viewGroup) {
        this.entrance = viewGroup;
    }

    public BackgroundHelper getEntranceBgHelper() {
        return this.entranceBgHelper;
    }

    public void setEntranceBgHelper(BackgroundHelper backgroundHelper) {
        this.entranceBgHelper = backgroundHelper;
    }

    public ListenedHorizontalScrollView getScrollerView() {
        ListenedHorizontalScrollView listenedHorizontalScrollView = this.scrollerView;
        if (listenedHorizontalScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollerView");
        }
        return listenedHorizontalScrollView;
    }

    public void setScrollerView(ListenedHorizontalScrollView listenedHorizontalScrollView) {
        Intrinsics.checkParameterIsNotNull(listenedHorizontalScrollView, "<set-?>");
        this.scrollerView = listenedHorizontalScrollView;
    }

    public BlockLayout getBlockLayout() {
        BlockLayout blockLayout2 = this.blockLayout;
        if (blockLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockLayout");
        }
        return blockLayout2;
    }

    public void setBlockLayout(BlockLayout blockLayout2) {
        Intrinsics.checkParameterIsNotNull(blockLayout2, "<set-?>");
        this.blockLayout = blockLayout2;
    }

    public SmartRefreshHorizontal getRefreshLayout() {
        SmartRefreshHorizontal smartRefreshHorizontal = this.refreshLayout;
        if (smartRefreshHorizontal == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        return smartRefreshHorizontal;
    }

    public void setRefreshLayout(SmartRefreshHorizontal smartRefreshHorizontal) {
        Intrinsics.checkParameterIsNotNull(smartRefreshHorizontal, "<set-?>");
        this.refreshLayout = smartRefreshHorizontal;
    }

    public YogaNode getScrollViewNode() {
        YogaNode yogaNode = this.scrollViewNode;
        if (yogaNode == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollViewNode");
        }
        return yogaNode;
    }

    public void setScrollViewNode(YogaNode yogaNode) {
        Intrinsics.checkParameterIsNotNull(yogaNode, "<set-?>");
        this.scrollViewNode = yogaNode;
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

    public List<RealTimeExposure> getListeners() {
        return this.listeners;
    }

    public List<RealTimeExposure> getAppearedViews() {
        return this.appearedViews;
    }

    public int getMScolledX() {
        return this.mScolledX;
    }

    public void setMScolledX(int i) {
        this.mScolledX = i;
    }

    public FrameLayout createView(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        ListenedHorizontalScrollView listenedHorizontalScrollView = new ListenedHorizontalScrollView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        listenedHorizontalScrollView.setOnScrollListener(new HorizontalScrollerWithEntrance$createView$1$1(this));
        setScrollerView(listenedHorizontalScrollView);
        getScrollerView().setScrollBarStyle(33554432);
        getScrollerView().setHorizontalScrollBarEnabled(true);
        setBlockLayout(new BlockLayout(getContext()));
        YogaNode yogaNode = getBlockLayout().getYogaNode();
        Intrinsics.checkExpressionValueIsNotNull(yogaNode, "blockLayout.yogaNode");
        yogaNode.setFlexDirection(YogaFlexDirection.ROW);
        getBlockLayout().addOnLayoutChangeListener(new HorizontalScrollerWithEntrance$createView$2(this));
        getScrollerView().addView(getBlockLayout());
        getScrollerView().setOnTouchListener(generateOnTouchListener());
        setRefreshLayout(new SmartRefreshHorizontal(context));
        getRefreshLayout().setEnableRefresh(false);
        getRefreshLayout().setEnableLoadMore(false);
        getRefreshLayout().setEnableOverScrollDrag(true);
        getRefreshLayout().setRefreshContent(getScrollerView());
        FrameLayout createMRootView = createMRootView(context);
        createMRootView.addView(getRefreshLayout());
        generateEntrance(createMRootView);
        return createMRootView;
    }

    public View.OnTouchListener generateOnTouchListener() {
        return new C13423xcb2cb761(new HorizontalScrollerWithEntrance$generateOnTouchListener$1(this));
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.blocks.widget.scroller.HorizontalScrollerWithEntrance.onScrollerViewTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void initView() {
        YogaNode createYogaNode = YogaNodeUtil.createYogaNode();
        Intrinsics.checkExpressionValueIsNotNull(createYogaNode, "YogaNodeUtil.createYogaNode()");
        setScrollViewNode(createYogaNode);
        getScrollViewNode().setData(getScrollerView());
        getScrollViewNode().addChildAt(getBlockLayout().getYogaNode(), 0);
        getScrollViewNode().setFlexDirection(YogaFlexDirection.ROW);
        getScrollViewNode().setOverflow(YogaOverflow.SCROLL);
        getYogaNode().setMeasureFunction((YogaMeasureFunction) null);
        getYogaNode().setFlexShrink(1.0f);
        getYogaNode().addChildAt(getScrollViewNode(), 0);
    }

    public void setWidgetNode(WidgetNodeModel widgetNodeModel) {
        super.setWidgetNode(widgetNodeModel);
        getBlockLayout().setBlockNode(widgetNodeModel);
    }

    public void bindChildren(List<? extends Buildable> list) {
        Intrinsics.checkParameterIsNotNull(list, "children");
        getListeners().clear();
        getAppearedViews().clear();
        for (Buildable buildable : list) {
            BlockLayout blockLayout2 = getBlockLayout();
            if (buildable != null) {
                blockLayout2.addView((BaseBinder) buildable);
                getListeners().add((RealTimeExposure) buildable);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.didi.soda.blocks.style.BaseBinder<*>");
            }
        }
    }

    public void bindStyles(HashMap<String, Object> hashMap) {
        super.bindStyles(hashMap);
        getBlockLayout().getYogaNode().copyStyle(getYogaNode());
        YogaNode yogaNode = getBlockLayout().getYogaNode();
        Intrinsics.checkExpressionValueIsNotNull(yogaNode, "blockLayout.yogaNode");
        yogaNode.setFlexDirection(YogaFlexDirection.ROW);
        adjustWidthAndHeight();
        adjustMinMaxWidthAndHeight();
    }

    public final void adjustWidthAndHeight() {
        if (getYogaNode().getWidth().unit == YogaUnit.AUTO) {
            getBlockLayout().getYogaNode().setWidthAuto();
        } else {
            getBlockLayout().getYogaNode().setWidthPercent(100.0f);
        }
        if (getYogaNode().getHeight().unit == YogaUnit.AUTO) {
            getBlockLayout().getYogaNode().setHeightAuto();
        } else {
            getBlockLayout().getYogaNode().setHeightPercent(100.0f);
        }
    }

    public final void adjustMinMaxWidthAndHeight() {
        getBlockLayout().getYogaNode().setMinWidth(FloatCompanionObject.INSTANCE.getNaN());
        getBlockLayout().getYogaNode().setMaxWidth(FloatCompanionObject.INSTANCE.getNaN());
        getBlockLayout().getYogaNode().setMinHeight(FloatCompanionObject.INSTANCE.getNaN());
        getBlockLayout().getYogaNode().setMaxHeight(FloatCompanionObject.INSTANCE.getNaN());
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
            mBindProps(hashMap);
            super.bindProps(hashMap);
        }
    }

    public final void setShowScrollBar(boolean z) {
        getScrollerView().setHorizontalScrollBarEnabled(z);
    }

    public final void setBounces(boolean z) {
        getRefreshLayout().setEnableOverScrollDrag(z);
    }

    public final void setContentInset(int i, int i2, int i3, int i4) {
        getBlockLayout().getYogaNode().setPadding(YogaEdge.LEFT, (float) i);
        getBlockLayout().getYogaNode().setPadding(YogaEdge.TOP, (float) i2);
        getBlockLayout().getYogaNode().setPadding(YogaEdge.RIGHT, (float) i3);
        getBlockLayout().getYogaNode().setPadding(YogaEdge.BOTTOM, (float) i4);
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        HashMap<String, Object> contextParams;
        checkInVisible();
        setMScolledX(getScrollerView().getScrollX());
        WidgetNodeModel virtualNode = getVirtualNode();
        if (!(virtualNode == null || (contextParams = virtualNode.getContextParams()) == null)) {
            contextParams.put(Const.BlockParamConst.LAST_OFFSET, Integer.valueOf(getMScolledX()));
        }
        mOnScrollChanged(i, i2, i3, i4);
    }

    public final void checkInVisible() {
        int[] iArr = {0, 0};
        getScrollerView().getLocationOnScreen(iArr);
        int i = iArr[0];
        int width = getScrollerView().getWidth() + i;
        for (RealTimeExposure realTimeExposure : getListeners()) {
            if (realTimeExposure != null) {
                View view = ((BaseBinder) realTimeExposure).getView();
                int[] iArr2 = {0, 0};
                view.getLocationOnScreen(iArr2);
                int i2 = iArr2[0];
                if (view.getWidth() + i2 < i || i2 > width) {
                    getAppearedViews().remove(realTimeExposure);
                } else if (!getAppearedViews().contains(realTimeExposure)) {
                    realTimeExposure.doRealTimeExpose();
                    getAppearedViews().add(realTimeExposure);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.didi.soda.blocks.style.BaseBinder<*>");
            }
        }
    }

    public void onBindFinish(HashMap<String, Object> hashMap) {
        super.onBindFinish(hashMap);
        getScrollerView().post(new HorizontalScrollerWithEntrance$onBindFinish$1(this));
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
            getScrollerView().scrollTo(((Number) obj).intValue(), 0);
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
            getScrollerView().scrollTo(0, 0);
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
        if (getBlockLayout().getChildCount() > i) {
            int width = getScrollerView().getWidth();
            View childAt = getBlockLayout().getChildAt(i);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "anchorChild");
            getScrollerView().scrollTo((childAt.getLeft() + (childAt.getWidth() / 2)) - (width / 2), 0);
        }
    }

    private final void anchorToLeft(int i) {
        if (getBlockLayout().getChildCount() > i) {
            View childAt = getBlockLayout().getChildAt(i);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "anchorChild");
            getScrollerView().scrollTo(childAt.getLeft(), 0);
        }
    }

    public void mOnScrollChanged(int i, int i2, int i3, int i4) {
        if (((float) getMScolledX()) <= getAppearThreshold() || isShowArrow() != 1) {
            Log.d(Const.BlockParamConst.APPEAR_THRESHOLD, "gone:" + getAppearThreshold());
            ViewGroup entrance2 = getEntrance();
            if (entrance2 != null) {
                entrance2.setVisibility(8);
                return;
            }
            return;
        }
        Log.d(Const.BlockParamConst.APPEAR_THRESHOLD, "vis:" + getAppearThreshold());
        ViewGroup entrance3 = getEntrance();
        if (entrance3 != null) {
            entrance3.setVisibility(0);
        }
    }

    public FrameLayout createMRootView(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new FrameLayout(context);
    }

    public void mBindProps(HashMap<String, Object> hashMap) {
        ViewGroup entrance2 = getEntrance();
        if (entrance2 != null) {
            setEntranceBgHelper(new BackgroundHelper(getContext(), entrance2));
        }
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                switch (str.hashCode()) {
                    case -1931084020:
                        if (str.equals(Const.BlockParamConst.SHOW_ARROW) && (value instanceof String)) {
                            setIsShowArrow((String) value);
                            break;
                        }
                    case -1908101546:
                        if (!str.equals(Const.BlockParamConst.APPEAR_THRESHOLD)) {
                            break;
                        } else {
                            dealThreHold(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case -1737300163:
                        if (!str.equals(Const.BlockParamConst.ARROW_WIDTH)) {
                            break;
                        } else {
                            setEntranceWidth(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case -1026295774:
                        if (!str.equals(Const.BlockParamConst.ARROW_ICON)) {
                            break;
                        } else {
                            setEntranceIconFont(value);
                            break;
                        }
                    case -924285044:
                        if (!str.equals(Const.BlockParamConst.ARROW_BACKGROUND_COLOR)) {
                            break;
                        } else {
                            setArrowBgColor(value);
                            break;
                        }
                    case -903976125:
                        if (!str.equals(Const.BlockParamConst.ARROW_ICON_SIZE)) {
                            break;
                        } else {
                            setEntranceIconSize(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case 2905029:
                        if (!str.equals(Const.BlockParamConst.CHANGE_DISTANCE)) {
                            break;
                        } else {
                            dealDistance(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case 2026900577:
                        if (!str.equals(Const.BlockParamConst.ARROW_ICON_COLOR)) {
                            break;
                        } else {
                            setEntranceIconColor(value);
                            break;
                        }
                }
            }
        }
    }

    public boolean handleOtherTrigger(IBlockScope iBlockScope, String str, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        ViewGroup entrance2;
        Intrinsics.checkParameterIsNotNull(iBlockScope, "scope");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        if (!Intrinsics.areEqual((Object) str, (Object) getOnArrowClick()) || (entrance2 = getEntrance()) == null) {
            return true;
        }
        entrance2.setOnClickListener(new HorizontalScrollerWithEntrance$handleOtherTrigger$1(this, function3, iBlockScope, list));
        return true;
    }

    public void generateEntrance(ViewGroup viewGroup) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "root");
        if (getEntrance() == null) {
            setEntrance(new FrameLayout(getContext()));
            ViewGroup entrance2 = getEntrance();
            if (entrance2 != null) {
                entrance2.setVisibility(8);
            }
            viewGroup.addView(getEntrance());
            ViewGroup entrance3 = getEntrance();
            ViewGroup.LayoutParams layoutParams = entrance3 != null ? entrance3.getLayoutParams() : null;
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(21);
            }
            viewGroup.addOnLayoutChangeListener(new HorizontalScrollerWithEntrance$generateEntrance$listener$1(this, viewGroup));
        }
    }

    public void setIsShowArrow(String str) {
        int i;
        Intrinsics.checkParameterIsNotNull(str, Const.BlockParamConst.SHOW_ARROW);
        try {
            i = Integer.parseInt(str);
        } catch (Exception unused) {
            i = 0;
        }
        setShowArrow(i);
    }

    public void setArrowBgColor(Object obj) {
        BackgroundHelper entranceBgHelper2;
        if (obj != null && (entranceBgHelper2 = getEntranceBgHelper()) != null) {
            entranceBgHelper2.setBackgroundColor(ColorUtils.convertColor(obj));
        }
    }

    public void setEntranceWidth(float f) {
        ViewGroup entrance2 = getEntrance();
        ViewGroup.LayoutParams layoutParams = entrance2 != null ? entrance2.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.width = (int) f;
        }
        if (layoutParams != null) {
            layoutParams.height = -1;
        }
    }

    public void setEntranceIconFont(Object obj) {
        boolean z = obj instanceof String;
    }

    public void dealThreHold(float f) {
        setAppearThreshold(f);
    }
}
