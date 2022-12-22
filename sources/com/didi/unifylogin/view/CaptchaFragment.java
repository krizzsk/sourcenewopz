package com.didi.unifylogin.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.request.VerifyCaptchaParam;
import com.didi.unifylogin.base.net.pojo.response.BaseResponse;
import com.didi.unifylogin.base.presenter.ILoginBasePresenter;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.customview.CaptchaImageView;
import com.didi.unifylogin.utils.customview.CodeInputView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;

public class CaptchaFragment extends AbsLoginBaseFragment {
    public static boolean isCaptchaPass = false;
    protected CaptchaImageView captchaImageView;
    protected CodeInputView codeInputView;
    protected LoginState nextState;

    /* access modifiers changed from: protected */
    public ILoginBasePresenter bindPresenter() {
        return new LoginBasePresenter(this, this.context);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nextState = this.messenger.getNextState();
    }

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_captcha, viewGroup, false);
        CodeInputView codeInputView2 = (CodeInputView) inflate.findViewById(R.id.login_unify_captcha_input);
        this.codeInputView = codeInputView2;
        codeInputView2.build();
        CaptchaImageView captchaImageView2 = (CaptchaImageView) inflate.findViewById(R.id.login_unify_captcha_image);
        this.captchaImageView = captchaImageView2;
        captchaImageView2.setPhone(getMessenger().getCaptchaCell());
        isCaptchaPass = false;
        return inflate;
    }

    public void initListener() {
        this.codeInputView.setInputCompleteListener(new CodeInputView.InputCompleteListener() {
            public void onInputComplete(String str) {
                CaptchaFragment.this.showLoading((String) null);
                LoginModel.getNet(CaptchaFragment.this.getActivity()).verifyCaptcha(new VerifyCaptchaParam(CaptchaFragment.this.getActivity(), CaptchaFragment.this.messenger.getSceneNum()).setCell(CaptchaFragment.this.getMessenger().getCaptchaCell()).setCaptcha_code(CaptchaFragment.this.codeInputView.getCode()), new LoginRpcCallbackV2<BaseResponse>() {
                    public void onSuccess(RpcResponseProxy<BaseResponse> rpcResponseProxy) {
                        super.onSuccess(rpcResponseProxy);
                        BaseResponse content = rpcResponseProxy.getContent();
                        if (content == null) {
                            CaptchaFragment.this.showError(CaptchaFragment.this.getString(R.string.login_unify_net_error));
                            return;
                        }
                        int i = content.errno;
                        if (i == 0) {
                            CaptchaFragment.isCaptchaPass = true;
                            CaptchaFragment.this.m32256a();
                        } else if (i != 41008) {
                            CaptchaFragment.this.codeInputView.clearCode();
                            CaptchaFragment.this.hideLoading();
                            CaptchaFragment.this.showError(TextUtil.isEmpty(content.error) ? CaptchaFragment.this.getString(R.string.login_unify_net_error) : content.error);
                        } else {
                            CaptchaFragment.this.codeInputView.clearCode();
                            CaptchaFragment.this.hideLoading();
                            CaptchaFragment.this.captchaImageView.getCaptcha(CaptchaFragment.this.context);
                            CaptchaFragment.this.showError(TextUtil.isEmpty(content.error) ? CaptchaFragment.this.getString(R.string.login_unify_net_error) : content.error);
                        }
                    }

                    public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                        super.onFailure(rpcRequest, iOException);
                        CaptchaFragment.this.hideLoading();
                        CaptchaFragment.this.showError((int) R.string.login_unify_net_error);
                    }
                });
            }
        });
        this.captchaImageView.setRefreshListener(new CaptchaImageView.OnRefreshListener() {
            public void onRefresh() {
                CaptchaFragment.this.codeInputView.clearCode();
            }
        });
        this.captchaImageView.getCaptcha(this.context);
    }

    public LoginState getNowState() {
        return LoginState.STATE_CAPTCHA;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32256a() {
        LoginLog.write(this.TAG + " goNextPage nextState:" + this.messenger.getNextState());
        this.messenger.setNextState((LoginState) null);
        if (this.nextState != null) {
            hideLoading();
            this.presenter.updateOmegaScene(FragmentMessenger.getNowScene());
            this.presenter.transform(this.nextState);
            return;
        }
        hideLoading();
        goBack();
        LoginLog.write(this.TAG + " goBack");
    }
}
