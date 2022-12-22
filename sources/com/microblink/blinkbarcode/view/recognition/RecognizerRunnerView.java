package com.microblink.blinkbarcode.view.recognition;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.appsflyer.internal.referrer.Payload;
import com.didi.sdk.apm.SystemUtils;
import com.microblink.blinkbarcode.entities.recognizers.Recognizer;
import com.microblink.blinkbarcode.entities.recognizers.RecognizerBundle;
import com.microblink.blinkbarcode.geometry.Rectangle;
import com.microblink.blinkbarcode.hardware.MicroblinkDeviceManager;
import com.microblink.blinkbarcode.hardware.accelerometer.ShakeCallback;
import com.microblink.blinkbarcode.hardware.camera.AutoFocusRequiredButNotSupportedException;
import com.microblink.blinkbarcode.hardware.camera.CameraType;
import com.microblink.blinkbarcode.hardware.orientation.Orientation;
import com.microblink.blinkbarcode.hardware.orientation.OrientationChangeListener;
import com.microblink.blinkbarcode.image.highres.HighResImageWrapper;
import com.microblink.blinkbarcode.licence.exception.InvalidLicenceKeyException;
import com.microblink.blinkbarcode.metadata.MetadataCallbacks;
import com.microblink.blinkbarcode.recognition.FeatureNotSupportedException;
import com.microblink.blinkbarcode.recognition.NativeRecognizerWrapper;
import com.microblink.blinkbarcode.recognition.RecognitionSuccessType;
import com.microblink.blinkbarcode.recognition.Right;
import com.microblink.blinkbarcode.recognition.RightsManager;
import com.microblink.blinkbarcode.recognition.callback.RecognitionProcessCallback;
import com.microblink.blinkbarcode.secured.lIllllIlll;
import com.microblink.blinkbarcode.secured.llIIlllIll;
import com.microblink.blinkbarcode.secured.llIlllIIIl;
import com.microblink.blinkbarcode.secured.llllllIllI;
import com.microblink.blinkbarcode.util.Log;
import com.microblink.blinkbarcode.view.BaseCameraView;
import com.microblink.blinkbarcode.view.CameraEventsListener;
import com.microblink.blinkbarcode.view.CameraViewGroup;
import com.microblink.blinkbarcode.view.NotSupportedReason;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: line */
public final class RecognizerRunnerView extends CameraViewGroup implements LifecycleObserver {
    private final com.microblink.blinkbarcode.recognition.llIIlIlIIl IIIlIIlIll;
    private AtomicInteger IIIllIIlIl;
    private ScanResultListener IIIlllIlII;
    /* access modifiers changed from: private */
    public RecognitionProcessCallback IIlIIlIllI;
    /* access modifiers changed from: private */
    public AtomicBoolean IIllIIllll;
    private final BaseCameraView.BaseCameraListener IIllIllIII;
    /* access modifiers changed from: private */
    public Rectangle IIllllIIlI;
    /* access modifiers changed from: private */
    public Rectangle IlIIlllIll;
    /* access modifiers changed from: private */
    public NativeRecognizerWrapper IllIllIllI;
    private MetadataCallbacks IlllIlllll;
    /* access modifiers changed from: private */
    public boolean IlllllIIIl;
    /* access modifiers changed from: private */
    public View lIIIIIllIl;
    /* access modifiers changed from: private */
    public AtomicBoolean lIIlllIIlI;
    private NotSupportedReason lIlIIIlIll;
    /* access modifiers changed from: private */
    public AtomicBoolean lIlIllIIlI;
    /* access modifiers changed from: private */
    public HighResImageListener lIlIllIIll;
    /* access modifiers changed from: private */
    public AtomicReference<llIIlllIll> lIllIlIlIl;
    /* access modifiers changed from: private */
    public FrameRecognitionCallback llIIllIlII;
    /* access modifiers changed from: private */
    public final llIIlIIlll llIIlllIll;
    /* access modifiers changed from: private */
    public long llIllllIIl;
    /* access modifiers changed from: private */
    public RecognizerBundle lllIIIllII;
    private MicroblinkDeviceManager llllIllllI;
    private final BaseCameraView.BaseOrientationChangeListener llllllllll;

    /* compiled from: line */
    public class IlIllIlIIl implements Runnable {
        public IlIllIlIIl() {
        }

        public void run() {
            RecognizerRunnerView.this.lIIIIIllIl.setVisibility(8);
        }
    }

    /* compiled from: line */
    public class IllIIIIllI extends BaseCameraView.BaseCameraListener {
        private long IlIllIlIIl = -1;

        public IllIIIIllI() {
            super();
        }

        public boolean canReceiveFrame() {
            RecognizerRunnerView recognizerRunnerView = RecognizerRunnerView.this;
            Log.m40233v(recognizerRunnerView, "Recognition paused: {}, Analyzing frame: {}, Camera view state: {}", Boolean.valueOf(recognizerRunnerView.IIllIIllll.get()), Boolean.valueOf(RecognizerRunnerView.this.lIIlllIIlI.get()), RecognizerRunnerView.this.llIIIlllll);
            if (RecognizerRunnerView.this.IIllIIllll.get() || RecognizerRunnerView.this.lIIlllIIlI.get() || RecognizerRunnerView.this.llIIIlllll != BaseCameraView.CameraViewState.RESUMED) {
                return false;
            }
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:53:0x01ed, code lost:
            if (com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.IllIIIIllI(r11.IllIIIllII).compareAndSet((java.lang.Object) null, r12) != false) goto L_0x0212;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0210, code lost:
            if (com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.IllIIIIllI(r11.IllIIIllII).compareAndSet((java.lang.Object) null, r12) != false) goto L_0x0212;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onCameraFrame(com.microblink.blinkbarcode.secured.llIIlllIll r12) {
            /*
                r11 = this;
                long r0 = r11.IlIllIlIIl
                r2 = -1
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 != 0) goto L_0x000e
                long r0 = java.lang.System.currentTimeMillis()
                r11.IlIllIlIIl = r0
            L_0x000e:
                boolean r0 = r12 instanceof com.microblink.blinkbarcode.secured.IlllIIIllI
                if (r0 == 0) goto L_0x008a
                com.microblink.blinkbarcode.secured.IlIIlIIIII r2 = new com.microblink.blinkbarcode.secured.IlIIlIIIII
                com.microblink.blinkbarcode.secured.IlllIIIllI r12 = (com.microblink.blinkbarcode.secured.IlllIIIllI) r12
                r2.<init>(r12)
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                android.graphics.RectF r0 = r12.getVisiblePart()
                android.graphics.RectF r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.llIIlIlIIl((com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView) r12, (android.graphics.RectF) r0)
                r2.llIIlIlIIl((android.graphics.RectF) r12)
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.hardware.orientation.Orientation r12 = r12.getOrientationForRecognition()
                r2.llIIlIlIIl((com.microblink.blinkbarcode.hardware.orientation.Orientation) r12)
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                long r0 = r12.llIllllIIl
                boolean r12 = r2.llIIlIlIIl((long) r0)
                if (r12 == 0) goto L_0x0085
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                boolean r12 = r12.isCameraActive()
                if (r12 == 0) goto L_0x0085
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                boolean r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.llIIlIlIIl((com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView) r12)
                if (r12 != 0) goto L_0x0085
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.recognition.NativeRecognizerWrapper r12 = r12.IllIllIllI
                if (r12 == 0) goto L_0x0085
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.recognition.NativeRecognizerWrapper r12 = r12.IllIllIllI
                com.microblink.blinkbarcode.recognition.IllIIIllII r12 = r12.IlIllIlIIl()
                com.microblink.blinkbarcode.recognition.IllIIIllII r0 = com.microblink.blinkbarcode.recognition.IllIIIllII.READY
                if (r12 != r0) goto L_0x0085
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.recognition.NativeRecognizerWrapper r1 = r12.IllIllIllI
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.entities.recognizers.RecognizerBundle r3 = r12.lllIIIllII
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.recognition.callback.RecognitionProcessCallback r4 = r12.IIlIIlIllI
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView$llIIlIIlll r5 = r12.llIIlllIll
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView$llIIlIIlll r6 = r12.llIIlllIll
                r7 = 0
                r1.llIIlIlIIl(r2, r3, r4, r5, r6, r7)
                goto L_0x02c9
            L_0x0085:
                r2.IllIIIllII()
                goto L_0x02c9
            L_0x008a:
                int r0 = com.microblink.blinkbarcode.hardware.IllIIIllII.IlIllIlllI()
                java.lang.String r1 = "Sending frame id {} to recognition"
                r2 = 1
                r3 = 0
                if (r0 != r2) goto L_0x011b
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r0 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                boolean r0 = r0.isCameraActive()
                if (r0 == 0) goto L_0x0116
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r0 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                boolean r0 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.llIIlIlIIl((com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView) r0)
                if (r0 != 0) goto L_0x0116
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r0 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.recognition.NativeRecognizerWrapper r0 = r0.IllIllIllI
                if (r0 == 0) goto L_0x0116
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r0 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.recognition.NativeRecognizerWrapper r0 = r0.IllIllIllI
                com.microblink.blinkbarcode.recognition.IllIIIllII r0 = r0.IlIllIlIIl()
                com.microblink.blinkbarcode.recognition.IllIIIllII r4 = com.microblink.blinkbarcode.recognition.IllIIIllII.READY
                if (r0 != r4) goto L_0x0116
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r0 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                android.graphics.RectF r4 = r0.getVisiblePart()
                android.graphics.RectF r0 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.llIIlIlIIl((com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView) r0, (android.graphics.RectF) r4)
                r12.llIIlIlIIl((android.graphics.RectF) r0)
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r0 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.hardware.orientation.Orientation r0 = r0.getOrientationForRecognition()
                r12.llIIlIlIIl((com.microblink.blinkbarcode.hardware.orientation.Orientation) r0)
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r0 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                long r4 = r0.llIllllIIl
                boolean r0 = r12.llIIlIlIIl((long) r4)
                if (r0 != 0) goto L_0x00e0
                r12.IllIIIllII()
                return
            L_0x00e0:
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r0 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                java.lang.Object[] r2 = new java.lang.Object[r2]
                long r4 = r12.lIlIIIIlIl()
                java.lang.Long r4 = java.lang.Long.valueOf(r4)
                r2[r3] = r4
                com.microblink.blinkbarcode.util.Log.m40233v(r0, r1, r2)
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r0 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.recognition.NativeRecognizerWrapper r1 = r0.IllIllIllI
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r0 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.entities.recognizers.RecognizerBundle r3 = r0.lllIIIllII
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r0 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.recognition.callback.RecognitionProcessCallback r4 = r0.IIlIIlIllI
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r0 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView$llIIlIIlll r5 = r0.llIIlllIll
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r0 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView$llIIlIIlll r6 = r0.llIIlllIll
                r7 = 0
                r2 = r12
                r1.llIIlIlIIl(r2, r3, r4, r5, r6, r7)
                goto L_0x02c9
            L_0x0116:
                r12.IllIIIllII()
                goto L_0x02c9
            L_0x011b:
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r0 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.lIIlllIIlI
                boolean r0 = r0.compareAndSet(r3, r2)
                if (r0 != 0) goto L_0x0132
                java.lang.Object[] r0 = new java.lang.Object[r3]
                java.lang.String r1 = "Frame analysis already in progress. Will skip it"
                com.microblink.blinkbarcode.util.Log.m40231i(r11, r1, r0)
                r12.IllIIIllII()
                return
            L_0x0132:
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r0 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                android.graphics.RectF r4 = r0.getVisiblePart()
                android.graphics.RectF r0 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.llIIlIlIIl((com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView) r0, (android.graphics.RectF) r4)
                r12.llIIlIlIIl((android.graphics.RectF) r0)
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r0 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.hardware.orientation.Orientation r0 = r0.getOrientationForRecognition()
                r12.llIIlIlIIl((com.microblink.blinkbarcode.hardware.orientation.Orientation) r0)
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r0 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                long r4 = r0.llIllllIIl
                boolean r0 = r12.llIIlIlIIl((long) r4)
                if (r0 != 0) goto L_0x0161
                r12.IllIIIllII()
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                java.util.concurrent.atomic.AtomicBoolean r12 = r12.lIIlllIIlI
                r12.set(r3)
                return
            L_0x0161:
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r0 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                java.lang.Object[] r4 = new java.lang.Object[r2]
                long r5 = r12.lIlIIIIlIl()
                java.lang.Long r5 = java.lang.Long.valueOf(r5)
                r4[r3] = r5
                java.lang.String r5 = "Calculating quality of frame id {}"
                com.microblink.blinkbarcode.util.Log.m40233v(r0, r5, r4)
                double r4 = r12.IllIIIIllI()
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r0 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                r6 = 2
                java.lang.Object[] r6 = new java.lang.Object[r6]
                long r7 = r12.lIlIIIIlIl()
                java.lang.Long r7 = java.lang.Long.valueOf(r7)
                r6[r3] = r7
                java.lang.Double r7 = java.lang.Double.valueOf(r4)
                r6[r2] = r7
                java.lang.String r7 = "Finished quality calculation of frame id {}, quality is {}"
                com.microblink.blinkbarcode.util.Log.m40233v(r0, r7, r6)
                r6 = 0
                r0 = 0
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 >= 0) goto L_0x01a7
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r4 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                java.util.concurrent.atomic.AtomicReference r4 = r4.lIllIlIlIl
                java.lang.Object r12 = r4.getAndSet(r12)
                com.microblink.blinkbarcode.secured.llIIlllIll r12 = (com.microblink.blinkbarcode.secured.llIIlllIll) r12
                goto L_0x0213
            L_0x01a7:
                r6 = 4624633867356078080(0x402e000000000000, double:15.0)
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 <= 0) goto L_0x01b4
                long r6 = java.lang.System.currentTimeMillis()
                r11.IlIllIlIIl = r6
                goto L_0x01d5
            L_0x01b4:
                long r6 = java.lang.System.currentTimeMillis()
                long r8 = r11.IlIllIlIIl
                long r6 = r6 - r8
                r8 = 1500(0x5dc, double:7.41E-321)
                int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r10 <= 0) goto L_0x01d5
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r6 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                java.lang.Object[] r7 = new java.lang.Object[r3]
                java.lang.String r8 = "No good quality frame for more than 1.5 sec. Requesting autofocus"
                com.microblink.blinkbarcode.util.Log.m40235w(r6, r8, r7)
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r6 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                r6.focusCamera()
                long r6 = java.lang.System.currentTimeMillis()
                r11.IlIllIlIIl = r6
            L_0x01d5:
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r6 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                java.util.concurrent.atomic.AtomicReference r6 = r6.lIllIlIlIl
                java.lang.Object r6 = r6.get()
                com.microblink.blinkbarcode.secured.llIIlllIll r6 = (com.microblink.blinkbarcode.secured.llIIlllIll) r6
                if (r6 != 0) goto L_0x01f0
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r4 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                java.util.concurrent.atomic.AtomicReference r4 = r4.lIllIlIlIl
                boolean r4 = r4.compareAndSet(r0, r12)
                if (r4 == 0) goto L_0x0213
                goto L_0x0212
            L_0x01f0:
                double r7 = r6.IllIIIIllI()
                int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
                if (r9 < 0) goto L_0x0213
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r4 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                java.util.concurrent.atomic.AtomicReference r4 = r4.lIllIlIlIl
                boolean r4 = r4.compareAndSet(r6, r12)
                if (r4 == 0) goto L_0x0206
                r12 = r6
                goto L_0x0213
            L_0x0206:
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r4 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                java.util.concurrent.atomic.AtomicReference r4 = r4.lIllIlIlIl
                boolean r4 = r4.compareAndSet(r0, r12)
                if (r4 == 0) goto L_0x0213
            L_0x0212:
                r12 = r0
            L_0x0213:
                if (r12 == 0) goto L_0x0218
                r12.IllIIIllII()
            L_0x0218:
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.recognition.NativeRecognizerWrapper r12 = r12.IllIllIllI
                if (r12 == 0) goto L_0x0234
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                java.lang.Object[] r4 = new java.lang.Object[r2]
                com.microblink.blinkbarcode.recognition.NativeRecognizerWrapper r5 = r12.IllIllIllI
                com.microblink.blinkbarcode.recognition.IllIIIllII r5 = r5.IlIllIlIIl()
                r4[r3] = r5
                java.lang.String r5 = "RecognizerRunner state is {}"
                com.microblink.blinkbarcode.util.Log.m40233v(r12, r5, r4)
                goto L_0x023d
            L_0x0234:
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                java.lang.Object[] r4 = new java.lang.Object[r3]
                java.lang.String r5 = "RecognizerRunner is null"
                com.microblink.blinkbarcode.util.Log.m40233v(r12, r5, r4)
            L_0x023d:
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                boolean r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.llIIlIlIIl((com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView) r12)
                if (r12 != 0) goto L_0x02a6
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                boolean r12 = r12.isCameraActive()
                if (r12 == 0) goto L_0x02c0
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.recognition.NativeRecognizerWrapper r12 = r12.IllIllIllI
                if (r12 == 0) goto L_0x02c0
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.recognition.NativeRecognizerWrapper r12 = r12.IllIllIllI
                com.microblink.blinkbarcode.recognition.IllIIIllII r12 = r12.IlIllIlIIl()
                com.microblink.blinkbarcode.recognition.IllIIIllII r4 = com.microblink.blinkbarcode.recognition.IllIIIllII.READY
                if (r12 != r4) goto L_0x02c0
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                java.util.concurrent.atomic.AtomicReference r12 = r12.lIllIlIlIl
                java.lang.Object r12 = r12.getAndSet(r0)
                r5 = r12
                com.microblink.blinkbarcode.secured.llIIlllIll r5 = (com.microblink.blinkbarcode.secured.llIIlllIll) r5
                if (r5 == 0) goto L_0x02c0
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                java.lang.Object[] r0 = new java.lang.Object[r2]
                long r6 = r5.lIlIIIIlIl()
                java.lang.Long r2 = java.lang.Long.valueOf(r6)
                r0[r3] = r2
                com.microblink.blinkbarcode.util.Log.m40233v(r12, r1, r0)
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.recognition.NativeRecognizerWrapper r4 = r12.IllIllIllI
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.entities.recognizers.RecognizerBundle r6 = r12.lllIIIllII
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.recognition.callback.RecognitionProcessCallback r7 = r12.IIlIIlIllI
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView$llIIlIIlll r8 = r12.llIIlllIll
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView$llIIlIIlll r9 = r12.llIIlllIll
                r10 = 0
                r4.llIIlIlIIl(r5, r6, r7, r8, r9, r10)
                goto L_0x02c0
            L_0x02a6:
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                java.lang.Object[] r1 = new java.lang.Object[r3]
                java.lang.String r2 = "Recognition is paused. Invalidating best frame"
                com.microblink.blinkbarcode.util.Log.m40227d(r12, r2, r1)
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                java.util.concurrent.atomic.AtomicReference r12 = r12.lIllIlIlIl
                java.lang.Object r12 = r12.getAndSet(r0)
                com.microblink.blinkbarcode.secured.llIIlllIll r12 = (com.microblink.blinkbarcode.secured.llIIlllIll) r12
                if (r12 == 0) goto L_0x02c0
                r12.IllIIIllII()
            L_0x02c0:
                com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r12 = com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.this
                java.util.concurrent.atomic.AtomicBoolean r12 = r12.lIIlllIIlI
                r12.set(r3)
            L_0x02c9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.IllIIIIllI.onCameraFrame(com.microblink.blinkbarcode.secured.llIIlllIll):void");
        }

        public void onHighResFrame(llIIlllIll lliilllill) {
            if (RecognizerRunnerView.this.lIlIllIIll != null) {
                RecognizerRunnerView.this.lIlIllIIll.onHighResImageAvailable(HighResImageWrapper.Factory.createFromFrame(lliilllill, RecognizerRunnerView.this.getOrientationForRecognition()));
            }
        }
    }

    /* compiled from: line */
    public class IllIIIllII implements Runnable {
        public IllIIIllII() {
        }

        public void run() {
            RecognizerRunnerView.this.lIIIIIllIl.setVisibility(0);
        }
    }

    /* compiled from: line */
    public class lIlIIIIlIl extends CameraViewGroup.CameraViewGroupOrientationChangeListener {
        public lIlIIIIlIl() {
            super();
        }

        public final void onOrientationChange(Orientation orientation) {
            super.onOrientationChange(orientation);
            if (RecognizerRunnerView.this.IllIllIllI != null && orientation != Orientation.ORIENTATION_UNKNOWN && RecognizerRunnerView.this.llIIlIlIIl(orientation) && RecognizerRunnerView.this.IlllllIIIl && RecognizerRunnerView.this.IlIIlllIll != null) {
                RecognizerRunnerView.this.IlIllIlIIl(orientation);
                RecognizerRunnerView.this.IIlIIlIllI.setScanningRegion(RecognizerRunnerView.this.IIllllIIlI);
            }
        }
    }

    /* compiled from: line */
    public class llIIIlllll implements com.microblink.blinkbarcode.recognition.llIIlIlIIl {
        public llIIIlllll() {
        }

        public RecognizerBundle IlIllIlIIl() {
            return RecognizerRunnerView.this.lllIIIllII;
        }

        public RecognitionProcessCallback IllIIIIllI() {
            return RecognizerRunnerView.this.IIlIIlIllI;
        }

        public NativeRecognizerWrapper.lllIIIlIlI IllIIIllII() {
            return RecognizerRunnerView.this.llIIlllIll;
        }

        public NativeRecognizerWrapper.lllIlIlIIl llIIIlllll() {
            return RecognizerRunnerView.this.llIIlllIll;
        }

        public llIIlllIll llIIlIlIIl() {
            if (RecognizerRunnerView.this.IIllIIllll.get()) {
                return null;
            }
            return (llIIlllIll) RecognizerRunnerView.this.lIllIlIlIl.getAndSet((Object) null);
        }
    }

    /* compiled from: line */
    public class llIIlIIlll implements NativeRecognizerWrapper.lllIIIlIlI, NativeRecognizerWrapper.lllIlIlIIl, com.microblink.blinkbarcode.recognition.callback.llIIlIlIIl {

        /* compiled from: line */
        public class IlIllIlIIl implements Runnable {
            public final /* synthetic */ String llIIlIlIIl;

            public IlIllIlIIl(String str) {
                this.llIIlIlIIl = str;
            }

            public void run() {
                RecognizerRunnerView.llIIlIlIIl(RecognizerRunnerView.this, this.llIIlIlIIl);
            }
        }

        /* compiled from: line */
        public class llIIlIlIIl implements Runnable {
            public final /* synthetic */ Throwable llIIlIlIIl;

            public llIIlIlIIl(Throwable th) {
                this.llIIlIlIIl = th;
            }

            public void run() {
                RecognizerRunnerView.this.llIIlIlIIl.onError(this.llIIlIlIIl);
            }
        }

        private llIIlIIlll() {
        }

        public void onLicenseInformation(String str) {
            RecognizerRunnerView.this.lIlIllIIlI.set(true);
            RecognizerRunnerView.this.llIIlIlIIl((Runnable) new IlIllIlIIl(str));
        }

        public void onRecognitionDone(RecognitionSuccessType recognitionSuccessType) {
            if (!RecognizerRunnerView.this.lIlIllIIlI.get()) {
                Log.m40233v(RecognizerRunnerView.this, "recognition done", new Object[0]);
                boolean z = recognitionSuccessType == RecognitionSuccessType.PARTIAL;
                RecognizerRunnerView recognizerRunnerView = RecognizerRunnerView.this;
                Log.m40233v(recognizerRunnerView, "Is camera active: {}, Should start timer: {}", Boolean.valueOf(recognizerRunnerView.isCameraActive()), Boolean.valueOf(z));
                if (!RecognizerRunnerView.this.isCameraActive() || !z) {
                    RecognizerRunnerView.lIllIIlIIl(RecognizerRunnerView.this);
                } else {
                    RecognizerRunnerView recognizerRunnerView2 = RecognizerRunnerView.this;
                    recognizerRunnerView2.setRecognitionTimeout(recognizerRunnerView2.lllIIIllII.getNumMsBeforeTimeout());
                }
                if (RecognizerRunnerView.this.llIIllIlII != null) {
                    RecognizerRunnerView.this.llIIllIlII.onFrameRecognitionDone(recognitionSuccessType);
                }
                if (RecognizerRunnerView.this.lllIIIllII.getRecognitionDebugMode() != RecognizerBundle.RecognitionDebugMode.RECOGNITION) {
                    RecognizerRunnerView.this.llIIlIlIIl(true);
                    RecognizerRunnerView.this.IlIlllllII();
                } else if (recognitionSuccessType == RecognitionSuccessType.SUCCESSFUL) {
                    RecognizerRunnerView.llIIlIlIIl(RecognizerRunnerView.this, recognitionSuccessType);
                } else {
                    RecognizerRunnerView.this.IlIlllllII();
                }
            }
        }

        public void onRecognitionDoneWithTimeout(RecognitionSuccessType recognitionSuccessType) {
            if (!RecognizerRunnerView.this.lIlIllIIlI.get()) {
                Log.m40227d(RecognizerRunnerView.this, "recognition done with timeout", new Object[0]);
                if (RecognizerRunnerView.this.lllIIIllII.getRecognitionDebugMode() == RecognizerBundle.RecognitionDebugMode.RECOGNITION) {
                    RecognizerRunnerView.llIIlIlIIl(RecognizerRunnerView.this, recognitionSuccessType);
                    return;
                }
                RecognizerRunnerView.this.llIIlIlIIl(true);
                RecognizerRunnerView.this.IlIlllllII();
            }
        }

        public void onRecognizerError(Throwable th) {
            RecognizerRunnerView.this.llIIlIlIIl((Runnable) new llIIlIlIIl(th));
        }

        public /* synthetic */ llIIlIIlll(RecognizerRunnerView recognizerRunnerView, llIIlIlIIl lliililiil) {
            this();
        }
    }

    /* compiled from: line */
    public class llIIlIlIIl implements ShakeCallback {
        public llIIlIlIIl() {
        }

        public void onShakingStarted() {
        }

        public void onShakingStopped() {
            if (!RecognizerRunnerView.llIIlIlIIl(RecognizerRunnerView.this)) {
                RecognizerRunnerView.this.llIIlIlIIl(false);
            }
        }
    }

    static {
        com.microblink.blinkbarcode.recognition.IlIllIlIIl.IllIIIllII();
    }

    public RecognizerRunnerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lIlIIIlIll = null;
        this.IllIllIllI = null;
        this.IlIIlllIll = new Rectangle(0.0f, 0.0f, 1.0f, 1.0f);
        this.IIllllIIlI = new Rectangle(0.0f, 0.0f, 1.0f, 1.0f);
        this.IlllllIIIl = false;
        this.IIllIIllll = new AtomicBoolean(true);
        this.lIlIllIIlI = new AtomicBoolean(false);
        this.IlllIlllll = new MetadataCallbacks();
        this.lIllIlIlIl = new AtomicReference<>((Object) null);
        this.lIIlllIIlI = new AtomicBoolean(false);
        this.IIIllIIlIl = new AtomicInteger(0);
        this.llIllllIIl = 0;
        this.llIIlllIll = new llIIlIIlll(this, (llIIlIlIIl) null);
        this.IIIlIIlIll = new llIIIlllll();
        this.IIllIllIII = new IllIIIIllI();
        this.llllllllll = new lIlIIIIlIl();
        this.lIIIIIllIl = new llllllIllI(context, (AttributeSet) null);
        IlIllIlIIl(context);
    }

    /* access modifiers changed from: private */
    public Orientation getOrientationForRecognition() {
        Orientation currentOrientation = getCurrentOrientation();
        if (currentOrientation == null || currentOrientation == Orientation.ORIENTATION_UNKNOWN) {
            currentOrientation = getInitialOrientation();
        }
        if (llIIlIlIIl()) {
            currentOrientation = currentOrientation.rotate180();
        }
        Log.m40227d(this, "Current orientation for recognition: {}", currentOrientation);
        return currentOrientation;
    }

    private static native long initializeNativeFrameSupport(long[] jArr, int i, int i2, double d);

    public static void lIllIIlIIl(RecognizerRunnerView recognizerRunnerView) {
        recognizerRunnerView.IllIllIllI.llIIlIlIIl();
    }

    public static RectF llIIlIlIIl(RecognizerRunnerView recognizerRunnerView, RectF rectF) {
        recognizerRunnerView.getClass();
        float x = rectF.left + (recognizerRunnerView.IIllllIIlI.getX() * rectF.width());
        float y = rectF.top + (recognizerRunnerView.IIllllIIlI.getY() * rectF.height());
        RectF rectF2 = new RectF(x, y, (recognizerRunnerView.IIllllIIlI.getWidth() * rectF.width()) + x, (recognizerRunnerView.IIllllIIlI.getHeight() * rectF.height()) + y);
        Log.m40233v(recognizerRunnerView, "From visible {} and scanning region {}, calculated absolute region is {}", rectF, recognizerRunnerView.IIllllIIlI, rectF2);
        return rectF2;
    }

    /* access modifiers changed from: private */
    public void setRecognitionTimeout(int i) {
        this.IllIllIllI.llIIlIlIIl(i);
    }

    private static native void terminateNativeFrameSupport(long j);

    private static native void updateNativeFrameSupport(long j, long[] jArr, int i, int i2);

    public void IIlIIIllIl() {
    }

    public void captureHighResImage(HighResImageListener highResImageListener) {
        this.lIlIllIIll = highResImageListener;
        IllIIIllII();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void create() {
        if (this.llIIIlllll == BaseCameraView.CameraViewState.DESTROYED) {
            com.microblink.blinkbarcode.recognition.IlIllIlIIl.llIIlIlIIl();
            this.llIllllIIl = initializeNativeFrameSupport(NativeRecognizerWrapper.llIIlIlIIl(this.lllIIIllII.getRecognizers()), this.lllIIIllII.getFrameQualityEstimationMode().ordinal(), com.microblink.blinkbarcode.hardware.IllIIIllII.IlIllIlllI(), this.llllIllllI.IlIllIlIIl());
            this.IIlIIlIllI = new RecognitionProcessCallback(this.llIIlllIll, this.IlllIlllll, this.IIllllIIlI, this.lllIIIllII.getRecognitionDebugMode());
            if (this.IIIlllIlII != null) {
                setCameraFrameFactory(new com.microblink.blinkbarcode.hardware.camera.IllIIIIllI());
                super.create();
                View view = this.lIIIIIllIl;
                if (view != null) {
                    view.setVisibility(8);
                    addChildView(this.lIIIIIllIl, false);
                    return;
                }
                return;
            }
            throw new NullPointerException("Please set ScanResultListener with method setScanResultListener before calling create method!");
        }
        throw new IllegalStateException("It is not allowed to call create() on already created view (state is " + this.llIIIlllll.name() + ")");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void destroy() {
        super.destroy();
        this.IIlIIlIllI.dispose();
        this.IIlIIlIllI = null;
        com.microblink.blinkbarcode.recognition.IlIllIlIIl.llIIlIlIIl();
        terminateNativeFrameSupport(this.llIllllIIl);
    }

    public RecognizerBundle getRecognizerBundle() {
        return this.lllIIIllII;
    }

    public ScanResultListener getScanResultListener() {
        return this.IIIlllIlII;
    }

    public Rectangle getScanningRegion() {
        return this.IlIIlllIll;
    }

    public boolean isScanningPaused() {
        RecognitionProcessCallback recognitionProcessCallback = this.IIlIIlIllI;
        return recognitionProcessCallback == null || recognitionProcessCallback.isPaused();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void pause() {
        if (this.llIIIlllll == BaseCameraView.CameraViewState.RESUMED) {
            lIIIIIlIlI();
            RecognitionProcessCallback recognitionProcessCallback = this.IIlIIlIllI;
            if (recognitionProcessCallback != null) {
                recognitionProcessCallback.setPaused(true);
            }
            NativeRecognizerWrapper nativeRecognizerWrapper = this.IllIllIllI;
            if (nativeRecognizerWrapper != null) {
                nativeRecognizerWrapper.IlIllIlIIl(true);
            }
            this.IllIllIllI.llIIlIIlll();
            do {
            } while (this.lIIlllIIlI.get());
            super.pause();
            return;
        }
        throw new IllegalStateException("Cannot pause view that has not been resumed. Please make sure that your view has been resumed with resume() method. State is " + this.llIIIlllll.name());
    }

    public final void pauseScanning() {
        if (this.IIIllIIlIl.getAndIncrement() == 0) {
            lIIIIIlIlI();
            RecognitionProcessCallback recognitionProcessCallback = this.IIlIIlIllI;
            if (recognitionProcessCallback != null) {
                recognitionProcessCallback.setPaused(true);
            }
            NativeRecognizerWrapper nativeRecognizerWrapper = this.IllIllIllI;
            if (nativeRecognizerWrapper != null) {
                nativeRecognizerWrapper.IlIllIlIIl(true);
            }
        }
        Log.m40231i(this, "pauseScanning: pause count is {}", this.IIIllIIlIl);
    }

    public void reconfigureRecognizers(RecognizerBundle recognizerBundle) {
        if (recognizerBundle != null) {
            BaseCameraView.CameraViewState cameraViewState = this.llIIIlllll;
            if (cameraViewState == BaseCameraView.CameraViewState.DESTROYED || cameraViewState == BaseCameraView.CameraViewState.CREATED) {
                throw new IllegalStateException("Method must be called after calling start()");
            }
            Boolean isAutofocusSupported = isAutofocusSupported();
            if (isAutofocusSupported == null) {
                Log.m40235w(this, "Reconfiguring recognizers while camera is paused. Cannot perform autofocus check.", new Object[0]);
            } else if (!isAutofocusSupported.booleanValue() && llIIlIlIIl(recognizerBundle.getRecognizers())) {
                throw new AutoFocusRequiredButNotSupportedException("New recognition settings require camera with autofocus, while opened camera does not support that!");
            }
            this.lllIIIllII = recognizerBundle;
            updateNativeFrameSupport(this.llIllllIIl, NativeRecognizerWrapper.llIIlIlIIl(recognizerBundle.getRecognizers()), this.lllIIIllII.getFrameQualityEstimationMode().ordinal(), com.microblink.blinkbarcode.hardware.IllIIIllII.IlIllIlllI());
            NativeRecognizerWrapper nativeRecognizerWrapper = this.IllIllIllI;
            if (nativeRecognizerWrapper != null) {
                nativeRecognizerWrapper.llIIlIlIIl(this.lllIIIllII, (NativeRecognizerWrapper.lllIIIlIlI) this.llIIlllIll);
            }
        }
    }

    public final void resetRecognitionState() {
        resetRecognitionState(true);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void resume() {
        if (this.llIIIlllll == BaseCameraView.CameraViewState.STARTED) {
            Log.m40231i(this, "RecognizerRunner view resume: Context = {}", getContext());
            if (this.lIlIIIlIll == null) {
                super.resume();
            } else {
                this.llIIIlllll = BaseCameraView.CameraViewState.RESUMED;
            }
        } else {
            throw new IllegalStateException("Cannot resume view that has not been started. Please call start() first. State is " + this.llIIIlllll.name());
        }
    }

    public final void resumeScanning(boolean z) {
        if (this.IIIllIIlIl.decrementAndGet() <= 0) {
            IlIllIlIIl(z);
        }
        Log.m40231i(this, "resumeScanning: pause count is {}", Integer.valueOf(this.IIIllIIlIl.get()));
    }

    public void setFrameRecognitionCallback(FrameRecognitionCallback frameRecognitionCallback) {
        this.llIIllIlII = frameRecognitionCallback;
    }

    public void setLifecycle(Lifecycle lifecycle) {
        lifecycle.addObserver(this);
    }

    public void setMetadataCallbacks(MetadataCallbacks metadataCallbacks) {
        if (metadataCallbacks == null) {
            metadataCallbacks = new MetadataCallbacks();
        }
        this.IlllIlllll = metadataCallbacks;
        RecognitionProcessCallback recognitionProcessCallback = this.IIlIIlIllI;
        if (recognitionProcessCallback != null) {
            recognitionProcessCallback.setMetadataCallbacks(metadataCallbacks);
        }
    }

    public void setRecognizerBundle(RecognizerBundle recognizerBundle) {
        if (this.llIIIlllll != BaseCameraView.CameraViewState.DESTROYED) {
            throw new IllegalStateException("Method setRecognizerBundle must be called before calling create()");
        } else if (recognizerBundle != null) {
            this.lllIIIllII = recognizerBundle;
        }
    }

    public void setScanResultListener(ScanResultListener scanResultListener) {
        if (this.llIIIlllll == BaseCameraView.CameraViewState.DESTROYED) {
            this.IIIlllIlII = scanResultListener;
            return;
        }
        throw new IllegalStateException("Method setScanResultListener must be called before calling create()");
    }

    public final void setScanningRegion(Rectangle rectangle, boolean z) {
        this.IlIIlllIll = rectangle;
        this.IlllllIIIl = z;
        if (rectangle != null && !rectangle.isRelative()) {
            throw new IllegalArgumentException("Scanning region must be given in relative coordinates, i.e. following must hold true: x + width <= 1.f && y + height <= 1.f. Given region is " + rectangle);
        } else if (getOpenedCameraType() != null) {
            IlIllIlIIl(getCurrentOrientation());
            Log.m40227d(this, "Updated scanning region", new Object[0]);
            RecognitionProcessCallback recognitionProcessCallback = this.IIlIIlIllI;
            if (recognitionProcessCallback != null) {
                recognitionProcessCallback.setScanningRegion(this.IIllllIIlI);
            }
        }
    }

    public boolean shouldRotateScanningRegion() {
        return this.IlllllIIIl;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void start() {
        CameraEventsListener cameraEventsListener;
        super.start();
        Context context = getContext();
        Log.m40231i(this, "Loading Native Library!", new Object[0]);
        if (this.IllIllIllI == null) {
            this.IllIllIllI = NativeRecognizerWrapper.INSTANCE;
        }
        this.IllIllIllI.llIIlIlIIl(this.IIIlIIlIll);
        NotSupportedReason notSupportedReason = null;
        try {
            boolean llIIIlllll2 = RightsManager.llIIIlllll();
            NotSupportedReason IllIIIllII2 = this.llllIllllI.IllIIIllII();
            if (IllIIIllII2 != null) {
                notSupportedReason = IllIIIllII2;
            } else if (!llIIIlllll2) {
                notSupportedReason = NotSupportedReason.INVALID_OR_MISSING_LICENSE;
            } else if (!llIIlIlIIl.llIIlIlIIl(context)) {
                notSupportedReason = NotSupportedReason.CUSTOM_UI_FORBIDDEN;
            } else if (!this.IlIllIlIIl) {
                this.IllIllIllI.llIIlIlIIl(getContext(), this.lllIIIllII, (NativeRecognizerWrapper.lllIIIlIlI) this.llIIlllIll);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            CameraEventsListener cameraEventsListener2 = this.llIIlIlIIl;
            if (cameraEventsListener2 != null) {
                cameraEventsListener2.onError(th);
            }
            this.IlIllIlIIl = true;
        }
        this.lIlIIIlIll = notSupportedReason;
        Log.m40231i(this, "Not support reason: {}", notSupportedReason);
        if (this.lIlIIIlIll != null && (cameraEventsListener = this.llIIlIlIIl) != null) {
            cameraEventsListener.onError(new FeatureNotSupportedException(this.lIlIIIlIll));
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void stop() {
        super.stop();
        NativeRecognizerWrapper nativeRecognizerWrapper = this.IllIllIllI;
        if (nativeRecognizerWrapper != null) {
            nativeRecognizerWrapper.llIIlIlIIl((com.microblink.blinkbarcode.recognition.llIIlIlIIl) null);
            this.IllIllIllI.llIIIlllll();
            this.IllIllIllI = null;
        }
    }

    /* access modifiers changed from: private */
    public void IlIlllllII() {
        NativeRecognizerWrapper nativeRecognizerWrapper = this.IllIllIllI;
        if (nativeRecognizerWrapper != null) {
            Log.m40227d(this, "Before preparing for next recognition, recognizer state is: {}", nativeRecognizerWrapper.IlIllIlIIl());
        }
        NativeRecognizerWrapper nativeRecognizerWrapper2 = this.IllIllIllI;
        if (nativeRecognizerWrapper2 != null && nativeRecognizerWrapper2.IlIllIlIIl() == com.microblink.blinkbarcode.recognition.IllIIIllII.DONE) {
            this.IllIllIllI.IllIIIllII();
        }
    }

    private void lIIIIIlIlI() {
        this.IIllIIllll.set(true);
        llIIlllIll andSet = this.lIllIlIlIl.getAndSet((Object) null);
        if (andSet != null) {
            andSet.IllIIIllII();
        }
    }

    public boolean IlIllIlllI() {
        return llIIlIlIIl(this.lllIIIllII.getRecognizers());
    }

    public final OrientationChangeListener IllIIIIllI() {
        return this.llllllllll;
    }

    public final boolean IllIIlIIII() {
        try {
            NativeRecognizerWrapper nativeRecognizerWrapper = this.IllIllIllI;
            if (nativeRecognizerWrapper != null) {
                nativeRecognizerWrapper.llIIlIlIIl(true);
            }
            return com.microblink.blinkbarcode.recognition.IlIllIlIIl.IlIllIlIIl();
        } catch (UnsatisfiedLinkError e) {
            Log.m40230e(this, e, "Unable to load native library", new Object[0]);
            throw e;
        }
    }

    public void lIIIIIllll() {
        boolean z = false;
        if (getCameraViewState() != BaseCameraView.CameraViewState.RESUMED) {
            Log.m40235w(this, "Camera preview started callback received after view was paused", new Object[0]);
            return;
        }
        Orientation currentOrientation = getCurrentOrientation();
        if (currentOrientation == null || currentOrientation == Orientation.ORIENTATION_UNKNOWN) {
            currentOrientation = getInitialOrientation();
        }
        if (currentOrientation == null || currentOrientation == Orientation.ORIENTATION_UNKNOWN) {
            if (getConfigurationOrientation() == 1) {
                currentOrientation = Orientation.ORIENTATION_PORTRAIT;
            } else {
                currentOrientation = Orientation.ORIENTATION_LANDSCAPE_RIGHT;
            }
        }
        IlIllIlIIl(currentOrientation);
        this.IIlIIlIllI.setScanningRegion(this.IIllllIIlI);
        if (this.lIIIIIllIl != null) {
            if (!RightsManager.llIIIlllll() || !RightsManager.llIIlIlIIl(Right.ALLOW_REMOVE_DEMO_OVERLAY)) {
                llIIlIlIIl((Runnable) new IllIIIllII());
            } else {
                llIIlIlIIl((Runnable) new IlIllIlIIl());
            }
        }
        RecognitionProcessCallback recognitionProcessCallback = this.IIlIIlIllI;
        if (recognitionProcessCallback != null) {
            if (getOpenedCameraType() == CameraType.CAMERA_FRONTFACE) {
                z = true;
            }
            recognitionProcessCallback.setCameraOptions(z, llIIlIlIIl());
        }
        if (this.IIIllIIlIl.get() <= 0) {
            IlIllIlIIl(true);
        }
    }

    public final com.microblink.blinkbarcode.hardware.camera.llIIlIlIIl llIIIlllll() {
        return this.IIllIllIII;
    }

    public void lllIIIlIlI() {
        llIIlllIll andSet = this.lIllIlIlIl.getAndSet((Object) null);
        if (andSet != null) {
            andSet.IllIIIllII();
        }
    }

    public final void resetRecognitionState(boolean z) {
        llIIlIlIIl(z);
    }

    private void IlIllIlIIl(Context context) {
        if (!isInEditMode()) {
            this.llllIllllI = MicroblinkDeviceManager.llIIlIlIIl(context);
            if (RightsManager.llIIIlllll()) {
                getContext().getApplicationContext();
                return;
            }
            throw new InvalidLicenceKeyException("Please set valid license key before creating RecognizerRunnerView");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00a6, code lost:
        if (r9 == com.microblink.blinkbarcode.hardware.camera.CameraType.CAMERA_BACKFACE) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00ab, code lost:
        if (r9 == com.microblink.blinkbarcode.hardware.camera.CameraType.CAMERA_FRONTFACE) goto L_0x00ad;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void IlIllIlIIl(com.microblink.blinkbarcode.hardware.orientation.Orientation r9) {
        /*
            r8 = this;
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.microblink.blinkbarcode.geometry.Rectangle r1 = r8.IlIIlllIll
            r2 = 0
            r0[r2] = r1
            r1 = 1
            r0[r1] = r9
            java.lang.String r3 = "Preparing ROI from original ROI {} in orientation {}"
            com.microblink.blinkbarcode.util.Log.m40227d(r8, r3, r0)
            com.microblink.blinkbarcode.geometry.Rectangle r0 = r8.IlIIlllIll
            if (r0 == 0) goto L_0x00b8
            float r0 = r0.getX()
            com.microblink.blinkbarcode.geometry.Rectangle r3 = r8.IlIIlllIll
            float r3 = r3.getY()
            com.microblink.blinkbarcode.geometry.Rectangle r4 = r8.IlIIlllIll
            float r4 = r4.getWidth()
            com.microblink.blinkbarcode.geometry.Rectangle r5 = r8.IlIIlllIll
            float r5 = r5.getHeight()
            com.microblink.blinkbarcode.hardware.orientation.Orientation r6 = com.microblink.blinkbarcode.hardware.orientation.Orientation.ORIENTATION_LANDSCAPE_LEFT
            r7 = 1065353216(0x3f800000, float:1.0)
            if (r9 != r6) goto L_0x004f
            com.microblink.blinkbarcode.geometry.Rectangle r9 = r8.IlIIlllIll
            float r9 = r9.getX()
            com.microblink.blinkbarcode.geometry.Rectangle r0 = r8.IlIIlllIll
            float r0 = r0.getWidth()
            float r9 = r9 + r0
            float r0 = r7 - r9
            com.microblink.blinkbarcode.geometry.Rectangle r9 = r8.IlIIlllIll
            float r9 = r9.getY()
            com.microblink.blinkbarcode.geometry.Rectangle r3 = r8.IlIIlllIll
            float r3 = r3.getHeight()
        L_0x004b:
            float r9 = r9 + r3
            float r3 = r7 - r9
            goto L_0x0097
        L_0x004f:
            com.microblink.blinkbarcode.hardware.orientation.Orientation r6 = com.microblink.blinkbarcode.hardware.orientation.Orientation.ORIENTATION_PORTRAIT
            if (r9 != r6) goto L_0x0072
            com.microblink.blinkbarcode.geometry.Rectangle r9 = r8.IlIIlllIll
            float r4 = r9.getHeight()
            com.microblink.blinkbarcode.geometry.Rectangle r9 = r8.IlIIlllIll
            float r5 = r9.getWidth()
            com.microblink.blinkbarcode.geometry.Rectangle r9 = r8.IlIIlllIll
            float r0 = r9.getY()
            com.microblink.blinkbarcode.geometry.Rectangle r9 = r8.IlIIlllIll
            float r9 = r9.getX()
            com.microblink.blinkbarcode.geometry.Rectangle r3 = r8.IlIIlllIll
            float r3 = r3.getWidth()
            goto L_0x004b
        L_0x0072:
            com.microblink.blinkbarcode.hardware.orientation.Orientation r6 = com.microblink.blinkbarcode.hardware.orientation.Orientation.ORIENTATION_PORTRAIT_UPSIDE
            if (r9 != r6) goto L_0x0097
            com.microblink.blinkbarcode.geometry.Rectangle r9 = r8.IlIIlllIll
            float r4 = r9.getHeight()
            com.microblink.blinkbarcode.geometry.Rectangle r9 = r8.IlIIlllIll
            float r5 = r9.getWidth()
            com.microblink.blinkbarcode.geometry.Rectangle r9 = r8.IlIIlllIll
            float r9 = r9.getY()
            com.microblink.blinkbarcode.geometry.Rectangle r0 = r8.IlIIlllIll
            float r0 = r0.getHeight()
            float r9 = r9 + r0
            float r0 = r7 - r9
            com.microblink.blinkbarcode.geometry.Rectangle r9 = r8.IlIIlllIll
            float r3 = r9.getX()
        L_0x0097:
            com.microblink.blinkbarcode.hardware.camera.CameraType r9 = r8.getOpenedCameraType()
            boolean r6 = r8.llIIlIlIIl()
            if (r6 == 0) goto L_0x00a9
            float r0 = r0 + r4
            float r0 = r7 - r0
            com.microblink.blinkbarcode.hardware.camera.CameraType r6 = com.microblink.blinkbarcode.hardware.camera.CameraType.CAMERA_BACKFACE
            if (r9 != r6) goto L_0x00b0
            goto L_0x00ad
        L_0x00a9:
            com.microblink.blinkbarcode.hardware.camera.CameraType r6 = com.microblink.blinkbarcode.hardware.camera.CameraType.CAMERA_FRONTFACE
            if (r9 != r6) goto L_0x00b0
        L_0x00ad:
            float r3 = r3 + r5
            float r3 = r7 - r3
        L_0x00b0:
            com.microblink.blinkbarcode.geometry.Rectangle r9 = new com.microblink.blinkbarcode.geometry.Rectangle
            r9.<init>(r0, r3, r4, r5)
            r8.IIllllIIlI = r9
            goto L_0x00be
        L_0x00b8:
            com.microblink.blinkbarcode.geometry.Rectangle r9 = com.microblink.blinkbarcode.geometry.Rectangle.getDefaultROI()
            r8.IIllllIIlI = r9
        L_0x00be:
            java.lang.Object[] r9 = new java.lang.Object[r1]
            com.microblink.blinkbarcode.geometry.Rectangle r0 = r8.IIllllIIlI
            r9[r2] = r0
            java.lang.String r0 = "Prepared ROI {}"
            com.microblink.blinkbarcode.util.Log.m40227d(r8, r0, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.IlIllIlIIl(com.microblink.blinkbarcode.hardware.orientation.Orientation):void");
    }

    private void IlIllIlIIl(boolean z) {
        this.IIIllIIlIl.set(0);
        RecognitionProcessCallback recognitionProcessCallback = this.IIlIIlIllI;
        if (recognitionProcessCallback != null) {
            recognitionProcessCallback.setPaused(false);
        }
        NativeRecognizerWrapper nativeRecognizerWrapper = this.IllIllIllI;
        if (nativeRecognizerWrapper != null) {
            nativeRecognizerWrapper.IlIllIlIIl(false);
        }
        if (z) {
            llIIlIlIIl(true);
        }
        this.IIllIIllll.set(false);
        IlIlllllII();
    }

    public static void IlIllIlIIl(RecognizerRunnerView recognizerRunnerView, boolean z) {
        if (recognizerRunnerView.IIIllIIlIl.get() <= 0) {
            recognizerRunnerView.IlIllIlIIl(z);
        }
    }

    public final void llIIlIlIIl(com.microblink.blinkbarcode.hardware.camera.IlIllIlIIl ilIllIlIIl) {
        super.llIIlIlIIl(ilIllIlIIl);
        ilIllIlIIl.llIIIlllll(false);
        ilIllIlIIl.IlIllIlIIl(230400);
        ilIllIlIIl.llIIlIlIIl((ShakeCallback) new llIIlIlIIl());
    }

    /* access modifiers changed from: private */
    public void llIIlIlIIl(boolean z) {
        if (this.IllIllIllI != null) {
            Log.m40227d(this, "Resetting recognizer state!", new Object[0]);
            this.IllIllIllI.llIIlIlIIl(z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r1 = (r1 = r1.IllIllIllI).IlIllIlIIl();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean llIIlIlIIl(com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r1) {
        /*
            boolean r0 = r1.isScanningPaused()
            if (r0 == 0) goto L_0x0007
            goto L_0x001b
        L_0x0007:
            com.microblink.blinkbarcode.recognition.NativeRecognizerWrapper r1 = r1.IllIllIllI
            if (r1 != 0) goto L_0x000c
            goto L_0x001b
        L_0x000c:
            com.microblink.blinkbarcode.recognition.IllIIIllII r1 = r1.IlIllIlIIl()
            com.microblink.blinkbarcode.recognition.IllIIIllII r0 = com.microblink.blinkbarcode.recognition.IllIIIllII.DONE
            if (r1 == r0) goto L_0x001b
            com.microblink.blinkbarcode.recognition.IllIIIllII r0 = com.microblink.blinkbarcode.recognition.IllIIIllII.UNINITIALIZED
            if (r1 != r0) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            r1 = 0
            goto L_0x001c
        L_0x001b:
            r1 = 1
        L_0x001c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView.llIIlIlIIl(com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView):boolean");
    }

    private boolean llIIlIlIIl(Recognizer[] recognizerArr) {
        if (recognizerArr == null) {
            return false;
        }
        for (Recognizer recognizer : recognizerArr) {
            if (recognizer != null && recognizer.requiresAutofocus()) {
                return true;
            }
        }
        return false;
    }

    public void llIIlIlIIl(Configuration configuration) {
        super.llIIlIlIIl(configuration);
        if (getOpenedCameraType() != null) {
            IlIllIlIIl(getCurrentOrientation());
            Log.m40227d(this, "Updated scanning region", new Object[0]);
            RecognitionProcessCallback recognitionProcessCallback = this.IIlIIlIllI;
            if (recognitionProcessCallback != null) {
                recognitionProcessCallback.setScanningRegion(this.IIllllIIlI);
            }
        }
    }

    public static void llIIlIlIIl(RecognizerRunnerView recognizerRunnerView, String str) {
        if (!recognizerRunnerView.IIllIIllll.get()) {
            AlertDialog create = new AlertDialog.Builder(recognizerRunnerView.getContext()).setCancelable(false).setTitle("Library information").setMessage(str).setNeutralButton(Payload.RESPONSE_OK, new IlIllIlIIl(recognizerRunnerView)).create();
            if (recognizerRunnerView.llIIIlllll == BaseCameraView.CameraViewState.RESUMED) {
                recognizerRunnerView.lIIIIIlIlI();
                SystemUtils.showDialog(create);
            }
        }
    }

    public static void llIIlIlIIl(RecognizerRunnerView recognizerRunnerView, RecognitionSuccessType recognitionSuccessType) {
        if (!recognizerRunnerView.IIllIIllll.get()) {
            RecognitionProcessCallback recognitionProcessCallback = recognizerRunnerView.IIlIIlIllI;
            if (recognitionProcessCallback != null && !recognitionProcessCallback.isPaused()) {
                recognizerRunnerView.lIIIIIlIlI();
                recognizerRunnerView.IIIlllIlII.onScanningDone(recognitionSuccessType);
                lIllllIlll.llIIlIlIIl().llIIlIlIIl(recognizerRunnerView.lllIIIllII, llIlllIIIl.VIDEO_STREAM);
                if (recognizerRunnerView.IIIllIIlIl.get() <= 0) {
                    recognizerRunnerView.IIllIIllll.set(false);
                    recognizerRunnerView.IlIlllllII();
                    return;
                }
                return;
            }
            return;
        }
        Log.m40231i(recognizerRunnerView, "Recognition has been paused, will not raise scanning done event.", new Object[0]);
    }

    public RecognizerRunnerView(Context context) {
        this(context, (AttributeSet) null);
    }
}
