package com.didichuxing.omega.sdk.common.collector;

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
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.Log;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.p171v2.store.IStoreCallback;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.threadpool.ThreadPoolHelp;
import com.didichuxing.omega.sdk.common.threadpool.ThreadTaskObject;
import com.didichuxing.omega.sdk.common.utils.OLog;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.List;

public class NetworkCollector {
    private static volatile String IMSI = "";
    private static int currentSingleDbm = 0;
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
    private static long timeLast = 0;
    private static String wifiSSID = "";

    public static void init(Context context) {
        mContext = context;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        try {
            mContext.registerReceiver(new NetWorkChangeReceiver(), intentFilter);
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
                    OLog.m34769w("NetworkCollector: Couldn't get getSystemService");
                }
            }
        }.start();
    }

    public static String getNetworkInfo() {
        StringBuilder sb = new StringBuilder();
        try {
            if (mConnectivityManager == null) {
                mConnectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(mConnectivityManager);
            if (activeNetworkInfo == null) {
                OLog.m34769w("NetworkCollector: Couldn't get NetworkInfo : " + mContext.getPackageName());
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
            OLog.m34769w("NetworkCollector: Couldn't get NetworkInfo : " + mContext.getPackageName());
        }
    }

    public static String getNetworkStatus() {
        try {
            if (mConnectivityManager == null) {
                mConnectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
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
            OLog.m34769w("getNetworkType fail.");
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
            if (mConnectivityManager == null) {
                mConnectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(mConnectivityManager);
            if (activeNetworkInfo == null) {
                networkType = "UNKNOWN";
            } else if (!activeNetworkInfo.isConnected()) {
                networkType = IStoreCallback.DEFAULT_API_DETAIL_KEY;
            } else {
                int type = activeNetworkInfo.getType();
                int subtype = activeNetworkInfo.getSubtype();
                if (1 == type) {
                    networkType = "WIFI";
                } else if (type == 0) {
                    switch (subtype) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            networkType = "2G";
                            return;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            networkType = "3G";
                            return;
                        case 13:
                            networkType = "4G";
                            return;
                        default:
                            networkType = "UNKNOWN";
                            return;
                    }
                }
            }
        } catch (Throwable unused) {
            OLog.m34769w("getNetworkType fail");
            networkType = "UNKNOWN";
        }
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
            OLog.m34769w("getWifiSsid fail");
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
            OLog.m34769w("NetworkCollector: Couldn't get NetworkOperatorName : " + mContext.getPackageName());
            return "";
        }
    }

    public static String getNetworkOperatorName() {
        try {
            String imsi = getIMSI("");
            if (imsi == null || imsi.length() != 15) {
                return "";
            }
            if (!imsi.startsWith("46000") && !imsi.startsWith("46002") && !imsi.startsWith("46007")) {
                if (!imsi.startsWith("46020")) {
                    if (!imsi.startsWith("46001")) {
                        if (!imsi.startsWith("46006")) {
                            if (!imsi.startsWith("46003") && !imsi.startsWith("46005")) {
                                if (!imsi.startsWith("46011")) {
                                    return imsi.substring(0, 5);
                                }
                            }
                            return "中国电信";
                        }
                    }
                    return "中国联通";
                }
            }
            return "中国移动";
        } catch (Throwable unused) {
            OLog.m34769w("NetworkCollector: Couldn't get NetworkOperatorName : " + mContext.getPackageName());
            return "";
        }
    }

    public static String getNetworkOperatorMCC() {
        try {
            String imsi = getIMSI("UNKNOW");
            if (imsi == null || imsi.length() != 15) {
                return "UNKNOW";
            }
            return imsi.substring(0, 3);
        } catch (Throwable unused) {
            OLog.m34769w("NetworkCollector: Couldn't get NetworkOperatorMCC : " + mContext.getPackageName());
            return "UNKNOW";
        }
    }

    public static String getNetworkOperatorMNC() {
        try {
            String imsi = getIMSI("UNKNOW");
            if (imsi == null || imsi.length() != 15) {
                return "UNKNOW";
            }
            return imsi.substring(3, 5);
        } catch (Throwable unused) {
            OLog.m34769w("NetworkCollector: Couldn't get NetworkOperatorMNC : " + mContext.getPackageName());
            return "UNKNOW";
        }
    }

    public static String getNetworkOperatorMSIN() {
        try {
            String imsi = getIMSI("UNKNOW");
            if (imsi == null || imsi.length() != 15) {
                return "UNKNOW";
            }
            return imsi.substring(5, 15);
        } catch (Throwable unused) {
            OLog.m34769w("NetworkCollector: Couldn't get NetworkOperatorMSIN : " + mContext.getPackageName());
            return "UNKNOW";
        }
    }

    public static String getIMSI(String str) {
        try {
            if (!TextUtils.isEmpty(IMSI)) {
                return IMSI;
            }
            if (mContext.checkCallingOrSelfPermission(Permission.READ_PHONE_STATE) != 0) {
                return str;
            }
            if (mTelMgr == null) {
                mTelMgr = (TelephonyManager) mContext.getSystemService("phone");
            }
            IMSI = mTelMgr.getSubscriberId();
            return IMSI;
        } catch (Exception unused) {
            IMSI = "";
            OLog.m34763e("NetworkCollector: Couldn't get getSubscriberId");
        }
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
            OLog.m34769w("NetworkCollector: Couldn't get Cellid : " + mContext.getPackageName());
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
            OLog.m34769w("NetworkCollector: Couldn't get Lac : " + mContext.getPackageName());
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
            OLog.m34765i("getNetWorkStrength error");
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
