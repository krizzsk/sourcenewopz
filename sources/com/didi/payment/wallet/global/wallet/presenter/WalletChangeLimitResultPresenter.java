package com.didi.payment.wallet.global.wallet.presenter;

import androidx.fragment.app.FragmentActivity;
import com.didi.payment.wallet.global.model.NightlyLimitSettingModel;
import com.didi.payment.wallet.global.model.resp.QueryNightlyLimitSettingResp;
import com.didi.payment.wallet.global.wallet.contract.WalletChangeLimitResultContract;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;

public class WalletChangeLimitResultPresenter implements WalletChangeLimitResultContract.IPresenter {

    /* renamed from: a */
    private FragmentActivity f32016a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WalletChangeLimitResultContract.IView f32017b;

    /* renamed from: c */
    private final NightlyLimitSettingModel f32018c;

    public WalletChangeLimitResultPresenter(FragmentActivity fragmentActivity, WalletChangeLimitResultContract.IView iView) {
        this.f32016a = fragmentActivity;
        this.f32017b = iView;
        this.f32018c = new NightlyLimitSettingModel(fragmentActivity);
    }

    public void requestData() {
        this.f32017b.showLoadingDialog();
        this.f32018c.getNightlyLimitSetting(new RpcService.Callback<QueryNightlyLimitSettingResp>() {
            public void onSuccess(QueryNightlyLimitSettingResp queryNightlyLimitSettingResp) {
                if (WalletChangeLimitResultPresenter.this.f32017b != null) {
                    QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo queryNightlyLimitSettingVo = queryNightlyLimitSettingResp.data;
                    if (queryNightlyLimitSettingResp.errno != 0 || queryNightlyLimitSettingVo == null) {
                        WalletChangeLimitResultPresenter.this.f32017b.showNetworkError();
                    } else {
                        WalletChangeLimitResultPresenter.this.f32017b.showResult(queryNightlyLimitSettingVo);
                    }
                    WalletChangeLimitResultPresenter.this.f32017b.dismissLoadingDialog();
                }
            }

            public void onFailure(IOException iOException) {
                if (WalletChangeLimitResultPresenter.this.f32017b != null) {
                    WalletChangeLimitResultPresenter.this.f32017b.dismissLoadingDialog();
                    WalletChangeLimitResultPresenter.this.f32017b.showNetworkError();
                }
            }
        });
    }

    public void destroy() {
        WalletChangeLimitResultContract.IView iView = this.f32017b;
        if (iView != null) {
            iView.dismissLoadingDialog();
        }
        this.f32016a = null;
        this.f32017b = null;
    }
}
