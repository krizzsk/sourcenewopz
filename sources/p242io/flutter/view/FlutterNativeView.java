package p242io.flutter.view;

import android.app.Activity;
import android.content.Context;
import java.nio.ByteBuffer;
import java.util.List;
import p242io.flutter.Log;
import p242io.flutter.app.FlutterPluginRegistry;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.embedding.engine.FlutterJNI;
import p242io.flutter.embedding.engine.dart.DartExecutor;
import p242io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import p242io.flutter.plugin.common.BinaryMessenger;

@Deprecated
/* renamed from: io.flutter.view.FlutterNativeView */
public class FlutterNativeView implements BinaryMessenger {

    /* renamed from: a */
    private static final String f57962a = "FlutterNativeView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final FlutterPluginRegistry f57963b;

    /* renamed from: c */
    private final DartExecutor f57964c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FlutterView f57965d;

    /* renamed from: e */
    private final FlutterJNI f57966e;

    /* renamed from: f */
    private final Context f57967f;

    /* renamed from: g */
    private boolean f57968g;

    /* renamed from: h */
    private final FlutterUiDisplayListener f57969h;

    public void disableBufferingIncomingMessages() {
    }

    public void enableBufferingIncomingMessages() {
    }

    public /* synthetic */ BinaryMessenger.TaskQueue makeBackgroundTaskQueue() {
        return BinaryMessenger.CC.$default$makeBackgroundTaskQueue(this);
    }

    public FlutterNativeView(Context context) {
        this(context, false);
    }

    public FlutterNativeView(Context context, boolean z) {
        this.f57969h = new FlutterUiDisplayListener() {
            public void onFlutterUiNoLongerDisplayed() {
            }

            public void onFlutterUiDisplayed() {
                if (FlutterNativeView.this.f57965d != null) {
                    FlutterNativeView.this.f57965d.onFirstFrame();
                }
            }
        };
        if (z) {
            Log.m41142w(f57962a, "'isBackgroundView' is no longer supported and will be ignored");
        }
        this.f57967f = context;
        this.f57963b = new FlutterPluginRegistry(this, context);
        FlutterJNI flutterJNI = new FlutterJNI();
        this.f57966e = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(this.f57969h);
        this.f57964c = new DartExecutor(this.f57966e, context.getAssets());
        this.f57966e.addEngineLifecycleListener(new EngineLifecycleListenerImpl());
        m41749c(this);
        assertAttached();
    }

    public void detachFromFlutterView() {
        this.f57963b.detach();
        this.f57965d = null;
    }

    public void destroy() {
        this.f57963b.destroy();
        this.f57964c.onDetachedFromJNI();
        this.f57965d = null;
        this.f57966e.removeIsDisplayingFlutterUiListener(this.f57969h);
        this.f57966e.detachFromNativeAndReleaseResources();
        this.f57968g = false;
    }

    public DartExecutor getDartExecutor() {
        return this.f57964c;
    }

    public FlutterPluginRegistry getPluginRegistry() {
        return this.f57963b;
    }

    public void attachViewAndActivity(FlutterView flutterView, Activity activity) {
        this.f57965d = flutterView;
        this.f57963b.attach(flutterView, activity);
    }

    public boolean isAttached() {
        return this.f57966e.isAttached();
    }

    public void assertAttached() {
        if (!isAttached()) {
            throw new AssertionError("Platform view is not attached");
        }
    }

    public void runFromBundle(FlutterRunArguments flutterRunArguments) {
        if (flutterRunArguments.entrypoint != null) {
            assertAttached();
            if (!this.f57968g) {
                this.f57966e.runBundleAndSnapshotFromLibrary(flutterRunArguments.bundlePath, flutterRunArguments.entrypoint, flutterRunArguments.libraryPath, this.f57967f.getResources().getAssets(), (List<String>) null);
                this.f57968g = true;
                return;
            }
            throw new AssertionError("This Flutter engine instance is already running an application");
        }
        throw new AssertionError("An entrypoint must be specified");
    }

    public boolean isApplicationRunning() {
        return this.f57968g;
    }

    public static String getObservatoryUri() {
        return FlutterJNI.getObservatoryUri();
    }

    public BinaryMessenger.TaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
        return this.f57964c.getBinaryMessenger().makeBackgroundTaskQueue(taskQueueOptions);
    }

    public void send(String str, ByteBuffer byteBuffer) {
        this.f57964c.getBinaryMessenger().send(str, byteBuffer);
    }

    public void send(String str, ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
        if (!isAttached()) {
            Log.m41134d(f57962a, "FlutterView.send called on a detached view, channel=" + str);
            return;
        }
        this.f57964c.getBinaryMessenger().send(str, byteBuffer, binaryReply);
    }

    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        this.f57964c.getBinaryMessenger().setMessageHandler(str, binaryMessageHandler);
    }

    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler, BinaryMessenger.TaskQueue taskQueue) {
        this.f57964c.getBinaryMessenger().setMessageHandler(str, binaryMessageHandler, taskQueue);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public FlutterJNI mo172958a() {
        return this.f57966e;
    }

    /* renamed from: c */
    private void m41749c(FlutterNativeView flutterNativeView) {
        this.f57966e.attachToNative();
        this.f57964c.onAttachedToJNI();
    }

    /* renamed from: io.flutter.view.FlutterNativeView$EngineLifecycleListenerImpl */
    private final class EngineLifecycleListenerImpl implements FlutterEngine.EngineLifecycleListener {
        public void onEngineWillDestroy() {
        }

        private EngineLifecycleListenerImpl() {
        }

        public void onPreEngineRestart() {
            if (FlutterNativeView.this.f57965d != null) {
                FlutterNativeView.this.f57965d.mo172972b();
            }
            if (FlutterNativeView.this.f57963b != null) {
                FlutterNativeView.this.f57963b.onPreEngineRestart();
            }
        }
    }
}
