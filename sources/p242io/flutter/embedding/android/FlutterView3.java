package p242io.flutter.embedding.android;

import android.content.Context;
import android.util.AttributeSet;

/* renamed from: io.flutter.embedding.android.FlutterView3 */
public class FlutterView3 extends FlutterView {

    /* renamed from: b */
    private int f57523b;

    /* renamed from: c */
    private int f57524c;

    public FlutterView3(Context context) {
        super(context);
    }

    public FlutterView3(Context context, FlutterSurfaceView flutterSurfaceView) {
        super(context, flutterSurfaceView);
    }

    public FlutterView3(Context context, FlutterTextureView flutterTextureView) {
        super(context, flutterTextureView);
    }

    public FlutterView3(Context context, FlutterImageView flutterImageView) {
        super(context, flutterImageView);
    }

    public FlutterView3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f57523b = i;
        this.f57524c = i2;
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void fixViewSize() {
        super.onSizeChanged(this.f57523b, this.f57524c, 0, 0);
    }

    public void attachToRenderer() {
        if ((this.f57482a != null && this.f57482a.getAttachedRenderer() == null) || !this.f57482a.getAttachedRenderer().isDisplayingFlutterUi()) {
            this.f57482a.attachToRenderer(getAttachedFlutterEngine().getRenderer());
        }
    }

    public void detachFromRenderer() {
        this.f57482a.detachFromRenderer();
    }
}
