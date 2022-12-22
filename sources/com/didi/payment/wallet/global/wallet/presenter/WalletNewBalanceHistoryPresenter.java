package com.didi.payment.wallet.global.wallet.presenter;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.base.utils.WalletToast;
import com.didi.payment.wallet.global.model.WalletBalanceModel;
import com.didi.payment.wallet.global.model.resp.WalletBalanceHistoryResp;
import com.didi.payment.wallet.global.model.resp.WalletBalanceOption;
import com.didi.payment.wallet.global.model.resp.WalletBalanceOptionResp;
import com.didi.payment.wallet.global.wallet.contract.WalletNewBalanceHistoryContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.taxis99.R;
import java.io.IOException;
import java.util.List;

public class WalletNewBalanceHistoryPresenter implements WalletNewBalanceHistoryContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WalletNewBalanceHistoryContract.View f32042a;

    /* renamed from: b */
    private WalletBalanceModel f32043b;

    /* renamed from: c */
    private FragmentActivity f32044c;

    /* renamed from: d */
    private SmartRefreshLayout f32045d;

    /* renamed from: e */
    private int f32046e;

    /* renamed from: f */
    private long f32047f = -1;
    public WalletBalanceOption walletBalanceOptionsSelected;

    public void onDestroy() {
    }

    public WalletNewBalanceHistoryPresenter(FragmentActivity fragmentActivity, WalletNewBalanceHistoryContract.View view, SmartRefreshLayout smartRefreshLayout) {
        this.f32044c = fragmentActivity;
        this.f32042a = view;
        this.f32045d = smartRefreshLayout;
        this.f32043b = new WalletBalanceModel(fragmentActivity);
        requestOptions();
    }

    public void init() {
        requestData();
    }

    public void retryRequestData() {
        requestData();
    }

    public void requestNextData(long j) {
        this.f32046e = 0;
        this.f32047f = j;
        requestData();
    }

    public void onSelectedBalanceOption(WalletBalanceOption walletBalanceOption) {
        this.f32046e = 0;
        this.walletBalanceOptionsSelected = walletBalanceOption;
        requestData();
    }

    public void onSelectedBalanceTime(long j) {
        this.f32046e = 0;
        this.f32047f = j;
        requestData();
    }

    public void requestData() {
        if (this.f32046e == 0) {
            this.f32042a.showLoadingDialog();
        }
        C111901 r6 = new RpcService.Callback<WalletBalanceHistoryResp>() {
            public void onSuccess(WalletBalanceHistoryResp walletBalanceHistoryResp) {
                WalletNewBalanceHistoryPresenter.this.m22722a(walletBalanceHistoryResp);
            }

            public void onFailure(IOException iOException) {
                WalletNewBalanceHistoryPresenter.this.m22722a((WalletBalanceHistoryResp) null);
            }
        };
        WalletBalanceOption walletBalanceOption = this.walletBalanceOptionsSelected;
        int optionType = walletBalanceOption != null ? walletBalanceOption.getOptionType() : 0;
        if (this.f32046e < 0) {
            this.f32046e = 0;
        }
        this.f32043b.getBalanceStatements(this.f32046e, this.f32047f, optionType, r6);
    }

    public void requestOptions() {
        this.f32043b.getBalanceOptions(new RpcService.Callback<WalletBalanceOptionResp>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(WalletBalanceOptionResp walletBalanceOptionResp) {
                List<WalletBalanceOption> options;
                if (walletBalanceOptionResp != null && walletBalanceOptionResp.getData() != null && (options = walletBalanceOptionResp.getData().getOptions()) != null && !options.isEmpty()) {
                    WalletNewBalanceHistoryPresenter.this.f32042a.onBalanceOptionSuccessful(options);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22722a(WalletBalanceHistoryResp walletBalanceHistoryResp) {
        if (this.f32046e == 0) {
            this.f32042a.dismissLoadingDialog();
        }
        this.f32045d.finishRefresh();
        this.f32045d.finishLoadMore();
        if (walletBalanceHistoryResp == null || walletBalanceHistoryResp.errno != 0) {
            if (walletBalanceHistoryResp == null || TextUtils.isEmpty(walletBalanceHistoryResp.errmsg)) {
                FragmentActivity fragmentActivity = this.f32044c;
                WalletToast.showFailedMsg(fragmentActivity, fragmentActivity.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
            } else {
                WalletToast.showFailedMsg(this.f32044c, walletBalanceHistoryResp.errmsg);
            }
            this.f32042a.onNetworkError();
            return;
        }
        m22724b(walletBalanceHistoryResp);
    }

    /* renamed from: b */
    private void m22724b(WalletBalanceHistoryResp walletBalanceHistoryResp) {
        if (walletBalanceHistoryResp != null && walletBalanceHistoryResp.data != null) {
            WalletBalanceHistoryResp.DataBean dataBean = walletBalanceHistoryResp.data;
            boolean z = dataBean.nextIndex != -1;
            List<WalletBalanceHistoryResp.StatementBean> list = dataBean.statement;
            if (this.f32046e == 0) {
                this.f32042a.onBalanceDataSuccessful(list, z, dataBean.topupBtn);
            } else {
                this.f32042a.onBalanceMoreDataSuccessful(list, z);
            }
            this.f32046e = dataBean.nextIndex;
        }
    }
}
