package com.didi.beatles.p099im.api.url;

import com.didi.beatles.p099im.IMCommonContextInfoHelper;
import com.didi.beatles.p099im.pref.IMPreference;
import com.didi.beatles.p099im.utils.IMLog;

/* renamed from: com.didi.beatles.im.api.url.IMApiUrl */
public final class IMApiUrl {
    public static final String IM_ACTION_REPORT_PATH = "/msgcenter/assistant/opreport";
    public static final String IM_COMMON_PATH = "/broker/";
    public static final String IM_DOWNLOAD_VOICE_PATH = "/gift/obtain_token/resource/im_voice_ns/";
    public static final String IM_POLLING_PATH = "/broker/polling/";
    public static final String IM_PROFILE_PATH = "/msgcenter/assistant/userprofile?appid=";
    public static final String IM_ROBOT_DOWNLOAD_VOICE_PATH = "/gift/resource/im_robot_voice/?keys=";
    public static final String IM_TRANSLATE_PATH = "/global/translate";
    public static final String IM_UP_LOAD_IMAGE_PATH = "/gift/upload_data/resource/im_image_ns/";
    public static final String IM_UP_LOAD_VOICE_PATH = "/gift/upload_data/resource/im_voice_ns/";

    /* renamed from: a */
    private static IMBaseUrl f9130a = null;
    public static int mCurrentUrlType = -1;

    public static void setIMUrlDelegate(IMBaseUrl iMBaseUrl) {
        f9130a = iMBaseUrl;
    }

    public static IMBaseUrl getIMUrlDelegate() {
        return f9130a;
    }

    /* renamed from: a */
    private static boolean m6194a() {
        if (f9130a != null) {
            return true;
        }
        IMLog.m6632e("IMApiUrl", "sIMUrlDelegate can not be null !");
        return false;
    }

    public static String getCommonHost() {
        if (mCurrentUrlType == -1) {
            mCurrentUrlType = IMPreference.getInstance(IMCommonContextInfoHelper.getContext()).getUrlType();
        }
        return m6194a() ? f9130a.getCommonHost(mCurrentUrlType) : "";
    }

    public static int getCurrentUrlType() {
        if (mCurrentUrlType == -1) {
            mCurrentUrlType = IMPreference.getInstance(IMCommonContextInfoHelper.getContext()).getUrlType();
        }
        return mCurrentUrlType;
    }

    public static void setCurrentUrlType(int i) {
        mCurrentUrlType = i;
        IMPreference.getInstance(IMCommonContextInfoHelper.getContext()).setUrlType(i);
    }

    public static String getCommonHostOnline() {
        return m6194a() ? f9130a.getCommonHost(0) : "";
    }

    public static String getProfileHost() {
        return m6194a() ? f9130a.getProfileHost() : "";
    }
}
