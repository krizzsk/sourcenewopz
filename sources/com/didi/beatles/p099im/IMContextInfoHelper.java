package com.didi.beatles.p099im;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.didi.beatles.p099im.access.IMContext;
import com.didi.beatles.p099im.access.audio.IMAudioConfig;
import com.didi.beatles.p099im.access.briage.IMCustomChatRowProviderImpl;
import com.didi.beatles.p099im.access.style.IMStyleManager;
import com.didi.beatles.p099im.access.style.custom.IMCustomResBuilder;
import com.didi.beatles.p099im.access.style.custom.IMCustomViewBuilder;
import com.didi.beatles.p099im.access.utils.IMBusinessConfig;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.views.IMCustomChatRowProvider;
import com.didichuxing.apollo.sdk.Apollo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: com.didi.beatles.im.IMContextInfoHelper */
public class IMContextInfoHelper {

    /* renamed from: a */
    private static IMContext f8688a = null;

    /* renamed from: b */
    private static final String f8689b = "im-sdk";

    /* renamed from: c */
    private static Context f8690c = null;

    /* renamed from: d */
    private static boolean f8691d = false;

    /* renamed from: e */
    private static boolean f8692e = false;

    /* renamed from: f */
    private static IMAudioConfig f8693f = null;

    /* renamed from: g */
    private static int f8694g = -1;

    /* renamed from: h */
    private static int f8695h = -1;

    /* renamed from: i */
    private static int f8696i = -1;

    /* renamed from: j */
    private static boolean f8697j = false;

    /* renamed from: k */
    private static boolean f8698k = false;

    public static boolean getBottomConfig(int i) {
        return true;
    }

    public static ArrayList<String> getEmojiList() {
        return null;
    }

    public static int getRecentMessagesCount4Feed(long j) {
        return j == 1153205327579062703L ? 2 : 6;
    }

    @Deprecated
    public static boolean isCipherDisable() {
        return true;
    }

    public static void inject(Context context, IMContext iMContext) {
        f8688a = iMContext;
        f8690c = context.getApplicationContext();
        IMCommonContextInfoHelper.inject(context, iMContext);
    }

    public static boolean isInject() {
        return f8688a != null;
    }

    public static boolean isUseFeed() {
        if (!f8692e) {
            IMContext iMContext = f8688a;
            f8691d = iMContext != null ? iMContext.showFeed() : false;
            f8692e = true;
        }
        return f8691d;
    }

    public static String locationTopScheme() {
        IMContext iMContext = f8688a;
        if (iMContext != null) {
            return iMContext.locationTopScheme();
        }
        return null;
    }

    public static void destory() {
        if (f8688a != null) {
            f8688a = null;
        }
    }

    public static boolean isLogingNow() {
        IMContext iMContext = f8688a;
        if (iMContext != null) {
            return iMContext.isLoginNow();
        }
        return false;
    }

    public static long getUid() {
        IMContext iMContext = f8688a;
        if (iMContext != null) {
            return iMContext.getUid();
        }
        return 0;
    }

    public static String getToken() {
        IMContext iMContext = f8688a;
        return iMContext != null ? iMContext.getToken() : "ErrorToken";
    }

    public static String getAppVersion() {
        IMContext iMContext = f8688a;
        return iMContext != null ? iMContext.getVersionName() : "ErrorVersion";
    }

    public static Context getContext() {
        return f8690c;
    }

    public static String getDeviceId() {
        IMContext iMContext = f8688a;
        return iMContext != null ? iMContext.getDeviceId() : "ErrorDeviceId";
    }

    public static IMContext getInfoProvider() {
        return f8688a;
    }

    public static IMCustomChatRowProvider getRegisterMessageCardView() {
        return new IMCustomChatRowProviderImpl(f8690c);
    }

    public static Class<?> getAppMainClass() {
        IMContext iMContext = f8688a;
        if (iMContext != null) {
            return iMContext.getAppMainClass();
        }
        return null;
    }

    public static boolean isMainActivityAlive() {
        IMContext iMContext = f8688a;
        if (iMContext != null) {
            return iMContext.isMainActivityAlive();
        }
        return false;
    }

    public static Uri getNotificationSoundUri() {
        IMContext iMContext = f8688a;
        if (iMContext != null) {
            return iMContext.getNotificationSoundUri();
        }
        return null;
    }

    public static ArrayList<String> getQuickReplyList(int i) {
        IMContext iMContext = f8688a;
        if (iMContext != null && iMContext.getQuickReplyList(i) != null && f8688a.getQuickReplyList(i).size() > 0) {
            return f8688a.getQuickReplyList(i);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Context context = f8690c;
        if (context != null) {
            String[] stringArray = context.getResources().getStringArray(R.array.im_default_word_list);
            if (stringArray != null && stringArray.length > 0) {
                for (String add : stringArray) {
                    arrayList.add(add);
                }
            }
        } else {
            IMLog.m6632e(f8689b, "get local default quicklist failed because mcontext is null");
        }
        return arrayList;
    }

    public static String getBusinessPayload(String str) {
        IMContext iMContext = f8688a;
        if (iMContext != null) {
            return iMContext.getPayload(str);
        }
        IMLog.m6631d(f8689b, "getBusinessPayload failed while sInfoProvider is null !");
        return null;
    }

    public static boolean isUseInnerStorage() {
        IMContext iMContext = f8688a;
        if (iMContext != null) {
            return iMContext.isUseInnerStorage();
        }
        return false;
    }

    public static boolean isPad() {
        IMContext iMContext = f8688a;
        if (iMContext != null) {
            return iMContext.isPad();
        }
        return false;
    }

    public static int getAppChannel() {
        IMContext iMContext = f8688a;
        if (iMContext != null) {
            return iMContext.getAppChannel();
        }
        return 0;
    }

    public static int getActivityTheme() {
        IMContext iMContext = f8688a;
        if (iMContext != null) {
            return iMContext.getActivityTheme();
        }
        return 0;
    }

    public static String getWebActivityScheme() {
        IMContext iMContext = f8688a;
        if (iMContext != null) {
            return iMContext.getWebActivityScheme();
        }
        return null;
    }

    public static boolean handLink(Context context, String str) {
        IMContext iMContext = f8688a;
        if (iMContext != null) {
            return iMContext.handLink(context, str);
        }
        return false;
    }

    public static String setSettingPageScheme() {
        IMContext iMContext = f8688a;
        if (iMContext != null) {
            return iMContext.setSettingPageScheme();
        }
        return null;
    }

    public static Locale getLocale() {
        IMContext iMContext = f8688a;
        if (iMContext != null) {
            return iMContext.getLocale();
        }
        return null;
    }

    public static String getPackageName() {
        Context context = f8690c;
        return context != null ? context.getPackageName() : "null";
    }

    public static IMAudioConfig getAudioConfig() {
        if (f8693f == null) {
            IMAudioConfig iMAudioConfig = null;
            IMContext iMContext = f8688a;
            if (iMContext != null) {
                iMAudioConfig = iMContext.getAudioConfig();
            }
            if (iMAudioConfig == null) {
                iMAudioConfig = new IMAudioConfig();
            }
            f8693f = iMAudioConfig;
        }
        return f8693f;
    }

    public static IMBusinessConfig getDefaultBusinessConfig() {
        IMContext iMContext = f8688a;
        if (iMContext != null) {
            return iMContext.getDefaultBusinessConfig();
        }
        return null;
    }

    public static boolean isMoveCipher() {
        IMContext iMContext = f8688a;
        if (iMContext != null && iMContext.isMoveInnerStorage()) {
            return true;
        }
        if (f8694g < 0) {
            f8694g = ((Integer) Apollo.getToggle("IM_Config_Encrypt_China").getExperiment().getParam("is_open_encrypt", 0)).intValue();
        }
        if (1 == f8694g) {
            return true;
        }
        return false;
    }

    public static boolean isNewInnerFlow() {
        IMContext iMContext = f8688a;
        if (iMContext != null && iMContext.isMoveInnerStorage()) {
            return true;
        }
        if (f8695h < 0) {
            f8695h = ((Integer) Apollo.getToggle("IM_Config_Decrypt_China_Android").getExperiment().getParam("is_open_decrypt", 0)).intValue();
        }
        if (1 == f8695h) {
            return true;
        }
        return false;
    }

    public static boolean enableSendImage() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static IMStyleManager.Style getStyle() {
        IMContext iMContext = f8688a;
        if (iMContext == null) {
            return IMStyleManager.Style.DEFAULT;
        }
        return iMContext.getIMStyle();
    }

    public static IMCustomViewBuilder getCustomViewBuilder() {
        IMContext iMContext = f8688a;
        if (iMContext == null) {
            return null;
        }
        return iMContext.getCustomViewBuilder();
    }

    public static IMCustomResBuilder getCustomResBuilder() {
        IMContext iMContext = f8688a;
        if (iMContext == null) {
            return null;
        }
        return iMContext.getCustomResBuilder();
    }

    public static boolean isUseDecorFloatStyle() {
        if (!f8698k) {
            IMContext iMContext = f8688a;
            boolean z = iMContext != null && iMContext.useDecorFloatStyle();
            f8697j = z;
            f8698k = true;
            IMLog.m6631d(f8689b, C4234I.m6591t("[isUseDecorFloatStyle] -> ", Boolean.valueOf(z)));
        }
        return f8697j;
    }
}
