package com.didi.soda.customer.biz.popdialog.natived.presenter;

import com.didi.soda.customer.biz.popdialog.natived.Contract;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.NAPopDialogEntity;
import com.didi.soda.customer.foundation.util.LoginUtil;

public class LoginPopDialogPresenter extends Contract.AbsPopDialogPresenter {

    /* renamed from: a */
    private static final String f40499a = "LoginPopDialogPresenter";

    public LoginPopDialogPresenter(NAPopDialogEntity nAPopDialogEntity) {
        super(nAPopDialogEntity);
    }

    public void onImageClick() {
        super.onImageClick();
        LoginUtil.loginActivityAndTrack(getContext(), 14);
        ((Contract.AbsPopDialogView) getLogicView()).hidePopDialog(this.mPopDialogEntity);
        LogUtil.m29104i(f40499a, "onImageClick ");
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        ((Contract.AbsPopDialogView) getLogicView()).updatePopDialog(this.mPopDialogEntity);
    }
}
