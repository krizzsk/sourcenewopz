package com.didi.unifylogin.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginNetErrNo;
import com.didi.unifylogin.base.net.pojo.request.SetCellParam;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.base.net.pojo.response.SetCellResponse;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.presenter.ability.IInputNewPhonePresenter;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.phone.PhoneUtils;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didi.unifylogin.view.ability.IInputNewPhoneView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.taxis99.R;

public class InputNewPhonePresenter extends LoginBasePresenter<IInputNewPhoneView> implements IInputNewPhonePresenter {

    /* renamed from: a */
    private CountryListResponse.CountryRule f44832a;

    public InputNewPhonePresenter(IInputNewPhoneView iInputNewPhoneView, Context context) {
        super(iInputNewPhoneView, context);
    }

    public void verifyPhone() {
        if (TextUtils.isEmpty(this.messenger.getCell()) || this.messenger.getCell().equals(PhoneUtils.toNormalPhone(((IInputNewPhoneView) this.view).getPhone()))) {
            ((IInputNewPhoneView) this.view).showShortError((int) R.string.login_unify_old_new_cell_consistent);
            return;
        }
        ((IInputNewPhoneView) this.view).showLoading((String) null);
        getMessenger().setNewCell(PhoneUtils.toNormalPhone(((IInputNewPhoneView) this.view).getPhone()));
        SetCellParam ticket = new SetCellParam(this.context, getSceneNum()).setCheckSnatchable(true).setCell(this.messenger.getCell()).setNewCell(this.messenger.getNewCell()).setTicket(LoginStore.getInstance().getToken());
        CountryListResponse.CountryRule countryRule = this.f44832a;
        if (countryRule != null) {
            ticket.setNewCellCountryCallingCode(countryRule.calling_code);
            getMessenger().setNewCellCountry(this.f44832a);
        }
        LoginModel.getNet(this.context).setCell(ticket, new LoginServiceCallbackV2<SetCellResponse>(this.view) {
            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
            }

            /* access modifiers changed from: protected */
            public boolean handleResponse(SetCellResponse setCellResponse, int i, String str) {
                ((IInputNewPhoneView) InputNewPhonePresenter.this.view).hideLoading();
                switch (setCellResponse.errno) {
                    case 41018:
                        InputNewPhonePresenter.this.messenger.setPromptPageData(setCellResponse.prompt);
                        InputNewPhonePresenter.this.updateOmegaScene(FragmentMessenger.getNowScene());
                        InputNewPhonePresenter.this.transform(LoginState.STATE_CONFIRM_SNATCH);
                        return true;
                    case LoginNetErrNo.ERR_NEED_NEW_CODE:
                        InputNewPhonePresenter.this.updateOmegaScene(FragmentMessenger.getNowScene());
                        InputNewPhonePresenter.this.transform(LoginState.STATE_NEW_CODE);
                        return true;
                    case 41023:
                        InputNewPhonePresenter.this.messenger.setPromptPageData(setCellResponse.prompt);
                        InputNewPhonePresenter.this.updateOmegaScene(FragmentMessenger.getNowScene());
                        InputNewPhonePresenter.this.transform(LoginState.STATE_SETCELL_ERROR);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    public void setNewCellCountry(CountryListResponse.CountryRule countryRule) {
        this.f44832a = countryRule;
    }
}
