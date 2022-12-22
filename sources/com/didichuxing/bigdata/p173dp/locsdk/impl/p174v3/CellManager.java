package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3;

import android.content.Context;
import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.didi.mapbizinterface.utils.ReflectUtils;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.bigdata.p173dp.locsdk.Cgi;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.ICellManager;
import com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils;
import com.didichuxing.bigdata.p173dp.locsdk.utils.Utils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.CellManager */
public class CellManager implements ICellManager {

    /* renamed from: m */
    private static final int f45780m = Integer.MAX_VALUE;

    /* renamed from: a */
    private Context f45781a;

    /* renamed from: b */
    private boolean f45782b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f45783c;

    /* renamed from: d */
    private volatile List<Cgi> f45784d;

    /* renamed from: e */
    private volatile Cgi f45785e;

    /* renamed from: f */
    private int f45786f;

    /* renamed from: g */
    private TelephonyManager f45787g;

    /* renamed from: h */
    private Object f45788h;

    /* renamed from: i */
    private long f45789i;

    /* renamed from: j */
    private PhoneStateListener f45790j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public CellLocation f45791k;

    /* renamed from: l */
    private String f45792l;

    public void setPhnum() {
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.CellManager$SingletonHolder */
    private static class SingletonHolder {
        static final CellManager sInstance = new CellManager();

        private SingletonHolder() {
        }
    }

    public static CellManager getInstance() {
        return SingletonHolder.sInstance;
    }

    private CellManager() {
        this.f45782b = false;
        this.f45783c = 0;
        this.f45784d = new ArrayList();
        this.f45785e = null;
        this.f45786f = Const.iDefCgiSig;
        this.f45789i = 0;
        this.f45792l = "CellManager";
    }

    public static int getSim2T() {
        int i;
        try {
            Class.forName("android.telephony.MSimTelephonyManager");
            i = 1;
        } catch (Exception unused) {
            i = 0;
        }
        if (i == 0) {
            try {
                Class.forName("android.telephony.TelephonyManager2");
                i = 2;
            } catch (Exception unused2) {
            }
        }
        if (i == 0) {
            DLog.m32737d("sim2 default");
        }
        return i;
    }

    public synchronized void init(Context context) {
        if (!this.f45782b) {
            this.f45781a = context;
            if (context == null) {
                DLog.m32737d("CellManager::init context is null");
                return;
            }
            TelephonyManager telephonyManager = (TelephonyManager) Utils.getServ(context, "phone");
            this.f45787g = telephonyManager;
            try {
                this.f45783c = Utils.getCellLocT(telephonyManager.getCellLocation(), this.f45781a);
                m32806f();
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            m32803e();
            this.f45782b = true;
        }
    }

    public List<Cgi> getDetectedCgiList() {
        return this.f45784d != null ? new ArrayList(this.f45784d) : new ArrayList();
    }

    public Cgi getLastDetectedCgiInfo() {
        return this.f45785e;
    }

    public int getMainCgiType() {
        return this.f45783c;
    }

    public String getDeviceId() {
        String str;
        try {
            str = SystemUtil.getIMEI();
        } catch (Exception unused) {
            str = null;
        }
        return str == null ? "" : str;
    }

    public CellLocation getCellLocation() {
        TelephonyManager telephonyManager = this.f45787g;
        CellLocation cellLocation = null;
        if (telephonyManager != null) {
            try {
                cellLocation = telephonyManager.getCellLocation();
                if (cgiUseful(cellLocation)) {
                    this.f45791k = cellLocation;
                }
            } catch (Exception unused) {
            }
        }
        return cellLocation;
    }

    public CellLocation getLastCellLocation() {
        return this.f45791k;
    }

    public TelephonyManager getTelephonyManagerInstance() {
        return this.f45787g;
    }

    public void refresh() {
        m32789a();
    }

    public void reset() {
        m32807g();
    }

    public void requestCgiLocationUpdate() {
        m32803e();
    }

    public synchronized void destroy() {
        if (this.f45782b) {
            if (!(this.f45787g == null || this.f45790j == null)) {
                try {
                    DLog.m32737d("cell unregister listener");
                    this.f45787g.listen(this.f45790j, 0);
                } catch (Exception e) {
                    DLog.m32737d(e.toString());
                }
            }
            if (this.f45784d != null) {
                this.f45784d.clear();
            }
            this.f45786f = Const.iDefCgiSig;
            this.f45785e = null;
            this.f45787g = null;
            this.f45788h = null;
            this.f45782b = false;
        }
    }

    public void refineCellT() {
        int i = this.f45783c;
        if (i != 1) {
            if (i == 2 && this.f45784d != null && this.f45784d.isEmpty()) {
                DLog.m32737d("refine cell cdma2def");
                this.f45783c = 0;
            }
        } else if (this.f45784d != null && this.f45784d.isEmpty()) {
            DLog.m32737d("refine cgi gsm2def");
            this.f45783c = 0;
        }
    }

    public boolean cgiNeedUpdate(boolean z) {
        if (z || this.f45789i == 0 || Utils.getTimeBoot() - this.f45789i < 10000) {
            return false;
        }
        return true;
    }

    public boolean isCellValid() {
        CellLocation cellLocation = this.f45791k;
        return cellLocation != null && cgiUseful(cellLocation) && Utils.getTimeBoot() - this.f45789i <= 10000;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        if (r6.getBaseStationId() < 0) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cgiUseful(android.telephony.CellLocation r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.content.Context r1 = r5.f45781a
            int r1 = com.didichuxing.bigdata.p173dp.locsdk.utils.Utils.getCellLocT(r6, r1)
            r2 = 1
            if (r1 == r2) goto L_0x004e
            r3 = 2
            if (r1 == r3) goto L_0x0012
            goto L_0x009f
        L_0x0012:
            boolean r1 = r6 instanceof android.telephony.cdma.CdmaCellLocation     // Catch:{ Exception -> 0x002f }
            if (r1 == 0) goto L_0x009f
            android.telephony.cdma.CdmaCellLocation r6 = (android.telephony.cdma.CdmaCellLocation) r6     // Catch:{ Exception -> 0x002f }
            int r1 = r6.getSystemId()     // Catch:{ Exception -> 0x002f }
            if (r1 > 0) goto L_0x0021
        L_0x001e:
            r2 = 0
            goto L_0x009f
        L_0x0021:
            int r1 = r6.getNetworkId()     // Catch:{ Exception -> 0x002f }
            if (r1 >= 0) goto L_0x0028
            goto L_0x001e
        L_0x0028:
            int r6 = r6.getBaseStationId()     // Catch:{ Exception -> 0x002f }
            if (r6 >= 0) goto L_0x009f
            goto L_0x001e
        L_0x002f:
            r6 = move-exception
            java.lang.String r1 = "cgiUseful"
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackReflectError(r6, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = r5.f45792l
            r1.append(r3)
            java.lang.String r6 = r6.toString()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r6)
            goto L_0x009f
        L_0x004e:
            android.telephony.gsm.GsmCellLocation r6 = (android.telephony.gsm.GsmCellLocation) r6
            int r1 = r6.getLac()
            r3 = -1
            if (r1 != r3) goto L_0x0059
        L_0x0057:
            r2 = 0
            goto L_0x0089
        L_0x0059:
            int r1 = r6.getLac()
            if (r1 != 0) goto L_0x0060
            goto L_0x0057
        L_0x0060:
            int r1 = r6.getLac()
            r4 = 65535(0xffff, float:9.1834E-41)
            if (r1 <= r4) goto L_0x006a
            goto L_0x0057
        L_0x006a:
            int r1 = r6.getCid()
            if (r1 != r3) goto L_0x0071
            goto L_0x0057
        L_0x0071:
            int r1 = r6.getCid()
            if (r1 != 0) goto L_0x0078
            goto L_0x0057
        L_0x0078:
            int r1 = r6.getCid()
            if (r1 != r4) goto L_0x007f
            goto L_0x0057
        L_0x007f:
            int r1 = r6.getCid()
            r3 = 268435455(0xfffffff, float:2.5243547E-29)
            if (r1 < r3) goto L_0x0089
            goto L_0x0057
        L_0x0089:
            int r6 = r6.getCid()
            r1 = 8
            if (r6 == r1) goto L_0x009a
            r1 = 10
            if (r6 == r1) goto L_0x009a
            r1 = 33
            if (r6 == r1) goto L_0x009a
            goto L_0x009f
        L_0x009a:
            java.lang.String r6 = "cgi|fake"
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r6)
        L_0x009f:
            if (r2 != 0) goto L_0x00a3
            r5.f45783c = r0
        L_0x00a3:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.CellManager.cgiUseful(android.telephony.CellLocation):boolean");
    }

    public boolean cgiUseful(NeighboringCellInfo neighboringCellInfo) {
        if (neighboringCellInfo == null || neighboringCellInfo.getLac() == -1 || neighboringCellInfo.getLac() == 0 || neighboringCellInfo.getLac() > 65535 || neighboringCellInfo.getCid() == -1 || neighboringCellInfo.getCid() == 0 || neighboringCellInfo.getCid() == 65535 || neighboringCellInfo.getCid() >= 268435455) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d4, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m32789a() {
        /*
            r5 = this;
            monitor-enter(r5)
            android.content.Context r0 = r5.f45781a     // Catch:{ all -> 0x00d5 }
            boolean r0 = com.didichuxing.bigdata.p173dp.locsdk.utils.Utils.airPlaneModeOn(r0)     // Catch:{ all -> 0x00d5 }
            if (r0 != 0) goto L_0x00d3
            android.telephony.TelephonyManager r0 = r5.f45787g     // Catch:{ all -> 0x00d5 }
            if (r0 == 0) goto L_0x00d3
            r0 = 0
            java.util.List<com.didichuxing.bigdata.dp.locsdk.Cgi> r1 = r5.f45784d     // Catch:{ all -> 0x00d5 }
            r2 = 0
            if (r1 == 0) goto L_0x0023
            java.util.List<com.didichuxing.bigdata.dp.locsdk.Cgi> r1 = r5.f45784d     // Catch:{ all -> 0x00d5 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00d5 }
            if (r1 != 0) goto L_0x0023
            java.util.List<com.didichuxing.bigdata.dp.locsdk.Cgi> r0 = r5.f45784d     // Catch:{ all -> 0x00d5 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x00d5 }
            com.didichuxing.bigdata.dp.locsdk.Cgi r0 = (com.didichuxing.bigdata.p173dp.locsdk.Cgi) r0     // Catch:{ all -> 0x00d5 }
        L_0x0023:
            java.util.List r1 = r5.m32795b()     // Catch:{ all -> 0x00d5 }
            r5.f45784d = r1     // Catch:{ all -> 0x00d5 }
            java.util.List<com.didichuxing.bigdata.dp.locsdk.Cgi> r1 = r5.f45784d     // Catch:{ all -> 0x00d5 }
            if (r1 == 0) goto L_0x0035
            java.util.List<com.didichuxing.bigdata.dp.locsdk.Cgi> r1 = r5.f45784d     // Catch:{ all -> 0x00d5 }
            int r1 = r1.size()     // Catch:{ all -> 0x00d5 }
            if (r1 != 0) goto L_0x0040
        L_0x0035:
            java.lang.String r1 = "sim1 miss"
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r1)     // Catch:{ all -> 0x00d5 }
            java.util.List r1 = r5.m32799c()     // Catch:{ all -> 0x00d5 }
            r5.f45784d = r1     // Catch:{ all -> 0x00d5 }
        L_0x0040:
            java.util.List<com.didichuxing.bigdata.dp.locsdk.Cgi> r1 = r5.f45784d     // Catch:{ all -> 0x00d5 }
            if (r1 == 0) goto L_0x004c
            java.util.List<com.didichuxing.bigdata.dp.locsdk.Cgi> r1 = r5.f45784d     // Catch:{ all -> 0x00d5 }
            int r1 = r1.size()     // Catch:{ all -> 0x00d5 }
            if (r1 != 0) goto L_0x0051
        L_0x004c:
            java.lang.String r1 = "sim2 miss"
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r1)     // Catch:{ all -> 0x00d5 }
        L_0x0051:
            android.telephony.CellLocation r1 = r5.f45791k     // Catch:{ all -> 0x00d5 }
            boolean r1 = r5.cgiUseful((android.telephony.CellLocation) r1)     // Catch:{ all -> 0x00d5 }
            if (r1 != 0) goto L_0x0060
            java.lang.String r0 = "non sim found"
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r0)     // Catch:{ all -> 0x00d5 }
            monitor-exit(r5)
            return
        L_0x0060:
            java.util.List<com.didichuxing.bigdata.dp.locsdk.Cgi> r1 = r5.f45784d     // Catch:{ all -> 0x00d5 }
            if (r1 != 0) goto L_0x006b
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00d5 }
            r1.<init>()     // Catch:{ all -> 0x00d5 }
            r5.f45784d = r1     // Catch:{ all -> 0x00d5 }
        L_0x006b:
            android.telephony.CellLocation r1 = r5.f45791k     // Catch:{ all -> 0x00d5 }
            android.content.Context r3 = r5.f45781a     // Catch:{ all -> 0x00d5 }
            int r1 = com.didichuxing.bigdata.p173dp.locsdk.utils.Utils.getCellLocT(r1, r3)     // Catch:{ all -> 0x00d5 }
            r3 = 1
            if (r1 == r3) goto L_0x0094
            r3 = 2
            if (r1 == r3) goto L_0x008e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d5 }
            r3.<init>()     // Catch:{ all -> 0x00d5 }
            java.lang.String r4 = "cell: type unknown "
            r3.append(r4)     // Catch:{ all -> 0x00d5 }
            r3.append(r1)     // Catch:{ all -> 0x00d5 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x00d5 }
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r1)     // Catch:{ all -> 0x00d5 }
            goto L_0x00a1
        L_0x008e:
            android.telephony.CellLocation r1 = r5.f45791k     // Catch:{ all -> 0x00d5 }
            r5.m32796b((android.telephony.CellLocation) r1)     // Catch:{ all -> 0x00d5 }
            goto L_0x00a1
        L_0x0094:
            java.util.List<com.didichuxing.bigdata.dp.locsdk.Cgi> r1 = r5.f45784d     // Catch:{ all -> 0x00d5 }
            int r1 = r1.size()     // Catch:{ all -> 0x00d5 }
            if (r1 != 0) goto L_0x00a1
            android.telephony.CellLocation r1 = r5.f45791k     // Catch:{ all -> 0x00d5 }
            r5.m32791a((android.telephony.CellLocation) r1)     // Catch:{ all -> 0x00d5 }
        L_0x00a1:
            java.util.List<com.didichuxing.bigdata.dp.locsdk.Cgi> r1 = r5.f45784d     // Catch:{ all -> 0x00d5 }
            int r1 = r1.size()     // Catch:{ all -> 0x00d5 }
            if (r1 <= 0) goto L_0x00b5
            java.util.List<com.didichuxing.bigdata.dp.locsdk.Cgi> r1 = r5.f45784d     // Catch:{ all -> 0x00d5 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x00d5 }
            com.didichuxing.bigdata.dp.locsdk.Cgi r1 = (com.didichuxing.bigdata.p173dp.locsdk.Cgi) r1     // Catch:{ all -> 0x00d5 }
            int r1 = r1.type     // Catch:{ all -> 0x00d5 }
            r5.f45783c = r1     // Catch:{ all -> 0x00d5 }
        L_0x00b5:
            java.util.List<com.didichuxing.bigdata.dp.locsdk.Cgi> r1 = r5.f45784d     // Catch:{ all -> 0x00d5 }
            if (r1 == 0) goto L_0x00d3
            java.util.List<com.didichuxing.bigdata.dp.locsdk.Cgi> r1 = r5.f45784d     // Catch:{ all -> 0x00d5 }
            int r1 = r1.size()     // Catch:{ all -> 0x00d5 }
            if (r1 <= 0) goto L_0x00d3
            if (r0 == 0) goto L_0x00d3
            java.util.List<com.didichuxing.bigdata.dp.locsdk.Cgi> r1 = r5.f45784d     // Catch:{ all -> 0x00d5 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x00d5 }
            com.didichuxing.bigdata.dp.locsdk.Cgi r1 = (com.didichuxing.bigdata.p173dp.locsdk.Cgi) r1     // Catch:{ all -> 0x00d5 }
            boolean r1 = r0.isSame(r1)     // Catch:{ all -> 0x00d5 }
            if (r1 != 0) goto L_0x00d3
            r5.f45785e = r0     // Catch:{ all -> 0x00d5 }
        L_0x00d3:
            monitor-exit(r5)
            return
        L_0x00d5:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.CellManager.m32789a():void");
    }

    /* renamed from: a */
    private void m32791a(CellLocation cellLocation) {
        Cgi a;
        if (cellLocation != null && this.f45787g != null && cgiUseful(cellLocation)) {
            if (this.f45784d != null) {
                this.f45784d.add(0, m32785a(cellLocation, 5));
            }
            if (this.f45784d != null && this.f45784d.size() == 1) {
                List<NeighboringCellInfo> list = null;
                try {
                    list = this.f45787g.getNeighboringCellInfo();
                } catch (Exception | SecurityException unused) {
                }
                if (list == null || list.isEmpty()) {
                    DLog.m32737d("cell neighboring cell unknown");
                    return;
                }
                for (NeighboringCellInfo neighboringCellInfo : list) {
                    if (cgiUseful(neighboringCellInfo) && (a = m32786a(neighboringCellInfo)) != null && !this.f45784d.contains(a)) {
                        this.f45784d.add(a);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m32796b(CellLocation cellLocation) {
        Cgi a;
        if (cellLocation != null) {
            if (Utils.getSdk() < 5) {
                DLog.m32737d("do not support cdma");
                return;
            }
            try {
                if (this.f45788h != null) {
                    boolean z = false;
                    try {
                        Field declaredField = cellLocation.getClass().getDeclaredField("mGsmCellLoc");
                        if (!declaredField.isAccessible()) {
                            declaredField.setAccessible(true);
                        }
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) declaredField.get(cellLocation);
                        if (gsmCellLocation != null && cgiUseful((CellLocation) gsmCellLocation)) {
                            DLog.m32737d("get gsm cell loc");
                            this.f45791k = gsmCellLocation;
                            if (this.f45784d != null && this.f45784d.size() > 0) {
                                this.f45784d.remove(0);
                            }
                            m32791a((CellLocation) gsmCellLocation);
                            z = true;
                        }
                    } catch (Exception unused) {
                        DLog.m32737d("can not found gsm cell loc");
                    }
                    if (z) {
                        return;
                    }
                }
                if (cgiUseful(cellLocation) && (a = m32787a((Object) cellLocation, 2)) != null && this.f45784d.size() == 0) {
                    this.f45784d.add(a);
                }
            } catch (Exception e) {
                DLog.m32737d(e.toString());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x008a A[Catch:{ Exception -> 0x0090 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.didichuxing.bigdata.p173dp.locsdk.Cgi m32787a(java.lang.Object r7, int r8) {
        /*
            r6 = this;
            android.telephony.TelephonyManager r0 = r6.f45787g
            java.lang.String[] r0 = com.didichuxing.bigdata.p173dp.locsdk.utils.Utils.getMccMnc(r0)
            com.didichuxing.bigdata.dp.locsdk.Cgi r1 = new com.didichuxing.bigdata.dp.locsdk.Cgi
            r1.<init>()
            boolean r2 = r7 instanceof android.telephony.cdma.CdmaCellLocation     // Catch:{ Exception -> 0x0090 }
            r3 = 0
            if (r2 == 0) goto L_0x0054
            android.telephony.cdma.CdmaCellLocation r7 = (android.telephony.cdma.CdmaCellLocation) r7     // Catch:{ Exception -> 0x0090 }
            r0 = r0[r3]     // Catch:{ Exception -> 0x0090 }
            r1.mcc = r0     // Catch:{ Exception -> 0x0090 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0090 }
            r0.<init>()     // Catch:{ Exception -> 0x0090 }
            java.lang.String r2 = ""
            r0.append(r2)     // Catch:{ Exception -> 0x0090 }
            int r2 = r7.getSystemId()     // Catch:{ Exception -> 0x0090 }
            r0.append(r2)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0090 }
            r1.mnc_sid = r0     // Catch:{ Exception -> 0x0090 }
            int r0 = r7.getNetworkId()     // Catch:{ Exception -> 0x0090 }
            r1.lac_nid = r0     // Catch:{ Exception -> 0x0090 }
            int r0 = r7.getBaseStationId()     // Catch:{ Exception -> 0x0090 }
            r1.cid_bid = r0     // Catch:{ Exception -> 0x0090 }
            int r0 = r6.f45786f     // Catch:{ Exception -> 0x0090 }
            r1.sig = r0     // Catch:{ Exception -> 0x0090 }
            int r0 = r7.getBaseStationLatitude()     // Catch:{ Exception -> 0x0090 }
            r1.lat = r0     // Catch:{ Exception -> 0x0090 }
            int r7 = r7.getBaseStationLongitude()     // Catch:{ Exception -> 0x0090 }
            r1.lon = r7     // Catch:{ Exception -> 0x0090 }
            r1.type = r8     // Catch:{ Exception -> 0x0090 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0090 }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 / r4
            r1.detectedTs = r7     // Catch:{ Exception -> 0x0090 }
        L_0x0054:
            r7 = 1
            int r8 = r1.lat     // Catch:{ Exception -> 0x0090 }
            if (r8 < 0) goto L_0x0084
            int r8 = r1.lon     // Catch:{ Exception -> 0x0090 }
            if (r8 >= 0) goto L_0x005e
            goto L_0x0084
        L_0x005e:
            int r8 = r1.lat     // Catch:{ Exception -> 0x0090 }
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r8 != r0) goto L_0x006a
            r1.lat = r3     // Catch:{ Exception -> 0x0090 }
            r1.lon = r3     // Catch:{ Exception -> 0x0090 }
            goto L_0x0088
        L_0x006a:
            int r8 = r1.lon     // Catch:{ Exception -> 0x0090 }
            if (r8 != r0) goto L_0x0073
            r1.lat = r3     // Catch:{ Exception -> 0x0090 }
            r1.lon = r3     // Catch:{ Exception -> 0x0090 }
            goto L_0x0088
        L_0x0073:
            int r8 = r1.lat     // Catch:{ Exception -> 0x0090 }
            int r0 = r1.lon     // Catch:{ Exception -> 0x0090 }
            if (r8 != r0) goto L_0x0082
            int r8 = r1.lat     // Catch:{ Exception -> 0x0090 }
            if (r8 <= 0) goto L_0x0082
            r1.lat = r3     // Catch:{ Exception -> 0x0090 }
            r1.lon = r3     // Catch:{ Exception -> 0x0090 }
            goto L_0x0088
        L_0x0082:
            r3 = 1
            goto L_0x0088
        L_0x0084:
            r1.lat = r3     // Catch:{ Exception -> 0x0090 }
            r1.lon = r3     // Catch:{ Exception -> 0x0090 }
        L_0x0088:
            if (r3 != 0) goto L_0x0097
            java.lang.String r7 = "cdma coordinate is invalid"
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r7)     // Catch:{ Exception -> 0x0090 }
            goto L_0x0097
        L_0x0090:
            r7 = move-exception
            java.lang.String r8 = "getCdmaCgi"
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackReflectError(r7, r8)
            r1 = 0
        L_0x0097:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.CellManager.m32787a(java.lang.Object, int):com.didichuxing.bigdata.dp.locsdk.Cgi");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0052  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.didichuxing.bigdata.p173dp.locsdk.Cgi> m32795b() {
        /*
            r11 = this;
            java.lang.String r0 = "getCellLocationGemini"
            java.lang.String r1 = "getCellLocationExt"
            java.lang.String r2 = "getAllCellInfo list is empty"
            java.lang.String r3 = "getSim1Cgis"
            android.telephony.TelephonyManager r4 = r11.f45787g
            r5 = 0
            if (r4 != 0) goto L_0x000e
            return r5
        L_0x000e:
            android.content.Context r6 = r11.f45781a     // Catch:{ Exception -> 0x0030 }
            boolean r6 = com.didichuxing.bigdata.p173dp.locsdk.utils.Utils.isLocationPermissionGranted(r6)     // Catch:{ Exception -> 0x0030 }
            if (r6 == 0) goto L_0x003b
            java.util.List r6 = r4.getAllCellInfo()     // Catch:{ Exception -> 0x0030 }
            boolean r7 = com.didi.sdk.util.collection.CollectionUtil.isEmpty((java.util.Collection<?>) r6)     // Catch:{ Exception -> 0x0030 }
            if (r7 == 0) goto L_0x002b
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r2)     // Catch:{ Exception -> 0x0030 }
            java.lang.Throwable r7 = new java.lang.Throwable     // Catch:{ Exception -> 0x0030 }
            r7.<init>(r2)     // Catch:{ Exception -> 0x0030 }
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackReflectError(r7, r3)     // Catch:{ Exception -> 0x0030 }
        L_0x002b:
            java.util.List r2 = r11.m32788a((java.util.List<?>) r6)     // Catch:{ Exception -> 0x0030 }
            goto L_0x003c
        L_0x0030:
            r2 = move-exception
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackReflectError(r2, r3)
            java.lang.String r2 = r2.toString()
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r2)
        L_0x003b:
            r2 = r5
        L_0x003c:
            java.lang.String r6 = "sim1"
            r7 = 1
            if (r2 == 0) goto L_0x0052
            int r8 = r2.size()
            if (r8 <= 0) goto L_0x0052
            java.lang.String r0 = "sim1 cellLocation got 1"
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r0)
            java.lang.String r0 = "getAllCellInfo"
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackGetSimCgi(r7, r6, r0)
            return r2
        L_0x0052:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            android.telephony.CellLocation r5 = r4.getCellLocation()     // Catch:{ Exception | SecurityException -> 0x005c }
            goto L_0x005d
        L_0x005c:
        L_0x005d:
            boolean r8 = r11.cgiUseful((android.telephony.CellLocation) r5)
            if (r8 == 0) goto L_0x0073
            r11.f45791k = r5
            r11.m32792a((android.telephony.CellLocation) r5, (java.util.List<com.didichuxing.bigdata.p173dp.locsdk.Cgi>) r2)
            java.lang.String r0 = "sim1 cellLocation got 2"
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r0)
            java.lang.String r0 = "getCellLocation"
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackGetSimCgi(r7, r6, r0)
            return r2
        L_0x0073:
            r8 = 0
            java.lang.Object[] r9 = new java.lang.Object[r7]     // Catch:{ NoSuchMethodException -> 0x0088, Exception -> 0x0086 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r7)     // Catch:{ NoSuchMethodException -> 0x0088, Exception -> 0x0086 }
            r9[r8] = r10     // Catch:{ NoSuchMethodException -> 0x0088, Exception -> 0x0086 }
            java.lang.Object r9 = com.didichuxing.bigdata.p173dp.locsdk.Reflect.invokeMethod(r4, r1, r9)     // Catch:{ NoSuchMethodException -> 0x0088, Exception -> 0x0086 }
            if (r9 == 0) goto L_0x009d
            android.telephony.CellLocation r9 = (android.telephony.CellLocation) r9     // Catch:{ NoSuchMethodException -> 0x0088, Exception -> 0x0086 }
            r5 = r9
            goto L_0x009d
        L_0x0086:
            r9 = move-exception
            goto L_0x008a
        L_0x0088:
            r9 = move-exception
            goto L_0x0095
        L_0x008a:
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackReflectError(r9, r3)
            java.lang.String r9 = r9.toString()
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r9)
            goto L_0x009d
        L_0x0095:
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackReflectError(r9, r3)
            java.lang.String r9 = "sim1 getAllCellInfo failed 2"
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r9)
        L_0x009d:
            boolean r9 = r11.cgiUseful((android.telephony.CellLocation) r5)
            if (r9 == 0) goto L_0x00b1
            java.lang.String r0 = "sim1 getAllCellInfo got 3"
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r0)
            r11.f45791k = r5
            r11.m32792a((android.telephony.CellLocation) r5, (java.util.List<com.didichuxing.bigdata.p173dp.locsdk.Cgi>) r2)
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackGetSimCgi(r7, r6, r1)
            return r2
        L_0x00b1:
            java.lang.Object[] r1 = new java.lang.Object[r7]     // Catch:{ NoSuchMethodException -> 0x00c5, Exception -> 0x00c3 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)     // Catch:{ NoSuchMethodException -> 0x00c5, Exception -> 0x00c3 }
            r1[r8] = r9     // Catch:{ NoSuchMethodException -> 0x00c5, Exception -> 0x00c3 }
            java.lang.Object r1 = com.didichuxing.bigdata.p173dp.locsdk.Reflect.invokeMethod(r4, r0, r1)     // Catch:{ NoSuchMethodException -> 0x00c5, Exception -> 0x00c3 }
            if (r1 == 0) goto L_0x00da
            android.telephony.CellLocation r1 = (android.telephony.CellLocation) r1     // Catch:{ NoSuchMethodException -> 0x00c5, Exception -> 0x00c3 }
            r5 = r1
            goto L_0x00da
        L_0x00c3:
            r1 = move-exception
            goto L_0x00c7
        L_0x00c5:
            r1 = move-exception
            goto L_0x00d2
        L_0x00c7:
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackReflectError(r1, r3)
            java.lang.String r1 = r1.toString()
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r1)
            goto L_0x00da
        L_0x00d2:
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackReflectError(r1, r3)
            java.lang.String r1 = "sim1 getCellLocationGemini failed"
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r1)
        L_0x00da:
            boolean r1 = r11.cgiUseful((android.telephony.CellLocation) r5)
            if (r1 == 0) goto L_0x00ee
            java.lang.String r1 = "sim1 getAllCellInfo got 4"
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r1)
            r11.f45791k = r5
            r11.m32792a((android.telephony.CellLocation) r5, (java.util.List<com.didichuxing.bigdata.p173dp.locsdk.Cgi>) r2)
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackGetSimCgi(r7, r6, r0)
            return r2
        L_0x00ee:
            int r0 = r4.getSimState()     // Catch:{ Exception -> 0x00f9 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x00f9 }
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackGetSimCgi(r8, r6, r0)     // Catch:{ Exception -> 0x00f9 }
        L_0x00f9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.CellManager.m32795b():java.util.List");
    }

    /* renamed from: a */
    private void m32792a(CellLocation cellLocation, List<Cgi> list) {
        Cgi a;
        int cellLocT = Utils.getCellLocT(cellLocation, this.f45781a);
        if (cellLocT == 1) {
            list.add(m32785a(cellLocation, 5));
        } else if (cellLocT == 2 && (a = m32787a((Object) cellLocation, cellLocT)) != null) {
            list.add(a);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.util.List<com.didichuxing.bigdata.dp.locsdk.Cgi>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.util.List<com.didichuxing.bigdata.dp.locsdk.Cgi>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.util.List<com.didichuxing.bigdata.dp.locsdk.Cgi>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.util.List<com.didichuxing.bigdata.dp.locsdk.Cgi>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.util.List<com.didichuxing.bigdata.dp.locsdk.Cgi>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.util.List<com.didichuxing.bigdata.dp.locsdk.Cgi>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.util.List<com.didichuxing.bigdata.dp.locsdk.Cgi>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: java.util.List<com.didichuxing.bigdata.dp.locsdk.Cgi>} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056 A[SYNTHETIC, Splitter:B:18:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0062 A[Catch:{ Exception -> 0x010a }] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.didichuxing.bigdata.p173dp.locsdk.Cgi> m32799c() {
        /*
            r12 = this;
            java.lang.String r0 = "sim2 NoSuchMethodException: getCellLocationGemini"
            java.lang.String r1 = "getSim2Cgis"
            java.lang.Object r2 = r12.f45788h
            java.lang.String r3 = "sim2"
            r4 = 0
            r5 = 0
            if (r2 != 0) goto L_0x0012
            java.lang.String r0 = "tm2==null"
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackGetSimCgi(r5, r3, r0)
            return r4
        L_0x0012:
            java.lang.Class r6 = r12.m32802d()     // Catch:{ Exception -> 0x010d }
            boolean r7 = r6.isInstance(r2)     // Catch:{ Exception -> 0x010d }
            if (r7 == 0) goto L_0x0115
            java.lang.Object r2 = r6.cast(r2)     // Catch:{ Exception -> 0x010d }
            java.lang.String r6 = "getAllCellInfo"
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ NoSuchMethodException -> 0x0048, Exception -> 0x002b }
            java.lang.Object r6 = com.didichuxing.bigdata.p173dp.locsdk.Reflect.invokeMethod(r2, r6, r7)     // Catch:{ NoSuchMethodException -> 0x0048, Exception -> 0x002b }
            java.util.List r6 = (java.util.List) r6     // Catch:{ NoSuchMethodException -> 0x0048, Exception -> 0x002b }
            goto L_0x0050
        L_0x002b:
            r6 = move-exception
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackReflectError(r6, r1)     // Catch:{ Exception -> 0x010d }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010d }
            r7.<init>()     // Catch:{ Exception -> 0x010d }
            java.lang.String r8 = "sim2 exception 3: "
            r7.append(r8)     // Catch:{ Exception -> 0x010d }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x010d }
            r7.append(r6)     // Catch:{ Exception -> 0x010d }
            java.lang.String r6 = r7.toString()     // Catch:{ Exception -> 0x010d }
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r6)     // Catch:{ Exception -> 0x010d }
            goto L_0x004f
        L_0x0048:
            r6 = move-exception
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackReflectError(r6, r1)     // Catch:{ Exception -> 0x010d }
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r0)     // Catch:{ Exception -> 0x010d }
        L_0x004f:
            r6 = r4
        L_0x0050:
            java.util.List r6 = r12.m32788a((java.util.List<?>) r6)     // Catch:{ Exception -> 0x010d }
            if (r6 != 0) goto L_0x005c
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x010a }
            r7.<init>()     // Catch:{ Exception -> 0x010a }
            r6 = r7
        L_0x005c:
            int r7 = r6.size()     // Catch:{ Exception -> 0x010a }
            if (r7 != 0) goto L_0x0108
            java.lang.String r7 = "getCellLocation"
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ NoSuchMethodException -> 0x0088, Exception -> 0x006b }
            java.lang.Object r4 = com.didichuxing.bigdata.p173dp.locsdk.Reflect.invokeMethod(r2, r7, r8)     // Catch:{ NoSuchMethodException -> 0x0088, Exception -> 0x006b }
            goto L_0x0091
        L_0x006b:
            r8 = move-exception
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackReflectError(r8, r1)     // Catch:{ Exception -> 0x010a }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010a }
            r9.<init>()     // Catch:{ Exception -> 0x010a }
            java.lang.String r10 = "sim2 exception 0: "
            r9.append(r10)     // Catch:{ Exception -> 0x010a }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x010a }
            r9.append(r8)     // Catch:{ Exception -> 0x010a }
            java.lang.String r8 = r9.toString()     // Catch:{ Exception -> 0x010a }
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r8)     // Catch:{ Exception -> 0x010a }
            goto L_0x0091
        L_0x0088:
            r8 = move-exception
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackReflectError(r8, r1)     // Catch:{ Exception -> 0x010a }
            java.lang.String r8 = "sim2 NoSuchMethodException: getCellLocation"
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r8)     // Catch:{ Exception -> 0x010a }
        L_0x0091:
            r8 = 1
            if (r4 != 0) goto L_0x00c7
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ NoSuchMethodException -> 0x00be, Exception -> 0x00a1 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r8)     // Catch:{ NoSuchMethodException -> 0x00be, Exception -> 0x00a1 }
            r9[r5] = r10     // Catch:{ NoSuchMethodException -> 0x00be, Exception -> 0x00a1 }
            java.lang.Object r4 = com.didichuxing.bigdata.p173dp.locsdk.Reflect.invokeMethod(r2, r7, r9)     // Catch:{ NoSuchMethodException -> 0x00be, Exception -> 0x00a1 }
            goto L_0x00c7
        L_0x00a1:
            r9 = move-exception
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackReflectError(r9, r1)     // Catch:{ Exception -> 0x010a }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010a }
            r10.<init>()     // Catch:{ Exception -> 0x010a }
            java.lang.String r11 = "sim2 exception 1: "
            r10.append(r11)     // Catch:{ Exception -> 0x010a }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x010a }
            r10.append(r9)     // Catch:{ Exception -> 0x010a }
            java.lang.String r9 = r10.toString()     // Catch:{ Exception -> 0x010a }
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r9)     // Catch:{ Exception -> 0x010a }
            goto L_0x00c7
        L_0x00be:
            r9 = move-exception
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackReflectError(r9, r1)     // Catch:{ Exception -> 0x010a }
            java.lang.String r9 = "sim2 NoSuchMethodException: getCellLocation 2"
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r9)     // Catch:{ Exception -> 0x010a }
        L_0x00c7:
            if (r4 != 0) goto L_0x00fc
            java.lang.String r7 = "getCellLocationGemini"
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ NoSuchMethodException -> 0x00f5, Exception -> 0x00d8 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r8)     // Catch:{ NoSuchMethodException -> 0x00f5, Exception -> 0x00d8 }
            r9[r5] = r10     // Catch:{ NoSuchMethodException -> 0x00f5, Exception -> 0x00d8 }
            java.lang.Object r4 = com.didichuxing.bigdata.p173dp.locsdk.Reflect.invokeMethod(r2, r7, r9)     // Catch:{ NoSuchMethodException -> 0x00f5, Exception -> 0x00d8 }
            goto L_0x00fc
        L_0x00d8:
            r0 = move-exception
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackReflectError(r0, r1)     // Catch:{ Exception -> 0x010a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010a }
            r1.<init>()     // Catch:{ Exception -> 0x010a }
            java.lang.String r2 = "sim2 exception 2: "
            r1.append(r2)     // Catch:{ Exception -> 0x010a }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x010a }
            r1.append(r0)     // Catch:{ Exception -> 0x010a }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x010a }
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r0)     // Catch:{ Exception -> 0x010a }
            goto L_0x00fc
        L_0x00f5:
            r2 = move-exception
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackReflectError(r2, r1)     // Catch:{ Exception -> 0x010a }
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r0)     // Catch:{ Exception -> 0x010a }
        L_0x00fc:
            if (r4 == 0) goto L_0x0108
            android.telephony.CellLocation r4 = (android.telephony.CellLocation) r4     // Catch:{ Exception -> 0x010a }
            r12.f45791k = r4     // Catch:{ Exception -> 0x010a }
            r12.m32792a((android.telephony.CellLocation) r4, (java.util.List<com.didichuxing.bigdata.p173dp.locsdk.Cgi>) r6)     // Catch:{ Exception -> 0x010a }
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackGetSimCgi(r8, r3, r7)     // Catch:{ Exception -> 0x010a }
        L_0x0108:
            r4 = r6
            goto L_0x0115
        L_0x010a:
            r0 = move-exception
            r4 = r6
            goto L_0x010e
        L_0x010d:
            r0 = move-exception
        L_0x010e:
            java.lang.String r0 = r0.toString()
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r0)
        L_0x0115:
            if (r4 == 0) goto L_0x011d
            int r0 = r4.size()
            if (r0 != 0) goto L_0x0122
        L_0x011d:
            java.lang.String r0 = ""
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackGetSimCgi(r5, r3, r0)
        L_0x0122:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.CellManager.m32799c():java.util.List");
    }

    /* renamed from: d */
    private Class<?> m32802d() {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        int sim2T = getSim2T();
        try {
            return systemClassLoader.loadClass(sim2T != 0 ? sim2T != 1 ? sim2T != 2 ? null : "android.telephony.TelephonyManager2" : "android.telephony.MSimTelephonyManager" : "android.telephony.TelephonyManager");
        } catch (Exception e) {
            DLog.m32737d(e.toString());
            return null;
        }
    }

    /* renamed from: a */
    private List<Cgi> m32788a(List<?> list) {
        int i;
        CellSignalStrength cellSignalStrength;
        GsmCellLocation gsmCellLocation;
        List<?> list2 = list;
        if (list2 == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        GsmCellLocation gsmCellLocation2 = null;
        CdmaCellLocation cdmaCellLocation = null;
        String str = null;
        String str2 = null;
        for (int i2 = 0; i2 < list.size(); i2++) {
            CellInfo cellInfo = (CellInfo) list2.get(i2);
            if (cellInfo != null) {
                try {
                    if (cellInfo instanceof CellInfoGsm) {
                        CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
                        cellSignalStrength = cellInfoGsm.getCellSignalStrength();
                        gsmCellLocation = new GsmCellLocation();
                        try {
                            gsmCellLocation.setLacAndCid(cellIdentity.getLac(), cellIdentity.getCid());
                            if (Build.VERSION.SDK_INT >= 28) {
                                str = cellIdentity.getMccString();
                                str2 = cellIdentity.getMncString();
                            }
                            i = 1;
                            gsmCellLocation2 = gsmCellLocation;
                        } catch (Exception e) {
                            e = e;
                            gsmCellLocation2 = gsmCellLocation;
                            OmegaUtils.trackReflectError(e, "retrieveCgis");
                            DLog.m32737d("retrieveCgis-->" + e.toString());
                        }
                    } else if (cellInfo instanceof CellInfoWcdma) {
                        CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                        CellIdentityWcdma cellIdentity2 = cellInfoWcdma.getCellIdentity();
                        cellSignalStrength = cellInfoWcdma.getCellSignalStrength();
                        gsmCellLocation = new GsmCellLocation();
                        gsmCellLocation.setLacAndCid(cellIdentity2.getLac(), cellIdentity2.getCid());
                        if (Build.VERSION.SDK_INT >= 28) {
                            str = cellIdentity2.getMccString();
                            str2 = cellIdentity2.getMncString();
                        }
                        gsmCellLocation2 = gsmCellLocation;
                        i = 3;
                    } else if (cellInfo instanceof CellInfoLte) {
                        CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                        CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                        cellSignalStrength = cellInfoLte.getCellSignalStrength();
                        gsmCellLocation = new GsmCellLocation();
                        gsmCellLocation.setLacAndCid(cellIdentity3.getTac(), cellIdentity3.getCi());
                        if (Build.VERSION.SDK_INT >= 28) {
                            str = cellIdentity3.getMccString();
                            str2 = cellIdentity3.getMncString();
                        }
                        gsmCellLocation2 = gsmCellLocation;
                        i = 4;
                    } else if (cellInfo instanceof CellInfoCdma) {
                        CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                        CellSignalStrengthCdma cellSignalStrength2 = cellInfoCdma.getCellSignalStrength();
                        CdmaCellLocation cdmaCellLocation2 = new CdmaCellLocation();
                        try {
                            CellIdentityCdma cellIdentity4 = cellInfoCdma.getCellIdentity();
                            cdmaCellLocation2.setCellLocationData(cellIdentity4.getBasestationId(), cellIdentity4.getLatitude(), cellIdentity4.getLongitude(), cellIdentity4.getSystemId(), cellIdentity4.getNetworkId());
                            cellSignalStrength = cellSignalStrength2;
                            cdmaCellLocation = cdmaCellLocation2;
                            i = 2;
                        } catch (Exception e2) {
                            e = e2;
                            cdmaCellLocation = cdmaCellLocation2;
                            OmegaUtils.trackReflectError(e, "retrieveCgis");
                            DLog.m32737d("retrieveCgis-->" + e.toString());
                        }
                    } else {
                        cellSignalStrength = null;
                        i = 0;
                    }
                    if (!(i == 0 || cellSignalStrength == null)) {
                        int dbm = cellSignalStrength.getDbm();
                        if (i == 2) {
                            if (cgiUseful((CellLocation) cdmaCellLocation)) {
                                if (arrayList.size() == 0) {
                                    this.f45791k = cdmaCellLocation;
                                }
                                Cgi a = m32787a((Object) cdmaCellLocation, i);
                                if (dbm > -113 && dbm < 0) {
                                    a.sig = dbm;
                                }
                                if (a != null) {
                                    DLog.m32737d(this.f45792l + "cdma" + a.toString());
                                    arrayList.add(a);
                                }
                            }
                        } else if (cgiUseful((CellLocation) gsmCellLocation2)) {
                            if (arrayList.size() == 0) {
                                this.f45791k = gsmCellLocation2;
                            }
                            Cgi a2 = m32785a((CellLocation) gsmCellLocation2, i);
                            if (a2 != null) {
                                if (dbm > -113 && dbm < 0) {
                                    try {
                                        a2.sig = dbm;
                                    } catch (Exception e3) {
                                        OmegaUtils.trackReflectError(e3, "retrieveCgis");
                                    }
                                }
                                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                    a2.mcc = str;
                                    a2.mnc_sid = str2;
                                }
                                DLog.m32737d(this.f45792l + "other" + a2.toString());
                                arrayList.add(a2);
                            }
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    OmegaUtils.trackReflectError(e, "retrieveCgis");
                    DLog.m32737d("retrieveCgis-->" + e.toString());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private Cgi m32785a(CellLocation cellLocation, int i) {
        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
        Cgi cgi = new Cgi();
        String[] mccMnc = Utils.getMccMnc(this.f45787g);
        cgi.mcc = mccMnc[0];
        cgi.mnc_sid = mccMnc[1];
        cgi.lac_nid = gsmCellLocation.getLac();
        cgi.cid_bid = gsmCellLocation.getCid();
        cgi.sig = this.f45786f;
        cgi.type = i;
        cgi.detectedTs = System.currentTimeMillis() / 1000;
        return cgi;
    }

    /* renamed from: a */
    private Cgi m32786a(NeighboringCellInfo neighboringCellInfo) {
        if (Utils.getSdk() < 5) {
            DLog.m32737d("api" + Utils.getSdk() + " do not support NeighboringCellInfo");
            return null;
        }
        try {
            Cgi cgi = new Cgi();
            String[] mccMnc = Utils.getMccMnc(this.f45787g);
            cgi.mcc = mccMnc[0];
            cgi.mnc_sid = mccMnc[1];
            cgi.lac_nid = neighboringCellInfo.getLac();
            cgi.cid_bid = neighboringCellInfo.getCid();
            int rssi = neighboringCellInfo.getRssi();
            cgi.sig = rssi != 99 ? Utils.asu2Dbm(rssi) : -1;
            if (neighboringCellInfo.getPsc() != -1) {
                DLog.m32737d("nb Primary Scrambling Code #" + neighboringCellInfo.getPsc());
            }
            return cgi;
        } catch (Exception e) {
            OmegaUtils.trackReflectError(e, "getGsm");
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m32803e() {
        try {
            CellLocation.requestLocationUpdate();
        } catch (Exception e) {
            DLog.m32737d(e.toString());
        }
        this.f45789i = Utils.getTimeBoot();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044 A[SYNTHETIC, Splitter:B:16:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0078 A[Catch:{ all -> 0x0081 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ac  */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m32806f() {
        /*
            r4 = this;
            com.didichuxing.bigdata.dp.locsdk.impl.v3.CellManager$1 r0 = new com.didichuxing.bigdata.dp.locsdk.impl.v3.CellManager$1
            r0.<init>()
            r4.f45790j = r0
            int r0 = com.didichuxing.bigdata.p173dp.locsdk.utils.Utils.getSdk()
            java.lang.String r1 = "initPhoneStateListener"
            java.lang.String r2 = "android.telephony.PhoneStateListener"
            r3 = 7
            if (r0 >= r3) goto L_0x0025
            java.lang.String r0 = "LISTEN_SIGNAL_STRENGTH"
            int r0 = com.didichuxing.bigdata.p173dp.locsdk.Reflect.getStaticIntProp(r2, r0)     // Catch:{ Exception -> 0x0019 }
            goto L_0x0038
        L_0x0019:
            r0 = move-exception
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackReflectError(r0, r1)
            java.lang.String r0 = r0.toString()
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r0)
            goto L_0x0037
        L_0x0025:
            java.lang.String r0 = "LISTEN_SIGNAL_STRENGTHS"
            int r0 = com.didichuxing.bigdata.p173dp.locsdk.Reflect.getStaticIntProp(r2, r0)     // Catch:{ Exception -> 0x002c }
            goto L_0x0038
        L_0x002c:
            r0 = move-exception
            com.didichuxing.bigdata.p173dp.locsdk.utils.OmegaUtils.trackReflectError(r0, r1)
            java.lang.String r0 = r0.toString()
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r0)
        L_0x0037:
            r0 = 0
        L_0x0038:
            r1 = 16
            if (r0 != 0) goto L_0x0044
            android.telephony.TelephonyManager r0 = r4.f45787g
            android.telephony.PhoneStateListener r2 = r4.f45790j
            r0.listen(r2, r1)
            goto L_0x0055
        L_0x0044:
            android.telephony.TelephonyManager r2 = r4.f45787g     // Catch:{ Exception -> 0x004d }
            android.telephony.PhoneStateListener r3 = r4.f45790j     // Catch:{ Exception -> 0x004d }
            r0 = r0 | r1
            r2.listen(r3, r0)     // Catch:{ Exception -> 0x004d }
            goto L_0x0055
        L_0x004d:
            r0 = move-exception
            java.lang.String r0 = r0.toString()
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r0)
        L_0x0055:
            int r0 = getSim2T()     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = "phone2"
            if (r0 == 0) goto L_0x0078
            r2 = 1
            if (r0 == r2) goto L_0x006d
            r2 = 2
            if (r0 == r2) goto L_0x0064
            goto L_0x0089
        L_0x0064:
            android.content.Context r0 = r4.f45781a     // Catch:{ all -> 0x0081 }
            java.lang.Object r0 = com.didichuxing.bigdata.p173dp.locsdk.utils.Utils.getServ(r0, r1)     // Catch:{ all -> 0x0081 }
            r4.f45788h = r0     // Catch:{ all -> 0x0081 }
            goto L_0x0089
        L_0x006d:
            android.content.Context r0 = r4.f45781a     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = "phone_msim"
            java.lang.Object r0 = com.didichuxing.bigdata.p173dp.locsdk.utils.Utils.getServ(r0, r1)     // Catch:{ all -> 0x0081 }
            r4.f45788h = r0     // Catch:{ all -> 0x0081 }
            goto L_0x0089
        L_0x0078:
            android.content.Context r0 = r4.f45781a     // Catch:{ all -> 0x0081 }
            java.lang.Object r0 = com.didichuxing.bigdata.p173dp.locsdk.utils.Utils.getServ(r0, r1)     // Catch:{ all -> 0x0081 }
            r4.f45788h = r0     // Catch:{ all -> 0x0081 }
            goto L_0x0089
        L_0x0081:
            r0 = move-exception
            java.lang.String r0 = r0.toString()
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r0)
        L_0x0089:
            java.lang.Object r0 = r4.f45788h
            if (r0 == 0) goto L_0x00ac
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "set sim2 state listener success "
            r0.append(r1)
            java.lang.Object r1 = r4.f45788h
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r0)
            goto L_0x00b1
        L_0x00ac:
            java.lang.String r0 = "set sim2 state listener failed"
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r0)
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.CellManager.m32806f():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32790a(int i) {
        if (i == -113) {
            this.f45786f = Const.iDefCgiSig;
            return;
        }
        this.f45786f = i;
        int i2 = this.f45783c;
        if ((i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) && this.f45784d != null && !this.f45784d.isEmpty()) {
            try {
                this.f45784d.get(0).sig = this.f45786f;
            } catch (Exception e) {
                DLog.m32737d(e.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m32807g() {
        this.f45791k = null;
        this.f45783c = 0;
        if (this.f45784d != null) {
            this.f45784d.clear();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m32781a(SignalStrength signalStrength) {
        if (signalStrength.isGsm()) {
            int c = m32798c(signalStrength);
            if (c != Integer.MAX_VALUE) {
                return c;
            }
            if (!m32804e(signalStrength)) {
                return m32805f(signalStrength);
            }
            if (m32794b(signalStrength) == Integer.MAX_VALUE) {
                return m32801d(signalStrength);
            }
            return m32794b(signalStrength);
        }
        int cdmaDbm = signalStrength.getCdmaDbm();
        int evdoDbm = signalStrength.getEvdoDbm();
        if (evdoDbm == -120) {
            return cdmaDbm;
        }
        return (cdmaDbm != -120 && cdmaDbm < evdoDbm) ? cdmaDbm : evdoDbm;
    }

    /* renamed from: b */
    private int m32794b(SignalStrength signalStrength) {
        return ReflectUtils.getDeclaredIntField(SignalStrength.class, signalStrength, "mWcdmaRscp", Integer.MAX_VALUE);
    }

    /* renamed from: c */
    private int m32798c(SignalStrength signalStrength) {
        try {
            Field declaredField = SignalStrength.class.getDeclaredField("mLteRsrp");
            declaredField.setAccessible(true);
            return declaredField.getInt(signalStrength);
        } catch (Exception e) {
            if ((System.currentTimeMillis() / 1000) % 60 == 0) {
                OmegaUtils.trackReflectError(e, "getLteDbm");
            }
            return Integer.MAX_VALUE;
        }
    }

    /* renamed from: d */
    private int m32801d(SignalStrength signalStrength) {
        int gsmSignalStrength = signalStrength.getGsmSignalStrength();
        if (gsmSignalStrength == 99) {
            gsmSignalStrength = -1;
        }
        if (gsmSignalStrength != -1) {
            return (gsmSignalStrength * 2) + Const.iDefCgiSig;
        }
        return -1;
    }

    /* renamed from: e */
    private boolean m32804e(SignalStrength signalStrength) {
        int f = m32805f(signalStrength);
        return f == Integer.MAX_VALUE || f > -25 || f < -110;
    }

    /* renamed from: f */
    private int m32805f(SignalStrength signalStrength) {
        return ReflectUtils.getDeclaredIntField(SignalStrength.class, signalStrength, "mTdScdmaRscp", Integer.MAX_VALUE);
    }
}
