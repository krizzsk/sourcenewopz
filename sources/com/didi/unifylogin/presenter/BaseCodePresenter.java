package com.didi.unifylogin.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.CodeMtParam;
import com.didi.unifylogin.base.net.pojo.response.CodeMtResponse;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.presenter.ability.IVerifyCodePresenter;
import com.didi.unifylogin.utils.LoginChoicePopUtil;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.TimerCount;
import com.didi.unifylogin.view.ability.IVerifyCodeView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseCodePresenter extends LoginBasePresenter<IVerifyCodeView> implements IVerifyCodePresenter, TimerCount.TimerListener {

    /* renamed from: a */
    private static int f44823a = 35;

    /* renamed from: b */
    private static final int f44824b = 60;

    /* renamed from: c */
    private static final long f44825c = 1000;
    protected List<LoginChoicePopUtil.ChoiceItem> choiceItems;

    /* renamed from: d */
    private TimerCount f44826d;

    public void setCell(boolean z, boolean z2) {
    }

    public BaseCodePresenter(IVerifyCodeView iVerifyCodeView, Context context) {
        super(iVerifyCodeView, context);
        if (LoginPreferredConfig.getCodeReducedTime() > 0) {
            f44823a = LoginPreferredConfig.getCodeReducedTime();
        }
    }

    public void notReceiveCode() {
        new LoginOmegaUtil(LoginOmegaUtil.SMS_GETFAIL_CK).send();
        if (getChoices().size() > 1) {
            ((IVerifyCodeView) this.view).showChoicePopupMenu();
        } else {
            handleChoice(0);
        }
    }

    public void retrieveAcc() {
        setScene(LoginScene.SCENE_RETRIEVE);
        updateOmegaScene(LoginScene.SCENE_RETRIEVE);
        transform(LoginState.STATE_CONFIRM_PHONE);
    }

    public String getPhone() {
        return this.messenger.getCell();
    }

    public int getCodeType() {
        return this.messenger.getCodeType();
    }

    public void setCodeType(int i) {
        this.messenger.setCodeType(i);
    }

    public void startCountDown() {
        if (this.f44826d == null) {
            this.f44826d = new TimerCount(60000, 1000, this);
        }
        this.f44826d.start();
    }

    public void requestSms(final int i) {
        ((IVerifyCodeView) this.view).showLoading((String) null);
        CodeMtParam codeType = new CodeMtParam(this.context, this.messenger.getSceneNum()).setCell(getPhone()).setCodeType(i);
        this.messenger.setLastCodeMTTime(SystemClock.uptimeMillis());
        LoginModel.getNet(this.context).codeMt(codeType, new LoginRpcCallbackV2<CodeMtResponse>() {
            public void onSuccess(RpcResponseProxy<CodeMtResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                CodeMtResponse content = rpcResponseProxy.getContent();
                ((IVerifyCodeView) BaseCodePresenter.this.view).hideLoading();
                if (content == null) {
                    ((IVerifyCodeView) BaseCodePresenter.this.view).showError((int) R.string.login_unify_net_error);
                    return;
                }
                int i = content.errno;
                if (i == 0) {
                    BaseCodePresenter.this.setCodeType(content.code_type);
                    BaseCodePresenter.this.messenger.setPrompt(content.prompt);
                    BaseCodePresenter.this.messenger.setVoiceSupport(content.voiceSupport);
                    ((IVerifyCodeView) BaseCodePresenter.this.view).resetCodeStatus();
                    int i2 = content.code_type;
                    if (i2 == 1) {
                        ((IVerifyCodeView) BaseCodePresenter.this.view).voiceDialog();
                    } else if (i2 == 2) {
                        ((IVerifyCodeView) BaseCodePresenter.this.view).showShortCompleted((int) R.string.login_unify_send_email_code_success);
                        LoginOmegaUtil.trackEvent(LoginOmegaUtil.GP_RECEIVE_SUCCESS_VIEW_SW);
                    } else if (i2 != 4) {
                        ((IVerifyCodeView) BaseCodePresenter.this.view).showShortCompleted((int) R.string.login_unify_send_sms_code_success);
                    } else {
                        ((IVerifyCodeView) BaseCodePresenter.this.view).showShortCompleted((int) R.string.login_unify_send_sms_code_success);
                        LoginOmegaUtil.trackEvent(LoginOmegaUtil.GP_RECEIVE_SUCCESS_VIEW_SW);
                    }
                } else if (i != 41002) {
                    ((IVerifyCodeView) BaseCodePresenter.this.view).showError(TextUtils.isEmpty(content.error) ? BaseCodePresenter.this.context.getString(R.string.login_unify_net_error) : content.error);
                } else {
                    BaseCodePresenter.this.messenger.setCodeType(i);
                    BaseCodePresenter.this.messenger.setNextState(((IVerifyCodeView) BaseCodePresenter.this.view).getNowState());
                    BaseCodePresenter.this.messenger.setCaptchaCell(BaseCodePresenter.this.getPhone());
                    BaseCodePresenter.this.messenger.updateOmegaScene(FragmentMessenger.scenesStack.peek());
                    BaseCodePresenter.this.transform(LoginState.STATE_CAPTCHA);
                }
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                ((IVerifyCodeView) BaseCodePresenter.this.view).hideLoading();
                ((IVerifyCodeView) BaseCodePresenter.this.view).showError((int) R.string.login_unify_net_error);
                iOException.printStackTrace();
            }
        });
    }

    public void handleChoice(int i) {
        LoginLog.write("NowState:" + ((IVerifyCodeView) this.view).getNowState() + " popUpMenu item click " + getChoices().get(i).f44924id);
        int i2 = getChoices().get(i).f44924id;
        if (i2 == 1) {
            new LoginOmegaUtil(LoginOmegaUtil.CODEFAIL_BYVCODE_CK).send();
            requestSms(1);
        } else if (i2 == 2) {
            new LoginOmegaUtil(LoginOmegaUtil.CODEFAIL_BYID_CK).send();
            retrieveAcc();
        } else if (i2 == 3) {
            new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_CODEFAIL_BYEMAIL_CK).send();
            verifyEmailCode();
        } else if (i2 == 4) {
            new LoginOmegaUtil(LoginOmegaUtil.CODEFAIL_BYWHATSAPP_CK).send();
            requestSms(4);
        }
    }

    /* access modifiers changed from: protected */
    public void verifyEmailCode() {
        updateOmegaScene(FragmentMessenger.getNowScene());
        transform(LoginState.STATE_EMAIL_CODE);
    }

    public List<LoginChoicePopUtil.ChoiceItem> getChoices() {
        if (this.choiceItems == null) {
            this.choiceItems = new ArrayList();
            if (this.messenger.isVoiceSupport()) {
                this.choiceItems.add(new LoginChoicePopUtil.ChoiceItem(1, this.context.getString(R.string.login_unify_choice_voice)));
            }
            if (!TextUtils.isEmpty(this.messenger.getHideEmail())) {
                this.choiceItems.add(new LoginChoicePopUtil.ChoiceItem(3, this.context.getString(R.string.login_unify_choice_email_code)));
            }
        }
        return this.choiceItems;
    }

    public void onTick(long j) {
        int i = (int) (j / 1000);
        if (i <= f44823a && getCodeType() == 0 && getChoices().size() > 0) {
            ((IVerifyCodeView) this.view).setNotReceiveVisibility(0);
        }
        ((IVerifyCodeView) this.view).setCountDownTime(i);
    }

    public void onFinish() {
        ((IVerifyCodeView) this.view).showRetryGetCode();
    }
}
