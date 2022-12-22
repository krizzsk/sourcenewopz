package com.didichuxing.bigdata.p173dp.locsdk.once;

import com.didichuxing.bigdata.p173dp.locsdk.EvilTransform;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.LocBuffer */
public class LocBuffer {

    /* renamed from: a */
    private long f46102a;

    /* renamed from: b */
    private Queue<LonLat> f46103b;

    /* renamed from: c */
    private final long f46104c = 60000;

    /* renamed from: d */
    private final long f46105d = 10000;

    /* renamed from: e */
    private final int f46106e = 10;

    public LocBuffer() {
        LinkedList linkedList = new LinkedList();
        this.f46103b = linkedList;
        linkedList.clear();
        this.f46102a = 0;
    }

    public void clear() {
        this.f46103b.clear();
        this.f46102a = 0;
    }

    public boolean isCompatible(LocationServiceResponse locationServiceResponse) {
        LocationServiceResponse locationServiceResponse2 = locationServiceResponse;
        if (locationServiceResponse2 == null || locationServiceResponse2.locations.size() <= 0) {
            return false;
        }
        LonLat a = m33123a(locationServiceResponse);
        if (this.f46103b.size() <= 0) {
            this.f46102a = System.currentTimeMillis();
            this.f46103b.add(a);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f46102a > 60000) {
            this.f46103b.clear();
            this.f46103b.add(a);
            this.f46102a = currentTimeMillis;
            return true;
        }
        Iterator it = this.f46103b.iterator();
        int i = 0;
        while (it.hasNext()) {
            LonLat lonLat = (LonLat) it.next();
            Iterator it2 = it;
            if (EvilTransform.calcdistance(a.lon, a.lat, lonLat.lon, lonLat.lat) > 10000.0d) {
                i++;
            }
            it = it2;
        }
        if (i <= 0) {
            m33124a(a);
            this.f46102a = currentTimeMillis;
            return true;
        } else if (i == this.f46103b.size()) {
            return false;
        } else {
            this.f46103b.clear();
            this.f46103b.add(a);
            this.f46102a = currentTimeMillis;
            return true;
        }
    }

    /* renamed from: a */
    private void m33124a(LonLat lonLat) {
        if (this.f46103b.size() >= 10) {
            this.f46103b.poll();
        }
        this.f46103b.add(lonLat);
    }

    /* renamed from: a */
    private LonLat m33123a(LocationServiceResponse locationServiceResponse) {
        List<location_info_t> list = locationServiceResponse.locations;
        location_info_t location_info_t = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).confidence > location_info_t.confidence) {
                location_info_t = list.get(i);
            }
        }
        return new LonLat(location_info_t.lon_gcj, location_info_t.lat_gcj);
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.once.LocBuffer$LonLat */
    class LonLat {
        double lat;
        double lon;

        public LonLat(double d, double d2) {
            this.lon = d;
            this.lat = d2;
        }
    }
}
