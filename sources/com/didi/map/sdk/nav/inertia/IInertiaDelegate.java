package com.didi.map.sdk.nav.inertia;

import com.didi.common.map.model.LatLng;
import com.map.sdk.nav.libc.common.DMKEventPoint;
import com.map.sdk.nav.libc.common.MapMatchType;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.ArrayList;
import java.util.List;

public interface IInertiaDelegate {

    public interface ISimulateEvaluateCallback {
        void onReceiveCarMoveInfo(CarMoveInfo carMoveInfo);

        void onReceiveSimulateInfo(SimulateInfo simulateInfo);
    }

    void destroy();

    int distanceLeft();

    int distanceLeft(RouteGuidanceGPSPoint routeGuidanceGPSPoint);

    ArrayList<DMKEventPoint> getEventPointList();

    int getEventPointSize();

    RouteGuidanceGPSPoint getLastMatchGPSPoint();

    MapMatchType getMapMatchType();

    void getMatchPoint(boolean z);

    MatchPointType getMatchPointType();

    void onRecvDriverLocation(RouteGuidanceGPSPoint routeGuidanceGPSPoint);

    void resetRecvDriverLocation();

    void setOnLocationMatched(OnLocationMatched onLocationMatched);

    void setOrderInfo(String str, int i);

    void setPredictionApolloParams(ApolloParamsSctxPrediction apolloParamsSctxPrediction);

    void setRequestIntervalInMills(int i);

    void setRouteId(String str);

    void setRoutePoints(List<LatLng> list);

    void setRoutePoints(List<LatLng> list, int i);

    void setRoutePoints(List<LatLng> list, int i, boolean z);

    void setRoutePoints(List<LatLng> list, boolean z);

    void setSimulateEvaluateCallback(ISimulateEvaluateCallback iSimulateEvaluateCallback);
}
