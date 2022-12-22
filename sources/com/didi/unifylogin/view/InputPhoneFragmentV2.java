package com.didi.unifylogin.view;

import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.SPUtils;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.presenter.LoginPhonePresenterV2;
import com.didi.unifylogin.presenter.ability.IInputPhonePresenter;
import com.didi.unifylogin.presenter.ability.IInputPhonePresenterV2;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.simplifycode.LoginTextWatcher;
import com.didi.unifylogin.view.ability.IInputPhoneViewV2;
import com.taxis99.R;

public class InputPhoneFragmentV2 extends InputPhoneFragment implements IInputPhoneViewV2 {

    /* renamed from: b */
    private static final String f45045b = "unify_login_image_url_key";

    /* renamed from: c */
    private TextView f45046c;

    /* renamed from: d */
    private TextView f45047d;

    /* renamed from: e */
    private ImageView f45048e;

    /* renamed from: f */
    private View f45049f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IInputPhonePresenterV2 f45050g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ImageView f45051h;

    public boolean canSlide() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int getVersion() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public View getInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.login_unify_fragment_phone_v2, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void initView(View view) {
        super.initView(view);
        this.f45050g = (IInputPhonePresenterV2) this.presenter;
        this.titleBar.setVisibility(8);
        this.f45049f = view.findViewById(R.id.ll_phone_container);
        this.f45048e = (ImageView) view.findViewById(R.id.iv_login_pre_bg);
        this.lawLayout = (LinearLayout) view.findViewById(R.id.ll_law2);
        this.lawCheckBox = (CheckBox) view.findViewById(R.id.cb_law2);
        this.lawLinkTv = (TextView) view.findViewById(R.id.tv_law2);
        this.lawCheckBox.setChecked(LoginPreferredConfig.getIsLawCbUseCache() && LoginStore.getInstance().isLawChecked());
        this.lawLinkTv.setText(LoginPreferredConfig.getLawHint());
        this.lawCbLl = (LinearLayout) view.findViewById(R.id.ll_cb_law2);
        this.f45046c = (TextView) view.findViewById(R.id.tv_switch_country_code2);
        this.f45047d = (TextView) view.findViewById(R.id.et_phone2);
        m32314a(view.findViewById(R.id.ll_law), false);
        m32314a(view.findViewById(R.id.rl_third_party_hint), false);
        this.f45047d.setText(this.messenger.getCell());
        this.thirdPartyGv = (GridView) view.findViewById(R.id.gv_third_party2);
        this.f45050g.initViewAnimatorHelper(view, this.titleBar);
        this.f45051h = (ImageView) view.findViewById(R.id.iv_clear_phone);
        loadImage("");
    }

    /* renamed from: a */
    private void m32314a(View view, boolean z) {
        view.setVisibility(z ? 0 : 8);
    }

    public void goBack() {
        if (!this.f45050g.onBackPressed()) {
            super.goBack();
        }
    }

    public boolean onBackPressed() {
        return this.f45050g.onBackPressed();
    }

    public void initListener() {
        super.initListener();
        this.f45049f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                InputPhoneFragmentV2.this.f45050g.clickPhone();
            }
        });
        this.f45046c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                InputPhoneFragmentV2.this.f45050g.clickCountry();
            }
        });
        this.f45051h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                InputPhoneFragmentV2.this.f45050g.clickClearPhone();
            }
        });
        this.phoneEt.addTextChangedListener(new LoginTextWatcher() {
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(editable)) {
                    InputPhoneFragmentV2.this.f45051h.setVisibility(8);
                } else {
                    InputPhoneFragmentV2.this.f45051h.setVisibility(0);
                }
            }
        });
    }

    public void onResume() {
        this.f45050g.preLoginRequest();
        super.onResume();
        this.f45046c.setText(CountryManager.getIns().getDefCountry().calling_code);
    }

    public void loadImage(String str) {
        if (!TextUtils.isEmpty(str)) {
            SPUtils.put(getContext(), f45045b, str);
        } else {
            str = (String) SPUtils.get(getContext(), f45045b, "");
        }
        if (!TextUtils.isEmpty(str)) {
            Glide.with(getContext()).load(str).transition(DrawableTransitionOptions.withCrossFade()).into(this.f45048e);
            new LoginOmegaUtil(LoginOmegaUtil.PUB_IBTPASLOGIN_PHOTE_SW).send();
        }
    }

    /* access modifiers changed from: protected */
    public IInputPhonePresenter bindPresenter() {
        return new LoginPhonePresenterV2(this, this.context);
    }

    /* access modifiers changed from: protected */
    public void thirdPartOmega(AbsThirdPartyLoginBase absThirdPartyLoginBase) {
        new LoginOmegaUtil(LoginOmegaUtil.PUB_IBTPASLOGIN_SOCIAL_CK, absThirdPartyLoginBase).send();
    }

    public void clearPhone() {
        this.phoneEt.setText("");
    }
}
