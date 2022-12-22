package com.jumio.sdk.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.didi.passenger.C10448R;
import com.jumio.commons.camera.JumioCameraManager;
import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.core.views.FrameScanView;
import com.jumio.sdk.enums.JumioCameraFacing;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.taxis99.R;
import jumio.core.C21372o0;
import jumio.core.C21381t;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 82\u00020\u0001:\u000289B)\b\u0007\u0012\b\u00102\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\b\b\u0002\u00105\u001a\u00020\n¢\u0006\u0004\b6\u00107J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0017J\b\u0010\u0007\u001a\u00020\u0004H\u0017J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00128V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R$\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c8V@VX\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%R$\u0010,\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020#8V@VX\u000e¢\u0006\f\u001a\u0004\b)\u0010%\"\u0004\b*\u0010+R$\u0010/\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020#8V@VX\u000e¢\u0006\f\u001a\u0004\b-\u0010%\"\u0004\b.\u0010+R\u0016\u00100\u001a\u00020#8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b0\u0010%¨\u0006:"}, mo175978d2 = {"Lcom/jumio/sdk/views/JumioScanView;", "Lcom/jumio/core/views/FrameScanView;", "Lcom/jumio/sdk/scanpart/JumioScanPart;", "scanPart", "", "attach", "resume", "pause", "switchCamera", "takePicture", "", "o", "I", "getMode", "()I", "setMode", "(I)V", "mode", "", "p", "F", "getRatio", "()F", "setRatio", "(F)V", "ratio", "getMinRatio", "minRatio", "Lcom/jumio/sdk/enums/JumioCameraFacing;", "value", "getCameraFacing", "()Lcom/jumio/sdk/enums/JumioCameraFacing;", "setCameraFacing", "(Lcom/jumio/sdk/enums/JumioCameraFacing;)V", "cameraFacing", "", "getHasMultipleCameras", "()Z", "hasMultipleCameras", "getHasFlash", "hasFlash", "getFlash", "setFlash", "(Z)V", "flash", "getExtraction", "setExtraction", "extraction", "isShutterEnabled", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "InterfaceImpl", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioScanView.kt */
public final class JumioScanView extends FrameScanView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MODE_FACE = 1;
    public static final int MODE_ID = 0;

    /* renamed from: o */
    public int f55131o;

    /* renamed from: p */
    public float f55132p;

    /* renamed from: q */
    public int f55133q;

    /* renamed from: r */
    public final InterfaceImpl f55134r;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, mo175978d2 = {"Lcom/jumio/sdk/views/JumioScanView$Companion;", "", "", "MODE_FACE", "I", "MODE_ID", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: JumioScanView.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, mo175978d2 = {"Lcom/jumio/sdk/views/JumioScanView$InterfaceImpl;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "<init>", "(Lcom/jumio/sdk/views/JumioScanView;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: JumioScanView.kt */
    public final class InterfaceImpl implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        public final /* synthetic */ JumioScanView f55135a;

        public InterfaceImpl(JumioScanView jumioScanView) {
            Intrinsics.checkNotNullParameter(jumioScanView, "this$0");
            this.f55135a = jumioScanView;
        }

        public void onGlobalLayout() {
            C21381t access$getScanOverlayView;
            TextureView access$getTextureView = this.f55135a.getTextureView();
            if (access$getTextureView != null) {
                JumioScanView jumioScanView = this.f55135a;
                if (!(access$getTextureView.getHeight() == jumioScanView.getOldHeight() || access$getTextureView.getWidth() == jumioScanView.getOldWidth() || (access$getScanOverlayView = jumioScanView.getScanOverlayView()) == null)) {
                    access$getScanOverlayView.requestLayout();
                }
                jumioScanView.setOldWidth(access$getTextureView.getWidth());
                jumioScanView.setOldHeight(access$getTextureView.getHeight());
            }
        }
    }

    public JumioScanView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public JumioScanView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JumioScanView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* renamed from: a */
    public final LinearLayout mo163660a() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        boolean z = true;
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int roundToInt = MathKt.roundToInt(ScreenUtil.dipToPx(getContext(), 20.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        int i = this.f55133q;
        if (i <= roundToInt || i >= getMeasuredHeight() - (roundToInt * 2)) {
            layoutParams.topMargin = roundToInt;
        } else {
            layoutParams.topMargin = this.f55133q;
        }
        int i2 = 0;
        linearLayout.setPadding(roundToInt, 0, roundToInt, 0);
        linearLayout.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setAdjustViewBounds(true);
        Resources resources = getResources();
        Context context = getContext();
        imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.ic_powered_by_jumio, context == null ? null : context.getTheme()));
        C21372o0 scanViewInterface = getScanViewInterface();
        if (scanViewInterface == null || !scanViewInterface.mo163124h()) {
            z = false;
        }
        if (!z) {
            i2 = 4;
        }
        imageView.setVisibility(i2);
        linearLayout.addView(imageView);
        return linearLayout;
    }

    public void attach(JumioScanPart jumioScanPart) {
        JumioCameraManager cameraManager$jumio_core_release;
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        Intrinsics.checkNotNullParameter(jumioScanPart, "scanPart");
        super.attach(jumioScanPart);
        TextureView textureView = getTextureView();
        if (!(textureView == null || (viewTreeObserver2 = textureView.getViewTreeObserver()) == null)) {
            viewTreeObserver2.removeOnGlobalLayoutListener(this.f55134r);
        }
        removeAllViews();
        setTextureView(new TextureView(getContext()));
        TextureView textureView2 = getTextureView();
        if (textureView2 != null) {
            textureView2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        boolean z = false;
        addView(getTextureView(), 0);
        TextureView textureView3 = getTextureView();
        if (!(textureView3 == null || (viewTreeObserver = textureView3.getViewTreeObserver()) == null)) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f55134r);
        }
        setScanOverlayView(new C21381t(getContext()));
        C21381t scanOverlayView = getScanOverlayView();
        if (scanOverlayView != null) {
            scanOverlayView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        C21381t scanOverlayView2 = getScanOverlayView();
        if (scanOverlayView2 != null) {
            scanOverlayView2.setDrawViewInterface(getDrawViewInterface());
        }
        addView(getScanOverlayView());
        addView(mo163660a());
        invalidate();
        TextureView textureView4 = getTextureView();
        if (textureView4 != null) {
            textureView4.setVisibility(0);
        }
        if (getCameraManager$jumio_core_release() == null) {
            JumioCameraManager.Companion companion = JumioCameraManager.Companion;
            DeviceRotationManager rotationManager = jumioScanPart.getScanPart$jumio_core_release().getController().getRotationManager();
            if (getCameraFacing() == JumioCameraFacing.FRONT) {
                z = true;
            }
            setCameraManager$jumio_core_release(companion.create(rotationManager, z, getFlash()));
            JumioCameraManager cameraManager$jumio_core_release2 = getCameraManager$jumio_core_release();
            if (cameraManager$jumio_core_release2 != null) {
                C21372o0 scanViewInterface = getScanViewInterface();
                cameraManager$jumio_core_release2.requestedSize = scanViewInterface == null ? null : scanViewInterface.mo163114b();
            }
        } else {
            JumioCameraManager cameraManager$jumio_core_release3 = getCameraManager$jumio_core_release();
            if (cameraManager$jumio_core_release3 != null) {
                cameraManager$jumio_core_release3.startPreview();
            }
        }
        TextureView textureView5 = getTextureView();
        if (textureView5 != null && (cameraManager$jumio_core_release = getCameraManager$jumio_core_release()) != null) {
            cameraManager$jumio_core_release.setup(textureView5, getCameraInterface());
        }
    }

    public JumioCameraFacing getCameraFacing() {
        return super.getCameraFacing();
    }

    public boolean getExtraction() {
        return super.getExtraction();
    }

    public boolean getFlash() {
        return super.getFlash();
    }

    public boolean getHasFlash() {
        return super.getHasFlash();
    }

    public boolean getHasMultipleCameras() {
        return super.getHasMultipleCameras();
    }

    public float getMinRatio() {
        return this.f55131o == 0 ? 1.33f : 1.0f;
    }

    public final int getMode() {
        return this.f55131o;
    }

    public float getRatio() {
        return this.f55132p;
    }

    public boolean isShutterEnabled() {
        return super.isShutterEnabled();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void pause() {
        super.pause();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void resume() {
        super.resume();
    }

    public void setCameraFacing(JumioCameraFacing jumioCameraFacing) {
        Intrinsics.checkNotNullParameter(jumioCameraFacing, "value");
        super.setCameraFacing(jumioCameraFacing);
    }

    public void setExtraction(boolean z) {
        super.setExtraction(z);
    }

    public void setFlash(boolean z) {
        super.setFlash(z);
    }

    public final void setMode(int i) {
        this.f55131o = i;
    }

    public void setRatio(float f) {
        this.f55132p = f;
    }

    public void switchCamera() {
        super.switchCamera();
    }

    public void takePicture() {
        super.takePicture();
    }

    public JumioScanView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArray;
        int i2;
        this.f55132p = getMinRatio();
        this.f55134r = new InterfaceImpl(this);
        Float f = null;
        int i3 = 0;
        if (context == null) {
            typedArray = null;
        } else {
            typedArray = context.obtainStyledAttributes(attributeSet, C10448R.styleable.JumioScanView, 0, 0);
        }
        if (typedArray == null) {
            i2 = 0;
        } else {
            try {
                i2 = typedArray.getInt(1, 0);
            } catch (Throwable th) {
                if (typedArray != null) {
                    typedArray.recycle();
                }
                throw th;
            }
        }
        this.f55131o = i2;
        if (typedArray != null) {
            f = Float.valueOf(typedArray.getFloat(2, getMinRatio()));
        }
        setRatio(f == null ? getMinRatio() : f.floatValue());
        if (typedArray != null) {
            i3 = typedArray.getDimensionPixelSize(0, 0);
        }
        this.f55133q = i3;
        if (typedArray != null) {
            typedArray.recycle();
        }
    }
}
