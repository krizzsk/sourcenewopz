package com.didi.dimina.starbox.module.jsbridge.scancode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
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
    public final Handler f18100a = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CaptureManager f18101b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DecoratedBarcodeView f18102c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ViewfinderView f18103d;

    /* renamed from: e */
    private View f18104e;

    /* renamed from: f */
    private Button f18105f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f18106g;

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
        setContentView(R.layout.dimina_starbox_activity_scan);
        m13514a();
        m13522b();
    }

    /* renamed from: a */
    private void m13514a() {
        this.f18102c = (DecoratedBarcodeView) findViewById(R.id.bv_scanner_container);
        this.f18104e = findViewById(R.id.zxing_rl_surface_loading);
        ViewfinderView viewfinderView = (ViewfinderView) findViewById(R.id.zxing_viewfinder_view);
        this.f18103d = viewfinderView;
        viewfinderView.setAnimeFlag(false);
        this.f18105f = (Button) findViewById(R.id.torch_button);
        TextView textView = (TextView) findViewById(R.id.title_bar);
        textView.setText(R.string.dm_kit_scan_title);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ScanActivity.this.onBackPressed();
            }
        });
        this.f18105f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (ScanActivity.this.f18106g) {
                    ScanActivity.this.f18102c.setTorchOff();
                } else {
                    ScanActivity.this.f18102c.setTorchOn();
                }
            }
        });
        this.f18102c.setTorchListener(new DecoratedBarcodeView.TorchListener() {
            public void onTorchOn() {
                ScanActivity.this.m13515a((int) R.drawable.dimina_starbox_open_ride_torch_on);
                boolean unused = ScanActivity.this.f18106g = true;
            }

            public void onTorchOff() {
                ScanActivity.this.m13515a((int) R.drawable.dimina_starbox_open_ride_torch_off);
                boolean unused = ScanActivity.this.f18106g = false;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13515a(int i) {
        this.f18105f.setBackgroundResource(i);
    }

    /* renamed from: b */
    private void m13522b() {
        CaptureManager captureManager = new CaptureManager(this, this.f18102c);
        this.f18101b = captureManager;
        captureManager.decodeContinuous(new BarcodeCallback() {
            public void possibleResultPoints(List<ResultPoint> list) {
            }

            public void barcodeResult(BarcodeResult barcodeResult) {
                ScanActivity.this.f18101b.onPauseWhioutWait();
                ScanActivity.this.m13518a(barcodeResult);
            }
        });
        this.f18101b.addStateListener(new CameraPreview.StateListener() {
            public void cameraClosed() {
            }

            public void previewSized() {
            }

            public void previewStarted() {
                ScanActivity.this.hideScannerLoading();
                ScanActivity.this.f18103d.setAnimeFlag(true);
            }

            public void previewStopped() {
                ScanActivity.this.f18103d.setAnimeFlag(false);
            }

            public void cameraError(Exception exc) {
                ScanActivity.this.f18100a.postDelayed(new Runnable() {
                    public void run() {
                        ScanActivity.this.f18101b.onResume();
                    }
                }, 2000);
                exc.printStackTrace();
            }
        });
        this.f18101b.onResume();
    }

    public void hideScannerLoading() {
        View view = this.f18104e;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.f18104e.getParent()).removeView(this.f18104e);
            this.f18104e = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13518a(BarcodeResult barcodeResult) {
        ScanResultListener scanResultListener = scanListener;
        if (scanResultListener != null) {
            scanResultListener.onSuccess(barcodeResult.getText());
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f18101b.onPauseWhioutWait();
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
        this.f18101b.onDestroy();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.f18101b.onRequestPermissionsResult(i, strArr, iArr);
    }
}
