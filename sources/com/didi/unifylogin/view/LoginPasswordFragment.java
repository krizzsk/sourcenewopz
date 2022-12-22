package com.didi.unifylogin.view;

import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextUtils;
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
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.presenter.LoginPasswordPresenter;
import com.didi.unifylogin.presenter.ability.ILoginPasswordPresenter;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.PasswordUtils;
import com.didi.unifylogin.utils.simplifycode.LoginTextWatcher;
import com.didi.unifylogin.view.ability.ILoginPwdView;
import com.taxis99.R;

public class LoginPasswordFragment extends AbsLoginBaseFragment<ILoginPasswordPresenter> implements ILoginPwdView {
    protected TextView changeWayTv;
    protected Button confirmBtn;
    protected TextView forgetPasswordTv;
    protected EditText inputPasswordEt;
    protected TextView inputPasswordHintTv;
    protected ImageView pwdModeBtn;
    protected boolean showPwd;
    protected TextView tvTitle;

    public void onResume() {
        super.onResume();
        ((ILoginPasswordPresenter) this.presenter).captchaCheck();
    }

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_password, viewGroup, false);
        this.confirmBtn = (Button) inflate.findViewById(R.id.btn_unify_login_confirm_password);
        this.inputPasswordEt = (EditText) inflate.findViewById(R.id.et_unify_login_input_password);
        this.forgetPasswordTv = (TextView) inflate.findViewById(R.id.tv_unify_login_forget_password);
        this.pwdModeBtn = (ImageView) inflate.findViewById(R.id.iv_unify_login_password_mode);
        this.inputPasswordHintTv = (TextView) inflate.findViewById(R.id.tv_input_password_hint);
        this.changeWayTv = (TextView) inflate.findViewById(R.id.tv_unify_login_change_way);
        this.subTitleTv = (TextView) inflate.findViewById(R.id.tv_sub_title);
        this.tvTitle = (TextView) inflate.findViewById(R.id.tv_title);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        if (LoginPreferredConfig.isUnifyPwd()) {
            this.subTitleTv.setVisibility(0);
            this.subTitleTv.setText(R.string.login_unify_input_login_password_subtitle);
        } else {
            this.subTitleTv.setVisibility(4);
        }
        this.inputPasswordEt.setTypeface(Typeface.DEFAULT);
        this.inputPasswordEt.setTransformationMethod(new PasswordTransformationMethod());
        if (LoginPreferredConfig.isSupportJump() && !this.messenger.isNeedBind()) {
            setTitleBarRightVisible(true);
            setTitleBarRightText(getString(R.string.login_unify_jump));
            setTitleBarRightListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    LoginPasswordFragment.this.goJump();
                }
            });
        }
        showKeyBoardDelay(this.inputPasswordEt);
    }

    public void initListener() {
        this.confirmBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                String obj = LoginPasswordFragment.this.inputPasswordEt.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    LoginLog.write(LoginPasswordFragment.this.TAG + " confirmBtn click");
                    new LoginOmegaUtil(LoginOmegaUtil.CONFM_CK).send();
                    ((ILoginPasswordPresenter) LoginPasswordFragment.this.presenter).passwordLogin(obj);
                }
            }
        });
        this.forgetPasswordTv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.PSWDINP_FORGET_CK).send();
                LoginLog.write(LoginPasswordFragment.this.TAG + " forgetPasswordTv click");
                ((ILoginPasswordPresenter) LoginPasswordFragment.this.presenter).forgetPwd();
            }
        });
        this.inputPasswordEt.addTextChangedListener(new LoginTextWatcher() {
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                LoginPasswordFragment.this.pwdModeBtn.setVisibility(TextUtils.isEmpty(obj) ? 8 : 0);
                LoginPasswordFragment.this.confirmBtn.setEnabled(PasswordUtils.isValid(obj));
            }
        });
        this.pwdModeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.PSWDINP_DISPLAY_CK).add(LoginOmegaUtil.ACTIONID, LoginPasswordFragment.this.showPwd ? LoginOmegaUtil.ACTIONID_SW : LoginOmegaUtil.ACTIONID_HIDE).send();
                int selectionEnd = LoginPasswordFragment.this.inputPasswordEt.getSelectionEnd();
                if (LoginPasswordFragment.this.showPwd) {
                    LoginPasswordFragment.this.inputPasswordEt.setTransformationMethod(new PasswordTransformationMethod());
                    LoginPasswordFragment.this.pwdModeBtn.setBackgroundResource(R.drawable.login_unify_img_pwd_hide);
                } else {
                    LoginPasswordFragment.this.inputPasswordEt.setTransformationMethod((TransformationMethod) null);
                    LoginPasswordFragment.this.pwdModeBtn.setBackgroundResource(R.drawable.login_unify_img_pwd_show);
                }
                LoginPasswordFragment.this.inputPasswordEt.setSelection(selectionEnd);
                LoginPasswordFragment loginPasswordFragment = LoginPasswordFragment.this;
                loginPasswordFragment.showPwd = !loginPasswordFragment.showPwd;
            }
        });
        this.inputPasswordEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                LoginPasswordFragment.this.inputPasswordEt.setHint(z ? "" : LoginPasswordFragment.this.getString(R.string.login_unify_input_login_password_tips));
                LoginPasswordFragment.this.inputPasswordHintTv.setVisibility((z || !TextUtils.isEmpty(LoginPasswordFragment.this.inputPasswordEt.getText())) ? 0 : 4);
            }
        });
        this.changeWayTv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ((ILoginPasswordPresenter) LoginPasswordFragment.this.presenter).changeLoginWay();
            }
        });
    }

    public LoginState getNowState() {
        return LoginState.STATE_PASSWORD;
    }

    /* access modifiers changed from: protected */
    public ILoginPasswordPresenter bindPresenter() {
        return new LoginPasswordPresenter(this, this.context);
    }

    public void setPassword(String str) {
        EditText editText = this.inputPasswordEt;
        if (editText != null) {
            editText.setText(str);
        }
    }

    public void setChangeWay(String str) {
        this.changeWayTv.setText(str);
        this.changeWayTv.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
    }
}
