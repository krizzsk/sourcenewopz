package com.didi.unifylogin.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.request.SetEmailParam;
import com.didi.unifylogin.base.net.pojo.response.SetEmailResponse;
import com.didi.unifylogin.base.presenter.LoginBaseFillerPresenter;
import com.didi.unifylogin.presenter.ability.IInputInfoPresenter;
import com.didi.unifylogin.spi.CPFVerifySerialInterface;
import com.didi.unifylogin.spi.CPFVerifyService;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.view.ability.IInputInfoView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;

public class InputInfoPresenter extends LoginBaseFillerPresenter<IInputInfoView> implements IInputInfoPresenter {
    public InputInfoPresenter(IInputInfoView iInputInfoView, Context context) {
        super(iInputInfoView, context);
    }

    public void fillInInfo() {
        ((IInputInfoView) this.view).showLoading((String) null);
        LoginModel.getNet(this.context).setEmail(new SetEmailParam(this.context, getSceneNum()).setTicket(LoginStore.getInstance().getTemporaryToken()).setFirstName(((IInputInfoView) this.view).getFirstName()).setLastName(((IInputInfoView) this.view).getLastName()).setNewEmail(((IInputInfoView) this.view).getEmail()).setPromoCode(((IInputInfoView) this.view).getPromoCode()), new LoginRpcCallbackV2<SetEmailResponse>() {
            public void onSuccess(RpcResponseProxy<SetEmailResponse> rpcResponseProxy) {
                String str;
                String str2;
                super.onSuccess(rpcResponseProxy);
                SetEmailResponse content = rpcResponseProxy.getContent();
                int i = content.errno;
                if (i == 0) {
                    LoginStore.getInstance().setAndSaveHideEmail(content.email);
                    LoginStore.getInstance().setFinishInputInfo(true);
                    LoginLog.write("InputInfoPresenter: finish");
                    if (!CPFVerifyService.cpfTestVerify(InputInfoPresenter.this.context, new CPFVerifySerialInterface.TestCallback() {
                        public void onSuccess() {
                            if (InputInfoPresenter.this.m31959a() == null) {
                                InputInfoPresenter.this.goFillNextInfo();
                            } else {
                                CPFVerifyService.cpfJumpTo((Activity) null, InputInfoPresenter.this.m31959a(), (CPFVerifySerialInterface.CpfCallback) null);
                            }
                        }

                        public void onFailed() {
                            InputInfoPresenter.this.goFillNextInfo();
                        }
                    })) {
                        InputInfoPresenter.this.goFillNextInfo();
                    }
                } else if (i != 41029) {
                    ((IInputInfoView) InputInfoPresenter.this.view).hideLoading();
                    if (content.errno == 51002) {
                        new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_EMAIL_REG).send();
                    }
                    IInputInfoView iInputInfoView = (IInputInfoView) InputInfoPresenter.this.view;
                    if (!TextUtils.isEmpty(content.error)) {
                        str2 = content.error;
                    } else {
                        str2 = InputInfoPresenter.this.context.getResources().getString(R.string.login_unify_net_error);
                    }
                    iInputInfoView.showError(str2);
                } else {
                    LoginStore.getInstance().setAndSaveHideEmail(content.email);
                    ((IInputInfoView) InputInfoPresenter.this.view).hideLoading();
                    if (content.promoConfig != null) {
                        ((IInputInfoView) InputInfoPresenter.this.view).showPromoDialog(content.promoConfig);
                        return;
                    }
                    IInputInfoView iInputInfoView2 = (IInputInfoView) InputInfoPresenter.this.view;
                    if (!TextUtils.isEmpty(content.error)) {
                        str = content.error;
                    } else {
                        str = InputInfoPresenter.this.context.getResources().getString(R.string.login_unify_net_error);
                    }
                    iInputInfoView2.showError(str);
                }
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                ((IInputInfoView) InputInfoPresenter.this.view).hideLoading();
                ((IInputInfoView) InputInfoPresenter.this.view).showError(InputInfoPresenter.this.context.getResources().getString(R.string.login_unify_net_error));
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 35) {
            goFillNextInfo();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Fragment m31959a() {
        if (this.view instanceof Fragment) {
            return (Fragment) this.view;
        }
        return null;
    }
}
