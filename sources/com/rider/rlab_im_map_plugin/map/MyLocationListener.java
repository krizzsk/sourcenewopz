package com.rider.rlab_im_map_plugin.map;

import android.content.Context;
import com.didi.common.map.model.LatLng;
import com.didi.common.sensor.OrientationListener;
import com.didi.common.sensor.OrientationManager;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import com.rider.rlab_im_map_plugin.channel.MapIMPluginHelper;
import com.rider.rlab_im_map_plugin.engine.ImMapConfig;
import com.rider.rlab_im_map_plugin.marker.MyLocationMarker;

public class MyLocationListener implements OrientationListener {

    /* renamed from: a */
    private final Logger f55911a = LoggerFactory.getLogger("MapViewMyLocationListener");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f55912b;

    /* renamed from: c */
    private boolean f55913c = false;

    /* renamed from: d */
    private final ImLocationListener f55914d = new ImLocationListener();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public MyLocationMarker f55915e;

    /* renamed from: f */
    private final DIDILocationUpdateOption f55916f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LatLng f55917g;

    /* renamed from: h */
    private int f55918h = 0;

    public MyLocationListener(Context context) {
        this.f55912b = context;
        DIDILocationUpdateOption defaultLocationUpdateOption = DIDILocationManager.getInstance(context).getDefaultLocationUpdateOption();
        this.f55916f = defaultLocationUpdateOption;
        defaultLocationUpdateOption.setInterval(DIDILocationUpdateOption.IntervalMode.NORMAL);
        this.f55916f.setModuleKey(context.getPackageName());
    }

    public void onOrientationChanged(float f, float f2, float f3) {
        MyLocationMarker myLocationMarker = this.f55915e;
        if (myLocationMarker != null) {
            myLocationMarker.updateArrowRotateAngle(f);
        }
    }

    public void startLocation() {
        Context context = this.f55912b;
        if (context != null && !this.f55913c) {
            DIDILocationManager.getInstance(context).requestLocationUpdates(this.f55914d, this.f55916f);
            OrientationManager.getInstance(this.f55912b).addOrientationListener(this);
            this.f55913c = true;
        }
    }

    public void stopLocation() {
        Context context = this.f55912b;
        if (context != null) {
            OrientationManager.getInstance(context).removeOrientationListener(this);
            DIDILocationManager.getInstance(this.f55912b).removeLocationUpdates(this.f55914d);
            this.f55913c = false;
        }
    }

    public void setMarker(MyLocationMarker myLocationMarker) {
        this.f55915e = myLocationMarker;
    }

    public LatLng getLatLng() {
        return this.f55917g;
    }

    public class ImLocationListener implements DIDILocationListener {
        public void onStatusUpdate(String str, int i, String str2) {
        }

        public ImLocationListener() {
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            if (MyLocationListener.this.f55915e != null && dIDILocation != null) {
                LatLng latLng = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
                LatLng mockLatLng = ImMapConfig.getInstance().getMockLatLng();
                if (mockLatLng != null) {
                    MyLocationListener.this.f55915e.updatePosition(mockLatLng);
                    LatLng unused = MyLocationListener.this.f55917g = mockLatLng;
                } else {
                    MyLocationListener.this.f55915e.updatePosition(latLng);
                    LatLng unused2 = MyLocationListener.this.f55917g = latLng;
                }
                MapIMPluginHelper.setLocationInfo(MyLocationListener.this.f55917g.latitude, MyLocationListener.this.f55917g.longitude);
            }
        }

        public void onLocationError(int i, ErrInfo errInfo) {
            DIDILocation lastKnownLocation;
            if (MyLocationListener.this.f55915e != null && (lastKnownLocation = DIDILocationManager.getInstance(MyLocationListener.this.f55912b).getLastKnownLocation()) != null) {
                MyLocationListener.this.f55915e.updatePosition(new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()));
            }
        }
    }
}
