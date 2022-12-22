package com.didi.payment.wallet.global.wallet.presenter;

import androidx.fragment.app.FragmentActivity;
import com.didi.payment.base.utils.WalletToast;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.model.resp.WalletCreateOrderRespOldServer;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didi.payment.wallet.global.wallet.contract.WalletTopUpAmountContractOldServer;
import com.didi.payment.wallet.global.wallet.view.widget.TopUpCheckErrorDialogFragment;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class WalletTopUpAmountPresenterOldServer implements WalletTopUpAmountContractOldServer.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public FragmentActivity f32093a;

    /* renamed from: b */
    private WalletTopUpAmountContractOldServer.View f32094b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletLoadingContract f32095c;

    /* renamed from: d */
    private WalletPageModel f32096d;

    public WalletTopUpAmountPresenterOldServer(FragmentActivity fragmentActivity, WalletTopUpAmountContractOldServer.View view, WalletLoadingContract walletLoadingContract) {
        this.f32093a = fragmentActivity;
        this.f32094b = view;
        this.f32095c = walletLoadingContract;
        this.f32096d = new WalletPageModel(fragmentActivity);
    }

    public void requestData() {
        this.f32095c.showLoadingDialog();
    }

    public void handleTopUpClick(WalletTopUpChannelResp.ExtraDataMexicoOnlineItem extraDataMexicoOnlineItem) {
        if (extraDataMexicoOnlineItem != null) {
            this.f32095c.showLoadingDialog();
            this.f32096d.createOrderOldServer(extraDataMexicoOnlineItem.sku, extraDataMexicoOnlineItem.currency, extraDataMexicoOnlineItem.extend_params, new RpcService.Callback<WalletCreateOrderRespOldServer>() {
                public void onSuccess(WalletCreateOrderRespOldServer walletCreateOrderRespOldServer) {
                    WalletTopUpAmountPresenterOldServer.this.f32095c.dismissLoadingDialog();
                    if (walletCreateOrderRespOldServer == null) {
                        WalletToast.showFailedMsg(WalletTopUpAmountPresenterOldServer.this.f32093a, WalletTopUpAmountPresenterOldServer.this.f32093a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    } else if (walletCreateOrderRespOldServer.errno != 0 || walletCreateOrderRespOldServer.data == null) {
                        TopUpCheckErrorDialogFragment topUpCheckErrorDialogFragment = new TopUpCheckErrorDialogFragment();
                        topUpCheckErrorDialogFragment.setData(walletCreateOrderRespOldServer.errmsg);
                        topUpCheckErrorDialogFragment.show(WalletTopUpAmountPresenterOldServer.this.f32093a.getSupportFragmentManager(), "topuperror");
                    } else {
                        WalletTopUpAmountPresenterOldServer.this.onCreateOrderSuccess(walletCreateOrderRespOldServer.data);
                    }
                }

                public void onFailure(IOException iOException) {
                    WalletTopUpAmountPresenterOldServer.this.f32095c.dismissLoadingDialog();
                    WalletToast.showFailedMsg(WalletTopUpAmountPresenterOldServer.this.f32093a, WalletTopUpAmountPresenterOldServer.this.f32093a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                }
            });
        }
    }

    public void onCreateOrderSuccess(WalletCreateOrderRespOldServer.DataBean dataBean) {
        WalletRouter.gotoUniPayPage(this.f32093a, dataBean);
    }
}
