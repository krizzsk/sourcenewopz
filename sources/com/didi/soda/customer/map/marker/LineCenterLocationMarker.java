package com.didi.soda.customer.map.marker;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.MapUtils;
import com.didi.foundation.sdk.map.IMapView;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.rpc.entity.Bubble;
import com.didi.soda.customer.map.InfoWindowOptions;
import com.didi.soda.customer.widget.map.MarkerInfoWindowView;

public class LineCenterLocationMarker extends AbsMarker {
    public static final String TAG_LINE_CENTER_MARKER = "tag_line_center_marker";

    /* renamed from: a */
    private MarkerInfoWindowView f41375a;

    public String getTag() {
        return TAG_LINE_CENTER_MARKER;
    }

    public void onAdd() {
    }

    public LineCenterLocationMarker(Context context, IMapView iMapView) {
        super(context, iMapView);
    }

    public void show(LatLng latLng) {
        if (latLng != null) {
            draw((MarkerOptions) new MarkerOptions().icon((BitmapDescriptor) null).alpha(0.0f).position(latLng).draggable(false).visible(true).zIndex(15));
        }
    }

    public void attachToMap(LatLng latLng) {
        if (latLng != null) {
            if (!isExist() || getMarker() == null || getMarker().getOptions() == null) {
                draw((MarkerOptions) new MarkerOptions().icon((BitmapDescriptor) null).alpha(0.0f).position(latLng).draggable(false).visible(false).zIndex(15));
            } else if (getMarker() != null) {
                getMarker().setPosition(latLng);
                getMarker().setVisible(false);
            }
        }
    }

    public void updateInfoWindow(Bubble bubble, OnInfoWindowClickListener onInfoWindowClickListener) {
        if (bubble != null && (!TextUtils.isEmpty(bubble.getDistanceRich()) || !TextUtils.isEmpty(bubble.getEtaRich()))) {
            if (this.f41375a == null) {
                this.f41375a = new MarkerInfoWindowView(GlobalContext.getContext());
            }
            this.f41375a.updateView(bubble.getDistanceRich(), bubble.getEtaRich());
            if (this.mInfoWindow == null || this.mInfoWindow.getInfoWindowMarker() == null) {
                this.mInfoWindow = buildInfoWindow(GlobalContext.getContext(), new InfoWindowOptions.Builder(this.f41375a).setVisible(false).setZIndex(14).build());
            } else {
                this.mInfoWindow.getInfoWindowMarker().setIcon(GlobalContext.getContext(), BitmapDescriptorFactory.fromBitmap(MapUtils.getViewBitmap(this.f41375a)));
                this.mInfoWindow.getInfoWindowMarker().setVisible(false);
            }
            if (this.mInfoWindow != null) {
                this.mInfoWindow.addOnInfoWindowClickListener(onInfoWindowClickListener);
            }
        } else if (this.mInfoWindow != null) {
            hideInfoWindow();
        }
    }

    public void showInfoWindow() {
        if (this.f41375a != null && this.mInfoWindow != null) {
            super.showInfoWindow();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f41375a = null;
    }

    public void remove() {
        super.remove();
        this.f41375a = null;
    }
}
