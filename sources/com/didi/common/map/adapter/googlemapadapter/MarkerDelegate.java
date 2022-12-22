package com.didi.common.map.adapter.googlemapadapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import com.didi.common.map.adapter.googlemapadapter.converter.Converter;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.internal.IMarkerDelegate;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.model.animation.AlphaAnimation;
import com.didi.common.map.model.animation.Animation;
import com.didi.common.map.model.animation.AnimationListener;
import com.didi.common.map.model.animation.AnimationSet;
import com.didi.common.map.model.animation.RotateAnimation;
import com.didi.common.map.model.animation.ScaleAnimation;
import com.didi.common.map.model.animation.TranslateAnimation;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.SphericalUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MarkerDelegate implements IMarkerDelegate {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Marker f10768a;

    /* renamed from: b */
    private MarkerOptions f10769b;

    /* renamed from: c */
    private GoogleMap f10770c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AnimationListener f10771d;

    public boolean isClickable() throws MapNotExistApiException {
        return true;
    }

    public void setClickable(boolean z) {
    }

    public MarkerDelegate(Marker marker, MarkerOptions markerOptions, GoogleMap googleMap) {
        this.f10770c = googleMap;
        this.f10768a = marker;
        this.f10769b = markerOptions;
    }

    public void remove() throws MapNotExistApiException {
        Marker marker = this.f10768a;
        if (marker != null) {
            if (marker.isInfoWindowShown()) {
                this.f10768a.hideInfoWindow();
            }
            this.f10768a.remove();
            this.f10768a = null;
            this.f10769b = null;
        }
    }

    public String getId() throws MapNotExistApiException {
        Marker marker = this.f10768a;
        if (marker == null) {
            return null;
        }
        return marker.getId();
    }

    public void setPosition(LatLng latLng) throws MapNotExistApiException {
        if (this.f10768a != null) {
            MarkerOptions markerOptions = this.f10769b;
            if (markerOptions != null) {
                markerOptions.position(latLng);
            }
            this.f10768a.setPosition(Converter.convertToGoogleLatLng(latLng));
        }
    }

    public void setTitle(String str) throws MapNotExistApiException {
        Marker marker = this.f10768a;
        if (marker != null) {
            marker.setTitle(str);
            MarkerOptions markerOptions = this.f10769b;
            if (markerOptions != null) {
                markerOptions.title(str);
            }
        }
    }

    public void setSnippet(String str) throws MapNotExistApiException {
        Marker marker = this.f10768a;
        if (marker != null) {
            marker.setSnippet(str);
            MarkerOptions markerOptions = this.f10769b;
            if (markerOptions != null) {
                markerOptions.snippet(str);
            }
        }
    }

    public void setDraggable(boolean z) throws MapNotExistApiException {
        Marker marker = this.f10768a;
        if (marker != null) {
            marker.setDraggable(z);
            MarkerOptions markerOptions = this.f10769b;
            if (markerOptions != null) {
                markerOptions.draggable(z);
            }
        }
    }

    public void setVisible(boolean z) throws MapNotExistApiException {
        Marker marker = this.f10768a;
        if (marker != null) {
            marker.setVisible(z);
            MarkerOptions markerOptions = this.f10769b;
            if (markerOptions != null) {
                markerOptions.visible(z);
            }
        }
    }

    public boolean isVisible() throws MapNotExistApiException {
        Marker marker = this.f10768a;
        if (marker == null) {
            return false;
        }
        return marker.isVisible();
    }

    public void setAnchor(float f, float f2) throws MapNotExistApiException {
        Marker marker = this.f10768a;
        if (marker != null) {
            marker.setAnchor(f, f2);
            MarkerOptions markerOptions = this.f10769b;
            if (markerOptions != null) {
                markerOptions.anchor(f, f2);
            }
        }
    }

    public void setFlat(boolean z) throws MapNotExistApiException {
        Marker marker = this.f10768a;
        if (marker != null) {
            marker.setFlat(z);
            MarkerOptions markerOptions = this.f10769b;
            if (markerOptions != null) {
                markerOptions.flat(z);
            }
        }
    }

    public void setIcon(Context context, BitmapDescriptor bitmapDescriptor) throws MapNotExistApiException {
        Marker marker = this.f10768a;
        if (marker != null || marker.isVisible()) {
            com.google.android.gms.maps.model.BitmapDescriptor convertToGoogleBitmapDescriptor = Converter.convertToGoogleBitmapDescriptor(bitmapDescriptor);
            if (convertToGoogleBitmapDescriptor != null) {
                this.f10768a.setIcon(convertToGoogleBitmapDescriptor);
            }
            MarkerOptions markerOptions = this.f10769b;
            if (markerOptions != null) {
                markerOptions.icon(bitmapDescriptor);
            }
        }
    }

    public void setRotation(float f) throws MapNotExistApiException {
        Marker marker = this.f10768a;
        if (marker != null) {
            marker.setRotation(f);
            MarkerOptions markerOptions = this.f10769b;
            if (markerOptions != null) {
                markerOptions.rotation(f);
            }
        }
    }

    public void setAlpha(float f) throws MapNotExistApiException {
        Marker marker = this.f10768a;
        if (marker != null) {
            marker.setAlpha(f);
            MarkerOptions markerOptions = this.f10769b;
            if (markerOptions != null) {
                markerOptions.alpha(f);
            }
        }
    }

    public boolean isDraggable() throws MapNotExistApiException {
        Marker marker = this.f10768a;
        if (marker != null) {
            return marker.isDraggable();
        }
        return false;
    }

    public void setZIndex(int i) throws MapNotExistApiException {
        Marker marker = this.f10768a;
        if (marker != null) {
            marker.setZIndex((float) i);
            MarkerOptions markerOptions = this.f10769b;
            if (markerOptions != null) {
                markerOptions.zIndex(i);
            }
        }
    }

    public int getZIndex() throws MapNotExistApiException {
        Marker marker = this.f10768a;
        if (marker != null) {
            return (int) marker.getZIndex();
        }
        return 0;
    }

    public Object getElement() {
        return this.f10768a;
    }

    public void setOptions(IMapElementOptions iMapElementOptions) throws MapNotExistApiException {
        if (this.f10768a != null && iMapElementOptions != null && (iMapElementOptions instanceof MarkerOptions)) {
            MarkerOptions markerOptions = (MarkerOptions) iMapElementOptions;
            if (markerOptions.getTitle() != null) {
                this.f10768a.setTitle(markerOptions.getTitle());
            }
            if (markerOptions.getSnippet() != null) {
                this.f10768a.setSnippet(markerOptions.getSnippet());
            }
            com.google.android.gms.maps.model.LatLng convertToGoogleLatLng = Converter.convertToGoogleLatLng(markerOptions.getPosition());
            if (convertToGoogleLatLng != null) {
                this.f10768a.setPosition(convertToGoogleLatLng);
            }
            com.google.android.gms.maps.model.BitmapDescriptor convertToGoogleBitmapDescriptor = Converter.convertToGoogleBitmapDescriptor(markerOptions.getIcon());
            if (convertToGoogleBitmapDescriptor != null) {
                this.f10768a.setIcon(convertToGoogleBitmapDescriptor);
            }
            this.f10768a.setAnchor(markerOptions.getAnchorU(), markerOptions.getAnchorV());
            this.f10768a.setRotation(markerOptions.getRotation());
            this.f10768a.setAlpha(markerOptions.getAlpha());
            this.f10768a.setVisible(markerOptions.isVisible());
            this.f10768a.setZIndex((float) markerOptions.getZIndex());
            this.f10768a.setDraggable(markerOptions.isDraggable());
            this.f10768a.setFlat(markerOptions.isFlat());
            this.f10769b = markerOptions;
        }
    }

    public IMapElementOptions getOptions() {
        return this.f10769b;
    }

    public List<LatLng> getBounderPoints() throws MapNotExistApiException {
        Object tag = this.f10768a.getTag();
        ArrayList arrayList = new ArrayList();
        if (tag == null || !(tag instanceof com.didi.common.map.model.Marker)) {
            arrayList.add(Converter.convertFromGoogleLatLng(this.f10768a.getPosition()));
        } else {
            com.didi.common.map.model.Marker marker = (com.didi.common.map.model.Marker) tag;
            Marker.MarkerSize markerSize = marker.getMarkerSize();
            if (markerSize == null || markerSize.isEmpty()) {
                arrayList.add(Converter.convertFromGoogleLatLng(this.f10768a.getPosition()));
                return arrayList;
            }
            float anchorU = marker.getOptions().getAnchorU();
            float anchorV = marker.getOptions().getAnchorV();
            int i = (int) (((float) markerSize.width) * anchorU);
            int i2 = markerSize.width - i;
            int i3 = (int) (((float) markerSize.height) * anchorV);
            int i4 = markerSize.height - i3;
            if (!(marker.getInfoWindow() == null || marker.getInfoWindow().getInfoWindowMarker() == null)) {
                com.didi.common.map.model.Marker infoWindowMarker = marker.getInfoWindow().getInfoWindowMarker();
                Marker.MarkerSize markerSize2 = infoWindowMarker.getMarkerSize();
                int anchorU2 = (int) (((float) markerSize2.width) * infoWindowMarker.getOptions().getAnchorU());
                i = Math.max(i, anchorU2);
                i2 = Math.max(i2, markerSize2.width - anchorU2);
                i3 += markerSize2.height;
            }
            LatLng position = marker.getPosition();
            Projection projection = this.f10770c.getProjection();
            Point screenLocation = projection.toScreenLocation(Converter.convertToGoogleLatLng(position));
            Point point = new Point();
            point.x = screenLocation.x - i;
            point.y = screenLocation.y - i3;
            arrayList.add(Converter.convertFromGoogleLatLng(projection.fromScreenLocation(point)));
            point.x = screenLocation.x + i2;
            point.y = screenLocation.y - i3;
            arrayList.add(Converter.convertFromGoogleLatLng(projection.fromScreenLocation(point)));
            point.x = screenLocation.x - i;
            point.y = screenLocation.y + i4;
            arrayList.add(Converter.convertFromGoogleLatLng(projection.fromScreenLocation(point)));
            point.x = screenLocation.x + i2;
            point.y = screenLocation.y + i4;
            arrayList.add(Converter.convertFromGoogleLatLng(projection.fromScreenLocation(point)));
        }
        return arrayList;
    }

    public boolean isFlat() throws MapNotExistApiException {
        com.google.android.gms.maps.model.Marker marker = this.f10768a;
        if (marker != null) {
            return marker.isFlat();
        }
        return false;
    }

    public float getRotation() {
        com.google.android.gms.maps.model.Marker marker = this.f10768a;
        if (marker != null) {
            return marker.getRotation();
        }
        return 0.0f;
    }

    public LatLng getPosition() {
        com.google.android.gms.maps.model.Marker marker = this.f10768a;
        if (marker != null) {
            return Converter.convertFromGoogleLatLng(marker.getPosition());
        }
        return null;
    }

    public String getSnippet() {
        com.google.android.gms.maps.model.Marker marker = this.f10768a;
        if (marker != null) {
            return marker.getSnippet();
        }
        return null;
    }

    public String getTitle() {
        com.google.android.gms.maps.model.Marker marker = this.f10768a;
        if (marker != null) {
            return marker.getTitle();
        }
        return null;
    }

    public BitmapDescriptor getIcon() {
        MarkerOptions markerOptions = this.f10769b;
        if (markerOptions != null) {
            return markerOptions.getIcon();
        }
        return null;
    }

    public float getAlpha() {
        com.google.android.gms.maps.model.Marker marker = this.f10768a;
        if (marker != null) {
            return marker.getAlpha();
        }
        return 0.0f;
    }

    public void setAnimationListener(AnimationListener animationListener) throws MapNotExistApiException {
        this.f10771d = animationListener;
    }

    public void startAnimation(Animation animation) throws MapNotExistApiException {
        Animator a;
        if (this.f10768a != null && (a = m7334a(animation)) != null) {
            if (this.f10771d != null) {
                a.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationStart(Animator animator) {
                        if (MarkerDelegate.this.f10771d != null) {
                            MarkerDelegate.this.f10771d.onAnimationStart();
                        }
                    }

                    public void onAnimationEnd(Animator animator) {
                        if (MarkerDelegate.this.f10771d != null) {
                            MarkerDelegate.this.f10771d.onAnimationEnd();
                        }
                    }
                });
            }
            a.start();
        }
    }

    /* renamed from: a */
    private Animator m7334a(Animation animation) {
        AnimatorSet animatorSet = null;
        if (!(this.f10768a == null || animation == null)) {
            Animation.AnimationType type = animation.getType();
            if (type == Animation.AnimationType.ALPHA) {
                AlphaAnimation alphaAnimation = (AlphaAnimation) animation;
                final ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{alphaAnimation.getFromAlpha(), alphaAnimation.getToAlpha()});
                ofFloat.setDuration(alphaAnimation.getDuration());
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (MarkerDelegate.this.f10768a != null) {
                            MarkerDelegate.this.f10768a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            return;
                        }
                        ValueAnimator valueAnimator2 = ofFloat;
                        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                            ofFloat.cancel();
                            ofFloat.removeUpdateListener(this);
                        }
                    }
                });
                return ofFloat;
            } else if (type == Animation.AnimationType.SCALE) {
                ScaleAnimation scaleAnimation = (ScaleAnimation) animation;
                ValueAnimator.ofFloat(new float[]{scaleAnimation.getFromX(), scaleAnimation.getFromY()}).setDuration(scaleAnimation.getDuration());
                return null;
            } else if (type == Animation.AnimationType.TRANSLATE) {
                TranslateAnimation translateAnimation = (TranslateAnimation) animation;
                final ValueAnimator ofObject = ValueAnimator.ofObject(new LatLngTypeEvaluator(), new Object[]{this.f10768a.getPosition(), Converter.convertToGoogleLatLng(translateAnimation.getTarget())});
                ofObject.setDuration(translateAnimation.getDuration());
                ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (MarkerDelegate.this.f10768a == null) {
                            ValueAnimator valueAnimator2 = ofObject;
                            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                                ofObject.cancel();
                                ofObject.removeUpdateListener(this);
                            }
                        } else if (valueAnimator.getAnimatedValue() instanceof com.google.android.gms.maps.model.LatLng) {
                            com.google.android.gms.maps.model.LatLng latLng = (com.google.android.gms.maps.model.LatLng) valueAnimator.getAnimatedValue();
                            Object tag = MarkerDelegate.this.f10768a.getTag();
                            if (tag == null || !(tag instanceof com.didi.common.map.model.Marker)) {
                                MarkerDelegate.this.f10768a.setPosition(latLng);
                            } else {
                                ((com.didi.common.map.model.Marker) tag).setPosition(Converter.convertFromGoogleLatLng(latLng));
                            }
                        }
                    }
                });
                return ofObject;
            } else if (type == Animation.AnimationType.ROTATE) {
                RotateAnimation rotateAnimation = (RotateAnimation) animation;
                final ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{rotateAnimation.getFromDegree(), rotateAnimation.getToDegree()});
                ofFloat2.setDuration(rotateAnimation.getDuration());
                ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (MarkerDelegate.this.f10768a != null) {
                            MarkerDelegate.this.f10768a.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            return;
                        }
                        ValueAnimator valueAnimator2 = ofFloat2;
                        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                            ofFloat2.cancel();
                            ofFloat2.removeUpdateListener(this);
                        }
                    }
                });
                return ofFloat2;
            } else if (type == Animation.AnimationType.EMERGE) {
                return null;
            } else {
                if (type == Animation.AnimationType.SET) {
                    animatorSet = new AnimatorSet();
                    Iterator<Animation> it = ((AnimationSet) animation).getAllAnimations().iterator();
                    while (it.hasNext()) {
                        Animation next = it.next();
                        if (next != null) {
                            animatorSet.playTogether(new Animator[]{m7334a(next)});
                        }
                    }
                    animatorSet.setDuration(animation.getDuration());
                }
            }
        }
        return animatorSet;
    }

    private class LatLngTypeEvaluator implements TypeEvaluator<com.google.android.gms.maps.model.LatLng> {
        private LatLngTypeEvaluator() {
        }

        public com.google.android.gms.maps.model.LatLng evaluate(float f, com.google.android.gms.maps.model.LatLng latLng, com.google.android.gms.maps.model.LatLng latLng2) {
            return SphericalUtil.interpolate(latLng, latLng2, (double) f);
        }
    }
}
