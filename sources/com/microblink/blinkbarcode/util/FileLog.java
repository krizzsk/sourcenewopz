package com.microblink.blinkbarcode.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.didi.sdk.apm.SystemUtils;
import com.microblink.blinkbarcode.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: line */
public class FileLog implements Log.LogWriter {
    private static String IlIllIlIIl;
    private PrintWriter llIIlIlIIl;

    private FileLog(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            llIIlIlIIl(context);
        } else {
            IlIllIlIIl(context);
        }
    }

    private void IlIllIlIIl(Context context) {
        try {
            File file = new File(getLogFolder(context));
            file.mkdirs();
            this.llIIlIlIIl = new PrintWriter(new BufferedWriter(new FileWriter(file.getAbsolutePath() + "/" + "javaLog.txt", true)));
        } catch (IOException unused) {
            this.llIIlIlIIl = null;
        }
    }

    public static synchronized void disableFileLogging() {
        synchronized (FileLog.class) {
            FileLog fileLog = (FileLog) Log.getLogWriter();
            if (fileLog != null) {
                synchronized (fileLog) {
                    PrintWriter printWriter = fileLog.llIIlIlIIl;
                    if (printWriter != null) {
                        printWriter.close();
                        fileLog.llIIlIlIIl = null;
                    }
                }
                Log.setLogWriter((Log.LogWriter) null);
            }
        }
    }

    public static synchronized void enableFileLogging(Context context) {
        synchronized (FileLog.class) {
            Log.setLogWriter(new FileLog(context));
        }
    }

    public static synchronized String getLogFolder(Context context) {
        String str;
        String str2;
        synchronized (FileLog.class) {
            if (IlIllIlIIl == null) {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    str2 = SystemUtils.getExternalStorageDirectory().toString();
                } else if (context != null) {
                    str2 = context.getCacheDir().getAbsolutePath();
                } else {
                    str2 = Environment.getDataDirectory().getAbsolutePath();
                }
                IlIllIlIIl = str2 + "/" + "Documents/microblink";
                int ordinal = Log.getCurrentLogLevel().ordinal();
                Log.LogLevel logLevel = Log.LogLevel.LOG_INFORMATION;
                if (ordinal >= 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Log folder will be ");
                    sb.append(IlIllIlIIl);
                }
            }
            str = IlIllIlIIl;
        }
        return str;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x009b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void llIIlIlIIl(android.content.Context r13) {
        /*
            r12 = this;
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.String r1 = "_display_name"
            java.lang.String r2 = "javaLog.txt"
            r0.put(r1, r2)
            java.lang.String r1 = "mime_type"
            java.lang.String r3 = "text/plain"
            r0.put(r1, r3)
            java.lang.String r1 = "relative_path"
            java.lang.String r3 = "Documents/microblink"
            r0.put(r1, r3)
            r1 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            java.lang.String r4 = "is_pending"
            r0.put(r4, r3)
            android.content.ContentResolver r13 = r13.getContentResolver()
            java.lang.String r3 = "external_primary"
            android.net.Uri r3 = android.provider.MediaStore.Files.getContentUri(r3)
            android.net.Uri r5 = r13.insert(r3, r0)
            r6 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            r8 = 0
            if (r5 != 0) goto L_0x0083
            android.os.Bundle r9 = new android.os.Bundle
            r9.<init>()
            java.lang.String r10 = "android:query-arg-sql-selection"
            java.lang.String r11 = "_display_name = ? AND relative_path = ?"
            r9.putString(r10, r11)
            java.lang.String r10 = "Documents/microblink/"
            java.lang.String[] r2 = new java.lang.String[]{r2, r10}
            java.lang.String r10 = "android:query-arg-sql-selection-args"
            r9.putStringArray(r10, r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            r10 = 30
            if (r2 < r10) goto L_0x005c
            java.lang.String r11 = "android:query-arg-match-pending"
            r9.putInt(r11, r1)
        L_0x005c:
            if (r2 >= r10) goto L_0x0063
            android.net.Uri r2 = android.provider.MediaStore.setIncludePending(r3)
            goto L_0x0064
        L_0x0063:
            r2 = r3
        L_0x0064:
            java.lang.String r10 = "_id"
            java.lang.String[] r10 = new java.lang.String[]{r10}
            android.database.Cursor r2 = r13.query(r2, r10, r9, r8)
            int r9 = r2.getCount()
            if (r9 != r1) goto L_0x0080
            r2.moveToFirst()
            java.lang.String r1 = r2.getString(r6)
            android.net.Uri r1 = android.net.Uri.withAppendedPath(r3, r1)
            r5 = r1
        L_0x0080:
            r2.close()
        L_0x0083:
            java.io.OutputStream r1 = r13.openOutputStream(r5)     // Catch:{ FileNotFoundException -> 0x009b }
            java.io.PrintWriter r2 = new java.io.PrintWriter     // Catch:{ FileNotFoundException -> 0x009b }
            java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch:{ FileNotFoundException -> 0x009b }
            java.io.OutputStreamWriter r6 = new java.io.OutputStreamWriter     // Catch:{ FileNotFoundException -> 0x009b }
            r6.<init>(r1)     // Catch:{ FileNotFoundException -> 0x009b }
            r3.<init>(r6)     // Catch:{ FileNotFoundException -> 0x009b }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x009b }
            r12.llIIlIlIIl = r2     // Catch:{ FileNotFoundException -> 0x009b }
            goto L_0x009d
        L_0x0099:
            r1 = move-exception
            goto L_0x00a7
        L_0x009b:
            r12.llIIlIlIIl = r8     // Catch:{ all -> 0x0099 }
        L_0x009d:
            r0.clear()
            r0.put(r4, r7)
            r13.update(r5, r0, r8, r8)
            return
        L_0x00a7:
            r0.clear()
            r0.put(r4, r7)
            r13.update(r5, r0, r8, r8)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkbarcode.util.FileLog.llIIlIlIIl(android.content.Context):void");
    }

    public void writeLog(String str, String str2, String str3, Throwable th) {
        synchronized (this) {
            PrintWriter printWriter = this.llIIlIlIIl;
            if (printWriter != null) {
                printWriter.write(str);
                Timestamp timestamp = new Timestamp(new Date().getTime());
                this.llIIlIlIIl.write(" (");
                this.llIIlIlIIl.write(timestamp.toString());
                this.llIIlIlIIl.write(") [");
                this.llIIlIlIIl.write(str2);
                this.llIIlIlIIl.write("] ");
                this.llIIlIlIIl.write(str3);
                this.llIIlIlIIl.write("\n");
                if (th != null) {
                    th.printStackTrace(this.llIIlIlIIl);
                }
                this.llIIlIlIIl.flush();
            }
        }
    }
}
