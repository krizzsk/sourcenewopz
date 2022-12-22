package com.didi.soda.customer.map.marker;

import android.content.Context;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.MarkerOptions;
import com.didi.foundation.sdk.map.IMapView;
import com.didi.global.map.animation.transition.util.FramesUtil;

public class DestAddressMarker extends AbsMarker {
    public static final String TAG_DEST_ADDRESS_MARKER = "tag_dest_address_marker";

    public String getTag() {
        return TAG_DEST_ADDRESS_MARKER;
    }

    public DestAddressMarker(Context context, IMapView iMapView) {
        super(context, iMapView);
    }

    public void show(LatLng latLng) {
        if (latLng != null) {
            draw((MarkerOptions) new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(this.mContext, FramesUtil.getCustomerInitialResourceId())).draggable(false).anchor(0.5f, 0.79f).zIndex(11).visible(true));
        }
    }

    public void attachToMap(LatLng latLng) {
        if (latLng != null) {
            if (!isExist() || getMarker() == null || getMarker().getOptions() == null) {
                draw((MarkerOptions) new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(this.mContext, FramesUtil.getCustomerInitialResourceId())).draggable(false).anchor(0.5f, 0.79f).zIndex(11).visible(false));
            } else if (getMarker() != null) {
                getMarker().setPosition(latLng);
                getMarker().setVisible(false);
            }
        }
    }

    public void showWithAnim(LatLng latLng) {
        if (latLng != null) {
            draw((MarkerOptions) new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(this.mContext, FramesUtil.customer_frames[0])).draggable(false).anchor(0.5f, 0.79f).zIndex(11));
        }
    }
}
