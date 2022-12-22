package com.didi.payment.transfer.fillamount.presenter;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.utils.MathUtil;
import com.didi.payment.transfer.DebugUtil;
import com.didi.payment.transfer.common.AbsTransRpcSvrCallback;
import com.didi.payment.transfer.fillamount.ICfmAmountPageView;
import com.didi.payment.transfer.fillamount.IConfirmTransferInfo;
import com.didi.payment.transfer.fillamount.TransCreateOrderResp;
import com.didi.payment.transfer.fillamount.TransServiceFeeResp;
import com.didi.payment.transfer.fillamount.presenter.ICfmAmountPresenter;
import com.didi.payment.transfer.net.TransferBizModel;
import com.didi.payment.wallet.global.model.NightlyLimitSettingModel;
import com.didi.payment.wallet.global.model.resp.GetNightlyLimitResp;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.io.IOException;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

public class TransCfmAmountPresenter extends ICfmAmountPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public TransCreateOrderResp.DataBean f31367a;

    /* renamed from: b */
    private NightlyLimitSettingModel f31368b;

    /* access modifiers changed from: protected */
    public String getCurrency() {
        return "BRL";
    }

    public FragmentManager getFragmentMgr() {
        return null;
    }

    public void verifyInputAmount(float f, ICfmAmountPresenter.VerifyNumberlCallback verifyNumberlCallback) {
    }

    public TransCfmAmountPresenter(Context context, ICfmAmountPageView iCfmAmountPageView) {
        super(context, iCfmAmountPageView);
        this.f31368b = new NightlyLimitSettingModel(context);
    }

    public String constructMetadata() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("currency", getCurrency());
            jSONObject.put(ErrorConst.ModuleName.SKU, "transfer_to_99pay");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String constructBizontent() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("toTel", ((ICfmAmountPageView) this.mPageView).getInputValue(IConfirmTransferInfo.ValueType.To_TEL));
        jsonObject.addProperty("toName", ((ICfmAmountPageView) this.mPageView).getInputValue(IConfirmTransferInfo.ValueType.NAME));
        try {
            jsonObject.addProperty("transferAmount", (Number) Integer.valueOf(MathUtil.dollarToCent(Float.parseFloat(((ICfmAmountPageView) this.mPageView).getInputValue(IConfirmTransferInfo.ValueType.Transfer_Amount4Program)))));
        } catch (Exception e) {
            DebugUtil.log("parse float transfer amount catch exception: %s", e.getMessage());
        }
        jsonObject.addProperty("toCountryCode", ((ICfmAmountPageView) this.mPageView).getInputValue(IConfirmTransferInfo.ValueType.To_CountryCode));
        jsonObject.addProperty("toIconUrl", ((ICfmAmountPageView) this.mPageView).getInputValue(IConfirmTransferInfo.ValueType.HEAD_ICON));
        return jsonObject.toString();
    }

    public void loadServiceFeeData(int i, final int i2, String str) {
        ((ICfmAmountPageView) this.mPageView).onShowPageLoadding();
        TransferBizModel.getInstance(getContext()).queryServiceFee(i, i2, str, new RpcService.Callback<TransServiceFeeResp>() {
            public void onSuccess(TransServiceFeeResp transServiceFeeResp) {
                ((ICfmAmountPageView) TransCfmAmountPresenter.this.mPageView).onDismissPageLoadding();
                if (transServiceFeeResp.data == null || transServiceFeeResp.data.withdrawMg == null) {
                    ((ICfmAmountPageView) TransCfmAmountPresenter.this.mPageView).onServiceFeeGot((TransServiceFeeResp) null);
                    DebugUtil.log("load drawfee return empty data!", new Object[0]);
                    return;
                }
                ((ICfmAmountPageView) TransCfmAmountPresenter.this.mPageView).onServiceFeeGot(transServiceFeeResp);
                TransCfmAmountPresenter.this.loadNightlyLimitConfig(i2);
            }

            public void onFailure(IOException iOException) {
                DebugUtil.log("load drawfee return empty data!", new Object[0]);
                ((ICfmAmountPageView) TransCfmAmountPresenter.this.mPageView).onServiceFeeGot((TransServiceFeeResp) null);
                ((ICfmAmountPageView) TransCfmAmountPresenter.this.mPageView).onDismissPageLoadding();
            }
        });
    }

    public void loadNightlyLimitConfig(int i) {
        ((ICfmAmountPageView) this.mPageView).onShowPageLoadding();
        this.f31368b.getNightlyLimit(i, new RpcService.Callback<GetNightlyLimitResp>() {
            public void onSuccess(GetNightlyLimitResp getNightlyLimitResp) {
                ((ICfmAmountPageView) TransCfmAmountPresenter.this.mPageView).onDismissPageLoadding();
                GetNightlyLimitResp.NightlyLimitVo nightlyLimitVo = getNightlyLimitResp.data;
                if (getNightlyLimitResp.errno != 0 || nightlyLimitVo == null) {
                    ((ICfmAmountPageView) TransCfmAmountPresenter.this.mPageView).onFetchLimit((GetNightlyLimitResp.NightlyLimitVo) null);
                } else {
                    ((ICfmAmountPageView) TransCfmAmountPresenter.this.mPageView).onFetchLimit(nightlyLimitVo);
                }
            }

            public void onFailure(IOException iOException) {
                ((ICfmAmountPageView) TransCfmAmountPresenter.this.mPageView).onDismissPageLoadding();
                ((ICfmAmountPageView) TransCfmAmountPresenter.this.mPageView).onFetchLimit((GetNightlyLimitResp.NightlyLimitVo) null);
            }
        });
    }

    public void createOrder(final int i, int i2, String str, boolean z) {
        ((ICfmAmountPageView) this.mPageView).onShowPageLoadding();
        TransferBizModel.getInstance(getContext()).createTransferOrder(i, i2, constructMetadata(), constructBizontent(), str, z, new AbsTransRpcSvrCallback<TransCreateOrderResp>(getContext(), true) {
            public void onHandleSuccess(TransCreateOrderResp transCreateOrderResp) {
                ((ICfmAmountPageView) TransCfmAmountPresenter.this.mPageView).onDismissPageLoadding();
                if (transCreateOrderResp == null) {
                    DebugUtil.log("Create order return empty data!", new Object[0]);
                    showDefaultErrorToast();
                } else if (transCreateOrderResp.errno != 0 && !TextUtil.isEmpty(transCreateOrderResp.errmsg)) {
                    DebugUtil.log("Create order return errmsg!", new Object[0]);
                    ToastHelper.showShortInfo(TransCfmAmountPresenter.this.getContext(), transCreateOrderResp.errmsg, (int) R.drawable.wallet_toast_icon_fail);
                } else if (transCreateOrderResp.data == null) {
                    DebugUtil.log("Create order return empty data!", new Object[0]);
                    showDefaultErrorToast();
                } else {
                    TransCreateOrderResp.DataBean unused = TransCfmAmountPresenter.this.f31367a = transCreateOrderResp.data;
                    ((ICfmAmountPageView) TransCfmAmountPresenter.this.mPageView).openCashier(transCreateOrderResp.data, i);
                    TransCreateOrderResp.ToastInfo toastInfo = transCreateOrderResp.data.toastInfo;
                    if (toastInfo != null && toastInfo.isErrorToast()) {
                        ToastHelper.showShortInfo(TransCfmAmountPresenter.this.getContext(), toastInfo.message, (int) R.drawable.wallet_toast_icon_fail);
                    }
                }
            }

            public void onHandleFailure(IOException iOException) {
                ((ICfmAmountPageView) TransCfmAmountPresenter.this.mPageView).onDismissPageLoadding();
                DebugUtil.log("Create order failed!", new Object[0]);
            }
        });
    }

    public void onPaySuccess(String str) {
        TransCreateOrderResp.DataBean dataBean = this.f31367a;
        String str2 = dataBean != null ? dataBean.orderId : "-1";
        DebugUtil.log("goto order detail page with created order id: " + str2, new Object[0]);
        ((ICfmAmountPageView) this.mPageView).toOrderDetailPage(str2);
        EventBus.getDefault().post(new WalletRefreshDataEvent());
    }
}
