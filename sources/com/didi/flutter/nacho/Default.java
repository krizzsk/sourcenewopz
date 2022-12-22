package com.didi.flutter.nacho;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.flutter.nacho.p114ui.UIHelper;
import com.didi.flutter.nacho.p114ui.UIUpdateListener;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class Default {
    public static final String TAG_BOTTOM_DIALOG = "flutter_bottom_dialog";

    public static class ActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public static class DefaultFlutterEngineLifecycleListener implements FlutterEngineLifecycleListener {
        public void onPostStart(Context context, String str) {
        }

        public void onPreStart(Context context, String str) {
        }
    }

    public static class DefaultNativeInfoFetcher implements NativeInfoFetcher {
        public Map<String, Object> getInfo(Context context) {
            HashMap hashMap = new HashMap();
            hashMap.put("screenWidth", Float.valueOf(UIHelper.getScreenWidthInDp(context)));
            hashMap.put("screenHeight", Float.valueOf(UIHelper.getScreenHeightInDp(context)));
            return hashMap;
        }
    }

    public static class DefaultRouter implements Router {
        public static final String KEY_HEIGHT = "_nacho_height";
        public static final String KEY_URL = "_nacho_url";
        private final Map<String, Page> routers = new HashMap();

        /* access modifiers changed from: protected */
        public boolean dispatch2Native(String str, HashMap<String, Object> hashMap) {
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean openNative(Context context, String str, HashMap<String, Object> hashMap) {
            return false;
        }

        public boolean open(Context context, String str, HashMap<String, Object> hashMap) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Activity topActivity = Nacho.getInstance().getTopActivity();
            if (context instanceof Activity) {
                topActivity = (Activity) context;
            }
            if (topActivity == null) {
                return false;
            }
            if (str.startsWith("/")) {
                int indexOf = str.indexOf("?");
                if (indexOf > 0) {
                    str2 = str.substring(0, indexOf);
                    if (str.length() > str2.length() + 1) {
                        String[] split = str.substring(indexOf + 1).split(ParamKeys.SIGN_AND);
                        HashMap hashMap2 = new HashMap();
                        for (String split2 : split) {
                            String[] split3 = split2.split("=");
                            hashMap2.put(split3[0], split3.length >= 2 ? urlDecode(split3[1]) : "");
                        }
                        if (hashMap2.size() > 0) {
                            if (hashMap == null) {
                                hashMap = new HashMap<>();
                            }
                            hashMap.putAll(hashMap2);
                        }
                    }
                } else {
                    str2 = str;
                }
                Page page = this.routers.get(str2);
                if (page != null) {
                    page.doOpen(topActivity, str2, str, hashMap);
                }
                if (page != null) {
                    return true;
                }
                return false;
            } else if (dispatch2Native(str, hashMap)) {
                return openNative(context, str, hashMap);
            } else {
                return false;
            }
        }

        private String urlDecode(String str) {
            try {
                return URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return str;
            }
        }

        public boolean open(Context context, String str) {
            return open(context, str, (HashMap<String, Object>) null);
        }

        public Router register(Page page) {
            String[] names = page.getNames();
            if (names != null) {
                for (String put : names) {
                    this.routers.put(put, page);
                }
            }
            return this;
        }
    }

    public class DefaultUIUpdateListener implements UIUpdateListener {
        public void updateNativeDialogHeight(int i) {
        }

        public DefaultUIUpdateListener() {
        }
    }
}
