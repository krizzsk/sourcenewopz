package com.didi.map.global.flow.scene.order.confirm.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.LatLngUtils;
import com.didi.common.map.util.MapUtils;
import com.didi.map.global.component.collide.CollideStrategyFactory;
import com.didi.map.global.component.collide.ICollideStrategy;
import com.didi.map.global.component.collide.util.StrategyUtil;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.OnLineClickListener;
import com.didi.map.global.component.markers.IMarkersCompContract;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.OnMarkerCompClickListener;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.global.flow.scene.order.confirm.normal.ILineShowListener;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \\2\u00020\u0001:\u0001\\B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u0017H\u0002J\u0006\u00105\u001a\u000202J\b\u00106\u001a\u000202H\u0002J\b\u00107\u001a\u000202H\u0002J\b\u00108\u001a\u000202H\u0002J\"\u00109\u001a\u0004\u0018\u00010\u001a2\u0006\u0010:\u001a\u00020\b2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000bH\u0002J\u0012\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0017H\u0002J\u0006\u0010?\u001a\u00020\u001cJ,\u0010@\u001a\u0002022\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b2\b\u0010B\u001a\u0004\u0018\u00010\u00112\b\u0010C\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010D\u001a\u000202H\u0002J\u001e\u0010E\u001a\u0002022\u0014\u0010F\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u0011\u0018\u00010GH\u0002J\u0010\u0010I\u001a\u0002022\u0006\u0010:\u001a\u00020\bH\u0002J\u0010\u0010J\u001a\u0002022\u0006\u0010:\u001a\u00020\bH\u0002J\b\u0010K\u001a\u000202H\u0002J\u000e\u0010L\u001a\u0002022\u0006\u0010M\u001a\u00020\u001cJ\u0010\u0010N\u001a\u0002022\b\u0010O\u001a\u0004\u0018\u00010+J\u0010\u0010P\u001a\u0002022\b\u0010Q\u001a\u0004\u0018\u00010\"J\u001a\u0010R\u001a\u0002022\b\u0010S\u001a\u0004\u0018\u00010\u00112\u0006\u0010T\u001a\u00020UH\u0002J<\u0010V\u001a\u0002022\b\u0010W\u001a\u0004\u0018\u00010\u00112\u0006\u0010X\u001a\u00020\u00172\u0006\u0010Y\u001a\u00020\u001c2\b\u0010>\u001a\u0004\u0018\u00010\u00172\u0006\u0010Z\u001a\u00020\b2\u0006\u0010.\u001a\u00020/H\u0002J\u0006\u0010[\u001a\u000202R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\bXD¢\u0006\u0002\n\u0000¨\u0006]"}, mo175978d2 = {"Lcom/didi/map/global/flow/scene/order/confirm/component/MultiLineComponent;", "", "mContext", "Landroid/content/Context;", "mMap", "Lcom/didi/common/map/Map;", "(Landroid/content/Context;Lcom/didi/common/map/Map;)V", "FIRST_SELECT", "", "SECOND_SELECT", "bestViewElements", "", "Lcom/didi/common/map/internal/IMapElement;", "getBestViewElements", "()Ljava/util/List;", "bubble1Direction", "bubble1Latlng", "Lcom/didi/common/map/model/LatLng;", "bubble2Direction", "bubble2Latlng", "delayHandler", "Landroid/os/Handler;", "educBubbleId", "", "educBubbleZIndex", "firstLine", "Lcom/didi/map/global/component/line/component/ICompLineContract;", "isFirstCollide", "", "line1BubbleId", "line2BubbleId", "lineBubbleZIndexSelect", "lineBubbleZIndexUnSelect", "lineParam", "Lcom/didi/map/global/flow/scene/order/confirm/component/MultiLineParam;", "lineParam1", "Lcom/didi/map/global/flow/scene/order/confirm/component/LineParam;", "lineParam2", "mOnMapGestureListener", "Lcom/didi/common/map/listener/OnMapGestureListener;", "markersComp", "Lcom/didi/map/global/component/markers/IMarkersCompContract;", "onElementShowCallback", "Lcom/didi/map/global/flow/scene/order/confirm/component/OnElementShowCallback;", "secondLine", "selectLineIndex", "strategy", "Lcom/didi/map/global/component/collide/ICollideStrategy;", "unSelectLineIndex", "addLineClickListener", "", "changeBubbleZIndex", "selectBubbleId", "destroy", "destroyEducMarker", "destroyLine", "destroyLineBubble", "drawRouteLine", "type", "points", "getNewerEducView", "Landroid/view/View;", "content", "hasLine", "initBubbleDirection", "line", "line1", "line2", "initMarkerComp", "onCalculateResult", "result", "Ljava/util/HashMap;", "", "onClickInfoWindow", "onClickLine", "onEducMarkerHide", "setAllLineVisible", "visible", "setBubblePositionCallback", "callback", "setConfigParam", "param", "showEducBubble", "point", "bmp", "Landroid/graphics/Bitmap;", "showLineBubble", "latLng", "markerId", "isSelect", "direction", "start", "Companion", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MultiLineComponent.kt */
public final class MultiLineComponent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "MultiLineComponent";

    /* renamed from: A */
    private OnMapGestureListener f26590A;

    /* renamed from: a */
    private Context f26591a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Map f26592b;

    /* renamed from: c */
    private final int f26593c;

    /* renamed from: d */
    private final int f26594d = 1;

    /* renamed from: e */
    private final String f26595e = "educBubbleId";
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final String f26596f = "line1Bubble";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final String f26597g = "line2Bubble";
    /* access modifiers changed from: private */

    /* renamed from: h */
    public MultiLineParam f26598h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ICompLineContract f26599i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ICompLineContract f26600j;

    /* renamed from: k */
    private final int f26601k = 20;

    /* renamed from: l */
    private final int f26602l = 10;

    /* renamed from: m */
    private final int f26603m = 99;

    /* renamed from: n */
    private final int f26604n = 98;

    /* renamed from: o */
    private final int f26605o = 97;

    /* renamed from: p */
    private int f26606p = 32;

    /* renamed from: q */
    private int f26607q = 2;

    /* renamed from: r */
    private LineParam f26608r;

    /* renamed from: s */
    private LineParam f26609s;

    /* renamed from: t */
    private Handler f26610t;

    /* renamed from: u */
    private OnElementShowCallback f26611u;

    /* renamed from: v */
    private LatLng f26612v;

    /* renamed from: w */
    private LatLng f26613w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public IMarkersCompContract f26614x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f26615y = true;

    /* renamed from: z */
    private ICollideStrategy f26616z;

    public MultiLineComponent(Context context, Map map) {
        this.f26591a = context;
        this.f26592b = map;
        ICollideStrategy collideStrategyV2 = CollideStrategyFactory.getCollideStrategyV2(new MultiLineComponent$strategy$1(this));
        Intrinsics.checkNotNullExpressionValue(collideStrategyV2, "getCollideStrategyV2(object : IDMarkerContractV2 {\n        override fun getMap(): Map {\n            return mMap!!\n        }\n\n        override fun isCanWork(): Boolean {\n            return isFirstCollide\n        }\n\n        override fun getHot(id: String?): Int {\n            if (markersComp == null){\n                return 0\n            }\n            return markersComp?.getMarkerZindex(id)!!\n        }\n\n        override fun setLabelDirect(id: String, direct: Int) {\n            Log.e(\"ccc\", \"$id, setLabelDirect $direct\")\n            if (id === line1BubbleId) {\n                markersComp?.updateMarkerLabelDirect(id, direct)\n            }\n            if (id === line2BubbleId) {\n                markersComp?.updateMarkerLabelDirect(id, direct)\n            }\n        }\n\n        override fun getCurrentLabelPosition(id: String): Int {\n            if (TextUtils.isEmpty(id) || markersComp == null){\n                return LabelDirection.LABEL_DIRECTION_LEFT_TOP\n            }\n            return markersComp!!.getMarkerLabelDirect(id)\n        }\n\n        override fun getDisabledLines(): List<RouteInfo>? {\n            val lists: MutableList<RouteInfo> = ArrayList()\n            if (firstLine != null) {\n                lists.add(RouteInfo(firstLine!!.allLinePoints))\n            }\n            if (secondLine != null) {\n                lists.add(RouteInfo(secondLine!!.allLinePoints))\n            }\n            return lists\n        }\n\n        override fun getDisabledRect(): List<Rect>? {\n            val list: List<Marker>? = lineParam?.markersCollide\n            if (CollectionUtil.isEmpty(list)) {\n                return null\n            }\n            val rects: MutableList<Rect> = ArrayList()\n            for (element in list!!) {\n                if (element is Marker && element.isVisible) {\n                    rects.add(StrategyUtil.getMarkerRect(map, element as Marker?, null, false))\n                }\n            }\n            return rects\n        }\n\n        override fun isLabelDirectClockwise(): Boolean {\n            return true\n        }\n\n        override fun getEnableLabelPosition(id: String): Int {\n            return LabelDirection.LABEL_DIRECTION_LEFT_TOP or LabelDirection.LABEL_DIRECTION_RIGHT_TOP or\n                    LabelDirection.LABEL_DIRECTION_LEFT_BOTTOM or LabelDirection.LABEL_DIRECTION_RIGHT_BOTTOM\n        }\n    })");
        this.f26616z = collideStrategyV2;
        this.f26590A = new MultiLineComponent$mOnMapGestureListener$1(this);
    }

    public final void setConfigParam(MultiLineParam multiLineParam) {
        this.f26598h = multiLineParam;
    }

    public final void setBubblePositionCallback(OnElementShowCallback onElementShowCallback) {
        this.f26611u = onElementShowCallback;
    }

    public final void start() {
        Boolean bool;
        MultiLineParam multiLineParam;
        ILineShowListener onLineShowListener;
        Map map = this.f26592b;
        if (map != null) {
            map.addOnMapGestureListener(this.f26590A);
        }
        MultiLineParam multiLineParam2 = this.f26598h;
        List<LatLng> list = null;
        List<LineParam> lineParams = multiLineParam2 == null ? null : multiLineParam2.getLineParams();
        if (lineParams == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(!lineParams.isEmpty());
        }
        if (Intrinsics.areEqual((Object) bool, (Object) true)) {
            int size = lineParams.size();
            if (size == 1) {
                LineParam lineParam = lineParams.get(0);
                this.f26608r = lineParam;
                if (lineParam != null) {
                    list = lineParam.getPoints();
                }
                this.f26599i = m18828a(0, list);
                OnElementShowCallback onElementShowCallback = this.f26611u;
                if (onElementShowCallback != null) {
                    onElementShowCallback.onLineShowSuccess();
                }
            } else if (size == 2) {
                this.f26608r = lineParams.get(0);
                this.f26609s = lineParams.get(1);
                LineParam lineParam2 = this.f26608r;
                if (Intrinsics.areEqual((Object) lineParam2 == null ? null : Boolean.valueOf(lineParam2.isSelect()), (Object) true)) {
                    LineParam lineParam3 = this.f26609s;
                    this.f26600j = m18828a(1, lineParam3 == null ? null : lineParam3.getPoints());
                    LineParam lineParam4 = this.f26608r;
                    if (lineParam4 != null) {
                        list = lineParam4.getPoints();
                    }
                    this.f26599i = m18828a(0, list);
                } else {
                    LineParam lineParam5 = this.f26608r;
                    this.f26599i = m18828a(1, lineParam5 == null ? null : lineParam5.getPoints());
                    LineParam lineParam6 = this.f26609s;
                    if (lineParam6 != null) {
                        list = lineParam6.getPoints();
                    }
                    this.f26600j = m18828a(0, list);
                }
                if (!(this.f26608r == null || this.f26609s == null || (multiLineParam = this.f26598h) == null || (onLineShowListener = multiLineParam.getOnLineShowListener()) == null)) {
                    onLineShowListener.show(true, true);
                }
                OnElementShowCallback onElementShowCallback2 = this.f26611u;
                if (onElementShowCallback2 != null) {
                    onElementShowCallback2.onLineShowSuccess();
                }
                SystemUtils.log(6, "CollideStrategyV2", "异步计算锚点 开始", (Throwable) null, "com.didi.map.global.flow.scene.order.confirm.component.MultiLineComponent", 220);
                new CalculateTask(new MultiLineComponent$start$1(this), this.f26591a).execute(new List[]{lineParams});
            }
        }
    }

    public final void destroy() {
        ICompLineContract iCompLineContract = this.f26599i;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
        }
        this.f26599i = null;
        ICompLineContract iCompLineContract2 = this.f26600j;
        if (iCompLineContract2 != null) {
            iCompLineContract2.destroy();
        }
        this.f26600j = null;
        m18845e();
        m18844d();
        this.f26591a = null;
        Map map = this.f26592b;
        if (map != null) {
            map.removeOnMapGestureListener(this.f26590A);
        }
        this.f26590A = null;
        this.f26592b = null;
        this.f26611u = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m18836a(HashMap<Long, LatLng> hashMap) {
        Boolean bool;
        if (this.f26592b != null && this.f26591a != null) {
            if (hashMap == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(!hashMap.isEmpty());
            }
            if (Intrinsics.areEqual((Object) bool, (Object) true)) {
                java.util.Map map = hashMap;
                LineParam lineParam = this.f26608r;
                this.f26612v = (LatLng) map.get(lineParam == null ? null : Long.valueOf(lineParam.getLineId()));
                LineParam lineParam2 = this.f26609s;
                this.f26613w = (LatLng) map.get(lineParam2 == null ? null : Long.valueOf(lineParam2.getLineId()));
                if (LatLngUtils.locateCorrect(this.f26612v) && LatLngUtils.locateCorrect(this.f26613w)) {
                    LineParam lineParam3 = this.f26608r;
                    boolean areEqual = Intrinsics.areEqual((Object) lineParam3 == null ? null : Boolean.valueOf(lineParam3.isSelect()), (Object) true);
                    m18843c();
                    LineParam lineParam4 = this.f26608r;
                    m18837a(lineParam4 == null ? null : lineParam4.getPoints(), this.f26612v, this.f26613w);
                    MultiLineParam multiLineParam = this.f26598h;
                    if (Intrinsics.areEqual((Object) multiLineParam == null ? null : Boolean.valueOf(multiLineParam.isShowEducBubble()), (Object) true)) {
                        LatLng latLng = areEqual ? this.f26613w : this.f26612v;
                        MultiLineParam multiLineParam2 = this.f26598h;
                        Intrinsics.checkNotNull(multiLineParam2);
                        Bitmap viewBitmap = MapUtils.getViewBitmap(m18839b(multiLineParam2.getEducBubbleContent()));
                        Intrinsics.checkNotNullExpressionValue(viewBitmap, "getViewBitmap(getNewerEducView(lineParam!!.educBubbleContent))");
                        m18831a(latLng, viewBitmap);
                    } else {
                        LatLng latLng2 = this.f26612v;
                        String str = this.f26596f;
                        LineParam lineParam5 = this.f26608r;
                        m18832a(latLng2, str, areEqual, lineParam5 == null ? null : lineParam5.getLineBubbleContent(), this.f26607q, this.f26616z);
                        LatLng latLng3 = this.f26613w;
                        String str2 = this.f26597g;
                        boolean z = !areEqual;
                        LineParam lineParam6 = this.f26609s;
                        m18832a(latLng3, str2, z, lineParam6 == null ? null : lineParam6.getLineBubbleContent(), this.f26606p, this.f26616z);
                    }
                }
            }
            OnElementShowCallback onElementShowCallback = this.f26611u;
            if (onElementShowCallback != null) {
                onElementShowCallback.onBubbleShowSuccess();
            }
            m18829a();
        }
    }

    /* renamed from: a */
    private final void m18837a(List<LatLng> list, LatLng latLng, LatLng latLng2) {
        Double d;
        Double d2;
        Double d3;
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            Double d4 = null;
            Integer valueOf = list == null ? null : Integer.valueOf(list.size());
            Intrinsics.checkNotNull(valueOf);
            if (valueOf.intValue() > 1 && LatLngUtils.locateCorrect(latLng) && LatLngUtils.locateCorrect(latLng2)) {
                double computeHeading = DDSphericalUtil.computeHeading(list.get(0), list.get(list.size() - 1));
                if (Math.abs(computeHeading) > 0.0d && Math.abs(computeHeading) < 90.0d) {
                    if (latLng == null) {
                        d3 = null;
                    } else {
                        d3 = Double.valueOf(latLng.longitude);
                    }
                    Intrinsics.checkNotNull(d3);
                    double doubleValue = d3.doubleValue();
                    if (latLng2 != null) {
                        d4 = Double.valueOf(latLng2.longitude);
                    }
                    Intrinsics.checkNotNull(d4);
                    if (doubleValue < d4.doubleValue()) {
                        this.f26607q = 32;
                        this.f26606p = 2;
                        return;
                    }
                    this.f26607q = 2;
                    this.f26606p = 32;
                } else if (Math.abs(computeHeading) <= 90.0d || Math.abs(computeHeading) >= 180.0d) {
                    if (latLng == null) {
                        d = null;
                    } else {
                        d = Double.valueOf(latLng.longitude);
                    }
                    Intrinsics.checkNotNull(d);
                    double doubleValue2 = d.doubleValue();
                    if (latLng2 != null) {
                        d4 = Double.valueOf(latLng2.longitude);
                    }
                    Intrinsics.checkNotNull(d4);
                    if (doubleValue2 < d4.doubleValue()) {
                        this.f26607q = 32;
                        this.f26606p = 2;
                        return;
                    }
                    this.f26607q = 2;
                    this.f26606p = 32;
                } else {
                    if (latLng == null) {
                        d2 = null;
                    } else {
                        d2 = Double.valueOf(latLng.longitude);
                    }
                    Intrinsics.checkNotNull(d2);
                    double doubleValue3 = d2.doubleValue();
                    if (latLng2 != null) {
                        d4 = Double.valueOf(latLng2.longitude);
                    }
                    Intrinsics.checkNotNull(d4);
                    if (doubleValue3 < d4.doubleValue()) {
                        this.f26607q = 8;
                        this.f26606p = 128;
                        return;
                    }
                    this.f26607q = 128;
                    this.f26606p = 8;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0073  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.didi.map.global.component.line.component.ICompLineContract m18828a(int r6, java.util.List<com.didi.common.map.model.LatLng> r7) {
        /*
            r5 = this;
            r0 = r7
            java.util.Collection r0 = (java.util.Collection) r0
            r1 = 0
            if (r0 == 0) goto L_0x000f
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            r0 = 0
            goto L_0x0010
        L_0x000f:
            r0 = 1
        L_0x0010:
            r2 = 0
            if (r0 == 0) goto L_0x0014
            return r2
        L_0x0014:
            if (r6 != 0) goto L_0x001a
            java.lang.String r0 = "选中路线"
            goto L_0x001d
        L_0x001a:
            java.lang.String r0 = "非选中路线"
        L_0x001d:
            java.lang.String r3 = "绘制 line"
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r0)
            java.lang.Object[] r3 = new java.lang.Object[r1]
            java.lang.String r4 = "MultiLineComponent"
            com.didi.common.map.util.DLog.m7384d(r4, r0, r3)
            com.didi.common.map.Map r0 = r5.f26592b
            if (r0 == 0) goto L_0x00a9
            android.content.Context r0 = r5.f26591a
            if (r0 == 0) goto L_0x00a9
            com.didi.map.global.flow.scene.order.confirm.component.MultiLineParam r0 = r5.f26598h
            if (r0 != 0) goto L_0x0039
            goto L_0x00a9
        L_0x0039:
            if (r6 != 0) goto L_0x0043
            if (r0 != 0) goto L_0x003e
            goto L_0x0045
        L_0x003e:
            int r0 = r0.getSelectLineColor()
            goto L_0x004b
        L_0x0043:
            if (r0 != 0) goto L_0x0047
        L_0x0045:
            r0 = r2
            goto L_0x004f
        L_0x0047:
            int r0 = r0.getUnSelectLineColor()
        L_0x004b:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x004f:
            if (r6 != 0) goto L_0x0054
            r3 = 23
            goto L_0x0056
        L_0x0054:
            r3 = 29
        L_0x0056:
            com.didi.map.global.flow.scene.order.confirm.component.MultiLineParam r4 = r5.f26598h
            if (r6 != 0) goto L_0x0062
            if (r4 != 0) goto L_0x005d
            goto L_0x0064
        L_0x005d:
            int r4 = r4.getSelectLineWidth()
            goto L_0x006a
        L_0x0062:
            if (r4 != 0) goto L_0x0066
        L_0x0064:
            r4 = r2
            goto L_0x006e
        L_0x0066:
            int r4 = r4.getUnSelectLineWidth()
        L_0x006a:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x006e:
            if (r6 != 0) goto L_0x0073
            int r6 = r5.f26601k
            goto L_0x0075
        L_0x0073:
            int r6 = r5.f26602l
        L_0x0075:
            if (r0 == 0) goto L_0x00a9
            if (r4 != 0) goto L_0x007a
            goto L_0x00a9
        L_0x007a:
            com.didi.map.global.component.line.component.LineParams r2 = new com.didi.map.global.component.line.component.LineParams
            int r0 = r0.intValue()
            int r4 = r4.intValue()
            r2.<init>(r7, r0, r4)
            r2.setDidiColor(r3)
            r2.setZIndex(r6)
            com.didi.map.global.component.line.component.LineExParam r6 = new com.didi.map.global.component.line.component.LineExParam
            r6.<init>()
            r6.setHasPulseAnim(r1)
            r6.setHasLineExtensionAnim(r1)
            r2.setExParam(r6)
            com.didi.map.global.component.line.component.CompLineFactory$LineType r6 = com.didi.map.global.component.line.component.CompLineFactory.LineType.LINE_COMMON
            com.didi.common.map.Map r7 = r5.f26592b
            android.content.Context r0 = r5.f26591a
            com.didi.map.global.component.line.component.ICompLineContract r6 = com.didi.map.global.component.line.component.CompLineFactory.createLineComponent(r6, r7, r0, r2)
            r6.start()
            return r6
        L_0x00a9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.confirm.component.MultiLineComponent.m18828a(int, java.util.List):com.didi.map.global.component.line.component.ICompLineContract");
    }

    public final List<IMapElement> getBestViewElements() {
        List<IMapElement> arrayList = new ArrayList<>();
        ICompLineContract iCompLineContract = this.f26599i;
        if (iCompLineContract != null) {
            List<IMapElement> bestViewElements = iCompLineContract.getBestViewElements();
            Intrinsics.checkNotNullExpressionValue(bestViewElements, "it.bestViewElements");
            arrayList.addAll(bestViewElements);
        }
        ICompLineContract iCompLineContract2 = this.f26600j;
        if (iCompLineContract2 != null) {
            List<IMapElement> bestViewElements2 = iCompLineContract2.getBestViewElements();
            Intrinsics.checkNotNullExpressionValue(bestViewElements2, "it.bestViewElements");
            arrayList.addAll(bestViewElements2);
        }
        IMarkersCompContract iMarkersCompContract = this.f26614x;
        if (iMarkersCompContract != null) {
            List<Marker> markers = iMarkersCompContract.getMarkers();
            Intrinsics.checkNotNullExpressionValue(markers, "it.markers");
            arrayList.addAll(markers);
        }
        return arrayList;
    }

    public final void setAllLineVisible(boolean z) {
        ICompLineContract iCompLineContract = this.f26599i;
        if (iCompLineContract != null) {
            iCompLineContract.setLineVisible(z);
        }
        ICompLineContract iCompLineContract2 = this.f26600j;
        if (iCompLineContract2 != null) {
            iCompLineContract2.setLineVisible(z);
        }
        IMarkersCompContract iMarkersCompContract = this.f26614x;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.setAllMarkersVisible(z);
        }
    }

    /* renamed from: a */
    private final void m18829a() {
        ICompLineContract iCompLineContract = this.f26599i;
        if (iCompLineContract != null) {
            iCompLineContract.setLineClickListener(new OnLineClickListener() {
                public final void onLineClick(ICompLineContract iCompLineContract) {
                    MultiLineComponent.m18834a(MultiLineComponent.this, iCompLineContract);
                }
            });
        }
        ICompLineContract iCompLineContract2 = this.f26600j;
        if (iCompLineContract2 != null) {
            iCompLineContract2.setLineClickListener(new OnLineClickListener() {
                public final void onLineClick(ICompLineContract iCompLineContract) {
                    MultiLineComponent.m18842b(MultiLineComponent.this, iCompLineContract);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m18834a(MultiLineComponent multiLineComponent, ICompLineContract iCompLineContract) {
        Intrinsics.checkNotNullParameter(multiLineComponent, "this$0");
        multiLineComponent.m18830a(multiLineComponent.f26593c);
        multiLineComponent.m18841b(multiLineComponent.f26593c);
        multiLineComponent.m18835a(multiLineComponent.f26596f);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m18842b(MultiLineComponent multiLineComponent, ICompLineContract iCompLineContract) {
        Intrinsics.checkNotNullParameter(multiLineComponent, "this$0");
        multiLineComponent.m18830a(multiLineComponent.f26594d);
        multiLineComponent.m18841b(multiLineComponent.f26594d);
        multiLineComponent.m18835a(multiLineComponent.f26597g);
    }

    /* renamed from: a */
    private final void m18835a(String str) {
        if (Intrinsics.areEqual((Object) this.f26596f, (Object) str)) {
            IMarkersCompContract iMarkersCompContract = this.f26614x;
            if (iMarkersCompContract != null) {
                iMarkersCompContract.updateLabelZindex(this.f26596f, this.f26603m);
            }
            IMarkersCompContract iMarkersCompContract2 = this.f26614x;
            if (iMarkersCompContract2 != null) {
                iMarkersCompContract2.updateLabelZindex(this.f26597g, this.f26604n);
                return;
            }
            return;
        }
        IMarkersCompContract iMarkersCompContract3 = this.f26614x;
        if (iMarkersCompContract3 != null) {
            iMarkersCompContract3.updateLabelZindex(this.f26597g, this.f26603m);
        }
        IMarkersCompContract iMarkersCompContract4 = this.f26614x;
        if (iMarkersCompContract4 != null) {
            iMarkersCompContract4.updateLabelZindex(this.f26596f, this.f26604n);
        }
    }

    /* renamed from: a */
    private final void m18830a(int i) {
        IMarkersCompContract iMarkersCompContract = this.f26614x;
        boolean z = true;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.updateLabelSelected(this.f26596f, i == this.f26593c);
        }
        IMarkersCompContract iMarkersCompContract2 = this.f26614x;
        if (iMarkersCompContract2 != null) {
            String str = this.f26597g;
            if (i != this.f26594d) {
                z = false;
            }
            iMarkersCompContract2.updateLabelSelected(str, z);
        }
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [com.didi.map.global.flow.scene.order.confirm.normal.ILineSelectedListener] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m18841b(int r6) {
        /*
            r5 = this;
            com.didi.map.global.flow.scene.order.confirm.component.MultiLineParam r0 = r5.f26598h
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r5.m18840b()
            r5.m18845e()
            int r0 = r5.f26593c
            r1 = 0
            r2 = 1
            r3 = 0
            if (r6 != r0) goto L_0x0051
            com.didi.map.global.flow.scene.order.confirm.component.LineParam r6 = r5.f26609s
            if (r6 != 0) goto L_0x0018
            r6 = r3
            goto L_0x001c
        L_0x0018:
            java.util.List r6 = r6.getPoints()
        L_0x001c:
            com.didi.map.global.component.line.component.ICompLineContract r6 = r5.m18828a((int) r2, (java.util.List<com.didi.common.map.model.LatLng>) r6)
            r5.f26600j = r6
            com.didi.map.global.flow.scene.order.confirm.component.LineParam r6 = r5.f26608r
            if (r6 != 0) goto L_0x0027
            goto L_0x002b
        L_0x0027:
            java.util.List r3 = r6.getPoints()
        L_0x002b:
            com.didi.map.global.component.line.component.ICompLineContract r6 = r5.m18828a((int) r1, (java.util.List<com.didi.common.map.model.LatLng>) r3)
            r5.f26599i = r6
            com.didi.map.global.flow.scene.order.confirm.component.LineParam r6 = r5.f26608r
            if (r6 != 0) goto L_0x0037
            goto L_0x00a9
        L_0x0037:
            com.didi.map.global.flow.scene.order.confirm.component.MultiLineParam r0 = r5.f26598h
            if (r0 != 0) goto L_0x003d
            goto L_0x00a9
        L_0x003d:
            com.didi.map.global.flow.scene.order.confirm.normal.ILineSelectedListener r0 = r0.getOnLineSelectListener()
            if (r0 != 0) goto L_0x0045
            goto L_0x00a9
        L_0x0045:
            long r1 = r6.getLineId()
            long r3 = r6.getLineId()
            r0.routeSelected(r1, r3)
            goto L_0x00a9
        L_0x0051:
            int r0 = r5.f26594d
            if (r6 != r0) goto L_0x00a9
            com.didi.map.global.flow.scene.order.confirm.component.LineParam r6 = r5.f26608r
            if (r6 != 0) goto L_0x005b
            r6 = r3
            goto L_0x005f
        L_0x005b:
            java.util.List r6 = r6.getPoints()
        L_0x005f:
            com.didi.map.global.component.line.component.ICompLineContract r6 = r5.m18828a((int) r2, (java.util.List<com.didi.common.map.model.LatLng>) r6)
            r5.f26599i = r6
            com.didi.map.global.flow.scene.order.confirm.component.LineParam r6 = r5.f26609s
            if (r6 != 0) goto L_0x006b
            r6 = r3
            goto L_0x006f
        L_0x006b:
            java.util.List r6 = r6.getPoints()
        L_0x006f:
            com.didi.map.global.component.line.component.ICompLineContract r6 = r5.m18828a((int) r1, (java.util.List<com.didi.common.map.model.LatLng>) r6)
            r5.f26600j = r6
            com.didi.map.global.flow.scene.order.confirm.component.MultiLineParam r6 = r5.f26598h
            if (r6 != 0) goto L_0x007a
            goto L_0x007e
        L_0x007a:
            com.didi.map.global.flow.scene.order.confirm.normal.ILineSelectedListener r3 = r6.getOnLineSelectListener()
        L_0x007e:
            if (r3 == 0) goto L_0x00a9
            com.didi.map.global.flow.scene.order.confirm.component.LineParam r6 = r5.f26608r
            if (r6 == 0) goto L_0x00a9
            com.didi.map.global.flow.scene.order.confirm.component.LineParam r6 = r5.f26609s
            if (r6 == 0) goto L_0x00a9
            com.didi.map.global.flow.scene.order.confirm.component.MultiLineParam r6 = r5.f26598h
            if (r6 != 0) goto L_0x008d
            goto L_0x00a9
        L_0x008d:
            com.didi.map.global.flow.scene.order.confirm.normal.ILineSelectedListener r6 = r6.getOnLineSelectListener()
            if (r6 != 0) goto L_0x0094
            goto L_0x00a9
        L_0x0094:
            com.didi.map.global.flow.scene.order.confirm.component.LineParam r0 = r5.f26609s
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            long r0 = r0.getLineId()
            com.didi.map.global.flow.scene.order.confirm.component.LineParam r2 = r5.f26608r
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            long r2 = r2.getLineId()
            r6.routeSelected(r0, r2)
        L_0x00a9:
            r5.m18829a()
            com.didi.map.global.flow.scene.order.confirm.component.OnElementShowCallback r6 = r5.f26611u
            if (r6 != 0) goto L_0x00b1
            goto L_0x00b4
        L_0x00b1:
            r6.onLineShowSuccess()
        L_0x00b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.confirm.component.MultiLineComponent.m18841b(int):void");
    }

    /* renamed from: b */
    private final void m18840b() {
        ICompLineContract iCompLineContract = this.f26599i;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
        }
        this.f26599i = null;
        ICompLineContract iCompLineContract2 = this.f26600j;
        if (iCompLineContract2 != null) {
            iCompLineContract2.destroy();
        }
        this.f26600j = null;
    }

    /* renamed from: c */
    private final void m18843c() {
        if (this.f26614x == null) {
            IMarkersCompContract markersComponent = new MarkersComponent();
            this.f26614x = markersComponent;
            if (markersComponent != null) {
                markersComponent.create(this.f26591a, this.f26592b);
            }
            IMarkersCompContract iMarkersCompContract = this.f26614x;
            if (iMarkersCompContract != null) {
                iMarkersCompContract.setOnClickListener(new OnMarkerCompClickListener() {
                    public final boolean onClick(String str) {
                        return MultiLineComponent.m18838a(MultiLineComponent.this, str);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m18838a(MultiLineComponent multiLineComponent, String str) {
        Intrinsics.checkNotNullParameter(multiLineComponent, "this$0");
        DLog.m7384d("ccc", Intrinsics.stringPlus("onClick id=:", str), new Object[0]);
        if (str == multiLineComponent.f26596f) {
            multiLineComponent.m18830a(multiLineComponent.f26593c);
            multiLineComponent.m18841b(multiLineComponent.f26593c);
            multiLineComponent.m18835a(multiLineComponent.f26596f);
            return true;
        }
        String str2 = multiLineComponent.f26597g;
        if (str == str2) {
            multiLineComponent.m18835a(str2);
            multiLineComponent.m18830a(multiLineComponent.f26594d);
            multiLineComponent.m18841b(multiLineComponent.f26594d);
            return true;
        }
        if (str == multiLineComponent.f26595e) {
            multiLineComponent.m18846f();
        }
        return false;
    }

    /* renamed from: d */
    private final void m18844d() {
        IMarkersCompContract iMarkersCompContract = this.f26614x;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.removeMarker(this.f26596f);
        }
        IMarkersCompContract iMarkersCompContract2 = this.f26614x;
        if (iMarkersCompContract2 != null) {
            iMarkersCompContract2.removeMarker(this.f26597g);
        }
    }

    /* renamed from: a */
    private final void m18832a(LatLng latLng, String str, boolean z, String str2, int i, ICollideStrategy iCollideStrategy) {
        MarkerModel markerModel = new MarkerModel();
        markerModel.setPoint(latLng);
        markerModel.setId(str);
        markerModel.setAddressName(str2);
        markerModel.setMarkerIcon(StrategyUtil.getDefaultAnchorBitmap());
        markerModel.setAnchorV(0.5f);
        markerModel.setAnchorU(0.5f);
        markerModel.setLabelZIndex(z ? this.f26603m : this.f26604n);
        markerModel.setZOrder(markerModel.getLabelZIndex());
        markerModel.setClickable(true);
        markerModel.setLabelView(new LineBubbleView());
        markerModel.setLabelDirection(i);
        markerModel.setStrategy(iCollideStrategy);
        markerModel.setLabelSelected(z);
        int dp2px = DisplayUtils.dp2px(this.f26591a, 15.0f);
        markerModel.setLabelAnchorPadding(new Padding(dp2px, dp2px, dp2px, dp2px));
        IMarkersCompContract iMarkersCompContract = this.f26614x;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.addNewMarkerToComponent(markerModel, (MarkersComponent.ImageNetWorkCallback) null);
        }
    }

    /* renamed from: b */
    private final View m18839b(String str) {
        View inflate = View.inflate(this.f26591a, R.layout.line_bubble_newer_educ, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.bubble_content)).setText(str);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return inflate;
    }

    /* renamed from: a */
    private final void m18831a(LatLng latLng, Bitmap bitmap) {
        MarkerModel markerModel = new MarkerModel();
        markerModel.setId(this.f26595e);
        markerModel.setAnchorV(0.0f);
        markerModel.setAnchorU(0.15f);
        markerModel.setZOrder(this.f26605o);
        markerModel.setPoint(latLng);
        markerModel.setMarkerIcon(bitmap);
        IMarkersCompContract iMarkersCompContract = this.f26614x;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.addNewMarkerToComponent(markerModel, (MarkersComponent.ImageNetWorkCallback) null);
        }
        if (this.f26610t == null) {
            Handler handler = new Handler();
            this.f26610t = handler;
            Intrinsics.checkNotNull(handler);
            handler.postDelayed(new Runnable() {
                public final void run() {
                    MultiLineComponent.m18833a(MultiLineComponent.this);
                }
            }, 5000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m18833a(MultiLineComponent multiLineComponent) {
        Intrinsics.checkNotNullParameter(multiLineComponent, "this$0");
        multiLineComponent.m18846f();
    }

    /* renamed from: e */
    private final void m18845e() {
        IMarkersCompContract iMarkersCompContract = this.f26614x;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.removeMarker(this.f26595e);
        }
        Handler handler = this.f26610t;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.f26610t = null;
    }

    /* renamed from: f */
    private final void m18846f() {
        if (this.f26592b != null && this.f26591a != null) {
            m18845e();
            LineParam lineParam = this.f26608r;
            boolean areEqual = Intrinsics.areEqual((Object) lineParam == null ? null : Boolean.valueOf(lineParam.isSelect()), (Object) true);
            LatLng latLng = this.f26612v;
            String str = this.f26596f;
            LineParam lineParam2 = this.f26608r;
            m18832a(latLng, str, areEqual, lineParam2 == null ? null : lineParam2.getLineBubbleContent(), this.f26607q, this.f26616z);
            LatLng latLng2 = this.f26613w;
            String str2 = this.f26597g;
            boolean z = !areEqual;
            LineParam lineParam3 = this.f26609s;
            m18832a(latLng2, str2, z, lineParam3 == null ? null : lineParam3.getLineBubbleContent(), this.f26606p, this.f26616z);
            m18830a(areEqual ? this.f26593c : this.f26594d);
        }
    }

    public final boolean hasLine() {
        return this.f26599i != null;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/map/global/flow/scene/order/confirm/component/MultiLineComponent$Companion;", "", "()V", "TAG", "", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MultiLineComponent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
