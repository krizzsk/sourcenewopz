package com.didi.map.global.component.myLocation.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.SensorManager;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.ImageUtil;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.security.wireless.ISecurityConf;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class MyLocationMarker {

    /* renamed from: a */
    private static final String f26077a = "MyLocationMarker";

    /* renamed from: b */
    private static final String f26078b = "map_location_arrow_tag";

    /* renamed from: c */
    private static final String f26079c = "map_location_avator_tag";

    /* renamed from: d */
    private Context f26080d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Map f26081e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Marker f26082f;

    /* renamed from: g */
    private MarkerOptions f26083g;

    /* renamed from: h */
    private MarkerOptions f26084h;

    /* renamed from: i */
    private LocationAccuracyCircle f26085i;

    /* renamed from: j */
    private ValueAnimator f26086j;
    public Marker mAvatarBase;

    public MyLocationMarker(MyLocationMarkerOptions myLocationMarkerOptions) {
        if (myLocationMarkerOptions != null && myLocationMarkerOptions.getMap() != null) {
            Map map = myLocationMarkerOptions.getMap();
            this.f26081e = map;
            this.f26080d = map.getContext();
            int i = myLocationMarkerOptions.getzIndex();
            if (((SensorManager) this.f26080d.getSystemService(ISecurityConf.KEY_SENSOR)).getDefaultSensor(3) != null) {
                BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(this.f26080d, myLocationMarkerOptions.getArrowIcon() != 0 ? myLocationMarkerOptions.getArrowIcon() : R.drawable.map_icon_position_arrow);
                if (fromResource != null) {
                    Bitmap scaledBitmap = ImageUtil.getScaledBitmap(this.f26080d, fromResource.getBitmap());
                    this.f26083g = new MarkerOptions();
                    DLog.m7384d(f26077a, "have orientation sensor", new Object[0]);
                    this.f26083g.icon(BitmapDescriptorFactory.fromBitmap(scaledBitmap));
                    this.f26083g.clickable(false);
                    this.f26083g.anchor(0.5f, 0.5f);
                    this.f26083g.title("location");
                    this.f26083g.zIndex(i);
                    if (LocationHelper.getLastKnownLocation(this.f26080d) != null && this.f26083g.getPosition() == null) {
                        this.f26083g.position(new LatLng(LocationHelper.getLastKnownLocation(this.f26080d).getLatitude(), LocationHelper.getLastKnownLocation(this.f26080d).getLongitude()));
                    }
                }
            } else {
                DLog.m7384d(f26077a, "no orientation sensor", new Object[0]);
            }
            BitmapDescriptor fromResource2 = BitmapDescriptorFactory.fromResource(this.f26080d, myLocationMarkerOptions.getPositionIcon() != 0 ? myLocationMarkerOptions.getPositionIcon() : R.drawable.map_icon_position);
            if (fromResource2 != null) {
                Bitmap scaledBitmap2 = ImageUtil.getScaledBitmap(this.f26080d, fromResource2.getBitmap());
                MarkerOptions markerOptions = new MarkerOptions();
                this.f26084h = markerOptions;
                markerOptions.icon(BitmapDescriptorFactory.fromBitmap(scaledBitmap2));
                this.f26084h.anchor(0.5f, 0.5f);
                this.f26084h.title("location");
                this.f26084h.zIndex(i + 1);
                if (LocationHelper.getLastKnownLocation(this.f26080d) != null && this.f26084h.getPosition() == null) {
                    this.f26084h.position(new LatLng(LocationHelper.getLastKnownLocation(this.f26080d).getLatitude(), LocationHelper.getLastKnownLocation(this.f26080d).getLongitude()));
                }
            }
            m18499a(myLocationMarkerOptions);
        }
    }

    /* renamed from: a */
    private void m18499a(MyLocationMarkerOptions myLocationMarkerOptions) {
        if (myLocationMarkerOptions == null || myLocationMarkerOptions.getAccuracyCircleOptions() == null) {
            m18497a();
            return;
        }
        m18497a();
        LocationAccuracyCircle locationAccuracyCircle = new LocationAccuracyCircle(this.f26081e, myLocationMarkerOptions.getAccuracyCircleOptions());
        this.f26085i = locationAccuracyCircle;
        locationAccuracyCircle.show();
    }

    public void addSelf() {
        Map map = this.f26081e;
        if (map != null && this.f26082f == null) {
            MarkerOptions markerOptions = this.f26083g;
            if (markerOptions != null) {
                this.f26082f = map.addMarker(f26078b, markerOptions);
            }
            MarkerOptions markerOptions2 = this.f26084h;
            if (markerOptions2 != null) {
                this.mAvatarBase = this.f26081e.addMarker(f26079c, markerOptions2);
            }
            setVisible(false);
        }
    }

    public void removeSelf(boolean z, int i) {
        ValueAnimator valueAnimator = this.f26086j;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f26086j = null;
        }
        if (this.f26082f == null) {
            z = false;
        }
        if (z) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f26082f.getAlpha(), 0.0f});
            this.f26086j = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (MyLocationMarker.this.f26082f != null) {
                        MyLocationMarker.this.f26082f.setAlpha(floatValue);
                    }
                    if (MyLocationMarker.this.mAvatarBase != null) {
                        MyLocationMarker.this.mAvatarBase.setAlpha(floatValue);
                    }
                    if (valueAnimator.getAnimatedFraction() > 0.9f) {
                        if (MyLocationMarker.this.f26082f != null) {
                            MyLocationMarker.this.f26081e.remove(MyLocationMarker.this.f26082f);
                            Marker unused = MyLocationMarker.this.f26082f = null;
                        }
                        if (MyLocationMarker.this.mAvatarBase != null) {
                            MyLocationMarker.this.f26081e.remove(MyLocationMarker.this.mAvatarBase);
                            MyLocationMarker.this.mAvatarBase = null;
                        }
                    }
                }
            });
            this.f26086j.setDuration((long) i);
            this.f26086j.start();
        } else {
            Marker marker = this.f26082f;
            if (marker != null) {
                this.f26081e.remove(marker);
                this.f26082f = null;
            }
            Marker marker2 = this.mAvatarBase;
            if (marker2 != null) {
                this.f26081e.remove(marker2);
                this.mAvatarBase = null;
            }
        }
        m18497a();
    }

    /* renamed from: a */
    private void m18497a() {
        LocationAccuracyCircle locationAccuracyCircle = this.f26085i;
        if (locationAccuracyCircle != null) {
            locationAccuracyCircle.hide();
        }
    }

    public void updateAccuracyView(LatLng latLng, float f) {
        LocationAccuracyCircle locationAccuracyCircle = this.f26085i;
        if (locationAccuracyCircle != null) {
            locationAccuracyCircle.update(latLng, f);
        }
    }

    public void updatePosition(LatLng latLng) {
        if (latLng != null) {
            m18501b(latLng);
            m18498a(latLng);
        }
    }

    /* renamed from: a */
    private void m18498a(LatLng latLng) {
        Marker marker = this.f26082f;
        if (marker == null) {
            MarkerOptions markerOptions = this.f26083g;
            if (markerOptions != null) {
                markerOptions.position(latLng);
                Marker addMarker = this.f26081e.addMarker(f26078b, this.f26083g);
                this.f26082f = addMarker;
                if (addMarker != null) {
                    addMarker.setVisible(true);
                }
            }
        } else if (!latLng.equals(marker.getPosition())) {
            this.f26082f.setPosition(latLng);
        }
    }

    /* renamed from: b */
    private void m18501b(LatLng latLng) {
        Marker marker = this.mAvatarBase;
        if (marker == null) {
            MarkerOptions markerOptions = this.f26084h;
            if (markerOptions != null) {
                markerOptions.position(latLng);
                Marker addMarker = this.f26081e.addMarker(f26079c, this.f26084h);
                this.mAvatarBase = addMarker;
                if (addMarker != null) {
                    addMarker.setVisible(true);
                }
            }
        } else if (!latLng.equals(marker.getPosition())) {
            this.mAvatarBase.setPosition(latLng);
        }
    }

    public void updateArrowRotateAngle(float f) {
        Marker marker;
        if (this.f26083g != null && (marker = this.f26082f) != null && ((double) Math.abs(f - marker.getRotation())) > 0.8d) {
            this.f26083g.rotation(f);
            this.f26082f.setRotation(this.f26083g.getRotation());
        }
    }

    public List<IMapElement> getMarkers() {
        ArrayList arrayList = new ArrayList(2);
        Marker marker = this.f26082f;
        if (marker != null) {
            arrayList.add(marker);
        }
        Marker marker2 = this.mAvatarBase;
        if (marker2 != null) {
            arrayList.add(marker2);
        }
        return arrayList;
    }

    public boolean isVisible() {
        Marker marker = this.f26082f;
        if (marker == null || this.mAvatarBase == null || !marker.isVisible() || !this.mAvatarBase.isVisible()) {
            return false;
        }
        return true;
    }

    public void setVisible(boolean z) {
        Marker marker = this.f26082f;
        if (marker != null) {
            marker.setVisible(z);
        }
        Marker marker2 = this.mAvatarBase;
        if (marker2 != null) {
            marker2.setVisible(z);
        }
        LocationAccuracyCircle locationAccuracyCircle = this.f26085i;
        if (locationAccuracyCircle == null) {
            return;
        }
        if (z) {
            locationAccuracyCircle.show();
        } else {
            locationAccuracyCircle.hide();
        }
    }

    public void setZIndex(int i) {
        Marker marker = this.f26082f;
        if (marker != null) {
            marker.setZIndex(i);
        }
        Marker marker2 = this.mAvatarBase;
        if (marker2 != null) {
            marker2.setZIndex(i);
        }
    }
}
