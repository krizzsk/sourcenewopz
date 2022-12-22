package com.didi.payment.transfer.fillphone.presenter;

import android.content.Context;
import com.didi.payment.transfer.common.AbsTransBasePresenter;
import com.didi.payment.transfer.fillphone.IPhoneCfmView;

public abstract class IPhoneConfirmPresenter extends AbsTransBasePresenter<IPhoneCfmView> {
    public abstract void addNoFromContacts();

    public abstract void loadCountryCode();

    public abstract boolean loadTransferAccountRecords(int i);

    public abstract void query99AcountByTel(String str, String str2);

    public abstract void validateTel(String str);

    public IPhoneConfirmPresenter(Context context, IPhoneCfmView iPhoneCfmView) {
        super(context, iPhoneCfmView);
    }
}
