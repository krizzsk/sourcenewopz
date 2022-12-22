package com.didi.unifylogin.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.presenter.ILoginBasePresenter;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.base.view.AbsLoginBaseFillerFragment;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.phone.PhoneUtils;
import com.taxis99.R;

public class PreSetPwdFragment extends AbsLoginBaseFillerFragment {

    /* renamed from: b */
    TextView f45064b;
    protected Button nextBtn;

    public boolean canSlide() {
        return false;
    }

    /* access modifiers changed from: protected */
    public ILoginBasePresenter bindPresenter() {
        return new LoginBasePresenter(this, this.context);
    }

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_pre_set_pwd, viewGroup, false);
        this.titleTv = (TextView) inflate.findViewById(R.id.tv_title);
        this.f45064b = (TextView) inflate.findViewById(R.id.tv_sub_title);
        this.nextBtn = (Button) inflate.findViewById(R.id.btn_next);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        this.f45064b.setText(getString(R.string.login_unify_pre_set_unify_pwd_tips, PhoneUtils.hideMiddleDigital(this.messenger.getCell())));
    }

    public void initListener() {
        this.nextBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.CONFM_CK).send();
                boolean isForbidBack = PreSetPwdFragment.this.isForbidBack();
                PreSetPwdFragment.this.presenter.updateOmegaScene(FragmentMessenger.getNowScene());
                PreSetPwdFragment.this.presenter.transform(LoginState.STATE_SET_PWD);
                PreSetPwdFragment.this.setForbidBack(isForbidBack);
            }
        });
    }

    public LoginState getNowState() {
        return LoginState.STATE_PRE_SET_PWD;
    }
}
