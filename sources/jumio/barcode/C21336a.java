package jumio.barcode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.didi.raven.config.RavenKey;
import com.google.common.base.Ascii;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.camera.Size;
import com.jumio.commons.log.Log;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.enums.ErrorCase;
import com.jumio.core.error.Error;
import com.jumio.core.extraction.barcode.BaseBarcodeClient;
import com.jumio.core.model.StaticModel;
import com.jumio.core.models.SettingsModel;
import com.jumio.core.persistence.DataManager;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import com.microblink.blinkbarcode.MicroblinkSDK;
import com.microblink.blinkbarcode.directApi.DirectApiErrorListener;
import com.microblink.blinkbarcode.directApi.RecognizerRunner;
import com.microblink.blinkbarcode.entities.Entity;
import com.microblink.blinkbarcode.entities.recognizers.Recognizer;
import com.microblink.blinkbarcode.entities.recognizers.RecognizerBundle;
import com.microblink.blinkbarcode.entities.recognizers.blinkbarcode.barcode.BarcodeRecognizer;
import com.microblink.blinkbarcode.geometry.Rectangle;
import com.microblink.blinkbarcode.hardware.orientation.Orientation;
import com.microblink.blinkbarcode.image.Image;
import com.microblink.blinkbarcode.image.ImageBuilder;
import com.microblink.blinkbarcode.recognition.RecognitionSuccessType;
import com.microblink.blinkbarcode.util.Log;
import com.microblink.blinkbarcode.view.recognition.ScanResultListener;
import java.nio.charset.Charset;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* renamed from: jumio.barcode.a */
/* compiled from: BarcodeClient.kt */
public final class C21336a extends BaseBarcodeClient implements ScanResultListener {

    /* renamed from: j */
    public static final C21337a f59572j = new C21337a((DefaultConstructorMarker) null);

    /* renamed from: k */
    public static final String f59573k = C21336a.class.getSimpleName();

    /* renamed from: a */
    public final Object f59574a = new Object();

    /* renamed from: b */
    public PreviewProperties f59575b;

    /* renamed from: c */
    public Rect f59576c;

    /* renamed from: d */
    public RecognizerBundle f59577d = new RecognizerBundle(new Recognizer[0]);

    /* renamed from: e */
    public RecognizerRunner f59578e;

    /* renamed from: f */
    public BarcodeRecognizer f59579f;

    /* renamed from: g */
    public int f59580g;

    /* renamed from: h */
    public int f59581h;

    /* renamed from: i */
    public Image f59582i;

    /* renamed from: jumio.barcode.a$a */
    /* compiled from: BarcodeClient.kt */
    public static final class C21337a {
        public C21337a() {
        }

        public /* synthetic */ C21337a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: a */
        public final boolean mo175776a(Context context, DataManager dataManager) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(dataManager, "dataManager");
            try {
                String barcodeScannerKey = ((SettingsModel) dataManager.get(SettingsModel.class)).getBarcodeScannerKey();
                if (barcodeScannerKey != null) {
                    MicroblinkSDK.setLicenseKey(barcodeScannerKey, StringDeobfuscator.deobfuscate(new byte[]{49, 106, 69, Ascii.f53585EM, 49}, 2707057876264250875L), context);
                    return true;
                }
                throw new Exception("No license found for barcode scanning, please set one!");
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C21336a(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* renamed from: a */
    public static final void m42087a(C21336a aVar, Throwable th) {
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        Intrinsics.checkNotNullParameter(th, RavenKey.TYPE);
        Log.m39462e(f59573k, "Failed to initialize recognizer.", th);
        aVar.f59578e = null;
        aVar.publishError(new Error(ErrorCase.OCR_LOADING_FAILED, 0, 0, 6, (DefaultConstructorMarker) null));
    }

    public void configure(DataManager dataManager, StaticModel staticModel) {
        Intrinsics.checkNotNullParameter(dataManager, "dataManager");
        Intrinsics.checkNotNullParameter(staticModel, "configurationModel");
        synchronized (this.f59574a) {
            try {
                super.configure(dataManager, staticModel);
                C21337a aVar = f59572j;
                Context context = this.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                if (aVar.mo175776a(context, dataManager)) {
                    com.microblink.blinkbarcode.util.Log.setLogLevel(Log.LogLevel.LOG_QUIET);
                    BarcodeRecognizer barcodeRecognizer = new BarcodeRecognizer();
                    barcodeRecognizer.setScanPdf417(true);
                    barcodeRecognizer.setNullQuietZoneAllowed(true);
                    barcodeRecognizer.setScanUncertain(true);
                    barcodeRecognizer.setAutoScaleDetection(true);
                    Unit unit = Unit.INSTANCE;
                    this.f59579f = barcodeRecognizer;
                    this.f59577d = new RecognizerBundle(barcodeRecognizer);
                    RecognizerRunner singletonInstance = RecognizerRunner.getSingletonInstance();
                    this.f59578e = singletonInstance;
                    Intrinsics.checkNotNull(singletonInstance);
                    singletonInstance.initialize(this.context, this.f59577d, new DirectApiErrorListener() {
                        public final void onRecognizerError(Throwable th) {
                            C21336a.m42087a(C21336a.this, th);
                        }
                    });
                    Unit unit2 = Unit.INSTANCE;
                } else {
                    throw new Exception("License not valid");
                }
            } catch (Exception e) {
                com.jumio.commons.log.Log.m39462e(f59573k, "Failed to configure", (Throwable) e);
                this.f59578e = null;
                publishError(new Error(ErrorCase.OCR_LOADING_FAILED, 0, 0, 6, (DefaultConstructorMarker) null));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void destroy() {
        synchronized (this.f59574a) {
            RecognizerRunner recognizerRunner = this.f59578e;
            if (recognizerRunner != null) {
                recognizerRunner.terminate();
            }
            this.f59578e = null;
            this.f59579f = null;
            Unit unit = Unit.INSTANCE;
        }
        super.destroy();
    }

    public void init(PreviewProperties previewProperties, Rect rect) {
        super.init(previewProperties, rect);
        synchronized (this.f59574a) {
            RecognizerRunner recognizerRunner = this.f59578e;
            if (recognizerRunner != null) {
                recognizerRunner.resetRecognitionState();
            }
            this.imageSource = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public void onScanningDone(RecognitionSuccessType recognitionSuccessType) {
        String str;
        Intrinsics.checkNotNullParameter(recognitionSuccessType, "recognitionSuccessType");
        Image image = this.f59582i;
        if (image != null) {
            try {
                image.dispose();
                this.f59582i = null;
            } catch (Exception e) {
                com.jumio.commons.log.Log.m39457d(f59573k, "Exception during disposing the image!", (Throwable) e);
            }
        }
        com.jumio.commons.log.Log.m39456d(f59573k, Intrinsics.stringPlus("Photopay ", recognitionSuccessType));
        boolean z = false;
        if (recognitionSuccessType == RecognitionSuccessType.SUCCESSFUL) {
            BarcodeRecognizer barcodeRecognizer = this.f59579f;
            Intrinsics.checkNotNull(barcodeRecognizer);
            Entity.Result result = barcodeRecognizer.getResult();
            Intrinsics.checkNotNullExpressionValue(result, "barcodeRecognizer!!.result");
            BarcodeRecognizer.Result result2 = (BarcodeRecognizer.Result) result;
            ImageSource imageSource = this.imageSource;
            PreviewProperties previewProperties = this.f59575b;
            Intrinsics.checkNotNull(previewProperties);
            Bitmap yuv2bitmap = CameraUtils.yuv2bitmap(imageSource, previewProperties.isPortrait, this.f59575b, this.f59576c, -1);
            try {
                byte[] rawData = result2.getRawData();
                Intrinsics.checkNotNullExpressionValue(rawData, "result.rawData");
                Charset forName = Charset.forName("ISO-8859-1");
                Intrinsics.checkNotNullExpressionValue(forName, "forName(\"ISO-8859-1\")");
                str = new String(rawData, forName);
            } catch (Exception unused) {
                byte[] rawData2 = result2.getRawData();
                Intrinsics.checkNotNullExpressionValue(rawData2, "result.rawData");
                str = new String(rawData2, Charsets.UTF_8);
            }
            z = onFinished(str, yuv2bitmap, this.f59580g, this.f59581h);
        }
        synchronized (this.f59574a) {
            RecognizerRunner recognizerRunner = this.f59578e;
            if (recognizerRunner != null) {
                recognizerRunner.resetRecognitionState();
            }
            setResult(z);
            this.imageSource = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public void onUnrecoverableError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        com.jumio.commons.log.Log.m39477w(f59573k, "Barcode scanning failed with exception!", th);
        publishError(new Error(ErrorCase.OCR_LOADING_FAILED, 0, 0, 6, (DefaultConstructorMarker) null));
    }

    public void process(ImageSource imageSource, PreviewProperties previewProperties, Rect rect) {
        Intrinsics.checkNotNullParameter(imageSource, "data");
        Intrinsics.checkNotNullParameter(previewProperties, "previewProperties");
        Intrinsics.checkNotNullParameter(rect, "extractionArea");
        byte[] bytes = imageSource.getImage().toBytes();
        Size size = previewProperties.camera;
        this.f59580g = size.width;
        this.f59581h = size.height;
        this.f59575b = previewProperties;
        this.f59576c = rect;
        synchronized (this.f59574a) {
            this.imageSource = imageSource;
            this.f59582i = ImageBuilder.buildImageFromCamera1NV21Frame(bytes, this.f59580g, this.f59581h, Orientation.ORIENTATION_LANDSCAPE_LEFT, (Rectangle) null);
            try {
                RecognizerRunner recognizerRunner = this.f59578e;
                if ((recognizerRunner == null ? null : recognizerRunner.getCurrentState()) != RecognizerRunner.State.READY) {
                    RecognizerRunner recognizerRunner2 = this.f59578e;
                    if (recognizerRunner2 != null) {
                        recognizerRunner2.cancel();
                    }
                }
                RecognizerRunner recognizerRunner3 = this.f59578e;
                Intrinsics.checkNotNull(recognizerRunner3);
                Image image = this.f59582i;
                Intrinsics.checkNotNull(image);
                recognizerRunner3.recognizeImage(image, this);
            } catch (Exception e) {
                com.jumio.commons.log.Log.m39462e(f59573k, "Exception during recognizing the image!", (Throwable) e);
                RecognizerRunner recognizerRunner4 = this.f59578e;
                if (recognizerRunner4 != null) {
                    recognizerRunner4.resetRecognitionState();
                }
                RecognizerRunner recognizerRunner5 = this.f59578e;
                if (recognizerRunner5 != null) {
                    recognizerRunner5.cancel();
                }
                this.imageSource = null;
                setResult(false);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public boolean shouldFeed() {
        boolean z;
        synchronized (this.f59574a) {
            z = this.f59578e != null && this.imageSource == null;
        }
        return z;
    }
}
