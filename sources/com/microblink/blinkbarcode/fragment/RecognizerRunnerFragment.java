package com.microblink.blinkbarcode.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.didi.sdk.apm.SystemUtils;
import com.microblink.blinkbarcode.entities.recognizers.Recognizer;
import com.microblink.blinkbarcode.entities.recognizers.RecognizerBundle;
import com.microblink.blinkbarcode.fragment.overlay.ScanningOverlay;
import com.microblink.blinkbarcode.library.R;
import com.microblink.blinkbarcode.locale.LanguageUtils;
import com.microblink.blinkbarcode.recognition.RecognitionSuccessType;
import com.microblink.blinkbarcode.util.CameraPermissionManager;
import com.microblink.blinkbarcode.util.Log;
import com.microblink.blinkbarcode.view.BaseCameraEventsListener;
import com.microblink.blinkbarcode.view.CameraEventsListener;
import com.microblink.blinkbarcode.view.exception.NonLandscapeOrientationNotSupportedException;
import com.microblink.blinkbarcode.view.recognition.FrameRecognitionCallback;
import com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView;
import com.microblink.blinkbarcode.view.recognition.ScanResultListener;

/* compiled from: line */
public final class RecognizerRunnerFragment extends Fragment {
    private LifecycleObserver IIlIIIllIl;
    private RecognizerBundle IlIllIlIIl;
    private final CameraEventsListener IlIllIlllI = new CameraEventsListener() {
        public void onAutofocusFailed() {
            if (RecognizerRunnerFragment.this.llIIlIIlll != null) {
                RecognizerRunnerFragment.this.llIIlIIlll.onAutofocusFailed();
            }
        }

        public void onAutofocusStarted(Rect[] rectArr) {
            if (RecognizerRunnerFragment.this.llIIlIIlll != null) {
                RecognizerRunnerFragment.this.llIIlIIlll.onAutofocusStarted(rectArr);
            }
        }

        public void onAutofocusStopped(Rect[] rectArr) {
            if (RecognizerRunnerFragment.this.llIIlIIlll != null) {
                RecognizerRunnerFragment.this.llIIlIIlll.onAutofocusStopped(rectArr);
            }
        }

        public void onCameraPermissionDenied() {
            RecognizerRunnerFragment.this.llIIIlllll.askForCameraPermission();
        }

        public void onCameraPreviewStarted() {
            if (RecognizerRunnerFragment.this.lIlIIIIlIl != null && RecognizerRunnerFragment.this.lIlIIIIlIl.getVisibility() == 0) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(500);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationEnd(Animation animation) {
                        RecognizerRunnerFragment.this.lIlIIIIlIl.setVisibility(8);
                    }

                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }
                });
                RecognizerRunnerFragment.this.lIlIIIIlIl.startAnimation(alphaAnimation);
            }
            if (RecognizerRunnerFragment.this.llIIlIIlll != null) {
                RecognizerRunnerFragment.this.llIIlIIlll.onCameraPreviewStarted();
            }
        }

        public void onCameraPreviewStopped() {
            if (RecognizerRunnerFragment.this.llIIlIIlll != null) {
                RecognizerRunnerFragment.this.llIIlIIlll.onCameraPreviewStopped();
            }
        }

        public void onError(Throwable th) {
            if (RecognizerRunnerFragment.this.llIIlIIlll != null) {
                RecognizerRunnerFragment.this.llIIlIIlll.onError(th);
            }
        }
    };
    private FrameLayout IllIIIIllI;
    /* access modifiers changed from: private */
    public ScanningOverlay IllIIIllII;
    private int lIIIIIllll = R.layout.mb_camera_splash;
    /* access modifiers changed from: private */
    public View lIlIIIIlIl = null;
    /* access modifiers changed from: private */
    public CameraPermissionManager llIIIlllll;
    /* access modifiers changed from: private */
    public BaseCameraEventsListener llIIlIIlll;
    private RecognizerRunnerView llIIlIlIIl;
    private final ScanResultListener lllIIIlIlI = new ScanResultListener() {
        public void onScanningDone(RecognitionSuccessType recognitionSuccessType) {
            RecognizerRunnerFragment.this.IllIIIllII.onScanningDone(recognitionSuccessType);
        }

        public void onUnrecoverableError(Throwable th) {
            RecognizerRunnerFragment.this.IllIIIllII.onUnrecoverableError(th);
        }
    };
    private final FrameRecognitionCallback lllIlIlIIl = new FrameRecognitionCallback() {
        public void onFrameRecognitionDone(RecognitionSuccessType recognitionSuccessType) {
            RecognizerRunnerFragment.this.IllIIIllII.onFrameRecognitionDone(recognitionSuccessType);
        }
    };

    /* renamed from: com.microblink.blinkbarcode.fragment.RecognizerRunnerFragment$4 */
    /* compiled from: line */
    public static /* synthetic */ class C203664 {
        public static final /* synthetic */ int[] llIIlIlIIl;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0011 */
        static {
            /*
                com.microblink.blinkbarcode.view.BaseCameraView.CameraViewState.values()
                r0 = 4
                int[] r0 = new int[r0]
                llIIlIlIIl = r0
                r1 = 1
                r2 = 3
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000c }
            L_0x000c:
                int[] r0 = llIIlIlIIl     // Catch:{ NoSuchFieldError -> 0x0011 }
                r3 = 2
                r0[r3] = r3     // Catch:{ NoSuchFieldError -> 0x0011 }
            L_0x0011:
                int[] r0 = llIIlIlIIl     // Catch:{ NoSuchFieldError -> 0x0015 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkbarcode.fragment.RecognizerRunnerFragment.C203664.<clinit>():void");
        }
    }

    /* compiled from: line */
    public interface ScanningOverlayBinder {
        ScanningOverlay getScanningOverlay();
    }

    public FrameLayout getContentLayout() {
        return this.IllIIIIllI;
    }

    public RecognizerRunnerView getRecognizerRunnerView() {
        return this.llIIlIlIIl;
    }

    public int getSplashScreenResourceId() {
        return this.lIIIIIllll;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            ScanningOverlay scanningOverlay = ((ScanningOverlayBinder) activity).getScanningOverlay();
            this.IllIIIllII = scanningOverlay;
            scanningOverlay.onRecognizerRunnerFragmentAttached(this, activity);
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement ScanningOverlayBinder interface!");
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        RecognizerRunnerView recognizerRunnerView = this.llIIlIlIIl;
        if (recognizerRunnerView != null) {
            recognizerRunnerView.changeConfiguration(configuration);
        }
        LifecycleObserver lifecycleObserver = this.IIlIIIllIl;
        if (lifecycleObserver != null) {
            lifecycleObserver.onConfigurationChanged(configuration);
        }
    }

    public void onCreate(Bundle bundle) {
        LanguageUtils.setLanguageConfiguration(getResources());
        super.onCreate(bundle);
        Log.m40231i(this, "onCreate: {}", this);
        Log.m40227d(this, "My instance is: {}", RecognizerRunnerFragment.class.getName());
        LifecycleObserver lifecycleObserver = this.IIlIIIllIl;
        if (lifecycleObserver != null) {
            lifecycleObserver.onCreate(bundle);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        this.IllIIIIllI = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.IllIIIIllI.setVisibility(0);
        this.llIIIlllll = new CameraPermissionManager((Fragment) this);
        llIIlIlIIl(layoutInflater.getContext());
        RecognizerRunnerView recognizerRunnerView = this.llIIlIlIIl;
        if (recognizerRunnerView == null) {
            return null;
        }
        RecognizerBundle recognizerBundle = recognizerRunnerView.getRecognizerBundle();
        this.IlIllIlIIl = recognizerBundle;
        if (recognizerBundle == null) {
            throw new NullPointerException("You must set RecognizerBundle in your onRecognizerRunnerViewCreated callback");
        } else if (recognizerBundle.getRecognizers().length != 0) {
            Recognizer[] recognizers = this.IlIllIlIIl.getRecognizers();
            int length = recognizers.length;
            int i = 0;
            while (i < length) {
                if (recognizers[i] != null) {
                    i++;
                } else {
                    throw new NullPointerException("It is not allowed to set null Recognizer in RecognizerBundle!");
                }
            }
            int i2 = this.lIIIIIllll;
            if (i2 != 0) {
                this.lIlIIIIlIl = layoutInflater.inflate(i2, (ViewGroup) null);
            }
            View view = this.lIlIIIIlIl;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.lIlIIIIlIl;
            if (view2 != null) {
                this.IllIIIIllI.addView(view2);
            }
            View askPermissionOverlay = this.llIIIlllll.getAskPermissionOverlay();
            if (askPermissionOverlay != null) {
                this.IllIIIIllI.addView(askPermissionOverlay);
            }
            this.llIIlIlIIl.create();
            return this.IllIIIIllI;
        } else {
            throw new IllegalStateException("You must set at least one Recognizer object into RecognizerBundle which is set to RecognizerRunnerView in onRecognizerRunnerViewCreated callback");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        LifecycleObserver lifecycleObserver = this.IIlIIIllIl;
        if (lifecycleObserver != null) {
            lifecycleObserver.onDestroy();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        RecognizerRunnerView recognizerRunnerView = this.llIIlIlIIl;
        if (recognizerRunnerView != null) {
            recognizerRunnerView.destroy();
            this.llIIlIlIIl = null;
        }
    }

    public void onPause() {
        super.onPause();
        RecognizerRunnerView recognizerRunnerView = this.llIIlIlIIl;
        if (recognizerRunnerView != null) {
            recognizerRunnerView.pause();
        }
        LifecycleObserver lifecycleObserver = this.IIlIIIllIl;
        if (lifecycleObserver != null) {
            lifecycleObserver.onPause();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.llIIIlllll.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void onResume() {
        LanguageUtils.setLanguageConfiguration(getResources());
        super.onResume();
        RecognizerRunnerView recognizerRunnerView = this.llIIlIlIIl;
        if (recognizerRunnerView != null) {
            recognizerRunnerView.resume();
            View view = this.lIlIIIIlIl;
            if (view != null) {
                view.setVisibility(0);
            }
        }
        LifecycleObserver lifecycleObserver = this.IIlIIIllIl;
        if (lifecycleObserver != null) {
            lifecycleObserver.onResume();
        }
        CameraPermissionManager cameraPermissionManager = this.llIIIlllll;
        if (cameraPermissionManager != null) {
            cameraPermissionManager.onResume();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        LifecycleObserver lifecycleObserver = this.IIlIIIllIl;
        if (lifecycleObserver != null) {
            lifecycleObserver.onSaveInstanceState(bundle);
        }
    }

    public void onStart() {
        super.onStart();
        RecognizerRunnerView recognizerRunnerView = this.llIIlIlIIl;
        if (recognizerRunnerView != null) {
            recognizerRunnerView.start();
        }
        LifecycleObserver lifecycleObserver = this.IIlIIIllIl;
        if (lifecycleObserver != null) {
            lifecycleObserver.onStart();
        }
    }

    public void onStop() {
        super.onStop();
        RecognizerRunnerView recognizerRunnerView = this.llIIlIlIIl;
        if (recognizerRunnerView != null) {
            recognizerRunnerView.stop();
        }
        LifecycleObserver lifecycleObserver = this.IIlIIIllIl;
        if (lifecycleObserver != null) {
            lifecycleObserver.onStop();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void recreateRecognizerRunnerView() {
        /*
            r5 = this;
            com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r0 = r5.llIIlIlIIl
            if (r0 == 0) goto L_0x005d
            com.microblink.blinkbarcode.view.BaseCameraView$CameraViewState r0 = r0.getCameraViewState()
            int r1 = r0.ordinal()
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == r4) goto L_0x0020
            if (r1 == r3) goto L_0x001b
            if (r1 == r2) goto L_0x0016
            goto L_0x0025
        L_0x0016:
            com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r1 = r5.llIIlIlIIl
            r1.pause()
        L_0x001b:
            com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r1 = r5.llIIlIlIIl
            r1.stop()
        L_0x0020:
            com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r1 = r5.llIIlIlIIl
            r1.destroy()
        L_0x0025:
            r1 = 0
            r5.llIIlIlIIl = r1
            androidx.fragment.app.FragmentActivity r1 = r5.getActivity()
            r5.llIIlIlIIl((android.content.Context) r1)
            com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r1 = r5.llIIlIlIIl
            if (r1 != 0) goto L_0x0034
            return
        L_0x0034:
            int r0 = r0.ordinal()
            r1 = 0
            if (r0 == r4) goto L_0x0046
            if (r0 == r3) goto L_0x0043
            if (r0 == r2) goto L_0x0042
            r0 = 0
            r4 = 0
            goto L_0x0047
        L_0x0042:
            r1 = 1
        L_0x0043:
            r0 = r1
            r1 = 1
            goto L_0x0047
        L_0x0046:
            r0 = 0
        L_0x0047:
            if (r4 == 0) goto L_0x004e
            com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r2 = r5.llIIlIlIIl
            r2.create()
        L_0x004e:
            if (r1 == 0) goto L_0x0055
            com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r1 = r5.llIIlIlIIl
            r1.start()
        L_0x0055:
            if (r0 == 0) goto L_0x005c
            com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView r0 = r5.llIIlIlIIl
            r0.resume()
        L_0x005c:
            return
        L_0x005d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "RecognizerRunnerView has not been created yet,it is created in onCreateView() method!"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkbarcode.fragment.RecognizerRunnerFragment.recreateRecognizerRunnerView():void");
    }

    public void registerLifecycleObserver(LifecycleObserver lifecycleObserver) {
        this.IIlIIIllIl = lifecycleObserver;
    }

    public void setCameraEventsListener(BaseCameraEventsListener baseCameraEventsListener) {
        this.llIIlIIlll = baseCameraEventsListener;
    }

    public void setSplashScreenResourceId(int i) {
        this.lIIIIIllll = i;
    }

    private void llIIlIlIIl(Context context) {
        try {
            this.llIIlIlIIl = new RecognizerRunnerView(context);
        } catch (NullPointerException e) {
            e.printStackTrace();
            this.llIIlIlIIl = null;
        } catch (NonLandscapeOrientationNotSupportedException unused) {
            SystemUtils.hookSetRequestedOrientation(getActivity(), 0);
            getActivity().recreate();
            this.llIIlIlIIl = null;
        }
        if (this.llIIlIlIIl != null) {
            this.IllIIIIllI.removeAllViews();
            this.IllIIIIllI.addView(this.llIIlIlIIl);
            this.IllIIIllII.onRecognizerRunnerViewCreated(this);
            this.llIIlIlIIl.setScanResultListener(this.lllIIIlIlI);
            this.llIIlIlIIl.setFrameRecognitionCallback(this.lllIlIlIIl);
            this.llIIlIlIIl.setCameraEventsListener(this.IlIllIlllI);
        }
    }
}
