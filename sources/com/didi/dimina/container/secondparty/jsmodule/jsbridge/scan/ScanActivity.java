package com.didi.dimina.container.secondparty.jsmodule.jsbridge.scan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.didi.dqr.ResultPoint;
import com.didi.sdk.apm.SystemUtils;
import com.didi.zxing.barcodescanner.BarcodeCallback;
import com.didi.zxing.barcodescanner.BarcodeResult;
import com.didi.zxing.barcodescanner.CameraPreview;
import com.didi.zxing.barcodescanner.CaptureManager;
import com.didi.zxing.barcodescanner.DecoratedBarcodeView;
import com.didi.zxing.barcodescanner.ViewfinderView;
import com.taxis99.R;
import java.util.List;

public class ScanActivity extends Activity {
    public static ScanResultListener scanListener;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Handler f17266a = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CaptureManager f17267b;

    /* renamed from: c */
    private DecoratedBarcodeView f17268c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ViewfinderView f17269d;

    /* renamed from: e */
    private View f17270e;

    /* renamed from: f */
    private View f17271f;

    /* renamed from: g */
    private ImageView f17272g;

    /* renamed from: h */
    private ImageView f17273h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f17274i;

    public interface ScanResultListener {
        void onCancel();

        void onSuccess(String str);
    }

    public static void start(Activity activity, ScanResultListener scanResultListener) {
        scanListener = scanResultListener;
        Intent intent = new Intent();
        intent.setClass(activity, ScanActivity.class);
        activity.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView(R.layout.dimina_scan_activity);
        m12825a();
        m12833b();
    }

    /* renamed from: a */
    private void m12825a() {
        this.f17273h = (ImageView) findViewById(R.id.iv_back);
        this.f17268c = (DecoratedBarcodeView) findViewById(R.id.bv_scanner_container);
        this.f17270e = findViewById(R.id.zxing_rl_surface_loading);
        ViewfinderView viewfinderView = (ViewfinderView) findViewById(R.id.zxing_viewfinder_view);
        this.f17269d = viewfinderView;
        viewfinderView.setAnimeFlag(false);
        this.f17271f = findViewById(R.id.torch_view);
        this.f17272g = (ImageView) findViewById(R.id.torch_button);
        this.f17273h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ScanActivity.this.m12834b(view);
            }
        });
        this.f17271f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ScanActivity.this.m12827a(view);
            }
        });
        this.f17268c.setTorchListener(new DecoratedBarcodeView.TorchListener() {
            public void onTorchOn() {
                ScanActivity.this.m12826a((int) R.drawable.dimina_open_torch_on);
                boolean unused = ScanActivity.this.f17274i = true;
            }

            public void onTorchOff() {
                ScanActivity.this.m12826a((int) R.drawable.dimina_open_torch_off);
                boolean unused = ScanActivity.this.f17274i = false;
            }
        });
        this.f17268c.getBarcodeView().setDecodeFormats("QR_CODE,CODE_128,EAN_13,EAN_8,ITF");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m12834b(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12827a(View view) {
        if (this.f17274i) {
            this.f17268c.setTorchOff();
        } else {
            this.f17268c.setTorchOn();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12826a(int i) {
        this.f17272g.setBackgroundResource(i);
    }

    /* renamed from: b */
    private void m12833b() {
        CaptureManager captureManager = new CaptureManager(this, this.f17268c);
        this.f17267b = captureManager;
        captureManager.decodeContinuous(new BarcodeCallback() {
            public void possibleResultPoints(List<ResultPoint> list) {
            }

            public void barcodeResult(BarcodeResult barcodeResult) {
                ScanActivity.this.f17267b.onPauseWhioutWait();
                ScanActivity.this.m12830a(barcodeResult);
            }
        });
        this.f17267b.addStateListener(new CameraPreview.StateListener() {
            public void cameraClosed() {
            }

            public void previewSized() {
            }

            public void previewStarted() {
                ScanActivity.this.hideScannerLoading();
                ScanActivity.this.f17269d.setAnimeFlag(true);
            }

            public void previewStopped() {
                ScanActivity.this.f17269d.setAnimeFlag(false);
            }

            public void cameraError(Exception exc) {
                ScanActivity.this.f17266a.postDelayed(new Runnable() {
                    public void run() {
                        ScanActivity.this.f17267b.onResume();
                    }
                }, 2000);
                exc.printStackTrace();
            }
        });
        this.f17267b.onResume();
    }

    public void hideScannerLoading() {
        View view = this.f17270e;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.f17270e.getParent()).removeView(this.f17270e);
            this.f17270e = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12830a(BarcodeResult barcodeResult) {
        String text = barcodeResult.getText();
        ScanResultListener scanResultListener = scanListener;
        if (scanResultListener != null) {
            scanResultListener.onSuccess(text);
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f17267b.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f17267b.onPauseWhioutWait();
    }

    public void onBackPressed() {
        ScanResultListener scanResultListener = scanListener;
        if (scanResultListener != null) {
            scanResultListener.onCancel();
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        scanListener = null;
        this.f17267b.onDestroy();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.f17267b.onRequestPermissionsResult(i, strArr, iArr);
    }
}
