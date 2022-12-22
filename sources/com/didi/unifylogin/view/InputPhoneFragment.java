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
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didi.thirdpartylogin.base.ThirdPartyLoginManager;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.response.GateKeeperResponse;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.entrance.OneLoginActivity;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.presenter.LoginPhonePresenter;
import com.didi.unifylogin.presenter.ability.IInputPhonePresenter;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.CertificationController;
import com.didi.unifylogin.utils.LoginChoicePopUtil;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.OmegaUtils;
import com.didi.unifylogin.utils.ToastHelper;
import com.didi.unifylogin.utils.phone.LoginPhoneTextWatcher;
import com.didi.unifylogin.utils.phone.PhoneUtils;
import com.didi.unifylogin.view.ability.IInputPhoneView;
import com.didi.unifylogin.view.adpter.ThirdPartyEntranceAdapter;
import com.didichuxing.apollo.sdk.Apollo;
import com.didiglobal.font.DIDIFontUtils;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Stack;

public class InputPhoneFragment extends AbsLoginBaseFragment<IInputPhonePresenter> implements IInputPhoneView {

    /* renamed from: a */
    List<GateKeeperResponse.Role> f45042a;

    /* renamed from: b */
    private View f45043b;

    /* renamed from: c */
    private TextView f45044c;
    protected LinearLayout lawCbLl;
    protected CheckBox lawCheckBox;
    protected LinearLayout lawLayout;
    protected TextView lawLinkTv;
    protected View lineView;
    protected Button nextBtn;
    protected EditText phoneEt;
    protected TextView retrieveTv;
    protected GridView thirdPartyGv;
    protected RelativeLayout thirdPartyHintLayout;

    public String getEmail() {
        return null;
    }

    public Fragment getFragment() {
        return this;
    }

    /* access modifiers changed from: protected */
    public int getVersion() {
        return 0;
    }

    public void setEmail(String str) {
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
        String inputPhoneSubTitle = LoginPreferredConfig.getTextAdapter(this.messenger).getInputPhoneSubTitle(this.context);
        if (!TextUtils.isEmpty(inputPhoneSubTitle)) {
            setSubTitle(inputPhoneSubTitle);
        } else if (!LoginPreferredConfig.isUnifyPwd()) {
            this.subTitleTv.setVisibility(4);
        } else {
            this.subTitleTv.setVisibility(0);
        }
        this.phoneEt = (EditText) view.findViewById(R.id.et_phone);
        this.nextBtn = (Button) view.findViewById(R.id.btn_next);
        this.f45044c = (TextView) view.findViewById(R.id.change_phone);
        if (LoginPreferredConfig.isIsShowChangePhoneByIDEntrance()) {
            OmegaUtils.ibt_gd_brchangephone_login_sw();
            this.f45044c.setVisibility(0);
        } else {
            this.f45044c.setVisibility(8);
        }
        this.retrieveTv = (TextView) view.findViewById(R.id.tv_other_way);
        this.lawLayout = (LinearLayout) view.findViewById(R.id.ll_law);
        this.lawCheckBox = (CheckBox) view.findViewById(R.id.cb_law);
        this.lawLinkTv = (TextView) view.findViewById(R.id.tv_law);
        this.lawCheckBox.setChecked((LoginPreferredConfig.getIsLawCbUseCache() && LoginStore.getInstance().isLawChecked()) || m32299a());
        this.lawLinkTv.setText(LoginPreferredConfig.getLawHint());
        this.lawCbLl = (LinearLayout) view.findViewById(R.id.ll_cb_law);
        this.lineView = view.findViewById(R.id.v_line);
        this.thirdPartyHintLayout = (RelativeLayout) view.findViewById(R.id.rl_third_party_hint);
        this.thirdPartyGv = (GridView) view.findViewById(R.id.gv_third_party);
        DIDIFontUtils.Companion.setTypeface(getContext(), this.lawCheckBox);
        this.f45043b = view.findViewById(R.id.signInEmail);
        if (LoginPreferredConfig.getShowEmailEntrance()) {
            this.f45043b.setVisibility(0);
        } else {
            this.f45043b.setVisibility(8);
        }
    }

    /* renamed from: a */
    private boolean m32299a() {
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
        return layoutInflater.inflate(R.layout.login_unify_fragment_phone, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        this.lawLayout.setVisibility(TextUtils.isEmpty(LoginPreferredConfig.getLawHint()) ? 8 : 0);
        if (LoginPreferredConfig.isDefLawSelected()) {
            LoginStore.getInstance().setLawChecked(true);
        }
        if (!TextUtils.isEmpty(this.messenger.getCell())) {
            this.phoneEt.setText(this.messenger.getCell());
        }
        if (LoginPreferredConfig.isSupportJump()) {
            m32301b();
        }
        if (ListenerManager.getShowSkipListener() != null) {
            ListenerManager.getShowSkipListener().isShowSkip(new StaticShowSkipCallBack(this));
        }
        setTitleBarLeftVisible(LoginPreferredConfig.isHomeCanBacke());
        setOtherWaVisibility(!LoginPreferredConfig.isCloseRetrieve());
        showThirdPartyView();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getBaseActivity() instanceof OneLoginActivity) {
            ((IInputPhonePresenter) this.presenter).goRegByKey(getBaseActivity().getIntent().getStringExtra(OneLoginActivity.REG_BY_KEY));
        }
    }

    private static class StaticShowSkipCallBack implements LoginListeners.ShowSkipCallBack {
        private WeakReference<InputPhoneFragment> mWeakInputPhoneFragment;

        public StaticShowSkipCallBack(InputPhoneFragment inputPhoneFragment) {
            this.mWeakInputPhoneFragment = new WeakReference<>(inputPhoneFragment);
        }

        public void showSkip() {
            InputPhoneFragment inputPhoneFragment;
            WeakReference<InputPhoneFragment> weakReference = this.mWeakInputPhoneFragment;
            if (weakReference != null && (inputPhoneFragment = (InputPhoneFragment) weakReference.get()) != null) {
                inputPhoneFragment.m32301b();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m32301b() {
        setTitleBarRightVisible(true);
        setTitleBarRightText(getString(R.string.login_unify_jump));
        setTitleBarRightListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                InputPhoneFragment.this.goJump();
            }
        });
    }

    public void showThirdPartyView() {
        ThirdPartyLoginManager.filterUnsupported();
        if (ThirdPartyLoginManager.getThirdPartyLogins() != null && ThirdPartyLoginManager.getThirdPartyLogins().size() > 0) {
            this.thirdPartyGv.setVisibility(0);
            this.thirdPartyHintLayout.setVisibility(0);
            this.thirdPartyGv.setNumColumns(ThirdPartyLoginManager.getThirdPartyLogins().size());
            ThirdPartyEntranceAdapter thirdPartyEntranceAdapter = new ThirdPartyEntranceAdapter(this.context, new ThirdPartyEntranceAdapter.ItemClickListener() {
                public void OnItemClickListener(int i) {
                    if (!InputPhoneFragment.this.isAgreeLaw()) {
                        ToastHelper.showAgreeLawHint(InputPhoneFragment.this.context, InputPhoneFragment.this);
                        return;
                    }
                    AbsThirdPartyLoginBase absThirdPartyLoginBase = ThirdPartyLoginManager.getThirdPartyLogins().get(i);
                    InputPhoneFragment.this.thirdPartOmega(absThirdPartyLoginBase);
                    if (absThirdPartyLoginBase.isSupport()) {
                        ((IInputPhonePresenter) InputPhoneFragment.this.presenter).getThirdPartyToken(absThirdPartyLoginBase);
                        return;
                    }
                    InputPhoneFragment inputPhoneFragment = InputPhoneFragment.this;
                    inputPhoneFragment.showError(inputPhoneFragment.context.getResources().getString(R.string.login_unify_third_party_get_token_error));
                }
            }, ThirdPartyLoginManager.getThirdPartyLogins());
            thirdPartyEntranceAdapter.setVersion(getVersion());
            this.thirdPartyGv.setAdapter(thirdPartyEntranceAdapter);
        }
    }

    /* access modifiers changed from: protected */
    public void thirdPartOmega(AbsThirdPartyLoginBase absThirdPartyLoginBase) {
        new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LOGIN_SOCIAL_CK, absThirdPartyLoginBase).send();
    }

    public void initListener() {
        this.lawCbLl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                LoginStore.getInstance().setLawChecked(!InputPhoneFragment.this.lawCheckBox.isChecked());
                InputPhoneFragment.this.lawCheckBox.setChecked(!InputPhoneFragment.this.lawCheckBox.isChecked());
            }
        });
        this.nextBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.CONFM_CK).send();
                LoginLog.write(InputPhoneFragment.this.TAG + " nextBtn click");
                ((IInputPhonePresenter) InputPhoneFragment.this.presenter).nextOperate();
            }
        });
        this.f45044c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ((IInputPhonePresenter) InputPhoneFragment.this.presenter).go2InputCPF(InputPhoneFragment.this.getContext());
            }
        });
        this.retrieveTv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.PHOE_UNAVAIL_CK).send();
                LoginLog.write(InputPhoneFragment.this.TAG + " retrieveTv click");
                InputPhoneFragment.this.messenger.setCell(InputPhoneFragment.this.getPhone());
                ((IInputPhonePresenter) InputPhoneFragment.this.presenter).retrieveAccount();
            }
        });
        this.lawCheckBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                LoginStore.getInstance().setLawChecked(InputPhoneFragment.this.lawCheckBox.isChecked());
            }
        });
        this.lawLinkTv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.LAW_CK).send();
                if (!TextUtils.isEmpty(LoginPreferredConfig.getLawUrl())) {
                    CertificationController.loadLawStatus(InputPhoneFragment.this.getActivity(), LoginPreferredConfig.getLawUrl());
                }
            }
        });
        EditText editText = this.phoneEt;
        editText.addTextChangedListener(new LoginPhoneTextWatcher(this.nextBtn, editText));
        this.phoneEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    new LoginOmegaUtil(LoginOmegaUtil.GP_PHONENUMBER_ET_EVENT).add("content", InputPhoneFragment.this.phoneEt.getText().toString()).send();
                }
                InputPhoneFragment.this.lineView.setBackgroundColor(InputPhoneFragment.this.context.getResources().getColor(z ? R.color.login_unify_color_edittext_line_input : R.color.login_unify_color_edittext_line_no_input));
            }
        });
        this.f45043b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IInputPhonePresenter bindPresenter = InputPhoneFragment.this.bindPresenter();
                if (bindPresenter != null) {
                    bindPresenter.transform(LoginState.STATE_EMAIL_REGISTER_OR_LOGIN);
                }
            }
        });
    }

    public boolean isAutoSlide() {
        return ThirdPartyLoginManager.getThirdPartyLogins() == null || ThirdPartyLoginManager.getThirdPartyLogins().size() <= 0;
    }

    public LoginState getNowState() {
        return LoginState.STATE_INPUT_PHONE;
    }

    public void onResume() {
        super.onResume();
        EditText editText = this.phoneEt;
        editText.setText(editText.getText());
        EditText editText2 = this.phoneEt;
        editText2.setSelection(editText2.getText().length());
        Stack<LoginScene> stack = FragmentMessenger.scenesStack;
        if (!stack.isEmpty() && !(this instanceof ThirdPartyPhoneFragment) && stack.peek() == LoginScene.SCENE_THIRD_LOGIN) {
            stack.pop();
        }
    }

    public String getPhone() {
        EditText editText = this.phoneEt;
        if (editText != null) {
            return PhoneUtils.toNormalPhone(editText.getText().toString());
        }
        return null;
    }

    public void setPhone(String str) {
        EditText editText = this.phoneEt;
        if (editText != null) {
            editText.setText(str);
        }
    }

    public void setOtherWaVisibility(boolean z) {
        TextView textView = this.retrieveTv;
        if (textView == null) {
            return;
        }
        if (z) {
            new LoginOmegaUtil(LoginOmegaUtil.GP_NOT_FINISH_INIT).send();
            this.retrieveTv.setVisibility(0);
            return;
        }
        textView.setVisibility(8);
    }

    public void selectDoubleIdentity(final List<GateKeeperResponse.Role> list) {
        this.f45042a = list;
        LoginChoicePopUtil.showPopMenu(this.baseActivity, LoginChoicePopUtil.getChoicesFormRole(this.f45042a), new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
                if (i < InputPhoneFragment.this.f45042a.size()) {
                    int i2 = ((GateKeeperResponse.Role) list.get(i)).f44704id;
                    LoginStore.getInstance().setAndSaveRole(i2);
                    LoginLog.write(InputPhoneFragment.this.TAG + " selectDoubleIdentity role:" + i2);
                }
                ((IInputPhonePresenter) InputPhoneFragment.this.presenter).goLogin(((GateKeeperResponse.Role) list.get(i)).login_type);
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

    public void hideThirdPartyView() {
        this.thirdPartyGv.setVisibility(8);
        this.thirdPartyHintLayout.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public IInputPhonePresenter bindPresenter() {
        LoginLog.write(this.TAG + " bindPresenter preScene:" + this.preScene.getSceneNum());
        return new LoginPhonePresenter(this, this.context);
    }
}
