package com.didi.payment.transfer.newaccount.presenter;

import android.content.Context;
import com.didi.payment.transfer.common.AbsTransBasePresenter;
import com.didi.payment.transfer.newaccount.INewAccountPageView;

public abstract class ITransNewAccountPresenter extends AbsTransBasePresenter<INewAccountPageView> {
    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract boolean mo84971a(TransferBankField transferBankField);

    public abstract void getBankAccountTypeList();

    public ITransNewAccountPresenter(Context context, INewAccountPageView iNewAccountPageView) {
        super(context, iNewAccountPageView);
    }

    public enum TransferBankField {
        CPF(0),
        BANK_ACCOUNT_NO(1),
        AGENCY_CODE(2);
        
        private int value;

        private TransferBankField(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }
}
