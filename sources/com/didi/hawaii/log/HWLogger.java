package com.didi.hawaii.log;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.util.Pools;
import com.didi.hawaii.basic.HWSharedPreference;
import com.didi.hawaii.basic.HWSupportedAppVersion;
import com.didi.hawaii.utils.StorageUtils;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Locale;

public final class HWLogger implements FileLogger {

    /* renamed from: a */
    private static final int f23453a = 1;

    /* renamed from: b */
    private static final int f23454b = 4;

    /* renamed from: c */
    private static final int f23455c = 2;

    /* renamed from: d */
    private static final int f23456d = 7;

    /* renamed from: e */
    private static final int f23457e = 5;

    /* renamed from: f */
    private static final int f23458f = 3;

    /* renamed from: g */
    private static final int f23459g = 6;

    /* renamed from: h */
    private static final int f23460h = 8;

    /* renamed from: i */
    private static final int f23461i = 20971520;

    /* renamed from: j */
    private final LogHandler f23462j;

    public interface HWLoggerHook {
        void onPreWrite(File file);

        boolean onWrite(OutputStream outputStream, String str, String str2);
    }

    private static class LogMessage {
        private static final Pools.SynchronizedPool<LogMessage> sPools = new Pools.SynchronizedPool<>(10);
        /* access modifiers changed from: private */
        public volatile byte[] bytes;
        /* access modifiers changed from: private */
        public volatile boolean isBinary = false;
        /* access modifiers changed from: private */
        public volatile String msg;
        /* access modifiers changed from: private */
        public volatile String tag;
        /* access modifiers changed from: private */
        public volatile String threadName;
        /* access modifiers changed from: private */
        public volatile long timeStamp;

        private LogMessage() {
        }

        static LogMessage obtain() {
            LogMessage acquire = sPools.acquire();
            return acquire != null ? acquire : new LogMessage();
        }

        /* access modifiers changed from: package-private */
        public void recycle() {
            this.msg = null;
            this.threadName = null;
            this.isBinary = false;
            this.timeStamp = -1;
            this.tag = null;
            sPools.release(this);
        }
    }

    private static class LogConfig {
        /* access modifiers changed from: private */
        public volatile String packageName;
        /* access modifiers changed from: private */
        public volatile String path;
        /* access modifiers changed from: private */
        public volatile String phoneNumber;
        /* access modifiers changed from: private */
        public volatile String rule;

        private LogConfig() {
        }
    }

    public HWLogger(String str, HWLoggerHook hWLoggerHook) {
        this.f23462j = new LogHandler(hWLoggerHook, HWLogger2.f23463a.getLooper(), str);
    }

    public HWLogger(String str) {
        this(str, (HWLoggerHook) null);
    }

    public HWLogger(String str, String str2, HWLoggerHook hWLoggerHook) {
        this.f23462j = new LogHandler(hWLoggerHook, HWLogger2.f23463a.getLooper(), str, str2);
    }

    public HWLogger(String str, String str2) {
        this(str, str2, (HWLoggerHook) null);
    }

    public HWLogger(HWLoggerHook hWLoggerHook) {
        this.f23462j = new LogHandler(hWLoggerHook, HWLogger2.f23463a.getLooper());
    }

    public HWLogger() {
        this((HWLoggerHook) null);
    }

    public void setPhoneNumber(String str) {
        if (str != null) {
            Message obtain = Message.obtain(this.f23462j, 1);
            obtain.obj = str;
            this.f23462j.sendMessage(obtain);
        }
    }

    public void setPath(String str) {
        if (str != null) {
            if (!str.endsWith(File.separator)) {
                str = str + File.separator;
            }
            Message obtain = Message.obtain(this.f23462j, 4);
            obtain.obj = str;
            this.f23462j.sendMessage(obtain);
        }
    }

    public void setPackageName(String str) {
        if (str != null) {
            Message obtain = Message.obtain(this.f23462j, 5);
            obtain.obj = str;
            this.f23462j.sendMessage(obtain);
        }
    }

    public void log(String str) {
        if (str != null) {
            Message obtain = Message.obtain(this.f23462j, 2);
            LogMessage obtain2 = LogMessage.obtain();
            String unused = obtain2.msg = str;
            String unused2 = obtain2.threadName = Thread.currentThread().getName();
            long unused3 = obtain2.timeStamp = System.currentTimeMillis();
            obtain.obj = obtain2;
            this.f23462j.sendMessage(obtain);
        }
    }

    public void log(String str, String str2) {
        if (str == null) {
            log(str2);
            return;
        }
        Message obtain = Message.obtain(this.f23462j, 2);
        LogMessage obtain2 = LogMessage.obtain();
        String unused = obtain2.msg = str2;
        String unused2 = obtain2.tag = str;
        String unused3 = obtain2.threadName = Thread.currentThread().getName();
        long unused4 = obtain2.timeStamp = System.currentTimeMillis();
        obtain.obj = obtain2;
        this.f23462j.sendMessage(obtain);
    }

    public void log(byte[] bArr) {
        if (bArr != null) {
            Message obtain = Message.obtain(this.f23462j, 2);
            LogMessage obtain2 = LogMessage.obtain();
            byte[] unused = obtain2.bytes = bArr;
            boolean unused2 = obtain2.isBinary = true;
            String unused3 = obtain2.threadName = Thread.currentThread().getName();
            long unused4 = obtain2.timeStamp = System.currentTimeMillis();
            obtain.obj = obtain2;
            this.f23462j.sendMessage(obtain);
        }
    }

    public void setRule(String str) {
        if (str != null) {
            Message obtain = Message.obtain(this.f23462j, 7);
            obtain.obj = str;
            this.f23462j.sendMessage(obtain);
        }
    }

    public void setPackageRelatedRules(String str) {
        if (str != null) {
            setRule(C8942b.m16775a(str));
        }
    }

    public void reset() {
        this.f23462j.sendEmptyMessage(6);
    }

    public void close() {
        this.f23462j.closeStream();
    }

    public void setDebug(boolean z) {
        boolean unused = this.f23462j.mDebug = z;
    }

    private static class LogHandler extends Handler {
        private static final StringBuilder sStringBuilder = new StringBuilder();
        private final SimpleDateFormat HHmmss;
        private final SimpleDateFormat HHmmssSSS;
        private int count;
        /* access modifiers changed from: private */
        public volatile boolean mDebug;
        private File mFile;
        private volatile boolean mFirst;
        private final HWLoggerHook mLogHook;
        private OutputStream mOutputStream;
        private OutputStreamWriter mOutputStreamWriter;
        private String mPackageName;
        private String mPath;
        private String mPhoneNumber;
        private String mRule;
        private long timeSpend;
        private final SimpleDateFormat yyyyMMdd;

        LogHandler(HWLoggerHook hWLoggerHook, Looper looper) {
            this(hWLoggerHook, looper, (String) null);
        }

        LogHandler(HWLoggerHook hWLoggerHook, Looper looper, String str) {
            this(hWLoggerHook, looper, str, (String) null);
        }

        LogHandler(HWLoggerHook hWLoggerHook, Looper looper, String str, String str2) {
            this(hWLoggerHook, looper, str, str2, "11000000011");
        }

        LogHandler(HWLoggerHook hWLoggerHook, Looper looper, String str, String str2, String str3) {
            this(hWLoggerHook, looper, str, str2, str3, "unknown");
        }

        LogHandler(HWLoggerHook hWLoggerHook, Looper looper, String str, String str2, String str3, String str4) {
            super(looper);
            this.yyyyMMdd = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
            this.HHmmss = new SimpleDateFormat("HH_mm_ss", Locale.CHINA);
            this.HHmmssSSS = new SimpleDateFormat("HH:mm:ss.SSS", Locale.CHINA);
            this.mFirst = true;
            this.mPhoneNumber = "11000000011";
            this.mRule = null;
            this.mPackageName = "unknown";
            this.mDebug = false;
            this.count = 0;
            this.timeSpend = 0;
            retrieveLogConfigFromSharedPreference();
            changeConfig(str2, str4, str3, str);
            this.mLogHook = hWLoggerHook;
        }

        private void retrieveLogConfigFromSharedPreference() {
            if (this.mFirst) {
                sendEmptyMessage(3);
                this.mFirst = false;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:45:0x00f2 A[SYNTHETIC, Splitter:B:45:0x00f2] */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x018d A[Catch:{ all -> 0x025d }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r11) {
            /*
                r10 = this;
                long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x025d }
                int r2 = r11.what     // Catch:{ all -> 0x025d }
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x01ee;
                    case 2: goto L_0x00b3;
                    case 3: goto L_0x0093;
                    case 4: goto L_0x0077;
                    case 5: goto L_0x005b;
                    case 6: goto L_0x004d;
                    case 7: goto L_0x0031;
                    case 8: goto L_0x000c;
                    default: goto L_0x000a;
                }     // Catch:{ all -> 0x025d }
            L_0x000a:
                goto L_0x0218
            L_0x000c:
                java.lang.Object r2 = r11.obj     // Catch:{ all -> 0x025d }
                if (r2 == 0) goto L_0x0218
                java.lang.Object r2 = r11.obj     // Catch:{ all -> 0x025d }
                boolean r2 = r2 instanceof com.didi.hawaii.log.HWLogger.LogConfig     // Catch:{ all -> 0x025d }
                if (r2 == 0) goto L_0x0218
                java.lang.Object r11 = r11.obj     // Catch:{ all -> 0x025d }
                com.didi.hawaii.log.HWLogger$LogConfig r11 = (com.didi.hawaii.log.HWLogger.LogConfig) r11     // Catch:{ all -> 0x025d }
                java.lang.String r3 = r11.packageName     // Catch:{ all -> 0x025d }
                java.lang.String r4 = r11.phoneNumber     // Catch:{ all -> 0x025d }
                java.lang.String r5 = r11.path     // Catch:{ all -> 0x025d }
                java.lang.String r6 = r11.rule     // Catch:{ all -> 0x025d }
                r7 = 1
                r2 = r10
                r2.changeConfigIfNecessary(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x025d }
                goto L_0x0218
            L_0x0031:
                java.lang.Object r2 = r11.obj     // Catch:{ all -> 0x025d }
                if (r2 == 0) goto L_0x0218
                java.lang.Object r2 = r11.obj     // Catch:{ all -> 0x025d }
                boolean r2 = r2 instanceof java.lang.String     // Catch:{ all -> 0x025d }
                if (r2 == 0) goto L_0x0218
                java.lang.Object r11 = r11.obj     // Catch:{ all -> 0x025d }
                r6 = r11
                java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x025d }
                java.lang.String r3 = r10.mPackageName     // Catch:{ all -> 0x025d }
                java.lang.String r4 = r10.mPhoneNumber     // Catch:{ all -> 0x025d }
                java.lang.String r5 = r10.mPath     // Catch:{ all -> 0x025d }
                r7 = 1
                r2 = r10
                r2.changeConfigIfNecessary(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x025d }
                goto L_0x0218
            L_0x004d:
                r10.closeStream()     // Catch:{ all -> 0x025d }
                r10.mFile = r3     // Catch:{ all -> 0x025d }
                java.io.File r11 = r10.getHawaiiLogFile()     // Catch:{ all -> 0x025d }
                r10.changeFileIfNecessary(r11)     // Catch:{ all -> 0x025d }
                goto L_0x0218
            L_0x005b:
                java.lang.Object r2 = r11.obj     // Catch:{ all -> 0x025d }
                if (r2 == 0) goto L_0x0218
                java.lang.Object r2 = r11.obj     // Catch:{ all -> 0x025d }
                boolean r2 = r2 instanceof java.lang.String     // Catch:{ all -> 0x025d }
                if (r2 == 0) goto L_0x0218
                java.lang.Object r11 = r11.obj     // Catch:{ all -> 0x025d }
                r3 = r11
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x025d }
                java.lang.String r4 = r10.mPhoneNumber     // Catch:{ all -> 0x025d }
                java.lang.String r5 = r10.mPath     // Catch:{ all -> 0x025d }
                java.lang.String r6 = r10.mRule     // Catch:{ all -> 0x025d }
                r7 = 1
                r2 = r10
                r2.changeConfigIfNecessary(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x025d }
                goto L_0x0218
            L_0x0077:
                java.lang.Object r2 = r11.obj     // Catch:{ all -> 0x025d }
                if (r2 == 0) goto L_0x0218
                java.lang.Object r2 = r11.obj     // Catch:{ all -> 0x025d }
                boolean r2 = r2 instanceof java.lang.String     // Catch:{ all -> 0x025d }
                if (r2 == 0) goto L_0x0218
                java.lang.Object r11 = r11.obj     // Catch:{ all -> 0x025d }
                r5 = r11
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x025d }
                java.lang.String r3 = r10.mPackageName     // Catch:{ all -> 0x025d }
                java.lang.String r4 = r10.mPhoneNumber     // Catch:{ all -> 0x025d }
                java.lang.String r6 = r10.mRule     // Catch:{ all -> 0x025d }
                r7 = 1
                r2 = r10
                r2.changeConfigIfNecessary(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x025d }
                goto L_0x0218
            L_0x0093:
                android.content.SharedPreferences r11 = com.didi.hawaii.basic.HWSharedPreference.getSharePreference()     // Catch:{ all -> 0x025d }
                if (r11 == 0) goto L_0x0218
                java.lang.String r2 = "logger.phonenumber"
                java.lang.String r6 = r11.getString(r2, r3)     // Catch:{ all -> 0x025d }
                java.lang.String r2 = "logger.path"
                java.lang.String r7 = r11.getString(r2, r3)     // Catch:{ all -> 0x025d }
                java.lang.String r2 = "logger.packagename"
                java.lang.String r5 = r11.getString(r2, r3)     // Catch:{ all -> 0x025d }
                r8 = 0
                r9 = 0
                r4 = r10
                r4.changeConfigIfNecessary(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x025d }
                goto L_0x0218
            L_0x00b3:
                java.lang.Object r2 = r11.obj     // Catch:{ all -> 0x025d }
                if (r2 == 0) goto L_0x0218
                java.lang.Object r2 = r11.obj     // Catch:{ all -> 0x025d }
                boolean r2 = r2 instanceof com.didi.hawaii.log.HWLogger.LogMessage     // Catch:{ all -> 0x025d }
                if (r2 == 0) goto L_0x0218
                java.lang.Object r11 = r11.obj     // Catch:{ all -> 0x025d }
                com.didi.hawaii.log.HWLogger$LogMessage r11 = (com.didi.hawaii.log.HWLogger.LogMessage) r11     // Catch:{ all -> 0x025d }
                com.didi.hawaii.log.HWLogger$HWLoggerHook r2 = r10.mLogHook     // Catch:{ all -> 0x025d }
                if (r2 == 0) goto L_0x00cc
                com.didi.hawaii.log.HWLogger$HWLoggerHook r2 = r10.mLogHook     // Catch:{ all -> 0x025d }
                java.io.File r3 = r10.mFile     // Catch:{ all -> 0x025d }
                r2.onPreWrite(r3)     // Catch:{ all -> 0x025d }
            L_0x00cc:
                java.io.File r2 = r10.mFile     // Catch:{ all -> 0x025d }
                if (r2 == 0) goto L_0x00dd
                java.io.File r2 = r10.mFile     // Catch:{ all -> 0x025d }
                boolean r2 = r2.exists()     // Catch:{ all -> 0x025d }
                if (r2 != 0) goto L_0x00d9
                goto L_0x00dd
            L_0x00d9:
                r10.testCurrentFile()     // Catch:{ all -> 0x025d }
                goto L_0x00e4
            L_0x00dd:
                java.io.File r2 = r10.getHawaiiLogFile()     // Catch:{ all -> 0x025d }
                r10.changeFileIfNecessary(r2)     // Catch:{ all -> 0x025d }
            L_0x00e4:
                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x025d }
                boolean r4 = r11.isBinary     // Catch:{ all -> 0x025d }
                java.lang.String r5 = "write spend "
                r6 = 0
                if (r4 != 0) goto L_0x018d
                java.io.OutputStreamWriter r4 = r10.mOutputStreamWriter     // Catch:{ all -> 0x025d }
                if (r4 == 0) goto L_0x01d3
                com.didi.hawaii.log.HWLogger$HWLoggerHook r4 = r10.mLogHook     // Catch:{ all -> 0x025d }
                if (r4 == 0) goto L_0x010b
                com.didi.hawaii.log.HWLogger$HWLoggerHook r4 = r10.mLogHook     // Catch:{ all -> 0x025d }
                java.io.OutputStream r7 = r10.mOutputStream     // Catch:{ all -> 0x025d }
                java.lang.String r8 = r11.msg     // Catch:{ all -> 0x025d }
                java.lang.String r9 = r11.tag     // Catch:{ all -> 0x025d }
                boolean r4 = r4.onWrite(r7, r8, r9)     // Catch:{ all -> 0x025d }
                goto L_0x010c
            L_0x010b:
                r4 = 0
            L_0x010c:
                if (r4 == 0) goto L_0x0127
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x025d }
                r11.<init>()     // Catch:{ all -> 0x025d }
                r11.append(r5)     // Catch:{ all -> 0x025d }
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x025d }
                long r4 = r4 - r2
                r11.append(r4)     // Catch:{ all -> 0x025d }
                java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x025d }
                r10.debug(r11)     // Catch:{ all -> 0x025d }
                goto L_0x0218
            L_0x0127:
                java.lang.StringBuilder r4 = sStringBuilder     // Catch:{ all -> 0x025d }
                r4.setLength(r6)     // Catch:{ all -> 0x025d }
                java.lang.StringBuilder r4 = sStringBuilder     // Catch:{ all -> 0x025d }
                java.text.SimpleDateFormat r6 = r10.HHmmssSSS     // Catch:{ all -> 0x025d }
                java.util.Date r7 = new java.util.Date     // Catch:{ all -> 0x025d }
                long r8 = r11.timeStamp     // Catch:{ all -> 0x025d }
                r7.<init>(r8)     // Catch:{ all -> 0x025d }
                java.lang.String r6 = r6.format(r7)     // Catch:{ all -> 0x025d }
                r4.append(r6)     // Catch:{ all -> 0x025d }
                java.lang.String r6 = "-["
                r4.append(r6)     // Catch:{ all -> 0x025d }
                java.lang.String r6 = r11.threadName     // Catch:{ all -> 0x025d }
                r4.append(r6)     // Catch:{ all -> 0x025d }
                java.lang.String r6 = "] "
                r4.append(r6)     // Catch:{ all -> 0x025d }
                java.lang.String r4 = r11.tag     // Catch:{ all -> 0x025d }
                if (r4 == 0) goto L_0x0165
                java.lang.StringBuilder r4 = sStringBuilder     // Catch:{ all -> 0x025d }
                java.lang.String r6 = r11.tag     // Catch:{ all -> 0x025d }
                r4.append(r6)     // Catch:{ all -> 0x025d }
                java.lang.String r6 = ": "
                r4.append(r6)     // Catch:{ all -> 0x025d }
            L_0x0165:
                java.lang.StringBuilder r4 = sStringBuilder     // Catch:{ all -> 0x025d }
                java.lang.String r6 = r11.msg     // Catch:{ all -> 0x025d }
                if (r6 != 0) goto L_0x0170
                java.lang.String r6 = ""
                goto L_0x0174
            L_0x0170:
                java.lang.String r6 = r11.msg     // Catch:{ all -> 0x025d }
            L_0x0174:
                r4.append(r6)     // Catch:{ all -> 0x025d }
                java.lang.String r6 = "\n"
                r4.append(r6)     // Catch:{ all -> 0x025d }
                java.io.OutputStreamWriter r4 = r10.mOutputStreamWriter     // Catch:{ all -> 0x025d }
                java.lang.StringBuilder r6 = sStringBuilder     // Catch:{ all -> 0x025d }
                java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x025d }
                r4.write(r6)     // Catch:{ all -> 0x025d }
                java.io.OutputStreamWriter r4 = r10.mOutputStreamWriter     // Catch:{ all -> 0x025d }
                r4.flush()     // Catch:{ all -> 0x025d }
                goto L_0x01d3
            L_0x018d:
                java.io.OutputStream r4 = r10.mOutputStream     // Catch:{ all -> 0x025d }
                if (r4 == 0) goto L_0x01d3
                byte[] r4 = r11.bytes     // Catch:{ all -> 0x025d }
                if (r4 == 0) goto L_0x01d3
                com.didi.hawaii.log.HWLogger$HWLoggerHook r4 = r10.mLogHook     // Catch:{ all -> 0x025d }
                if (r4 == 0) goto L_0x01ab
                com.didi.hawaii.log.HWLogger$HWLoggerHook r4 = r10.mLogHook     // Catch:{ all -> 0x025d }
                java.io.OutputStream r6 = r10.mOutputStream     // Catch:{ all -> 0x025d }
                java.lang.String r7 = r11.msg     // Catch:{ all -> 0x025d }
                java.lang.String r8 = r11.tag     // Catch:{ all -> 0x025d }
                boolean r6 = r4.onWrite(r6, r7, r8)     // Catch:{ all -> 0x025d }
            L_0x01ab:
                if (r6 == 0) goto L_0x01c5
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x025d }
                r11.<init>()     // Catch:{ all -> 0x025d }
                r11.append(r5)     // Catch:{ all -> 0x025d }
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x025d }
                long r4 = r4 - r2
                r11.append(r4)     // Catch:{ all -> 0x025d }
                java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x025d }
                r10.debug(r11)     // Catch:{ all -> 0x025d }
                goto L_0x0218
            L_0x01c5:
                java.io.OutputStream r4 = r10.mOutputStream     // Catch:{ all -> 0x025d }
                byte[] r6 = r11.bytes     // Catch:{ all -> 0x025d }
                r4.write(r6)     // Catch:{ all -> 0x025d }
                java.io.OutputStream r4 = r10.mOutputStream     // Catch:{ all -> 0x025d }
                r4.flush()     // Catch:{ all -> 0x025d }
            L_0x01d3:
                r11.recycle()     // Catch:{ all -> 0x025d }
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x025d }
                r11.<init>()     // Catch:{ all -> 0x025d }
                r11.append(r5)     // Catch:{ all -> 0x025d }
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x025d }
                long r4 = r4 - r2
                r11.append(r4)     // Catch:{ all -> 0x025d }
                java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x025d }
                r10.debug(r11)     // Catch:{ all -> 0x025d }
                goto L_0x0218
            L_0x01ee:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x025d }
                r2.<init>()     // Catch:{ all -> 0x025d }
                java.lang.String r3 = "change phoneNumber to "
                r2.append(r3)     // Catch:{ all -> 0x025d }
                java.lang.Object r3 = r11.obj     // Catch:{ all -> 0x025d }
                r2.append(r3)     // Catch:{ all -> 0x025d }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x025d }
                r10.debug(r2)     // Catch:{ all -> 0x025d }
                java.lang.Object r2 = r11.obj     // Catch:{ all -> 0x025d }
                if (r2 == 0) goto L_0x0218
                java.lang.Object r11 = r11.obj     // Catch:{ all -> 0x025d }
                r4 = r11
                java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x025d }
                java.lang.String r3 = r10.mPackageName     // Catch:{ all -> 0x025d }
                java.lang.String r5 = r10.mPath     // Catch:{ all -> 0x025d }
                java.lang.String r6 = r10.mRule     // Catch:{ all -> 0x025d }
                r7 = 1
                r2 = r10
                r2.changeConfigIfNecessary(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x025d }
            L_0x0218:
                boolean r11 = r10.mDebug     // Catch:{ all -> 0x025d }
                if (r11 == 0) goto L_0x0261
                int r11 = r10.count     // Catch:{ all -> 0x025d }
                int r11 = r11 + 1
                r10.count = r11     // Catch:{ all -> 0x025d }
                long r2 = r10.timeSpend     // Catch:{ all -> 0x025d }
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x025d }
                long r4 = r4 - r0
                long r2 = r2 + r4
                r10.timeSpend = r2     // Catch:{ all -> 0x025d }
                java.lang.String r5 = "LogThread"
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x025d }
                r11.<init>()     // Catch:{ all -> 0x025d }
                java.lang.String r2 = "handler process average time: "
                r11.append(r2)     // Catch:{ all -> 0x025d }
                long r2 = r10.timeSpend     // Catch:{ all -> 0x025d }
                double r2 = (double) r2     // Catch:{ all -> 0x025d }
                int r4 = r10.count     // Catch:{ all -> 0x025d }
                double r6 = (double) r4     // Catch:{ all -> 0x025d }
                double r2 = r2 / r6
                r11.append(r2)     // Catch:{ all -> 0x025d }
                java.lang.String r2 = "ms, this round time:"
                r11.append(r2)     // Catch:{ all -> 0x025d }
                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x025d }
                long r2 = r2 - r0
                r11.append(r2)     // Catch:{ all -> 0x025d }
                java.lang.String r6 = r11.toString()     // Catch:{ all -> 0x025d }
                r4 = 3
                r7 = 0
                java.lang.String r8 = "com.didi.hawaii.log.HWLogger$LogHandler"
                r9 = 460(0x1cc, float:6.45E-43)
                com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x025d }
                goto L_0x0261
            L_0x025d:
                r11 = move-exception
                r11.printStackTrace()
            L_0x0261:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.log.HWLogger.LogHandler.handleMessage(android.os.Message):void");
        }

        private String getPath() {
            String str = this.mPath;
            if (str == null) {
                String str2 = this.mPackageName;
                if (str2 != null) {
                    str = HWSupportedAppVersion.getBaMaiLogDir(str2, StorageUtils.getSDRootPath() + "hawaii/");
                } else {
                    str = "" + StorageUtils.getSDRootPath() + "hawaii/";
                }
            }
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            return str;
        }

        private void changeConfigIfNecessary(String str, String str2, String str3, String str4, boolean z) throws IOException {
            boolean z2;
            boolean z3;
            SharedPreferences sharePreference;
            boolean z4 = false;
            boolean z5 = true;
            if (this.mPhoneNumber == null || (!TextUtils.isEmpty(str2) && !this.mPhoneNumber.equals(str2))) {
                this.mPhoneNumber = str2;
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.mPath == null || (!TextUtils.isEmpty(str3) && !this.mPath.equals(str3))) {
                this.mPath = str3;
                z3 = true;
            } else {
                z3 = false;
            }
            if (this.mPackageName == null || (!TextUtils.isEmpty(str) && !this.mPackageName.equals(str))) {
                this.mPackageName = str;
                z4 = true;
            }
            if (this.mRule == null || (!TextUtils.isEmpty(str4) && !this.mRule.equals(str4))) {
                this.mRule = str4;
            } else {
                z5 = z3;
            }
            if (z2 || z5) {
                changeFileIfNecessary(getHawaiiLogFile());
                if (z && (sharePreference = HWSharedPreference.getSharePreference()) != null) {
                    SharedPreferences.Editor edit = sharePreference.edit();
                    if (z2) {
                        edit.putString(HWSharedPreference.LOG.KEY_SHARED_PHONE_NUMBER, this.mPhoneNumber);
                    }
                    if (z5) {
                        edit.putString(HWSharedPreference.LOG.KEY_SHARED_LOG_PATH, this.mPath);
                    }
                    if (z4) {
                        edit.putString(HWSharedPreference.LOG.KEY_SHARED_PACKAGENAME, this.mPackageName);
                    }
                    edit.commit();
                }
            }
        }

        private void testCurrentFile() throws IOException {
            File file = this.mFile;
            if (file != null && file.length() > 20971520) {
                debug("===========exceed the Threshold");
                changeFileIfNecessary(getHawaiiLogFile());
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
        /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void changeFileIfNecessary(java.io.File r5) {
            /*
                r4 = this;
                if (r5 != 0) goto L_0x0003
                return
            L_0x0003:
                r0 = 0
                java.io.File r1 = r4.mFile
                r2 = 1
                if (r1 == 0) goto L_0x0023
                boolean r1 = r1.exists()
                if (r1 != 0) goto L_0x0010
                goto L_0x0023
            L_0x0010:
                java.lang.String r1 = r5.getAbsolutePath()
                java.io.File r3 = r4.mFile
                java.lang.String r3 = r3.getAbsolutePath()
                boolean r1 = r1.equals(r3)
                if (r1 != 0) goto L_0x0026
                r4.mFile = r5
                goto L_0x0025
            L_0x0023:
                r4.mFile = r5
            L_0x0025:
                r0 = 1
            L_0x0026:
                if (r0 == 0) goto L_0x0080
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r0 = "====>change file to "
                r5.append(r0)
                java.io.File r0 = r4.mFile
                java.lang.String r0 = r0.getAbsolutePath()
                r5.append(r0)
                java.lang.String r5 = r5.toString()
                r4.debug(r5)
                r4.closeStream()
                r5 = 0
                java.io.File r0 = r4.mFile     // Catch:{ FileNotFoundException -> 0x0077, UnsupportedEncodingException -> 0x0075, IOException -> 0x006b, Exception -> 0x0061 }
                r0.createNewFile()     // Catch:{ FileNotFoundException -> 0x0077, UnsupportedEncodingException -> 0x0075, IOException -> 0x006b, Exception -> 0x0061 }
                java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0077, UnsupportedEncodingException -> 0x0075, IOException -> 0x006b, Exception -> 0x0061 }
                java.io.File r1 = r4.mFile     // Catch:{ FileNotFoundException -> 0x0077, UnsupportedEncodingException -> 0x0075, IOException -> 0x006b, Exception -> 0x0061 }
                r0.<init>(r1, r2)     // Catch:{ FileNotFoundException -> 0x0077, UnsupportedEncodingException -> 0x0075, IOException -> 0x006b, Exception -> 0x0061 }
                r4.mOutputStream = r0     // Catch:{ FileNotFoundException -> 0x0077, UnsupportedEncodingException -> 0x0075, IOException -> 0x006b, Exception -> 0x0061 }
                java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter     // Catch:{ FileNotFoundException -> 0x0077, UnsupportedEncodingException -> 0x0075, IOException -> 0x006b, Exception -> 0x0061 }
                java.io.OutputStream r1 = r4.mOutputStream     // Catch:{ FileNotFoundException -> 0x0077, UnsupportedEncodingException -> 0x0075, IOException -> 0x006b, Exception -> 0x0061 }
                java.lang.String r2 = "utf-8"
                r0.<init>(r1, r2)     // Catch:{ FileNotFoundException -> 0x0077, UnsupportedEncodingException -> 0x0075, IOException -> 0x006b, Exception -> 0x0061 }
                r4.mOutputStreamWriter = r0     // Catch:{ FileNotFoundException -> 0x0077, UnsupportedEncodingException -> 0x0075, IOException -> 0x006b, Exception -> 0x0061 }
                goto L_0x0080
            L_0x0061:
                r0 = move-exception
                r0.printStackTrace()
                r4.mFile = r5
                r4.closeStream()
                goto L_0x0080
            L_0x006b:
                r0 = move-exception
                r0.printStackTrace()
                r4.mFile = r5
                r4.closeStream()
                goto L_0x0080
            L_0x0075:
                r0 = move-exception
                goto L_0x0078
            L_0x0077:
                r0 = move-exception
            L_0x0078:
                r0.printStackTrace()
                r4.mFile = r5
                r4.closeStream()
            L_0x0080:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.log.HWLogger.LogHandler.changeFileIfNecessary(java.io.File):void");
        }

        private File getHawaiiLogFile() throws IOException {
            if (this.mRule == null) {
                if (!TextUtils.isEmpty(this.mPackageName)) {
                    String a = C8942b.m16775a(this.mPackageName);
                    if (a != null) {
                        this.mRule = a;
                    } else {
                        this.mRule = C8942b.m16774a();
                    }
                } else {
                    this.mRule = C8942b.m16774a();
                }
            }
            int calculateMaxCount = calculateMaxCount();
            return new File(getPath() + C8942b.m16776a(this.mRule, this.mPhoneNumber, calculateMaxCount, this.yyyyMMdd, this.HHmmss));
        }

        private int calculateMaxCount() {
            int i = 1;
            while (true) {
                if (new File(getPath() + C8942b.m16776a(this.mRule, this.mPhoneNumber, i, this.yyyyMMdd, this.HHmmss)).length() <= 20971520) {
                    return i;
                }
                i++;
            }
        }

        /* access modifiers changed from: private */
        public void closeStream() {
            OutputStreamWriter outputStreamWriter = this.mOutputStreamWriter;
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                    this.mOutputStreamWriter = null;
                    OutputStream outputStream = this.mOutputStream;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                            this.mOutputStream = null;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    OutputStream outputStream2 = this.mOutputStream;
                    if (outputStream2 != null) {
                        outputStream2.close();
                        this.mOutputStream = null;
                    }
                } catch (Throwable th) {
                    OutputStream outputStream3 = this.mOutputStream;
                    if (outputStream3 != null) {
                        try {
                            outputStream3.close();
                            this.mOutputStream = null;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } else {
                OutputStream outputStream4 = this.mOutputStream;
                if (outputStream4 != null) {
                    try {
                        outputStream4.close();
                        this.mOutputStream = null;
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }

        private void debug(String str) {
            if (this.mDebug) {
                SystemUtils.log(3, "LogThread", str, (Throwable) null, "com.didi.hawaii.log.HWLogger$LogHandler", 672);
            }
        }

        private Message obtainConfigMessage(String str, String str2, String str3, String str4) {
            Message obtain = Message.obtain(this, 8);
            LogConfig logConfig = new LogConfig();
            String unused = logConfig.path = str;
            String unused2 = logConfig.packageName = str2;
            String unused3 = logConfig.phoneNumber = str3;
            String unused4 = logConfig.rule = str4;
            obtain.obj = logConfig;
            return obtain;
        }

        /* access modifiers changed from: package-private */
        public void changeConfig(String str, String str2, String str3, String str4) {
            sendMessage(obtainConfigMessage(str, str2, str3, str4));
        }
    }
}
