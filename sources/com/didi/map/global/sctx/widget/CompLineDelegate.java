package com.didi.map.global.sctx.widget;

import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineExParam;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.sdk.nav.traffic.ITrafficLine;
import com.didi.map.sdk.nav.traffic.TrafficData;
import com.didi.map.sdk.nav.traffic.TrafficOptions;
import com.didi.map.sdk.nav.traffic.model.TrafficLineAnimatorOptions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\u0012\u0010\u0019\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/map/global/sctx/widget/CompLineDelegate;", "Lcom/didi/map/sdk/nav/traffic/ITrafficLine;", "()V", "compTrafficLine", "Lcom/didi/map/global/component/line/component/ICompLineContract;", "trafficOptions", "Lcom/didi/map/sdk/nav/traffic/TrafficOptions;", "addToMap", "", "map", "Lcom/didi/common/map/Map;", "animatorOptions", "Lcom/didi/map/sdk/nav/traffic/model/TrafficLineAnimatorOptions;", "erase", "segmentIndex", "", "car", "Lcom/didi/common/map/model/LatLng;", "getLines", "", "Lcom/didi/common/map/model/Line;", "highLight", "show", "", "remove", "setTrafficOptions", "base-sync-trip_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CompLineDelegate.kt */
public final class CompLineDelegate implements ITrafficLine {

    /* renamed from: a */
    private TrafficOptions f27705a;

    /* renamed from: b */
    private ICompLineContract f27706b;

    public void setTrafficOptions(TrafficOptions trafficOptions) {
        this.f27705a = trafficOptions;
    }

    public void addToMap(Map map) {
        addToMap(map, (TrafficLineAnimatorOptions) null);
    }

    public void addToMap(Map map, TrafficLineAnimatorOptions trafficLineAnimatorOptions) {
        TrafficOptions trafficOptions;
        List list;
        if (map != null && (trafficOptions = this.f27705a) != null) {
            LineExParam lineExParam = new LineExParam();
            boolean z = false;
            lineExParam.setLineExtensionAnimDuration(trafficLineAnimatorOptions != null ? (int) trafficLineAnimatorOptions.duration : 0);
            lineExParam.setHasLineExtensionAnim(trafficLineAnimatorOptions != null && trafficLineAnimatorOptions.duration > 0);
            lineExParam.setLineMinorColor(trafficOptions.lineMinorColor);
            List<TrafficData> list2 = trafficOptions.trafficDatas;
            if (list2 != null) {
                Iterable<TrafficData> iterable = list2;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (TrafficData trafficData : iterable) {
                    com.didi.map.global.component.line.component.traffic.TrafficData trafficData2 = new com.didi.map.global.component.line.component.traffic.TrafficData();
                    trafficData2.color = trafficData.color;
                    trafficData2.fromIndex = trafficData.fromIndex;
                    trafficData2.toIndex = trafficData.toIndex;
                    trafficData2.minorColor = trafficData.minorColor;
                    arrayList.add(trafficData2);
                }
                list = (List) arrayList;
            } else {
                list = null;
            }
            LineParams lineParams = new LineParams(list, trafficOptions.points, trafficOptions.lineColor, DisplayUtils.px2dp(map.getContext(), (float) trafficOptions.lineWidth));
            lineParams.setClickable(trafficOptions.clickable);
            if (trafficOptions.drawLineType == 2) {
                z = true;
            }
            lineParams.setEnableEarthWormLine(z);
            lineParams.setExParam(lineExParam);
            lineParams.setDidiColor(1);
            ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_TRAFFIC, map, map.getContext(), lineParams);
            this.f27706b = createLineComponent;
            if (createLineComponent != null) {
                createLineComponent.setListener(new CompLineDelegate$addToMap$1(trafficLineAnimatorOptions));
            }
            ICompLineContract iCompLineContract = this.f27706b;
            if (iCompLineContract != null) {
                iCompLineContract.start();
            }
        }
    }

    public void remove() {
        ICompLineContract iCompLineContract = this.f27706b;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
        }
    }

    public void erase(int i, LatLng latLng) {
        if (latLng != null) {
            ICompLineContract iCompLineContract = this.f27706b;
            if (!(iCompLineContract instanceof com.didi.map.global.component.line.component.traffic.ITrafficLine)) {
                iCompLineContract = null;
            }
            com.didi.map.global.component.line.component.traffic.ITrafficLine iTrafficLine = (com.didi.map.global.component.line.component.traffic.ITrafficLine) iCompLineContract;
            if (iTrafficLine != null) {
                iTrafficLine.erase(i, latLng);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000b, code lost:
        r0 = r0.getLines();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.didi.common.map.model.Line> getLines() {
        /*
            r2 = this;
            com.didi.map.global.component.line.component.ICompLineContract r0 = r2.f27706b
            boolean r1 = r0 instanceof com.didi.map.global.component.line.component.traffic.ITrafficLine
            if (r1 != 0) goto L_0x0007
            r0 = 0
        L_0x0007:
            com.didi.map.global.component.line.component.traffic.ITrafficLine r0 = (com.didi.map.global.component.line.component.traffic.ITrafficLine) r0
            if (r0 == 0) goto L_0x0012
            java.util.List r0 = r0.getLines()
            if (r0 == 0) goto L_0x0012
            goto L_0x0016
        L_0x0012:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.widget.CompLineDelegate.getLines():java.util.List");
    }

    public void highLight(boolean z) {
        ICompLineContract iCompLineContract = this.f27706b;
        if (!(iCompLineContract instanceof com.didi.map.global.component.line.component.traffic.ITrafficLine)) {
            iCompLineContract = null;
        }
        com.didi.map.global.component.line.component.traffic.ITrafficLine iTrafficLine = (com.didi.map.global.component.line.component.traffic.ITrafficLine) iCompLineContract;
        if (iTrafficLine != null) {
            iTrafficLine.highLight(z);
        }
    }
}
