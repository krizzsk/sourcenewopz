package com.didi.map.global.component.departure.data.store;

import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.departure.controller.InterceptConfig;
import com.didi.map.global.component.departure.util.DepartureUtils;
import com.didi.map.global.component.departure.util.FenceUtils;
import com.didi.map.global.component.departure.util.TerminalUtils;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.poi.ReverseStationsInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DepartureDataStore {

    /* renamed from: a */
    private static final String f25055a = "DepartureDataStore";

    /* renamed from: b */
    private static DepartureDataStore f25056b = null;

    /* renamed from: d */
    private static final int f25057d = 10;

    /* renamed from: c */
    private boolean f25058c;

    /* renamed from: e */
    private List<DataCatchItem> f25059e = new ArrayList();

    /* renamed from: f */
    private LatLng f25060f;

    /* renamed from: g */
    private long f25061g;

    private DepartureDataStore() {
    }

    public static DepartureDataStore getInstance() {
        if (f25056b == null) {
            synchronized (DepartureDataStore.class) {
                if (f25056b == null) {
                    f25056b = new DepartureDataStore();
                }
            }
        }
        return f25056b;
    }

    public LatLng getPinLocation() {
        return this.f25060f;
    }

    public void setPinLocation(LatLng latLng) {
        this.f25060f = latLng;
    }

    public void setReverseResult(ReverseStationsInfo reverseStationsInfo, LatLng latLng) {
        if (reverseStationsInfo != null && latLng != null) {
            synchronized (this) {
                if (this.f25059e != null) {
                    DataCatchItem dataCatchItem = new DataCatchItem();
                    dataCatchItem.points = new ArrayList();
                    dataCatchItem.points.add(latLng);
                    ArrayList<RpcPoi> recStartPoints = reverseStationsInfo.getRecStartPoints();
                    if (!CollectionUtil.isEmpty((Collection<?>) recStartPoints)) {
                        for (RpcPoi next : recStartPoints) {
                            if (next.base_info != null) {
                                dataCatchItem.points.add(new LatLng(next.base_info.lat, next.base_info.lng));
                            }
                        }
                    } else {
                        List<RpcPoi> wholeSpecialRpcPoiList = TerminalUtils.getWholeSpecialRpcPoiList(reverseStationsInfo);
                        if (!CollectionUtil.isEmpty((Collection<?>) wholeSpecialRpcPoiList)) {
                            for (RpcPoi next2 : wholeSpecialRpcPoiList) {
                                if (next2.base_info != null) {
                                    dataCatchItem.points.add(new LatLng(next2.base_info.lat, next2.base_info.lng));
                                }
                            }
                        }
                    }
                    dataCatchItem.info = reverseStationsInfo;
                    if (this.f25059e.size() > 10) {
                        this.f25059e.remove(0);
                    }
                    this.f25059e.add(dataCatchItem);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sdk.poibase.model.poi.ReverseStationsInfo findSameAddr(com.didi.common.map.Map r5, com.didi.common.map.model.LatLng r6) {
        /*
            r4 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            monitor-enter(r4)
            java.util.List<com.didi.map.global.component.departure.data.store.DataCatchItem> r1 = r4.f25059e     // Catch:{ all -> 0x002f }
            int r1 = r1.size()     // Catch:{ all -> 0x002f }
            if (r1 <= 0) goto L_0x002d
            java.util.List<com.didi.map.global.component.departure.data.store.DataCatchItem> r1 = r4.f25059e     // Catch:{ all -> 0x002f }
            int r1 = r1.size()     // Catch:{ all -> 0x002f }
            int r1 = r1 + -1
        L_0x0015:
            r2 = -1
            if (r1 <= r2) goto L_0x002d
            java.util.List<com.didi.map.global.component.departure.data.store.DataCatchItem> r2 = r4.f25059e     // Catch:{ all -> 0x002f }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x002f }
            com.didi.map.global.component.departure.data.store.DataCatchItem r2 = (com.didi.map.global.component.departure.data.store.DataCatchItem) r2     // Catch:{ all -> 0x002f }
            boolean r3 = r4.m17904a(r5, r2, r6)     // Catch:{ all -> 0x002f }
            if (r3 == 0) goto L_0x002a
            com.sdk.poibase.model.poi.ReverseStationsInfo r5 = r2.info     // Catch:{ all -> 0x002f }
            monitor-exit(r4)     // Catch:{ all -> 0x002f }
            return r5
        L_0x002a:
            int r1 = r1 + -1
            goto L_0x0015
        L_0x002d:
            monitor-exit(r4)     // Catch:{ all -> 0x002f }
            return r0
        L_0x002f:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x002f }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.data.store.DepartureDataStore.findSameAddr(com.didi.common.map.Map, com.didi.common.map.model.LatLng):com.sdk.poibase.model.poi.ReverseStationsInfo");
    }

    /* renamed from: a */
    private boolean m17904a(Map map, DataCatchItem dataCatchItem, LatLng latLng) {
        if (!(dataCatchItem == null || dataCatchItem.info == null || latLng == null)) {
            if (FenceUtils.positionIsInFence(map, DepartureUtils.getFenceInfo(dataCatchItem.info), latLng)) {
                DLog.m7384d(f25055a, "命中围栏缓存", new Object[0]);
                return true;
            } else if (!CollectionUtil.isEmpty((Collection<?>) dataCatchItem.points)) {
                for (LatLng isSameLatLng : dataCatchItem.points) {
                    if (LatLngUtils.isSameLatLng(isSameLatLng, latLng)) {
                        DLog.m7384d(f25055a, "命中小绿点缓存", new Object[0]);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void clear() {
        synchronized (this) {
            if (this.f25059e != null) {
                this.f25059e.clear();
            }
        }
    }

    public boolean isFirstLaunch() {
        if (!this.f25058c) {
            return false;
        }
        this.f25058c = false;
        return true;
    }

    public void saveInterceptTime() {
        this.f25061g = System.currentTimeMillis();
        DLog.m7384d(f25055a, "saveInterceptTime", new Object[0]);
    }

    public boolean isInterceptTimeInvalid() {
        long currentTimeMillis = System.currentTimeMillis() - this.f25061g;
        DLog.m7384d(f25055a, "isInterceptTimeInvalid diff=" + currentTimeMillis, new Object[0]);
        if (currentTimeMillis > ((long) (InterceptConfig.getInstance().time_limit * 60 * 1000))) {
            return true;
        }
        return false;
    }
}
