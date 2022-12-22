package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocationStorage */
public class LocationStorage {
    public static final String ACTION_UPDATE_CURRENT_LOCATION = "com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.LocationStorage.ACTION_UPDATE_CURRENT_LOCATION";
    public static final String INTENT_EXTRA_DATA_LOCATION = "com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.LocationStorage.INTENT_EXTRA_DATA_LOCATION";

    /* renamed from: a */
    private volatile DIDILocation f45887a;

    /* renamed from: b */
    private final int f45888b;

    /* renamed from: c */
    private Queue<DIDILocation> f45889c;

    /* renamed from: d */
    private Context f45890d;

    /* renamed from: e */
    private String f45891e;

    private LocationStorage() {
        this.f45887a = null;
        this.f45888b = 20;
        this.f45889c = new ArrayBlockingQueue(20);
    }

    public void init(Context context) {
        this.f45890d = context;
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocationStorage$SingletonHolder */
    private static class SingletonHolder {
        static LocationStorage sInstance = new LocationStorage();

        private SingletonHolder() {
        }
    }

    public static LocationStorage getInstance() {
        return SingletonHolder.sInstance;
    }

    public void setAppId(String str) {
        this.f45891e = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo114508a(DIDILocation dIDILocation, String str) {
        DIDILocation dIDILocation2 = this.f45887a;
        this.f45887a = dIDILocation;
        m32932a(this.f45887a);
        OmegaUtils.trackLocTimestampMonotonic(dIDILocation2, this.f45887a, str);
        if (dIDILocation2 == null || Double.compare(dIDILocation2.getLongitude(), dIDILocation.getLongitude()) != 0 || Double.compare(dIDILocation2.getLatitude(), dIDILocation.getLatitude()) != 0 || Float.compare(dIDILocation2.getAccuracy(), dIDILocation.getAccuracy()) != 0 || dIDILocation2.getTime() != dIDILocation.getTime()) {
            if (this.f45889c.size() == 20) {
                this.f45889c.remove();
            }
            this.f45889c.offer(dIDILocation);
        }
    }

    /* renamed from: a */
    private void m32932a(DIDILocation dIDILocation) {
        Intent intent = new Intent(ACTION_UPDATE_CURRENT_LOCATION);
        intent.putExtra(INTENT_EXTRA_DATA_LOCATION, dIDILocation);
        LocalBroadcastManager.getInstance(this.f45890d).sendBroadcast(intent);
    }

    public DIDILocation getLastKnownLocation() {
        if (this.f45887a != null && System.currentTimeMillis() - this.f45887a.getLocalTime() > 30000) {
            this.f45887a.setEffective(false);
        }
        m32931a();
        return this.f45887a;
    }

    public List<DIDILocation> getRecentLocations(int i) {
        ArrayList arrayList = new ArrayList(Arrays.asList(this.f45889c.toArray(new DIDILocation[0])));
        int size = arrayList.size();
        if (size <= 0) {
            return arrayList;
        }
        if (i >= size) {
            i = size;
        }
        return arrayList.subList(size - i, size);
    }

    /* renamed from: a */
    private void m32931a() {
        float f;
        boolean z;
        boolean z2 = false;
        if (this.f45887a != null) {
            z = this.f45887a.isEffective();
            f = this.f45887a.getAccuracy();
        } else {
            f = -1.0f;
            z = false;
        }
        String str = this.f45891e;
        if (this.f45887a != null) {
            z2 = true;
        }
        OmegaUtils.trackLastKnowResult(str, z, z2, f);
    }
}
