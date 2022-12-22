package com.didi.unifylogin.base.net;

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
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.Map;

public interface LoginNet extends RpcService {
    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/activateEmail")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void activateEmail(@BodyParameter("q") SimpleParam simpleParam, RpcService.CallbackV2<BaseResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/changeCellByIdCard")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void changeCellByIdCard(@BodyParameter("q") ChangeCellByIdCardParam changeCellByIdCardParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<ChangeCellResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/checkPassword")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void checkPassword(@BodyParameter("q") SimpleParam simpleParam, RpcService.CallbackV2<CheckPwdResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/codeMT")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void codeMt(@BodyParameter("q") CodeMtParam codeMtParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<CodeMtResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/compass/v2/external/idc/judge")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void compassJudge(@BodyParameter("q") ComboJudgeParam comboJudgeParam, RpcService.CallbackV2<JudgeResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/ctrolAuth")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void ctrolAuth(@BodyParameter("q") AuthParam authParam, RpcService.CallbackV2<BaseResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/deleteAccount")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void deleteAccount(@BodyParameter("q") DeleteAccountParam deleteAccountParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<DeleteAccountResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/deleteUser")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void deleteUser(@BodyParameter("q") DeleteUserParam deleteUserParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<DeleteUserResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/forgetPassword")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void forgetPassword(@BodyParameter("q") ForgetPasswordParam forgetPasswordParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<BaseLoginSuccessResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/gatekeeper")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void gatekeeper(@BodyParameter("q") GateKeeperParam gateKeeperParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<GateKeeperResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/getAuthList")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void getAuthList(@BodyParameter("q") AuthParam authParam, RpcService.CallbackV2<AuthListResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/getCaptcha")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void getCaptcha(@BodyParameter("q") GetCaptchaParam getCaptchaParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<GetCaptchaResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/getCountryList")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void getCountryList(@BodyParameter("q") CountryRequseParam countryRequseParam, @TargetThread(ThreadType.WORKER) RpcService.CallbackV2<CountryListResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/getDeleteAccountManual")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void getDeleteAccountManual(@BodyParameter("q") GetDeleteAccountManualParam getDeleteAccountManualParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<GetDeleteAccountManualResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/getEmailInfo")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void getEmailInfo(@BodyParameter("q") SimpleParam simpleParam, RpcService.CallbackV2<GetEmailInfoResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/getIdentity")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void getIdentity(@BodyParameter("q") GetIdentityParam getIdentityParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<BaseResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/getLoginType")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void getLoginType(@BodyParameter("q") LoginTypeParam loginTypeParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<LoginTypeResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/getPostLoginAction")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void getPostLoginAction(@BodyParameter("q") LoginActionParam loginActionParam, RpcService.CallbackV2<ActionResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/getUserIdentityStatus")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void getUserIdentityStatus(@BodyParameter("q") SimpleParam simpleParam, RpcService.CallbackV2<IdentityStatusResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/getVerifyInfo")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void getVerifyInfo(@BodyParameter("q") VerifyInfoParam verifyInfoParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<VerifyInfoResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/getWhatsAppKey")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void getWhatsAppKey(@BodyParameter("q") BaseParam baseParam, RpcService.CallbackV2<GetWhatsAppKeyResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/listDeleteAccountReasons")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void listDeleteAccountReasons(@BodyParameter("q") ListDeleteAccountReasonsParam listDeleteAccountReasonsParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<ListDeleteAccountReasonsResponse> callbackV2);

    @Path("/passport/login/v5/loginPageAbTest")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void loginPageAbTest(@BodyParameter("q") String str, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<LoginPageAbTestResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/newUserAppeal")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void newUserAppeal(@BodyParameter("q") NewUserAppealParam newUserAppealParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<NewUserAppealResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/refreshTicket")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void refreshTicket(@BodyParameter("q") RefreshTicketParam refreshTicketParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<RefreshTicketResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/regByKey")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void regByKey(@BodyParameter("q") RegByKeyParam regByKeyParam, RpcService.CallbackV2<BaseLoginSuccessResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/resetEmail")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void resetEmail(@BodyParameter("q") ResetEmailParam resetEmailParam, RpcService.CallbackV2<SetEmailResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/resetPassword")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void resetPassword(@BodyParameter("q") ResetPasswordParam resetPasswordParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<BaseResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/setCell")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void setCell(@BodyParameter("q") SetCellParam setCellParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<SetCellResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/setEmail")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void setEmail(@BodyParameter("q") SetEmailParam setEmailParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<SetEmailResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/setPassword")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void setPassword(@BodyParameter("q") SetPasswordParam setPasswordParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<BaseResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/signUpByEmail")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void setPasswordByEmail(@BodyParameter("q") SetPasswordParamByEmail setPasswordParamByEmail, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<BaseResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/signByAuth")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void signByAuth(@BodyParameter("q") AuthParam authParam, RpcService.CallbackV2<AuthResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/signInByCell")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void signInByCell(@BodyParameter("q") AuthParam authParam, RpcService.CallbackV2<AuthResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/signInByCode")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void signInByCode(@BodyParameter("q") SignInByCodeParam signInByCodeParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<SignInByCodeResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/signInByFace")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void signInByFace(@BodyParameter("q") SignInByFaceParam signInByFaceParam, RpcService.CallbackV2<SignInByFaceResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/signInByPassword")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void signInByPassword(@BodyParameter("q") SignInByPasswordParam signInByPasswordParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<SignInByPasswordResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/signInByWhatsAppKey")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void signInByWhatsAppKey(@BodyParameter("q") SignInByWhatsAppKeyParam signInByWhatsAppKeyParam, RpcService.CallbackV2<WhatsAppLoginSuccessResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/signOff")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void signOff(@BodyParameter("q") SignOffParam signOffParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<BaseResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/uploadLocation")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void uploadLocation(@BodyParameter("q") Map<String, Object> map, RpcService.CallbackV2<BaseResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/validateTicket")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void validate(@BodyParameter("q") Map<String, String> map, RpcService.CallbackV2<BaseResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/verifyBankAccount")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void verifyBankAccount(@BodyParameter("q") VerifyBankAccountParam verifyBankAccountParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<VerifyBankAccountResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/verifyCaptcha")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void verifyCaptcha(@BodyParameter("q") VerifyCaptchaParam verifyCaptchaParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<BaseResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/verifyCode")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void verifyCode(@BodyParameter("q") VerifyCodeParam verifyCodeParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<VerifyCodeResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/verifyPassword")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void verifyPassword(@BodyParameter("q") VerifyPasswordParam verifyPasswordParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<BaseResponse> callbackV2);

    @Serialization(LoginGsonFormSerializer.class)
    @Path("/passport/login/v5/verifyPersonInfo")
    @Post
    @Deserialization(LoginGsonDeserializer.class)
    void verifyPersonInfo(@BodyParameter("q") VerifyPersonInfoParam verifyPersonInfoParam, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<VerifyPersonInfoResponse> callbackV2);
}
