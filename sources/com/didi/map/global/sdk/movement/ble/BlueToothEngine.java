package com.didi.map.global.sdk.movement.ble;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.common.sensor.OrientationListener;
import com.didi.common.sensor.OrientationManager;
import com.didi.map.global.sdk.movement.apollo.ApolloParamRssi2Distance;
import com.didi.map.global.sdk.movement.apollo.MovementApolloUtil;
import com.didi.map.global.sdk.movement.omega.MovementOmegaUtil;
import com.didi.map.global.sdk.movement.sensor.DidiMovementManager;
import com.didi.map.global.sdk.movement.sensor.Movement;
import com.didi.map.global.sdk.movement.sensor.PdrPoint;
import com.didi.map.global.sdk.movement.sensor.SMAHandler;
import com.didi.map.global.sdk.movement.sensor.WorkThread;
import com.didi.map.global.sdk.movement.sensor.onDidiMovementListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BlueToothEngine implements OrientationListener, iBluetoothNav {
    public static final int STATUS_ARRIVED = 12;
    public static final int STATUS_TOWARDS = 11;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final float f27714a = MovementApolloUtil.getEngineValidAcc();

    /* renamed from: b */
    private static final String f27715b = "BlueToothEngine";

    /* renamed from: c */
    private Context f27716c;

    /* renamed from: d */
    private onBleNavListener f27717d;

    /* renamed from: e */
    private WorkThread f27718e;

    /* renamed from: f */
    private long f27719f;

    /* renamed from: g */
    private float f27720g = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public PdrPoint f27721h;

    /* renamed from: i */
    private List<BluetoothPoint> f27722i;

    /* renamed from: j */
    private LocationInfo f27723j;

    /* renamed from: k */
    private LocationInfo f27724k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public PdrPoint[] f27725l;

    /* renamed from: m */
    private List<BluetoothPoint> f27726m;

    /* renamed from: n */
    private long f27727n;

    /* renamed from: o */
    private SMAHandler f27728o = new SMAHandler(5);

    /* renamed from: p */
    private CacheNavInfo f27729p;

    /* renamed from: q */
    private volatile int f27730q = 11;

    /* renamed from: r */
    private int f27731r;

    /* renamed from: s */
    private final String f27732s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public final Handler f27733t = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                BlueToothEngine.this.m19868a((CacheNavInfo) message.obj);
            }
        }
    };

    public static class CacheNavInfo {
        public BleNavGuide gps;
        public BleNavGuide normal;
        public BleNavGuide pdr;
        public boolean strong;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public float m19862a(double d) {
        return (float) ((d + 360.0d) % 360.0d);
    }

    public BlueToothEngine(Context context, String str) {
        DLog.m7384d(f27715b, "构造函数", new Object[0]);
        this.f27716c = context;
        this.f27732s = str;
        this.f27718e = new WorkThread();
        DidiMovementManager.getInstance(context).start(new onDidiMovementListener() {
            public void onMovementChanged(Movement movement) {
            }

            public void onNewStep(int i) {
            }

            public void onPrintLog(String str) {
            }

            public void onShowLine(float f) {
            }

            public void onPdrPointChanged(PdrPoint pdrPoint) {
                PdrPoint unused = BlueToothEngine.this.f27721h = pdrPoint;
            }
        });
        OrientationManager.getInstance(context).addOrientationListener(this);
    }

    public void onOrientationChanged(float f, float f2, float f3) {
        this.f27720g = m19862a((double) f);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19868a(CacheNavInfo cacheNavInfo) {
        if (cacheNavInfo == null) {
            return;
        }
        if (this.f27730q == 12) {
            DLog.m7384d(f27715b, "onNewBleNavGuide: 到达后直接返回", new Object[0]);
            return;
        }
        BleNavGuide bleNavGuide = null;
        if (cacheNavInfo.gps != null) {
            this.f27717d.onBleNavGuide(cacheNavInfo.gps);
            MovementOmegaUtil.reportOmegaBTNav(this.f27732s, cacheNavInfo, 0);
            BleNavGuide bleNavGuide2 = cacheNavInfo.gps;
            this.f27729p = null;
            DLog.m7384d(f27715b, "onNewBleNavGuide: 使用gps结果 " + cacheNavInfo.gps, new Object[0]);
            bleNavGuide = bleNavGuide2;
        } else if (cacheNavInfo.pdr != null) {
            this.f27717d.onBleNavGuide(cacheNavInfo.pdr);
            MovementOmegaUtil.reportOmegaBTNav(this.f27732s, cacheNavInfo, 1);
            this.f27729p = null;
            bleNavGuide = cacheNavInfo.pdr;
            DLog.m7384d(f27715b, "onNewBleNavGuide: 使用pdr结果 " + cacheNavInfo.pdr, new Object[0]);
        } else if (cacheNavInfo.normal != null) {
            CacheNavInfo cacheNavInfo2 = this.f27729p;
            if (!(cacheNavInfo2 == null || cacheNavInfo2.normal == null)) {
                double a = m19860a((double) cacheNavInfo.normal.direct_pax_toDriver, (double) this.f27729p.normal.direct_pax_toDriver);
                DLog.m7384d(f27715b, "onNewBleNavGuide: 判断是否使用结果diff：" + a, new Object[0]);
                if (a < 30.0d) {
                    BleNavGuide bleNavGuide3 = cacheNavInfo.normal;
                    this.f27717d.onBleNavGuide(cacheNavInfo.normal);
                    MovementOmegaUtil.reportOmegaBTNav(this.f27732s, cacheNavInfo, 2);
                    bleNavGuide = bleNavGuide3;
                }
            }
            this.f27729p = cacheNavInfo;
        }
        if (bleNavGuide != null) {
            if (bleNavGuide.eda < 5.0d) {
                this.f27731r++;
            } else {
                this.f27731r = 0;
            }
        }
        if (this.f27731r > 2 && bleNavGuide != null) {
            this.f27730q = 12;
            DLog.m7384d(f27715b, "onNewBleNavGuide: 已到达", new Object[0]);
            onBleNavListener onblenavlistener = this.f27717d;
            if (onblenavlistener != null) {
                onblenavlistener.onNavArrived((int) bleNavGuide.eda);
            }
        }
    }

    public void setOnBleNavListener(onBleNavListener onblenavlistener) {
        this.f27717d = onblenavlistener;
    }

    public void onReceiveDriverLocation(LocationInfo locationInfo) {
        this.f27723j = locationInfo;
    }

    public void onReceivePaxLocation(LocationInfo locationInfo) {
        this.f27724k = locationInfo;
    }

    public void onReceiveRssi(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f27722i == null || this.f27726m == null) {
            this.f27722i = new ArrayList();
            this.f27726m = new ArrayList();
        }
        this.f27726m.add(new BluetoothPoint(i, this.f27720g, currentTimeMillis, this.f27723j, this.f27724k, this.f27721h));
        if (currentTimeMillis - this.f27727n > 1000) {
            this.f27727n = currentTimeMillis;
            this.f27722i.addAll(m19867a(this.f27726m));
            this.f27726m.clear();
            if (this.f27722i.size() > 30) {
                List<BluetoothPoint> list = this.f27722i;
                list.subList(0, list.size() - 30).clear();
            }
        }
        if (currentTimeMillis - this.f27719f > 3000) {
            this.f27719f = currentTimeMillis;
            this.f27718e.executeTask(new NavTask(this.f27722i));
        }
    }

    public void onDestroy() {
        DLog.m7384d(f27715b, "onDestroy ", new Object[0]);
        Context context = this.f27716c;
        if (context != null) {
            DidiMovementManager.getInstance(context).stop();
            OrientationManager.getInstance(this.f27716c).removeOrientationListener(this);
            this.f27716c = null;
        }
        WorkThread workThread = this.f27718e;
        if (workThread != null) {
            workThread.destroy();
            this.f27718e = null;
        }
        SMAHandler sMAHandler = this.f27728o;
        if (sMAHandler != null) {
            sMAHandler.destroy();
            this.f27728o = null;
        }
    }

    public class NavTask implements Runnable {
        private final List<BluetoothPoint> list;

        public NavTask(List<BluetoothPoint> list2) {
            this.list = new ArrayList(list2);
        }

        public void run() {
            PdrPoint[] driverPoint;
            DLog.m7384d(BlueToothEngine.f27715b, "NavTask run!!!!!    " + hashCode(), new Object[0]);
            if (this.list.size() >= 2) {
                LocationInfo locationInfo = null;
                LocationInfo locationInfo2 = null;
                BluetoothPoint bluetoothPoint = null;
                BluetoothPoint bluetoothPoint2 = null;
                for (int size = this.list.size() - 1; size > 0; size--) {
                    BluetoothPoint bluetoothPoint3 = this.list.get(size);
                    if (!(bluetoothPoint3 == null || bluetoothPoint3.point == null)) {
                        if (bluetoothPoint == null || bluetoothPoint2 == null) {
                            bluetoothPoint = bluetoothPoint3;
                            bluetoothPoint2 = bluetoothPoint;
                        } else {
                            if (bluetoothPoint3.rssi > bluetoothPoint2.rssi) {
                                bluetoothPoint2 = bluetoothPoint3;
                            }
                            if (bluetoothPoint3.rssi < bluetoothPoint.rssi) {
                                bluetoothPoint = bluetoothPoint3;
                            }
                        }
                    }
                    if (bluetoothPoint3 != null && locationInfo == null && bluetoothPoint3.driverLoc != null && bluetoothPoint3.driverLoc.isAvailable()) {
                        locationInfo = bluetoothPoint3.driverLoc;
                    }
                    if (bluetoothPoint3 != null && locationInfo2 == null && bluetoothPoint3.paxLoc != null && bluetoothPoint3.paxLoc.isAvailable()) {
                        locationInfo2 = bluetoothPoint3.paxLoc;
                    }
                }
                CacheNavInfo cacheNavInfo = new CacheNavInfo();
                if (locationInfo != null && locationInfo.isAvailable() && locationInfo2 != null && locationInfo2.isAvailable()) {
                    BleNavGuide bleNavGuide = new BleNavGuide();
                    bleNavGuide.eda = DDSphericalUtil.computeDistanceBetween(locationInfo2.pos, locationInfo.pos);
                    bleNavGuide.direct_pax_toDriver = BlueToothEngine.this.m19862a(DDSphericalUtil.computeHeading(locationInfo2.pos, locationInfo.pos));
                    bleNavGuide.type = 0;
                    cacheNavInfo.gps = bleNavGuide;
                }
                if (!(bluetoothPoint2 == null || bluetoothPoint == null || Math.abs(bluetoothPoint2.rssi - bluetoothPoint.rssi) <= 0)) {
                    double a = (double) BlueToothEngine.this.m19862a((double) PdrPoint.getDirectBetweenPoints(bluetoothPoint.point, bluetoothPoint2.point));
                    double distanceBetweenPoints = (double) PdrPoint.getDistanceBetweenPoints(bluetoothPoint2.point, bluetoothPoint.point);
                    if (bluetoothPoint2.paxLoc != null && bluetoothPoint2.paxLoc.isAvailable() && bluetoothPoint.paxLoc != null && bluetoothPoint.paxLoc.isAvailable()) {
                        a = DDSphericalUtil.computeHeading(bluetoothPoint.paxLoc.pos, bluetoothPoint.paxLoc.pos);
                        distanceBetweenPoints = DDSphericalUtil.computeDistanceBetween(bluetoothPoint.paxLoc.pos, bluetoothPoint.paxLoc.pos);
                    }
                    double d = distanceBetweenPoints;
                    double d2 = a;
                    boolean z = bluetoothPoint2.time > bluetoothPoint.time || bluetoothPoint.time <= bluetoothPoint2.time;
                    cacheNavInfo.strong = z;
                    boolean z2 = !Double.isNaN(d) && d > 0.001d && !Double.isNaN(d2);
                    if (z2) {
                        BleNavGuide bleNavGuide2 = new BleNavGuide();
                        bleNavGuide2.direct_pax_toDriver = BlueToothEngine.this.m19862a(d2);
                        bleNavGuide2.eda = (double) BlueToothEngine.this.m19863a(z ? bluetoothPoint2.rssi : bluetoothPoint.rssi);
                        bleNavGuide2.type = 2;
                        cacheNavInfo.normal = bleNavGuide2;
                    }
                    if (z2 && (driverPoint = getDriverPoint(bluetoothPoint2.point, BlueToothEngine.this.m19863a(bluetoothPoint.rssi), BlueToothEngine.this.m19863a(bluetoothPoint2.rssi), d, d2)) != null) {
                        PdrPoint mergeNavInfo = mergeNavInfo(BlueToothEngine.this.f27725l, driverPoint);
                        PdrPoint[] unused = BlueToothEngine.this.f27725l = driverPoint;
                        if (mergeNavInfo != null) {
                            float directBetweenPoints = PdrPoint.getDirectBetweenPoints(bluetoothPoint2.point, mergeNavInfo);
                            BleNavGuide bleNavGuide3 = new BleNavGuide();
                            bleNavGuide3.direct_pax_toDriver = BlueToothEngine.this.m19862a((double) directBetweenPoints);
                            bleNavGuide3.eda = (double) BlueToothEngine.this.m19863a(z ? bluetoothPoint2.rssi : bluetoothPoint.rssi);
                            bleNavGuide3.type = 1;
                            cacheNavInfo.pdr = bleNavGuide3;
                        }
                    }
                }
                callBack(cacheNavInfo);
            }
        }

        private PdrPoint mergeNavInfo(PdrPoint[] pdrPointArr, PdrPoint[] pdrPointArr2) {
            if (pdrPointArr == null || pdrPointArr2 == null || pdrPointArr.length != 2 || pdrPointArr2.length != 2) {
                return null;
            }
            float distanceBetweenPoints = PdrPoint.getDistanceBetweenPoints(pdrPointArr[0], pdrPointArr2[0]);
            float distanceBetweenPoints2 = PdrPoint.getDistanceBetweenPoints(pdrPointArr[0], pdrPointArr2[1]);
            float distanceBetweenPoints3 = PdrPoint.getDistanceBetweenPoints(pdrPointArr[1], pdrPointArr2[0]);
            float distanceBetweenPoints4 = PdrPoint.getDistanceBetweenPoints(pdrPointArr[1], pdrPointArr2[1]);
            float min = Math.min(Math.min(Math.min(distanceBetweenPoints, distanceBetweenPoints2), distanceBetweenPoints3), distanceBetweenPoints4);
            if (min >= 20.0f) {
                return null;
            }
            if (min == distanceBetweenPoints || min == distanceBetweenPoints3) {
                return pdrPointArr2[0];
            }
            if (min == distanceBetweenPoints2 || min == distanceBetweenPoints4) {
                return pdrPointArr2[1];
            }
            return null;
        }

        private PdrPoint[] getDriverPoint(PdrPoint pdrPoint, float f, float f2, double d, double d2) {
            if (!BlueToothEngine.this.m19870a((double) f, (double) f2, d)) {
                return null;
            }
            double d3 = ((((double) (f * f)) + (d * d)) - ((double) (f2 * f2))) / (((double) (2.0f * f)) * d);
            if (d3 < -1.0d || d3 > 1.0d) {
                return null;
            }
            double degrees = (double) ((float) Math.toDegrees(Math.acos(d3)));
            return new PdrPoint[]{PdrPoint.getNextPoint(pdrPoint, f, BlueToothEngine.this.m19862a((d2 + 180.0d) - degrees)), PdrPoint.getNextPoint(pdrPoint, f, BlueToothEngine.this.m19862a((d2 - 180.0d) + degrees))};
        }

        private void callBack(CacheNavInfo cacheNavInfo) {
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.obj = cacheNavInfo;
            BlueToothEngine.this.f27733t.sendMessage(obtain);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public float m19863a(int i) {
        int abs = Math.abs(i);
        ApolloParamRssi2Distance apolloParamRssi2Distance = MovementApolloUtil.getApolloParamRssi2Distance();
        return (float) Math.pow(10.0d, (((double) abs) - apolloParamRssi2Distance.A_Value) / (apolloParamRssi2Distance.n_Value * 10.0d));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m19870a(double d, double d2, double d3) {
        return !Double.isNaN(d) && !Double.isNaN(d2) && !Double.isNaN(d3) && d + d2 > d3 && d + d3 > d2 && d2 + d3 > d;
    }

    /* renamed from: a */
    private double m19860a(double d, double d2) {
        double abs = Math.abs(d - d2);
        return abs > 180.0d ? 360.0d - abs : abs;
    }

    public static class LocationInfo {
        public float acc;
        public LatLng pos;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LocationInfo :");
            LatLng latLng = this.pos;
            sb.append(latLng == null ? "pos= null" : latLng.toString());
            sb.append(", acc =");
            sb.append(this.acc);
            return sb.toString();
        }

        public boolean isAvailable() {
            return LatLngUtils.locateCorrect(this.pos) && this.acc <= BlueToothEngine.f27714a;
        }
    }

    /* renamed from: a */
    private List<BluetoothPoint> m19867a(List<BluetoothPoint> list) {
        if (CollectionUtil.isEmpty((Collection<?>) list) || list.size() < 2) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        double b = (double) m19874b(list);
        double d = 0.0d;
        for (BluetoothPoint next : list) {
            if (next != null) {
                d += (((double) next.rssi) - b) * (((double) next.rssi) - b);
            }
        }
        double sqrt = Math.sqrt(d / ((double) (list.size() - 1)));
        for (BluetoothPoint next2 : list) {
            if (this.f27728o != null && next2 != null && ((double) next2.rssi) <= b + sqrt && ((double) next2.rssi) >= b - sqrt) {
                next2.rssi = (int) this.f27728o.handleValues((float) next2.rssi);
                arrayList.add(next2);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private int m19874b(List<BluetoothPoint> list) {
        int i = 0;
        for (BluetoothPoint bluetoothPoint : list) {
            i += bluetoothPoint.rssi;
        }
        return i / list.size();
    }
}
