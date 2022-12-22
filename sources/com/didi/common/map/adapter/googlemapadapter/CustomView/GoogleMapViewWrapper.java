package com.didi.common.map.adapter.googlemapadapter.CustomView;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.GestureDetectorCompat;
import com.didi.common.map.adapter.googlemapadapter.converter.Converter;
import com.didi.common.map.adapter.googlemapadapter.listener.GoogleMapEventListener;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnMapClickListener;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.listener.OnMapLongClickListener;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.didi.common.map.util.DLog;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;

public class GoogleMapViewWrapper extends FrameLayout {
    public static final int ANIMATE_TIME = 400;
    public static boolean IS_SCALE = false;

    /* renamed from: a */
    private static final String f10742a = "GoogleMapViewWrapper";

    /* renamed from: b */
    private static final float f10743b = 1.5f;
    public static boolean isActionPointerDown = false;
    public static boolean isDoubleScale = false;

    /* renamed from: c */
    private MapView f10744c;

    /* renamed from: d */
    private View f10745d;

    /* renamed from: e */
    private GestureDetectorCompat f10746e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public GoogleMap f10747f;

    /* renamed from: g */
    private float f10748g;

    /* renamed from: h */
    private long f10749h;

    /* renamed from: i */
    private float f10750i;

    /* renamed from: j */
    private LatLng f10751j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public GoogleMapEventListener f10752k;

    /* renamed from: l */
    private long f10753l;

    /* renamed from: m */
    private double f10754m;

    /* renamed from: n */
    private double f10755n;

    /* renamed from: o */
    private boolean f10756o;

    /* renamed from: p */
    private long f10757p;

    /* renamed from: q */
    private LatLng f10758q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public long f10759r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public LatLng f10760s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f10761t;

    /* renamed from: u */
    private final GestureDetector.SimpleOnGestureListener f10762u = new GestureDetector.SimpleOnGestureListener() {
        public boolean onDoubleTap(MotionEvent motionEvent) {
            boolean unused = GoogleMapViewWrapper.this.f10761t = true;
            if (GoogleMapViewWrapper.this.f10752k != null) {
                for (OnMapGestureListener onDoubleTap : GoogleMapViewWrapper.this.f10752k.getOnMapGestureListeners()) {
                    onDoubleTap.onDoubleTap(motionEvent.getX(), motionEvent.getY());
                }
            }
            if (GoogleMapViewWrapper.this.f10747f == null) {
                return false;
            }
            GoogleMapViewWrapper.this.f10747f.getUiSettings().setScrollGesturesEnabled(false);
            float f = 21.0f;
            if (GoogleMapViewWrapper.this.f10747f.getCameraPosition().zoom == 21.0f) {
                GoogleMapViewWrapper.this.f10747f.getUiSettings().setScrollGesturesEnabled(true);
                return true;
            }
            float f2 = GoogleMapViewWrapper.this.f10747f.getCameraPosition().zoom + 1.0f;
            if (f2 <= 21.0f) {
                f = f2;
            }
            long eventTime = motionEvent.getEventTime();
            if (eventTime - GoogleMapViewWrapper.this.f10759r >= 300) {
                GoogleMapViewWrapper googleMapViewWrapper = GoogleMapViewWrapper.this;
                LatLng unused2 = googleMapViewWrapper.f10760s = googleMapViewWrapper.f10747f.getCameraPosition().target;
            } else if (GoogleMapViewWrapper.this.f10760s == null) {
                GoogleMapViewWrapper googleMapViewWrapper2 = GoogleMapViewWrapper.this;
                LatLng unused3 = googleMapViewWrapper2.f10760s = googleMapViewWrapper2.f10747f.getCameraPosition().target;
            }
            long unused4 = GoogleMapViewWrapper.this.f10759r = eventTime;
            GoogleMapViewWrapper.this.f10752k.gesture = 3;
            GoogleMapViewWrapper.this.f10747f.animateCamera(CameraUpdateFactory.newLatLngZoom(GoogleMapViewWrapper.this.f10760s, f), 400, new GoogleMap.CancelableCallback() {
                public void onFinish() {
                    GoogleMapViewWrapper.this.f10747f.getUiSettings().setScrollGesturesEnabled(true);
                }

                public void onCancel() {
                    GoogleMapViewWrapper.this.f10747f.getUiSettings().setScrollGesturesEnabled(true);
                }
            });
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (GoogleMapViewWrapper.this.f10752k != null) {
                for (OnMapGestureListener onScroll : GoogleMapViewWrapper.this.f10752k.getOnMapGestureListeners()) {
                    onScroll.onScroll(f, f2);
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (GoogleMapViewWrapper.this.f10752k != null) {
                for (OnMapGestureListener onFling : GoogleMapViewWrapper.this.f10752k.getOnMapGestureListeners()) {
                    onFling.onFling(f, f2);
                }
            }
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        public boolean onDown(MotionEvent motionEvent) {
            if (GoogleMapViewWrapper.this.f10752k != null) {
                for (OnMapGestureListener onDown : GoogleMapViewWrapper.this.f10752k.getOnMapGestureListeners()) {
                    onDown.onDown(motionEvent.getX(), motionEvent.getY());
                }
            }
            return super.onDown(motionEvent);
        }

        public void onLongPress(MotionEvent motionEvent) {
            if (GoogleMapViewWrapper.this.f10752k != null) {
                for (OnMapGestureListener onLongPress : GoogleMapViewWrapper.this.f10752k.getOnMapGestureListeners()) {
                    onLongPress.onLongPress(motionEvent.getX(), motionEvent.getY());
                }
            }
            try {
                LatLng fromScreenLocation = GoogleMapViewWrapper.this.f10747f.getProjection().fromScreenLocation(new Point((int) motionEvent.getX(), (int) motionEvent.getY()));
                if (GoogleMapViewWrapper.this.f10752k != null) {
                    for (OnMapLongClickListener onMapLongClick : GoogleMapViewWrapper.this.f10752k.getOnMapLongClickListeners()) {
                        onMapLongClick.onMapLongClick(Converter.convertFromGoogleLatLng(fromScreenLocation));
                    }
                }
            } catch (Exception e) {
                DLog.m7384d(GoogleMapViewWrapper.f10742a, "long press exc: " + e.getMessage(), new Object[0]);
            }
            super.onLongPress(motionEvent);
        }
    };

    public void destroy() {
    }

    public GoogleMapViewWrapper(Context context) {
        super(context);
        m7329a(context);
    }

    public GoogleMapViewWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7329a(context);
    }

    public GoogleMapViewWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7329a(context);
    }

    /* renamed from: a */
    private void m7329a(Context context) {
        this.f10745d = new View(context);
        MapView mapView = new MapView(context);
        this.f10744c = mapView;
        addView(mapView);
        addView(this.f10745d);
        this.f10746e = new GestureDetectorCompat(context, this.f10762u);
        this.f10748g = 1.5f / ((float) getResources().getDisplayMetrics().widthPixels);
    }

    public MapView getGoogleMapView() {
        return this.f10744c;
    }

    public void setGoogleMap(GoogleMap googleMap) {
        this.f10747f = googleMap;
        if (this.f10752k == null) {
            this.f10752k = new GoogleMapEventListener(googleMap);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        GoogleMap googleMap = this.f10747f;
        if (googleMap == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!googleMap.getUiSettings().isZoomGesturesEnabled()) {
            return true;
        }
        if (actionMasked == 0) {
            if (!this.f10747f.getUiSettings().isScrollGesturesEnabled()) {
                this.f10747f.getUiSettings().setScrollGesturesEnabled(true);
            }
            z = this.f10746e.onTouchEvent(motionEvent);
        } else if (actionMasked == 1) {
            this.f10755n = 0.0d;
            z = this.f10746e.onTouchEvent(motionEvent);
            GoogleMapEventListener googleMapEventListener = this.f10752k;
            if (googleMapEventListener != null) {
                for (OnMapGestureListener onUp : googleMapEventListener.getOnMapGestureListeners()) {
                    onUp.onUp(motionEvent.getX(), motionEvent.getY());
                }
            }
            if (isActionPointerDown) {
                isActionPointerDown = false;
            }
            if (IS_SCALE) {
                IS_SCALE = false;
                motionEvent.setAction(0);
                super.dispatchTouchEvent(motionEvent);
                return true;
            } else if (this.f10761t) {
                this.f10761t = false;
                return true;
            } else if (this.f10756o) {
                this.f10756o = false;
                return true;
            }
        } else if (actionMasked == 5) {
            isActionPointerDown = true;
            z = this.f10746e.onTouchEvent(motionEvent);
            this.f10749h = motionEvent.getEventTime();
            this.f10754m = getPointsLength(motionEvent);
            this.f10747f.getUiSettings().setScrollGesturesEnabled(false);
            this.f10750i = this.f10747f.getCameraPosition().zoom;
            this.f10751j = this.f10747f.getCameraPosition().target;
        } else if (actionMasked == 6) {
            this.f10755n = 0.0d;
            z = this.f10746e.onTouchEvent(motionEvent);
            GoogleMapEventListener googleMapEventListener2 = this.f10752k;
            if (googleMapEventListener2 != null) {
                for (OnMapGestureListener onUp2 : googleMapEventListener2.getOnMapGestureListeners()) {
                    onUp2.onUp(motionEvent.getX(), motionEvent.getY());
                }
            }
            if (!this.f10747f.getUiSettings().isScrollGesturesEnabled()) {
                this.f10747f.getUiSettings().setScrollGesturesEnabled(true);
            }
            this.f10753l = motionEvent.getEventTime();
            if (motionEvent.getPointerCount() > 1 && this.f10753l - this.f10749h < 200 && this.f10747f.getCameraPosition().zoom != this.f10747f.getMinZoomLevel() && !IS_SCALE) {
                this.f10756o = true;
                float f = this.f10747f.getCameraPosition().zoom - 1.0f;
                if (f < this.f10747f.getMinZoomLevel()) {
                    f = this.f10747f.getMinZoomLevel();
                }
                isDoubleScale = true;
                long eventTime = motionEvent.getEventTime();
                if (eventTime - this.f10757p >= 300) {
                    this.f10758q = this.f10747f.getCameraPosition().target;
                } else if (this.f10758q == null) {
                    this.f10758q = this.f10747f.getCameraPosition().target;
                }
                this.f10757p = eventTime;
                this.f10752k.gesture = 2;
                this.f10747f.animateCamera(CameraUpdateFactory.newLatLngZoom(this.f10758q, f), 400, (GoogleMap.CancelableCallback) null);
                return true;
            }
        } else if (actionMasked != 2) {
            z = false;
        } else if (motionEvent.getPointerCount() > 1) {
            double pointsLength = getPointsLength(motionEvent);
            double abs = Math.abs((pointsLength - this.f10754m) * ((double) this.f10748g));
            if (Math.abs(abs - this.f10755n) > 0.01d) {
                IS_SCALE = true;
                this.f10755n = abs;
                float f2 = (float) (((pointsLength - this.f10754m) * ((double) this.f10748g)) + ((double) this.f10750i));
                if (f2 > this.f10747f.getMinZoomLevel() || this.f10747f.getCameraPosition().zoom != this.f10747f.getMinZoomLevel()) {
                    if (f2 >= 21.0f && this.f10747f.getCameraPosition().zoom >= 21.0f) {
                        this.f10754m = pointsLength;
                        this.f10750i = 21.0f;
                        if (this.f10747f.getCameraPosition().zoom == 21.0f) {
                            return true;
                        }
                    }
                    if (this.f10751j == null) {
                        this.f10751j = this.f10747f.getCameraPosition().target;
                    }
                    this.f10752k.gesture = 1;
                    this.f10747f.animateCamera(CameraUpdateFactory.newLatLngZoom(this.f10751j, f2), 1, (GoogleMap.CancelableCallback) null);
                    GoogleMapEventListener googleMapEventListener3 = this.f10752k;
                    if (googleMapEventListener3 != null) {
                        googleMapEventListener3.onCameraChange();
                    }
                } else {
                    this.f10754m = pointsLength;
                    this.f10750i = this.f10747f.getMinZoomLevel();
                    return true;
                }
            }
            return true;
        } else {
            if (!(this.f10752k.gesture == 2 || this.f10752k.gesture == 3)) {
                this.f10752k.gesture = 0;
            }
            if (motionEvent.getEventTime() - this.f10753l <= 50) {
                return false;
            }
            if (this.f10746e.onTouchEvent(motionEvent)) {
                return true;
            }
            try {
                if (super.dispatchTouchEvent(motionEvent)) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                DLog.m7384d(f10742a, "super.dispatchTouchEvent = " + th, new Object[0]);
                return false;
            }
        }
        if (z || super.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public double getPointsLength(MotionEvent motionEvent) {
        float abs = Math.abs(motionEvent.getX(0) - motionEvent.getX(motionEvent.getPointerCount() - 1));
        float abs2 = Math.abs(motionEvent.getY(0) - motionEvent.getY(motionEvent.getPointerCount() - 1));
        return Math.sqrt((double) ((abs * abs) + (abs2 * abs2)));
    }

    public void addOnMapGestureListener(OnMapGestureListener onMapGestureListener) throws MapNotExistApiException {
        GoogleMapEventListener googleMapEventListener = this.f10752k;
        if (googleMapEventListener != null) {
            googleMapEventListener.addOnMapGestureListener(onMapGestureListener);
        }
    }

    public void removeOnMapGestureListener(OnMapGestureListener onMapGestureListener) throws MapNotExistApiException {
        GoogleMapEventListener googleMapEventListener = this.f10752k;
        if (googleMapEventListener != null) {
            googleMapEventListener.removeOnMapGestureListener(onMapGestureListener);
        }
    }

    public void addOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) throws MapNotExistApiException {
        GoogleMapEventListener googleMapEventListener = this.f10752k;
        if (googleMapEventListener != null) {
            googleMapEventListener.addOnCameraChangeListener(onCameraChangeListener);
        }
    }

    public void removeOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) throws MapNotExistApiException {
        GoogleMapEventListener googleMapEventListener = this.f10752k;
        if (googleMapEventListener != null) {
            googleMapEventListener.removeOnCameraChangeListener(onCameraChangeListener);
        }
    }

    public void addOnMapClickListener(OnMapClickListener onMapClickListener) throws MapNotExistApiException {
        GoogleMapEventListener googleMapEventListener = this.f10752k;
        if (googleMapEventListener != null) {
            googleMapEventListener.addOnMapClickListener(onMapClickListener);
        }
    }

    public void removeOnMapClickListener(OnMapClickListener onMapClickListener) throws MapNotExistApiException {
        GoogleMapEventListener googleMapEventListener = this.f10752k;
        if (googleMapEventListener != null) {
            googleMapEventListener.removeOnMapClickListener(onMapClickListener);
        }
    }

    public void addOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) throws MapNotExistApiException {
        GoogleMapEventListener googleMapEventListener = this.f10752k;
        if (googleMapEventListener != null) {
            googleMapEventListener.addOnMapLongClickListener(onMapLongClickListener);
        }
    }

    public void removeOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) throws MapNotExistApiException {
        GoogleMapEventListener googleMapEventListener = this.f10752k;
        if (googleMapEventListener != null) {
            googleMapEventListener.removeOnMapLongClickListener(onMapLongClickListener);
        }
    }
}
