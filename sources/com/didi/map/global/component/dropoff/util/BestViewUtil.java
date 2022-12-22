package com.didi.map.global.component.dropoff.util;

import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.LatLngUtils;
import java.util.Arrays;
import java.util.List;

public class BestViewUtil {
    public static void adjustMapCamera(Map map, LatLng latLng, List<LatLng> list, Padding padding, Padding padding2, BestViewer.IBestViewListener iBestViewListener) {
        BestViewer.doBestView(map, true, latLng, list, padding, padding2, iBestViewListener);
    }

    public static void adjustCameraForPinView(Map map, LatLng latLng, boolean z, boolean z2, float f, Padding padding, BestViewer.IBestViewListener iBestViewListener) {
        if (latLng != null && map != null) {
            if (f == 0.0f) {
                f = 14.0f;
            }
            if (!z2) {
                f = (float) map.getCameraPosition().zoom;
            }
            BestViewer.doBestView(map, z, Float.valueOf(f), latLng, padding, iBestViewListener);
        }
    }

    public void updateMapPadding(Map map, Padding padding) {
        if (map != null && map.getCameraPosition() != null && padding != null && !padding.equals(map.getPadding())) {
            if (map.getMapVendor() == MapVendor.DIDI) {
                map.setPadding(padding.left, padding.top, padding.right, padding.bottom);
                return;
            }
            CameraPosition cameraPosition = map.getCameraPosition();
            BestViewer.doBestView(map, false, Float.valueOf((float) cameraPosition.zoom), cameraPosition.target, padding, (BestViewer.IBestViewListener) null);
        }
    }

    public static List<LatLng> getBoundsForDistance(int i, LatLng latLng) {
        double d = (double) i;
        double m2L = LatLngUtils.m2L(d, latLng.longitude);
        double m2L2 = LatLngUtils.m2L(d, latLng.latitude);
        return Arrays.asList(new LatLng[]{new LatLng(latLng.latitude - m2L2, latLng.longitude - m2L), new LatLng(latLng.latitude + m2L2, latLng.longitude + m2L)});
    }
}
