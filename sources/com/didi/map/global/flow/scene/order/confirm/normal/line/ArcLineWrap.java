package com.didi.map.global.flow.scene.order.confirm.normal.line;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineExParam;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.flow.scene.order.confirm.component.OnElementShowCallback;
import com.didi.map.global.flow.scene.order.confirm.normal.ILineSelectedListener;
import com.didi.map.global.flow.scene.order.confirm.normal.line.IRouteLineWrap;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.sdk.proto.driver_gl.EpfOrderType;
import com.didi.safetoolkit.router.SfRouter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\u0012\u0010\u001c\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/map/global/flow/scene/order/confirm/normal/line/ArcLineWrap;", "Lcom/didi/map/global/flow/scene/order/confirm/normal/line/IRouteLineWrap;", "mContext", "Landroid/content/Context;", "mMap", "Lcom/didi/common/map/Map;", "mParam", "Lcom/didi/map/global/flow/scene/order/confirm/normal/line/BubbleLineParam;", "(Landroid/content/Context;Lcom/didi/common/map/Map;Lcom/didi/map/global/flow/scene/order/confirm/normal/line/BubbleLineParam;)V", "arcLineComponent", "Lcom/didi/map/global/component/line/component/ICompLineContract;", "elementShowCallback", "Lcom/didi/map/global/flow/scene/order/confirm/component/OnElementShowCallback;", "isArcLineVisible", "", "create", "", "destroy", "drawArcLine", "drawLine", "bubbleId", "", "getBestViewElements", "", "Lcom/didi/common/map/internal/IMapElement;", "hasLine", "setLineVisible", "visible", "setOnElementShowCallback", "Companion", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ArcLineWrap.kt */
public final class ArcLineWrap implements IRouteLineWrap {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: g */
    private static final String f26663g = "ArcLineWrap";

    /* renamed from: a */
    private final Context f26664a;

    /* renamed from: b */
    private final Map f26665b;

    /* renamed from: c */
    private final BubbleLineParam f26666c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ICompLineContract f26667d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f26668e = true;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public OnElementShowCallback f26669f;

    public void create() {
    }

    public ArcLineWrap(Context context, Map map, BubbleLineParam bubbleLineParam) {
        this.f26664a = context;
        this.f26665b = map;
        this.f26666c = bubbleLineParam;
    }

    public String getDefaultBubbleContent() {
        return IRouteLineWrap.DefaultImpls.getDefaultBubbleContent(this);
    }

    public long getDefaultRouteId() {
        return IRouteLineWrap.DefaultImpls.getDefaultRouteId(this);
    }

    public String getOptionBubbleContent() {
        return IRouteLineWrap.DefaultImpls.getOptionBubbleContent(this);
    }

    public long getOptionRouteId() {
        return IRouteLineWrap.DefaultImpls.getOptionRouteId(this);
    }

    public long getSelectedRouteId() {
        return IRouteLineWrap.DefaultImpls.getSelectedRouteId(this);
    }

    public boolean hasMultiLine() {
        return IRouteLineWrap.DefaultImpls.hasMultiLine(this);
    }

    public void onlyShowDefaultLine(boolean z) {
        IRouteLineWrap.DefaultImpls.onlyShowDefaultLine(this, z);
    }

    public void setEpfOrderType(EpfOrderType epfOrderType) {
        IRouteLineWrap.DefaultImpls.setEpfOrderType(this, epfOrderType);
    }

    public void setLineSelectedListener(ILineSelectedListener iLineSelectedListener) {
        IRouteLineWrap.DefaultImpls.setLineSelectedListener(this, iLineSelectedListener);
    }

    public void setMarkersCollide(List<? extends Marker> list) {
        IRouteLineWrap.DefaultImpls.setMarkersCollide(this, list);
    }

    public void setUseCache(boolean z) {
        IRouteLineWrap.DefaultImpls.setUseCache(this, z);
    }

    /* renamed from: a */
    private final void m18875a() {
        BubbleLineParam bubbleLineParam;
        DLog.m7384d(f26663g, "绘制 arcLineComponent", new Object[0]);
        if (this.f26665b != null && this.f26664a != null && (bubbleLineParam = this.f26666c) != null && bubbleLineParam.getCommonLineParam() != null) {
            CommonLineParam commonLineParam = this.f26666c.getCommonLineParam();
            int color = commonLineParam.getLineColor() == 0 ? this.f26664a.getResources().getColor(R.color.global_map_waiting_scene_line_color) : commonLineParam.getLineColor();
            int lineWidth = commonLineParam.getLineWidth() == 0 ? 6 : commonLineParam.getLineWidth();
            List arrayList = new ArrayList();
            LatLng startPoint = commonLineParam.getStartPoint();
            Intrinsics.checkNotNullExpressionValue(startPoint, "param.startPoint");
            arrayList.add(startPoint);
            LatLng endPoint = commonLineParam.getEndPoint();
            Intrinsics.checkNotNullExpressionValue(endPoint, "param.endPoint");
            arrayList.add(endPoint);
            LineParams lineParams = new LineParams(arrayList, color, lineWidth);
            LineExParam lineExParam = new LineExParam();
            lineExParam.setHasArcLineShadow(true);
            lineExParam.setHasPulseAnim(false);
            lineExParam.setHasLineExtensionAnim(false);
            lineParams.setExParam(lineExParam);
            ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_ARC, this.f26665b, this.f26664a, lineParams);
            this.f26667d = createLineComponent;
            if (createLineComponent != null) {
                createLineComponent.start();
            }
            ICompLineContract iCompLineContract = this.f26667d;
            if (iCompLineContract != null) {
                iCompLineContract.setListener(new ArcLineWrap$drawArcLine$1(this));
            }
        }
    }

    public void drawLine(String str) {
        Intrinsics.checkNotNullParameter(str, SfRouter.BUBBLE_ID);
        m18875a();
    }

    public void destroy() {
        ICompLineContract iCompLineContract = this.f26667d;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
        }
    }

    public List<IMapElement> getBestViewElements() {
        ICompLineContract iCompLineContract = this.f26667d;
        if (iCompLineContract == null) {
            return null;
        }
        return iCompLineContract.getBestViewElements();
    }

    public void setLineVisible(boolean z) {
        ICompLineContract iCompLineContract = this.f26667d;
        if (iCompLineContract != null) {
            iCompLineContract.setLineVisible(z);
        }
        this.f26668e = z;
    }

    public boolean hasLine() {
        return this.f26667d != null;
    }

    public void setOnElementShowCallback(OnElementShowCallback onElementShowCallback) {
        this.f26669f = onElementShowCallback;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/map/global/flow/scene/order/confirm/normal/line/ArcLineWrap$Companion;", "", "()V", "TAG", "", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ArcLineWrap.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
