package p242io.flutter.plugins.pathprovider;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.didi.sdk.apm.SystemUtils;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.MethodChannel;
import p242io.flutter.plugin.common.MethodCodec;
import p242io.flutter.plugin.common.PluginRegistry;
import p242io.flutter.plugin.common.StandardMethodCodec;
import p242io.flutter.plugins.pathprovider.PathProviderPlugin;
import p242io.flutter.util.PathUtils;

/* renamed from: io.flutter.plugins.pathprovider.PathProviderPlugin */
public class PathProviderPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: a */
    static final String f57895a = "PathProviderPlugin";

    /* renamed from: b */
    private Context f57896b;

    /* renamed from: c */
    private MethodChannel f57897c;

    /* renamed from: d */
    private PathProviderImpl f57898d;

    /* renamed from: io.flutter.plugins.pathprovider.PathProviderPlugin$PathProviderImpl */
    private interface PathProviderImpl {
        void getApplicationDocumentsDirectory(MethodChannel.Result result);

        void getApplicationSupportDirectory(MethodChannel.Result result);

        void getExternalCacheDirectories(MethodChannel.Result result);

        void getExternalStorageDirectories(String str, MethodChannel.Result result);

        void getStorageDirectory(MethodChannel.Result result);

        void getTemporaryDirectory(MethodChannel.Result result);
    }

    /* renamed from: io.flutter.plugins.pathprovider.PathProviderPlugin$PathProviderPlatformThread */
    private class PathProviderPlatformThread implements PathProviderImpl {
        private final Executor executor;
        private final Executor uiThreadExecutor;

        private PathProviderPlatformThread() {
            this.uiThreadExecutor = new UiThreadExecutor();
            this.executor = Executors.newSingleThreadExecutor(new ThreadFactoryBuilder().setNameFormat("path-provider-background-%d").setPriority(5).build());
        }

        public void getTemporaryDirectory(MethodChannel.Result result) {
            executeInBackground(new Callable() {
                public final Object call() {
                    return PathProviderPlugin.PathProviderPlatformThread.this.mo172908xf26208b();
                }
            }, result);
        }

        /* renamed from: lambda$getTemporaryDirectory$0$PathProviderPlugin$PathProviderPlatformThread */
        public /* synthetic */ String mo172908xf26208b() throws Exception {
            return PathProviderPlugin.this.m41664a();
        }

        public void getApplicationDocumentsDirectory(MethodChannel.Result result) {
            executeInBackground(new Callable() {
                public final Object call() {
                    return PathProviderPlugin.PathProviderPlatformThread.this.mo172903xfbae5e63();
                }
            }, result);
        }

        /* renamed from: lambda$getApplicationDocumentsDirectory$1$PathProviderPlugin$PathProviderPlatformThread */
        public /* synthetic */ String mo172903xfbae5e63() throws Exception {
            return PathProviderPlugin.this.m41671c();
        }

        public void getStorageDirectory(MethodChannel.Result result) {
            executeInBackground(new Callable() {
                public final Object call() {
                    return PathProviderPlugin.PathProviderPlatformThread.this.mo172907xa280d663();
                }
            }, result);
        }

        /* renamed from: lambda$getStorageDirectory$2$PathProviderPlugin$PathProviderPlatformThread */
        public /* synthetic */ String mo172907xa280d663() throws Exception {
            return PathProviderPlugin.this.m41673d();
        }

        public void getExternalCacheDirectories(MethodChannel.Result result) {
            executeInBackground(new Callable() {
                public final Object call() {
                    return PathProviderPlugin.PathProviderPlatformThread.this.mo172905x6f7afe46();
                }
            }, result);
        }

        /* renamed from: lambda$getExternalCacheDirectories$3$PathProviderPlugin$PathProviderPlatformThread */
        public /* synthetic */ List mo172905x6f7afe46() throws Exception {
            return PathProviderPlugin.this.m41676e();
        }

        public void getExternalStorageDirectories(String str, MethodChannel.Result result) {
            executeInBackground(new Callable(str) {
                public final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final Object call() {
                    return PathProviderPlugin.PathProviderPlatformThread.this.mo172906x8fc930ee(this.f$1);
                }
            }, result);
        }

        /* renamed from: lambda$getExternalStorageDirectories$4$PathProviderPlugin$PathProviderPlatformThread */
        public /* synthetic */ List mo172906x8fc930ee(String str) throws Exception {
            return PathProviderPlugin.this.m41667a(str);
        }

        public void getApplicationSupportDirectory(MethodChannel.Result result) {
            executeInBackground(new Callable() {
                public final Object call() {
                    return PathProviderPlugin.PathProviderPlatformThread.this.mo172904x2bb84ff0();
                }
            }, result);
        }

        /* renamed from: lambda$getApplicationSupportDirectory$5$PathProviderPlugin$PathProviderPlatformThread */
        public /* synthetic */ String mo172904x2bb84ff0() throws Exception {
            return PathProviderPlugin.this.m41669b();
        }

        private <T> void executeInBackground(Callable<T> callable, final MethodChannel.Result result) {
            SettableFuture create = SettableFuture.create();
            Futures.addCallback(create, new FutureCallback<T>() {
                public void onSuccess(T t) {
                    result.success(t);
                }

                public void onFailure(Throwable th) {
                    result.error(th.getClass().getName(), th.getMessage(), (Object) null);
                }
            }, this.uiThreadExecutor);
            this.executor.execute(new Runnable(callable) {
                public final /* synthetic */ Callable f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    PathProviderPlugin.PathProviderPlatformThread.lambda$executeInBackground$6(SettableFuture.this, this.f$1);
                }
            });
        }

        static /* synthetic */ void lambda$executeInBackground$6(SettableFuture settableFuture, Callable callable) {
            try {
                settableFuture.set(callable.call());
            } catch (Throwable th) {
                settableFuture.setException(th);
            }
        }
    }

    /* renamed from: io.flutter.plugins.pathprovider.PathProviderPlugin$PathProviderBackgroundThread */
    private class PathProviderBackgroundThread implements PathProviderImpl {
        private PathProviderBackgroundThread() {
        }

        public void getTemporaryDirectory(MethodChannel.Result result) {
            result.success(PathProviderPlugin.this.m41664a());
        }

        public void getApplicationDocumentsDirectory(MethodChannel.Result result) {
            result.success(PathProviderPlugin.this.m41671c());
        }

        public void getStorageDirectory(MethodChannel.Result result) {
            result.success(PathProviderPlugin.this.m41673d());
        }

        public void getExternalCacheDirectories(MethodChannel.Result result) {
            result.success(PathProviderPlugin.this.m41676e());
        }

        public void getExternalStorageDirectories(String str, MethodChannel.Result result) {
            result.success(PathProviderPlugin.this.m41667a(str));
        }

        public void getApplicationSupportDirectory(MethodChannel.Result result) {
            result.success(PathProviderPlugin.this.m41669b());
        }
    }

    /* renamed from: a */
    private void m41668a(BinaryMessenger binaryMessenger, Context context) {
        try {
            Class<?> cls = Class.forName("io.flutter.plugin.common.MethodChannel");
            Class<?> cls2 = Class.forName("io.flutter.plugin.common.BinaryMessenger$TaskQueue");
            Object invoke = binaryMessenger.getClass().getMethod("makeBackgroundTaskQueue", new Class[0]).invoke(binaryMessenger, new Object[0]);
            this.f57897c = (MethodChannel) cls.getConstructor(new Class[]{BinaryMessenger.class, String.class, MethodCodec.class, cls2}).newInstance(new Object[]{binaryMessenger, "plugins.flutter.io/path_provider", StandardMethodCodec.INSTANCE, invoke});
            this.f57898d = new PathProviderBackgroundThread();
            SystemUtils.log(3, f57895a, "Use TaskQueues.", (Throwable) null, "io.flutter.plugins.pathprovider.PathProviderPlugin", 170);
        } catch (Exception unused) {
            this.f57897c = new MethodChannel(binaryMessenger, "plugins.flutter.io/path_provider");
            this.f57898d = new PathProviderPlatformThread();
            SystemUtils.log(3, f57895a, "Don't use TaskQueues.", (Throwable) null, "io.flutter.plugins.pathprovider.PathProviderPlugin", 174);
        }
        this.f57896b = context;
        this.f57897c.setMethodCallHandler(this);
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new PathProviderPlugin().m41668a(registrar.messenger(), registrar.context());
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        m41668a(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getApplicationContext());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f57897c.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.f57897c = null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(p242io.flutter.plugin.common.MethodCall r8, p242io.flutter.plugin.common.MethodChannel.Result r9) {
        /*
            r7 = this;
            java.lang.String r0 = r8.method
            int r1 = r0.hashCode()
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r1) {
                case -1832373352: goto L_0x0041;
                case -1208689078: goto L_0x0037;
                case 299667825: goto L_0x002d;
                case 1200320591: goto L_0x0023;
                case 1252916648: goto L_0x0019;
                case 1711844626: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x004b
        L_0x000f:
            java.lang.String r1 = "getTemporaryDirectory"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004b
            r0 = 0
            goto L_0x004c
        L_0x0019:
            java.lang.String r1 = "getStorageDirectory"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004b
            r0 = 2
            goto L_0x004c
        L_0x0023:
            java.lang.String r1 = "getApplicationDocumentsDirectory"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004b
            r0 = 1
            goto L_0x004c
        L_0x002d:
            java.lang.String r1 = "getExternalStorageDirectories"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004b
            r0 = 4
            goto L_0x004c
        L_0x0037:
            java.lang.String r1 = "getExternalCacheDirectories"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004b
            r0 = 3
            goto L_0x004c
        L_0x0041:
            java.lang.String r1 = "getApplicationSupportDirectory"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004b
            r0 = 5
            goto L_0x004c
        L_0x004b:
            r0 = -1
        L_0x004c:
            if (r0 == 0) goto L_0x0086
            if (r0 == r6) goto L_0x0080
            if (r0 == r5) goto L_0x007a
            if (r0 == r4) goto L_0x0074
            if (r0 == r3) goto L_0x0062
            if (r0 == r2) goto L_0x005c
            r9.notImplemented()
            goto L_0x008b
        L_0x005c:
            io.flutter.plugins.pathprovider.PathProviderPlugin$PathProviderImpl r8 = r7.f57898d
            r8.getApplicationSupportDirectory(r9)
            goto L_0x008b
        L_0x0062:
            java.lang.String r0 = "type"
            java.lang.Object r8 = r8.argument(r0)
            java.lang.Integer r8 = (java.lang.Integer) r8
            java.lang.String r8 = p242io.flutter.plugins.pathprovider.C21154a.m41683a(r8)
            io.flutter.plugins.pathprovider.PathProviderPlugin$PathProviderImpl r0 = r7.f57898d
            r0.getExternalStorageDirectories(r8, r9)
            goto L_0x008b
        L_0x0074:
            io.flutter.plugins.pathprovider.PathProviderPlugin$PathProviderImpl r8 = r7.f57898d
            r8.getExternalCacheDirectories(r9)
            goto L_0x008b
        L_0x007a:
            io.flutter.plugins.pathprovider.PathProviderPlugin$PathProviderImpl r8 = r7.f57898d
            r8.getStorageDirectory(r9)
            goto L_0x008b
        L_0x0080:
            io.flutter.plugins.pathprovider.PathProviderPlugin$PathProviderImpl r8 = r7.f57898d
            r8.getApplicationDocumentsDirectory(r9)
            goto L_0x008b
        L_0x0086:
            io.flutter.plugins.pathprovider.PathProviderPlugin$PathProviderImpl r8 = r7.f57898d
            r8.getTemporaryDirectory(r9)
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p242io.flutter.plugins.pathprovider.PathProviderPlugin.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m41664a() {
        return this.f57896b.getCacheDir().getPath();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m41669b() {
        return PathUtils.getFilesDir(this.f57896b);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public String m41671c() {
        return PathUtils.getDataDirectory(this.f57896b);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public String m41673d() {
        File externalFilesDir = this.f57896b.getExternalFilesDir((String) null);
        if (externalFilesDir == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public List<String> m41676e() {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 19) {
            for (File file : this.f57896b.getExternalCacheDirs()) {
                if (file != null) {
                    arrayList.add(file.getAbsolutePath());
                }
            }
        } else {
            File externalCacheDir = this.f57896b.getExternalCacheDir();
            if (externalCacheDir != null) {
                arrayList.add(externalCacheDir.getAbsolutePath());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<String> m41667a(String str) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 19) {
            for (File file : this.f57896b.getExternalFilesDirs(str)) {
                if (file != null) {
                    arrayList.add(file.getAbsolutePath());
                }
            }
        } else {
            File externalFilesDir = this.f57896b.getExternalFilesDir(str);
            if (externalFilesDir != null) {
                arrayList.add(externalFilesDir.getAbsolutePath());
            }
        }
        return arrayList;
    }

    /* renamed from: io.flutter.plugins.pathprovider.PathProviderPlugin$UiThreadExecutor */
    private static class UiThreadExecutor implements Executor {
        private final Handler handler;

        private UiThreadExecutor() {
            this.handler = new Handler(Looper.getMainLooper());
        }

        public void execute(Runnable runnable) {
            this.handler.post(runnable);
        }
    }
}
