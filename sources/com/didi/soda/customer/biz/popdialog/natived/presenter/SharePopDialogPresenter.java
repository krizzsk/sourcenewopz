package com.didi.soda.customer.biz.popdialog.natived.presenter;

import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.soda.customer.biz.popdialog.natived.Contract;
import com.didi.soda.customer.foundation.rpc.entity.NAPopDialogEntity;
import com.didi.soda.customer.foundation.share.ShareHelper;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;

public class SharePopDialogPresenter extends Contract.AbsPopDialogPresenter {

    /* renamed from: a */
    private static final String f40503a = "SharePopDialogPresenter";

    public SharePopDialogPresenter(NAPopDialogEntity nAPopDialogEntity) {
        super(nAPopDialogEntity);
    }

    public void onBtnClick() {
        super.onBtnClick();
        ShareHelper.getInstance().showSharePlatform(getContext(), ShareHelper.getInstance().convertShareToolModel(this.mPopDialogEntity.info.buttons), (ICallback.IPlatformClickCallback) new ICallback.IPlatformClickCallback() {
            public final void onClickPlatform(OneKeyShareInfo oneKeyShareInfo) {
                SharePopDialogPresenter.this.m28738a(oneKeyShareInfo);
            }
        });
        ((Contract.AbsPopDialogView) getLogicView()).hidePopDialog(this.mPopDialogEntity);
        OmegaTracker.Builder.create(EventConst.ShareDialog.SAILING_C_X_SHARE_COMMON_SW).addEventParam(ParamConst.PARAM_SHARE_TEST_GROUP, (this.mPopDialogEntity == null || this.mPopDialogEntity.info == null) ? "" : this.mPopDialogEntity.info.treatmentGroup).build().track();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28738a(OneKeyShareInfo oneKeyShareInfo) {
        OmegaTracker.Builder.create(EventConst.ShareDialog.SAILING_C_X_SHARE_IMAGE_CK).addEventParam(ParamConst.PARAM_SHARE_CHANNEL, oneKeyShareInfo.platform.platformName().toLowerCase()).addEventParam(ParamConst.PARAM_SHARE_TEST_GROUP, (this.mPopDialogEntity == null || this.mPopDialogEntity.info == null) ? "" : this.mPopDialogEntity.info.treatmentGroup).build().track();
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        ((Contract.AbsPopDialogView) getLogicView()).updatePopDialog(this.mPopDialogEntity);
    }
}
