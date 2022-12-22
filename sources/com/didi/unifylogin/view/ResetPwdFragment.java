package com.didi.unifylogin.view;

import android.graphics.Typeface;
import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.api.LoginTextAdapter;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.presenter.ResetPwdPresenter;
import com.didi.unifylogin.presenter.ability.IResetPasswordPresenter;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.PasswordUtils;
import com.didi.unifylogin.utils.simplifycode.LoginTextWatcher;
import com.didi.unifylogin.view.ability.IRestPwdView;
import com.taxis99.R;

public class ResetPwdFragment extends AbsLoginBaseFragment<IResetPasswordPresenter> implements IRestPwdView {
    protected TextView forgetPwdTv;
    protected boolean isShowNewPwd = false;
    protected boolean isShowOldPwd = false;
    protected EditText newPwdEt;
    protected TextView newPwdHintTv;
    protected ImageView newPwdModeBtn;
    protected Button nextBtn;
    protected EditText oldPwdEt;
    protected TextView oldPwdHintTv;
    protected ImageView oldPwdModeBtn;

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_verify_old_pwd, viewGroup, false);
        this.titleTv = (TextView) inflate.findViewById(R.id.tv_title);
        this.subTitleTv = (TextView) inflate.findViewById(R.id.tv_sub_title);
        this.nextBtn = (Button) inflate.findViewById(R.id.btn_next);
        this.forgetPwdTv = (TextView) inflate.findViewById(R.id.tv_forget_password);
        this.oldPwdEt = (EditText) inflate.findViewById(R.id.et_old_pwd);
        this.newPwdEt = (EditText) inflate.findViewById(R.id.et_new_pwd);
        this.oldPwdEt.setTypeface(Typeface.DEFAULT);
        this.newPwdEt.setTypeface(Typeface.DEFAULT);
        this.oldPwdHintTv = (TextView) inflate.findViewById(R.id.tv_verify_old_password_hint);
        this.newPwdHintTv = (TextView) inflate.findViewById(R.id.tv_verify_new_password_hint);
        this.oldPwdModeBtn = (ImageView) inflate.findViewById(R.id.iv_old_pwd_mode);
        this.newPwdModeBtn = (ImageView) inflate.findViewById(R.id.iv_new_pwd_mode);
        this.oldPwdEt.setTransformationMethod((TransformationMethod) null);
        this.newPwdEt.setTransformationMethod((TransformationMethod) null);
        setSubTitle(getString(LoginPreferredConfig.isUseWeakPwd() ? R.string.login_unify_please_input_ur_weak_old_password : R.string.login_unify_please_input_ur_old_password));
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32348a() {
        if (!m32349a(getNewPwd())) {
            new LoginOmegaUtil(LoginOmegaUtil.PSWDCHGE_NEW_MISMATCH_SW).send();
            return;
        }
        this.messenger.setScene(LoginScene.SCENE_RESET_PWD);
        this.messenger.updateOmegaScene(LoginScene.SCENE_RESET_PWD);
        LoginTextAdapter.DialogText resPwdWarnDialog = LoginPreferredConfig.getTextAdapter(this.messenger).getResPwdWarnDialog(this.context);
        if (resPwdWarnDialog != null) {
            showInfoDialog(resPwdWarnDialog.title, resPwdWarnDialog.msg, resPwdWarnDialog.positiveBtnTxt, resPwdWarnDialog.negativeBtnTxt, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    ((IResetPasswordPresenter) ResetPwdFragment.this.presenter).resetPassword();
                }
            }, (View.OnClickListener) null);
            return;
        }
        ((IResetPasswordPresenter) this.presenter).resetPassword();
    }

    public void initListener() {
        this.nextBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.CONFM_CK).send();
                ResetPwdFragment.this.m32348a();
            }
        });
        this.forgetPwdTv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                LoginLog.write(ResetPwdFragment.this.TAG + " forgetPwdTv click");
                ResetPwdFragment.this.m32350b();
            }
        });
        this.oldPwdEt.addTextChangedListener(new OldPasswordTextWatcher());
        this.oldPwdModeBtn.setOnClickListener(new OldPasswordModeListener());
        this.newPwdModeBtn.setOnClickListener(new NewPasswordModeListener());
        this.newPwdEt.addTextChangedListener(new NewPasswordTextWatcher());
    }

    public LoginState getNowState() {
        return LoginState.STATE_VERIFY_OLD_PWD;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m32350b() {
        new LoginOmegaUtil(LoginOmegaUtil.PSWDCHGE_FORGET_CK).send();
        this.messenger.setScene(LoginScene.SCENE_FORGETPWD);
        this.messenger.updateOmegaScene(LoginScene.SCENE_FORGETPWD);
        ((IResetPasswordPresenter) this.presenter).transform(LoginState.STATE_CODE);
        this.oldPwdEt.setText("");
        this.newPwdEt.setText("");
    }

    /* renamed from: a */
    private boolean m32349a(String str) {
        if (!PasswordUtils.isValid(str, LoginPreferredConfig.isUseWeakPwd())) {
            showError(getString(R.string.login_unify_verify_old_password_err_tips_1, Integer.valueOf(PasswordUtils.getMinDigit())));
            return false;
        } else if (PasswordUtils.chackPasswordMix(str)) {
            return true;
        } else {
            showError((int) R.string.login_unify_verify_old_password_err_tips_2);
            return false;
        }
    }

    public String getOldPwd() {
        EditText editText = this.oldPwdEt;
        if (editText != null) {
            return editText.getText().toString();
        }
        return null;
    }

    public String getNewPwd() {
        EditText editText = this.newPwdEt;
        if (editText != null) {
            return editText.getText().toString();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public IResetPasswordPresenter bindPresenter() {
        return new ResetPwdPresenter(this, this.context);
    }

    class OldPasswordTextWatcher extends LoginTextWatcher {
        OldPasswordTextWatcher() {
        }

        public void afterTextChanged(Editable editable) {
            boolean z = false;
            if (TextUtil.isEmpty(editable.toString())) {
                ResetPwdFragment.this.oldPwdModeBtn.setVisibility(8);
                ResetPwdFragment.this.oldPwdHintTv.setVisibility(4);
            } else {
                ResetPwdFragment.this.oldPwdModeBtn.setVisibility(0);
                ResetPwdFragment.this.oldPwdHintTv.setVisibility(0);
            }
            Button button = ResetPwdFragment.this.nextBtn;
            if (!TextUtil.isEmpty(ResetPwdFragment.this.getOldPwd()) && !TextUtil.isEmpty(ResetPwdFragment.this.getNewPwd())) {
                z = true;
            }
            button.setEnabled(z);
        }
    }

    class NewPasswordTextWatcher extends LoginTextWatcher {
        NewPasswordTextWatcher() {
        }

        public void afterTextChanged(Editable editable) {
            boolean z = false;
            if (TextUtil.isEmpty(editable.toString())) {
                ResetPwdFragment.this.newPwdModeBtn.setVisibility(8);
                ResetPwdFragment.this.newPwdHintTv.setVisibility(4);
            } else {
                ResetPwdFragment.this.newPwdModeBtn.setVisibility(0);
                ResetPwdFragment.this.newPwdHintTv.setVisibility(0);
            }
            Button button = ResetPwdFragment.this.nextBtn;
            if (!TextUtil.isEmpty(ResetPwdFragment.this.getOldPwd()) && !TextUtil.isEmpty(ResetPwdFragment.this.getNewPwd())) {
                z = true;
            }
            button.setEnabled(z);
        }
    }

    class OldPasswordModeListener implements View.OnClickListener {
        OldPasswordModeListener() {
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            new LoginOmegaUtil(LoginOmegaUtil.PSWDCHGE_OLD_DISPLAY_CK).add(LoginOmegaUtil.ACTIONID, ResetPwdFragment.this.isShowOldPwd ? LoginOmegaUtil.ACTIONID_SW : LoginOmegaUtil.ACTIONID_HIDE).send();
            if (ResetPwdFragment.this.isShowOldPwd) {
                int selectionEnd = ResetPwdFragment.this.oldPwdEt.getSelectionEnd();
                ResetPwdFragment.this.oldPwdEt.setTransformationMethod(new PasswordTransformationMethod());
                ResetPwdFragment.this.oldPwdEt.setSelection(selectionEnd);
                ResetPwdFragment.this.oldPwdModeBtn.setBackgroundResource(R.drawable.login_unify_img_pwd_hide);
                ResetPwdFragment.this.isShowOldPwd = false;
                return;
            }
            int selectionEnd2 = ResetPwdFragment.this.oldPwdEt.getSelectionEnd();
            ResetPwdFragment.this.oldPwdEt.setTransformationMethod((TransformationMethod) null);
            ResetPwdFragment.this.oldPwdEt.setSelection(selectionEnd2);
            ResetPwdFragment.this.oldPwdModeBtn.setBackgroundResource(R.drawable.login_unify_img_pwd_show);
            ResetPwdFragment.this.isShowOldPwd = true;
        }
    }

    class NewPasswordModeListener implements View.OnClickListener {
        NewPasswordModeListener() {
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            new LoginOmegaUtil(LoginOmegaUtil.PSWDCHGE_NEW_DISPLAY_CK).add(LoginOmegaUtil.ACTIONID, ResetPwdFragment.this.isShowNewPwd ? LoginOmegaUtil.ACTIONID_SW : LoginOmegaUtil.ACTIONID_HIDE).send();
            if (ResetPwdFragment.this.isShowNewPwd) {
                int selectionEnd = ResetPwdFragment.this.newPwdEt.getSelectionEnd();
                ResetPwdFragment.this.newPwdEt.setTransformationMethod(new PasswordTransformationMethod());
                ResetPwdFragment.this.newPwdEt.setSelection(selectionEnd);
                ResetPwdFragment.this.newPwdModeBtn.setBackgroundResource(R.drawable.login_unify_img_pwd_hide);
                ResetPwdFragment.this.isShowNewPwd = false;
                return;
            }
            int selectionEnd2 = ResetPwdFragment.this.newPwdEt.getSelectionEnd();
            ResetPwdFragment.this.newPwdEt.setTransformationMethod((TransformationMethod) null);
            ResetPwdFragment.this.newPwdEt.setSelection(selectionEnd2);
            ResetPwdFragment.this.newPwdModeBtn.setBackgroundResource(R.drawable.login_unify_img_pwd_show);
            ResetPwdFragment.this.isShowNewPwd = true;
        }
    }
}
