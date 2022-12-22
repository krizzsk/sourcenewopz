package com.didi.soda.customer.biz.popdialog.natived.presenter;

import android.text.TextUtils;
import com.didi.soda.customer.biz.popdialog.natived.Contract;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.NAPopDialogEntity;

public class CouponPopDialogPresenter extends Contract.AbsPopDialogPresenter {

    /* renamed from: a */
    private static final String f40497a = "CouponPopDialogPresenter";

    public CouponPopDialogPresenter(NAPopDialogEntity nAPopDialogEntity) {
        super(nAPopDialogEntity);
    }

    public void onBtnClick() {
        super.onBtnClick();
        if (this.mPopDialogEntity.info != null && !TextUtils.isEmpty(this.mPopDialogEntity.info.btnUrl)) {
            SchemeHelper.dispatchMsg(this.mPopDialogEntity.info.btnUrl);
        }
        ((Contract.AbsPopDialogView) getLogicView()).hidePopDialog(this.mPopDialogEntity);
        LogUtil.m29104i(f40497a, "onBtnClick = " + this.mPopDialogEntity.info.btnUrl);
    }

    public void onImageClick() {
        super.onImageClick();
        if (this.mPopDialogEntity.info != null && TextUtils.isEmpty(this.mPopDialogEntity.info.btnText)) {
            SchemeHelper.dispatchMsg(this.mPopDialogEntity.info.btnUrl);
            ((Contract.AbsPopDialogView) getLogicView()).hidePopDialog(this.mPopDialogEntity);
        }
        LogUtil.m29104i(f40497a, "onImageClick btnUrl = " + this.mPopDialogEntity.info.btnUrl + ",btnText =" + this.mPopDialogEntity.info.btnText);
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        ((Contract.AbsPopDialogView) getLogicView()).updatePopDialog(this.mPopDialogEntity);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }
}
