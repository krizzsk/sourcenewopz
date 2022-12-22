package com.appsflyer.internal.referrer;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.appsflyer.AFLogger;
import com.appsflyer.AndroidUtils;
import com.appsflyer.AppsFlyerLibCore;
import com.didi.sdk.onehotpatch.openapi.HotpatchStateConst;
import java.util.HashMap;
import java.util.Map;

public class GoogleReferrer {
    public final Map<String, Object> newMap = new HashMap();
    public final Map<String, Object> oldMap = new HashMap();

    public static boolean allow(AppsFlyerLibCore appsFlyerLibCore, Context context) {
        if (appsFlyerLibCore.getLaunchCounter(AppsFlyerLibCore.getSharedPreferences(context), false) > 2) {
            AFLogger.afRDLog("Install referrer will not load, the counter > 2, ");
            return false;
        }
        try {
            Class.forName("com.android.installreferrer.api.InstallReferrerClient");
            if (AndroidUtils.isPermissionAvailable(context, "com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE")) {
                AFLogger.afDebugLog("Install referrer is allowed");
                return true;
            }
            AFLogger.afDebugLog("Install referrer is not allowed");
            return false;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb = new StringBuilder("Class ");
            sb.append("com.android.installreferrer.api.InstallReferrerClient");
            sb.append(" not found");
            AFLogger.afRDLog(sb.toString());
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog("An error occurred while trying to verify manifest : ".concat("com.android.installreferrer.api.InstallReferrerClient"), th);
            return false;
        }
    }

    public void start(Context context, final Runnable runnable) {
        try {
            final InstallReferrerClient build = InstallReferrerClient.newBuilder(context).build();
            AFLogger.afDebugLog("Connecting to Install Referrer Library...");
            build.startConnection(new InstallReferrerStateListener() {
                public final void onInstallReferrerSetupFinished(int i) {
                    GoogleReferrer.this.oldMap.put("code", String.valueOf(i));
                    GoogleReferrer.this.newMap.put("source", "google");
                    GoogleReferrer.this.newMap.putAll(new MandatoryFields());
                    if (i == -1) {
                        AFLogger.afWarnLog("InstallReferrer SERVICE_DISCONNECTED");
                        GoogleReferrer.this.newMap.put("response", Payload.RESPONSE_SERVICE_DISCONNECTED);
                    } else if (i == 0) {
                        GoogleReferrer.this.newMap.put("response", Payload.RESPONSE_OK);
                        try {
                            AFLogger.afDebugLog("InstallReferrer connected");
                            if (build.isReady()) {
                                ReferrerDetails installReferrer = build.getInstallReferrer();
                                String installReferrer2 = installReferrer.getInstallReferrer();
                                if (installReferrer2 != null) {
                                    GoogleReferrer.this.oldMap.put("val", installReferrer2);
                                    GoogleReferrer.this.newMap.put(Payload.REFERRER, installReferrer2);
                                }
                                long referrerClickTimestampSeconds = installReferrer.getReferrerClickTimestampSeconds();
                                GoogleReferrer.this.oldMap.put("clk", Long.toString(referrerClickTimestampSeconds));
                                GoogleReferrer.this.newMap.put(Payload.CLICK_TS, Long.valueOf(referrerClickTimestampSeconds));
                                long installBeginTimestampSeconds = installReferrer.getInstallBeginTimestampSeconds();
                                GoogleReferrer.this.oldMap.put(HotpatchStateConst.INSTALL, Long.toString(installBeginTimestampSeconds));
                                GoogleReferrer.this.newMap.put(Payload.INSTALL_BEGIN_TS, Long.valueOf(installBeginTimestampSeconds));
                                try {
                                    GoogleReferrer.this.oldMap.put("instant", Boolean.valueOf(installReferrer.getGooglePlayInstantParam()));
                                } catch (NoSuchMethodError unused) {
                                }
                            } else {
                                AFLogger.afWarnLog("ReferrerClient: InstallReferrer is not ready");
                                GoogleReferrer.this.oldMap.put(NotificationCompat.CATEGORY_ERROR, "ReferrerClient: InstallReferrer is not ready");
                            }
                        } catch (Throwable th) {
                            StringBuilder sb = new StringBuilder("Failed to get install referrer: ");
                            sb.append(th.getMessage());
                            AFLogger.afWarnLog(sb.toString());
                            GoogleReferrer.this.oldMap.put(NotificationCompat.CATEGORY_ERROR, th.getMessage());
                        }
                    } else if (i == 1) {
                        GoogleReferrer.this.newMap.put("response", Payload.RESPONSE_SERVICE_UNAVAILABLE);
                        AFLogger.afWarnLog("InstallReferrer not supported");
                    } else if (i == 2) {
                        AFLogger.afWarnLog("InstallReferrer FEATURE_NOT_SUPPORTED");
                        GoogleReferrer.this.newMap.put("response", Payload.RESPONSE_FEATURE_NOT_SUPPORTED);
                    } else if (i != 3) {
                        AFLogger.afWarnLog("responseCode not found.");
                    } else {
                        AFLogger.afWarnLog("InstallReferrer DEVELOPER_ERROR");
                        GoogleReferrer.this.newMap.put("response", Payload.RESPONSE_DEVELOPER_ERROR);
                    }
                    AFLogger.afDebugLog("Install Referrer collected locally");
                    runnable.run();
                    build.endConnection();
                }

                public final void onInstallReferrerServiceDisconnected() {
                    AFLogger.afDebugLog("Install Referrer service disconnected");
                }
            });
        } catch (Throwable th) {
            AFLogger.afErrorLog("referrerClient -> startConnection", th);
        }
    }
}
