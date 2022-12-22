package com.didi.beatles.p099im.access;

import android.content.Context;
import android.net.Uri;
import com.didi.beatles.p099im.access.audio.IMAudioConfig;
import com.didi.beatles.p099im.api.url.IMApiUrlEmpty;
import com.didi.beatles.p099im.api.url.IMBaseUrl;
import com.didi.beatles.p099im.api.url.IMBaseUrlAdmin;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: com.didi.beatles.im.access.IMCommonContext */
public abstract class IMCommonContext {
    public int getActivityTheme() {
        return 0;
    }

    public abstract int getAppChannel();

    public abstract Class<?> getAppMainClass();

    public abstract String getCurrenLoginUser();

    public abstract String getDeviceId();

    public abstract boolean getIMBottomConfig(int i);

    public Locale getLocale() {
        return null;
    }

    public abstract Uri getNotificationSoundUri();

    public String getPayload(String str) {
        return null;
    }

    public abstract ArrayList<String> getQuickReplyList(int i);

    public abstract String getToken();

    public abstract long getUid();

    public abstract String getVersionName();

    @Deprecated
    public String getWebActivityScheme() {
        return null;
    }

    public boolean handLink(Context context, String str) {
        return false;
    }

    public abstract boolean isLoginNow();

    public abstract boolean isMainActivityAlive();

    public boolean isMoveInnerStorage() {
        return false;
    }

    public boolean isPad() {
        return false;
    }

    @Deprecated
    public boolean isUseInnerStorage() {
        return false;
    }

    public String locationTopScheme() {
        return null;
    }

    public String setSettingPageScheme() {
        return null;
    }

    public boolean showFeed() {
        return false;
    }

    public boolean useDecorFloatStyle() {
        return false;
    }

    public IMBaseUrl getIMUrlDelegate() {
        Iterator<S> it = ServiceLoader.load(IMBaseUrlAdmin.class).iterator();
        IMBaseUrl iMBaseUrl = it.hasNext() ? (IMBaseUrl) it.next() : null;
        return iMBaseUrl == null ? new IMApiUrlEmpty() : iMBaseUrl;
    }

    public IMAudioConfig getAudioConfig() {
        return new IMAudioConfig();
    }
}
