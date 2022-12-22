package jumio.p244lf;

import android.content.Context;
import android.graphics.Rect;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogUtils;
import com.jumio.core.data.document.DocumentFormat;
import com.jumio.core.enums.ErrorCase;
import com.jumio.core.error.Error;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.extraction.ExtractionUpdateState;
import com.jumio.core.extraction.linefinder.environment.LinefinderEnvironment;
import com.jumio.core.model.StaticModel;
import com.jumio.core.models.IDScanPartModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.network.ErrorMock;
import com.jumio.core.persistence.DataManager;
import com.jumio.jvision.jvcardfindjava.swig.DetectionEngine;
import com.jumio.jvision.jvcardfindjava.swig.DetectionInternalSettingsFactory;
import com.jumio.jvision.jvcardfindjava.swig.DetectionSettings;
import com.jumio.jvision.jvcardfindjava.swig.IntQuadrangle;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import java.security.InvalidParameterException;

/* renamed from: jumio.lf.a */
/* compiled from: LineFinderClient */
public class C21412a extends ExtractionClient {

    /* renamed from: g */
    public static int f59764g = 800;

    /* renamed from: h */
    public static int f59765h = 600;

    /* renamed from: a */
    public DetectionEngine f59766a;

    /* renamed from: b */
    public long f59767b = 0;

    /* renamed from: c */
    public DocumentFormat f59768c;

    /* renamed from: d */
    public ImageSource f59769d;

    /* renamed from: e */
    public IntQuadrangle f59770e;

    /* renamed from: f */
    public float f59771f = 0.0f;

    /* renamed from: jumio.lf.a$a */
    /* compiled from: LineFinderClient */
    public class C21413a implements StaticModel {
        public C21413a(C21412a aVar) {
        }
    }

    public C21412a(Context context) {
        super(context);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: boolean} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Incorrect type for immutable var: ssa=boolean, code=int, for r1v0, types: [int, boolean] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int mo175940a(int r1, boolean r2, boolean r3, boolean r4) {
        /*
            r0 = this;
            if (r2 == 0) goto L_0x0004
            int r1 = r1 + 1
        L_0x0004:
            if (r3 == 0) goto L_0x0008
            int r1 = r1 + 1
        L_0x0008:
            if (r4 == 0) goto L_0x000c
            int r1 = r1 + 1
        L_0x000c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.p244lf.C21412a.mo175940a(boolean, boolean, boolean, boolean):int");
    }

    /* renamed from: a */
    public final void mo175941a() {
        this.f59771f = 0.0f;
        ImageSource imageSource = this.f59769d;
        if (imageSource != null) {
            imageSource.delete();
            this.f59769d = null;
        }
        IntQuadrangle intQuadrangle = this.f59770e;
        if (intQuadrangle != null) {
            intQuadrangle.delete();
            this.f59770e = null;
        }
    }

    public void configure(DataManager dataManager, StaticModel staticModel) {
        super.configure(dataManager, staticModel);
        if (staticModel instanceof ScanPartModel) {
            this.f59768c = ((IDScanPartModel) staticModel).getFormat();
            return;
        }
        throw new InvalidParameterException("Configuration model should be an instance of ScanPartModel");
    }

    public void init(PreviewProperties previewProperties, Rect rect) {
        super.init(previewProperties, rect);
        LinefinderEnvironment.loadJniJvCardFindLib();
        double overlayLeft = this.f59768c.getOverlayLeft();
        double overlayTop = this.f59768c.getOverlayTop();
        double overlayRight = this.f59768c.getOverlayRight();
        double overlayBottom = this.f59768c.getOverlayBottom();
        DetectionSettings detectionSettings = new DetectionSettings();
        detectionSettings.setRoiLeftMargin(overlayLeft);
        detectionSettings.setRoiRightMargin(overlayRight);
        detectionSettings.setRoiTopMargin(overlayTop);
        detectionSettings.setRoiBottomMargin(overlayBottom);
        detectionSettings.setRoiVerticalDeviation(0.04d);
        detectionSettings.setRoiHorizontalDeviation(0.03d);
        try {
            ErrorMock.onOcrLoadingMock();
            String cardDetectionSettingsPath = LinefinderEnvironment.getCardDetectionSettingsPath(this.context);
            if (cardDetectionSettingsPath != null) {
                this.f59766a = new DetectionEngine(detectionSettings, DetectionInternalSettingsFactory.createFromFileSystem(cardDetectionSettingsPath));
                publishUpdate(new ExtractionClient.ExtractionUpdate(C21418d.f59786a, new C21417c(false, false, false, false, false, false)));
                this.f59767b = 0;
                return;
            }
            throw new Exception("Loading detection settings failed!");
        } catch (Exception unused) {
            publishError(new Error(ErrorCase.OCR_LOADING_FAILED));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x03cb  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x03d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void process(com.jumio.jvision.jvcorejava.swig.ImageSource r19, com.jumio.commons.camera.PreviewProperties r20, android.graphics.Rect r21) {
        /*
            r18 = this;
            r8 = r18
            r9 = r19
            r0 = r20
            java.lang.String r10 = ";"
            r1 = 800(0x320, float:1.121E-42)
            f59764g = r1
            r1 = 600(0x258, float:8.41E-43)
            f59765h = r1
            long r11 = java.lang.System.nanoTime()
            android.graphics.RectF r1 = com.jumio.commons.camera.CameraUtils.surfaceToPreview(r20, r21)
            int r2 = r21.height()
            float r2 = (float) r2
            int r3 = r21.width()
            float r3 = (float) r3
            float r2 = r2 / r3
            boolean r3 = r0.isPortrait
            r4 = 1145569280(0x44480000, float:800.0)
            r5 = 1142292480(0x44160000, float:600.0)
            r6 = 1061158912(0x3f400000, float:0.75)
            if (r3 == 0) goto L_0x005c
            float r3 = r1.width()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0047
            int r3 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r3 < 0) goto L_0x0047
            float r1 = r1.width()
            int r1 = (int) r1
            f59764g = r1
            float r1 = (float) r1
            float r1 = r1 * r6
            int r1 = (int) r1
            f59765h = r1
            goto L_0x008a
        L_0x0047:
            float r3 = r1.height()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x008a
            float r1 = r1.height()
            int r1 = (int) r1
            f59765h = r1
            float r1 = (float) r1
            float r1 = r1 / r6
            int r1 = (int) r1
            f59764g = r1
            goto L_0x008a
        L_0x005c:
            float r3 = r1.height()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x0075
            int r3 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r3 > 0) goto L_0x0075
            float r1 = r1.height()
            int r1 = (int) r1
            f59765h = r1
            float r1 = (float) r1
            float r1 = r1 / r6
            int r1 = (int) r1
            f59764g = r1
            goto L_0x008a
        L_0x0075:
            float r3 = r1.width()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x008a
            float r1 = r1.width()
            int r1 = (int) r1
            f59764g = r1
            float r1 = (float) r1
            float r1 = r1 * r6
            int r1 = (int) r1
            f59765h = r1
        L_0x008a:
            boolean r1 = r0.isPortrait
            if (r1 == 0) goto L_0x0093
            int r3 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x0093
            goto L_0x00a0
        L_0x0093:
            if (r1 != 0) goto L_0x009e
            int r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x009e
            float r2 = java.lang.Math.min(r6, r2)
            goto L_0x00a0
        L_0x009e:
            r2 = 1061158912(0x3f400000, float:0.75)
        L_0x00a0:
            com.jumio.commons.camera.Size r1 = new com.jumio.commons.camera.Size
            r3 = -1
            r1.<init>(r3, r3)
            r3 = r21
            com.jumio.jvision.jvcorejava.swig.ImageSource r14 = com.jumio.commons.camera.CameraUtils.yuv2rgb(r9, r0, r3, r2, r1)     // Catch:{ Exception -> 0x03c2, all -> 0x03bd }
            r0 = 1
            r1 = 0
            if (r14 != 0) goto L_0x00cd
            com.jumio.jvision.jvcorejava.swig.ImageSource[] r0 = new com.jumio.jvision.jvcorejava.swig.ImageSource[r0]     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            r0[r1] = r9     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            r8.cleanImages(r0)     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            r8.setResult(r1)     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            if (r14 == 0) goto L_0x00bf
            r14.delete()
        L_0x00bf:
            r19.delete()
            return
        L_0x00c3:
            r0 = move-exception
            r3 = r8
            r13 = r14
            goto L_0x03d3
        L_0x00c8:
            r0 = move-exception
            r3 = r8
            r13 = r14
            goto L_0x03c6
        L_0x00cd:
            float r15 = com.jumio.core.ImageQuality.calculateFocus(r14)     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            com.jumio.jvision.jvcardfindjava.swig.DetectionEngine r2 = r8.f59766a     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            com.jumio.jvision.jvcardfindjava.swig.DetectionResult r16 = r2.processImage(r14)     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            if (r16 == 0) goto L_0x039e
            boolean r2 = r16.hasTopOfCard()     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            boolean r3 = r16.hasBottomOfCard()     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            boolean r4 = r16.hasLeftOfCard()     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            boolean r5 = r16.hasRightOfCard()     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            int r2 = r8.mo175940a(r2, r3, r4, r5)     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            r3 = 3
            java.lang.String r7 = "LineFinderClient"
            if (r2 < r3) goto L_0x014f
            boolean r2 = r16.hasLeftOfCard()     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            if (r2 == 0) goto L_0x014f
            boolean r2 = r16.hasRightOfCard()     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            if (r2 == 0) goto L_0x014f
            float r2 = r8.f59771f     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            int r2 = (r15 > r2 ? 1 : (r15 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x014f
            com.jumio.commons.log.Log$LogLevel r2 = com.jumio.commons.log.Log.LogLevel.INFO     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            boolean r2 = com.jumio.commons.log.Log.isLogEnabledForLevel(r2)     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            if (r2 == 0) goto L_0x0128
            java.util.Locale r2 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            java.lang.String r3 = "Previous image focus value %f was replaced with new image focus value %f"
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            float r5 = r8.f59771f     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            r4[r1] = r5     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            java.lang.Float r1 = java.lang.Float.valueOf(r15)     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            r4[r0] = r1     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            java.lang.String r1 = java.lang.String.format(r2, r3, r4)     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            com.jumio.commons.log.Log.m39466i((java.lang.String) r7, (java.lang.String) r1)     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
        L_0x0128:
            r18.mo175941a()     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            r8.f59771f = r15     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            com.jumio.jvision.jvcorejava.swig.ImageSource r1 = new com.jumio.jvision.jvcorejava.swig.ImageSource     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            r1.<init>(r14)     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            r8.f59769d = r1     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            com.jumio.jvision.jvcardfindjava.swig.IntQuadrangle r1 = r16.getCardQuadrangle()     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            com.jumio.jvision.jvcardfindjava.swig.IntQuadrangle r2 = new com.jumio.jvision.jvcardfindjava.swig.IntQuadrangle     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            com.jumio.jvision.jvcardfindjava.swig.IntPoint r3 = r1.getTopLeft()     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            com.jumio.jvision.jvcardfindjava.swig.IntPoint r4 = r1.getTopRight()     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            com.jumio.jvision.jvcardfindjava.swig.IntPoint r5 = r1.getBottomRight()     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            com.jumio.jvision.jvcardfindjava.swig.IntPoint r1 = r1.getBottomLeft()     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            r2.<init>(r3, r4, r5, r1)     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            r8.f59770e = r2     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
        L_0x014f:
            boolean r2 = r16.hasTopOfCard()     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            boolean r3 = r16.hasBottomOfCard()     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            boolean r4 = r16.hasLeftOfCard()     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            boolean r5 = r16.hasRightOfCard()     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            boolean r6 = r16.getFlashTurnOn()     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            boolean r1 = r16.isCardImageOfGoodQuality()     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            r0 = r0 ^ r1
            r1 = r18
            r13 = r7
            r7 = r0
            boolean r1 = r1.mo175943a(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            if (r1 == 0) goto L_0x0396
            com.jumio.jvision.jvcardfindjava.swig.IntQuadrangle r0 = r8.f59770e     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            java.lang.String r2 = "\r\n"
            if (r0 == 0) goto L_0x02c7
            com.jumio.jvision.jvcardfindjava.swig.IntPoint r0 = r0.getTopLeft()     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            com.jumio.jvision.jvcardfindjava.swig.IntQuadrangle r3 = r8.f59770e     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            com.jumio.jvision.jvcardfindjava.swig.IntPoint r3 = r3.getTopRight()     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            com.jumio.jvision.jvcardfindjava.swig.IntQuadrangle r4 = r8.f59770e     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            com.jumio.jvision.jvcardfindjava.swig.IntPoint r4 = r4.getBottomLeft()     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            com.jumio.jvision.jvcardfindjava.swig.IntQuadrangle r5 = r8.f59770e     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            com.jumio.jvision.jvcardfindjava.swig.IntPoint r5 = r5.getBottomRight()     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            int r6 = r0.getX()     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            int r7 = r4.getX()     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            int r6 = java.lang.Math.min(r6, r7)     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            int r7 = r0.getY()     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            r20 = r1
            int r1 = r3.getY()     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            int r1 = java.lang.Math.min(r7, r1)     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            int r7 = r5.getX()     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            int r9 = r3.getX()     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            int r7 = java.lang.Math.max(r7, r9)     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            int r9 = r5.getY()     // Catch:{ Exception -> 0x03b6, all -> 0x03af }
            r21 = r14
            int r14 = r4.getY()     // Catch:{ Exception -> 0x02c3, all -> 0x02bf }
            int r9 = java.lang.Math.max(r9, r14)     // Catch:{ Exception -> 0x02c3, all -> 0x02bf }
            com.jumio.commons.log.Log$LogLevel r14 = com.jumio.commons.log.Log.LogLevel.VERBOSE     // Catch:{ Exception -> 0x02c3, all -> 0x02bf }
            boolean r14 = com.jumio.commons.log.Log.isLogEnabledForLevel(r14)     // Catch:{ Exception -> 0x02c3, all -> 0x02bf }
            if (r14 == 0) goto L_0x02b3
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r14.<init>()     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r17 = r15
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r15.<init>()     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            java.lang.String r8 = "topLeft: "
            r15.append(r8)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            int r8 = r0.getX()     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r15.append(r8)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r15.append(r10)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            int r0 = r0.getY()     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r15.append(r0)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            java.lang.String r0 = r15.toString()     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r14.append(r0)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r14.append(r2)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r0.<init>()     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            java.lang.String r8 = "topRight: "
            r0.append(r8)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            int r8 = r3.getX()     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r0.append(r8)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r0.append(r10)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            int r3 = r3.getY()     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r0.append(r3)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r14.append(r0)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r14.append(r2)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r0.<init>()     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            java.lang.String r3 = "bottomLeft: "
            r0.append(r3)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            int r3 = r4.getX()     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r0.append(r3)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r0.append(r10)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            int r3 = r4.getY()     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r0.append(r3)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r14.append(r0)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r14.append(r2)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r0.<init>()     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            java.lang.String r3 = "bottomRight: "
            r0.append(r3)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            int r3 = r5.getX()     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r0.append(r3)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r0.append(r10)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            int r3 = r5.getY()     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r0.append(r3)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r14.append(r0)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r14.append(r2)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r0.<init>()     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            java.lang.String r3 = "crop: "
            r0.append(r3)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r0.append(r6)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r0.append(r10)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r0.append(r1)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            java.lang.String r1 = " "
            r0.append(r1)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r0.append(r7)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r0.append(r10)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r0.append(r9)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r14.append(r0)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r14.append(r2)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            java.lang.String r0 = r14.toString()     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r1.<init>()     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            r1.append(r11)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            java.lang.String r3 = "ocr_rectrangle.txt"
            r1.append(r3)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            com.jumio.commons.log.LogUtils.logInfoInSubfolder(r0, r13, r1)     // Catch:{ Exception -> 0x02ae, all -> 0x02a9 }
            goto L_0x02b5
        L_0x02a9:
            r0 = move-exception
            r3 = r18
            goto L_0x03b3
        L_0x02ae:
            r0 = move-exception
            r3 = r18
            goto L_0x03ba
        L_0x02b3:
            r17 = r15
        L_0x02b5:
            r3 = r18
            com.jumio.jvision.jvcorejava.swig.ImageSource r0 = r3.f59769d     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r1 = r17
            r3.mo175942a(r0, r1)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            goto L_0x02cc
        L_0x02bf:
            r0 = move-exception
            r3 = r8
            goto L_0x03b3
        L_0x02c3:
            r0 = move-exception
            r3 = r8
            goto L_0x03ba
        L_0x02c7:
            r20 = r1
            r3 = r8
            r21 = r14
        L_0x02cc:
            com.jumio.commons.log.Log$LogLevel r0 = com.jumio.commons.log.Log.LogLevel.INFO     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            boolean r0 = com.jumio.commons.log.Log.isLogEnabledForLevel(r0)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            if (r0 == 0) goto L_0x039b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r0.<init>()     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r1.<init>()     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.String r4 = "hasTopOfCard(): "
            r1.append(r4)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            boolean r4 = r16.hasTopOfCard()     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.String r4 = java.lang.Boolean.toString(r4)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r1.append(r4)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r0.append(r1)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r1.<init>()     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.String r4 = "hasBottomOfCard(): "
            r1.append(r4)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            boolean r4 = r16.hasBottomOfCard()     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.String r4 = java.lang.Boolean.toString(r4)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r1.append(r4)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r0.append(r1)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r1.<init>()     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.String r4 = "hasLeftOfCard(): "
            r1.append(r4)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            boolean r4 = r16.hasLeftOfCard()     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.String r4 = java.lang.Boolean.toString(r4)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r1.append(r4)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r0.append(r1)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r1.<init>()     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.String r4 = "hasRightOfCard(): "
            r1.append(r4)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            boolean r4 = r16.hasRightOfCard()     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.String r4 = java.lang.Boolean.toString(r4)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r1.append(r4)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r0.append(r1)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r1.<init>()     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.String r4 = "getFlashTurnOn(): "
            r1.append(r4)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            boolean r4 = r16.getFlashTurnOn()     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.String r4 = java.lang.Boolean.toString(r4)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r1.append(r4)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r0.append(r1)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r1.<init>()     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.String r4 = "isCardImageOfGoodQuality(): "
            r1.append(r4)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            boolean r4 = r16.isCardImageOfGoodQuality()     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.String r4 = java.lang.Boolean.toString(r4)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r1.append(r4)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r0.append(r1)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r0.append(r2)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            com.jumio.commons.log.LogUtils.LineFinder.logLineCount(r0)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            java.lang.Class<jumio.lf.a> r1 = jumio.p244lf.C21412a.class
            java.lang.String r1 = r1.getSimpleName()     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r2 = 0
            com.jumio.commons.log.LogUtils.logInfoInSubfolder(r0, r1, r2)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            goto L_0x039b
        L_0x0396:
            r20 = r1
            r3 = r8
            r21 = r14
        L_0x039b:
            r1 = r20
            goto L_0x03a1
        L_0x039e:
            r3 = r8
            r21 = r14
        L_0x03a1:
            r3.setResult(r1)     // Catch:{ Exception -> 0x03ad, all -> 0x03ab }
            r21.delete()
            r19.delete()
            goto L_0x03d1
        L_0x03ab:
            r0 = move-exception
            goto L_0x03b3
        L_0x03ad:
            r0 = move-exception
            goto L_0x03ba
        L_0x03af:
            r0 = move-exception
            r3 = r8
            r21 = r14
        L_0x03b3:
            r13 = r21
            goto L_0x03d3
        L_0x03b6:
            r0 = move-exception
            r3 = r8
            r21 = r14
        L_0x03ba:
            r13 = r21
            goto L_0x03c6
        L_0x03bd:
            r0 = move-exception
            r3 = r8
            r2 = 0
            r13 = r2
            goto L_0x03d3
        L_0x03c2:
            r0 = move-exception
            r3 = r8
            r2 = 0
            r13 = r2
        L_0x03c6:
            com.jumio.commons.log.Log.printStackTrace(r0)     // Catch:{ all -> 0x03d2 }
            if (r13 == 0) goto L_0x03ce
            r13.delete()
        L_0x03ce:
            r19.delete()
        L_0x03d1:
            return
        L_0x03d2:
            r0 = move-exception
        L_0x03d3:
            if (r13 == 0) goto L_0x03d8
            r13.delete()
        L_0x03d8:
            r19.delete()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.p244lf.C21412a.process(com.jumio.jvision.jvcorejava.swig.ImageSource, com.jumio.commons.camera.PreviewProperties, android.graphics.Rect):void");
    }

    public boolean shouldFeed() {
        return this.f59766a != null;
    }

    /* renamed from: a */
    public final boolean mo175943a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        publishUpdate(new ExtractionClient.ExtractionUpdate(C21418d.f59786a, new C21417c(z4, z3, z, z2, z5, z6)));
        int a = mo175940a(z, z2, z3, z4);
        if (a < 3 || !z3 || !z4 || z6) {
            this.f59767b = 0;
            mo175941a();
            if (Log.isLogEnabledForLevel(Log.LogLevel.INFO)) {
                LogUtils.LineFinder.resetLineCount();
            }
            return false;
        }
        if (this.f59767b == 0) {
            this.f59767b = System.currentTimeMillis();
        }
        if (Log.isLogEnabledForLevel(Log.LogLevel.INFO)) {
            LogUtils.LineFinder.saveLineCount(a);
        }
        if (System.currentTimeMillis() >= this.f59767b + 400) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final void mo175942a(ImageSource imageSource, float f) {
        publishUpdate(new ExtractionClient.ExtractionUpdate(ExtractionUpdateState.shotTaken, Float.valueOf(f)));
        publishUpdate(new ExtractionClient.ExtractionUpdate(C21418d.f59786a, new C21417c(true, true, true, true, false, false)));
        publishUpdate(new ExtractionClient.ExtractionUpdate(ExtractionUpdateState.saveImage, CameraUtils.rgb2bitmap(imageSource)));
        mo175941a();
        publishResult(new C21413a(this));
        System.gc();
    }
}
