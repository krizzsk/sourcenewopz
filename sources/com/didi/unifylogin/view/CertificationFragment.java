package com.didi.unifylogin.view;

import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.presenter.ForgetCertificationPresenter;
import com.didi.unifylogin.presenter.LoginCertificationPresenter;
import com.didi.unifylogin.presenter.ability.ICertificationPresenter;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.customview.LoginNextButton;
import com.didi.unifylogin.utils.simplifycode.LoginTextWatcher;
import com.didi.unifylogin.view.ability.ICertificationView;
import com.taxis99.R;

public class CertificationFragment extends AbsLoginBaseFragment<ICertificationPresenter> implements ICertificationView {

    /* renamed from: a */
    EditText f45013a;

    /* renamed from: b */
    EditText f45014b;

    /* renamed from: c */
    EditText f45015c;

    /* renamed from: d */
    TextView f45016d;

    /* renamed from: e */
    TextView f45017e;

    /* renamed from: f */
    TextView f45018f;

    /* renamed from: g */
    LoginNextButton f45019g;

    /* access modifiers changed from: protected */
    public void setScrolLayoutChange(ScrollView scrollView) {
    }

    /* renamed from: com.didi.unifylogin.view.CertificationFragment$2 */
    static /* synthetic */ class C146602 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$unifylogin$base$net$LoginScene;

        static {
            int[] iArr = new int[LoginScene.values().length];
            $SwitchMap$com$didi$unifylogin$base$net$LoginScene = iArr;
            try {
                iArr[LoginScene.SCENE_FORGETPWD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public ICertificationPresenter bindPresenter() {
        if (C146602.$SwitchMap$com$didi$unifylogin$base$net$LoginScene[this.messenger.getScene().ordinal()] != 1) {
            return new LoginCertificationPresenter(this, this.context);
        }
        return new ForgetCertificationPresenter(this, this.context);
    }

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_certification, viewGroup, false);
        this.subTitleTv = (TextView) inflate.findViewById(R.id.tv_sub_title);
        this.f45013a = (EditText) inflate.findViewById(R.id.et_name);
        this.f45014b = (EditText) inflate.findViewById(R.id.et_last_name);
        this.f45015c = (EditText) inflate.findViewById(R.id.et_id_num);
        this.f45019g = (LoginNextButton) inflate.findViewById(R.id.btn_next);
        this.f45016d = (TextView) inflate.findViewById(R.id.tv_last_name_hint);
        this.f45017e = (TextView) inflate.findViewById(R.id.tv_name_hint);
        this.f45018f = (TextView) inflate.findViewById(R.id.tv_certification_num_hint);
        return inflate;
    }

    public void initListener() {
        this.f45019g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.CONFM_CK).send();
                ((ICertificationPresenter) CertificationFragment.this.presenter).certification();
            }
        });
        this.f45014b.addTextChangedListener(new CertifiCationTextWatcher());
        this.f45013a.addTextChangedListener(new CertifiCationTextWatcher());
        this.f45015c.addTextChangedListener(new CertifiCationTextWatcher());
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        if (!TextUtils.isEmpty(this.messenger.getCredential())) {
            this.f45018f.setText(this.messenger.getCredential());
        }
        if (CountryManager.getIns().getCurrentCountry() != null && CountryManager.getIns().getCurrentCountry().country_id == 156) {
            this.f45014b.setVisibility(8);
            this.f45016d.setVisibility(8);
            this.f45017e.setText(getText(R.string.login_unify_certification_name_hint));
        }
    }

    public LoginState getNowState() {
        return LoginState.STATE_CERTIFICATION;
    }

    public String getName() {
        EditText editText = this.f45013a;
        if (editText != null) {
            return editText.getText().toString().trim();
        }
        return null;
    }

    public String getLastName() {
        EditText editText = this.f45014b;
        if (editText != null) {
            return editText.getText().toString().trim();
        }
        return null;
    }

    public String getIdNum() {
        EditText editText = this.f45015c;
        if (editText != null) {
            return editText.getText().toString().trim();
        }
        return null;
    }

    class CertifiCationTextWatcher extends LoginTextWatcher {
        CertifiCationTextWatcher() {
        }

        public void afterTextChanged(Editable editable) {
            boolean z = false;
            boolean z2 = CertificationFragment.this.f45013a.getVisibility() != 0 || !TextUtils.isEmpty(CertificationFragment.this.f45013a.getText());
            if (CertificationFragment.this.f45014b.getVisibility() == 0 && TextUtils.isEmpty(CertificationFragment.this.f45014b.getText())) {
                z2 = false;
            }
            if (CertificationFragment.this.f45015c.getVisibility() != 0 || !TextUtils.isEmpty(CertificationFragment.this.f45015c.getText())) {
                z = z2;
            }
            CertificationFragment.this.f45019g.setEnabled(z);
        }
    }
}
