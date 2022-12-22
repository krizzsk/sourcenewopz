package com.didi.unifylogin.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.presenter.ILoginBasePresenter;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.taxis99.R;

public class PreRetrieveFragment extends AbsLoginBaseFragment {
    protected Button forgetCellBtn;
    protected Button notGetCodeBtn;

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_pre_retrieve, viewGroup, false);
        this.notGetCodeBtn = (Button) inflate.findViewById(R.id.btn_not_get);
        this.forgetCellBtn = (Button) inflate.findViewById(R.id.btn_forget_cell);
        return inflate;
    }

    public void initListener() {
        this.notGetCodeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.BYID_CK).send();
                LoginLog.write(PreRetrieveFragment.this.TAG + " notGetCodeBtn click");
                PreRetrieveFragment.this.presenter.updateOmegaScene(FragmentMessenger.getNowScene());
                PreRetrieveFragment.this.presenter.transform(LoginState.STATE_CONFIRM_PHONE);
            }
        });
        this.forgetCellBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.PHOE_FORGET_CK).send();
                LoginLog.write(PreRetrieveFragment.this.TAG + " forgetCellBtn click");
                PreRetrieveFragment.this.presenter.updateOmegaScene(FragmentMessenger.getNowScene());
                PreRetrieveFragment.this.presenter.transform(LoginState.STATE_FORGET_CELL);
            }
        });
    }

    public LoginState getNowState() {
        return LoginState.STATE_PRE_RETRIEVE;
    }

    /* access modifiers changed from: protected */
    public ILoginBasePresenter bindPresenter() {
        return new LoginBasePresenter(this, this.context);
    }
}
