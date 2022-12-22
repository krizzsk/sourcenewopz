package com.didi.unifylogin.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didi.thirdpartylogin.base.ThirdPartyLoginListener;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.pojo.request.AuthParam;
import com.didi.unifylogin.base.net.pojo.response.AuthListResponse;
import com.didi.unifylogin.base.net.pojo.response.BaseResponse;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.presenter.ability.IThirdPartySetIPresenter;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginConstants;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didi.unifylogin.view.ability.IThirdPartySetView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.taxis99.R;

public class ThirdPartySetPresenter extends LoginBasePresenter<IThirdPartySetView> implements IThirdPartySetIPresenter {
    public ThirdPartySetPresenter(IThirdPartySetView iThirdPartySetView, Context context) {
        super(iThirdPartySetView, context);
    }

    public void bind(AbsThirdPartyLoginBase absThirdPartyLoginBase) {
        m32114a(absThirdPartyLoginBase);
    }

    public void unBind(final AbsThirdPartyLoginBase absThirdPartyLoginBase) {
        ((IThirdPartySetView) this.view).showInfoDialog(this.context.getString(R.string.login_unify_third_party_unBind_dialog_title), this.context.getString(R.string.login_unify_third_party_unBind_dialog_hide, new Object[]{absThirdPartyLoginBase.getText()}), this.context.getString(R.string.login_unify_third_party_btn_go_unBind), this.context.getString(R.string.login_unify_third_party_cancel_btn), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_SOCIALUNLINK_CONFIRM_CK, absThirdPartyLoginBase).send();
                ((IThirdPartySetView) ThirdPartySetPresenter.this.view).showLoading((String) null);
                ThirdPartySetPresenter.this.m32116a(LoginConstants.AUTH_UNBIND_METHOD, (String) null, absThirdPartyLoginBase);
            }
        }, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_SOCIALUNLINK_CANCEL_CK, absThirdPartyLoginBase).send();
            }
        });
        new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_SOCIALUNLINK_CONFIRM_SW, absThirdPartyLoginBase).send();
    }

    public void loadThirdPartys() {
        ((IThirdPartySetView) this.view).showLoading((String) null);
        LoginModel.getNet(this.context).getAuthList(new AuthParam(this.context, getSceneNum()).setTicket(LoginStore.getInstance().getToken()), new LoginServiceCallbackV2<AuthListResponse>(this.view) {
            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
            }

            /* access modifiers changed from: protected */
            public boolean handleResponse(AuthListResponse authListResponse, int i, String str) {
                if (authListResponse.errno != 0) {
                    return false;
                }
                ((IThirdPartySetView) ThirdPartySetPresenter.this.view).updateListView(authListResponse.data);
                return true;
            }
        });
    }

    /* renamed from: a */
    private void m32114a(final AbsThirdPartyLoginBase absThirdPartyLoginBase) {
        if (absThirdPartyLoginBase != null) {
            LoginLog.write(this.TAG + " - startTPLoginAndBind() channel:" + absThirdPartyLoginBase.getChannel());
            if (!absThirdPartyLoginBase.isSupport()) {
                ((IThirdPartySetView) this.view).showError(this.context.getResources().getString(R.string.login_unify_third_party_get_token_error));
                return;
            }
            ((IThirdPartySetView) this.view).showLoading((String) null);
            absThirdPartyLoginBase.startLogin(((IThirdPartySetView) this.view).getBaseActivity(), new ThirdPartyLoginListener() {
                public void onSucess(String str, String str2) {
                    ThirdPartySetPresenter.this.m32116a(LoginConstants.AUTH_BIND_METHOD, str, absThirdPartyLoginBase);
                }

                public void onFailure(Exception exc) {
                    ((IThirdPartySetView) ThirdPartySetPresenter.this.view).hideLoading();
                    ((IThirdPartySetView) ThirdPartySetPresenter.this.view).showError(ThirdPartySetPresenter.this.context.getResources().getString(R.string.login_unify_third_party_get_token_error));
                    LoginLog.write(ThirdPartySetPresenter.this.TAG + " - " + absThirdPartyLoginBase.getChannel() + "获取第三方失败" + exc.toString());
                    new LoginOmegaUtil(LoginOmegaUtil.TECH_PAX_EVENT_THIRD_PARTY_TOKEN_ERROR).add("module", absThirdPartyLoginBase.getChannel()).add("err_type", 6).add("err_msg", exc.getMessage()).send();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32116a(String str, String str2, AbsThirdPartyLoginBase absThirdPartyLoginBase) {
        LoginModel.getNet(this.context).ctrolAuth(new AuthParam(this.context, this.messenger.getSceneNum()).setAuthChannel(absThirdPartyLoginBase.getChannel()).setIdToken(str2).setTicket(LoginStore.getInstance().getToken()).setMethod(str), new LoginServiceCallbackV2<BaseResponse>(this.view) {
            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
            }

            /* access modifiers changed from: protected */
            public boolean handleResponse(BaseResponse baseResponse, int i, String str) {
                String str2;
                ((IThirdPartySetView) ThirdPartySetPresenter.this.view).hideLoading();
                if (baseResponse == null) {
                    ((IThirdPartySetView) ThirdPartySetPresenter.this.view).showError((int) R.string.login_unify_net_error);
                    return false;
                } else if (baseResponse.errno != 0) {
                    IThirdPartySetView iThirdPartySetView = (IThirdPartySetView) ThirdPartySetPresenter.this.view;
                    if (!TextUtils.isEmpty(baseResponse.error)) {
                        str2 = baseResponse.error;
                    } else {
                        str2 = ThirdPartySetPresenter.this.context.getResources().getString(R.string.login_unify_net_error);
                    }
                    iThirdPartySetView.showError(str2);
                    return false;
                } else {
                    ThirdPartySetPresenter.this.loadThirdPartys();
                    return true;
                }
            }
        });
    }
}
