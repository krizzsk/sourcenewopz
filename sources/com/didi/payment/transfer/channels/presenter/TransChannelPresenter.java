package com.didi.payment.transfer.channels.presenter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.transfer.DebugUtil;
import com.didi.payment.transfer.channels.IChannelPageView;
import com.didi.payment.transfer.channels.IChannelPresenter;
import com.didi.payment.transfer.channels.TransChannelResp;
import com.didi.payment.transfer.common.AbsTransRpcSvrCallback;
import com.didi.payment.transfer.common.model.ConfirmInfo;
import com.didi.payment.transfer.common.model.FuncButton;
import com.didi.payment.transfer.common.model.OmegaAccountState;
import com.didi.payment.transfer.constants.TransferContants;
import com.didi.payment.transfer.net.TransferBizModel;
import com.didi.payment.transfer.records.TransOrderRecordsActivity;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.transfer.utils.TransOmegaUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.unifiedPay.util.LogUtil;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class TransChannelPresenter extends IChannelPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AtomicBoolean f31317a = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f31318b = "";

    public TransChannelPresenter(Context context, IChannelPageView iChannelPageView) {
        super(context, iChannelPageView);
    }

    public void loadChannels() {
        ((IChannelPageView) this.mPageView).onShowPageLoadding();
        TransferBizModel.getInstance(this.mContext).loadTransferChannels(new HashMap(), new AbsTransRpcSvrCallback<TransChannelResp>(getContext(), false) {
            public void onHandleSuccess(TransChannelResp transChannelResp) {
                if (transChannelResp == null || transChannelResp.errno != 0) {
                    ((IChannelPageView) TransChannelPresenter.this.mPageView).onLoadChannelFail((TransChannelResp.DataBean) null);
                    return;
                }
                ((IChannelPageView) TransChannelPresenter.this.mPageView).updateChannel(transChannelResp.data);
                String unused = TransChannelPresenter.this.f31318b = transChannelResp.data.productLines;
            }

            public void onHandleFailure(IOException iOException) {
                ((IChannelPageView) TransChannelPresenter.this.mPageView).onLoadChannelFail((TransChannelResp.DataBean) null);
            }

            public void onTaskFinish() {
                ((IChannelPageView) TransChannelPresenter.this.mPageView).onDismissPageLoadding();
            }
        });
    }

    /* renamed from: a */
    private void m22038a(final int i) {
        if (this.f31317a.get()) {
            LogUtil.m31685fi("wallet_transfer", "request not return, wait!");
            return;
        }
        ((IChannelPageView) this.mPageView).onShowPageLoadding();
        OmegaAccountState.getInstance().clearPayerInfo();
        this.f31317a.set(true);
        TransferBizModel.getInstance(getContext()).queryAccountStatus(new AbsTransRpcSvrCallback<TransAccountStatusResp>(getContext()) {
            public void onHandleSuccess(TransAccountStatusResp transAccountStatusResp) {
                ((IChannelPageView) TransChannelPresenter.this.mPageView).onDismissPageLoadding();
                if (transAccountStatusResp == null || transAccountStatusResp.data == null) {
                    LogUtil.m31685fi("wallet_transfer", "check account status return empty data!");
                    showDefaultErrorToast();
                    return;
                }
                TransOmegaUtil.addGlobalParam(TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, Integer.valueOf(transAccountStatusResp.data.status));
                if (transAccountStatusResp.data.status == 1) {
                    ((IChannelPageView) TransChannelPresenter.this.mPageView).gotoCfmPhonePage(i);
                    return;
                }
                ConfirmInfo confirmInfo = transAccountStatusResp.data.registerNotice;
                final FuncButton funcButton = transAccountStatusResp.data.registerButton;
                FuncButton funcButton2 = transAccountStatusResp.data.gotItButton;
                if (confirmInfo == null || funcButton == null) {
                    DebugUtil.showShortToast(TransChannelPresenter.this.getContext(), "can't get account status.", R.drawable.common_toast_icon_error);
                    return;
                }
                if (i == 651) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("add_version", "v1217");
                    TransOmegaUtil.trackEventWithGlobal("ibt_didipay_p2p_bank_account_unregistered_sw", hashMap, TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS);
                }
                String str = confirmInfo.titleMain;
                String str2 = funcButton.label;
                String str3 = funcButton2 != null ? funcButton2.label : "";
                if (WalletApolloUtil.isNewPayMethodListEnable()) {
                    if (!TextUtil.isEmpty(confirmInfo.newTitleMain)) {
                        str = confirmInfo.newTitleMain;
                    }
                    if (!TextUtil.isEmpty(funcButton.newLabel)) {
                        str2 = funcButton.newLabel;
                    }
                    if (funcButton2 != null && !TextUtil.isEmpty(funcButton2.newLabel)) {
                        str3 = funcButton2.newLabel;
                    }
                }
                ((IChannelPageView) TransChannelPresenter.this.mPageView).showAccountRegisteDialog(str, confirmInfo.titleDesc, str2, str3, new DoubleCheckOnClickListener() {
                    public void doClick(View view) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("add_version", "v1217");
                        TransOmegaUtil.trackEventWithGlobal("ibt_didipay_p2p_bank_account_registration_confirm_ck", hashMap, TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS);
                        DRouter.build(!TextUtil.isEmpty(funcButton.routerUrl) ? funcButton.routerUrl : TransferContants.Router.ROUTE_TO_99PAY_REGISTE).start(TransChannelPresenter.this.getContext());
                    }
                }, (DoubleCheckOnClickListener) null);
            }

            public void onHandleFailure(IOException iOException) {
                ((IChannelPageView) TransChannelPresenter.this.mPageView).onDismissPageLoadding();
                DebugUtil.showShortToast(TransChannelPresenter.this.getContext(), "verity user accont failed!");
            }

            public void onTaskFinish() {
                TransChannelPresenter.this.f31317a.set(false);
            }
        });
    }

    public void onHandleChannelItemClick(TransChannelResp.ChannelBean channelBean) {
        if (channelBean != null) {
            TransOmegaUtil.addOmegaGlobalParam("wallet_channel_id", channelBean.channelId);
            m22038a(channelBean.productLine);
        }
    }

    public void toHistoryPage() {
        Bundle bundle = new Bundle();
        bundle.putInt(TransferContants.IntentKey.INTENT_PARAM_KEY_PRODUCT_LINE, 99999);
        bundle.putInt(TransferContants.IntentKey.INTENT_PARAM_KEY_FROM_PAGE, TransferContants.Pages.PAGE_TRANSFER_CHANNELS);
        bundle.putString(TransferContants.IntentKey.INTENT_PARAMS_KEY_PRODUCT_LINES, this.f31318b);
        TransOrderRecordsActivity.startActivity(getContext(), bundle);
    }
}
