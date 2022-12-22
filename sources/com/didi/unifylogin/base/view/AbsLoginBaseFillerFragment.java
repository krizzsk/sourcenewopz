package com.didi.unifylogin.base.view;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifylogin.base.manager.LoginFillerFragmentManager;
import com.didi.unifylogin.base.net.pojo.response.ActionResponse;
import com.didi.unifylogin.base.presenter.ILoginBaseFillerPresenter;
import com.didi.unifylogin.base.view.ability.ILoginBaseFillerFragment;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.taxis99.R;

public abstract class AbsLoginBaseFillerFragment<P extends ILoginBaseFillerPresenter> extends AbsLoginBaseFragment<P> implements ILoginBaseFillerFragment {

    /* renamed from: a */
    ActionResponse.Action f44714a;

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        if (getAction() != null && getAction().skip) {
            setTitleBarRightVisible(true);
            setTitleBarRightText(getString(R.string.login_unify_action_jump));
            setTitleBarRightListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    AbsLoginBaseFillerFragment.this.hideLoading();
                    ((ILoginBaseFillerPresenter) AbsLoginBaseFillerFragment.this.presenter).goFillNextInfo();
                    LoginOmegaUtil.jump(AbsLoginBaseFillerFragment.this.getNowState());
                }
            });
        }
        setTitleBarLeftVisible(!isForbidBack());
    }

    public ActionResponse.Action getAction() {
        if (this.f44714a == null) {
            this.f44714a = LoginFillerFragmentManager.getFillerInfo(getNowState());
        }
        return this.f44714a;
    }
}
