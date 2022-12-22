package com.didi.payment.wallet.global.useraccount.balance.presenter;

import android.app.Activity;
import com.didi.payment.base.utils.WalletToast;
import com.didi.payment.wallet.global.useraccount.balance.contract.WalletBalanceContract;
import com.didi.payment.wallet.global.useraccount.balance.model.BalanceModel;
import com.didi.payment.wallet.global.useraccount.balance.model.BalanceResp;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class WalletBalancePresenter implements WalletBalanceContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f31812a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WalletBalanceContract.View f31813b;

    /* renamed from: c */
    private BalanceModel f31814c;

    /* renamed from: d */
    private int f31815d;

    /* renamed from: e */
    private int f31816e;

    /* renamed from: f */
    private String f31817f;

    public WalletBalancePresenter(Activity activity, WalletBalanceContract.View view, int i, String str) {
        this.f31812a = activity;
        this.f31813b = view;
        this.f31816e = i;
        this.f31817f = str;
        this.f31814c = new BalanceModel(activity);
    }

    public void retryRequestData() {
        this.f31815d = 0;
        requestData();
    }

    /* renamed from: a */
    private void m22548a(long j, int i, String str, RpcService.Callback<BalanceResp> callback) {
        this.f31814c.requestBalanceList(j, i, str, callback);
    }

    public void requestData() {
        this.f31813b.showLoadingFirstTime();
        m22548a((long) this.f31815d, this.f31816e, this.f31817f, new RpcService.Callback<BalanceResp>() {
            public void onSuccess(BalanceResp balanceResp) {
                WalletBalancePresenter.this.f31813b.dismissLoadingFirstTime();
                if (balanceResp == null) {
                    WalletToast.showFailedMsg(WalletBalancePresenter.this.f31812a, WalletBalancePresenter.this.f31812a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    WalletBalancePresenter.this.f31813b.onNetworkError();
                } else if (balanceResp.errno == 0) {
                    WalletBalancePresenter.this.m22549a(balanceResp);
                } else {
                    WalletToast.showFailedMsg(WalletBalancePresenter.this.f31812a, balanceResp.errmsg);
                    WalletBalancePresenter.this.f31813b.onNetworkError();
                }
            }

            public void onFailure(IOException iOException) {
                WalletBalancePresenter.this.f31813b.dismissLoadingFirstTime();
                WalletToast.showFailedMsg(WalletBalancePresenter.this.f31812a, WalletBalancePresenter.this.f31812a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                WalletBalancePresenter.this.f31813b.onNetworkError();
            }
        });
    }

    public void requestMoreData() {
        m22548a((long) this.f31815d, this.f31816e, this.f31817f, new RpcService.Callback<BalanceResp>() {
            public void onSuccess(BalanceResp balanceResp) {
                if (balanceResp == null) {
                    WalletToast.showFailedMsg(WalletBalancePresenter.this.f31812a, WalletBalancePresenter.this.f31812a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    WalletBalancePresenter.this.f31813b.onNetworkError();
                } else if (balanceResp.errno != 0 || balanceResp.data == null) {
                    WalletToast.showFailedMsg(WalletBalancePresenter.this.f31812a, balanceResp.errmsg);
                    WalletBalancePresenter.this.f31813b.onNetworkError();
                } else {
                    WalletBalancePresenter.this.m22552b(balanceResp);
                }
            }

            public void onFailure(IOException iOException) {
                WalletToast.showFailedMsg(WalletBalancePresenter.this.f31812a, WalletBalancePresenter.this.f31812a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                WalletBalancePresenter.this.f31813b.onNetworkError();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22549a(BalanceResp balanceResp) {
        if (balanceResp != null) {
            BalanceResp.DataBean dataBean = balanceResp.data;
            int i = dataBean.nextIndex;
            this.f31815d = i;
            this.f31813b.onBalanceDataSuccessful(dataBean.statement, i != -1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m22552b(BalanceResp balanceResp) {
        if (balanceResp != null) {
            BalanceResp.DataBean dataBean = balanceResp.data;
            int i = dataBean.nextIndex;
            this.f31815d = i;
            this.f31813b.onBalanceMoreDataSuccessful(dataBean.statement, i != -1);
        }
    }
}
