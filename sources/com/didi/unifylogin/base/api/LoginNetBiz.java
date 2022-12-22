package com.didi.unifylogin.base.api;

import android.content.Context;
import com.didi.unifylogin.base.net.LoginNet;
import com.didi.unifylogin.base.net.LoginUrlProvider;
import com.didi.unifylogin.base.net.pojo.request.AuthParam;
import com.didi.unifylogin.base.net.pojo.request.BaseParam;
import com.didi.unifylogin.base.net.pojo.request.ChangeCellByIdCardParam;
import com.didi.unifylogin.base.net.pojo.request.CodeMtParam;
import com.didi.unifylogin.base.net.pojo.request.ComboJudgeParam;
import com.didi.unifylogin.base.net.pojo.request.CountryRequseParam;
import com.didi.unifylogin.base.net.pojo.request.DeleteAccountParam;
import com.didi.unifylogin.base.net.pojo.request.DeleteUserParam;
import com.didi.unifylogin.base.net.pojo.request.ForgetPasswordParam;
import com.didi.unifylogin.base.net.pojo.request.GateKeeperParam;
import com.didi.unifylogin.base.net.pojo.request.GetCaptchaParam;
import com.didi.unifylogin.base.net.pojo.request.GetDeleteAccountManualParam;
import com.didi.unifylogin.base.net.pojo.request.GetIdentityParam;
import com.didi.unifylogin.base.net.pojo.request.ListDeleteAccountReasonsParam;
import com.didi.unifylogin.base.net.pojo.request.LoginActionParam;
import com.didi.unifylogin.base.net.pojo.request.LoginTypeParam;
import com.didi.unifylogin.base.net.pojo.request.NewUserAppealParam;
import com.didi.unifylogin.base.net.pojo.request.RefreshTicketParam;
import com.didi.unifylogin.base.net.pojo.request.RegByKeyParam;
import com.didi.unifylogin.base.net.pojo.request.ResetEmailParam;
import com.didi.unifylogin.base.net.pojo.request.ResetPasswordParam;
import com.didi.unifylogin.base.net.pojo.request.SetCellParam;
import com.didi.unifylogin.base.net.pojo.request.SetEmailParam;
import com.didi.unifylogin.base.net.pojo.request.SetPasswordParam;
import com.didi.unifylogin.base.net.pojo.request.SetPasswordParamByEmail;
import com.didi.unifylogin.base.net.pojo.request.SignInByCodeParam;
import com.didi.unifylogin.base.net.pojo.request.SignInByFaceParam;
import com.didi.unifylogin.base.net.pojo.request.SignInByPasswordParam;
import com.didi.unifylogin.base.net.pojo.request.SignInByWhatsAppKeyParam;
import com.didi.unifylogin.base.net.pojo.request.SignOffParam;
import com.didi.unifylogin.base.net.pojo.request.SimpleParam;
import com.didi.unifylogin.base.net.pojo.request.VerifyBankAccountParam;
import com.didi.unifylogin.base.net.pojo.request.VerifyCaptchaParam;
import com.didi.unifylogin.base.net.pojo.request.VerifyCodeParam;
import com.didi.unifylogin.base.net.pojo.request.VerifyInfoParam;
import com.didi.unifylogin.base.net.pojo.request.VerifyPasswordParam;
import com.didi.unifylogin.base.net.pojo.request.VerifyPersonInfoParam;
import com.didi.unifylogin.base.net.pojo.response.ActionResponse;
import com.didi.unifylogin.base.net.pojo.response.AuthListResponse;
import com.didi.unifylogin.base.net.pojo.response.AuthResponse;
import com.didi.unifylogin.base.net.pojo.response.BaseLoginSuccessResponse;
import com.didi.unifylogin.base.net.pojo.response.BaseResponse;
import com.didi.unifylogin.base.net.pojo.response.ChangeCellResponse;
import com.didi.unifylogin.base.net.pojo.response.CheckPwdResponse;
import com.didi.unifylogin.base.net.pojo.response.CodeMtResponse;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.base.net.pojo.response.DeleteAccountResponse;
import com.didi.unifylogin.base.net.pojo.response.DeleteUserResponse;
import com.didi.unifylogin.base.net.pojo.response.GateKeeperResponse;
import com.didi.unifylogin.base.net.pojo.response.GetCaptchaResponse;
import com.didi.unifylogin.base.net.pojo.response.GetDeleteAccountManualResponse;
import com.didi.unifylogin.base.net.pojo.response.GetEmailInfoResponse;
import com.didi.unifylogin.base.net.pojo.response.GetWhatsAppKeyResponse;
import com.didi.unifylogin.base.net.pojo.response.IdentityStatusResponse;
import com.didi.unifylogin.base.net.pojo.response.JudgeResponse;
import com.didi.unifylogin.base.net.pojo.response.ListDeleteAccountReasonsResponse;
import com.didi.unifylogin.base.net.pojo.response.LoginPageAbTestResponse;
import com.didi.unifylogin.base.net.pojo.response.LoginTypeResponse;
import com.didi.unifylogin.base.net.pojo.response.NewUserAppealResponse;
import com.didi.unifylogin.base.net.pojo.response.RefreshTicketResponse;
import com.didi.unifylogin.base.net.pojo.response.SetCellResponse;
import com.didi.unifylogin.base.net.pojo.response.SetEmailResponse;
import com.didi.unifylogin.base.net.pojo.response.SignInByCodeResponse;
import com.didi.unifylogin.base.net.pojo.response.SignInByFaceResponse;
import com.didi.unifylogin.base.net.pojo.response.SignInByPasswordResponse;
import com.didi.unifylogin.base.net.pojo.response.VerifyBankAccountResponse;
import com.didi.unifylogin.base.net.pojo.response.VerifyCodeResponse;
import com.didi.unifylogin.base.net.pojo.response.VerifyInfoResponse;
import com.didi.unifylogin.base.net.pojo.response.VerifyPersonInfoResponse;
import com.didi.unifylogin.base.net.pojo.response.WhatsAppLoginSuccessResponse;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.util.Map;

public class LoginNetBiz implements LoginNet {

    /* renamed from: a */
    private Context f44677a;

    /* renamed from: b */
    private LoginNet f44678b;

    public LoginNetBiz(Context context) {
        this.f44677a = context.getApplicationContext();
        this.f44678b = (LoginNet) new RpcServiceFactory(context).newRpcService(LoginNet.class, LoginUrlProvider.getInstance().getPassportBaseUrl());
    }

    public void getCountryList(CountryRequseParam countryRequseParam, RpcService.CallbackV2<CountryListResponse> callbackV2) {
        this.f44678b.getCountryList(countryRequseParam, callbackV2);
    }

    public void gatekeeper(GateKeeperParam gateKeeperParam, RpcService.CallbackV2<GateKeeperResponse> callbackV2) {
        this.f44678b.gatekeeper(gateKeeperParam, callbackV2);
    }

    public void codeMt(CodeMtParam codeMtParam, RpcService.CallbackV2<CodeMtResponse> callbackV2) {
        this.f44678b.codeMt(codeMtParam, callbackV2);
    }

    public void verifyCode(VerifyCodeParam verifyCodeParam, RpcService.CallbackV2<VerifyCodeResponse> callbackV2) {
        this.f44678b.verifyCode(verifyCodeParam, callbackV2);
    }

    public void signInByCode(SignInByCodeParam signInByCodeParam, RpcService.CallbackV2<SignInByCodeResponse> callbackV2) {
        this.f44678b.signInByCode(signInByCodeParam, callbackV2);
    }

    public void getVerifyInfo(VerifyInfoParam verifyInfoParam, RpcService.CallbackV2<VerifyInfoResponse> callbackV2) {
        this.f44678b.getVerifyInfo(verifyInfoParam, callbackV2);
    }

    public void verifyPersonInfo(VerifyPersonInfoParam verifyPersonInfoParam, RpcService.CallbackV2<VerifyPersonInfoResponse> callbackV2) {
        this.f44678b.verifyPersonInfo(verifyPersonInfoParam, callbackV2);
    }

    public void verifyBankAccount(VerifyBankAccountParam verifyBankAccountParam, RpcService.CallbackV2<VerifyBankAccountResponse> callbackV2) {
        this.f44678b.verifyBankAccount(verifyBankAccountParam, callbackV2);
    }

    public void newUserAppeal(NewUserAppealParam newUserAppealParam, RpcService.CallbackV2<NewUserAppealResponse> callbackV2) {
        this.f44678b.newUserAppeal(newUserAppealParam, callbackV2);
    }

    public void signInByPassword(SignInByPasswordParam signInByPasswordParam, RpcService.CallbackV2<SignInByPasswordResponse> callbackV2) {
        this.f44678b.signInByPassword(signInByPasswordParam, callbackV2);
    }

    public void signOff(SignOffParam signOffParam, RpcService.CallbackV2<BaseResponse> callbackV2) {
        this.f44678b.signOff(signOffParam, callbackV2);
    }

    public void validate(Map<String, String> map, RpcService.CallbackV2<BaseResponse> callbackV2) {
        this.f44678b.validate(map, callbackV2);
    }

    public void getEmailInfo(SimpleParam simpleParam, RpcService.CallbackV2<GetEmailInfoResponse> callbackV2) {
        this.f44678b.getEmailInfo(simpleParam, callbackV2);
    }

    public void activateEmail(SimpleParam simpleParam, RpcService.CallbackV2<BaseResponse> callbackV2) {
        this.f44678b.activateEmail(simpleParam, callbackV2);
    }

    public void resetEmail(ResetEmailParam resetEmailParam, RpcService.CallbackV2<SetEmailResponse> callbackV2) {
        this.f44678b.resetEmail(resetEmailParam, callbackV2);
    }

    public void uploadLocation(Map<String, Object> map, RpcService.CallbackV2<BaseResponse> callbackV2) {
        this.f44678b.uploadLocation(map, callbackV2);
    }

    public void signInByCell(AuthParam authParam, RpcService.CallbackV2<AuthResponse> callbackV2) {
        this.f44678b.signInByCell(authParam, callbackV2);
    }

    public void checkPassword(SimpleParam simpleParam, RpcService.CallbackV2<CheckPwdResponse> callbackV2) {
        this.f44678b.checkPassword(simpleParam, callbackV2);
    }

    public void getPostLoginAction(LoginActionParam loginActionParam, RpcService.CallbackV2<ActionResponse> callbackV2) {
        this.f44678b.getPostLoginAction(loginActionParam, callbackV2);
    }

    public void getUserIdentityStatus(SimpleParam simpleParam, RpcService.CallbackV2<IdentityStatusResponse> callbackV2) {
        this.f44678b.getUserIdentityStatus(simpleParam, callbackV2);
    }

    public void signInByFace(SignInByFaceParam signInByFaceParam, RpcService.CallbackV2<SignInByFaceResponse> callbackV2) {
        this.f44678b.signInByFace(signInByFaceParam, callbackV2);
    }

    public void compassJudge(ComboJudgeParam comboJudgeParam, RpcService.CallbackV2<JudgeResponse> callbackV2) {
        this.f44678b.compassJudge(comboJudgeParam, callbackV2);
    }

    public void ctrolAuth(AuthParam authParam, RpcService.CallbackV2<BaseResponse> callbackV2) {
        this.f44678b.ctrolAuth(authParam, callbackV2);
    }

    public void signByAuth(AuthParam authParam, RpcService.CallbackV2<AuthResponse> callbackV2) {
        this.f44678b.signByAuth(authParam, callbackV2);
    }

    public void getAuthList(AuthParam authParam, RpcService.CallbackV2<AuthListResponse> callbackV2) {
        this.f44678b.getAuthList(authParam, callbackV2);
    }

    public void refreshTicket(RefreshTicketParam refreshTicketParam, RpcService.CallbackV2<RefreshTicketResponse> callbackV2) {
        this.f44678b.refreshTicket(refreshTicketParam, callbackV2);
    }

    public void setEmail(SetEmailParam setEmailParam, RpcService.CallbackV2<SetEmailResponse> callbackV2) {
        this.f44678b.setEmail(setEmailParam, callbackV2);
    }

    public void setPassword(SetPasswordParam setPasswordParam, RpcService.CallbackV2<BaseResponse> callbackV2) {
        this.f44678b.setPassword(setPasswordParam, callbackV2);
    }

    public void resetPassword(ResetPasswordParam resetPasswordParam, RpcService.CallbackV2<BaseResponse> callbackV2) {
        this.f44678b.resetPassword(resetPasswordParam, callbackV2);
    }

    public void forgetPassword(ForgetPasswordParam forgetPasswordParam, RpcService.CallbackV2<BaseLoginSuccessResponse> callbackV2) {
        this.f44678b.forgetPassword(forgetPasswordParam, callbackV2);
    }

    public void changeCellByIdCard(ChangeCellByIdCardParam changeCellByIdCardParam, RpcService.CallbackV2<ChangeCellResponse> callbackV2) {
        this.f44678b.changeCellByIdCard(changeCellByIdCardParam, callbackV2);
    }

    public void deleteAccount(DeleteAccountParam deleteAccountParam, RpcService.CallbackV2<DeleteAccountResponse> callbackV2) {
        this.f44678b.deleteAccount(deleteAccountParam, callbackV2);
    }

    public void getDeleteAccountManual(GetDeleteAccountManualParam getDeleteAccountManualParam, RpcService.CallbackV2<GetDeleteAccountManualResponse> callbackV2) {
        this.f44678b.getDeleteAccountManual(getDeleteAccountManualParam, callbackV2);
    }

    public void listDeleteAccountReasons(ListDeleteAccountReasonsParam listDeleteAccountReasonsParam, RpcService.CallbackV2<ListDeleteAccountReasonsResponse> callbackV2) {
        this.f44678b.listDeleteAccountReasons(listDeleteAccountReasonsParam, callbackV2);
    }

    public void deleteUser(DeleteUserParam deleteUserParam, RpcService.CallbackV2<DeleteUserResponse> callbackV2) {
        this.f44678b.deleteUser(deleteUserParam, callbackV2);
    }

    public void setCell(SetCellParam setCellParam, RpcService.CallbackV2<SetCellResponse> callbackV2) {
        this.f44678b.setCell(setCellParam, callbackV2);
    }

    public void getIdentity(GetIdentityParam getIdentityParam, RpcService.CallbackV2<BaseResponse> callbackV2) {
        this.f44678b.getIdentity(getIdentityParam, callbackV2);
    }

    public void getCaptcha(GetCaptchaParam getCaptchaParam, RpcService.CallbackV2<GetCaptchaResponse> callbackV2) {
        this.f44678b.getCaptcha(getCaptchaParam, callbackV2);
    }

    public void verifyCaptcha(VerifyCaptchaParam verifyCaptchaParam, RpcService.CallbackV2<BaseResponse> callbackV2) {
        this.f44678b.verifyCaptcha(verifyCaptchaParam, callbackV2);
    }

    public void verifyPassword(VerifyPasswordParam verifyPasswordParam, RpcService.CallbackV2<BaseResponse> callbackV2) {
        this.f44678b.verifyPassword(verifyPasswordParam, callbackV2);
    }

    public void regByKey(RegByKeyParam regByKeyParam, RpcService.CallbackV2<BaseLoginSuccessResponse> callbackV2) {
        this.f44678b.regByKey(regByKeyParam, callbackV2);
    }

    public void setPasswordByEmail(SetPasswordParamByEmail setPasswordParamByEmail, RpcService.CallbackV2<BaseResponse> callbackV2) {
        this.f44678b.setPasswordByEmail(setPasswordParamByEmail, callbackV2);
    }

    public void getWhatsAppKey(BaseParam baseParam, RpcService.CallbackV2<GetWhatsAppKeyResponse> callbackV2) {
        this.f44678b.getWhatsAppKey(baseParam, callbackV2);
    }

    public void signInByWhatsAppKey(SignInByWhatsAppKeyParam signInByWhatsAppKeyParam, RpcService.CallbackV2<WhatsAppLoginSuccessResponse> callbackV2) {
        this.f44678b.signInByWhatsAppKey(signInByWhatsAppKeyParam, callbackV2);
    }

    public void loginPageAbTest(String str, RpcService.CallbackV2<LoginPageAbTestResponse> callbackV2) {
        this.f44678b.loginPageAbTest(str, callbackV2);
    }

    public void getLoginType(LoginTypeParam loginTypeParam, RpcService.CallbackV2<LoginTypeResponse> callbackV2) {
        this.f44678b.getLoginType(loginTypeParam, callbackV2);
    }
}
