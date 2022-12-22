package p242io.github.ponnamkarthik.toast.fluttertoast;

import android.content.Context;
import com.didi.travel.psnger.model.response.ScarShareChannel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.MethodChannel;
import p242io.flutter.plugin.common.PluginRegistry;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0016J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u0006H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lio/github/ponnamkarthik/toast/fluttertoast/FlutterToastPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "()V", "channel", "Lio/flutter/plugin/common/MethodChannel;", "onAttachedToEngine", "", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "p0", "setupChannel", "messenger", "Lio/flutter/plugin/common/BinaryMessenger;", "context", "Landroid/content/Context;", "teardownChannel", "Companion", "fluttertoast_release"}, mo175979k = 1, mo175980mv = {1, 6, 0}, mo175982xi = 48)
/* renamed from: io.github.ponnamkarthik.toast.fluttertoast.FlutterToastPlugin */
/* compiled from: FlutterToastPlugin.kt */
public final class FlutterToastPlugin implements FlutterPlugin {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private MethodChannel f58002a;

    @JvmStatic
    public static final void registerWith(PluginRegistry.Registrar registrar) {
        Companion.registerWith(registrar);
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lio/github/ponnamkarthik/toast/fluttertoast/FlutterToastPlugin$Companion;", "", "()V", "registerWith", "", "registrar", "Lio/flutter/plugin/common/PluginRegistry$Registrar;", "fluttertoast_release"}, mo175979k = 1, mo175980mv = {1, 6, 0}, mo175982xi = 48)
    /* renamed from: io.github.ponnamkarthik.toast.fluttertoast.FlutterToastPlugin$Companion */
    /* compiled from: FlutterToastPlugin.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void registerWith(PluginRegistry.Registrar registrar) {
            Intrinsics.checkNotNullParameter(registrar, "registrar");
            FlutterToastPlugin flutterToastPlugin = new FlutterToastPlugin();
            BinaryMessenger messenger = registrar.messenger();
            Intrinsics.checkNotNullExpressionValue(messenger, "registrar.messenger()");
            Context context = registrar.context();
            Intrinsics.checkNotNullExpressionValue(context, "registrar.context()");
            flutterToastPlugin.setupChannel(messenger, context);
        }
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "binding.binaryMessenger");
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "binding.applicationContext");
        setupChannel(binaryMessenger, applicationContext);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "p0");
        m41769a();
    }

    public final void setupChannel(BinaryMessenger binaryMessenger, Context context) {
        Intrinsics.checkNotNullParameter(binaryMessenger, ScarShareChannel.MESSENGER);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f58002a = new MethodChannel(binaryMessenger, "PonnamKarthik/fluttertoast");
        MethodCallHandlerImpl methodCallHandlerImpl = new MethodCallHandlerImpl(context);
        MethodChannel methodChannel = this.f58002a;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(methodCallHandlerImpl);
        }
    }

    /* renamed from: a */
    private final void m41769a() {
        MethodChannel methodChannel = this.f58002a;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.f58002a = null;
    }
}
