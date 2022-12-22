package com.didi.unifylogin.presenter;

import android.content.Context;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginNetErrNo;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.ChangeCellByIdCardParam;
import com.didi.unifylogin.base.net.pojo.response.ChangeCellResponse;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.presenter.ability.IInputNewPhonePresenter;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.phone.PhoneUtils;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didi.unifylogin.view.ability.IInputNewPhoneView;
import com.didichuxing.foundation.rpc.RpcRequest;

public class InputNewPhoneByIDPresenter extends LoginBasePresenter<IInputNewPhoneView> implements IInputNewPhonePresenter {
    public InputNewPhoneByIDPresenter(IInputNewPhoneView iInputNewPhoneView, Context context) {
        super(iInputNewPhoneView, context);
    }

    public void verifyPhone() {
        ((IInputNewPhoneView) this.view).showLoading((String) null);
        ChangeCellByIdCardParam changeCellByIdCardParam = new ChangeCellByIdCardParam(this.context, LoginScene.SCENE_CHANGE_PHONE_WITH_CODE.getSceneNum());
        changeCellByIdCardParam.setIdNum(getMessenger().getIdNum());
        changeCellByIdCardParam.setSessionId(getMessenger().getSessionId());
        String normalPhone = PhoneUtils.toNormalPhone(((IInputNewPhoneView) this.view).getPhone());
        changeCellByIdCardParam.setNewCell(normalPhone);
        getMessenger().setNewCell(normalPhone);
        LoginModel.getNet(this.context).changeCellByIdCard(changeCellByIdCardParam, new LoginServiceCallbackV2<ChangeCellResponse>(this.view) {
            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
            }

            /* access modifiers changed from: protected */
            public boolean handleResponse(ChangeCellResponse changeCellResponse, int i, String str) {
                ((IInputNewPhoneView) InputNewPhoneByIDPresenter.this.view).hideLoading();
                switch (changeCellResponse.errno) {
                    case 41018:
                        InputNewPhoneByIDPresenter.this.messenger.setPromptPageData(changeCellResponse.prompt);
                        InputNewPhoneByIDPresenter.this.updateOmegaScene(FragmentMessenger.getNowScene());
                        InputNewPhoneByIDPresenter.this.transform(LoginState.STATE_CONFIRM_SNATCH);
                        return true;
                    case LoginNetErrNo.ERR_NEED_NEW_CODE:
                        InputNewPhoneByIDPresenter.this.transform(LoginState.STATE_NEW_CODE);
                        return true;
                    case 41023:
                        InputNewPhoneByIDPresenter.this.messenger.setPromptPageData(changeCellResponse.prompt);
                        InputNewPhoneByIDPresenter.this.updateOmegaScene(FragmentMessenger.getNowScene());
                        InputNewPhoneByIDPresenter.this.transform(LoginState.STATE_SETCELL_ERROR);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
}
