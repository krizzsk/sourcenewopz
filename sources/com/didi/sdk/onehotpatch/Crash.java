package com.didi.sdk.onehotpatch;

import android.app.Application;
import android.text.TextUtils;
import com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didi.sdk.onehotpatch.commonstatic.util.UtilsHub;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

class Crash implements Runnable {
    public static int LIMIT_FAIL_COUNT = 5;
    public static int LIMIT_SUCC_COUNT = 100;
    public static String RECORD_CRASH_DIR_NAME = "hotpatch_app_delegate";
    public static String RECORD_CRASH_FILE_NAME = "crash_log_";
    public static String RECORD_REPORT_FILE_NAME = "report_";
    public static String RECORD_REPORT_SUCC_FILE_NAME = "report_succ_";
    private static String TAG = "app_delegate_test";
    private Application context;
    private File crashLogFile;
    private String errorMsg;
    private String errorType = "hotpatch application delegate fail";
    private String patchVersion = "-1";
    private String progressName;
    private int status = 10000;
    private String type = "delegate";

    public Crash() {
    }

    public Crash(Application application) {
        this.crashLogFile = getCurProcessCrashInfoFile(application);
        this.context = application;
    }

    public String getPatchVersion() {
        return this.patchVersion;
    }

    public String getType() {
        return this.type;
    }

    public int getStatus() {
        return this.status;
    }

    public String getErrorType() {
        return this.errorType;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public String getProgressName() {
        return this.progressName;
    }

    public void setProgressName(String str) {
        this.progressName = str;
    }

    public String toString() {
        return "{ status:" + this.status + " type:" + this.type + " progressName:" + this.progressName + " errorType:" + this.errorType + " errorMsg:" + this.errorMsg + "}";
    }

    private String renameCrashInfoFileName(String str, int i, int i2, int i3) {
        String replaceProcessName = !TextUtils.isEmpty(str) ? replaceProcessName(str) : "";
        return RECORD_CRASH_FILE_NAME + replaceProcessName + "_" + i + "_" + i2 + "_" + i3;
    }

    public String replaceProcessName(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace(".", "_").replace(":", "_");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.File getCurProcessCrashInfoFile(android.content.Context r12) {
        /*
            r11 = this;
            r0 = 0
            if (r12 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.File r1 = new java.io.File
            java.io.File r2 = r12.getFilesDir()
            java.lang.String r3 = RECORD_CRASH_DIR_NAME
            r1.<init>(r2, r3)
            boolean r2 = r1.exists()
            if (r2 != 0) goto L_0x0018
            r1.mkdirs()
        L_0x0018:
            java.lang.String r2 = com.didi.sdk.onehotpatch.commonstatic.util.UtilsHub.getProcessName(r12)
            java.lang.String r2 = r11.replaceProcessName(r2)
            java.io.File[] r3 = r1.listFiles()
            r4 = 0
            if (r3 == 0) goto L_0x0075
            int r5 = r3.length
            r6 = 0
        L_0x0029:
            if (r6 >= r5) goto L_0x0075
            r7 = r3[r6]
            java.lang.String r8 = r7.getName()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0072
            java.lang.String r8 = r7.getName()
            java.lang.String r9 = RECORD_CRASH_FILE_NAME
            boolean r8 = r8.startsWith(r9)
            if (r8 == 0) goto L_0x0072
            java.lang.String r8 = r7.getName()
            java.lang.String r9 = RECORD_CRASH_FILE_NAME
            java.lang.String r8 = r11.readProcessNameFromFilename(r8, r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "curProcessName: "
            r9.append(r10)
            r9.append(r2)
            java.lang.String r10 = " - fileProcessName: "
            r9.append(r10)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            java.lang.Object[] r10 = new java.lang.Object[r4]
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r9, r10)
            boolean r8 = android.text.TextUtils.equals(r2, r8)
            if (r8 == 0) goto L_0x0072
            goto L_0x0076
        L_0x0072:
            int r6 = r6 + 1
            goto L_0x0029
        L_0x0075:
            r7 = r0
        L_0x0076:
            if (r7 != 0) goto L_0x0094
            java.io.File r7 = new java.io.File
            java.lang.String r12 = com.didi.sdk.onehotpatch.commonstatic.util.UtilsHub.getProcessName(r12)
            java.lang.String r12 = r11.renameCrashInfoFileName(r12, r4, r4, r4)
            r7.<init>(r1, r12)
            boolean r12 = r7.exists()
            if (r12 != 0) goto L_0x0094
            r7.createNewFile()     // Catch:{ IOException -> 0x008f }
            goto L_0x0094
        L_0x008f:
            r12 = move-exception
            r12.printStackTrace()
            return r0
        L_0x0094:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "crashLog: "
            r12.append(r0)
            java.lang.String r0 = r7.getAbsolutePath()
            r12.append(r0)
            java.lang.String r12 = r12.toString()
            java.lang.Object[] r0 = new java.lang.Object[r4]
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r12, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.Crash.getCurProcessCrashInfoFile(android.content.Context):java.io.File");
    }

    public String readProcessNameFromFilename(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str.contains(str2)) {
            str = str.substring(str2.length());
        }
        int length = str.length();
        int i = 3;
        for (int i2 = length - 1; i2 >= 0; i2--) {
            if (str.charAt(i2) == '_') {
                if (i <= 0) {
                    break;
                }
                i--;
                length = i2;
            }
        }
        if (length > 0) {
            return str.substring(0, length);
        }
        return "";
    }

    public void recordCrashToFile(String str, String str2) {
        File file = this.crashLogFile;
        if (file != null && file.exists()) {
            int[] infoFromFileName = getInfoFromFileName(this.crashLogFile.getName());
            File file2 = new File(this.crashLogFile.getParent(), renameCrashInfoFileName(str, infoFromFileName[0], infoFromFileName[1] + 1, 1));
            if (!this.crashLogFile.renameTo(file2)) {
                ONEPatchFacade.trackEvent(this.context, (PatchModule) null, -1, 0, "rename fail", "record crash rename file fail");
                return;
            }
            this.crashLogFile = file2;
            this.progressName = str;
            this.errorMsg = str2;
            writeCrashInfoToFile();
        }
    }

    public void recordSuccToFile(String str) {
        File file = this.crashLogFile;
        if (file != null && file.exists()) {
            int[] infoFromFileName = getInfoFromFileName(this.crashLogFile.getName());
            File file2 = new File(this.crashLogFile.getParent(), renameCrashInfoFileName(str, infoFromFileName[0] + 1, infoFromFileName[1], 0));
            if (!this.crashLogFile.renameTo(file2)) {
                ONEPatchFacade.trackEvent(this.context, (PatchModule) null, -1, 0, "rename fail", "record succ rename file fail");
            } else {
                this.crashLogFile = file2;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0075 A[SYNTHETIC, Splitter:B:22:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007f A[SYNTHETIC, Splitter:B:27:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeCrashInfoToFile() {
        /*
            r5 = this;
            java.io.File r0 = r5.crashLogFile
            if (r0 == 0) goto L_0x009e
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x000c
            goto L_0x009e
        L_0x000c:
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            int r1 = r5.status
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "status"
            r0.put(r2, r1)
            java.lang.String r1 = r5.type
            java.lang.String r2 = "type"
            r0.put(r2, r1)
            java.lang.String r1 = r5.errorType
            java.lang.String r2 = "errorType"
            r0.put(r2, r1)
            java.lang.String r1 = r5.errorMsg
            java.lang.String r2 = "errorMsg"
            r0.put(r2, r1)
            java.lang.String r1 = r5.progressName
            java.lang.String r2 = "progressName"
            r0.put(r2, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "record crash: "
            r1.append(r2)
            java.lang.String r2 = r0.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r1, r3)
            r1 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x006f }
            java.io.File r4 = r5.crashLogFile     // Catch:{ all -> 0x006f }
            r3.<init>(r4, r2)     // Catch:{ all -> 0x006f }
            java.lang.String r1 = ""
            r0.store(r3, r1)     // Catch:{ all -> 0x006c }
            r3.flush()     // Catch:{ IOException -> 0x0064 }
            goto L_0x0068
        L_0x0064:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0068:
            r3.close()     // Catch:{ IOException -> 0x0083 }
            goto L_0x0087
        L_0x006c:
            r0 = move-exception
            r1 = r3
            goto L_0x0070
        L_0x006f:
            r0 = move-exception
        L_0x0070:
            r0.printStackTrace()     // Catch:{ all -> 0x0088 }
            if (r1 == 0) goto L_0x007d
            r1.flush()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007d
        L_0x0079:
            r0 = move-exception
            r0.printStackTrace()
        L_0x007d:
            if (r1 == 0) goto L_0x0087
            r1.close()     // Catch:{ IOException -> 0x0083 }
            goto L_0x0087
        L_0x0083:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0087:
            return
        L_0x0088:
            r0 = move-exception
            if (r1 == 0) goto L_0x0093
            r1.flush()     // Catch:{ IOException -> 0x008f }
            goto L_0x0093
        L_0x008f:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0093:
            if (r1 == 0) goto L_0x009d
            r1.close()     // Catch:{ IOException -> 0x0099 }
            goto L_0x009d
        L_0x0099:
            r1 = move-exception
            r1.printStackTrace()
        L_0x009d:
            throw r0
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.Crash.writeCrashInfoToFile():void");
    }

    private boolean readReportFromFile() {
        if (this.context == null) {
            return false;
        }
        File file = new File(this.context.getFilesDir(), RECORD_CRASH_DIR_NAME);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, RECORD_REPORT_FILE_NAME + "" + replaceProcessName(UtilsHub.getProcessName(this.context))).exists();
    }

    public boolean reset() {
        if (this.context == null) {
            return false;
        }
        File file = new File(this.context.getFilesDir(), RECORD_CRASH_DIR_NAME);
        String str = RECORD_REPORT_FILE_NAME + "" + replaceProcessName(UtilsHub.getProcessName(this.context));
        File file2 = new File(file, "should_del_report_" + replaceProcessName(UtilsHub.getProcessName(this.context)));
        if (file2.exists()) {
            file2.delete();
        }
        boolean readReportFromFile = readReportFromFile();
        if (readReportFromFile) {
            File file3 = new File(file, str);
            if (file3.exists()) {
                if (file3.renameTo(file2)) {
                    file2.delete();
                } else {
                    ONEPatchFacade.trackEvent(this.context, (PatchModule) null, -1, 0, "rename fail", "rename report file fail");
                    return false;
                }
            }
        }
        File file4 = this.crashLogFile;
        if (file4 != null && file4.exists()) {
            String name = this.crashLogFile.getName();
            int[] infoFromFileName = getInfoFromFileName(name);
            int i = infoFromFileName[0];
            int i2 = infoFromFileName[1];
            boolean z = infoFromFileName[2] != 0;
            if (readReportFromFile) {
                File file5 = new File(this.crashLogFile.getParent(), renameCrashInfoFileName(UtilsHub.getProcessName(this.context), i, i2, 0));
                if (this.crashLogFile.renameTo(file5)) {
                    this.crashLogFile = file5;
                    z = false;
                } else {
                    ONEPatchFacade.trackEvent(this.context, (PatchModule) null, -1, 0, "rename fail", "reset crash file fail");
                    return false;
                }
            }
            Logger.log("name: " + name + " succCount: " + i + " failCount: " + i2 + " isCrash: " + z, new Object[0]);
            if (z || i >= LIMIT_SUCC_COUNT || i2 >= LIMIT_FAIL_COUNT) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int[] getInfoFromFileName(String str) {
        int[] iArr = {-1, -1, 0};
        if (TextUtils.isEmpty(str)) {
            return iArr;
        }
        int length = str.length();
        int i = 2;
        for (int i2 = length - 1; i2 >= 0; i2--) {
            if (str.charAt(i2) == '_') {
                if (i < 0) {
                    break;
                }
                iArr[i] = Integer.valueOf(str.substring(i2 + 1, length)).intValue();
                i--;
                length = i2;
            }
        }
        return iArr;
    }

    public Crash readCrashFromFile(File file) {
        if (file != null && file.exists()) {
            Crash crash = new Crash();
            Properties properties = new Properties();
            try {
                properties.load(new FileInputStream(file));
                crash.setErrorMsg(properties.getProperty("errorMsg", ""));
                crash.setProgressName(properties.getProperty("progressName", ""));
                return crash;
            } catch (Throwable th) {
                Logger.log("read crash info fail! \n " + UtilsHub.dumpException(th), new Object[0]);
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r2 = new java.io.File(r1.context.getFilesDir().getAbsolutePath(), RECORD_CRASH_DIR_NAME);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r21 = this;
            r1 = r21
            android.app.Application r0 = r1.context
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            java.io.File r2 = new java.io.File
            android.app.Application r0 = r1.context
            java.io.File r0 = r0.getFilesDir()
            java.lang.String r0 = r0.getAbsolutePath()
            java.lang.String r3 = RECORD_CRASH_DIR_NAME
            r2.<init>(r0, r3)
            java.io.File[] r3 = r2.listFiles()
            if (r3 != 0) goto L_0x001f
            return
        L_0x001f:
            int r4 = r3.length
            r5 = 0
            r6 = 0
        L_0x0022:
            if (r6 >= r4) goto L_0x011e
            r0 = r3[r6]
            java.lang.String r7 = r0.getName()
            java.lang.String r8 = RECORD_CRASH_FILE_NAME
            boolean r7 = r7.startsWith(r8)
            if (r7 == 0) goto L_0x011a
            com.didi.sdk.onehotpatch.Crash r7 = r1.readCrashFromFile(r0)
            if (r7 != 0) goto L_0x003a
            goto L_0x011a
        L_0x003a:
            java.lang.String r8 = r0.getName()
            int[] r8 = r7.getInfoFromFileName(r8)
            r9 = 2
            r10 = r8[r9]
            r11 = 1
            if (r10 != 0) goto L_0x009e
            r10 = r8[r5]
            int r12 = LIMIT_SUCC_COUNT
            if (r10 != r12) goto L_0x009e
            java.lang.String r0 = r0.getName()
            java.lang.String r9 = RECORD_CRASH_FILE_NAME
            java.lang.String r0 = r7.readProcessNameFromFilename(r0, r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = RECORD_REPORT_SUCC_FILE_NAME
            r9.append(r10)
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            java.io.File r10 = new java.io.File
            java.lang.String r12 = r2.getAbsolutePath()
            r10.<init>(r12, r9)
            boolean r9 = r10.exists()
            if (r9 != 0) goto L_0x011a
            boolean r9 = r10.createNewFile()     // Catch:{ IOException -> 0x0098 }
            if (r9 == 0) goto L_0x011a
            android.app.Application r12 = r1.context     // Catch:{ IOException -> 0x0098 }
            java.lang.String r13 = r7.getPatchVersion()     // Catch:{ IOException -> 0x0098 }
            java.lang.String r14 = r7.getType()     // Catch:{ IOException -> 0x0098 }
            r15 = 0
            java.lang.String r16 = ""
            java.lang.String r17 = ""
            r18 = r8[r5]     // Catch:{ IOException -> 0x0098 }
            r19 = r8[r11]     // Catch:{ IOException -> 0x0098 }
            r20 = r0
            com.didi.sdk.onehotpatch.commonstatic.report.HotPatchEvent.track(r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ IOException -> 0x0098 }
            goto L_0x011a
        L_0x0098:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x011a
        L_0x009e:
            r0 = r8[r9]
            if (r0 == 0) goto L_0x011a
            r0 = r8[r11]
            int r9 = LIMIT_FAIL_COUNT
            if (r0 > r9) goto L_0x011a
            r0 = r8[r5]
            int r9 = LIMIT_SUCC_COUNT
            if (r0 <= r9) goto L_0x00af
            goto L_0x011a
        L_0x00af:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r9 = RECORD_REPORT_FILE_NAME
            r0.append(r9)
            java.lang.String r9 = r7.getProgressName()
            java.lang.String r9 = r7.replaceProcessName(r9)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.io.File r9 = new java.io.File
            java.lang.String r10 = r2.getAbsolutePath()
            r9.<init>(r10, r0)
            boolean r0 = r9.exists()
            if (r0 != 0) goto L_0x011a
            r9.createNewFile()     // Catch:{ IOException -> 0x0116 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0116 }
            r0.<init>()     // Catch:{ IOException -> 0x0116 }
            java.lang.String r9 = "report info "
            r0.append(r9)     // Catch:{ IOException -> 0x0116 }
            java.lang.String r9 = r7.toString()     // Catch:{ IOException -> 0x0116 }
            r0.append(r9)     // Catch:{ IOException -> 0x0116 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0116 }
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0116 }
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r0, r9)     // Catch:{ IOException -> 0x0116 }
            android.app.Application r12 = r1.context     // Catch:{ IOException -> 0x0116 }
            java.lang.String r13 = r7.getPatchVersion()     // Catch:{ IOException -> 0x0116 }
            java.lang.String r14 = r7.getType()     // Catch:{ IOException -> 0x0116 }
            int r15 = r7.getStatus()     // Catch:{ IOException -> 0x0116 }
            java.lang.String r16 = r7.getErrorType()     // Catch:{ IOException -> 0x0116 }
            java.lang.String r17 = r7.getErrorMsg()     // Catch:{ IOException -> 0x0116 }
            r18 = r8[r5]     // Catch:{ IOException -> 0x0116 }
            r19 = r8[r11]     // Catch:{ IOException -> 0x0116 }
            java.lang.String r20 = r7.getProgressName()     // Catch:{ IOException -> 0x0116 }
            com.didi.sdk.onehotpatch.commonstatic.report.HotPatchEvent.track(r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ IOException -> 0x0116 }
            goto L_0x011a
        L_0x0116:
            r0 = move-exception
            r0.printStackTrace()
        L_0x011a:
            int r6 = r6 + 1
            goto L_0x0022
        L_0x011e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.Crash.run():void");
    }
}
