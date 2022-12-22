package com.didi.map.global.model.location;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import com.didichuxing.bigdata.p173dp.locsdk.once.DIDILocNlpOnceManager;
import com.didichuxing.bigdata.p173dp.locsdk.once.DIDILocationUpdateOnceParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NLPLocationListener implements DIDILocationListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f27326a;

    /* renamed from: b */
    private LocationRegisterParam f27327b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<DIDILocationListener> f27328c = new ArrayList();

    /* renamed from: d */
    private String f27329d = "LocationListener-->didi";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public DIDILocation f27330e;

    /* renamed from: f */
    private long f27331f;

    public void onLocationError(int i, ErrInfo errInfo) {
    }

    public void onStatusUpdate(String str, int i, String str2) {
    }

    public NLPLocationListener(LocationRegisterParam locationRegisterParam, Context context) {
        this.f27327b = locationRegisterParam;
        this.f27326a = context;
    }

    public void registerLocationListener(DIDILocationListener dIDILocationListener, DIDILocationUpdateOption.IntervalMode intervalMode) {
        List<DIDILocationListener> list = this.f27328c;
        if (list == null || list.isEmpty()) {
            this.f27328c = new ArrayList();
            this.f27331f = System.currentTimeMillis();
            DIDILocationManager instance = DIDILocationManager.getInstance(this.f27326a);
            if (instance != null) {
                DIDILocationUpdateOption defaultLocationUpdateOption = instance.getDefaultLocationUpdateOption();
                defaultLocationUpdateOption.setModuleKey("didi.map.global.common.model");
                defaultLocationUpdateOption.setInterval(DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY);
                instance.setCoordinateType(0);
                instance.setOnlyOSLocationAbroad(true);
                instance.removeLocationUpdates(this);
                instance.requestLocationUpdates(this, defaultLocationUpdateOption);
            }
        }
        this.f27328c.add(dIDILocationListener);
    }

    public void unRegisterLocationListener(DIDILocationListener dIDILocationListener) {
        List<DIDILocationListener> list = this.f27328c;
        if (list != null) {
            list.remove(dIDILocationListener);
            if (this.f27328c.isEmpty()) {
                DIDILocationManager instance = DIDILocationManager.getInstance(this.f27326a);
                if (instance != null) {
                    instance.removeLocationUpdates(this);
                    this.f27328c = null;
                }
                this.f27331f = 0;
                DLog.m7384d(this.f27329d, "自建定位NLP已经销毁", new Object[0]);
            }
        }
    }

    public void updateNlpParam(LocationRegisterParam locationRegisterParam) {
        this.f27327b = locationRegisterParam;
    }

    public DIDILocation getLastKnownLocation() {
        return this.f27330e;
    }

    public DIDILocation getLastKnownLocationFlp(Context context) {
        DIDILocationManager instance = DIDILocationManager.getInstance(context);
        if (instance != null) {
            return instance.getLastKnownLocation();
        }
        return null;
    }

    /* renamed from: a */
    private void m19301a() {
        LocationRegisterParam locationRegisterParam = this.f27327b;
        if (locationRegisterParam != null && this.f27326a != null && locationRegisterParam.getNlpRegisterParam() != null) {
            DIDILocationUpdateOnceParam dIDILocationUpdateOnceParam = new DIDILocationUpdateOnceParam();
            if (!TextUtils.isEmpty(this.f27327b.getNlpRegisterParam().getmCallFrom())) {
                dIDILocationUpdateOnceParam.setCallFrom(this.f27327b.getNlpRegisterParam().getmCallFrom());
            }
            dIDILocationUpdateOnceParam.setEntrance(PaxEnvironment.getInstance().getEntrance().toString());
            dIDILocationUpdateOnceParam.setModuleKey("map-mylocation");
            dIDILocationUpdateOnceParam.setTimeOut(this.f27327b.getNlpRegisterParam().getmConnectTimeOut());
            DIDILocNlpOnceManager.getInstance(this.f27326a).requestLocationUpdateOnce(m19307c(), dIDILocationUpdateOnceParam, 3);
        }
    }

    /* renamed from: b */
    private boolean m19306b() {
        LocationRegisterParam locationRegisterParam = this.f27327b;
        int frequency = (locationRegisterParam == null || locationRegisterParam.getNlpRegisterParam() == null) ? 2000 : this.f27327b.getNlpRegisterParam().getFrequency();
        boolean z = false;
        if (this.f27331f != 0 && System.currentTimeMillis() - this.f27331f > ((long) frequency)) {
            z = true;
        }
        if (z) {
            this.f27331f = System.currentTimeMillis();
        }
        return z;
    }

    public void onLocationChanged(DIDILocation dIDILocation) {
        if (m19306b()) {
            m19301a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19303a(DIDILocation dIDILocation) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f27328c)) {
            for (DIDILocationListener next : this.f27328c) {
                if (next != null) {
                    next.onLocationChanged(dIDILocation);
                }
            }
            this.f27330e = dIDILocation;
        }
    }

    /* renamed from: c */
    private DIDILocationListener m19307c() {
        return new DIDILocationListener() {
            public void onLocationChanged(DIDILocation dIDILocation) {
                NLPLocationListener.this.m19303a(dIDILocation);
                DIDILocation unused = NLPLocationListener.this.f27330e = dIDILocation;
            }

            public void onLocationError(int i, ErrInfo errInfo) {
                NLPLocationListener nLPLocationListener = NLPLocationListener.this;
                nLPLocationListener.m19303a(nLPLocationListener.getLastKnownLocationFlp(nLPLocationListener.f27326a));
            }

            public void onStatusUpdate(String str, int i, String str2) {
                if (!CollectionUtil.isEmpty((Collection<?>) NLPLocationListener.this.f27328c)) {
                    for (DIDILocationListener dIDILocationListener : NLPLocationListener.this.f27328c) {
                        if (dIDILocationListener != null) {
                            dIDILocationListener.onStatusUpdate(str, i, str2);
                        }
                    }
                }
            }
        };
    }
}
