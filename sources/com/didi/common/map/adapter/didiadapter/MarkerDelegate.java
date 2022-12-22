package com.didi.common.map.adapter.didiadapter;

import android.content.Context;
import com.didi.common.map.adapter.didiadapter.converter.Converter;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.internal.IMarkerDelegate;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.model.animation.AnimationListener;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.model.Marker;
import com.didi.map.outer.model.animation.Animation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MarkerDelegate implements IMarkerDelegate {

    /* renamed from: a */
    private Marker f10720a;

    /* renamed from: b */
    private MarkerOptions f10721b;

    /* renamed from: c */
    private DidiMap f10722c;

    /* renamed from: a */
    private float m7320a(float f) {
        return 360.0f - f;
    }

    public MarkerDelegate(Marker marker, MarkerOptions markerOptions, DidiMap didiMap) {
        this.f10722c = didiMap;
        this.f10720a = marker;
        this.f10721b = markerOptions;
    }

    public void remove() throws MapNotExistApiException {
        Marker marker = this.f10720a;
        if (marker != null) {
            if (marker.isInfoWindowShown()) {
                this.f10720a.hideInfoWindow();
            }
            this.f10720a.remove();
            this.f10720a = null;
        }
        this.f10721b = null;
    }

    public String getId() throws MapNotExistApiException {
        Marker marker = this.f10720a;
        if (marker == null) {
            return null;
        }
        return marker.getId();
    }

    public void setPosition(LatLng latLng) throws MapNotExistApiException {
        Marker marker = this.f10720a;
        if (marker != null) {
            marker.setPosition(Converter.convertToDidiLatLng(latLng));
            MarkerOptions markerOptions = this.f10721b;
            if (markerOptions != null) {
                markerOptions.position(latLng);
            }
        }
    }

    public void setTitle(String str) throws MapNotExistApiException {
        Marker marker = this.f10720a;
        if (marker != null) {
            marker.setTitle(str);
            MarkerOptions markerOptions = this.f10721b;
            if (markerOptions != null) {
                markerOptions.title(str);
            }
        }
    }

    public void setSnippet(String str) throws MapNotExistApiException {
        Marker marker = this.f10720a;
        if (marker != null) {
            marker.setSnippet(str);
            MarkerOptions markerOptions = this.f10721b;
            if (markerOptions != null) {
                markerOptions.snippet(str);
            }
        }
    }

    public void setDraggable(boolean z) throws MapNotExistApiException {
        Marker marker = this.f10720a;
        if (marker != null) {
            marker.setDraggable(z);
            MarkerOptions markerOptions = this.f10721b;
            if (markerOptions != null) {
                markerOptions.draggable(z);
            }
        }
    }

    public void setVisible(boolean z) throws MapNotExistApiException {
        Marker marker = this.f10720a;
        if (marker != null) {
            marker.setVisible(z);
            MarkerOptions markerOptions = this.f10721b;
            if (markerOptions != null) {
                markerOptions.visible(z);
            }
        }
    }

    public boolean isVisible() throws MapNotExistApiException {
        Marker marker = this.f10720a;
        if (marker == null) {
            return false;
        }
        return marker.isVisible();
    }

    public void setAnchor(float f, float f2) throws MapNotExistApiException {
        Marker marker = this.f10720a;
        if (marker != null) {
            marker.setAnchor(f, f2);
            MarkerOptions markerOptions = this.f10721b;
            if (markerOptions != null) {
                markerOptions.anchor(f, f2);
            }
        }
    }

    public void setFlat(boolean z) throws MapNotExistApiException {
        MarkerOptions markerOptions = this.f10721b;
        if (markerOptions != null) {
            markerOptions.flat(z);
        }
    }

    public void setIcon(Context context, BitmapDescriptor bitmapDescriptor) throws MapNotExistApiException {
        if (this.f10720a != null) {
            com.didi.map.outer.model.BitmapDescriptor convertToDidiBitmapDescriptor = Converter.convertToDidiBitmapDescriptor(bitmapDescriptor);
            if (convertToDidiBitmapDescriptor != null) {
                this.f10720a.setIcon(convertToDidiBitmapDescriptor);
            }
            MarkerOptions markerOptions = this.f10721b;
            if (markerOptions != null) {
                markerOptions.icon(bitmapDescriptor);
            }
        }
    }

    public void setRotation(float f) throws MapNotExistApiException {
        Marker marker = this.f10720a;
        if (marker != null) {
            marker.setRotateAngle(f);
            MarkerOptions markerOptions = this.f10721b;
            if (markerOptions != null) {
                markerOptions.rotation(f);
            }
        }
    }

    public void setAlpha(float f) throws MapNotExistApiException {
        Marker marker = this.f10720a;
        if (marker != null) {
            marker.setAlpha(f);
            MarkerOptions markerOptions = this.f10721b;
            if (markerOptions != null) {
                markerOptions.alpha(f);
            }
        }
    }

    public void setZIndex(int i) throws MapNotExistApiException {
        Marker marker = this.f10720a;
        if (marker != null) {
            marker.setZIndex((float) i);
            MarkerOptions markerOptions = this.f10721b;
            if (markerOptions != null) {
                markerOptions.zIndex(i);
            }
        }
    }

    public int getZIndex() throws MapNotExistApiException {
        MarkerOptions markerOptions = this.f10721b;
        if (markerOptions != null) {
            return markerOptions.getZIndex();
        }
        return 0;
    }

    public boolean isClickable() throws MapNotExistApiException {
        Marker marker = this.f10720a;
        if (marker == null) {
            return false;
        }
        return marker.isClickable();
    }

    public void setClickable(boolean z) {
        Marker marker = this.f10720a;
        if (marker != null) {
            marker.setClickable(z);
            MarkerOptions markerOptions = this.f10721b;
            if (markerOptions != null) {
                markerOptions.clickable(z);
            }
        }
    }

    public Object getElement() {
        return this.f10720a;
    }

    public List<LatLng> getBounderPoints() throws MapNotExistApiException {
        if (this.f10722c == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<com.didi.map.outer.model.LatLng> bounderPoints = this.f10722c.getBounderPoints(this.f10720a);
        if (CollectionUtil.isEmpty((Collection<?>) bounderPoints) || bounderPoints.size() != 2) {
            if (bounderPoints != null) {
                arrayList.addAll(bounderPoints);
            }
            DLog.m7384d("getBounderPoints error ", "返回边界点错误", new Object[0]);
        } else {
            com.didi.map.outer.model.LatLng latLng = bounderPoints.get(0);
            com.didi.map.outer.model.LatLng latLng2 = bounderPoints.get(1);
            arrayList.add(new com.didi.map.outer.model.LatLng(latLng.latitude, latLng.longitude));
            arrayList.add(new com.didi.map.outer.model.LatLng(latLng.latitude, latLng2.longitude));
            arrayList.add(new com.didi.map.outer.model.LatLng(latLng2.latitude, latLng.longitude));
            arrayList.add(new com.didi.map.outer.model.LatLng(latLng2.latitude, latLng2.longitude));
        }
        return Converter.convertFromDidiLatLngs(arrayList);
    }

    public boolean isDraggable() throws MapNotExistApiException {
        Marker marker = this.f10720a;
        if (marker != null) {
            return marker.isDraggable();
        }
        return false;
    }

    public boolean isFlat() throws MapNotExistApiException {
        MarkerOptions markerOptions = this.f10721b;
        if (markerOptions != null) {
            return markerOptions.isFlat();
        }
        return false;
    }

    public float getRotation() {
        Marker marker = this.f10720a;
        if (marker != null) {
            return marker.getRotateAngle();
        }
        return 0.0f;
    }

    public LatLng getPosition() {
        Marker marker = this.f10720a;
        if (marker != null) {
            return Converter.convertFromDidiLatLng(marker.getPosition());
        }
        return null;
    }

    public String getSnippet() {
        Marker marker = this.f10720a;
        if (marker != null) {
            return marker.getSnippet();
        }
        return null;
    }

    public String getTitle() {
        Marker marker = this.f10720a;
        if (marker != null) {
            return marker.getTitle();
        }
        return null;
    }

    public BitmapDescriptor getIcon() {
        MarkerOptions markerOptions = this.f10721b;
        if (markerOptions != null) {
            return markerOptions.getIcon();
        }
        return null;
    }

    public float getAlpha() {
        Marker marker = this.f10720a;
        if (marker != null) {
            return marker.getAlpha();
        }
        return 0.0f;
    }

    public void setOptions(IMapElementOptions iMapElementOptions) {
        Marker marker = this.f10720a;
        if (marker != null && iMapElementOptions != null && (iMapElementOptions instanceof MarkerOptions)) {
            MarkerOptions markerOptions = (MarkerOptions) iMapElementOptions;
            this.f10721b = markerOptions;
            marker.setMarkerOptions(Converter.convertToDidiMarkerOption(markerOptions));
        }
    }

    public IMapElementOptions getOptions() {
        return this.f10721b;
    }

    public void setAnimationListener(final AnimationListener animationListener) throws MapNotExistApiException {
        C44631 r3;
        Marker marker = this.f10720a;
        if (marker != null) {
            if (animationListener == null) {
                r3 = null;
            } else {
                r3 = new Animation.AnimationListener() {
                    public void onAnimationStart() {
                        animationListener.onAnimationStart();
                    }

                    public void onAnimationEnd() {
                        animationListener.onAnimationEnd();
                    }
                };
            }
            marker.setAnimationListener(r3);
        }
    }

    public void startAnimation(com.didi.common.map.model.animation.Animation animation) throws MapNotExistApiException {
        Marker marker = this.f10720a;
        if (marker != null) {
            marker.setAnimation(Converter.convertToDidiAnimation(animation));
            this.f10720a.startAnimation();
        }
    }
}
