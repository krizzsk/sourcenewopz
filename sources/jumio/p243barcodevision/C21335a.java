package jumio.p243barcodevision;

import android.content.Context;
import android.graphics.Rect;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.barcode.Barcode;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.log.Log;
import com.jumio.core.enums.ErrorCase;
import com.jumio.core.error.Error;
import com.jumio.core.extraction.barcode.BaseBarcodeClient;
import com.jumio.core.model.StaticModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.network.ErrorMock;
import com.jumio.core.persistence.DataManager;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;

/* renamed from: jumio.barcode-vision.a */
/* compiled from: BarcodeVisionClient.kt */
public final class C21335a extends BaseBarcodeClient {

    /* renamed from: a */
    public final String f59569a = "javaClass";

    /* renamed from: b */
    public BarcodeScanner f59570b;

    /* renamed from: c */
    public Object f59571c = new Object();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C21335a(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* renamed from: a */
    public static final void m42085a(C21335a aVar, PreviewProperties previewProperties, Rect rect, Ref.BooleanRef booleanRef, int i, int i2, List list) {
        String str;
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        Intrinsics.checkNotNullParameter(previewProperties, "$previewProperties");
        Intrinsics.checkNotNullParameter(rect, "$extractionArea");
        Intrinsics.checkNotNullParameter(booleanRef, "$result");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            byte[] rawBytes = ((Barcode) it.next()).getRawBytes();
            if (rawBytes != null) {
                try {
                    str = new String(rawBytes, Charsets.ISO_8859_1);
                } catch (Exception unused) {
                    str = new String(rawBytes, Charsets.UTF_8);
                }
                booleanRef.element = aVar.onFinished(str, CameraUtils.yuv2bitmap(aVar.imageSource, previewProperties.isPortrait, previewProperties, rect, -1), i, i2);
                ImageSource imageSource = aVar.imageSource;
                if (imageSource != null) {
                    imageSource.delete();
                    aVar.imageSource = null;
                }
                Log.m39456d(aVar.f59569a, "Success completed");
                aVar.setResult(booleanRef.element);
                return;
            }
        }
    }

    public void configure(DataManager dataManager, StaticModel staticModel) {
        Intrinsics.checkNotNullParameter(dataManager, "dataManager");
        Intrinsics.checkNotNullParameter(staticModel, "configurationModel");
        try {
            super.configure(dataManager, staticModel);
            if (staticModel instanceof ScanPartModel) {
                ErrorMock.onOcrLoadingMock();
                BarcodeScannerOptions build = new BarcodeScannerOptions.Builder().setBarcodeFormats(2048, new int[0]).build();
                Intrinsics.checkNotNullExpressionValue(build, "Builder().setBarcodeForm…RMAT_PDF417\n\t\t\t\t).build()");
                this.f59570b = BarcodeScanning.getClient(build);
                System.currentTimeMillis();
                return;
            }
            throw new IllegalArgumentException("Configuration model should be an instance of ScanPartModel");
        } catch (Exception unused) {
            publishError(new Error(ErrorCase.OCR_LOADING_FAILED, 0, 0, 6, (DefaultConstructorMarker) null));
        }
    }

    public void destroy() {
        super.destroy();
        synchronized (this.f59571c) {
            BarcodeScanner barcodeScanner = this.f59570b;
            if (barcodeScanner != null) {
                if (barcodeScanner != null) {
                    barcodeScanner.close();
                }
                this.f59570b = null;
            }
            ImageSource imageSource = this.imageSource;
            if (imageSource != null) {
                if (imageSource != null) {
                    imageSource.delete();
                }
                this.imageSource = null;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0069, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006a, code lost:
        com.jumio.commons.log.Log.m39463e(r9.f59569a, (java.lang.Throwable) r10);
        r10 = r9.imageSource;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0071, code lost:
        if (r10 != null) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0073, code lost:
        r10.delete();
        r9.imageSource = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0079, code lost:
        setResult(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void process(com.jumio.jvision.jvcorejava.swig.ImageSource r10, com.jumio.commons.camera.PreviewProperties r11, android.graphics.Rect r12) {
        /*
            r9 = this;
            java.lang.String r0 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "previewProperties"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "extractionArea"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            com.jumio.commons.camera.Size r0 = r11.camera
            int r6 = r0.width
            int r7 = r0.height
            com.jumio.jvision.jvcorejava.swig.Image r0 = r10.getImage()
            byte[] r0 = r0.toBytes()
            kotlin.jvm.internal.Ref$BooleanRef r5 = new kotlin.jvm.internal.Ref$BooleanRef
            r5.<init>()
            r9.imageSource = r10     // Catch:{ Exception -> 0x0069 }
            int r10 = r11.orientation     // Catch:{ Exception -> 0x0069 }
            r1 = 17
            com.google.mlkit.vision.common.InputImage r10 = com.google.mlkit.vision.common.InputImage.fromByteArray(r0, r6, r7, r10, r1)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r0 = "fromByteArray(dataBytes,…tImage.IMAGE_FORMAT_NV21)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r0 = r9.f59571c     // Catch:{ Exception -> 0x0069 }
            monitor-enter(r0)     // Catch:{ Exception -> 0x0069 }
            com.google.mlkit.vision.barcode.BarcodeScanner r1 = r9.f59570b     // Catch:{ all -> 0x0066 }
            if (r1 != 0) goto L_0x0039
            goto L_0x0064
        L_0x0039:
            com.google.android.gms.tasks.Task r10 = r1.process(r10)     // Catch:{ all -> 0x0066 }
            if (r10 != 0) goto L_0x0040
            goto L_0x0064
        L_0x0040:
            jumio.barcode-vision.-$$Lambda$XN95wNKI0dykUSLTQUB_2zseHfA r8 = new jumio.barcode-vision.-$$Lambda$XN95wNKI0dykUSLTQUB_2zseHfA     // Catch:{ all -> 0x0066 }
            r1 = r8
            r2 = r9
            r3 = r11
            r4 = r12
            r1.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0066 }
            com.google.android.gms.tasks.Task r10 = r10.addOnSuccessListener(r8)     // Catch:{ all -> 0x0066 }
            if (r10 != 0) goto L_0x0050
            goto L_0x0064
        L_0x0050:
            jumio.barcode-vision.-$$Lambda$PLYQaTNtGVAfhMT0J3__QVSIOLE r11 = new jumio.barcode-vision.-$$Lambda$PLYQaTNtGVAfhMT0J3__QVSIOLE     // Catch:{ all -> 0x0066 }
            r11.<init>()     // Catch:{ all -> 0x0066 }
            com.google.android.gms.tasks.Task r10 = r10.addOnFailureListener(r11)     // Catch:{ all -> 0x0066 }
            if (r10 != 0) goto L_0x005c
            goto L_0x0064
        L_0x005c:
            jumio.barcode-vision.-$$Lambda$wHpBihcckNmTlPf9kZP-Vp3qRbY r11 = new jumio.barcode-vision.-$$Lambda$wHpBihcckNmTlPf9kZP-Vp3qRbY     // Catch:{ all -> 0x0066 }
            r11.<init>()     // Catch:{ all -> 0x0066 }
            r10.addOnCompleteListener(r11)     // Catch:{ all -> 0x0066 }
        L_0x0064:
            monitor-exit(r0)     // Catch:{ Exception -> 0x0069 }
            goto L_0x007d
        L_0x0066:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ Exception -> 0x0069 }
            throw r10     // Catch:{ Exception -> 0x0069 }
        L_0x0069:
            r10 = move-exception
            java.lang.String r11 = r9.f59569a
            com.jumio.commons.log.Log.m39463e((java.lang.String) r11, (java.lang.Throwable) r10)
            com.jumio.jvision.jvcorejava.swig.ImageSource r10 = r9.imageSource
            if (r10 == 0) goto L_0x0079
            r10.delete()
            r10 = 0
            r9.imageSource = r10
        L_0x0079:
            r10 = 0
            r9.setResult(r10)
        L_0x007d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.p243barcodevision.C21335a.process(com.jumio.jvision.jvcorejava.swig.ImageSource, com.jumio.commons.camera.PreviewProperties, android.graphics.Rect):void");
    }

    public boolean shouldFeed() {
        return this.f59570b != null;
    }

    /* renamed from: a */
    public static final void m42086a(C21335a aVar, Exception exc) {
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        Log.m39456d(aVar.f59569a, Intrinsics.stringPlus("Barcode scanner failed: ", exc.getLocalizedMessage()));
        aVar.imageSource = null;
        aVar.setResult(false);
    }

    /* renamed from: a */
    public static final void m42084a(C21335a aVar, Task task) {
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        Log.m39456d(aVar.f59569a, "Progress completed");
        ImageSource imageSource = aVar.imageSource;
        if (imageSource != null) {
            imageSource.delete();
            aVar.imageSource = null;
            aVar.setResult(false);
        }
    }
}
