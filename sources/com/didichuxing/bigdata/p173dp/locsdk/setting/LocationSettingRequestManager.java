package com.didichuxing.bigdata.p173dp.locsdk.setting;

import android.content.Context;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.Iterator;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.setting.LocationSettingRequestManager */
public class LocationSettingRequestManager {

    /* renamed from: a */
    private ILocationSettingRequest f46163a;

    private LocationSettingRequestManager() {
        this.f46163a = m33151a();
    }

    /* renamed from: a */
    private ILocationSettingRequest m33151a() {
        try {
            Iterator<S> it = ServiceLoader.load(ILocationSettingRequest.class).iterator();
            while (it.hasNext()) {
                ILocationSettingRequest iLocationSettingRequest = (ILocationSettingRequest) it.next();
                if (iLocationSettingRequest != null) {
                    return iLocationSettingRequest;
                }
            }
            return null;
        } catch (Exception unused) {
            DLog.m32737d(" get location setting request impl failed");
            return null;
        }
    }

    public void checkSettingRequest(Context context, LocationSettingRequestCallback locationSettingRequestCallback) {
        if (this.f46163a == null) {
            this.f46163a = m33151a();
        }
        ILocationSettingRequest iLocationSettingRequest = this.f46163a;
        if (iLocationSettingRequest != null) {
            iLocationSettingRequest.checkSettingRequest(context, locationSettingRequestCallback);
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.setting.LocationSettingRequestManager$HOLDER */
    private static class HOLDER {
        /* access modifiers changed from: private */
        public static LocationSettingRequestManager instance = new LocationSettingRequestManager();

        private HOLDER() {
        }
    }

    public static LocationSettingRequestManager getInstance() {
        return HOLDER.instance;
    }
}
