package com.didi.map.global.component.bluetooth.util;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.bluetooth.apollo.ApolloParamRssi2Distance;
import com.didi.map.global.component.bluetooth.apollo.BluetoothApolloUtil;
import com.yanzhenjie.permission.runtime.Permission;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.UUID;

/* renamed from: com.didi.map.global.component.bluetooth.util.Util */
public class C9358Util {

    /* renamed from: a */
    private static final String f24810a = "BluetoothComponent";

    public static UUID OrderIdToUUID(String str) {
        if (TextUtils.isEmpty(str)) {
            logWrite("OrderIdToUUID, input error");
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(new BigInteger(1, MessageDigest.getInstance("md5").digest(str.getBytes())).toString(16));
            int length = 32 - sb.length();
            for (int i = 0; i < length; i++) {
                sb.insert(0, "0");
            }
            sb.insert(20, "-");
            sb.insert(16, "-");
            sb.insert(12, "-");
            sb.insert(8, "-");
            return UUID.fromString(sb.toString());
        } catch (NoSuchAlgorithmException e) {
            logWrite("没有这个md5算法！");
            e.printStackTrace();
            return null;
        }
    }

    public static boolean bluetoothEnable() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            logWrite("本机没有找到蓝牙硬件或驱动！");
            return false;
        } else if (!defaultAdapter.isEnabled()) {
            logWrite("蓝牙关闭着！");
            return false;
        } else {
            logWrite("蓝牙已打开！");
            return true;
        }
    }

    public static boolean checkBlePermission(Context context) {
        if (context == null) {
            return false;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (context.getApplicationInfo() != null && context.getApplicationInfo().targetSdkVersion >= 31 && Build.VERSION.SDK_INT >= 31) {
            logWrite("Android 12 蓝牙权限检测");
            arrayList.add("android.permission.BLUETOOTH_SCAN");
            arrayList.add("android.permission.BLUETOOTH_ADVERTISE");
            arrayList.add("android.permission.BLUETOOTH_CONNECT");
        } else if (Build.VERSION.SDK_INT >= 23) {
            logWrite("Android 6 蓝牙权限检测");
            arrayList.add("android.permission.BLUETOOTH_ADMIN");
            arrayList.add(Permission.ACCESS_COARSE_LOCATION);
        } else {
            logWrite("Android 6 以下 蓝牙权限检测");
        }
        for (String a : arrayList) {
            if (m17657a(context, a) != 0) {
                logWrite("无蓝牙权限！");
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static int m17657a(Context context, String str) {
        try {
            return ContextCompat.checkSelfPermission(context, str);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static double getDistance(int i) {
        int abs = Math.abs(i);
        ApolloParamRssi2Distance apolloParamRssi2Distance = BluetoothApolloUtil.getApolloParamRssi2Distance();
        return Math.pow(10.0d, (((double) abs) - apolloParamRssi2Distance.A_Value) / (apolloParamRssi2Distance.n_Value * 10.0d));
    }

    public static void logWrite(String str) {
        DLog.m7384d(f24810a, str, new Object[0]);
    }

    public static String getBit(byte b, int i) {
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            sb.append((b >> 3) & 1);
            sb.append((b >> 2) & 1);
            sb.append((b >> 1) & 1);
            sb.append((b >> 0) & 1);
        } else {
            sb.append((b >> 7) & 1);
            sb.append((b >> 6) & 1);
            sb.append((b >> 5) & 1);
            sb.append((b >> 4) & 1);
            sb.append((b >> 3) & 1);
            sb.append((b >> 2) & 1);
            sb.append((b >> 1) & 1);
            sb.append((b >> 0) & 1);
        }
        return sb.toString();
    }

    public static byte bitToByte(String str) {
        int i;
        if (str == null) {
            return 0;
        }
        int length = str.length();
        if (length != 4 && length != 8) {
            return 0;
        }
        if (length != 8) {
            i = Integer.parseInt(str, 2);
        } else if (str.charAt(0) == '0') {
            i = Integer.parseInt(str, 2);
        } else {
            i = Integer.parseInt(str, 2) + InputDeviceCompat.SOURCE_ANY;
        }
        return (byte) i;
    }

    public static byte[] mCompression(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = (bArr.length + 1) / 2;
        byte[] bArr2 = new byte[length];
        int i = 0;
        int i2 = 0;
        while (i < bArr.length && i2 < length) {
            String bit = getBit((byte) (bArr[i] - 42), 0);
            int i3 = i + 1;
            if (i3 < bArr.length) {
                bit = bit + getBit((byte) (bArr[i3] - 42), 0);
            }
            bArr2[i2] = bitToByte(bit);
            i += 2;
            i2++;
        }
        return bArr2;
    }

    public static byte[] mDecompress(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (byte bit : bArr) {
            String bit2 = getBit(bit, 1);
            String substring = bit2.substring(0, 4);
            String substring2 = bit2.substring(4);
            byte bitToByte = bitToByte(substring);
            if (bitToByte != 0) {
                arrayList.add(Byte.valueOf((byte) (bitToByte + 42)));
            }
            byte bitToByte2 = bitToByte(substring2);
            if (bitToByte2 != 0) {
                arrayList.add(Byte.valueOf((byte) (bitToByte2 + 42)));
            }
        }
        byte[] bArr2 = new byte[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            bArr2[i] = ((Byte) arrayList.get(i)).byteValue();
        }
        return bArr2;
    }
}
