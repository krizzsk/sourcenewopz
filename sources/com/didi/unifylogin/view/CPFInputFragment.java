package com.didi.unifylogin.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.presenter.CPFInputPresenter;
import com.didi.unifylogin.presenter.ICPFInputPresenter;
import com.didi.unifylogin.presenter.ICPFInputView;
import com.didi.unifylogin.utils.CPFWatcher;
import com.didi.unifylogin.utils.CommonUtils;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.OmegaUtils;
import com.taxis99.R;

public class CPFInputFragment extends AbsLoginBaseFragment<ICPFInputPresenter> implements ICPFInputView {

    /* renamed from: a */
    private long f45012a;
    protected EditText mCPFEt;
    protected Button mNextBtn;
    protected TextView mSmallHint;

    public void initListener() {
    }

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f45012a = System.currentTimeMillis();
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_input_cpf, viewGroup, false);
        this.mCPFEt = (EditText) inflate.findViewById(R.id.et_cpf);
        this.mSmallHint = (TextView) inflate.findViewById(R.id.tv_small_hint);
        Button button = (Button) inflate.findViewById(R.id.btn_next);
        this.mNextBtn = button;
        EditText editText = this.mCPFEt;
        editText.addTextChangedListener(new CPFWatcher(editText, button, this.mSmallHint));
        this.mNextBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ((ICPFInputPresenter) CPFInputFragment.this.presenter).verifyCPF();
            }
        });
        OmegaUtils.ibt_gd_brchangephone_cfp_sw();
        return inflate;
    }

    public void onPause() {
        super.onPause();
        OmegaUtils.ibt_gd_time_brchangephone_cfp_sw(System.currentTimeMillis() - this.f45012a);
    }

    public String getCPF() {
        EditText editText = this.mCPFEt;
        if (editText != null) {
            return CommonUtils.deleteNonNum(editText.getText().toString().trim());
        }
        return null;
    }

    public LoginState getNowState() {
        return LoginState.STATE_LOGIN_CHANGE_PHONE_INPUT_CPF;
    }

    /* access modifiers changed from: protected */
    public ICPFInputPresenter bindPresenter() {
        return new CPFInputPresenter(this, this.context);
    }
}
