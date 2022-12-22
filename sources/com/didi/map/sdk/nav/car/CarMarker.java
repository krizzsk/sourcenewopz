package com.didi.map.sdk.nav.car;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.sdk.nav.util.ApolloToggleUtils;
import java.util.List;

public class CarMarker implements IMapElement {

    /* renamed from: a */
    private static final String f28376a = "CarMarker";

    /* renamed from: b */
    private Context f28377b;

    /* renamed from: c */
    private Marker f28378c;

    /* renamed from: d */
    private boolean f28379d;

    /* renamed from: e */
    private int f28380e;

    /* renamed from: f */
    private float f28381f;

    /* renamed from: g */
    private BitmapDescriptor f28382g;

    /* renamed from: h */
    private BitmapDescriptor f28383h;

    public CarMarker(Context context, Marker marker) {
        this.f28377b = context;
        this.f28378c = marker;
    }

    public Marker getMarker() {
        return this.f28378c;
    }

    public void set3DCarEnabled(boolean z) {
        this.f28379d = z;
        m20114a();
        CarIconsPreloader.getInstance().set3DCarEnabled(z);
    }

    /* renamed from: a */
    private void m20114a() {
        Marker marker = this.f28378c;
        if (marker == null || this.f28377b == null) {
            DLog.m7384d("3dcar", "resizeFromMarkerToInfoWindowInterval() return", new Object[0]);
            return;
        }
        marker.setEnableTopHeightInterval(true);
        int dp2px = DisplayUtils.dp2px(this.f28377b, (float) ApolloToggleUtils.get3DCarHeightInterval());
        this.f28378c.setTopHeightInterval((float) dp2px);
        DLog.m7384d("3dcar", "resizeFromMarkerToInfoWindowInterval() topHeightInterval:" + dp2px, new Object[0]);
    }

    public void setOptions(IMapElementOptions iMapElementOptions) {
        Marker marker = this.f28378c;
        if (marker != null) {
            marker.setOptions(iMapElementOptions);
        }
    }

    public IMapElementOptions getOptions() {
        Marker marker = this.f28378c;
        if (marker != null) {
            return marker.getOptions();
        }
        return null;
    }

    public String getId() {
        Marker marker = this.f28378c;
        return marker != null ? marker.getId() : "null";
    }

    public void setZIndex(int i) {
        Marker marker = this.f28378c;
        if (marker != null) {
            marker.setZIndex(i);
        }
    }

    public int getZIndex() {
        Marker marker = this.f28378c;
        if (marker != null) {
            return marker.getZIndex();
        }
        return 0;
    }

    public void setVisible(boolean z) {
        Marker marker = this.f28378c;
        if (marker != null) {
            marker.setVisible(z);
        }
    }

    public boolean isVisible() {
        Marker marker = this.f28378c;
        if (marker != null) {
            return marker.isVisible();
        }
        return false;
    }

    public boolean isClickable() {
        Marker marker = this.f28378c;
        if (marker != null) {
            return marker.isClickable();
        }
        return false;
    }

    public List<LatLng> getBounderPoints() {
        Marker marker = this.f28378c;
        if (marker != null) {
            return marker.getBounderPoints();
        }
        return null;
    }

    public Object getElement() {
        Marker marker = this.f28378c;
        if (marker != null) {
            return marker.getElement();
        }
        return null;
    }

    public void remove() {
        destroy();
    }

    public void setBundle(Bundle bundle) {
        Marker marker = this.f28378c;
        if (marker != null) {
            marker.setBundle(bundle);
        }
    }

    public Bundle getBundle() {
        Marker marker = this.f28378c;
        if (marker != null) {
            return marker.getBundle();
        }
        return null;
    }

    public void setData(Object obj) {
        Marker marker = this.f28378c;
        if (marker != null) {
            marker.setData(obj);
        }
    }

    public Object getData() {
        Marker marker = this.f28378c;
        if (marker != null) {
            return marker.getData();
        }
        return null;
    }

    public void setIcon(Context context, BitmapDescriptor bitmapDescriptor) {
        Marker marker = this.f28378c;
        if (marker != null) {
            marker.setIcon(context, bitmapDescriptor);
        }
    }

    public BitmapDescriptor getIcon() {
        Marker marker = this.f28378c;
        if (marker != null) {
            return marker.getIcon();
        }
        return null;
    }

    public void setPosition(LatLng latLng) {
        Marker marker = this.f28378c;
        if (marker != null) {
            marker.setPosition(latLng);
        }
    }

    public LatLng getPosition() {
        Marker marker = this.f28378c;
        if (marker != null) {
            return marker.getPosition();
        }
        return null;
    }

    public int getLastIndex() {
        return this.f28380e;
    }

    public void setRotation(float f) {
        float f2 = f % 360.0f;
        if (f2 < 0.0f) {
            f2 += 360.0f;
        }
        this.f28381f = f2;
        if (this.f28379d) {
            int indexByAngle = CarAngleUtil.getIndexByAngle(f2);
            if (this.f28380e != indexByAngle) {
                this.f28380e = indexByAngle;
                BitmapDescriptor carBitmapDescriptor = CarAngleUtil.getCarBitmapDescriptor(this.f28377b, indexByAngle);
                if (carBitmapDescriptor != null) {
                    setIcon(this.f28377b, carBitmapDescriptor);
                } else {
                    DLog.m7384d(f28376a, "setRotation bitmapDescriptor = null", new Object[0]);
                }
            }
        } else {
            Marker marker = this.f28378c;
            if (marker != null) {
                marker.setRotation(f2);
            }
        }
    }

    public float getRotation() {
        if (this.f28379d) {
            return this.f28381f;
        }
        Marker marker = this.f28378c;
        if (marker != null) {
            return marker.getRotation();
        }
        return 0.0f;
    }

    public void setFlat(boolean z) {
        Marker marker = this.f28378c;
        if (marker != null) {
            marker.setFlat(z);
        }
    }

    public boolean isFlat() {
        Marker marker = this.f28378c;
        if (marker != null) {
            return marker.isFlat();
        }
        return false;
    }

    public InfoWindow buildInfoWindow(Map map, Context context) {
        Marker marker = this.f28378c;
        if (marker != null) {
            return marker.buildInfoWindow(map, context);
        }
        return null;
    }

    public InfoWindow buildInfoWindow(Map map, Context context, InfoWindow.Position position) {
        Marker marker = this.f28378c;
        if (marker != null) {
            return marker.buildInfoWindow(map, context, position);
        }
        return null;
    }

    public InfoWindow getInfoWindow() {
        Marker marker = this.f28378c;
        if (marker != null) {
            return marker.getInfoWindow();
        }
        return null;
    }

    public void destroy() {
        this.f28378c = null;
        this.f28382g = null;
        this.f28383h = null;
    }

    public void updateOriginIcon(BitmapDescriptor bitmapDescriptor) {
        if (DriverCarNewAnimApollo.getInstance().enable() && bitmapDescriptor != null && bitmapDescriptor.getBitmap() != null) {
            this.f28382g = bitmapDescriptor;
            this.f28383h = m20113a(bitmapDescriptor.getBitmap(), DriverCarNewAnimApollo.getInstance().getCarZoomRatio());
        }
    }

    /* renamed from: a */
    private BitmapDescriptor m20113a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        if (f == 1.0f) {
            try {
                return BitmapDescriptorFactory.fromBitmap(bitmap);
            } catch (Exception e) {
                DLog.m7384d(f28376a, "DriverCarAnim except: " + e.getMessage(), new Object[0]);
            }
        } else {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.preScale(f, f);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
            if (createBitmap != null) {
                return BitmapDescriptorFactory.fromBitmap(createBitmap);
            }
            return null;
        }
    }

    public void enlargeMarkerIcon() {
        Marker marker;
        BitmapDescriptor bitmapDescriptor;
        if (DriverCarNewAnimApollo.getInstance().enable() && (marker = this.f28378c) != null && marker.getIcon() != null && this.f28383h != null && this.f28378c.getIcon() != (bitmapDescriptor = this.f28383h)) {
            this.f28378c.setIcon(this.f28377b, bitmapDescriptor);
        }
    }

    public void restoreMarkerIcon() {
        Marker marker;
        BitmapDescriptor bitmapDescriptor;
        if (DriverCarNewAnimApollo.getInstance().enable() && (marker = this.f28378c) != null && marker.getIcon() != null && this.f28382g != null && this.f28378c.getIcon() != (bitmapDescriptor = this.f28382g)) {
            this.f28378c.setIcon(this.f28377b, bitmapDescriptor);
        }
    }
}
