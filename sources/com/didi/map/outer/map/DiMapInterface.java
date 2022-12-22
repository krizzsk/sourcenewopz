package com.didi.map.outer.map;

import android.view.View;

public class DiMapInterface {

    public interface IOnInfoWindowClickListener<T extends DMarker> {
        void onInfoWindowClick(T t);

        void onInfoWindowClickLocation(int i, int i2, int i3, int i4);
    }

    public interface IOnMarkerClickListener<T extends DMarker> {
        boolean onMarkerClick(T t);
    }

    public interface IWindowAdapter<T extends DMarker> {
        public static final int NORMAL = 0;
        public static final int PRESS = 1;

        View getInfoContents(T t);

        View[] getInfoWindow(T t);

        View[] getOverturnInfoWindow(T t);
    }
}
