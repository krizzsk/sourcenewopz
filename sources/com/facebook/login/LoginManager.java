package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.fragment.app.Fragment;
import com.didi.sdk.apm.SystemUtils;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.AuthenticationToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.LoginStatusCallback;
import com.facebook.Profile;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 w2\u00020\u0001:\u0005uvwxyB\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!H\u0014J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'H\u0014J\b\u0010(\u001a\u00020\u001fH\u0014JH\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010\u001f2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\r2\u000e\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104H\u0002J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001fH\u0014JL\u00109\u001a\u00020*2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=2\u0014\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010?2\b\u00100\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020\r2\b\u00108\u001a\u0004\u0018\u00010\u001fH\u0002J\u0016\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020D2\u0006\u0010&\u001a\u00020'J\u001e\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020D2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!J(\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020D2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!2\b\u0010E\u001a\u0004\u0018\u00010\u0004J\u001e\u0010B\u001a\u00020*2\u0006\u0010F\u001a\u00020G2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!J(\u0010B\u001a\u00020*2\u0006\u0010F\u001a\u00020G2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!2\b\u0010E\u001a\u0004\u0018\u00010\u0004J \u0010B\u001a\u00020*2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010&\u001a\u00020'H\u0002J$\u0010B\u001a\u00020*2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040!J.\u0010B\u001a\u00020*2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040!2\b\u0010E\u001a\u0004\u0018\u00010\u0004J\u001e\u0010B\u001a\u00020*2\u0006\u0010F\u001a\u00020L2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!J(\u0010B\u001a\u00020*2\u0006\u0010F\u001a\u00020L2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!2\b\u0010E\u001a\u0004\u0018\u00010\u0004J\u0016\u0010B\u001a\u00020*2\u0006\u0010F\u001a\u00020M2\u0006\u0010&\u001a\u00020'J\u001e\u0010B\u001a\u00020*2\u0006\u0010F\u001a\u00020M2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!J(\u0010B\u001a\u00020*2\u0006\u0010F\u001a\u00020M2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!2\b\u0010E\u001a\u0004\u0018\u00010\u0004J\u0016\u0010N\u001a\u00020*2\u0006\u0010F\u001a\u00020L2\u0006\u0010&\u001a\u00020'J\u001e\u0010O\u001a\u00020*2\u0006\u0010C\u001a\u00020D2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!J\u001c\u0010O\u001a\u00020*2\u0006\u0010F\u001a\u00020G2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040!J$\u0010O\u001a\u00020*2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040!J$\u0010O\u001a\u00020*2\u0006\u0010F\u001a\u00020L2\u0006\u0010J\u001a\u00020K2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040!J\u001e\u0010O\u001a\u00020*2\u0006\u0010F\u001a\u00020L2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040!H\u0007J\u001e\u0010O\u001a\u00020*2\u0006\u0010F\u001a\u00020M2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040!H\u0002J\u001e\u0010P\u001a\u00020*2\u0006\u0010C\u001a\u00020D2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!J\u001c\u0010P\u001a\u00020*2\u0006\u0010F\u001a\u00020G2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040!J$\u0010P\u001a\u00020*2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040!J$\u0010P\u001a\u00020*2\u0006\u0010F\u001a\u00020L2\u0006\u0010J\u001a\u00020K2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040!J\u001e\u0010P\u001a\u00020*2\u0006\u0010F\u001a\u00020L2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040!H\u0007J\u001e\u0010P\u001a\u00020*2\u0006\u0010F\u001a\u00020M2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040!H\u0002J\b\u0010Q\u001a\u00020*H\u0016J\u001c\u0010R\u001a\u00020*2\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010S\u001a\u0004\u0018\u00010\u001fH\u0002J\u0016\u0010T\u001a\u00020*2\u0006\u0010C\u001a\u00020D2\u0006\u0010&\u001a\u00020'J\u0018\u0010T\u001a\u00020*2\u0006\u0010F\u001a\u00020M2\u0006\u0010&\u001a\u00020'H\u0002J,\u0010U\u001a\u00020\r2\u0006\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u0001072\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104H\u0017J\u000e\u0010Y\u001a\u00020*2\u0006\u0010C\u001a\u00020DJ\u000e\u0010Y\u001a\u00020*2\u0006\u0010F\u001a\u00020LJ\u0010\u0010Y\u001a\u00020*2\u0006\u0010F\u001a\u00020MH\u0002J \u0010Z\u001a\u00020*2\b\u0010J\u001a\u0004\u0018\u00010K2\u000e\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104J\u0016\u0010[\u001a\u00020*2\u0006\u0010C\u001a\u00020D2\u0006\u0010#\u001a\u00020$J\u0016\u0010[\u001a\u00020*2\u0006\u0010F\u001a\u00020G2\u0006\u0010#\u001a\u00020$J\u001e\u0010[\u001a\u00020*2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010#\u001a\u00020$J\u001e\u0010[\u001a\u00020*2\u0006\u0010F\u001a\u00020L2\u0006\u0010J\u001a\u00020K2\u0006\u0010#\u001a\u00020$J\u0018\u0010[\u001a\u00020*2\u0006\u0010F\u001a\u00020L2\u0006\u0010#\u001a\u00020$H\u0007J\u0018\u0010[\u001a\u00020*2\u0006\u0010F\u001a\u00020M2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010\\\u001a\u00020\r2\u0006\u0010]\u001a\u000207H\u0002J\u0016\u0010^\u001a\u00020*2\u0006\u0010:\u001a\u00020;2\u0006\u0010_\u001a\u00020`J\u001e\u0010^\u001a\u00020*2\u0006\u0010:\u001a\u00020;2\u0006\u0010a\u001a\u00020b2\u0006\u0010_\u001a\u00020`J \u0010c\u001a\u00020*2\u0006\u0010:\u001a\u00020;2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020bH\u0002J\u000e\u0010d\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010e\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010f\u001a\u00020*2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010g\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010h\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010i\u001a\u00020\u00002\u0006\u0010j\u001a\u00020\u0014J\u0010\u0010k\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004J\u000e\u0010l\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\rJ\u000e\u0010m\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\rJ\u0018\u0010n\u001a\u00020*2\u0006\u0010o\u001a\u00020p2\u0006\u00108\u001a\u00020\u001fH\u0002J\u0018\u0010q\u001a\u00020\r2\u0006\u0010o\u001a\u00020p2\u0006\u00108\u001a\u00020\u001fH\u0002J\u0010\u0010r\u001a\u00020*2\b\u0010J\u001a\u0004\u0018\u00010KJ\u0018\u0010s\u001a\u00020*2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!H\u0002J\u0018\u0010t\u001a\u00020*2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!H\u0002R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0014@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000e¨\u0006z"}, mo175978d2 = {"Lcom/facebook/login/LoginManager;", "", "()V", "<set-?>", "", "authType", "getAuthType", "()Ljava/lang/String;", "Lcom/facebook/login/DefaultAudience;", "defaultAudience", "getDefaultAudience", "()Lcom/facebook/login/DefaultAudience;", "isExpressLoginAllowed", "", "()Z", "isFamilyLogin", "Lcom/facebook/login/LoginBehavior;", "loginBehavior", "getLoginBehavior", "()Lcom/facebook/login/LoginBehavior;", "Lcom/facebook/login/LoginTargetApp;", "loginTargetApp", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "messengerPageId", "resetMessengerState", "sharedPreferences", "Landroid/content/SharedPreferences;", "shouldSkipAccountDeduplication", "getShouldSkipAccountDeduplication", "createLoginRequest", "Lcom/facebook/login/LoginClient$Request;", "permissions", "", "createLoginRequestFromResponse", "response", "Lcom/facebook/GraphResponse;", "createLoginRequestWithConfig", "loginConfig", "Lcom/facebook/login/LoginConfiguration;", "createReauthorizeRequest", "finishLogin", "", "newToken", "Lcom/facebook/AccessToken;", "newIdToken", "Lcom/facebook/AuthenticationToken;", "origRequest", "exception", "Lcom/facebook/FacebookException;", "isCanceled", "callback", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/login/LoginResult;", "getFacebookActivityIntent", "Landroid/content/Intent;", "request", "logCompleteLogin", "context", "Landroid/content/Context;", "result", "Lcom/facebook/login/LoginClient$Result$Code;", "resultExtras", "", "Ljava/lang/Exception;", "wasLoginActivityTried", "logIn", "activity", "Landroid/app/Activity;", "loggerID", "fragment", "Landroid/app/Fragment;", "activityResultRegistryOwner", "Landroidx/activity/result/ActivityResultRegistryOwner;", "callbackManager", "Lcom/facebook/CallbackManager;", "Landroidx/fragment/app/Fragment;", "Lcom/facebook/internal/FragmentWrapper;", "logInWithConfiguration", "logInWithPublishPermissions", "logInWithReadPermissions", "logOut", "logStartLogin", "loginRequest", "loginWithConfiguration", "onActivityResult", "resultCode", "", "data", "reauthorizeDataAccess", "registerCallback", "resolveError", "resolveIntent", "intent", "retrieveLoginStatus", "responseCallback", "Lcom/facebook/LoginStatusCallback;", "toastDurationMs", "", "retrieveLoginStatusImpl", "setAuthType", "setDefaultAudience", "setExpressLoginStatus", "setFamilyLogin", "setLoginBehavior", "setLoginTargetApp", "targetApp", "setMessengerPageId", "setResetMessengerState", "setShouldSkipAccountDeduplication", "startLogin", "startActivityDelegate", "Lcom/facebook/login/StartActivityDelegate;", "tryFacebookActivity", "unregisterCallback", "validatePublishPermissions", "validateReadPermissions", "ActivityStartActivityDelegate", "AndroidxActivityResultRegistryOwnerStartActivityDelegate", "Companion", "FragmentStartActivityDelegate", "LoginLoggerHolder", "facebook-common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LoginManager.kt */
public class LoginManager {
    public static final Companion Companion;
    private static final String EXPRESS_LOGIN_ALLOWED = "express_login_allowed";
    private static final String MANAGE_PERMISSION_PREFIX = "manage";
    /* access modifiers changed from: private */
    public static final Set<String> OTHER_PUBLISH_PERMISSIONS;
    private static final String PREFERENCE_LOGIN_MANAGER = "com.facebook.loginManager";
    private static final String PUBLISH_PERMISSION_PREFIX = "publish";
    private static final String TAG;
    /* access modifiers changed from: private */
    public static volatile LoginManager instance;
    private String authType = ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE;
    private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
    private boolean isFamilyLogin;
    private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
    private LoginTargetApp loginTargetApp = LoginTargetApp.FACEBOOK;
    private String messengerPageId;
    private boolean resetMessengerState;
    private final SharedPreferences sharedPreferences;
    private boolean shouldSkipAccountDeduplication;

    @JvmStatic
    public static final LoginResult computeLoginResult(LoginClient.Request request, AccessToken accessToken, AuthenticationToken authenticationToken) {
        return Companion.computeLoginResult(request, accessToken, authenticationToken);
    }

    @JvmStatic
    public static final Map<String, String> getExtraDataFromIntent(Intent intent) {
        return Companion.getExtraDataFromIntent(intent);
    }

    @JvmStatic
    public static LoginManager getInstance() {
        return Companion.getInstance();
    }

    @JvmStatic
    public static final boolean isPublishPermission(String str) {
        return Companion.isPublishPermission(str);
    }

    public final boolean onActivityResult(int i, Intent intent) {
        return onActivityResult$default(this, i, intent, (FacebookCallback) null, 4, (Object) null);
    }

    public LoginManager() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        SharedPreferences sharedPreferences2 = SystemUtils.getSharedPreferences(FacebookSdk.getApplicationContext(), PREFERENCE_LOGIN_MANAGER, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "getApplicationContext().getSharedPreferences(PREFERENCE_LOGIN_MANAGER, Context.MODE_PRIVATE)");
        this.sharedPreferences = sharedPreferences2;
        if (FacebookSdk.hasCustomTabsPrefetching) {
            CustomTabUtils customTabUtils = CustomTabUtils.INSTANCE;
            if (CustomTabUtils.getChromePackage() != null) {
                CustomTabPrefetchHelper customTabPrefetchHelper = new CustomTabPrefetchHelper();
                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                CustomTabsClient.bindCustomTabsService(FacebookSdk.getApplicationContext(), "com.android.chrome", customTabPrefetchHelper);
                FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
                Context applicationContext = FacebookSdk.getApplicationContext();
                FacebookSdk facebookSdk4 = FacebookSdk.INSTANCE;
                CustomTabsClient.connectAndInitialize(applicationContext, FacebookSdk.getApplicationContext().getPackageName());
            }
        }
    }

    public final LoginBehavior getLoginBehavior() {
        return this.loginBehavior;
    }

    public final DefaultAudience getDefaultAudience() {
        return this.defaultAudience;
    }

    public final String getAuthType() {
        return this.authType;
    }

    public final LoginTargetApp getLoginTargetApp() {
        return this.loginTargetApp;
    }

    public final boolean isFamilyLogin() {
        return this.isFamilyLogin;
    }

    public final boolean getShouldSkipAccountDeduplication() {
        return this.shouldSkipAccountDeduplication;
    }

    public final void resolveError(Activity activity, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(graphResponse, "response");
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestFromResponse(graphResponse));
    }

    @Deprecated(message = "")
    public final void resolveError(Fragment fragment, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(graphResponse, "response");
        resolveError(new FragmentWrapper(fragment), graphResponse);
    }

    public final void resolveError(Fragment fragment, CallbackManager callbackManager, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(graphResponse, "response");
        ComponentActivity activity = fragment.getActivity();
        if (activity != null) {
            resolveError((ActivityResultRegistryOwner) activity, callbackManager, graphResponse);
            return;
        }
        throw new FacebookException(Intrinsics.stringPlus("Cannot obtain activity context on the fragment ", fragment));
    }

    public final void resolveError(android.app.Fragment fragment, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(graphResponse, "response");
        resolveError(new FragmentWrapper(fragment), graphResponse);
    }

    private final void resolveError(FragmentWrapper fragmentWrapper, GraphResponse graphResponse) {
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequestFromResponse(graphResponse));
    }

    public final void resolveError(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(graphResponse, "response");
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), createLoginRequestFromResponse(graphResponse));
    }

    private final LoginClient.Request createLoginRequestFromResponse(GraphResponse graphResponse) {
        Set<String> permissions;
        AccessToken accessToken = graphResponse.getRequest().getAccessToken();
        List list = null;
        if (!(accessToken == null || (permissions = accessToken.getPermissions()) == null)) {
            list = CollectionsKt.filterNotNull(permissions);
        }
        return createLoginRequest(list);
    }

    public final void registerCallback(CallbackManager callbackManager, FacebookCallback<LoginResult> facebookCallback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).registerCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback(facebookCallback) {
                public final /* synthetic */ FacebookCallback f$1;

                {
                    this.f$1 = r2;
                }

                public final boolean onActivityResult(int i, Intent intent) {
                    return LoginManager.m47439registerCallback$lambda0(LoginManager.this, this.f$1, i, intent);
                }
            });
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    /* access modifiers changed from: private */
    /* renamed from: registerCallback$lambda-0  reason: not valid java name */
    public static final boolean m47439registerCallback$lambda0(LoginManager loginManager, FacebookCallback facebookCallback, int i, Intent intent) {
        Intrinsics.checkNotNullParameter(loginManager, "this$0");
        return loginManager.onActivityResult(i, intent, facebookCallback);
    }

    public final void unregisterCallback(CallbackManager callbackManager) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).unregisterCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode());
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    public static /* synthetic */ boolean onActivityResult$default(LoginManager loginManager, int i, Intent intent, FacebookCallback facebookCallback, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                facebookCallback = null;
            }
            return loginManager.onActivityResult(i, intent, facebookCallback);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onActivityResult");
    }

    public boolean onActivityResult(int i, Intent intent, FacebookCallback<LoginResult> facebookCallback) {
        boolean z;
        Map<String, String> map;
        LoginClient.Result.Code code;
        LoginClient.Request request;
        AuthenticationToken authenticationToken;
        AccessToken accessToken;
        AuthenticationToken authenticationToken2;
        int i2 = i;
        Intent intent2 = intent;
        LoginClient.Result.Code code2 = LoginClient.Result.Code.ERROR;
        FacebookException facebookException = null;
        boolean z2 = false;
        if (intent2 != null) {
            intent2.setExtrasClassLoader(LoginClient.Result.class.getClassLoader());
            LoginClient.Result result = (LoginClient.Result) intent2.getParcelableExtra(LoginFragment.RESULT_KEY);
            if (result != null) {
                request = result.request;
                LoginClient.Result.Code code3 = result.code;
                if (i2 != -1) {
                    if (i2 != 0) {
                        accessToken = null;
                        authenticationToken2 = null;
                    } else {
                        accessToken = null;
                        authenticationToken2 = null;
                        z2 = true;
                    }
                } else if (result.code == LoginClient.Result.Code.SUCCESS) {
                    accessToken = result.token;
                    authenticationToken2 = result.authenticationToken;
                } else {
                    authenticationToken2 = null;
                    facebookException = new FacebookAuthorizationException(result.errorMessage);
                    accessToken = null;
                }
                map = result.loggingExtras;
                z = z2;
                authenticationToken = authenticationToken2;
                code = code3;
                if (facebookException == null && accessToken == null && !z) {
                    facebookException = new FacebookException("Unexpected call to LoginManager.onActivityResult");
                }
                FacebookException facebookException2 = facebookException;
                LoginClient.Request request2 = request;
                logCompleteLogin((Context) null, code, map, facebookException2, true, request2);
                finishLogin(accessToken, authenticationToken, request2, facebookException2, z, facebookCallback);
                return true;
            }
        } else if (i2 == 0) {
            code = LoginClient.Result.Code.CANCEL;
            accessToken = null;
            authenticationToken = null;
            request = null;
            map = null;
            z = true;
            facebookException = new FacebookException("Unexpected call to LoginManager.onActivityResult");
            FacebookException facebookException22 = facebookException;
            LoginClient.Request request22 = request;
            logCompleteLogin((Context) null, code, map, facebookException22, true, request22);
            finishLogin(accessToken, authenticationToken, request22, facebookException22, z, facebookCallback);
            return true;
        }
        code = code2;
        accessToken = null;
        authenticationToken = null;
        request = null;
        map = null;
        z = false;
        facebookException = new FacebookException("Unexpected call to LoginManager.onActivityResult");
        FacebookException facebookException222 = facebookException;
        LoginClient.Request request222 = request;
        logCompleteLogin((Context) null, code, map, facebookException222, true, request222);
        finishLogin(accessToken, authenticationToken, request222, facebookException222, z, facebookCallback);
        return true;
    }

    public final LoginManager setLoginBehavior(LoginBehavior loginBehavior2) {
        Intrinsics.checkNotNullParameter(loginBehavior2, "loginBehavior");
        this.loginBehavior = loginBehavior2;
        return this;
    }

    public final LoginManager setLoginTargetApp(LoginTargetApp loginTargetApp2) {
        Intrinsics.checkNotNullParameter(loginTargetApp2, "targetApp");
        this.loginTargetApp = loginTargetApp2;
        return this;
    }

    public final LoginManager setDefaultAudience(DefaultAudience defaultAudience2) {
        Intrinsics.checkNotNullParameter(defaultAudience2, "defaultAudience");
        this.defaultAudience = defaultAudience2;
        return this;
    }

    public final LoginManager setAuthType(String str) {
        Intrinsics.checkNotNullParameter(str, "authType");
        this.authType = str;
        return this;
    }

    public final LoginManager setMessengerPageId(String str) {
        this.messengerPageId = str;
        return this;
    }

    public final LoginManager setResetMessengerState(boolean z) {
        this.resetMessengerState = z;
        return this;
    }

    public final LoginManager setFamilyLogin(boolean z) {
        this.isFamilyLogin = z;
        return this;
    }

    public final LoginManager setShouldSkipAccountDeduplication(boolean z) {
        this.shouldSkipAccountDeduplication = z;
        return this;
    }

    public void logOut() {
        AccessToken.Companion.setCurrentAccessToken((AccessToken) null);
        AuthenticationToken.Companion.setCurrentAuthenticationToken((AuthenticationToken) null);
        Profile.Companion.setCurrentProfile((Profile) null);
        setExpressLoginStatus(false);
    }

    public final void retrieveLoginStatus(Context context, LoginStatusCallback loginStatusCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(loginStatusCallback, "responseCallback");
        retrieveLoginStatus(context, 5000, loginStatusCallback);
    }

    public final void retrieveLoginStatus(Context context, long j, LoginStatusCallback loginStatusCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(loginStatusCallback, "responseCallback");
        retrieveLoginStatusImpl(context, loginStatusCallback, j);
    }

    @Deprecated(message = "")
    public final void logInWithReadPermissions(Fragment fragment, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        logInWithReadPermissions(new FragmentWrapper(fragment), collection);
    }

    public final void logInWithReadPermissions(Fragment fragment, CallbackManager callbackManager, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        ComponentActivity activity = fragment.getActivity();
        if (activity != null) {
            logInWithReadPermissions((ActivityResultRegistryOwner) activity, callbackManager, collection);
            return;
        }
        throw new FacebookException(Intrinsics.stringPlus("Cannot obtain activity context on the fragment ", fragment));
    }

    public final void logInWithReadPermissions(android.app.Fragment fragment, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        logInWithReadPermissions(new FragmentWrapper(fragment), collection);
    }

    private final void logInWithReadPermissions(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        validateReadPermissions(collection);
        logIn(fragmentWrapper, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logInWithReadPermissions(Activity activity, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        validateReadPermissions(collection);
        logIn(activity, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logInWithReadPermissions(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        validateReadPermissions(collection);
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logInWithConfiguration(Fragment fragment, LoginConfiguration loginConfiguration) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(loginConfiguration, "loginConfig");
        loginWithConfiguration(new FragmentWrapper(fragment), loginConfiguration);
    }

    private final void loginWithConfiguration(FragmentWrapper fragmentWrapper, LoginConfiguration loginConfiguration) {
        logIn(fragmentWrapper, loginConfiguration);
    }

    public final void loginWithConfiguration(Activity activity, LoginConfiguration loginConfiguration) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(loginConfiguration, "loginConfig");
        logIn(activity, loginConfiguration);
    }

    public final void reauthorizeDataAccess(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        startLogin(new ActivityStartActivityDelegate(activity), createReauthorizeRequest());
    }

    public final void reauthorizeDataAccess(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        reauthorizeDataAccess(new FragmentWrapper(fragment));
    }

    private final void reauthorizeDataAccess(FragmentWrapper fragmentWrapper) {
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createReauthorizeRequest());
    }

    @Deprecated(message = "")
    public final void logInWithPublishPermissions(Fragment fragment, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        logInWithPublishPermissions(new FragmentWrapper(fragment), collection);
    }

    public final void logInWithPublishPermissions(Fragment fragment, CallbackManager callbackManager, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        ComponentActivity activity = fragment.getActivity();
        if (activity != null) {
            logInWithPublishPermissions((ActivityResultRegistryOwner) activity, callbackManager, collection);
            return;
        }
        throw new FacebookException(Intrinsics.stringPlus("Cannot obtain activity context on the fragment ", fragment));
    }

    public final void logInWithPublishPermissions(android.app.Fragment fragment, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        logInWithPublishPermissions(new FragmentWrapper(fragment), collection);
    }

    private final void logInWithPublishPermissions(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        validatePublishPermissions(collection);
        loginWithConfiguration(fragmentWrapper, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logInWithPublishPermissions(Activity activity, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        validatePublishPermissions(collection);
        loginWithConfiguration(activity, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logInWithPublishPermissions(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        validatePublishPermissions(collection);
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logIn(Fragment fragment, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection);
    }

    public final void logIn(Fragment fragment, Collection<String> collection, String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection, str);
    }

    public final void logIn(android.app.Fragment fragment, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection);
    }

    public final void logIn(android.app.Fragment fragment, Collection<String> collection, String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection, str);
    }

    public final void logIn(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragmentWrapper, "fragment");
        logIn(fragmentWrapper, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logIn(FragmentWrapper fragmentWrapper, Collection<String> collection, String str) {
        Intrinsics.checkNotNullParameter(fragmentWrapper, "fragment");
        LoginClient.Request createLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
        if (str != null) {
            createLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequestWithConfig);
    }

    public final void logIn(Activity activity, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        logIn(activity, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logIn(FragmentWrapper fragmentWrapper, LoginConfiguration loginConfiguration) {
        Intrinsics.checkNotNullParameter(fragmentWrapper, "fragment");
        Intrinsics.checkNotNullParameter(loginConfiguration, "loginConfig");
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequestWithConfig(loginConfiguration));
    }

    public final void logIn(Activity activity, LoginConfiguration loginConfiguration) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(loginConfiguration, "loginConfig");
        if (activity instanceof ActivityResultRegistryOwner) {
            SystemUtils.log(5, TAG, "You're calling logging in Facebook with an activity supports androidx activity result APIs. Please follow our document to upgrade to new APIs to avoid overriding onActivityResult().", (Throwable) null, "com.facebook.login.LoginManager", 742);
        }
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestWithConfig(loginConfiguration));
    }

    public final void logIn(Activity activity, Collection<String> collection, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        LoginClient.Request createLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
        if (str != null) {
            createLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestWithConfig);
    }

    private final void logIn(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, LoginConfiguration loginConfiguration) {
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), createLoginRequestWithConfig(loginConfiguration));
    }

    public final void logIn(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, Collection<String> collection, String str) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        LoginClient.Request createLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
        if (str != null) {
            createLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), createLoginRequestWithConfig);
    }

    public final void logIn(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    private final void validateReadPermissions(Collection<String> collection) {
        if (collection != null) {
            for (String next : collection) {
                if (Companion.isPublishPermission(next)) {
                    throw new FacebookException("Cannot pass a publish or manage permission (" + next + ") to a request for read authorization");
                }
            }
        }
    }

    private final void validatePublishPermissions(Collection<String> collection) {
        if (collection != null) {
            for (String next : collection) {
                if (!Companion.isPublishPermission(next)) {
                    throw new FacebookException("Cannot pass a read permission (" + next + ") to a request for publish authorization");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public LoginClient.Request createLoginRequestWithConfig(LoginConfiguration loginConfiguration) {
        String str;
        Intrinsics.checkNotNullParameter(loginConfiguration, "loginConfig");
        CodeChallengeMethod codeChallengeMethod = CodeChallengeMethod.S256;
        try {
            PKCEUtil pKCEUtil = PKCEUtil.INSTANCE;
            str = PKCEUtil.generateCodeChallenge(loginConfiguration.getCodeVerifier(), codeChallengeMethod);
        } catch (FacebookException unused) {
            codeChallengeMethod = CodeChallengeMethod.PLAIN;
            str = loginConfiguration.getCodeVerifier();
        }
        String str2 = str;
        LoginBehavior loginBehavior2 = this.loginBehavior;
        Set set = CollectionsKt.toSet(loginConfiguration.getPermissions());
        DefaultAudience defaultAudience2 = this.defaultAudience;
        String str3 = this.authType;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(loginBehavior2, set, defaultAudience2, str3, applicationId, uuid, this.loginTargetApp, loginConfiguration.getNonce(), loginConfiguration.getCodeVerifier(), str2, codeChallengeMethod);
        request.setRerequest(AccessToken.Companion.isCurrentAccessTokenActive());
        request.setMessengerPageId(this.messengerPageId);
        request.setResetMessengerState(this.resetMessengerState);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    /* access modifiers changed from: protected */
    public LoginClient.Request createLoginRequest(Collection<String> collection) {
        Set set;
        LoginBehavior loginBehavior2 = this.loginBehavior;
        if (collection == null) {
            set = null;
        } else {
            set = CollectionsKt.toSet(collection);
        }
        Set set2 = set;
        DefaultAudience defaultAudience2 = this.defaultAudience;
        String str = this.authType;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(loginBehavior2, set2, defaultAudience2, str, applicationId, uuid, this.loginTargetApp, (String) null, (String) null, (String) null, (CodeChallengeMethod) null, 1920, (DefaultConstructorMarker) null);
        request.setRerequest(AccessToken.Companion.isCurrentAccessTokenActive());
        request.setMessengerPageId(this.messengerPageId);
        request.setResetMessengerState(this.resetMessengerState);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    /* access modifiers changed from: protected */
    public LoginClient.Request createReauthorizeRequest() {
        DefaultAudience defaultAudience2 = this.defaultAudience;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(LoginBehavior.DIALOG_ONLY, new HashSet(), defaultAudience2, "reauthorize", applicationId, uuid, this.loginTargetApp, (String) null, (String) null, (String) null, (CodeChallengeMethod) null, 1920, (DefaultConstructorMarker) null);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    private final void startLogin(StartActivityDelegate startActivityDelegate, LoginClient.Request request) throws FacebookException {
        logStartLogin(startActivityDelegate.getActivityContext(), request);
        CallbackManagerImpl.Companion.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback() {
            public final boolean onActivityResult(int i, Intent intent) {
                return LoginManager.m47441startLogin$lambda1(LoginManager.this, i, intent);
            }
        });
        if (!tryFacebookActivity(startActivityDelegate, request)) {
            FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            logCompleteLogin(startActivityDelegate.getActivityContext(), LoginClient.Result.Code.ERROR, (Map<String, String>) null, facebookException, false, request);
            throw facebookException;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startLogin$lambda-1  reason: not valid java name */
    public static final boolean m47441startLogin$lambda1(LoginManager loginManager, int i, Intent intent) {
        Intrinsics.checkNotNullParameter(loginManager, "this$0");
        return onActivityResult$default(loginManager, i, intent, (FacebookCallback) null, 4, (Object) null);
    }

    private final void logStartLogin(Context context, LoginClient.Request request) {
        LoginLogger logger = LoginLoggerHolder.INSTANCE.getLogger(context);
        if (logger != null && request != null) {
            logger.logStartLogin(request, request.isFamilyLogin() ? LoginLogger.EVENT_NAME_FOA_LOGIN_START : LoginLogger.EVENT_NAME_LOGIN_START);
        }
    }

    private final void logCompleteLogin(Context context, LoginClient.Result.Code code, Map<String, String> map, Exception exc, boolean z, LoginClient.Request request) {
        LoginLogger logger = LoginLoggerHolder.INSTANCE.getLogger(context);
        if (logger != null) {
            if (request == null) {
                LoginLogger.logUnexpectedError$default(logger, LoginLogger.EVENT_NAME_LOGIN_COMPLETE, "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", (String) null, 4, (Object) null);
                return;
            }
            Map hashMap = new HashMap();
            hashMap.put(LoginLogger.EVENT_EXTRAS_TRY_LOGIN_ACTIVITY, z ? "1" : "0");
            logger.logCompleteLogin(request.getAuthId(), hashMap, code, map, exc, request.isFamilyLogin() ? LoginLogger.EVENT_NAME_FOA_LOGIN_COMPLETE : LoginLogger.EVENT_NAME_LOGIN_COMPLETE);
        }
    }

    private final boolean tryFacebookActivity(StartActivityDelegate startActivityDelegate, LoginClient.Request request) {
        Intent facebookActivityIntent = getFacebookActivityIntent(request);
        if (!resolveIntent(facebookActivityIntent)) {
            return false;
        }
        try {
            startActivityDelegate.startActivityForResult(facebookActivityIntent, LoginClient.Companion.getLoginRequestCode());
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    private final boolean resolveIntent(Intent intent) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0) != null;
    }

    /* access modifiers changed from: protected */
    public Intent getFacebookActivityIntent(LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intent intent = new Intent();
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(request.getLoginBehavior().toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("request", request);
        intent.putExtra(LoginFragment.REQUEST_KEY, bundle);
        return intent;
    }

    private final void finishLogin(AccessToken accessToken, AuthenticationToken authenticationToken, LoginClient.Request request, FacebookException facebookException, boolean z, FacebookCallback<LoginResult> facebookCallback) {
        if (accessToken != null) {
            AccessToken.Companion.setCurrentAccessToken(accessToken);
            Profile.Companion.fetchProfileForCurrentAccessToken();
        }
        if (authenticationToken != null) {
            AuthenticationToken.Companion.setCurrentAuthenticationToken(authenticationToken);
        }
        if (facebookCallback != null) {
            LoginResult computeLoginResult = (accessToken == null || request == null) ? null : Companion.computeLoginResult(request, accessToken, authenticationToken);
            if (z || (computeLoginResult != null && computeLoginResult.getRecentlyGrantedPermissions().isEmpty())) {
                facebookCallback.onCancel();
            } else if (facebookException != null) {
                facebookCallback.onError(facebookException);
            } else if (accessToken != null && computeLoginResult != null) {
                setExpressLoginStatus(true);
                facebookCallback.onSuccess(computeLoginResult);
            }
        }
    }

    private final void retrieveLoginStatusImpl(Context context, LoginStatusCallback loginStatusCallback, long j) {
        Context context2;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        if (context == null) {
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            context2 = FacebookSdk.getApplicationContext();
        } else {
            context2 = context;
        }
        LoginLogger loginLogger = new LoginLogger(context2, applicationId);
        if (!isExpressLoginAllowed()) {
            loginLogger.logLoginStatusFailure(uuid);
            loginStatusCallback.onFailure();
            return;
        }
        FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
        LoginStatusClient loginStatusClient = new LoginStatusClient(context, applicationId, uuid, FacebookSdk.getGraphApiVersion(), j, (String) null);
        LoginStatusCallback loginStatusCallback2 = loginStatusCallback;
        loginStatusClient.setCompletedListener(new PlatformServiceClient.CompletedListener(uuid, loginLogger, loginStatusCallback, applicationId) {
            public final /* synthetic */ String f$0;
            public final /* synthetic */ LoginLogger f$1;
            public final /* synthetic */ LoginStatusCallback f$2;
            public final /* synthetic */ String f$3;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void completed(Bundle bundle) {
                LoginManager.m47440retrieveLoginStatusImpl$lambda2(this.f$0, this.f$1, this.f$2, this.f$3, bundle);
            }
        });
        loginLogger.logLoginStatusStart(uuid);
        if (!loginStatusClient.start()) {
            loginLogger.logLoginStatusFailure(uuid);
            loginStatusCallback.onFailure();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: retrieveLoginStatusImpl$lambda-2  reason: not valid java name */
    public static final void m47440retrieveLoginStatusImpl$lambda2(String str, LoginLogger loginLogger, LoginStatusCallback loginStatusCallback, String str2, Bundle bundle) {
        String str3 = str;
        LoginLogger loginLogger2 = loginLogger;
        LoginStatusCallback loginStatusCallback2 = loginStatusCallback;
        Bundle bundle2 = bundle;
        Intrinsics.checkNotNullParameter(str3, "$loggerRef");
        Intrinsics.checkNotNullParameter(loginLogger2, "$logger");
        Intrinsics.checkNotNullParameter(loginStatusCallback2, "$responseCallback");
        Intrinsics.checkNotNullParameter(str2, "$applicationId");
        if (bundle2 != null) {
            String string = bundle2.getString(NativeProtocol.STATUS_ERROR_TYPE);
            String string2 = bundle2.getString(NativeProtocol.STATUS_ERROR_DESCRIPTION);
            if (string != null) {
                Companion.handleLoginStatusError(string, string2, str, loginLogger, loginStatusCallback);
                return;
            }
            String string3 = bundle2.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
            Utility utility = Utility.INSTANCE;
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle2, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0));
            ArrayList<String> stringArrayList = bundle2.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            String string4 = bundle2.getString(NativeProtocol.RESULT_ARGS_SIGNED_REQUEST);
            String string5 = bundle2.getString("graph_domain");
            Utility utility2 = Utility.INSTANCE;
            Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle2, NativeProtocol.EXTRA_DATA_ACCESS_EXPIRATION_TIME, new Date(0));
            String str4 = null;
            Utility utility3 = Utility.INSTANCE;
            if (!Utility.isNullOrEmpty(string4)) {
                str4 = LoginMethodHandler.Companion.getUserIDFromSignedRequest(string4);
            }
            String str5 = str4;
            if (string3 != null) {
                boolean z = false;
                if ((string3.length() > 0) && stringArrayList != null) {
                    Collection collection = stringArrayList;
                    if ((!collection.isEmpty()) && str5 != null) {
                        if (str5.length() > 0) {
                            z = true;
                        }
                        if (z) {
                            AccessToken accessToken = new AccessToken(string3, str2, str5, collection, (Collection<String>) null, (Collection<String>) null, (AccessTokenSource) null, bundleLongAsDate, (Date) null, bundleLongAsDate2, string5);
                            AccessToken.Companion.setCurrentAccessToken(accessToken);
                            Profile.Companion.fetchProfileForCurrentAccessToken();
                            loginLogger2.logLoginStatusSuccess(str3);
                            loginStatusCallback2.onCompleted(accessToken);
                            return;
                        }
                    }
                }
            }
            loginLogger2.logLoginStatusFailure(str3);
            loginStatusCallback.onFailure();
            return;
        }
        loginLogger2.logLoginStatusFailure(str3);
        loginStatusCallback.onFailure();
    }

    private final void setExpressLoginStatus(boolean z) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putBoolean(EXPRESS_LOGIN_ALLOWED, z);
        edit.apply();
    }

    private final boolean isExpressLoginAllowed() {
        return this.sharedPreferences.getBoolean(EXPRESS_LOGIN_ALLOWED, true);
    }

    @Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/facebook/login/LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate;", "Lcom/facebook/login/StartActivityDelegate;", "activityResultRegistryOwner", "Landroidx/activity/result/ActivityResultRegistryOwner;", "callbackManager", "Lcom/facebook/CallbackManager;", "(Landroidx/activity/result/ActivityResultRegistryOwner;Lcom/facebook/CallbackManager;)V", "activityContext", "Landroid/app/Activity;", "getActivityContext", "()Landroid/app/Activity;", "startActivityForResult", "", "intent", "Landroid/content/Intent;", "requestCode", "", "facebook-common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LoginManager.kt */
    private static final class AndroidxActivityResultRegistryOwnerStartActivityDelegate implements StartActivityDelegate {
        private final ActivityResultRegistryOwner activityResultRegistryOwner;
        private final CallbackManager callbackManager;

        public AndroidxActivityResultRegistryOwnerStartActivityDelegate(ActivityResultRegistryOwner activityResultRegistryOwner2, CallbackManager callbackManager2) {
            Intrinsics.checkNotNullParameter(activityResultRegistryOwner2, "activityResultRegistryOwner");
            Intrinsics.checkNotNullParameter(callbackManager2, "callbackManager");
            this.activityResultRegistryOwner = activityResultRegistryOwner2;
            this.callbackManager = callbackManager2;
        }

        public void startActivityForResult(Intent intent, int i) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            C17731x7971582c loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder = new C17731x7971582c();
            loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.setLauncher(this.activityResultRegistryOwner.getActivityResultRegistry().register("facebook-login", new C17730x357b4191(), new ActivityResultCallback(loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder) {
                public final /* synthetic */ C17731x7971582c f$1;

                {
                    this.f$1 = r2;
                }

                public final void onActivityResult(Object obj) {
                    LoginManager.AndroidxActivityResultRegistryOwnerStartActivityDelegate.m47442startActivityForResult$lambda0(LoginManager.AndroidxActivityResultRegistryOwnerStartActivityDelegate.this, this.f$1, (Pair) obj);
                }
            }));
            ActivityResultLauncher<Intent> launcher = loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.getLauncher();
            if (launcher != null) {
                launcher.launch(intent);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: startActivityForResult$lambda-0  reason: not valid java name */
        public static final void m47442startActivityForResult$lambda0(AndroidxActivityResultRegistryOwnerStartActivityDelegate androidxActivityResultRegistryOwnerStartActivityDelegate, C17731x7971582c loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder, Pair pair) {
            Intrinsics.checkNotNullParameter(androidxActivityResultRegistryOwnerStartActivityDelegate, "this$0");
            Intrinsics.checkNotNullParameter(loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder, "$launcherHolder");
            CallbackManager callbackManager2 = androidxActivityResultRegistryOwnerStartActivityDelegate.callbackManager;
            int requestCode = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
            Object obj = pair.first;
            Intrinsics.checkNotNullExpressionValue(obj, "result.first");
            callbackManager2.onActivityResult(requestCode, ((Number) obj).intValue(), (Intent) pair.second);
            ActivityResultLauncher<Intent> launcher = loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.getLauncher();
            if (launcher != null) {
                launcher.unregister();
            }
            loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.setLauncher((ActivityResultLauncher<Intent>) null);
        }

        public Activity getActivityContext() {
            ActivityResultRegistryOwner activityResultRegistryOwner2 = this.activityResultRegistryOwner;
            if (activityResultRegistryOwner2 instanceof Activity) {
                return (Activity) activityResultRegistryOwner2;
            }
            return null;
        }
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, mo175978d2 = {"Lcom/facebook/login/LoginManager$ActivityStartActivityDelegate;", "Lcom/facebook/login/StartActivityDelegate;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "activityContext", "getActivityContext", "()Landroid/app/Activity;", "startActivityForResult", "", "intent", "Landroid/content/Intent;", "requestCode", "", "facebook-common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LoginManager.kt */
    private static final class ActivityStartActivityDelegate implements StartActivityDelegate {
        private final Activity activityContext;

        public ActivityStartActivityDelegate(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.activityContext = activity;
        }

        public Activity getActivityContext() {
            return this.activityContext;
        }

        public void startActivityForResult(Intent intent, int i) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            getActivityContext().startActivityForResult(intent, i);
        }
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/facebook/login/LoginManager$FragmentStartActivityDelegate;", "Lcom/facebook/login/StartActivityDelegate;", "fragment", "Lcom/facebook/internal/FragmentWrapper;", "(Lcom/facebook/internal/FragmentWrapper;)V", "activityContext", "Landroid/app/Activity;", "getActivityContext", "()Landroid/app/Activity;", "startActivityForResult", "", "intent", "Landroid/content/Intent;", "requestCode", "", "facebook-common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LoginManager.kt */
    private static final class FragmentStartActivityDelegate implements StartActivityDelegate {
        private final Activity activityContext;
        private final FragmentWrapper fragment;

        public FragmentStartActivityDelegate(FragmentWrapper fragmentWrapper) {
            Intrinsics.checkNotNullParameter(fragmentWrapper, "fragment");
            this.fragment = fragmentWrapper;
            this.activityContext = fragmentWrapper.getActivity();
        }

        public void startActivityForResult(Intent intent, int i) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.fragment.startActivityForResult(intent, i);
        }

        public Activity getActivityContext() {
            return this.activityContext;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/facebook/login/LoginManager$LoginLoggerHolder;", "", "()V", "logger", "Lcom/facebook/login/LoginLogger;", "getLogger", "context", "Landroid/content/Context;", "facebook-common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LoginManager.kt */
    private static final class LoginLoggerHolder {
        public static final LoginLoggerHolder INSTANCE = new LoginLoggerHolder();
        private static LoginLogger logger;

        private LoginLoggerHolder() {
        }

        public final synchronized LoginLogger getLogger(Context context) {
            if (context == null) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                context = FacebookSdk.getApplicationContext();
            }
            if (context == null) {
                return null;
            }
            if (logger == null) {
                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                logger = new LoginLogger(context, FacebookSdk.getApplicationId());
            }
            return logger;
        }
    }

    @Metadata(mo175977d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J \u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\b\u0010\u001c\u001a\u00020\fH\u0017J2\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006)"}, mo175978d2 = {"Lcom/facebook/login/LoginManager$Companion;", "", "()V", "EXPRESS_LOGIN_ALLOWED", "", "MANAGE_PERMISSION_PREFIX", "OTHER_PUBLISH_PERMISSIONS", "", "PREFERENCE_LOGIN_MANAGER", "PUBLISH_PERMISSION_PREFIX", "TAG", "instance", "Lcom/facebook/login/LoginManager;", "otherPublishPermissions", "getOtherPublishPermissions", "()Ljava/util/Set;", "computeLoginResult", "Lcom/facebook/login/LoginResult;", "request", "Lcom/facebook/login/LoginClient$Request;", "newToken", "Lcom/facebook/AccessToken;", "newIdToken", "Lcom/facebook/AuthenticationToken;", "getExtraDataFromIntent", "", "intent", "Landroid/content/Intent;", "getInstance", "handleLoginStatusError", "", "errorType", "errorDescription", "loggerRef", "logger", "Lcom/facebook/login/LoginLogger;", "responseCallback", "Lcom/facebook/LoginStatusCallback;", "isPublishPermission", "", "permission", "facebook-common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LoginManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public LoginManager getInstance() {
            if (LoginManager.instance == null) {
                synchronized (this) {
                    Companion companion = LoginManager.Companion;
                    LoginManager.instance = new LoginManager();
                    Unit unit = Unit.INSTANCE;
                }
            }
            LoginManager access$getInstance$cp = LoginManager.instance;
            if (access$getInstance$cp != null) {
                return access$getInstance$cp;
            }
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            throw null;
        }

        @JvmStatic
        public final Map<String, String> getExtraDataFromIntent(Intent intent) {
            if (intent == null) {
                return null;
            }
            intent.setExtrasClassLoader(LoginClient.Result.class.getClassLoader());
            LoginClient.Result result = (LoginClient.Result) intent.getParcelableExtra(LoginFragment.RESULT_KEY);
            if (result == null) {
                return null;
            }
            return result.extraData;
        }

        @JvmStatic
        public final boolean isPublishPermission(String str) {
            if (str == null) {
                return false;
            }
            if (StringsKt.startsWith$default(str, LoginManager.PUBLISH_PERMISSION_PREFIX, false, 2, (Object) null) || StringsKt.startsWith$default(str, LoginManager.MANAGE_PERMISSION_PREFIX, false, 2, (Object) null) || LoginManager.OTHER_PUBLISH_PERMISSIONS.contains(str)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        public final Set<String> getOtherPublishPermissions() {
            return SetsKt.setOf("ads_management", "create_event", "rsvp_event");
        }

        @JvmStatic
        public final LoginResult computeLoginResult(LoginClient.Request request, AccessToken accessToken, AuthenticationToken authenticationToken) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(accessToken, "newToken");
            Set<String> permissions = request.getPermissions();
            Set mutableSet = CollectionsKt.toMutableSet(CollectionsKt.filterNotNull(accessToken.getPermissions()));
            if (request.isRerequest()) {
                mutableSet.retainAll(permissions);
            }
            Set mutableSet2 = CollectionsKt.toMutableSet(CollectionsKt.filterNotNull(permissions));
            mutableSet2.removeAll(mutableSet);
            return new LoginResult(accessToken, authenticationToken, mutableSet, mutableSet2);
        }

        /* access modifiers changed from: private */
        public final void handleLoginStatusError(String str, String str2, String str3, LoginLogger loginLogger, LoginStatusCallback loginStatusCallback) {
            Exception facebookException = new FacebookException(str + ": " + str2);
            loginLogger.logLoginStatusError(str3, facebookException);
            loginStatusCallback.onError(facebookException);
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        OTHER_PUBLISH_PERMISSIONS = companion.getOtherPublishPermissions();
        String cls = LoginManager.class.toString();
        Intrinsics.checkNotNullExpressionValue(cls, "LoginManager::class.java.toString()");
        TAG = cls;
    }
}
