package com.didi.component.openride.newscan;

import android.content.Context;
import android.text.TextUtils;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.net.CarRequest;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.PinCodeInfoResult;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;

public class GlobalOpenRideQRScanPresenter {
    public static final int FROM_PINCODE = 2;
    public static final int FROM_SCAN = 1;

    /* renamed from: a */
    private static final int f14731a = 8;

    /* renamed from: b */
    private static final String f14732b = "driverCode";

    /* renamed from: c */
    private Context f14733c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IQRScannerView f14734d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f14735e;

    public GlobalOpenRideQRScanPresenter(Context context, IQRScannerView iQRScannerView) {
        this.f14733c = context;
        this.f14734d = iQRScannerView;
    }

    public void handleDriverCode(String str, int i) {
        this.f14735e = i;
        if (!m10541b(str)) {
            this.f14734d.showNotRequireQRCodeToast();
        } else {
            m10539a(str);
        }
    }

    /* renamed from: a */
    private void m10539a(String str) {
        int parseInt = Integer.parseInt(str);
        this.f14734d.showRequestLoadingDialog();
        CarRequest.confirmPinCode(this.f14733c, parseInt, new ResponseListener<PinCodeInfoResult>() {
            public void onSuccess(PinCodeInfoResult pinCodeInfoResult) {
                GlobalOpenRideQRScanPresenter.this.createPinSuccess(pinCodeInfoResult);
            }

            public void onError(PinCodeInfoResult pinCodeInfoResult) {
                super.onError(pinCodeInfoResult);
                GlobalOpenRideQRScanPresenter.this.f14734d.showRequestFailedToast(pinCodeInfoResult);
            }

            public void onFail(PinCodeInfoResult pinCodeInfoResult) {
                super.onFail(pinCodeInfoResult);
                GlobalOpenRideQRScanPresenter.this.f14734d.showRequestFailedToast(pinCodeInfoResult);
            }

            public void onFinish(PinCodeInfoResult pinCodeInfoResult) {
                super.onFinish(pinCodeInfoResult);
                if (GlobalOpenRideQRScanPresenter.this.f14735e == 1) {
                    GlobalOmegaUtils.trackEvent("Pas_99GO_qrcode_scan", Constants.ERROR_CODE, String.valueOf(pinCodeInfoResult.errno));
                } else if (GlobalOpenRideQRScanPresenter.this.f14735e == 2) {
                    GlobalOmegaUtils.trackEvent("Pas_99GO_digitcode_enter", Constants.ERROR_CODE, String.valueOf(pinCodeInfoResult.errno));
                }
                GlobalOpenRideQRScanPresenter.this.f14734d.dismissRequestLoadingDialog();
            }
        });
    }

    public void createPinSuccess(PinCodeInfoResult pinCodeInfoResult) {
        if (pinCodeInfoResult != null) {
            FormStore.getInstance().setDriverInfo(pinCodeInfoResult);
            this.f14734d.showPop(pinCodeInfoResult);
            notifyDriverStateOfPsg(1, pinCodeInfoResult.driverId);
        }
    }

    public void notifyDriverStateOfPsg(int i, String str) {
        CarRequest.notifyDriverStateOfPsg(this.f14733c, i, str, (ResponseListener<BaseObject>) null);
    }

    /* renamed from: b */
    private boolean m10541b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.matches("^\\d{8}$");
        }
        return false;
    }
}
