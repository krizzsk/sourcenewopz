package com.didi.unifylogin.presenter;

import android.content.Context;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.ChangeCellByIdCardParam;
import com.didi.unifylogin.base.net.pojo.response.ChangeCellResponse;
import com.didi.unifylogin.utils.OmegaUtils;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didi.unifylogin.view.ability.IVerifyCodeView;
import com.didichuxing.foundation.rpc.RpcRequest;

public class VerifyNewCodeInChangePhoneByIDPresenter extends BaseCodePresenter {
    public VerifyNewCodeInChangePhoneByIDPresenter(IVerifyCodeView iVerifyCodeView, Context context) {
        super(iVerifyCodeView, context);
    }

    public void nextOperate() {
        ((IVerifyCodeView) this.view).showLoading((String) null);
        ChangeCellByIdCardParam changeCellByIdCardParam = new ChangeCellByIdCardParam(((IVerifyCodeView) this.view).getBaseActivity(), LoginScene.SCENE_CHANGE_PHONE_WITH_CODE.getSceneNum());
        changeCellByIdCardParam.setCodeType(this.messenger.getCodeType());
        changeCellByIdCardParam.setSessionId(this.messenger.getSessionId());
        changeCellByIdCardParam.setNewCell(this.messenger.getNewCell());
        changeCellByIdCardParam.setNewCode(((IVerifyCodeView) this.view).getCode());
        changeCellByIdCardParam.setIdNum(this.messenger.getIdNum());
        LoginModel.getNet(this.context).changeCellByIdCard(changeCellByIdCardParam, new LoginServiceCallbackV2<ChangeCellResponse>(this.view) {
            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
            }

            /* access modifiers changed from: protected */
            public boolean handleResponse(ChangeCellResponse changeCellResponse, int i, String str) {
                ((IVerifyCodeView) VerifyNewCodeInChangePhoneByIDPresenter.this.view).hideLoading();
                if (changeCellResponse.errno != 0) {
                    ((IVerifyCodeView) VerifyNewCodeInChangePhoneByIDPresenter.this.view).cleanCode();
                    OmegaUtils.ibt_gd_brchangephone_verify_status_popup_sw(1);
                    return false;
                }
                ((IVerifyCodeView) VerifyNewCodeInChangePhoneByIDPresenter.this.view).onFlowFinish(-1);
                OmegaUtils.ibt_gd_brchangephone_verify_status_popup_sw(0);
                return true;
            }
        });
    }
}
