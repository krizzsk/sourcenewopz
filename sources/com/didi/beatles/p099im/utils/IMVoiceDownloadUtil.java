package com.didi.beatles.p099im.utils;

import android.content.Context;
import android.text.TextUtils;
import com.didi.beatles.p099im.api.entity.voice.IMVoiceBody;
import com.didi.beatles.p099im.api.entity.voice.IMVoiceListBody;
import com.didi.beatles.p099im.api.entity.voice.IMVoiceResponse;
import com.didi.beatles.p099im.api.url.IMApiUrl;
import com.didi.beatles.p099im.net.IMHttpManager;
import com.didi.beatles.p099im.net.IMNetCallback;
import com.didi.beatles.p099im.utils.IMFileUtil;
import java.io.File;
import java.io.IOException;
import java.util.List;

/* renamed from: com.didi.beatles.im.utils.IMVoiceDownloadUtil */
public class IMVoiceDownloadUtil {

    /* renamed from: a */
    private static final String f9797a = IMVoiceDownloadUtil.class.getSimpleName();

    /* renamed from: com.didi.beatles.im.utils.IMVoiceDownloadUtil$FilepathCallback */
    public interface FilepathCallback {
        void onPathCallback(String str, String str2);
    }

    /* renamed from: com.didi.beatles.im.utils.IMVoiceDownloadUtil$UrlCallback */
    public interface UrlCallback {
        void onUrlCallback(List<IMVoiceBody> list);
    }

    public static void downloadVoiceUrl(final UrlCallback urlCallback, String... strArr) {
        if (strArr != null && strArr.length != 0 && urlCallback != null) {
            IMHttpManager.getInstance().getDownloadFileInfo(IMApiUrl.getCommonHost() + IMApiUrl.IM_ROBOT_DOWNLOAD_VOICE_PATH + IMTextUtil.join((Object[]) strArr, ","), new IMNetCallback<IMVoiceResponse>() {
                public void success(final IMVoiceResponse iMVoiceResponse) {
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            IMVoiceResponse iMVoiceResponse = iMVoiceResponse;
                            if (iMVoiceResponse == null || iMVoiceResponse.body == null) {
                                urlCallback.onUrlCallback((List<IMVoiceBody>) null);
                            } else {
                                urlCallback.onUrlCallback(((IMVoiceListBody) iMVoiceResponse.body).voice_list);
                            }
                        }
                    });
                }

                public void failure(IOException iOException) {
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            urlCallback.onUrlCallback((List<IMVoiceBody>) null);
                        }
                    });
                }
            });
        } else if (urlCallback != null) {
            urlCallback.onUrlCallback((List<IMVoiceBody>) null);
        }
    }

    public static void downloadVoice(final Context context, final IMVoiceBody iMVoiceBody, final FilepathCallback filepathCallback) {
        if (iMVoiceBody != null && filepathCallback != null) {
            final String str = IMFileUtil.getTmpPath(context) + iMVoiceBody.key;
            IMHttpManager.getInstance().downloadFile(iMVoiceBody.url, str, new IMNetCallback<Boolean>() {
                public void success(Boolean bool) {
                    if (!bool.booleanValue() || TextUtils.isEmpty(iMVoiceBody.key)) {
                        FilepathCallback filepathCallback = filepathCallback;
                        if (filepathCallback != null) {
                            filepathCallback.onPathCallback((String) null, (String) null);
                            return;
                        }
                        return;
                    }
                    IMFileUtil.saveFileAsync(context, new File(str), iMVoiceBody.key, new IMFileUtil.FileSaveCallBack() {
                        public void onFinish(String str) {
                            filepathCallback.onPathCallback(str, iMVoiceBody.key);
                        }
                    });
                }

                public void failure(IOException iOException) {
                    FilepathCallback filepathCallback = filepathCallback;
                    if (filepathCallback != null) {
                        filepathCallback.onPathCallback((String) null, (String) null);
                    }
                }
            });
        } else if (filepathCallback != null) {
            filepathCallback.onPathCallback((String) null, (String) null);
        }
    }

    public static void downloadVoice(final Context context, final String str, final FilepathCallback filepathCallback) {
        if (str != null && filepathCallback != null) {
            final String str2 = IMFileUtil.getTmpPath(context) + IMEncryptionUtil.encrypt(str);
            IMHttpManager.getInstance().downloadFile(str, str2, new IMNetCallback<Boolean>() {
                public void success(Boolean bool) {
                    if (!bool.booleanValue()) {
                        FilepathCallback filepathCallback = filepathCallback;
                        if (filepathCallback != null) {
                            filepathCallback.onPathCallback((String) null, (String) null);
                            return;
                        }
                        return;
                    }
                    IMFileUtil.saveFileAsync(context, new File(str2), str, new IMFileUtil.FileSaveCallBack() {
                        public void onFinish(String str) {
                            filepathCallback.onPathCallback(str, str);
                        }
                    });
                }

                public void failure(IOException iOException) {
                    FilepathCallback filepathCallback = filepathCallback;
                    if (filepathCallback != null) {
                        filepathCallback.onPathCallback((String) null, (String) null);
                    }
                }
            });
        } else if (filepathCallback != null) {
            filepathCallback.onPathCallback((String) null, (String) null);
        }
    }
}
