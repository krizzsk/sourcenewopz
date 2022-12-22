package com.didi.payment.transfer.newaccount.presenter;

import android.content.Context;
import com.didi.payment.transfer.common.AbsTransRpcSvrCallback;
import com.didi.payment.transfer.net.TransferBizModel;
import com.didi.payment.transfer.newaccount.INewAccountPageView;
import com.didi.payment.transfer.newaccount.TransBankAccountTypeResp;
import com.didi.payment.transfer.newaccount.presenter.ITransNewAccountPresenter;
import java.io.IOException;

public class TransNewAccountPresenter extends ITransNewAccountPresenter {
    public TransNewAccountPresenter(Context context, INewAccountPageView iNewAccountPageView) {
        super(context, iNewAccountPageView);
    }

    /* renamed from: com.didi.payment.transfer.newaccount.presenter.TransNewAccountPresenter$2 */
    static /* synthetic */ class C109732 {

        /* renamed from: $SwitchMap$com$didi$payment$transfer$newaccount$presenter$ITransNewAccountPresenter$TransferBankField */
        static final /* synthetic */ int[] f31428x1352febc;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.payment.transfer.newaccount.presenter.ITransNewAccountPresenter$TransferBankField[] r0 = com.didi.payment.transfer.newaccount.presenter.ITransNewAccountPresenter.TransferBankField.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31428x1352febc = r0
                com.didi.payment.transfer.newaccount.presenter.ITransNewAccountPresenter$TransferBankField r1 = com.didi.payment.transfer.newaccount.presenter.ITransNewAccountPresenter.TransferBankField.CPF     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31428x1352febc     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.payment.transfer.newaccount.presenter.ITransNewAccountPresenter$TransferBankField r1 = com.didi.payment.transfer.newaccount.presenter.ITransNewAccountPresenter.TransferBankField.AGENCY_CODE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31428x1352febc     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.payment.transfer.newaccount.presenter.ITransNewAccountPresenter$TransferBankField r1 = com.didi.payment.transfer.newaccount.presenter.ITransNewAccountPresenter.TransferBankField.BANK_ACCOUNT_NO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.transfer.newaccount.presenter.TransNewAccountPresenter.C109732.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo84971a(ITransNewAccountPresenter.TransferBankField transferBankField) {
        int i = C109732.f31428x1352febc[transferBankField.ordinal()];
        return false;
    }

    public void onAdd() {
        super.onAdd();
        getBankAccountTypeList();
    }

    public void getBankAccountTypeList() {
        ((INewAccountPageView) this.mPageView).onShowPageLoadding();
        TransferBizModel.getInstance(getContext()).getBankAccountTypeList(new AbsTransRpcSvrCallback<TransBankAccountTypeResp>(getContext(), false) {
            public void onHandleSuccess(TransBankAccountTypeResp transBankAccountTypeResp) {
                ((INewAccountPageView) TransNewAccountPresenter.this.mPageView).onDismissPageLoadding();
                if (TransBankAccountTypeResp.isValid(transBankAccountTypeResp)) {
                    ((INewAccountPageView) TransNewAccountPresenter.this.mPageView).onGetAccountTypeList(transBankAccountTypeResp.data);
                } else {
                    showDefaultErrorToast();
                }
            }

            public void onHandleFailure(IOException iOException) {
                ((INewAccountPageView) TransNewAccountPresenter.this.mPageView).onDismissPageLoadding();
                showDefaultErrorToast();
            }
        });
    }
}
