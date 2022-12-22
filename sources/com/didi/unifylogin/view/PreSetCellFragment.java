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
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.phone.PhoneUtils;
import com.taxis99.R;

public class PreSetCellFragment extends AbsLoginBaseFragment {
    protected Button nextBtn;

    public boolean canSlide() {
        return false;
    }

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_pre_set_cell, viewGroup, false);
        this.titleTv = (TextView) inflate.findViewById(R.id.tv_title);
        this.subTitleTv = (TextView) inflate.findViewById(R.id.tv_sub_title);
        this.nextBtn = (Button) inflate.findViewById(R.id.btn_next);
        this.subTitleTv.setText(getString(R.string.login_unify_current_phone, PhoneUtils.hideMiddleDigital(this.messenger.getCell())));
        return inflate;
    }

    public void initListener() {
        this.nextBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.CONFM_CK).send();
                LoginLog.write(PreSetCellFragment.this.TAG + " nextBtn click");
                PreSetCellFragment.this.presenter.updateOmegaScene(FragmentMessenger.getNowScene());
                PreSetCellFragment.this.presenter.transform(LoginState.STATE_NEW_PHONE);
            }
        });
    }

    public LoginState getNowState() {
        return LoginState.STATE_PRE_SET_CELL;
    }

    /* access modifiers changed from: protected */
    public ILoginBasePresenter bindPresenter() {
        return new LoginBasePresenter(this, this.context);
    }
}
