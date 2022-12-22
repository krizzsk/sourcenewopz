package com.didi.unifylogin.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.thirdpartylogin.base.ThirdPartyLoginManager;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.net.pojo.response.GateKeeperResponse;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.entrance.OneLoginActivity;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.presenter.LoginEmailPresenter;
import com.didi.unifylogin.presenter.ability.IInputPhonePresenter;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.CertificationController;
import com.didi.unifylogin.utils.LoginChoicePopUtil;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.email.LoginEmailTextWatcher;
import com.didi.unifylogin.view.ability.IInputPhoneView;
import com.didichuxing.apollo.sdk.Apollo;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.List;

public class InputEmailFragment extends AbsLoginBaseFragment<IInputPhonePresenter> implements IInputPhoneView {

    /* renamed from: a */
    List<GateKeeperResponse.Role> f45038a;

    /* renamed from: b */
    private View f45039b;
    protected EditText emailEt;
    protected LinearLayout lawCbLl;
    protected CheckBox lawCheckBox;
    protected LinearLayout lawLayout;
    protected TextView lawLinkTv;
    protected Button nextBtn;

    public Fragment getFragment() {
        return this;
    }

    public String getPhone() {
        return null;
    }

    public void hideThirdPartyView() {
    }

    public void setOtherWaVisibility(boolean z) {
    }

    public void setPhone(String str) {
    }

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflateView = getInflateView(layoutInflater, viewGroup);
        initView(inflateView);
        return inflateView;
    }

    /* access modifiers changed from: protected */
    public void initView(View view) {
        this.titleTv = (TextView) view.findViewById(R.id.tv_title);
        this.subTitleTv = (TextView) view.findViewById(R.id.tv_sub_title);
        this.emailEt = (EditText) view.findViewById(R.id.et_email);
        this.nextBtn = (Button) view.findViewById(R.id.btn_next);
        this.lawLayout = (LinearLayout) view.findViewById(R.id.ll_law);
        this.lawCheckBox = (CheckBox) view.findViewById(R.id.cb_law);
        this.lawLinkTv = (TextView) view.findViewById(R.id.tv_law);
        this.lawCheckBox.setChecked((LoginPreferredConfig.getIsLawCbUseCache() && LoginStore.getInstance().isLawChecked()) || m32290a());
        this.lawLinkTv.setText(LoginPreferredConfig.getLawHint());
        this.lawCbLl = (LinearLayout) view.findViewById(R.id.ll_cb_law);
        this.f45039b = view.findViewById(R.id.phoneLoginButton);
    }

    /* renamed from: a */
    private boolean m32290a() {
        try {
            if (((Integer) Apollo.getToggle("passport_article_autocheck").getExperiment().getParam("icon_type", 0)).intValue() == 1) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            LoginLog.write(this.TAG + "passportArticleAutocheck parse fail");
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public View getInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.login_unify_fragment_email, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        String plainTextEmail = LoginStore.getInstance().getPlainTextEmail();
        if (!TextUtils.isEmpty(plainTextEmail)) {
            this.emailEt.setText(plainTextEmail);
            EditText editText = this.emailEt;
            editText.setSelection(editText.getText().length());
        }
        this.lawLayout.setVisibility(TextUtils.isEmpty(LoginPreferredConfig.getLawHint()) ? 8 : 0);
        if (LoginPreferredConfig.isDefLawSelected()) {
            LoginStore.getInstance().setLawChecked(true);
        }
        if (!TextUtils.isEmpty(this.messenger.getEmail())) {
            this.emailEt.setText(this.messenger.getEmail());
        }
        if (LoginPreferredConfig.isSupportJump()) {
            m32292b();
        }
        if (ListenerManager.getShowSkipListener() != null) {
            ListenerManager.getShowSkipListener().isShowSkip(new StaticShowSkipCallBack(this));
        }
        setTitleBarLeftVisible(LoginPreferredConfig.isHomeCanBacke());
        setOtherWaVisibility(!LoginPreferredConfig.isCloseRetrieve());
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getBaseActivity() instanceof OneLoginActivity) {
            ((IInputPhonePresenter) this.presenter).goRegByKey(getBaseActivity().getIntent().getStringExtra(OneLoginActivity.REG_BY_KEY));
        }
    }

    private static class StaticShowSkipCallBack implements LoginListeners.ShowSkipCallBack {
        private WeakReference<InputEmailFragment> mWeakInputPhoneFragment;

        public StaticShowSkipCallBack(InputEmailFragment inputEmailFragment) {
            this.mWeakInputPhoneFragment = new WeakReference<>(inputEmailFragment);
        }

        public void showSkip() {
            InputEmailFragment inputEmailFragment;
            WeakReference<InputEmailFragment> weakReference = this.mWeakInputPhoneFragment;
            if (weakReference != null && (inputEmailFragment = (InputEmailFragment) weakReference.get()) != null) {
                inputEmailFragment.m32292b();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m32292b() {
        setTitleBarRightVisible(true);
        setTitleBarRightText(getString(R.string.login_unify_jump));
        setTitleBarRightListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                InputEmailFragment.this.goJump();
            }
        });
    }

    public void initListener() {
        this.lawCbLl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                LoginStore.getInstance().setLawChecked(!InputEmailFragment.this.lawCheckBox.isChecked());
                InputEmailFragment.this.lawCheckBox.setChecked(!InputEmailFragment.this.lawCheckBox.isChecked());
            }
        });
        this.nextBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.CONFM_CK).send();
                LoginLog.write(InputEmailFragment.this.TAG + " nextBtn click");
                ((IInputPhonePresenter) InputEmailFragment.this.presenter).nextOperate();
            }
        });
        this.lawCheckBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                LoginStore.getInstance().setLawChecked(InputEmailFragment.this.lawCheckBox.isChecked());
            }
        });
        this.lawLinkTv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.LAW_CK).send();
                if (!TextUtils.isEmpty(LoginPreferredConfig.getLawUrl())) {
                    CertificationController.loadLawStatus(InputEmailFragment.this.getActivity(), LoginPreferredConfig.getLawUrl());
                }
            }
        });
        this.emailEt.addTextChangedListener(new LoginEmailTextWatcher(this.nextBtn));
        this.emailEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    new LoginOmegaUtil(LoginOmegaUtil.GP_PHONENUMBER_ET_EVENT).add("content", InputEmailFragment.this.emailEt.getText().toString()).send();
                }
            }
        });
        this.f45039b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FragmentActivity activity = InputEmailFragment.this.getActivity();
                if (activity != null && activity.getSupportFragmentManager() != null) {
                    activity.getSupportFragmentManager().popBackStack();
                }
            }
        });
    }

    public boolean isAutoSlide() {
        return ThirdPartyLoginManager.getThirdPartyLogins() == null || ThirdPartyLoginManager.getThirdPartyLogins().size() <= 0;
    }

    public LoginState getNowState() {
        return LoginState.STATE_EMAIL_REGISTER_OR_LOGIN;
    }

    public void onResume() {
        super.onResume();
        EditText editText = this.emailEt;
        editText.setText(editText.getText());
        EditText editText2 = this.emailEt;
        editText2.setSelection(editText2.getText().length());
    }

    public void setEmail(String str) {
        EditText editText = this.emailEt;
        if (editText != null) {
            editText.setText(str);
        }
    }

    public String getEmail() {
        EditText editText = this.emailEt;
        if (editText != null) {
            return editText.getText().toString();
        }
        return null;
    }

    public void selectDoubleIdentity(final List<GateKeeperResponse.Role> list) {
        this.f45038a = list;
        LoginChoicePopUtil.showPopMenu(this.baseActivity, LoginChoicePopUtil.getChoicesFormRole(this.f45038a), new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
                if (i < InputEmailFragment.this.f45038a.size()) {
                    int i2 = ((GateKeeperResponse.Role) list.get(i)).f44704id;
                    LoginStore.getInstance().setAndSaveRole(i2);
                    LoginLog.write(InputEmailFragment.this.TAG + " selectDoubleIdentity role:" + i2);
                }
                ((IInputPhonePresenter) InputEmailFragment.this.presenter).goLogin(((GateKeeperResponse.Role) list.get(i)).login_type);
            }
        }, (View.OnClickListener) null);
        new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LOGIN_ROLE_SW).send();
    }

    public void updateLawLayoutVisibility(boolean z) {
        this.lawLayout.setVisibility(z ? 0 : 8);
    }

    public boolean isAgreeLaw() {
        return (this.lawCheckBox.getVisibility() == 0 && this.lawLayout.getVisibility() == 0 && !this.lawCheckBox.isChecked()) ? false : true;
    }

    /* access modifiers changed from: protected */
    public IInputPhonePresenter bindPresenter() {
        LoginLog.write(this.TAG + " bindPresenter preScene:" + this.preScene.getSceneNum());
        return new LoginEmailPresenter(this, this.context);
    }
}
