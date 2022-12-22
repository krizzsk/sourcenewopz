package p242io.flutter.embedding.engine.dart;

import android.content.res.AssetManager;
import androidx.tracing.Trace;
import com.didi.flutter.nacho2.p115v2.NachoConstants;
import java.nio.ByteBuffer;
import java.util.List;
import p242io.flutter.FlutterInjector;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.FlutterJNI;
import p242io.flutter.embedding.engine.loader.FlutterLoader;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StringCodec;
import p242io.flutter.view.FlutterCallbackInformation;

/* renamed from: io.flutter.embedding.engine.dart.DartExecutor */
public class DartExecutor implements BinaryMessenger {

    /* renamed from: a */
    private static final String f57601a = "DartExecutor";

    /* renamed from: b */
    private final FlutterJNI f57602b;

    /* renamed from: c */
    private final AssetManager f57603c;

    /* renamed from: d */
    private final DartMessenger f57604d;

    /* renamed from: e */
    private final BinaryMessenger f57605e;

    /* renamed from: f */
    private boolean f57606f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f57607g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public IsolateServiceIdListener f57608h;

    /* renamed from: i */
    private final BinaryMessenger.BinaryMessageHandler f57609i = new BinaryMessenger.BinaryMessageHandler() {
        public void onMessage(ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
            String unused = DartExecutor.this.f57607g = StringCodec.INSTANCE.decodeMessage(byteBuffer);
            if (DartExecutor.this.f57608h != null) {
                DartExecutor.this.f57608h.onIsolateServiceIdAvailable(DartExecutor.this.f57607g);
            }
        }
    };

    /* renamed from: io.flutter.embedding.engine.dart.DartExecutor$IsolateServiceIdListener */
    public interface IsolateServiceIdListener {
        void onIsolateServiceIdAvailable(String str);
    }

    public /* synthetic */ BinaryMessenger.TaskQueue makeBackgroundTaskQueue() {
        return BinaryMessenger.CC.$default$makeBackgroundTaskQueue(this);
    }

    public DartExecutor(FlutterJNI flutterJNI, AssetManager assetManager) {
        this.f57602b = flutterJNI;
        this.f57603c = assetManager;
        DartMessenger dartMessenger = new DartMessenger(flutterJNI);
        this.f57604d = dartMessenger;
        dartMessenger.setMessageHandler("flutter/isolate", this.f57609i);
        this.f57605e = new DefaultBinaryMessenger(this.f57604d);
        if (flutterJNI.isAttached()) {
            this.f57606f = true;
        }
    }

    public void onAttachedToJNI() {
        Log.m41140v(f57601a, "Attached to JNI. Registering the platform message handler for this Dart execution context.");
        this.f57602b.setPlatformMessageHandler(this.f57604d);
    }

    public void onDetachedFromJNI() {
        Log.m41140v(f57601a, "Detached from JNI. De-registering the platform message handler for this Dart execution context.");
        this.f57602b.setPlatformMessageHandler((PlatformMessageHandler) null);
    }

    public boolean isExecutingDart() {
        return this.f57606f;
    }

    public void executeDartEntrypoint(DartEntrypoint dartEntrypoint) {
        executeDartEntrypoint(dartEntrypoint, (List<String>) null);
    }

    public void executeDartEntrypoint(DartEntrypoint dartEntrypoint, List<String> list) {
        if (this.f57606f) {
            Log.m41142w(f57601a, "Attempted to run a DartExecutor that is already running.");
            return;
        }
        Trace.beginSection("DartExecutor#executeDartEntrypoint");
        Log.m41140v(f57601a, "Executing Dart entrypoint: " + dartEntrypoint);
        try {
            this.f57602b.runBundleAndSnapshotFromLibrary(dartEntrypoint.pathToBundle, dartEntrypoint.dartEntrypointFunctionName, dartEntrypoint.dartEntrypointLibrary, this.f57603c, list);
            this.f57606f = true;
        } finally {
            Trace.endSection();
        }
    }

    public void executeDartCallback(DartCallback dartCallback) {
        if (this.f57606f) {
            Log.m41142w(f57601a, "Attempted to run a DartExecutor that is already running.");
            return;
        }
        Trace.beginSection("DartExecutor#executeDartCallback");
        Log.m41140v(f57601a, "Executing Dart callback: " + dartCallback);
        try {
            this.f57602b.runBundleAndSnapshotFromLibrary(dartCallback.pathToBundle, dartCallback.callbackHandle.callbackName, dartCallback.callbackHandle.callbackLibraryPath, dartCallback.androidAssetManager, (List<String>) null);
            this.f57606f = true;
        } finally {
            Trace.endSection();
        }
    }

    public BinaryMessenger getBinaryMessenger() {
        return this.f57605e;
    }

    @Deprecated
    public BinaryMessenger.TaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
        return this.f57605e.makeBackgroundTaskQueue(taskQueueOptions);
    }

    @Deprecated
    public void send(String str, ByteBuffer byteBuffer) {
        this.f57605e.send(str, byteBuffer);
    }

    @Deprecated
    public void send(String str, ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
        this.f57605e.send(str, byteBuffer, binaryReply);
    }

    @Deprecated
    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        this.f57605e.setMessageHandler(str, binaryMessageHandler);
    }

    @Deprecated
    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler, BinaryMessenger.TaskQueue taskQueue) {
        this.f57605e.setMessageHandler(str, binaryMessageHandler, taskQueue);
    }

    @Deprecated
    public void enableBufferingIncomingMessages() {
        this.f57604d.enableBufferingIncomingMessages();
    }

    @Deprecated
    public void disableBufferingIncomingMessages() {
        this.f57604d.disableBufferingIncomingMessages();
    }

    public int getPendingChannelResponseCount() {
        return this.f57604d.mo172510a();
    }

    public String getIsolateServiceId() {
        return this.f57607g;
    }

    public void setIsolateServiceIdListener(IsolateServiceIdListener isolateServiceIdListener) {
        String str;
        this.f57608h = isolateServiceIdListener;
        if (isolateServiceIdListener != null && (str = this.f57607g) != null) {
            isolateServiceIdListener.onIsolateServiceIdAvailable(str);
        }
    }

    public void notifyLowMemoryWarning() {
        if (this.f57602b.isAttached()) {
            this.f57602b.notifyLowMemoryWarning();
        }
    }

    /* renamed from: io.flutter.embedding.engine.dart.DartExecutor$DartEntrypoint */
    public static class DartEntrypoint {
        public final String dartEntrypointFunctionName;
        public final String dartEntrypointLibrary;
        public final String pathToBundle;

        public static DartEntrypoint createDefault() {
            FlutterLoader flutterLoader = FlutterInjector.instance().flutterLoader();
            if (flutterLoader.initialized()) {
                return new DartEntrypoint(flutterLoader.findAppBundlePath(), NachoConstants.NACHO_ENTRYPOINT_NAME);
            }
            throw new AssertionError("DartEntrypoints can only be created once a FlutterEngine is created.");
        }

        public DartEntrypoint(String str, String str2) {
            this.pathToBundle = str;
            this.dartEntrypointLibrary = null;
            this.dartEntrypointFunctionName = str2;
        }

        public DartEntrypoint(String str, String str2, String str3) {
            this.pathToBundle = str;
            this.dartEntrypointLibrary = str2;
            this.dartEntrypointFunctionName = str3;
        }

        public String toString() {
            return "DartEntrypoint( bundle path: " + this.pathToBundle + ", function: " + this.dartEntrypointFunctionName + " )";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DartEntrypoint dartEntrypoint = (DartEntrypoint) obj;
            if (!this.pathToBundle.equals(dartEntrypoint.pathToBundle)) {
                return false;
            }
            return this.dartEntrypointFunctionName.equals(dartEntrypoint.dartEntrypointFunctionName);
        }

        public int hashCode() {
            return (this.pathToBundle.hashCode() * 31) + this.dartEntrypointFunctionName.hashCode();
        }
    }

    /* renamed from: io.flutter.embedding.engine.dart.DartExecutor$DartCallback */
    public static class DartCallback {
        public final AssetManager androidAssetManager;
        public final FlutterCallbackInformation callbackHandle;
        public final String pathToBundle;

        public DartCallback(AssetManager assetManager, String str, FlutterCallbackInformation flutterCallbackInformation) {
            this.androidAssetManager = assetManager;
            this.pathToBundle = str;
            this.callbackHandle = flutterCallbackInformation;
        }

        public String toString() {
            return "DartCallback( bundle path: " + this.pathToBundle + ", library path: " + this.callbackHandle.callbackLibraryPath + ", function: " + this.callbackHandle.callbackName + " )";
        }
    }

    /* renamed from: io.flutter.embedding.engine.dart.DartExecutor$DefaultBinaryMessenger */
    private static class DefaultBinaryMessenger implements BinaryMessenger {
        private final DartMessenger messenger;

        public /* synthetic */ BinaryMessenger.TaskQueue makeBackgroundTaskQueue() {
            return BinaryMessenger.CC.$default$makeBackgroundTaskQueue(this);
        }

        private DefaultBinaryMessenger(DartMessenger dartMessenger) {
            this.messenger = dartMessenger;
        }

        public BinaryMessenger.TaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
            return this.messenger.makeBackgroundTaskQueue(taskQueueOptions);
        }

        public void send(String str, ByteBuffer byteBuffer) {
            this.messenger.send(str, byteBuffer, (BinaryMessenger.BinaryReply) null);
        }

        public void send(String str, ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
            this.messenger.send(str, byteBuffer, binaryReply);
        }

        public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
            this.messenger.setMessageHandler(str, binaryMessageHandler);
        }

        public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler, BinaryMessenger.TaskQueue taskQueue) {
            this.messenger.setMessageHandler(str, binaryMessageHandler, taskQueue);
        }

        public void enableBufferingIncomingMessages() {
            this.messenger.enableBufferingIncomingMessages();
        }

        public void disableBufferingIncomingMessages() {
            this.messenger.disableBufferingIncomingMessages();
        }
    }
}
