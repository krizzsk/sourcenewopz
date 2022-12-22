package com.didi.map.global.component.bluetooth.server;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.Context;
import android.content.IntentFilter;
import android.os.ParcelUuid;
import android.text.TextUtils;
import android.util.Log;
import com.didi.common.map.Map;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.bluetooth.BluetoothListenerReceiver;
import com.didi.map.global.component.bluetooth.apollo.BluetoothApolloUtil;
import com.didi.map.global.component.bluetooth.util.C9358Util;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.UUID;

public class BleBluetoothServer implements IBleBluetoothServerInterface {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final long f24793a = BluetoothApolloUtil.getEngineValidTimeInterval();

    /* renamed from: b */
    private BluetoothLeAdvertiser f24794b;

    /* renamed from: c */
    private BluetoothGattServer f24795c = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IBleBluetoothServerCallBack f24796d = null;

    /* renamed from: e */
    private String f24797e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public UUID f24798f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public UUID f24799g;

    /* renamed from: h */
    private Context f24800h;

    /* renamed from: i */
    private boolean f24801i = true;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public byte[] f24802j = null;

    /* renamed from: k */
    private final AdvertiseCallback f24803k = new AdvertiseCallback() {
        public void onStartSuccess(AdvertiseSettings advertiseSettings) {
            if (BleBluetoothServer.this.f24796d != null) {
                BleBluetoothServer.this.f24796d.onStateChange(ServerState.OpenAdvertiserSuccess);
            }
            C9358Util.logWrite("AdvertiseCallback onStartSuccess Success");
        }

        public void onStartFailure(int i) {
            C9358Util.logWrite("AdvertiseCallback onStartFailure, errorCode = " + i);
            if (BleBluetoothServer.this.f24796d != null) {
                BleBluetoothServer.this.f24796d.onStateChange(ServerState.OpenAdvertiserFailure);
            }
        }
    };

    /* renamed from: l */
    private BluetoothListenerReceiver f24804l = null;

    /* renamed from: m */
    private final BluetoothGattServerCallback f24805m = new BluetoothGattServerCallback() {
        public void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i, int i2) {
            String str;
            if (bluetoothDevice != null) {
                C9358Util.logWrite(String.format("onConnectionStateChange:%s,%s,%s,%s", new Object[]{bluetoothDevice.getName(), bluetoothDevice.getAddress(), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            if (i == 0) {
                str = i2 == 2 ? "与[%s]连接成功" : "与[%s]连接断开";
            } else {
                str = "与[%s]连接出错,错误码:" + i;
            }
            C9358Util.logWrite(String.format(str, new Object[]{bluetoothDevice}));
        }

        public void onCharacteristicReadRequest(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            BleServerData bleServerData;
            if (bluetoothGattCharacteristic.getUuid().equals(BleBluetoothServer.this.f24799g)) {
                String str = null;
                if (i2 == 0) {
                    if (BleBluetoothServer.this.f24796d != null) {
                        bleServerData = BleBluetoothServer.this.f24796d.getReadData();
                        if (bleServerData != null && LatLngUtils.locateCorrect(bleServerData.getDriverPos()) && Math.abs(System.currentTimeMillis() - bleServerData.getDriverTime()) < BleBluetoothServer.f24793a) {
                            str = BleBluetoothServer.m17646b(bleServerData.getDriverPos().latitude) + "," + BleBluetoothServer.m17646b(bleServerData.getDriverPos().longitude) + "," + ((int) bleServerData.getDriverAcc());
                        }
                    } else {
                        bleServerData = null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        byte[] unused = BleBluetoothServer.this.f24802j = C9358Util.mCompression(str.getBytes());
                    } else {
                        byte[] unused2 = BleBluetoothServer.this.f24802j = "there is no data".getBytes();
                        if (bleServerData != null) {
                            if (!LatLngUtils.locateCorrect(bleServerData.getDriverPos())) {
                                C9358Util.logWrite("获取到的司机定位格式不正确");
                                byte[] unused3 = BleBluetoothServer.this.f24802j = "locate error".getBytes();
                            }
                            if (Math.abs(System.currentTimeMillis() - bleServerData.getDriverTime()) >= BleBluetoothServer.f24793a) {
                                long abs = Math.abs(System.currentTimeMillis() - bleServerData.getDriverTime());
                                C9358Util.logWrite("获取到的司机定位时间戳不符合要求, 时间差为:" + abs);
                                byte[] unused4 = BleBluetoothServer.this.f24802j = ("time error:" + abs).getBytes();
                            }
                        } else {
                            C9358Util.logWrite("获取不到司机定位");
                        }
                    }
                    BleBluetoothServer bleBluetoothServer = BleBluetoothServer.this;
                    bleBluetoothServer.m17643a(bluetoothDevice, i, i2, bleBluetoothServer.f24802j);
                } else if (BleBluetoothServer.this.f24802j == null || i2 >= BleBluetoothServer.this.f24802j.length) {
                    BleBluetoothServer.this.m17643a(bluetoothDevice, i, i2, (byte[]) null);
                } else {
                    int length = BleBluetoothServer.this.f24802j.length - i2;
                    byte[] bArr = new byte[length];
                    System.arraycopy(BleBluetoothServer.this.f24802j, i2, bArr, 0, length);
                    BleBluetoothServer.this.m17643a(bluetoothDevice, i, i2, bArr);
                }
            } else {
                BleBluetoothServer.this.m17643a(bluetoothDevice, i, i2, "there is no data".getBytes());
                C9358Util.logWrite("CharacterUUID 不正确");
            }
        }

        public void onServiceAdded(int i, BluetoothGattService bluetoothGattService) {
            if (BleBluetoothServer.this.f24796d == null) {
                return;
            }
            if (i != 0 || bluetoothGattService == null || bluetoothGattService.getUuid() == null || !bluetoothGattService.getUuid().equals(BleBluetoothServer.this.f24798f)) {
                BleBluetoothServer.this.f24796d.onStateChange(ServerState.AddServiceFailure);
                C9358Util.logWrite("onServiceAdded failed");
                return;
            }
            BleBluetoothServer.this.f24796d.onStateChange(ServerState.AddServiceSuccess);
            C9358Util.logWrite("onServiceAdded ok");
        }
    };

    /* renamed from: n */
    private final AdvertiseSettings f24806n = new AdvertiseSettings.Builder().setAdvertiseMode(2).setTxPowerLevel(3).setConnectable(true).build();

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17643a(BluetoothDevice bluetoothDevice, int i, int i2, byte[] bArr) {
        BluetoothGattServer bluetoothGattServer = this.f24795c;
        if (bluetoothGattServer != null) {
            try {
                bluetoothGattServer.sendResponse(bluetoothDevice, i, 0, i2, bArr);
            } catch (Exception e) {
                C9358Util.logWrite("sendResponse failed " + e.toString());
            }
        }
    }

    public void create(Context context, Map map) {
        C9358Util.logWrite("BleBluetoothServer create");
        this.f24800h = context;
    }

    public void start() {
        if (!C9358Util.bluetoothEnable() || !C9358Util.checkBlePermission(this.f24800h)) {
            C9358Util.logWrite("startAdvertiser Failed ：蓝牙不可用");
        } else {
            m17649c();
        }
    }

    public void stop() {
        m17652d();
    }

    public void setConfigParam(BleBluetoothServerParam bleBluetoothServerParam) {
        if (bleBluetoothServerParam == null || TextUtils.isEmpty(bleBluetoothServerParam.orderId)) {
            C9358Util.logWrite("setConfigParam err ：入参错误");
            return;
        }
        this.f24796d = bleBluetoothServerParam.mCallback;
        this.f24797e = bleBluetoothServerParam.orderId;
        this.f24804l = bleBluetoothServerParam.receiver;
        m17654f();
        C9358Util.logWrite("BleBluetoothServer setConfigParam" + this.f24797e);
        UUID OrderIdToUUID = C9358Util.OrderIdToUUID(this.f24797e);
        this.f24798f = OrderIdToUUID;
        if (OrderIdToUUID == null) {
            C9358Util.logWrite("setConfigParam ：orderId转mServiceUUID出错");
        }
        UUID OrderIdToUUID2 = C9358Util.OrderIdToUUID(this.f24797e + "ReadCharacter");
        this.f24799g = OrderIdToUUID2;
        if (OrderIdToUUID2 == null) {
            C9358Util.logWrite("setDataCallBack ：orderId转mReadCharacterUUID出错");
        }
    }

    public void onMapVisible(boolean z) {
        this.f24801i = z;
        C9358Util.logWrite("BleBluetoothServer onMapVisible" + z);
    }

    public void destroy() {
        C9358Util.logWrite("BleBluetoothServer destroy");
        m17653e();
        m17652d();
        m17648b();
        this.f24794b = null;
        this.f24800h = null;
        this.f24797e = null;
        this.f24798f = null;
        this.f24799g = null;
        this.f24796d = null;
    }

    /* renamed from: b */
    private void m17648b() {
        BluetoothListenerReceiver bluetoothListenerReceiver;
        Context context = this.f24800h;
        if (context != null && (bluetoothListenerReceiver = this.f24804l) != null) {
            try {
                context.unregisterReceiver(bluetoothListenerReceiver);
            } catch (Exception e) {
                try {
                    Log.d("Context", "unregisterReceiver", e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    C9358Util.logWrite("unregisterReceiver crash " + e2.toString());
                }
            }
            this.f24804l = null;
        }
    }

    /* renamed from: a */
    private AdvertiseData m17640a(UUID uuid) {
        return new AdvertiseData.Builder().setIncludeDeviceName(false).setIncludeTxPowerLevel(false).addServiceUuid(new ParcelUuid(uuid)).build();
    }

    /* renamed from: c */
    private void m17649c() {
        m17652d();
        C9358Util.logWrite("startAdvertising");
        if (this.f24798f != null) {
            BluetoothLeAdvertiser bluetoothLeAdvertiser = BluetoothAdapter.getDefaultAdapter().getBluetoothLeAdvertiser();
            this.f24794b = bluetoothLeAdvertiser;
            if (bluetoothLeAdvertiser != null) {
                try {
                    bluetoothLeAdvertiser.startAdvertising(this.f24806n, m17640a(this.f24798f), this.f24803k);
                    m17656h();
                } catch (Exception e) {
                    C9358Util.logWrite("startAdvertising failed " + e.toString());
                }
            }
        }
    }

    /* renamed from: d */
    private void m17652d() {
        m17653e();
        C9358Util.logWrite("stopAdvertising");
        BluetoothLeAdvertiser bluetoothLeAdvertiser = this.f24794b;
        if (bluetoothLeAdvertiser != null) {
            try {
                bluetoothLeAdvertiser.stopAdvertising(this.f24803k);
                this.f24794b = null;
            } catch (Exception e) {
                C9358Util.logWrite("stopAdvertiser failed ： " + e.toString());
            }
        }
    }

    /* renamed from: e */
    private void m17653e() {
        C9358Util.logWrite("closeConnect");
        this.f24802j = null;
        BluetoothGattServer bluetoothGattServer = this.f24795c;
        if (bluetoothGattServer != null) {
            try {
                bluetoothGattServer.close();
            } catch (Exception e) {
                C9358Util.logWrite("closeConnect failed " + e.toString());
            }
            this.f24795c = null;
        }
    }

    /* renamed from: f */
    private void m17654f() {
        BluetoothListenerReceiver bluetoothListenerReceiver;
        Context context = this.f24800h;
        if (context != null && (bluetoothListenerReceiver = this.f24804l) != null) {
            try {
                try {
                    context.registerReceiver(bluetoothListenerReceiver, m17655g());
                } catch (Exception e) {
                    Log.d("Context", "registerReceiver", e);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                C9358Util.logWrite("registerReceiver crash " + e2.toString());
            }
        }
    }

    /* renamed from: g */
    private IntentFilter m17655g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        return intentFilter;
    }

    /* renamed from: h */
    private void m17656h() {
        BluetoothManager bluetoothManager;
        C9358Util.logWrite("addConnectService");
        Context context = this.f24800h;
        if (context != null && (bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth")) != null && this.f24799g != null) {
            BluetoothGattService bluetoothGattService = new BluetoothGattService(this.f24798f, 0);
            bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(this.f24799g, 2, 1));
            try {
                BluetoothGattServer openGattServer = bluetoothManager.openGattServer(this.f24800h, this.f24805m);
                this.f24795c = openGattServer;
                if (openGattServer != null) {
                    openGattServer.addService(bluetoothGattService);
                }
            } catch (Exception e) {
                C9358Util.logWrite("addConnectService failed " + e.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m17646b(double d) {
        DecimalFormat decimalFormat = new DecimalFormat("##0.000000");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        return decimalFormat.format(d);
    }
}
