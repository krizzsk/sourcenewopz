package com.didi.payment.utilities.scan.widget;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.didi.dqr.SoLoader;
import com.didi.global.globalgenerickit.utils.UIThreadHandler;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.utilities.scan.collect.CollectionConstant;
import com.didi.payment.utilities.scan.collect.CollectionManager;
import com.didi.payment.utilities.scan.utils.PreviewCollectionUtils;
import com.didi.payment.utilities.scan.utils.PreviewImageUtils;
import com.didi.payment.utilities.scan.utils.ZbarSoLoader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import net.sourceforge.zbar.Image;
import net.sourceforge.zbar.ImageScanner;
import net.sourceforge.zbar.Symbol;
import p065me.dm7.barcodescanner.core.BarcodeScannerView;
import p065me.dm7.barcodescanner.core.CameraWrapper;
import p065me.dm7.barcodescanner.zbar.BarcodeFormat;
import p065me.dm7.barcodescanner.zbar.Result;

public class CsI25ZBarScannerView extends BarcodeScannerView {

    /* renamed from: a */
    private static final String f31702a = "ZBarScannerView";

    /* renamed from: b */
    private ImageScanner f31703b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ResultHandler f31704c;

    /* renamed from: d */
    private boolean f31705d;

    /* renamed from: e */
    private boolean f31706e;

    /* renamed from: f */
    private Rect f31707f;

    /* renamed from: g */
    private boolean f31708g;

    /* renamed from: h */
    private boolean f31709h;

    /* renamed from: i */
    private volatile boolean f31710i;

    /* renamed from: j */
    private float f31711j;

    /* renamed from: k */
    private int f31712k;

    /* renamed from: l */
    private boolean f31713l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public EventListener f31714m;

    /* renamed from: n */
    private CollectionManager f31715n;

    /* renamed from: o */
    private CameraWrapper f31716o;

    public interface EventListener {
        void onPreviewUploadDone();

        void onQRCodeFound();

        void onScanningActionTracked();
    }

    public interface ResultHandler {
        boolean handleResult(Result result);
    }

    static {
        ZbarSoLoader.load();
        SoLoader.load();
    }

    public CsI25ZBarScannerView(Context context) {
        super(context);
        m22485a();
    }

    public CsI25ZBarScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22485a();
    }

    public void setResultHandler(ResultHandler resultHandler) {
        this.f31704c = resultHandler;
    }

    public void setEventListener(EventListener eventListener) {
        this.f31714m = eventListener;
    }

    public void doUploadOnceInNextPreview() {
        this.f31710i = true;
    }

    /* renamed from: a */
    private void m22485a() {
        if (!ZbarSoLoader.loadSoError) {
            this.f31705d = WalletApolloUtil.getStatus("ibt_wallet_one_barcode_reg_toggle");
            boolean status = WalletApolloUtil.getStatus(CollectionConstant.APOLLO_ID);
            this.f31708g = status;
            if (status) {
                this.f31715n = new CollectionManager();
            }
            boolean boletoScanOptTimeoutFlag = WalletApolloUtil.getBoletoScanOptTimeoutFlag();
            this.f31709h = boletoScanOptTimeoutFlag;
            if (boletoScanOptTimeoutFlag) {
                this.f31711j = WalletApolloUtil.getBoletoScanOptTimeoutRatio();
                this.f31712k = WalletApolloUtil.getBoletoScanOptTimeoutQuality();
            }
            this.f31713l = WalletApolloUtil.getBoletoScanOptQRTipsFlag();
            try {
                ImageScanner imageScanner = new ImageScanner();
                this.f31703b = imageScanner;
                imageScanner.setConfig(0, 256, 1);
                this.f31703b.setConfig(0, 257, 1);
                this.f31703b.setConfig(0, 0, 0);
                this.f31703b.setConfig(25, 0, 1);
                this.f31703b.setConfig(38, 0, 1);
                this.f31703b.setConfig(128, 0, 1);
                this.f31703b.setConfig(25, 32, 44);
                this.f31703b.setConfig(38, 32, 44);
                this.f31703b.setConfig(128, 32, 44);
                if (this.f31713l) {
                    this.f31703b.setConfig(64, 0, 1);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                ZbarSoLoader.loadSoError = true;
                HashMap hashMap = new HashMap();
                hashMap.put("error", th.getCause());
                PayTracker.trackEvent("ibt_gp_scan_zbar_so_load_error_bt", hashMap);
            }
            setAutoFocus(true);
        }
    }

    public void setMexicoScannerType() {
        for (BarcodeFormat next : BarcodeFormat.ALL_FORMATS) {
            this.f31703b.setConfig(next.getId(), 0, 1);
            this.f31703b.setConfig(next.getId(), 32, 10);
            this.f31703b.setConfig(next.getId(), 33, 33);
        }
    }

    public void setupCameraPreview(CameraWrapper cameraWrapper) {
        super.setupCameraPreview(cameraWrapper);
        this.f31716o = cameraWrapper;
    }

    public void stopCamera() {
        super.stopCamera();
        this.f31716o = null;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        int i;
        BarcodeFormat barcodeFormat;
        if (this.f31704c != null && !ZbarSoLoader.loadSoError) {
            try {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                int i2 = previewSize.width;
                int i3 = previewSize.height;
                PreviewImageUtils.BarcodeFeatureModel b = m22489b(bArr, i2, i3);
                Rect rect = (b == null || b.rect == null) ? this.f31707f : b.rect;
                this.f31707f = rect;
                if (rect != null) {
                    byte[] clipData = PreviewImageUtils.clipData(bArr, i2, i3, rect.left, this.f31707f.top, this.f31707f.width(), this.f31707f.height());
                    Image image = new Image(this.f31707f.width(), this.f31707f.height(), "Y800");
                    image.setData(clipData);
                    i = this.f31703b.scanImage(image);
                    if (i != 0) {
                        System.out.println("crop hit!!!!!!!!!");
                    }
                } else {
                    i = 0;
                }
                if (i == 0) {
                    Image image2 = new Image(i2, i3, "Y800");
                    image2.setData(bArr);
                    i = this.f31703b.scanImage(image2);
                }
                if (this.f31710i) {
                    m22487a(bArr, i2, i3);
                }
                if (i == 0) {
                    m22488a(bArr, i2, i3, b, false);
                    camera.setOneShotPreviewCallback(this);
                    return;
                }
                Result b2 = m22491b();
                if (TextUtils.isEmpty(b2.getContents())) {
                    m22488a(bArr, i2, i3, b, false);
                    camera.setOneShotPreviewCallback(this);
                } else if (!this.f31713l || (barcodeFormat = b2.getBarcodeFormat()) == null || barcodeFormat.getId() != 64) {
                    m22488a(bArr, i2, i3, b, true);
                    if (!this.f31706e) {
                        this.f31706e = true;
                        PayTracker.getTracker().trackEvent("ibt_boleto_scan_scanning_action_bt");
                    }
                    m22486a(b2);
                } else {
                    m22492c();
                    m22488a(bArr, i2, i3, b, false);
                    camera.setOneShotPreviewCallback(this);
                }
            } catch (Throwable th) {
                this.f31705d = false;
                this.f31708g = false;
                this.f31715n = null;
                try {
                    camera.setOneShotPreviewCallback(this);
                } catch (Exception unused) {
                }
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m22487a(byte[] bArr, int i, int i2) {
        this.f31710i = false;
        if (this.f31709h) {
            String compressData = PreviewCollectionUtils.compressData(bArr, i, i2, this.f31711j, this.f31712k);
            HashMap hashMap = new HashMap();
            hashMap.put("data", compressData);
            hashMap.put("action_tracked", Integer.valueOf(this.f31706e ? 1 : 0));
            PayTracker.trackEvent("ibt_boleto_scan_preview_upload_once_bt", hashMap);
            m22494e();
        }
    }

    /* renamed from: a */
    private void m22488a(byte[] bArr, int i, int i2, PreviewImageUtils.BarcodeFeatureModel barcodeFeatureModel, boolean z) {
        CollectionManager collectionManager;
        if (this.f31708g && (collectionManager = this.f31715n) != null) {
            collectionManager.collectIfNeeded(bArr, i, i2, barcodeFeatureModel != null && barcodeFeatureModel.hasBarcodeFeature, z);
        }
    }

    /* renamed from: b */
    private PreviewImageUtils.BarcodeFeatureModel m22489b(byte[] bArr, int i, int i2) {
        if (SoLoader.loadLibraryError || !this.f31705d) {
            return null;
        }
        PreviewImageUtils.BarcodeFeatureModel checkOneBarcodeFeature = PreviewImageUtils.checkOneBarcodeFeature(bArr, i, i2);
        if (!this.f31706e && checkOneBarcodeFeature != null && checkOneBarcodeFeature.hasBarcodeFeature) {
            this.f31706e = true;
            System.out.println("scanning barcode!!!!!!!!!!!!!!!");
            PayTracker.getTracker().trackEvent("ibt_boleto_scan_scanning_action_bt");
            PayTracker.getTracker().trackEvent("ibt_boleto_scan_scanning_real_bt");
            m22493d();
        }
        return checkOneBarcodeFeature;
    }

    /* renamed from: b */
    private Result m22491b() {
        String str;
        Result result = new Result();
        Iterator<Symbol> it = this.f31703b.getResults().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Symbol next = it.next();
            if (Build.VERSION.SDK_INT >= 19) {
                str = new String(next.getDataBytes(), StandardCharsets.UTF_8);
            } else {
                str = next.getData();
            }
            if (!TextUtils.isEmpty(str)) {
                result.setContents(str);
                result.setBarcodeFormat(BarcodeFormat.getFormatById(next.getType()));
                break;
            }
        }
        return result;
    }

    /* renamed from: a */
    private void m22486a(final Result result) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                if (CsI25ZBarScannerView.this.f31704c != null && CsI25ZBarScannerView.this.f31704c.handleResult(result)) {
                    CsI25ZBarScannerView.this.stopCameraPreview();
                    ResultHandler unused = CsI25ZBarScannerView.this.f31704c = null;
                }
            }
        });
    }

    public void resumeCameraPreview(ResultHandler resultHandler) {
        this.f31704c = resultHandler;
        super.resumeCameraPreview();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f31715n;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasCollectedData() {
        /*
            r1 = this;
            boolean r0 = r1.f31708g
            if (r0 == 0) goto L_0x0010
            com.didi.payment.utilities.scan.collect.CollectionManager r0 = r1.f31715n
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.hasCollectedData()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.utilities.scan.widget.CsI25ZBarScannerView.hasCollectedData():boolean");
    }

    public void dumpCollectedData(boolean z) {
        CollectionManager collectionManager;
        if (this.f31708g && (collectionManager = this.f31715n) != null) {
            collectionManager.dump(z);
        }
    }

    /* renamed from: c */
    private void m22492c() {
        UIThreadHandler.post(new Runnable() {
            public void run() {
                if (CsI25ZBarScannerView.this.f31714m != null) {
                    CsI25ZBarScannerView.this.f31714m.onQRCodeFound();
                }
            }
        });
    }

    /* renamed from: d */
    private void m22493d() {
        UIThreadHandler.post(new Runnable() {
            public void run() {
                if (CsI25ZBarScannerView.this.f31714m != null) {
                    CsI25ZBarScannerView.this.f31714m.onScanningActionTracked();
                }
            }
        });
    }

    /* renamed from: e */
    private void m22494e() {
        UIThreadHandler.post(new Runnable() {
            public void run() {
                if (CsI25ZBarScannerView.this.f31714m != null) {
                    CsI25ZBarScannerView.this.f31714m.onPreviewUploadDone();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void setZoom(boolean z) {
        Camera camera;
        Camera.Parameters parameters;
        CameraWrapper cameraWrapper = this.f31716o;
        if (cameraWrapper != null && (camera = cameraWrapper.mCamera) != null && (parameters = camera.getParameters()) != null && parameters.isZoomSupported()) {
            int maxZoom = parameters.getMaxZoom();
            int zoom = parameters.getZoom();
            if (z && zoom < maxZoom) {
                zoom++;
            } else if (zoom > 0) {
                zoom--;
            }
            parameters.setZoom(zoom);
            camera.setParameters(parameters);
        }
    }
}
