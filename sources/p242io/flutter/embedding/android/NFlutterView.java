package p242io.flutter.embedding.android;

import android.content.Context;
import com.didi.flutter.nacho2.p115v2.NachoAction;
import p242io.flutter.embedding.engine.FlutterEngine;

/* renamed from: io.flutter.embedding.android.NFlutterView */
public class NFlutterView extends FlutterView {
    public NFlutterView(Context context) {
        super(context);
    }

    public NFlutterView(Context context, FlutterTextureView flutterTextureView) {
        super(context, flutterTextureView);
    }

    public void attachToFlutterEngine(NachoAction nachoAction) {
        super.attachToFlutterEngine(nachoAction.getEngine());
    }

    public void attachToFlutterEngine(FlutterEngine flutterEngine) {
        throw new IllegalArgumentException("attachToFlutterEngine with engine is not supported. Please use NachoAction.");
    }
}
