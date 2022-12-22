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
import com.didi.unifylogin.base.view.AbsLoginBaseFillerFragment;
import com.didi.unifylogin.presenter.ForgetSetPwdPresenter;
import com.didi.unifylogin.presenter.LoginSetPwdPresenter;
import com.didi.unifylogin.presenter.SetPwdPresenter;
import com.didi.unifylogin.presenter.ability.ISetPwdPresenter;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.PasswordUtils;
import com.didi.unifylogin.utils.phone.PhoneUtils;
import com.didi.unifylogin.utils.simplifycode.LoginTextWatcher;
import com.didi.unifylogin.view.ability.ISetPwdView;
import com.taxis99.R;

public class SetPwdFragment extends AbsLoginBaseFillerFragment<ISetPwdPresenter> implements ISetPwdView {
    protected Button confirmBtn;
    protected boolean isPasswordShow = true;
    protected ImageView mixIv;
    protected ImageView passwordBtn;
    protected EditText passwordEt;
    protected TextView smallHint;
    protected TextView tvMixHint;
    protected TextView validHint;
    protected ImageView validIv;

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_set_password, viewGroup, false);
        this.titleTv = (TextView) inflate.findViewById(R.id.tv_title);
        this.confirmBtn = (Button) inflate.findViewById(R.id.login_unify_set_password_confirm);
        this.mixIv = (ImageView) inflate.findViewById(R.id.iv_isMix);
        this.validIv = (ImageView) inflate.findViewById(R.id.iv_isValid);
        this.subTitleTv = (TextView) inflate.findViewById(R.id.tv_sub_title);
        this.passwordBtn = (ImageView) inflate.findViewById(R.id.iv_unify_login_password_mode);
        this.passwordEt = (EditText) inflate.findViewById(R.id.et_unify_login_set_password);
        this.smallHint = (TextView) inflate.findViewById(R.id.tv_small_hint);
        this.validHint = (TextView) inflate.findViewById(R.id.tv_valid_hint);
        this.tvMixHint = (TextView) inflate.findViewById(R.id.tv_mix_hint);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        this.smallHint.setText(getString(R.string.login_unify_set_password_tips, Integer.valueOf(PasswordUtils.getMinDigit())));
        String setPwdSubTitle = LoginPreferredConfig.getTextAdapter(this.messenger).getSetPwdSubTitle(this.context);
        if (TextUtils.isEmpty(setPwdSubTitle)) {
            setSubTitle(getString(LoginPreferredConfig.isUnifyPwd() ? R.string.login_unify_set_unify_pwd_sub_title : R.string.login_unify_set_pwd_sub_title, PhoneUtils.hideMiddleDigital(this.messenger.getCell())));
        } else {
            setSubTitle(setPwdSubTitle);
        }
        if (!TextUtils.isEmpty(LoginPreferredConfig.getBrand()) && !LoginPreferredConfig.getBrand().equals("DiDi")) {
            this.subTitleTv.setVisibility(4);
        }
        this.passwordEt.setTypeface(Typeface.DEFAULT);
        this.passwordEt.setTransformationMethod((TransformationMethod) null);
        this.validHint.setText(getString(R.string.login_unify_set_password_tips_2, Integer.valueOf(PasswordUtils.getMinDigit())));
        this.passwordEt.setHint(getString(R.string.login_unify_set_password_tips, Integer.valueOf(PasswordUtils.getMinDigit())));
        this.passwordBtn.setBackgroundResource(R.drawable.login_unify_img_pwd_show);
    }

    public void initListener() {
        this.confirmBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                String obj = SetPwdFragment.this.passwordEt.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    new LoginOmegaUtil(LoginOmegaUtil.CONFM_CK).send();
                    LoginLog.write(SetPwdFragment.this.TAG + " confirmBtn click");
                    ((ISetPwdPresenter) SetPwdFragment.this.presenter).setPassword(obj);
                    return;
                }
                LoginLog.write(SetPwdFragment.this.TAG + " confirmBtn password is null!");
            }
        });
        this.passwordBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.PSWDSET_DISPLAY_CK).add(LoginOmegaUtil.ACTIONID, SetPwdFragment.this.isPasswordShow ? LoginOmegaUtil.ACTIONID_SW : LoginOmegaUtil.ACTIONID_HIDE).send();
                if (SetPwdFragment.this.isPasswordShow) {
                    SetPwdFragment.this.passwordEt.setTransformationMethod(new PasswordTransformationMethod());
                    SetPwdFragment.this.passwordBtn.setBackgroundResource(R.drawable.login_unify_img_pwd_hide);
                } else {
                    SetPwdFragment.this.passwordEt.setTransformationMethod((TransformationMethod) null);
                    SetPwdFragment.this.passwordBtn.setBackgroundResource(R.drawable.login_unify_img_pwd_show);
                }
                SetPwdFragment.this.passwordEt.setSelection(SetPwdFragment.this.passwordEt.getText().length());
                SetPwdFragment setPwdFragment = SetPwdFragment.this;
                setPwdFragment.isPasswordShow = !setPwdFragment.isPasswordShow;
            }
        });
        this.passwordEt.addTextChangedListener(new LoginTextWatcher() {
            public void afterTextChanged(Editable editable) {
                SetPwdFragment.this.confirmBtn.setEnabled(SetPwdFragment.this.checkPasswordRule(editable.toString()));
                SetPwdFragment.this.passwordBtn.setVisibility(TextUtils.isEmpty(editable) ? 8 : 0);
            }
        });
        this.passwordEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                String str;
                EditText editText = SetPwdFragment.this.passwordEt;
                int i = 0;
                if (z) {
                    str = "";
                } else {
                    str = SetPwdFragment.this.getString(R.string.login_unify_set_password_tips, Integer.valueOf(PasswordUtils.getMinDigit()));
                }
                editText.setHint(str);
                TextView textView = SetPwdFragment.this.smallHint;
                if (!z && TextUtils.isEmpty(SetPwdFragment.this.passwordEt.getText())) {
                    i = 4;
                }
                textView.setVisibility(i);
            }
        });
    }

    public LoginState getNowState() {
        return LoginState.STATE_SET_PWD;
    }

    /* renamed from: com.didi.unifylogin.view.SetPwdFragment$5 */
    static /* synthetic */ class C147435 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$unifylogin$base$net$LoginScene;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.unifylogin.base.net.LoginScene[] r0 = com.didi.unifylogin.base.net.LoginScene.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$unifylogin$base$net$LoginScene = r0
                com.didi.unifylogin.base.net.LoginScene r1 = com.didi.unifylogin.base.net.LoginScene.SCENE_FORGETPWD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$unifylogin$base$net$LoginScene     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.unifylogin.base.net.LoginScene r1 = com.didi.unifylogin.base.net.LoginScene.SCENE_RESET_PWD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.unifylogin.view.SetPwdFragment.C147435.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public ISetPwdPresenter bindPresenter() {
        int i = C147435.$SwitchMap$com$didi$unifylogin$base$net$LoginScene[this.messenger.getScene().ordinal()];
        if (i == 1) {
            return new ForgetSetPwdPresenter(this, this.context);
        }
        if (i != 2) {
            return new LoginSetPwdPresenter(this, this.context);
        }
        return new SetPwdPresenter(this, this.context);
    }

    public boolean checkPasswordRule(String str) {
        boolean z;
        boolean z2 = true;
        if (PasswordUtils.isValid(str, LoginPreferredConfig.isUseWeakPwd())) {
            this.validIv.setVisibility(0);
            z = true;
        } else {
            this.validIv.setVisibility(4);
            z = false;
        }
        if (PasswordUtils.chackPasswordMix(str)) {
            this.mixIv.setVisibility(0);
        } else {
            this.mixIv.setVisibility(4);
            z2 = false;
        }
        return z2 & z;
    }
}
