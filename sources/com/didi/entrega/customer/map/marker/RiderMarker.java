package com.didi.entrega.customer.map.marker;

import android.content.Context;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.MarkerOptions;
import com.didi.foundation.sdk.map.IMapView;
import com.didi.global.map.animation.util.FramesUtil;

public class RiderMarker extends AbsMarker {
    public static final String TAG_RIDER_MARKER = "tag_rider_marker";

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
            draw((MarkerOptions) new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(this.mContext, FramesUtil.getDeliveryInitialResourceId(this.mContext))).draggable(false).anchor(0.5f, 0.7f).zIndex(13));
        }
    }

    public void updateIcon() {
        setIcon(this.mContext, BitmapDescriptorFactory.fromResource(this.mContext, FramesUtil.getDeliveryInitialResourceId(this.mContext)));
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
