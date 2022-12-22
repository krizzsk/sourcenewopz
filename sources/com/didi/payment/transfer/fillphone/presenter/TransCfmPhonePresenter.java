package com.didi.payment.transfer.fillphone.presenter;

import android.content.Context;
import com.didi.payment.transfer.DebugUtil;
import com.didi.payment.transfer.accounts.presenter.NNPayAccount;
import com.didi.payment.transfer.accounts.presenter.TransAccountRecordResp;
import com.didi.payment.transfer.accounts.presenter.TransVerifyAccountResp;
import com.didi.payment.transfer.common.AbsTransRpcSvrCallback;
import com.didi.payment.transfer.common.model.ConfirmInfo;
import com.didi.payment.transfer.fillamount.IConfirmTransferInfo;
import com.didi.payment.transfer.fillphone.IPhoneCfmView;
import com.didi.payment.transfer.fillphone.TransCountryCodeResp;
import com.didi.payment.transfer.net.TransferBizModel;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.transfer.utils.TransOmegaUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;
import java.io.IOException;
import java.util.List;

public class TransCfmPhonePresenter extends IPhoneConfirmPresenter {
    public void addNoFromContacts() {
    }

    public void validateTel(String str) {
    }

    public TransCfmPhonePresenter(Context context, IPhoneCfmView iPhoneCfmView) {
        super(context, iPhoneCfmView);
    }

    public void onAdd() {
        super.onAdd();
        loadCountryCode();
        loadTransferAccountRecords(2);
    }

    public void loadCountryCode() {
        ((IPhoneCfmView) this.mPageView).onShowPageLoadding();
        TransferBizModel.getInstance(getContext()).queryCountryList(new AbsTransRpcSvrCallback<TransCountryCodeResp>(getContext(), false) {
            public void onHandleSuccess(TransCountryCodeResp transCountryCodeResp) {
                ((IPhoneCfmView) TransCfmPhonePresenter.this.mPageView).onDismissPageLoadding();
                if (transCountryCodeResp == null || transCountryCodeResp.data == null) {
                    ((IPhoneCfmView) TransCfmPhonePresenter.this.mPageView).onCountryCodeLoaded((List<String>) null);
                } else {
                    ((IPhoneCfmView) TransCfmPhonePresenter.this.mPageView).onCountryCodeLoaded(transCountryCodeResp.data.countryCallingCodes);
                }
            }

            public void onHandleFailure(IOException iOException) {
                ((IPhoneCfmView) TransCfmPhonePresenter.this.mPageView).onDismissPageLoadding();
                ((IPhoneCfmView) TransCfmPhonePresenter.this.mPageView).onCountryCodeLoaded((List<String>) null);
            }

            public void onTaskFinish() {
                ((IPhoneCfmView) TransCfmPhonePresenter.this.mPageView).onMultiTaskFinish("request_country_code");
            }
        });
    }

    public void query99AcountByTel(String str, final String str2) {
        DebugUtil.log("input tel: %s & countryCode = %s", str2, str);
        ((IPhoneCfmView) this.mPageView).onShowPageLoadding();
        TransOmegaUtil.removeGlobalParam(TransGlobalOmegaKey.KEY_PAYEE_99ACCOUNT_STATUS);
        TransOmegaUtil.removeGlobalParam(TransGlobalOmegaKey.KEY_PAYEE_99PAY_ACCOUNT_STATUS);
        TransferBizModel.getInstance(getContext()).verifyUserAccount(String.valueOf(str2), String.valueOf(str), new AbsTransRpcSvrCallback<TransVerifyAccountResp>(getContext(), false) {
            public void onHandleSuccess(TransVerifyAccountResp transVerifyAccountResp) {
                ConfirmInfo confirmInfo;
                ((IPhoneCfmView) TransCfmPhonePresenter.this.mPageView).onDismissPageLoadding();
                if (transVerifyAccountResp == null || transVerifyAccountResp.data == null) {
                    showDefaultErrorToast();
                    DebugUtil.log("check tel return empty data", new Object[0]);
                } else if (!transVerifyAccountResp.data.telValid) {
                    ToastHelper.showShortInfo(TransCfmPhonePresenter.this.getContext(), !TextUtil.isEmpty(transVerifyAccountResp.data.telInvalidMsg) ? transVerifyAccountResp.data.telInvalidMsg : "Invalid phone number, please check.", (int) R.drawable.wallet_toast_icon_fail);
                } else {
                    boolean z = transVerifyAccountResp.data.has99TaxiAccount;
                    boolean z2 = transVerifyAccountResp.data.hasRegiste99Pay;
                    TransOmegaUtil.addGlobalParam(TransGlobalOmegaKey.KEY_PAYEE_99ACCOUNT_STATUS, Integer.valueOf(z ? 1 : 0));
                    TransOmegaUtil.addGlobalParam(TransGlobalOmegaKey.KEY_PAYEE_99PAY_ACCOUNT_STATUS, Integer.valueOf(z2 ? 1 : 0));
                    transVerifyAccountResp.rebuildSelf();
                    if (transVerifyAccountResp.data.accountInfo == null) {
                        NNPayAccount nNPayAccount = new NNPayAccount();
                        nNPayAccount.setTypeValue(IConfirmTransferInfo.ValueType.To_TEL, str2);
                        nNPayAccount.localConstruct = true;
                        transVerifyAccountResp.data.accountInfo = nNPayAccount;
                    }
                    if (transVerifyAccountResp.data.hasRegiste99Pay) {
                        confirmInfo = transVerifyAccountResp.data.confirmNotice;
                        if (confirmInfo == null) {
                            confirmInfo = new ConfirmInfo();
                            confirmInfo.titleMain = String.format(TransCfmPhonePresenter.this.getContext().getString(R.string.GRider_PAX_Do_you_fzlF), new Object[]{transVerifyAccountResp.data.accountInfo.getValueByType(IConfirmTransferInfo.ValueType.NAME)});
                            confirmInfo.titleDesc = TransCfmPhonePresenter.this.getContext().getString(R.string.GRider_PAX_Please_note_yAUz);
                            confirmInfo.initDefaultBtn(TransCfmPhonePresenter.this.getContext());
                        }
                    } else {
                        confirmInfo = transVerifyAccountResp.data.confirmNotice;
                        if (confirmInfo != null) {
                            if (TextUtil.isEmpty(confirmInfo.btnTextPositive)) {
                                confirmInfo.btnTextPositive = TransCfmPhonePresenter.this.getContext().getResources().getString(R.string.GRider_pax_positive_btn_Yes);
                            }
                            if (TextUtil.isEmpty(confirmInfo.btnTextNegative)) {
                                confirmInfo.btnTextNegative = TransCfmPhonePresenter.this.getContext().getResources().getString(R.string.GRider_pax_negative_btn_No);
                            }
                        }
                    }
                    if (confirmInfo != null) {
                        ((IPhoneCfmView) TransCfmPhonePresenter.this.mPageView).showConfirmTransferDialog(confirmInfo, transVerifyAccountResp.data.accountInfo);
                    } else {
                        ((IPhoneCfmView) TransCfmPhonePresenter.this.mPageView).gotoEditAmountPage(transVerifyAccountResp.data.accountInfo);
                    }
                }
            }

            public void onHandleFailure(IOException iOException) {
                ((IPhoneCfmView) TransCfmPhonePresenter.this.mPageView).onDismissPageLoadding();
                showDefaultErrorToast();
            }
        });
    }

    public boolean loadTransferAccountRecords(int i) {
        ((IPhoneCfmView) this.mPageView).onShowPageLoadding();
        TransferBizModel.getInstance(getContext()).loadHistoryTransAccounts(i, 0, 5, new AbsTransRpcSvrCallback<TransAccountRecordResp>(getContext(), false) {
            public void onHandleSuccess(TransAccountRecordResp transAccountRecordResp) {
                ((IPhoneCfmView) TransCfmPhonePresenter.this.mPageView).onDismissPageLoadding();
                if (transAccountRecordResp == null || transAccountRecordResp.data == null) {
                    ((IPhoneCfmView) TransCfmPhonePresenter.this.mPageView).onHistoryTransAccountLoaded((List<NNPayAccount>) null);
                } else {
                    ((IPhoneCfmView) TransCfmPhonePresenter.this.mPageView).onHistoryTransAccountLoaded(transAccountRecordResp.data.transAccounts);
                }
            }

            public void onHandleFailure(IOException iOException) {
                ((IPhoneCfmView) TransCfmPhonePresenter.this.mPageView).onDismissPageLoadding();
                ((IPhoneCfmView) TransCfmPhonePresenter.this.mPageView).onHistoryTransAccountLoaded((List<NNPayAccount>) null);
            }

            public void onTaskFinish() {
                ((IPhoneCfmView) TransCfmPhonePresenter.this.mPageView).onMultiTaskFinish("request_history_transfer_record");
            }
        });
        return false;
    }
}
