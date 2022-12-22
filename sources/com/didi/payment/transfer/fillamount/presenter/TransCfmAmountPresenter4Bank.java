package com.didi.payment.transfer.fillamount.presenter;

import android.content.Context;
import com.didi.payment.base.utils.MathUtil;
import com.didi.payment.transfer.DebugUtil;
import com.didi.payment.transfer.fillamount.ICfmAmountPageView;
import com.didi.payment.transfer.fillamount.IConfirmTransferInfo;
import com.didi.payment.transfer.fillamount.TransCreateOrderResp;
import com.didi.payment.transfer.net.TransferBizModel;
import com.didi.payment.wallet.password.PasswordDataVo;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class TransCfmAmountPresenter4Bank extends TransCfmAmountPresenter {
    public boolean needSecondConfirmData() {
        return true;
    }

    public TransCfmAmountPresenter4Bank(Context context, ICfmAmountPageView iCfmAmountPageView) {
        super(context, iCfmAmountPageView);
    }

    public void createOrder(int i, int i2, String str, boolean z) {
        m22111a(i, i2, constructMetadata(), constructBizontent(), str);
    }

    /* renamed from: a */
    private void m22111a(int i, int i2, String str, String str2, String str3) {
        ((ICfmAmountPageView) this.mPageView).onShowPageLoadding();
        TransferBizModel.getInstance(getContext()).createTransferOrder(i, i2, str, str2, str3, false, new RpcService.Callback<TransCreateOrderResp>() {
            public void onSuccess(TransCreateOrderResp transCreateOrderResp) {
                ((ICfmAmountPageView) TransCfmAmountPresenter4Bank.this.mPageView).onDismissPageLoadding();
                if (transCreateOrderResp == null) {
                    showDefaultErrorToast();
                } else if (transCreateOrderResp.errno == 60231 || transCreateOrderResp.errno == 60232) {
                    ((ICfmAmountPageView) TransCfmAmountPresenter4Bank.this.mPageView).payPwdInfo(new PasswordDataVo(1, "", transCreateOrderResp.data.paymentPasswordInfo.paySessionId, (String) null, (String) null, (String) null, (String) null));
                } else if (transCreateOrderResp.errno == 60233) {
                    if (transCreateOrderResp.data.noticeInfo != null) {
                        ((ICfmAmountPageView) TransCfmAmountPresenter4Bank.this.mPageView).payPwdInfo(new PasswordDataVo(0, "", "", transCreateOrderResp.data.noticeInfo.title, transCreateOrderResp.data.noticeInfo.content, transCreateOrderResp.data.noticeInfo.confirmButton, transCreateOrderResp.data.noticeInfo.cancelButton));
                    }
                } else if (transCreateOrderResp.errno != 0 && !TextUtil.isEmpty(transCreateOrderResp.errmsg)) {
                    ToastHelper.showShortInfo(TransCfmAmountPresenter4Bank.this.getContext(), transCreateOrderResp.errmsg, (int) R.drawable.wallet_toast_icon_fail);
                } else if (transCreateOrderResp.data == null) {
                    showDefaultErrorToast();
                } else {
                    ((ICfmAmountPageView) TransCfmAmountPresenter4Bank.this.mPageView).toOrderDetailPage(transCreateOrderResp.data.orderId);
                }
            }

            public void onFailure(IOException iOException) {
                DebugUtil.log("create transfer to bank order failed!", new Object[0]);
                ((ICfmAmountPageView) TransCfmAmountPresenter4Bank.this.mPageView).onDismissPageLoadding();
                showDefaultErrorToast();
            }

            private void showDefaultErrorToast() {
                ToastHelper.showShortInfo(TransCfmAmountPresenter4Bank.this.getContext(), TransCfmAmountPresenter4Bank.this.getContext().getResources().getString(R.string.GRider_PAX_Operation_failed_HAmB), (int) R.drawable.wallet_toast_icon_fail);
            }
        });
    }

    public String constructMetadata() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("currency", getCurrency());
            jSONObject.put(ErrorConst.ModuleName.SKU, "transfer_to_bank");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String constructBizontent() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cardHolder", ((ICfmAmountPageView) this.mPageView).getInputValue(IConfirmTransferInfo.ValueType.NAME));
            try {
                jSONObject.put("transferAmount", MathUtil.dollarToCent(Float.parseFloat(((ICfmAmountPageView) this.mPageView).getInputValue(IConfirmTransferInfo.ValueType.Transfer_Amount4Program))));
            } catch (Exception e) {
                DebugUtil.log("parse float transfer amount catch exception : %s", e.getMessage());
            }
            jSONObject.put("cardCode", ((ICfmAmountPageView) this.mPageView).getInputValue(IConfirmTransferInfo.ValueType.BANK_CODE));
            jSONObject.put("orgCode", ((ICfmAmountPageView) this.mPageView).getInputValue(IConfirmTransferInfo.ValueType.AGENT_CODE));
            jSONObject.put("accountType", Integer.valueOf(((ICfmAmountPageView) this.mPageView).getInputValue(IConfirmTransferInfo.ValueType.ACCOUNT_TYPE_VALUE)));
            jSONObject.put("cardId", ((ICfmAmountPageView) this.mPageView).getInputValue(IConfirmTransferInfo.ValueType.BANK_CARD));
            jSONObject.put("cpf", ((ICfmAmountPageView) this.mPageView).getInputValue(IConfirmTransferInfo.ValueType.CPF));
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "{\"msg\":\"error happened when construct !\"}";
        }
    }
}
