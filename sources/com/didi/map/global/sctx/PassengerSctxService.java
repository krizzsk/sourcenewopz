package com.didi.map.global.sctx;

import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.map.global.sctx.SctxService;
import com.didi.map.global.sctx.model.SctxTripParam;
import com.didi.map.sdk.nav.car.CarMarker;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import java.util.ArrayList;
import java.util.List;

public class PassengerSctxService implements SctxService {

    /* renamed from: a */
    private SctxService f27407a;

    public PassengerSctxService(SctxTripParam sctxTripParam) {
        if (sctxTripParam != null && sctxTripParam.getMap() != null && sctxTripParam.getContext() != null) {
            this.f27407a = new SctxServiceFactory().getSctxService(sctxTripParam);
        }
    }

    public void enter() {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            sctxService.enter();
        }
    }

    public void resume() {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            sctxService.resume();
        }
    }

    public void pause() {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            sctxService.pause();
        }
    }

    public void leave() {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            sctxService.leave();
        }
    }

    public long getRouteId() {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            return sctxService.getRouteId();
        }
        return 0;
    }

    public CarMarker getCarMarker() {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            return sctxService.getCarMarker();
        }
        return null;
    }

    public LatLng getDriverPoint() {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            return sctxService.getDriverPoint();
        }
        return null;
    }

    public List<LatLng> getRemainingRoutePoints() {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            return sctxService.getRemainingRoutePoints();
        }
        return new ArrayList();
    }

    public double getRemainingRouteDistance() {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            return sctxService.getRemainingRouteDistance();
        }
        return 0.0d;
    }

    public List<LatLng> getRoutePoints() {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            return sctxService.getRoutePoints();
        }
        return new ArrayList();
    }

    public List<Line> getLines() {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            return sctxService.getLines();
        }
        return new ArrayList();
    }

    public void setCarIcon(BitmapDescriptor bitmapDescriptor) {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            sctxService.setCarIcon(bitmapDescriptor);
        }
    }

    public boolean set3DCarIcons(boolean z, List<String> list) {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            return sctxService.set3DCarIcons(z, list);
        }
        return false;
    }

    public void setOraRequestInterval(long j) {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            sctxService.setOraRequestInterval(j);
        }
    }

    public void updateDestination(LatLng latLng) {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            sctxService.updateDestination(latLng);
        }
    }

    public void updatePickupPoint(LatLng latLng) {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            sctxService.updatePickupPoint(latLng);
        }
    }

    public void setWayPoints(List<OdPoint> list, long j) {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            sctxService.setWayPoints(list, j);
        }
    }

    public void setSctxOraNetAgent(SctxService.SctxOraNetAgent sctxOraNetAgent) {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            sctxService.setSctxOraNetAgent(sctxOraNetAgent);
        }
    }

    public void registerSctxCallback(SctxService.SctxCallback sctxCallback) {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            sctxService.registerSctxCallback(sctxCallback);
        }
    }

    public void unRegisterSctxCallback(SctxService.SctxCallback sctxCallback) {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            sctxService.unRegisterSctxCallback(sctxCallback);
        }
    }

    public void update(SctxTripParam sctxTripParam) {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            sctxService.update(sctxTripParam);
        }
    }

    public void cancelPickupPointRecommend() {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            sctxService.cancelPickupPointRecommend();
        }
    }

    public void chooseLine(int i) {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            sctxService.chooseLine(i);
        }
    }

    public void showRecommendPickupPoint(boolean z) {
        SctxService sctxService = this.f27407a;
        if (sctxService != null) {
            sctxService.showRecommendPickupPoint(z);
        }
    }
}
