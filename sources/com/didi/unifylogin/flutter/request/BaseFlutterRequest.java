package com.didi.unifylogin.flutter.request;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.LoginActionParam;
import com.didi.unifylogin.base.net.pojo.response.BaseLoginSuccessResponse;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.entrance.OneLoginActivity;
import com.didi.unifylogin.flutter.LoginLogicManager;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginState;
import com.didichuxing.omega.sdk.Omega;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J*\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0006\u001a\u00020\u00072\u0010\u0010#\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u001dH&J\u0012\u0010&\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0016J\u0012\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010+\u001a\u00020\u001d2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010.\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006/"}, mo175978d2 = {"Lcom/didi/unifylogin/flutter/request/BaseFlutterRequest;", "", "context", "Landroid/content/Context;", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "(Landroid/content/Context;Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "getCall", "()Lio/flutter/plugin/common/MethodCall;", "getContext", "()Landroid/content/Context;", "logger", "Lcom/didi/sdk/logging/Logger;", "kotlin.jvm.PlatformType", "getLogger", "()Lcom/didi/sdk/logging/Logger;", "messenger", "Lcom/didi/unifylogin/base/model/FragmentMessenger;", "getMessenger", "()Lcom/didi/unifylogin/base/model/FragmentMessenger;", "setMessenger", "(Lcom/didi/unifylogin/base/model/FragmentMessenger;)V", "getResult", "()Lio/flutter/plugin/common/MethodChannel$Result;", "setResult", "(Lio/flutter/plugin/common/MethodChannel$Result;)V", "goLogin", "", "loginType", "", "handToken", "response", "Lcom/didi/unifylogin/base/net/pojo/response/BaseLoginSuccessResponse;", "ext", "", "request", "resultSuccess", "any", "setScene", "scene", "Lcom/didi/unifylogin/base/net/LoginScene;", "transform", "initState", "Lcom/didi/unifylogin/utils/LoginState;", "updateOmegaScene", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BaseFlutterRequest.kt */
public abstract class BaseFlutterRequest {

    /* renamed from: a */
    private FragmentMessenger f44782a;

    /* renamed from: b */
    private final Logger f44783b = LoggerFactory.getLogger("LoginLogicManager");

    /* renamed from: c */
    private final Context f44784c;

    /* renamed from: d */
    private final MethodCall f44785d;

    /* renamed from: e */
    private MethodChannel.Result f44786e;

    public abstract void request();

    public BaseFlutterRequest(Context context, MethodCall methodCall, MethodChannel.Result result) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(result, "result");
        this.f44784c = context;
        this.f44785d = methodCall;
        this.f44786e = result;
        FragmentMessenger messenger = LoginLogicManager.getMessenger();
        Intrinsics.checkExpressionValueIsNotNull(messenger, "LoginLogicManager.getMessenger()");
        this.f44782a = messenger;
    }

    public final MethodCall getCall() {
        return this.f44785d;
    }

    public final Context getContext() {
        return this.f44784c;
    }

    public final MethodChannel.Result getResult() {
        return this.f44786e;
    }

    public final void setResult(MethodChannel.Result result) {
        Intrinsics.checkParameterIsNotNull(result, "<set-?>");
        this.f44786e = result;
    }

    public final FragmentMessenger getMessenger() {
        return this.f44782a;
    }

    public final void setMessenger(FragmentMessenger fragmentMessenger) {
        Intrinsics.checkParameterIsNotNull(fragmentMessenger, "<set-?>");
        this.f44782a = fragmentMessenger;
    }

    public final Logger getLogger() {
        return this.f44783b;
    }

    public void handToken(BaseLoginSuccessResponse baseLoginSuccessResponse, MethodChannel.Result result) {
        Intrinsics.checkParameterIsNotNull(baseLoginSuccessResponse, "response");
        Intrinsics.checkParameterIsNotNull(result, "result");
        handToken(baseLoginSuccessResponse, result, (Map<?, ?>) null);
    }

    public void handToken(BaseLoginSuccessResponse baseLoginSuccessResponse, MethodChannel.Result result, Map<?, ?> map) {
        Intrinsics.checkParameterIsNotNull(baseLoginSuccessResponse, "response");
        Intrinsics.checkParameterIsNotNull(result, "result");
        LoginStore instance = LoginStore.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "LoginStore.getInstance()");
        instance.setUserType(baseLoginSuccessResponse.userType);
        CountryListResponse.CountryRule countryById = CountryManager.getIns().getCountryById(baseLoginSuccessResponse.countryId);
        if (baseLoginSuccessResponse.countryId == 86) {
            Map hashMap = new HashMap();
            String str = baseLoginSuccessResponse.cell;
            Intrinsics.checkExpressionValueIsNotNull(str, "response.cell");
            hashMap.put("phone", str);
            OmegaSDKAdapter.trackEvent("loginResponseIs86", (Map<String, Object>) hashMap);
        }
        if (countryById != null) {
            CountryManager ins = CountryManager.getIns();
            Intrinsics.checkExpressionValueIsNotNull(ins, "CountryManager.getIns()");
            ins.setCurrentCountry(countryById);
        }
        LoginStore.getInstance().saveLoginInfo(baseLoginSuccessResponse, this.f44782a);
        LoginActionParam loginActionParam = new LoginActionParam(this.f44784c, this.f44782a.getSceneNum());
        LoginStore instance2 = LoginStore.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance2, "LoginStore.getInstance()");
        LoginActionParam usertype = loginActionParam.setUsertype(instance2.getUserType());
        Intrinsics.checkExpressionValueIsNotNull(usertype, "param");
        LoginStore instance3 = LoginStore.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance3, "LoginStore.getInstance()");
        usertype.setTicket(instance3.getTemporaryToken());
        LoginModel.getFlutterNet(this.f44784c).getPostLoginAction(usertype, new BaseFlutterRequest$handToken$1(map, result));
    }

    public void goLogin(int i) {
        if (i == 1) {
            setScene(LoginScene.SCENE_CODE_LOGIN);
            updateOmegaScene(LoginScene.SCENE_LOGIN);
            this.f44782a.setNextState(LoginState.STATE_CODE);
        } else if (i == 2) {
            setScene(LoginScene.SCENE_PWD_LOGIN);
            updateOmegaScene(LoginScene.SCENE_PWD_LOGIN);
            this.f44782a.setNextState(LoginState.STATE_PASSWORD);
        } else if (i == 4 || i == 8) {
            setScene(LoginScene.SCENE_FACE_LOGIN);
            updateOmegaScene(LoginScene.SCENE_FACE_LOGIN);
            transform(LoginState.STATE_PRE_FACE);
            this.f44782a.setNextState(LoginState.STATE_PRE_FACE);
        } else {
            setScene(LoginScene.SCENE_CODE_LOGIN);
            updateOmegaScene(LoginScene.SCENE_CODE_LOGIN);
            this.f44782a.setNextState(LoginState.STATE_CODE);
        }
    }

    public void transform(LoginState loginState) {
        Intent intent = new Intent(this.f44784c, OneLoginActivity.class);
        if (!(this.f44784c instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra(OneLoginActivity.INIT_STATE, loginState);
        intent.putExtra(OneLoginActivity.INIT_MESSENGER, this.f44782a);
        this.f44784c.startActivity(intent);
    }

    public void setScene(LoginScene loginScene) {
        if (loginScene != null) {
            this.f44782a.setScene(loginScene);
        }
    }

    public void updateOmegaScene(LoginScene loginScene) {
        if (loginScene != null) {
            this.f44782a.updateOmegaScene(loginScene);
        }
    }

    public void resultSuccess(Object obj) {
        try {
            this.f44786e.success(obj);
        } catch (Exception e) {
            Omega.trackError("passport_flutter_result_error", e);
        }
    }
}
