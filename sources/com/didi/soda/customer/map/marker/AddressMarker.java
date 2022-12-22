package com.didi.soda.customer.map.marker;

import android.content.Context;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.MarkerOptions;
import com.didi.foundation.sdk.map.IMapView;
import com.taxis99.R;

public class AddressMarker extends AbsMarker {
    public static final String TAG_ADDRESS_MARKER = "tag_address_marker";

    public String getTag() {
        return TAG_ADDRESS_MARKER;
    }

    public AddressMarker(Context context, IMapView iMapView) {
        super(context, iMapView);
    }

    public void show(LatLng latLng) {
        if (latLng != null) {
            draw((MarkerOptions) new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(this.mContext, R.drawable.customer_skin_icon_address_anchor)).draggable(false).anchor(0.3f, 0.9f).zIndex(11).visible(true));
        }
    }
}
