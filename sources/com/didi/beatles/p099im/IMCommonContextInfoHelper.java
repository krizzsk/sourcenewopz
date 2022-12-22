package com.didi.beatles.p099im;

import android.content.Context;
import android.os.Looper;
import com.didi.beatles.p099im.access.IMCommonContext;
import com.didi.beatles.p099im.access.audio.IMAudioConfig;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.UiThreadHandler;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: com.didi.beatles.im.IMCommonContextInfoHelper */
public class IMCommonContextInfoHelper {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static volatile IMCommonContext f8682a = null;

    /* renamed from: b */
    private static final String f8683b = "im-sdk";

    /* renamed from: c */
    private static Context f8684c;

    /* renamed from: d */
    private static boolean f8685d;

    /* renamed from: e */
    private static boolean f8686e;

    /* renamed from: f */
    private static IMAudioConfig f8687f;

    public static boolean getBottomConfig(int i) {
        return true;
    }

    public static ArrayList<String> getEmojiList() {
        return null;
    }

    public static int getRecentMessagesCount4Feed(long j) {
        return j == 1153205327579062703L ? 2 : 6;
    }

    public static void inject(Context context, IMCommonContext iMCommonContext) {
        f8682a = iMCommonContext;
        f8684c = context.getApplicationContext();
    }

    public static boolean isInject() {
        return f8682a != null;
    }

    public static boolean isUseFeed() {
        if (!f8686e) {
            f8685d = f8682a != null ? f8682a.showFeed() : false;
            f8686e = true;
        }
        return f8685d;
    }

    public static void destory() {
        if (f8682a == null) {
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            f8682a = null;
        } else {
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    IMCommonContext unused = IMCommonContextInfoHelper.f8682a = null;
                }
            });
        }
    }

    public static boolean isLogingNow() {
        if (f8682a != null) {
            return f8682a.isLoginNow();
        }
        return false;
    }

    public static long getUid() {
        if (f8682a != null) {
            return f8682a.getUid();
        }
        return 0;
    }

    public static String getToken() {
        return f8682a != null ? f8682a.getToken() : "ErrorToken";
    }

    public static String getAppVersion() {
        return f8682a != null ? f8682a.getVersionName() : "ErrorVersion";
    }

    public static Context getContext() {
        return f8684c;
    }

    public static String getDeviceId() {
        return f8682a != null ? f8682a.getDeviceId() : "ErrorDeviceId";
    }

    public static IMCommonContext getInfoProvider() {
        return f8682a;
    }

    public static Class<?> getAppMainClass() {
        if (f8682a != null) {
            return f8682a.getAppMainClass();
        }
        return null;
    }

    public static boolean isMainActivityAlive() {
        if (f8682a != null) {
            return f8682a.isMainActivityAlive();
        }
        return false;
    }

    public static String getBusinessPayload(String str) {
        if (f8682a != null) {
            return f8682a.getPayload(str);
        }
        IMLog.m6631d(f8683b, "getBusinessPayload failed while sInfoProvider is null !");
        return null;
    }

    public static boolean isUseInnerStorage() {
        if (f8682a != null) {
            return f8682a.isUseInnerStorage();
        }
        return false;
    }

    public static boolean isPad() {
        if (f8682a != null) {
            return f8682a.isPad();
        }
        return false;
    }

    public static int getAppChannel() {
        if (f8682a != null) {
            return f8682a.getAppChannel();
        }
        return 0;
    }

    public static int getActivityTheme() {
        if (f8682a != null) {
            return f8682a.getActivityTheme();
        }
        return 0;
    }

    public static String getWebActivityScheme() {
        if (f8682a != null) {
            return f8682a.getWebActivityScheme();
        }
        return null;
    }

    public static boolean handLink(Context context, String str) {
        if (f8682a != null) {
            return f8682a.handLink(context, str);
        }
        return false;
    }

    public static String setSettingPageScheme() {
        if (f8682a != null) {
            return f8682a.setSettingPageScheme();
        }
        return null;
    }

    public static Locale getLocale() {
        if (f8682a != null) {
            return f8682a.getLocale();
        }
        return null;
    }

    public static String getPackageName() {
        Context context = f8684c;
        return context != null ? context.getPackageName() : "null";
    }

    public static IMAudioConfig getAudioConfig() {
        if (f8687f == null) {
            IMAudioConfig iMAudioConfig = null;
            if (f8682a != null) {
                iMAudioConfig = f8682a.getAudioConfig();
            }
            if (iMAudioConfig == null) {
                iMAudioConfig = new IMAudioConfig();
            }
            f8687f = iMAudioConfig;
        }
        return f8687f;
    }
}
