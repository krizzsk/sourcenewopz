package com.microblink.blinkbarcode.fragment.overlay.basic;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import com.didi.autotracker.AutoTrackHelper;
import com.microblink.blinkbarcode.entities.recognizers.HighResImagesBundle;
import com.microblink.blinkbarcode.entities.recognizers.Recognizer;
import com.microblink.blinkbarcode.entities.recognizers.RecognizerBundle;
import com.microblink.blinkbarcode.fragment.RecognizerRunnerFragment;
import com.microblink.blinkbarcode.fragment.overlay.BaseOverlayController;
import com.microblink.blinkbarcode.fragment.overlay.components.debug.DebugViewHandler;
import com.microblink.blinkbarcode.fragment.overlay.components.feedback.RecognitionFeedbackHandler;
import com.microblink.blinkbarcode.fragment.overlay.components.settings.ControlsLayoutConfig;
import com.microblink.blinkbarcode.fragment.overlay.components.statusmsg.StatusMessageTranslator;
import com.microblink.blinkbarcode.fragment.overlay.components.statusmsg.StatusTextManager;
import com.microblink.blinkbarcode.fragment.overlay.components.statusmsg.StatusTextStyler;
import com.microblink.blinkbarcode.geometry.Rectangle;
import com.microblink.blinkbarcode.hardware.orientation.Orientation;
import com.microblink.blinkbarcode.image.DebugImageListener;
import com.microblink.blinkbarcode.image.highres.HighResImageWrapper;
import com.microblink.blinkbarcode.library.R;
import com.microblink.blinkbarcode.metadata.MetadataCallbacks;
import com.microblink.blinkbarcode.metadata.detection.FailedDetectionCallback;
import com.microblink.blinkbarcode.metadata.detection.points.DisplayablePointsDetection;
import com.microblink.blinkbarcode.metadata.detection.points.PointsDetectionCallback;
import com.microblink.blinkbarcode.metadata.detection.quad.DisplayableQuadDetection;
import com.microblink.blinkbarcode.metadata.detection.quad.QuadDetectionCallback;
import com.microblink.blinkbarcode.recognition.IlIllIlIIl;
import com.microblink.blinkbarcode.recognition.RecognitionSuccessType;
import com.microblink.blinkbarcode.secured.IIIlIIlIll;
import com.microblink.blinkbarcode.uisettings.options.OverlayOrientation;
import com.microblink.blinkbarcode.util.Log;
import com.microblink.blinkbarcode.view.OnActivityFlipListener;
import com.microblink.blinkbarcode.view.OrientationAllowedListener;
import com.microblink.blinkbarcode.view.recognition.HighResImageListener;
import com.microblink.blinkbarcode.view.recognition.ScanResultListener;
import com.microblink.blinkbarcode.view.viewfinder.quadview.QuadViewManager;
import com.microblink.blinkbarcode.view.viewfinder.quadview.QuadViewManagerFactory;

/* compiled from: line */
public final class BasicOverlayController extends BaseOverlayController {
    private OnActivityFlipListener IlIIlIIIII = new OnActivityFlipListener() {
        public void onActivityFlip() {
            if (BasicOverlayController.this.lllIlIlIIl != null) {
                BasicOverlayController.this.lllIlIlIIl.configurationChanged(BasicOverlayController.this.llIIIlllll, BasicOverlayController.this.IllIIIllII.getResources().getConfiguration());
            }
            BasicOverlayController.this.llIllIIlll.onOrientationChange(BasicOverlayController.this.llIIIlllll.getHostScreenOrientation());
        }
    };
    /* access modifiers changed from: private */
    public BasicOverlaySettings IlIIlllIIl;
    private ImageButton IlIllIlllI;
    private MetadataCallbacks IlIlllllII = new MetadataCallbacks();
    private RecognizerBundle IllIIlIIII;
    /* access modifiers changed from: private */
    public HighResImagesBundle lIIIIIlIlI = new HighResImagesBundle();
    /* access modifiers changed from: private */
    public StatusMessageTranslator lIllIIlIIl;
    /* access modifiers changed from: private */
    public StatusTextManager lIlllIlIlI;
    /* access modifiers changed from: private */
    public Runnable llIIlIIIll;
    /* access modifiers changed from: private */
    public RecognitionFeedbackHandler llIllIIlll;
    private OrientationAllowedListener lllIIlIIlI = new OrientationAllowedListener() {
        public boolean isOrientationAllowed(Orientation orientation) {
            OverlayOrientation IllIIIIllI = BasicOverlayController.this.IlIIlllIIl.IllIIIIllI();
            if (IllIIIIllI == null) {
                Orientation llIIIlllll = BasicOverlayController.this.lIlIIIIlIl();
                if (llIIIlllll == null || !llIIIlllll.isHorizontal() || orientation.isHorizontal()) {
                    return true;
                }
                return false;
            } else if ((IllIIIIllI != OverlayOrientation.LANDSCAPE || !orientation.isHorizontal()) && (IllIIIIllI != OverlayOrientation.PORTRAIT || !orientation.isVertical())) {
                return false;
            } else {
                return true;
            }
        }
    };
    /* access modifiers changed from: private */
    public QuadViewManager lllIlIlIIl;
    private ControlsLayoutConfig lllllIlIll;

    public BasicOverlayController(BasicOverlaySettings basicOverlaySettings, ScanResultListener scanResultListener) {
        super(scanResultListener);
        this.IllIIlIIII = basicOverlaySettings.lIIIIIllll();
        this.llIIlIIIll = basicOverlaySettings.lIlIIIIlIl();
        this.IlIIlllIIl = basicOverlaySettings;
        this.lllllIlIll = basicOverlaySettings.IllIIIllII();
        this.llIllIIlll = basicOverlaySettings.IIlIIIllIl();
        this.lIllIIlIIl = basicOverlaySettings.lllIlIlIIl();
    }

    public boolean IllIIIIllI() {
        return true;
    }

    public HighResImagesBundle getHighResImagesBundle() {
        return this.lIIIIIlIlI;
    }

    public void onCameraAutofocusFailed() {
        QuadViewManager quadViewManager = this.lllIlIlIIl;
        if (quadViewManager != null) {
            quadViewManager.animateQuadToDefaultPosition();
        }
        this.llIllIIlll.clear();
    }

    public void onRecognizerRunnerViewCreated(final RecognizerRunnerFragment recognizerRunnerFragment) {
        super.onRecognizerRunnerViewCreated(recognizerRunnerFragment);
        this.llIIIlllll.setRecognizerBundle(this.IllIIlIIII);
        this.llIIIlllll.setAnimateRotation(true);
        this.IlIIlllIIl.IlIllIlIIl().apply(this.llIIIlllll);
        this.llIIIlllll.setHighResFrameCaptureEnabled(this.IlIIlllIIl.IllIIlIIII());
        Rectangle rectangle = this.IlIIlllIIl.lllIIIlIlI().roi;
        if (rectangle != null) {
            this.llIIIlllll.setScanningRegion(rectangle, this.IlIIlllIIl.lllIIIlIlI().isRotatable);
        }
        this.IlIlllllII.setFailedDetectionCallback(new FailedDetectionCallback() {
            public void onDetectionFailed() {
                BasicOverlayController.this.llIllIIlll.clear();
                if (BasicOverlayController.this.lllIlIlIIl != null) {
                    BasicOverlayController.this.lllIlIlIIl.animateQuadToDefaultPosition();
                }
                if (BasicOverlayController.this.lIlllIlIlI != null) {
                    BasicOverlayController.this.lIlllIlIlI.updateStatus(BasicOverlayController.this.lIllIIlIIl.getMessage(StatusMessageTranslator.Event.DETECTION_FAILED));
                }
            }
        });
        this.IlIlllllII.setQuadDetectionCallback(new QuadDetectionCallback() {
            public void onQuadDetection(DisplayableQuadDetection displayableQuadDetection) {
                if (BasicOverlayController.this.lllIlIlIIl != null) {
                    BasicOverlayController.this.lllIlIlIIl.animateQuadToDetectionPosition(displayableQuadDetection);
                }
                if (BasicOverlayController.this.lIlllIlIlI != null) {
                    BasicOverlayController.this.lIlllIlIlI.updateStatus(BasicOverlayController.this.lIllIIlIIl.getMessage(StatusMessageTranslator.Event.fromDetectionStatus(displayableQuadDetection.getDetectionStatus())));
                }
                BasicOverlayController.this.llIllIIlll.clear();
            }
        });
        this.IlIlllllII.setPointsDetectionCallback(new PointsDetectionCallback() {
            public void onPointsDetection(DisplayablePointsDetection displayablePointsDetection) {
                BasicOverlayController.this.llIllIIlll.onPointsDetection(displayablePointsDetection);
                if (BasicOverlayController.this.lIlllIlIlI != null) {
                    BasicOverlayController.this.lIlllIlIlI.updateStatus(BasicOverlayController.this.lIllIIlIIl.getMessage(StatusMessageTranslator.Event.fromDetectionStatus(displayablePointsDetection.getDetectionStatus())));
                }
            }
        });
        DebugImageListener llIIIlllll = this.IlIIlllIIl.llIIIlllll();
        if (llIIIlllll != null) {
            this.IlIlllllII.setDebugImageCallback(llIIIlllll);
        }
        OverlayOrientation IllIIIIllI = this.IlIIlllIIl.IllIIIIllI();
        if (IllIIIIllI == null) {
            this.llIIIlllll.setInitialOrientation(lIlIIIIlIl());
        } else {
            this.llIIIlllll.setInitialOrientation(IllIIIIllI.toOrientation());
        }
        this.llIIIlllll.setOrientationAllowedListener(this.lllIIlIIlI);
        this.llIIIlllll.setOnActivityFlipListener(this.IlIIlIIIII);
        ViewGroup viewGroup = (ViewGroup) recognizerRunnerFragment.getActivity().getLayoutInflater().inflate(this.lllllIlIll.layoutId, (ViewGroup) null);
        this.llIIIlllll.addChildView(viewGroup, true);
        if (this.IllIIlIIII.getRecognitionDebugMode() != RecognizerBundle.RecognitionDebugMode.RECOGNITION) {
            new DebugViewHandler().initialize(recognizerRunnerFragment.getActivity(), viewGroup, this.IlIlllllII);
        }
        this.lllIlIlIIl = QuadViewManagerFactory.createQuadViewFromPreset(this.llIIIlllll, this.IlIIlllIIl.llIIlIIlll());
        if (this.IllIIlIIII.getRecognitionDebugMode() == RecognizerBundle.RecognitionDebugMode.DETECTION_TEST) {
            this.lllIlIlIIl.setAnimationDuration(0);
        }
        View createView = this.llIllIIlll.createView(this.llIIIlllll, this.IlIlllllII);
        if (createView != null) {
            this.llIIIlllll.addChildView(createView, false);
        }
        this.IIlIIIllIl.setup((ImageView) this.llIIIlllll.findViewById(this.lllllIlIll.torchButtonId), this.llIIIlllll);
        ((ImageButton) this.llIIIlllll.findViewById(this.lllllIlIll.backButtonId)).setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                recognizerRunnerFragment.getActivity().onBackPressed();
            }
        });
        ImageButton imageButton = (ImageButton) viewGroup.findViewById(this.lllllIlIll.helpButtonId);
        this.IlIllIlllI = imageButton;
        imageButton.setVisibility(8);
        this.IlIllIlllI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (BasicOverlayController.this.llIIlIIIll != null) {
                    BasicOverlayController.this.llIIlIIIll.run();
                }
            }
        });
        TextSwitcher textSwitcher = (TextSwitcher) viewGroup.findViewById(this.lllllIlIll.statusTextId);
        if (textSwitcher != null) {
            this.lIlllIlIlI = new StatusTextManager(textSwitcher, new StatusTextStyler.Default(R.style.MB_scan_status_text));
            textSwitcher.setVisibility(0);
            this.lIlllIlIlI.updateStatus(this.lIllIIlIIl.getMessage(StatusMessageTranslator.Event.INITIAL));
        }
        this.llIIIlllll.setMetadataCallbacks(this.IlIlllllII);
    }

    public final void onScanningDone(final RecognitionSuccessType recognitionSuccessType) {
        if (recognitionSuccessType != RecognitionSuccessType.UNSUCCESSFUL) {
            pauseScanning();
            if (!this.IlIIlllIIl.IllIIlIIII()) {
                this.llIIlIIlll.play();
                if (this.lIlllIlIlI != null) {
                    this.lIlllIlIlI.updateStatus(this.lIllIIlIIl.getMessage(StatusMessageTranslator.Event.fromRecognitionSuccessType(recognitionSuccessType)));
                }
                this.llIIlIlIIl.onScanningDone(recognitionSuccessType);
                resumeScanning();
                return;
            }
            this.llIIIlllll.post(new Runnable() {
                public void run() {
                    BasicOverlayController.this.llIIIlllll.captureHighResImage(new HighResImageListener() {
                        public void onHighResImageAvailable(HighResImageWrapper highResImageWrapper) {
                            BasicOverlayController.this.llIIlIIlll.play();
                            BasicOverlayController.this.lIIIIIlIlI.addImage(highResImageWrapper);
                            C203756 r2 = C203756.this;
                            BasicOverlayController.llIIlIlIIl(BasicOverlayController.this, recognitionSuccessType);
                            BasicOverlayController.this.llIIlIlIIl.onScanningDone(recognitionSuccessType);
                            BasicOverlayController.this.resumeScanning();
                        }
                    });
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public Orientation lIlIIIIlIl() {
        if (!IlIllIlIIl.IlIllIlIIl()) {
            Log.m40235w(this, "It seems that lib{}.so has not been loaded!", IIIlIIlIll.IlIllIlIIl[0]);
            return null;
        }
        Recognizer[] recognizers = this.IllIIlIIII.getRecognizers();
        if (recognizers != null) {
            for (Recognizer recognizer : recognizers) {
                if (recognizer != null && recognizer.requiresLandscapeMode()) {
                    return Orientation.ORIENTATION_LANDSCAPE_RIGHT;
                }
            }
        }
        return null;
    }

    public static void llIIlIlIIl(BasicOverlayController basicOverlayController, RecognitionSuccessType recognitionSuccessType) {
        if (basicOverlayController.lIlllIlIlI != null) {
            basicOverlayController.lIlllIlIlI.updateStatus(basicOverlayController.lIllIIlIIl.getMessage(StatusMessageTranslator.Event.fromRecognitionSuccessType(recognitionSuccessType)));
        }
    }

    public int IlIllIlIIl() {
        return this.IlIIlllIIl.IlIllIlllI();
    }

    public void llIIIlllll() {
        this.IllIIlIIII.clearSavedState();
        this.lIIIIIlIlI.clearSavedState();
        if (this.llIIlIIIll != null) {
            this.IlIllIlllI.setVisibility(0);
        } else {
            this.IlIllIlllI.setVisibility(4);
        }
        StatusTextManager statusTextManager = this.lIlllIlIlI;
        if (statusTextManager != null) {
            statusTextManager.updateStatus(this.lIllIIlIIl.getMessage(StatusMessageTranslator.Event.INITIAL));
        }
    }

    public int llIIlIlIIl() {
        return this.IlIIlllIIl.llIIlIlIIl();
    }

    public void llIIlIlIIl(Configuration configuration) {
        QuadViewManager quadViewManager = this.lllIlIlIIl;
        if (quadViewManager != null) {
            quadViewManager.configurationChanged(this.llIIIlllll, configuration);
        }
        this.llIllIIlll.onOrientationChange(this.llIIIlllll.getHostScreenOrientation());
    }

    public void llIIlIlIIl(Bundle bundle) {
        this.IllIIlIIII.saveState();
        this.lIIIIIlIlI.saveState();
    }
}
