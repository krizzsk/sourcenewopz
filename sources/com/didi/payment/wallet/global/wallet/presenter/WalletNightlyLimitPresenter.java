package com.didi.payment.wallet.global.wallet.presenter;

import androidx.fragment.app.FragmentActivity;
import com.didi.payment.wallet.global.model.NightlyLimitSettingModel;
import com.didi.payment.wallet.global.model.resp.QueryNightlyLimitSettingResp;
import com.didi.payment.wallet.global.wallet.contract.WalletNightlyLimitContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class WalletNightlyLimitPresenter implements WalletNightlyLimitContract.IPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WalletNightlyLimitContract.IView f32071a;

    /* renamed from: b */
    private FragmentActivity f32072b;

    /* renamed from: c */
    private NightlyLimitSettingModel f32073c;

    public WalletNightlyLimitPresenter(WalletNightlyLimitContract.IView iView, FragmentActivity fragmentActivity) {
        this.f32071a = iView;
        this.f32072b = fragmentActivity;
        this.f32073c = new NightlyLimitSettingModel(fragmentActivity);
    }

    public void requestData() {
        this.f32071a.showLoadingDialog();
        this.f32073c.getNightlyLimitSetting(new RpcService.Callback<QueryNightlyLimitSettingResp>() {
            public void onSuccess(QueryNightlyLimitSettingResp queryNightlyLimitSettingResp) {
                if (WalletNightlyLimitPresenter.this.f32071a != null) {
                    WalletNightlyLimitPresenter.this.f32071a.dismissLoadingDialog();
                    QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo queryNightlyLimitSettingVo = queryNightlyLimitSettingResp.data;
                    if (queryNightlyLimitSettingResp.errno != 0 || queryNightlyLimitSettingVo == null) {
                        WalletNightlyLimitPresenter.this.f32071a.onNetworkError();
                    } else {
                        WalletNightlyLimitPresenter.this.f32071a.showSettingLimit(queryNightlyLimitSettingVo);
                    }
                }
            }

            public void onFailure(IOException iOException) {
                if (WalletNightlyLimitPresenter.this.f32071a != null) {
                    WalletNightlyLimitPresenter.this.f32071a.dismissLoadingDialog();
                    WalletNightlyLimitPresenter.this.f32071a.onNetworkError();
                }
            }
        });
    }

    public void submit(long j, long j2) {
        WalletNightlyLimitContract.IView iView = this.f32071a;
        if (iView != null) {
            iView.showLoadingDialog();
            this.f32073c.setNightlyLimit(j, j2, new RpcService.Callback<QueryNightlyLimitSettingResp>() {
                public void onSuccess(QueryNightlyLimitSettingResp queryNightlyLimitSettingResp) {
                    if (WalletNightlyLimitPresenter.this.f32071a != null) {
                        WalletNightlyLimitPresenter.this.f32071a.dismissLoadingDialog();
                        QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo queryNightlyLimitSettingVo = queryNightlyLimitSettingResp.data;
                        if (queryNightlyLimitSettingResp.errno == 0 && queryNightlyLimitSettingVo != null) {
                            WalletNightlyLimitPresenter.this.f32071a.onChangeSuccess(queryNightlyLimitSettingVo);
                        } else if (queryNightlyLimitSettingResp.errno == 40101) {
                            WalletNightlyLimitPresenter.this.f32071a.onChangeFailed(queryNightlyLimitSettingResp.errmsg);
                        } else {
                            WalletNightlyLimitPresenter.this.f32071a.onChangeFailed(WalletNightlyLimitPresenter.this.f32071a.getContext().getString(R.string.pay_base_network_error));
                        }
                    }
                }

                public void onFailure(IOException iOException) {
                    if (WalletNightlyLimitPresenter.this.f32071a != null) {
                        WalletNightlyLimitPresenter.this.f32071a.dismissLoadingDialog();
                        WalletNightlyLimitPresenter.this.f32071a.onChangeFailed(WalletNightlyLimitPresenter.this.f32071a.getContext().getString(R.string.pay_base_network_error));
                    }
                }
            });
        }
    }

    public void destroy() {
        WalletNightlyLimitContract.IView iView = this.f32071a;
        if (iView != null) {
            iView.dismissLoadingDialog();
        }
        this.f32071a = null;
        this.f32072b = null;
    }
}
