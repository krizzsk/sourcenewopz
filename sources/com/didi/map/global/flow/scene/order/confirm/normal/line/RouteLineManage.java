package com.didi.map.global.flow.scene.order.confirm.normal.line;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.Marker;
import com.didi.common.map.util.DLog;
import com.didi.map.global.flow.scene.order.confirm.component.OnElementShowCallback;
import com.didi.map.global.flow.scene.order.confirm.normal.ILineSelectedListener;
import com.didi.map.global.flow.scene.order.confirm.normal.LineMode;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.sdk.proto.driver_gl.EpfOrderType;
import com.didi.safetoolkit.router.SfRouter;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 12\u00020\u0001:\u00011B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0014J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u001dJ\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J\u0010\u0010$\u001a\u00020\u00172\b\u0010%\u001a\u0004\u0018\u00010&J\u0016\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\"2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010)\u001a\u00020\u00172\b\u0010*\u001a\u0004\u0018\u00010\nJ\u000e\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\"J\u0016\u0010-\u001a\u00020\u00172\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014J\u0010\u0010/\u001a\u00020\u00172\b\u00100\u001a\u0004\u0018\u00010\fR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e`\u0012X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, mo175978d2 = {"Lcom/didi/map/global/flow/scene/order/confirm/normal/line/RouteLineManage;", "", "mContext", "Landroid/content/Context;", "mMap", "Lcom/didi/common/map/Map;", "(Landroid/content/Context;Lcom/didi/common/map/Map;)V", "bubbleParam", "Lcom/didi/map/global/flow/scene/order/confirm/normal/line/BubbleLineParam;", "mListener", "Lcom/didi/map/global/flow/scene/order/confirm/normal/ILineSelectedListener;", "mOnElementShowCallback", "Lcom/didi/map/global/flow/scene/order/confirm/component/OnElementShowCallback;", "mRouteLineWrap", "Lcom/didi/map/global/flow/scene/order/confirm/normal/line/IRouteLineWrap;", "mRouteLineWrapCache", "Ljava/util/HashMap;", "Lcom/didi/map/global/flow/scene/order/confirm/normal/LineMode;", "Lkotlin/collections/HashMap;", "markersCollide", "", "Lcom/didi/common/map/model/Marker;", "destroy", "", "getBestViewElements", "Lcom/didi/common/map/internal/IMapElement;", "getDefaultBubbleContent", "", "getDefaultRouteId", "", "getOptionBubbleContent", "getOptionRouteId", "getSelectedRouteId", "hasLine", "", "hasMultiLine", "setEpfOrderType", "type", "Lcom/didi/map/sdk/proto/driver_gl/EpfOrderType;", "setLineMode", "onlyShowDefaultLine", "setLineSelectedListener", "listener", "setLineVisible", "visible", "setMarkersCollide", "sizes", "setOnElementShowCallback", "elementShowCallback", "Companion", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RouteLineManage.kt */
public final class RouteLineManage {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "RouteLineManage";

    /* renamed from: a */
    private final Context f26707a;

    /* renamed from: b */
    private final Map f26708b;

    /* renamed from: c */
    private IRouteLineWrap f26709c;

    /* renamed from: d */
    private ILineSelectedListener f26710d;

    /* renamed from: e */
    private OnElementShowCallback f26711e;

    /* renamed from: f */
    private HashMap<LineMode, IRouteLineWrap> f26712f = new HashMap<>();

    /* renamed from: g */
    private List<? extends Marker> f26713g;

    /* renamed from: h */
    private BubbleLineParam f26714h;

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: RouteLineManage.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LineMode.values().length];
            iArr[LineMode.MODE_SINGLE_ROUTE.ordinal()] = 1;
            iArr[LineMode.MODE_ARC.ordinal()] = 2;
            iArr[LineMode.MODE_MULTI_ROUTE.ordinal()] = 3;
            iArr[LineMode.MODE_NONE.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RouteLineManage(Context context, Map map) {
        this.f26707a = context;
        this.f26708b = map;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/map/global/flow/scene/order/confirm/normal/line/RouteLineManage$Companion;", "", "()V", "TAG", "", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: RouteLineManage.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void setLineMode(boolean z, BubbleLineParam bubbleLineParam) {
        int i;
        IRouteLineWrap iRouteLineWrap;
        Intrinsics.checkNotNullParameter(bubbleLineParam, "bubbleParam");
        IRouteLineWrap iRouteLineWrap2 = this.f26709c;
        if (iRouteLineWrap2 != null) {
            iRouteLineWrap2.destroy();
        }
        this.f26714h = bubbleLineParam;
        String bubbleId = bubbleLineParam.getBubbleId();
        LineMode lineMode = bubbleLineParam.getLineMode();
        if (this.f26712f.containsKey(lineMode)) {
            this.f26709c = this.f26712f.get(lineMode);
        } else {
            if (lineMode == null) {
                i = -1;
            } else {
                i = WhenMappings.$EnumSwitchMapping$0[lineMode.ordinal()];
            }
            if (i == 1) {
                iRouteLineWrap = new SingleRouteLineWrap(this.f26707a, this.f26708b, bubbleLineParam);
            } else if (i == 2) {
                iRouteLineWrap = new ArcLineWrap(this.f26707a, this.f26708b, bubbleLineParam);
            } else if (i == 3) {
                iRouteLineWrap = new MultiRouteLineWrap(this.f26707a, this.f26708b, bubbleLineParam);
            } else if (i == 4) {
                iRouteLineWrap = null;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            this.f26709c = iRouteLineWrap;
            if (iRouteLineWrap != null) {
                Intrinsics.checkNotNullExpressionValue(lineMode, ParamKeys.PARAM_MODE);
                IRouteLineWrap iRouteLineWrap3 = this.f26709c;
                Intrinsics.checkNotNull(iRouteLineWrap3);
                this.f26712f.put(lineMode, iRouteLineWrap3);
            }
        }
        IRouteLineWrap iRouteLineWrap4 = this.f26709c;
        if (iRouteLineWrap4 != null) {
            iRouteLineWrap4.create();
        }
        IRouteLineWrap iRouteLineWrap5 = this.f26709c;
        if (iRouteLineWrap5 != null) {
            iRouteLineWrap5.onlyShowDefaultLine(z);
        }
        IRouteLineWrap iRouteLineWrap6 = this.f26709c;
        if (iRouteLineWrap6 != null) {
            iRouteLineWrap6.setLineSelectedListener(this.f26710d);
        }
        IRouteLineWrap iRouteLineWrap7 = this.f26709c;
        if (iRouteLineWrap7 != null) {
            iRouteLineWrap7.setOnElementShowCallback(this.f26711e);
        }
        IRouteLineWrap iRouteLineWrap8 = this.f26709c;
        if (iRouteLineWrap8 != null) {
            iRouteLineWrap8.setMarkersCollide(this.f26713g);
        }
        IRouteLineWrap iRouteLineWrap9 = this.f26709c;
        if (iRouteLineWrap9 != null) {
            Intrinsics.checkNotNullExpressionValue(bubbleId, SfRouter.BUBBLE_ID);
            iRouteLineWrap9.drawLine(bubbleId);
        }
    }

    public final void setOnElementShowCallback(OnElementShowCallback onElementShowCallback) {
        this.f26711e = onElementShowCallback;
        IRouteLineWrap iRouteLineWrap = this.f26709c;
        if (iRouteLineWrap != null) {
            iRouteLineWrap.setOnElementShowCallback(onElementShowCallback);
        }
    }

    public final void setMarkersCollide(List<? extends Marker> list) {
        this.f26713g = list;
        IRouteLineWrap iRouteLineWrap = this.f26709c;
        if (iRouteLineWrap != null) {
            iRouteLineWrap.setMarkersCollide(list);
        }
    }

    public final void setEpfOrderType(EpfOrderType epfOrderType) {
        IRouteLineWrap iRouteLineWrap = this.f26709c;
        if (iRouteLineWrap != null) {
            iRouteLineWrap.setEpfOrderType(epfOrderType);
        }
    }

    public final List<IMapElement> getBestViewElements() {
        IRouteLineWrap iRouteLineWrap = this.f26709c;
        if (iRouteLineWrap == null) {
            return null;
        }
        return iRouteLineWrap.getBestViewElements();
    }

    public final void setLineSelectedListener(ILineSelectedListener iLineSelectedListener) {
        this.f26710d = iLineSelectedListener;
        IRouteLineWrap iRouteLineWrap = this.f26709c;
        if (iRouteLineWrap != null) {
            iRouteLineWrap.setLineSelectedListener(iLineSelectedListener);
        }
    }

    public final boolean hasLine() {
        IRouteLineWrap iRouteLineWrap = this.f26709c;
        if (iRouteLineWrap == null) {
            return false;
        }
        return iRouteLineWrap.hasLine();
    }

    public final void destroy() {
        IRouteLineWrap iRouteLineWrap = this.f26709c;
        if (iRouteLineWrap != null) {
            iRouteLineWrap.destroy();
        }
    }

    public final long getDefaultRouteId() {
        CommonLineParam commonLineParam;
        IRouteLineWrap iRouteLineWrap = this.f26709c;
        long j = 0;
        if (iRouteLineWrap == null) {
            BubbleLineParam bubbleLineParam = this.f26714h;
            if (bubbleLineParam == null || (commonLineParam = bubbleLineParam.getCommonLineParam()) == null || commonLineParam.getStartPoint() == null || commonLineParam.getEndPoint() == null) {
                DLog.m7384d("BubblePage", "instance: " + this + ", getDefaultRouteId -> default 0", new Object[0]);
                return 0;
            }
            long defaultRouteId = BubblePageCache.getInstance().getDefaultRouteId(commonLineParam.getStartPoint(), commonLineParam.getEndPoint(), commonLineParam.getWayPoints());
            DLog.m7384d("BubblePage", "instance: " + this + ", from cache, start: " + commonLineParam + ".startPoint, end: $ lineParam.endPoint, getDefaultRouteId -> routeId: " + defaultRouteId, new Object[0]);
            return defaultRouteId;
        }
        if (iRouteLineWrap != null) {
            j = iRouteLineWrap.getDefaultRouteId();
        }
        DLog.m7384d("BubblePage", "instance: " + this + ", from memory, getDefaultRouteId -> routeId: " + j, new Object[0]);
        return j;
    }

    public final long getSelectedRouteId() {
        CommonLineParam commonLineParam;
        IRouteLineWrap iRouteLineWrap = this.f26709c;
        long j = 0;
        if (iRouteLineWrap == null) {
            BubbleLineParam bubbleLineParam = this.f26714h;
            if (bubbleLineParam == null || (commonLineParam = bubbleLineParam.getCommonLineParam()) == null || commonLineParam.getStartPoint() == null || commonLineParam.getEndPoint() == null) {
                DLog.m7384d("BubblePage", "instance: " + this + ", getSelectedRouteId -> default 0", new Object[0]);
                return 0;
            }
            long defaultRouteId = BubblePageCache.getInstance().getDefaultRouteId(commonLineParam.getStartPoint(), commonLineParam.getEndPoint(), commonLineParam.getWayPoints());
            DLog.m7384d("BubblePage", "instance: " + this + ", from cache, start: " + commonLineParam + ".startPoint, end: $ lineParam.endPoint, getDefaultRouteId -> routeId: " + defaultRouteId, new Object[0]);
            return defaultRouteId;
        }
        if (iRouteLineWrap != null) {
            j = iRouteLineWrap.getSelectedRouteId();
        }
        DLog.m7384d("BubblePage", "instance: " + this + ", from memory, getSelectedRouteId -> routeId: " + j, new Object[0]);
        return j;
    }

    public final long getOptionRouteId() {
        IRouteLineWrap iRouteLineWrap = this.f26709c;
        if (iRouteLineWrap == null) {
            return 0;
        }
        return iRouteLineWrap.getOptionRouteId();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r0 = r0.getDefaultBubbleContent();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getDefaultBubbleContent() {
        /*
            r2 = this;
            com.didi.map.global.flow.scene.order.confirm.normal.line.IRouteLineWrap r0 = r2.f26709c
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0007
            goto L_0x000f
        L_0x0007:
            java.lang.String r0 = r0.getDefaultBubbleContent()
            if (r0 != 0) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r1 = r0
        L_0x000f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.confirm.normal.line.RouteLineManage.getDefaultBubbleContent():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r0 = r0.getOptionBubbleContent();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getOptionBubbleContent() {
        /*
            r2 = this;
            com.didi.map.global.flow.scene.order.confirm.normal.line.IRouteLineWrap r0 = r2.f26709c
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0007
            goto L_0x000f
        L_0x0007:
            java.lang.String r0 = r0.getOptionBubbleContent()
            if (r0 != 0) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r1 = r0
        L_0x000f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.confirm.normal.line.RouteLineManage.getOptionBubbleContent():java.lang.String");
    }

    public final boolean hasMultiLine() {
        IRouteLineWrap iRouteLineWrap = this.f26709c;
        if (iRouteLineWrap == null) {
            return false;
        }
        return iRouteLineWrap.hasMultiLine();
    }

    public final void setLineVisible(boolean z) {
        IRouteLineWrap iRouteLineWrap = this.f26709c;
        if (iRouteLineWrap != null) {
            iRouteLineWrap.setLineVisible(z);
        }
    }
}
