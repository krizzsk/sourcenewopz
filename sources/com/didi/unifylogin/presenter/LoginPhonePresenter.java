package com.didi.unifylogin.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didi.thirdpartylogin.base.ThirdPartyLoginListener;
import com.didi.unifylogin.api.LoginActionApi;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.base.manager.LoginFillerFragmentManager;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginNet;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.AuthParam;
import com.didi.unifylogin.base.net.pojo.request.GateKeeperParam;
import com.didi.unifylogin.base.net.pojo.request.LoginActionParam;
import com.didi.unifylogin.base.net.pojo.request.RegByKeyParam;
import com.didi.unifylogin.base.net.pojo.response.ActionResponse;
import com.didi.unifylogin.base.net.pojo.response.AuthResponse;
import com.didi.unifylogin.base.net.pojo.response.BaseLoginSuccessResponse;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.base.net.pojo.response.GateKeeperResponse;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.base.view.ability.ILoginBaseFragment;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.domain.CompassService;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.presenter.ability.IInputPhonePresenter;
import com.didi.unifylogin.spi.CompassRequestService;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.OmegaUtils;
import com.didi.unifylogin.utils.ToastHelper;
import com.didi.unifylogin.utils.UiUtils;
import com.didi.unifylogin.utils.customview.CommonBottomDialog;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didi.unifylogin.view.ability.IInputPhoneView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginPhonePresenter extends LoginBasePresenter<IInputPhoneView> implements CompassService.CompassCheckCondition, CompassService.IBizProcessor, CompassService.PopupShowHandler, IInputPhonePresenter {

    /* renamed from: a */
    private static final String f44839a = "LoginPhonePresenter - ";

    /* renamed from: b */
    private final boolean f44840b;

    /* renamed from: c */
    private final String f44841c;

    public LoginPhonePresenter(IInputPhoneView iInputPhoneView, Context context, boolean z, String str) {
        super(iInputPhoneView, context);
        this.f44840b = z;
        this.f44841c = str;
    }

    public LoginPhonePresenter(IInputPhoneView iInputPhoneView, Context context) {
        this(iInputPhoneView, context, false, (String) null);
    }

    public void goRegByKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((IInputPhoneView) this.view).showLoading((String) null);
            LoginModel.getNet(this.context).regByKey(new RegByKeyParam(this.context, getSceneNum()).setRegKey(str), new LoginRpcCallbackV2<BaseLoginSuccessResponse>() {
                public void onSuccess(RpcResponseProxy<BaseLoginSuccessResponse> rpcResponseProxy) {
                    String str;
                    super.onSuccess(rpcResponseProxy);
                    BaseLoginSuccessResponse content = rpcResponseProxy.getContent();
                    if (content == null) {
                        ((IInputPhoneView) LoginPhonePresenter.this.view).hideLoading();
                        ((IInputPhoneView) LoginPhonePresenter.this.view).showError(LoginPhonePresenter.this.context.getResources().getString(R.string.login_unify_net_error));
                        return;
                    }
                    LoginOmegaUtil add = new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LOGIN_CODE_CHECK).add("errno", Integer.valueOf(content.errno));
                    if (content.uid > 0) {
                        add.add("uid", Long.valueOf(content.uid));
                    }
                    add.send();
                    int i = content.errno;
                    if (i == 0) {
                        LoginPhonePresenter.this.handToken(content);
                    } else if (i == 41012) {
                        ((IInputPhoneView) LoginPhonePresenter.this.view).hideLoading();
                        LoginPhonePresenter.this.updateOmegaScene(FragmentMessenger.getNowScene());
                        LoginPhonePresenter.this.transform(LoginState.STATE_VERIFY_EMAIL);
                    } else if (i != 41015) {
                        ((IInputPhoneView) LoginPhonePresenter.this.view).hideLoading();
                        IInputPhoneView iInputPhoneView = (IInputPhoneView) LoginPhonePresenter.this.view;
                        if (!TextUtils.isEmpty(content.error)) {
                            str = content.error;
                        } else {
                            str = LoginPhonePresenter.this.context.getResources().getString(R.string.login_unify_net_error);
                        }
                        iInputPhoneView.showError(str);
                        new LoginOmegaUtil(LoginOmegaUtil.LOGIN_FAIL_SW).add("errno", Integer.valueOf(content.errno)).send();
                    } else {
                        ((IInputPhoneView) LoginPhonePresenter.this.view).hideLoading();
                    }
                }

                public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                    super.onFailure(rpcRequest, iOException);
                    ((IInputPhoneView) LoginPhonePresenter.this.view).hideLoading();
                    ((IInputPhoneView) LoginPhonePresenter.this.view).showError((int) R.string.login_unify_net_error);
                }
            });
        }
    }

    public void handToken(BaseLoginSuccessResponse baseLoginSuccessResponse) {
        CountryListResponse.CountryRule countryById = CountryManager.getIns().getCountryById(baseLoginSuccessResponse.countryId);
        if (baseLoginSuccessResponse.countryId == 86) {
            HashMap hashMap = new HashMap();
            hashMap.put("phone", baseLoginSuccessResponse.cell);
            OmegaSDKAdapter.trackEvent("loginResponseIs86", (Map<String, Object>) hashMap);
        }
        if (countryById != null) {
            CountryManager.getIns().setCurrentCountry(countryById);
        }
        LoginStore.getInstance().saveLoginInfo(baseLoginSuccessResponse, this.messenger);
        if (!((IInputPhoneView) this.view).isLoginFlow()) {
            ((IInputPhoneView) this.view).onFlowFinish(-1);
            return;
        }
        ((IInputPhoneView) this.view).showLoading((String) null);
        LoginActionParam usertype = new LoginActionParam(this.context, getSceneNum()).setUsertype(baseLoginSuccessResponse.userType);
        usertype.setTicket(LoginStore.getInstance().getTemporaryToken());
        LoginModel.getNet(this.context).getPostLoginAction(usertype, new LoginRpcCallbackV2<ActionResponse>() {
            public void onSuccess(RpcResponseProxy<ActionResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                ActionResponse content = rpcResponseProxy.getContent();
                if (content == null || content.errno != 0) {
                    ((IInputPhoneView) LoginPhonePresenter.this.view).onFlowFinish(-1);
                    return;
                }
                LoginFillerFragmentManager.setFillers(content.actions);
                LoginPhonePresenter.this.goFillInfo();
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                ((IInputPhoneView) LoginPhonePresenter.this.view).onFlowFinish(-1);
                iOException.printStackTrace();
            }
        });
    }

    public void nextOperate() {
        if (!((IInputPhoneView) this.view).isAgreeLaw()) {
            ToastHelper.showAgreeLawHint(this.context, this.view);
        } else if (LoginStore.getInstance().getAppId() != 70000 || !TextUtils.isEmpty(LoginStore.getInstance().getPhone()) || !CountryManager.getIns().getCurrentCountryCode().equals("+7")) {
            m32038a();
        } else {
            CommonBottomDialog commonBottomDialog = new CommonBottomDialog(((IInputPhoneView) this.view).getBaseActivity());
            commonBottomDialog.setCloseDialogIconVisible();
            commonBottomDialog.setCancelable(true);
            commonBottomDialog.show("", this.context.getResources().getString(R.string.Others_up_Make_Sure_JZCB), this.context.getResources().getString(R.string.Others_up_OK_dGhr), this.context.getResources().getString(R.string.Others_up_Cancel_AHDU), (View) null, new CommonBottomDialog.BottomDialogInterface() {
                public void onConfirmClicked(CommonBottomDialog commonBottomDialog) {
                    commonBottomDialog.dismiss();
                    LoginPhonePresenter.this.m32038a();
                }

                public void onCancelClicked(CommonBottomDialog commonBottomDialog) {
                    commonBottomDialog.dismiss();
                }

                public void onCloseDialog(CommonBottomDialog commonBottomDialog) {
                    super.onCloseDialog(commonBottomDialog);
                    commonBottomDialog.dismiss();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32038a() {
        ((IInputPhoneView) this.view).showLoading((String) null);
        this.messenger.setCell(((IInputPhoneView) this.view).getPhone());
        LoginStore.getInstance().setAndSavePhone(((IInputPhoneView) this.view).getPhone());
        HashMap hashMap = new HashMap();
        hashMap.put("cell_phone", this.messenger.getCell());
        hashMap.put("invoke_scene", "user_login");
        new CompassService().setCompassCheckCond(this).setPopupHandler(this).registeProcessor(this).getCompassJudge(this.context, hashMap);
    }

    /* renamed from: b */
    private void m32041b() {
        ((IInputPhoneView) this.view).showLoading((String) null);
        LoginModel.getNet(this.context).gatekeeper(new GateKeeperParam(this.context, getSceneNum()).setCell(this.messenger.getCell()).setForceCodeLogin(this.f44840b).setAuthChannel(this.f44841c), new LoginRpcCallbackV2<GateKeeperResponse>() {
            public void onSuccess(RpcResponseProxy<GateKeeperResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                GateKeeperResponse content = rpcResponseProxy.getContent();
                ((IInputPhoneView) LoginPhonePresenter.this.view).hideLoading();
                if (content == null) {
                    ((IInputPhoneView) LoginPhonePresenter.this.view).showError(LoginPhonePresenter.this.context.getResources().getString(R.string.login_unify_net_error));
                } else if (content.errno != 0) {
                    new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LOGIN_PHONE_CHECK).add("errno", Integer.valueOf(content.errno)).send();
                    ((IInputPhoneView) LoginPhonePresenter.this.view).showError(!TextUtils.isEmpty(content.error) ? content.error : LoginPhonePresenter.this.context.getResources().getString(R.string.login_unify_net_error));
                } else {
                    new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LOGIN_USERENTER).send();
                    new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LOGIN_CONFM_USERTYPE_CK).send();
                    if (content.roles == null) {
                        ((IInputPhoneView) LoginPhonePresenter.this.view).showError(!TextUtils.isEmpty(content.error) ? content.error : LoginPhonePresenter.this.context.getResources().getString(R.string.login_unify_net_error));
                        return;
                    }
                    LoginStore.getInstance().setUserType(content.usertype);
                    LoginPhonePresenter.this.messenger.setHideEmail(content.email);
                    LoginPhonePresenter.this.messenger.setCredential(content.credential);
                    LoginPhonePresenter.this.messenger.setFaceDes(content.faceDes);
                    saveActionOfSeven(content.actions);
                    if (OneLoginFacade.getStore().isNewUser()) {
                        new LoginOmegaUtil(LoginOmegaUtil.CONFM_NEWUSER_CK).send();
                    }
                    if (content.roles.size() > 1) {
                        LoginStore.getInstance().setAndSaveDoubleId(true);
                        ((IInputPhoneView) LoginPhonePresenter.this.view).selectDoubleIdentity(content.roles);
                        return;
                    }
                    LoginStore.getInstance().setAndSaveDoubleId(false);
                    LoginStore.getInstance().setAndSaveRole(content.roles.get(0).f44704id);
                    LoginPhonePresenter.this.goLogin(content.roles.get(0).login_type);
                }
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                ((IInputPhoneView) LoginPhonePresenter.this.view).hideLoading();
                ((IInputPhoneView) LoginPhonePresenter.this.view).showError(LoginPhonePresenter.this.context.getResources().getString(R.string.login_unify_net_error));
            }

            /* access modifiers changed from: package-private */
            public void saveActionOfSeven(List<GateKeeperResponse.Action> list) {
                if (list != null && list.size() > 0) {
                    for (GateKeeperResponse.Action action : list) {
                        if (action.action == 7) {
                            LoginStore.getInstance().setFinishInputInfo(false);
                            LoginLog.write("saveActionOfSeven: need");
                            return;
                        }
                    }
                }
                LoginStore.getInstance().setFinishInputInfo(true);
            }
        });
    }

    public void goLogin(int i) {
        if (i == 1) {
            setScene(LoginScene.SCENE_CODE_LOGIN);
            updateOmegaScene(LoginScene.SCENE_LOGIN);
            transform(LoginState.STATE_CODE);
        } else if (i == 2) {
            setScene(LoginScene.SCENE_PWD_LOGIN);
            updateOmegaScene(LoginScene.SCENE_PWD_LOGIN);
            transform(LoginState.STATE_PASSWORD);
        } else if (i == 4 || i == 8) {
            setScene(LoginScene.SCENE_FACE_LOGIN);
            updateOmegaScene(LoginScene.SCENE_FACE_LOGIN);
            transform(LoginState.STATE_PRE_FACE);
        } else {
            setScene(LoginScene.SCENE_CODE_LOGIN);
            updateOmegaScene(LoginScene.SCENE_CODE_LOGIN);
            transform(LoginState.STATE_CODE);
        }
    }

    public void getThirdPartyToken(AbsThirdPartyLoginBase absThirdPartyLoginBase) {
        if (absThirdPartyLoginBase != null) {
            ((IInputPhoneView) this.view).showLoading((String) null);
            m32039a(absThirdPartyLoginBase);
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    ((IInputPhoneView) LoginPhonePresenter.this.view).hideLoading();
                }
            }, 5000);
        }
    }

    /* renamed from: a */
    private void m32039a(final AbsThirdPartyLoginBase absThirdPartyLoginBase) {
        absThirdPartyLoginBase.startLogin(((IInputPhoneView) this.view).getBaseActivity(), new ThirdPartyLoginListener() {
            public void onSucess(String str, String str2) {
                LoginLog.write("LoginPhonePresenter - getThirdPartyToken() onSuccess");
                String reasonOfFirstInstall = ListenerManager.getFirstInstallListener() != null ? ListenerManager.getFirstInstallListener().reasonOfFirstInstall() : null;
                AuthParam idToken = new AuthParam(LoginPhonePresenter.this.context, LoginPhonePresenter.this.getSceneNum()).setAuthChannel(absThirdPartyLoginBase.getChannel()).setIdToken(str);
                if (TextUtils.isEmpty(reasonOfFirstInstall)) {
                    reasonOfFirstInstall = LoginActionApi.loginReason;
                }
                AuthParam signReason = idToken.setSignReason(reasonOfFirstInstall);
                LoginNet net2 = LoginModel.getNet(LoginPhonePresenter.this.context);
                LoginPhonePresenter loginPhonePresenter = LoginPhonePresenter.this;
                net2.signByAuth(signReason, new AuthLoginServiceCallback(loginPhonePresenter.view, str, absThirdPartyLoginBase.getChannel()));
            }

            public void onFailure(Exception exc) {
                ((IInputPhoneView) LoginPhonePresenter.this.view).hideLoading();
                LoginLog.write("LoginPhonePresenter - getThirdPartyToken() onFailure :" + exc.toString());
                ((IInputPhoneView) LoginPhonePresenter.this.view).showError(LoginPhonePresenter.this.context.getResources().getString(R.string.login_unify_third_party_get_token_error));
                new LoginOmegaUtil(LoginOmegaUtil.TECH_PAX_EVENT_THIRD_PARTY_TOKEN_ERROR).add("module", absThirdPartyLoginBase.getChannel()).add("err_type", 6).add("err_msg", exc.getMessage()).send();
            }
        });
    }

    public void go2InputCPF(Context context) {
        CommonBottomDialog commonBottomDialog = new CommonBottomDialog(((IInputPhoneView) this.view).getBaseActivity());
        commonBottomDialog.setCloseDialogIconVisible();
        commonBottomDialog.setCancelable(false);
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.confirm_change_phone_img);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, UiUtils.dip2px(context, 81.0f));
        layoutParams.gravity = 1;
        imageView.setLayoutParams(layoutParams);
        commonBottomDialog.show(context.getResources().getString(R.string.GDriver_phonenumber_Modify_gCSK), context.getResources().getString(R.string.GDriver_phonenumber_The_information_TJJi), context.getResources().getString(R.string.GDriver_phonenumber_going_to_rvAr), imageView, new CommonBottomDialog.BottomDialogInterface() {
            public void onConfirmClicked(CommonBottomDialog commonBottomDialog) {
                commonBottomDialog.dismiss();
                OmegaUtils.ibt_gd_brchangephone_popup_ck(1);
                LoginPhonePresenter.this.transform(LoginState.STATE_LOGIN_CHANGE_PHONE_INPUT_CPF);
            }

            public void onCancelClicked(CommonBottomDialog commonBottomDialog) {
                commonBottomDialog.dismiss();
            }

            public void onCloseDialog(CommonBottomDialog commonBottomDialog) {
                super.onCloseDialog(commonBottomDialog);
                commonBottomDialog.dismiss();
                OmegaUtils.ibt_gd_brchangephone_popup_ck(0);
            }
        });
        OmegaUtils.ibt_gd_brchangephone_login_ck();
        OmegaUtils.ibt_gd_brchangephone_popup_sw();
    }

    public void retrieveAccount() {
        setScene(LoginScene.SCENE_RETRIEVE);
        updateOmegaScene(LoginScene.SCENE_RETRIEVE);
        transform(LoginState.STATE_PRE_RETRIEVE);
    }

    public void onShowPopup(SimplePopupBase simplePopupBase) {
        if (((IInputPhoneView) this.view).getFragment() != null && ((IInputPhoneView) this.view).getFragment().getFragmentManager() != null) {
            simplePopupBase.show(((IInputPhoneView) this.view).getFragment().getFragmentManager(), "");
            ((IInputPhoneView) this.view).hideLoading();
        }
    }

    public void onConfirm() {
        m32041b();
    }

    public void onCancel() {
        m32041b();
    }

    public void processBiz() {
        m32041b();
    }

    public boolean haveCpsCKCondition() {
        return CompassRequestService.isSupportDynamicDomain(this.context);
    }

    class AuthLoginServiceCallback extends LoginServiceCallbackV2<AuthResponse> {
        private final String channel;
        private final String idToken;

        public AuthLoginServiceCallback(ILoginBaseFragment iLoginBaseFragment, String str, String str2) {
            super(iLoginBaseFragment, false);
            this.idToken = str;
            this.channel = str2;
        }

        /* access modifiers changed from: protected */
        public boolean handleResponse(AuthResponse authResponse, int i, String str) {
            LoginPhonePresenter.this.messenger.setChannel(this.channel);
            LoginPhonePresenter.this.setScene(LoginScene.SCENE_THIRD_LOGIN);
            int i2 = authResponse.errno;
            if (i2 == 0) {
                LoginPhonePresenter.this.updateOmegaScene(LoginScene.SCENE_THIRD_LOGIN);
                new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LOGIN_USERENTER).send();
                if (!TextUtils.isEmpty(authResponse.email)) {
                    LoginPhonePresenter.this.messenger.setHideEmail(authResponse.email);
                }
                if (!TextUtils.isEmpty(authResponse.credential)) {
                    LoginPhonePresenter.this.messenger.setCredential(authResponse.credential);
                }
                LoginPhonePresenter.this.messenger.setCell(authResponse.cell);
                LoginStore.getInstance().setUserType(authResponse.userType);
                LoginPhonePresenter.this.handToken(authResponse);
                return true;
            } else if (i2 != 41011) {
                ((IInputPhoneView) LoginPhonePresenter.this.view).hideLoading();
                String str2 = authResponse.error;
                if (authResponse.errno != -1) {
                    i = authResponse.errno;
                }
                LoginOmegaUtil.trackLoginErrorEvent(2, str2, i, str, "signByAuth", this.channel);
                return false;
            } else {
                ((IInputPhoneView) LoginPhonePresenter.this.view).hideLoading();
                LoginPhonePresenter.this.messenger.setAuthInfo(authResponse.data);
                LoginPhonePresenter.this.messenger.setIdtoken(this.idToken);
                LoginPhonePresenter.this.updateOmegaScene(LoginScene.SCENE_THIRD_LOGIN);
                LoginPhonePresenter.this.transform(LoginState.STATE_BIND_THIRD_PHONE);
                return true;
            }
        }

        /* access modifiers changed from: protected */
        public void handleError(RpcRequest rpcRequest) {
            LoginOmegaUtil.trackLoginErrorEvent(0, (String) null, -1, "", "signByAuth", this.channel);
        }
    }
}
