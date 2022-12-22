package com.didi.beatles.p099im.access.briage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.notify.IMFloatWindowController;
import com.didi.beatles.p099im.access.notify.NotiFloatWindow;
import com.didi.beatles.p099im.access.notify.NotificationUtils;
import com.didi.beatles.p099im.access.notify.decorfloat.IMDecorFloatController;
import com.didi.beatles.p099im.api.entity.IMHelperBody;
import com.didi.beatles.p099im.event.IMEventDispatcher;
import com.didi.beatles.p099im.event.IMSendAddressEvent;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.manager.IMSessionMessageListenerManager;
import com.didi.beatles.p099im.module.IIMUserModule;
import com.didi.beatles.p099im.module.entity.IMAddress;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.module.entity.IMUser;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMTextUtil;
import com.didi.beatles.p099im.utils.ShakeUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.access.briage.IMMessageReciver */
public class IMMessageReciver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        IMLog.m6631d("IMPushEngine", "onPushArrive PushEngine onReceive sdk IMMessageReceiver");
        if (intent != null && !TextUtils.isEmpty(intent.getAction())) {
            if (intent.getAction().equals(IMEventDispatcher.RECEIVE_NEW_MESSAGE_ACTION)) {
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(IMEventDispatcher.IM_MESSAGE_EXTRA);
                if (!IMTextUtil.isEmpty((Collection<?>) parcelableArrayListExtra)) {
                    IMLog.m6631d("IMPushEngine", "onPushArrive PushEngine onReceive IM_MESSAGE_FOR_UPDATE");
                    IMSessionMessageListenerManager.getInstance().notifyListeners(IMSessionMessageListenerManager.generateSessionIdSet(parcelableArrayListExtra));
                    IMMessage iMMessage = (IMMessage) parcelableArrayListExtra.get(parcelableArrayListExtra.size() - 1);
                    IMLog.m6631d("IMMessageReciver", "震动内");
                    if ((iMMessage.getMattr() & 32) != 0) {
                        ShakeUtils.shake(context, 500, false);
                        IMLog.m6631d("IMMessageReciver", "震动内" + iMMessage.getMattr());
                    }
                    if (iMMessage.getSenderUid() != IMContextInfoHelper.getUid() && (iMMessage.getMattr() & 4) != 0) {
                        if (!IMFloatWindowController.isEnable()) {
                            IMLog.m6631d("IMPushEngine", "[IMMessageReceiver] disable float window");
                            return;
                        }
                        boolean isUseDecorFloatStyle = IMContextInfoHelper.isUseDecorFloatStyle();
                        IMLog.m6631d("IMPushEngine", "onPushArrive Notification.   isUseDecorFloat=" + isUseDecorFloatStyle);
                        generateIMMessagePushContent(iMMessage);
                        if (isUseDecorFloatStyle) {
                            IMDecorFloatController.getInstance().add(iMMessage);
                            return;
                        }
                        NotiFloatWindow.getInstance(context).add(iMMessage);
                        NotificationUtils.showPushMsgNotification(context, iMMessage, new NotificationUtils.NotificationConfig(iMMessage), true);
                    }
                }
            } else if (intent.getAction().equals(IMEventDispatcher.IM_ACTION_LOCATION_RESPONSE)) {
                EventBus.getDefault().post(new IMSendAddressEvent((IMAddress) intent.getSerializableExtra("address")));
            }
        }
    }

    public static void generateIMMessagePushContent(IMMessage iMMessage) {
        IIMUserModule userModel;
        IMUser userInfoFromCache;
        if (iMMessage != null) {
            String nickName = iMMessage.getNickName();
            if (!(!TextUtils.isEmpty(nickName) || (userModel = IMManager.getInstance().getUserModel()) == null || (userInfoFromCache = userModel.getUserInfoFromCache(iMMessage.getSenderUid())) == null)) {
                nickName = userInfoFromCache.getNickName();
            }
            if (TextUtils.isEmpty(nickName)) {
                nickName = IMResource.getString(R.string.bts_user_default_name);
            }
            iMMessage.setNickName(nickName);
            if (iMMessage.getType() == 327680) {
                String string = IMResource.getString(R.string.bts_im_msg_notify_face);
                iMMessage.setPushText(nickName + string);
                iMMessage.floatPushText = string;
            } else if (iMMessage.getType() == 196608) {
                String string2 = IMResource.getString(R.string.bts_im_msg_notify_image);
                iMMessage.floatPushText = string2;
                iMMessage.setPushText(nickName + string2);
            } else if (iMMessage.getType() == 458752) {
                String topText = iMMessage.getTopText();
                if (TextUtils.isEmpty(topText)) {
                    topText = IMResource.getString(R.string.bts_im_msg_notify_default);
                }
                iMMessage.setPushText(nickName + "：" + topText);
                iMMessage.setPushContent(iMMessage.getTopContent());
                iMMessage.floatPushText = topText;
            } else if (iMMessage.getType() == 393223) {
                String topText2 = iMMessage.getTopText();
                if (TextUtils.isEmpty(topText2)) {
                    topText2 = IMResource.getString(R.string.bts_im_msg_notify_default);
                }
                iMMessage.setPushText(topText2);
                iMMessage.setPushContent(iMMessage.getTopContent());
                iMMessage.floatPushText = topText2;
            } else if (iMMessage.getType() == 393224) {
                String topText3 = iMMessage.getTopText();
                if (TextUtils.isEmpty(topText3)) {
                    topText3 = IMResource.getString(R.string.bts_im_msg_notify_default);
                }
                iMMessage.setPushText(topText3);
                iMMessage.setPushContent(iMMessage.getTopContent());
                iMMessage.floatPushText = topText3;
            } else if (iMMessage.getType() == 10486017) {
                String string3 = IMResource.getString(R.string.bts_im_msg_notify_location);
                iMMessage.floatPushText = string3;
                iMMessage.setPushText(nickName + string3);
            } else if (iMMessage.getType() == 131072) {
                String string4 = IMResource.getString(R.string.bts_im_msg_notify_voice);
                iMMessage.setPushText(nickName + string4);
                iMMessage.floatPushText = string4;
            } else if (iMMessage.getType() == 10485761) {
                String string5 = IMResource.getString(R.string.bts_im_msg_notify_share_location);
                iMMessage.setPushText(nickName + string5);
                iMMessage.floatPushText = string5;
            } else if (iMMessage.getType() == 528385 || iMMessage.getType() == 393219) {
                String topText4 = iMMessage.getTopText();
                if (TextUtils.isEmpty(topText4)) {
                    topText4 = IMResource.getString(R.string.bts_im_msg_notify_default);
                }
                iMMessage.setPushText(nickName + "：" + topText4);
                iMMessage.setPushContent(iMMessage.getTopContent());
                iMMessage.floatPushText = topText4;
            } else if (iMMessage.getType() == 393220) {
                IMHelperBody iMHelperBody = (IMHelperBody) IMJsonUtil.objectFromJson(iMMessage.getContent(), IMHelperBody.class);
                if (iMHelperBody != null) {
                    String str = iMHelperBody.title;
                    iMMessage.setPushText(nickName + "：" + str);
                    iMMessage.floatPushText = str;
                    return;
                }
                String string6 = IMResource.getString(R.string.bts_im_msg_notify_text);
                iMMessage.setPushText(nickName + string6);
                iMMessage.floatPushText = string6;
            } else {
                String content = iMMessage.getContent();
                iMMessage.setPushText(nickName + "：" + content);
                iMMessage.floatPushText = content;
            }
        }
    }
}
