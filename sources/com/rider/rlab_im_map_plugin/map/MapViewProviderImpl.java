package com.rider.rlab_im_map_plugin.map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.didi.rlab.uni_im_map.map.IMMapMarkerBubble;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.rider.rlab_im_map_plugin.ImMapActivity;
import com.rider.rlab_im_map_plugin.tool.ImMapUtils;

@ServiceProvider({IMapViewProvider.class})
public class MapViewProviderImpl implements IMapViewProvider {

    /* renamed from: a */
    private final Logger f55909a = LoggerFactory.getLogger("MapViewProviderImpl");

    /* renamed from: b */
    private ImMapView f55910b;

    public void setMapView(ImMapView imMapView) {
        this.f55910b = imMapView;
        this.f55909a.info("MapViewProviderImpl setMapView", new Object[0]);
    }

    public ImMapView getMapView() {
        return this.f55910b;
    }

    public void setHintView(int i, int i2, int i3, int i4) {
        if (getMapView() != null) {
            this.f55910b.setHintView(i, i2, i3, i4);
        }
        this.f55909a.info("MapViewProviderImpl setHintView", new Object[0]);
    }

    public void setMapRecenter() {
        if (getMapView() != null) {
            this.f55910b.setMapRecenter();
        }
        this.f55909a.info("MapViewProviderImpl setMapRecenter", new Object[0]);
    }

    public void setMapIMDropMarker(IMMapMarkerBubble iMMapMarkerBubble) {
        if (getMapView() != null && iMMapMarkerBubble != null) {
            String icon = iMMapMarkerBubble.getIcon();
            double lat = iMMapMarkerBubble.getLat();
            double lng = iMMapMarkerBubble.getLng();
            getMapView().setCamera(lat, lng);
            getMapView().setWaterMarker(icon, lat, lng);
        }
    }

    public void setMapCenterCoordinate() {
        if (getMapView() != null) {
            this.f55910b.setMapCenterCoordinate();
        }
        this.f55909a.info("MapViewProviderImpl setMapCenterCoordinate", new Object[0]);
    }

    public void startMapNavigation(double d, double d2) {
        Activity scanForActivity;
        this.f55909a.info("MapViewProviderImpl startMapNavigation", new Object[0]);
        ImMapView mapView = getMapView();
        if (mapView != null && (scanForActivity = ImMapUtils.scanForActivity(mapView.getContext())) != null && (scanForActivity instanceof ImMapActivity)) {
            ((ImMapActivity) scanForActivity).startMapNavigation(d, d2, "");
        }
    }

    public void goToGpsSetting() {
        this.f55909a.info("MapViewProviderImpl goToGpsSetting", new Object[0]);
        ImMapView mapView = getMapView();
        if (mapView != null && mapView.getContext() != null) {
            Context context = mapView.getContext();
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }
}
