package com.didichuxing.mas.sdk.quality.report.collector;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mas.sdk.quality.report.MASMapConfig;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import java.util.Set;

public class PackageCollector {
    private static String mAppLabel;
    private static String mAppName;
    private static Context mContext;
    private static PackageInfo mPkgInfo;
    private static PackageManager mPkgMgr;

    public static void init(Context context) {
        mContext = context;
        try {
            PackageManager packageManager = context.getPackageManager();
            mPkgMgr = packageManager;
            mPkgInfo = SystemUtils.getPackageInfo(packageManager, mContext.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            OLog.m34424w("PackageCollector.init fail.");
        }
    }

    public static String getPkgName() {
        Context context;
        if (MASMapConfig.config != null) {
            return MASMapConfig.config.getPackageName();
        }
        if (TextUtils.isEmpty(mAppName) && (context = mContext) != null) {
            mAppName = context.getPackageName();
        }
        return mAppName;
    }

    public static String getAppLabel() {
        if (TextUtils.isEmpty(mAppLabel)) {
            PackageInfo packageInfo = mPkgInfo;
            if (packageInfo == null) {
                return "";
            }
            mAppLabel = packageInfo.applicationInfo.loadLabel(mPkgMgr).toString();
        }
        return mAppLabel;
    }

    public static String getVN() {
        if (MASMapConfig.config != null) {
            return MASMapConfig.config.getAppVersionName();
        }
        PackageInfo packageInfo = mPkgInfo;
        if (packageInfo == null) {
            return "";
        }
        return packageInfo.versionName;
    }

    public static int getVC() {
        if (MASMapConfig.config != null) {
            return MASMapConfig.config.getAppVersionCode();
        }
        PackageInfo packageInfo = mPkgInfo;
        if (packageInfo == null) {
            return 0;
        }
        return packageInfo.versionCode;
    }

    public static String getBlueToothList() {
        StringBuilder sb = new StringBuilder();
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
                if (bondedDevices.size() > 0) {
                    for (BluetoothDevice next : bondedDevices) {
                        sb.append(next.getName() + "," + next.getAddress() + "\n");
                    }
                }
            }
            return sb.toString();
        } catch (Exception e) {
            OLog.m34418e(e.getMessage());
            return sb.toString();
        } catch (Throwable unused) {
            return sb.toString();
        }
    }
}
