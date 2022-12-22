package com.didi.soda.customer.map.marker;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.MapUtils;
import com.didi.foundation.sdk.map.IMapView;
import com.didi.global.map.animation.transition.util.FramesUtil;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.rpc.entity.Bubble;
import com.didi.soda.customer.map.InfoWindowOptions;
import com.didi.soda.customer.widget.map.MarkerInfoWindowView;

public class RiderMarker extends AbsMarker {
    public static final String TAG_RIDER_MARKER = "tag_rider_marker";

    /* renamed from: a */
    private MarkerInfoWindowView f41376a;

    public String getTag() {
        return "tag_rider_marker";
    }

    public void onAdd() {
    }

    public RiderMarker(Context context, IMapView iMapView) {
        super(context, iMapView);
    }

    public void show(LatLng latLng) {
        if (latLng != null) {
            draw((MarkerOptions) new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(this.mContext, FramesUtil.getDeliveryInitialResourceId(this.mContext))).draggable(false).anchor(0.5f, 0.5f).zIndex(13).visible(true));
        }
    }

    public void attachToMap(LatLng latLng) {
        if (latLng != null) {
            if (!isExist() || getMarker() == null || getMarker().getOptions() == null) {
                draw((MarkerOptions) new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(this.mContext, FramesUtil.getDeliveryInitialResourceId(this.mContext))).draggable(false).anchor(0.5f, 0.5f).zIndex(13).visible(false));
            } else if (getMarker() != null) {
                getMarker().setPosition(latLng);
                getMarker().setVisible(false);
            }
        }
    }

    public void updateInfoWindow(Bubble bubble, OnInfoWindowClickListener onInfoWindowClickListener) {
        if (bubble != null && (!TextUtils.isEmpty(bubble.getDistanceRich()) || !TextUtils.isEmpty(bubble.getEtaRich()))) {
            if (this.f41376a == null) {
                this.f41376a = new MarkerInfoWindowView(GlobalContext.getContext());
            }
            this.f41376a.updateView(bubble.getDistanceRich(), bubble.getEtaRich());
            if (this.mInfoWindow == null || this.mInfoWindow.getInfoWindowMarker() == null) {
                this.mInfoWindow = buildInfoWindow(GlobalContext.getContext(), new InfoWindowOptions.Builder(this.f41376a).setVisible(false).setZIndex(14).build());
            } else {
                this.mInfoWindow.getInfoWindowMarker().setIcon(GlobalContext.getContext(), BitmapDescriptorFactory.fromBitmap(MapUtils.getViewBitmap(this.f41376a)));
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
        if (this.f41376a != null && this.mInfoWindow != null) {
            super.showInfoWindow();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f41376a = null;
    }

    public void remove() {
        super.remove();
        this.f41376a = null;
    }
}
