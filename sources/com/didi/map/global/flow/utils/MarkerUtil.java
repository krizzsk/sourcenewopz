package com.didi.map.global.flow.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.view.View;
import com.didi.common.map.MapView;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.Marker;

public class MarkerUtil {
    public static void showInfoWindow(MapView mapView, Marker marker, View view, int i, InfoWindow.Position position) {
        if (mapView != null && mapView.getMap() != null && marker != null && view != null && marker.getId() != null) {
            InfoWindow buildInfoWindow = marker.buildInfoWindow(mapView.getMap(), mapView.getContext().getApplicationContext(), position);
            if (position != null) {
                buildInfoWindow.setPosition(position);
            }
            buildInfoWindow.showInfoWindow(view);
            if (buildInfoWindow.getInfoWindowMarker() != null) {
                buildInfoWindow.getInfoWindowMarker().setZIndex(i);
            }
        }
    }

    public static void hideInfoWindow(Marker marker) {
        if (marker != null && marker.getInfoWindow() != null) {
            marker.hideInfoWindow();
        }
    }

    public static void showInfoWindow(Marker marker) {
        if (marker != null && marker.getInfoWindow() != null && marker.getInfoWindow().getInfoWindowMarker() != null) {
            marker.getInfoWindow().getInfoWindowMarker().setVisible(true);
        }
    }

    public static Bitmap getMaskBitmap(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap);
            new Canvas(createBitmap).drawColor(i, PorterDuff.Mode.DST_IN);
            return createBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
