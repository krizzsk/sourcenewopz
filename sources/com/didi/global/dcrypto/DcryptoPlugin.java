package com.didi.global.dcrypto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didi.thirdpartylogin.base.ThirdPartyLoginManager;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.country.CountryListActivity;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.SmsUtils;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.embedding.engine.plugins.activity.ActivityAware;
import p242io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;
import p242io.flutter.plugin.common.PluginRegistry;

public class DcryptoPlugin implements FlutterPlugin, ActivityAware, MethodChannel.MethodCallHandler {
    public static final String CHANNEL_NAME = "dcrypto_channel";

    /* renamed from: c */
    private static final int f21398c = 1024;

    /* renamed from: g */
    private static final String f21399g = "com.taxis99";

    /* renamed from: h */
    private static final String f21400h = "com.pay99.wallet";

    /* renamed from: i */
    private static final String f21401i = "com.didi.payment.commonsdk.widget";

    /* renamed from: j */
    private static final String f21402j = "com.didiglobal.wallet.frame.widget";

    /* renamed from: k */
    private static final String f21403k = ".WalletToastNew";

    /* renamed from: a */
    private MethodChannel f21404a;

    /* renamed from: b */
    private WeakReference<Activity> f21405b;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MethodChannel.Result f21406d;

    /* renamed from: e */
    private Logger f21407e = LoggerFactory.getLogger("DcryptoPlugin");

    /* renamed from: f */
    private SmsUtils f21408f;

    public void onDetachedFromActivityForConfigChanges() {
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), CHANNEL_NAME);
        this.f21404a = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new MethodChannel(registrar.messenger(), CHANNEL_NAME).setMethodCallHandler(new DcryptoPlugin());
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        MethodCall methodCall2 = methodCall;
        MethodChannel.Result result2 = result;
        Logger logger = this.f21407e;
        logger.debug("dcryptoplugintest onMethodCall:" + methodCall2.method, new Object[0]);
        Logger logger2 = this.f21407e;
        logger2.debug("dcryptoplugintest arguments:" + methodCall2.arguments, new Object[0]);
        Activity activity = (Activity) this.f21405b.get();
        if (methodCall2.method.equals("selectCountryCode")) {
            if (activity != null) {
                Intent intent = new Intent(activity, CountryListActivity.class);
                intent.putExtra(CountryListActivity.SEND_RESULT_2_CALLER, true);
                activity.startActivityForResult(intent, 1024);
                this.f21406d = result2;
            } else {
                result2.success("");
            }
        }
        String str = methodCall2.method;
        char c = 65535;
        switch (str.hashCode()) {
            case -1845096254:
                if (str.equals("dcrypto_set_EducatedFlag")) {
                    c = 2;
                    break;
                }
                break;
            case -739329482:
                if (str.equals("dcrypto_get_token")) {
                    c = 0;
                    break;
                }
                break;
            case -713166700:
                if (str.equals("dcrypto_go_bitCoinTab")) {
                    c = 3;
                    break;
                }
                break;
            case 543114104:
                if (str.equals("dcrypto_native_parameters")) {
                    c = 1;
                    break;
                }
                break;
            case 1348957350:
                if (str.equals("dcrypto_call_native_toast")) {
                    c = 5;
                    break;
                }
                break;
            case 1542179859:
                if (str.equals("testMethod")) {
                    c = 4;
                    break;
                }
                break;
        }
        if (c == 0) {
            SystemUtils.log(4, "methodchannel", "MethodChannel result: [start]" + methodCall2.method, (Throwable) null, "com.didi.global.dcrypto.DcryptoPlugin", 115);
            String token = OneLoginFacade.getStore().getToken();
            SystemUtils.log(4, "methodchannel", "MethodChannel result: [end]" + methodCall2.method, (Throwable) null, "com.didi.global.dcrypto.DcryptoPlugin", 117);
            result2.success(token);
        } else if (c == 1) {
            SystemUtils.log(4, "methodchannel", "MethodChannel result: [start]" + methodCall2.method, (Throwable) null, "com.didi.global.dcrypto.DcryptoPlugin", 121);
            SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(activity.getApplicationContext(), "MyPref", 0);
            String string = sharedPreferences.getString("env_env", "");
            String string2 = sharedPreferences.getString("env_terminal_id", "");
            HashMap hashMap = new HashMap();
            hashMap.put("env", string);
            hashMap.put("terminal_id", string2);
            SystemUtils.log(4, "methodchannel", "MethodChannel result: [end]" + methodCall2.method, (Throwable) null, "com.didi.global.dcrypto.DcryptoPlugin", 130);
            result2.success(hashMap);
        } else if (c == 2) {
            SystemUtils.log(4, "methodchannel", "MethodChannel result: [start]" + methodCall2.method, (Throwable) null, "com.didi.global.dcrypto.DcryptoPlugin", 134);
            SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(activity, "DcryptoSharedPreference", 0).edit();
            edit.putBoolean("DCryptoFirstLaunch", true);
            edit.apply();
            SystemUtils.log(4, "methodchannel", "MethodChannel result: [end]" + methodCall2.method, (Throwable) null, "com.didi.global.dcrypto.DcryptoPlugin", 140);
            result2.success("success");
        } else if (c == 3) {
            SystemUtils.log(4, "methodchannel", "MethodChannel result: [Start]" + methodCall2.method, (Throwable) null, "com.didi.global.dcrypto.DcryptoPlugin", 144);
            try {
                ((Request) ((Request) DRouter.build("99OneTravel://one/bitcoin").putExtra("env", "sim113")).putExtra("terminal_id", "5")).start(activity.getApplicationContext());
            } catch (Exception e) {
                e.printStackTrace();
            }
            SystemUtils.log(4, "methodchannel", "MethodChannel result: [End]" + methodCall2.method, (Throwable) null, "com.didi.global.dcrypto.DcryptoPlugin", 150);
            result2.success("success");
        } else if (c == 4) {
            SystemUtils.log(4, "methodchannel", "MethodChannel result: [Start]" + methodCall2.method, (Throwable) null, "com.didi.global.dcrypto.DcryptoPlugin", 154);
            result2.success("test yi method success from kotlin 99payandroid GlobalWallet");
            SystemUtils.log(4, "methodchannel", "MethodChannel result: [End]" + methodCall2.method, (Throwable) null, "com.didi.global.dcrypto.DcryptoPlugin", 156);
        } else if (c == 5) {
            SystemUtils.log(4, "methodchannel", "MethodChannel result: [Start]" + methodCall2.method, (Throwable) null, "com.didi.global.dcrypto.DcryptoPlugin", 159);
            if (methodCall2.argument("message") != null) {
                SystemUtils.log(4, "methodchannel", "dcrypto_call_native_toast message = " + methodCall2.argument("message") + " packageName = " + methodCall2.argument("packageName"), (Throwable) null, "com.didi.global.dcrypto.DcryptoPlugin", 161);
                m15717a(methodCall2.argument("message").toString(), methodCall2.argument("packageName").toString());
            } else {
                SystemUtils.log(4, "methodchannel", "dcrypto_call_native_toast message = [EMPTY]", (Throwable) null, "com.didi.global.dcrypto.DcryptoPlugin", 164);
            }
            SystemUtils.log(4, "methodchannel", "MethodChannel result: [End]" + methodCall2.method, (Throwable) null, "com.didi.global.dcrypto.DcryptoPlugin", 166);
        }
    }

    /* renamed from: a */
    private void m15717a(String str, String str2) {
        String str3 = str2.equalsIgnoreCase(f21400h) ? f21402j : f21401i;
        SystemUtils.log(4, "methodchannel", "dcrypto_call_native_toast message [ShowMessageInNative] = " + str + " packageName = " + str3, (Throwable) null, "com.didi.global.dcrypto.DcryptoPlugin", 179);
        try {
            Method declaredMethod = Class.forName(str3 + f21403k).getDeclaredMethod("showFailedMsg", new Class[]{Context.class, String.class});
            PrintStream printStream = System.out;
            printStream.println("method = " + declaredMethod.toString());
            declaredMethod.invoke((Object) null, new Object[]{((Activity) this.f21405b.get()).getApplicationContext(), str});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f21404a.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        this.f21405b = new WeakReference<>(activityPluginBinding.getActivity());
        activityPluginBinding.addActivityResultListener(new PluginRegistry.ActivityResultListener() {
            public boolean onActivityResult(int i, int i2, Intent intent) {
                if (i == 1024 && DcryptoPlugin.this.f21406d != null) {
                    if (i2 == -1) {
                        try {
                            DcryptoPlugin.this.f21406d.success(((CountryListResponse.CountryRule) intent.getSerializableExtra("country")).toJSON());
                        } catch (JSONException e) {
                            e.printStackTrace();
                            DcryptoPlugin.this.f21406d.success("");
                        }
                    } else {
                        DcryptoPlugin.this.f21406d.success("");
                    }
                    return true;
                } else if (i == 2000 && DcryptoPlugin.this.f21406d != null) {
                    DcryptoPlugin.this.m15714a(i2, intent);
                    return true;
                } else if (ThirdPartyLoginManager.getThirdPartyLogins() == null) {
                    return false;
                } else {
                    for (AbsThirdPartyLoginBase handleLoginResult : ThirdPartyLoginManager.getThirdPartyLogins()) {
                        handleLoginResult.handleLoginResult(i, i2, intent);
                    }
                    return false;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15714a(int i, Intent intent) {
        if (i != -1 || intent == null) {
            CredentialsApi credentialsApi = Auth.CredentialsApi;
            if (i == 1001) {
                m15716a(this.f21406d);
                new LoginOmegaUtil("login_credential_picker_other_ck").send();
                return;
            }
            CredentialsApi credentialsApi2 = Auth.CredentialsApi;
            if (i == 1002) {
                m15716a(this.f21406d);
                new LoginOmegaUtil("login_credential_picker_no_hint").send();
                return;
            }
            m15716a(this.f21406d);
            return;
        }
        try {
            Credential credential = (Credential) intent.getParcelableExtra(Credential.EXTRA_KEY);
            if (credential != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errno", 0);
                jSONObject.put("error", "");
                jSONObject.put("firstName", credential.getGivenName());
                jSONObject.put("lastName", credential.getFamilyName());
                jSONObject.put("email", credential.getId());
                new LoginOmegaUtil("login_credential_picker_ck").send();
                this.f21406d.success(jSONObject.toString());
                return;
            }
            m15716a(this.f21406d);
        } catch (Exception e) {
            e.printStackTrace();
            m15716a(this.f21406d);
        }
    }

    /* renamed from: a */
    private void m15716a(MethodChannel.Result result) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errno", -1);
            jSONObject.put("error", "");
            result.success(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            result.success(new HashMap());
        }
    }

    public void onDetachedFromActivity() {
        this.f21406d = null;
        SmsUtils smsUtils = this.f21408f;
        if (smsUtils != null) {
            smsUtils.unRegisteSmsRetriever((Context) this.f21405b.get());
            this.f21408f = null;
        }
        this.f21405b.clear();
    }
}
