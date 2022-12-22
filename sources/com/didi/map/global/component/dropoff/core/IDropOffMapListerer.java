package com.didi.map.global.component.dropoff.core;

import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.model.CameraPosition;

public interface IDropOffMapListerer extends OnCameraChangeListener, OnMapGestureListener {

    /* renamed from: com.didi.map.global.component.dropoff.core.IDropOffMapListerer$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onCameraChange(IDropOffMapListerer iDropOffMapListerer, CameraPosition cameraPosition) {
        }

        public static boolean $default$onDoubleTap(IDropOffMapListerer iDropOffMapListerer, float f, float f2) {
            return false;
        }

        public static boolean $default$onDown(IDropOffMapListerer iDropOffMapListerer, float f, float f2) {
            return false;
        }

        public static boolean $default$onFling(IDropOffMapListerer iDropOffMapListerer, float f, float f2) {
            return false;
        }

        public static boolean $default$onLongPress(IDropOffMapListerer iDropOffMapListerer, float f, float f2) {
            return false;
        }

        public static void $default$onMapStable(IDropOffMapListerer iDropOffMapListerer) {
        }

        public static boolean $default$onScroll(IDropOffMapListerer iDropOffMapListerer, float f, float f2) {
            return false;
        }

        public static boolean $default$onSingleTap(IDropOffMapListerer iDropOffMapListerer, float f, float f2) {
            return false;
        }

        public static boolean $default$onUp(IDropOffMapListerer iDropOffMapListerer, float f, float f2) {
            return false;
        }
    }

    void onCameraChange(CameraPosition cameraPosition);

    boolean onDoubleTap(float f, float f2);

    boolean onDown(float f, float f2);

    boolean onFling(float f, float f2);

    boolean onLongPress(float f, float f2);

    void onMapStable();

    boolean onScroll(float f, float f2);

    boolean onSingleTap(float f, float f2);

    boolean onUp(float f, float f2);
}
