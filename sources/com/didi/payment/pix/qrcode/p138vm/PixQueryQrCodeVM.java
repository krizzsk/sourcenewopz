package com.didi.payment.pix.qrcode.p138vm;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo.ChooseImageReq;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.commonsdk.net.PixQrCodeQueryResp;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.pix.constant.PixRouter;
import com.didi.payment.pix.net.PixNetModel;
import com.didi.payment.pix.net.response.PixKeyVerifyResp;
import com.didi.sdk.util.TextUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

/* renamed from: com.didi.payment.pix.qrcode.vm.PixQueryQrCodeVM */
public class PixQueryQrCodeVM extends WBaseViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f31167a = "";
    public MutableLiveData<String> mErrorMessage = new MutableLiveData<>();
    public MutableLiveData<Boolean> mQuerySuccess = new MutableLiveData<>();

    public void loadData() {
    }

    public PixQueryQrCodeVM(Application application) {
        super(application);
    }

    public void queryQrCode(String str, boolean z, String str2) {
        this.f31167a = str2;
        queryQrCode(str, z, false);
    }

    public void queryQrCode(String str, boolean z, final boolean z2) {
        isLoading().postValue(true);
        new PixNetModel(getApplication()).queryPixQrCode(str, new RpcService.Callback<PixQrCodeQueryResp>() {
            public void onSuccess(PixQrCodeQueryResp pixQrCodeQueryResp) {
                String str;
                String str2;
                PixQueryQrCodeVM.this.isLoading().postValue(false);
                String str3 = "camera";
                String str4 = "scan_qrcode";
                if (pixQrCodeQueryResp == null || pixQrCodeQueryResp.errno != 0 || pixQrCodeQueryResp.data == null) {
                    if (!TextUtil.isEmpty(pixQrCodeQueryResp.errmsg)) {
                        str = pixQrCodeQueryResp.errmsg;
                    } else {
                        str = PixQueryQrCodeVM.this.getApplication().getString(R.string.pay_base_network_error);
                    }
                    PixQueryQrCodeVM.this.mErrorMessage.postValue(str);
                    PixQueryQrCodeVM.this.mQuerySuccess.postValue(false);
                    if (!z2) {
                        FinOmegaSDK.trackEvent("ibt_didipay_pix_photo_input_api_fail_bt");
                        if (PixQueryQrCodeVM.this.f31167a != null) {
                            if (!PixQueryQrCodeVM.this.f31167a.equals(str4)) {
                                str3 = ChooseImageReq.SOURCE_TYPE_ALBUM;
                            }
                            FinOmegaSDK.trackEvent("ibt_didipay_pix_scan_success_sw", "photo_source", str3);
                            return;
                        }
                        return;
                    }
                    return;
                }
                PixKeyVerifyResp.PixAccount pixAccount = new PixKeyVerifyResp.PixAccount();
                pixAccount.setKey(pixQrCodeQueryResp.data.getKey());
                pixAccount.setName(pixQrCodeQueryResp.data.getName());
                if (!z2) {
                    FinOmegaSDK.trackEvent("ibt_didipay_pix_photo_input_api_success_bt", "pix_payee_key", pixQrCodeQueryResp.data.getKey());
                    if (PixQueryQrCodeVM.this.f31167a != null) {
                        if (!PixQueryQrCodeVM.this.f31167a.equals(str4)) {
                            str3 = ChooseImageReq.SOURCE_TYPE_ALBUM;
                        }
                        FinOmegaSDK.trackEvent("ibt_didipay_pix_scan_success_sw", "photo_source", str3);
                    }
                } else {
                    FinOmegaSDK.trackEvent("ibt_didipay_pix_manual_input_bt", "pix_payee_key", pixQrCodeQueryResp.data.getKey());
                }
                Bundle bundle = new Bundle();
                bundle.putSerializable("detected_qrcode", pixQrCodeQueryResp.data);
                if (!TextUtil.isEmpty(PixQueryQrCodeVM.this.f31167a)) {
                    str2 = PixQueryQrCodeVM.this.f31167a;
                } else {
                    if (z2) {
                        str4 = "manual_input_qrcode";
                    }
                    str2 = str4;
                }
                bundle.putString("source_page", str2);
                ((Request) DRouter.build(PixRouter.build("/pix_transfer")).putExtras(bundle)).start(PixQueryQrCodeVM.this.getApplication());
                PixQueryQrCodeVM.this.mQuerySuccess.postValue(true);
            }

            public void onFailure(IOException iOException) {
                PixQueryQrCodeVM.this.isLoading().postValue(false);
                PixQueryQrCodeVM.this.mErrorMessage.postValue(PixQueryQrCodeVM.this.getApplication().getString(R.string.GRider_payment_Invalid_QR_yyIJ));
                PixQueryQrCodeVM.this.mQuerySuccess.postValue(false);
                if (!z2) {
                    FinOmegaSDK.trackEvent("ibt_didipay_pix_photo_input_api_fail_bt");
                }
            }
        });
    }

    public void queryQrCode(String str, String str2) {
        queryQrCode(str, true, str2);
    }

    public void queryQrCodeWithType(String str, Boolean bool) {
        queryQrCode(str, true, bool.booleanValue());
    }

    /* renamed from: com.didi.payment.pix.qrcode.vm.PixQueryQrCodeVM$Factory */
    public static class Factory implements ViewModelProvider.Factory {
        private Application application;

        public Factory(Application application2) {
            this.application = application2;
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            return new PixQueryQrCodeVM(this.application);
        }
    }
}
