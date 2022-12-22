package com.didi.unifylogin.third;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.LoginTypeParam;
import com.didi.unifylogin.base.net.pojo.response.LoginTypeResponse;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u0010\u0011\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/unifylogin/third/LoginTypeManager;", "", "()V", "KEY_LOGIN_TYPE_LIST", "", "KEY_LOGIN_TYPE_TIMESTAMP", "PREF_NAME", "checkIfExpired", "", "context", "Landroid/content/Context;", "getLoginTypeList", "", "listener", "Lcom/didi/unifylogin/third/LoginTypeListListener;", "refreshLoginType", "requestLoginType", "updatePref", "response", "Lcom/didi/unifylogin/base/net/pojo/response/LoginTypeResponse;", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: LoginTypeManager.kt */
public final class LoginTypeManager {
    public static final LoginTypeManager INSTANCE = new LoginTypeManager();

    /* renamed from: a */
    private static final String f44895a = "login_pref";

    /* renamed from: b */
    private static final String f44896b = "login_type_timestamp";

    /* renamed from: c */
    private static final String f44897c = "login_type_list";

    private LoginTypeManager() {
    }

    public final void getLoginTypeList(Context context, LoginTypeListListener loginTypeListListener) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(loginTypeListListener, "listener");
        if (m32199a(context)) {
            m32198a(context, loginTypeListListener);
            return;
        }
        String string = SystemUtils.getSharedPreferences(context, f44895a, 0).getString(f44897c, "");
        Type type = new LoginTypeManager$getLoginTypeList$type$1().getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "object : TypeToken<ArrayList<String?>?>() {}.type");
        Object fromJson = new Gson().fromJson(string, type);
        Intrinsics.checkExpressionValueIsNotNull(fromJson, "Gson().fromJson(typeList, type)");
        loginTypeListListener.onResult((List) fromJson);
    }

    public final void refreshLoginType(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (m32199a(context)) {
            m32198a(context, (LoginTypeListListener) null);
        }
    }

    /* renamed from: a */
    private final boolean m32199a(Context context) {
        if (System.currentTimeMillis() - SystemUtils.getSharedPreferences(context, f44895a, 0).getLong(f44896b, 0) > ((long) 3600000)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private final void m32198a(Context context, LoginTypeListListener loginTypeListListener) {
        LoginModel.getFlutterNet(context).getLoginType(new LoginTypeParam(context, LoginScene.SCENE_UNDEFINED.getSceneNum()), new LoginTypeManager$requestLoginType$1(context, loginTypeListListener));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m32197a(Context context, LoginTypeResponse loginTypeResponse) {
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(context, f44895a, 0).edit();
        edit.putLong(f44896b, System.currentTimeMillis());
        edit.putString(f44897c, new Gson().toJson((Object) loginTypeResponse != null ? loginTypeResponse.getLoginTypeList() : null));
        edit.apply();
    }
}
