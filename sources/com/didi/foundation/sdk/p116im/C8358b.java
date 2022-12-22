package com.didi.foundation.sdk.p116im;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.didi.beatles.p099im.access.IMContext;
import com.didi.beatles.p099im.api.url.IMApiUrlGlobal;
import com.didi.beatles.p099im.api.url.IMBaseUrl;
import com.didi.foundation.sdk.log.LogService;
import com.didi.foundation.sdk.login.LoginService;
import com.didi.foundation.sdk.login.LoginServiceProvider;
import com.didi.sdk.logging.Logger;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: com.didi.foundation.sdk.im.b */
/* compiled from: FoundationIMContext */
class C8358b extends IMContext {

    /* renamed from: a */
    private Logger f21178a = LogService.getLogger("FoundationIMContext");

    /* renamed from: b */
    private final Application f21179b;

    /* renamed from: c */
    private final IMContextProvider f21180c;

    /* renamed from: d */
    private LoginServiceProvider f21181d = LoginService.getInstance();

    public String getCurrenLoginUser() {
        return null;
    }

    public boolean getIMBottomConfig(int i) {
        return false;
    }

    public Uri getNotificationSoundUri() {
        return null;
    }

    C8358b(Application application, IMContextProvider iMContextProvider) {
        this.f21179b = application;
        this.f21180c = iMContextProvider;
    }

    public long getUid() {
        try {
            return Long.parseLong(this.f21181d.getUid());
        } catch (NumberFormatException e) {
            Logger logger = this.f21178a;
            logger.error("getUid error: " + e, new Object[0]);
            return 0;
        }
    }

    public String getToken() {
        return this.f21181d.getToken();
    }

    public boolean isLoginNow() {
        return this.f21181d.isLogin();
    }

    public String getDeviceId() {
        return this.f21180c.getDeviceId();
    }

    public String getVersionName() {
        return this.f21180c.getVersionName();
    }

    public Class<?> getAppMainClass() {
        return this.f21180c.getAppMainClass();
    }

    public boolean isMainActivityAlive() {
        return this.f21180c.isMainActivityAlive();
    }

    public ArrayList<String> getQuickReplyList(int i) {
        return this.f21180c.getQuickReplyList(i);
    }

    public IMBaseUrl getIMUrlDelegate() {
        return new IMApiUrlGlobal();
    }

    public String getWebActivityScheme() {
        return this.f21180c.getWebActivityScheme();
    }

    public int getAppChannel() {
        return this.f21180c.getAppChannel();
    }

    public int getActivityTheme() {
        return this.f21180c.getActivityTheme();
    }

    public boolean isPad() {
        return this.f21180c.isPad();
    }

    public Locale getLocale() {
        return this.f21180c.getLocale();
    }

    public boolean handLink(Context context, String str) {
        return this.f21180c.handleLink(context, str);
    }

    public boolean isMoveInnerStorage() {
        return this.f21180c.isMoveInnerStorage();
    }

    public String locationTopScheme() {
        return this.f21180c.locationTopScheme();
    }

    public boolean useDecorFloatStyle() {
        return this.f21180c.useDecorFloatStyle();
    }
}
