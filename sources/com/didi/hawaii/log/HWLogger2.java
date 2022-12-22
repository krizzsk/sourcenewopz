package com.didi.hawaii.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.util.Pools;
import com.datadog.android.core.internal.persistence.file.FilePersistenceConfig;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class HWLogger2 implements FileLogger {

    /* renamed from: a */
    static final HandlerThread f23463a;

    /* renamed from: c */
    private static final int f23464c = 4194304;

    /* renamed from: b */
    private final LogHandler f23465b;

    @Deprecated
    public void close() {
    }

    @Deprecated
    public void reset() {
    }

    @Deprecated
    public void setDebug(boolean z) {
    }

    @Deprecated
    public void setPackageName(String str) {
    }

    @Deprecated
    public void setPackageRelatedRules(String str) {
    }

    @Deprecated
    public void setRule(String str) {
    }

    static {
        HandlerThread handlerThread = new HandlerThread("HWLogThread");
        f23463a = handlerThread;
        handlerThread.start();
    }

    public HWLogger2(String str) {
        this.f23465b = new LogHandler(str, f23463a.getLooper());
    }

    public void setPhoneNumber(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f23465b.sendMessage(this.f23465b.obtainMessage(2, str));
        }
    }

    public void setPath(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.endsWith(File.separator)) {
                str = str + File.separator;
            }
            this.f23465b.sendMessage(this.f23465b.obtainMessage(3, str));
        }
    }

    public void log(String str) {
        if (!TextUtils.isEmpty(str)) {
            Log obtain = Log.obtain();
            obtain.msg = str;
            obtain.thread = Thread.currentThread().getName();
            obtain.timeStamp = System.currentTimeMillis();
            this.f23465b.sendMessage(this.f23465b.obtainMessage(1, obtain));
        }
    }

    public void log(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log obtain = Log.obtain();
            obtain.msg = str2;
            obtain.tag = str;
            obtain.thread = Thread.currentThread().getName();
            obtain.timeStamp = System.currentTimeMillis();
            this.f23465b.sendMessage(this.f23465b.obtainMessage(1, obtain));
        }
    }

    public void log(byte[] bArr) {
        if (bArr != null) {
            Log obtain = Log.obtain();
            obtain.msgBinary = bArr;
            this.f23465b.sendMessage(this.f23465b.obtainMessage(1, obtain));
        }
    }

    private static class Log {
        private static final Pools.SynchronizedPool<Log> sPools = new Pools.SynchronizedPool<>(10);
        public String msg;
        public byte[] msgBinary;
        public String tag;
        public String thread;
        public long timeStamp;

        private Log() {
        }

        static Log obtain() {
            Log acquire = sPools.acquire();
            return acquire != null ? acquire : new Log();
        }

        /* access modifiers changed from: package-private */
        public void recycle() {
            this.msg = null;
            this.thread = null;
            this.timeStamp = -1;
            this.msgBinary = null;
            this.tag = null;
            sPools.release(this);
        }
    }

    private static class LogHandler extends Handler {
        private static final int PATH_OK = 1;
        private static final int PHONE_OK = 2;
        private static final int SET_PATH = 3;
        private static final int SET_PHONE = 2;
        private static final int WRITE_TEXT = 1;
        private static final StringBuilder sBuffer = new StringBuilder();
        private final SimpleDateFormat HHmmss;
        private final SimpleDateFormat HHmmssSSS;
        private final String fileFormatRule;
        private File logFile;
        private OutputStream output;
        private String path;
        private String phoneNumber;
        private int status;
        private OutputStreamWriter writer;
        private final SimpleDateFormat yyyyMMdd;

        private LogHandler(String str, Looper looper) {
            super(looper);
            this.yyyyMMdd = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
            this.HHmmss = new SimpleDateFormat("HH_mm_ss", Locale.CHINA);
            this.HHmmssSSS = new SimpleDateFormat("HH:mm:ss.SSS", Locale.CHINA);
            this.fileFormatRule = str;
        }

        private boolean isPropertiesOK() {
            int i = this.status;
            return ((i & 2) == 0 || (i & 1) == 0) ? false : true;
        }

        private void ensureFileOK() throws IOException {
            File file = this.logFile;
            if (file == null || !file.exists()) {
                changeFileIfNecessary(generateLogFile());
                return;
            }
            File file2 = this.logFile;
            if (file2 != null && file2.length() > FilePersistenceConfig.MAX_BATCH_SIZE) {
                changeFileIfNecessary(generateLogFile());
            }
        }

        public void handleMessage(Message message) {
            try {
                int i = message.what;
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            if (message.obj instanceof String) {
                                this.path = (String) message.obj;
                                this.status |= 1;
                            }
                        }
                    } else if ((message.obj instanceof String) && this.phoneNumber == null) {
                        this.phoneNumber = (String) message.obj;
                        this.status |= 2;
                    }
                } else if (isPropertiesOK() && (message.obj instanceof Log)) {
                    Log log = (Log) message.obj;
                    ensureFileOK();
                    if (!(log.msgBinary == null || this.output == null)) {
                        this.output.write(log.msgBinary);
                        this.output.flush();
                    }
                    if (!(log.msg == null || this.writer == null)) {
                        sBuffer.setLength(0);
                        StringBuilder sb = sBuffer;
                        sb.append(this.HHmmssSSS.format(new Date(log.timeStamp)));
                        sb.append("-[");
                        sb.append(log.thread);
                        sb.append("] ");
                        if (!TextUtils.isEmpty(log.tag)) {
                            StringBuilder sb2 = sBuffer;
                            sb2.append(log.tag);
                            sb2.append(": ");
                        }
                        StringBuilder sb3 = sBuffer;
                        sb3.append(log.msg == null ? "" : log.msg);
                        sb3.append("\n");
                        this.writer.write(sBuffer.toString());
                        this.writer.flush();
                    }
                    log.recycle();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private File generateLogFile() throws IOException {
            int i = 1;
            while (true) {
                if (new File(this.path + C8942b.m16776a(this.fileFormatRule, this.phoneNumber, i, this.yyyyMMdd, this.HHmmss)).length() > FilePersistenceConfig.MAX_BATCH_SIZE) {
                    i++;
                } else {
                    return new File(this.path + C8942b.m16776a(this.fileFormatRule, this.phoneNumber, i, this.yyyyMMdd, this.HHmmss));
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
        /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void changeFileIfNecessary(java.io.File r5) {
            /*
                r4 = this;
                if (r5 != 0) goto L_0x0003
                return
            L_0x0003:
                r0 = 0
                java.io.File r1 = r4.logFile
                r2 = 1
                if (r1 == 0) goto L_0x0023
                boolean r1 = r1.exists()
                if (r1 != 0) goto L_0x0010
                goto L_0x0023
            L_0x0010:
                java.lang.String r1 = r5.getAbsolutePath()
                java.io.File r3 = r4.logFile
                java.lang.String r3 = r3.getAbsolutePath()
                boolean r1 = r1.equals(r3)
                if (r1 != 0) goto L_0x0026
                r4.logFile = r5
                goto L_0x0025
            L_0x0023:
                r4.logFile = r5
            L_0x0025:
                r0 = 1
            L_0x0026:
                if (r0 == 0) goto L_0x0063
                r4.closeStream()
                java.io.File r5 = new java.io.File     // Catch:{ IOException -> 0x0059 }
                java.lang.String r0 = r4.path     // Catch:{ IOException -> 0x0059 }
                r5.<init>(r0)     // Catch:{ IOException -> 0x0059 }
                boolean r0 = r5.exists()     // Catch:{ IOException -> 0x0059 }
                if (r0 != 0) goto L_0x003b
                r5.mkdirs()     // Catch:{ IOException -> 0x0059 }
            L_0x003b:
                java.io.File r5 = r4.logFile     // Catch:{ IOException -> 0x0059 }
                r5.createNewFile()     // Catch:{ IOException -> 0x0059 }
                java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0059 }
                java.io.File r0 = r4.logFile     // Catch:{ IOException -> 0x0059 }
                r5.<init>(r0, r2)     // Catch:{ IOException -> 0x0059 }
                r4.output = r5     // Catch:{ IOException -> 0x0059 }
                java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x0059 }
                java.io.OutputStream r0 = r4.output     // Catch:{ IOException -> 0x0059 }
                java.lang.String r1 = "UTF-8"
                java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)     // Catch:{ IOException -> 0x0059 }
                r5.<init>(r0, r1)     // Catch:{ IOException -> 0x0059 }
                r4.writer = r5     // Catch:{ IOException -> 0x0059 }
                goto L_0x0063
            L_0x0059:
                r5 = move-exception
                r5.printStackTrace()
                r5 = 0
                r4.logFile = r5
                r4.closeStream()
            L_0x0063:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.log.HWLogger2.LogHandler.changeFileIfNecessary(java.io.File):void");
        }

        private void closeStream() {
            OutputStreamWriter outputStreamWriter = this.writer;
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                    this.writer = null;
                    OutputStream outputStream = this.output;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                            this.output = null;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    OutputStream outputStream2 = this.output;
                    if (outputStream2 != null) {
                        outputStream2.close();
                        this.output = null;
                    }
                } catch (Throwable th) {
                    OutputStream outputStream3 = this.output;
                    if (outputStream3 != null) {
                        try {
                            outputStream3.close();
                            this.output = null;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } else {
                OutputStream outputStream4 = this.output;
                if (outputStream4 != null) {
                    try {
                        outputStream4.close();
                        this.output = null;
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }
    }
}
