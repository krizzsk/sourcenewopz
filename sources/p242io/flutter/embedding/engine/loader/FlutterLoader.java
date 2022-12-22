package p242io.flutter.embedding.engine.loader;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.WindowManager;
import androidx.tracing.Trace;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import p242io.flutter.FlutterInjector;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.FlutterJNI;
import p242io.flutter.embedding.engine.loader.FlutterLoader;
import p242io.flutter.util.PathUtils;
import p242io.flutter.view.VsyncWaiter;

/* renamed from: io.flutter.embedding.engine.loader.FlutterLoader */
public class FlutterLoader {

    /* renamed from: a */
    static final String f57638a = "aot-shared-library-name";

    /* renamed from: b */
    static final String f57639b = "aot-vmservice-shared-library-name";

    /* renamed from: c */
    static final String f57640c = "snapshot-asset-path";

    /* renamed from: d */
    static final String f57641d = "vm-snapshot-data";

    /* renamed from: e */
    static final String f57642e = "isolate-snapshot-data";

    /* renamed from: f */
    static final String f57643f = "flutter-assets-dir";

    /* renamed from: g */
    static final String f57644g = "automatically-register-plugins";

    /* renamed from: i */
    private static final String f57645i = "FlutterLoader";

    /* renamed from: j */
    private static final String f57646j = "io.flutter.embedding.android.OldGenHeapSize";

    /* renamed from: k */
    private static final String f57647k = "io.flutter.embedding.android.EnableSkParagraph";

    /* renamed from: l */
    private static final String f57648l = "libflutter.so";

    /* renamed from: m */
    private static final String f57649m = "kernel_blob.bin";

    /* renamed from: n */
    private static final String f57650n = "libvmservice_snapshot.so";

    /* renamed from: o */
    private static FlutterLoader f57651o;

    /* renamed from: h */
    Future<InitResult> f57652h;

    /* renamed from: p */
    private boolean f57653p;

    /* renamed from: q */
    private Settings f57654q;

    /* renamed from: r */
    private long f57655r;

    /* renamed from: s */
    private FlutterApplicationInfo f57656s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public FlutterJNI f57657t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public ExecutorService f57658u;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public ResourceExtractor m41454a(Context context) {
        return null;
    }

    public FlutterLoader() {
        this(FlutterInjector.instance().getFlutterJNIFactory().provideFlutterJNI());
    }

    public FlutterLoader(FlutterJNI flutterJNI) {
        this(flutterJNI, FlutterInjector.instance().executorService());
    }

    public FlutterLoader(FlutterJNI flutterJNI, ExecutorService executorService) {
        this.f57653p = false;
        this.f57657t = flutterJNI;
        this.f57658u = executorService;
    }

    /* renamed from: io.flutter.embedding.engine.loader.FlutterLoader$InitResult */
    private static class InitResult {
        final String appStoragePath;
        final String dataDirPath;
        final String engineCachesPath;

        private InitResult(String str, String str2, String str3) {
            this.appStoragePath = str;
            this.engineCachesPath = str2;
            this.dataDirPath = str3;
        }
    }

    public void startInitialization(Context context) {
        startInitialization(context, new Settings());
    }

    public void startInitialization(Context context, Settings settings) {
        VsyncWaiter vsyncWaiter;
        if (this.f57654q == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Trace.beginSection("FlutterLoader#startInitialization");
                try {
                    final Context applicationContext = context.getApplicationContext();
                    this.f57654q = settings;
                    this.f57655r = SystemClock.uptimeMillis();
                    this.f57656s = ApplicationInfoLoader.load(applicationContext);
                    if (Build.VERSION.SDK_INT >= 17) {
                        vsyncWaiter = VsyncWaiter.getInstance((DisplayManager) applicationContext.getSystemService("display"), this.f57657t);
                    } else {
                        vsyncWaiter = VsyncWaiter.getInstance(((WindowManager) applicationContext.getSystemService("window")).getDefaultDisplay().getRefreshRate(), this.f57657t);
                    }
                    vsyncWaiter.init();
                    this.f57652h = this.f57658u.submit(new Callable<InitResult>() {
                        public InitResult call() {
                            Trace.beginSection("FlutterLoader initTask");
                            try {
                                ResourceExtractor a = FlutterLoader.this.m41454a(applicationContext);
                                FlutterLoader.this.f57657t.loadLibrary();
                                FlutterLoader.this.f57658u.execute(new Runnable() {
                                    public final void run() {
                                        FlutterLoader.C210791.this.lambda$call$0$FlutterLoader$1();
                                    }
                                });
                                if (a != null) {
                                    a.mo172546b();
                                }
                                return new InitResult(PathUtils.getFilesDir(applicationContext), PathUtils.getCacheDirectory(applicationContext), PathUtils.getDataDirectory(applicationContext));
                            } finally {
                                Trace.endSection();
                            }
                        }

                        public /* synthetic */ void lambda$call$0$FlutterLoader$1() {
                            FlutterLoader.this.f57657t.prefetchDefaultFontManager();
                        }
                    });
                } finally {
                    Trace.endSection();
                }
            } else {
                throw new IllegalStateException("startInitialization must be called on the main thread");
            }
        }
    }

    public void ensureInitializationComplete(Context context, String[] strArr) {
        if (!this.f57653p) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
            } else if (this.f57654q != null) {
                Trace.beginSection("FlutterLoader#ensureInitializationComplete");
                try {
                    InitResult initResult = this.f57652h.get();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
                    arrayList.add("--icu-native-lib-path=" + this.f57656s.nativeLibraryDir + File.separator + f57648l);
                    if (strArr != null) {
                        Collections.addAll(arrayList, strArr);
                    }
                    arrayList.add("--aot-shared-library-name=" + this.f57656s.aotSharedLibraryName);
                    arrayList.add("--aot-shared-library-name=" + this.f57656s.nativeLibraryDir + File.separator + this.f57656s.aotSharedLibraryName);
                    StringBuilder sb = new StringBuilder();
                    sb.append("--cache-dir-path=");
                    sb.append(initResult.engineCachesPath);
                    arrayList.add(sb.toString());
                    if (this.f57656s.domainNetworkPolicy != null) {
                        arrayList.add("--domain-network-policy=" + this.f57656s.domainNetworkPolicy);
                    }
                    if (this.f57654q.getLogTag() != null) {
                        arrayList.add("--log-tag=" + this.f57654q.getLogTag());
                    }
                    Bundle bundle = SystemUtils.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128).metaData;
                    int i = bundle != null ? bundle.getInt(f57646j) : 0;
                    if (i == 0) {
                        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
                        i = (int) ((((double) memoryInfo.totalMem) / 1000000.0d) / 2.0d);
                    }
                    arrayList.add("--old-gen-heap-size=" + i);
                    arrayList.add("--prefetched-default-font-manager");
                    if (bundle != null && bundle.getBoolean(f57647k)) {
                        arrayList.add("--enable-skparagraph");
                    }
                    long uptimeMillis = SystemClock.uptimeMillis() - this.f57655r;
                    this.f57657t.init(context, (String[]) arrayList.toArray(new String[0]), (String) null, initResult.appStoragePath, initResult.engineCachesPath, uptimeMillis);
                    this.f57653p = true;
                    Trace.endSection();
                } catch (Exception e) {
                    Log.m41137e(f57645i, "Flutter initialization failed.", e);
                    throw new RuntimeException(e);
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            } else {
                throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
            }
        }
    }

    public void ensureInitializationCompleteAsync(Context context, String[] strArr, Handler handler, Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        } else if (this.f57654q == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        } else if (this.f57653p) {
            handler.post(runnable);
        } else {
            this.f57658u.execute(new Runnable(context, strArr, handler, runnable) {
                public final /* synthetic */ Context f$1;
                public final /* synthetic */ String[] f$2;
                public final /* synthetic */ Handler f$3;
                public final /* synthetic */ Runnable f$4;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void run() {
                    FlutterLoader.this.m41457a(this.f$1, this.f$2, this.f$3, this.f$4);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m41457a(Context context, String[] strArr, Handler handler, Runnable runnable) {
        try {
            InitResult initResult = this.f57652h.get();
            new Handler(Looper.getMainLooper()).post(new Runnable(context, strArr, handler, runnable) {
                public final /* synthetic */ Context f$1;
                public final /* synthetic */ String[] f$2;
                public final /* synthetic */ Handler f$3;
                public final /* synthetic */ Runnable f$4;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void run() {
                    FlutterLoader.this.m41459b(this.f$1, this.f$2, this.f$3, this.f$4);
                }
            });
        } catch (Exception e) {
            Log.m41137e(f57645i, "Flutter initialization failed.", e);
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m41459b(Context context, String[] strArr, Handler handler, Runnable runnable) {
        ensureInitializationComplete(context.getApplicationContext(), strArr);
        handler.post(runnable);
    }

    public boolean initialized() {
        return this.f57653p;
    }

    public String findAppBundlePath() {
        return this.f57656s.flutterAssetsDir;
    }

    public String getLookupKeyForAsset(String str) {
        return m41456a(str);
    }

    public String getLookupKeyForAsset(String str, String str2) {
        return getLookupKeyForAsset("packages" + File.separator + str2 + File.separator + str);
    }

    public boolean automaticallyRegisterPlugins() {
        return this.f57656s.f57637a;
    }

    /* renamed from: a */
    private String m41456a(String str) {
        return this.f57656s.flutterAssetsDir + File.separator + str;
    }

    /* renamed from: io.flutter.embedding.engine.loader.FlutterLoader$Settings */
    public static class Settings {
        private String logTag;

        public String getLogTag() {
            return this.logTag;
        }

        public void setLogTag(String str) {
            this.logTag = str;
        }
    }
}
