package com.didi.unifylogin.view;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.presenter.ResetInputEmailPresenter;
import com.didi.unifylogin.presenter.ability.IInputEmailPresenter;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.simplifycode.LoginTextWatcher;
import com.didi.unifylogin.view.ability.IInputEmailView;
import com.taxis99.R;

public class InputNewEmailFragment extends AbsLoginBaseFragment<IInputEmailPresenter> implements IInputEmailView {

    /* renamed from: a */
    EditText f45040a;

    /* renamed from: b */
    Button f45041b;

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_input_new_email, (ViewGroup) null);
        this.f45040a = (EditText) inflate.findViewById(R.id.et_email);
        this.f45041b = (Button) inflate.findViewById(R.id.btn_next);
        this.titleTv = (TextView) inflate.findViewById(R.id.tv_title);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        String str;
        super.updateView();
        if (TextUtil.isEmpty(this.messenger.getHideEmail())) {
            str = getString(R.string.login_unify_input_email_title);
        } else {
            str = getString(R.string.login_unify_input_new_email_title);
        }
        setTitle(str);
    }

    public void initListener() {
        this.f45041b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TextUtil.isEmpty(InputNewEmailFragment.this.getNewEmail()) || !InputNewEmailFragment.this.getNewEmail().contains("@")) {
                    InputNewEmailFragment inputNewEmailFragment = InputNewEmailFragment.this;
                    inputNewEmailFragment.showError(inputNewEmailFragment.context.getString(R.string.login_unify_input_right_email));
                    return;
                }
                new LoginOmegaUtil(LoginOmegaUtil.CONFM_CK).send();
                ((IInputEmailPresenter) InputNewEmailFragment.this.presenter).resetEmail();
            }
        });
        this.f45040a.addTextChangedListener(new LoginTextWatcher() {
            public void afterTextChanged(Editable editable) {
                InputNewEmailFragment.this.f45041b.setEnabled(!TextUtil.isEmpty(editable.toString()));
            }
        });
    }

    public LoginState getNowState() {
        return LoginState.STATE_NEW_EMAIL;
    }

    /* access modifiers changed from: protected */
    public IInputEmailPresenter bindPresenter() {
        return new ResetInputEmailPresenter(this, this.context);
    }

    public String getNewEmail() {
        EditText editText = this.f45040a;
        if (editText != null) {
            return editText.getText().toString();
        }
        return null;
    }
}
