package com.cardinalcommerce.p060a;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cardinalcommerce.a.setCompoundDrawablesRelative */
public final class setCompoundDrawablesRelative implements Serializable, Runnable {
    private static int cca_continue = 1;
    private static int init;
    public List<char[]> Cardinal;
    public boolean getInstance;

    setCompoundDrawablesRelative(Context context) {
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
        if (bluetoothManager != null && bluetoothManager.getAdapter() != null) {
            ArrayList arrayList = new ArrayList();
            for (BluetoothDevice name : bluetoothManager.getAdapter().getBondedDevices()) {
                arrayList.add(setHorizontallyScrolling.getInstance(name.getName()));
            }
            this.Cardinal = arrayList;
            this.getInstance = bluetoothManager.getAdapter().isEnabled();
        }
    }

    public final JSONObject init() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!(this.Cardinal == null)) {
                int i = init;
                int i2 = ((((i | 88) << 1) - (i ^ 88)) - 0) - 1;
                cca_continue = i2 % 128;
                int i3 = i2 % 2;
                if (!this.Cardinal.isEmpty()) {
                    jSONObject.putOpt("BondedDevices", new JSONArray(setHorizontallyScrolling.configure(this.Cardinal)));
                    int i4 = init + 1;
                    cca_continue = i4 % 128;
                    int i5 = i4 % 2;
                }
            }
            jSONObject.putOpt("IsBluetoothEnabled", Boolean.valueOf(this.getInstance));
            int i6 = init;
            int i7 = i6 ^ 67;
            int i8 = -(-((i6 & 67) << 1));
            int i9 = (i7 ^ i8) + ((i8 & i7) << 1);
            cca_continue = i9 % 128;
            int i10 = i9 % 2;
        } catch (JSONException e) {
            setTextMetricsParams.getSDKVersion().configure("13101", e.getLocalizedMessage(), (String) null);
        }
        int i11 = cca_continue;
        int i12 = i11 & 53;
        int i13 = ((i11 ^ 53) | i12) << 1;
        int i14 = -((i11 | 53) & (~i12));
        int i15 = (i13 ^ i14) + ((i14 & i13) << 1);
        init = i15 % 128;
        if ((i15 % 2 != 0 ? (char) 14 : 0) == 0) {
            return jSONObject;
        }
        int i16 = 93 / 0;
        return jSONObject;
    }

    public final void run() {
        int i = cca_continue;
        int i2 = i & 93;
        int i3 = (((i | 93) & (~i2)) - (~(-(-(i2 << 1))))) - 1;
        init = i3 % 128;
        int i4 = i3 % 2;
        setHorizontallyScrolling.init(this.Cardinal);
        boolean z = false;
        this.getInstance = false;
        int i5 = cca_continue;
        int i6 = i5 & 55;
        int i7 = i6 + ((i5 ^ 55) | i6);
        init = i7 % 128;
        if (i7 % 2 != 0) {
            z = true;
        }
        if (z) {
            Object obj = null;
            super.hashCode();
        }
    }
}
