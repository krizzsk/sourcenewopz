package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3;

import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocationListenerWrapper */
public class LocationListenerWrapper {

    /* renamed from: a */
    long f45883a;

    /* renamed from: b */
    private DIDILocationUpdateOption f45884b;

    /* renamed from: c */
    private DIDILocationListener f45885c;

    /* renamed from: d */
    private long f45886d;

    public long getNotifyLocTime() {
        return this.f45886d;
    }

    public void setNotifyLocTime(long j) {
        this.f45886d = j;
    }

    public LocationListenerWrapper(DIDILocationListener dIDILocationListener, DIDILocationUpdateOption dIDILocationUpdateOption) {
        this.f45885c = dIDILocationListener;
        this.f45884b = dIDILocationUpdateOption;
    }

    public DIDILocationUpdateOption getOption() {
        return this.f45884b;
    }

    public void setOption(DIDILocationUpdateOption dIDILocationUpdateOption) {
        this.f45884b = dIDILocationUpdateOption;
    }

    public DIDILocationListener getListener() {
        return this.f45885c;
    }

    public void setListener(DIDILocationListener dIDILocationListener) {
        this.f45885c = dIDILocationListener;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof LocationListenerWrapper)) {
            return false;
        }
        LocationListenerWrapper locationListenerWrapper = (LocationListenerWrapper) obj;
        if (!this.f45885c.equals(locationListenerWrapper.getListener()) || this.f45884b.getInterval().getValue() != locationListenerWrapper.getOption().getInterval().getValue()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f45885c.hashCode();
    }
}
