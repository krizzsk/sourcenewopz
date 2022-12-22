package com.didi.beatles.p099im.access.notify;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.core.IMPushEngine;
import com.didi.beatles.p099im.manager.IMAccessibilityManager;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.module.IIMMessageModule;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.net.IMThreadHelper;
import com.didi.beatles.p099im.omega.IMMessageTraceUtil;
import com.didi.beatles.p099im.omega.IMTraceError;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.beatles.p099im.omega.OmegaUtil;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.UiThreadHandler;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.didi.beatles.im.access.notify.NotificationUtils */
public class NotificationUtils {
    public static final String NOTIFICATION_ICON_ID = "im_notification_icon_id";
    public static final int NOTIFICATION_TYPE_APP_FLOAT_MSG = 1;
    public static final int NOTIFICATION_TYPE_APP_INNER = 0;
    public static final int NOTIFICATION_TYPE_OUT_PUSH = 2;

    /* renamed from: a */
    private static NotificationManager f8803a = null;

    /* renamed from: b */
    private static String f8804b = null;

    /* renamed from: c */
    private static Map<Integer, Integer> f8805c = new HashMap();

    /* renamed from: d */
    private static final int f8806d = 1;

    /* renamed from: e */
    private static final int f8807e = 0;

    /* renamed from: f */
    private static final int f8808f = -1;

    /* renamed from: g */
    private static AtomicInteger f8809g = new AtomicInteger(-1);
    public static int sInitialNotificationId = 300;

    /* renamed from: com.didi.beatles.im.access.notify.NotificationUtils$OnIMNotificationEnableCallback */
    public interface OnIMNotificationEnableCallback {
        void onNotificationEnabled(boolean z);
    }

    static {
        m5874a();
    }

    public static boolean showPushMsgNotification(Context context, IMMessage iMMessage, NotificationConfig notificationConfig, boolean z) {
        if (iMMessage == null) {
            IMLog.m6632e("", "msg or msg's content is null when try to show notification");
            return false;
        } else if (!m5876a(context, iMMessage, z)) {
            return false;
        } else {
            OmegaUtil.trackPushMsgOmega("tone_p_x_push_message_to", iMMessage);
            Notification generateNotification = generateNotification(m5873a(iMMessage), iMMessage, notificationConfig);
            if (generateNotification == null) {
                return false;
            }
            if (f8803a == null) {
                f8803a = (NotificationManager) context.getSystemService("notification");
            }
            try {
                f8803a.notify(notificationConfig.f8810id, generateNotification);
                IMLog.m6631d("im-sdk", "IM Push Log generateNotification:" + iMMessage.getContent());
                IMMessageTraceUtil.trackMessageCoreEvent("ddim_push_all_sw", iMMessage).add("push_type", 0).add("push_type_new", Integer.valueOf(iMMessage.notifyType)).report();
                IMTraceUtil.addBusinessEvent("msg_remind_sw").add("business_id", Integer.valueOf(iMMessage.getBusinessId())).add("type", 1).add("msg_id", Long.valueOf(iMMessage.getMid())).report();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /* renamed from: a */
    private static void m5874a() {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                String string = IMResource.getString(R.string.im_notification_channel_name);
                String string2 = IMResource.getString(R.string.im_notification_channel_name);
                f8804b = IMResource.getString(R.string.im_notification_channel);
                NotificationChannel notificationChannel = new NotificationChannel(f8804b, string, 4);
                notificationChannel.setDescription(string2);
                if (f8803a == null) {
                    f8803a = (NotificationManager) IMContextInfoHelper.getContext().getSystemService("notification");
                }
                if (f8803a != null) {
                    f8803a.createNotificationChannel(notificationChannel);
                }
            }
        } catch (Exception e) {
            IMTraceError.trackError("NotificationUtils#createChannel#", e);
        }
    }

    /* renamed from: a */
    private static Intent m5873a(IMMessage iMMessage) {
        iMMessage.msgForUid = IMContextInfoHelper.getUid();
        iMMessage.notifyType = 0;
        Intent intent = new Intent(IMDispatcherActivity.PUSH_DISPATCHER);
        if (IMContextInfoHelper.getContext() != null) {
            intent.setPackage(IMContextInfoHelper.getContext().getPackageName());
        }
        intent.putExtra(IMDispatcherActivity.KEY_INTENT_GSON_NOTIFICATION, IMJsonUtil.jsonFromObject(iMMessage));
        intent.setFlags(268435456);
        return intent;
    }

    /* renamed from: a */
    private static boolean m5876a(Context context, IMMessage iMMessage, boolean z) {
        int businessId = iMMessage.getBusinessId();
        if (z) {
            if (!IMEngine.getInstance(context).getCurrentBusinessConfig(iMMessage.getSidType(), businessId).isOpenInnerNotification()) {
                return false;
            }
            if ((IMAccessibilityManager.getInstance() == null || !IMAccessibilityManager.getInstance().isEnabled()) && IMPushEngine.inThisMessagePage(iMMessage)) {
                return false;
            }
        } else if (!IMEngine.getInstance(context).getCurrentBusinessConfig(iMMessage.getSidType(), businessId).isOpenOuterNotification()) {
            return false;
        }
        return true;
    }

    public static Notification generateNotification(Intent intent, IMMessage iMMessage, NotificationConfig notificationConfig) {
        String str;
        if (iMMessage == null || TextUtils.isEmpty(iMMessage.getPushText())) {
            IMLog.m6632e("", "intent or content is null when try to show notification");
            return null;
        }
        String pushText = iMMessage.getPushText();
        String pushContent = iMMessage.getPushContent();
        int currentTimeMillis = (int) System.currentTimeMillis();
        Context context = IMContextInfoHelper.getContext();
        try {
            if (TextUtils.isEmpty(pushContent)) {
                str = IMContextInfoHelper.getContext().getResources().getString(IMContextInfoHelper.getContext().getApplicationInfo().labelRes);
                pushContent = pushText;
            } else {
                str = pushText;
            }
            int i = View.NAVIGATION_BAR_TRANSIENT;
            if (Build.VERSION.SDK_INT >= 23) {
                i = 201326592;
            }
            PendingIntent activity = PendingIntent.getActivity(context, currentTimeMillis, intent, i);
            int sid = (int) iMMessage.getSid();
            if (f8805c.containsKey(Integer.valueOf(sid))) {
                f8805c.put(Integer.valueOf(sid), Integer.valueOf(f8805c.get(Integer.valueOf(sid)).intValue() + 1));
                pushContent = String.format(IMResource.getString(R.string.im_notification_num), new Object[]{f8805c.get(Integer.valueOf(sid))}) + pushContent;
            } else {
                f8805c.put(Integer.valueOf(sid), 1);
            }
            NotificationCompat.Builder ticker = new NotificationCompat.Builder(context).setAutoCancel(true).setContentIntent(activity).setContentTitle(str).setContentText(pushContent).setTicker(pushText);
            try {
                ticker.setChannelId(f8804b);
            } catch (Throwable unused) {
                IMLog.m6632e("support version too low,can't setChannelId", new Object[0]);
            }
            int appResouceId = IMEngine.getInstance(IMContextInfoHelper.getContext()).getAppResouceId(NOTIFICATION_ICON_ID);
            if (appResouceId == 0) {
                appResouceId = IMContextInfoHelper.getContext().getApplicationInfo().icon;
            }
            ticker.setSmallIcon(appResouceId);
            if (IMContextInfoHelper.getNotificationSoundUri() == null) {
                ticker.setDefaults(1);
            } else {
                ticker.setSound(IMContextInfoHelper.getNotificationSoundUri());
            }
            Notification build = ticker.build();
            build.ledARGB = context.getResources().getColor(R.color.im_nomix_orange);
            build.flags |= 1;
            build.ledOnMS = 500;
            build.ledOffMS = 2000;
            return build;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void cancelNotification() {
        try {
            if (f8803a != null) {
                f8803a.cancelAll();
            }
            f8805c.clear();
        } catch (Exception e) {
            IMLog.m6633e(e);
        }
    }

    /* renamed from: com.didi.beatles.im.access.notify.NotificationUtils$NotificationConfig */
    public static class NotificationConfig {

        /* renamed from: id */
        public int f8810id;
        public boolean isRing = true;

        public NotificationConfig(IMMessage iMMessage) {
            if (iMMessage != null) {
                this.f8810id = (int) iMMessage.getSid();
            } else {
                this.f8810id = NotificationUtils.sInitialNotificationId;
            }
        }

        public NotificationConfig setRing(boolean z) {
            this.isRing = z;
            return this;
        }

        public NotificationConfig setId(int i) {
            this.f8810id = i;
            return this;
        }
    }

    public static boolean isShowNotificationSettingsEntrance() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public static boolean isNotificationEnabled(Context context) {
        try {
            int i = 1;
            boolean z = isAppNotificationEnabled(context) && isIMNotificationChannelEnabled();
            if (!z) {
                i = 0;
            }
            m5875a(i);
            return z;
        } catch (Exception e) {
            IMLog.m6633e(e);
            return false;
        }
    }

    /* renamed from: a */
    private static void m5875a(int i) {
        IMLog.m6631d("NotificationUtils", C4234I.m6591t("[updateNotificationEnableStatus] #onNotificationEnabled# status=", Integer.valueOf(i), " |lastStatus=" + f8809g.get()));
        if (i != f8809g.get()) {
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    IMLog.m6631d("NotificationUtils", "[updateNotificationEnableStatus] #onNotificationEnabled# update message module info.");
                    IIMMessageModule messageModel = IMManager.getInstance().getMessageModel();
                    if (messageModel != null) {
                        messageModel.updateSyncInfo();
                    }
                }
            });
        }
        f8809g.set(i);
    }

    public static boolean getNotificationEnableStatus() {
        return f8809g.get() == 1;
    }

    public static void isNotificationEnabled(final Context context, final OnIMNotificationEnableCallback onIMNotificationEnableCallback) {
        if (onIMNotificationEnableCallback != null) {
            IMThreadHelper.getInstance().execute(new Runnable() {
                public void run() {
                    final boolean isNotificationEnabled = NotificationUtils.isNotificationEnabled(context);
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            if (onIMNotificationEnableCallback != null) {
                                onIMNotificationEnableCallback.onNotificationEnabled(isNotificationEnabled);
                            }
                        }
                    });
                }
            });
        }
    }

    public static boolean isAppNotificationEnabled(Context context) {
        try {
            NotificationManagerCompat from = NotificationManagerCompat.from(context);
            if (from != null) {
                return from.areNotificationsEnabled();
            }
            return true;
        } catch (Exception e) {
            IMLog.m6633e(e);
            return true;
        }
    }

    public static boolean isIMNotificationChannelEnabled() {
        return isNotificationChannelEnabled(f8804b);
    }

    public static boolean isNotificationChannelEnabled(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        NotificationChannel notificationChannel = f8803a.getNotificationChannel(str);
        if (notificationChannel == null || notificationChannel.getImportance() == 0) {
            return false;
        }
        return true;
    }

    public static void openNotificationSettings(Context context) {
        String packageName = context.getPackageName();
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT >= 26) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        } else if (Build.VERSION.SDK_INT >= 21) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("app_package", packageName);
            intent.putExtra("app_uid", context.getApplicationInfo().uid);
        } else {
            intent.addFlags(268435456);
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", packageName, (String) null));
        }
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            IMLog.m6632e("NotificationUtils", "[openNotificationSettings]", e);
        }
    }
}
