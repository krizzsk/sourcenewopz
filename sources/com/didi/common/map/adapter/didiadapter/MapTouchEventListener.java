package com.didi.common.map.adapter.didiadapter;

import android.content.Context;
import android.os.Handler;
import com.didi.common.map.adapter.didiadapter.converter.Converter;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnMapClickListener;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.listener.OnMapLoadedCallback;
import com.didi.common.map.listener.OnMapLongClickListener;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.model.CameraPosition;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.MapGestureListener;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class MapTouchEventListener implements DidiMap.OnCameraChangeListener, DidiMap.OnMapClickListener, DidiMap.OnMapLoadedCallback, DidiMap.OnMapLongClickListener, MapGestureListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CopyOnWriteArrayList<OnMapGestureListener> f10710a;

    /* renamed from: b */
    private CopyOnWriteArrayList<OnMapLoadedCallback> f10711b;

    /* renamed from: c */
    private CopyOnWriteArrayList<OnCameraChangeListener> f10712c;

    /* renamed from: d */
    private CopyOnWriteArrayList<OnMapClickListener> f10713d;

    /* renamed from: e */
    private CopyOnWriteArrayList<OnMapLongClickListener> f10714e;

    /* renamed from: f */
    private DidiMap f10715f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f10716g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f10717h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Runnable f10718i = new Runnable() {
        public void run() {
            if (MapTouchEventListener.this.f10716g != null && MapTouchEventListener.this.f10718i != null) {
                if (MapTouchEventListener.this.f10717h) {
                    MapTouchEventListener.this.f10716g.removeCallbacks(MapTouchEventListener.this.f10718i);
                    MapTouchEventListener.this.f10716g.postDelayed(MapTouchEventListener.this.f10718i, 250);
                    return;
                }
                synchronized (MapTouchEventListener.this.f10710a) {
                    if (MapTouchEventListener.this.f10710a != null) {
                        Iterator it = MapTouchEventListener.this.f10710a.iterator();
                        while (it.hasNext()) {
                            ((OnMapGestureListener) it.next()).onMapStable();
                        }
                    }
                }
            }
        }
    };

    /* renamed from: j */
    private Runnable f10719j = new Runnable() {
        public void run() {
            if (MapTouchEventListener.this.f10716g != null) {
                MapTouchEventListener.this.m7315a();
            }
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7315a() {
        HashMap hashMap = new HashMap();
        hashMap.put("times", 1);
        hashMap.put("map_type", RpcPoiBaseInfo.MAP_TYPE_DIDI);
        OmegaSDKAdapter.trackEvent("map_global_index_map_drag", (Map<String, Object>) hashMap);
    }

    public MapTouchEventListener(DidiMap didiMap, Context context) {
        this.f10715f = didiMap;
        this.f10710a = new CopyOnWriteArrayList<>();
        this.f10711b = new CopyOnWriteArrayList<>();
        this.f10712c = new CopyOnWriteArrayList<>();
        this.f10713d = new CopyOnWriteArrayList<>();
        this.f10714e = new CopyOnWriteArrayList<>();
        this.f10715f.addMapGestureListener(this);
        this.f10715f.setOnCameraChangeListener(this);
        this.f10715f.setOnMapClickListener(this);
        this.f10715f.setOnMapLongClickListener(this);
        this.f10715f.setOnMapLoadedCallback(this);
        this.f10717h = false;
        this.f10716g = new Handler(context.getMainLooper());
    }

    public void destroy() {
        DidiMap didiMap = this.f10715f;
        if (didiMap != null) {
            didiMap.removeMapGestureListener((MapGestureListener) this);
            this.f10715f.setOnCameraChangeListener((DidiMap.OnCameraChangeListener) null);
            this.f10715f.setOnMapClickListener((DidiMap.OnMapClickListener) null);
            this.f10715f.setOnMapLongClickListener((DidiMap.OnMapLongClickListener) null);
            this.f10715f.setOnMapLoadedCallback((DidiMap.OnMapLoadedCallback) null);
            this.f10715f = null;
        }
        Handler handler = this.f10716g;
        if (handler != null) {
            handler.removeCallbacks(this.f10718i);
            this.f10716g.removeCallbacks(this.f10719j);
            this.f10716g = null;
            this.f10718i = null;
            this.f10719j = null;
        }
        synchronized (this.f10710a) {
            if (this.f10710a != null) {
                this.f10710a.clear();
                this.f10710a = null;
            }
        }
        synchronized (this.f10711b) {
            if (this.f10711b != null) {
                this.f10711b.clear();
                this.f10711b = null;
            }
        }
        synchronized (this.f10712c) {
            if (this.f10712c != null) {
                this.f10712c.clear();
                this.f10712c = null;
            }
        }
        synchronized (this.f10713d) {
            if (this.f10713d != null) {
                this.f10713d.clear();
                this.f10713d = null;
            }
        }
        synchronized (this.f10714e) {
            if (this.f10714e != null) {
                this.f10714e.clear();
                this.f10714e = null;
            }
        }
        this.f10717h = false;
    }

    public boolean onDoubleTap(float f, float f2) {
        synchronized (this.f10710a) {
            if (this.f10710a != null) {
                Iterator<OnMapGestureListener> it = this.f10710a.iterator();
                while (it.hasNext()) {
                    it.next().onDoubleTap(f, f2);
                }
            }
        }
        return false;
    }

    public boolean onSingleTap(float f, float f2) {
        synchronized (this.f10710a) {
            if (this.f10710a != null) {
                Iterator<OnMapGestureListener> it = this.f10710a.iterator();
                while (it.hasNext()) {
                    it.next().onSingleTap(f, f2);
                }
            }
        }
        return false;
    }

    public boolean onFling(float f, float f2) {
        synchronized (this.f10710a) {
            if (this.f10710a != null) {
                Iterator<OnMapGestureListener> it = this.f10710a.iterator();
                while (it.hasNext()) {
                    it.next().onFling(f, f2);
                }
            }
        }
        return false;
    }

    public boolean onScroll(float f, float f2) {
        synchronized (this.f10710a) {
            if (this.f10710a != null) {
                Iterator<OnMapGestureListener> it = this.f10710a.iterator();
                while (it.hasNext()) {
                    it.next().onScroll(f, f2);
                }
            }
        }
        Handler handler = this.f10716g;
        if (handler == null) {
            return false;
        }
        handler.removeCallbacks(this.f10719j);
        this.f10716g.postDelayed(this.f10719j, 500);
        return false;
    }

    public boolean onLongPress(float f, float f2) {
        synchronized (this.f10710a) {
            if (this.f10710a != null) {
                Iterator<OnMapGestureListener> it = this.f10710a.iterator();
                while (it.hasNext()) {
                    it.next().onLongPress(f, f2);
                }
            }
        }
        return false;
    }

    public boolean onDown(float f, float f2) {
        this.f10717h = true;
        CopyOnWriteArrayList<OnMapGestureListener> copyOnWriteArrayList = this.f10710a;
        if (copyOnWriteArrayList == null) {
            return false;
        }
        Iterator<OnMapGestureListener> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            it.next().onDown(f, f2);
        }
        return false;
    }

    public boolean onUp(float f, float f2) {
        this.f10717h = false;
        synchronized (this.f10710a) {
            if (this.f10710a != null) {
                Iterator<OnMapGestureListener> it = this.f10710a.iterator();
                while (it.hasNext()) {
                    it.next().onUp(f, f2);
                }
            }
        }
        return false;
    }

    public void onMapStable() {
        Runnable runnable;
        Handler handler = this.f10716g;
        if (handler != null && (runnable = this.f10718i) != null) {
            handler.removeCallbacks(runnable);
            this.f10716g.postDelayed(this.f10718i, 250);
        }
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        synchronized (this.f10712c) {
            if (this.f10712c != null) {
                Iterator<OnCameraChangeListener> it = this.f10712c.iterator();
                while (it.hasNext()) {
                    it.next().onCameraChange(Converter.convertFromDidiCameraPosition(cameraPosition));
                }
            }
        }
    }

    public void onMapClick(LatLng latLng) {
        synchronized (this.f10713d) {
            if (this.f10713d != null) {
                Iterator<OnMapClickListener> it = this.f10713d.iterator();
                while (it.hasNext()) {
                    it.next().onMapClick(Converter.convertFromDidiLatLng(latLng));
                }
            }
        }
    }

    public void onMapLongClick(LatLng latLng) {
        synchronized (this.f10714e) {
            if (this.f10714e != null) {
                Iterator<OnMapLongClickListener> it = this.f10714e.iterator();
                while (it.hasNext()) {
                    it.next().onMapLongClick(Converter.convertFromDidiLatLng(latLng));
                }
            }
        }
    }

    public void onMapLoaded() {
        synchronized (this.f10711b) {
            if (this.f10711b != null) {
                Iterator<OnMapLoadedCallback> it = this.f10711b.iterator();
                while (it.hasNext()) {
                    it.next().onMapLoaded();
                }
            }
        }
    }

    public void addOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) throws MapNotExistApiException {
        if (onCameraChangeListener != null) {
            synchronized (this.f10712c) {
                if (this.f10712c != null && !this.f10712c.contains(onCameraChangeListener)) {
                    this.f10712c.add(onCameraChangeListener);
                }
            }
        }
    }

    public void removeOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) throws MapNotExistApiException {
        this.f10712c.remove(onCameraChangeListener);
    }

    public void addOnMapGestureListener(OnMapGestureListener onMapGestureListener) throws MapNotExistApiException {
        if (onMapGestureListener != null) {
            synchronized (this.f10710a) {
                if (!this.f10710a.contains(onMapGestureListener)) {
                    this.f10710a.add(onMapGestureListener);
                }
            }
        }
    }

    public void removeOnMapGestureListener(OnMapGestureListener onMapGestureListener) throws MapNotExistApiException {
        synchronized (this.f10710a) {
            this.f10710a.remove(onMapGestureListener);
        }
    }

    public void addOnMapClickListener(OnMapClickListener onMapClickListener) throws MapNotExistApiException {
        if (onMapClickListener != null) {
            synchronized (this.f10713d) {
                if (!this.f10713d.contains(onMapClickListener)) {
                    this.f10713d.add(onMapClickListener);
                }
            }
        }
    }

    public void removeOnMapClickListener(OnMapClickListener onMapClickListener) throws MapNotExistApiException {
        synchronized (this.f10713d) {
            this.f10713d.remove(onMapClickListener);
        }
    }

    public void addOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) throws MapNotExistApiException {
        if (onMapLongClickListener != null) {
            synchronized (this.f10714e) {
                if (!this.f10714e.contains(onMapLongClickListener)) {
                    this.f10714e.add(onMapLongClickListener);
                }
            }
        }
    }

    public void removeOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) throws MapNotExistApiException {
        synchronized (this.f10714e) {
            this.f10714e.remove(onMapLongClickListener);
        }
    }

    public void addOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) throws MapNotExistApiException {
        synchronized (this.f10711b) {
            if (!this.f10711b.contains(onMapLoadedCallback)) {
                this.f10711b.add(onMapLoadedCallback);
            }
        }
    }

    public void removeOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) throws MapNotExistApiException {
        synchronized (this.f10711b) {
            this.f10711b.remove(onMapLoadedCallback);
        }
    }
}
