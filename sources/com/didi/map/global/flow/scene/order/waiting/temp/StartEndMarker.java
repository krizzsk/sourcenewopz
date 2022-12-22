package com.didi.map.global.flow.scene.order.waiting.temp;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.didi.common.map.MapView;
import com.didi.common.map.Projection;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.listener.OnMarkerClickListener;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.MapUtils;
import com.didi.map.global.flow.model.StartEndMarkerModel;
import com.didi.map.global.flow.widget.AddressNameMarkerWrapper;
import com.didichuxing.omega.sdk.Omega;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class StartEndMarker {

    /* renamed from: a */
    private MapView f26968a;

    /* renamed from: b */
    private Marker f26969b;

    /* renamed from: c */
    private Marker f26970c;

    /* renamed from: d */
    private boolean f26971d = false;

    /* renamed from: e */
    private AddressNameMarkerWrapper f26972e;

    /* renamed from: f */
    private AddressNameMarkerWrapper f26973f;

    /* renamed from: g */
    private StartEndMarkerModel f26974g = new StartEndMarkerModel();

    public StartEndMarker(MapView mapView) {
        this.f26968a = mapView;
    }

    public List<IMapElement> getStartMapElements() {
        ArrayList arrayList = new ArrayList();
        Marker marker = this.f26969b;
        if (marker != null) {
            arrayList.add(marker);
        }
        AddressNameMarkerWrapper addressNameMarkerWrapper = this.f26972e;
        if (addressNameMarkerWrapper != null) {
            arrayList.addAll(addressNameMarkerWrapper.getMapElements());
        }
        return arrayList;
    }

    public List<IMapElement> getEndMapElements() {
        ArrayList arrayList = new ArrayList();
        Marker marker = this.f26970c;
        if (marker != null) {
            arrayList.add(marker);
        }
        AddressNameMarkerWrapper addressNameMarkerWrapper = this.f26973f;
        if (addressNameMarkerWrapper != null) {
            arrayList.addAll(addressNameMarkerWrapper.getMapElements());
        }
        return arrayList;
    }

    public void update(StartEndMarkerModel startEndMarkerModel) {
        if (this.f26968a != null && startEndMarkerModel != null) {
            m19035a();
            updateStartMarker(startEndMarkerModel.start, startEndMarkerModel.startAddressName, startEndMarkerModel.startIcon, startEndMarkerModel.sAnchorU, startEndMarkerModel.sAnchorV);
            updateEndMarker(startEndMarkerModel.end, startEndMarkerModel.endAddressName, startEndMarkerModel.endIcon, startEndMarkerModel.eAnchorU, startEndMarkerModel.eAnchorV);
            this.f26974g = startEndMarkerModel;
            this.f26971d = false;
        }
    }

    public void destroy() {
        m19035a();
    }

    public void updateStartMarker(LatLng latLng, String str, Bitmap bitmap, float f, float f2) {
        StartEndMarkerModel startEndMarkerModel;
        StartEndMarkerModel startEndMarkerModel2;
        if (latLng != null && bitmap != null) {
            if (this.f26969b == null || (startEndMarkerModel2 = this.f26974g) == null) {
                if (this.f26969b != null) {
                    this.f26968a.getMap().remove(this.f26969b);
                }
                this.f26969b = this.f26968a.getMap().addMarker(m19034a(latLng, bitmap, 102, f, f2));
            } else if (startEndMarkerModel2.startIcon != bitmap || !latLng.equals(this.f26974g.start)) {
                this.f26969b.setPosition(latLng);
                this.f26969b.setIcon(this.f26968a.getContext(), BitmapDescriptorFactory.fromBitmap(bitmap));
            }
            if (this.f26972e == null || (startEndMarkerModel = this.f26974g) == null) {
                AddressNameMarkerWrapper addressNameMarkerWrapper = this.f26972e;
                if (addressNameMarkerWrapper != null) {
                    addressNameMarkerWrapper.removeFromMap(this.f26968a.getMap());
                }
                if (!TextUtils.isEmpty(str)) {
                    AddressNameMarkerWrapper addressNameMarkerWrapper2 = new AddressNameMarkerWrapper(this.f26968a.getContext(), latLng, str);
                    this.f26972e = addressNameMarkerWrapper2;
                    addressNameMarkerWrapper2.addToMap(this.f26968a.getMap());
                }
            } else if (!TextUtils.equals(str, startEndMarkerModel.startAddressName) || !latLng.equals(this.f26974g.start)) {
                this.f26972e.removeFromMap(this.f26968a.getMap());
                if (!TextUtils.isEmpty(str)) {
                    AddressNameMarkerWrapper addressNameMarkerWrapper3 = new AddressNameMarkerWrapper(this.f26968a.getContext(), latLng, str);
                    this.f26972e = addressNameMarkerWrapper3;
                    addressNameMarkerWrapper3.addToMap(this.f26968a.getMap());
                }
            }
            this.f26974g.start = latLng;
            this.f26974g.startAddressName = str;
            this.f26974g.startIcon = bitmap;
        }
    }

    public boolean updateEndMarker(LatLng latLng, String str, Bitmap bitmap, float f, float f2) {
        StartEndMarkerModel startEndMarkerModel;
        StartEndMarkerModel startEndMarkerModel2;
        if (latLng == null || bitmap == null) {
            return false;
        }
        if (this.f26970c == null || (startEndMarkerModel2 = this.f26974g) == null) {
            if (this.f26970c != null) {
                this.f26968a.getMap().remove(this.f26970c);
            }
            this.f26970c = this.f26968a.getMap().addMarker(m19034a(latLng, bitmap, 100, f, f2));
        } else if (startEndMarkerModel2.endIcon != bitmap || !latLng.equals(this.f26974g.end)) {
            this.f26970c.setPosition(latLng);
            this.f26970c.setIcon(this.f26968a.getContext(), BitmapDescriptorFactory.fromBitmap(bitmap));
        }
        if (this.f26973f == null || (startEndMarkerModel = this.f26974g) == null) {
            AddressNameMarkerWrapper addressNameMarkerWrapper = this.f26973f;
            if (addressNameMarkerWrapper != null) {
                addressNameMarkerWrapper.removeFromMap(this.f26968a.getMap());
            }
            if (!TextUtils.isEmpty(str)) {
                AddressNameMarkerWrapper addressNameMarkerWrapper2 = new AddressNameMarkerWrapper(this.f26968a.getContext(), latLng, str);
                this.f26973f = addressNameMarkerWrapper2;
                addressNameMarkerWrapper2.addToMap(this.f26968a.getMap());
            }
        } else if (!TextUtils.equals(str, startEndMarkerModel.endAddressName) || !latLng.equals(this.f26974g.end)) {
            this.f26973f.removeFromMap(this.f26968a.getMap());
            if (!TextUtils.isEmpty(str)) {
                AddressNameMarkerWrapper addressNameMarkerWrapper3 = new AddressNameMarkerWrapper(this.f26968a.getContext(), latLng, str);
                this.f26973f = addressNameMarkerWrapper3;
                addressNameMarkerWrapper3.addToMap(this.f26968a.getMap());
            }
        }
        this.f26974g.end = latLng;
        this.f26974g.endAddressName = str;
        this.f26974g.endIcon = bitmap;
        return true;
    }

    public boolean showStartMarkerInfoWindow(View view, InfoWindow.Position position) {
        MapView mapView;
        if (this.f26969b == null || view == null || (mapView = this.f26968a) == null || mapView.getMap() == null) {
            return false;
        }
        if (this.f26969b.getId() == null) {
            return true;
        }
        InfoWindow buildInfoWindow = this.f26969b.buildInfoWindow(this.f26968a.getMap(), this.f26968a.getContext().getApplicationContext());
        if (position != null) {
            buildInfoWindow.setPosition(position);
        }
        buildInfoWindow.showInfoWindow(view);
        if (buildInfoWindow.getInfoWindowMarker() == null || TextUtils.isEmpty(buildInfoWindow.getInfoWindowMarker().getId())) {
            return true;
        }
        buildInfoWindow.getInfoWindowMarker().setZIndex(106);
        return true;
    }

    public void setOnStartMarkerClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        Marker marker;
        if (onInfoWindowClickListener != null && (marker = this.f26969b) != null && marker.getInfoWindow() != null) {
            this.f26969b.getInfoWindow().addOnInfoWindowClickListener(onInfoWindowClickListener);
        }
    }

    public void hideStartMarkerInfoWindow() {
        Marker marker = this.f26969b;
        if (marker != null && marker.getInfoWindow() != null) {
            this.f26969b.getInfoWindow().removeOnInfoWindowClickListener();
            this.f26969b.hideInfoWindow();
        }
    }

    public boolean showEndMarkerInfoWindow(View view, InfoWindow.Position position) {
        Marker marker;
        if (this.f26968a == null || (marker = this.f26970c) == null || view == null) {
            return false;
        }
        if (marker.getId() != null) {
            InfoWindow buildInfoWindow = this.f26970c.buildInfoWindow(this.f26968a.getMap(), this.f26968a.getContext().getApplicationContext());
            if (position != null) {
                buildInfoWindow.setPosition(position);
            }
            buildInfoWindow.showInfoWindow(view);
            if (buildInfoWindow.getInfoWindowMarker() == null || TextUtils.isEmpty(buildInfoWindow.getInfoWindowMarker().getId())) {
                Omega.trackError("nullWorn", "403", "end infoWindow is null");
            } else {
                buildInfoWindow.getInfoWindowMarker().setZIndex(104);
            }
        }
        this.f26971d = true;
        return true;
    }

    public void setOnEndMarkerClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        Marker marker;
        if (onInfoWindowClickListener != null && (marker = this.f26970c) != null && marker.getInfoWindow() != null) {
            this.f26970c.getInfoWindow().addOnInfoWindowClickListener(onInfoWindowClickListener);
        }
    }

    public void hideEndMarkerInfoWindow() {
        Marker marker;
        if (this.f26968a != null && (marker = this.f26970c) != null && this.f26971d) {
            if (!(marker == null || marker.getInfoWindow() == null)) {
                this.f26970c.getInfoWindow().removeOnInfoWindowClickListener();
                this.f26970c.hideInfoWindow();
            }
            this.f26971d = false;
        }
    }

    /* renamed from: a */
    private void m19035a() {
        MapView mapView = this.f26968a;
        if (mapView != null) {
            if (this.f26969b != null) {
                mapView.getMap().remove(this.f26969b);
                this.f26969b = null;
            }
            if (this.f26970c != null) {
                this.f26968a.getMap().remove(this.f26970c);
                this.f26970c = null;
            }
            AddressNameMarkerWrapper addressNameMarkerWrapper = this.f26972e;
            if (addressNameMarkerWrapper != null) {
                addressNameMarkerWrapper.removeFromMap(this.f26968a.getMap());
                this.f26972e = null;
            }
            AddressNameMarkerWrapper addressNameMarkerWrapper2 = this.f26973f;
            if (addressNameMarkerWrapper2 != null) {
                addressNameMarkerWrapper2.removeFromMap(this.f26968a.getMap());
                this.f26973f = null;
            }
        }
    }

    /* renamed from: a */
    private MarkerOptions m19034a(LatLng latLng, Bitmap bitmap, int i, float f, float f2) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng).anchor(f, f2).icon(BitmapDescriptorFactory.fromBitmap(bitmap)).draggable(false).zIndex(i);
        return markerOptions;
    }

    /* renamed from: a */
    private static Bitmap m19033a(Context context, View view, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.mfv_marker_info_window, (ViewGroup) null);
        ((ImageView) inflate.findViewById(R.id.mfv_info_window)).setImageBitmap(MapUtils.getViewBitmap(view));
        ((ImageView) inflate.findViewById(R.id.mfv_marker)).setImageBitmap(BitmapDescriptorFactory.fromResource(context, i).getBitmap());
        return MapUtils.getViewBitmap(inflate);
    }

    public void setMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        MapView mapView = this.f26968a;
        if (mapView != null) {
            mapView.getMap().addOnMarkerClickListener(onMarkerClickListener);
        }
    }

    /* renamed from: b */
    private boolean m19037b() {
        if (this.f26969b == null || this.f26970c == null) {
            return false;
        }
        Projection projection = this.f26968a.getMap().getProjection();
        if (projection.toScreenLocation(this.f26969b.getPosition()).x < projection.toScreenLocation(this.f26970c.getPosition()).x) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private boolean m19038c() {
        if (this.f26969b == null || this.f26970c == null) {
            return false;
        }
        Projection projection = this.f26968a.getMap().getProjection();
        if (projection.toScreenLocation(this.f26969b.getPosition()).y < projection.toScreenLocation(this.f26970c.getPosition()).y) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private int m19031a(Marker marker) {
        int i = marker.getMarkerSize().height + 0;
        InfoWindow infoWindow = marker.getInfoWindow();
        return infoWindow != null ? i + infoWindow.getInfoWindowMarker().getMarkerSize().height : i;
    }

    /* renamed from: b */
    private int m19036b(Marker marker) {
        int i = marker.getMarkerSize().width;
        InfoWindow infoWindow = marker.getInfoWindow();
        if (infoWindow != null) {
            i = infoWindow.getInfoWindowMarker().getMarkerSize().width;
        }
        return i / 2;
    }

    /* renamed from: a */
    private int m19032a(Marker marker, AddressNameMarkerWrapper addressNameMarkerWrapper) {
        int i = marker.getMarkerSize().width / 2;
        InfoWindow infoWindow = marker.getInfoWindow();
        if (infoWindow == null) {
            return addressNameMarkerWrapper != null ? Math.max(i, addressNameMarkerWrapper.getTextWidth()) : i;
        }
        int i2 = infoWindow.getInfoWindowMarker().getMarkerSize().width / 2;
        if (addressNameMarkerWrapper != null) {
            i2 = Math.max(i2, addressNameMarkerWrapper.getTextWidth());
        }
        return i2;
    }

    public Bounds getStartEndMarkerBounds() {
        Bounds bounds = new Bounds();
        bounds.left = DisplayUtils.dp2px(this.f26968a.getContext(), 10.0f);
        bounds.right = bounds.left;
        bounds.top = bounds.left;
        bounds.bottom = bounds.left;
        if (m19037b()) {
            bounds.left += m19036b(this.f26969b);
            bounds.right += m19032a(this.f26970c, this.f26973f);
        } else {
            bounds.left += m19036b(this.f26970c);
            bounds.right += m19032a(this.f26969b, this.f26972e);
        }
        if (m19038c()) {
            bounds.top = m19031a(this.f26969b);
        } else {
            bounds.top = m19031a(this.f26970c);
        }
        return bounds;
    }

    public List<Marker> getMarkers() {
        ArrayList arrayList = new ArrayList();
        Marker marker = this.f26969b;
        if (marker != null) {
            arrayList.add(marker);
            if (this.f26969b.getInfoWindow() != null) {
                arrayList.add(this.f26969b.getInfoWindow().getInfoWindowMarker());
            }
        }
        AddressNameMarkerWrapper addressNameMarkerWrapper = this.f26972e;
        if (addressNameMarkerWrapper != null) {
            arrayList.add(addressNameMarkerWrapper.getMarker());
        }
        Marker marker2 = this.f26970c;
        if (marker2 != null) {
            arrayList.add(marker2);
            if (this.f26970c.getInfoWindow() != null) {
                arrayList.add(this.f26970c.getInfoWindow().getInfoWindowMarker());
            }
        }
        AddressNameMarkerWrapper addressNameMarkerWrapper2 = this.f26973f;
        if (addressNameMarkerWrapper2 != null) {
            arrayList.add(addressNameMarkerWrapper2.getMarker());
        }
        return arrayList;
    }

    public LatLng getStartMarkerPosition() {
        Marker marker = this.f26969b;
        if (marker != null) {
            return marker.getPosition();
        }
        return new LatLng(0.0d, 0.0d);
    }

    public void hideEndMarker() {
        Marker marker = this.f26970c;
        if (marker != null) {
            marker.setVisible(false);
        }
    }

    public void showEndMarker() {
        Marker marker = this.f26970c;
        if (marker != null) {
            marker.setVisible(true);
        }
    }

    public class Bounds {
        public int bottom;
        public int left;
        public int right;
        public int top;

        public Bounds() {
        }
    }

    public Marker getStartIconMarker() {
        return this.f26969b;
    }
}
