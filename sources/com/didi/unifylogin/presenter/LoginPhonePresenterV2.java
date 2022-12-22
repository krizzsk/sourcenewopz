package com.didi.unifylogin.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.didi.unifylogin.country.CountryListActivity;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.presenter.ability.IInputPhonePresenterV2;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.ToastHelper;
import com.didi.unifylogin.utils.customview.AbsLoginTitleBar;
import com.didi.unifylogin.view.ability.IInputPhoneView;
import com.didi.unifylogin.view.ability.IInputPhoneViewV2;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginPhonePresenterV2 extends LoginPhonePresenter implements IInputPhonePresenterV2 {

    /* renamed from: a */
    private C14638a f44842a;

    /* renamed from: b */
    private IInputPhoneViewV2 f44843b;

    /* renamed from: c */
    private boolean f44844c;

    public LoginPhonePresenterV2(IInputPhoneViewV2 iInputPhoneViewV2, Context context) {
        super(iInputPhoneViewV2, context);
        this.f44843b = iInputPhoneViewV2;
    }

    public void initViewAnimatorHelper(View view, AbsLoginTitleBar absLoginTitleBar) {
        this.f44842a = new C14638a(view, absLoginTitleBar);
    }

    public void clickPhone() {
        if (!((IInputPhoneView) this.view).isAgreeLaw()) {
            ToastHelper.showAgreeLawHint(this.context, this.view);
        } else {
            this.f44842a.mo112756a();
            this.f44844c = true;
        }
        new LoginOmegaUtil(LoginOmegaUtil.PUB_IBTPASLOGIN_NUMBER_CK).send();
    }

    public void clickCountry() {
        new LoginOmegaUtil(LoginOmegaUtil.COUNTRY_CK).send();
        Intent intent = new Intent(this.context, CountryListActivity.class);
        intent.addFlags(268435456);
        this.context.startActivity(intent);
        new LoginOmegaUtil(LoginOmegaUtil.PUB_IBTPASLOGIN_COUNTRY_CK).send();
    }

    public boolean onBackPressed() {
        if (!this.f44844c) {
            return false;
        }
        this.f44842a.mo112757b();
        this.f44844c = false;
        return true;
    }

    public void clickClearPhone() {
        this.f44843b.clearPhone();
        new LoginOmegaUtil(LoginOmegaUtil.PUB_IBTPASLOGIN_DELETE_CK).send();
    }

    public void preLoginRequest() {
        ListenerManager.setPreLoginListener(new LoginListeners.IPreLoginListener() {
            public void callback(String str) {
                JSONObject optJSONObject;
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null && optJSONObject.has("image") && !TextUtils.isEmpty(optJSONObject.getString("image"))) {
                        ((IInputPhoneViewV2) LoginPhonePresenterV2.this.view).loadImage(optJSONObject.getString("image"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
