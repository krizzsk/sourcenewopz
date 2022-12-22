package com.didi.map.global.component.bluetooth.client;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelUuid;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.map.global.component.bluetooth.apollo.BluetoothApolloUtil;
import com.didi.map.global.component.bluetooth.util.C9358Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class BleBluetoothClient implements IBleBluetoothClientInterface {

    /* renamed from: p */
    private static final long f24764p = BluetoothApolloUtil.getBleScanFailedInterval();

    /* renamed from: q */
    private static final long f24765q = BluetoothApolloUtil.getBleRssiFailedInterval();
    /* access modifiers changed from: private */

    /* renamed from: r */
    public static final long f24766r = BluetoothApolloUtil.getBleReadDataInterval();
    /* access modifiers changed from: private */

    /* renamed from: s */
    public static final long f24767s = BluetoothApolloUtil.getBleReadRssiInterval();

    /* renamed from: a */
    private ScanSettings f24768a = null;

    /* renamed from: b */
    private BluetoothGatt f24769b = null;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IBleBluetoothClientCallback f24770c = null;

    /* renamed from: d */
    private String f24771d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public UUID f24772e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public UUID f24773f = null;

    /* renamed from: g */
    private Context f24774g = null;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f24775h = true;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f24776i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f24777j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f24778k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f24779l = false;

    /* renamed from: m */
    private Timer f24780m = null;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f24781n = 0;

    /* renamed from: o */
    private Handler f24782o = new Handler(Looper.myLooper());
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f24783t = 0;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f24784u = 0;

    /* renamed from: v */
    private final ScanCallback f24785v = new ScanCallback() {
        public void onScanResult(int i, ScanResult scanResult) {
            List<ParcelUuid> serviceUuids;
            if (scanResult != null && scanResult.getScanRecord() != null && (serviceUuids = scanResult.getScanRecord().getServiceUuids()) != null && serviceUuids.size() > 0) {
                for (ParcelUuid uuid : serviceUuids) {
                    if (uuid.getUuid().equals(BleBluetoothClient.this.f24772e)) {
                        if (!BleBluetoothClient.this.f24778k) {
                            boolean unused = BleBluetoothClient.this.f24778k = true;
                            BleBluetoothClient.this.m17620h();
                            BleBluetoothClient.this.m17598a(ClientState.ScanSuccess);
                        }
                        if (!BleBluetoothClient.this.f24777j && BleBluetoothClient.this.f24770c != null && BleBluetoothClient.this.f24775h) {
                            RssiInfoResult rssiInfoResult = new RssiInfoResult();
                            int rssi = scanResult.getRssi();
                            rssiInfoResult.setRssi(rssi);
                            rssiInfoResult.setDistance(C9358Util.getDistance(rssi));
                            BleBluetoothClient.this.m17622i();
                            BleBluetoothClient.this.f24770c.onRssiInfoResult(rssiInfoResult);
                        }
                        if (!BleBluetoothClient.this.f24777j && !BleBluetoothClient.this.f24776i) {
                            BleBluetoothClient.this.m17595a(scanResult.getDevice());
                            return;
                        }
                        return;
                    }
                }
            }
        }

        public void onScanFailed(int i) {
            C9358Util.logWrite("onScanFailed : errorCode = " + i);
        }
    };

    /* renamed from: w */
    private final Runnable f24786w = new Runnable() {
        public void run() {
            boolean unused = BleBluetoothClient.this.f24778k = false;
            BleBluetoothClient.this.m17626k();
            BleBluetoothClient.this.m17598a(ClientState.ScanFailure);
        }
    };

    /* renamed from: x */
    private final Runnable f24787x = new Runnable() {
        public void run() {
            BleBluetoothClient.this.m17630m();
            BleBluetoothClient.this.m17626k();
            BleBluetoothClient.this.m17598a(ClientState.ConnectFailure);
        }
    };

    /* renamed from: y */
    private final BluetoothGattCallback f24788y = new BluetoothGattCallback() {
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onConnectionStateChange(bluetoothGatt, i, i2);
            C9358Util.logWrite("onConnectionStateChange : status = " + i + ", newState = " + i2);
            if (i == 0 && i2 == 2) {
                if (bluetoothGatt != null) {
                    try {
                        bluetoothGatt.discoverServices();
                    } catch (Exception e) {
                        C9358Util.logWrite("onConnectionStateChange crash " + e);
                    }
                }
                boolean unused = BleBluetoothClient.this.f24777j = true;
                if (!BleBluetoothClient.this.f24779l) {
                    boolean unused2 = BleBluetoothClient.this.f24779l = true;
                    BleBluetoothClient.this.m17598a(ClientState.ConnectSuccess);
                }
                BleBluetoothClient.this.m17606c();
                BleBluetoothClient.this.m17626k();
            } else {
                BleBluetoothClient.this.m17630m();
                BleBluetoothClient.this.m17616f();
            }
            boolean unused3 = BleBluetoothClient.this.f24776i = false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x00c3  */
        /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCharacteristicRead(android.bluetooth.BluetoothGatt r9, android.bluetooth.BluetoothGattCharacteristic r10, int r11) {
            /*
                r8 = this;
                super.onCharacteristicRead(r9, r10, r11)
                if (r11 != 0) goto L_0x00cd
                if (r10 == 0) goto L_0x00cd
                com.didi.map.global.component.bluetooth.client.BleBluetoothClient r9 = com.didi.map.global.component.bluetooth.client.BleBluetoothClient.this
                r11 = 0
                int unused = r9.f24783t = r11
                java.util.UUID r9 = r10.getUuid()
                if (r9 == 0) goto L_0x00d2
                com.didi.map.global.component.bluetooth.client.BleBluetoothClient r0 = com.didi.map.global.component.bluetooth.client.BleBluetoothClient.this
                java.util.UUID r0 = r0.f24773f
                boolean r9 = r9.equals(r0)
                if (r9 == 0) goto L_0x00d2
                r9 = 0
                byte[] r10 = r10.getValue()
                java.lang.String r0 = new java.lang.String
                byte[] r1 = com.didi.map.global.component.bluetooth.util.C9358Util.mDecompress(r10)
                r0.<init>(r1)
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                if (r1 != 0) goto L_0x00b3
                java.lang.String r1 = ","
                java.lang.String[] r0 = r0.split(r1)
                int r1 = r0.length
                r2 = 3
                if (r1 != r2) goto L_0x009a
                r1 = r0[r11]
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x009a
                r1 = 1
                r2 = r0[r1]
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 != 0) goto L_0x009a
                r2 = 2
                r3 = r0[r2]
                boolean r3 = android.text.TextUtils.isEmpty(r3)
                if (r3 != 0) goto L_0x009a
                com.didi.map.global.component.bluetooth.client.DriverInfoResult r10 = new com.didi.map.global.component.bluetooth.client.DriverInfoResult     // Catch:{ NumberFormatException -> 0x007c }
                r10.<init>()     // Catch:{ NumberFormatException -> 0x007c }
                r9 = r0[r11]     // Catch:{ NumberFormatException -> 0x007a }
                double r3 = java.lang.Double.parseDouble(r9)     // Catch:{ NumberFormatException -> 0x007a }
                r9 = r0[r1]     // Catch:{ NumberFormatException -> 0x007a }
                double r5 = java.lang.Double.parseDouble(r9)     // Catch:{ NumberFormatException -> 0x007a }
                com.didi.common.map.model.LatLng r9 = new com.didi.common.map.model.LatLng     // Catch:{ NumberFormatException -> 0x007a }
                r9.<init>((double) r3, (double) r5)     // Catch:{ NumberFormatException -> 0x007a }
                r10.setDriverPos(r9)     // Catch:{ NumberFormatException -> 0x007a }
                r9 = r0[r2]     // Catch:{ NumberFormatException -> 0x007a }
                float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x007a }
                r10.setDriverAcc(r9)     // Catch:{ NumberFormatException -> 0x007a }
                goto L_0x0098
            L_0x007a:
                r9 = move-exception
                goto L_0x0080
            L_0x007c:
                r10 = move-exception
                r7 = r10
                r10 = r9
                r9 = r7
            L_0x0080:
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                java.lang.String r0 = "format driver data failed, e = "
                r11.append(r0)
                java.lang.String r9 = r9.toString()
                r11.append(r9)
                java.lang.String r9 = r11.toString()
                com.didi.map.global.component.bluetooth.util.C9358Util.logWrite(r9)
            L_0x0098:
                r9 = r10
                goto L_0x00b3
            L_0x009a:
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                java.lang.String r0 = "format driver data failed, value = "
                r11.append(r0)
                java.lang.String r0 = new java.lang.String
                r0.<init>(r10)
                r11.append(r0)
                java.lang.String r10 = r11.toString()
                com.didi.map.global.component.bluetooth.util.C9358Util.logWrite(r10)
            L_0x00b3:
                com.didi.map.global.component.bluetooth.client.BleBluetoothClient r10 = com.didi.map.global.component.bluetooth.client.BleBluetoothClient.this
                com.didi.map.global.component.bluetooth.client.IBleBluetoothClientCallback r10 = r10.f24770c
                if (r10 == 0) goto L_0x00d2
                com.didi.map.global.component.bluetooth.client.BleBluetoothClient r10 = com.didi.map.global.component.bluetooth.client.BleBluetoothClient.this
                boolean r10 = r10.f24775h
                if (r10 == 0) goto L_0x00d2
                com.didi.map.global.component.bluetooth.client.BleBluetoothClient r10 = com.didi.map.global.component.bluetooth.client.BleBluetoothClient.this
                com.didi.map.global.component.bluetooth.client.IBleBluetoothClientCallback r10 = r10.f24770c
                r10.onDriverInfoResult(r9)
                goto L_0x00d2
            L_0x00cd:
                com.didi.map.global.component.bluetooth.client.BleBluetoothClient r9 = com.didi.map.global.component.bluetooth.client.BleBluetoothClient.this
                r9.m17601b((int) r11)
            L_0x00d2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.bluetooth.client.BleBluetoothClient.C93554.onCharacteristicRead(android.bluetooth.BluetoothGatt, android.bluetooth.BluetoothGattCharacteristic, int):void");
        }

        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onReadRemoteRssi(bluetoothGatt, i, i2);
            if (i2 == 0) {
                int unused = BleBluetoothClient.this.f24784u = 0;
                RssiInfoResult rssiInfoResult = new RssiInfoResult();
                if (BleBluetoothClient.this.f24770c != null && BleBluetoothClient.this.f24775h) {
                    rssiInfoResult.setRssi(i);
                    rssiInfoResult.setDistance(C9358Util.getDistance(i));
                    BleBluetoothClient.this.m17622i();
                    BleBluetoothClient.this.f24770c.onRssiInfoResult(rssiInfoResult);
                    return;
                }
                return;
            }
            BleBluetoothClient.this.m17594a(i2);
        }
    };

    /* renamed from: o */
    static /* synthetic */ int m17634o(BleBluetoothClient bleBluetoothClient) {
        int i = bleBluetoothClient.f24781n;
        bleBluetoothClient.f24781n = i + 1;
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17594a(int i) {
        int i2 = this.f24784u + 1;
        this.f24784u = i2;
        if (i2 >= 25) {
            C9358Util.logWrite("readRssiFailed status = " + i);
            m17630m();
            m17616f();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17601b(int i) {
        int i2 = this.f24783t + 1;
        this.f24783t = i2;
        if (i2 >= 5) {
            C9358Util.logWrite("readCharacterFailed status = " + i);
            m17630m();
            m17616f();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m17606c() {
        m17609d();
        if (this.f24780m == null) {
            C9358Util.logWrite("startReadConnectData");
            Timer timer = new Timer();
            this.f24780m = timer;
            timer.schedule(new ConnectionTimerTask(), 0, f24767s);
        }
    }

    /* renamed from: d */
    private void m17609d() {
        if (this.f24780m != null) {
            C9358Util.logWrite("stopReadConnectData");
            this.f24780m.cancel();
            this.f24780m = null;
        }
    }

    public void create(Context context, Map map) {
        C9358Util.logWrite("BleBluetoothClient create");
        this.f24774g = context;
        m17628l();
    }

    public void start() {
        C9358Util.logWrite("BleBluetoothClient start");
        this.f24779l = false;
        this.f24778k = false;
        if (!C9358Util.bluetoothEnable() || !C9358Util.checkBlePermission(this.f24774g)) {
            C9358Util.logWrite("start Failed ：蓝牙不可用");
        } else {
            m17616f();
        }
    }

    public void stop() {
        m17630m();
        m17626k();
    }

    public void setConfigParam(BleBluetoothClientParam bleBluetoothClientParam) {
        if (bleBluetoothClientParam != null) {
            this.f24771d = bleBluetoothClientParam.orderId;
            this.f24770c = bleBluetoothClientParam.mCallback;
            if (TextUtils.isEmpty(this.f24771d)) {
                C9358Util.logWrite("setConfigParam ：mOrderId is null");
            } else {
                UUID OrderIdToUUID = C9358Util.OrderIdToUUID(this.f24771d);
                this.f24772e = OrderIdToUUID;
                if (OrderIdToUUID == null) {
                    C9358Util.logWrite("setConfigParam ：orderId转UUID出错");
                }
                UUID OrderIdToUUID2 = C9358Util.OrderIdToUUID(this.f24771d + "ReadCharacter");
                this.f24773f = OrderIdToUUID2;
                if (OrderIdToUUID2 == null) {
                    C9358Util.logWrite("setConfigParam ：orderId转mReadCharacterUUID出错");
                }
            }
            if (this.f24770c == null) {
                C9358Util.logWrite("setConfigParam ：mCallback is null");
            }
        }
    }

    public void onMapVisible(boolean z) {
        this.f24775h = z;
        if (!z) {
            m17609d();
            m17624j();
            return;
        }
        m17606c();
        m17622i();
    }

    public void destroy() {
        m17620h();
        m17630m();
        m17626k();
        this.f24768a = null;
        this.f24774g = null;
        this.f24771d = null;
        this.f24772e = null;
        this.f24773f = null;
        this.f24770c = null;
        this.f24782o = null;
        this.f24779l = false;
        this.f24778k = false;
    }

    /* renamed from: e */
    private List<ScanFilter> m17615e() {
        try {
            if (this.f24772e == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ScanFilter.Builder().setServiceUuid(new ParcelUuid(this.f24772e)).build());
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            C9358Util.logWrite("createFilters failed: " + e.toString());
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m17616f() {
        BluetoothAdapter defaultAdapter;
        m17626k();
        C9358Util.logWrite("BleBluetoothClient startScanBle");
        m17618g();
        try {
            if (this.f24768a != null && (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) != null) {
                BluetoothLeScanner bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner();
                List<ScanFilter> e = m17615e();
                if (e != null && bluetoothLeScanner != null) {
                    bluetoothLeScanner.startScan(e, this.f24768a, this.f24785v);
                    C9358Util.logWrite("BleBluetoothClient startScanBle ok");
                }
            }
        } catch (Exception e2) {
            C9358Util.logWrite("startScanBle failed: " + e2.toString());
            m17620h();
            m17598a(ClientState.ScanFailure);
        }
    }

    /* renamed from: g */
    private void m17618g() {
        Handler handler;
        if (!this.f24778k && (handler = this.f24782o) != null) {
            handler.removeCallbacks(this.f24786w);
            this.f24782o.postDelayed(this.f24786w, f24764p);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m17620h() {
        Handler handler = this.f24782o;
        if (handler != null) {
            handler.removeCallbacks(this.f24786w);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m17622i() {
        Handler handler = this.f24782o;
        if (handler != null) {
            handler.removeCallbacks(this.f24787x);
            this.f24782o.postDelayed(this.f24787x, f24765q);
        }
    }

    /* renamed from: j */
    private void m17624j() {
        Handler handler = this.f24782o;
        if (handler != null) {
            handler.removeCallbacks(this.f24787x);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m17626k() {
        C9358Util.logWrite("BleBluetoothClient stopScanBle");
        m17620h();
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                BluetoothLeScanner bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner();
                if (bluetoothLeScanner != null) {
                    bluetoothLeScanner.stopScan(this.f24785v);
                }
                C9358Util.logWrite("BleBluetoothClient stopScanBle ok");
            }
        } catch (Exception e) {
            C9358Util.logWrite("stopScanBle failed: " + e.toString());
        }
    }

    /* renamed from: l */
    private void m17628l() {
        ScanSettings.Builder builder = new ScanSettings.Builder();
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setLegacy(false);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            builder.setMatchMode(1);
            builder.setCallbackType(1);
        }
        builder.setScanMode(2);
        this.f24768a = builder.build();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17595a(BluetoothDevice bluetoothDevice) {
        m17630m();
        C9358Util.logWrite("startConnect");
        this.f24776i = true;
        if (bluetoothDevice != null) {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f24769b = bluetoothDevice.connectGatt(this.f24774g, false, this.f24788y, 2, 2);
                } else if (Build.VERSION.SDK_INT >= 23) {
                    this.f24769b = bluetoothDevice.connectGatt(this.f24774g, false, this.f24788y, 2);
                } else {
                    this.f24769b = bluetoothDevice.connectGatt(this.f24774g, false, this.f24788y);
                }
            } catch (Exception e) {
                C9358Util.logWrite("startConnect failed " + e.toString());
                this.f24776i = false;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17598a(ClientState clientState) {
        IBleBluetoothClientCallback iBleBluetoothClientCallback = this.f24770c;
        if (iBleBluetoothClientCallback != null) {
            iBleBluetoothClientCallback.onStateChange(clientState);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m17630m() {
        C9358Util.logWrite("closeConnect");
        m17609d();
        this.f24777j = false;
        this.f24783t = 0;
        this.f24784u = 0;
        BluetoothGatt bluetoothGatt = this.f24769b;
        if (bluetoothGatt != null) {
            try {
                bluetoothGatt.disconnect();
                this.f24769b.close();
            } catch (Exception e) {
                C9358Util.logWrite("closeConnect failed " + e.toString());
            }
            this.f24769b = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m17633n() {
        BluetoothGatt bluetoothGatt = this.f24769b;
        if (bluetoothGatt != null) {
            boolean z = false;
            int i = 1000;
            BluetoothGattService service = bluetoothGatt.getService(this.f24772e);
            if (service != null) {
                i = 1001;
                BluetoothGattCharacteristic characteristic = service.getCharacteristic(this.f24773f);
                if (characteristic != null) {
                    i = 1002;
                    try {
                        z = this.f24769b.readCharacteristic(characteristic);
                    } catch (Exception e) {
                        C9358Util.logWrite("readData failed " + e.toString());
                        i = 1003;
                    }
                }
            }
            if (!z) {
                m17601b(i);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m17635o() {
        BluetoothGatt bluetoothGatt = this.f24769b;
        if (bluetoothGatt != null) {
            boolean z = false;
            int i = 1000;
            try {
                z = bluetoothGatt.readRemoteRssi();
            } catch (Exception e) {
                C9358Util.logWrite("readRssi failed " + e.toString());
                i = 1001;
            }
            if (!z) {
                m17594a(i);
            }
        }
    }

    private class ConnectionTimerTask extends TimerTask {
        private ConnectionTimerTask() {
        }

        public void run() {
            if (BleBluetoothClient.this.f24777j) {
                BleBluetoothClient.m17634o(BleBluetoothClient.this);
                BleBluetoothClient.this.m17635o();
                if (((long) BleBluetoothClient.this.f24781n) == BleBluetoothClient.f24766r / BleBluetoothClient.f24767s) {
                    int unused = BleBluetoothClient.this.f24781n = 0;
                    BleBluetoothClient.this.m17633n();
                }
            }
        }
    }
}
