package com.didi.unifylogin.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.text.BidiFormatter;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.presenter.CancelCodePresenter;
import com.didi.unifylogin.presenter.ChangePhoneWithVerifyCodePresenter;
import com.didi.unifylogin.presenter.DeleteAccountCodePresenter;
import com.didi.unifylogin.presenter.ForgetPwdCodePresenter;
import com.didi.unifylogin.presenter.LoginCodePresenter;
import com.didi.unifylogin.presenter.LoginFaceCodePresenter;
import com.didi.unifylogin.presenter.SetEmailCodePresenter;
import com.didi.unifylogin.presenter.SetPhoneCodePresenter;
import com.didi.unifylogin.presenter.ability.IVerifyCodePresenter;
import com.didi.unifylogin.utils.LoginChoicePopUtil;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.SmsUtils;
import com.didi.unifylogin.utils.autologin.SmsReceiver;
import com.didi.unifylogin.utils.customview.CodeInputView;
import com.didi.unifylogin.utils.phone.PhoneUtils;
import com.didi.unifylogin.view.ability.IVerifyCodeView;
import com.taxis99.R;

public class VerifyCodeFragment extends AbsLoginBaseFragment<IVerifyCodePresenter> implements IVerifyCodeView {
    protected static final int DEFAULT_CODE_LENGTH = 6;
    protected static final int OLD_RUSSIA_ID = 7;
    protected static final int RUSSIA_ID = 643;

    /* renamed from: a */
    private static final String f45067a = "{{digit}}";

    /* renamed from: b */
    private SmsUtils f45068b;
    protected CodeInputView codeInputView;
    protected TextView codeLenTv;
    protected TextView countDownTimeTv;
    protected int countryId = 0;
    protected int curCodeLength;
    protected TextView notReceiveCodeTv;
    protected View notReceiveCodeView;
    protected TextView phoneOrEmailTv;
    protected Button retryCodeBtn;

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_code, viewGroup, false);
        this.phoneOrEmailTv = (TextView) inflate.findViewById(R.id.tv_phone);
        this.codeInputView = (CodeInputView) inflate.findViewById(R.id.login_unify_code_input);
        int codeLength = this.messenger.getCodeLength() == 0 ? 6 : this.messenger.getCodeLength();
        this.curCodeLength = codeLength;
        this.codeInputView.setCodeLength(codeLength).build();
        this.retryCodeBtn = (Button) inflate.findViewById(R.id.btn_retry_again);
        this.notReceiveCodeTv = (TextView) inflate.findViewById(R.id.tv_other_way);
        this.notReceiveCodeView = inflate.findViewById(R.id.v_unify_login_not_receive_code);
        this.titleTv = (TextView) inflate.findViewById(R.id.tv_title);
        this.subTitleTv = (TextView) inflate.findViewById(R.id.tv_sub_title);
        this.countDownTimeTv = (TextView) inflate.findViewById(R.id.txt_count_down_time);
        this.codeLenTv = (TextView) inflate.findViewById(R.id.login_unify_num_bits_tips);
        String string = this.context.getResources().getString(R.string.login_unify_verify_code_hint);
        TextView textView = this.codeLenTv;
        textView.setText(string.replace(f45067a, this.curCodeLength + ""));
        String string2 = this.context.getResources().getString(R.string.login_unify_verify_code_send_to_phone);
        this.subTitleTv.setText(string2.replace(f45067a, this.curCodeLength + ""));
        SmsUtils smsUtils = new SmsUtils();
        this.f45068b = smsUtils;
        smsUtils.registeSmsRetriever(getBaseActivity(), new SmsReceiver.SmsReceiverListener() {
            public void handleSmsCode(String str) {
                LoginLog.write("SmsRetriever get code:" + str);
                VerifyCodeFragment.this.codeInputView.setCode(str);
            }
        });
        return inflate;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onResume() {
        super.onResume();
        voiceDialog();
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        this.phoneOrEmailTv.setText(BidiFormatter.getInstance().unicodeWrap(CountryManager.getIns().getCurrentCountryCode() + " " + PhoneUtils.toSpecialPhone(((IVerifyCodePresenter) this.presenter).getPhone())));
        this.notReceiveCodeTv.setText(getString(R.string.login_unify_not_receive_code));
        ((IVerifyCodePresenter) this.presenter).startCountDown();
    }

    public void initListener() {
        this.codeInputView.setInputCompleteListener(new CodeInputView.InputCompleteListener() {
            public void onInputComplete(String str) {
                VerifyCodeFragment.this.messenger.setScene(VerifyCodeFragment.this.preScene);
                ((IVerifyCodePresenter) VerifyCodeFragment.this.presenter).nextOperate();
                LoginLog.write(VerifyCodeFragment.this.TAG + " codeInputView onInputComplete, presenter nextOperate");
            }
        });
        this.retryCodeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ((IVerifyCodePresenter) VerifyCodeFragment.this.presenter).requestSms(((IVerifyCodePresenter) VerifyCodeFragment.this.presenter).getCodeType());
                VerifyCodeFragment.this.codeInputView.clearCode();
                LoginLog.write(VerifyCodeFragment.this.TAG + " retryCodeBtn click, requestSms 0");
                new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_SMS_ANRECEIVE_CK).add("ctype", "re").send();
            }
        });
        this.notReceiveCodeView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ((IVerifyCodePresenter) VerifyCodeFragment.this.presenter).notReceiveCode();
                VerifyCodeFragment.this.codeInputView.clearCode();
                LoginLog.write(VerifyCodeFragment.this.TAG + " onClickNotReceiveCode");
                new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_SMS_ANRECEIVE_CK).add("ctype", "unreceive").send();
            }
        });
    }

    public LoginState getNowState() {
        return LoginState.STATE_CODE;
    }

    /* access modifiers changed from: protected */
    public IVerifyCodePresenter bindPresenter() {
        if (this.preScene == null) {
            return new LoginCodePresenter(this, this.context);
        }
        LoginLog.write(this.TAG + " preScene: " + this.preScene.getSceneNum());
        switch (C147539.$SwitchMap$com$didi$unifylogin$base$net$LoginScene[this.preScene.ordinal()]) {
            case 1:
                return new SetPhoneCodePresenter(this, this.context);
            case 2:
                return new ForgetPwdCodePresenter(this, this.context);
            case 3:
                return new CancelCodePresenter(this, this.context);
            case 4:
                return new DeleteAccountCodePresenter(this, this.context);
            case 5:
                return new SetEmailCodePresenter(this, this.context);
            case 6:
                return new ChangePhoneWithVerifyCodePresenter(this, this.context);
            case 7:
                return new LoginFaceCodePresenter(this, this.context);
            default:
                return new LoginCodePresenter(this, this.context);
        }
    }

    /* renamed from: com.didi.unifylogin.view.VerifyCodeFragment$9 */
    static /* synthetic */ class C147539 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$unifylogin$base$net$LoginScene;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.unifylogin.base.net.LoginScene[] r0 = com.didi.unifylogin.base.net.LoginScene.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$unifylogin$base$net$LoginScene = r0
                com.didi.unifylogin.base.net.LoginScene r1 = com.didi.unifylogin.base.net.LoginScene.SCENE_SET_PHONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$unifylogin$base$net$LoginScene     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.unifylogin.base.net.LoginScene r1 = com.didi.unifylogin.base.net.LoginScene.SCENE_FORGETPWD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$unifylogin$base$net$LoginScene     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.unifylogin.base.net.LoginScene r1 = com.didi.unifylogin.base.net.LoginScene.SCENE_CANCEL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$unifylogin$base$net$LoginScene     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.unifylogin.base.net.LoginScene r1 = com.didi.unifylogin.base.net.LoginScene.SCENE_DELETE_ACCOUNT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$unifylogin$base$net$LoginScene     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.unifylogin.base.net.LoginScene r1 = com.didi.unifylogin.base.net.LoginScene.SCENE_RESET_EMAIL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$didi$unifylogin$base$net$LoginScene     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.unifylogin.base.net.LoginScene r1 = com.didi.unifylogin.base.net.LoginScene.SCENE_CHANGE_PHONE_WITH_CODE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$didi$unifylogin$base$net$LoginScene     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.unifylogin.base.net.LoginScene r1 = com.didi.unifylogin.base.net.LoginScene.SCENE_FACE_LOGIN     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.unifylogin.view.VerifyCodeFragment.C147539.<clinit>():void");
        }
    }

    public void voiceDialog() {
        if (!TextUtil.isEmpty(this.messenger.getPrompt())) {
            LoginLog.write(this.TAG + " show voiceDialog");
            showInfoDialog((String) null, this.messenger.getPrompt(), getString(R.string.login_unify_str_know_btn), new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    VerifyCodeFragment verifyCodeFragment = VerifyCodeFragment.this;
                    verifyCodeFragment.showKeyBoardDelay(verifyCodeFragment.codeInputView.getCodeView(0));
                }
            });
            this.messenger.setPrompt((String) null);
            new LoginOmegaUtil(LoginOmegaUtil.VCODE_VOICE_SW).send();
            LoginOmegaUtil.trackEvent(LoginOmegaUtil.GP_RECEIVE_SUCCESS_VIEW_SW);
            return;
        }
        showKeyBoardDelay(this.codeInputView.getCodeView(0));
    }

    public void cleanCode() {
        CodeInputView codeInputView2 = this.codeInputView;
        if (codeInputView2 != null) {
            codeInputView2.clearCode();
        }
    }

    public String getCode() {
        return this.codeInputView.getCode();
    }

    public void showChoicePopupMenu() {
        LoginChoicePopUtil.showPopMenu(this.baseActivity, ((IVerifyCodePresenter) this.presenter).getChoices(), new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
                ((IVerifyCodePresenter) VerifyCodeFragment.this.presenter).handleChoice(i);
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.CODEFAIL_CANCEL_CK).send();
            }
        });
        new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_CODEFAIL_CHOICE_SW).send();
    }

    public void setNotReceiveVisibility(int i) {
        if (this.notReceiveCodeView.getVisibility() != i) {
            LoginLog.write(this.TAG + " setNotReceiveVisibility : " + i);
            this.notReceiveCodeView.setVisibility(i);
            if (i == 0) {
                new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_SMS_ANRECEIVE_SW).send();
            }
        }
    }

    public void showRetryGetCode() {
        if (isViewAlive()) {
            this.retryCodeBtn.setVisibility(0);
            this.countDownTimeTv.setVisibility(4);
        }
    }

    public void setCountDownTime(int i) {
        if (isViewAlive()) {
            TextView textView = this.countDownTimeTv;
            String string = getResources().getString(R.string.login_unify_count_down_time);
            textView.setText(String.format(string, new Object[]{i + ""}));
        }
    }

    public void resetCodeStatus() {
        LoginLog.write(this.TAG + " resetCodeStatus");
        this.notReceiveCodeView.setVisibility(4);
        this.retryCodeBtn.setVisibility(4);
        this.countDownTimeTv.setVisibility(0);
        ((IVerifyCodePresenter) this.presenter).startCountDown();
    }

    public void showIdentityAuthPromptInfo() {
        showInfoDialog(this.context.getString(R.string.login_unify_verify_dialog_identity_auth_title), (String) null, this.context.getString(R.string.login_unify_verify_dialog_identity_auth_button), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ((IVerifyCodePresenter) VerifyCodeFragment.this.presenter).transform(LoginState.STATE_CERTIFICATION);
                ((IVerifyCodePresenter) VerifyCodeFragment.this.presenter).updateOmegaScene(FragmentMessenger.getNowScene());
            }
        });
    }

    public void onDestroyView() {
        super.onDestroyView();
        SmsUtils smsUtils = this.f45068b;
        if (smsUtils != null) {
            smsUtils.unRegisteSmsRetriever(getBaseActivity());
            this.f45068b = null;
        }
    }
}
