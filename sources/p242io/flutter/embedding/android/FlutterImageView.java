package p242io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import java.nio.ByteBuffer;
import java.util.Locale;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.renderer.FlutterRenderer;
import p242io.flutter.embedding.engine.renderer.RenderSurface;

/* renamed from: io.flutter.embedding.android.FlutterImageView */
public class FlutterImageView extends View implements RenderSurface {

    /* renamed from: a */
    private static final String f57428a = "FlutterImageView";

    /* renamed from: b */
    private ImageReader f57429b;

    /* renamed from: c */
    private Image f57430c;

    /* renamed from: d */
    private Bitmap f57431d;

    /* renamed from: e */
    private FlutterRenderer f57432e;

    /* renamed from: f */
    private SurfaceKind f57433f;

    /* renamed from: g */
    private boolean f57434g;

    /* renamed from: io.flutter.embedding.android.FlutterImageView$SurfaceKind */
    public enum SurfaceKind {
        background,
        overlay
    }

    public void pause() {
    }

    public ImageReader getImageReader() {
        return this.f57429b;
    }

    public FlutterImageView(Context context, int i, int i2, SurfaceKind surfaceKind) {
        this(context, m41311a(i, i2), surfaceKind);
    }

    public FlutterImageView(Context context) {
        this(context, 1, 1, SurfaceKind.background);
    }

    public FlutterImageView(Context context, AttributeSet attributeSet) {
        this(context, 1, 1, SurfaceKind.background);
    }

    FlutterImageView(Context context, ImageReader imageReader, SurfaceKind surfaceKind) {
        super(context, (AttributeSet) null);
        this.f57434g = false;
        this.f57429b = imageReader;
        this.f57433f = surfaceKind;
        m41312a();
    }

    /* renamed from: a */
    private void m41312a() {
        setAlpha(0.0f);
    }

    /* renamed from: a */
    private static void m41313a(String str, Object... objArr) {
        Log.m41142w(f57428a, String.format(Locale.US, str, objArr));
    }

    /* renamed from: a */
    private static ImageReader m41311a(int i, int i2) {
        int i3;
        int i4;
        if (i <= 0) {
            m41313a("ImageReader width must be greater than 0, but given width=%d, set width=1", Integer.valueOf(i));
            i3 = 1;
        } else {
            i3 = i;
        }
        if (i2 <= 0) {
            m41313a("ImageReader height must be greater than 0, but given height=%d, set height=1", Integer.valueOf(i2));
            i4 = 1;
        } else {
            i4 = i2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return ImageReader.newInstance(i3, i4, 1, 3, 768);
        }
        return ImageReader.newInstance(i3, i4, 1, 3);
    }

    public Surface getSurface() {
        return this.f57429b.getSurface();
    }

    public FlutterRenderer getAttachedRenderer() {
        return this.f57432e;
    }

    /* renamed from: io.flutter.embedding.android.FlutterImageView$1 */
    static /* synthetic */ class C210411 {

        /* renamed from: $SwitchMap$io$flutter$embedding$android$FlutterImageView$SurfaceKind */
        static final /* synthetic */ int[] f57435x435d6649;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.flutter.embedding.android.FlutterImageView$SurfaceKind[] r0 = p242io.flutter.embedding.android.FlutterImageView.SurfaceKind.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f57435x435d6649 = r0
                io.flutter.embedding.android.FlutterImageView$SurfaceKind r1 = p242io.flutter.embedding.android.FlutterImageView.SurfaceKind.background     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f57435x435d6649     // Catch:{ NoSuchFieldError -> 0x001d }
                io.flutter.embedding.android.FlutterImageView$SurfaceKind r1 = p242io.flutter.embedding.android.FlutterImageView.SurfaceKind.overlay     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p242io.flutter.embedding.android.FlutterImageView.C210411.<clinit>():void");
        }
    }

    public void attachToRenderer(FlutterRenderer flutterRenderer) {
        if (C210411.f57435x435d6649[this.f57433f.ordinal()] == 1) {
            flutterRenderer.swapSurface(this.f57429b.getSurface());
        }
        setAlpha(1.0f);
        this.f57432e = flutterRenderer;
        this.f57434g = true;
    }

    public void detachFromRenderer() {
        if (this.f57434g) {
            setAlpha(0.0f);
            acquireLatestImage();
            this.f57431d = null;
            m41314b();
            invalidate();
            this.f57434g = false;
        }
    }

    public boolean acquireLatestImage() {
        if (!this.f57434g) {
            return false;
        }
        Image acquireLatestImage = this.f57429b.acquireLatestImage();
        if (acquireLatestImage != null) {
            m41314b();
            this.f57430c = acquireLatestImage;
            invalidate();
        }
        if (acquireLatestImage != null) {
            return true;
        }
        return false;
    }

    public void resizeIfNeeded(int i, int i2) {
        if (this.f57432e != null) {
            if (i != this.f57429b.getWidth() || i2 != this.f57429b.getHeight()) {
                m41314b();
                closeImageReader();
                this.f57429b = m41311a(i, i2);
            }
        }
    }

    public void closeImageReader() {
        this.f57429b.close();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f57430c != null) {
            m41315c();
        }
        Bitmap bitmap = this.f57431d;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    /* renamed from: b */
    private void m41314b() {
        Image image = this.f57430c;
        if (image != null) {
            image.close();
            this.f57430c = null;
        }
    }

    /* renamed from: c */
    private void m41315c() {
        if (Build.VERSION.SDK_INT >= 29) {
            HardwareBuffer hardwareBuffer = this.f57430c.getHardwareBuffer();
            this.f57431d = Bitmap.wrapHardwareBuffer(hardwareBuffer, ColorSpace.get(ColorSpace.Named.SRGB));
            hardwareBuffer.close();
            return;
        }
        Image.Plane[] planes = this.f57430c.getPlanes();
        if (planes.length == 1) {
            Image.Plane plane = planes[0];
            int rowStride = plane.getRowStride() / plane.getPixelStride();
            int height = this.f57430c.getHeight();
            Bitmap bitmap = this.f57431d;
            if (!(bitmap != null && bitmap.getWidth() == rowStride && this.f57431d.getHeight() == height)) {
                this.f57431d = Bitmap.createBitmap(rowStride, height, Bitmap.Config.ARGB_8888);
            }
            ByteBuffer buffer = plane.getBuffer();
            buffer.rewind();
            this.f57431d.copyPixelsFromBuffer(buffer);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!(i == this.f57429b.getWidth() && i2 == this.f57429b.getHeight()) && this.f57433f == SurfaceKind.background && this.f57434g) {
            resizeIfNeeded(i, i2);
            this.f57432e.swapSurface(this.f57429b.getSurface());
        }
    }
}
