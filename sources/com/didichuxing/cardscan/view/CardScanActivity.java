package com.didichuxing.cardscan.view;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.cardscan.CardScanCallback;
import com.didichuxing.cardscan.CardScanResult;
import com.didichuxing.cardscan.DidiCardScanner;
import com.didichuxing.cardscan.p175a.C15180a;
import com.didichuxing.cardscan.p175a.C15183d;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import p242io.card.payment.CardScanner;
import p242io.card.payment.CreditCard;
import p242io.card.payment.DetectionInfo;

public class CardScanActivity extends Activity {

    /* renamed from: a */
    static final /* synthetic */ boolean f46192a = (!CardScanActivity.class.desiredAssertionStatus());

    /* renamed from: b */
    private CardScanner f46193b;

    /* renamed from: c */
    private C15187a f46194c;

    /* renamed from: d */
    private OverlayView f46195d;

    /* renamed from: e */
    private boolean f46196e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f46197f = 0;

    /* renamed from: a */
    private void m33180a(int i) {
        CardScanResult cardScanResult = new CardScanResult();
        cardScanResult.resultCode = i;
        cardScanResult.requestCode = DidiCardScanner.getInstance().getRequestCode();
        cardScanResult.duration = System.currentTimeMillis() - this.f46197f;
        CardScanCallback cardScanCallback = DidiCardScanner.getInstance().getCardScanCallback();
        if (cardScanCallback != null) {
            cardScanCallback.onScanResult(cardScanResult);
            DidiCardScanner.getInstance().setScanCallback((CardScanCallback) null);
        }
    }

    /* renamed from: c */
    private boolean m33181c() {
        C15187a aVar;
        if (f46192a || this.f46194c != null) {
            CardScanner cardScanner = this.f46193b;
            if (cardScanner == null || (aVar = this.f46194c) == null) {
                return false;
            }
            return cardScanner.resumeScanning(aVar.getSurfaceHolder());
        }
        throw new AssertionError();
    }

    /* renamed from: d */
    private void m33182d() {
        SurfaceView surfaceView = this.f46194c.getSurfaceView();
        if (surfaceView != null) {
            int width = (int) (((float) ((surfaceView.getWidth() * 640) / 480)) * (((((float) surfaceView.getHeight()) * ((float) CardScanner.sDesiredPreviewHeight)) / ((float) surfaceView.getWidth())) / ((float) CardScanner.sDesiredPreviewWidth)));
            Rect guideFrame = this.f46193b.getGuideFrame(surfaceView.getWidth(), width);
            int height = (surfaceView.getHeight() - width) / 2;
            guideFrame.top += height;
            guideFrame.bottom += height;
            guideFrame.top += surfaceView.getTop();
            guideFrame.bottom += surfaceView.getTop();
            this.f46195d.mo114843a(guideFrame, 0);
        }
    }

    /* renamed from: e */
    private void m33183e() {
        Camera camera;
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i = point.x;
        int i2 = point.y;
        int height = getWindow().getDecorView().getHeight();
        if (i2 < height) {
            i2 = height;
        }
        int i3 = (i2 * 100) / i;
        Camera.Size size = null;
        try {
            camera = Camera.open();
        } catch (RuntimeException unused) {
            m33180a(1);
            finish();
            camera = null;
        }
        if (camera != null) {
            int i4 = 100;
            for (Camera.Size next : camera.getParameters().getSupportedPreviewSizes()) {
                int abs = Math.abs(((next.width * 100) / next.height) - i3);
                if (abs < i4 || (abs <= i4 && next.width == i2)) {
                    size = next;
                    i4 = abs;
                }
            }
            if (size != null) {
                CardScanner.sDesiredPreviewHeight = size.height;
                CardScanner.sDesiredPreviewWidth = size.width;
            }
            camera.release();
        }
    }

    /* renamed from: f */
    private void m33184f() {
        m33183e();
        if (C15183d.m33171a()) {
            if (Build.VERSION.SDK_INT >= 16) {
                getWindow().getDecorView().setSystemUiVisibility(4);
                ActionBar actionBar = getActionBar();
                if (actionBar != null) {
                    actionBar.hide();
                }
            }
            try {
                CardScanner cardScanner = new CardScanner(this);
                this.f46193b = cardScanner;
                cardScanner.prepareScanner();
            } catch (Exception e) {
                e.printStackTrace();
                m33180a(4);
                finish();
            }
            m33185g();
        }
    }

    /* renamed from: g */
    private void m33185g() {
        String str;
        OverlayView overlayView;
        FrameLayout frameLayout = new FrameLayout(this);
        C15187a aVar = new C15187a(this, (AttributeSet) null);
        this.f46194c = aVar;
        aVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(this.f46194c);
        OverlayView overlayView2 = (OverlayView) LayoutInflater.from(this).inflate(R.layout.cardscan_overlay_layout, frameLayout, false);
        this.f46195d = overlayView2;
        overlayView2.mo114844a(this);
        this.f46195d.setWillNotDraw(false);
        this.f46195d.setTorchEnabled(false);
        this.f46195d.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (getApplicationContext().getPackageName().contains("com.taxis99")) {
            overlayView = this.f46195d;
            str = "#fffea330";
        } else {
            overlayView = this.f46195d;
            str = "#ffff7733";
        }
        overlayView.setGuideColor(Color.parseColor(str));
        ((TextView) this.f46195d.findViewById(R.id.title_tv)).setText(DidiCardScanner.getInstance().getTitleText());
        frameLayout.addView(this.f46195d);
        setContentView(frameLayout);
    }

    /* renamed from: a */
    public void mo114831a() {
        SurfaceView surfaceView = this.f46194c.getSurfaceView();
        OverlayView overlayView = this.f46195d;
        if (overlayView != null) {
            overlayView.setCameraPreviewRect(new Rect(surfaceView.getLeft(), surfaceView.getTop(), surfaceView.getRight(), surfaceView.getBottom()));
        }
        m33182d();
        mo114832a(new DetectionInfo());
    }

    /* renamed from: a */
    public void mo114832a(DetectionInfo detectionInfo) {
        OverlayView overlayView = this.f46195d;
        if (overlayView != null) {
            overlayView.setDetectionInfo(detectionInfo);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = r1.f46193b;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo114833a(boolean r2) {
        /*
            r1 = this;
            com.didichuxing.cardscan.view.a r0 = r1.f46194c
            if (r0 == 0) goto L_0x0014
            com.didichuxing.cardscan.view.OverlayView r0 = r1.f46195d
            if (r0 == 0) goto L_0x0014
            io.card.payment.CardScanner r0 = r1.f46193b
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.setFlashOn(r2)
            if (r0 == 0) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            if (r0 == 0) goto L_0x001c
            com.didichuxing.cardscan.view.OverlayView r0 = r1.f46195d
            r0.setTorchOn(r2)
        L_0x001c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.cardscan.view.CardScanActivity.mo114833a(boolean):void");
    }

    /* renamed from: b */
    public void mo114834b() {
        CardScanner cardScanner = this.f46193b;
        if (cardScanner != null) {
            cardScanner.triggerAutoFocus();
        }
    }

    /* renamed from: b */
    public void mo114835b(final DetectionInfo detectionInfo) {
        Vibrator vibrator = (Vibrator) getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(new long[]{0, 70, 10, 40}, -1);
        }
        C151861 r0 = new Runnable() {
            public void run() {
                CreditCard creditCard = detectionInfo.creditCard();
                CardScanResult cardScanResult = new CardScanResult();
                cardScanResult.cardNumber = creditCard.cardNumber;
                cardScanResult.expiryMonth = creditCard.expiryMonth;
                cardScanResult.expiryYear = creditCard.expiryYear;
                cardScanResult.resultCode = 0;
                cardScanResult.requestCode = DidiCardScanner.getInstance().getRequestCode();
                cardScanResult.duration = System.currentTimeMillis() - CardScanActivity.this.f46197f;
                CardScanCallback cardScanCallback = DidiCardScanner.getInstance().getCardScanCallback();
                if (cardScanCallback != null) {
                    cardScanCallback.onScanResult(cardScanResult);
                    DidiCardScanner.getInstance().setScanCallback((CardScanCallback) null);
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r0.run();
        } else {
            runOnUiThread(r0);
        }
        finish();
    }

    public void onBackPressed() {
        CardScanCallback cardScanCallback = DidiCardScanner.getInstance().getCardScanCallback();
        if (cardScanCallback != null) {
            cardScanCallback.onKeyBackBtnClick();
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        C15180a.m33162a(this);
        super.onCreate(bundle);
        getWindow().addFlags(8192);
        this.f46197f = System.currentTimeMillis();
        if (CardScanner.processorSupported()) {
            if (Build.VERSION.SDK_INT < 23) {
                requestWindowFeature(1);
            } else if (checkSelfPermission(Permission.CAMERA) == -1) {
                this.f46196e = true;
                requestPermissions(new String[]{Permission.CAMERA}, 11);
                return;
            }
            m33184f();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        mo114833a(false);
        CardScanner cardScanner = this.f46193b;
        if (cardScanner != null) {
            cardScanner.endScanning();
            this.f46193b = null;
        }
        super.onDestroy();
        DidiCardScanner.getInstance().reset();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        mo114833a(false);
        CardScanner cardScanner = this.f46193b;
        if (cardScanner != null) {
            cardScanner.pauseScanning();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 11) {
            if (strArr.length > 0) {
                int i2 = 0;
                while (i2 < strArr.length) {
                    if (!Permission.CAMERA.equals(strArr[i2]) || iArr[i2] != 0) {
                        i2++;
                    } else {
                        m33184f();
                        m33181c();
                        return;
                    }
                }
            }
            m33180a(1);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!this.f46196e && m33181c()) {
            mo114833a(false);
        }
    }
}
