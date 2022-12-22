package com.didi.map.global.flow.scene.order.confirm.component;

import android.graphics.Rect;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.map.global.component.collide.strategy2.IDMarkerContractV2;
import com.didi.map.global.component.collide.strategy2.RouteInfo;
import com.didi.map.global.component.collide.util.StrategyUtil;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.markers.IMarkersCompContract;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J\u0010\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0003H\u0016¨\u0006\u0015"}, mo175978d2 = {"com/didi/map/global/flow/scene/order/confirm/component/MultiLineComponent$strategy$1", "Lcom/didi/map/global/component/collide/strategy2/IDMarkerContractV2;", "getCurrentLabelPosition", "", "id", "", "getDisabledLines", "", "Lcom/didi/map/global/component/collide/strategy2/RouteInfo;", "getDisabledRect", "Landroid/graphics/Rect;", "getEnableLabelPosition", "getHot", "getMap", "Lcom/didi/common/map/Map;", "isCanWork", "", "isLabelDirectClockwise", "setLabelDirect", "", "direct", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MultiLineComponent.kt */
public final class MultiLineComponent$strategy$1 implements IDMarkerContractV2 {
    final /* synthetic */ MultiLineComponent this$0;

    public int getEnableLabelPosition(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return 170;
    }

    public boolean isLabelDirectClockwise() {
        return true;
    }

    MultiLineComponent$strategy$1(MultiLineComponent multiLineComponent) {
        this.this$0 = multiLineComponent;
    }

    public Map getMap() {
        Map access$getMMap$p = this.this$0.f26592b;
        Intrinsics.checkNotNull(access$getMMap$p);
        return access$getMMap$p;
    }

    public boolean isCanWork() {
        return this.this$0.f26615y;
    }

    public int getHot(String str) {
        if (this.this$0.f26614x == null) {
            return 0;
        }
        IMarkersCompContract access$getMarkersComp$p = this.this$0.f26614x;
        Integer valueOf = access$getMarkersComp$p == null ? null : Integer.valueOf(access$getMarkersComp$p.getMarkerZindex(str));
        Intrinsics.checkNotNull(valueOf);
        return valueOf.intValue();
    }

    public void setLabelDirect(String str, int i) {
        IMarkersCompContract access$getMarkersComp$p;
        IMarkersCompContract access$getMarkersComp$p2;
        Intrinsics.checkNotNullParameter(str, "id");
        SystemUtils.log(6, "ccc", str + ", setLabelDirect " + i, (Throwable) null, "com.didi.map.global.flow.scene.order.confirm.component.MultiLineComponent$strategy$1", 98);
        if (str == this.this$0.f26596f && (access$getMarkersComp$p2 = this.this$0.f26614x) != null) {
            access$getMarkersComp$p2.updateMarkerLabelDirect(str, i);
        }
        if (str == this.this$0.f26597g && (access$getMarkersComp$p = this.this$0.f26614x) != null) {
            access$getMarkersComp$p.updateMarkerLabelDirect(str, i);
        }
    }

    public int getCurrentLabelPosition(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (TextUtils.isEmpty(str) || this.this$0.f26614x == null) {
            return 32;
        }
        IMarkersCompContract access$getMarkersComp$p = this.this$0.f26614x;
        Intrinsics.checkNotNull(access$getMarkersComp$p);
        return access$getMarkersComp$p.getMarkerLabelDirect(str);
    }

    public List<RouteInfo> getDisabledLines() {
        List<RouteInfo> arrayList = new ArrayList<>();
        if (this.this$0.f26599i != null) {
            ICompLineContract access$getFirstLine$p = this.this$0.f26599i;
            Intrinsics.checkNotNull(access$getFirstLine$p);
            arrayList.add(new RouteInfo(access$getFirstLine$p.getAllLinePoints()));
        }
        if (this.this$0.f26600j != null) {
            ICompLineContract access$getSecondLine$p = this.this$0.f26600j;
            Intrinsics.checkNotNull(access$getSecondLine$p);
            arrayList.add(new RouteInfo(access$getSecondLine$p.getAllLinePoints()));
        }
        return arrayList;
    }

    public List<Rect> getDisabledRect() {
        MultiLineParam access$getLineParam$p = this.this$0.f26598h;
        List<Marker> markersCollide = access$getLineParam$p == null ? null : access$getLineParam$p.getMarkersCollide();
        if (CollectionUtil.isEmpty((Collection<?>) markersCollide)) {
            return null;
        }
        List<Rect> arrayList = new ArrayList<>();
        Intrinsics.checkNotNull(markersCollide);
        for (Marker next : markersCollide) {
            if ((next instanceof Marker) && next.isVisible()) {
                Rect markerRect = StrategyUtil.getMarkerRect(getMap(), next, (Padding) null, false);
                Intrinsics.checkNotNullExpressionValue(markerRect, "getMarkerRect(map, element as Marker?, null, false)");
                arrayList.add(markerRect);
            }
        }
        return arrayList;
    }
}
