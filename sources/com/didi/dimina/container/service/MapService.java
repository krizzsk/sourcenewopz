package com.didi.dimina.container.service;

import android.view.View;
import org.json.JSONObject;

public interface MapService {

    public static class DefaultMapServiceImpl implements MapService {
        public View getCustomMarkerInfoView(JSONObject jSONObject) {
            return null;
        }

        public Object getMap() {
            return null;
        }

        public View getMapView() {
            return null;
        }

        public boolean useSingleMapInstance() {
            return false;
        }
    }

    View getCustomMarkerInfoView(JSONObject jSONObject);

    Object getMap();

    View getMapView();

    boolean useSingleMapInstance();
}
