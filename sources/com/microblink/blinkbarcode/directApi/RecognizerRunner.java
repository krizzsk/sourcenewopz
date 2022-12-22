package com.microblink.blinkbarcode.directApi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.microblink.blinkbarcode.entities.recognizers.Recognizer;
import com.microblink.blinkbarcode.entities.recognizers.RecognizerBundle;
import com.microblink.blinkbarcode.geometry.Rectangle;
import com.microblink.blinkbarcode.hardware.camera.memory.BitmapCameraFrame;
import com.microblink.blinkbarcode.hardware.orientation.Orientation;
import com.microblink.blinkbarcode.image.Image;
import com.microblink.blinkbarcode.image.ImageFrame;
import com.microblink.blinkbarcode.licence.exception.InvalidLicenceKeyException;
import com.microblink.blinkbarcode.metadata.MetadataCallbacks;
import com.microblink.blinkbarcode.recognition.NativeRecognizerWrapper;
import com.microblink.blinkbarcode.recognition.RecognitionSuccessType;
import com.microblink.blinkbarcode.recognition.Right;
import com.microblink.blinkbarcode.recognition.RightsManager;
import com.microblink.blinkbarcode.recognition.callback.RecognitionProcessCallback;
import com.microblink.blinkbarcode.recognition.callback.llIIlIlIIl;
import com.microblink.blinkbarcode.secured.lIllllIlll;
import com.microblink.blinkbarcode.secured.llIlllIIIl;
import com.microblink.blinkbarcode.settings.NativeLibraryInfo;
import com.microblink.blinkbarcode.util.Log;
import com.microblink.blinkbarcode.view.recognition.ScanResultListener;

/* compiled from: line */
public class RecognizerRunner {
    private static RecognizerRunner IlIllIlllI = new RecognizerRunner();
    private RecognitionLicenseAndErrorCallback IIlIIIllIl;
    private ScanResultListener IlIllIlIIl = null;
    private MetadataCallbacks IllIIIIllI = new MetadataCallbacks();
    /* access modifiers changed from: private */
    public DirectApiErrorListener IllIIIllII = null;
    private RecognitionProcessCallback lIIIIIllll;
    private long lIlIIIIlIl = 1000000;
    private RecognizerBundle llIIIlllll = null;
    /* access modifiers changed from: private */
    public Context llIIlIIlll = null;
    private NativeRecognizerWrapper llIIlIlIIl = null;
    /* access modifiers changed from: private */
    public State lllIIIlIlI;

    /* compiled from: line */
    public class RecognitionLicenseAndErrorCallback implements NativeRecognizerWrapper.lllIIIlIlI, NativeRecognizerWrapper.lllIlIlIIl, llIIlIlIIl {
        private RecognitionLicenseAndErrorCallback() {
        }

        public void onLicenseInformation(String str) {
            if (RecognizerRunner.this.llIIlIIlll != null) {
                SystemUtils.showToast(Toast.makeText(RecognizerRunner.this.llIIlIIlll, str, 1));
            }
        }

        public void onRecognitionDone(RecognitionSuccessType recognitionSuccessType) {
            RecognizerRunner.llIIlIlIIl(RecognizerRunner.this, recognitionSuccessType);
        }

        public void onRecognitionDoneWithTimeout(RecognitionSuccessType recognitionSuccessType) {
            RecognizerRunner.llIIlIlIIl(RecognizerRunner.this, recognitionSuccessType);
        }

        public void onRecognizerError(Throwable th) {
            RecognizerRunner.this.IllIIIllII.onRecognizerError(th);
            synchronized (RecognizerRunner.this) {
                if (RecognizerRunner.this.lllIIIlIlI == State.WORKING) {
                    State unused = RecognizerRunner.this.lllIIIlIlI = State.READY;
                }
            }
        }
    }

    /* compiled from: line */
    public enum State {
        OFFLINE,
        READY,
        WORKING
    }

    private RecognizerRunner() {
        RecognitionLicenseAndErrorCallback recognitionLicenseAndErrorCallback = new RecognitionLicenseAndErrorCallback();
        this.IIlIIIllIl = recognitionLicenseAndErrorCallback;
        this.lIIIIIllll = new RecognitionProcessCallback(recognitionLicenseAndErrorCallback, this.IllIIIIllI, Rectangle.getDefaultROI(), RecognizerBundle.RecognitionDebugMode.RECOGNITION);
        this.lllIIIlIlI = State.OFFLINE;
    }

    public static RecognizerRunner getSingletonInstance() {
        return IlIllIlllI;
    }

    public synchronized void cancel() {
        if (this.lllIIIlIlI == State.WORKING) {
            this.lIIIIIllll.setPaused(true);
            this.llIIlIlIIl.llIIlIIlll();
            this.lllIIIlIlI = State.READY;
        }
    }

    public final synchronized State getCurrentState() {
        return this.lllIIIlIlI;
    }

    public final synchronized void initialize(Context context, RecognizerBundle recognizerBundle, DirectApiErrorListener directApiErrorListener) {
        if (this.lllIIIlIlI != State.OFFLINE) {
            throw new IllegalStateException("Cannot initialize already initialized recognizer!");
        } else if (context == null) {
            throw new NullPointerException("Context cannot be null");
        } else if (directApiErrorListener != null) {
            if (recognizerBundle == null) {
                recognizerBundle = new RecognizerBundle(new Recognizer[0]);
            }
            llIIlIlIIl(recognizerBundle);
            if (NativeLibraryInfo.isProtectionEnabled()) {
                if (!RightsManager.llIIlIlIIl(Right.ALLOW_CUSTOM_UI)) {
                    Log.m40229e(this, "Direct API requires license key that allows creation of custom UI!", new Object[0]);
                    throw new InvalidLicenceKeyException("Direct API requires license key that allows creation of custom UI!");
                }
            }
            this.llIIIlllll = recognizerBundle;
            this.IllIIIllII = directApiErrorListener;
            this.llIIlIlIIl = NativeRecognizerWrapper.INSTANCE;
            this.llIIlIIlll = context;
            if (NativeLibraryInfo.isProtectionEnabled() && !RightsManager.llIIlIlIIl(Right.ALLOW_REMOVE_DEMO_OVERLAY)) {
                SystemUtils.showToast(Toast.makeText(this.llIIlIIlll, "Powered by Microblink SDK", 1));
            }
            this.llIIlIlIIl.llIIlIlIIl(context, recognizerBundle, (NativeRecognizerWrapper.lllIIIlIlI) this.IIlIIIllIl);
            this.lllIIIlIlI = State.READY;
        } else {
            throw new NullPointerException("Error listener cannot be null!");
        }
    }

    public final void recognizeBitmap(Bitmap bitmap, Orientation orientation, ScanResultListener scanResultListener) {
        recognizeBitmapWithRecognizers(bitmap, orientation, new Rectangle(0.0f, 0.0f, 1.0f, 1.0f), scanResultListener, this.llIIIlllll);
    }

    public final void recognizeBitmapWithRecognizers(Bitmap bitmap, Orientation orientation, ScanResultListener scanResultListener, RecognizerBundle recognizerBundle) {
        recognizeBitmapWithRecognizers(bitmap, orientation, new Rectangle(0.0f, 0.0f, 1.0f, 1.0f), scanResultListener, recognizerBundle);
    }

    public final void recognizeImage(Image image, ScanResultListener scanResultListener) {
        recognizeImageWithRecognizers(image, scanResultListener, this.llIIIlllll);
    }

    public final void recognizeImageWithRecognizers(Image image, ScanResultListener scanResultListener, RecognizerBundle recognizerBundle) {
        if (this.lllIIIlIlI != State.READY) {
            throw new IllegalStateException("Cannot recognize image. RecognizerRunner not ready!");
        } else if (scanResultListener != null) {
            if (recognizerBundle != this.llIIIlllll) {
                if (recognizerBundle == null) {
                    recognizerBundle = new RecognizerBundle(new Recognizer[0]);
                }
                llIIlIlIIl(recognizerBundle);
            }
            RecognizerBundle recognizerBundle2 = recognizerBundle;
            this.IlIllIlIIl = scanResultListener;
            this.lIIIIIllll.setPaused(false);
            this.llIIlIlIIl.IlIllIlIIl(false);
            Rect rawROI = image.getRawROI();
            this.lIIIIIllll.setScanningRegion(new Rectangle(((float) rawROI.left) / ((float) image.getRawWidth()), ((float) rawROI.top) / ((float) image.getRawHeight()), ((float) rawROI.width()) / ((float) image.getRawWidth()), ((float) rawROI.height()) / ((float) image.getRawHeight())));
            NativeRecognizerWrapper nativeRecognizerWrapper = this.llIIlIlIIl;
            if (!image.isDisposed()) {
                long j = this.lIlIIIIlIl;
                this.lIlIIIIlIl = 1 + j;
                ImageFrame imageFrame = new ImageFrame(image, j);
                if (imageFrame.llIIlIlIIl(0)) {
                    RecognitionProcessCallback recognitionProcessCallback = this.lIIIIIllll;
                    RecognitionLicenseAndErrorCallback recognitionLicenseAndErrorCallback = this.IIlIIIllIl;
                    nativeRecognizerWrapper.llIIlIlIIl(imageFrame, recognizerBundle2, recognitionProcessCallback, recognitionLicenseAndErrorCallback, recognitionLicenseAndErrorCallback, true);
                    this.lllIIIlIlI = State.WORKING;
                    return;
                }
                imageFrame.IllIIIllII();
                throw new RuntimeException("Failed to process given image. See ADB log for more info.");
            }
            throw new IllegalStateException("Cannot recognize disposed image!");
        } else {
            throw new NullPointerException("Result listener cannot be null!");
        }
    }

    public final void recognizeString(String str, ScanResultListener scanResultListener) {
        recognizeStringWithRecognizers(str, scanResultListener, this.llIIIlllll);
    }

    public final void recognizeStringWithRecognizers(String str, ScanResultListener scanResultListener, RecognizerBundle recognizerBundle) {
        if (this.lllIIIlIlI != State.READY) {
            throw new IllegalStateException("Cannot recognize string. RecognizerRunner not ready!");
        } else if (scanResultListener != null) {
            if (recognizerBundle != this.llIIIlllll) {
                if (recognizerBundle == null) {
                    recognizerBundle = new RecognizerBundle(new Recognizer[0]);
                }
                llIIlIlIIl(recognizerBundle);
            }
            this.IlIllIlIIl = scanResultListener;
            this.lIIIIIllll.setPaused(false);
            this.llIIlIlIIl.IlIllIlIIl(false);
            NativeRecognizerWrapper nativeRecognizerWrapper = this.llIIlIlIIl;
            RecognitionProcessCallback recognitionProcessCallback = this.lIIIIIllll;
            RecognitionLicenseAndErrorCallback recognitionLicenseAndErrorCallback = this.IIlIIIllIl;
            nativeRecognizerWrapper.llIIlIlIIl(str, recognizerBundle, recognitionProcessCallback, recognitionLicenseAndErrorCallback, recognitionLicenseAndErrorCallback);
            this.lllIIIlIlI = State.WORKING;
        } else {
            throw new NullPointerException("Result listener cannot be null!");
        }
    }

    public final void resetRecognitionState() {
        resetRecognitionState(true);
    }

    public void setMetadataCallbacks(MetadataCallbacks metadataCallbacks) {
        if (metadataCallbacks == null) {
            metadataCallbacks = new MetadataCallbacks();
        }
        this.IllIIIIllI = metadataCallbacks;
        this.lIIIIIllll.setMetadataCallbacks(metadataCallbacks);
    }

    public synchronized void terminate() {
        State state = this.lllIIIlIlI;
        State state2 = State.OFFLINE;
        if (state != state2) {
            this.lIIIIIllll.setPaused(true);
            this.llIIlIlIIl.llIIIlllll();
            this.lllIIIlIlI = state2;
            this.llIIlIlIIl = null;
            this.llIIIlllll = null;
            this.IlIllIlIIl = null;
            this.IllIIIllII = null;
            MetadataCallbacks metadataCallbacks = new MetadataCallbacks();
            this.IllIIIIllI = metadataCallbacks;
            this.llIIlIIlll = null;
            this.lIIIIIllll.setMetadataCallbacks(metadataCallbacks);
        }
    }

    public final void recognizeBitmap(Bitmap bitmap, Orientation orientation, Rectangle rectangle, ScanResultListener scanResultListener) {
        recognizeBitmapWithRecognizers(bitmap, orientation, rectangle, scanResultListener, this.llIIIlllll);
    }

    public final synchronized void recognizeBitmapWithRecognizers(Bitmap bitmap, Orientation orientation, Rectangle rectangle, ScanResultListener scanResultListener, RecognizerBundle recognizerBundle) {
        if (this.lllIIIlIlI != State.READY) {
            throw new IllegalStateException("Cannot recognize image. RecognizerRunner not ready!");
        } else if (scanResultListener == null) {
            throw new NullPointerException("Result listener cannot be null!");
        } else if (rectangle == null) {
            throw new NullPointerException("Scan region cannot be null!");
        } else if (orientation == null || orientation == Orientation.ORIENTATION_UNKNOWN) {
            throw new IllegalArgumentException("Bitmap orientation cannot be null nor unknown!");
        } else if (rectangle.isRelative()) {
            if (recognizerBundle != this.llIIIlllll) {
                if (recognizerBundle == null) {
                    recognizerBundle = new RecognizerBundle(new Recognizer[0]);
                }
                llIIlIlIIl(recognizerBundle);
            }
            RecognizerBundle recognizerBundle2 = recognizerBundle;
            this.IlIllIlIIl = scanResultListener;
            this.lIIIIIllll.setPaused(false);
            this.llIIlIlIIl.IlIllIlIIl(false);
            this.lIIIIIllll.setScanningRegion(rectangle);
            NativeRecognizerWrapper nativeRecognizerWrapper = this.llIIlIlIIl;
            long j = this.lIlIIIIlIl;
            this.lIlIIIIlIl = 1 + j;
            BitmapCameraFrame bitmapCameraFrame = new BitmapCameraFrame(bitmap, j);
            bitmapCameraFrame.llIIlIlIIl(rectangle.toRectF());
            bitmapCameraFrame.llIIlIlIIl(orientation);
            if (bitmapCameraFrame.llIIlIlIIl(0)) {
                RecognitionProcessCallback recognitionProcessCallback = this.lIIIIIllll;
                RecognitionLicenseAndErrorCallback recognitionLicenseAndErrorCallback = this.IIlIIIllIl;
                nativeRecognizerWrapper.llIIlIlIIl(bitmapCameraFrame, recognizerBundle2, recognitionProcessCallback, recognitionLicenseAndErrorCallback, recognitionLicenseAndErrorCallback, true);
                this.lllIIIlIlI = State.WORKING;
            } else {
                bitmapCameraFrame.IllIIIllII();
                throw new RuntimeException("Failed to process given bitmap. See ADB log for more info.");
            }
        } else {
            throw new IllegalArgumentException("Scanning region must be given in relative coordinates, i.e. following must hold true: x + width <= 1.f && y + height <= 1.f");
        }
    }

    public final void resetRecognitionState(boolean z) {
        if (this.llIIlIlIIl != null) {
            Log.m40227d(this, "Resetting recognizer state!", new Object[0]);
            this.llIIlIlIIl.llIIlIlIIl(z);
        }
    }

    private void llIIlIlIIl(RecognizerBundle recognizerBundle) {
        Recognizer[] recognizers = recognizerBundle.getRecognizers();
        if (recognizers == null || recognizers.length == 0) {
            throw new NullPointerException("RecognizerRunner recognizer array inside RecognizerBundle cannot be null nor empty!");
        }
    }

    public static void llIIlIlIIl(RecognizerRunner recognizerRunner, RecognitionSuccessType recognitionSuccessType) {
        if (!recognizerRunner.lIIIIIllll.isPaused()) {
            synchronized (recognizerRunner) {
                if (recognizerRunner.llIIlIlIIl != null) {
                    recognizerRunner.lllIIIlIlI = State.READY;
                }
            }
        }
        lIllllIlll.llIIlIlIIl().llIIlIlIIl(recognizerRunner.llIIIlllll, llIlllIIIl.DIRECT_API);
        recognizerRunner.IlIllIlIIl.onScanningDone(recognitionSuccessType);
        recognizerRunner.llIIlIlIIl.IllIIIllII();
    }
}
