package com.didi.soda.customer.map.marker;

import android.content.Context;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.MarkerOptions;
import com.didi.foundation.sdk.map.IMapView;
import com.didi.global.map.animation.transition.util.FramesUtil;
import java.util.ArrayList;

public class BusinessMarker extends AbsMarker {
    public static final String TAG_BUSINESS_MARKER = "tag_business_marker";

    public String getTag() {
        return TAG_BUSINESS_MARKER;
    }

    public BusinessMarker(Context context, IMapView iMapView) {
        super(context, iMapView);
    }

    public void show(LatLng latLng) {
        if (latLng != null) {
            draw((MarkerOptions) new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(this.mContext, FramesUtil.getBusinessInitialResourceId(this.mContext))).draggable(false).anchor(0.5f, 0.79f).zIndex(12).visible(true));
        }
    }

    public void attachToMap(LatLng latLng) {
        if (latLng != null) {
            if (!isExist() || getMarker() == null || getMarker().getOptions() == null) {
                draw((MarkerOptions) new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(this.mContext, FramesUtil.getBusinessInitialResourceId(this.mContext))).draggable(false).anchor(0.5f, 0.79f).size(10.0f).zIndex(12).visible(false));
            } else if (getMarker() != null) {
                getMarker().setPosition(latLng);
                getMarker().setVisible(false);
            }
        }
    }

    public void attachToMapWithAnim(LatLng latLng) {
        if (latLng != null) {
            if (!isExist() || getMarker() == null || getMarker().getOptions() == null) {
                draw((MarkerOptions) new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(this.mContext, FramesUtil.getBusinessFrames(this.mContext)[0])).draggable(false).anchor(0.5f, 0.79f).zIndex(12).visible(false));
            } else if (getMarker() != null) {
                getMarker().setPosition(latLng);
                getMarker().setVisible(false);
            }
        }
    }

    public void attachToMap(LatLng latLng, LatLng latLng2) {
        if (latLng != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(latLng);
            arrayList.add(latLng2);
            draw((MarkerOptions) new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(this.mContext, FramesUtil.getBusinessInitialResourceId(this.mContext))).draggable(false).anchor(0.5f, 0.79f).zIndex(12).visible(false), arrayList);
        }
    }
}
