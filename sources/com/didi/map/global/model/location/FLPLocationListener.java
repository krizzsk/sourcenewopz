package com.didi.map.global.model.location;

import android.content.Context;
import com.didi.common.map.util.CollectionUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FLPLocationListener implements DIDILocationListener {

    /* renamed from: a */
    private Context f27316a;

    /* renamed from: b */
    private LocationRegisterParam f27317b;

    /* renamed from: c */
    private List<DIDILocationListener> f27318c = new ArrayList();

    /* renamed from: d */
    private String f27319d = "LocationListener-->google";

    public FLPLocationListener(LocationRegisterParam locationRegisterParam, Context context) {
        this.f27317b = locationRegisterParam;
        this.f27316a = context;
    }

    public void registerLocationListener(DIDILocationListener dIDILocationListener, DIDILocationUpdateOption.IntervalMode intervalMode) {
        List<DIDILocationListener> list = this.f27318c;
        if (list == null || list.isEmpty()) {
            this.f27318c = new ArrayList();
            m19295a(intervalMode);
        }
        this.f27318c.add(dIDILocationListener);
    }

    /* renamed from: a */
    private void m19295a(DIDILocationUpdateOption.IntervalMode intervalMode) {
        DIDILocationManager instance = DIDILocationManager.getInstance(this.f27316a);
        if (instance != null) {
            DIDILocationUpdateOption defaultLocationUpdateOption = instance.getDefaultLocationUpdateOption();
            defaultLocationUpdateOption.setModuleKey("didi.map.global.common.model");
            defaultLocationUpdateOption.setInterval(intervalMode);
            instance.setCoordinateType(0);
            instance.setOnlyOSLocationAbroad(true);
            instance.removeLocationUpdates(this);
            instance.requestLocationUpdates(this, defaultLocationUpdateOption);
        }
    }

    public void unRegisterLocationListener(DIDILocationListener dIDILocationListener) {
        DIDILocationManager instance;
        List<DIDILocationListener> list = this.f27318c;
        if (list != null) {
            list.remove(dIDILocationListener);
            if (this.f27318c.isEmpty() && (instance = DIDILocationManager.getInstance(this.f27316a)) != null) {
                instance.removeLocationUpdates(this);
                this.f27318c = null;
            }
        }
    }

    public void onLocationChanged(DIDILocation dIDILocation) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f27318c)) {
            for (DIDILocationListener next : this.f27318c) {
                if (next != null) {
                    next.onLocationChanged(dIDILocation);
                }
            }
        }
    }

    public void onLocationError(int i, ErrInfo errInfo) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f27318c)) {
            for (DIDILocationListener next : this.f27318c) {
                if (next != null) {
                    next.onLocationError(i, errInfo);
                }
            }
        }
    }

    public void onStatusUpdate(String str, int i, String str2) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f27318c)) {
            for (DIDILocationListener next : this.f27318c) {
                if (next != null) {
                    next.onStatusUpdate(str, i, str2);
                }
            }
        }
    }

    public DIDILocation getLastKnownLocation(Context context) {
        DIDILocationManager instance = DIDILocationManager.getInstance(context);
        if (instance != null) {
            return instance.getLastKnownLocation();
        }
        return null;
    }
}
