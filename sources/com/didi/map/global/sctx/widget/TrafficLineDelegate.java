package com.didi.map.global.sctx.widget;

import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.map.google.util.DLog;
import com.didi.map.sdk.nav.traffic.ITrafficLine;
import com.didi.map.sdk.nav.traffic.TrafficLine;
import com.didi.map.sdk.nav.traffic.TrafficOptions;
import com.didi.map.sdk.nav.traffic.model.TrafficLineAnimatorOptions;
import java.util.ArrayList;
import java.util.List;

public class TrafficLineDelegate implements ITrafficLine {

    /* renamed from: a */
    private final String f27707a = TrafficLineDelegate.class.getSimpleName();

    /* renamed from: b */
    private ITrafficLine f27708b;

    public void setTrafficOptions(TrafficOptions trafficOptions) {
        if (trafficOptions != null) {
            if (trafficOptions.useNewCompLine) {
                this.f27708b = new CompLineDelegate();
            } else {
                this.f27708b = new TrafficLine();
            }
            String str = this.f27707a;
            StringBuilder sb = new StringBuilder();
            sb.append("use new compLine: ");
            sb.append(trafficOptions.useNewCompLine);
            sb.append("|use texture: ");
            sb.append(trafficOptions.drawLineType == 2);
            DLog.m19914d(str, sb.toString(), new Object[0]);
            this.f27708b.setTrafficOptions(trafficOptions);
        }
    }

    public void addToMap(Map map) {
        ITrafficLine iTrafficLine = this.f27708b;
        if (iTrafficLine != null) {
            iTrafficLine.addToMap(map);
        }
    }

    public void addToMap(Map map, TrafficLineAnimatorOptions trafficLineAnimatorOptions) {
        ITrafficLine iTrafficLine = this.f27708b;
        if (iTrafficLine != null) {
            iTrafficLine.addToMap(map, trafficLineAnimatorOptions);
        }
    }

    public void remove() {
        ITrafficLine iTrafficLine = this.f27708b;
        if (iTrafficLine != null) {
            iTrafficLine.remove();
        }
    }

    public void erase(int i, LatLng latLng) {
        ITrafficLine iTrafficLine = this.f27708b;
        if (iTrafficLine != null) {
            iTrafficLine.erase(i, latLng);
        }
    }

    public List<Line> getLines() {
        ITrafficLine iTrafficLine = this.f27708b;
        return iTrafficLine != null ? iTrafficLine.getLines() : new ArrayList();
    }

    public void highLight(boolean z) {
        ITrafficLine iTrafficLine = this.f27708b;
        if (iTrafficLine != null) {
            iTrafficLine.highLight(z);
        }
    }
}
