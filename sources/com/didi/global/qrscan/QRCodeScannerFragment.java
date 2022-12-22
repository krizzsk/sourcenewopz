package com.didi.global.qrscan;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.dqr.ResultPoint;
import com.didi.global.qrscan.NetWorkStatusBar;
import com.didi.global.qrscan.inter.QRCodeProcess;
import com.didi.sdk.util.Utils;
import com.didi.zxing.barcodescanner.BarcodeCallback;
import com.didi.zxing.barcodescanner.BarcodeResult;
import com.didi.zxing.barcodescanner.CameraPreview;
import com.didi.zxing.barcodescanner.CaptureManager;
import com.didi.zxing.barcodescanner.DecoratedBarcodeView;
import com.didi.zxing.barcodescanner.ViewfinderView;
import com.didi.zxing.barcodescanner.camera.CameraSettings;
import com.taxis99.R;
import java.util.List;

public class QRCodeScannerFragment extends C8796a implements NetWorkStatusBar.OnViewVisibilityChangeListener {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CaptureManager f22912b;

    /* renamed from: c */
    private RelativeLayout f22913c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DecoratedBarcodeView f22914d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ViewfinderView f22915e;

    /* renamed from: f */
    private TextView f22916f;

    /* renamed from: g */
    private Button f22917g;

    /* renamed from: h */
    private ImageView f22918h;

    /* renamed from: i */
    private TextView f22919i;

    /* renamed from: j */
    private View f22920j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Handler f22921k = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f22922l;

    /* renamed from: m */
    private View f22923m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public QRScanFragment f22924n;

    /* renamed from: o */
    private NetWorkStatusBar f22925o;

    /* renamed from: p */
    private boolean f22926p;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67435a(boolean z) {
    }

    public /* bridge */ /* synthetic */ void setProcess(QRCodeProcess qRCodeProcess) {
        super.setProcess(qRCodeProcess);
    }

    public void setParent(QRScanFragment qRScanFragment) {
        this.f22924n = qRScanFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarLightingCompat.setStatusBarBgLightning(getActivity(), true, 0);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f22913c = (RelativeLayout) layoutInflater.inflate(R.layout.global_qrcode_scanner_fragment_new, viewGroup, false);
        m16487c();
        m16491e();
        return this.f22913c;
    }

    /* renamed from: c */
    private void m16487c() {
        this.f22914d = (DecoratedBarcodeView) this.f22913c.findViewById(R.id.bv_scanner_container);
        ViewfinderView viewfinderView = (ViewfinderView) this.f22913c.findViewById(R.id.zxing_viewfinder_view);
        this.f22915e = viewfinderView;
        viewfinderView.setAnimeFlag(false);
        TextView textView = (TextView) this.f22913c.findViewById(R.id.g_pincode_manually_btn);
        this.f22916f = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                QRCodeScannerFragment.this.f22924n.mo67451c();
            }
        });
        Button button = (Button) this.f22913c.findViewById(R.id.g_scan_torch_img);
        this.f22917g = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (QRCodeScannerFragment.this.f22922l) {
                    QRCodeScannerFragment.this.f22914d.setTorchOff();
                } else {
                    QRCodeScannerFragment.this.f22914d.setTorchOn();
                }
            }
        });
        this.f22914d.setTorchListener(new DecoratedBarcodeView.TorchListener() {
            public void onTorchOn() {
                QRCodeScannerFragment.this.m16480a((int) R.drawable.open_ride_torch_on);
                boolean unused = QRCodeScannerFragment.this.f22922l = true;
            }

            public void onTorchOff() {
                QRCodeScannerFragment.this.m16480a((int) R.drawable.open_ride_torch_off);
                boolean unused = QRCodeScannerFragment.this.f22922l = false;
            }
        });
        CameraSettings cameraSettings = this.f22914d.getBarcodeView().getCameraSettings();
        if (this.f22930a != null) {
            cameraSettings.setAutoTorchEnabled(this.f22930a.autoTorchEnabled());
        }
        ImageView imageView = (ImageView) this.f22913c.findViewById(R.id.g_scan_back_img);
        this.f22918h = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                QRCodeScannerFragment.this.f22924n.mo67449a();
            }
        });
        TextView textView2 = (TextView) this.f22913c.findViewById(R.id.g_scan_guide_rule_btn);
        this.f22919i = textView2;
        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (QRCodeScannerFragment.this.f22930a != null && QRCodeScannerFragment.this.f22930a.getGuideClickListener() != null) {
                    QRCodeScannerFragment.this.f22930a.getGuideClickListener().onClick(view);
                }
            }
        });
        this.f22920j = this.f22913c.findViewById(R.id.global_code_scanner_title_bar);
        this.f22923m = this.f22913c.findViewById(R.id.g_view_below_scan);
        TextView textView3 = (TextView) this.f22913c.findViewById(R.id.g_scan_intro_tv);
        if (this.f22930a != null) {
            textView3.setText(this.f22930a.getScanText());
            this.f22919i.setText(this.f22930a.getGuideText());
        }
        NetWorkStatusBar netWorkStatusBar = (NetWorkStatusBar) this.f22913c.findViewById(R.id.networkBar);
        this.f22925o = netWorkStatusBar;
        netWorkStatusBar.setOnViewVisibilityChangeListener(this);
        m16489d();
    }

    /* renamed from: d */
    private void m16489d() {
        int statusBarHeight = UiUtils.getStatusBarHeight(getContext());
        int dip2px = UiUtils.dip2px(getContext(), 44.0f);
        int dip2px2 = UiUtils.dip2px(getContext(), 46.0f);
        int dip2px3 = UiUtils.dip2px(getContext(), 18.0f);
        int dip2px4 = UiUtils.dip2px(getContext(), 16.0f);
        int dip2px5 = UiUtils.dip2px(getContext(), 112.0f);
        int windowHeight = UiUtils.getWindowHeight(getActivity());
        int dip2px6 = UiUtils.dip2px(getContext(), 250.0f);
        int dip2px7 = ((((windowHeight - statusBarHeight) - dip2px) - dip2px2) - dip2px3) - UiUtils.dip2px(getContext(), 80.0f);
        int i = dip2px6 + dip2px4 + dip2px5;
        if (dip2px7 < i) {
            dip2px6 = (dip2px7 - dip2px4) - dip2px5;
            i = dip2px7;
        }
        int dip2px8 = dip2px + UiUtils.dip2px(getContext(), 60.0f) + ((dip2px7 - i) / 2);
        this.f22915e.setViewPosition(dip2px6, dip2px6, dip2px8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, dip2px6 + dip2px8 + UiUtils.dip2px(getContext(), 20.0f), 0, 0);
        layoutParams.addRule(14);
        this.f22923m.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16480a(int i) {
        this.f22917g.setBackgroundResource(i);
    }

    public Context getContext() {
        return super.getContext();
    }

    public void onResume() {
        super.onResume();
        if (!this.f22926p) {
            this.f22912b.onResume();
            if (this.f22930a != null) {
                this.f22930a.onScanStart();
            }
        }
        this.f22925o.refreshOnResume();
    }

    public void onPause() {
        super.onPause();
        this.f22912b.onPauseWhioutWait();
        if (this.f22930a != null) {
            this.f22930a.onScanStop();
        }
    }

    public void onStop() {
        super.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f22912b.onDestroy();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.f22912b.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* renamed from: e */
    private void m16491e() {
        CaptureManager captureManager = new CaptureManager(getActivity(), this.f22914d);
        this.f22912b = captureManager;
        captureManager.decodeContinuous(new BarcodeCallback() {
            public void possibleResultPoints(List<ResultPoint> list) {
            }

            public void barcodeResult(BarcodeResult barcodeResult) {
                if (QRCodeScannerFragment.this.f22912b != null) {
                    QRCodeScannerFragment.this.m16483a(barcodeResult);
                }
            }
        });
        this.f22912b.addStateListener(new CameraPreview.StateListener() {
            public void cameraClosed() {
            }

            public void previewSized() {
            }

            public void previewStarted() {
                if (Utils.isNetworkConnected(QRCodeScannerFragment.this.getContext())) {
                    QRCodeScannerFragment.this.f22915e.setAnimeFlag(true);
                }
            }

            public void previewStopped() {
                QRCodeScannerFragment.this.f22915e.setAnimeFlag(false);
            }

            public void cameraError(Exception exc) {
                QRCodeScannerFragment.this.f22921k.postDelayed(new Runnable() {
                    public void run() {
                        QRCodeScannerFragment.this.f22912b.onResume();
                    }
                }, 2000);
                exc.printStackTrace();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16483a(BarcodeResult barcodeResult) {
        if (barcodeResult != null && !TextUtils.isEmpty(barcodeResult.getText()) && Utils.isNetworkConnected(getContext())) {
            this.f22926p = true;
            this.f22912b.onPauseWhioutWait();
            if (this.f22930a != null) {
                this.f22930a.onScanResult(barcodeResult.getText());
            }
        }
    }

    public View getTitleBar() {
        return this.f22920j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67434a() {
        this.f22926p = false;
        CaptureManager captureManager = this.f22912b;
        if (captureManager != null) {
            captureManager.onResume();
        }
        if (this.f22930a != null) {
            this.f22930a.onScanStart();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo67447b() {
        this.f22926p = true;
        this.f22912b.onPauseWhioutWait();
        if (this.f22930a != null) {
            this.f22930a.onScanStop();
        }
    }

    public void onNetWorkStateChanged(View view) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getTitleBar().getLayoutParams();
        if (view.getVisibility() == 0) {
            this.f22915e.setAnimeFlag(false);
            layoutParams.topMargin = (int) getContext().getResources().getDimension(R.dimen.qr_network_error_height);
            this.f22913c.findViewById(R.id.scan_mask).setVisibility(0);
            this.f22913c.findViewById(R.id.title_mask).setVisibility(0);
            if (this.f22930a != null) {
                ((TextView) this.f22913c.findViewById(R.id.no_net_dis)).setText(this.f22930a.getNoNetworkText());
                return;
            }
            return;
        }
        if (!this.f22926p) {
            this.f22915e.setAnimeFlag(true);
        }
        layoutParams.topMargin = (int) getContext().getResources().getDimension(R.dimen.qr_network_normal_marginTop);
        this.f22913c.findViewById(R.id.scan_mask).setVisibility(8);
        this.f22913c.findViewById(R.id.title_mask).setVisibility(8);
    }
}
