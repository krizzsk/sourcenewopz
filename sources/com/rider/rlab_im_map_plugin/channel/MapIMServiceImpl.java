package com.rider.rlab_im_map_plugin.channel;

import android.app.Activity;
import android.content.Context;
import com.didi.beatles.p099im.event.IMSendAddressEvent;
import com.didi.beatles.p099im.module.entity.IMAddress;
import com.didi.beatles.p099im.protocol.host.IMHostLoader;
import com.didi.beatles.p099im.protocol.host.IMHostService;
import com.didi.common.map.util.DisplayUtils;
import com.didi.rlab.uni_im_map.map.IMLocationResult;
import com.didi.rlab.uni_im_map.map.IMMapMarkerBubble;
import com.didi.rlab.uni_im_map.map.MapIMService;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sofa.utils.LocationUtils;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.rider.rlab_im_map_plugin.ImMapActivity;
import com.rider.rlab_im_map_plugin.engine.CustomerConfigListener;
import com.rider.rlab_im_map_plugin.engine.ImMapConfig;
import com.rider.rlab_im_map_plugin.map.IMapViewProvider;
import com.rider.rlab_im_map_plugin.map.ImMapView;
import com.rider.rlab_im_map_plugin.map.MapViewProviderImpl;
import com.rider.rlab_im_map_plugin.tool.ImMapUtils;
import com.rider.rlab_im_map_plugin.xpanel.XPanelLayout;

public class MapIMServiceImpl implements MapIMService {
    public static final String POI_COORDINATE_TYPE = "wgs84";
    public static final String POI_MAPSDK_TYPE = "gmap";
    public static final int POI_PRODUCT_ID = 392;
    public static final String POI_REQUESTER_TYPE = "soda.customer.android";
    public static final int REQUEST_FAIL = 0;
    public static final int REQUEST_SUCCESS = 1;
    public static IMapViewProvider iMapViewProvider = new MapViewProviderImpl();

    /* renamed from: a */
    private final Logger f55850a = LoggerFactory.getLogger("MapIMServiceImpl");

    public void sendMapIMLocation(IMMapMarkerBubble iMMapMarkerBubble) {
        Activity scanForActivity;
        this.f55850a.info("MapIMServiceImpl sendMapIMLocation", new Object[0]);
        if (iMMapMarkerBubble != null) {
            try {
                IMAddress iMAddress = new IMAddress();
                iMAddress.setLat(iMMapMarkerBubble.getLat());
                iMAddress.setLng(iMMapMarkerBubble.getLng());
                iMAddress.setAddress(iMMapMarkerBubble.getAddress());
                iMAddress.setDisplayname(iMMapMarkerBubble.getDisplayname());
                IMSendAddressEvent iMSendAddressEvent = new IMSendAddressEvent(iMAddress);
                boolean invoke = IMHostLoader.getHost().invoke(IMHostService.ACTION_SEND_LOCATION_MESSAGE, iMSendAddressEvent, false);
                Logger logger = this.f55850a;
                logger.info("MapIMServiceImpl invoke : " + invoke, new Object[0]);
            } finally {
                this.f55850a.info("MapIMServiceImpl finish ImMapActivity", new Object[0]);
                XPanelLayout xPanelLayout = NavIMServiceImpl.iNavigationProvider.getXPanelLayout();
                if (!(xPanelLayout == null || (scanForActivity = ImMapUtils.scanForActivity(xPanelLayout.getContext())) == null || !(scanForActivity instanceof ImMapActivity))) {
                    scanForActivity.finish();
                }
            }
        }
    }

    public void setMapIMRecenter() {
        this.f55850a.info("MapIMServiceImpl setMapIMRecenter", new Object[0]);
        iMapViewProvider.setMapRecenter();
    }

    public void startOverView(double d, double d2) {
        this.f55850a.info("MapIMServiceImpl startOverView", new Object[0]);
        ImMapView mapView = iMapViewProvider.getMapView();
        if (mapView != null) {
            mapView.setMapOverView(d, d2);
        }
    }

    public void setCamera(double d, double d2) {
        this.f55850a.info("MapIMServiceImpl setCamera", new Object[0]);
        ImMapView mapView = iMapViewProvider.getMapView();
        if (mapView != null) {
            mapView.setCamera(d, d2);
        }
    }

    public void setMapIMPadding(double d, double d2, double d3, double d4) {
        Logger logger = this.f55850a;
        logger.info("MapIMServiceImpl setMapIMPadding" + d + "-" + d2 + "-" + d3 + "-" + d4, new Object[0]);
        Context context = ImMapConfig.getInstance().getContext();
        int dp2px = DisplayUtils.dp2px(context, (float) d);
        int dp2px2 = DisplayUtils.dp2px(context, (float) d3);
        iMapViewProvider.setHintView(dp2px, DisplayUtils.dp2px(context, (float) d2), dp2px2, DisplayUtils.dp2px(context, (float) d4));
        XPanelLayout xPanelLayout = NavIMServiceImpl.iNavigationProvider.getXPanelLayout();
        if (xPanelLayout != null) {
            xPanelLayout.setMapTouchHeight(Double.valueOf((double) dp2px2));
        }
    }

    public void setMapIMDropMarker(IMMapMarkerBubble iMMapMarkerBubble) {
        this.f55850a.info("MapIMServiceImpl setMapIMDropMarker", new Object[0]);
        iMapViewProvider.setMapIMDropMarker(iMMapMarkerBubble);
    }

    public void notHandleMapEvents(boolean z) {
        XPanelLayout xPanelLayout = NavIMServiceImpl.iNavigationProvider.getXPanelLayout();
        if (xPanelLayout != null) {
            xPanelLayout.setNotHandling(z);
        }
    }

    public double distanceBetween(double d, double d2, double d3, double d4) {
        return LocationUtils.getDistance(d, d2, d3, d4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startPoiRequest(double r12, double r14) {
        /*
            r11 = this;
            com.didi.sdk.logging.Logger r0 = r11.f55850a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "startPoiRequest "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r2 = " , "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r0.info((java.lang.String) r1, (java.lang.Object[]) r3)
            java.math.BigDecimal r0 = new java.math.BigDecimal     // Catch:{ Exception -> 0x0040 }
            r0.<init>(r12)     // Catch:{ Exception -> 0x0040 }
            r1 = 4
            r3 = 6
            java.math.BigDecimal r0 = r0.setScale(r3, r1)     // Catch:{ Exception -> 0x0040 }
            double r4 = r0.doubleValue()     // Catch:{ Exception -> 0x0040 }
            java.math.BigDecimal r0 = new java.math.BigDecimal     // Catch:{ Exception -> 0x003e }
            r0.<init>(r14)     // Catch:{ Exception -> 0x003e }
            java.math.BigDecimal r0 = r0.setScale(r3, r1)     // Catch:{ Exception -> 0x003e }
            double r0 = r0.doubleValue()     // Catch:{ Exception -> 0x003e }
            goto L_0x0062
        L_0x003e:
            r0 = move-exception
            goto L_0x0042
        L_0x0040:
            r0 = move-exception
            r4 = r12
        L_0x0042:
            r0.printStackTrace()
            com.didi.sdk.logging.Logger r1 = r11.f55850a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "rectify error "
            r3.append(r6)
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r1.error((java.lang.String) r0, (java.lang.Object[]) r3)
            r0 = r14
        L_0x0062:
            com.rider.rlab_im_map_plugin.engine.ImMapConfig r3 = com.rider.rlab_im_map_plugin.engine.ImMapConfig.getInstance()
            android.content.Context r3 = r3.getContext()
            com.rider.rlab_im_map_plugin.engine.ImMapConfig r6 = com.rider.rlab_im_map_plugin.engine.ImMapConfig.getInstance()
            java.lang.String r6 = r6.getToken()
            com.rider.rlab_im_map_plugin.engine.ImMapConfig r7 = com.rider.rlab_im_map_plugin.engine.ImMapConfig.getInstance()
            java.util.Locale r7 = r7.getLocale()
            if (r7 == 0) goto L_0x0081
            java.lang.String r7 = r7.toString()
            goto L_0x0083
        L_0x0081:
            java.lang.String r7 = "en_US"
        L_0x0083:
            com.didichuxing.bigdata.dp.locsdk.DIDILocationManager r8 = com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager.getInstance(r3)
            com.didichuxing.bigdata.dp.locsdk.DIDILocation r8 = r8.getLastKnownLocation()
            com.sdk.poibase.model.reverse.ReverseGeoParam r9 = new com.sdk.poibase.model.reverse.ReverseGeoParam
            r9.<init>()
            com.sdk.poibase.CallFrom r10 = com.sdk.poibase.CallFrom.SODA
            r9.callFrom = r10
            java.lang.String r10 = "392"
            r9.productId = r10
            r9.select_lat = r4
            r9.select_lng = r0
            if (r8 == 0) goto L_0x00ab
            double r0 = r8.getLatitude()
            r9.user_loc_lat = r0
            double r0 = r8.getLongitude()
            r9.user_loc_lng = r0
            goto L_0x00b1
        L_0x00ab:
            r0 = 0
            r9.user_loc_lat = r0
            r9.user_loc_lng = r0
        L_0x00b1:
            java.lang.String r0 = "wgs84"
            r9.coordinate_type = r0
            java.lang.String r0 = "gmap"
            r9.mapType = r0
            r9.token = r6
            java.lang.String r0 = com.rider.rlab_im_map_plugin.tool.VersionTools.getVersionName(r3)
            r9.appVersion = r0
            r9.lang = r7
            com.didi.sdk.logging.Logger r0 = r11.f55850a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "startPoiRequest params :  user_loc_lat:"
            r1.append(r4)
            double r4 = r9.user_loc_lat
            r1.append(r4)
            java.lang.String r4 = " user_loc_lng:"
            r1.append(r4)
            double r4 = r9.user_loc_lng
            r1.append(r4)
            java.lang.String r4 = " token:"
            r1.append(r4)
            java.lang.String r4 = r9.token
            r1.append(r4)
            java.lang.String r4 = " appVersion:"
            r1.append(r4)
            java.lang.String r4 = r9.appVersion
            r1.append(r4)
            java.lang.String r4 = " lang:"
            r1.append(r4)
            java.lang.String r4 = r9.lang
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r0.info((java.lang.String) r1, (java.lang.Object[]) r2)
            com.sdk.poibase.PoiBizType r0 = com.sdk.poibase.PoiBizType.TYPE_GLOBAL
            com.sdk.poibase.IPoiBaseApi r0 = com.sdk.poibase.PoiBaseApiFactory.createDidiApi(r3, r0)
            com.rider.rlab_im_map_plugin.channel.MapIMServiceImpl$1 r7 = new com.rider.rlab_im_map_plugin.channel.MapIMServiceImpl$1
            r1 = r7
            r2 = r11
            r3 = r12
            r5 = r14
            r1.<init>(r3, r5)
            r0.reverseGeo(r9, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rider.rlab_im_map_plugin.channel.MapIMServiceImpl.startPoiRequest(double, double):void");
    }

    public void getCustomerOrderInfo(String str) {
        CustomerConfigListener customerConfigListener = ImMapConfig.getInstance().getCustomerConfigListener();
        if (customerConfigListener != null) {
            customerConfigListener.getCustomerOrderInfo(str);
        }
    }

    public void closeImMapPage() {
        Activity scanForActivity;
        this.f55850a.info("closeImMapPage finish ImMapActivity", new Object[0]);
        XPanelLayout xPanelLayout = NavIMServiceImpl.iNavigationProvider.getXPanelLayout();
        if (xPanelLayout != null && (scanForActivity = ImMapUtils.scanForActivity(xPanelLayout.getContext())) != null && (scanForActivity instanceof ImMapActivity)) {
            scanForActivity.finish();
        }
    }

    public IMLocationResult getLocationInfo() {
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(ImMapConfig.getInstance().getContext()).getLastKnownLocation();
        if (lastKnownLocation == null) {
            return null;
        }
        IMLocationResult iMLocationResult = new IMLocationResult();
        iMLocationResult.setVerticalAccuracy((double) lastKnownLocation.getAccuracy());
        iMLocationResult.setHorizontalAccuracy((double) lastKnownLocation.getAccuracy());
        iMLocationResult.setLatitude(lastKnownLocation.getLatitude());
        iMLocationResult.setLongtitude(lastKnownLocation.getLongitude());
        return iMLocationResult;
    }
}
