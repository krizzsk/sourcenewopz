package com.didi.unifylogin.presenter;

import android.content.Context;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.pojo.request.SignInByFaceParam;
import com.didi.unifylogin.base.net.pojo.response.SignInByFaceResponse;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.listener.pojo.FaceParam;
import com.didi.unifylogin.presenter.ability.IPreFacePresenter;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didi.unifylogin.view.ability.IPreFaceView;
import com.didichuxing.foundation.rpc.RpcRequest;

public class PreFacePresenter extends LoginBasePresenter<IPreFaceView> implements IPreFacePresenter {
    public PreFacePresenter(IPreFaceView iPreFaceView, Context context) {
        super(iPreFaceView, context);
    }

    public void verifyFace() {
        SignInByFaceParam cell = new SignInByFaceParam(this.context, getSceneNum()).setSessionId(this.messenger.getSessionId()).setCell(this.messenger.getCell());
        ((IPreFaceView) this.view).showLoading((String) null);
        LoginModel.getNet(this.context).signInByFace(cell, new LoginServiceCallbackV2<SignInByFaceResponse>(this.view) {
            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
            }

            /* access modifiers changed from: protected */
            public boolean handleResponse(SignInByFaceResponse signInByFaceResponse, int i, String str) {
                LoginOmegaUtil.trackEvent(LoginOmegaUtil.TONE_P_X_LOGIN_FACE_FAILTOAST);
                int i2 = signInByFaceResponse.errno;
                if (i2 == 0) {
                    PreFacePresenter.this.handToken(signInByFaceResponse);
                    return true;
                } else if (i2 == 41000) {
                    PreFacePresenter.this.updateOmegaScene(FragmentMessenger.getNowScene());
                    PreFacePresenter.this.transform(LoginState.STATE_CODE);
                    return true;
                } else if (i2 != 41030) {
                    return false;
                } else {
                    PreFacePresenter.this.m32077a(signInByFaceResponse);
                    return true;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32077a(SignInByFaceResponse signInByFaceResponse) {
        this.messenger.setSessionId(signInByFaceResponse.sessionId);
        FaceParam faceParam = new FaceParam();
        faceParam.setAccessToken(signInByFaceResponse.accessToken);
        faceParam.setSessionId(signInByFaceResponse.sessionId);
        ListenerManager.getFaceListener().callFaceListener(faceParam, new LoginListeners.FaceCallback() {
            public void onResult(int i) {
                if (i < 0 || i >= 10) {
                    LoginOmegaUtil.trackEvent(LoginOmegaUtil.TONE_P_X_LOGIN_FACE_FAILTOAST);
                } else {
                    PreFacePresenter.this.verifyFace();
                }
            }
        });
    }
}
