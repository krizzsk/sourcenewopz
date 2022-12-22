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

public class LoginFlutterNetBiz implements LoginNet {

    /* renamed from: a */
    private Context f44675a;

    /* renamed from: b */
    private LoginNet f44676b;

    public LoginFlutterNetBiz(Context context) {
        this.f44675a = context.getApplicationContext();
        this.f44676b = (LoginNet) new RpcServiceFactory(context).newRpcService(LoginNet.class, LoginUrlProvider.getInstance().getPassportBaseUrl());
    }

    /* renamed from: a */
    private static <T extends BaseParam> T m31720a(T t) {
        t.useFlutterLoginSdkType();
        return t;
    }

    public void getCountryList(CountryRequseParam countryRequseParam, RpcService.CallbackV2<CountryListResponse> callbackV2) {
        this.f44676b.getCountryList((CountryRequseParam) m31720a(countryRequseParam), callbackV2);
    }

    public void gatekeeper(GateKeeperParam gateKeeperParam, RpcService.CallbackV2<GateKeeperResponse> callbackV2) {
        this.f44676b.gatekeeper((GateKeeperParam) m31720a(gateKeeperParam), callbackV2);
    }

    public void codeMt(CodeMtParam codeMtParam, RpcService.CallbackV2<CodeMtResponse> callbackV2) {
        this.f44676b.codeMt((CodeMtParam) m31720a(codeMtParam), callbackV2);
    }

    public void verifyCode(VerifyCodeParam verifyCodeParam, RpcService.CallbackV2<VerifyCodeResponse> callbackV2) {
        this.f44676b.verifyCode((VerifyCodeParam) m31720a(verifyCodeParam), callbackV2);
    }

    public void signInByCode(SignInByCodeParam signInByCodeParam, RpcService.CallbackV2<SignInByCodeResponse> callbackV2) {
        this.f44676b.signInByCode((SignInByCodeParam) m31720a(signInByCodeParam), callbackV2);
    }

    public void getVerifyInfo(VerifyInfoParam verifyInfoParam, RpcService.CallbackV2<VerifyInfoResponse> callbackV2) {
        this.f44676b.getVerifyInfo((VerifyInfoParam) m31720a(verifyInfoParam), callbackV2);
    }

    public void verifyPersonInfo(VerifyPersonInfoParam verifyPersonInfoParam, RpcService.CallbackV2<VerifyPersonInfoResponse> callbackV2) {
        this.f44676b.verifyPersonInfo((VerifyPersonInfoParam) m31720a(verifyPersonInfoParam), callbackV2);
    }

    public void verifyBankAccount(VerifyBankAccountParam verifyBankAccountParam, RpcService.CallbackV2<VerifyBankAccountResponse> callbackV2) {
        this.f44676b.verifyBankAccount((VerifyBankAccountParam) m31720a(verifyBankAccountParam), callbackV2);
    }

    public void newUserAppeal(NewUserAppealParam newUserAppealParam, RpcService.CallbackV2<NewUserAppealResponse> callbackV2) {
        this.f44676b.newUserAppeal((NewUserAppealParam) m31720a(newUserAppealParam), callbackV2);
    }

    public void signInByPassword(SignInByPasswordParam signInByPasswordParam, RpcService.CallbackV2<SignInByPasswordResponse> callbackV2) {
        this.f44676b.signInByPassword((SignInByPasswordParam) m31720a(signInByPasswordParam), callbackV2);
    }

    public void signOff(SignOffParam signOffParam, RpcService.CallbackV2<BaseResponse> callbackV2) {
        this.f44676b.signOff((SignOffParam) m31720a(signOffParam), callbackV2);
    }

    public void validate(Map<String, String> map, RpcService.CallbackV2<BaseResponse> callbackV2) {
        this.f44676b.validate(map, callbackV2);
    }

    public void getEmailInfo(SimpleParam simpleParam, RpcService.CallbackV2<GetEmailInfoResponse> callbackV2) {
        this.f44676b.getEmailInfo((SimpleParam) m31720a(simpleParam), callbackV2);
    }

    public void activateEmail(SimpleParam simpleParam, RpcService.CallbackV2<BaseResponse> callbackV2) {
        this.f44676b.activateEmail((SimpleParam) m31720a(simpleParam), callbackV2);
    }

    public void resetEmail(ResetEmailParam resetEmailParam, RpcService.CallbackV2<SetEmailResponse> callbackV2) {
        this.f44676b.resetEmail((ResetEmailParam) m31720a(resetEmailParam), callbackV2);
    }

    public void uploadLocation(Map<String, Object> map, RpcService.CallbackV2<BaseResponse> callbackV2) {
        this.f44676b.uploadLocation(map, callbackV2);
    }

    public void signInByCell(AuthParam authParam, RpcService.CallbackV2<AuthResponse> callbackV2) {
        this.f44676b.signInByCell((AuthParam) m31720a(authParam), callbackV2);
    }

    public void checkPassword(SimpleParam simpleParam, RpcService.CallbackV2<CheckPwdResponse> callbackV2) {
        this.f44676b.checkPassword((SimpleParam) m31720a(simpleParam), callbackV2);
    }

    public void getPostLoginAction(LoginActionParam loginActionParam, RpcService.CallbackV2<ActionResponse> callbackV2) {
        this.f44676b.getPostLoginAction((LoginActionParam) m31720a(loginActionParam), callbackV2);
    }

    public void getUserIdentityStatus(SimpleParam simpleParam, RpcService.CallbackV2<IdentityStatusResponse> callbackV2) {
        this.f44676b.getUserIdentityStatus((SimpleParam) m31720a(simpleParam), callbackV2);
    }

    public void signInByFace(SignInByFaceParam signInByFaceParam, RpcService.CallbackV2<SignInByFaceResponse> callbackV2) {
        this.f44676b.signInByFace((SignInByFaceParam) m31720a(signInByFaceParam), callbackV2);
    }

    public void compassJudge(ComboJudgeParam comboJudgeParam, RpcService.CallbackV2<JudgeResponse> callbackV2) {
        this.f44676b.compassJudge((ComboJudgeParam) m31720a(comboJudgeParam), callbackV2);
    }

    public void ctrolAuth(AuthParam authParam, RpcService.CallbackV2<BaseResponse> callbackV2) {
        this.f44676b.ctrolAuth((AuthParam) m31720a(authParam), callbackV2);
    }

    public void signByAuth(AuthParam authParam, RpcService.CallbackV2<AuthResponse> callbackV2) {
        this.f44676b.signByAuth((AuthParam) m31720a(authParam), callbackV2);
    }

    public void getAuthList(AuthParam authParam, RpcService.CallbackV2<AuthListResponse> callbackV2) {
        this.f44676b.getAuthList((AuthParam) m31720a(authParam), callbackV2);
    }

    public void refreshTicket(RefreshTicketParam refreshTicketParam, RpcService.CallbackV2<RefreshTicketResponse> callbackV2) {
        this.f44676b.refreshTicket((RefreshTicketParam) m31720a(refreshTicketParam), callbackV2);
    }

    public void setEmail(SetEmailParam setEmailParam, RpcService.CallbackV2<SetEmailResponse> callbackV2) {
        this.f44676b.setEmail((SetEmailParam) m31720a(setEmailParam), callbackV2);
    }

    public void setPassword(SetPasswordParam setPasswordParam, RpcService.CallbackV2<BaseResponse> callbackV2) {
        this.f44676b.setPassword((SetPasswordParam) m31720a(setPasswordParam), callbackV2);
    }

    public void resetPassword(ResetPasswordParam resetPasswordParam, RpcService.CallbackV2<BaseResponse> callbackV2) {
        this.f44676b.resetPassword((ResetPasswordParam) m31720a(resetPasswordParam), callbackV2);
    }

    public void forgetPassword(ForgetPasswordParam forgetPasswordParam, RpcService.CallbackV2<BaseLoginSuccessResponse> callbackV2) {
        this.f44676b.forgetPassword((ForgetPasswordParam) m31720a(forgetPasswordParam), callbackV2);
    }

    public void changeCellByIdCard(ChangeCellByIdCardParam changeCellByIdCardParam, RpcService.CallbackV2<ChangeCellResponse> callbackV2) {
        this.f44676b.changeCellByIdCard((ChangeCellByIdCardParam) m31720a(changeCellByIdCardParam), callbackV2);
    }

    public void deleteAccount(DeleteAccountParam deleteAccountParam, RpcService.CallbackV2<DeleteAccountResponse> callbackV2) {
        this.f44676b.deleteAccount((DeleteAccountParam) m31720a(deleteAccountParam), callbackV2);
    }

    public void getDeleteAccountManual(GetDeleteAccountManualParam getDeleteAccountManualParam, RpcService.CallbackV2<GetDeleteAccountManualResponse> callbackV2) {
        this.f44676b.getDeleteAccountManual((GetDeleteAccountManualParam) m31720a(getDeleteAccountManualParam), callbackV2);
    }

    public void listDeleteAccountReasons(ListDeleteAccountReasonsParam listDeleteAccountReasonsParam, RpcService.CallbackV2<ListDeleteAccountReasonsResponse> callbackV2) {
        this.f44676b.listDeleteAccountReasons((ListDeleteAccountReasonsParam) m31720a(listDeleteAccountReasonsParam), callbackV2);
    }

    public void deleteUser(DeleteUserParam deleteUserParam, RpcService.CallbackV2<DeleteUserResponse> callbackV2) {
        this.f44676b.deleteUser((DeleteUserParam) m31720a(deleteUserParam), callbackV2);
    }

    public void setCell(SetCellParam setCellParam, RpcService.CallbackV2<SetCellResponse> callbackV2) {
        this.f44676b.setCell((SetCellParam) m31720a(setCellParam), callbackV2);
    }

    public void getIdentity(GetIdentityParam getIdentityParam, RpcService.CallbackV2<BaseResponse> callbackV2) {
        this.f44676b.getIdentity((GetIdentityParam) m31720a(getIdentityParam), callbackV2);
    }

    public void getCaptcha(GetCaptchaParam getCaptchaParam, RpcService.CallbackV2<GetCaptchaResponse> callbackV2) {
        this.f44676b.getCaptcha((GetCaptchaParam) m31720a(getCaptchaParam), callbackV2);
    }

    public void verifyCaptcha(VerifyCaptchaParam verifyCaptchaParam, RpcService.CallbackV2<BaseResponse> callbackV2) {
        this.f44676b.verifyCaptcha((VerifyCaptchaParam) m31720a(verifyCaptchaParam), callbackV2);
    }

    public void verifyPassword(VerifyPasswordParam verifyPasswordParam, RpcService.CallbackV2<BaseResponse> callbackV2) {
        this.f44676b.verifyPassword((VerifyPasswordParam) m31720a(verifyPasswordParam), callbackV2);
    }

    public void regByKey(RegByKeyParam regByKeyParam, RpcService.CallbackV2<BaseLoginSuccessResponse> callbackV2) {
        this.f44676b.regByKey((RegByKeyParam) m31720a(regByKeyParam), callbackV2);
    }

    public void setPasswordByEmail(SetPasswordParamByEmail setPasswordParamByEmail, RpcService.CallbackV2<BaseResponse> callbackV2) {
        this.f44676b.setPasswordByEmail((SetPasswordParamByEmail) m31720a(setPasswordParamByEmail), callbackV2);
    }

    public void getWhatsAppKey(BaseParam baseParam, RpcService.CallbackV2<GetWhatsAppKeyResponse> callbackV2) {
        this.f44676b.getWhatsAppKey(m31720a(baseParam), callbackV2);
    }

    public void signInByWhatsAppKey(SignInByWhatsAppKeyParam signInByWhatsAppKeyParam, RpcService.CallbackV2<WhatsAppLoginSuccessResponse> callbackV2) {
        this.f44676b.signInByWhatsAppKey((SignInByWhatsAppKeyParam) m31720a(signInByWhatsAppKeyParam), callbackV2);
    }

    public void loginPageAbTest(String str, RpcService.CallbackV2<LoginPageAbTestResponse> callbackV2) {
        this.f44676b.loginPageAbTest(str, callbackV2);
    }

    public void getLoginType(LoginTypeParam loginTypeParam, RpcService.CallbackV2<LoginTypeResponse> callbackV2) {
        this.f44676b.getLoginType(loginTypeParam, callbackV2);
    }
}
