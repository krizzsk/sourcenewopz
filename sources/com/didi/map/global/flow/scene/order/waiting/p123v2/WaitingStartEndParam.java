package com.didi.map.global.flow.scene.order.waiting.p123v2;

import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didichuxing.routesearchsdk.CallFrom;
import java.util.List;

/* renamed from: com.didi.map.global.flow.scene.order.waiting.v2.WaitingStartEndParam */
public class WaitingStartEndParam {

    /* renamed from: a */
    private MarkerModel f26990a;

    /* renamed from: b */
    private MarkerModel f26991b;

    /* renamed from: c */
    private WaitingStartEndLineParam f26992c;

    /* renamed from: d */
    private List<MarkerModel> f26993d;

    public WaitingStartEndParam(MarkerModel markerModel, MarkerModel markerModel2, WaitingStartEndLineParam waitingStartEndLineParam) {
        this.f26990a = markerModel;
        this.f26991b = markerModel2;
        this.f26992c = waitingStartEndLineParam;
    }

    public WaitingStartEndParam(MarkerModel markerModel, MarkerModel markerModel2, WaitingStartEndLineParam waitingStartEndLineParam, List<MarkerModel> list) {
        this.f26990a = markerModel;
        this.f26991b = markerModel2;
        this.f26992c = waitingStartEndLineParam;
        this.f26993d = list;
    }

    public MarkerModel getStartMarkerModel() {
        return this.f26990a;
    }

    public void setStartMarkerModel(MarkerModel markerModel) {
        this.f26990a = markerModel;
    }

    public MarkerModel getEndMarkerModel() {
        return this.f26991b;
    }

    public void setEndMarkerModel(MarkerModel markerModel) {
        this.f26991b = markerModel;
    }

    public WaitingStartEndLineParam getLineCompParams() {
        return this.f26992c;
    }

    public void setLineCompParams(WaitingStartEndLineParam waitingStartEndLineParam) {
        this.f26992c = waitingStartEndLineParam;
    }

    public List<MarkerModel> getWayPointsModels() {
        return this.f26993d;
    }

    public void setWayPointsModels(List<MarkerModel> list) {
        this.f26993d = list;
    }

    /* renamed from: com.didi.map.global.flow.scene.order.waiting.v2.WaitingStartEndParam$WaitingStartEndLineParam */
    public static class WaitingStartEndLineParam {
        private CallFrom caller = null;
        private int color = 0;
        private LatLng endPos = null;
        private int lineExtensionAnimDuration = 1500;
        private int lineWidth = 0;
        private int pulseAnimDuration = 1500;
        private LatLng startPos = null;
        private List<LatLng> wayPoints = null;

        public LatLng getStartPos() {
            return this.startPos;
        }

        public void setStartPos(LatLng latLng) {
            this.startPos = latLng;
        }

        public LatLng getEndPos() {
            return this.endPos;
        }

        public void setEndPos(LatLng latLng) {
            this.endPos = latLng;
        }

        public List<LatLng> getWayPoints() {
            return this.wayPoints;
        }

        public void setWayPoints(List<LatLng> list) {
            this.wayPoints = list;
        }

        public CallFrom getCaller() {
            return this.caller;
        }

        public void setCaller(CallFrom callFrom) {
            this.caller = callFrom;
        }

        public int getColor() {
            return this.color;
        }

        public void setColor(int i) {
            this.color = i;
        }

        public int getLineWidth() {
            return this.lineWidth;
        }

        public void setLineWidth(int i) {
            this.lineWidth = i;
        }

        public int getPulseAnimDuration() {
            return this.pulseAnimDuration;
        }

        public void setPulseAnimDuration(int i) {
            this.pulseAnimDuration = i;
        }

        public int getLineExtensionAnimDuration() {
            return this.lineExtensionAnimDuration;
        }

        public void setLineExtensionAnimDuration(int i) {
            this.lineExtensionAnimDuration = i;
        }
    }
}
