package com.didichuxing.omega.sdk.common.collector;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.omega.sdk.analysis.SystemTrack;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.perforence.ServiceConfig;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.didichuxing.omega.sdk.common.utils.OLog;

public class PersistentInfoCollector {
    public static final String KEY_FIVE_ODAT = "fiveodat";
    public static final String KEY_LAST_APP_VERSION_UPLOAD_SCREENSHOT = "lavus";
    public static final String KEY_LAST_PAGE_PAUSE_TIME = "lppt";
    public static final String KEY_LAST_SEND_REAL_EVENT_SEQ = "lsres";
    public static final String KEY_MOMENT_ID = "mid";
    public static final String KEY_MOMENT_LAST_STOP_TIME = "mlst";
    public static final String KEY_ODAT = "odat";
    public static final String KEY_OMEGA_ID = "omega_id";
    public static final String KEY_OMEGA_LAST_SEND_EVENT_SEQ = "omega_lses_";
    public static final String KEY_SESSION_LAST_DATE = "ssld";
    public static final String KEY_SESSION_LAST_STOP_TIME = "sslst";
    public static final String KEY_STARTUP_LAST_STOP_TIME = "slst";
    public static final String OMEGA_USER_INFO = "omega_user_info";
    private static final String SHARED_OMEGA_ID_FILE = ".omega.key";
    private static long lastOmgHourlyTime = 0;
    private static long lastPagePauseTime = 0;
    private static Context mContext = null;
    private static long mLastSendEventSeq = 0;
    private static long mLastSendRealEventSeq = 1;
    private static SharedPreferences mPref;
    private static long momentId;
    private static String omegaId;
    private static long startupLastStopTime;

    public static void init(Context context) {
        mContext = context;
        mPref = SystemUtils.getSharedPreferences(context, "omega_user_info", 0);
    }

    public static String getOmegaId() {
        if (OmegaConfig.DEBUG_TEMP_OMEGA_ID != null && OmegaConfig.DEBUG_TEMP_OMEGA_ID.length() > 0) {
            return OmegaConfig.DEBUG_TEMP_OMEGA_ID;
        }
        if (omegaId == null) {
            try {
                String sharedOmegaId = getSharedOmegaId();
                String string = mPref.getString("omega_id", "");
                if (sharedOmegaId != null) {
                    omegaId = sharedOmegaId;
                } else if (string.length() > 0) {
                    omegaId = string;
                } else {
                    omegaId = CommonUtil.randomBase64UUID();
                }
                if (!omegaId.matches("[a-zA-Z0-9-]+")) {
                    omegaId = CommonUtil.randomBase64UUID();
                }
                if (!omegaId.equals(sharedOmegaId)) {
                    setSharedOmegaIdFile(omegaId);
                }
                if (!omegaId.equals(string)) {
                    mPref.edit().putString("omega_id", omegaId).apply();
                }
            } catch (Throwable unused) {
                OLog.m34769w("getOmegaId fail.");
            }
        }
        return omegaId;
    }

    public static String getOmegaIdSafety() {
        String str;
        String sharedOmegaId = getSharedOmegaId();
        String string = mPref.getString("omega_id", "");
        if (sharedOmegaId != null) {
            str = sharedOmegaId;
        } else if (string.length() > 0) {
            str = string;
        } else {
            str = CommonUtil.randomBase64UUID();
        }
        if (!str.matches("[a-zA-Z0-9-]+")) {
            str = CommonUtil.randomBase64UUID();
        }
        if (!str.equals(sharedOmegaId)) {
            setSharedOmegaIdFile(str);
        }
        if (!str.equals(string)) {
            mPref.edit().putString("omega_id", str).apply();
        }
        omegaId = str;
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005a, code lost:
        if (r0 != null) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getSharedOmegaId() {
        /*
            android.content.Context r0 = mContext
            java.lang.String r1 = android.os.Environment.DIRECTORY_DOWNLOADS
            java.io.File r0 = com.didichuxing.omega.sdk.common.utils.FileUtil.getFileDir(r0, r1)
            r1 = 0
            if (r0 != 0) goto L_0x000c
            return r1
        L_0x000c:
            java.io.File r2 = new java.io.File
            java.lang.String r3 = ".omega.key"
            r2.<init>(r0, r3)
            boolean r0 = r2.exists()
            if (r0 == 0) goto L_0x005d
            java.io.FileReader r0 = new java.io.FileReader     // Catch:{ all -> 0x0059 }
            r0.<init>(r2)     // Catch:{ all -> 0x0059 }
            r2 = 50
            char[] r2 = new char[r2]     // Catch:{ all -> 0x0057 }
            int r3 = r0.read(r2)     // Catch:{ all -> 0x0057 }
            if (r3 > 0) goto L_0x0029
            goto L_0x004b
        L_0x0029:
            r4 = 22
            r5 = 0
            if (r3 == r4) goto L_0x004f
            r4 = 36
            if (r3 != r4) goto L_0x0033
            goto L_0x004f
        L_0x0033:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0057 }
            r4.<init>()     // Catch:{ all -> 0x0057 }
            java.lang.String r6 = "SharedOmegaId is malformed. str: "
            r4.append(r6)     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = java.lang.String.valueOf(r2, r5, r3)     // Catch:{ all -> 0x0057 }
            r4.append(r2)     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0057 }
            com.didichuxing.omega.sdk.common.utils.OLog.m34769w(r2)     // Catch:{ all -> 0x0057 }
        L_0x004b:
            r0.close()     // Catch:{ all -> 0x005d }
            goto L_0x005d
        L_0x004f:
            java.lang.String r1 = java.lang.String.valueOf(r2, r5, r3)     // Catch:{ all -> 0x0057 }
            r0.close()     // Catch:{ all -> 0x0056 }
        L_0x0056:
            return r1
        L_0x0057:
            goto L_0x005a
        L_0x0059:
            r0 = r1
        L_0x005a:
            if (r0 == 0) goto L_0x005d
            goto L_0x004b
        L_0x005d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector.getSharedOmegaId():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0027 A[Catch:{ all -> 0x0022, all -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void setSharedOmegaIdFile(java.lang.String r3) {
        /*
            android.content.Context r0 = mContext
            java.lang.String r1 = android.os.Environment.DIRECTORY_DOWNLOADS
            java.io.File r0 = com.didichuxing.omega.sdk.common.utils.FileUtil.getFileDir(r0, r1)
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            java.io.File r1 = new java.io.File
            java.lang.String r2 = ".omega.key"
            r1.<init>(r0, r2)
            r0 = 0
            java.io.FileWriter r2 = new java.io.FileWriter     // Catch:{ all -> 0x0024 }
            r2.<init>(r1)     // Catch:{ all -> 0x0024 }
            r2.write(r3)     // Catch:{ all -> 0x0022 }
            r2.close()     // Catch:{ all -> 0x0022 }
            r2.close()     // Catch:{ all -> 0x002a }
            goto L_0x002a
        L_0x0022:
            r0 = r2
            goto L_0x0025
        L_0x0024:
        L_0x0025:
            if (r0 == 0) goto L_0x002a
            r0.close()     // Catch:{ all -> 0x002a }
        L_0x002a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector.setSharedOmegaIdFile(java.lang.String):void");
    }

    public static Long getRecordSeq(String str) {
        Long l = 0L;
        try {
            l = Long.valueOf(ServiceConfig.getInstanse().getLongValue(str, 0) + 1);
            ServiceConfig.getInstanse().setLongValue(str, l.longValue());
            return l;
        } catch (Exception e) {
            OLog.m34763e("get record seq failed. " + e.getMessage());
        } catch (Throwable unused) {
        }
        return l;
    }

    public static Long getRecordSeqSync(String str) {
        try {
            return Long.valueOf(ServiceConfig.getInstanse().getLongValueSync(str, 0));
        } catch (Exception e) {
            OLog.m34763e("get record seq failed. " + e.getMessage());
        } catch (Throwable unused) {
        }
        return 0L;
    }

    public static long getLastSendEventSeq(String str) {
        if (mLastSendEventSeq == 0) {
            SharedPreferences sharedPreferences = mPref;
            mLastSendEventSeq = sharedPreferences.getLong(KEY_OMEGA_LAST_SEND_EVENT_SEQ + str, 0);
        }
        return mLastSendEventSeq;
    }

    public static void saveLastSendEventSeq(String str, long j) {
        try {
            mLastSendEventSeq = j;
            SharedPreferences.Editor edit = mPref.edit();
            edit.putLong(KEY_OMEGA_LAST_SEND_EVENT_SEQ + str, j).apply();
        } catch (Throwable unused) {
        }
    }

    public static boolean ifNeedODAT() {
        long currentTimeMillis = (System.currentTimeMillis() + ((long) (TimeCollector.getTimeZoneUtcOffset() * 60000))) / 86400000;
        SharedPreferences sharedPreferences = mPref;
        if (sharedPreferences.getLong("odat_" + PackageCollector.getVN(), 0) >= currentTimeMillis) {
            return false;
        }
        try {
            SharedPreferences.Editor edit = mPref.edit();
            edit.putLong("odat_" + PackageCollector.getVN(), currentTimeMillis).apply();
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean ifNeed5ODAT() {
        long currentTimeMillis = (System.currentTimeMillis() + ((long) (TimeCollector.getTimeZoneUtcOffset() * 60000))) / 86400000;
        SharedPreferences sharedPreferences = mPref;
        if (currentTimeMillis - sharedPreferences.getLong("fiveodat_" + PackageCollector.getVN(), 0) < 5) {
            return false;
        }
        try {
            SharedPreferences.Editor edit = mPref.edit();
            edit.putLong("fiveodat_" + PackageCollector.getVN(), currentTimeMillis).apply();
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean ifNeedODAT(String str) {
        long currentTimeMillis = (System.currentTimeMillis() + ((long) (TimeCollector.getTimeZoneUtcOffset() * 60000))) / 86400000;
        if (mPref.getLong(str, 0) >= currentTimeMillis) {
            return false;
        }
        try {
            mPref.edit().putLong(str, currentTimeMillis).apply();
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean ifNeedOMGHourly(String str) {
        long currentTimeMillis = (System.currentTimeMillis() + ((long) (TimeCollector.getTimeZoneUtcOffset() * 60000))) / 3600000;
        if (mPref.getLong(str, 0) >= currentTimeMillis) {
            return false;
        }
        try {
            mPref.edit().putLong(str, currentTimeMillis).apply();
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean ifNeedOMGHourly() {
        if (!(System.currentTimeMillis() - lastOmgHourlyTime > 3600000)) {
            return false;
        }
        lastOmgHourlyTime = System.currentTimeMillis();
        return true;
    }

    public static long getFromLastPagePauseTime() {
        if (lastPagePauseTime == 0) {
            SharedPreferences sharedPreferences = mPref;
            lastPagePauseTime = sharedPreferences.getLong("lppt_" + PackageCollector.getVN(), 0);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - lastPagePauseTime;
        lastPagePauseTime = currentTimeMillis;
        return j;
    }

    public static void saveTimeWhenPagePause() {
        lastPagePauseTime = System.currentTimeMillis();
        try {
            SharedPreferences.Editor edit = mPref.edit();
            edit.putLong("lppt_" + PackageCollector.getVN(), lastPagePauseTime).apply();
        } catch (Throwable unused) {
        }
    }

    public static boolean checkAndSaveStartup() {
        SharedPreferences sharedPreferences = mPref;
        long j = sharedPreferences.getLong("slst_" + PackageCollector.getVN(), 0);
        saveStartupTime();
        return OmegaConfig.CAL_START_INTERVEL < System.currentTimeMillis() - j;
    }

    public static void saveStartupTime() {
        try {
            SharedPreferences.Editor edit = mPref.edit();
            edit.putLong("slst_" + PackageCollector.getVN(), System.currentTimeMillis()).apply();
        } catch (Throwable unused) {
        }
    }

    public static void saveMomentTime() {
        try {
            mPref.edit().putLong("mlst", System.currentTimeMillis()).apply();
        } catch (Throwable unused) {
        }
    }

    public static void updateMomentId() {
        if (OmegaConfig.MOMENT_ID_INTERVAL < System.currentTimeMillis() - mPref.getLong("mlst", 0)) {
            momentId = mPref.getLong("mid", 0) + 1;
            try {
                mPref.edit().putLong("mid", momentId).apply();
            } catch (Throwable unused) {
            }
        }
        saveMomentTime();
    }

    public static void updateSession() {
        SystemTrack.trackAppSession(mPref);
    }

    public static long getMomentId() {
        SharedPreferences sharedPreferences = mPref;
        if (sharedPreferences == null) {
            return 0;
        }
        if (0 == momentId) {
            momentId = sharedPreferences.getLong("mid", 1);
        }
        return momentId;
    }

    public static boolean hasCurVersionUploadScreenShot(String str) {
        if (str == null || mPref.getString("lavus", "").equals(str)) {
            return true;
        }
        mPref.edit().putString("lavus", str).apply();
        return false;
    }

    public static long getLastSendRealEventSeq() {
        if (mLastSendRealEventSeq == 1) {
            mLastSendRealEventSeq = mPref.getLong("lsres", 1);
        }
        return mLastSendRealEventSeq;
    }

    public static void increaseAndSaveLastSendRealEventSeq() {
        try {
            mLastSendRealEventSeq = getLastSendRealEventSeq() + 1;
            mPref.edit().putLong("lsres", mLastSendRealEventSeq).apply();
        } catch (Throwable unused) {
        }
    }
}
