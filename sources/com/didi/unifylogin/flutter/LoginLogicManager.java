package com.didi.unifylogin.flutter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didi.thirdpartylogin.base.ThirdPartyLoginManager;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.manager.LoginFillerFragmentManager;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.LoginActionParam;
import com.didi.unifylogin.base.net.pojo.response.ActionResponse;
import com.didi.unifylogin.base.net.pojo.response.BaseLoginSuccessResponse;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.domain.GlobalDomainCache;
import com.didi.unifylogin.entrance.OneLoginActivity;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.listener.pojo.FaceParam;
import com.didi.unifylogin.spi.CompassRequestService;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.third.LoginTypeListListener;
import com.didi.unifylogin.third.LoginTypeManager;
import com.didi.unifylogin.utils.ApolloSwitch;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.PasswordUtils;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

public class LoginLogicManager {

    /* renamed from: b */
    private static FragmentMessenger f44775b;

    /* renamed from: a */
    private final Context f44776a;

    /* renamed from: c */
    private final Logger f44777c = LoggerFactory.getLogger("LoginLogicManager");

    public static FragmentMessenger getMessenger() {
        if (f44775b == null) {
            f44775b = new FragmentMessenger().setScene(LoginScene.SCENE_LOGIN).updateOmegaScene(LoginScene.SCENE_LOGIN).setCell(LoginStore.getInstance().getPhone()).setHideEmail(LoginStore.getInstance().getHideEmail()).setCredential(LoginStore.getInstance().getCredential());
        }
        return f44775b;
    }

    public LoginLogicManager(Context context) {
        this.f44776a = context == null ? LoginStore.getContext() : context;
        getMessenger();
    }

    public void transform(LoginState loginState) {
        Intent intent = new Intent(this.f44776a, OneLoginActivity.class);
        if (!(this.f44776a instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra(OneLoginActivity.INIT_STATE, loginState);
        intent.putExtra(OneLoginActivity.INIT_MESSENGER, f44775b);
        this.f44776a.startActivity(intent);
    }

    public void setScene(LoginScene loginScene) {
        FragmentMessenger fragmentMessenger;
        if (loginScene != null && (fragmentMessenger = f44775b) != null) {
            fragmentMessenger.setScene(loginScene);
        }
    }

    public void updateOmegaScene(LoginScene loginScene) {
        FragmentMessenger fragmentMessenger;
        if (loginScene != null && (fragmentMessenger = f44775b) != null) {
            fragmentMessenger.updateOmegaScene(loginScene);
        }
    }

    public void handToken(BaseLoginSuccessResponse baseLoginSuccessResponse, MethodChannel.Result result) {
        handToken(baseLoginSuccessResponse, result, (Map) null);
    }

    public void handToken(BaseLoginSuccessResponse baseLoginSuccessResponse, final MethodChannel.Result result, final Map map) {
        LoginStore.getInstance().setUserType(baseLoginSuccessResponse.userType);
        CountryListResponse.CountryRule countryById = CountryManager.getIns().getCountryById(baseLoginSuccessResponse.countryId);
        if (baseLoginSuccessResponse.countryId == 86) {
            HashMap hashMap = new HashMap();
            hashMap.put("phone", baseLoginSuccessResponse.cell);
            OmegaSDKAdapter.trackEvent("loginResponseIs86", (Map<String, Object>) hashMap);
        }
        if (countryById != null) {
            CountryManager.getIns().setCurrentCountry(countryById);
        }
        LoginStore.getInstance().saveLoginInfo(baseLoginSuccessResponse, f44775b);
        LoginActionParam usertype = new LoginActionParam(this.f44776a, f44775b.getSceneNum()).setUsertype(LoginStore.getInstance().getUserType());
        usertype.setTicket(LoginStore.getInstance().getTemporaryToken());
        LoginModel.getFlutterNet(this.f44776a).getPostLoginAction(usertype, new LoginRpcCallbackV2<ActionResponse>() {
            public void onSuccess(RpcResponseProxy<ActionResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                ActionResponse content = rpcResponseProxy.getContent();
                if (content == null || content.errno != 0) {
                    LoginLogicManager.this.m31802a(result, (Object) Result.m31807ok());
                    return;
                }
                LoginFillerFragmentManager.setFillers(content.actions);
                String from = Result.from(content);
                Map map = map;
                if (map != null && !map.isEmpty()) {
                    try {
                        JSONObject jSONObject = new JSONObject(from);
                        for (Map.Entry entry : map.entrySet()) {
                            jSONObject.put("" + entry.getKey(), entry.getValue());
                        }
                        from = jSONObject.toString();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                LoginLogicManager.this.m31802a(result, (Object) from);
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                LoginLogicManager.this.m31802a(result, (Object) Result.m31807ok());
                iOException.printStackTrace();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31802a(MethodChannel.Result result, Object obj) {
        try {
            result.success(obj);
        } catch (Exception unused) {
        }
    }

    public void getConfig(MethodCall methodCall, MethodChannel.Result result) {
        try {
            boolean isSupportDynamicDomain = CompassRequestService.isSupportDynamicDomain(this.f44776a);
            JSONObject jSONObject = new JSONObject();
            JSONObject c = m31804c();
            CountryListResponse.CountryRule currentCountry = CountryManager.getIns().getCurrentCountry();
            if (currentCountry == null) {
                currentCountry = CountryManager.getIns().getDefCountry();
            }
            jSONObject.put("cell", f44775b.getCell());
            jSONObject.put(ParamKeys.PARAM_USER_TYPE, LoginStore.getInstance().getUserType());
            if (ListenerManager.getWhatsAppListener() != null) {
                jSONObject.put("supportWhatsAppVerificationCode", ListenerManager.getWhatsAppListener().supportWhatsAppVerificationCode() && ListenerManager.getWhatsAppListener().whatsAppInstalled());
                jSONObject.put("whatsAppInstalled", ListenerManager.getWhatsAppListener().whatsAppInstalled());
            }
            jSONObject.put("showNewWhatsAppChanelDic", m31800a());
            jSONObject.put("country", currentCountry.getJSONObj());
            jSONObject.put("haveCpsCKCondition", isSupportDynamicDomain);
            jSONObject.put("i18n", c);
            jSONObject.put("minDigit", PasswordUtils.getMinDigit());
            jSONObject.put("lawHint", LoginPreferredConfig.getLawHint());
            jSONObject.put("lawUrl", LoginPreferredConfig.getLawUrl());
            jSONObject.put("isLawDefaultChecked", m31803b());
            jSONObject.put("isHomeCanBack", LoginPreferredConfig.isHomeCanBacke());
            jSONObject.put("isOptionalEmail", LoginPreferredConfig.isOptionalEmail());
            jSONObject.put("newUserCpfIntercept", LoginPreferredConfig.isNewUserCpfIntercept());
            jSONObject.put("canSwitchCountry", LoginPreferredConfig.isCanSwitchCountry());
            result.success(jSONObject.toString());
        } catch (Exception e) {
            this.f44777c.error("getConfig error", (Throwable) e);
            result.success(Result.error());
        }
    }

    /* renamed from: a */
    private JSONObject m31800a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isShowWhatsAppNewFlag", ApolloSwitch.getInstance().isNewWhatsApp());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("text", "whatsApp");
            jSONObject2.put("channel", "whats_app");
            jSONObject.put("whatsAppDic", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m31803b() {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            java.lang.String r2 = "passport_article_autocheck"
            com.didichuxing.apollo.sdk.IToggle r2 = com.didichuxing.apollo.sdk.Apollo.getToggle(r2)     // Catch:{ Exception -> 0x0020 }
            com.didichuxing.apollo.sdk.IExperiment r2 = r2.getExperiment()     // Catch:{ Exception -> 0x0020 }
            java.lang.String r3 = "icon_type"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0020 }
            java.lang.Object r2 = r2.getParam(r3, r4)     // Catch:{ Exception -> 0x0020 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x0020 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x0020 }
            if (r2 != r0) goto L_0x0024
            r2 = 1
            goto L_0x0025
        L_0x0020:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0024:
            r2 = 0
        L_0x0025:
            if (r2 != 0) goto L_0x0039
            boolean r2 = com.didi.unifylogin.api.LoginPreferredConfig.getIsLawCbUseCache()
            if (r2 == 0) goto L_0x0038
            com.didi.unifylogin.store.LoginStore r2 = com.didi.unifylogin.store.LoginStore.getInstance()
            boolean r2 = r2.isLawChecked()
            if (r2 == 0) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.unifylogin.flutter.LoginLogicManager.m31803b():boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public JSONArray m31799a(List<String> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        boolean z = ApolloSwitch.getInstance().supportWhatsAppLogin() && ListenerManager.getWhatsAppListener() != null && ListenerManager.getWhatsAppListener().whatsAppInstalled() && list.contains("whats_app");
        if (z && ApolloSwitch.getInstance().isNewWhatsApp()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("text", "phonenum");
            jSONObject.put("channel", "phone_num");
            jSONArray.put(jSONObject);
        }
        List<AbsThirdPartyLoginBase> thirdPartyLogins = ThirdPartyLoginManager.getThirdPartyLogins();
        if (thirdPartyLogins != null) {
            for (AbsThirdPartyLoginBase next : thirdPartyLogins) {
                if (next.isSupport() && list.contains(next.getChannel())) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("text", next.getText());
                    jSONObject2.put("channel", next.getChannel());
                    jSONArray.put(jSONObject2);
                }
            }
        }
        if (z && !ApolloSwitch.getInstance().isNewWhatsApp()) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("text", "WhatsApp");
            jSONObject3.put("channel", "whats_app");
            jSONArray.put(jSONObject3);
        }
        return jSONArray;
    }

    /* renamed from: c */
    private JSONObject m31804c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("login_unify_net_error", this.f44776a.getString(R.string.login_unify_net_error));
        jSONObject.put("login_unify_input_right_email", this.f44776a.getString(R.string.login_unify_input_right_email));
        jSONObject.put("login_unify_name_hint", this.f44776a.getString(R.string.login_unify_name_hint));
        jSONObject.put("login_unify_last_name_hint", this.f44776a.getString(R.string.login_unify_last_name_hint));
        jSONObject.put("login_unify_email_hint", this.f44776a.getString(R.string.login_unify_email_hint));
        jSONObject.put("login_unify_invitation_hint", this.f44776a.getString(R.string.login_unify_invitation_hint));
        jSONObject.put("login_unify_input_info_title", this.f44776a.getString(R.string.login_unify_input_info_title));
        jSONObject.put("login_unify_next_step", this.f44776a.getString(R.string.login_unify_next_step));
        jSONObject.put("GRider_loginsdk_Number_input_IGkd", this.f44776a.getString(R.string.GRider_loginsdk_Number_input_IGkd));
        jSONObject.put("GRider_loginsdk_Start_hvEU", this.f44776a.getString(R.string.GRider_loginsdk_Start_hvEU));
        jSONObject.put("login_unify_input_login_password_title", this.f44776a.getString(R.string.login_unify_input_login_password_title));
        jSONObject.put("login_unify_forget_password", this.f44776a.getString(R.string.login_unify_forget_password));
        jSONObject.put("login_unify_input_login_password_tips", this.f44776a.getString(R.string.login_unify_set_password_tips, new Object[]{Integer.valueOf(PasswordUtils.getMinDigit())}));
        jSONObject.put("login_unify_please_input_ur_old_password", this.f44776a.getString(R.string.login_unify_please_input_ur_old_password));
        jSONObject.put("login_unify_choice_voice", this.f44776a.getString(R.string.login_unify_choice_voice));
        jSONObject.put("login_unify_choice_whatsapp", this.f44776a.getString(R.string.login_unify_choice_whatsapp));
        jSONObject.put("login_unify_choice_email_code", this.f44776a.getString(R.string.login_unify_choice_email_code));
        jSONObject.put("login_unify_switch_code_login", this.f44776a.getString(R.string.login_unify_switch_code_login));
        jSONObject.put("login_unify_search_focused_hint", this.f44776a.getString(R.string.login_unify_search_focused_hint));
        jSONObject.put("login_unify_verify_code_try_again", this.f44776a.getString(R.string.login_unify_verify_code_try_again));
        jSONObject.put("login_unify_send_sms_code_success", this.f44776a.getString(R.string.login_unify_send_sms_code_success));
        jSONObject.put("login_unify_input_verify_code", this.f44776a.getString(R.string.login_unify_input_verify_code));
        jSONObject.put("login_unify_str_captcha_refresh", this.f44776a.getString(R.string.login_unify_str_captcha_refresh));
        jSONObject.put("login_unify_str_captcha_failed", this.f44776a.getString(R.string.login_unify_str_captcha_failed));
        jSONObject.put("login_unify_captcha_title", this.f44776a.getString(R.string.login_unify_captcha_title));
        jSONObject.put("login_unify_code_send_email", this.f44776a.getString(R.string.login_unify_verify_code_send_to_email));
        jSONObject.put("login_unify_set_password_title", this.f44776a.getString(R.string.login_unify_set_password_title));
        jSONObject.put("login_unify_action_jump", this.f44776a.getString(R.string.login_unify_action_jump));
        jSONObject.put("login_unify_verify_dialog_know_button", this.f44776a.getString(R.string.login_unify_verify_dialog_know_button));
        jSONObject.put("login_unify_verify_dialog_status_exception_title", this.f44776a.getString(R.string.login_unify_verify_dialog_status_exception_title));
        return jSONObject;
    }

    public void getLoginType(MethodCall methodCall, final MethodChannel.Result result) {
        LoginTypeManager.INSTANCE.getLoginTypeList(this.f44776a, new LoginTypeListListener() {
            public void onResult(List<String> list) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("thirdPartyLogin", LoginLogicManager.this.m31799a(list));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                result.success(jSONObject.toString());
            }
        });
    }

    public void logoutAndClean(MethodCall methodCall, MethodChannel.Result result) {
        new LoginOmegaUtil(LoginOmegaUtil.LOGIN_FAIL_SW).add(LoginOmegaUtil.ISAPPERRNO, true).send();
        LoginStore.getInstance().loginOutClean();
    }

    public void getLoginInfo(MethodCall methodCall, MethodChannel.Result result) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("authAccount", LoginStore.getInstance().getPhone());
            jSONObject.put("authToken", LoginStore.getInstance().getToken());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        result.success(jSONObject.toString());
    }

    public void changeIDC(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("idc_sign");
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if (!lowerCase.equals(GlobalDomainCache.getInstance(this.f44776a).getDomainFromCache(this.f44776a))) {
                GlobalDomainCache.getInstance(this.f44776a).setDomainSuffix(this.f44776a, lowerCase);
                CompassRequestService.compassResponse(lowerCase);
            }
        }
        result.success(Result.m31807ok());
    }

    public void faceVerification(MethodCall methodCall, final MethodChannel.Result result) {
        int i;
        String str = (String) methodCall.argument("session_id");
        Integer num = (Integer) methodCall.argument("biz_code");
        f44775b.setSessionId(str);
        FaceParam faceParam = new FaceParam();
        faceParam.setAccessToken((String) methodCall.argument("access_token"));
        faceParam.setSessionId(str);
        if (num == null) {
            i = 0;
        } else {
            i = num.intValue();
        }
        faceParam.setBizCode(i);
        ListenerManager.getFaceListener().callFaceListener(faceParam, new LoginListeners.FaceCallback() {
            public void onResult(int i) {
                if (i < 0 || i >= 100) {
                    result.success(Result.error());
                    LoginOmegaUtil.trackEvent(LoginOmegaUtil.TONE_P_X_LOGIN_FACE_FAILTOAST);
                    return;
                }
                result.success(Result.m31807ok());
            }
        });
    }
}
