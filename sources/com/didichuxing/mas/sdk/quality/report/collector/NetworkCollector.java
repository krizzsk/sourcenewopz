package com.didichuxing.mas.sdk.quality.report.collector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.p171v2.store.IStoreCallback;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.mas.sdk.quality.report.analysis.AnalysisDelegater;
import com.didichuxing.mas.sdk.quality.report.analysis.Tracker;
import com.didichuxing.mas.sdk.quality.report.threadpool.ThreadPoolHelp;
import com.didichuxing.mas.sdk.quality.report.threadpool.ThreadTaskObject;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.List;

public class NetworkCollector {
    public static final String NETWORK_TYPE_UNKNOWN = "UNKNOWN";
    private static int currentSingleDbm = 0;
    private static String imsi = "";
    /* access modifiers changed from: private */
    public static ConnectivityManager mConnectivityManager = null;
    /* access modifiers changed from: private */
    public static Context mContext = null;
    /* access modifiers changed from: private */
    public static TelephonyManager mTelMgr = null;
    /* access modifiers changed from: private */
    public static WifiManager mWifiManager = null;
    private static String networkType = "";
    private static String operatorName = "";
    private static boolean readImsi = false;
    private static long timeLast = 0;
    private static String wifiSSID = "";

    public static void init(Context context) {
        mContext = context;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        NetWorkChangeReceiver netWorkChangeReceiver = new NetWorkChangeReceiver();
        Context context2 = mContext;
        if (context2 != null) {
            try {
                context2.registerReceiver(netWorkChangeReceiver, intentFilter);
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
            new ThreadTaskObject() {
                public void run() {
                    ThreadPoolHelp.renameThread(Thread.currentThread(), getClass().getName());
                    try {
                        ConnectivityManager unused = NetworkCollector.mConnectivityManager = (ConnectivityManager) NetworkCollector.mContext.getSystemService("connectivity");
                        TelephonyManager unused2 = NetworkCollector.mTelMgr = (TelephonyManager) NetworkCollector.mContext.getSystemService("phone");
                        WifiManager unused3 = NetworkCollector.mWifiManager = (WifiManager) NetworkCollector.mContext.getSystemService("wifi");
                    } catch (Throwable unused4) {
                        OLog.m34424w("NetworkCollector: Couldn't get getSystemService");
                    }
                }
            }.start();
        }
    }

    public static String getNetworkInfo() {
        StringBuilder sb = new StringBuilder();
        try {
            if (mConnectivityManager == null) {
                mConnectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(mConnectivityManager);
            if (activeNetworkInfo == null) {
                OLog.m34424w("NetworkCollector: Couldn't get NetworkInfo : " + mContext.getPackageName());
                return "";
            }
            if (!activeNetworkInfo.isConnected()) {
                sb.append("type: none\n");
            } else {
                sb.append("type: ");
                sb.append(activeNetworkInfo.getTypeName());
                sb.append("\n");
                if (activeNetworkInfo.getType() == 0) {
                    sb.append("subType: ");
                    sb.append(activeNetworkInfo.getSubtypeName());
                    sb.append("\n");
                    if (mTelMgr == null) {
                        mTelMgr = (TelephonyManager) mContext.getSystemService("phone");
                    }
                    sb.append("isRoaming: ");
                    sb.append(mTelMgr.isNetworkRoaming() ? "yes" : LoginOmegaUtil.NO_EMAIL);
                    sb.append("\n");
                }
            }
            return sb.toString();
        } catch (Throwable unused) {
            OLog.m34424w("NetworkCollector: Couldn't get NetworkInfo : " + mContext.getPackageName());
        }
    }

    public static String getNetworkStatus() {
        Context context = mContext;
        if (context == null) {
            return "UNKNOWN";
        }
        try {
            if (mConnectivityManager == null) {
                mConnectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(mConnectivityManager);
            if (activeNetworkInfo == null) {
                return "UNKNOWN";
            }
            if (!activeNetworkInfo.isConnected()) {
                return IStoreCallback.DEFAULT_API_DETAIL_KEY;
            }
            return activeNetworkInfo.getTypeName().toUpperCase();
        } catch (Throwable unused) {
            OLog.m34424w("getNetworkType fail.");
            return "UNKNOWN";
        }
    }

    public static String getNetworkType() {
        if (!TextUtils.isEmpty(networkType)) {
            return networkType;
        }
        updateNetWorkType();
        return networkType;
    }

    /* access modifiers changed from: private */
    public static void updateNetWorkType() {
        try {
            networkType = getNetworkTypeName();
        } catch (Throwable unused) {
            OLog.m34424w("getNetworkType fail");
            networkType = "UNKNOWN";
        }
    }

    public static String getNetworkTypeName() {
        Context context = mContext;
        if (context == null) {
            SystemUtils.log(6, "getNetworkTypeName", "context is null", (Throwable) null, "com.didichuxing.mas.sdk.quality.report.collector.NetworkCollector", 187);
            return "UNKNOWN";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return "UNKNOWN";
        }
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager);
        if (activeNetworkInfo != null && 1 == activeNetworkInfo.getType()) {
            return "WIFI";
        }
        if (!activeNetworkInfo.isConnected()) {
            return IStoreCallback.DEFAULT_API_DETAIL_KEY;
        }
        switch (getNetWorkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return "3G";
            case 13:
            case 18:
                return "4G";
            case 20:
                return "5G";
            default:
                return "UNKNOWN";
        }
    }

    public static int getNetWorkType() {
        Context context = mContext;
        int i = 0;
        if (context == null) {
            SystemUtils.log(6, "getNetWorkType", "context is null", (Throwable) null, "com.didichuxing.mas.sdk.quality.report.collector.NetworkCollector", 241);
            return 0;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        try {
            int subId = getSubId();
            if (subId != -1) {
                Object invokeMethod = ReflectionUtil.invokeMethod(telephonyManager, "android.telephony.TelephonyManager", "getDataNetworkType", new Class[]{Integer.TYPE}, Integer.valueOf(subId));
                if (invokeMethod instanceof Integer) {
                    i = ((Integer) invokeMethod).intValue();
                }
                if (i == 0 && checkPhonePermission(mContext)) {
                    i = telephonyManager.getNetworkType();
                }
            } else if (checkPhonePermission(mContext)) {
                i = telephonyManager.getNetworkType();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return i == 13 ? adjustNetworkType(mContext, i) : i;
    }

    private static boolean checkPhonePermission(Context context) {
        return ActivityCompat.checkSelfPermission(context, Permission.READ_PHONE_STATE) == 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.telephony.ServiceState} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int adjustNetworkType(android.content.Context r8, int r9) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 < r1) goto L_0x005d
            java.lang.String r0 = "android.permission.READ_PHONE_STATE"
            int r0 = r8.checkSelfPermission(r0)
            if (r0 != 0) goto L_0x005d
            java.lang.String r0 = "phone"
            java.lang.Object r8 = r8.getSystemService(r0)     // Catch:{ all -> 0x0059 }
            android.telephony.TelephonyManager r8 = (android.telephony.TelephonyManager) r8     // Catch:{ all -> 0x0059 }
            r0 = 0
            int r1 = getSubId()     // Catch:{ all -> 0x0059 }
            r2 = -1
            if (r1 != r2) goto L_0x0023
            android.telephony.ServiceState r8 = r8.getServiceState()     // Catch:{ all -> 0x0059 }
            goto L_0x004a
        L_0x0023:
            java.lang.String r2 = "android.telephony.TelephonyManager"
            java.lang.String r3 = "getServiceStateForSubscriber"
            r4 = 1
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ all -> 0x0059 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0059 }
            r7 = 0
            r5[r7] = r6     // Catch:{ all -> 0x0059 }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0059 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0059 }
            r4[r7] = r1     // Catch:{ all -> 0x0059 }
            java.lang.Object r1 = com.didichuxing.mas.sdk.quality.report.collector.ReflectionUtil.invokeMethod(r8, r2, r3, r5, r4)     // Catch:{ all -> 0x0059 }
            boolean r2 = r1 instanceof android.telephony.ServiceState     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x0042
            r0 = r1
            android.telephony.ServiceState r0 = (android.telephony.ServiceState) r0     // Catch:{ all -> 0x0059 }
        L_0x0042:
            if (r0 != 0) goto L_0x0049
            android.telephony.ServiceState r8 = r8.getServiceState()     // Catch:{ all -> 0x0059 }
            goto L_0x004a
        L_0x0049:
            r8 = r0
        L_0x004a:
            if (r8 == 0) goto L_0x005d
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0059 }
            boolean r8 = isServiceStateFiveGAvailable(r8)     // Catch:{ all -> 0x0059 }
            if (r8 == 0) goto L_0x005d
            r9 = 20
            goto L_0x005d
        L_0x0059:
            r8 = move-exception
            r8.printStackTrace()
        L_0x005d:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.collector.NetworkCollector.adjustNetworkType(android.content.Context, int):int");
    }

    private static boolean isServiceStateFiveGAvailable(String str) {
        return !TextUtils.isEmpty(str) && (str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED"));
    }

    private static int getSubId() {
        if (Build.VERSION.SDK_INT >= 24) {
            return SubscriptionManager.getDefaultDataSubscriptionId();
        }
        return -1;
    }

    public static String getWifiSsid() {
        if (!TextUtils.isEmpty(wifiSSID)) {
            return wifiSSID;
        }
        updateWifiSSID();
        return wifiSSID;
    }

    /* access modifiers changed from: private */
    public static void updateWifiSSID() {
        try {
            if (mWifiManager == null) {
                mWifiManager = (WifiManager) mContext.getSystemService("wifi");
            }
            WifiInfo connectionInfo = mWifiManager.getConnectionInfo();
            if (connectionInfo != null && connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
                wifiSSID = connectionInfo.getSSID();
            }
        } catch (Throwable th) {
            OLog.m34424w("getWifiSsid fail");
            Tracker.trackGood("getWifiSsid fail", th);
            wifiSSID = "";
        }
    }

    public static String getNetworkOperator() {
        try {
            if (mTelMgr == null) {
                mTelMgr = (TelephonyManager) mContext.getSystemService("phone");
            }
            if (timeLast == 0 || (System.currentTimeMillis() - timeLast) / 1000 > 300 || operatorName == null || "".equals(operatorName)) {
                operatorName = mTelMgr.getNetworkOperatorName();
                timeLast = System.currentTimeMillis();
            }
            return operatorName;
        } catch (RuntimeException unused) {
            OLog.m34424w("NetworkCollector: Couldn't get NetworkOperatorName : " + mContext.getPackageName());
            return "";
        }
    }

    public static String getNetworkOperatorType() {
        Context context = mContext;
        if (context == null) {
            return "UNKNOWN";
        }
        try {
            String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
            if ("46000".equals(simOperator) || "46002".equals(simOperator) || "46004".equals(simOperator) || "46007".equals(simOperator)) {
                return "中国移动";
            }
            if ("46020".equals(simOperator)) {
                return "中国移动";
            }
            if ("46001".equals(simOperator) || "46006".equals(simOperator)) {
                return "中国联通";
            }
            if ("46009".equals(simOperator)) {
                return "中国联通";
            }
            if ("46003".equals(simOperator) || "46005".equals(simOperator) || "46011".equals(simOperator)) {
                return "中国电信";
            }
            return "UNKNOWN";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getNetworkOperatorMCC() {
        try {
            String imsi2 = getIMSI("UNKNOWN");
            if (TextUtils.isEmpty(imsi2) || imsi2.length() != 15) {
                return "UNKNOWN";
            }
            return imsi2.substring(0, 3);
        } catch (Throwable unused) {
            OLog.m34424w("NetworkCollector: Couldn't get NetworkOperatorMCC : " + mContext.getPackageName());
            return "UNKNOWN";
        }
    }

    public static String getNetworkOperatorMNC() {
        try {
            String imsi2 = getIMSI("UNKNOWN");
            if (TextUtils.isEmpty(imsi2) || imsi2.length() != 15) {
                return "UNKNOWN";
            }
            return imsi2.substring(3, 5);
        } catch (Throwable unused) {
            OLog.m34424w("NetworkCollector: Couldn't get NetworkOperatorMNC : " + mContext.getPackageName());
            return "UNKNOWN";
        }
    }

    public static String getNetworkOperatorMSIN() {
        if (!AnalysisDelegater.isAppAtFront()) {
            return "UNKNOWN";
        }
        try {
            String imsi2 = getIMSI("UNKNOWN");
            if (TextUtils.isEmpty(imsi2) || imsi2.length() != 15) {
                return "UNKNOWN";
            }
            return imsi2.substring(5, 15);
        } catch (Throwable unused) {
            OLog.m34424w("NetworkCollector: Couldn't get NetworkOperatorMSIN : " + mContext.getPackageName());
            return "UNKNOWN";
        }
    }

    public static String getIMSI(String str) {
        if (!TextUtils.isEmpty(imsi)) {
            return imsi;
        }
        if (readImsi || !AnalysisDelegater.isAppAtFront() || mContext.checkSelfPermission(Permission.READ_PHONE_STATE) != 0) {
            return str;
        }
        if (mTelMgr == null) {
            mTelMgr = (TelephonyManager) mContext.getSystemService("phone");
        }
        String subscriberId = mTelMgr.getSubscriberId();
        imsi = subscriberId;
        readImsi = true;
        return subscriberId;
    }

    public static int getCellid() {
        try {
            if (mContext.checkCallingOrSelfPermission(Permission.ACCESS_FINE_LOCATION) != 0 && mContext.checkCallingOrSelfPermission(Permission.ACCESS_COARSE_LOCATION) != 0) {
                return -1;
            }
            if (mTelMgr == null) {
                mTelMgr = (TelephonyManager) mContext.getSystemService("phone");
            }
            CellLocation cellLocation = mTelMgr.getCellLocation();
            if (cellLocation instanceof GsmCellLocation) {
                return ((GsmCellLocation) cellLocation).getCid();
            }
            if (cellLocation instanceof CdmaCellLocation) {
                return ((CdmaCellLocation) cellLocation).getBaseStationId();
            }
            return -1;
        } catch (RuntimeException unused) {
            OLog.m34424w("NetworkCollector: Couldn't get Cellid : " + mContext.getPackageName());
            return -1;
        }
    }

    public static int getLac() {
        try {
            if (mContext.checkCallingOrSelfPermission(Permission.ACCESS_FINE_LOCATION) != 0 && mContext.checkCallingOrSelfPermission(Permission.ACCESS_COARSE_LOCATION) != 0) {
                return -1;
            }
            if (mTelMgr == null) {
                mTelMgr = (TelephonyManager) mContext.getSystemService("phone");
            }
            CellLocation cellLocation = mTelMgr.getCellLocation();
            if (cellLocation instanceof GsmCellLocation) {
                return ((GsmCellLocation) cellLocation).getLac();
            }
            if (cellLocation instanceof CdmaCellLocation) {
                return ((CdmaCellLocation) cellLocation).getNetworkId();
            }
            return -1;
        } catch (RuntimeException unused) {
            OLog.m34424w("NetworkCollector: Couldn't get Lac : " + mContext.getPackageName());
            return -1;
        }
    }

    public static int getNetWorkStrength() {
        List<CellInfo> allCellInfo;
        int i = currentSingleDbm;
        if (i != 0) {
            return i;
        }
        try {
            if (mContext.checkCallingOrSelfPermission(Permission.ACCESS_FINE_LOCATION) != 0 && mContext.checkCallingOrSelfPermission(Permission.ACCESS_COARSE_LOCATION) != 0) {
                return currentSingleDbm;
            }
            if (mTelMgr == null) {
                mTelMgr = (TelephonyManager) mContext.getSystemService("phone");
            }
            if (Build.VERSION.SDK_INT >= 18 && (allCellInfo = mTelMgr.getAllCellInfo()) != null) {
                for (CellInfo next : allCellInfo) {
                    if (next instanceof CellInfoGsm) {
                        currentSingleDbm = ((CellInfoGsm) next).getCellSignalStrength().getDbm();
                    } else if (next instanceof CellInfoCdma) {
                        currentSingleDbm = ((CellInfoCdma) next).getCellSignalStrength().getDbm();
                    } else if (next instanceof CellInfoWcdma) {
                        currentSingleDbm = ((CellInfoWcdma) next).getCellSignalStrength().getDbm();
                    } else if (next instanceof CellInfoLte) {
                        currentSingleDbm = ((CellInfoLte) next).getCellSignalStrength().getDbm();
                    }
                }
            }
            return currentSingleDbm;
        } catch (Throwable unused) {
            OLog.m34420i("getNetWorkStrength error");
        }
    }

    private static class NetWorkChangeReceiver extends BroadcastReceiver {
        private NetWorkChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION.equals(action)) {
                return;
            }
            if (NetworkCollector.mConnectivityManager != null) {
                NetworkCollector.updateNetWorkType();
            } else if ("android.net.wifi.STATE_CHANGE".equals(action)) {
                NetworkCollector.updateWifiSSID();
            }
        }
    }
}
