package com.didi.payment.utilities.scan;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.permission.PermissionCallback;
import com.didi.commoninterfacelib.permission.PermissionContext;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.dqr.common.StringUtils;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.dialog.GGKDialogFragment;
import com.didi.global.globalgenerickit.dialog.GGKDialogModel1;
import com.didi.global.globalgenerickit.dialog.GGKDialogModel2;
import com.didi.global.globalgenerickit.dialog.GGKDialogModel3;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.dialog.GGKUICreatorWithThemeCheck;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.PaySharedPreferencesUtil;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.base.utils.WalletToast;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.utilities.CsBoletoCheckUtil;
import com.didi.payment.utilities.base.CsBaseActivity;
import com.didi.payment.utilities.base.CsNetModel;
import com.didi.payment.utilities.base.CsRouter;
import com.didi.payment.utilities.details.CsBillDetailActivity;
import com.didi.payment.utilities.editAmount.CsEditAmountActivity;
import com.didi.payment.utilities.resp.CsGetBillResp;
import com.didi.payment.utilities.scan.CsScanGuideDialog;
import com.didi.payment.utilities.scan.widget.CsI25ZBarScannerView;
import com.didi.payment.utilities.scan.widget.CsScanView;
import com.didi.payment.utilities.scan.widget.CsViewFinderView;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.resp.LimitRiskReminderVo;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpPayResultActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.security.wireless.ISecurityConf;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.IOException;
import java.util.HashMap;
import p065me.dm7.barcodescanner.zbar.Result;

public class CsScanActivity extends CsBaseActivity implements SensorEventListener, View.OnClickListener, CsI25ZBarScannerView.EventListener, CsI25ZBarScannerView.ResultHandler, CsViewFinderView.OnFrameRectUpdatedListener {

    /* renamed from: b */
    private static final String f31648b = "CsScanActivity";

    /* renamed from: a */
    boolean f31649a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CsScanView f31650c;

    /* renamed from: d */
    private ImageView f31651d;

    /* renamed from: e */
    private TextView f31652e;

    /* renamed from: f */
    private TextView f31653f;

    /* renamed from: g */
    private ImageView f31654g;

    /* renamed from: h */
    private ViewGroup f31655h;

    /* renamed from: i */
    private long f31656i;

    /* renamed from: j */
    private boolean f31657j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f31658k;

    /* renamed from: l */
    private boolean f31659l;

    /* renamed from: m */
    private SensorManager f31660m;

    /* renamed from: n */
    private CsScanGuideDialog f31661n;

    /* renamed from: o */
    private GGKDialogFragment f31662o;

    /* renamed from: p */
    private GGKDialogFragment f31663p;

    /* renamed from: q */
    private ImageView f31664q;

    /* renamed from: r */
    private String f31665r;

    /* renamed from: s */
    private boolean f31666s;

    /* renamed from: t */
    private String f31667t = "";

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        getWindow().addFlags(1024);
        m22428a();
        this.f31658k = WalletApolloUtil.isBoletoScanOptEnable();
        setContentView((int) R.layout.cs_activity_scan_layout);
        m22441c();
        m22437b();
        m22445d();
    }

    /* renamed from: a */
    private void m22428a() {
        Intent intent = getIntent();
        FinOmegaSDK.trackEvent("ibt_gp_didipay_lifebill_code_sw", WalletExtraConstant.Key.PUB_PAGE_FROM, (intent == null || TextUtils.isEmpty(intent.getStringExtra(WalletExtraConstant.Key.PUB_PAGE_FROM))) ? "" : intent.getStringExtra(WalletExtraConstant.Key.PUB_PAGE_FROM));
    }

    /* renamed from: b */
    private void m22437b() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            this.f31667t = getIntent().getExtras().getString(InvitationPageActivity.RESOURCE_ID);
        }
    }

    /* renamed from: c */
    private void m22441c() {
        initProgressDialog(this, R.id.cs_scan_title_bar);
        CsScanView csScanView = (CsScanView) findViewById(R.id.scan_view);
        this.f31650c = csScanView;
        csScanView.setOnFrameUpdatedListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.cs_title_bar_left_btn);
        this.f31651d = imageView;
        imageView.setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.cs_scan_page_tap_btn);
        this.f31652e = textView;
        textView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) findViewById(R.id.cs_scan_light_btn);
        this.f31654g = imageView2;
        int i = 0;
        imageView2.setVisibility(this.f31658k ? 0 : 8);
        this.f31654g.setOnClickListener(this);
        ImageView imageView3 = (ImageView) findViewById(R.id.cs_scan_help);
        this.f31664q = imageView3;
        imageView3.setOnClickListener(this);
        ImageView imageView4 = this.f31664q;
        if (!this.f31658k) {
            i = 8;
        }
        imageView4.setVisibility(i);
        this.f31655h = (ViewGroup) findViewById(R.id.cs_scan_bottom_container);
        this.f31665r = getString(R.string.cs_boleto_scan_tips_guide);
        TextView textView2 = (TextView) findViewById(R.id.cs_scan_tips);
        this.f31653f = textView2;
        textView2.setText(this.f31665r);
    }

    /* renamed from: d */
    private void m22445d() {
        PermissionUtil.checkAndRequestPermissions((PermissionContext) this, (PermissionCallback) new PermissionCallback() {
            public void isAllGranted(boolean z, String[] strArr) {
                if (z) {
                    CsScanActivity.this.m22448e();
                    PayTracker.getTracker().trackEvent("ibt_boleto_scan_permission_yes_sw");
                    return;
                }
                PayTracker.getTracker().trackEvent("ibt_boleto_scan_permission_no_sw");
            }
        }, new String[]{Permission.CAMERA}, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m22448e() {
        if (!m22451f()) {
            this.f31650c.setEventListener(this);
            m22456h();
            m22457i();
            m22458j();
            m22459k();
        }
    }

    /* renamed from: f */
    private boolean m22451f() {
        boolean q = m22465q();
        this.f31649a = q;
        if (q) {
            this.f31650c.setMexicoScannerType();
        }
        boolean z = !PaySharedPreferencesUtil.isBoletoScanGuideShown(this) && this.f31658k;
        if (!m22466r() && !z) {
            return false;
        }
        this.f31661n = CsScanGuideDialog.show(this, Boolean.valueOf(this.f31649a), new CsScanGuideDialog.Listener() {
            public void onScanGuideShownOver(CsScanGuideDialog csScanGuideDialog) {
                CsScanActivity.this.m22453g();
            }
        });
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m22453g() {
        PaySharedPreferencesUtil.setBoletoScanGuideShown(this, true);
        this.f31661n = null;
        this.f31650c.setEventListener(this);
        m22456h();
        m22457i();
        m22458j();
        m22459k();
    }

    /* renamed from: h */
    private void m22456h() {
        this.f31656i = System.currentTimeMillis();
    }

    /* renamed from: i */
    private void m22457i() {
        SensorManager sensorManager;
        Sensor defaultSensor;
        if (this.f31658k && (sensorManager = (SensorManager) getSystemService(ISecurityConf.KEY_SENSOR)) != null && (defaultSensor = sensorManager.getDefaultSensor(5)) != null) {
            sensorManager.registerListener(this, defaultSensor, 3);
            this.f31660m = sensorManager;
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (!this.f31657j && sensorEvent != null && sensorEvent.values != null && sensorEvent.values.length > 0 && sensorEvent.values[0] < 3.0f) {
            try {
                this.f31650c.setFlash(true);
                this.f31654g.setSelected(true);
                this.f31653f.setText(R.string.cs_boleto_scan_tips_action_light_on);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            SensorManager sensorManager = this.f31660m;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
        }
    }

    public void onFrameRectUpdated(Rect rect) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f31655h.getLayoutParams();
        marginLayoutParams.topMargin = rect.bottom;
        this.f31655h.setLayoutParams(marginLayoutParams);
        if (!this.f31659l) {
            this.f31659l = true;
            m22450e("ibt_didpay_pay_boleto_pre_scan_guide_sw");
            this.f31653f.setVisibility(0);
        }
    }

    /* renamed from: j */
    private void m22458j() {
        if (this.f31658k) {
            UiThreadHandler.postOnceDelayed(new Runnable() {
                public void run() {
                    CsScanActivity.this.m22461m();
                }
            }, (long) (WalletApolloUtil.getBoletoScanOptTimeoutDelay() * 1000));
        }
    }

    /* renamed from: k */
    private void m22459k() {
        if (this.f31658k) {
            UiThreadHandler.postOnceDelayed(new Runnable() {
                public void run() {
                    CsScanActivity.this.m22462n();
                }
            }, (long) (WalletApolloUtil.getBoletoScanOptFailedDelay() * 1000));
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.cs_title_bar_left_btn) {
            m22447d("ibt_boleto_back_after_scan_page_sw");
            m22432a((Runnable) new Runnable() {
                public void run() {
                    CsScanActivity.this.m22460l();
                }
            });
        } else if (view.getId() == R.id.cs_scan_page_tap_btn) {
            if (this.f31649a) {
                finish();
                return;
            }
            m22447d("ibt_boleto_manual_mode_after_scan_page_sw");
            m22432a((Runnable) new Runnable() {
                public void run() {
                    CsScanActivity.this.m22434a("");
                }
            });
        } else if (view.getId() == R.id.cs_scan_help) {
            WebBrowserUtil.startInternalWebActivity(this, WalletConstant.URL.H5_UTILITIES_GUIDE, "");
        } else if (view.getId() == R.id.cs_scan_light_btn) {
            boolean z = true;
            this.f31657j = true;
            try {
                this.f31650c.setFlash(!this.f31654g.isSelected());
                ImageView imageView = this.f31654g;
                if (this.f31654g.isSelected()) {
                    z = false;
                }
                imageView.setSelected(z);
                if (this.f31654g.isSelected()) {
                    this.f31653f.setText(R.string.cs_boleto_scan_tips_action_light_on);
                } else {
                    this.f31653f.setText(this.f31665r);
                }
                m22450e("ibt_didpay_pay_boleto_flashlight_ck");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22434a(String str) {
        String str2;
        String str3;
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(WalletExtraConstant.Key.ACTIVITY_TEXT);
            str2 = intent.getStringExtra("activity_url");
            str3 = stringExtra;
        } else {
            str3 = null;
            str2 = null;
        }
        CsRouter.startManualInputActivity(this, str3, str2, str, (LimitRiskReminderVo) null, OmegaComParams.BOLETO_SCAN_PAGE);
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m22440b(String str) {
        PayTracker.putGlobal("wallet_channel_id", "-1");
        if (WalletCommonParamsUtil.isDriverClient()) {
            WebBrowserUtil.startInternalWebActivity(this, WalletConstant.URL.H5_DRIVER_BOLETO_DETAILS + "&barcode=" + str, "");
            return;
        }
        m22444c(str);
    }

    /* renamed from: c */
    private void m22444c(String str) {
        showLoadingDialog();
        CsNetModel.getIns(this).getBillInfo(606, str, new RpcService.Callback<CsGetBillResp>() {
            public void onSuccess(CsGetBillResp csGetBillResp) {
                CsScanActivity.this.dismissLoadingDialog();
                if (csGetBillResp != null) {
                    KycOmega.Companion.fin_tech_wallet_http_req_lite_en(csGetBillResp.errno, csGetBillResp.errmsg, "api/v0/didipay/bill1");
                }
                if (csGetBillResp != null && csGetBillResp.errno != 0 && !TextUtils.isEmpty(csGetBillResp.errmsg)) {
                    WalletToast.showFailedMsg(CsScanActivity.this, csGetBillResp.errmsg);
                } else if (csGetBillResp != null && csGetBillResp.data != null) {
                    if (!TextUtils.isEmpty(csGetBillResp.data.orderId)) {
                        Intent intent = new Intent(CsScanActivity.this.getContext(), WalletTopUpPayResultActivity.class);
                        intent.putExtra("product_line", 606);
                        intent.putExtra("order_id", csGetBillResp.data.orderId);
                        intent.putExtra("order_type", -1);
                        intent.putExtra(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, 260);
                        CsScanActivity.this.startActivity(intent);
                        CsScanActivity.this.finish();
                    } else if (csGetBillResp.data.needToJumpZeroBill) {
                        CsEditAmountActivity.launch(CsScanActivity.this.getContext(), csGetBillResp.data.maxBillAmountLimit, csGetBillResp.data.minBillAmountLimit, csGetBillResp.data.amountInputSubTitle, csGetBillResp);
                        CsScanActivity.this.finish();
                    } else {
                        CsBillDetailActivity.startActivity(csGetBillResp, (Context) CsScanActivity.this, OmegaComParams.BOLETO_SCAN_PAGE);
                        CsScanActivity.this.finish();
                    }
                }
            }

            public void onFailure(IOException iOException) {
                CsScanActivity.this.dismissLoadingDialog();
                KycOmega.Companion.fin_tech_wallet_http_req_lite_en(-11, "", "api/v0/didipay/bill1");
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m22460l() {
        if (this.f31649a) {
            finish();
            return;
        }
        if (!"1".equals(this.f31667t) && this.f31658k) {
            CsRouter.startUtilitiesActivity(this);
        }
        finish();
    }

    public void onResume() {
        super.onResume();
        this.f31650c.setResultHandler(this);
        this.f31650c.startCamera();
    }

    public void onPause() {
        super.onPause();
        this.f31650c.stopCamera();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f31666s = true;
        SensorManager sensorManager = this.f31660m;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        CsScanGuideDialog csScanGuideDialog = this.f31661n;
        if (csScanGuideDialog != null) {
            csScanGuideDialog.dismiss();
        }
        GGKDialogFragment gGKDialogFragment = this.f31662o;
        if (gGKDialogFragment != null) {
            gGKDialogFragment.dismiss();
        }
        GGKDialogFragment gGKDialogFragment2 = this.f31663p;
        if (gGKDialogFragment2 != null) {
            gGKDialogFragment2.dismiss();
        }
    }

    public void onBackPressed() {
        m22447d("ibt_boleto_back_after_scan_page_sw");
        m22432a((Runnable) new Runnable() {
            public void run() {
                CsScanActivity.this.m22460l();
            }
        });
    }

    public void onLowMemory() {
        super.onLowMemory();
        CsScanView csScanView = this.f31650c;
        if (csScanView != null) {
            csScanView.dumpCollectedData(false);
        }
    }

    public View getLoadingAnchorView() {
        return findViewById(R.id.cs_scan_title_bar);
    }

    public void onQRCodeFound() {
        m22463o();
    }

    public void onScanningActionTracked() {
        if (this.f31658k) {
            m22450e("ibt_didipay_pay_boleto_scan_in_progress_sw");
            String string = getString(R.string.cs_boleto_scan_tips_action_tracked);
            this.f31665r = string;
            this.f31653f.setText(string);
        }
    }

    public void onPreviewUploadDone() {
        m22450e("ibt_didipay_pay_boleto_scan_timeout_upload_sucess_sw");
        WalletToast.showSuccessMsg(this, getString(R.string.cs_boleto_scan_screen_upload_success));
    }

    public boolean handleResult(Result result) {
        String name;
        this.f31650c.dumpCollectedData(false);
        final String contents = result.getContents();
        String str = "";
        if (!(result.getBarcodeFormat() == null || (name = result.getBarcodeFormat().getName()) == null)) {
            str = name;
        }
        if (this.f31649a) {
            if (!CsBoletoCheckUtil.checkMexicoLength(contents)) {
                return false;
            }
            m22435a("ibt_boleto_scan_result_valid_sw", str);
            setResult(-1, new Intent().putExtra("result", contents));
            finish();
            return true;
        } else if (!this.f31658k && !CsBoletoCheckUtil.checkBoletoLength(contents)) {
            m22436a("ibt_boleto_scan_result_not_valid_sw", contents, str);
            WalletToast.showFailedMsg(this, getResources().getString(R.string.cs_invalidate_num));
            return false;
        } else if (!this.f31658k || CsBoletoCheckUtil.checkBoletoBarcodeLength(contents)) {
            m22435a("ibt_boleto_scan_result_valid_sw", str);
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    if (CsScanActivity.this.f31658k) {
                        CsScanActivity.this.m22440b(contents);
                    } else {
                        CsScanActivity.this.m22434a(contents);
                    }
                }
            });
            return true;
        } else {
            m22436a("ibt_boleto_scan_result_not_valid_sw", contents, str);
            WalletToast.showFailedMsg(this, getResources().getString(R.string.cs_invalidate_num));
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m22461m() {
        if (!this.f31666s && this.f31663p == null && this.f31662o == null) {
            String string = getString(R.string.cs_boleto_scan_timeout_tips_dialog_title);
            String string2 = getString(R.string.cs_boleto_scan_timeout_tips_dialog_content);
            String string3 = getString(R.string.cs_boleto_scan_timeout_tips_dialog_pos);
            String string4 = getString(R.string.cs_boleto_scan_timeout_tips_dialog_neg);
            GGKDialogModel3 gGKDialogModel3 = new GGKDialogModel3(string, string2, new GGKBtnTextAndCallback(string3, new GGKOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    CsScanActivity.this.m22450e("ibt_didipay_pay_boleto_scan_timeout_retry_ck");
                    CsScanActivity.this.m22464p();
                }
            }));
            gGKDialogModel3.addMinorBtn(new GGKBtnTextAndCallback(string4, new GGKOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    CsScanActivity.this.m22450e("ibt_didipay_pay_boleto_scan_timeout_upload_ck");
                    CsScanActivity.this.m22464p();
                    CsScanActivity.this.f31650c.doUploadOnceInNextPreview();
                }
            }));
            m22450e("ibt_didipay_pay_boleto_scan_timeout_sw");
            this.f31662o = GGKUICreatorWithThemeCheck.showDialogModel(this, gGKDialogModel3, "tips_dialog");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m22462n() {
        if (!this.f31666s && this.f31663p == null && this.f31662o == null) {
            String string = getString(R.string.cs_boleto_scan_failed_tips_dialog_content);
            String string2 = getString(R.string.cs_boleto_scan_failed_tips_dialog_pos);
            String string3 = getString(R.string.cs_boleto_scan_failed_tips_dialog_neg);
            GGKDialogModel1 gGKDialogModel1 = new GGKDialogModel1(string, new GGKBtnTextAndCallback(string2, new GGKOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    CsScanActivity.this.m22450e("ibt_didipay_pay_boleto_scan_timeout_retry_again_ck");
                    CsScanActivity.this.m22464p();
                }
            }));
            gGKDialogModel1.addMinorBtn(new GGKBtnTextAndCallback(string3, new GGKOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    CsScanActivity.this.m22450e("ibt_didipay_pay_boleto_scan_timeout_retry_drop_ck");
                    CsScanActivity.this.m22464p();
                    CsScanActivity.this.m22460l();
                }
            }));
            m22450e("ibt_didipay_pay_boleto_scan_timeout_retry_fail_sw");
            this.f31662o = GGKUICreatorWithThemeCheck.showDialogModel(this, gGKDialogModel1, "tips_dialog");
        }
    }

    /* renamed from: o */
    private void m22463o() {
        if (this.f31663p == null && this.f31662o == null) {
            GGKDialogModel1 gGKDialogModel1 = new GGKDialogModel1(getString(R.string.cs_boleto_scan_qr_tips_dialog_content), new GGKBtnTextAndCallback(getString(R.string.cs_boleto_scan_qr_tips_dialog_pos), new GGKOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    CsScanActivity.this.m22450e("ibt_didipay_pay_boleto_scan_not_recognized_retry_ck");
                    CsScanActivity.this.m22464p();
                }
            }));
            m22450e("ibt_didipay_pay_boleto_scan_not_recognized_sw");
            this.f31662o = GGKUICreatorWithThemeCheck.showDialogModel(this, gGKDialogModel1, "tips_dialog");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m22464p() {
        GGKDialogFragment gGKDialogFragment = this.f31662o;
        if (gGKDialogFragment != null) {
            gGKDialogFragment.dismiss();
            this.f31662o = null;
        }
    }

    /* renamed from: a */
    private void m22432a(final Runnable runnable) {
        if (this.f31650c.hasCollectedData()) {
            String string = getString(R.string.cs_boleto_scan_upload_dialog_content);
            String string2 = getString(R.string.cs_boleto_scan_upload_dialog_btn_yes);
            String string3 = getString(R.string.cs_boleto_scan_upload_dialog_btn_no);
            GGKDialogModel2 gGKDialogModel2 = new GGKDialogModel2(string, new GGKBtnTextAndCallback(string2, new GGKOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    PayTracker.trackEvent("ibt_boleto_scan_upload_auth_dialog_yes_ck");
                    CsScanActivity.this.m22433a(runnable, true);
                }
            }));
            gGKDialogModel2.addMinorBtn(new GGKBtnTextAndCallback(string3, new GGKOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    PayTracker.trackEvent("ibt_boleto_scan_upload_auth_dialog_no_ck");
                    CsScanActivity.this.m22433a(runnable, false);
                }
            }));
            this.f31663p = GGKUICreatorWithThemeCheck.showDialogModel(this, gGKDialogModel2, "collection_dialog");
            PayTracker.trackEvent("ibt_boleto_scan_upload_auth_dialog_sw");
        } else if (runnable != null) {
            runnable.run();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22433a(Runnable runnable, boolean z) {
        this.f31650c.dumpCollectedData(z);
        if (runnable != null) {
            runnable.run();
        }
        GGKDialogFragment gGKDialogFragment = this.f31663p;
        if (gGKDialogFragment != null) {
            gGKDialogFragment.dismiss();
            this.f31663p = null;
        }
    }

    /* renamed from: d */
    private void m22447d(String str) {
        long currentTimeMillis = System.currentTimeMillis() - this.f31656i;
        HashMap hashMap = new HashMap();
        hashMap.put("interval", Long.valueOf(currentTimeMillis));
        PayTracker.trackEvent(str, hashMap);
    }

    /* renamed from: a */
    private void m22435a(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis() - this.f31656i;
        HashMap hashMap = new HashMap();
        hashMap.put("interval", Long.valueOf(currentTimeMillis));
        hashMap.put("barcode_format", str2);
        PayTracker.trackEvent(str, hashMap);
    }

    /* renamed from: a */
    private void m22436a(String str, String str2, String str3) {
        long currentTimeMillis = System.currentTimeMillis() - this.f31656i;
        HashMap hashMap = new HashMap();
        hashMap.put("interval", Long.valueOf(currentTimeMillis));
        if (StringUtils.isEmpty(str2)) {
            str2 = "";
        }
        hashMap.put("content", str2);
        hashMap.put("barcode_format", str3);
        PayTracker.trackEvent(str, hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m22450e(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("flashlight_status", this.f31654g.isSelected() ? "flashlight_on" : "flashlight_off");
        PayTracker.trackEvent(str, hashMap);
    }

    /* renamed from: q */
    private boolean m22465q() {
        return getIntent().getIntExtra("isFromDa", -1) == 1;
    }

    /* renamed from: r */
    private boolean m22466r() {
        return getIntent().getIntExtra("showGuide", -1) == 1;
    }
}
