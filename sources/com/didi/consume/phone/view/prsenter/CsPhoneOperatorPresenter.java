package com.didi.consume.phone.view.prsenter;

import android.app.Activity;
import com.didi.consume.base.CsNetModel;
import com.didi.consume.base.CsOmegaUtils;
import com.didi.consume.phone.model.CsOperatorListResp;
import com.didi.consume.phone.view.contract.CsPhoneOperatorContract;
import com.didi.payment.base.utils.WalletToast;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;

public class CsPhoneOperatorPresenter implements CsPhoneOperatorContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f16372a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CsPhoneOperatorContract.View f16373b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletLoadingContract f16374c;

    /* renamed from: d */
    private CsNetModel f16375d;

    /* renamed from: e */
    private int f16376e = -1;

    public CsPhoneOperatorPresenter(Activity activity, CsPhoneOperatorContract.View view, WalletLoadingContract walletLoadingContract) {
        this.f16372a = activity;
        this.f16373b = view;
        this.f16374c = walletLoadingContract;
        this.f16375d = CsNetModel.getIns(activity);
        this.f16376e = this.f16372a.getIntent().getIntExtra("order_type", -1);
    }

    public void trackOmega(int i) {
        if (i == 0) {
            HashMap hashMap = new HashMap();
            int i2 = 1;
            if (this.f16376e != 1) {
                i2 = 0;
            }
            hashMap.put("order_type", Integer.valueOf(i2));
            CsOmegaUtils.trackPhoneBillOperatorSelected(hashMap);
        }
    }

    public void getOperatorList(int i, String str, String str2) {
        this.f16374c.showLoadingDialog();
        this.f16375d.getOperatorList(i, str, str2, new RpcService.Callback<CsOperatorListResp>() {
            public void onSuccess(CsOperatorListResp csOperatorListResp) {
                CsPhoneOperatorPresenter.this.f16374c.dismissLoadingDialog();
                if (csOperatorListResp == null) {
                    WalletToast.showFailedMsg(CsPhoneOperatorPresenter.this.f16372a, CsPhoneOperatorPresenter.this.f16372a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    CsPhoneOperatorPresenter.this.f16373b.onNetworkError();
                } else if (csOperatorListResp.errno == 0) {
                    CsPhoneOperatorPresenter.this.f16373b.showOperators(csOperatorListResp);
                } else {
                    WalletToast.showFailedMsg(CsPhoneOperatorPresenter.this.f16372a, csOperatorListResp.errmsg);
                    CsPhoneOperatorPresenter.this.f16373b.onNetworkError();
                }
            }

            public void onFailure(IOException iOException) {
                CsPhoneOperatorPresenter.this.f16374c.dismissLoadingDialog();
                WalletToast.showFailedMsg(CsPhoneOperatorPresenter.this.f16372a, CsPhoneOperatorPresenter.this.f16372a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                CsPhoneOperatorPresenter.this.f16373b.onNetworkError();
            }
        });
    }
}
