package com.didi.zxing.barcodescanner;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.qrcode.detector.FinderPattern;
import com.didi.dqrutil.DqrConfigHelper;
import com.didi.dqrutil.DqrDecodeConfig;
import com.didi.dqrutil.analysis.AnalysisManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.util.DecodeConfigUtil;
import com.didi.zxing.barcodescanner.scale.ScaleGestureDetector;
import com.didi.zxing.client.BeepManager;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class BarcodeView extends CameraPreview {

    /* renamed from: a */
    private static final String f45204a = "BarcodeView";

    /* renamed from: b */
    private String f45205b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DecodeMode f45206c = DecodeMode.NONE;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public BarcodeCallback f45207d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public DecodeThreadInter f45208e;

    /* renamed from: f */
    private DecoderFactory f45209f;

    /* renamed from: g */
    private Handler f45210g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public float f45211h = 1.0f;

    /* renamed from: i */
    private Rect f45212i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public BeepManager f45213j;

    /* renamed from: k */
    private final Handler.Callback f45214k = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what == R.id.zxing_decode_succeeded) {
                BarcodeResult barcodeResult = (BarcodeResult) message.obj;
                if (!(barcodeResult == null || BarcodeView.this.f45207d == null || BarcodeView.this.f45206c == DecodeMode.NONE)) {
                    BarcodeView.this.f45213j.playBeepSoundAndVibrate();
                    BarcodeView.this.f45207d.barcodeResult(barcodeResult);
                    if (BarcodeView.this.f45206c == DecodeMode.SINGLE) {
                        BarcodeView.this.stopDecoding();
                    }
                }
                return true;
            } else if (message.what == R.id.zxing_decode_failed) {
                return true;
            } else {
                if (message.what != R.id.zxing_possible_result_points) {
                    return false;
                }
                DecodeConfig config = DecodeConfigUtil.getConfig();
                if (config != null && config.autoZoom()) {
                    FinderPattern finderPattern = (FinderPattern) message.obj;
                    float dip2px = (float) C14921Util.dip2px(BarcodeView.this.getContext(), (float) config.zoomMinDp());
                    float estimatedModuleSize = finderPattern.getEstimatedModuleSize();
                    if (finderPattern.getEstimatedModuleSize() < dip2px) {
                        BarcodeView.this.setZoom(dip2px / estimatedModuleSize);
                    }
                }
                return true;
            }
        }
    };

    private enum DecodeMode {
        NONE,
        SINGLE,
        CONTINUOUS
    }

    public void setZoom(float f) {
        try {
            if (getCameraInstance() == null) {
                return;
            }
            if (getCameraInstance().getCameraManager() != null) {
                Camera camera = getCameraInstance().getCameraManager().getCamera();
                if (camera != null) {
                    Camera.Parameters parameters = camera.getParameters();
                    if (camera == null) {
                        return;
                    }
                    if (parameters.isZoomSupported()) {
                        int maxZoom = parameters.getMaxZoom();
                        int a = m32467a(f, camera);
                        this.f45211h = ((float) camera.getParameters().getZoomRatios().get(a).intValue()) / 100.0f;
                        if (a <= maxZoom) {
                            maxZoom = a;
                        }
                        if (parameters.isSmoothZoomSupported()) {
                            camera.startSmoothZoom(maxZoom);
                            return;
                        }
                        parameters.setZoom(maxZoom);
                        camera.setParameters(parameters);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private int m32467a(float f, Camera camera) {
        List<Integer> zoomRatios = camera.getParameters().getZoomRatios();
        int i = (int) (f * 100.0f);
        int i2 = 0;
        while (true) {
            if (i2 >= zoomRatios.size()) {
                i2 = -1;
                break;
            } else if (zoomRatios.get(i2).intValue() >= i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        if (i > zoomRatios.get(zoomRatios.size() - 1).intValue()) {
            return zoomRatios.size() - 1;
        }
        return 0;
    }

    public BarcodeView(Context context) {
        super(context);
        m32469a();
    }

    public BarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m32469a();
    }

    public BarcodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m32469a();
    }

    /* renamed from: a */
    private void m32469a() {
        final DecodeConfig config = DecodeConfigUtil.getConfig();
        if (config != null && config.analysisDqr()) {
            AnalysisManager.init(config.getAnalysis());
        }
        this.f45209f = new DefaultDecoderFactory(config != null ? config.extraBarcodeFormats() : "");
        this.f45210g = new Handler(this.f45214k);
        this.f45213j = new BeepManager(getContext());
        if (config != null && config.autoZoom()) {
            setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (BarcodeView.this.f45211h > 1.0f) {
                        if (BarcodeView.this.f45208e != null) {
                            BarcodeView.this.f45208e.setCheckPattern(true);
                        }
                        BarcodeView.this.setZoom(1.0f);
                        return;
                    }
                    if (BarcodeView.this.f45208e != null) {
                        BarcodeView.this.f45208e.setCheckPattern(false);
                    }
                    DecodeConfig decodeConfig = config;
                    if (decodeConfig != null) {
                        BarcodeView.this.setZoom((float) decodeConfig.zoomSize());
                    }
                }
            });
        }
        final ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleGestureDetector.OnScaleGestureListener() {
            float lastScale = 1.0f;

            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                BarcodeView barcodeView = BarcodeView.this;
                barcodeView.setZoom(barcodeView.f45211h + ((scaleFactor - this.lastScale) * 4.0f));
                this.lastScale = scaleFactor;
                return false;
            }

            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                this.lastScale = 1.0f;
            }
        });
        setOnTouchListener(new View.OnTouchListener() {
            long lastClick;
            long lastUp;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    if (SystemClock.elapsedRealtime() - this.lastUp >= 500 || SystemClock.elapsedRealtime() - this.lastClick <= 1000) {
                        this.lastUp = SystemClock.elapsedRealtime();
                    } else {
                        this.lastClick = SystemClock.elapsedRealtime();
                        view.performClick();
                    }
                }
                return scaleGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    public void setDecoderFactory(DecoderFactory decoderFactory) {
        C14921Util.validateMainThread();
        this.f45209f = decoderFactory;
        DecodeThreadInter decodeThreadInter = this.f45208e;
        if (decodeThreadInter != null) {
            decodeThreadInter.setDecoder(m32471b());
        }
    }

    /* renamed from: b */
    private Decoder m32471b() {
        if (this.f45209f == null) {
            this.f45209f = createDefaultDecoderFactory();
        }
        return this.f45209f.createDecoder(new HashMap());
    }

    public DecoderFactory getDecoderFactory() {
        return this.f45209f;
    }

    public void decodeSingle(BarcodeCallback barcodeCallback) {
        this.f45206c = DecodeMode.SINGLE;
        this.f45207d = barcodeCallback;
        startDecoderThread();
    }

    public void decodeContinuous(BarcodeCallback barcodeCallback) {
        this.f45206c = DecodeMode.CONTINUOUS;
        this.f45207d = barcodeCallback;
        startDecoderThread();
    }

    public void stopDecoding() {
        this.f45206c = DecodeMode.NONE;
        this.f45207d = null;
        m32473c();
    }

    /* access modifiers changed from: protected */
    public DecoderFactory createDefaultDecoderFactory() {
        return new DefaultDecoderFactory();
    }

    public void startDecoderThread() {
        m32473c();
        if (this.f45206c != DecodeMode.NONE && isPreviewActive()) {
            DecodeConfig config = DecodeConfigUtil.getConfig();
            if (config != null) {
                DqrConfigHelper.init(config);
            }
            SystemUtils.log(4, f45204a, "useMultiThread", (Throwable) null, "com.didi.zxing.barcodescanner.BarcodeView", 328);
            MultiDecoderThread multiDecoderThread = new MultiDecoderThread(getContext(), getCameraInstance(), m32471b(), this.f45210g);
            this.f45208e = multiDecoderThread;
            Rect rect = this.f45212i;
            if (rect != null) {
                multiDecoderThread.setCropRect(rect);
            } else {
                multiDecoderThread.setCropRect(getPreviewFramingRect());
            }
            this.f45208e.setProductId(this.f45205b);
            this.f45208e.start();
        }
    }

    public void setCropRect(Rect rect) {
        if (rect != null && rect.width() > 0 && rect.height() > 0) {
            this.f45212i = rect;
            DecodeThreadInter decodeThreadInter = this.f45208e;
            if (decodeThreadInter != null) {
                decodeThreadInter.setCropRect(rect);
            }
        }
    }

    public void resume() {
        super.resume();
    }

    /* access modifiers changed from: protected */
    public void previewStarted() {
        super.previewStarted();
        startDecoderThread();
    }

    /* renamed from: c */
    private void m32473c() {
        DecodeThreadInter decodeThreadInter = this.f45208e;
        if (decodeThreadInter != null) {
            decodeThreadInter.stop();
            this.f45208e = null;
        }
        DqrConfigHelper.init((DqrDecodeConfig) null);
    }

    public void pause() {
        super.pause();
        m32473c();
        AnalysisManager.reportAll();
    }

    public void pauseAndHoldCamera() {
        m32473c();
    }

    public void destroy() {
        m32473c();
        if (this.cameraInstance != null && this.cameraInstance.isOpen()) {
            this.cameraInstance.close();
            this.cameraInstance = null;
        }
    }

    @Deprecated
    public void setDecodeFormats(Collection<BarcodeFormat> collection) {
        DecoderFactory decoderFactory = this.f45209f;
        if (decoderFactory != null) {
            decoderFactory.setDecodeFormats(collection);
        }
    }

    public void setDecodeFormats(String str) {
        if (this.f45209f != null && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            C14921Util.addExtraBarcodeFormats(str, arrayList);
            if (arrayList.isEmpty()) {
                arrayList.add(BarcodeFormat.QR_CODE);
            }
            this.f45209f.setDecodeFormats(arrayList);
        }
    }

    public void setProductId(String str) {
        this.f45205b = str;
    }
}
