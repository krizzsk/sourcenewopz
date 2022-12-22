package com.didichuxing.gbankcard.ocr.act;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.dfbasesdk.AppContextHolder;
import com.didichuxing.dfbasesdk.utils.CameraUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.UIHandler;
import com.didichuxing.gbankcard.ocr.ScanCardHelper;
import com.didichuxing.gbankcard.ocr.ScanCardParam;
import com.didichuxing.gbankcard.ocr.ScanCardResult;
import com.didichuxing.gbankcard.ocr.bankcard.BankcardDetector;
import com.didichuxing.gbankcard.ocr.bankcard.BankcardResult;
import com.didichuxing.gbankcard.ocr.log.GLogReporter;
import com.didichuxing.gbankcard.ocr.log.LogData;
import com.didichuxing.gbankcard.ocr.network.GBankcardApi;
import com.didichuxing.gbankcard.ocr.network.data.GuideResp;
import com.didichuxing.gbankcard.ocr.ottoevent.OcrVerifyDoneEvent;
import com.didichuxing.gbankcard.ocr.utils.ICamera;
import com.didichuxing.gbankcard.ocr.utils.YuvCroper;
import com.squareup.otto.Subscribe;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.HashMap;

public class GBankcardOcrAct extends C15711a implements Camera.PreviewCallback, TextureView.SurfaceTextureListener {

    /* renamed from: p */
    private static final int f47662p = 1;

    /* renamed from: q */
    private static final int f47663q = 2;

    /* renamed from: a */
    private TextureView f47664a;

    /* renamed from: b */
    private SurfaceTexture f47665b;

    /* renamed from: c */
    private HollowEffectView f47666c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FrameLayout f47667d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Button f47668e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ICamera f47669f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile BankcardDetector f47670g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ScanCardParam f47671h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public volatile boolean f47672i;

    /* renamed from: j */
    private Runnable f47673j;

    /* renamed from: k */
    private boolean f47674k;

    /* renamed from: l */
    private GLogReporter f47675l;

    /* renamed from: m */
    private int f47676m;

    /* renamed from: n */
    private HandlerThread f47677n;

    /* renamed from: o */
    private Handler f47678o;

    /* renamed from: r */
    private ScanCardResult f47679r;

    /* renamed from: s */
    private long f47680s;

    /* renamed from: t */
    private YuvCroper f47681t;

    /* renamed from: u */
    private final Object f47682u = new Object();

    /* renamed from: v */
    private TmpDetectResult f47683v;

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.gbankcard_ocr_act;
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return true;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public static void start(Context context, ScanCardParam scanCardParam) {
        AppContextHolder.init(context);
        GBankcardApi.getInstance().buildClientDeviceInfo(context);
        Intent intent = new Intent(context, GBankcardOcrAct.class);
        intent.putExtra("param", scanCardParam);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.f47671h = (ScanCardParam) getIntent().getParcelableExtra("param");
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        this.f47671h = (ScanCardParam) intent.getParcelableExtra("param");
        this.f47676m = 2;
        m34121a().onEnter();
        m34133b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public GLogReporter m34121a() {
        GLogReporter gLogReporter = this.f47675l;
        if (gLogReporter != null) {
            return gLogReporter;
        }
        if (this.f47671h == null) {
            this.f47671h = (ScanCardParam) getIntent().getParcelableExtra("param");
        }
        ScanCardParam scanCardParam = this.f47671h;
        GLogReporter gLogReporter2 = new GLogReporter(scanCardParam != null ? scanCardParam.getUid() : "", GBankcardApi.getInstance().getClientDeviceInfo());
        this.f47675l = gLogReporter2;
        return gLogReporter2;
    }

    /* renamed from: b */
    private void m34133b() {
        LogData logData = new LogData(LogData.EVENT_ENTER);
        logData.addDetail("type", Integer.valueOf(this.f47671h.getType())).addDetail("ocrType", Integer.valueOf(this.f47676m)).addDetail("countryCode", this.f47671h.getCountryCode()).addDetail("cardBin", this.f47671h.getCardBin());
        this.f47675l.report(logData);
    }

    /* renamed from: c */
    private void m34137c() {
        this.f47674k = ContextCompat.checkSelfPermission(this, Permission.CAMERA) == 0;
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        hideTitleArea();
        getWindow().addFlags(16777216);
        TextureView textureView = (TextureView) findViewById(R.id.camera_preview_tv);
        this.f47664a = textureView;
        textureView.setSurfaceTextureListener(this);
        this.f47666c = (HollowEffectView) findViewById(R.id.hollow_effect_view);
        this.f47669f = new ICamera();
        m34137c();
        if (!this.f47674k) {
            ActivityCompat.requestPermissions(this, new String[]{Permission.CAMERA}, 666);
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.card_preview_rect);
        this.f47667d = frameLayout;
        frameLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GBankcardOcrAct.this.f47669f.refocus();
            }
        });
        findViewById(R.id.back_icon).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GBankcardOcrAct.this.m34134b(103);
            }
        });
        this.f47668e = (Button) findViewById(R.id.bottom_back_btn);
        if (this.f47671h.isForceType()) {
            this.f47668e.setVisibility(4);
        } else {
            this.f47668e.setVisibility(0);
            this.f47668e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GBankcardOcrAct.this.m34134b(105);
                }
            });
            if (this.f47673j == null) {
                this.f47673j = new Runnable() {
                    public void run() {
                        GBankcardOcrAct.this.f47668e.setSelected(true);
                    }
                };
            }
            UIHandler.postDelayed(10000, this.f47673j);
        }
        this.f47670g = new BankcardDetector(GuideResp.newDefaultOne(this.f47676m));
    }

    /* renamed from: d */
    private void m34140d() {
        this.f47676m = 1;
        this.f47670g = new BankcardDetector(GuideResp.newDefaultOne(1));
        m34121a().report(m34123a(LogData.EVENT_FALLBACK_CARDIO));
    }

    /* renamed from: e */
    private void m34141e() {
        TextView textView = (TextView) findViewById(R.id.gbankcard_title);
        String charSequence = textView.getText().toString();
        textView.setText(charSequence + this.f47676m);
    }

    /* renamed from: a */
    private void m34125a(int i) {
        LogData logData = new LogData(LogData.EVENT_GUIDE);
        logData.addDetail("supportCardIO", Integer.valueOf(i));
        m34121a().report(logData);
    }

    /* renamed from: a */
    private void m34126a(ScanCardResult scanCardResult) {
        if (scanCardResult != null) {
            LogData logData = new LogData(LogData.EVENT_EXIT);
            HashMap hashMap = new HashMap();
            hashMap.put("code", Integer.valueOf(scanCardResult.code));
            hashMap.put("type", Integer.valueOf(scanCardResult.type));
            hashMap.put("ocrType", Integer.valueOf(this.f47676m));
            hashMap.put("cardNum", scanCardResult.getMaskedCardNum());
            if (scanCardResult.cardRect != null) {
                hashMap.put("cardRect", Arrays.toString(scanCardResult.cardRect));
            }
            if (scanCardResult.cardNumRect != null) {
                hashMap.put("cardNumRect", Arrays.toString(scanCardResult.cardNumRect));
            }
            hashMap.put("cardNumState", Integer.valueOf(scanCardResult.cardNumState));
            hashMap.put("cardNumScore", Float.valueOf(scanCardResult.prob));
            logData.addDetails(hashMap);
            m34121a().report(logData);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m34135b(ScanCardResult scanCardResult) {
        if (scanCardResult.isForceType() && scanCardResult.code == 0) {
            LogUtils.m33563d("no need finish act case, wait outer biz verify done...");
            this.f47679r = scanCardResult;
        } else {
            m34126a(scanCardResult);
            finish();
        }
        ScanCardHelper.notifyCallback(scanCardResult);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m34134b(int i) {
        this.f47672i = true;
        ScanCardResult scanCardResult = new ScanCardResult(i, this.f47671h.getType());
        synchronized (this.f47682u) {
            if (this.f47683v != null) {
                scanCardResult.cardNum = this.f47683v.cardNum;
                scanCardResult.cardNumState = this.f47683v.state;
                scanCardResult.prob = this.f47683v.prob;
                scanCardResult.cardRect = this.f47683v.rect1;
                scanCardResult.cardNumRect = this.f47683v.rect2;
            }
        }
        m34135b(scanCardResult);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initDataFromIntent(intent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        for (int i2 : iArr) {
            if (i2 != 0) {
                m34144f();
                return;
            }
        }
        this.f47674k = true;
    }

    /* renamed from: f */
    private void m34144f() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.GBANKCARD_RETRY_DIALOG);
        builder.setView((int) R.layout.gbankcard_ask_camera_permission_dialog_view).setCancelable(false);
        final AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        SystemUtils.showDialog(create);
        create.findViewById(R.id.dialog_left_btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                create.dismiss();
                GBankcardOcrAct.this.m34134b(102);
            }
        });
        create.findViewById(R.id.dialog_right_btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GBankcardOcrAct.this.m34146g();
                create.dismiss();
                GBankcardOcrAct.this.m34134b(102);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m34146g() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addFlags(268435456);
            intent.setData(Uri.fromParts("package", getPackageName(), (String) null));
            startActivity(intent);
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
            try {
                Intent intent2 = new Intent("android.settings.SETTINGS");
                intent2.addFlags(268435456);
                startActivity(intent2);
            } catch (Exception e2) {
                LogUtils.logStackTrace(e2);
            }
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        LogUtils.m33569i("onSurface avail, surface===" + surfaceTexture);
        this.f47665b = surfaceTexture;
        m34148h();
    }

    /* renamed from: h */
    private void m34148h() {
        LogUtils.m33569i("doPreview() called...");
        SurfaceTexture surfaceTexture = this.f47665b;
        if (surfaceTexture == null) {
            LogUtils.m33569i("ignore, surfaceTexture==null!!!");
        } else if (!this.f47674k) {
            LogUtils.m33569i("ignore, no camera permisson!!!");
        } else {
            try {
                this.f47669f.startPreview(surfaceTexture);
                this.f47669f.setPreviewCallback(this);
                this.f47669f.autoFocus();
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
            }
            this.f47666c.setHollowArea(this.f47667d);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public LogData m34123a(String str) {
        LogData logData = new LogData(str);
        logData.addDetail("type", Integer.valueOf(this.f47671h.getType())).addDetail("ocrType", Integer.valueOf(this.f47676m));
        return logData;
    }

    /* renamed from: i */
    private void m34149i() {
        m34121a().report(m34123a(LogData.EVENT_BEGIN_SCAN));
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (bArr == null || bArr.length == 0) {
            LogUtils.m33569i("ignore, cause of invalid bytes!!!");
        } else if (!this.f47669f.hasFocus) {
            LogUtils.m33569i("ignore, cause of no focus!!!");
        } else if (this.f47672i) {
            LogUtils.m33569i("ignore, cause of paused!!!");
        } else if (this.f47670g == null) {
            LogUtils.m33569i("ignore, cause of null bankcardDetector!!!");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f47680s == 0) {
                m34149i();
            }
            long j = this.f47680s;
            if (j == 0 || currentTimeMillis - j >= 200) {
                this.f47680s = currentTimeMillis;
                LogUtils.m33563d("send data to detect, timestamp===" + currentTimeMillis);
                int i = this.f47669f.cameraWidth;
                int i2 = this.f47669f.cameraHeight;
                if (this.f47681t == null) {
                    int width = this.f47664a.getWidth();
                    int height = this.f47664a.getHeight();
                    int width2 = this.f47667d.getWidth();
                    int height2 = this.f47667d.getHeight();
                    float f = ((float) width2) * 0.05f;
                    float max = Math.max(((float) this.f47667d.getLeft()) - f, 0.0f);
                    float f2 = ((float) height2) * 0.05f;
                    float f3 = (float) width;
                    float f4 = (float) height;
                    RectF rectF = new RectF(Math.max(((float) this.f47667d.getTop()) - f2, 0.0f) / f4, max / f3, Math.min(((float) this.f47667d.getBottom()) + f2, f4) / f4, Math.min(((float) this.f47667d.getRight()) + f, f3) / f3);
                    LogUtils.m33563d("rectf===" + rectF);
                    this.f47681t = new YuvCroper(YuvCroper.YUV_420SP, i, i2, rectF);
                }
                if (this.f47677n == null) {
                    HandlerThread handlerThread = new HandlerThread("gbankcard_scan", 10);
                    this.f47677n = handlerThread;
                    handlerThread.start();
                    this.f47678o = new Handler(this.f47677n.getLooper()) {
                        public void handleMessage(Message message) {
                            if (message != null) {
                                int i = message.what;
                                if (i == 1) {
                                    if (message.obj instanceof byte[]) {
                                        GBankcardOcrAct.this.m34130a((byte[]) message.obj, message.arg1, message.arg2);
                                    }
                                } else if (i == 2) {
                                    LogUtils.m33563d("handle MSG_DESTROY!!!");
                                    if (GBankcardOcrAct.this.f47670g != null) {
                                        GBankcardOcrAct.this.f47670g.stop();
                                    }
                                    GBankcardOcrAct.this.runOnUiThread(new Runnable() {
                                        public void run() {
                                            GBankcardOcrAct.this.m34152l();
                                        }
                                    });
                                } else {
                                    LogUtils.m33563d("unknown msg what===" + i);
                                }
                            }
                        }
                    };
                }
                byte[] crop = this.f47681t.crop(bArr);
                Message obtain = Message.obtain(this.f47678o);
                obtain.what = 1;
                obtain.arg1 = this.f47681t.getCropWidth();
                obtain.arg2 = this.f47681t.getCropHeight();
                obtain.obj = crop;
                obtain.sendToTarget();
            }
        }
    }

    private static class TmpDetectResult {
        /* access modifiers changed from: private */
        public String cardNum;
        /* access modifiers changed from: private */
        public float prob;
        /* access modifiers changed from: private */
        public float[] rect1;
        /* access modifiers changed from: private */
        public float[] rect2;
        /* access modifiers changed from: private */
        public int state;

        private TmpDetectResult() {
        }

        /* access modifiers changed from: private */
        public static int getProbCount(TmpDetectResult tmpDetectResult) {
            int i = 0;
            if (tmpDetectResult == null) {
                return 0;
            }
            if (!TextUtils.isEmpty(tmpDetectResult.cardNum)) {
                i = 1;
            }
            float[] fArr = tmpDetectResult.rect1;
            if (fArr != null && fArr[1] > 0.0f) {
                i++;
            }
            float[] fArr2 = tmpDetectResult.rect2;
            return (fArr2 == null || fArr2[1] <= 0.0f) ? i : i + 1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34130a(byte[] bArr, int i, int i2) {
        final float[] fArr;
        final float[] fArr2;
        if (this.f47670g != null) {
            if (this.f47672i) {
                LogUtils.m33563d("ignore paused111!!!");
                return;
            }
            LogUtils.m33563d("detectInner, w===" + i + ", h=" + i2);
            if (this.f47670g.detect(bArr, i, i2) != 1) {
                LogUtils.m33563d("alpha ocr init failed!!!");
                return;
            }
            BankcardResult.CardNumInfo cardNumInfo = this.f47670g.getCardNumInfo();
            final int i3 = cardNumInfo.state;
            final String str = cardNumInfo.cardNum;
            final float f = cardNumInfo.score;
            LogUtils.m33563d("detected cardNumState===" + i3);
            float[] cardRect = this.f47670g.getCardRect();
            if (cardRect != null) {
                fArr = new float[6];
                System.arraycopy(cardRect, 0, fArr, 0, cardRect.length);
            } else {
                fArr = null;
            }
            float[] cardNumRect = this.f47670g.getCardNumRect();
            if (cardNumRect != null) {
                float[] fArr3 = new float[6];
                System.arraycopy(cardNumRect, 0, fArr3, 0, cardNumRect.length);
                fArr2 = fArr3;
            } else {
                fArr2 = null;
            }
            TmpDetectResult tmpDetectResult = new TmpDetectResult();
            int unused = tmpDetectResult.state = i3;
            String unused2 = tmpDetectResult.cardNum = str;
            float unused3 = tmpDetectResult.prob = f;
            float[] unused4 = tmpDetectResult.rect1 = fArr;
            float[] unused5 = tmpDetectResult.rect2 = fArr2;
            this.f47670g.reset();
            if (this.f47672i) {
                LogUtils.m33563d("ignore paused222!!!");
                return;
            }
            synchronized (this.f47682u) {
                if (TmpDetectResult.getProbCount(tmpDetectResult) >= TmpDetectResult.getProbCount(this.f47683v)) {
                    this.f47683v = tmpDetectResult;
                }
            }
            if (i3 == 5) {
                LogUtils.m33563d("detected cardNum===" + str);
                this.f47672i = true;
                runOnUiThread(new Runnable() {
                    public void run() {
                        GBankcardOcrAct.this.f47667d.setBackgroundResource(R.drawable.gbankcard_preview_rect_orange);
                        ScanCardResult scanCardResult = new ScanCardResult(0, GBankcardOcrAct.this.f47671h.getType());
                        scanCardResult.cardNum = str;
                        scanCardResult.cardNumState = i3;
                        scanCardResult.prob = f;
                        scanCardResult.cardRect = fArr;
                        scanCardResult.cardNumRect = fArr2;
                        GBankcardOcrAct.this.m34135b(scanCardResult);
                    }
                });
                return;
            }
            LogUtils.m33563d("detected nothing!!!");
            if (i3 == 4 || (i3 == 0 && fArr != null && fArr[0] > 0.0f)) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        GBankcardOcrAct.this.f47669f.refocus();
                    }
                });
            }
        }
    }

    /* renamed from: b */
    private void m34136b(byte[] bArr, int i, int i2) {
        if (!this.f47672i) {
            this.f47672i = true;
            YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, (int[]) null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, yuvImage.getWidth(), yuvImage.getHeight()), 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ((ImageView) findViewById(R.id.test_img)).setImageBitmap(BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length));
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        LogUtils.m33563d("resume===");
        ICamera iCamera = this.f47669f;
        if (iCamera != null) {
            CameraUtils.setCameraDisplayOrientation((Activity) this, 0, iCamera.openCamera(0));
            m34148h();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        LogUtils.m33563d("pause===");
        ICamera iCamera = this.f47669f;
        if (iCamera != null) {
            iCamera.closeCamera();
        }
    }

    /* access modifiers changed from: protected */
    public boolean onBackKeyIntercept() {
        m34134b(104);
        return true;
    }

    @Subscribe
    public void onOcrVerifyDoneEvent(OcrVerifyDoneEvent ocrVerifyDoneEvent) {
        if (ocrVerifyDoneEvent.verifyOk) {
            m34126a(this.f47679r);
            finish();
            return;
        }
        m34150j();
    }

    /* renamed from: j */
    private void m34150j() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.GBANKCARD_RETRY_DIALOG);
        builder.setView((int) R.layout.gbankcard_retry_dialog_view).setCancelable(false);
        final AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        SystemUtils.showDialog(create);
        create.findViewById(R.id.dialog_rescan_btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                create.dismiss();
                GBankcardOcrAct.this.f47667d.setBackgroundResource(R.drawable.gbankcard_preview_rect_white);
                boolean unused = GBankcardOcrAct.this.f47672i = false;
                GBankcardOcrAct.this.f47669f.refocus();
                GBankcardOcrAct.this.m34121a().report(GBankcardOcrAct.this.m34123a(LogData.EVENT_RESCAN));
            }
        });
        create.findViewById(R.id.dialog_quit_btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                create.dismiss();
                GBankcardOcrAct.this.m34121a().report(GBankcardOcrAct.this.m34123a(LogData.EVENT_QUIT));
                GBankcardOcrAct.this.m34134b(106);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        LogUtils.m33563d("onDestroy, ocrType===" + this.f47676m);
        if (this.f47670g != null) {
            m34151k();
        }
        Runnable runnable = this.f47673j;
        if (runnable != null) {
            UIHandler.removeCallbacks(runnable);
        }
        if (m34121a() != null) {
            m34121a().onExit();
        }
    }

    /* renamed from: k */
    private void m34151k() {
        StringBuilder sb = new StringBuilder();
        sb.append("scheduleDestroyDetector, scanHandler != null? ");
        sb.append(this.f47678o != null);
        LogUtils.m33563d(sb.toString());
        Handler handler = this.f47678o;
        if (handler != null) {
            handler.removeMessages(1);
            this.f47678o.obtainMessage(2).sendToTarget();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m34152l() {
        if (this.f47677n != null) {
            LogUtils.m33563d("quit scanThread...");
            this.f47677n.quit();
            this.f47677n = null;
            this.f47678o = null;
        }
    }
}
