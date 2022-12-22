package com.didi.common.map.adapter.googlemapadapter.listener;

import com.didi.common.map.adapter.googlemapadapter.converter.Converter;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnMapClickListener;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.listener.OnMapLongClickListener;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class GoogleMapEventListener implements GoogleMap.OnCameraIdleListener, GoogleMap.OnCameraMoveCanceledListener, GoogleMap.OnCameraMoveListener, GoogleMap.OnCameraMoveStartedListener, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {
    public static final int GESTURE_DEFAULT = 0;
    public static final int SINGLE_FINGER_DOUBLE_CLICK = 3;
    public static final int TOW_FINGERS_CLICK = 2;
    public static final int TOW_FINGERS_MOVE = 1;
    public static final int TOW_FINGERS_TO_SINGLE = 4;

    /* renamed from: a */
    private static final int f10782a = 1;

    /* renamed from: b */
    private static final int f10783b = 2;

    /* renamed from: c */
    private static final int f10784c = 3;

    /* renamed from: d */
    private GoogleMap f10785d;

    /* renamed from: e */
    private final CopyOnWriteArrayList<OnCameraChangeListener> f10786e;

    /* renamed from: f */
    private final CopyOnWriteArrayList<OnMapGestureListener> f10787f;

    /* renamed from: g */
    private final CopyOnWriteArrayList<OnMapClickListener> f10788g;
    public int gesture;

    /* renamed from: h */
    private final CopyOnWriteArrayList<OnMapLongClickListener> f10789h;

    /* renamed from: i */
    private int f10790i;

    public void onCameraMoveCanceled() {
    }

    public void onMapLongClick(LatLng latLng) {
    }

    public GoogleMapEventListener(GoogleMap googleMap) {
        if (googleMap != null) {
            this.f10785d = googleMap;
            this.f10786e = new CopyOnWriteArrayList<>();
            this.f10787f = new CopyOnWriteArrayList<>();
            this.f10788g = new CopyOnWriteArrayList<>();
            this.f10789h = new CopyOnWriteArrayList<>();
            googleMap.setOnCameraIdleListener(this);
            googleMap.setOnCameraMoveListener(this);
            googleMap.setOnCameraMoveCanceledListener(this);
            googleMap.setOnCameraMoveStartedListener(this);
            googleMap.setOnMapClickListener(this);
            googleMap.setOnMapLongClickListener(this);
            return;
        }
        throw new MapNotExistApiException("GoogleMapEventListener:googleMap is null!");
    }

    public void onCameraMoveStarted(int i) {
        this.f10790i = i;
    }

    public void onCameraMove() {
        onCameraChange();
    }

    public void onCameraIdle() {
        onCameraChange();
        if (this.f10790i == 1) {
            m7343a();
        }
        if (this.f10787f != null) {
            SystemUtils.log(6, "GestureFragment", "onCameraIdle", (Throwable) null, "com.didi.common.map.adapter.googlemapadapter.listener.GoogleMapEventListener", 99);
            synchronized (this.f10787f) {
                if (this.f10787f != null && this.f10787f.size() > 0) {
                    Iterator<OnMapGestureListener> it = this.f10787f.iterator();
                    while (it.hasNext()) {
                        it.next().onMapStable();
                    }
                }
            }
        }
        this.gesture = 0;
    }

    /* renamed from: a */
    private void m7343a() {
        HashMap hashMap = new HashMap();
        hashMap.put("times", 1);
        hashMap.put("map_type", "gmap");
        OmegaSDKAdapter.trackEvent("map_global_index_map_drag", (Map<String, Object>) hashMap);
    }

    public void onCameraChange() {
        synchronized (this.f10786e) {
            if (this.f10786e != null && this.f10786e.size() > 0) {
                CameraPosition convertFromGoogleCameraPosition = Converter.convertFromGoogleCameraPosition(this.f10785d.getCameraPosition());
                Iterator<OnCameraChangeListener> it = this.f10786e.iterator();
                while (it.hasNext()) {
                    it.next().onCameraChange(convertFromGoogleCameraPosition);
                }
            }
        }
    }

    public void onMapClick(LatLng latLng) {
        synchronized (this.f10788g) {
            if (this.f10788g != null && this.f10788g.size() > 0) {
                com.didi.common.map.model.LatLng convertFromGoogleLatLng = Converter.convertFromGoogleLatLng(latLng);
                Iterator<OnMapClickListener> it = this.f10788g.iterator();
                while (it.hasNext()) {
                    it.next().onMapClick(convertFromGoogleLatLng);
                }
            }
        }
    }

    public void destroy() {
        GoogleMap googleMap = this.f10785d;
        if (googleMap != null) {
            googleMap.setOnMapClickListener((GoogleMap.OnMapClickListener) null);
            this.f10785d.setOnCameraIdleListener((GoogleMap.OnCameraIdleListener) null);
            this.f10785d.setOnCameraMoveListener((GoogleMap.OnCameraMoveListener) null);
            this.f10785d.setOnCameraMoveCanceledListener((GoogleMap.OnCameraMoveCanceledListener) null);
            this.f10785d.setOnCameraMoveStartedListener((GoogleMap.OnCameraMoveStartedListener) null);
            this.f10785d.setOnMapClickListener((GoogleMap.OnMapClickListener) null);
            this.f10785d.setOnMapLongClickListener((GoogleMap.OnMapLongClickListener) null);
        }
    }

    public void addOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        if (onCameraChangeListener != null) {
            synchronized (this.f10786e) {
                if (!this.f10786e.contains(onCameraChangeListener)) {
                    this.f10786e.add(onCameraChangeListener);
                }
            }
        }
    }

    public void removeOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        synchronized (this.f10786e) {
            this.f10786e.remove(onCameraChangeListener);
        }
    }

    public void addOnMapClickListener(OnMapClickListener onMapClickListener) {
        if (onMapClickListener != null) {
            synchronized (this.f10788g) {
                if (!this.f10788g.contains(onMapClickListener)) {
                    this.f10788g.add(onMapClickListener);
                }
            }
        }
    }

    public void removeOnMapClickListener(OnMapClickListener onMapClickListener) {
        synchronized (this.f10788g) {
            this.f10788g.remove(onMapClickListener);
        }
    }

    public void addOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        if (onMapLongClickListener != null) {
            synchronized (this.f10789h) {
                if (!this.f10789h.contains(onMapLongClickListener)) {
                    this.f10789h.add(onMapLongClickListener);
                }
            }
        }
    }

    public void removeOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        synchronized (this.f10789h) {
            this.f10789h.remove(onMapLongClickListener);
        }
    }

    public void addOnMapGestureListener(OnMapGestureListener onMapGestureListener) {
        if (onMapGestureListener != null) {
            synchronized (this.f10787f) {
                if (!this.f10787f.contains(onMapGestureListener)) {
                    this.f10787f.add(onMapGestureListener);
                }
            }
        }
    }

    public void removeOnMapGestureListener(OnMapGestureListener onMapGestureListener) {
        synchronized (this.f10787f) {
            this.f10787f.remove(onMapGestureListener);
        }
    }

    public List<OnMapGestureListener> getOnMapGestureListeners() {
        CopyOnWriteArrayList<OnMapGestureListener> copyOnWriteArrayList;
        synchronized (this.f10787f) {
            copyOnWriteArrayList = this.f10787f;
        }
        return copyOnWriteArrayList;
    }

    public List<OnMapLongClickListener> getOnMapLongClickListeners() {
        CopyOnWriteArrayList<OnMapLongClickListener> copyOnWriteArrayList;
        synchronized (this.f10789h) {
            copyOnWriteArrayList = this.f10789h;
        }
        return copyOnWriteArrayList;
    }
}
