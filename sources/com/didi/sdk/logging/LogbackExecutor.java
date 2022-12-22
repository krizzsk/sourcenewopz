package com.didi.sdk.logging;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.didi.sdk.logging.model.AbstractLog;
import com.didi.sdk.logging.util.Debug;
import com.didi.sdk.logging.util.LoggerUtils;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class LogbackExecutor {

    /* renamed from: a */
    private static final int f36479a = 1024;

    /* renamed from: b */
    private static final Map<String, LogbackExecutor> f36480b = Collections.synchronizedMap(new HashMap());

    /* renamed from: c */
    private final C12387a f36481c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final BlockingQueue<AbstractLog> f36482d;

    /* renamed from: e */
    private final Worker f36483e;

    /* renamed from: f */
    private final Object f36484f = new Object();

    /* renamed from: g */
    private File f36485g;

    /* renamed from: h */
    private OutputStream f36486h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final AtomicBoolean f36487i = new AtomicBoolean(false);

    /* renamed from: j */
    private String f36488j = DXDecryptor.decode("+8at/cgV10ipDyx8W4Chrw==");

    /* renamed from: a */
    public static LogbackExecutor m25860a(String str) {
        LogbackExecutor logbackExecutor = f36480b.get(str);
        if (logbackExecutor == null) {
            synchronized (f36480b) {
                if (logbackExecutor == null) {
                    logbackExecutor = new LogbackExecutor(str);
                    f36480b.put(str, logbackExecutor);
                }
            }
        }
        return logbackExecutor;
    }

    private LogbackExecutor(String str) {
        this.f36483e = new Worker("logger-logback-" + str);
        this.f36482d = new ArrayBlockingQueue(1024);
        this.f36481c = new C12400h(Type.LOGBACK, str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo92521a(AbstractLog abstractLog) {
        if (abstractLog != null) {
            if (this.f36487i.compareAndSet(false, true)) {
                m25862a();
            }
            if (LoggerUtils.isMainThread()) {
                this.f36482d.offer(abstractLog);
                return;
            }
            try {
                this.f36482d.put(abstractLog);
            } catch (InterruptedException unused) {
            }
        }
    }

    /* renamed from: a */
    private void m25862a() {
        this.f36481c.mo92596a(System.currentTimeMillis());
        File file = new File(this.f36481c.mo92598b());
        this.f36485g = file;
        try {
            m25867a(file);
        } catch (IOException e) {
            Debug.logOrThrow("start work thread openFile IOException ", e);
        }
        m25870b();
    }

    /* renamed from: b */
    private void m25870b() {
        this.f36483e.setDaemon(true);
        this.f36483e.start();
    }

    class Worker extends Thread {
        Worker(String str) {
            super(str);
        }

        public void run() {
            boolean z;
            while (LogbackExecutor.this.f36487i.get()) {
                try {
                    AbstractLog abstractLog = (AbstractLog) LogbackExecutor.this.f36482d.take();
                    if (abstractLog != null) {
                        LoggerConfig config = LoggerFactory.getConfig();
                        Boolean isLogcatLogEnabled = config.isLogcatLogEnabled();
                        Boolean isFileLogEnabled = config.isFileLogEnabled();
                        boolean isAppDebuggable = LoggerContext.getDefault().isAppDebuggable();
                        boolean z2 = true;
                        if (isFileLogEnabled == null) {
                            z = isLogcatLogEnabled == null;
                        } else {
                            z = isFileLogEnabled.booleanValue();
                        }
                        if (isLogcatLogEnabled != null) {
                            z2 = isLogcatLogEnabled.booleanValue();
                        } else if (isFileLogEnabled != null || !isAppDebuggable) {
                            z2 = false;
                        }
                        int i = config.getFileLogLevel().level;
                        int i2 = config.getLogcatLogLevel().level;
                        int filterLevel = LoggerFactory.getFilterLevel();
                        String filterTag = LoggerFactory.getFilterTag();
                        int i3 = abstractLog.getLogLevel().level;
                        if (z) {
                            String content = abstractLog.getContent();
                            if (!TextUtils.isEmpty(content)) {
                                if (i3 < i) {
                                    if (i3 < filterLevel) {
                                        if (!TextUtils.isEmpty(filterTag) && abstractLog.getTag().equals(filterTag)) {
                                            LogbackExecutor.this.m25868a(content, config.isEncryptEnabled().booleanValue());
                                        }
                                    }
                                }
                                LogbackExecutor.this.m25868a(content, config.isEncryptEnabled().booleanValue());
                            } else {
                                return;
                            }
                        }
                        if (z2 && i3 >= i2) {
                            String content2 = abstractLog.getContent();
                            if (!TextUtils.isEmpty(content2)) {
                                LogbackExecutor.this.m25864a(abstractLog.getLogLevel(), abstractLog.getTag(), content2);
                            }
                        }
                    }
                } catch (Exception e) {
                    Debug.logOrThrow("Consume log failed log  ", e);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25868a(String str, boolean z) {
        if (this.f36481c.mo92597a(this.f36485g)) {
            m25873c();
        }
        try {
            m25871b(str, z);
        } catch (IOException e) {
            Debug.logOrThrow("writeLogToFile failed ", e);
        }
    }

    /* renamed from: c */
    private void m25873c() {
        synchronized (this.f36484f) {
            m25874d();
            this.f36481c.mo92595a();
            File file = new File(this.f36481c.mo92598b());
            this.f36485g = file;
            try {
                m25867a(file);
            } catch (IOException e) {
                Debug.m25981e("rollover openFile IOException e = " + e);
            }
        }
    }

    /* renamed from: a */
    private void m25867a(File file) throws IOException {
        synchronized (this.f36484f) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            this.f36486h = new C12398f(file, true);
        }
    }

    /* renamed from: b */
    private void m25871b(String str, boolean z) throws IOException {
        if (this.f36486h != null && !TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(this.f36488j)) {
                this.f36488j = DXDecryptor.decode("+8at/cgV10ipDyx8W4Chrw==");
            }
            AESEncryptor aESEncryptor = new AESEncryptor(this.f36488j);
            byte[] b = m25872b(str + "\n");
            if (b != null && b.length != 0) {
                if (z) {
                    b = aESEncryptor.encrypt(b);
                }
                if (b != null && b.length != 0) {
                    if (z) {
                        m25863a(b.length);
                    }
                    this.f36486h.write(b);
                    this.f36486h.flush();
                }
            }
        }
    }

    /* renamed from: a */
    private final void m25863a(int i) throws IOException {
        this.f36486h.write((i >>> 24) & 255);
        this.f36486h.write((i >>> 16) & 255);
        this.f36486h.write((i >>> 8) & 255);
        this.f36486h.write((i >>> 0) & 255);
    }

    /* renamed from: b */
    private byte[] m25872b(String str) {
        try {
            return str.getBytes();
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    /* renamed from: d */
    private void m25874d() {
        OutputStream outputStream = this.f36486h;
        if (outputStream != null) {
            try {
                outputStream.close();
                this.f36486h = null;
            } catch (IOException unused) {
            }
        }
    }

    static final class AESEncryptor {
        private final IvParameterSpec ivSpec;
        private final SecretKeySpec keySpec;

        public AESEncryptor(String str) {
            byte[] bytes = str.getBytes();
            byte[] bArr = new byte[16];
            System.arraycopy(bytes, 0, bArr, 0, Math.min(16, bytes.length));
            this.keySpec = new SecretKeySpec(bArr, "AES");
            this.ivSpec = new IvParameterSpec(bytes);
        }

        public byte[] encrypt(byte[] bArr) {
            try {
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance.init(1, this.keySpec, this.ivSpec);
                return instance.doFinal(bArr);
            } catch (Exception e) {
                e.printStackTrace();
                return bArr;
            }
        }
    }

    static class DXDecryptor {
        static String algo = "ARCFOUR";

        /* renamed from: kp */
        static String f36489kp = "DKrW9F9rh1oAHKf6";

        DXDecryptor() {
        }

        public static String decode(String str) {
            try {
                Cipher instance = Cipher.getInstance(algo);
                instance.init(2, new SecretKeySpec(f36489kp.getBytes(), algo));
                instance.init(2, new SecretKeySpec(instance.doFinal(Base64.decode("Jvjd0+0C6wPyUUkARsSLEQ==", 0)), algo));
                return new String(instance.doFinal(Base64.decode(str, 0)));
            } catch (Exception unused) {
                return "";
            }
        }
    }

    /* renamed from: com.didi.sdk.logging.LogbackExecutor$1 */
    static /* synthetic */ class C123851 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$sdk$logging$Level;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.sdk.logging.Level[] r0 = com.didi.sdk.logging.Level.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$sdk$logging$Level = r0
                com.didi.sdk.logging.Level r1 = com.didi.sdk.logging.Level.TRACE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$sdk$logging$Level     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.sdk.logging.Level r1 = com.didi.sdk.logging.Level.DEBUG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$sdk$logging$Level     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.sdk.logging.Level r1 = com.didi.sdk.logging.Level.INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$sdk$logging$Level     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.sdk.logging.Level r1 = com.didi.sdk.logging.Level.WARN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$sdk$logging$Level     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.sdk.logging.Level r1 = com.didi.sdk.logging.Level.ERROR     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.logging.LogbackExecutor.C123851.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25864a(Level level, String str, String str2) {
        int i = C123851.$SwitchMap$com$didi$sdk$logging$Level[level.ordinal()];
        if (i == 1) {
            Log.v(str, str2);
        } else if (i == 2) {
            Log.d(str, str2);
        } else if (i == 3) {
            Log.i(str, str2);
        } else if (i == 4) {
            Log.w(str, str2);
        } else if (i == 5) {
            Log.e(str, str2);
        }
    }
}
