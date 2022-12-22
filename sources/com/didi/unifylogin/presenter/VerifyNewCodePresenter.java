package com.didi.unifylogin.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.pojo.request.SetCellParam;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.base.net.pojo.response.SetCellResponse;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.CertificationController;
import com.didi.unifylogin.utils.LoginChoicePopUtil;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didi.unifylogin.view.ability.IVerifyCodeView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class VerifyNewCodePresenter extends BaseCodePresenter {
    public VerifyNewCodePresenter(IVerifyCodeView iVerifyCodeView, Context context) {
        super(iVerifyCodeView, context);
    }

    public void nextOperate() {
        setCell(false, true);
    }

    public void setCell(final boolean z, boolean z2) {
        ((IVerifyCodeView) this.view).showLoading((String) null);
        this.messenger.setNewCode(((IVerifyCodeView) this.view).getCode());
        SetCellParam ticket = new SetCellParam(this.context, getSceneNum()).setCheckChangeable(z2).setCell(this.messenger.getCell()).setNewCell(this.messenger.getNewCell()).setNewCode(this.messenger.getNewCode()).setNewCodeType(this.messenger.getNewCodeType()).setTicket(LoginStore.getInstance().getToken());
        if (this.messenger.getNewCellCountry() != null) {
            ticket.setNewCellCountryCallingCode(this.messenger.getNewCellCountry().calling_code);
        }
        LoginModel.getNet(this.context).setCell(ticket, new LoginServiceCallbackV2<SetCellResponse>(this.view) {
            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
            }

            /* access modifiers changed from: protected */
            public boolean handleResponse(SetCellResponse setCellResponse, int i, String str) {
                ((IVerifyCodeView) VerifyNewCodePresenter.this.view).hideLoading();
                if (z) {
                    new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_REAL_NAME_AUTH_RESUL_SW).add("errno", Integer.valueOf(setCellResponse.errno)).send();
                }
                int i2 = setCellResponse.errno;
                if (i2 == 0) {
                    LoginStore.getInstance().setAndSavePhone(VerifyNewCodePresenter.this.messenger.getNewCell());
                    if (VerifyNewCodePresenter.this.messenger.getNewCellCountry() != null) {
                        CountryManager.getIns().setCurrentCountry(VerifyNewCodePresenter.this.messenger.getNewCellCountry());
                        VerifyNewCodePresenter.this.messenger.setNewCellCountry((CountryListResponse.CountryRule) null);
                    }
                    ((IVerifyCodeView) VerifyNewCodePresenter.this.view).onFlowFinish(-1);
                    return true;
                } else if (i2 == 41000) {
                    VerifyNewCodePresenter.this.updateOmegaScene(FragmentMessenger.getNowScene());
                    VerifyNewCodePresenter.this.transform(LoginState.STATE_CODE);
                    return true;
                } else if (i2 == 41003) {
                    if (!z) {
                        CertificationController.checkFourElements(((IVerifyCodeView) VerifyNewCodePresenter.this.view).getBaseActivity(), VerifyNewCodePresenter.this.messenger.getCell());
                        new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_REAL_NAME_AUTH_SW).send();
                    }
                    return true;
                } else if (i2 != 41017) {
                    ((IVerifyCodeView) VerifyNewCodePresenter.this.view).cleanCode();
                    return false;
                } else {
                    VerifyNewCodePresenter.this.m32161a(TextUtils.isEmpty(setCellResponse.text) ? setCellResponse.error : setCellResponse.text);
                    return true;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32161a(String str) {
        ((IVerifyCodeView) this.view).showInfoDialog((String) null, str, this.context.getString(R.string.login_unify_dialog_change_btn), this.context.getString(R.string.login_unify_str_cancel_btn), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                VerifyNewCodePresenter.this.setCell(false, false);
            }
        }, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ((IVerifyCodeView) VerifyNewCodePresenter.this.view).cleanCode();
            }
        });
    }

    public List<LoginChoicePopUtil.ChoiceItem> getChoices() {
        if (this.choiceItems == null) {
            this.choiceItems = new ArrayList();
            if (this.messenger.isVoiceSupport()) {
                this.choiceItems.add(new LoginChoicePopUtil.ChoiceItem(1, this.context.getString(R.string.login_unify_choice_voice)));
            }
        }
        return this.choiceItems;
    }

    public String getPhone() {
        return this.messenger.getNewCell();
    }

    public int getCodeType() {
        return this.messenger.getNewCodeType();
    }

    public void setCodeType(int i) {
        this.messenger.setNewCodeType(i);
    }
}
