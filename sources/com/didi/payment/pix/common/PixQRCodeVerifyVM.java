package com.didi.payment.pix.common;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.net.PixQrCodeQueryResp;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.pix.net.PixNetModel;
import com.didi.sdk.util.TextUtil;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;

public class PixQRCodeVerifyVM extends WBaseViewModel {
    public MutableLiveData<String> errMsg = new MutableLiveData<>();
    public MutableLiveData<PixQrCodeQueryResp.QRCodeData> qrcodeData = new MutableLiveData<>();

    public void loadData() {
    }

    public PixQRCodeVerifyVM(Application application) {
        super(application);
    }

    public void autoVerifyQRCode(String str) {
        new PixNetModel(getApplication()).queryPixQrCode(str, new RpcService.Callback<PixQrCodeQueryResp>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(PixQrCodeQueryResp pixQrCodeQueryResp) {
                if (pixQrCodeQueryResp != null && pixQrCodeQueryResp.errno == 0) {
                    PixQRCodeVerifyVM.this.qrcodeData.setValue(pixQrCodeQueryResp.data);
                }
                if (pixQrCodeQueryResp != null && pixQrCodeQueryResp.errno != 0 && !TextUtil.isEmpty(pixQrCodeQueryResp.errmsg)) {
                    PixQRCodeVerifyVM.this.errMsg.setValue(pixQrCodeQueryResp.errmsg);
                }
            }
        });
    }
}
