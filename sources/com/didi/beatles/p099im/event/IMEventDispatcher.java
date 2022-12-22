package com.didi.beatles.p099im.event;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.msg.IMRobotPraiseTTSMsg;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.module.IIMMessageModule;
import com.didi.beatles.p099im.module.IIMSessionModule;
import com.didi.beatles.p099im.module.IIMUserModule;
import com.didi.beatles.p099im.module.IMSessionCallback;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.beatles.p099im.utils.IMLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.beatles.im.event.IMEventDispatcher */
public class IMEventDispatcher {
    public static final String CREATE_SHARE_LOCATION_ACTION = "create_share_location_action";
    public static final String IM_ACTION_LOCATION_REQUEST = "im_action_location_request";
    public static final String IM_ACTION_LOCATION_RESPONSE = "im_action_location_response";
    public static final String IM_AUDIO_START_PLAY_ACTION = "im_audio_start_play_action";
    public static final String IM_AUDIO_START_STOP_ACTION = "im_audio_start_stop_action";
    public static String IM_DMC_INFO_EXTRA = "im_dmc_info";
    public static String IM_MESSAGE_EXTRA = "im_message_extra";
    public static final String IM_RECEIVE_DMC_INFO_ACTION = "im_receive_dmc_info_action";
    public static String IM_SESSION_ID_EXTRA = "im_session_id_extra";
    public static final String JOIN_SHARE_LOCATION_ACTION = "join_share_location_action";
    public static final String KICK_GROUP = "kick_group";
    public static final String NOTIFY_DELET_SESSION = "delete_session";
    public static final String NOTIFY_EXPIRED_PICTURE = "delete_picture";
    public static final String NOTIFY_READ_STATUS_CHANGE = "read_ack";
    public static final String NOTIFY_SEESIONINFO_CHANGE = "notify_session_info";
    public static final String NOTIFY_UPDATE_MESSAGE = "notifyUpdateMessage";
    public static final String QUIT_GROUP = "quit_group";
    public static final String RECEIVE_MESSAGE_TO_TTS_ACTION = "receive_message_to_tts_action";
    public static final String RECEIVE_NEW_MESSAGE_ACTION = "receive_new_message_action";
    public static final String RECEIVE_ROBOT_PRAISE_MESSAGE_TO_TTS_ACTION = "receive_robot_praise_message_to_tts_action";
    public static final String SESSION_CHANGE_ACTION = "session_change_action";
    public static String SHARE_LOCATION_ID_EXTRA = "share_location_id";

    /* renamed from: a */
    private static final String f9213a = "IMEventDispatcher";

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007c, code lost:
        if (r0.equals(NOTIFY_SEESIONINFO_CHANGE) != false) goto L_0x008a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean dispatchIMMessage(android.content.Context r4, com.didi.beatles.p099im.module.entity.IMMessage r5) {
        /*
            java.lang.String r0 = r5.getActionId()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0011
            java.lang.String r4 = "message ==  null || actionId = null"
            m6221a(r4)
            return r1
        L_0x0011:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "dispatchIMMessage -->"
            r0.append(r2)
            java.lang.String r2 = r5.getContent()
            r0.append(r2)
            java.lang.String r2 = "action is "
            r0.append(r2)
            java.lang.String r2 = r5.getActionId()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "IMEventDispatcher"
            com.didi.beatles.p099im.utils.IMLog.m6631d(r2, r0)
            java.lang.String r0 = r5.getActionId()
            r2 = -1
            int r3 = r0.hashCode()
            switch(r3) {
                case -2069375998: goto L_0x007f;
                case -1791526419: goto L_0x0076;
                case -867219872: goto L_0x006c;
                case -748862321: goto L_0x0062;
                case -619690170: goto L_0x0058;
                case -337138070: goto L_0x004e;
                case 1256460853: goto L_0x0044;
                default: goto L_0x0043;
            }
        L_0x0043:
            goto L_0x0089
        L_0x0044:
            java.lang.String r1 = "notifyUpdateMessage"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0089
            r1 = 6
            goto L_0x008a
        L_0x004e:
            java.lang.String r1 = "delete_picture"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0089
            r1 = 5
            goto L_0x008a
        L_0x0058:
            java.lang.String r1 = "kick_group"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0089
            r1 = 4
            goto L_0x008a
        L_0x0062:
            java.lang.String r1 = "quit_group"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0089
            r1 = 3
            goto L_0x008a
        L_0x006c:
            java.lang.String r1 = "read_ack"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0089
            r1 = 1
            goto L_0x008a
        L_0x0076:
            java.lang.String r3 = "notify_session_info"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0089
            goto L_0x008a
        L_0x007f:
            java.lang.String r1 = "delete_session"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0089
            r1 = 2
            goto L_0x008a
        L_0x0089:
            r1 = -1
        L_0x008a:
            switch(r1) {
                case 0: goto L_0x00b0;
                case 1: goto L_0x00ab;
                case 2: goto L_0x00a6;
                case 3: goto L_0x00a1;
                case 4: goto L_0x009c;
                case 5: goto L_0x0097;
                case 6: goto L_0x0092;
                default: goto L_0x008d;
            }
        L_0x008d:
            boolean r4 = m6228g(r4, r5)
            return r4
        L_0x0092:
            boolean r4 = m6223b(r4, r5)
            return r4
        L_0x0097:
            boolean r4 = m6222a(r4, r5)
            return r4
        L_0x009c:
            boolean r4 = m6224c(r4, r5)
            return r4
        L_0x00a1:
            boolean r4 = m6229h(r4, r5)
            return r4
        L_0x00a6:
            boolean r4 = m6227f(r4, r5)
            return r4
        L_0x00ab:
            boolean r4 = m6226e(r4, r5)
            return r4
        L_0x00b0:
            boolean r4 = m6225d(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.event.IMEventDispatcher.dispatchIMMessage(android.content.Context, com.didi.beatles.im.module.entity.IMMessage):boolean");
    }

    /* renamed from: a */
    private static boolean m6222a(Context context, IMMessage iMMessage) {
        IMLog.m6631d(f9213a, "NOTIFY_EXPIRED_PICTURE execute -->" + iMMessage.getContent());
        try {
            long parseLong = Long.parseLong(new JSONObject(iMMessage.getContent()).optString("sid"));
            IIMMessageModule messageModel = IMManager.getInstance().getMessageModel();
            if (messageModel == null) {
                return true;
            }
            messageModel.handleExpiredPicture(parseLong);
            return true;
        } catch (Exception e) {
            IMLog.m6631d(f9213a, "handleUpdateReadStatus failed,error =  " + e.toString());
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    private static boolean m6223b(Context context, IMMessage iMMessage) {
        IMLog.m6631d(f9213a, "NOTIFY_UPDATE_MESSAGE execute -->" + iMMessage.getContent());
        try {
            JSONObject jSONObject = new JSONObject(iMMessage.getContent());
            String optString = jSONObject.optString("sessionId");
            JSONArray optJSONArray = jSONObject.optJSONArray("messages");
            long parseLong = Long.parseLong(optString);
            IIMMessageModule messageModel = IMManager.getInstance().getMessageModel();
            if (messageModel == null) {
                return true;
            }
            messageModel.handleUpdateMessage(parseLong, optJSONArray);
            return true;
        } catch (Exception e) {
            IMLog.m6631d(f9213a, "handleUpdateMessage failed,error =  " + e.toString());
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    private static boolean m6224c(Context context, IMMessage iMMessage) {
        if (context == null || iMMessage == null || iMMessage.getContent() == null) {
            IMLog.m6632e(f9213a, "handleKickGroup failed while null !");
            return false;
        }
        IMLog.m6631d(f9213a, "handleKickGroup execute -->" + iMMessage.getContent());
        try {
            JSONObject jSONObject = new JSONObject(iMMessage.getContent());
            long optLong = jSONObject.optLong("sid");
            long optLong2 = jSONObject.optLong("uid");
            String optString = jSONObject.optString("na_txt");
            if (optLong2 != IMContextInfoHelper.getUid()) {
                IMLog.m6632e(f9213a, "handleKickGroup failed while uid is not mine !");
                return true;
            }
            IIMUserModule userModel = IMManager.getInstance().getUserModel();
            if (userModel == null) {
                IMLog.m6632e(f9213a, "handleKickGroup failed while userModule is null !");
                return false;
            }
            userModel.kickGroupUser(optLong, optLong2);
            IIMSessionModule sessionModel = IMManager.getInstance().getSessionModel();
            if (sessionModel == null) {
                IMLog.m6632e(f9213a, "handleKickGroup failed while sessionModule is null !");
                return false;
            }
            IMSession updateSessionStatusAndSize = sessionModel.updateSessionStatusAndSize(optLong, true, 0, optString, -1);
            EventBus.getDefault().post(new IMSessionInfoUpdateEvent(Arrays.asList(new IMSession[]{updateSessionStatusAndSize})));
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            IMLog.m6632e(f9213a, "handleQuitGroup failed ! exception = " + e.toString());
            return false;
        }
    }

    /* renamed from: d */
    private static boolean m6225d(Context context, IMMessage iMMessage) {
        long j;
        IMLog.m6631d(f9213a, "NOTIFY_SEESIONINFO_CHANGE execute -->" + iMMessage.getContent());
        try {
            j = Long.parseLong(new JSONObject(iMMessage.getContent()).optString("sid"));
        } catch (JSONException e) {
            e.printStackTrace();
            j = -1;
        }
        IIMSessionModule sessionModel = IMManager.getInstance().getSessionModel();
        if (sessionModel == null) {
            return false;
        }
        long[] jArr = {j};
        long[] jArr2 = new long[1];
        for (int i = 0; i < 1; i++) {
            IMSession sessionFromLocal = sessionModel.getSessionFromLocal(jArr[i]);
            if (sessionFromLocal != null) {
                jArr2[i] = sessionFromLocal.getPeerUid();
            }
        }
        sessionModel.getSessionInfoFormNet(jArr, jArr2, 0, new IMSessionCallback() {
            public void onSessionStatusUpdate(List<IMSession> list) {
            }

            public void onSessionOptionResult(List<IMSession> list, int i) {
                try {
                    IMLog.m6631d(IMEventDispatcher.f9213a, "NOTIFY_SEESIONINFO_CHANGE error -->");
                    EventBus.getDefault().post(new IMSessionInfoUpdateErrorEvent(i));
                } catch (Exception unused) {
                }
            }

            public void onSessionLoad(List<IMSession> list) {
                try {
                    IMLog.m6631d(IMEventDispatcher.f9213a, "NOTIFY_SEESIONINFO_CHANGE load finish-->" + list);
                    if (list != null && list.size() > 0) {
                        EventBus.getDefault().post(new IMSessionInfoUpdateEvent(list));
                    }
                } catch (Exception unused) {
                }
            }
        });
        return true;
    }

    /* renamed from: e */
    private static boolean m6226e(Context context, IMMessage iMMessage) {
        IMLog.m6631d(f9213a, "NOTIFY_READ_STATUS_CHANGE execute -->" + iMMessage.getContent());
        try {
            JSONObject jSONObject = new JSONObject(iMMessage.getContent());
            long parseLong = Long.parseLong(jSONObject.optString("sid"));
            JSONArray optJSONArray = jSONObject.optJSONArray("mids");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(Long.valueOf(optJSONArray.getLong(i)));
            }
            IIMMessageModule messageModel = IMManager.getInstance().getMessageModel();
            if (messageModel == null) {
                return true;
            }
            messageModel.updateReadStatus(parseLong, true, arrayList, true);
            return true;
        } catch (Exception e) {
            IMLog.m6631d(f9213a, "handleUpdateReadStatus failed,error =  " + e.toString());
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: f */
    private static boolean m6227f(Context context, IMMessage iMMessage) {
        IMLog.m6631d(f9213a, "NOTIFY_DELETE_SESSION execute -->" + iMMessage.getContent());
        try {
            long parseLong = Long.parseLong(new JSONObject(iMMessage.getContent()).optString("sid"));
            IIMSessionModule sessionModel = IMManager.getInstance().getSessionModel();
            if (sessionModel == null) {
                IMLog.m6632e(f9213a, "handleDeleteSession failed while sessionModule is null !");
                return false;
            }
            sessionModel.deleteSession(sessionModel.getSessionFromLocal(parseLong));
            return true;
        } catch (Exception e) {
            IMLog.m6631d(f9213a, "handleDeleteSession failed,error = " + e.toString());
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: g */
    private static boolean m6228g(Context context, IMMessage iMMessage) {
        if (context == null) {
            m6221a("context = null !");
            return false;
        }
        IMLog.m6635i(f9213a, "send command msg broad cast, actionID is " + iMMessage.getActionId());
        IMTraceUtil.addBusinessEvent("im_send_command_msg").add("actionId", iMMessage.getActionId()).add("type", "send").report();
        Intent intent = new Intent();
        intent.setAction(iMMessage.getActionId());
        intent.putExtra(IM_MESSAGE_EXTRA, iMMessage.getContent());
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        return true;
    }

    /* renamed from: h */
    private static boolean m6229h(Context context, IMMessage iMMessage) {
        if (context == null || iMMessage == null || iMMessage.getContent() == null) {
            IMLog.m6632e(f9213a, "handleQuitGroup failed while null !");
            return false;
        }
        IMLog.m6631d(f9213a, "handleQuitGroup execute -->" + iMMessage.getContent());
        try {
            JSONObject jSONObject = new JSONObject(iMMessage.getContent());
            long optLong = jSONObject.optLong("sid");
            if (jSONObject.optLong("uid") != IMContextInfoHelper.getUid()) {
                IMLog.m6632e(f9213a, "handleQuitGroup failed while uid is not mine !");
                return true;
            }
            IIMSessionModule sessionModel = IMManager.getInstance().getSessionModel();
            if (sessionModel == null) {
                IMLog.m6632e(f9213a, "handleQuitGroup failed while sessionModule is null !");
                return false;
            }
            sessionModel.deleteSession(sessionModel.getSessionFromLocal(optLong));
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            IMLog.m6632e(f9213a, "handleQuitGroup failed ! exception = " + e.toString());
            return false;
        }
    }

    /* renamed from: a */
    private static void m6221a(String str) {
        IMTraceUtil.CodeErrorParam addErrno = IMTraceUtil.addCodeErrorEvent().addErrno(7);
        addErrno.addErrMsg("errmsg = " + str).report();
    }

    public static void sendLocalBroadcast(Context context, String str, IMMessage iMMessage) {
        IMLog.m6631d(f9213a, "sendLocalBroadcast action is " + str + " |value is " + iMMessage);
        Intent intent = new Intent();
        intent.setAction(str);
        if (iMMessage != null) {
            intent.putExtra(IM_MESSAGE_EXTRA, iMMessage);
        }
        if (context != null) {
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
    }

    public static void sendLocalBroadcast4DMC(Context context, IMMessage iMMessage) {
        if (iMMessage != null) {
            if (TextUtils.isEmpty(iMMessage.dmcCardInfo)) {
                IMLog.m6632e(f9213a, "[sendLocalBroadcast4DMC] invalid dmc card info");
                return;
            }
            Intent intent = new Intent();
            intent.setAction(IM_RECEIVE_DMC_INFO_ACTION);
            intent.putExtra(IM_DMC_INFO_EXTRA, iMMessage.dmcCardInfo);
            if (context != null) {
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            }
        }
    }

    public static void sendLocalBroadcast(Context context, IMRobotPraiseTTSMsg iMRobotPraiseTTSMsg) {
        IMLog.m6631d(f9213a, "sendLocalBroadcast action is receive_robot_praise_message_to_tts_action |msg is " + iMRobotPraiseTTSMsg);
        Intent intent = new Intent();
        intent.setAction(RECEIVE_ROBOT_PRAISE_MESSAGE_TO_TTS_ACTION);
        if (iMRobotPraiseTTSMsg != null) {
            intent.putExtra(IM_MESSAGE_EXTRA, iMRobotPraiseTTSMsg);
        }
        if (context != null) {
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
    }

    public static void dispatchReceiverNewIMMessages(Context context, ArrayList<IMMessage> arrayList) {
        if (arrayList != null) {
            Intent intent = new Intent();
            intent.setAction(RECEIVE_NEW_MESSAGE_ACTION);
            intent.putParcelableArrayListExtra(IM_MESSAGE_EXTRA, arrayList);
            IMLog.m6631d(f9213a, "receive new message size " + arrayList.size());
            if (context != null) {
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            }
        }
    }

    public static void dispatchSessionChanged(Context context, long j) {
        Intent intent = new Intent();
        intent.setAction(SESSION_CHANGE_ACTION);
        intent.putExtra(IM_SESSION_ID_EXTRA, j);
        IMLog.m6631d(f9213a, "mSession change id is " + j);
        if (context != null) {
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
    }

    public static void dispatchSendStatusChanged(Context context, IMSession iMSession, IMMessage iMMessage) {
        if (iMSession != null && iMMessage != null) {
            IMMessageSendStatus iMMessageSendStatus = new IMMessageSendStatus();
            iMMessageSendStatus.setPeerUid(iMSession.getPeerUid());
            iMMessageSendStatus.setMessageId(iMMessage.getMid());
            iMMessageSendStatus.setProductId(iMMessage.getBusinessId());
            iMMessageSendStatus.setSendStatus(iMMessage.getStatus());
            iMMessageSendStatus.setSessionId(iMMessage.getSid());
            Intent intent = new Intent();
            intent.setAction(IMMessageSendStatus.action);
            intent.putExtra(IM_MESSAGE_EXTRA, iMMessageSendStatus);
            IMLog.m6631d(f9213a, "send status change");
            if (context != null) {
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            }
        }
    }

    public static void dispatchShareLocation(Context context, String str, String str2) {
        if (str.equals(CREATE_SHARE_LOCATION_ACTION)) {
            str2 = (Long.parseLong(str2) & -281474976710657L) + "";
        }
        Intent intent = new Intent();
        intent.setAction(str);
        intent.putExtra(SHARE_LOCATION_ID_EXTRA, str2);
        if (context != null) {
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
    }
}
