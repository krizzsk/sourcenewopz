package com.microblink.blinkbarcode.fragment.overlay;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.didi.sdk.apm.SystemUtils;
import com.microblink.blinkbarcode.fragment.LifecycleObserver;
import com.microblink.blinkbarcode.fragment.RecognizerRunnerFragment;
import com.microblink.blinkbarcode.fragment.overlay.components.ErrorDialogFactory;
import com.microblink.blinkbarcode.fragment.overlay.components.ScanSoundPlayer;
import com.microblink.blinkbarcode.fragment.overlay.components.TorchController;
import com.microblink.blinkbarcode.geometry.Rectangle;
import com.microblink.blinkbarcode.recognition.RecognitionSuccessType;
import com.microblink.blinkbarcode.view.BaseCameraEventsListener;
import com.microblink.blinkbarcode.view.CameraEventsListener;
import com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView;
import com.microblink.blinkbarcode.view.recognition.ScanResultListener;

/* compiled from: line */
public abstract class BaseOverlayController implements ScanningOverlay {
    public TorchController IIlIIIllIl = new TorchController();
    public OverlayState IlIllIlIIl = OverlayState.DESTROYED;
    public Handler IllIIIIllI = new Handler(Looper.getMainLooper());
    public RecognizerRunnerFragment IllIIIllII;
    private final BaseCameraEventsListener lIIIIIllll = new CameraEventsListener() {
        public void onAutofocusFailed() {
            BaseOverlayController.this.onCameraAutofocusFailed();
        }

        public void onAutofocusStarted(Rect[] rectArr) {
        }

        public void onAutofocusStopped(Rect[] rectArr) {
        }

        public void onCameraPermissionDenied() {
        }

        public void onCameraPreviewStarted() {
            BaseOverlayController.this.IIlIIIllIl.onTorchSupportStatusAvailable();
            BaseOverlayController baseOverlayController = BaseOverlayController.this;
            if (baseOverlayController.IlIllIlIIl == OverlayState.RESUMED) {
                baseOverlayController.llIIIlllll.setMeteringAreas(new RectF[]{new Rectangle(0.33f, 0.33f, 0.33f, 0.33f).toRectF()}, true);
            }
        }

        public void onCameraPreviewStopped() {
        }

        public void onError(final Throwable th) {
            BaseOverlayController.this.lIlIIIIlIl = new ErrorDialogFactory().createErrorDialog(BaseOverlayController.this.IllIIIllII.getActivity(), th, new Runnable() {
                public void run() {
                    BaseOverlayController.this.onUnrecoverableError(th);
                    BaseOverlayController.this.IllIIIllII.getActivity().onBackPressed();
                }
            });
            BaseOverlayController baseOverlayController = BaseOverlayController.this;
            OverlayState overlayState = baseOverlayController.IlIllIlIIl;
            if (overlayState == OverlayState.RESUMED || overlayState == OverlayState.STARTED) {
                SystemUtils.showDialog(baseOverlayController.lIlIIIIlIl);
                BaseOverlayController.this.lIlIIIIlIl = null;
            }
        }
    };
    public AlertDialog lIlIIIIlIl;
    public RecognizerRunnerView llIIIlllll;
    public ScanSoundPlayer llIIlIIlll = new ScanSoundPlayer();
    public ScanResultListener llIIlIlIIl;
    private final LifecycleObserver lllIIIlIlI = new LifecycleObserver() {
        public void onConfigurationChanged(Configuration configuration) {
            BaseOverlayController.this.llIIlIlIIl(configuration);
        }

        public void onCreate(Bundle bundle) {
            BaseOverlayController baseOverlayController = BaseOverlayController.this;
            baseOverlayController.IlIllIlIIl = OverlayState.CREATED;
            baseOverlayController.IllIIIllII();
        }

        public void onDestroy() {
            BaseOverlayController baseOverlayController = BaseOverlayController.this;
            baseOverlayController.IlIllIlIIl = OverlayState.DESTROYED;
            baseOverlayController.llIIlIIlll.clear();
            BaseOverlayController baseOverlayController2 = BaseOverlayController.this;
            baseOverlayController2.IllIIIllII = null;
            baseOverlayController2.IllIIIIllI.removeCallbacksAndMessages((Object) null);
            BaseOverlayController.this.getClass();
        }

        public void onPause() {
            BaseOverlayController.this.IlIllIlIIl = OverlayState.STARTED;
        }

        public void onResume() {
            BaseOverlayController baseOverlayController = BaseOverlayController.this;
            baseOverlayController.IlIllIlIIl = OverlayState.RESUMED;
            AlertDialog alertDialog = baseOverlayController.lIlIIIIlIl;
            if (alertDialog != null) {
                SystemUtils.showDialog(alertDialog);
                BaseOverlayController.this.lIlIIIIlIl = null;
            }
            BaseOverlayController.this.llIIIlllll();
        }

        public void onSaveInstanceState(Bundle bundle) {
            BaseOverlayController.this.llIIlIlIIl(bundle);
        }

        public void onStart() {
            BaseOverlayController.this.IlIllIlIIl = OverlayState.STARTED;
        }

        public void onStop() {
            BaseOverlayController.this.IlIllIlIIl = OverlayState.CREATED;
        }
    };

    public BaseOverlayController(ScanResultListener scanResultListener) {
        this.llIIlIlIIl = scanResultListener;
    }

    public abstract int IlIllIlIIl();

    public abstract boolean IllIIIIllI();

    public void IllIIIllII() {
    }

    public void llIIIlllll() {
    }

    public abstract int llIIlIlIIl();

    public void llIIlIlIIl(Configuration configuration) {
    }

    public void llIIlIlIIl(Bundle bundle) {
    }

    public void onCameraAutofocusFailed() {
    }

    public void onFrameRecognitionDone(RecognitionSuccessType recognitionSuccessType) {
    }

    public void onRecognizerRunnerFragmentAttached(RecognizerRunnerFragment recognizerRunnerFragment, Activity activity) {
        this.IllIIIllII = recognizerRunnerFragment;
        recognizerRunnerFragment.setCameraEventsListener(this.lIIIIIllll);
        recognizerRunnerFragment.registerLifecycleObserver(this.lllIIIlIlI);
        recognizerRunnerFragment.setSplashScreenResourceId(IlIllIlIIl());
    }

    public void onRecognizerRunnerViewCreated(RecognizerRunnerFragment recognizerRunnerFragment) {
        this.llIIIlllll = recognizerRunnerFragment.getRecognizerRunnerView();
        this.llIIlIIlll.initialize(recognizerRunnerFragment.getActivity(), llIIlIlIIl());
    }

    public void onUnrecoverableError(Throwable th) {
        this.llIIlIlIIl.onUnrecoverableError(th);
    }

    public void pauseScanning() {
        RecognizerRunnerView recognizerRunnerView = this.llIIIlllll;
        if (recognizerRunnerView != null) {
            recognizerRunnerView.pauseScanning();
        }
    }

    public void resumeScanning() {
        RecognizerRunnerView recognizerRunnerView = this.llIIIlllll;
        if (recognizerRunnerView != null) {
            recognizerRunnerView.resumeScanning(IllIIIIllI());
        }
    }
}
