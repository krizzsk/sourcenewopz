package com.jumio.commons.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.raven.config.RavenKey;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.sdk.enums.JumioCameraFacing;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import jumio.core.C21386v;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b&\u0018\u0000 b2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001bB!\b\u0004\u0012\u0006\u00103\u001a\u00020.\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u00108\u001a\u00020\f¢\u0006\u0004\b`\u0010aJ \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J \u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\fH&J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H&J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\fH&J\b\u0010\u0018\u001a\u00020\tH&J\b\u0010\u0019\u001a\u00020\tH&J\b\u0010\u001a\u001a\u00020\tH&J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\fH&J\b\u0010\u001d\u001a\u00020\tH&J\b\u0010\u001e\u001a\u00020\tH&J\u0018\u0010#\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0016J\u0006\u0010$\u001a\u00020\tJ\u0010\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010*\u001a\u00020\t2\u0006\u0010)\u001a\u00020(H\u0016J\u0018\u0010-\u001a\u00020\f2\u0006\u0010)\u001a\u00020(2\u0006\u0010,\u001a\u00020+H\u0016R\u001c\u00103\u001a\u00020.8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001c\u00108\u001a\u00020\f8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0016\u0010:\u001a\u0002098\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\f8\u0004@\u0004X\u000e¢\u0006\u0006\n\u0004\bB\u00105R*\u0010E\u001a\u00020\f2\u0006\u0010C\u001a\u00020\f8\u0006@DX\u000e¢\u0006\u0012\n\u0004\bD\u00105\u001a\u0004\bE\u00107\"\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020H8\u0004@\u0004X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010L\u001a\u00020K8\u0004@\u0004X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR*\u0010O\u001a\u00020\f2\u0006\u0010C\u001a\u00020\f8\u0016@TX\u000e¢\u0006\u0012\n\u0004\bN\u00105\u001a\u0004\bO\u00107\"\u0004\bP\u0010GR*\u0010R\u001a\u00020\f2\u0006\u0010C\u001a\u00020\f8\u0016@TX\u000e¢\u0006\u0012\n\u0004\bQ\u00105\u001a\u0004\bR\u00107\"\u0004\bS\u0010GR\u0016\u0010T\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\bT\u00105R\u0016\u0010U\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\bU\u00105R\u0018\u0010V\u001a\u0004\u0018\u0001098\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\bV\u0010;R$\u0010\"\u001a\u0004\u0018\u00010!8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\"\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\\\u00107R\u0016\u0010^\u001a\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b]\u00107R\u0013\u0010_\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b_\u00107¨\u0006c"}, mo175978d2 = {"Lcom/jumio/commons/camera/JumioCameraManager;", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnTouchListener;", "Landroid/graphics/SurfaceTexture;", "surface", "", "width", "height", "", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "frontFacing", "setCameraFacing", "Lcom/jumio/sdk/enums/JumioCameraFacing;", "facing", "x", "y", "requestFocus", "turnFlashOn", "setFlash", "startPreview", "reinitCamera", "addCallbackBuffer", "pause", "stopPreview", "destroy", "changeCamera", "Landroid/view/TextureView;", "textureView", "Ljumio/core/v;", "cameraCallback", "setup", "toggleFlash", "Lcom/jumio/commons/camera/ImageData;", "imageData", "getImageData", "Landroid/view/View;", "v", "onClick", "Landroid/view/MotionEvent;", "event", "onTouch", "Lcom/jumio/commons/utils/DeviceRotationManager;", "a", "Lcom/jumio/commons/utils/DeviceRotationManager;", "getRotationManager", "()Lcom/jumio/commons/utils/DeviceRotationManager;", "rotationManager", "b", "Z", "getEnableFlashOnStart", "()Z", "enableFlashOnStart", "Lcom/jumio/commons/camera/Size;", "previewSize", "Lcom/jumio/commons/camera/Size;", "c", "Landroid/view/TextureView;", "getTextureView", "()Landroid/view/TextureView;", "setTextureView", "(Landroid/view/TextureView;)V", "inPreview", "<set-?>", "e", "isPausePreview", "setPausePreview", "(Z)V", "Lcom/jumio/commons/camera/PreviewProperties;", "previewProperties", "Lcom/jumio/commons/camera/PreviewProperties;", "Ljava/util/concurrent/ExecutorService;", "executorService", "Ljava/util/concurrent/ExecutorService;", "f", "isFrontFacing", "setFrontFacing", "g", "isFlashOn", "setFlashOn", "manualFocusEnabled", "focusing", "requestedSize", "Ljumio/core/v;", "getCameraCallback", "()Ljumio/core/v;", "setCameraCallback", "(Ljumio/core/v;)V", "isFlashSupported", "getHasMultipleCameras", "hasMultipleCameras", "isFocusing", "<init>", "(Lcom/jumio/commons/utils/DeviceRotationManager;ZZ)V", "Companion", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioCameraManager.kt */
public abstract class JumioCameraManager implements TextureView.SurfaceTextureListener, View.OnClickListener, View.OnTouchListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final List<String> FALLBACK_AUTO_FOCUS_LIST = CollectionsKt.listOf("GT-I9100", "SPH-D710", "SGH-T989", "SCH-I605", "SAMSUNG-SGH-I727", "GT-I9100G", "SAMSUNG-SGH-I777", "SPH-D710BST", "GT-I9100P", "GT-I9100T", "SGH-S959G", "SGH-T989D", "SGH-I727R", "GT-I9100M", "SPH-D710VMUB", "SAMSUNG-SGH-T989", "SGH-I757M", "SGH-I777", "GT-I9210", "GT-I9105P", "GT-I9105", "GT-I9105I", "GT-I9105G", "SAMSUNG-SGH-I717", "SGH-T879", "SGH-I717M", "SGH-I717R", "GT-N7000", "GT-N7005", "DROIDX");
    public static final String[] FALLBACK_PREVIEW_FORMAT_LIST = {"Nexus 7"};

    /* renamed from: h */
    public static final String f54543h = "CameraManager";

    /* renamed from: i */
    public static final int f54544i = Camera.getNumberOfCameras();

    /* renamed from: a */
    public final DeviceRotationManager f54545a;

    /* renamed from: b */
    public final boolean f54546b;

    /* renamed from: c */
    public TextureView f54547c;

    /* renamed from: d */
    public C21386v f54548d;

    /* renamed from: e */
    public boolean f54549e;
    public ExecutorService executorService;

    /* renamed from: f */
    public boolean f54550f;
    public boolean focusing;

    /* renamed from: g */
    public boolean f54551g;
    public boolean inPreview;
    public boolean manualFocusEnabled;
    public PreviewProperties previewProperties = new PreviewProperties();
    public Size previewSize = new Size(0, 0);
    public Size requestedSize;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010\u0013J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\"\u0010\u000e\u001a\u00020\r8\u0004@\u0005XD¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0015\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00198\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001c8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, mo175978d2 = {"Lcom/jumio/commons/camera/JumioCameraManager$Companion;", "", "Lcom/jumio/commons/utils/DeviceRotationManager;", "rotationManager", "", "frontFacing", "enableFlashOnStartUp", "Lcom/jumio/commons/camera/JumioCameraManager;", "create", "Landroid/content/Context;", "context", "hasFrontFacingCamera", "hasAutoFocus", "", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "getTAG$annotations", "()V", "", "numberOfCameras", "I", "getNumberOfCameras", "()I", "", "FALLBACK_AUTO_FOCUS_LIST", "Ljava/util/List;", "", "FALLBACK_PREVIEW_FORMAT_LIST", "[Ljava/lang/String;", "<init>", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: JumioCameraManager.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getTAG$annotations() {
        }

        public final JumioCameraManager create(DeviceRotationManager deviceRotationManager, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(deviceRotationManager, "rotationManager");
            return new JumioCameraManagerAPI14(deviceRotationManager, z, z2);
        }

        public final int getNumberOfCameras() {
            return JumioCameraManager.f54544i;
        }

        public final String getTAG() {
            return JumioCameraManager.f54543h;
        }

        public final boolean hasAutoFocus(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getPackageManager().hasSystemFeature("android.hardware.camera.autofocus");
        }

        public final boolean hasFrontFacingCamera(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getPackageManager().hasSystemFeature("android.hardware.camera.front");
        }
    }

    public JumioCameraManager(DeviceRotationManager deviceRotationManager, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(deviceRotationManager, "rotationManager");
        this.f54545a = deviceRotationManager;
        this.f54546b = z2;
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor()");
        this.executorService = newSingleThreadExecutor;
        setCameraFacing(z);
    }

    public static final String getTAG() {
        return Companion.getTAG();
    }

    /* renamed from: a */
    public final void mo162382a() {
        TextureView textureView = this.f54547c;
        int i = 0;
        int width = textureView == null ? 0 : textureView.getWidth();
        TextureView textureView2 = this.f54547c;
        if (textureView2 != null) {
            i = textureView2.getHeight();
        }
        requestFocus(width, i);
    }

    public abstract void addCallbackBuffer();

    public abstract void changeCamera();

    public abstract void destroy();

    public final C21386v getCameraCallback() {
        return this.f54548d;
    }

    public final boolean getEnableFlashOnStart() {
        return this.f54546b;
    }

    public abstract boolean getHasMultipleCameras();

    public void getImageData(ImageData imageData) {
        Intrinsics.checkNotNullParameter(imageData, "imageData");
        imageData.setCameraPosition(isFrontFacing() ? ImageData.CameraPosition.FRONT : ImageData.CameraPosition.BACK);
        imageData.setOrientationMode(this.f54545a.getScreenOrientation());
        imageData.getImageSize().width = this.previewProperties.preview.width;
        imageData.getImageSize().height = this.previewProperties.preview.height;
        imageData.setFlashMode(isFlashOn());
    }

    public final DeviceRotationManager getRotationManager() {
        return this.f54545a;
    }

    public final TextureView getTextureView() {
        return this.f54547c;
    }

    public boolean isFlashOn() {
        return this.f54551g;
    }

    public abstract boolean isFlashSupported();

    public final boolean isFocusing() {
        return this.manualFocusEnabled && this.focusing;
    }

    public boolean isFrontFacing() {
        return this.f54550f;
    }

    public final boolean isPausePreview() {
        return this.f54549e;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        Intrinsics.checkNotNullParameter(view, RavenKey.VERSION);
        mo162382a();
    }

    public abstract void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2);

    public abstract boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture);

    public abstract void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2);

    public abstract void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture);

    public boolean onTouch(View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(view, RavenKey.VERSION);
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (this.f54549e) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            requestFocus(x, y);
        }
        return false;
    }

    public abstract void reinitCamera();

    public abstract void requestFocus(int i, int i2);

    public final void setCameraCallback(C21386v vVar) {
        this.f54548d = vVar;
    }

    public abstract void setCameraFacing(JumioCameraFacing jumioCameraFacing);

    public abstract void setCameraFacing(boolean z);

    public abstract void setFlash(boolean z);

    public void setFlashOn(boolean z) {
        this.f54551g = z;
    }

    public void setFrontFacing(boolean z) {
        this.f54550f = z;
    }

    public final void setPausePreview(boolean z) {
        this.f54549e = z;
    }

    public final void setTextureView(TextureView textureView) {
        this.f54547c = textureView;
    }

    public void setup(TextureView textureView, C21386v vVar) {
        Intrinsics.checkNotNullParameter(textureView, "textureView");
        Intrinsics.checkNotNullParameter(vVar, "cameraCallback");
        textureView.setSurfaceTextureListener(this);
        textureView.setOpaque(false);
        textureView.setOnClickListener(this);
        textureView.setOnTouchListener(this);
        Unit unit = Unit.INSTANCE;
        this.f54547c = textureView;
        this.f54548d = vVar;
    }

    public abstract void startPreview();

    public abstract void stopPreview(boolean z);

    public final void toggleFlash() {
        setFlash(!isFlashOn());
    }
}
