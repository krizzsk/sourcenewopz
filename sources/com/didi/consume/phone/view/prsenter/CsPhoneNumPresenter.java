package com.didi.consume.phone.view.prsenter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.didi.consume.base.CsNetModel;
import com.didi.consume.base.CsOmegaUtils;
import com.didi.consume.phone.model.CsDefaultPhoneNumberResp;
import com.didi.consume.phone.view.contract.CsPhoneNumContract;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.utils.WalletToast;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;

public class CsPhoneNumPresenter implements CsPhoneNumContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f16366a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CsPhoneNumContract.View f16367b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletLoadingContract f16368c;

    /* renamed from: d */
    private CsNetModel f16369d;

    /* renamed from: e */
    private String f16370e;

    /* renamed from: f */
    private int f16371f;

    public CsPhoneNumPresenter(Activity activity, CsPhoneNumContract.View view, WalletLoadingContract walletLoadingContract) {
        this.f16366a = activity;
        this.f16367b = view;
        this.f16368c = walletLoadingContract;
        this.f16369d = CsNetModel.getIns(activity);
    }

    public void init() {
        Intent intent = this.f16366a.getIntent();
        String stringExtra = intent.getStringExtra("activity_url");
        String stringExtra2 = intent.getStringExtra(WalletExtraConstant.Key.ACTIVITY_TEXT);
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
            this.f16370e = stringExtra;
            this.f16367b.showActivity(stringExtra2);
        }
        this.f16371f = intent.getIntExtra("order_type", -1);
        HashMap hashMap = new HashMap();
        int i = 1;
        if (this.f16371f != 1) {
            i = 0;
        }
        hashMap.put("order_type", Integer.valueOf(i));
        CsOmegaUtils.trackPhoneBillNumberDisplay(hashMap);
    }

    public void getDefaultPhoneNum(int i) {
        this.f16368c.showLoadingDialog();
        this.f16369d.getDefaultPhoneNumber(i, new RpcService.Callback<CsDefaultPhoneNumberResp>() {
            public void onSuccess(CsDefaultPhoneNumberResp csDefaultPhoneNumberResp) {
                CsPhoneNumPresenter.this.f16368c.dismissLoadingDialog();
                if (csDefaultPhoneNumberResp == null) {
                    WalletToast.showFailedMsg(CsPhoneNumPresenter.this.f16366a, CsPhoneNumPresenter.this.f16366a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    CsPhoneNumPresenter.this.f16367b.onNetworkError();
                } else if (csDefaultPhoneNumberResp.errno == 0) {
                    CsPhoneNumPresenter.this.f16367b.showPhoneNumber(csDefaultPhoneNumberResp.data);
                } else {
                    WalletToast.showFailedMsg(CsPhoneNumPresenter.this.f16366a, csDefaultPhoneNumberResp.errmsg);
                    CsPhoneNumPresenter.this.f16367b.onNetworkError();
                }
            }

            public void onFailure(IOException iOException) {
                CsPhoneNumPresenter.this.f16368c.dismissLoadingDialog();
                WalletToast.showFailedMsg(CsPhoneNumPresenter.this.f16366a, CsPhoneNumPresenter.this.f16366a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                CsPhoneNumPresenter.this.f16367b.onNetworkError();
            }
        });
    }

    public void jumpToActivityPage() {
        WebBrowserUtil.startInternalWebActivity(this.f16366a, this.f16370e, "");
    }
}
