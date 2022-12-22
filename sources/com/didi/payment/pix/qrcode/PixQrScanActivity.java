package com.didi.payment.pix.qrcode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.permission.PermissionCallback;
import com.didi.commoninterfacelib.permission.PermissionContext;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.dqr.ResultPoint;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.payment.base.dialog.GlobalAlertDialog;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.PaySharedPreferencesUtil;
import com.didi.payment.commonsdk.p129ui.WBaseActivity;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.pix.qrcode.p138vm.PixQueryQrCodeVM;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.zxing.barcodescanner.BarcodeCallback;
import com.didi.zxing.barcodescanner.BarcodeResult;
import com.didi.zxing.barcodescanner.CameraPreview;
import com.didi.zxing.barcodescanner.CaptureManager;
import com.didi.zxing.barcodescanner.DecoratedBarcodeView;
import com.didi.zxing.barcodescanner.ViewfinderView;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.ArrayList;
import java.util.List;

public class PixQrScanActivity extends WBaseActivity<PixQueryQrCodeVM> {
    public static ScanResultListener scanListener;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Handler f31154a = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CaptureManager f31155b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DecoratedBarcodeView f31156c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ViewfinderView f31157d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Button f31158e;

    /* renamed from: f */
    private Button f31159f;

    /* renamed from: g */
    private View f31160g;

    /* renamed from: h */
    private TextView f31161h;

    /* renamed from: i */
    private LinearLayout f31162i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f31163j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public LEGODrawer f31164k;
    public Runnable runnable = new Runnable() {
        public void run() {
            PixQrScanActivity.this.m21925e();
        }
    };

    public interface ScanResultListener {
        void onCancel();

        void onSuccess(String str);
    }

    public boolean registeBackstackEvent() {
        return true;
    }

    public static void start(Activity activity, ScanResultListener scanResultListener) {
        scanListener = scanResultListener;
        Intent intent = new Intent();
        intent.setClass(activity, PixQrScanActivity.class);
        activity.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.pix_activity_scan);
        m21909a();
        m21918b();
        this.f30177vm = (WBaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this, (ViewModelProvider.Factory) new PixQueryQrCodeVM.Factory(getApplication())).get(PixQueryQrCodeVM.class);
        subscribeUi((PixQueryQrCodeVM) this.f30177vm);
        FinOmegaSDK.trackEvent("ibt_didipay_pix_scan_sw");
    }

    /* access modifiers changed from: protected */
    public void onReceivePopbackEvent() {
        finish();
    }

    public void subscribeUi(PixQueryQrCodeVM pixQueryQrCodeVM) {
        super.subscribeUi(pixQueryQrCodeVM);
        pixQueryQrCodeVM.mQuerySuccess.observe(this, new Observer() {
            public final void onChanged(Object obj) {
                PixQrScanActivity.this.m21913a((Boolean) obj);
            }
        });
        pixQueryQrCodeVM.mErrorMessage.observe(this, new Observer() {
            public final void onChanged(Object obj) {
                PixQrScanActivity.this.m21914a((String) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21913a(Boolean bool) {
        if (bool.booleanValue()) {
            finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21914a(String str) {
        final GlobalAlertDialog globalAlertDialog = new GlobalAlertDialog();
        globalAlertDialog.setTitle(getString(R.string.GRider_payment_Identification_failed_UAhS));
        globalAlertDialog.setMsg(str);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(getString(R.string.GRider_payment_Try_again_SxKx));
        arrayList2.add(new GlobalAlertDialog.OnBtnClickListener() {
            public void onBtnClick(DialogFragment dialogFragment, int i) {
                globalAlertDialog.dismiss();
                PixQrScanActivity.this.f31155b.onResume();
                UiThreadHandler.postDelayed(PixQrScanActivity.this.runnable, 30000);
            }
        });
        globalAlertDialog.setButtons(arrayList);
        globalAlertDialog.setCancelable(false);
        globalAlertDialog.setListeners(arrayList2);
        globalAlertDialog.show(getSupportFragmentManager(), "showErrorDialog");
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return this.f31162i;
    }

    /* renamed from: a */
    private void m21909a() {
        this.f31156c = (DecoratedBarcodeView) findViewById(R.id.bv_scanner_container);
        ViewfinderView viewfinderView = (ViewfinderView) findViewById(R.id.zxing_viewfinder_view);
        this.f31157d = viewfinderView;
        viewfinderView.setAnimeFlag(false);
        this.f31158e = (Button) findViewById(R.id.torch_button);
        this.f31159f = (Button) findViewById(R.id.pix_scan_back);
        this.f31160g = findViewById(R.id.pix_scan_file);
        this.f31161h = (TextView) findViewById(R.id.pix_scan_tip);
        this.f31162i = (LinearLayout) findViewById(R.id.pix_scan_titlebar);
        this.f31159f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixQrScanActivity.this.m21919b(view);
            }
        });
        this.f31158e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (PixQrScanActivity.this.f31163j) {
                    PixQrScanActivity.this.f31156c.setTorchOff();
                } else {
                    PixQrScanActivity.this.f31156c.setTorchOn();
                }
            }
        });
        this.f31160g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixQrScanActivity.this.m21910a(view);
            }
        });
        this.f31156c.setTorchListener(new DecoratedBarcodeView.TorchListener() {
            public void onTorchOn() {
                PixQrScanActivity.this.f31158e.setBackgroundResource(R.drawable.pix_torch_open);
                boolean unused = PixQrScanActivity.this.f31163j = true;
            }

            public void onTorchOff() {
                PixQrScanActivity.this.f31158e.setBackgroundResource(R.drawable.pix_torch_close);
                boolean unused = PixQrScanActivity.this.f31163j = false;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m21919b(View view) {
        FinOmegaSDK.trackEvent("ibt_didipay_pix_scan_back_ck");
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21910a(View view) {
        FinOmegaSDK.trackEvent("ibt_didipay_pix_photo_input_ck");
        if (PaySharedPreferencesUtil.isPixPhotoInputGuideShown(this)) {
            m21923d();
        } else {
            m21921c();
        }
    }

    /* renamed from: b */
    private void m21918b() {
        CaptureManager captureManager = new CaptureManager(this, this.f31156c);
        this.f31155b = captureManager;
        captureManager.decodeContinuous(new BarcodeCallback() {
            public void possibleResultPoints(List<ResultPoint> list) {
            }

            public void barcodeResult(BarcodeResult barcodeResult) {
                PixQrScanActivity.this.f31155b.onPauseWhioutWait();
                PixQrScanActivity.this.m21912a(barcodeResult);
            }
        });
        this.f31155b.addStateListener(new CameraPreview.StateListener() {
            public void cameraClosed() {
            }

            public void previewSized() {
            }

            public void previewStarted() {
                PixQrScanActivity.this.f31157d.setAnimeFlag(true);
            }

            public void previewStopped() {
                PixQrScanActivity.this.f31157d.setAnimeFlag(false);
            }

            public void cameraError(Exception exc) {
                PixQrScanActivity.this.f31154a.postDelayed(new Runnable() {
                    public void run() {
                        PixQrScanActivity.this.f31155b.onResume();
                    }
                }, 2000);
                exc.printStackTrace();
            }
        });
        this.f31155b.onResume();
    }

    /* renamed from: c */
    private void m21921c() {
        try {
            if (this.f31164k != null && this.f31164k.isShowing()) {
                this.f31164k.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f31164k = LEGOUICreator.showDrawerTemplate(this, new LEGODrawerModel1(getString(R.string.GRider_payment_Select_a_IXgF), new LEGOBtnTextAndCallback(getString(R.string.pix_scan_select_img_button_text), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (PixQrScanActivity.this.f31164k != null && PixQrScanActivity.this.f31164k.isShowing()) {
                    PixQrScanActivity.this.f31164k.dismiss();
                }
                PixQrScanActivity.this.m21923d();
            }
        })).setIsShowCloseImg(true).setSubTitle(getString(R.string.pix_scan_select_img_content)));
        PaySharedPreferencesUtil.setPixPhotoInputGuideShown(this, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21912a(BarcodeResult barcodeResult) {
        String text = barcodeResult.getText();
        if (TextUtils.isEmpty(text)) {
            text = "";
        }
        UiThreadHandler.removeCallbacks(this.runnable);
        ScanResultListener scanResultListener = scanListener;
        if (scanResultListener != null) {
            scanResultListener.onSuccess(text);
        }
        ((PixQueryQrCodeVM) this.f30177vm).queryQrCode(text, "scan_qrcode");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m21923d() {
        PermissionUtil.checkAndRequestPermissions((PermissionContext) this, (PermissionCallback) new PermissionCallback() {
            public void isAllGranted(boolean z, String[] strArr) {
                if (z) {
                    PixQrScanActivity.this.startActivity(new Intent(PixQrScanActivity.this, PixPhotoInputActivity.class));
                } else if (!ActivityCompat.shouldShowRequestPermissionRationale(PixQrScanActivity.this, Permission.WRITE_EXTERNAL_STORAGE)) {
                    PixQrScanActivity pixQrScanActivity = PixQrScanActivity.this;
                    ToastHelper.showShortInfo((Context) pixQrScanActivity, pixQrScanActivity.getString(R.string.pix_scan_photo_permission_tip), (int) R.drawable.wallet_toast_icon_fail);
                }
            }
        }, new String[]{Permission.WRITE_EXTERNAL_STORAGE}, false);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        System.out.println("scanact#onResume===");
        PermissionUtil.checkAndRequestPermissions((PermissionContext) this, (PermissionCallback) new PermissionCallback() {
            public void isAllGranted(boolean z, String[] strArr) {
                if (z) {
                    PixQrScanActivity.this.f31155b.onResume();
                    UiThreadHandler.postDelayed(PixQrScanActivity.this.runnable, 30000);
                }
            }
        }, new String[]{Permission.CAMERA}, false);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        System.out.println("scanact#onPause===");
        this.f31155b.onPauseWhioutWait();
        UiThreadHandler.removeCallbacks(this.runnable);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m21925e() {
        final GlobalAlertDialog globalAlertDialog = new GlobalAlertDialog();
        globalAlertDialog.setTitle(getString(R.string.GRider_payment_Identification_failed_UAhS));
        globalAlertDialog.setMsg(getString(R.string.GRider_payment_Make_sure_bDKK));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(getString(R.string.GRider_payment_Try_again_SxKx));
        arrayList2.add(new GlobalAlertDialog.OnBtnClickListener() {
            public void onBtnClick(DialogFragment dialogFragment, int i) {
                globalAlertDialog.dismiss();
                UiThreadHandler.postDelayed(PixQrScanActivity.this.runnable, 30000);
            }
        });
        globalAlertDialog.setCancelable(false);
        globalAlertDialog.setButtons(arrayList);
        globalAlertDialog.setListeners(arrayList2);
        globalAlertDialog.show(getSupportFragmentManager(), "showTimeoutDialog");
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
        this.f31155b.onDestroy();
    }
}
