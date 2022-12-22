package com.didi.map.sdk.nav.traffic;

import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.map.sdk.nav.traffic.model.TrafficLineAnimatorOptions;
import java.util.ArrayList;
import java.util.List;

public class TrafficLine implements ITrafficLine {

    /* renamed from: a */
    private ITrafficLine f28491a;

    public void setTrafficOptions(TrafficOptions trafficOptions) {
        if (trafficOptions == null) {
            return;
        }
        if (trafficOptions.drawLineType == 1) {
            TrafficLineColor trafficLineColor = new TrafficLineColor();
            this.f28491a = trafficLineColor;
            trafficLineColor.setTrafficOptions(trafficOptions);
        } else if (trafficOptions.drawLineType == 2) {
            TrafficLineTexture trafficLineTexture = new TrafficLineTexture();
            this.f28491a = trafficLineTexture;
            trafficLineTexture.setTrafficOptions(trafficOptions);
        }
    }

    public void addToMap(Map map) {
        addToMap(map, (TrafficLineAnimatorOptions) null);
    }

    public void addToMap(Map map, TrafficLineAnimatorOptions trafficLineAnimatorOptions) {
        ITrafficLine iTrafficLine = this.f28491a;
        if (iTrafficLine != null) {
            iTrafficLine.addToMap(map, trafficLineAnimatorOptions);
        }
    }

    public void erase(int i, LatLng latLng) {
        ITrafficLine iTrafficLine = this.f28491a;
        if (iTrafficLine != null) {
            iTrafficLine.erase(i, latLng);
        }
    }

    public List<Line> getLines() {
        ITrafficLine iTrafficLine = this.f28491a;
        if (iTrafficLine != null) {
            return iTrafficLine.getLines();
        }
        return new ArrayList();
    }

    public void remove() {
        ITrafficLine iTrafficLine = this.f28491a;
        if (iTrafficLine != null) {
            iTrafficLine.remove();
        }
    }

    public void highLight(boolean z) {
        ITrafficLine iTrafficLine = this.f28491a;
        if (iTrafficLine != null) {
            iTrafficLine.highLight(z);
        }
    }
}
