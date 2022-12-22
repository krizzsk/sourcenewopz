package com.didi.map.global.flow.scene.vamos.sctx.driver.psglocation;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.text.TextUtils;
import android.widget.ImageView;
import com.didi.common.map.Map;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.ImageUtil;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.flow.scene.vamos.sctx.driver.omega.VamosDriverSctxOmegaUtil;
import com.didi.map.sdk.passengerlocation.PassengerInfo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class PassengerMarkerDrawer {

    /* renamed from: a */
    private static final int f27156a = 30000;

    /* renamed from: b */
    private static final String f27157b = "PassengerMarkerDrawer";

    /* renamed from: c */
    private Context f27158c;

    /* renamed from: d */
    private Map f27159d;

    /* renamed from: e */
    private List<PassengerMarkerSet> f27160e = new ArrayList();

    /* renamed from: f */
    private final Object f27161f = new Object();

    public PassengerMarkerDrawer(Map map, Context context) {
        this.f27159d = map;
        this.f27158c = context;
    }

    public List<PassengerMarkerSet> getPassengerMarkers() {
        return this.f27160e;
    }

    public void removePassengerMarkers() {
        synchronized (this.f27161f) {
            if (this.f27160e != null && !this.f27160e.isEmpty()) {
                for (PassengerMarkerSet next : this.f27160e) {
                    DLog.m7384d(f27157b, "removePassengerMarkers:" + next.f27162id, new Object[0]);
                    if (!(next.marker == null || this.f27159d == null)) {
                        this.f27159d.remove(next.marker);
                        next.marker = null;
                    }
                    if (!(next.marker_direct == null || this.f27159d == null)) {
                        this.f27159d.remove(next.marker_direct);
                        next.marker_direct = null;
                    }
                }
                this.f27160e.clear();
                this.f27160e = null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00cd A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeInvalidPassengerMarkers(java.util.List<com.didi.map.sdk.passengerlocation.PassengerInfo> r9) {
        /*
            r8 = this;
            java.lang.String r0 = "PassengerMarkerDrawer"
            java.lang.String r1 = "removeInvalidPassengerMarkers start"
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.didi.common.map.util.DLog.m7384d(r0, r1, r3)
            java.lang.Object r0 = r8.f27161f
            monitor-enter(r0)
            java.util.List<com.didi.map.global.flow.scene.vamos.sctx.driver.psglocation.PassengerMarkerSet> r1 = r8.f27160e     // Catch:{ all -> 0x00d3 }
            if (r1 == 0) goto L_0x00d1
            java.util.List<com.didi.map.global.flow.scene.vamos.sctx.driver.psglocation.PassengerMarkerSet> r1 = r8.f27160e     // Catch:{ all -> 0x00d3 }
            int r1 = r1.size()     // Catch:{ all -> 0x00d3 }
        L_0x0018:
            if (r1 <= 0) goto L_0x00d1
            java.util.List<com.didi.map.global.flow.scene.vamos.sctx.driver.psglocation.PassengerMarkerSet> r3 = r8.f27160e     // Catch:{ all -> 0x00d3 }
            int r4 = r1 + -1
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x00d3 }
            com.didi.map.global.flow.scene.vamos.sctx.driver.psglocation.PassengerMarkerSet r3 = (com.didi.map.global.flow.scene.vamos.sctx.driver.psglocation.PassengerMarkerSet) r3     // Catch:{ all -> 0x00d3 }
            if (r3 == 0) goto L_0x00cd
            java.lang.String r5 = "PassengerMarkerDrawer"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d3 }
            r6.<init>()     // Catch:{ all -> 0x00d3 }
            java.lang.String r7 = "removeInvalidPassengerMarkers list:"
            r6.append(r7)     // Catch:{ all -> 0x00d3 }
            java.lang.String r7 = r3.f27162id     // Catch:{ all -> 0x00d3 }
            r6.append(r7)     // Catch:{ all -> 0x00d3 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00d3 }
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ all -> 0x00d3 }
            com.didi.common.map.util.DLog.m7384d(r5, r6, r7)     // Catch:{ all -> 0x00d3 }
            if (r9 == 0) goto L_0x0081
            int r5 = r9.size()     // Catch:{ all -> 0x00d3 }
            if (r5 <= 0) goto L_0x0081
            java.util.Iterator r5 = r9.iterator()     // Catch:{ all -> 0x00d3 }
        L_0x004d:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x00d3 }
            if (r6 == 0) goto L_0x0081
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x00d3 }
            com.didi.map.sdk.passengerlocation.PassengerInfo r6 = (com.didi.map.sdk.passengerlocation.PassengerInfo) r6     // Catch:{ all -> 0x00d3 }
            java.lang.String r6 = r6.getId()     // Catch:{ all -> 0x00d3 }
            java.lang.String r7 = r3.f27162id     // Catch:{ all -> 0x00d3 }
            boolean r6 = r6.equalsIgnoreCase(r7)     // Catch:{ all -> 0x00d3 }
            if (r6 == 0) goto L_0x004d
            java.lang.String r5 = "PassengerMarkerDrawer"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d3 }
            r6.<init>()     // Catch:{ all -> 0x00d3 }
            java.lang.String r7 = "exist passenger id： "
            r6.append(r7)     // Catch:{ all -> 0x00d3 }
            java.lang.String r7 = r3.f27162id     // Catch:{ all -> 0x00d3 }
            r6.append(r7)     // Catch:{ all -> 0x00d3 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00d3 }
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ all -> 0x00d3 }
            com.didi.common.map.util.DLog.m7384d(r5, r6, r7)     // Catch:{ all -> 0x00d3 }
            r5 = 1
            goto L_0x0082
        L_0x0081:
            r5 = 0
        L_0x0082:
            if (r5 != 0) goto L_0x00cd
            com.didi.common.map.Map r5 = r8.f27159d     // Catch:{ all -> 0x00d3 }
            if (r5 == 0) goto L_0x00ad
            com.didi.common.map.model.Marker r5 = r3.marker     // Catch:{ all -> 0x00d3 }
            r6 = 0
            if (r5 == 0) goto L_0x0096
            com.didi.common.map.Map r5 = r8.f27159d     // Catch:{ all -> 0x00d3 }
            com.didi.common.map.model.Marker r7 = r3.marker     // Catch:{ all -> 0x00d3 }
            r5.remove(r7)     // Catch:{ all -> 0x00d3 }
            r3.marker = r6     // Catch:{ all -> 0x00d3 }
        L_0x0096:
            com.didi.common.map.model.Marker r5 = r3.marker_direct     // Catch:{ all -> 0x00d3 }
            if (r5 == 0) goto L_0x00a3
            com.didi.common.map.Map r5 = r8.f27159d     // Catch:{ all -> 0x00d3 }
            com.didi.common.map.model.Marker r7 = r3.marker_direct     // Catch:{ all -> 0x00d3 }
            r5.remove(r7)     // Catch:{ all -> 0x00d3 }
            r3.marker_direct = r6     // Catch:{ all -> 0x00d3 }
        L_0x00a3:
            java.lang.String r5 = "PassengerMarkerDrawer"
            java.lang.String r6 = "removeMarkerSet : ok"
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ all -> 0x00d3 }
            com.didi.common.map.util.DLog.m7384d(r5, r6, r7)     // Catch:{ all -> 0x00d3 }
        L_0x00ad:
            java.util.List<com.didi.map.global.flow.scene.vamos.sctx.driver.psglocation.PassengerMarkerSet> r5 = r8.f27160e     // Catch:{ all -> 0x00d3 }
            r5.remove(r4)     // Catch:{ all -> 0x00d3 }
            java.lang.String r4 = "PassengerMarkerDrawer"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d3 }
            r5.<init>()     // Catch:{ all -> 0x00d3 }
            java.lang.String r6 = "removeMarkerSet : "
            r5.append(r6)     // Catch:{ all -> 0x00d3 }
            java.lang.String r3 = r3.f27162id     // Catch:{ all -> 0x00d3 }
            r5.append(r3)     // Catch:{ all -> 0x00d3 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x00d3 }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ all -> 0x00d3 }
            com.didi.common.map.util.DLog.m7384d(r4, r3, r5)     // Catch:{ all -> 0x00d3 }
        L_0x00cd:
            int r1 = r1 + -1
            goto L_0x0018
        L_0x00d1:
            monitor-exit(r0)     // Catch:{ all -> 0x00d3 }
            return
        L_0x00d3:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00d3 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.vamos.sctx.driver.psglocation.PassengerMarkerDrawer.removeInvalidPassengerMarkers(java.util.List):void");
    }

    /* renamed from: a */
    private PassengerMarkerSet m19192a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f27161f) {
            if (this.f27160e != null) {
                for (PassengerMarkerSet next : this.f27160e) {
                    if (next != null && str.compareTo(next.f27162id) == 0) {
                        return next;
                    }
                }
            } else {
                this.f27160e = new ArrayList();
            }
            PassengerMarkerSet passengerMarkerSet = new PassengerMarkerSet(str);
            this.f27160e.add(passengerMarkerSet);
            return passengerMarkerSet;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m19193a(com.didi.map.global.flow.scene.vamos.sctx.driver.psglocation.PassengerMarkerSet r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f27161f
            monitor-enter(r0)
            if (r5 != 0) goto L_0x0007
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            return
        L_0x0007:
            com.didi.common.map.Map r1 = r4.f27159d     // Catch:{ all -> 0x004d }
            if (r1 == 0) goto L_0x0042
            com.didi.common.map.model.Marker r1 = r5.marker     // Catch:{ all -> 0x004d }
            r2 = 0
            if (r1 == 0) goto L_0x0019
            com.didi.common.map.Map r1 = r4.f27159d     // Catch:{ all -> 0x004d }
            com.didi.common.map.model.Marker r3 = r5.marker     // Catch:{ all -> 0x004d }
            r1.remove(r3)     // Catch:{ all -> 0x004d }
            r5.marker = r2     // Catch:{ all -> 0x004d }
        L_0x0019:
            com.didi.common.map.model.Marker r1 = r5.marker_direct     // Catch:{ all -> 0x004d }
            if (r1 == 0) goto L_0x0026
            com.didi.common.map.Map r1 = r4.f27159d     // Catch:{ all -> 0x004d }
            com.didi.common.map.model.Marker r3 = r5.marker_direct     // Catch:{ all -> 0x004d }
            r1.remove(r3)     // Catch:{ all -> 0x004d }
            r5.marker_direct = r2     // Catch:{ all -> 0x004d }
        L_0x0026:
            java.lang.String r1 = "PassengerMarkerDrawer"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x004d }
            r2.<init>()     // Catch:{ all -> 0x004d }
            java.lang.String r3 = "removeMarkerSet : "
            r2.append(r3)     // Catch:{ all -> 0x004d }
            java.lang.String r3 = r5.f27162id     // Catch:{ all -> 0x004d }
            r2.append(r3)     // Catch:{ all -> 0x004d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x004d }
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x004d }
            com.didi.common.map.util.DLog.m7384d(r1, r2, r3)     // Catch:{ all -> 0x004d }
        L_0x0042:
            java.util.List<com.didi.map.global.flow.scene.vamos.sctx.driver.psglocation.PassengerMarkerSet> r1 = r4.f27160e     // Catch:{ all -> 0x004d }
            if (r1 == 0) goto L_0x004b
            java.util.List<com.didi.map.global.flow.scene.vamos.sctx.driver.psglocation.PassengerMarkerSet> r1 = r4.f27160e     // Catch:{ all -> 0x004d }
            r1.remove(r5)     // Catch:{ all -> 0x004d }
        L_0x004b:
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            return
        L_0x004d:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.vamos.sctx.driver.psglocation.PassengerMarkerDrawer.m19193a(com.didi.map.global.flow.scene.vamos.sctx.driver.psglocation.PassengerMarkerSet):void");
    }

    public boolean addPassengerMarkers(List<PassengerInfo> list, int i) {
        boolean z;
        if (list == null || list.size() == 0) {
            return false;
        }
        DLog.m7384d(f27157b, "addPassengerMarkers:start ", new Object[0]);
        synchronized (this.f27161f) {
            z = true;
            for (PassengerInfo next : list) {
                if (next.getGpsLocation() != null) {
                    if (System.currentTimeMillis() - next.getGpsLocation().time <= 30000 || next.getGpsLocation().time == 0) {
                        if (next.getGpsLocation() != null) {
                            z = addPassengerMarker(next, i);
                        }
                    }
                }
                DLog.m7384d(f27157b, "addPassengerMarkers: passenger location is invalid!", new Object[0]);
                PassengerMarkerSet a = m19192a(next.getId());
                if (a != null) {
                    m19193a(a);
                }
            }
        }
        return z;
    }

    public boolean addPassengerMarker(PassengerInfo passengerInfo, int i) {
        PassengerMarkerSet a;
        BitmapDescriptor a2;
        BitmapDescriptor a3;
        if (passengerInfo == null || (a = m19192a(passengerInfo.getId())) == null) {
            return false;
        }
        if (a.marker != null) {
            if (LatLngUtils.locateCorrect(passengerInfo.getGpsLocation().latitude, passengerInfo.getGpsLocation().longitude)) {
                a.marker.setPosition(new LatLng(passengerInfo.getGpsLocation().latitude, passengerInfo.getGpsLocation().longitude));
                if (a.marker_direct != null) {
                    a.marker_direct.setPosition(new LatLng(passengerInfo.getGpsLocation().latitude, passengerInfo.getGpsLocation().longitude));
                    a.marker_direct.setRotation(passengerInfo.getGpsLocation().direction);
                }
                DLog.m7384d(f27157b, "updatePassengerMarker:" + passengerInfo.toString(), new Object[0]);
            }
            a.marker.setZIndex(i);
            if (a.marker_direct != null) {
                a.marker_direct.setZIndex(i - 1);
            }
            if (!(passengerInfo.getHeadIcon() == null || (a3 = m19190a(passengerInfo.getHeadIcon(), a.marker.getIcon().getBitmap().getWidth(), a.marker.getIcon().getBitmap().getHeight())) == null || this.f27158c == null)) {
                a.marker.setIcon(this.f27158c, a3);
            }
        } else {
            if (LatLngUtils.locateCorrect(passengerInfo.getGpsLocation().latitude, passengerInfo.getGpsLocation().longitude)) {
                a.marker = m19191a(R.drawable.passenger_map_location_nodirect, new LatLng(passengerInfo.getGpsLocation().latitude, passengerInfo.getGpsLocation().longitude), 0.0f, 0.5f, 0.5f, i);
                if (a.marker != null) {
                    if (!(passengerInfo.getHeadIcon() == null || (a2 = m19190a(passengerInfo.getHeadIcon(), a.marker.getIcon().getBitmap().getWidth(), a.marker.getIcon().getBitmap().getHeight())) == null || this.f27158c == null)) {
                        a.marker.setIcon(this.f27158c, a2);
                    }
                    DLog.m7384d(f27157b, "addPassengerMarker:" + passengerInfo.toString(), new Object[0]);
                }
            }
            if (!TextUtils.isEmpty(passengerInfo.getOrderId())) {
                VamosDriverSctxOmegaUtil.onPaxLocationShow();
            }
        }
        return true;
    }

    /* renamed from: a */
    private Marker m19191a(int i, LatLng latLng, float f, float f2, float f3, int i2) {
        Context context;
        if (this.f27159d == null || (context = this.f27158c) == null) {
            return null;
        }
        MarkerOptions rotation = new MarkerOptions().anchor(f2, f3).icon(BitmapDescriptorFactory.fromBitmap(m19189a(this.f27158c, BitmapDescriptorFactory.fromResource(context, i).getBitmap()))).position(new LatLng(latLng.latitude, latLng.longitude)).rotation(f);
        rotation.flat(false);
        rotation.zIndex(i2);
        return this.f27159d.addMarker(rotation);
    }

    /* renamed from: a */
    private Bitmap m19189a(Context context, Bitmap bitmap) {
        float f = context.getResources().getDisplayMetrics().density / 3.0f;
        if (f == 1.0f) {
            return bitmap;
        }
        return ImageUtil.scale(bitmap, ((float) bitmap.getWidth()) * f, ((float) bitmap.getHeight()) * f, ImageView.ScaleType.CENTER_CROP, true);
    }

    /* renamed from: a */
    private BitmapDescriptor m19190a(Bitmap bitmap, int i, int i2) {
        Bitmap extractThumbnail;
        if (bitmap == null || bitmap.isRecycled() || (extractThumbnail = ThumbnailUtils.extractThumbnail(ImageUtil.getCircleBitmap(bitmap), i, i2, 2)) == null) {
            return null;
        }
        return BitmapDescriptorFactory.fromBitmap(extractThumbnail);
    }
}
