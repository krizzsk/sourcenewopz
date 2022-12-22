package com.rider.rlab_im_map_plugin.marker;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.common.map.Map;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.util.ImageUtil;
import com.taxis99.R;

public class TargetMarker extends AbsBaseMarker {

    /* renamed from: a */
    private static final String f55931a = "map_location_im_target_marker";

    /* renamed from: b */
    private final Map f55932b;

    /* renamed from: c */
    private FrameLayout f55933c;

    /* renamed from: d */
    private LatLng f55934d;
    public Marker marker;

    public TargetMarker(Map map) {
        this.f55932b = map;
        Context context = map.getContext();
        BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(context, R.drawable.rider_im_water_icon);
        if (fromResource != null) {
            Bitmap scaledBitmap = ImageUtil.getScaledBitmap(context, fromResource.getBitmap());
            ImageView imageView = new ImageView(context);
            imageView.setImageBitmap(scaledBitmap);
            FrameLayout frameLayout = new FrameLayout(context);
            this.f55933c = frameLayout;
            frameLayout.addView(imageView);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = 134;
            layoutParams.height = 160;
            layoutParams.gravity = 17;
            imageView.setLayoutParams(layoutParams);
        }
    }

    public Map getMap() {
        return this.f55932b;
    }

    public void addMarker() {
        FrameLayout frameLayout;
        Map map = this.f55932b;
        if (map != null && (frameLayout = this.f55933c) != null) {
            map.setTopViewToCenter(frameLayout, 0.5f, 0.5f);
        }
    }

    public void removeMarker() {
        Map map = this.f55932b;
        if (map != null) {
            map.removeTopView();
        }
    }

    public void updatePosition(LatLng latLng) {
        if (latLng != null && latLng.longitude != 0.0d && latLng.latitude != 0.0d) {
            this.f55934d = latLng;
        }
    }

    public Marker getMarker() {
        return this.marker;
    }

    public LatLng getLatLng() {
        return this.f55934d;
    }
}
