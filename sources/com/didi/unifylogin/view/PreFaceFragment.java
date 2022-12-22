package com.didi.unifylogin.view;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.presenter.PreFacePresenter;
import com.didi.unifylogin.presenter.ability.IPreFacePresenter;
import com.didi.unifylogin.utils.KeyboardHelper;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.customview.LoginNextButton;
import com.didi.unifylogin.utils.phone.PhoneUtils;
import com.didi.unifylogin.view.ability.IPreFaceView;
import com.taxis99.R;

public class PreFaceFragment extends AbsLoginBaseFragment<IPreFacePresenter> implements IPreFaceView {

    /* renamed from: a */
    LoginNextButton f45056a;

    /* renamed from: b */
    TextView f45057b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LoginOmegaUtil.trackEvent(LoginOmegaUtil.TONE_P_X_LOGIN_FACE_DESC_SW);
    }

    /* access modifiers changed from: protected */
    public IPreFacePresenter bindPresenter() {
        return new PreFacePresenter(this, this.context);
    }

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_pre_face, viewGroup, false);
        this.f45056a = (LoginNextButton) inflate.findViewById(R.id.btn_next);
        this.f45057b = (TextView) inflate.findViewById(R.id.tv_hint_cell);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        this.f45057b.setText(PhoneUtils.hideMiddleDigital(this.messenger.getCell()));
        setTitleBarCenterVisible(true);
        setTitleBarCenterMsg(getString(R.string.login_unify_pre_face_title_bar));
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                KeyboardHelper.hideInputMethod(PreFaceFragment.this.context, PreFaceFragment.this.contentView);
            }
        }, Build.VERSION.SDK_INT < 21 ? 400 : 200);
    }

    public void initListener() {
        this.f45056a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                PreFaceFragment.this.messenger.setSessionId((String) null);
                ((IPreFacePresenter) PreFaceFragment.this.presenter).verifyFace();
                LoginOmegaUtil.trackEvent(LoginOmegaUtil.TONE_P_X_LOGIN_FACE_DESC_CK);
            }
        });
    }

    public LoginState getNowState() {
        return LoginState.STATE_PRE_FACE;
    }
}
