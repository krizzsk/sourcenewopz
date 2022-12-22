package com.didi.unifylogin.view;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.presenter.InputNewPhoneByIDPresenter;
import com.didi.unifylogin.presenter.InputNewPhonePresenter;
import com.didi.unifylogin.presenter.VerifyCodeInputPhonePresenter;
import com.didi.unifylogin.presenter.ability.IInputNewPhonePresenter;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.OmegaUtils;
import com.didi.unifylogin.utils.customview.CommonBottomDialog;
import com.didi.unifylogin.utils.customview.CountrySwitchView;
import com.didi.unifylogin.utils.phone.LoginPhoneTextWatcher;
import com.didi.unifylogin.view.ability.IInputNewPhoneView;
import com.didichuxing.apollo.sdk.Apollo;
import com.taxis99.R;

public class NewPhoneFragment extends AbsLoginBaseFragment<IInputNewPhonePresenter> implements IInputNewPhoneView {

    /* renamed from: a */
    private static final int f45052a = 100;

    /* renamed from: b */
    private long f45053b;
    protected CountrySwitchView countrySwitchView;
    protected Button nextBtn;
    protected EditText phoneEt;
    protected TextView retrieveTv;

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_phone, viewGroup, false);
        this.titleTv = (TextView) inflate.findViewById(R.id.tv_title);
        this.subTitleTv = (TextView) inflate.findViewById(R.id.tv_sub_title);
        this.phoneEt = (EditText) inflate.findViewById(R.id.et_phone);
        this.nextBtn = (Button) inflate.findViewById(R.id.btn_next);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_other_way);
        this.retrieveTv = textView;
        textView.setVisibility(8);
        CountrySwitchView countrySwitchView2 = (CountrySwitchView) inflate.findViewById(R.id.country_switch_view);
        this.countrySwitchView = countrySwitchView2;
        countrySwitchView2.setSendResult2Caller(true, 100);
        if (!Apollo.getToggle("update_phone_can_change_prefix", true).allow()) {
            this.countrySwitchView.forbidSwitch();
        }
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        setTitle(getString(R.string.login_unify_set_new_phone));
        setSubTitle(getString(R.string.login_unify_input_new_phone_sub_title));
    }

    public void onResume() {
        super.onResume();
        this.phoneEt.setText("");
        this.f45053b = System.currentTimeMillis();
    }

    public void onPause() {
        if (this.messenger.isChangePhoneByID()) {
            OmegaUtils.ibt_gd_time_brchangephone_newphone_sw(System.currentTimeMillis() - this.f45053b);
        }
        super.onPause();
    }

    public void initListener() {
        this.nextBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NewPhoneFragment.this.messenger.isChangePhoneByID()) {
                    OmegaUtils.ibt_gd_time_brchangephone_newphone_ck();
                    CommonBottomDialog commonBottomDialog = new CommonBottomDialog(NewPhoneFragment.this.baseActivity);
                    commonBottomDialog.setCloseDialogIconVisible();
                    commonBottomDialog.setCancelable(false);
                    commonBottomDialog.show(NewPhoneFragment.this.getResources().getString(R.string.GDriver_phonenumber_Confirm_Change_yoNf), NewPhoneFragment.this.getResources().getString(R.string.GDriver_phonenumber_The_information_fsXy), NewPhoneFragment.this.getResources().getString(R.string.GDriver_phonenumber_Determination_kUWR), (View) null, new CommonBottomDialog.BottomDialogInterface() {
                        public void onConfirmClicked(CommonBottomDialog commonBottomDialog) {
                            OmegaUtils.ibt_gd_brchangephone_newphone_confirm_popup_ck(1);
                            commonBottomDialog.dismiss();
                            ((IInputNewPhonePresenter) NewPhoneFragment.this.presenter).verifyPhone();
                        }

                        public void onCancelClicked(CommonBottomDialog commonBottomDialog) {
                            commonBottomDialog.dismiss();
                        }

                        public void onCloseDialog(CommonBottomDialog commonBottomDialog) {
                            super.onCloseDialog(commonBottomDialog);
                            commonBottomDialog.dismiss();
                            OmegaUtils.ibt_gd_brchangephone_newphone_confirm_popup_ck(0);
                        }
                    });
                    OmegaUtils.ibt_gd_brchangephone_newphone_popup_sw();
                    return;
                }
                ((IInputNewPhonePresenter) NewPhoneFragment.this.presenter).verifyPhone();
                new LoginOmegaUtil(LoginOmegaUtil.CONFM_CK).send();
                LoginLog.write(NewPhoneFragment.this.TAG + " nextBtn click");
            }
        });
        this.phoneEt.addTextChangedListener(new LoginPhoneTextWatcher(this.nextBtn));
    }

    public LoginState getNowState() {
        return LoginState.STATE_NEW_PHONE;
    }

    public String getPhone() {
        EditText editText = this.phoneEt;
        if (editText != null) {
            return editText.getText().toString().trim();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public IInputNewPhonePresenter bindPresenter() {
        if (this.messenger.isChangePhoneByID()) {
            OmegaUtils.ibt_gd_brchangephone_newphone_sw();
            return new InputNewPhoneByIDPresenter(this, this.context);
        } else if (this.preScene == null) {
            return new InputNewPhonePresenter(this, this.context);
        } else {
            LoginLog.write(this.TAG + " preScene: " + this.preScene.getSceneNum());
            if (C147222.$SwitchMap$com$didi$unifylogin$base$net$LoginScene[this.preScene.ordinal()] != 1) {
                return new InputNewPhonePresenter(this, this.context);
            }
            return new VerifyCodeInputPhonePresenter(this, this.context);
        }
    }

    /* renamed from: com.didi.unifylogin.view.NewPhoneFragment$2 */
    static /* synthetic */ class C147222 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$unifylogin$base$net$LoginScene;

        static {
            int[] iArr = new int[LoginScene.values().length];
            $SwitchMap$com$didi$unifylogin$base$net$LoginScene = iArr;
            try {
                iArr[LoginScene.SCENE_CHANGE_PHONE_WITH_CODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 100 && i2 == -1) {
            CountryListResponse.CountryRule countryRule = (CountryListResponse.CountryRule) intent.getSerializableExtra("country");
            if (this.presenter instanceof InputNewPhonePresenter) {
                this.countrySwitchView.setCountry(countryRule);
                ((InputNewPhonePresenter) this.presenter).setNewCellCountry(countryRule);
            }
        }
    }
}
