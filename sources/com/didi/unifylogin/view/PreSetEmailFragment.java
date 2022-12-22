package com.didi.unifylogin.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.presenter.PreSetEmailPresenter;
import com.didi.unifylogin.presenter.ability.IPreSetEmailPresenter;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.view.ability.IPreSetEmailView;
import com.taxis99.R;
import java.text.SimpleDateFormat;

public class PreSetEmailFragment extends AbsLoginBaseFragment<IPreSetEmailPresenter> implements IPreSetEmailView {

    /* renamed from: a */
    TextView f45058a;

    /* renamed from: b */
    TextView f45059b;

    /* renamed from: c */
    Button f45060c;

    /* renamed from: d */
    LinearLayout f45061d;

    /* renamed from: e */
    LinearLayout f45062e;

    /* renamed from: f */
    Button f45063f;

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_pre_set_email, (ViewGroup) null);
        this.f45061d = (LinearLayout) inflate.findViewById(R.id.ll_operate);
        this.f45062e = (LinearLayout) inflate.findViewById(R.id.rl_error);
        this.f45058a = (TextView) inflate.findViewById(R.id.tv_activate);
        this.f45060c = (Button) inflate.findViewById(R.id.btn_next);
        this.titleTv = (TextView) inflate.findViewById(R.id.tv_title);
        this.subTitleTv = (TextView) inflate.findViewById(R.id.tv_sub_title);
        this.f45059b = (TextView) inflate.findViewById(R.id.tv_content);
        this.f45063f = (Button) inflate.findViewById(R.id.btn_error_retry);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        this.f45061d.setVisibility(8);
        this.f45062e.setVisibility(8);
        ((IPreSetEmailPresenter) this.presenter).getEmailState();
    }

    public void initListener() {
        this.f45060c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ((IPreSetEmailPresenter) PreSetEmailFragment.this.presenter).updateOmegaScene(FragmentMessenger.getNowScene());
                ((IPreSetEmailPresenter) PreSetEmailFragment.this.presenter).transform(LoginState.STATE_NEW_EMAIL);
            }
        });
        this.f45058a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_EMAIL_VERIFY_CK).send();
                ((IPreSetEmailPresenter) PreSetEmailFragment.this.presenter).toActivate();
            }
        });
        this.f45063f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ((IPreSetEmailPresenter) PreSetEmailFragment.this.presenter).getEmailState();
            }
        });
    }

    public void upDateByState(int i, long j) {
        String str;
        String str2;
        String str3;
        String str4;
        this.f45062e.setVisibility(8);
        this.f45061d.setVisibility(0);
        if (TextUtil.isEmpty(this.messenger.getHideEmail())) {
            str = getString(R.string.login_unify_not_filled_email);
        } else {
            str = this.messenger.getHideEmail();
        }
        setSubTitle(str);
        if (TextUtil.isEmpty(this.messenger.getHideEmail())) {
            str2 = getString(R.string.login_unify_pre_set_email_title);
        } else {
            str2 = getString(R.string.login_unify_pre_reset_email_title);
        }
        setTitle(str2);
        Button button = this.f45060c;
        if (TextUtil.isEmpty(this.messenger.getHideEmail())) {
            str3 = getString(R.string.login_unify_pre_input_email_next);
        } else {
            str3 = getString(R.string.login_unify_pre_change_email_next);
        }
        button.setText(str3);
        if (i == 1) {
            this.f45058a.setVisibility(8);
            this.f45059b.setText(getString(R.string.login_unify_activated_email_content, transferLongToDate(j)));
            str4 = LoginOmegaUtil.VERIFYED_EMAIL;
        } else if (!TextUtil.isEmpty(this.messenger.getHideEmail())) {
            this.f45058a.setVisibility(0);
            this.f45059b.setText(getString(R.string.login_unify_unactivated_email_content));
            str4 = LoginOmegaUtil.NEED_VERIFY_EMAIL;
        } else {
            this.f45058a.setVisibility(8);
            this.f45059b.setText(getString(R.string.login_unify_not_filled_email_content));
            str4 = LoginOmegaUtil.NO_EMAIL;
        }
        new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_EMAIL_EDIT_SW).add("status", str4).send();
    }

    public void showActivateDialog() {
        showInfoDialog(getString(R.string.login_unify_activated_dialog_title), getString(R.string.login_unify_activated_dialog_msg), getString(R.string.login_unify_str_know_btn), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_EMAIL_VERIFYCONFIRM_CK).send();
            }
        });
        new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_EMAIL_VERIFYCONFIRM_SW).send();
    }

    public void showErrorView() {
        this.f45062e.setVisibility(0);
        this.f45061d.setVisibility(8);
    }

    public LoginState getNowState() {
        return LoginState.STATE_PRE_SET_EMAIL;
    }

    /* access modifiers changed from: protected */
    public IPreSetEmailPresenter bindPresenter() {
        return new PreSetEmailPresenter(this, this.context);
    }

    public static String transferLongToDate(long j) {
        if (j <= 0) {
            return "";
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j * 1000));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
