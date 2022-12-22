package com.didi.soda.customer.biz.popdialog.natived.presenter;

import android.text.TextUtils;
import com.didi.soda.customer.biz.popdialog.natived.Contract;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.NAPopDialogEntity;

public class ImagePopDialogPresenter extends Contract.AbsPopDialogPresenter {

    /* renamed from: a */
    private static final String f40498a = "ImagePopDialogPresenter";

    public ImagePopDialogPresenter(NAPopDialogEntity nAPopDialogEntity) {
        super(nAPopDialogEntity);
    }

    public void onImageClick() {
        super.onImageClick();
        if (this.mPopDialogEntity.info != null && !TextUtils.isEmpty(this.mPopDialogEntity.info.redirect)) {
            SchemeHelper.dispatchMsg(this.mPopDialogEntity.info.redirect);
        }
        LogUtil.m29104i(f40498a, "onImageClick redirect = " + this.mPopDialogEntity.info.redirect);
        ((Contract.AbsPopDialogView) getLogicView()).hidePopDialog(this.mPopDialogEntity);
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        ((Contract.AbsPopDialogView) getLogicView()).updatePopDialog(this.mPopDialogEntity);
    }

    /* access modifiers changed from: protected */
    public String getActivityUrl() {
        return (this.mPopDialogEntity.info == null || TextUtils.isEmpty(this.mPopDialogEntity.info.redirect)) ? "" : this.mPopDialogEntity.info.redirect;
    }
}
